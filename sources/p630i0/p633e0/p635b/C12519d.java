package p630i0.p633e0.p635b;

import java.io.IOException;
import okhttp3.ResponseBody;
import p007b.p100d.p104b.p105a.C1643a;
import p630i0.InterfaceC12554h;

/* JADX INFO: renamed from: i0.e0.b.d */
/* JADX INFO: compiled from: ScalarResponseBodyConverters.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C12519d implements InterfaceC12554h<ResponseBody, Character> {

    /* JADX INFO: renamed from: a */
    public static final C12519d f26521a = new C12519d();

    @Override // p630i0.InterfaceC12554h
    public Character convert(ResponseBody responseBody) throws IOException {
        String strM10998d = responseBody.m10998d();
        if (strM10998d.length() == 1) {
            return Character.valueOf(strM10998d.charAt(0));
        }
        StringBuilder sbM833U = C1643a.m833U("Expected body of length 1 for Character conversion but was ");
        sbM833U.append(strM10998d.length());
        throw new IOException(sbM833U.toString());
    }
}
