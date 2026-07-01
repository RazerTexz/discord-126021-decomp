package j0.l.e;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReference;
import rx.exceptions.CompositeException;

/* JADX INFO: renamed from: j0.l.e.d, reason: use source file name */
/* JADX INFO: compiled from: ExceptionsUtils.java */
/* JADX INFO: loaded from: classes3.dex */
public enum ExceptionsUtils {
    ;

    public static final Throwable j = new Throwable("Terminated");

    public static boolean f(AtomicReference<Throwable> atomicReference, Throwable th) {
        Throwable th2;
        Throwable compositeException;
        do {
            th2 = atomicReference.get();
            if (th2 == j) {
                return false;
            }
            if (th2 == null) {
                compositeException = th;
            } else if (th2 instanceof CompositeException) {
                ArrayList arrayList = new ArrayList(((CompositeException) th2).b());
                arrayList.add(th);
                compositeException = new CompositeException(arrayList);
            } else {
                compositeException = new CompositeException(th2, th);
            }
        } while (!atomicReference.compareAndSet(th2, compositeException));
        return true;
    }

    public static boolean g(Throwable th) {
        return th == j;
    }

    public static Throwable h(AtomicReference<Throwable> atomicReference) {
        Throwable th = atomicReference.get();
        Throwable th2 = j;
        return th != th2 ? atomicReference.getAndSet(th2) : th;
    }
}
