package d0;

import java.io.Serializable;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: LazyJVM.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class m<T> implements Lazy<T>, Serializable {
    public static final AtomicReferenceFieldUpdater<m<?>, Object> j;
    private volatile Object _value;

    /* JADX INFO: renamed from: final, reason: not valid java name */
    private final Object f12final;
    private volatile Function0<? extends T> initializer;

    static {
        new m$a(null);
        j = AtomicReferenceFieldUpdater.newUpdater(m.class, Object.class, "_value");
    }

    public m(Function0<? extends T> function0) {
        d0.z.d.m.checkNotNullParameter(function0, "initializer");
        this.initializer = function0;
        r rVar = r.a;
        this._value = rVar;
        this.f12final = rVar;
    }

    private final Object writeReplace() {
        return new d(getValue());
    }

    @Override // kotlin.Lazy
    public T getValue() {
        T t = (T) this._value;
        r rVar = r.a;
        if (t != rVar) {
            return t;
        }
        Function0<? extends T> function0 = this.initializer;
        if (function0 != null) {
            T tInvoke = function0.invoke();
            if (j.compareAndSet(this, rVar, tInvoke)) {
                this.initializer = null;
                return tInvoke;
            }
        }
        return (T) this._value;
    }

    @Override // kotlin.Lazy
    public boolean isInitialized() {
        return this._value != r.a;
    }

    public String toString() {
        return isInitialized() ? String.valueOf(getValue()) : "Lazy value not initialized yet.";
    }
}
