package i0.e0.b;

import java.io.IOException;
import okhttp3.ResponseBody;

/* JADX INFO: compiled from: ScalarResponseBodyConverters.java */
/* JADX INFO: loaded from: classes3.dex */
public final class i implements i0.h<ResponseBody, Short> {
    public static final i a = new i();

    @Override // i0.h
    public Short convert(ResponseBody responseBody) throws IOException {
        return Short.valueOf(responseBody.d());
    }
}
