package b.g.a.c.c0;

import b.d.b.a.outline;
import b.g.a.c.JavaType;
import b.g.a.c.i0.ClassUtil;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Member;

/* JADX INFO: renamed from: b.g.a.c.c0.g, reason: use source file name */
/* JADX INFO: compiled from: AnnotatedField.java */
/* JADX INFO: loaded from: classes3.dex */
public final class AnnotatedField extends AnnotatedMember implements Serializable {
    private static final long serialVersionUID = 1;
    public a _serialization;
    public final transient Field l;

    /* JADX INFO: renamed from: b.g.a.c.c0.g$a */
    /* JADX INFO: compiled from: AnnotatedField.java */
    public static final class a implements Serializable {
        private static final long serialVersionUID = 1;
        public Class<?> clazz;
        public String name;

        public a(Field field) {
            this.clazz = field.getDeclaringClass();
            this.name = field.getName();
        }
    }

    public AnnotatedField(TypeResolutionContext typeResolutionContext, Field field, AnnotationMap annotationMap) {
        super(typeResolutionContext, annotationMap);
        this.l = field;
    }

    @Override // b.g.a.c.c0.Annotated
    public String c() {
        return this.l.getName();
    }

    @Override // b.g.a.c.c0.Annotated
    public Class<?> d() {
        return this.l.getType();
    }

    @Override // b.g.a.c.c0.Annotated
    public JavaType e() {
        return this.j.a(this.l.getGenericType());
    }

    @Override // b.g.a.c.c0.Annotated
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return ClassUtil.o(obj, AnnotatedField.class) && ((AnnotatedField) obj).l == this.l;
    }

    @Override // b.g.a.c.c0.AnnotatedMember
    public Class<?> g() {
        return this.l.getDeclaringClass();
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
            return this.l.get(obj);
        } catch (IllegalAccessException e) {
            StringBuilder sbU = outline.U("Failed to getValue() for field ");
            sbU.append(h());
            sbU.append(": ");
            sbU.append(e.getMessage());
            throw new IllegalArgumentException(sbU.toString(), e);
        }
    }

    @Override // b.g.a.c.c0.AnnotatedMember
    public Annotated l(AnnotationMap annotationMap) {
        return new AnnotatedField(this.j, this.l, annotationMap);
    }

    public Object readResolve() {
        a aVar = this._serialization;
        Class<?> cls = aVar.clazz;
        try {
            Field declaredField = cls.getDeclaredField(aVar.name);
            if (!declaredField.isAccessible()) {
                ClassUtil.d(declaredField, false);
            }
            return new AnnotatedField(null, declaredField, null);
        } catch (Exception unused) {
            StringBuilder sbU = outline.U("Could not find method '");
            sbU.append(this._serialization.name);
            sbU.append("' from Class '");
            sbU.append(cls.getName());
            throw new IllegalArgumentException(sbU.toString());
        }
    }

    public String toString() {
        StringBuilder sbU = outline.U("[field ");
        sbU.append(h());
        sbU.append("]");
        return sbU.toString();
    }

    public Object writeReplace() {
        return new AnnotatedField(new a(this.l));
    }

    public AnnotatedField(a aVar) {
        super(null, null);
        this.l = null;
        this._serialization = aVar;
    }
}
