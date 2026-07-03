package p630i0.p633e0.p635b;

import java.io.IOException;
import okhttp3.ResponseBody;
import p630i0.InterfaceC12554h;

/* JADX INFO: renamed from: i0.e0.b.j */
/* JADX INFO: compiled from: ScalarResponseBodyConverters.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C12525j implements InterfaceC12554h<ResponseBody, String> {

    /* JADX INFO: renamed from: a */
    public static final C12525j f26527a = new C12525j();

    @Override // p630i0.InterfaceC12554h
    public String convert(ResponseBody responseBody) throws IOException {
        return responseBody.m10998d();
    }
}
