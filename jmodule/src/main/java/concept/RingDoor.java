package concept;

public class RingDoor extends AbstractDoor {

	@Override
	public void alarm() {
		System.out.println("alarm,ring,ring...");
	}

	@Override
	void open() {
		System.out.println("open door....");
	}

	@Override
	void close() {
		System.out.println("close door....");
	}

}
