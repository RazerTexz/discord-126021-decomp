package i0.e0.a;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import i0.Converter2;
import i0.Retrofit2;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;

/* JADX INFO: renamed from: i0.e0.a.a, reason: use source file name */
/* JADX INFO: compiled from: GsonConverterFactory.java */
/* JADX INFO: loaded from: classes3.dex */
public final class GsonConverterFactory extends Converter2.a {
    public final Gson a;

    public GsonConverterFactory(Gson gson) {
        this.a = gson;
    }

    @Override // i0.Converter2.a
    public Converter2<?, RequestBody> requestBodyConverter(Type type, Annotation[] annotationArr, Annotation[] annotationArr2, Retrofit2 retrofit3) {
        return new GsonRequestBodyConverter(this.a, this.a.h(TypeToken.get(type)));
    }

    @Override // i0.Converter2.a
    public Converter2<ResponseBody, ?> responseBodyConverter(Type type, Annotation[] annotationArr, Retrofit2 retrofit3) {
        return new GsonResponseBodyConverter(this.a, this.a.h(TypeToken.get(type)));
    }
}
