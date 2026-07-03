package p630i0.p633e0.p635b;

import java.io.IOException;
import okhttp3.ResponseBody;
import p630i0.InterfaceC12554h;

/* JADX INFO: renamed from: i0.e0.b.f */
/* JADX INFO: compiled from: ScalarResponseBodyConverters.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C12521f implements InterfaceC12554h<ResponseBody, Float> {

    /* JADX INFO: renamed from: a */
    public static final C12521f f26523a = new C12521f();

    @Override // p630i0.InterfaceC12554h
    public Float convert(ResponseBody responseBody) throws IOException {
        return Float.valueOf(responseBody.m10998d());
    }
}
