package d0.e0.p.d.m0.n;

import java.util.Iterator;

/* JADX INFO: compiled from: KotlinType.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class j0 extends i1 implements d0.e0.p.d.m0.n.n1.i, d0.e0.p.d.m0.n.n1.j {
    public j0() {
        super(null);
    }

    @Override // d0.e0.p.d.m0.n.i1
    public abstract j0 makeNullableAsSpecified(boolean z2);

    @Override // d0.e0.p.d.m0.n.i1
    public abstract j0 replaceAnnotations(d0.e0.p.d.m0.c.g1.g gVar);

    public String toString() {
        StringBuilder sb = new StringBuilder();
        Iterator<d0.e0.p.d.m0.c.g1.c> it = getAnnotations().iterator();
        while (it.hasNext()) {
            d0.g0.q.append(sb, "[", d0.e0.p.d.m0.j.c.renderAnnotation$default(d0.e0.p.d.m0.j.c.c, it.next(), null, 2, null), "] ");
        }
        sb.append(getConstructor());
        if (!getArguments().isEmpty()) {
            d0.t.u.joinTo$default(getArguments(), sb, ", ", "<", ">", 0, null, null, 112, null);
        }
        if (isMarkedNullable()) {
            sb.append("?");
        }
        String string = sb.toString();
        d0.z.d.m.checkNotNullExpressionValue(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }
}
