package b.g.a.c.h0;

/* JADX INFO: compiled from: ResolvedRecursiveType.java */
/* JADX INFO: loaded from: classes3.dex */
public class j extends l {
    private static final long serialVersionUID = 1;
    public b.g.a.c.j _referencedType;

    public j(Class<?> cls, m mVar) {
        super(cls, mVar, null, null, 0, null, null, false);
    }

    @Override // b.g.a.c.j
    public b.g.a.c.j C(Class<?> cls, m mVar, b.g.a.c.j jVar, b.g.a.c.j[] jVarArr) {
        return null;
    }

    @Override // b.g.a.c.j
    public b.g.a.c.j D(b.g.a.c.j jVar) {
        return this;
    }

    @Override // b.g.a.c.j
    public b.g.a.c.j E(Object obj) {
        return this;
    }

    @Override // b.g.a.c.j
    public b.g.a.c.j G() {
        return this;
    }

    @Override // b.g.a.c.j
    public b.g.a.c.j H(Object obj) {
        return this;
    }

    @Override // b.g.a.c.j
    public b.g.a.c.j I(Object obj) {
        return this;
    }

    @Override // b.g.a.c.j
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj != null && obj.getClass() == j.class) {
        }
        return false;
    }

    @Override // b.g.a.c.h0.l, b.g.a.c.j
    public m j() {
        b.g.a.c.j jVar = this._referencedType;
        return jVar != null ? jVar.j() : this._bindings;
    }

    @Override // b.g.a.c.j
    public StringBuilder l(StringBuilder sb) {
        b.g.a.c.j jVar = this._referencedType;
        return jVar != null ? jVar.l(sb) : sb;
    }

    @Override // b.g.a.c.j
    public StringBuilder m(StringBuilder sb) {
        b.g.a.c.j jVar = this._referencedType;
        if (jVar != null) {
            return jVar.l(sb);
        }
        sb.append("?");
        return sb;
    }

    @Override // b.g.a.c.h0.l, b.g.a.c.j
    public b.g.a.c.j q() {
        b.g.a.c.j jVar = this._referencedType;
        return jVar != null ? jVar.q() : this._superClass;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(40);
        sb.append("[recursive type; ");
        b.g.a.c.j jVar = this._referencedType;
        if (jVar == null) {
            sb.append("UNRESOLVED");
        } else {
            sb.append(jVar._class.getName());
        }
        return sb.toString();
    }

    @Override // b.g.a.c.j
    public boolean v() {
        return false;
    }
}
