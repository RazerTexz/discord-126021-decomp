package p630i0;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/* JADX INFO: renamed from: i0.x */
/* JADX INFO: compiled from: Retrofit.java */
/* JADX INFO: loaded from: classes3.dex */
public class C12570x implements InvocationHandler {

    /* JADX INFO: renamed from: a */
    public final C12567u f26669a = C12567u.f26614a;

    /* JADX INFO: renamed from: b */
    public final Object[] f26670b = new Object[0];

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ Class f26671c;

    /* JADX INFO: renamed from: d */
    public final /* synthetic */ C12571y f26672d;

    public C12570x(C12571y c12571y, Class cls) {
        this.f26672d = c12571y;
        this.f26671c = cls;
    }

    @Override // java.lang.reflect.InvocationHandler
    public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
        if (method.getDeclaringClass() == Object.class) {
            return method.invoke(this, objArr);
        }
        if (objArr == null) {
            objArr = this.f26670b;
        }
        return this.f26669a.f26615b && method.isDefault() ? this.f26669a.mo10717b(method, this.f26671c, obj, objArr) : this.f26672d.m10726b(method).mo10710a(objArr);
    }
}
