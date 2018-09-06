package com.lstfight.portal.constant;

/**
 * 对象数据表中状态列值
 *
 * @author 李尚庭
 * @date 2018/8/13 0013 14:40
 */

public class DatabaseConstant {

    /**
     * 资源表父资源默认ID
     */
    public enum ResourceParentId {
        /**
         * 默认父资源ID
         */
        NON_PARENT("默认父资源ID", "0");
        /**
         * 默认父资源ID名
         */
        private String name;
        /**
         * 默认父资源id值
         */
        private String code;

        ResourceParentId(String name, String code) {
            this.name = name;
            this.code = code;
        }

        public String getName() {
            return name;
        }

        public String getCode() {
            return code;
        }
    }

    public enum ResourceType {

        /**
         * 菜单类型资源
         */
        MENU("菜单", 1);

        /**
         * 默认父资源ID名
         */
        private String name;
        /**
         * 默认父资源id值
         */
        private int type;

        ResourceType(String name, int type) {
            this.name = name;
            this.type = type;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }
    }
}
