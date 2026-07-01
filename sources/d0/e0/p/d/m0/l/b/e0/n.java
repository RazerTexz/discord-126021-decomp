package d0.e0.p.d.m0.l.b.e0;

import d0.e0.p.d.m0.m.o;
import java.util.List;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: DeserializedAnnotations.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class n extends a {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n(o oVar, Function0<? extends List<? extends d0.e0.p.d.m0.c.g1.c>> function0) {
        super(oVar, function0);
        d0.z.d.m.checkNotNullParameter(oVar, "storageManager");
        d0.z.d.m.checkNotNullParameter(function0, "compute");
    }

    @Override // d0.e0.p.d.m0.l.b.e0.a, d0.e0.p.d.m0.c.g1.g
    public boolean isEmpty() {
        return false;
    }
}
