package i0.e0.b;

import java.io.IOException;
import okhttp3.ResponseBody;

/* JADX INFO: compiled from: ScalarResponseBodyConverters.java */
/* JADX INFO: loaded from: classes3.dex */
public final class d implements i0.h<ResponseBody, Character> {
    public static final d a = new d();

    @Override // i0.h
    public Character convert(ResponseBody responseBody) throws IOException {
        String strD = responseBody.d();
        if (strD.length() == 1) {
            return Character.valueOf(strD.charAt(0));
        }
        StringBuilder sbU = b.d.b.a.a.U("Expected body of length 1 for Character conversion but was ");
        sbU.append(strD.length());
        throw new IOException(sbU.toString());
    }
}
