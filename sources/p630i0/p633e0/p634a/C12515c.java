package p630i0.p633e0.p634a;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import java.io.IOException;
import java.io.Reader;
import java.nio.charset.Charset;
import okhttp3.MediaType;
import okhttp3.ResponseBody;
import p507d0.p579g0.C12086c;
import p615g0.InterfaceC12390g;
import p630i0.InterfaceC12554h;

/* JADX INFO: renamed from: i0.e0.a.c */
/* JADX INFO: compiled from: GsonResponseBodyConverter.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C12515c<T> implements InterfaceC12554h<ResponseBody, T> {

    /* JADX INFO: renamed from: a */
    public final Gson f26515a;

    /* JADX INFO: renamed from: b */
    public final TypeAdapter<T> f26516b;

    public C12515c(Gson gson, TypeAdapter<T> typeAdapter) {
        this.f26515a = gson;
        this.f26516b = typeAdapter;
    }

    @Override // p630i0.InterfaceC12554h
    public Object convert(ResponseBody responseBody) throws IOException {
        Charset charsetM10966a;
        ResponseBody responseBody2 = responseBody;
        Gson gson = this.f26515a;
        Reader c12938a = responseBody2.reader;
        if (c12938a == null) {
            InterfaceC12390g interfaceC12390gMo10105c = responseBody2.mo10105c();
            MediaType mediaTypeMo10104b = responseBody2.mo10104b();
            if (mediaTypeMo10104b == null || (charsetM10966a = mediaTypeMo10104b.m10966a(C12086c.f25136a)) == null) {
                charsetM10966a = C12086c.f25136a;
            }
            c12938a = new ResponseBody.C12938a(interfaceC12390gMo10105c, charsetM10966a);
            responseBody2.reader = c12938a;
        }
        JsonReader jsonReaderM9207k = gson.m9207k(c12938a);
        try {
            T t = this.f26516b.read(jsonReaderM9207k);
            if (jsonReaderM9207k.mo6878N() != JsonToken.END_DOCUMENT) {
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
