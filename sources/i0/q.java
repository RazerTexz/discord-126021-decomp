package i0;

import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Optional;
import okhttp3.ResponseBody;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;

/* JADX INFO: compiled from: OptionalConverterFactory.java */
/* JADX INFO: loaded from: classes3.dex */
@IgnoreJRERequirement
public final class q extends h$a {
    public static final h$a a = new q();

    @Override // i0.h$a
    public h<ResponseBody, ?> responseBodyConverter(Type type, Annotation[] annotationArr, y yVar) {
        if (h$a.getRawType(type) != Optional.class) {
            return null;
        }
        return new q$a(yVar.d(h$a.getParameterUpperBound(0, (ParameterizedType) type), annotationArr));
    }
}
