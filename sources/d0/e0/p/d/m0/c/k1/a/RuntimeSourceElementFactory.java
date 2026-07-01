package d0.e0.p.d.m0.c.k1.a;

import d0.e0.p.d.m0.c.k1.b.ReflectJavaElement;
import d0.e0.p.d.m0.c.v0;
import d0.e0.p.d.m0.e.a.j0.JavaSourceElementFactory;
import d0.e0.p.d.m0.e.a.j0.JavaSourceElementFactory2;
import d0.z.d.Intrinsics3;

/* JADX INFO: renamed from: d0.e0.p.d.m0.c.k1.a.m, reason: use source file name */
/* JADX INFO: compiled from: RuntimeSourceElementFactory.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class RuntimeSourceElementFactory implements JavaSourceElementFactory2 {
    public static final RuntimeSourceElementFactory a = new RuntimeSourceElementFactory();

    /* JADX INFO: renamed from: d0.e0.p.d.m0.c.k1.a.m$a */
    /* JADX INFO: compiled from: RuntimeSourceElementFactory.kt */
    public static final class a implements JavaSourceElementFactory {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ReflectJavaElement f3288b;

        public a(ReflectJavaElement reflectJavaElement) {
            Intrinsics3.checkNotNullParameter(reflectJavaElement, "javaElement");
            this.f3288b = reflectJavaElement;
        }

        @Override // d0.e0.p.d.m0.c.SourceElement
        public v0 getContainingFile() {
            v0 v0Var = v0.a;
            Intrinsics3.checkNotNullExpressionValue(v0Var, "NO_SOURCE_FILE");
            return v0Var;
        }

        @Override // d0.e0.p.d.m0.e.a.j0.JavaSourceElementFactory
        public ReflectJavaElement getJavaElement() {
            return this.f3288b;
        }

        public String toString() {
            return a.class.getName() + ": " + getJavaElement();
        }
    }

    @Override // d0.e0.p.d.m0.e.a.j0.JavaSourceElementFactory2
    public JavaSourceElementFactory source(d0.e0.p.d.m0.e.a.k0.l lVar) {
        Intrinsics3.checkNotNullParameter(lVar, "javaElement");
        return new a((ReflectJavaElement) lVar);
    }
}
