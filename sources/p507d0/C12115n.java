package p507d0;

import java.io.Serializable;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.n */
/* JADX INFO: compiled from: LazyJVM.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C12115n<T> implements Lazy<T>, Serializable {
    private volatile Object _value;
    private Function0<? extends T> initializer;
    private final Object lock;

    public C12115n(Function0<? extends T> function0, Object obj) {
        C12238m.checkNotNullParameter(function0, "initializer");
        this.initializer = function0;
        this._value = C12119r.f25171a;
        this.lock = obj == null ? this : obj;
    }

    private final Object writeReplace() {
        return new C11220d(getValue());
    }

    @Override // kotlin.Lazy
    public T getValue() {
        T tInvoke;
        T t = (T) this._value;
        C12119r c12119r = C12119r.f25171a;
        if (t != c12119r) {
            return t;
        }
        synchronized (this.lock) {
            tInvoke = (T) this._value;
            if (tInvoke == c12119r) {
                Function0<? extends T> function0 = this.initializer;
                C12238m.checkNotNull(function0);
                tInvoke = function0.invoke();
                this._value = tInvoke;
                this.initializer = null;
            }
        }
        return tInvoke;
    }

    @Override // kotlin.Lazy
    public boolean isInitialized() {
        return this._value != C12119r.f25171a;
    }

    public String toString() {
        return isInitialized() ? String.valueOf(getValue()) : "Lazy value not initialized yet.";
    }

    public /* synthetic */ C12115n(Function0 function0, Object obj, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(function0, (i & 2) != 0 ? null : obj);
    }
}
