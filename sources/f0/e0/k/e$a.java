package f0.e0.k;

import d0.z.d.m;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import kotlin.TypeCastException;

/* JADX INFO: compiled from: Jdk8WithJettyBootPlatform.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class e$a implements InvocationHandler {
    public boolean a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f3649b;
    public final List<String> c;

    public e$a(List<String> list) {
        m.checkParameterIsNotNull(list, "protocols");
        this.c = list;
    }

    @Override // java.lang.reflect.InvocationHandler
    public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
        m.checkParameterIsNotNull(obj, "proxy");
        m.checkParameterIsNotNull(method, "method");
        if (objArr == null) {
            objArr = new Object[0];
        }
        String name = method.getName();
        Class<?> returnType = method.getReturnType();
        if (m.areEqual(name, "supports") && m.areEqual(Boolean.TYPE, returnType)) {
            return Boolean.TRUE;
        }
        if (m.areEqual(name, "unsupported") && m.areEqual(Void.TYPE, returnType)) {
            this.a = true;
            return null;
        }
        if (m.areEqual(name, "protocols")) {
            if (objArr.length == 0) {
                return this.c;
            }
        }
        if ((!m.areEqual(name, "selectProtocol") && !m.areEqual(name, "select")) || !m.areEqual(String.class, returnType) || objArr.length != 1 || !(objArr[0] instanceof List)) {
            if ((!m.areEqual(name, "protocolSelected") && !m.areEqual(name, "selected")) || objArr.length != 1) {
                return method.invoke(this, Arrays.copyOf(objArr, objArr.length));
            }
            Object obj2 = objArr[0];
            if (obj2 == null) {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.String");
            }
            this.f3649b = (String) obj2;
            return null;
        }
        Object obj3 = objArr[0];
        if (obj3 == null) {
            throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.List<*>");
        }
        List list = (List) obj3;
        int size = list.size();
        if (size >= 0) {
            int i = 0;
            while (true) {
                Object obj4 = list.get(i);
                if (obj4 == null) {
                    throw new TypeCastException("null cannot be cast to non-null type kotlin.String");
                }
                String str = (String) obj4;
                if (!this.c.contains(str)) {
                    if (i == size) {
                        break;
                    }
                    i++;
                } else {
                    this.f3649b = str;
                    return str;
                }
            }
        }
        String str2 = this.c.get(0);
        this.f3649b = str2;
        return str2;
    }
}
