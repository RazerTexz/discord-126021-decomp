package i0.d0.a;

import i0.c0;
import i0.y;
import j0.h;
import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import retrofit2.Response;
import rx.Observable;
import rx.Scheduler;

/* JADX INFO: compiled from: RxJavaCallAdapterFactory.java */
/* JADX INFO: loaded from: classes3.dex */
public final class g extends i0.e$a {
    public g(Scheduler scheduler, boolean z2) {
    }

    @Override // i0.e$a
    public i0.e<?, ?> a(Type type, Annotation[] annotationArr, y yVar) {
        Type type2;
        boolean z2;
        boolean z3;
        Type typeE;
        Class<?> clsF = c0.f(type);
        boolean z4 = true;
        boolean z5 = clsF == h.class;
        boolean z6 = clsF == j0.d.class;
        if (clsF != Observable.class && !z5 && !z6) {
            return null;
        }
        if (z6) {
            return new f(Void.class, null, false, false, true, false, true);
        }
        if (!(type instanceof ParameterizedType)) {
            String str = z5 ? "Single" : "Observable";
            throw new IllegalStateException(str + " return type must be parameterized as " + str + "<Foo> or " + str + "<? extends Foo>");
        }
        Type typeE2 = c0.e(0, (ParameterizedType) type);
        Class<?> clsF2 = c0.f(typeE2);
        if (clsF2 != Response.class) {
            if (clsF2 != d.class) {
                type2 = typeE2;
                z2 = false;
                z3 = true;
            } else {
                if (!(typeE2 instanceof ParameterizedType)) {
                    throw new IllegalStateException("Result must be parameterized as Result<Foo> or Result<? extends Foo>");
                }
                typeE = c0.e(0, (ParameterizedType) typeE2);
            }
            return new f(type2, null, false, z2, z3, z5, false);
        }
        if (!(typeE2 instanceof ParameterizedType)) {
            throw new IllegalStateException("Response must be parameterized as Response<Foo> or Response<? extends Foo>");
        }
        typeE = c0.e(0, (ParameterizedType) typeE2);
        z4 = false;
        type2 = typeE;
        z2 = z4;
        z3 = false;
        return new f(type2, null, false, z2, z3, z5, false);
    }
}
