package p630i0.p633e0.p635b;

import java.io.IOException;
import okhttp3.ResponseBody;
import p630i0.InterfaceC12554h;

/* JADX INFO: renamed from: i0.e0.b.g */
/* JADX INFO: compiled from: ScalarResponseBodyConverters.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C12522g implements InterfaceC12554h<ResponseBody, Integer> {

    /* JADX INFO: renamed from: a */
    public static final C12522g f26524a = new C12522g();

    @Override // p630i0.InterfaceC12554h
    public Integer convert(ResponseBody responseBody) throws IOException {
        return Integer.valueOf(responseBody.m10998d());
    }
}
