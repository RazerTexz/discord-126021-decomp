package p507d0.p513e0.p514p.p515d.p517m0.p521c.p526k1.p528b;

import java.lang.annotation.Annotation;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11564a;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11568c;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.C11716e;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.c.k1.b.e */
/* JADX INFO: compiled from: ReflectJavaAnnotationArguments.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C11426e extends AbstractC11425d implements InterfaceC11568c {

    /* JADX INFO: renamed from: c */
    public final Annotation f23041c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C11426e(C11716e c11716e, Annotation annotation) {
        super(c11716e);
        C12238m.checkNotNullParameter(annotation, "annotation");
        this.f23041c = annotation;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11568c
    public InterfaceC11564a getAnnotation() {
        return new C11424c(this.f23041c);
    }
}
