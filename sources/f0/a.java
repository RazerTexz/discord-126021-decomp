package f0;

import com.adjust.sdk.Constants;
import com.discord.widgets.chat.input.MentionUtilsKt;
import java.net.Proxy;
import java.net.ProxySelector;
import java.util.List;
import java.util.Objects;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;

/* JADX INFO: compiled from: Address.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a {
    public final w a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<y> f3601b;
    public final List<m> c;
    public final s d;
    public final SocketFactory e;
    public final SSLSocketFactory f;
    public final HostnameVerifier g;
    public final g h;
    public final c i;
    public final Proxy j;
    public final ProxySelector k;

    public a(String str, int i, s sVar, SocketFactory socketFactory, SSLSocketFactory sSLSocketFactory, HostnameVerifier hostnameVerifier, g gVar, c cVar, Proxy proxy, List<? extends y> list, List<m> list2, ProxySelector proxySelector) {
        d0.z.d.m.checkParameterIsNotNull(str, "uriHost");
        d0.z.d.m.checkParameterIsNotNull(sVar, "dns");
        d0.z.d.m.checkParameterIsNotNull(socketFactory, "socketFactory");
        d0.z.d.m.checkParameterIsNotNull(cVar, "proxyAuthenticator");
        d0.z.d.m.checkParameterIsNotNull(list, "protocols");
        d0.z.d.m.checkParameterIsNotNull(list2, "connectionSpecs");
        d0.z.d.m.checkParameterIsNotNull(proxySelector, "proxySelector");
        this.d = sVar;
        this.e = socketFactory;
        this.f = sSLSocketFactory;
        this.g = hostnameVerifier;
        this.h = gVar;
        this.i = cVar;
        this.j = proxy;
        this.k = proxySelector;
        w$a w_a = new w$a();
        String str2 = sSLSocketFactory != null ? Constants.SCHEME : "http";
        d0.z.d.m.checkParameterIsNotNull(str2, "scheme");
        if (d0.g0.t.equals(str2, "http", true)) {
            w_a.f3682b = "http";
        } else {
            if (!d0.g0.t.equals(str2, Constants.SCHEME, true)) {
                throw new IllegalArgumentException(b.d.b.a.a.w("unexpected scheme: ", str2));
            }
            w_a.f3682b = Constants.SCHEME;
        }
        d0.z.d.m.checkParameterIsNotNull(str, "host");
        String strR1 = b.i.a.f.e.o.f.r1(w$b.d(w.f3681b, str, 0, 0, false, 7));
        if (strR1 == null) {
            throw new IllegalArgumentException(b.d.b.a.a.w("unexpected host: ", str));
        }
        w_a.e = strR1;
        if (!(1 <= i && 65535 >= i)) {
            throw new IllegalArgumentException(b.d.b.a.a.q("unexpected port: ", i).toString());
        }
        w_a.f = i;
        this.a = w_a.b();
        this.f3601b = f0.e0.c.z(list);
        this.c = f0.e0.c.z(list2);
    }

    public final boolean a(a aVar) {
        d0.z.d.m.checkParameterIsNotNull(aVar, "that");
        return d0.z.d.m.areEqual(this.d, aVar.d) && d0.z.d.m.areEqual(this.i, aVar.i) && d0.z.d.m.areEqual(this.f3601b, aVar.f3601b) && d0.z.d.m.areEqual(this.c, aVar.c) && d0.z.d.m.areEqual(this.k, aVar.k) && d0.z.d.m.areEqual(this.j, aVar.j) && d0.z.d.m.areEqual(this.f, aVar.f) && d0.z.d.m.areEqual(this.g, aVar.g) && d0.z.d.m.areEqual(this.h, aVar.h) && this.a.h == aVar.a.h;
    }

    public boolean equals(Object obj) {
        if (obj instanceof a) {
            a aVar = (a) obj;
            if (d0.z.d.m.areEqual(this.a, aVar.a) && a(aVar)) {
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
        StringBuilder sbU2 = b.d.b.a.a.U("Address{");
        sbU2.append(this.a.g);
        sbU2.append(MentionUtilsKt.EMOJIS_AND_STICKERS_CHAR);
        sbU2.append(this.a.h);
        sbU2.append(", ");
        if (this.j != null) {
            sbU = b.d.b.a.a.U("proxy=");
            obj = this.j;
        } else {
            sbU = b.d.b.a.a.U("proxySelector=");
            obj = this.k;
        }
        sbU.append(obj);
        sbU2.append(sbU.toString());
        sbU2.append("}");
        return sbU2.toString();
    }
}
