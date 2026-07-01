package h0.a.a;

import org.objectweb.asm.Opcodes;

/* JADX INFO: renamed from: h0.a.a.l, reason: use source file name */
/* JADX INFO: compiled from: FieldWriter.java */
/* JADX INFO: loaded from: classes3.dex */
public final class FieldWriter2 extends FieldVisitor2 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final SymbolTable2 f3710b;
    public final int c;
    public final int d;
    public final int e;
    public int f;
    public int g;
    public AnnotationWriter2 h;
    public AnnotationWriter2 i;
    public AnnotationWriter2 j;
    public AnnotationWriter2 k;
    public Attribute2 l;

    public FieldWriter2(SymbolTable2 symbolTable2, int i, String str, String str2, String str3, Object obj) {
        super(Opcodes.ASM7);
        this.f3710b = symbolTable2;
        this.c = i;
        this.d = symbolTable2.l(str);
        this.e = symbolTable2.l(str2);
        if (str3 != null) {
            this.f = symbolTable2.l(str3);
        }
        if (obj != null) {
            this.g = symbolTable2.b(obj).a;
        }
    }

    public AnnotationWriter2 a(String str, boolean z2) {
        ByteVector2 byteVector2 = new ByteVector2();
        byteVector2.j(this.f3710b.l(str));
        byteVector2.j(0);
        if (z2) {
            AnnotationWriter2 annotationWriter2 = new AnnotationWriter2(this.f3710b, true, byteVector2, this.h);
            this.h = annotationWriter2;
            return annotationWriter2;
        }
        AnnotationWriter2 annotationWriter3 = new AnnotationWriter2(this.f3710b, true, byteVector2, this.i);
        this.i = annotationWriter3;
        return annotationWriter3;
    }

    public AnnotationWriter2 b(int i, TypePath2 typePath2, String str, boolean z2) {
        ByteVector2 byteVector2 = new ByteVector2();
        b.i.a.f.e.o.f.W0(i, byteVector2);
        TypePath2.a(typePath2, byteVector2);
        byteVector2.j(this.f3710b.l(str));
        byteVector2.j(0);
        if (z2) {
            AnnotationWriter2 annotationWriter2 = new AnnotationWriter2(this.f3710b, true, byteVector2, this.j);
            this.j = annotationWriter2;
            return annotationWriter2;
        }
        AnnotationWriter2 annotationWriter3 = new AnnotationWriter2(this.f3710b, true, byteVector2, this.k);
        this.k = annotationWriter3;
        return annotationWriter3;
    }
}
