package b.g.a.c.h0;

/* JADX INFO: compiled from: SimpleType.java */
/* JADX INFO: loaded from: classes3.dex */
public class k extends l {
    private static final long serialVersionUID = 1;

    public k(Class<?> cls, m mVar, b.g.a.c.j jVar, b.g.a.c.j[] jVarArr, Object obj, Object obj2, boolean z2) {
        super(cls, mVar, jVar, jVarArr, 0, obj, obj2, z2);
    }

    public static k L(Class<?> cls) {
        return new k(cls, null, null, null, null, null, false);
    }

    @Override // b.g.a.c.j
    public b.g.a.c.j C(Class<?> cls, m mVar, b.g.a.c.j jVar, b.g.a.c.j[] jVarArr) {
        return null;
    }

    @Override // b.g.a.c.j
    public b.g.a.c.j D(b.g.a.c.j jVar) {
        throw new IllegalArgumentException("Simple types have no content types; cannot call withContentType()");
    }

    @Override // b.g.a.c.j
    public b.g.a.c.j E(Object obj) {
        throw new IllegalArgumentException("Simple types have no content types; cannot call withContenTypeHandler()");
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
        int iJ = this._bindings.j();
        if (iJ > 0) {
            sb.append('<');
            for (int i = 0; i < iJ; i++) {
                b.g.a.c.j jVarF = f(i);
                if (i > 0) {
                    sb.append(',');
                }
                sb.append(jVarF.e());
            }
            sb.append('>');
        }
        return sb.toString();
    }

    public k M() {
        return this._asStatic ? this : new k(this._class, this._bindings, this._superClass, this._superInterfaces, this._valueHandler, this._typeHandler, true);
    }

    public k N(Object obj) {
        return this._typeHandler == obj ? this : new k(this._class, this._bindings, this._superClass, this._superInterfaces, this._valueHandler, obj, this._asStatic);
    }

    public k O(Object obj) {
        return obj == this._valueHandler ? this : new k(this._class, this._bindings, this._superClass, this._superInterfaces, obj, this._typeHandler, this._asStatic);
    }

    @Override // b.g.a.c.j
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != getClass()) {
            return false;
        }
        k kVar = (k) obj;
        if (kVar._class != this._class) {
            return false;
        }
        return this._bindings.equals(kVar._bindings);
    }

    @Override // b.g.a.c.j
    public StringBuilder l(StringBuilder sb) {
        l.J(this._class, sb, true);
        return sb;
    }

    @Override // b.g.a.c.j
    public StringBuilder m(StringBuilder sb) {
        l.J(this._class, sb, false);
        int iJ = this._bindings.j();
        if (iJ > 0) {
            sb.append('<');
            for (int i = 0; i < iJ; i++) {
                sb = f(i).m(sb);
            }
            sb.append('>');
        }
        sb.append(';');
        return sb;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(40);
        sb.append("[simple type, class ");
        sb.append(K());
        sb.append(']');
        return sb.toString();
    }

    @Override // b.g.a.c.j
    public boolean v() {
        return false;
    }

    public k(Class<?> cls) {
        this(cls, m.l, null, null, null, null, false);
    }

    public k(Class<?> cls, m mVar, b.g.a.c.j jVar, b.g.a.c.j[] jVarArr, int i, Object obj, Object obj2, boolean z2) {
        super(cls, mVar, jVar, jVarArr, i, obj, obj2, z2);
    }
}
