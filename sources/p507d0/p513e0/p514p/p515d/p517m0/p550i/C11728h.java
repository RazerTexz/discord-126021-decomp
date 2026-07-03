package p507d0.p513e0.p514p.p515d.p517m0.p550i;

import com.adjust.sdk.Constants;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;

/* JADX INFO: renamed from: d0.e0.p.d.m0.i.h */
/* JADX INFO: compiled from: Internal.java */
/* JADX INFO: loaded from: classes3.dex */
public class C11728h {

    /* JADX INFO: renamed from: a */
    public static final byte[] f24142a;

    /* JADX INFO: renamed from: d0.e0.p.d.m0.i.h$a */
    /* JADX INFO: compiled from: Internal.java */
    public interface a {
        int getNumber();
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.i.h$b */
    /* JADX INFO: compiled from: Internal.java */
    public interface b<T extends a> {
        T findValueByNumber(int i);
    }

    static {
        byte[] bArr = new byte[0];
        f24142a = bArr;
        ByteBuffer.wrap(bArr);
    }

    public static boolean isValidUtf8(byte[] bArr) {
        return C11742v.isValidUtf8(bArr);
    }

    public static String toStringUtf8(byte[] bArr) {
        try {
            return new String(bArr, Constants.ENCODING);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("UTF-8 not supported?", e);
        }
    }
}
