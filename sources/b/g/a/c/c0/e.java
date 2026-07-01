package b.g.a.c.c0;

import java.lang.reflect.Constructor;
import java.lang.reflect.Member;
import java.lang.reflect.Type;

/* JADX INFO: compiled from: AnnotatedConstructor.java */
/* JADX INFO: loaded from: classes3.dex */
public final class e extends n {
    private static final long serialVersionUID = 1;
    public final Constructor<?> _constructor;
    public e$a _serialization;

    public e(e0 e0Var, Constructor<?> constructor, p pVar, p[] pVarArr) {
        super(e0Var, pVar, pVarArr);
        if (constructor == null) {
            throw new IllegalArgumentException("Null constructor not allowed");
        }
        this._constructor = constructor;
    }

    @Override // b.g.a.c.c0.b
    public String c() {
        return this._constructor.getName();
    }

    @Override // b.g.a.c.c0.b
    public Class<?> d() {
        return this._constructor.getDeclaringClass();
    }

    @Override // b.g.a.c.c0.b
    public b.g.a.c.j e() {
        return this.j.a(d());
    }

    @Override // b.g.a.c.c0.b
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return b.g.a.c.i0.d.o(obj, e.class) && ((e) obj)._constructor == this._constructor;
    }

    @Override // b.g.a.c.c0.i
    public Class<?> g() {
        return this._constructor.getDeclaringClass();
    }

    @Override // b.g.a.c.c0.b
    public int hashCode() {
        return this._constructor.getName().hashCode();
    }

    @Override // b.g.a.c.c0.i
    public Member i() {
        return this._constructor;
    }

    @Override // b.g.a.c.c0.i
    public Object j(Object obj) throws UnsupportedOperationException {
        StringBuilder sbU = b.d.b.a.a.U("Cannot call getValue() on constructor of ");
        sbU.append(g().getName());
        throw new UnsupportedOperationException(sbU.toString());
    }

    @Override // b.g.a.c.c0.i
    public b l(p pVar) {
        return new e(this.j, this._constructor, pVar, this._paramAnnotations);
    }

    @Override // b.g.a.c.c0.n
    public b.g.a.c.j n(int i) {
        Type[] genericParameterTypes = this._constructor.getGenericParameterTypes();
        if (i >= genericParameterTypes.length) {
            return null;
        }
        return this.j.a(genericParameterTypes[i]);
    }

    public Object readResolve() {
        e$a e_a = this._serialization;
        Class<?> cls = e_a.clazz;
        try {
            Constructor<?> declaredConstructor = cls.getDeclaredConstructor(e_a.args);
            if (!declaredConstructor.isAccessible()) {
                b.g.a.c.i0.d.d(declaredConstructor, false);
            }
            return new e(null, declaredConstructor, null, null);
        } catch (Exception unused) {
            StringBuilder sbU = b.d.b.a.a.U("Could not find constructor with ");
            sbU.append(this._serialization.args.length);
            sbU.append(" args from Class '");
            sbU.append(cls.getName());
            throw new IllegalArgumentException(sbU.toString());
        }
    }

    public String toString() {
        int length = this._constructor.getParameterTypes().length;
        Object[] objArr = new Object[4];
        objArr[0] = b.g.a.c.i0.d.u(this._constructor.getDeclaringClass());
        objArr[1] = Integer.valueOf(length);
        objArr[2] = length == 1 ? "" : "s";
        objArr[3] = this.k;
        return String.format("[constructor for %s (%d arg%s), annotations: %s", objArr);
    }

    public Object writeReplace() {
        return new e(new e$a(this._constructor));
    }

    public e(e$a e_a) {
        super(null, null, null);
        this._constructor = null;
        this._serialization = e_a;
    }
}
