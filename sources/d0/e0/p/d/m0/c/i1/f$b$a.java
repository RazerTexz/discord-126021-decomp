package d0.e0.p.d.m0.c.i1;

import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: AbstractTypeParameterDescriptor.java */
/* JADX INFO: loaded from: classes3.dex */
public class f$b$a implements Function0<d0.e0.p.d.m0.k.a0.i> {
    public final /* synthetic */ f$b j;

    public f$b$a(f$b f_b) {
        this.j = f_b;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ d0.e0.p.d.m0.k.a0.i invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public d0.e0.p.d.m0.k.a0.i invoke() {
        StringBuilder sbU = b.d.b.a.a.U("Scope for type parameter ");
        sbU.append(this.j.j.asString());
        return d0.e0.p.d.m0.k.a0.o.create(sbU.toString(), this.j.k.getUpperBounds());
    }
}
