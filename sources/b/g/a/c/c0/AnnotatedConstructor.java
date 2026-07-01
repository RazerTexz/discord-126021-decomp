package b.g.a.c.c0;

import b.d.b.a.outline;
import b.g.a.c.JavaType;
import b.g.a.c.i0.ClassUtil;
import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.Member;
import java.lang.reflect.Type;

/* JADX INFO: renamed from: b.g.a.c.c0.e, reason: use source file name */
/* JADX INFO: compiled from: AnnotatedConstructor.java */
/* JADX INFO: loaded from: classes3.dex */
public final class AnnotatedConstructor extends AnnotatedWithParams {
    private static final long serialVersionUID = 1;
    public final Constructor<?> _constructor;
    public a _serialization;

    /* JADX INFO: renamed from: b.g.a.c.c0.e$a */
    /* JADX INFO: compiled from: AnnotatedConstructor.java */
    public static final class a implements Serializable {
        private static final long serialVersionUID = 1;
        public Class<?>[] args;
        public Class<?> clazz;

        public a(Constructor<?> constructor) {
            this.clazz = constructor.getDeclaringClass();
            this.args = constructor.getParameterTypes();
        }
    }

    public AnnotatedConstructor(TypeResolutionContext typeResolutionContext, Constructor<?> constructor, AnnotationMap annotationMap, AnnotationMap[] annotationMapArr) {
        super(typeResolutionContext, annotationMap, annotationMapArr);
        if (constructor == null) {
            throw new IllegalArgumentException("Null constructor not allowed");
        }
        this._constructor = constructor;
    }

    @Override // b.g.a.c.c0.Annotated
    public String c() {
        return this._constructor.getName();
    }

    @Override // b.g.a.c.c0.Annotated
    public Class<?> d() {
        return this._constructor.getDeclaringClass();
    }

    @Override // b.g.a.c.c0.Annotated
    public JavaType e() {
        return this.j.a(d());
    }

    @Override // b.g.a.c.c0.Annotated
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return ClassUtil.o(obj, AnnotatedConstructor.class) && ((AnnotatedConstructor) obj)._constructor == this._constructor;
    }

    @Override // b.g.a.c.c0.AnnotatedMember
    public Class<?> g() {
        return this._constructor.getDeclaringClass();
    }

    @Override // b.g.a.c.c0.Annotated
    public int hashCode() {
        return this._constructor.getName().hashCode();
    }

    @Override // b.g.a.c.c0.AnnotatedMember
    public Member i() {
        return this._constructor;
    }

    @Override // b.g.a.c.c0.AnnotatedMember
    public Object j(Object obj) throws UnsupportedOperationException {
        StringBuilder sbU = outline.U("Cannot call getValue() on constructor of ");
        sbU.append(g().getName());
        throw new UnsupportedOperationException(sbU.toString());
    }

    @Override // b.g.a.c.c0.AnnotatedMember
    public Annotated l(AnnotationMap annotationMap) {
        return new AnnotatedConstructor(this.j, this._constructor, annotationMap, this._paramAnnotations);
    }

    @Override // b.g.a.c.c0.AnnotatedWithParams
    public JavaType n(int i) {
        Type[] genericParameterTypes = this._constructor.getGenericParameterTypes();
        if (i >= genericParameterTypes.length) {
            return null;
        }
        return this.j.a(genericParameterTypes[i]);
    }

    public Object readResolve() {
        a aVar = this._serialization;
        Class<?> cls = aVar.clazz;
        try {
            Constructor<?> declaredConstructor = cls.getDeclaredConstructor(aVar.args);
            if (!declaredConstructor.isAccessible()) {
                ClassUtil.d(declaredConstructor, false);
            }
            return new AnnotatedConstructor(null, declaredConstructor, null, null);
        } catch (Exception unused) {
            StringBuilder sbU = outline.U("Could not find constructor with ");
            sbU.append(this._serialization.args.length);
            sbU.append(" args from Class '");
            sbU.append(cls.getName());
            throw new IllegalArgumentException(sbU.toString());
        }
    }

    public String toString() {
        int length = this._constructor.getParameterTypes().length;
        Object[] objArr = new Object[4];
        objArr[0] = ClassUtil.u(this._constructor.getDeclaringClass());
        objArr[1] = Integer.valueOf(length);
        objArr[2] = length == 1 ? "" : "s";
        objArr[3] = this.k;
        return String.format("[constructor for %s (%d arg%s), annotations: %s", objArr);
    }

    public Object writeReplace() {
        return new AnnotatedConstructor(new a(this._constructor));
    }

    public AnnotatedConstructor(a aVar) {
        super(null, null, null);
        this._constructor = null;
        this._serialization = aVar;
    }
}
