package b.g.a.c.c0;

import java.lang.reflect.Member;

/* JADX INFO: compiled from: AnnotatedParameter.java */
/* JADX INFO: loaded from: classes3.dex */
public final class m extends i {
    private static final long serialVersionUID = 1;
    public final int _index;
    public final n _owner;
    public final b.g.a.c.j _type;

    public m(n nVar, b.g.a.c.j jVar, e0 e0Var, p pVar, int i) {
        super(e0Var, pVar);
        this._owner = nVar;
        this._type = jVar;
        this._index = i;
    }

    @Override // b.g.a.c.c0.b
    public String c() {
        return "";
    }

    @Override // b.g.a.c.c0.b
    public Class<?> d() {
        return this._type._class;
    }

    @Override // b.g.a.c.c0.b
    public b.g.a.c.j e() {
        return this._type;
    }

    @Override // b.g.a.c.c0.b
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!b.g.a.c.i0.d.o(obj, m.class)) {
            return false;
        }
        m mVar = (m) obj;
        return mVar._owner.equals(this._owner) && mVar._index == this._index;
    }

    @Override // b.g.a.c.c0.i
    public Class<?> g() {
        return this._owner.g();
    }

    @Override // b.g.a.c.c0.b
    public int hashCode() {
        return this._owner.hashCode() + this._index;
    }

    @Override // b.g.a.c.c0.i
    public Member i() {
        return this._owner.i();
    }

    @Override // b.g.a.c.c0.i
    public Object j(Object obj) throws UnsupportedOperationException {
        StringBuilder sbU = b.d.b.a.a.U("Cannot call getValue() on constructor parameter of ");
        sbU.append(g().getName());
        throw new UnsupportedOperationException(sbU.toString());
    }

    @Override // b.g.a.c.c0.i
    public b l(p pVar) {
        if (pVar == this.k) {
            return this;
        }
        n nVar = this._owner;
        int i = this._index;
        nVar._paramAnnotations[i] = pVar;
        return nVar.m(i);
    }

    public String toString() {
        StringBuilder sbU = b.d.b.a.a.U("[parameter #");
        sbU.append(this._index);
        sbU.append(", annotations: ");
        sbU.append(this.k);
        sbU.append("]");
        return sbU.toString();
    }
}
