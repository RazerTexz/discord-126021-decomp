package d0.e0.p.d.m0.m;

import kotlin.jvm.functions.Function0;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: compiled from: LockBasedStorageManager.java */
/* JADX INFO: loaded from: classes3.dex */
public class f$b<T> extends f$j<T> {
    public final /* synthetic */ Object m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f$b(f fVar, f fVar2, Function0 function0, Object obj) {
        super(fVar2, function0);
        this.m = obj;
    }

    @Override // d0.e0.p.d.m0.m.f$h
    public f$o<T> c(boolean z2) {
        f$o<T> f_oValue = f$o.value(this.m);
        if (f_oValue != null) {
            return f_oValue;
        }
        throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$4", "recursionDetected"));
    }
}
