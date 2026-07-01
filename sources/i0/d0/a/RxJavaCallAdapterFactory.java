package i0.d0.a;

import i0.CallAdapter;
import i0.Retrofit2;
import i0.Utils8;
import j0.Completable3;
import j0.Single2;
import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import retrofit2.Response;
import rx.Observable;
import rx.Scheduler;

/* JADX INFO: renamed from: i0.d0.a.g, reason: use source file name */
/* JADX INFO: compiled from: RxJavaCallAdapterFactory.java */
/* JADX INFO: loaded from: classes3.dex */
public final class RxJavaCallAdapterFactory extends CallAdapter.a {
    public RxJavaCallAdapterFactory(Scheduler scheduler, boolean z2) {
    }

    @Override // i0.CallAdapter.a
    public CallAdapter<?, ?> a(Type type, Annotation[] annotationArr, Retrofit2 retrofit3) {
        Type type2;
        boolean z2;
        boolean z3;
        Type typeE;
        Class<?> clsF = Utils8.f(type);
        boolean z4 = true;
        boolean z5 = clsF == Single2.class;
        boolean z6 = clsF == Completable3.class;
        if (clsF != Observable.class && !z5 && !z6) {
            return null;
        }
        if (z6) {
            return new RxJavaCallAdapter(Void.class, null, false, false, true, false, true);
        }
        if (!(type instanceof ParameterizedType)) {
            String str = z5 ? "Single" : "Observable";
            throw new IllegalStateException(str + " return type must be parameterized as " + str + "<Foo> or " + str + "<? extends Foo>");
        }
        Type typeE2 = Utils8.e(0, (ParameterizedType) type);
        Class<?> clsF2 = Utils8.f(typeE2);
        if (clsF2 != Response.class) {
            if (clsF2 != Result4.class) {
                type2 = typeE2;
                z2 = false;
                z3 = true;
            } else {
                if (!(typeE2 instanceof ParameterizedType)) {
                    throw new IllegalStateException("Result must be parameterized as Result<Foo> or Result<? extends Foo>");
                }
                typeE = Utils8.e(0, (ParameterizedType) typeE2);
            }
            return new RxJavaCallAdapter(type2, null, false, z2, z3, z5, false);
        }
        if (!(typeE2 instanceof ParameterizedType)) {
            throw new IllegalStateException("Response must be parameterized as Response<Foo> or Response<? extends Foo>");
        }
        typeE = Utils8.e(0, (ParameterizedType) typeE2);
        z4 = false;
        type2 = typeE;
        z2 = z4;
        z3 = false;
        return new RxJavaCallAdapter(type2, null, false, z2, z3, z5, false);
    }
}
