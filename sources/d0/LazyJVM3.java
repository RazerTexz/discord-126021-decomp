package d0;

import d0.z.d.Intrinsics3;
import java.io.Serializable;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: renamed from: d0.n, reason: use source file name */
/* JADX INFO: compiled from: LazyJVM.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class LazyJVM3<T> implements Lazy<T>, Serializable {
    private volatile Object _value;
    private Function0<? extends T> initializer;
    private final Object lock;

    public LazyJVM3(Function0<? extends T> function0, Object obj) {
        Intrinsics3.checkNotNullParameter(function0, "initializer");
        this.initializer = function0;
        this._value = Lazy6.a;
        this.lock = obj == null ? this : obj;
    }

    private final Object writeReplace() {
        return new Lazy3(getValue());
    }

    @Override // kotlin.Lazy
    public T getValue() {
        T tInvoke;
        T t = (T) this._value;
        Lazy6 lazy6 = Lazy6.a;
        if (t != lazy6) {
            return t;
        }
        synchronized (this.lock) {
            tInvoke = (T) this._value;
            if (tInvoke == lazy6) {
                Function0<? extends T> function0 = this.initializer;
                Intrinsics3.checkNotNull(function0);
                tInvoke = function0.invoke();
                this._value = tInvoke;
                this.initializer = null;
            }
        }
        return tInvoke;
    }

    @Override // kotlin.Lazy
    public boolean isInitialized() {
        return this._value != Lazy6.a;
    }

    public String toString() {
        return isInitialized() ? String.valueOf(getValue()) : "Lazy value not initialized yet.";
    }

    public /* synthetic */ LazyJVM3(Function0 function0, Object obj, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(function0, (i & 2) != 0 ? null : obj);
    }
}
