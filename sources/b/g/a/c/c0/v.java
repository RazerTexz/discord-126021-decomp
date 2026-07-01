package b.g.a.c.c0;

import b.g.a.a.i$d;
import b.g.a.a.p$b;
import java.io.Serializable;

/* JADX INFO: compiled from: ConcreteBeanPropertyBase.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class v implements b.g.a.c.d, Serializable {
    private static final long serialVersionUID = 1;
    public final b.g.a.c.s _metadata;

    public v(b.g.a.c.s sVar) {
        this._metadata = sVar == null ? b.g.a.c.s.l : sVar;
    }

    @Override // b.g.a.c.d
    public i$d a(b.g.a.c.z.l<?> lVar, Class<?> cls) {
        i member;
        i$d i_dI = lVar.i(cls);
        b.g.a.c.b bVarE = lVar.e();
        i$d i_dH = (bVarE == null || (member = getMember()) == null) ? null : bVarE.h(member);
        if (i_dI == null) {
            return i_dH == null ? b.g.a.c.d.c : i_dH;
        }
        return i_dH == null ? i_dI : i_dI.k(i_dH);
    }

    @Override // b.g.a.c.d
    public p$b b(b.g.a.c.z.l<?> lVar, Class<?> cls) {
        b.g.a.c.b bVarE = lVar.e();
        i member = getMember();
        if (member == null) {
            return lVar.j(cls);
        }
        p$b p_bG = lVar.g(cls, member.d());
        if (bVarE == null) {
            return p_bG;
        }
        p$b p_bZ = bVarE.z(member);
        return p_bG == null ? p_bZ : p_bG.a(p_bZ);
    }

    public v(v vVar) {
        this._metadata = vVar._metadata;
    }
}
