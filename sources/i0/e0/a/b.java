package i0.e0.a;

import com.adjust.sdk.Constants;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonWriter;
import g0.e;
import g0.f;
import i0.h;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import okhttp3.MediaType;
import okhttp3.MediaType$a;
import okhttp3.RequestBody;

/* JADX INFO: compiled from: GsonRequestBodyConverter.java */
/* JADX INFO: loaded from: classes3.dex */
public final class b<T> implements h<T, RequestBody> {
    public static final MediaType a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Charset f3737b;
    public final Gson c;
    public final TypeAdapter<T> d;

    static {
        MediaType$a mediaType$a = MediaType.c;
        a = MediaType$a.a("application/json; charset=UTF-8");
        f3737b = Charset.forName(Constants.ENCODING);
    }

    public b(Gson gson, TypeAdapter<T> typeAdapter) {
        this.c = gson;
        this.d = typeAdapter;
    }

    @Override // i0.h
    public RequestBody convert(Object obj) throws IOException {
        e eVar = new e();
        JsonWriter jsonWriterL = this.c.l(new OutputStreamWriter(new f(eVar), f3737b));
        this.d.write(jsonWriterL, obj);
        jsonWriterL.close();
        return RequestBody.create(a, eVar.x());
    }
}
