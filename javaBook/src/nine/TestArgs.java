package nine;

public class TestArgs {
    public static void main(String[] args) {
        //输出 args 数组的长度
        System.out.println(args.length);
        //遍历 args 数组的每个元素
        for(String arg : args){
            //输出为 0 ---> 说明是一个长度为 0 的空数组
            System.out.println(arg);
        }
    }
}
