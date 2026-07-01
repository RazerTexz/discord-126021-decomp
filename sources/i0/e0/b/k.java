package i0.e0.b;

import i0.h$a;
import i0.y;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;

/* JADX INFO: compiled from: ScalarsConverterFactory.java */
/* JADX INFO: loaded from: classes3.dex */
public final class k extends h$a {
    @Override // i0.h$a
    public i0.h<?, RequestBody> requestBodyConverter(Type type, Annotation[] annotationArr, Annotation[] annotationArr2, y yVar) {
        if (type == String.class || type == Boolean.TYPE || type == Boolean.class || type == Byte.TYPE || type == Byte.class || type == Character.TYPE || type == Character.class || type == Double.TYPE || type == Double.class || type == Float.TYPE || type == Float.class || type == Integer.TYPE || type == Integer.class || type == Long.TYPE || type == Long.class || type == Short.TYPE || type == Short.class) {
            return a.a;
        }
        return null;
    }

    @Override // i0.h$a
    public i0.h<ResponseBody, ?> responseBodyConverter(Type type, Annotation[] annotationArr, y yVar) {
        if (type == String.class) {
            return j.a;
        }
        if (type == Boolean.class || type == Boolean.TYPE) {
            return b.a;
        }
        if (type == Byte.class || type == Byte.TYPE) {
            return c.a;
        }
        if (type == Character.class || type == Character.TYPE) {
            return d.a;
        }
        if (type == Double.class || type == Double.TYPE) {
            return e.a;
        }
        if (type == Float.class || type == Float.TYPE) {
            return f.a;
        }
        if (type == Integer.class || type == Integer.TYPE) {
            return g.a;
        }
        if (type == Long.class || type == Long.TYPE) {
            return h.a;
        }
        if (type == Short.class || type == Short.TYPE) {
            return i.a;
        }
        return null;
    }
}
