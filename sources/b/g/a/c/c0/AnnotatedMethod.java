package b.g.a.c.c0;

import b.d.b.a.outline;
import b.g.a.c.JavaType;
import b.g.a.c.i0.ClassUtil;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Type;

/* JADX INFO: renamed from: b.g.a.c.c0.j, reason: use source file name */
/* JADX INFO: compiled from: AnnotatedMethod.java */
/* JADX INFO: loaded from: classes3.dex */
public final class AnnotatedMethod extends AnnotatedWithParams implements Serializable {
    private static final long serialVersionUID = 1;
    public Class<?>[] _paramClasses;
    public a _serialization;
    public final transient Method l;

    /* JADX INFO: renamed from: b.g.a.c.c0.j$a */
    /* JADX INFO: compiled from: AnnotatedMethod.java */
    public static final class a implements Serializable {
        private static final long serialVersionUID = 1;
        public Class<?>[] args;
        public Class<?> clazz;
        public String name;

        public a(Method method) {
            this.clazz = method.getDeclaringClass();
            this.name = method.getName();
            this.args = method.getParameterTypes();
        }
    }

    public AnnotatedMethod(TypeResolutionContext typeResolutionContext, Method method, AnnotationMap annotationMap, AnnotationMap[] annotationMapArr) {
        super(typeResolutionContext, annotationMap, annotationMapArr);
        if (method == null) {
            throw new IllegalArgumentException("Cannot construct AnnotatedMethod with null Method");
        }
        this.l = method;
    }

    @Override // b.g.a.c.c0.Annotated
    public String c() {
        return this.l.getName();
    }

    @Override // b.g.a.c.c0.Annotated
    public Class<?> d() {
        return this.l.getReturnType();
    }

    @Override // b.g.a.c.c0.Annotated
    public JavaType e() {
        return this.j.a(this.l.getGenericReturnType());
    }

    @Override // b.g.a.c.c0.Annotated
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return ClassUtil.o(obj, AnnotatedMethod.class) && ((AnnotatedMethod) obj).l == this.l;
    }

    @Override // b.g.a.c.c0.AnnotatedMember
    public Class<?> g() {
        return this.l.getDeclaringClass();
    }

    @Override // b.g.a.c.c0.AnnotatedMember
    public String h() {
        String strH = super.h();
        int iO = o();
        if (iO == 0) {
            return outline.w(strH, "()");
        }
        if (iO != 1) {
            return String.format("%s(%d params)", super.h(), Integer.valueOf(o()));
        }
        StringBuilder sbX = outline.X(strH, "(");
        sbX.append(p(0).getName());
        sbX.append(")");
        return sbX.toString();
    }

    @Override // b.g.a.c.c0.Annotated
    public int hashCode() {
        return this.l.getName().hashCode();
    }

    @Override // b.g.a.c.c0.AnnotatedMember
    public Member i() {
        return this.l;
    }

    @Override // b.g.a.c.c0.AnnotatedMember
    public Object j(Object obj) throws IllegalArgumentException {
        try {
            return this.l.invoke(obj, null);
        } catch (IllegalAccessException | InvocationTargetException e) {
            StringBuilder sbU = outline.U("Failed to getValue() with method ");
            sbU.append(h());
            sbU.append(": ");
            sbU.append(e.getMessage());
            throw new IllegalArgumentException(sbU.toString(), e);
        }
    }

    @Override // b.g.a.c.c0.AnnotatedMember
    public Annotated l(AnnotationMap annotationMap) {
        return new AnnotatedMethod(this.j, this.l, annotationMap, this._paramAnnotations);
    }

    @Override // b.g.a.c.c0.AnnotatedWithParams
    public JavaType n(int i) {
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
        a aVar = this._serialization;
        Class<?> cls = aVar.clazz;
        try {
            Method declaredMethod = cls.getDeclaredMethod(aVar.name, aVar.args);
            if (!declaredMethod.isAccessible()) {
                ClassUtil.d(declaredMethod, false);
            }
            return new AnnotatedMethod(null, declaredMethod, null, null);
        } catch (Exception unused) {
            StringBuilder sbU = outline.U("Could not find method '");
            sbU.append(this._serialization.name);
            sbU.append("' from Class '");
            sbU.append(cls.getName());
            throw new IllegalArgumentException(sbU.toString());
        }
    }

    public String toString() {
        StringBuilder sbU = outline.U("[method ");
        sbU.append(h());
        sbU.append("]");
        return sbU.toString();
    }

    public Object writeReplace() {
        return new AnnotatedMethod(new a(this.l));
    }

    public AnnotatedMethod(a aVar) {
        super(null, null, null);
        this.l = null;
        this._serialization = aVar;
    }
}
