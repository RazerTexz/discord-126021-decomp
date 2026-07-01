package h0.a.a;

/* JADX INFO: renamed from: h0.a.a.q, reason: use source file name */
/* JADX INFO: compiled from: MethodVisitor.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class MethodVisitor2 {
    public final int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public MethodVisitor2 f3715b;

    public MethodVisitor2(int i) {
        if (i != 393216 && i != 327680 && i != 262144 && i != 458752) {
            throw new IllegalArgumentException();
        }
        this.a = i;
        this.f3715b = null;
    }

    public abstract AnnotationWriter2 a(String str, boolean z2);

    public abstract void b(int i, String str, String str2, String str3);

    public abstract void c(int i, int i2, Object[] objArr, int i3, Object[] objArr2);

    public abstract void d(int i, int i2);

    public abstract void e(int i);

    public abstract AnnotationWriter2 f(int i, TypePath2 typePath2, String str, boolean z2);

    public abstract void g(int i, int i2);

    public abstract void h(int i, Label2 label2);

    public abstract void i(Label2 label2);

    public abstract void j(Object obj);

    public abstract void k(int i, Label2 label2);

    public abstract void l(String str, String str2, String str3, Label2 label2, Label2 label3, int i);

    public abstract AnnotationWriter2 m(int i, TypePath2 typePath2, Label2[] label2Arr, Label2[] label2Arr2, int[] iArr, String str, boolean z2);

    public abstract void n(int i, int i2);

    @Deprecated
    public void o(int i, String str, String str2, String str3) {
        if (this.a >= 327680) {
            p(i, str, str2, str3, i == 185);
            return;
        }
        MethodVisitor2 methodVisitor2 = this.f3715b;
        if (methodVisitor2 != null) {
            methodVisitor2.o(i, str, str2, str3);
        }
    }

    public abstract void p(int i, String str, String str2, String str3, boolean z2);

    public abstract void q(int i, int i2, Label2 label2, Label2... label2Arr);

    public abstract AnnotationWriter2 r(int i, TypePath2 typePath2, String str, boolean z2);

    public abstract void s(int i, String str);

    public abstract void t(int i, int i2);
}
