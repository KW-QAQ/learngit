package internetDemo;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressTest {
    public static void main(String[] args) throws Exception {
        //根据主机名来获取对应的 InetAddress 实例
        InetAddress ip = InetAddress.getByName( "www.baidu.com" );

        //判断是否可达
        System.out.println("baidu 是否可达:" + ip.isReachable( 2000 ));
        //获取该 InetAddress 实例的 IP 字符串
        System.out.println(ip.getHostAddress());

        //根据原始 IP 地址来获取对应的 InetAddress 实例
        InetAddress local = InetAddress.getByAddress( new byte[]
                {127,0,0,1} );
        System.out.println("本主机是否可达:" + local.isReachable( 100 ));
        //获取该 InetAddress 实例对应的全限定域名
        System.out.println(local.getCanonicalHostName());
        System.out.println(local.getHostAddress());
    }
}
