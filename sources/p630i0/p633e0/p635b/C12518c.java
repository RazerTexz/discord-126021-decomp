package p630i0.p633e0.p635b;

import java.io.IOException;
import okhttp3.ResponseBody;
import p630i0.InterfaceC12554h;

/* JADX INFO: renamed from: i0.e0.b.c */
/* JADX INFO: compiled from: ScalarResponseBodyConverters.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C12518c implements InterfaceC12554h<ResponseBody, Byte> {

    /* JADX INFO: renamed from: a */
    public static final C12518c f26520a = new C12518c();

    @Override // p630i0.InterfaceC12554h
    public Byte convert(ResponseBody responseBody) throws IOException {
        return Byte.valueOf(responseBody.m10998d());
    }
}
