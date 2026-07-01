package d0.e0.p.d.m0.e.b.b0;

/* JADX INFO: compiled from: ReadKotlinClassHeaderAnnotationVisitor.java */
/* JADX INFO: loaded from: classes3.dex */
public class d extends b$b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ b$c f3370b;

    public d(b$c b_c) {
        this.f3370b = b_c;
    }

    @Override // d0.e0.p.d.m0.e.b.b0.b$b
    public void b(String[] strArr) {
        if (strArr == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "result", "kotlin/reflect/jvm/internal/impl/load/kotlin/header/ReadKotlinClassHeaderAnnotationVisitor$KotlinMetadataArgumentVisitor$2", "visitEnd"));
        }
        this.f3370b.a.i = strArr;
    }
}
