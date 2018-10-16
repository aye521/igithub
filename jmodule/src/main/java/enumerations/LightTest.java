package enumerations;

import java.util.EnumMap;
import java.util.EnumSet;
/*
 * 枚举类型默认继承Enum类，编译器会在编译时自动增加一些方法，比如静态的values方法；
 * 枚举是一种特殊的class，每一个具体的枚举值就是该枚举类的一个实例
 */
public class LightTest {

    // 1. 定义枚举类型
    public enum Light {
        // 利用构造函数传参
        RED (1), GREEN (3), YELLOW (2);

        // 定义私有变量
        private int nCode ;

        // 构造函数，枚举类型只能为私有或者package范围
        private Light( int _nCode) {
            this.nCode = _nCode;
        }

        @Override
        public String toString() {
            return String.valueOf ( this.nCode );
        }
    }

    public enum Day {
        SUNDAY, MONDAY, TUESDAY, WEDNESDAY,
        THURSDAY, FRIDAY, SATURDAY
        //如果还要为枚举类型定义其他field或者方法的话需要分号(;)分割；
    }

    /**
     * @param args
     */
    public static void main(String[] args ) {

        System.out.println(Light.RED.name());
        Day day = Day.SUNDAY;
        System.out.println(Day.values().length);
//       // 1. 遍历枚举类型
//       System.out.println( " 演示枚举类型的遍历 ......");
//       testTraversalEnum ();
//
//       // 2. 演示 EnumMap 对象的使用
//       System.out.println( " 演示 EnmuMap 对象的使用和遍历 ....." );
//       testEnumMap ();
//
//       // 3. 演示 EnmuSet 的使用
//       System. out .println( " 演示 EnmuSet 对象的使用和遍历 ....." );
//       testEnumSet ();
    }

    /**
     * 演示枚举类型的遍历
     */
    private static void testTraversalEnum() {
        Light[] allLight = Light.values ();
        for (Light aLight : allLight) {
            System. out .println( " 当前灯 name ： " + aLight.name());
            System. out .println( " 当前灯 ordinal ： " + aLight.ordinal());
            System. out .println( " 当前灯： " + aLight);
        }
    }

    /**
     * 演示 EnumMap 的使用， EnumMap 跟 HashMap 的使用差不多，只不过 key 要是枚举类型
     */
    private static void testEnumMap() {
        // 1. 演示定义 EnumMap 对象， EnumMap 对象的构造函数需要参数传入 , 默认是 key 的类的类型
        EnumMap<Light, String> currEnumMap = new EnumMap<Light, String>(
                Light. class );
        currEnumMap.put(Light. RED , " 红灯 " );
        currEnumMap.put(Light. GREEN , " 绿灯 " );
        currEnumMap.put(Light. YELLOW , " 黄灯 " );

        // 2. 遍历对象
        for (Light aLight : Light.values ()) {
            System. out .println( "[key=" + aLight.name() + ",value="
                    + currEnumMap.get(aLight) + "]" );
        }
    }

    /**
     * 演示 EnumSet 如何使用， EnumSet 是一个抽象类，获取一个类型的枚举类型内容 <BR/>
     * 可以使用 allOf 方法
     */
    private static void testEnumSet() {
        EnumSet<Light> currEnumSet = EnumSet.allOf (Light. class );
        for (Light aLightSetElement : currEnumSet) {
            System. out .println( " 当前 EnumSet 中数据为： " + aLightSetElement);
        }

    }
}
