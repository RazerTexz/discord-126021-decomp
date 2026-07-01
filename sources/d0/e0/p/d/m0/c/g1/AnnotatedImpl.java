package d0.e0.p.d.m0.c.g1;

/* JADX INFO: renamed from: d0.e0.p.d.m0.c.g1.b, reason: use source file name */
/* JADX INFO: compiled from: AnnotatedImpl.java */
/* JADX INFO: loaded from: classes3.dex */
public class AnnotatedImpl implements Annotations3 {
    public final Annotations4 j;

    public AnnotatedImpl(Annotations4 annotations4) {
        if (annotations4 != null) {
            this.j = annotations4;
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

    @Override // d0.e0.p.d.m0.c.g1.Annotations3
    public Annotations4 getAnnotations() {
        Annotations4 annotations4 = this.j;
        if (annotations4 != null) {
            return annotations4;
        }
        a(1);
        throw null;
    }
}
