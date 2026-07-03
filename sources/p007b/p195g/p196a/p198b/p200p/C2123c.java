package p007b.p195g.p196a.p198b.p200p;

import p007b.p195g.p196a.p198b.p204t.C2139a;

/* JADX INFO: renamed from: b.g.a.b.p.c */
/* JADX INFO: compiled from: IOContext.java */
/* JADX INFO: loaded from: classes3.dex */
public class C2123c {

    /* JADX INFO: renamed from: a */
    public final Object f4545a;

    /* JADX INFO: renamed from: b */
    public final boolean f4546b;

    /* JADX INFO: renamed from: c */
    public final C2139a f4547c;

    /* JADX INFO: renamed from: d */
    public byte[] f4548d;

    /* JADX INFO: renamed from: e */
    public char[] f4549e;

    public C2123c(C2139a c2139a, Object obj, boolean z2) {
        this.f4547c = c2139a;
        this.f4545a = obj;
        this.f4546b = z2;
    }

    /* JADX INFO: renamed from: a */
    public void m1695a(byte[] bArr) {
        byte[] bArr2 = this.f4548d;
        if (bArr != bArr2 && bArr.length < bArr2.length) {
            throw new IllegalArgumentException("Trying to release buffer smaller than original");
        }
        this.f4548d = null;
        this.f4547c.f4593c.set(3, bArr);
    }
}
