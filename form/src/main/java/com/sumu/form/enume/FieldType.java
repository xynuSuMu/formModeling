package com.sumu.form.enume;


public interface FieldType {

    //=======字段映射关系======
    //
    //text     textarea  number float   money     radio     checkbox   select    image      file
    //varchar  longtext  int    float  decimal   varchar     varchar   varchar  varchar    varchar

    enum Relation {
        TEXT("text", "varchar", false, false),
        TEXT_AREA("textarea", "longtext", false, false),
        NUMBER("number", "int", false, false),
        FLOAT("float", "float", false, true),
        MONEY("money", "decimal", false, true),
        RADIO("radio", "varchar", true, false),
        CHECKBOX("checkbox", "varchar", true, false),
        SELECT("select", "varchar", true, false),
        IMAGE("image", "varchar", false, false),
        FILE("file", "varchar", false, false),
        ;


        private String front;

        private String back;

        private Boolean component;//组件

        private Boolean point;//小数点

        Relation(String front, String back, Boolean component, Boolean point) {
            this.front = front;
            this.back = back;
            this.component = component;
            this.point = point;
        }

        public Boolean getComponent() {
            return component;
        }

        public String getFront() {
            return front;
        }

        public String getBack() {
            return back;
        }

        public Boolean getPoint() {
            return point;
        }

        public static Relation getRelation(String front) {
            for (Relation relation : values()) {
                if (relation.front.equals(front)) {
                    return relation;
                }
            }
            return null;
        }
    }


    //
}
