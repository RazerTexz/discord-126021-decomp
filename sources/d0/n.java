package d0;

import java.io.Serializable;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: LazyJVM.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class n<T> implements Lazy<T>, Serializable {
    private volatile Object _value;
    private Function0<? extends T> initializer;
    private final Object lock;

    public n(Function0<? extends T> function0, Object obj) {
        d0.z.d.m.checkNotNullParameter(function0, "initializer");
        this.initializer = function0;
        this._value = r.a;
        this.lock = obj == null ? this : obj;
    }

    private final Object writeReplace() {
        return new d(getValue());
    }

    @Override // kotlin.Lazy
    public T getValue() {
        T tInvoke;
        T t = (T) this._value;
        r rVar = r.a;
        if (t != rVar) {
            return t;
        }
        synchronized (this.lock) {
            tInvoke = (T) this._value;
            if (tInvoke == rVar) {
                Function0<? extends T> function0 = this.initializer;
                d0.z.d.m.checkNotNull(function0);
                tInvoke = function0.invoke();
                this._value = tInvoke;
                this.initializer = null;
            }
        }
        return tInvoke;
    }

    @Override // kotlin.Lazy
    public boolean isInitialized() {
        return this._value != r.a;
    }

    public String toString() {
        return isInitialized() ? String.valueOf(getValue()) : "Lazy value not initialized yet.";
    }

    public /* synthetic */ n(Function0 function0, Object obj, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(function0, (i & 2) != 0 ? null : obj);
    }
}
