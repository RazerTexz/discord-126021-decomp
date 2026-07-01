package i0;

import i0.Converter2;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Optional;
import okhttp3.ResponseBody;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;

/* JADX INFO: renamed from: i0.q, reason: use source file name */
/* JADX INFO: compiled from: OptionalConverterFactory.java */
/* JADX INFO: loaded from: classes3.dex */
@IgnoreJRERequirement
public final class OptionalConverterFactory extends Converter2.a {
    public static final Converter2.a a = new OptionalConverterFactory();

    /* JADX INFO: renamed from: i0.q$a */
    /* JADX INFO: compiled from: OptionalConverterFactory.java */
    @IgnoreJRERequirement
    public static final class a<T> implements Converter2<ResponseBody, Optional<T>> {
        public final Converter2<ResponseBody, T> a;

        public a(Converter2<ResponseBody, T> converter2) {
            this.a = converter2;
        }

        @Override // i0.Converter2
        public Object convert(ResponseBody responseBody) throws IOException {
            return Optional.ofNullable(this.a.convert(responseBody));
        }
    }

    @Override // i0.Converter2.a
    public Converter2<ResponseBody, ?> responseBodyConverter(Type type, Annotation[] annotationArr, Retrofit2 retrofit3) {
        if (Converter2.a.getRawType(type) != Optional.class) {
            return null;
        }
        return new a(retrofit3.d(Converter2.a.getParameterUpperBound(0, (ParameterizedType) type), annotationArr));
    }
}
