package i0.e0.b;

import java.io.IOException;
import okhttp3.ResponseBody;

/* JADX INFO: compiled from: ScalarResponseBodyConverters.java */
/* JADX INFO: loaded from: classes3.dex */
public final class j implements i0.h<ResponseBody, String> {
    public static final j a = new j();

    @Override // i0.h
    public String convert(ResponseBody responseBody) throws IOException {
        return responseBody.d();
    }
}
