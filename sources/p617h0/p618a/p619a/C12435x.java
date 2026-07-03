package p617h0.p618a.p619a;

/* JADX INFO: renamed from: h0.a.a.x */
/* JADX INFO: compiled from: TypePath.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C12435x {

    /* JADX INFO: renamed from: a */
    public final byte[] f26374a;

    /* JADX INFO: renamed from: b */
    public final int f26375b;

    public C12435x(byte[] bArr, int i) {
        this.f26374a = bArr;
        this.f26375b = i;
    }

    /* JADX INFO: renamed from: a */
    public static void m10655a(C12435x c12435x, C12414c c12414c) {
        if (c12435x == null) {
            c12414c.m10535g(0);
            return;
        }
        byte[] bArr = c12435x.f26374a;
        int i = c12435x.f26375b;
        c12414c.m10536h(bArr, i, (bArr[i] * 2) + 1);
    }

    public String toString() {
        byte b2 = this.f26374a[this.f26375b];
        StringBuilder sb = new StringBuilder(b2 * 2);
        for (int i = 0; i < b2; i++) {
            byte[] bArr = this.f26374a;
            int i2 = this.f26375b;
            int i3 = i * 2;
            byte b3 = bArr[i3 + i2 + 1];
            if (b3 == 0) {
                sb.append('[');
            } else if (b3 == 1) {
                sb.append('.');
            } else if (b3 == 2) {
                sb.append('*');
            } else {
                if (b3 != 3) {
                    throw new AssertionError();
                }
                sb.append((int) bArr[i3 + i2 + 2]);
                sb.append(';');
            }
        }
        return sb.toString();
    }
}
