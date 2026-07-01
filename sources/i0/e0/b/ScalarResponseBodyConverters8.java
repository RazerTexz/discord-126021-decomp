package i0.e0.b;

import i0.Converter2;
import java.io.IOException;
import okhttp3.ResponseBody;

/* JADX INFO: renamed from: i0.e0.b.i, reason: use source file name */
/* JADX INFO: compiled from: ScalarResponseBodyConverters.java */
/* JADX INFO: loaded from: classes3.dex */
public final class ScalarResponseBodyConverters8 implements Converter2<ResponseBody, Short> {
    public static final ScalarResponseBodyConverters8 a = new ScalarResponseBodyConverters8();

    @Override // i0.Converter2
    public Short convert(ResponseBody responseBody) throws IOException {
        return Short.valueOf(responseBody.d());
    }
}
