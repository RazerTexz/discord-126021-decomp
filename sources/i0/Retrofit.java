package i0;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/* JADX INFO: renamed from: i0.x, reason: use source file name */
/* JADX INFO: compiled from: Retrofit.java */
/* JADX INFO: loaded from: classes3.dex */
public class Retrofit implements InvocationHandler {
    public final Platform3 a = Platform3.a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object[] f3766b = new Object[0];
    public final /* synthetic */ Class c;
    public final /* synthetic */ Retrofit2 d;

    public Retrofit(Retrofit2 retrofit3, Class cls) {
        this.d = retrofit3;
        this.c = cls;
    }

    @Override // java.lang.reflect.InvocationHandler
    public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
        if (method.getDeclaringClass() == Object.class) {
            return method.invoke(this, objArr);
        }
        if (objArr == null) {
            objArr = this.f3766b;
        }
        return this.a.f3758b && method.isDefault() ? this.a.b(method, this.c, obj, objArr) : this.d.b(method).a(objArr);
    }
}
