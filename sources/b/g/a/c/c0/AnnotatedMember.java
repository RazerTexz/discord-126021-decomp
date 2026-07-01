package b.g.a.c.c0;

import b.g.a.c.i0.ClassUtil;
import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.lang.reflect.Member;
import java.util.HashMap;

/* JADX INFO: renamed from: b.g.a.c.c0.i, reason: use source file name */
/* JADX INFO: compiled from: AnnotatedMember.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AnnotatedMember extends Annotated implements Serializable {
    private static final long serialVersionUID = 1;
    public final transient TypeResolutionContext j;
    public final transient AnnotationMap k;

    public AnnotatedMember(TypeResolutionContext typeResolutionContext, AnnotationMap annotationMap) {
        this.j = typeResolutionContext;
        this.k = annotationMap;
    }

    @Override // b.g.a.c.c0.Annotated
    public final <A extends Annotation> A b(Class<A> cls) {
        HashMap<Class<?>, Annotation> map;
        AnnotationMap annotationMap = this.k;
        if (annotationMap == null || (map = annotationMap.j) == null) {
            return null;
        }
        return (A) map.get(cls);
    }

    public final void f(boolean z2) {
        Member memberI = i();
        if (memberI != null) {
            ClassUtil.d(memberI, z2);
        }
    }

    public abstract Class<?> g();

    public String h() {
        return g().getName() + "#" + c();
    }

    public abstract Member i();

    public abstract Object j(Object obj) throws UnsupportedOperationException, IllegalArgumentException;

    public final boolean k(Class<?> cls) {
        HashMap<Class<?>, Annotation> map;
        AnnotationMap annotationMap = this.k;
        if (annotationMap == null || (map = annotationMap.j) == null) {
            return false;
        }
        return map.containsKey(cls);
    }

    public abstract Annotated l(AnnotationMap annotationMap);
}
