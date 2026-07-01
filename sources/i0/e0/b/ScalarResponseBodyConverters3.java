package i0.e0.b;

import b.d.b.a.outline;
import i0.Converter2;
import java.io.IOException;
import okhttp3.ResponseBody;

/* JADX INFO: renamed from: i0.e0.b.d, reason: use source file name */
/* JADX INFO: compiled from: ScalarResponseBodyConverters.java */
/* JADX INFO: loaded from: classes3.dex */
public final class ScalarResponseBodyConverters3 implements Converter2<ResponseBody, Character> {
    public static final ScalarResponseBodyConverters3 a = new ScalarResponseBodyConverters3();

    @Override // i0.Converter2
    public Character convert(ResponseBody responseBody) throws IOException {
        String strD = responseBody.d();
        if (strD.length() == 1) {
            return Character.valueOf(strD.charAt(0));
        }
        StringBuilder sbU = outline.U("Expected body of length 1 for Character conversion but was ");
        sbU.append(strD.length());
        throw new IOException(sbU.toString());
    }
}
