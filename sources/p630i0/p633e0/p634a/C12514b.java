package p630i0.p633e0.p634a;

import com.adjust.sdk.Constants;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import p615g0.C12388e;
import p615g0.C12389f;
import p630i0.InterfaceC12554h;

/* JADX INFO: renamed from: i0.e0.a.b */
/* JADX INFO: compiled from: GsonRequestBodyConverter.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C12514b<T> implements InterfaceC12554h<T, RequestBody> {

    /* JADX INFO: renamed from: a */
    public static final MediaType f26511a;

    /* JADX INFO: renamed from: b */
    public static final Charset f26512b;

    /* JADX INFO: renamed from: c */
    public final Gson f26513c;

    /* JADX INFO: renamed from: d */
    public final TypeAdapter<T> f26514d;

    static {
        MediaType.Companion companion = MediaType.INSTANCE;
        f26511a = MediaType.Companion.m10967a("application/json; charset=UTF-8");
        f26512b = Charset.forName(Constants.ENCODING);
    }

    public C12514b(Gson gson, TypeAdapter<T> typeAdapter) {
        this.f26513c = gson;
        this.f26514d = typeAdapter;
    }

    @Override // p630i0.InterfaceC12554h
    public RequestBody convert(Object obj) throws IOException {
        C12388e c12388e = new C12388e();
        JsonWriter jsonWriterM9208l = this.f26513c.m9208l(new OutputStreamWriter(new C12389f(c12388e), f26512b));
        this.f26514d.write(jsonWriterM9208l, obj);
        jsonWriterM9208l.close();
        return RequestBody.create(f26511a, c12388e.m10473x());
    }
}
