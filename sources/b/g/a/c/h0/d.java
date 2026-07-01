package b.g.a.c.h0;

/* JADX INFO: compiled from: CollectionLikeType.java */
/* JADX INFO: loaded from: classes3.dex */
public class d extends l {
    private static final long serialVersionUID = 1;
    public final b.g.a.c.j _elementType;

    public d(Class<?> cls, m mVar, b.g.a.c.j jVar, b.g.a.c.j[] jVarArr, b.g.a.c.j jVar2, Object obj, Object obj2, boolean z2) {
        super(cls, mVar, jVar, jVarArr, jVar2._hash, obj, obj2, z2);
        this._elementType = jVar2;
    }

    @Override // b.g.a.c.j
    public b.g.a.c.j C(Class<?> cls, m mVar, b.g.a.c.j jVar, b.g.a.c.j[] jVarArr) {
        return new d(cls, mVar, jVar, jVarArr, this._elementType, this._valueHandler, this._typeHandler, this._asStatic);
    }

    @Override // b.g.a.c.j
    public b.g.a.c.j D(b.g.a.c.j jVar) {
        return this._elementType == jVar ? this : new d(this._class, this._bindings, this._superClass, this._superInterfaces, jVar, this._valueHandler, this._typeHandler, this._asStatic);
    }

    @Override // b.g.a.c.j
    public /* bridge */ /* synthetic */ b.g.a.c.j E(Object obj) {
        return L(obj);
    }

    @Override // b.g.a.c.j
    public b.g.a.c.j F(b.g.a.c.j jVar) {
        b.g.a.c.j jVarF;
        b.g.a.c.j jVarF2 = super.F(jVar);
        b.g.a.c.j jVarK = jVar.k();
        return (jVarK == null || (jVarF = this._elementType.F(jVarK)) == this._elementType) ? jVarF2 : jVarF2.D(jVarF);
    }

    @Override // b.g.a.c.j
    public /* bridge */ /* synthetic */ b.g.a.c.j G() {
        return M();
    }

    @Override // b.g.a.c.j
    public /* bridge */ /* synthetic */ b.g.a.c.j H(Object obj) {
        return N(obj);
    }

    @Override // b.g.a.c.j
    public /* bridge */ /* synthetic */ b.g.a.c.j I(Object obj) {
        return O(obj);
    }

    @Override // b.g.a.c.h0.l
    public String K() {
        StringBuilder sb = new StringBuilder();
        sb.append(this._class.getName());
        if (this._elementType != null) {
            sb.append('<');
            sb.append(this._elementType.e());
            sb.append('>');
        }
        return sb.toString();
    }

    public d L(Object obj) {
        return new d(this._class, this._bindings, this._superClass, this._superInterfaces, this._elementType.H(obj), this._valueHandler, this._typeHandler, this._asStatic);
    }

    public d M() {
        return this._asStatic ? this : new d(this._class, this._bindings, this._superClass, this._superInterfaces, this._elementType.G(), this._valueHandler, this._typeHandler, true);
    }

    public d N(Object obj) {
        return new d(this._class, this._bindings, this._superClass, this._superInterfaces, this._elementType, this._valueHandler, obj, this._asStatic);
    }

    public d O(Object obj) {
        return new d(this._class, this._bindings, this._superClass, this._superInterfaces, this._elementType, obj, this._typeHandler, this._asStatic);
    }

    @Override // b.g.a.c.j
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != getClass()) {
            return false;
        }
        d dVar = (d) obj;
        return this._class == dVar._class && this._elementType.equals(dVar._elementType);
    }

    @Override // b.g.a.c.j
    public b.g.a.c.j k() {
        return this._elementType;
    }

    @Override // b.g.a.c.j
    public StringBuilder l(StringBuilder sb) {
        l.J(this._class, sb, true);
        return sb;
    }

    @Override // b.g.a.c.j
    public StringBuilder m(StringBuilder sb) {
        l.J(this._class, sb, false);
        sb.append('<');
        this._elementType.m(sb);
        sb.append(">;");
        return sb;
    }

    @Override // b.g.a.c.j
    public boolean s() {
        return super.s() || this._elementType.s();
    }

    public String toString() {
        StringBuilder sbU = b.d.b.a.a.U("[collection-like type; class ");
        b.d.b.a.a.k0(this._class, sbU, ", contains ");
        sbU.append(this._elementType);
        sbU.append("]");
        return sbU.toString();
    }

    @Override // b.g.a.c.j
    public boolean u() {
        return true;
    }

    @Override // b.g.a.c.j
    public boolean v() {
        return true;
    }
}
