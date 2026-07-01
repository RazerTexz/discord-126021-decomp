package s.a.a;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: renamed from: s.a.a.d, reason: use source file name */
/* JADX INFO: compiled from: Atomic.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class Atomic2<T> extends Atomic3 {
    public static final AtomicReferenceFieldUpdater a = AtomicReferenceFieldUpdater.newUpdater(Atomic2.class, Object.class, "_consensus");
    public volatile Object _consensus = Atomic.a;

    /* JADX WARN: Multi-variable type inference failed */
    @Override // s.a.a.Atomic3
    public final Object a(Object obj) {
        Object objC = this._consensus;
        Object obj2 = Atomic.a;
        if (objC == obj2) {
            objC = c(obj);
            Object obj3 = this._consensus;
            if (obj3 != obj2) {
                objC = obj3;
            } else if (!a.compareAndSet(this, obj2, objC)) {
                objC = this._consensus;
            }
        }
        b(obj, objC);
        return objC;
    }

    public abstract void b(T t, Object obj);

    public abstract Object c(T t);
}
