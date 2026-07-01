package d0;

import d0.z.d.Intrinsics3;
import java.io.Serializable;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: renamed from: d0.m, reason: use source file name */
/* JADX INFO: compiled from: LazyJVM.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class LazyJVM2<T> implements Lazy<T>, Serializable {
    public static final AtomicReferenceFieldUpdater<LazyJVM2<?>, Object> j;
    private volatile Object _value;

    /* JADX INFO: renamed from: final, reason: not valid java name */
    private final Object f12final;
    private volatile Function0<? extends T> initializer;

    /* JADX INFO: renamed from: d0.m$a */
    /* JADX INFO: compiled from: LazyJVM.kt */
    public static final class a {
        public a(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    static {
        new a(null);
        j = AtomicReferenceFieldUpdater.newUpdater(LazyJVM2.class, Object.class, "_value");
    }

    public LazyJVM2(Function0<? extends T> function0) {
        Intrinsics3.checkNotNullParameter(function0, "initializer");
        this.initializer = function0;
        Lazy6 lazy6 = Lazy6.a;
        this._value = lazy6;
        this.f12final = lazy6;
    }

    private final Object writeReplace() {
        return new Lazy3(getValue());
    }

    @Override // kotlin.Lazy
    public T getValue() {
        T t = (T) this._value;
        Lazy6 lazy6 = Lazy6.a;
        if (t != lazy6) {
            return t;
        }
        Function0<? extends T> function0 = this.initializer;
        if (function0 != null) {
            T tInvoke = function0.invoke();
            if (j.compareAndSet(this, lazy6, tInvoke)) {
                this.initializer = null;
                return tInvoke;
            }
        }
        return (T) this._value;
    }

    @Override // kotlin.Lazy
    public boolean isInitialized() {
        return this._value != Lazy6.a;
    }

    public String toString() {
        return isInitialized() ? String.valueOf(getValue()) : "Lazy value not initialized yet.";
    }
}
