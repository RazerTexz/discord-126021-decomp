package p630i0.p631d0.p632a;

import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import p630i0.C12503c0;
import p630i0.C12571y;
import p630i0.InterfaceC12512e;
import p637j0.C12578d;
import p637j0.C12582h;
import p658rx.Observable;
import p658rx.Scheduler;
import retrofit2.Response;

/* JADX INFO: renamed from: i0.d0.a.g */
/* JADX INFO: compiled from: RxJavaCallAdapterFactory.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C12511g extends InterfaceC12512e.a {
    public C12511g(Scheduler scheduler, boolean z2) {
    }

    @Override // p630i0.InterfaceC12512e.a
    /* JADX INFO: renamed from: a */
    public InterfaceC12512e<?, ?> mo10707a(Type type, Annotation[] annotationArr, C12571y c12571y) {
        Type type2;
        boolean z2;
        boolean z3;
        Type typeM10685e;
        Class<?> clsM10686f = C12503c0.m10686f(type);
        boolean z4 = true;
        boolean z5 = clsM10686f == C12582h.class;
        boolean z6 = clsM10686f == C12578d.class;
        if (clsM10686f != Observable.class && !z5 && !z6) {
            return null;
        }
        if (z6) {
            return new C12510f(Void.class, null, false, false, true, false, true);
        }
        if (!(type instanceof ParameterizedType)) {
            String str = z5 ? "Single" : "Observable";
            throw new IllegalStateException(str + " return type must be parameterized as " + str + "<Foo> or " + str + "<? extends Foo>");
        }
        Type typeM10685e2 = C12503c0.m10685e(0, (ParameterizedType) type);
        Class<?> clsM10686f2 = C12503c0.m10686f(typeM10685e2);
        if (clsM10686f2 != Response.class) {
            if (clsM10686f2 != C12508d.class) {
                type2 = typeM10685e2;
                z2 = false;
                z3 = true;
            } else {
                if (!(typeM10685e2 instanceof ParameterizedType)) {
                    throw new IllegalStateException("Result must be parameterized as Result<Foo> or Result<? extends Foo>");
                }
                typeM10685e = C12503c0.m10685e(0, (ParameterizedType) typeM10685e2);
            }
            return new C12510f(type2, null, false, z2, z3, z5, false);
        }
        if (!(typeM10685e2 instanceof ParameterizedType)) {
            throw new IllegalStateException("Response must be parameterized as Response<Foo> or Response<? extends Foo>");
        }
        typeM10685e = C12503c0.m10685e(0, (ParameterizedType) typeM10685e2);
        z4 = false;
        type2 = typeM10685e;
        z2 = z4;
        z3 = false;
        return new C12510f(type2, null, false, z2, z3, z5, false);
    }
}
