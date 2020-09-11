package packageClass;

public class AutoBoxingUnboxing {
    public static void main(String[] args) {
        //直接把一个基本类型变量赋值给 Integer 对象
        Integer inObj = 5;

        //直接把一个 boolean 类型变量，赋值给一个 Object 类型的变量
        Object boolObj = true;

        //直接把一个 Integer 对象赋值给 int 类型的变量
        int it = inObj;

        if(boolObj instanceof  Boolean){
            //先把 Object 对象强制转为 Boolean 类型，再赋值给 boolean 变量
            boolean b = (Boolean)boolObj;
            System.out.println(b);
        }
    }
}
