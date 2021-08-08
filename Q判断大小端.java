import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.util.concurrent.ScheduledExecutorService;

public class Q判断大小端 {
    public static void main(String[] args){
        checkBigOrSmallEnd();
    }

    public static void checkBigOrSmallEnd(){
        try{
            Field unsafeField = Unsafe.class.getDeclaredFields()[0];
            unsafeField.setAccessible(true);
            Unsafe unsafe = (Unsafe) unsafeField.get(null);

            long a = unsafe.allocateMemory(8);

            unsafe.putLong(a, 0x0102030405060708l);
            byte b = unsafe.getByte(a);
            if (b == 0x01)
                System.out.println("Big end");
            else if(b == 0x08)
                System.out.println("Small end");
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
