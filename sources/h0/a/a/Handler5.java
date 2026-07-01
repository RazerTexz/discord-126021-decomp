package h0.a.a;

/* JADX INFO: renamed from: h0.a.a.o, reason: use source file name */
/* JADX INFO: compiled from: Handler.java */
/* JADX INFO: loaded from: classes3.dex */
public final class Handler5 {
    public final Label2 a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Label2 f3713b;
    public final Label2 c;
    public final int d;
    public final String e;
    public Handler5 f;

    public Handler5(Label2 label2, Label2 label3, Label2 label4, int i, String str) {
        this.a = label2;
        this.f3713b = label3;
        this.c = label4;
        this.d = i;
        this.e = str;
    }

    public static Handler5 a(Handler5 handler5, Label2 label2, Label2 label3) {
        if (handler5 == null) {
            return null;
        }
        Handler5 handler5A = a(handler5.f, label2, label3);
        handler5.f = handler5A;
        Label2 label4 = handler5.a;
        int i = label4.e;
        Label2 label5 = handler5.f3713b;
        int i2 = label5.e;
        int i3 = label2.e;
        int i4 = label3 == null ? Integer.MAX_VALUE : label3.e;
        if (i3 >= i2 || i4 <= i) {
            return handler5;
        }
        if (i3 <= i) {
            return i4 >= i2 ? handler5A : new Handler5(handler5, label3, label5);
        }
        if (i4 >= i2) {
            return new Handler5(handler5, label4, label2);
        }
        handler5.f = new Handler5(handler5, label3, label5);
        return new Handler5(handler5, handler5.a, label2);
    }

    public Handler5(Handler5 handler5, Label2 label2, Label2 label3) {
        Label2 label4 = handler5.c;
        int i = handler5.d;
        String str = handler5.e;
        this.a = label2;
        this.f3713b = label3;
        this.c = label4;
        this.d = i;
        this.e = str;
        this.f = handler5.f;
    }
}
