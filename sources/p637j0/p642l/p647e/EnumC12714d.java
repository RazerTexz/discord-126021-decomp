package p637j0.p642l.p647e;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReference;
import p658rx.exceptions.CompositeException;

/* JADX INFO: renamed from: j0.l.e.d */
/* JADX INFO: compiled from: ExceptionsUtils.java */
/* JADX INFO: loaded from: classes3.dex */
public enum EnumC12714d {
    ;


    /* JADX INFO: renamed from: j */
    public static final Throwable f27268j = new Throwable("Terminated");

    /* JADX INFO: renamed from: f */
    public static boolean m10811f(AtomicReference<Throwable> atomicReference, Throwable th) {
        Throwable th2;
        Throwable compositeException;
        do {
            th2 = atomicReference.get();
            if (th2 == f27268j) {
                return false;
            }
            if (th2 == null) {
                compositeException = th;
            } else if (th2 instanceof CompositeException) {
                ArrayList arrayList = new ArrayList(((CompositeException) th2).m11122b());
                arrayList.add(th);
                compositeException = new CompositeException(arrayList);
            } else {
                compositeException = new CompositeException(th2, th);
            }
        } while (!atomicReference.compareAndSet(th2, compositeException));
        return true;
    }

    /* JADX INFO: renamed from: g */
    public static boolean m10812g(Throwable th) {
        return th == f27268j;
    }

    /* JADX INFO: renamed from: h */
    public static Throwable m10813h(AtomicReference<Throwable> atomicReference) {
        Throwable th = atomicReference.get();
        Throwable th2 = f27268j;
        return th != th2 ? atomicReference.getAndSet(th2) : th;
    }
}
