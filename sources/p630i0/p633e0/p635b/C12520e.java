package p630i0.p633e0.p635b;

import java.io.IOException;
import okhttp3.ResponseBody;
import p630i0.InterfaceC12554h;

/* JADX INFO: renamed from: i0.e0.b.e */
/* JADX INFO: compiled from: ScalarResponseBodyConverters.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C12520e implements InterfaceC12554h<ResponseBody, Double> {

    /* JADX INFO: renamed from: a */
    public static final C12520e f26522a = new C12520e();

    @Override // p630i0.InterfaceC12554h
    public Double convert(ResponseBody responseBody) throws IOException {
        return Double.valueOf(responseBody.m10998d());
    }
}
