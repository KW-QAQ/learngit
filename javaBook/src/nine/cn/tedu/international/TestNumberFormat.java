package nine.cn.tedu.international;

import java.text.NumberFormat;
import java.util.Locale;

public class TestNumberFormat {
    public static void main(String[] args) {
        //需要被格式化的数字
        double db = 1234.567;
        //创建四个 Locale，分别代表中国，日本，德国，美国
        Locale[] locales = {Locale.CHINA,Locale.JAPAN,Locale.GERMAN,
        Locale.US};
        NumberFormat[] nf = new NumberFormat[12];

        //为上面四个 Locale 创建12个 NumberFormat 对象
        //每个 Locale 分别有通用数值格式器，百分比格式器，货币格式器

        for(int i = 0 ; i < locales.length ; i++){
            nf[i * 3] = NumberFormat.getNumberInstance(locales[i]);
            nf[i * 3 + 1] = NumberFormat.getPercentInstance(locales[i]);
            nf[i * 3 + 2] = NumberFormat.getCurrencyInstance(locales[i]);
        }

        for(int i = 0 ; i < locales.length ; i++){
            switch (i){
                case 0:
                    System.out.println("----中国的格式----");
                    break;
                case 1:
                    System.out.println("----日本的格式----");
                    break;
                case 2:
                    System.out.println("----德国的格式----");
                    break;
                case 3:
                    System.out.println("----美国的格式----");
                    break;
            }
            System.out.println("通用数值格式" + nf[i * 3].format( db ));
            System.out.println("百分比数值格式" + nf[i * 3 + 1].format( db ));
            System.out.println("货币数值格式" + nf[i * 3 + 2].format( db ));

        }

    }
}
