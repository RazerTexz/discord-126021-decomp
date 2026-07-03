package p630i0.p633e0.p635b;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import p630i0.C12571y;
import p630i0.InterfaceC12554h;

/* JADX INFO: renamed from: i0.e0.b.k */
/* JADX INFO: compiled from: ScalarsConverterFactory.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C12526k extends InterfaceC12554h.a {
    @Override // p630i0.InterfaceC12554h.a
    public InterfaceC12554h<?, RequestBody> requestBodyConverter(Type type, Annotation[] annotationArr, Annotation[] annotationArr2, C12571y c12571y) {
        if (type == String.class || type == Boolean.TYPE || type == Boolean.class || type == Byte.TYPE || type == Byte.class || type == Character.TYPE || type == Character.class || type == Double.TYPE || type == Double.class || type == Float.TYPE || type == Float.class || type == Integer.TYPE || type == Integer.class || type == Long.TYPE || type == Long.class || type == Short.TYPE || type == Short.class) {
            return C12516a.f26517a;
        }
        return null;
    }

    @Override // p630i0.InterfaceC12554h.a
    public InterfaceC12554h<ResponseBody, ?> responseBodyConverter(Type type, Annotation[] annotationArr, C12571y c12571y) {
        if (type == String.class) {
            return C12525j.f26527a;
        }
        if (type == Boolean.class || type == Boolean.TYPE) {
            return C12517b.f26519a;
        }
        if (type == Byte.class || type == Byte.TYPE) {
            return C12518c.f26520a;
        }
        if (type == Character.class || type == Character.TYPE) {
            return C12519d.f26521a;
        }
        if (type == Double.class || type == Double.TYPE) {
            return C12520e.f26522a;
        }
        if (type == Float.class || type == Float.TYPE) {
            return C12521f.f26523a;
        }
        if (type == Integer.class || type == Integer.TYPE) {
            return C12522g.f26524a;
        }
        if (type == Long.class || type == Long.TYPE) {
            return C12523h.f26525a;
        }
        if (type == Short.class || type == Short.TYPE) {
            return C12524i.f26526a;
        }
        return null;
    }
}
