package b.i.a.f.h.l;

import b.i.a.f.h.l.u4;
import com.adjust.sdk.Constants;
import com.google.android.gms.internal.measurement.zzij;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class w4 {
    public static final Charset a = Charset.forName(Constants.ENCODING);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final byte[] f1500b;

    static {
        Charset.forName("ISO-8859-1");
        byte[] bArr = new byte[0];
        f1500b = bArr;
        ByteBuffer.wrap(bArr);
        int length = bArr.length;
        int i = length + 0;
        try {
            if (length < 0) {
                throw zzij.b();
            }
            if (length + 0 > Integer.MAX_VALUE) {
                throw zzij.a();
            }
            int i2 = i + 0 + 0;
        } catch (zzij e) {
            throw new IllegalArgumentException(e);
        }
    }

    public static int a(long j) {
        return (int) (j ^ (j >>> 32));
    }

    public static int b(boolean z2) {
        return z2 ? 1231 : 1237;
    }

    public static Object c(Object obj, Object obj2) {
        c6 c6Var = (c6) obj2;
        n3 n3Var = (n3) ((c6) obj).f();
        Objects.requireNonNull(n3Var);
        u4.b bVar = (u4.b) n3Var;
        if (!bVar.j.getClass().isInstance(c6Var)) {
            throw new IllegalArgumentException("mergeFrom(MessageLite) can only merge messages of the same type.");
        }
        bVar.l((u4) ((l3) c6Var));
        return bVar.o();
    }
}
