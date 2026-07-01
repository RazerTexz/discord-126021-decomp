package d0.e0.p.d.m0.e.b.b0;

import d0.e0.p.d.m0.e.b.b0.ReadKotlinClassHeaderAnnotationVisitor;

/* JADX INFO: renamed from: d0.e0.p.d.m0.e.b.b0.e, reason: use source file name */
/* JADX INFO: compiled from: ReadKotlinClassHeaderAnnotationVisitor.java */
/* JADX INFO: loaded from: classes3.dex */
public class ReadKotlinClassHeaderAnnotationVisitor4 extends ReadKotlinClassHeaderAnnotationVisitor.b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ReadKotlinClassHeaderAnnotationVisitor.d f3371b;

    public ReadKotlinClassHeaderAnnotationVisitor4(ReadKotlinClassHeaderAnnotationVisitor.d dVar) {
        this.f3371b = dVar;
    }

    @Override // d0.e0.p.d.m0.e.b.b0.ReadKotlinClassHeaderAnnotationVisitor.b
    public void b(String[] strArr) {
        if (strArr == null) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "data", "kotlin/reflect/jvm/internal/impl/load/kotlin/header/ReadKotlinClassHeaderAnnotationVisitor$OldDeprecatedAnnotationArgumentVisitor$1", "visitEnd"));
        }
        ReadKotlinClassHeaderAnnotationVisitor.this.h = strArr;
    }
}
