package i0;

import java.io.IOException;
import kotlin.Unit;
import okhttp3.ResponseBody;

/* JADX INFO: compiled from: BuiltInConverters.java */
/* JADX INFO: loaded from: classes3.dex */
public final class c$e implements h<ResponseBody, Unit> {
    public static final c$e a = new c$e();

    @Override // i0.h
    public Unit convert(ResponseBody responseBody) throws IOException {
        responseBody.close();
        return Unit.a;
    }
}
