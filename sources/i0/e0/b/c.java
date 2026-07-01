package i0.e0.b;

import java.io.IOException;
import okhttp3.ResponseBody;

/* JADX INFO: compiled from: ScalarResponseBodyConverters.java */
/* JADX INFO: loaded from: classes3.dex */
public final class c implements i0.h<ResponseBody, Byte> {
    public static final c a = new c();

    @Override // i0.h
    public Byte convert(ResponseBody responseBody) throws IOException {
        return Byte.valueOf(responseBody.d());
    }
}
