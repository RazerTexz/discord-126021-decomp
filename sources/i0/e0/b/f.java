package i0.e0.b;

import java.io.IOException;
import okhttp3.ResponseBody;

/* JADX INFO: compiled from: ScalarResponseBodyConverters.java */
/* JADX INFO: loaded from: classes3.dex */
public final class f implements i0.h<ResponseBody, Float> {
    public static final f a = new f();

    @Override // i0.h
    public Float convert(ResponseBody responseBody) throws IOException {
        return Float.valueOf(responseBody.d());
    }
}
