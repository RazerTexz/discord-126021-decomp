package i0.e0.b;

import i0.Converter2;
import i0.Retrofit2;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;

/* JADX INFO: renamed from: i0.e0.b.k, reason: use source file name */
/* JADX INFO: compiled from: ScalarsConverterFactory.java */
/* JADX INFO: loaded from: classes3.dex */
public final class ScalarsConverterFactory extends Converter2.a {
    @Override // i0.Converter2.a
    public Converter2<?, RequestBody> requestBodyConverter(Type type, Annotation[] annotationArr, Annotation[] annotationArr2, Retrofit2 retrofit3) {
        if (type == String.class || type == Boolean.TYPE || type == Boolean.class || type == Byte.TYPE || type == Byte.class || type == Character.TYPE || type == Character.class || type == Double.TYPE || type == Double.class || type == Float.TYPE || type == Float.class || type == Integer.TYPE || type == Integer.class || type == Long.TYPE || type == Long.class || type == Short.TYPE || type == Short.class) {
            return ScalarRequestBodyConverter.a;
        }
        return null;
    }

    @Override // i0.Converter2.a
    public Converter2<ResponseBody, ?> responseBodyConverter(Type type, Annotation[] annotationArr, Retrofit2 retrofit3) {
        if (type == String.class) {
            return ScalarResponseBodyConverters9.a;
        }
        if (type == Boolean.class || type == Boolean.TYPE) {
            return ScalarResponseBodyConverters.a;
        }
        if (type == Byte.class || type == Byte.TYPE) {
            return ScalarResponseBodyConverters2.a;
        }
        if (type == Character.class || type == Character.TYPE) {
            return ScalarResponseBodyConverters3.a;
        }
        if (type == Double.class || type == Double.TYPE) {
            return ScalarResponseBodyConverters4.a;
        }
        if (type == Float.class || type == Float.TYPE) {
            return ScalarResponseBodyConverters5.a;
        }
        if (type == Integer.class || type == Integer.TYPE) {
            return ScalarResponseBodyConverters6.a;
        }
        if (type == Long.class || type == Long.TYPE) {
            return ScalarResponseBodyConverters7.a;
        }
        if (type == Short.class || type == Short.TYPE) {
            return ScalarResponseBodyConverters8.a;
        }
        return null;
    }
}
