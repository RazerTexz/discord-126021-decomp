package p630i0.p633e0.p634a;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import p630i0.C12571y;
import p630i0.InterfaceC12554h;

/* JADX INFO: renamed from: i0.e0.a.a */
/* JADX INFO: compiled from: GsonConverterFactory.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C12513a extends InterfaceC12554h.a {

    /* JADX INFO: renamed from: a */
    public final Gson f26510a;

    public C12513a(Gson gson) {
        this.f26510a = gson;
    }

    @Override // p630i0.InterfaceC12554h.a
    public InterfaceC12554h<?, RequestBody> requestBodyConverter(Type type, Annotation[] annotationArr, Annotation[] annotationArr2, C12571y c12571y) {
        return new C12514b(this.f26510a, this.f26510a.m9204h(TypeToken.get(type)));
    }

    @Override // p630i0.InterfaceC12554h.a
    public InterfaceC12554h<ResponseBody, ?> responseBodyConverter(Type type, Annotation[] annotationArr, C12571y c12571y) {
        return new C12515c(this.f26510a, this.f26510a.m9204h(TypeToken.get(type)));
    }
}
