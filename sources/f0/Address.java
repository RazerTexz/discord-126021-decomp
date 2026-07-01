package f0;

import b.d.b.a.outline;
import com.adjust.sdk.Constants;
import com.discord.widgets.chat.input.MentionUtils;
import d0.g0.StringsJVM;
import d0.z.d.Intrinsics3;
import f0.HttpUrl;
import f0.e0.Util7;
import java.net.Proxy;
import java.net.ProxySelector;
import java.util.List;
import java.util.Objects;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;

/* JADX INFO: renamed from: f0.a, reason: use source file name */
/* JADX INFO: compiled from: Address.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class Address {
    public final HttpUrl a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<Protocol2> f3601b;
    public final List<ConnectionSpec> c;
    public final Dns2 d;
    public final SocketFactory e;
    public final SSLSocketFactory f;
    public final HostnameVerifier g;
    public final CertificatePinner h;
    public final Authenticator2 i;
    public final Proxy j;
    public final ProxySelector k;

    public Address(String str, int i, Dns2 dns2, SocketFactory socketFactory, SSLSocketFactory sSLSocketFactory, HostnameVerifier hostnameVerifier, CertificatePinner certificatePinner, Authenticator2 authenticator2, Proxy proxy, List<? extends Protocol2> list, List<ConnectionSpec> list2, ProxySelector proxySelector) {
        Intrinsics3.checkParameterIsNotNull(str, "uriHost");
        Intrinsics3.checkParameterIsNotNull(dns2, "dns");
        Intrinsics3.checkParameterIsNotNull(socketFactory, "socketFactory");
        Intrinsics3.checkParameterIsNotNull(authenticator2, "proxyAuthenticator");
        Intrinsics3.checkParameterIsNotNull(list, "protocols");
        Intrinsics3.checkParameterIsNotNull(list2, "connectionSpecs");
        Intrinsics3.checkParameterIsNotNull(proxySelector, "proxySelector");
        this.d = dns2;
        this.e = socketFactory;
        this.f = sSLSocketFactory;
        this.g = hostnameVerifier;
        this.h = certificatePinner;
        this.i = authenticator2;
        this.j = proxy;
        this.k = proxySelector;
        HttpUrl.a aVar = new HttpUrl.a();
        String str2 = sSLSocketFactory != null ? Constants.SCHEME : "http";
        Intrinsics3.checkParameterIsNotNull(str2, "scheme");
        if (StringsJVM.equals(str2, "http", true)) {
            aVar.f3682b = "http";
        } else {
            if (!StringsJVM.equals(str2, Constants.SCHEME, true)) {
                throw new IllegalArgumentException(outline.w("unexpected scheme: ", str2));
            }
            aVar.f3682b = Constants.SCHEME;
        }
        Intrinsics3.checkParameterIsNotNull(str, "host");
        String strR1 = b.i.a.f.e.o.f.r1(HttpUrl.b.d(HttpUrl.f3681b, str, 0, 0, false, 7));
        if (strR1 == null) {
            throw new IllegalArgumentException(outline.w("unexpected host: ", str));
        }
        aVar.e = strR1;
        if (!(1 <= i && 65535 >= i)) {
            throw new IllegalArgumentException(outline.q("unexpected port: ", i).toString());
        }
        aVar.f = i;
        this.a = aVar.b();
        this.f3601b = Util7.z(list);
        this.c = Util7.z(list2);
    }

    public final boolean a(Address address) {
        Intrinsics3.checkParameterIsNotNull(address, "that");
        return Intrinsics3.areEqual(this.d, address.d) && Intrinsics3.areEqual(this.i, address.i) && Intrinsics3.areEqual(this.f3601b, address.f3601b) && Intrinsics3.areEqual(this.c, address.c) && Intrinsics3.areEqual(this.k, address.k) && Intrinsics3.areEqual(this.j, address.j) && Intrinsics3.areEqual(this.f, address.f) && Intrinsics3.areEqual(this.g, address.g) && Intrinsics3.areEqual(this.h, address.h) && this.a.h == address.a.h;
    }

    public boolean equals(Object obj) {
        if (obj instanceof Address) {
            Address address = (Address) obj;
            if (Intrinsics3.areEqual(this.a, address.a) && a(address)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return Objects.hashCode(this.h) + ((Objects.hashCode(this.g) + ((Objects.hashCode(this.f) + ((Objects.hashCode(this.j) + ((this.k.hashCode() + ((this.c.hashCode() + ((this.f3601b.hashCode() + ((this.i.hashCode() + ((this.d.hashCode() + ((this.a.hashCode() + 527) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31);
    }

    public String toString() {
        StringBuilder sbU;
        Object obj;
        StringBuilder sbU2 = outline.U("Address{");
        sbU2.append(this.a.g);
        sbU2.append(MentionUtils.EMOJIS_AND_STICKERS_CHAR);
        sbU2.append(this.a.h);
        sbU2.append(", ");
        if (this.j != null) {
            sbU = outline.U("proxy=");
            obj = this.j;
        } else {
            sbU = outline.U("proxySelector=");
            obj = this.k;
        }
        sbU.append(obj);
        sbU2.append(sbU.toString());
        sbU2.append("}");
        return sbU2.toString();
    }
}
