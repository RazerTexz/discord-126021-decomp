package b.g.a.c.h0;

/* JADX INFO: compiled from: ReferenceType.java */
/* JADX INFO: loaded from: classes3.dex */
public class i extends k {
    private static final long serialVersionUID = 1;
    public final b.g.a.c.j _anchorType;
    public final b.g.a.c.j _referencedType;

    public i(Class<?> cls, m mVar, b.g.a.c.j jVar, b.g.a.c.j[] jVarArr, b.g.a.c.j jVar2, b.g.a.c.j jVar3, Object obj, Object obj2, boolean z2) {
        super(cls, mVar, jVar, jVarArr, jVar2._hash, obj, obj2, z2);
        this._referencedType = jVar2;
        this._anchorType = jVar3 == null ? this : jVar3;
    }

    @Override // b.g.a.c.h0.k, b.g.a.c.j
    public b.g.a.c.j C(Class<?> cls, m mVar, b.g.a.c.j jVar, b.g.a.c.j[] jVarArr) {
        return new i(cls, this._bindings, jVar, jVarArr, this._referencedType, this._anchorType, this._valueHandler, this._typeHandler, this._asStatic);
    }

    @Override // b.g.a.c.h0.k, b.g.a.c.j
    public b.g.a.c.j D(b.g.a.c.j jVar) {
        return this._referencedType == jVar ? this : new i(this._class, this._bindings, this._superClass, this._superInterfaces, jVar, this._anchorType, this._valueHandler, this._typeHandler, this._asStatic);
    }

    @Override // b.g.a.c.h0.k, b.g.a.c.j
    public b.g.a.c.j E(Object obj) {
        b.g.a.c.j jVar = this._referencedType;
        return obj == jVar._typeHandler ? this : new i(this._class, this._bindings, this._superClass, this._superInterfaces, jVar.H(obj), this._anchorType, this._valueHandler, this._typeHandler, this._asStatic);
    }

    @Override // b.g.a.c.h0.k, b.g.a.c.j
    public /* bridge */ /* synthetic */ b.g.a.c.j G() {
        return P();
    }

    @Override // b.g.a.c.h0.k, b.g.a.c.j
    public /* bridge */ /* synthetic */ b.g.a.c.j H(Object obj) {
        return Q(obj);
    }

    @Override // b.g.a.c.h0.k, b.g.a.c.j
    public /* bridge */ /* synthetic */ b.g.a.c.j I(Object obj) {
        return R(obj);
    }

    @Override // b.g.a.c.h0.k, b.g.a.c.h0.l
    public String K() {
        return this._class.getName() + '<' + this._referencedType.e() + '>';
    }

    @Override // b.g.a.c.h0.k
    public /* bridge */ /* synthetic */ k M() {
        return P();
    }

    @Override // b.g.a.c.h0.k
    public /* bridge */ /* synthetic */ k N(Object obj) {
        return Q(obj);
    }

    @Override // b.g.a.c.h0.k
    public /* bridge */ /* synthetic */ k O(Object obj) {
        return R(obj);
    }

    public i P() {
        return this._asStatic ? this : new i(this._class, this._bindings, this._superClass, this._superInterfaces, this._referencedType.G(), this._anchorType, this._valueHandler, this._typeHandler, true);
    }

    public i Q(Object obj) {
        return obj == this._typeHandler ? this : new i(this._class, this._bindings, this._superClass, this._superInterfaces, this._referencedType, this._anchorType, this._valueHandler, obj, this._asStatic);
    }

    public i R(Object obj) {
        return obj == this._valueHandler ? this : new i(this._class, this._bindings, this._superClass, this._superInterfaces, this._referencedType, this._anchorType, obj, this._typeHandler, this._asStatic);
    }

    @Override // b.g.a.c.j, b.g.a.b.s.a
    public b.g.a.b.s.a a() {
        return this._referencedType;
    }

    @Override // b.g.a.b.s.a
    public boolean b() {
        return true;
    }

    @Override // b.g.a.c.h0.k, b.g.a.c.j
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != i.class) {
            return false;
        }
        i iVar = (i) obj;
        if (iVar._class != this._class) {
            return false;
        }
        return this._referencedType.equals(iVar._referencedType);
    }

    @Override // b.g.a.c.j
    public b.g.a.c.j k() {
        return this._referencedType;
    }

    @Override // b.g.a.c.h0.k, b.g.a.c.j
    public StringBuilder l(StringBuilder sb) {
        l.J(this._class, sb, true);
        return sb;
    }

    @Override // b.g.a.c.h0.k, b.g.a.c.j
    public StringBuilder m(StringBuilder sb) {
        l.J(this._class, sb, false);
        sb.append('<');
        StringBuilder sbM = this._referencedType.m(sb);
        sbM.append(">;");
        return sbM;
    }

    @Override // b.g.a.c.j
    public b.g.a.c.j p() {
        return this._referencedType;
    }

    @Override // b.g.a.c.h0.k
    public String toString() {
        StringBuilder sb = new StringBuilder(40);
        sb.append("[reference type, class ");
        sb.append(K());
        sb.append('<');
        sb.append(this._referencedType);
        sb.append('>');
        sb.append(']');
        return sb.toString();
    }
}
