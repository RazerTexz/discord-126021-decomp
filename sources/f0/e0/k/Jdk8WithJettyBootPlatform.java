package f0.e0.k;

import d0.t.Iterables2;
import d0.z.d.Intrinsics3;
import f0.Protocol2;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import javax.net.ssl.SSLSocket;
import kotlin.TypeCastException;

/* JADX INFO: renamed from: f0.e0.k.e, reason: use source file name */
/* JADX INFO: compiled from: Jdk8WithJettyBootPlatform.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class Jdk8WithJettyBootPlatform extends Platform2 {
    public final Method d;
    public final Method e;
    public final Method f;
    public final Class<?> g;
    public final Class<?> h;

    /* JADX INFO: renamed from: f0.e0.k.e$a */
    /* JADX INFO: compiled from: Jdk8WithJettyBootPlatform.kt */
    public static final class a implements InvocationHandler {
        public boolean a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f3649b;
        public final List<String> c;

        public a(List<String> list) {
            Intrinsics3.checkParameterIsNotNull(list, "protocols");
            this.c = list;
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            Intrinsics3.checkParameterIsNotNull(obj, "proxy");
            Intrinsics3.checkParameterIsNotNull(method, "method");
            if (objArr == null) {
                objArr = new Object[0];
            }
            String name = method.getName();
            Class<?> returnType = method.getReturnType();
            if (Intrinsics3.areEqual(name, "supports") && Intrinsics3.areEqual(Boolean.TYPE, returnType)) {
                return Boolean.TRUE;
            }
            if (Intrinsics3.areEqual(name, "unsupported") && Intrinsics3.areEqual(Void.TYPE, returnType)) {
                this.a = true;
                return null;
            }
            if (Intrinsics3.areEqual(name, "protocols")) {
                if (objArr.length == 0) {
                    return this.c;
                }
            }
            if ((!Intrinsics3.areEqual(name, "selectProtocol") && !Intrinsics3.areEqual(name, "select")) || !Intrinsics3.areEqual(String.class, returnType) || objArr.length != 1 || !(objArr[0] instanceof List)) {
                if ((!Intrinsics3.areEqual(name, "protocolSelected") && !Intrinsics3.areEqual(name, "selected")) || objArr.length != 1) {
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

    public Jdk8WithJettyBootPlatform(Method method, Method method2, Method method3, Class<?> cls, Class<?> cls2) {
        Intrinsics3.checkParameterIsNotNull(method, "putMethod");
        Intrinsics3.checkParameterIsNotNull(method2, "getMethod");
        Intrinsics3.checkParameterIsNotNull(method3, "removeMethod");
        Intrinsics3.checkParameterIsNotNull(cls, "clientProviderClass");
        Intrinsics3.checkParameterIsNotNull(cls2, "serverProviderClass");
        this.d = method;
        this.e = method2;
        this.f = method3;
        this.g = cls;
        this.h = cls2;
    }

    @Override // f0.e0.k.Platform2
    public void a(SSLSocket sSLSocket) {
        Intrinsics3.checkParameterIsNotNull(sSLSocket, "sslSocket");
        try {
            this.f.invoke(null, sSLSocket);
        } catch (IllegalAccessException e) {
            throw new AssertionError("failed to remove ALPN", e);
        } catch (InvocationTargetException e2) {
            throw new AssertionError("failed to remove ALPN", e2);
        }
    }

    @Override // f0.e0.k.Platform2
    public void d(SSLSocket sSLSocket, String str, List<? extends Protocol2> list) {
        Intrinsics3.checkParameterIsNotNull(sSLSocket, "sslSocket");
        Intrinsics3.checkParameterIsNotNull(list, "protocols");
        Intrinsics3.checkParameterIsNotNull(list, "protocols");
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            if (((Protocol2) next) != Protocol2.HTTP_1_0) {
                arrayList.add(next);
            }
        }
        ArrayList arrayList2 = new ArrayList(Iterables2.collectionSizeOrDefault(arrayList, 10));
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            arrayList2.add(((Protocol2) it2.next()).toString());
        }
        try {
            this.d.invoke(null, sSLSocket, Proxy.newProxyInstance(Platform2.class.getClassLoader(), new Class[]{this.g, this.h}, new a(arrayList2)));
        } catch (IllegalAccessException e) {
            throw new AssertionError("failed to set ALPN", e);
        } catch (InvocationTargetException e2) {
            throw new AssertionError("failed to set ALPN", e2);
        }
    }

    @Override // f0.e0.k.Platform2
    public String f(SSLSocket sSLSocket) {
        Intrinsics3.checkParameterIsNotNull(sSLSocket, "sslSocket");
        try {
            InvocationHandler invocationHandler = Proxy.getInvocationHandler(this.e.invoke(null, sSLSocket));
            if (invocationHandler == null) {
                throw new TypeCastException("null cannot be cast to non-null type okhttp3.internal.platform.Jdk8WithJettyBootPlatform.AlpnProvider");
            }
            a aVar = (a) invocationHandler;
            boolean z2 = aVar.a;
            if (!z2 && aVar.f3649b == null) {
                Platform2.j(this, "ALPN callback dropped: HTTP/2 is disabled. Is alpn-boot on the boot class path?", 0, null, 6, null);
                return null;
            }
            if (z2) {
                return null;
            }
            return aVar.f3649b;
        } catch (IllegalAccessException e) {
            throw new AssertionError("failed to get ALPN selected protocol", e);
        } catch (InvocationTargetException e2) {
            throw new AssertionError("failed to get ALPN selected protocol", e2);
        }
    }
}
