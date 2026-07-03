package p507d0;

import java.io.Serializable;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.m */
/* JADX INFO: compiled from: LazyJVM.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C12114m<T> implements Lazy<T>, Serializable {

    /* JADX INFO: renamed from: j */
    public static final AtomicReferenceFieldUpdater<C12114m<?>, Object> f25170j;
    private volatile Object _value;

    /* JADX INFO: renamed from: final, reason: not valid java name */
    private final Object f28003final;
    private volatile Function0<? extends T> initializer;

    /* JADX INFO: renamed from: d0.m$a */
    /* JADX INFO: compiled from: LazyJVM.kt */
    public static final class a {
        public a(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    static {
        new a(null);
        f25170j = AtomicReferenceFieldUpdater.newUpdater(C12114m.class, Object.class, "_value");
    }

    public C12114m(Function0<? extends T> function0) {
        C12238m.checkNotNullParameter(function0, "initializer");
        this.initializer = function0;
        C12119r c12119r = C12119r.f25171a;
        this._value = c12119r;
        this.f28003final = c12119r;
    }

    private final Object writeReplace() {
        return new C11220d(getValue());
    }

    @Override // kotlin.Lazy
    public T getValue() {
        T t = (T) this._value;
        C12119r c12119r = C12119r.f25171a;
        if (t != c12119r) {
            return t;
        }
        Function0<? extends T> function0 = this.initializer;
        if (function0 != null) {
            T tInvoke = function0.invoke();
            if (f25170j.compareAndSet(this, c12119r, tInvoke)) {
                this.initializer = null;
                return tInvoke;
            }
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
