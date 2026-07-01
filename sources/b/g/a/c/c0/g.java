package b.g.a.c.c0;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Member;

/* JADX INFO: compiled from: AnnotatedField.java */
/* JADX INFO: loaded from: classes3.dex */
public final class g extends i implements Serializable {
    private static final long serialVersionUID = 1;
    public g$a _serialization;
    public final transient Field l;

    public g(e0 e0Var, Field field, p pVar) {
        super(e0Var, pVar);
        this.l = field;
    }

    @Override // b.g.a.c.c0.b
    public String c() {
        return this.l.getName();
    }

    @Override // b.g.a.c.c0.b
    public Class<?> d() {
        return this.l.getType();
    }

    @Override // b.g.a.c.c0.b
    public b.g.a.c.j e() {
        return this.j.a(this.l.getGenericType());
    }

    @Override // b.g.a.c.c0.b
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return b.g.a.c.i0.d.o(obj, g.class) && ((g) obj).l == this.l;
    }

    @Override // b.g.a.c.c0.i
    public Class<?> g() {
        return this.l.getDeclaringClass();
    }

    @Override // b.g.a.c.c0.b
    public int hashCode() {
        return this.l.getName().hashCode();
    }

    @Override // b.g.a.c.c0.i
    public Member i() {
        return this.l;
    }

    @Override // b.g.a.c.c0.i
    public Object j(Object obj) throws IllegalArgumentException {
        try {
            return this.l.get(obj);
        } catch (IllegalAccessException e) {
            StringBuilder sbU = b.d.b.a.a.U("Failed to getValue() for field ");
            sbU.append(h());
            sbU.append(": ");
            sbU.append(e.getMessage());
            throw new IllegalArgumentException(sbU.toString(), e);
        }
    }

    @Override // b.g.a.c.c0.i
    public b l(p pVar) {
        return new g(this.j, this.l, pVar);
    }

    public Object readResolve() {
        g$a g_a = this._serialization;
        Class<?> cls = g_a.clazz;
        try {
            Field declaredField = cls.getDeclaredField(g_a.name);
            if (!declaredField.isAccessible()) {
                b.g.a.c.i0.d.d(declaredField, false);
            }
            return new g(null, declaredField, null);
        } catch (Exception unused) {
            StringBuilder sbU = b.d.b.a.a.U("Could not find method '");
            sbU.append(this._serialization.name);
            sbU.append("' from Class '");
            sbU.append(cls.getName());
            throw new IllegalArgumentException(sbU.toString());
        }
    }

    public String toString() {
        StringBuilder sbU = b.d.b.a.a.U("[field ");
        sbU.append(h());
        sbU.append("]");
        return sbU.toString();
    }

    public Object writeReplace() {
        return new g(new g$a(this.l));
    }

    public g(g$a g_a) {
        super(null, null);
        this.l = null;
        this._serialization = g_a;
    }
}
