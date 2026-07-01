package d0.e0.p.d.m0.e.b.b0;

/* JADX INFO: compiled from: ReadKotlinClassHeaderAnnotationVisitor.java */
/* JADX INFO: loaded from: classes3.dex */
public class c extends b$b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ b$c f3369b;

    public c(b$c b_c) {
        this.f3369b = b_c;
    }

    @Override // d0.e0.p.d.m0.e.b.b0.b$b
    public void b(String[] strArr) {
        if (strArr == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "result", "kotlin/reflect/jvm/internal/impl/load/kotlin/header/ReadKotlinClassHeaderAnnotationVisitor$KotlinMetadataArgumentVisitor$1", "visitEnd"));
        }
        this.f3369b.a.h = strArr;
    }
}
