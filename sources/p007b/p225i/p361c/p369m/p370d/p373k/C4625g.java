package p007b.p225i.p361c.p369m.p370d.p373k;

import android.os.Process;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: renamed from: b.i.c.m.d.k.g */
/* JADX INFO: compiled from: CLSUUID.java */
/* JADX INFO: loaded from: classes3.dex */
public class C4625g {

    /* JADX INFO: renamed from: a */
    public static final AtomicLong f12292a = new AtomicLong(0);

    /* JADX INFO: renamed from: b */
    public static String f12293b;

    public C4625g(C4660v0 c4660v0) {
        long time = new Date().getTime();
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(4);
        byteBufferAllocate.putInt((int) (time / 1000));
        byteBufferAllocate.order(ByteOrder.BIG_ENDIAN);
        byteBufferAllocate.position(0);
        byte[] bArrArray = byteBufferAllocate.array();
        byte[] bArrM6406a = m6406a(time % 1000);
        byte[] bArrM6406a2 = m6406a(f12292a.incrementAndGet());
        byte[] bArrM6406a3 = m6406a(Integer.valueOf(Process.myPid()).shortValue());
        byte[] bArr = {bArrArray[0], bArrArray[1], bArrArray[2], bArrArray[3], bArrM6406a[0], bArrM6406a[1], bArrM6406a2[0], bArrM6406a2[1], bArrM6406a3[0], bArrM6406a3[1]};
        String strM6429w = C4628h.m6429w(c4660v0.m6456b());
        String strM6423q = C4628h.m6423q(bArr);
        Locale locale = Locale.US;
        f12293b = String.format(locale, "%s-%s-%s-%s", strM6423q.substring(0, 12), strM6423q.substring(12, 16), strM6423q.subSequence(16, 20), strM6429w.substring(0, 12)).toUpperCase(locale);
    }

    /* JADX INFO: renamed from: a */
    public static byte[] m6406a(long j) {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(2);
        byteBufferAllocate.putShort((short) j);
        byteBufferAllocate.order(ByteOrder.BIG_ENDIAN);
        byteBufferAllocate.position(0);
        return byteBufferAllocate.array();
    }

    public String toString() {
        return f12293b;
    }
}
