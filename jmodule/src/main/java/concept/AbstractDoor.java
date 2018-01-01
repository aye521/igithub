package concept;

public abstract class AbstractDoor implements IAlarm {

// 抽象类声明implement的接口，可选不实现,但子类必须实现
//	@Override
//	public void alarm() {
//
//	}
	
	abstract void open();
	
	abstract void close();

}
