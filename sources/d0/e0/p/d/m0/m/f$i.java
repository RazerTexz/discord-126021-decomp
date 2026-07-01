package d0.e0.p.d.m0.m;

import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: LockBasedStorageManager.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class f$i<T> extends f$h<T> {
    public volatile m<T> m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f$i(f fVar, Function0<? extends T> function0) {
        super(fVar, function0);
        if (fVar == null) {
            a(0);
            throw null;
        }
        if (function0 == null) {
            a(1);
            throw null;
        }
        this.m = null;
    }

    public static /* synthetic */ void a(int i) {
        Object[] objArr = new Object[3];
        if (i != 1) {
            objArr[0] = "storageManager";
        } else {
            objArr[0] = "computable";
        }
        objArr[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$LockBasedLazyValueWithPostCompute";
        objArr[2] = "<init>";
        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
    }

    @Override // d0.e0.p.d.m0.m.f$h
    public final void b(T t) {
        this.m = new m<>(t);
        try {
            f$c f_c = (f$c) this;
            if (t == null) {
                f$c.a(2);
                throw null;
            }
            f_c.o.invoke(t);
            this.m = null;
        } catch (Throwable th) {
            this.m = null;
            throw th;
        }
    }

    @Override // d0.e0.p.d.m0.m.f$h, kotlin.jvm.functions.Function0
    public T invoke() {
        m<T> mVar = this.m;
        return (mVar == null || !mVar.hasValue()) ? (T) super.invoke() : mVar.getValue();
    }
}
