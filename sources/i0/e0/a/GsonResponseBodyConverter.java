package i0.e0.a;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import d0.g0.Charsets2;
import g0.BufferedSource;
import i0.Converter2;
import java.io.IOException;
import java.io.Reader;
import java.nio.charset.Charset;
import okhttp3.MediaType;
import okhttp3.ResponseBody;

/* JADX INFO: renamed from: i0.e0.a.c, reason: use source file name */
/* JADX INFO: compiled from: GsonResponseBodyConverter.java */
/* JADX INFO: loaded from: classes3.dex */
public final class GsonResponseBodyConverter<T> implements Converter2<ResponseBody, T> {
    public final Gson a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TypeAdapter<T> f3738b;

    public GsonResponseBodyConverter(Gson gson, TypeAdapter<T> typeAdapter) {
        this.a = gson;
        this.f3738b = typeAdapter;
    }

    @Override // i0.Converter2
    public Object convert(ResponseBody responseBody) throws IOException {
        Charset charsetA;
        ResponseBody responseBody2 = responseBody;
        Gson gson = this.a;
        Reader aVar = responseBody2.reader;
        if (aVar == null) {
            BufferedSource bufferedSourceC = responseBody2.c();
            MediaType mediaTypeB = responseBody2.b();
            if (mediaTypeB == null || (charsetA = mediaTypeB.a(Charsets2.a)) == null) {
                charsetA = Charsets2.a;
            }
            aVar = new ResponseBody.a(bufferedSourceC, charsetA);
            responseBody2.reader = aVar;
        }
        JsonReader jsonReaderK = gson.k(aVar);
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
