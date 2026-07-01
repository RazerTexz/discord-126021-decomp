package f0.e0.k.i;

import d0.z.d.m;
import f0.e0.k.b$a;
import f0.y;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Objects;
import javax.net.ssl.SSLSocket;

/* JADX INFO: compiled from: AndroidSocketAdapter.kt */
/* JADX INFO: loaded from: classes3.dex */
public class f implements k {
    public static final j$a a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final f$a f3653b;
    public final Method c;
    public final Method d;
    public final Method e;
    public final Method f;
    public final Class<? super SSLSocket> g;

    static {
        f$a f_a = new f$a(null);
        f3653b = f_a;
        Objects.requireNonNull(f_a);
        m.checkParameterIsNotNull("com.google.android.gms.org.conscrypt", "packageName");
        a = new e("com.google.android.gms.org.conscrypt");
    }

    public f(Class<? super SSLSocket> cls) throws NoSuchMethodException {
        m.checkParameterIsNotNull(cls, "sslSocketClass");
        this.g = cls;
        Method declaredMethod = cls.getDeclaredMethod("setUseSessionTickets", Boolean.TYPE);
        m.checkExpressionValueIsNotNull(declaredMethod, "sslSocketClass.getDeclar…:class.javaPrimitiveType)");
        this.c = declaredMethod;
        this.d = cls.getMethod("setHostname", String.class);
        this.e = cls.getMethod("getAlpnSelectedProtocol", new Class[0]);
        this.f = cls.getMethod("setAlpnProtocols", byte[].class);
    }

    @Override // f0.e0.k.i.k
    public boolean a(SSLSocket sSLSocket) {
        m.checkParameterIsNotNull(sSLSocket, "sslSocket");
        return this.g.isInstance(sSLSocket);
    }

    @Override // f0.e0.k.i.k
    public boolean b() {
        b$a b_a = f0.e0.k.b.e;
        return f0.e0.k.b.d;
    }

    @Override // f0.e0.k.i.k
    public String c(SSLSocket sSLSocket) {
        m.checkParameterIsNotNull(sSLSocket, "sslSocket");
        if (!a(sSLSocket)) {
            return null;
        }
        try {
            byte[] bArr = (byte[]) this.e.invoke(sSLSocket, new Object[0]);
            if (bArr == null) {
                return null;
            }
            Charset charset = StandardCharsets.UTF_8;
            m.checkExpressionValueIsNotNull(charset, "StandardCharsets.UTF_8");
            return new String(bArr, charset);
        } catch (IllegalAccessException e) {
            throw new AssertionError(e);
        } catch (NullPointerException e2) {
            if (m.areEqual(e2.getMessage(), "ssl == null")) {
                return null;
            }
            throw e2;
        } catch (InvocationTargetException e3) {
            throw new AssertionError(e3);
        }
    }

    @Override // f0.e0.k.i.k
    public void d(SSLSocket sSLSocket, String str, List<? extends y> list) {
        m.checkParameterIsNotNull(sSLSocket, "sslSocket");
        m.checkParameterIsNotNull(list, "protocols");
        if (a(sSLSocket)) {
            try {
                this.c.invoke(sSLSocket, Boolean.TRUE);
                if (str != null) {
                    this.d.invoke(sSLSocket, str);
                }
                this.f.invoke(sSLSocket, f0.e0.k.h.c.b(list));
            } catch (IllegalAccessException e) {
                throw new AssertionError(e);
            } catch (InvocationTargetException e2) {
                throw new AssertionError(e2);
            }
        }
    }
}
