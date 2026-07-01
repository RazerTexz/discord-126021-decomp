package i0.e0.b;

import i0.Converter2;
import java.io.IOException;
import okhttp3.ResponseBody;

/* JADX INFO: renamed from: i0.e0.b.f, reason: use source file name */
/* JADX INFO: compiled from: ScalarResponseBodyConverters.java */
/* JADX INFO: loaded from: classes3.dex */
public final class ScalarResponseBodyConverters5 implements Converter2<ResponseBody, Float> {
    public static final ScalarResponseBodyConverters5 a = new ScalarResponseBodyConverters5();

    @Override // i0.Converter2
    public Float convert(ResponseBody responseBody) throws IOException {
        return Float.valueOf(responseBody.d());
    }
}
