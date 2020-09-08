package nine.cn.tedu.international;

import java.util.ListResourceBundle;

public class MyResource_zh_CN extends ListResourceBundle {

    //定义资源
    private final Object myData[][]={
            {"msg","{0},你好!今天是{1}"}
    };

    //重写方法 getContents()
    @Override
    protected Object[][] getContents() {
        //该方法返回资源的 key-value 对
        return myData;
    }
}
