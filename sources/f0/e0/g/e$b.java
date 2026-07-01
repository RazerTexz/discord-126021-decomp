package f0.e0.g;

import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: RealCall.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class e$b extends WeakReference<e> {
    public final Object a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e$b(e eVar, Object obj) {
        super(eVar);
        d0.z.d.m.checkParameterIsNotNull(eVar, "referent");
        this.a = obj;
    }
}
