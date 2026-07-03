package p630i0;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;

/* JADX INFO: renamed from: i0.h */
/* JADX INFO: compiled from: Converter.java */
/* JADX INFO: loaded from: classes3.dex */
public interface InterfaceC12554h<F, T> {

    /* JADX INFO: renamed from: i0.h$a */
    /* JADX INFO: compiled from: Converter.java */
    public static abstract class a {
        public static Type getParameterUpperBound(int i, ParameterizedType parameterizedType) {
            return C12503c0.m10685e(i, parameterizedType);
        }

        public static Class<?> getRawType(Type type) {
            return C12503c0.m10686f(type);
        }

        public InterfaceC12554h<?, RequestBody> requestBodyConverter(Type type, Annotation[] annotationArr, Annotation[] annotationArr2, C12571y c12571y) {
            return null;
        }

        public InterfaceC12554h<ResponseBody, ?> responseBodyConverter(Type type, Annotation[] annotationArr, C12571y c12571y) {
            return null;
        }

        public InterfaceC12554h<?, String> stringConverter(Type type, Annotation[] annotationArr, C12571y c12571y) {
            return null;
        }
    }

    T convert(F f) throws IOException;
}
