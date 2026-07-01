package i0;

import java.io.IOException;
import okhttp3.ResponseBody;

/* JADX INFO: compiled from: BuiltInConverters.java */
/* JADX INFO: loaded from: classes3.dex */
public final class c$a implements h<ResponseBody, ResponseBody> {
    public static final c$a a = new c$a();

    @Override // i0.h
    public ResponseBody convert(ResponseBody responseBody) throws IOException {
        ResponseBody responseBody2 = responseBody;
        try {
            return c0.a(responseBody2);
        } finally {
            responseBody2.close();
        }
    }
}
