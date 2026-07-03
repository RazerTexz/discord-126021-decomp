package p630i0.p633e0.p635b;

import java.io.IOException;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import p630i0.InterfaceC12554h;

/* JADX INFO: renamed from: i0.e0.b.a */
/* JADX INFO: compiled from: ScalarRequestBodyConverter.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C12516a<T> implements InterfaceC12554h<T, RequestBody> {

    /* JADX INFO: renamed from: a */
    public static final C12516a<Object> f26517a = new C12516a<>();

    /* JADX INFO: renamed from: b */
    public static final MediaType f26518b;

    static {
        MediaType.Companion companion = MediaType.INSTANCE;
        f26518b = MediaType.Companion.m10967a("text/plain; charset=UTF-8");
    }

    @Override // p630i0.InterfaceC12554h
    public RequestBody convert(Object obj) throws IOException {
        return RequestBody.create(f26518b, String.valueOf(obj));
    }
}
