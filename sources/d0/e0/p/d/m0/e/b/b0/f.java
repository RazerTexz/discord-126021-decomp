package d0.e0.p.d.m0.e.b.b0;

/* JADX INFO: compiled from: ReadKotlinClassHeaderAnnotationVisitor.java */
/* JADX INFO: loaded from: classes3.dex */
public class f extends b$b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ b$d f3372b;

    public f(b$d b_d) {
        this.f3372b = b_d;
    }

    @Override // d0.e0.p.d.m0.e.b.b0.b$b
    public void b(String[] strArr) {
        if (strArr == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "data", "kotlin/reflect/jvm/internal/impl/load/kotlin/header/ReadKotlinClassHeaderAnnotationVisitor$OldDeprecatedAnnotationArgumentVisitor$2", "visitEnd"));
        }
        this.f3372b.a.i = strArr;
    }
}
