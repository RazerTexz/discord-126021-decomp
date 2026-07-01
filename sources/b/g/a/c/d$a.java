package b.g.a.c;

import b.g.a.a.i$d;
import b.g.a.a.p$b;
import java.io.Serializable;

/* JADX INFO: compiled from: BeanProperty.java */
/* JADX INFO: loaded from: classes3.dex */
public class d$a implements d, Serializable {
    private static final long serialVersionUID = 1;
    public final b.g.a.c.c0.i _member;
    public final s _metadata;
    public final t _name;
    public final j _type;
    public final t _wrapperName;

    public d$a(t tVar, j jVar, t tVar2, b.g.a.c.c0.i iVar, s sVar) {
        this._name = tVar;
        this._type = jVar;
        this._wrapperName = tVar2;
        this._metadata = sVar;
        this._member = iVar;
    }

    @Override // b.g.a.c.d
    public i$d a(b.g.a.c.z.l<?> lVar, Class<?> cls) {
        b.g.a.c.c0.i iVar;
        i$d i_dH;
        i$d i_dI = lVar.i(cls);
        b bVarE = lVar.e();
        return (bVarE == null || (iVar = this._member) == null || (i_dH = bVarE.h(iVar)) == null) ? i_dI : i_dI.k(i_dH);
    }

    @Override // b.g.a.c.d
    public p$b b(b.g.a.c.z.l<?> lVar, Class<?> cls) {
        b.g.a.c.c0.i iVar;
        p$b p_bZ;
        p$b p_bG = lVar.g(cls, this._type._class);
        b bVarE = lVar.e();
        return (bVarE == null || (iVar = this._member) == null || (p_bZ = bVarE.z(iVar)) == null) ? p_bG : p_bG.a(p_bZ);
    }

    @Override // b.g.a.c.d
    public b.g.a.c.c0.i getMember() {
        return this._member;
    }

    @Override // b.g.a.c.d
    public j getType() {
        return this._type;
    }
}
