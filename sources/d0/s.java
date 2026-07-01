package d0;

import java.io.Serializable;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: Lazy.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class s<T> implements Lazy<T>, Serializable {
    private Object _value;
    private Function0<? extends T> initializer;

    public s(Function0<? extends T> function0) {
        d0.z.d.m.checkNotNullParameter(function0, "initializer");
        this.initializer = function0;
        this._value = r.a;
    }

    private final Object writeReplace() {
        return new d(getValue());
    }

    @Override // kotlin.Lazy
    public T getValue() {
        if (this._value == r.a) {
            Function0<? extends T> function0 = this.initializer;
            d0.z.d.m.checkNotNull(function0);
            this._value = function0.invoke();
            this.initializer = null;
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
