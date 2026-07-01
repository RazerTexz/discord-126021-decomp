package i0.e0.b;

import java.io.IOException;
import okhttp3.ResponseBody;

/* JADX INFO: compiled from: ScalarResponseBodyConverters.java */
/* JADX INFO: loaded from: classes3.dex */
public final class b implements i0.h<ResponseBody, Boolean> {
    public static final b a = new b();

    @Override // i0.h
    public Boolean convert(ResponseBody responseBody) throws IOException {
        return Boolean.valueOf(responseBody.d());
    }
}
