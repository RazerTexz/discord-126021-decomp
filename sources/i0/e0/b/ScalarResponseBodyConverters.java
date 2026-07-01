package i0.e0.b;

import i0.Converter2;
import java.io.IOException;
import okhttp3.ResponseBody;

/* JADX INFO: renamed from: i0.e0.b.b, reason: use source file name */
/* JADX INFO: compiled from: ScalarResponseBodyConverters.java */
/* JADX INFO: loaded from: classes3.dex */
public final class ScalarResponseBodyConverters implements Converter2<ResponseBody, Boolean> {
    public static final ScalarResponseBodyConverters a = new ScalarResponseBodyConverters();

    @Override // i0.Converter2
    public Boolean convert(ResponseBody responseBody) throws IOException {
        return Boolean.valueOf(responseBody.d());
    }
}
