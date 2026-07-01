package b.g.a.c.h0;

/* JADX INFO: compiled from: MapLikeType.java */
/* JADX INFO: loaded from: classes3.dex */
public class f extends l {
    private static final long serialVersionUID = 1;
    public final b.g.a.c.j _keyType;
    public final b.g.a.c.j _valueType;

    public f(Class<?> cls, m mVar, b.g.a.c.j jVar, b.g.a.c.j[] jVarArr, b.g.a.c.j jVar2, b.g.a.c.j jVar3, Object obj, Object obj2, boolean z2) {
        super(cls, mVar, jVar, jVarArr, jVar2._hash ^ jVar3._hash, obj, obj2, z2);
        this._keyType = jVar2;
        this._valueType = jVar3;
    }

    @Override // b.g.a.c.j
    public b.g.a.c.j C(Class<?> cls, m mVar, b.g.a.c.j jVar, b.g.a.c.j[] jVarArr) {
        return new f(cls, mVar, jVar, jVarArr, this._keyType, this._valueType, this._valueHandler, this._typeHandler, this._asStatic);
    }

    @Override // b.g.a.c.j
    public b.g.a.c.j D(b.g.a.c.j jVar) {
        return this._valueType == jVar ? this : new f(this._class, this._bindings, this._superClass, this._superInterfaces, this._keyType, jVar, this._valueHandler, this._typeHandler, this._asStatic);
    }

    @Override // b.g.a.c.j
    public /* bridge */ /* synthetic */ b.g.a.c.j E(Object obj) {
        return L(obj);
    }

    @Override // b.g.a.c.j
    public b.g.a.c.j F(b.g.a.c.j jVar) {
        b.g.a.c.j jVarF;
        b.g.a.c.j jVarF2;
        b.g.a.c.j jVarF3 = super.F(jVar);
        b.g.a.c.j jVarO = jVar.o();
        if ((jVarF3 instanceof f) && jVarO != null && (jVarF2 = this._keyType.F(jVarO)) != this._keyType) {
            jVarF3 = ((f) jVarF3).M(jVarF2);
        }
        b.g.a.c.j jVarK = jVar.k();
        return (jVarK == null || (jVarF = this._valueType.F(jVarK)) == this._valueType) ? jVarF3 : jVarF3.D(jVarF);
    }

    @Override // b.g.a.c.j
    public /* bridge */ /* synthetic */ b.g.a.c.j G() {
        return N();
    }

    @Override // b.g.a.c.j
    public /* bridge */ /* synthetic */ b.g.a.c.j H(Object obj) {
        return O(obj);
    }

    @Override // b.g.a.c.j
    public /* bridge */ /* synthetic */ b.g.a.c.j I(Object obj) {
        return P(obj);
    }

    @Override // b.g.a.c.h0.l
    public String K() {
        StringBuilder sb = new StringBuilder();
        sb.append(this._class.getName());
        if (this._keyType != null) {
            sb.append('<');
            sb.append(this._keyType.e());
            sb.append(',');
            sb.append(this._valueType.e());
            sb.append('>');
        }
        return sb.toString();
    }

    public f L(Object obj) {
        return new f(this._class, this._bindings, this._superClass, this._superInterfaces, this._keyType, this._valueType.H(obj), this._valueHandler, this._typeHandler, this._asStatic);
    }

    public f M(b.g.a.c.j jVar) {
        return jVar == this._keyType ? this : new f(this._class, this._bindings, this._superClass, this._superInterfaces, jVar, this._valueType, this._valueHandler, this._typeHandler, this._asStatic);
    }

    public f N() {
        return this._asStatic ? this : new f(this._class, this._bindings, this._superClass, this._superInterfaces, this._keyType, this._valueType.G(), this._valueHandler, this._typeHandler, true);
    }

    public f O(Object obj) {
        return new f(this._class, this._bindings, this._superClass, this._superInterfaces, this._keyType, this._valueType, this._valueHandler, obj, this._asStatic);
    }

    public f P(Object obj) {
        return new f(this._class, this._bindings, this._superClass, this._superInterfaces, this._keyType, this._valueType, obj, this._typeHandler, this._asStatic);
    }

    @Override // b.g.a.c.j
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != getClass()) {
            return false;
        }
        f fVar = (f) obj;
        return this._class == fVar._class && this._keyType.equals(fVar._keyType) && this._valueType.equals(fVar._valueType);
    }

    @Override // b.g.a.c.j
    public b.g.a.c.j k() {
        return this._valueType;
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
        this._keyType.m(sb);
        this._valueType.m(sb);
        sb.append(">;");
        return sb;
    }

    @Override // b.g.a.c.j
    public b.g.a.c.j o() {
        return this._keyType;
    }

    @Override // b.g.a.c.j
    public boolean s() {
        return super.s() || this._valueType.s() || this._keyType.s();
    }

    public String toString() {
        return String.format("[map-like type; class %s, %s -> %s]", this._class.getName(), this._keyType, this._valueType);
    }

    @Override // b.g.a.c.j
    public boolean v() {
        return true;
    }

    @Override // b.g.a.c.j
    public boolean z() {
        return true;
    }
}
