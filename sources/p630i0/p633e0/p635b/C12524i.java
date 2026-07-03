package p630i0.p633e0.p635b;

import java.io.IOException;
import okhttp3.ResponseBody;
import p630i0.InterfaceC12554h;

/* JADX INFO: renamed from: i0.e0.b.i */
/* JADX INFO: compiled from: ScalarResponseBodyConverters.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C12524i implements InterfaceC12554h<ResponseBody, Short> {

    /* JADX INFO: renamed from: a */
    public static final C12524i f26526a = new C12524i();

    @Override // p630i0.InterfaceC12554h
    public Short convert(ResponseBody responseBody) throws IOException {
        return Short.valueOf(responseBody.m10998d());
    }
}
