package f0.e0.k.i;

import d0.z.d.Intrinsics3;
import f0.Protocol2;
import f0.e0.k.AndroidPlatform;
import f0.e0.k.Platform2;
import f0.e0.k.i.DeferredSocketAdapter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Objects;
import javax.net.ssl.SSLSocket;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: renamed from: f0.e0.k.i.f, reason: use source file name */
/* JADX INFO: compiled from: AndroidSocketAdapter.kt */
/* JADX INFO: loaded from: classes3.dex */
public class AndroidSocketAdapter2 implements SocketAdapter {
    public static final DeferredSocketAdapter.a a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f3653b;
    public final Method c;
    public final Method d;
    public final Method e;
    public final Method f;
    public final Class<? super SSLSocket> g;

    /* JADX INFO: renamed from: f0.e0.k.i.f$a */
    /* JADX INFO: compiled from: AndroidSocketAdapter.kt */
    public static final class a {
        public a(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    static {
        a aVar = new a(null);
        f3653b = aVar;
        Objects.requireNonNull(aVar);
        Intrinsics3.checkParameterIsNotNull("com.google.android.gms.org.conscrypt", "packageName");
        a = new AndroidSocketAdapter("com.google.android.gms.org.conscrypt");
    }

    public AndroidSocketAdapter2(Class<? super SSLSocket> cls) throws NoSuchMethodException {
        Intrinsics3.checkParameterIsNotNull(cls, "sslSocketClass");
        this.g = cls;
        Method declaredMethod = cls.getDeclaredMethod("setUseSessionTickets", Boolean.TYPE);
        Intrinsics3.checkExpressionValueIsNotNull(declaredMethod, "sslSocketClass.getDeclar…:class.javaPrimitiveType)");
        this.c = declaredMethod;
        this.d = cls.getMethod("setHostname", String.class);
        this.e = cls.getMethod("getAlpnSelectedProtocol", new Class[0]);
        this.f = cls.getMethod("setAlpnProtocols", byte[].class);
    }

    @Override // f0.e0.k.i.SocketAdapter
    public boolean a(SSLSocket sSLSocket) {
        Intrinsics3.checkParameterIsNotNull(sSLSocket, "sslSocket");
        return this.g.isInstance(sSLSocket);
    }

    @Override // f0.e0.k.i.SocketAdapter
    public boolean b() {
        AndroidPlatform.a aVar = AndroidPlatform.e;
        return AndroidPlatform.d;
    }

    @Override // f0.e0.k.i.SocketAdapter
    public String c(SSLSocket sSLSocket) {
        Intrinsics3.checkParameterIsNotNull(sSLSocket, "sslSocket");
        if (!a(sSLSocket)) {
            return null;
        }
        try {
            byte[] bArr = (byte[]) this.e.invoke(sSLSocket, new Object[0]);
            if (bArr == null) {
                return null;
            }
            Charset charset = StandardCharsets.UTF_8;
            Intrinsics3.checkExpressionValueIsNotNull(charset, "StandardCharsets.UTF_8");
            return new String(bArr, charset);
        } catch (IllegalAccessException e) {
            throw new AssertionError(e);
        } catch (NullPointerException e2) {
            if (Intrinsics3.areEqual(e2.getMessage(), "ssl == null")) {
                return null;
            }
            throw e2;
        } catch (InvocationTargetException e3) {
            throw new AssertionError(e3);
        }
    }

    @Override // f0.e0.k.i.SocketAdapter
    public void d(SSLSocket sSLSocket, String str, List<? extends Protocol2> list) {
        Intrinsics3.checkParameterIsNotNull(sSLSocket, "sslSocket");
        Intrinsics3.checkParameterIsNotNull(list, "protocols");
        if (a(sSLSocket)) {
            try {
                this.c.invoke(sSLSocket, Boolean.TRUE);
                if (str != null) {
                    this.d.invoke(sSLSocket, str);
                }
                this.f.invoke(sSLSocket, Platform2.c.b(list));
            } catch (IllegalAccessException e) {
                throw new AssertionError(e);
            } catch (InvocationTargetException e2) {
                throw new AssertionError(e2);
            }
        }
    }
}
