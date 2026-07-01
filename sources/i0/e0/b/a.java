package i0.e0.b;

import java.io.IOException;
import okhttp3.MediaType;
import okhttp3.MediaType$a;
import okhttp3.RequestBody;

/* JADX INFO: compiled from: ScalarRequestBodyConverter.java */
/* JADX INFO: loaded from: classes3.dex */
public final class a<T> implements i0.h<T, RequestBody> {
    public static final a<Object> a = new a<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final MediaType f3739b;

    static {
        MediaType$a mediaType$a = MediaType.c;
        f3739b = MediaType$a.a("text/plain; charset=UTF-8");
    }

    @Override // i0.h
    public RequestBody convert(Object obj) throws IOException {
        return RequestBody.create(f3739b, String.valueOf(obj));
    }
}
