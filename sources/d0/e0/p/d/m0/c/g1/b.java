package d0.e0.p.d.m0.c.g1;

/* JADX INFO: compiled from: AnnotatedImpl.java */
/* JADX INFO: loaded from: classes3.dex */
public class b implements a {
    public final g j;

    public b(g gVar) {
        if (gVar != null) {
            this.j = gVar;
        } else {
            a(0);
            throw null;
        }
    }

    public static /* synthetic */ void a(int i) {
        String str = i != 1 ? "Argument for @NotNull parameter '%s' of %s.%s must not be null" : "@NotNull method %s.%s must not return null";
        Object[] objArr = new Object[i != 1 ? 3 : 2];
        if (i != 1) {
            objArr[0] = "annotations";
        } else {
            objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/annotations/AnnotatedImpl";
        }
        if (i != 1) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/annotations/AnnotatedImpl";
        } else {
            objArr[1] = "getAnnotations";
        }
        if (i != 1) {
            objArr[2] = "<init>";
        }
        String str2 = String.format(str, objArr);
        if (i == 1) {
            throw new IllegalStateException(str2);
        }
    }

    @Override // d0.e0.p.d.m0.c.g1.a
    public g getAnnotations() {
        g gVar = this.j;
        if (gVar != null) {
            return gVar;
        }
        a(1);
        throw null;
    }
}
