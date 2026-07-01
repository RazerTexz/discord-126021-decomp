package d0.e0.p.d.m0.j;

import d0.e0.p.d.m0.c.c1;

/* JADX INFO: compiled from: DescriptorRenderer.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class c$l$a implements c$l {
    public static final c$l$a a = new c$l$a();

    @Override // d0.e0.p.d.m0.j.c$l
    public void appendAfterValueParameter(c1 c1Var, int i, int i2, StringBuilder sb) {
        d0.z.d.m.checkNotNullParameter(c1Var, "parameter");
        d0.z.d.m.checkNotNullParameter(sb, "builder");
        if (i != i2 - 1) {
            sb.append(", ");
        }
    }

    @Override // d0.e0.p.d.m0.j.c$l
    public void appendAfterValueParameters(int i, StringBuilder sb) {
        d0.z.d.m.checkNotNullParameter(sb, "builder");
        sb.append(")");
    }

    @Override // d0.e0.p.d.m0.j.c$l
    public void appendBeforeValueParameter(c1 c1Var, int i, int i2, StringBuilder sb) {
        d0.z.d.m.checkNotNullParameter(c1Var, "parameter");
        d0.z.d.m.checkNotNullParameter(sb, "builder");
    }

    @Override // d0.e0.p.d.m0.j.c$l
    public void appendBeforeValueParameters(int i, StringBuilder sb) {
        d0.z.d.m.checkNotNullParameter(sb, "builder");
        sb.append("(");
    }
}
