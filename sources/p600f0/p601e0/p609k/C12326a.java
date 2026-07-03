package p600f0.p601e0.p609k;

import android.annotation.SuppressLint;
import android.net.http.X509TrustManagerExtensions;
import android.os.Build;
import android.security.NetworkSecurityPolicy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.X509TrustManager;
import p507d0.p580t.C12147n;
import p507d0.p592z.p594d.C12238m;
import p600f0.EnumC12381y;
import p600f0.p601e0.p609k.p610i.C12334a;
import p600f0.p601e0.p609k.p610i.C12335b;
import p600f0.p601e0.p609k.p610i.C12339f;
import p600f0.p601e0.p609k.p610i.C12340g;
import p600f0.p601e0.p609k.p610i.C12342i;
import p600f0.p601e0.p609k.p610i.C12343j;
import p600f0.p601e0.p609k.p610i.InterfaceC12344k;
import p600f0.p601e0.p612m.AbstractC12349c;

/* JADX INFO: renamed from: f0.e0.k.a */
/* JADX INFO: compiled from: Android10Platform.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C12326a extends C12333h {

    /* JADX INFO: renamed from: d */
    public static final boolean f25754d;

    /* JADX INFO: renamed from: e */
    public static final C12326a f25755e = null;

    /* JADX INFO: renamed from: f */
    public final List<InterfaceC12344k> f25756f;

    static {
        f25754d = C12333h.f25785c.m10333c() && Build.VERSION.SDK_INT >= 29;
    }

    public C12326a() {
        InterfaceC12344k[] interfaceC12344kArr = new InterfaceC12344k[4];
        interfaceC12344kArr[0] = C12238m.areEqual("Dalvik", System.getProperty("java.vm.name")) && Build.VERSION.SDK_INT >= 29 ? new C12334a() : null;
        C12339f.a aVar = C12339f.f25794b;
        interfaceC12344kArr[1] = new C12343j(C12339f.f25793a);
        interfaceC12344kArr[2] = new C12343j(C12342i.f25804a);
        interfaceC12344kArr[3] = new C12343j(C12340g.f25800a);
        List listListOfNotNull = C12147n.listOfNotNull((Object[]) interfaceC12344kArr);
        ArrayList arrayList = new ArrayList();
        for (Object obj : listListOfNotNull) {
            if (((InterfaceC12344k) obj).mo10335b()) {
                arrayList.add(obj);
            }
        }
        this.f25756f = arrayList;
    }

    @Override // p600f0.p601e0.p609k.C12333h
    /* JADX INFO: renamed from: b */
    public AbstractC12349c mo10315b(X509TrustManager x509TrustManager) {
        X509TrustManagerExtensions x509TrustManagerExtensions;
        C12238m.checkParameterIsNotNull(x509TrustManager, "trustManager");
        C12238m.checkParameterIsNotNull(x509TrustManager, "trustManager");
        try {
            x509TrustManagerExtensions = new X509TrustManagerExtensions(x509TrustManager);
        } catch (IllegalArgumentException unused) {
            x509TrustManagerExtensions = null;
        }
        C12335b c12335b = x509TrustManagerExtensions != null ? new C12335b(x509TrustManager, x509TrustManagerExtensions) : null;
        return c12335b != null ? c12335b : super.mo10315b(x509TrustManager);
    }

    @Override // p600f0.p601e0.p609k.C12333h
    /* JADX INFO: renamed from: d */
    public void mo10316d(SSLSocket sSLSocket, String str, List<? extends EnumC12381y> list) {
        Object next;
        C12238m.checkParameterIsNotNull(sSLSocket, "sslSocket");
        C12238m.checkParameterIsNotNull(list, "protocols");
        Iterator<T> it = this.f25756f.iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (!((InterfaceC12344k) next).mo10334a(sSLSocket));
        InterfaceC12344k interfaceC12344k = (InterfaceC12344k) next;
        if (interfaceC12344k != null) {
            interfaceC12344k.mo10337d(sSLSocket, str, list);
        }
    }

    @Override // p600f0.p601e0.p609k.C12333h
    /* JADX INFO: renamed from: f */
    public String mo10317f(SSLSocket sSLSocket) {
        Object next;
        C12238m.checkParameterIsNotNull(sSLSocket, "sslSocket");
        Iterator<T> it = this.f25756f.iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (!((InterfaceC12344k) next).mo10334a(sSLSocket));
        InterfaceC12344k interfaceC12344k = (InterfaceC12344k) next;
        if (interfaceC12344k != null) {
            return interfaceC12344k.mo10336c(sSLSocket);
        }
        return null;
    }

    @Override // p600f0.p601e0.p609k.C12333h
    @SuppressLint({"NewApi"})
    /* JADX INFO: renamed from: h */
    public boolean mo10318h(String str) {
        C12238m.checkParameterIsNotNull(str, "hostname");
        return NetworkSecurityPolicy.getInstance().isCleartextTrafficPermitted(str);
    }
}
