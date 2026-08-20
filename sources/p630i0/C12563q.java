package p630i0;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Optional;
import okhttp3.ResponseBody;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;

/* JADX INFO: renamed from: i0.q */
/* JADX INFO: compiled from: OptionalConverterFactory.java */
/* JADX INFO: loaded from: classes3.dex */
@IgnoreJRERequirement
public final class C12563q extends InterfaceC12554h.a {

    /* JADX INFO: renamed from: a */
    public static final InterfaceC12554h.a f26567a = new C12563q();

    /* JADX INFO: renamed from: i0.q$a */
    /* JADX INFO: compiled from: OptionalConverterFactory.java */
    @IgnoreJRERequirement
    public static final class a<T> implements InterfaceC12554h<ResponseBody, Optional<T>> {

        /* JADX INFO: renamed from: a */
        public final InterfaceC12554h<ResponseBody, T> f26568a;

        public a(InterfaceC12554h<ResponseBody, T> interfaceC12554h) {
            this.f26568a = interfaceC12554h;
        }

        @Override // p630i0.InterfaceC12554h
        public Object convert(ResponseBody responseBody) throws IOException {
            return Optional.ofNullable(this.f26568a.convert(responseBody));
        }
    }

    @Override // p630i0.InterfaceC12554h.a
    public InterfaceC12554h<ResponseBody, ?> responseBodyConverter(Type type, Annotation[] annotationArr, C12571y c12571y) {
        if (InterfaceC12554h.a.getRawType(type) != Optional.class) {
            return null;
        }
        return new a(c12571y.m10728d(InterfaceC12554h.a.getParameterUpperBound(0, (ParameterizedType) type), annotationArr));
    }
}
