package h0.a.a;

/* JADX INFO: compiled from: TypePath.java */
/* JADX INFO: loaded from: classes3.dex */
public final class x {
    public final byte[] a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f3727b;

    public x(byte[] bArr, int i) {
        this.a = bArr;
        this.f3727b = i;
    }

    public static void a(x xVar, c cVar) {
        if (xVar == null) {
            cVar.g(0);
            return;
        }
        byte[] bArr = xVar.a;
        int i = xVar.f3727b;
        cVar.h(bArr, i, (bArr[i] * 2) + 1);
    }

    public String toString() {
        byte b2 = this.a[this.f3727b];
        StringBuilder sb = new StringBuilder(b2 * 2);
        for (int i = 0; i < b2; i++) {
            byte[] bArr = this.a;
            int i2 = this.f3727b;
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
