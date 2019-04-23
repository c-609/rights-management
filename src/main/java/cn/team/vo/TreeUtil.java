package cn.team.vo;

import cn.team.bean.Menu;
import cn.team.dto.MenuTree;
import cn.team.dto.TreeNode;
import lombok.experimental.UtilityClass;

import java.util.ArrayList;
import java.util.List;

/**
 * UtilityClass注解，构造函数私有化
 *
 * create by yifeng
 */
@UtilityClass
public class TreeUtil {

    /**
     *  两层循环实现建树
     *
     * @param treeNodes 传入的树节点列表
     * @param root 根
     * @return
     */
    public <T extends TreeNode> List<T> buildByLoop(List<T> treeNodes, Object root) {
        List <T> trees = new ArrayList<>();

        for (T treeNode : treeNodes) {

            if(root.equals(treeNode.getParentId())) {
                trees.add(treeNode);
            }

            for (T it : treeNodes) {
                if(it.getParentId() == treeNode.getId()) {
                    if (treeNode.getChildren() == null) {
                        treeNode.setChildren(new ArrayList<>());
                    }
                    treeNode.add(it);
                }
            }

        }
        return trees;
    }

    public List<MenuTree> buildTree(List<Menu> menus, int root) {
        List<MenuTree> trees = new ArrayList<>();
        MenuTree node;
        for (Menu menu : menus) {
            node = new MenuTree();
            node.setId(menu.getId());
            node.setParentId(menu.getParentId());
            node.setName(menu.getName());
            node.setPath(menu.getPath());
            node.setComponent(menu.getComponent());
            trees.add(node);
        }
        return TreeUtil.buildByLoop(trees, root);
    }


}
