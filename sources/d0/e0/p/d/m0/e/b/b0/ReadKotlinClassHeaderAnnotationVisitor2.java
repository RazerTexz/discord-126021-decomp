package d0.e0.p.d.m0.e.b.b0;

import d0.e0.p.d.m0.e.b.b0.ReadKotlinClassHeaderAnnotationVisitor;

/* JADX INFO: renamed from: d0.e0.p.d.m0.e.b.b0.c, reason: use source file name */
/* JADX INFO: compiled from: ReadKotlinClassHeaderAnnotationVisitor.java */
/* JADX INFO: loaded from: classes3.dex */
public class ReadKotlinClassHeaderAnnotationVisitor2 extends ReadKotlinClassHeaderAnnotationVisitor.b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ReadKotlinClassHeaderAnnotationVisitor.c f3369b;

    public ReadKotlinClassHeaderAnnotationVisitor2(ReadKotlinClassHeaderAnnotationVisitor.c cVar) {
        this.f3369b = cVar;
    }

    @Override // d0.e0.p.d.m0.e.b.b0.ReadKotlinClassHeaderAnnotationVisitor.b
    public void b(String[] strArr) {
        if (strArr == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "result", "kotlin/reflect/jvm/internal/impl/load/kotlin/header/ReadKotlinClassHeaderAnnotationVisitor$KotlinMetadataArgumentVisitor$1", "visitEnd"));
        }
        ReadKotlinClassHeaderAnnotationVisitor.this.h = strArr;
    }
}
