package p007b.p225i.p226a.p288f.p313h.p322i;

import java.util.Queue;

/* JADX INFO: renamed from: b.i.a.f.h.i.b */
/* JADX INFO: compiled from: com.google.firebase:firebase-messaging@@21.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class C3488b {

    /* JADX INFO: renamed from: a */
    public static final /* synthetic */ int f9652a = 0;

    static {
        new C3487a();
    }

    /* JADX INFO: renamed from: a */
    public static byte[] m4412a(Queue<byte[]> queue, int i) {
        byte[] bArr = new byte[i];
        int i2 = i;
        while (i2 > 0) {
            byte[] bArrRemove = queue.remove();
            int iMin = Math.min(i2, bArrRemove.length);
            System.arraycopy(bArrRemove, 0, bArr, i - i2, iMin);
            i2 -= iMin;
        }
        return bArr;
    }
}
