package i0;

import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: DefaultCallAdapterFactory.java */
/* JADX INFO: loaded from: classes3.dex */
public final class i extends e$a {
    public final Executor a;

    public i(Executor executor) {
        this.a = executor;
    }

    @Override // i0.e$a
    public e<?, ?> a(Type type, Annotation[] annotationArr, y yVar) {
        if (c0.f(type) != d.class) {
            return null;
        }
        if (type instanceof ParameterizedType) {
            return new i$a(this, c0.e(0, (ParameterizedType) type), c0.i(annotationArr, a0.class) ? null : this.a);
        }
        throw new IllegalArgumentException("Call return type must be parameterized as Call<Foo> or Call<? extends Foo>");
    }
}
