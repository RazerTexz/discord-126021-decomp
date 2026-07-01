package d0.e0.p.d.m0.l.b;

import d0.e0.p.d.m0.c.u0;
import d0.e0.p.d.m0.f.c$c;

/* JADX INFO: compiled from: ProtoContainer.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class y$a extends y {
    public final d0.e0.p.d.m0.f.c d;
    public final y$a e;
    public final d0.e0.p.d.m0.g.a f;
    public final c$c g;
    public final boolean h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public y$a(d0.e0.p.d.m0.f.c cVar, d0.e0.p.d.m0.f.z.c cVar2, d0.e0.p.d.m0.f.z.g gVar, u0 u0Var, y$a y_a) {
        super(cVar2, gVar, u0Var, null);
        d0.z.d.m.checkNotNullParameter(cVar, "classProto");
        d0.z.d.m.checkNotNullParameter(cVar2, "nameResolver");
        d0.z.d.m.checkNotNullParameter(gVar, "typeTable");
        this.d = cVar;
        this.e = y_a;
        this.f = w.getClassId(cVar2, cVar.getFqName());
        c$c c_c = d0.e0.p.d.m0.f.z.b.e.get(cVar.getFlags());
        this.g = c_c == null ? c$c.CLASS : c_c;
        Boolean bool = d0.e0.p.d.m0.f.z.b.f.get(cVar.getFlags());
        d0.z.d.m.checkNotNullExpressionValue(bool, "IS_INNER.get(classProto.flags)");
        this.h = bool.booleanValue();
    }

    @Override // d0.e0.p.d.m0.l.b.y
    public d0.e0.p.d.m0.g.b debugFqName() {
        d0.e0.p.d.m0.g.b bVarAsSingleFqName = this.f.asSingleFqName();
        d0.z.d.m.checkNotNullExpressionValue(bVarAsSingleFqName, "classId.asSingleFqName()");
        return bVarAsSingleFqName;
    }

    public final d0.e0.p.d.m0.g.a getClassId() {
        return this.f;
    }

    public final d0.e0.p.d.m0.f.c getClassProto() {
        return this.d;
    }

    public final c$c getKind() {
        return this.g;
    }

    public final y$a getOuterClass() {
        return this.e;
    }

    public final boolean isInner() {
        return this.h;
    }
}
