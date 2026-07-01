package d0.e0.p.d.m0.m;

import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: LockBasedStorageManager.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class f$k<T> extends f$i<T> implements j<T> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f$k(f fVar, Function0<? extends T> function0) {
        super(fVar, function0);
        if (fVar == null) {
            a(0);
            throw null;
        }
        if (function0 != null) {
        } else {
            a(1);
            throw null;
        }
    }

    public static /* synthetic */ void a(int i) {
        String str = i != 2 ? "Argument for @NotNull parameter '%s' of %s.%s must not be null" : "@NotNull method %s.%s must not return null";
        Object[] objArr = new Object[i != 2 ? 3 : 2];
        if (i == 1) {
            objArr[0] = "computable";
        } else if (i != 2) {
            objArr[0] = "storageManager";
        } else {
            objArr[0] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$LockBasedNotNullLazyValueWithPostCompute";
        }
        if (i != 2) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$LockBasedNotNullLazyValueWithPostCompute";
        } else {
            objArr[1] = "invoke";
        }
        if (i != 2) {
            objArr[2] = "<init>";
        }
        String str2 = String.format(str, objArr);
        if (i == 2) {
            throw new IllegalStateException(str2);
        }
    }

    @Override // d0.e0.p.d.m0.m.f$i, d0.e0.p.d.m0.m.f$h, kotlin.jvm.functions.Function0
    public T invoke() {
        T t = (T) super.invoke();
        if (t != null) {
            return t;
        }
        a(2);
        throw null;
    }
}
