package p507d0;

import java.io.Serializable;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.s */
/* JADX INFO: compiled from: Lazy.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C12120s<T> implements Lazy<T>, Serializable {
    private Object _value;
    private Function0<? extends T> initializer;

    public C12120s(Function0<? extends T> function0) {
        C12238m.checkNotNullParameter(function0, "initializer");
        this.initializer = function0;
        this._value = C12119r.f25171a;
    }

    private final Object writeReplace() {
        return new C11220d(getValue());
    }

    @Override // kotlin.Lazy
    public T getValue() {
        if (this._value == C12119r.f25171a) {
            Function0<? extends T> function0 = this.initializer;
            C12238m.checkNotNull(function0);
            this._value = function0.invoke();
            this.initializer = null;
        }
        return (T) this._value;
    }

    @Override // kotlin.Lazy
    public boolean isInitialized() {
        return this._value != C12119r.f25171a;
    }

    public String toString() {
        return isInitialized() ? String.valueOf(getValue()) : "Lazy value not initialized yet.";
    }
}
