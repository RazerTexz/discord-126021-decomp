package i0;

import java.io.IOException;
import okhttp3.ResponseBody;

/* JADX INFO: compiled from: BuiltInConverters.java */
/* JADX INFO: loaded from: classes3.dex */
public final class c$f implements h<ResponseBody, Void> {
    public static final c$f a = new c$f();

    @Override // i0.h
    public Void convert(ResponseBody responseBody) throws IOException {
        responseBody.close();
        return null;
    }
}
