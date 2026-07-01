package b.g.a.c.c0;

import java.io.Serializable;
import java.lang.reflect.Member;

/* JADX INFO: compiled from: VirtualAnnotatedMember.java */
/* JADX INFO: loaded from: classes3.dex */
public class f0 extends i implements Serializable {
    private static final long serialVersionUID = 1;
    public final Class<?> _declaringClass;
    public final String _name;
    public final b.g.a.c.j _type;

    public f0(e0 e0Var, Class<?> cls, String str, b.g.a.c.j jVar) {
        super(e0Var, null);
        this._declaringClass = cls;
        this._type = jVar;
        this._name = str;
    }

    @Override // b.g.a.c.c0.b
    public String c() {
        return this._name;
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
        if (!b.g.a.c.i0.d.o(obj, f0.class)) {
            return false;
        }
        f0 f0Var = (f0) obj;
        return f0Var._declaringClass == this._declaringClass && f0Var._name.equals(this._name);
    }

    @Override // b.g.a.c.c0.i
    public Class<?> g() {
        return this._declaringClass;
    }

    @Override // b.g.a.c.c0.b
    public int hashCode() {
        return this._name.hashCode();
    }

    @Override // b.g.a.c.c0.i
    public Member i() {
        return null;
    }

    @Override // b.g.a.c.c0.i
    public Object j(Object obj) throws IllegalArgumentException {
        throw new IllegalArgumentException(b.d.b.a.a.J(b.d.b.a.a.U("Cannot get virtual property '"), this._name, "'"));
    }

    @Override // b.g.a.c.c0.i
    public b l(p pVar) {
        return this;
    }

    public String toString() {
        StringBuilder sbU = b.d.b.a.a.U("[virtual ");
        sbU.append(h());
        sbU.append("]");
        return sbU.toString();
    }
}
