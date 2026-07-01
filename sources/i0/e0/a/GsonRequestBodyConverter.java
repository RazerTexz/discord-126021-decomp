package i0.e0.a;

import com.adjust.sdk.Constants;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonWriter;
import g0.Buffer3;
import g0.Buffer4;
import i0.Converter2;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import okhttp3.MediaType;
import okhttp3.RequestBody;

/* JADX INFO: renamed from: i0.e0.a.b, reason: use source file name */
/* JADX INFO: compiled from: GsonRequestBodyConverter.java */
/* JADX INFO: loaded from: classes3.dex */
public final class GsonRequestBodyConverter<T> implements Converter2<T, RequestBody> {
    public static final MediaType a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Charset f3737b;
    public final Gson c;
    public final TypeAdapter<T> d;

    static {
        MediaType.Companion companion = MediaType.INSTANCE;
        a = MediaType.Companion.a("application/json; charset=UTF-8");
        f3737b = Charset.forName(Constants.ENCODING);
    }

    public GsonRequestBodyConverter(Gson gson, TypeAdapter<T> typeAdapter) {
        this.c = gson;
        this.d = typeAdapter;
    }

    @Override // i0.Converter2
    public RequestBody convert(Object obj) throws IOException {
        Buffer3 buffer3 = new Buffer3();
        JsonWriter jsonWriterL = this.c.l(new OutputStreamWriter(new Buffer4(buffer3), f3737b));
        this.d.write(jsonWriterL, obj);
        jsonWriterL.close();
        return RequestBody.create(a, buffer3.x());
    }
}
