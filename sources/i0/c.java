package i0;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import kotlin.Unit;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;

/* JADX INFO: compiled from: BuiltInConverters.java */
/* JADX INFO: loaded from: classes3.dex */
public final class c extends h$a {
    public boolean a = true;

    @Override // i0.h$a
    public h<?, RequestBody> requestBodyConverter(Type type, Annotation[] annotationArr, Annotation[] annotationArr2, y yVar) {
        if (RequestBody.class.isAssignableFrom(c0.f(type))) {
            return c$b.a;
        }
        return null;
    }

    @Override // i0.h$a
    public h<ResponseBody, ?> responseBodyConverter(Type type, Annotation[] annotationArr, y yVar) {
        if (type == ResponseBody.class) {
            return c0.i(annotationArr, i0.f0.w.class) ? c$c.a : c$a.a;
        }
        if (type == Void.class) {
            return c$f.a;
        }
        if (!this.a || type != Unit.class) {
            return null;
        }
        try {
            return c$e.a;
        } catch (NoClassDefFoundError unused) {
            this.a = false;
            return null;
        }
    }
}
