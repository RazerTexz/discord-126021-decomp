package i0.e0.a;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import g0.g;
import i0.h;
import java.io.IOException;
import java.io.Reader;
import java.nio.charset.Charset;
import okhttp3.MediaType;
import okhttp3.ResponseBody;
import okhttp3.ResponseBody$a;

/* JADX INFO: compiled from: GsonResponseBodyConverter.java */
/* JADX INFO: loaded from: classes3.dex */
public final class c<T> implements h<ResponseBody, T> {
    public final Gson a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TypeAdapter<T> f3738b;

    public c(Gson gson, TypeAdapter<T> typeAdapter) {
        this.a = gson;
        this.f3738b = typeAdapter;
    }

    @Override // i0.h
    public Object convert(ResponseBody responseBody) throws IOException {
        Charset charsetA;
        ResponseBody responseBody2 = responseBody;
        Gson gson = this.a;
        Reader responseBody$a = responseBody2.reader;
        if (responseBody$a == null) {
            g gVarC = responseBody2.c();
            MediaType mediaTypeB = responseBody2.b();
            if (mediaTypeB == null || (charsetA = mediaTypeB.a(d0.g0.c.a)) == null) {
                charsetA = d0.g0.c.a;
            }
            responseBody$a = new ResponseBody$a(gVarC, charsetA);
            responseBody2.reader = responseBody$a;
        }
        JsonReader jsonReaderK = gson.k(responseBody$a);
        try {
            T t = this.f3738b.read(jsonReaderK);
            if (jsonReaderK.N() != JsonToken.END_DOCUMENT) {
                throw new JsonIOException("JSON document was not fully consumed.");
            }
            responseBody2.close();
            return t;
        } catch (Throwable th) {
            responseBody2.close();
            throw th;
        }
    }
}
