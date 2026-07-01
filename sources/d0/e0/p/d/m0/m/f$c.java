package d0.e0.p.d.m0.m;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: compiled from: LockBasedStorageManager.java */
/* JADX INFO: loaded from: classes3.dex */
public class f$c<T> extends f$k<T> {
    public final /* synthetic */ Function1 n;
    public final /* synthetic */ Function1 o;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f$c(f fVar, f fVar2, Function0 function0, Function1 function1, Function1 function2) {
        super(fVar2, function0);
        this.n = function1;
        this.o = function2;
    }

    public static /* synthetic */ void a(int i) {
        String str = i != 2 ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[i != 2 ? 2 : 3];
        if (i != 2) {
            objArr[0] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$5";
        } else {
            objArr[0] = "value";
        }
        if (i != 2) {
            objArr[1] = "recursionDetected";
        } else {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$5";
        }
        if (i == 2) {
            objArr[2] = "doPostCompute";
        }
        String str2 = String.format(str, objArr);
        if (i == 2) {
            throw new IllegalArgumentException(str2);
        }
    }

    @Override // d0.e0.p.d.m0.m.f$h
    public f$o<T> c(boolean z2) {
        Function1 function1 = this.n;
        if (function1 == null) {
            f$o<T> f_oC = super.c(z2);
            if (f_oC != null) {
                return f_oC;
            }
            a(0);
            throw null;
        }
        f$o<T> f_oValue = f$o.value(function1.invoke(Boolean.valueOf(z2)));
        if (f_oValue != null) {
            return f_oValue;
        }
        a(1);
        throw null;
    }
}
