package concept;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

import static org.awaitility.Awaitility.await;
import static org.awaitility.proxy.AwaitilityClassProxy.to;
import static org.hamcrest.Matchers.*;

public class PhantomRefTest {

    static final CountDownLatch countDownLatch = new CountDownLatch(1);
    public static void main(String[] args) throws InterruptedException {
//        testPhantom();
        await().untilCall( to(new HashMap<>()).size(), equalTo(0) );
        testweakRef();
    }

    private static void testweakRef() throws InterruptedException {
        Object strongRef = new LargeObj();
        WeakReference r = new WeakReference(strongRef);
        System.out.println("------------>before gc: r=" + r.get());
        strongRef = null;
        System.gc();
        //then GC will finally reclaim that object
//        await().atMost(1, TimeUnit.SECONDS).untilTrue(new AtomicBoolean(null == r.get()));
        await().atMost(1, TimeUnit.SECONDS).until(() -> null == r.get());
        System.out.println("------------>after gc: r=" + r.get() );
    }

    private static void testPhantom() {
        ReferenceQueue<Object> referenceQueue = new ReferenceQueue<>();
        List<LargeObjectFinalizer> references = new ArrayList<>();
        List<Object> largeObjects = new ArrayList<>();

        for (int i = 0; i < 3; ++i) {
            Object largeObject = new LargeObj();
            largeObjects.add(largeObject);
            references.add(new LargeObjectFinalizer(largeObject, referenceQueue));
        }
        largeObjects = null;
        System.out.println("------------>before frist gc");
        System.gc();
        System.out.println("------------>after first gc");

        Reference<?> referenceFromQueue;
        for (PhantomReference<Object> reference : references) {
            System.out.println(reference.isEnqueued());
        }

        while ((referenceFromQueue = referenceQueue.poll()) != null) {
            ((LargeObjectFinalizer)referenceFromQueue).finalizeResources();
            referenceFromQueue.clear();
        }
        System.out.println("------------>before second gc");
        System.gc();
        System.out.println("------------>after second gc");
    }

}

class LargeObjectFinalizer extends PhantomReference<Object> {

    public LargeObjectFinalizer(
            Object referent, ReferenceQueue<? super Object> q) {
        super(referent, q);
    }

    public void finalizeResources() {
        // free resources
        System.out.println("clearing by phantom reference mechanism");
    }
}

class LargeObj {
    byte[] large = new byte[1024 * 1024];
    @Override
    protected void finalize() throws Throwable {
//        System.out.println("finalizing...");
    }

    @Override
    public String toString() {
        return "Large-Object";
    }
}