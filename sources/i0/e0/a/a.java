package i0.e0.a;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import i0.h;
import i0.h$a;
import i0.y;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;

/* JADX INFO: compiled from: GsonConverterFactory.java */
/* JADX INFO: loaded from: classes3.dex */
public final class a extends h$a {
    public final Gson a;

    public a(Gson gson) {
        this.a = gson;
    }

    @Override // i0.h$a
    public h<?, RequestBody> requestBodyConverter(Type type, Annotation[] annotationArr, Annotation[] annotationArr2, y yVar) {
        return new b(this.a, this.a.h(TypeToken.get(type)));
    }

    @Override // i0.h$a
    public h<ResponseBody, ?> responseBodyConverter(Type type, Annotation[] annotationArr, y yVar) {
        return new c(this.a, this.a.h(TypeToken.get(type)));
    }
}
