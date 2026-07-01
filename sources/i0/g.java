package i0;

import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.concurrent.CompletableFuture;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;
import retrofit2.Response;

/* JADX INFO: compiled from: CompletableFutureCallAdapterFactory.java */
/* JADX INFO: loaded from: classes3.dex */
@IgnoreJRERequirement
public final class g extends e$a {
    public static final e$a a = new g();

    @Override // i0.e$a
    public e<?, ?> a(Type type, Annotation[] annotationArr, y yVar) {
        if (c0.f(type) != CompletableFuture.class) {
            return null;
        }
        if (!(type instanceof ParameterizedType)) {
            throw new IllegalStateException("CompletableFuture return type must be parameterized as CompletableFuture<Foo> or CompletableFuture<? extends Foo>");
        }
        Type typeE = c0.e(0, (ParameterizedType) type);
        if (c0.f(typeE) != Response.class) {
            return new g$a(typeE);
        }
        if (typeE instanceof ParameterizedType) {
            return new g$c(c0.e(0, (ParameterizedType) typeE));
        }
        throw new IllegalStateException("Response must be parameterized as Response<Foo> or Response<? extends Foo>");
    }
}
