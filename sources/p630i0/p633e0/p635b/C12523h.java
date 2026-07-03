package p630i0.p633e0.p635b;

import java.io.IOException;
import okhttp3.ResponseBody;
import p630i0.InterfaceC12554h;

/* JADX INFO: renamed from: i0.e0.b.h */
/* JADX INFO: compiled from: ScalarResponseBodyConverters.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C12523h implements InterfaceC12554h<ResponseBody, Long> {

    /* JADX INFO: renamed from: a */
    public static final C12523h f26525a = new C12523h();

    @Override // p630i0.InterfaceC12554h
    public Long convert(ResponseBody responseBody) throws IOException {
        return Long.valueOf(responseBody.m10998d());
    }
}
