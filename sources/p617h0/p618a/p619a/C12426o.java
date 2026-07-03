package p617h0.p618a.p619a;

/* JADX INFO: renamed from: h0.a.a.o */
/* JADX INFO: compiled from: Handler.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C12426o {

    /* JADX INFO: renamed from: a */
    public final C12427p f26242a;

    /* JADX INFO: renamed from: b */
    public final C12427p f26243b;

    /* JADX INFO: renamed from: c */
    public final C12427p f26244c;

    /* JADX INFO: renamed from: d */
    public final int f26245d;

    /* JADX INFO: renamed from: e */
    public final String f26246e;

    /* JADX INFO: renamed from: f */
    public C12426o f26247f;

    public C12426o(C12427p c12427p, C12427p c12427p2, C12427p c12427p3, int i, String str) {
        this.f26242a = c12427p;
        this.f26243b = c12427p2;
        this.f26244c = c12427p3;
        this.f26245d = i;
        this.f26246e = str;
    }

    /* JADX INFO: renamed from: a */
    public static C12426o m10586a(C12426o c12426o, C12427p c12427p, C12427p c12427p2) {
        if (c12426o == null) {
            return null;
        }
        C12426o c12426oM10586a = m10586a(c12426o.f26247f, c12427p, c12427p2);
        c12426o.f26247f = c12426oM10586a;
        C12427p c12427p3 = c12426o.f26242a;
        int i = c12427p3.f26252e;
        C12427p c12427p4 = c12426o.f26243b;
        int i2 = c12427p4.f26252e;
        int i3 = c12427p.f26252e;
        int i4 = c12427p2 == null ? Integer.MAX_VALUE : c12427p2.f26252e;
        if (i3 >= i2 || i4 <= i) {
            return c12426o;
        }
        if (i3 <= i) {
            return i4 >= i2 ? c12426oM10586a : new C12426o(c12426o, c12427p2, c12427p4);
        }
        if (i4 >= i2) {
            return new C12426o(c12426o, c12427p3, c12427p);
        }
        c12426o.f26247f = new C12426o(c12426o, c12427p2, c12427p4);
        return new C12426o(c12426o, c12426o.f26242a, c12427p);
    }

    public C12426o(C12426o c12426o, C12427p c12427p, C12427p c12427p2) {
        C12427p c12427p3 = c12426o.f26244c;
        int i = c12426o.f26245d;
        String str = c12426o.f26246e;
        this.f26242a = c12427p;
        this.f26243b = c12427p2;
        this.f26244c = c12427p3;
        this.f26245d = i;
        this.f26246e = str;
        this.f26247f = c12426o.f26247f;
    }
}
