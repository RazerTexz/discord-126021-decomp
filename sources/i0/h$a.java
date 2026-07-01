package i0;

import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;

/* JADX INFO: compiled from: Converter.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class h$a {
    public static Type getParameterUpperBound(int i, ParameterizedType parameterizedType) {
        return c0.e(i, parameterizedType);
    }

    public static Class<?> getRawType(Type type) {
        return c0.f(type);
    }

    public h<?, RequestBody> requestBodyConverter(Type type, Annotation[] annotationArr, Annotation[] annotationArr2, y yVar) {
        return null;
    }

    public h<ResponseBody, ?> responseBodyConverter(Type type, Annotation[] annotationArr, y yVar) {
        return null;
    }

    public h<?, String> stringConverter(Type type, Annotation[] annotationArr, y yVar) {
        return null;
    }
}
