package p630i0.p633e0.p635b;

import java.io.IOException;
import okhttp3.ResponseBody;
import p630i0.InterfaceC12554h;

/* JADX INFO: renamed from: i0.e0.b.b */
/* JADX INFO: compiled from: ScalarResponseBodyConverters.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C12517b implements InterfaceC12554h<ResponseBody, Boolean> {

    /* JADX INFO: renamed from: a */
    public static final C12517b f26519a = new C12517b();

    @Override // p630i0.InterfaceC12554h
    public Boolean convert(ResponseBody responseBody) throws IOException {
        return Boolean.valueOf(responseBody.m10998d());
    }
}
