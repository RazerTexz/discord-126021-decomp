package b.g.a.c.c0;

import b.g.a.c.JavaType;

/* JADX INFO: renamed from: b.g.a.c.c0.n, reason: use source file name */
/* JADX INFO: compiled from: AnnotatedWithParams.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AnnotatedWithParams extends AnnotatedMember {
    private static final long serialVersionUID = 1;
    public final AnnotationMap[] _paramAnnotations;

    public AnnotatedWithParams(TypeResolutionContext typeResolutionContext, AnnotationMap annotationMap, AnnotationMap[] annotationMapArr) {
        super(typeResolutionContext, annotationMap);
        this._paramAnnotations = annotationMapArr;
    }

    public final AnnotatedParameter m(int i) {
        JavaType javaTypeN = n(i);
        TypeResolutionContext typeResolutionContext = this.j;
        AnnotationMap[] annotationMapArr = this._paramAnnotations;
        return new AnnotatedParameter(this, javaTypeN, typeResolutionContext, (annotationMapArr == null || i < 0 || i >= annotationMapArr.length) ? null : annotationMapArr[i], i);
    }

    public abstract JavaType n(int i);
}
