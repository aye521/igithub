package concept;
/**
 * 接口只能声明常量（默认public static final)和方法（默认public，可不用写public关键词),一般不包含常量；
 * @author meaning
 *
 */
public interface IAlarm {
	String iFiled = "test";
	void alarm();
}
