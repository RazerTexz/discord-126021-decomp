package d0;

import d0.z.d.Intrinsics3;
import java.io.Serializable;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;

/* JADX INFO: renamed from: d0.s, reason: use source file name */
/* JADX INFO: compiled from: Lazy.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class Lazy7<T> implements Lazy<T>, Serializable {
    private Object _value;
    private Function0<? extends T> initializer;

    public Lazy7(Function0<? extends T> function0) {
        Intrinsics3.checkNotNullParameter(function0, "initializer");
        this.initializer = function0;
        this._value = Lazy6.a;
    }

    private final Object writeReplace() {
        return new Lazy3(getValue());
    }

    @Override // kotlin.Lazy
    public T getValue() {
        if (this._value == Lazy6.a) {
            Function0<? extends T> function0 = this.initializer;
            Intrinsics3.checkNotNull(function0);
            this._value = function0.invoke();
            this.initializer = null;
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
