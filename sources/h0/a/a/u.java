package h0.a.a;

/* JADX INFO: compiled from: Symbol.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class u {
    public final int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f3724b;
    public final String c;
    public final String d;
    public final String e;
    public final long f;
    public int g;

    public u(int i, int i2, String str, String str2, String str3, long j) {
        this.a = i;
        this.f3724b = i2;
        this.c = str;
        this.d = str2;
        this.e = str3;
        this.f = j;
    }

    public int a() {
        if (this.g == 0) {
            this.g = w.b(this.e);
        }
        return this.g;
    }
}
