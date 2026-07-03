package p617h0.p618a.p619a;

import p007b.p100d.p104b.p105a.C1643a;

/* JADX INFO: renamed from: h0.a.a.b */
/* JADX INFO: compiled from: Attribute.java */
/* JADX INFO: loaded from: classes3.dex */
public class C12413b {

    /* JADX INFO: renamed from: a */
    public final String f26148a;

    /* JADX INFO: renamed from: b */
    public byte[] f26149b;

    /* JADX INFO: renamed from: c */
    public C12413b f26150c;

    /* JADX INFO: renamed from: h0.a.a.b$a */
    /* JADX INFO: compiled from: Attribute.java */
    public static final class a {

        /* JADX INFO: renamed from: a */
        public int f26151a;

        /* JADX INFO: renamed from: b */
        public C12413b[] f26152b = new C12413b[6];

        /* JADX INFO: renamed from: a */
        public void m10528a(C12413b c12413b) {
            boolean z2;
            while (c12413b != null) {
                int i = 0;
                while (true) {
                    if (i >= this.f26151a) {
                        z2 = false;
                        break;
                    } else {
                        if (this.f26152b[i].f26148a.equals(c12413b.f26148a)) {
                            z2 = true;
                            break;
                        }
                        i++;
                    }
                }
                if (!z2) {
                    int i2 = this.f26151a;
                    C12413b[] c12413bArr = this.f26152b;
                    if (i2 >= c12413bArr.length) {
                        C12413b[] c12413bArr2 = new C12413b[c12413bArr.length + 6];
                        System.arraycopy(c12413bArr, 0, c12413bArr2, 0, i2);
                        this.f26152b = c12413bArr2;
                    }
                    C12413b[] c12413bArr3 = this.f26152b;
                    int i3 = this.f26151a;
                    this.f26151a = i3 + 1;
                    c12413bArr3[i3] = c12413b;
                }
                c12413b = c12413b.f26150c;
            }
        }
    }

    public C12413b(String str) {
        this.f26148a = str;
    }

    /* JADX INFO: renamed from: a */
    public final int m10523a(C12433v c12433v) {
        return m10524b(c12433v, null, 0, -1, -1);
    }

    /* JADX INFO: renamed from: b */
    public final int m10524b(C12433v c12433v, byte[] bArr, int i, int i2, int i3) {
        C12417f c12417f = c12433v.f26347a;
        int length = 0;
        for (C12413b c12413b = this; c12413b != null; c12413b = c12413b.f26150c) {
            c12433v.m10637l(c12413b.f26148a);
            length += c12413b.f26149b.length + 6;
        }
        return length;
    }

    /* JADX INFO: renamed from: c */
    public final int m10525c() {
        int i = 0;
        for (C12413b c12413b = this; c12413b != null; c12413b = c12413b.f26150c) {
            i++;
        }
        return i;
    }

    /* JADX INFO: renamed from: d */
    public final void m10526d(C12433v c12433v, C12414c c12414c) {
        m10527e(c12433v, null, 0, -1, -1, c12414c);
    }

    /* JADX INFO: renamed from: e */
    public final void m10527e(C12433v c12433v, byte[] bArr, int i, int i2, int i3, C12414c c12414c) {
        C12417f c12417f = c12433v.f26347a;
        for (C12413b c12413b = this; c12413b != null; c12413b = c12413b.f26150c) {
            byte[] bArr2 = c12413b.f26149b;
            int length = bArr2.length;
            C1643a.m878t0(c12433v, c12413b.f26148a, c12414c, length);
            c12414c.m10536h(bArr2, 0, length);
        }
    }
}
