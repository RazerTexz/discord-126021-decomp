package d0.e0.p.d.l0;

import d0.e0.p.d.a0;
import d0.t.k;
import d0.z.d.m;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Map;
import kotlin.Lazy;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: AnnotationConstructorCaller.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class b$c implements InvocationHandler {
    public final /* synthetic */ Class a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Lazy f3203b;
    public final /* synthetic */ Lazy c;
    public final /* synthetic */ b$a d;
    public final /* synthetic */ Map e;

    public b$c(Class cls, Lazy lazy, KProperty kProperty, Lazy lazy2, KProperty kProperty2, b$a b_a, Map map) {
        this.a = cls;
        this.f3203b = lazy;
        this.c = lazy2;
        this.d = b_a;
        this.e = map;
    }

    @Override // java.lang.reflect.InvocationHandler
    public final Object invoke(Object obj, Method method, Object[] objArr) {
        m.checkNotNullExpressionValue(method, "method");
        String name = method.getName();
        if (name != null) {
            int iHashCode = name.hashCode();
            if (iHashCode != -1776922004) {
                if (iHashCode != 147696667) {
                    if (iHashCode == 1444986633 && name.equals("annotationType")) {
                        return this.a;
                    }
                } else if (name.equals("hashCode")) {
                    return this.c.getValue();
                }
            } else if (name.equals("toString")) {
                return this.f3203b.getValue();
            }
        }
        if (m.areEqual(name, "equals") && objArr != null && objArr.length == 1) {
            return Boolean.valueOf(this.d.invoke2(k.single(objArr)));
        }
        if (this.e.containsKey(name)) {
            return this.e.get(name);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Method is not supported: ");
        sb.append(method);
        sb.append(" (args: ");
        if (objArr == null) {
            objArr = new Object[0];
        }
        sb.append(k.toList(objArr));
        sb.append(')');
        throw new a0(sb.toString());
    }
}
