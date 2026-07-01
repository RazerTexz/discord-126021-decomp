package b.g.a.c.c0;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Type;

/* JADX INFO: compiled from: AnnotatedMethod.java */
/* JADX INFO: loaded from: classes3.dex */
public final class j extends n implements Serializable {
    private static final long serialVersionUID = 1;
    public Class<?>[] _paramClasses;
    public j$a _serialization;
    public final transient Method l;

    public j(e0 e0Var, Method method, p pVar, p[] pVarArr) {
        super(e0Var, pVar, pVarArr);
        if (method == null) {
            throw new IllegalArgumentException("Cannot construct AnnotatedMethod with null Method");
        }
        this.l = method;
    }

    @Override // b.g.a.c.c0.b
    public String c() {
        return this.l.getName();
    }

    @Override // b.g.a.c.c0.b
    public Class<?> d() {
        return this.l.getReturnType();
    }

    @Override // b.g.a.c.c0.b
    public b.g.a.c.j e() {
        return this.j.a(this.l.getGenericReturnType());
    }

    @Override // b.g.a.c.c0.b
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return b.g.a.c.i0.d.o(obj, j.class) && ((j) obj).l == this.l;
    }

    @Override // b.g.a.c.c0.i
    public Class<?> g() {
        return this.l.getDeclaringClass();
    }

    @Override // b.g.a.c.c0.i
    public String h() {
        String strH = super.h();
        int iO = o();
        if (iO == 0) {
            return b.d.b.a.a.w(strH, "()");
        }
        if (iO != 1) {
            return String.format("%s(%d params)", super.h(), Integer.valueOf(o()));
        }
        StringBuilder sbX = b.d.b.a.a.X(strH, "(");
        sbX.append(p(0).getName());
        sbX.append(")");
        return sbX.toString();
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
            return this.l.invoke(obj, null);
        } catch (IllegalAccessException | InvocationTargetException e) {
            StringBuilder sbU = b.d.b.a.a.U("Failed to getValue() with method ");
            sbU.append(h());
            sbU.append(": ");
            sbU.append(e.getMessage());
            throw new IllegalArgumentException(sbU.toString(), e);
        }
    }

    @Override // b.g.a.c.c0.i
    public b l(p pVar) {
        return new j(this.j, this.l, pVar, this._paramAnnotations);
    }

    @Override // b.g.a.c.c0.n
    public b.g.a.c.j n(int i) {
        Type[] genericParameterTypes = this.l.getGenericParameterTypes();
        if (i >= genericParameterTypes.length) {
            return null;
        }
        return this.j.a(genericParameterTypes[i]);
    }

    public int o() {
        if (this._paramClasses == null) {
            this._paramClasses = this.l.getParameterTypes();
        }
        return this._paramClasses.length;
    }

    public Class<?> p(int i) {
        if (this._paramClasses == null) {
            this._paramClasses = this.l.getParameterTypes();
        }
        Class<?>[] clsArr = this._paramClasses;
        if (i >= clsArr.length) {
            return null;
        }
        return clsArr[i];
    }

    public Object readResolve() {
        j$a j_a = this._serialization;
        Class<?> cls = j_a.clazz;
        try {
            Method declaredMethod = cls.getDeclaredMethod(j_a.name, j_a.args);
            if (!declaredMethod.isAccessible()) {
                b.g.a.c.i0.d.d(declaredMethod, false);
            }
            return new j(null, declaredMethod, null, null);
        } catch (Exception unused) {
            StringBuilder sbU = b.d.b.a.a.U("Could not find method '");
            sbU.append(this._serialization.name);
            sbU.append("' from Class '");
            sbU.append(cls.getName());
            throw new IllegalArgumentException(sbU.toString());
        }
    }

    public String toString() {
        StringBuilder sbU = b.d.b.a.a.U("[method ");
        sbU.append(h());
        sbU.append("]");
        return sbU.toString();
    }

    public Object writeReplace() {
        return new j(new j$a(this.l));
    }

    public j(j$a j_a) {
        super(null, null, null);
        this.l = null;
        this._serialization = j_a;
    }
}
