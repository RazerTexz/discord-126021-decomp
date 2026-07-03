package p007b.p225i.p226a.p288f.p313h.p325l;

import com.adjust.sdk.Constants;
import com.google.android.gms.internal.measurement.zzij;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Objects;
import p007b.p225i.p226a.p288f.p313h.p325l.AbstractC3851u4;

/* JADX INFO: renamed from: b.i.a.f.h.l.w4 */
/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class C3877w4 {

    /* JADX INFO: renamed from: a */
    public static final Charset f10379a = Charset.forName(Constants.ENCODING);

    /* JADX INFO: renamed from: b */
    public static final byte[] f10380b;

    static {
        Charset.forName("ISO-8859-1");
        byte[] bArr = new byte[0];
        f10380b = bArr;
        ByteBuffer.wrap(bArr);
        int length = bArr.length;
        int i = length + 0;
        try {
            if (length < 0) {
                throw zzij.m9104b();
            }
            if (length + 0 > Integer.MAX_VALUE) {
                throw zzij.m9103a();
            }
            int i2 = i + 0 + 0;
        } catch (zzij e) {
            throw new IllegalArgumentException(e);
        }
    }

    /* JADX INFO: renamed from: a */
    public static int m5344a(long j) {
        return (int) (j ^ (j >>> 32));
    }

    /* JADX INFO: renamed from: b */
    public static int m5345b(boolean z2) {
        return z2 ? 1231 : 1237;
    }

    /* JADX INFO: renamed from: c */
    public static Object m5346c(Object obj, Object obj2) {
        InterfaceC3612c6 interfaceC3612c6 = (InterfaceC3612c6) obj2;
        AbstractC3759n3 abstractC3759n3 = (AbstractC3759n3) ((InterfaceC3612c6) obj).mo4605f();
        Objects.requireNonNull(abstractC3759n3);
        AbstractC3851u4.b bVar = (AbstractC3851u4.b) abstractC3759n3;
        if (!bVar.f10346j.getClass().isInstance(interfaceC3612c6)) {
            throw new IllegalArgumentException("mergeFrom(MessageLite) can only merge messages of the same type.");
        }
        bVar.m5316l((AbstractC3851u4) ((AbstractC3733l3) interfaceC3612c6));
        return bVar.m5319o();
    }
}
