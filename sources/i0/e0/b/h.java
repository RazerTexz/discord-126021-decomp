package i0.e0.b;

import java.io.IOException;
import okhttp3.ResponseBody;

/* JADX INFO: compiled from: ScalarResponseBodyConverters.java */
/* JADX INFO: loaded from: classes3.dex */
public final class h implements i0.h<ResponseBody, Long> {
    public static final h a = new h();

    @Override // i0.h
    public Long convert(ResponseBody responseBody) throws IOException {
        return Long.valueOf(responseBody.d());
    }
}
