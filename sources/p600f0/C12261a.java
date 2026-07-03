package p600f0;

import com.adjust.sdk.Constants;
import com.discord.widgets.chat.input.MentionUtilsKt;
import java.net.Proxy;
import java.net.ProxySelector;
import java.util.List;
import java.util.Objects;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p507d0.p579g0.C12103t;
import p507d0.p592z.p594d.C12238m;
import p600f0.C12379w;
import p600f0.p601e0.C12272c;

/* JADX INFO: renamed from: f0.a */
/* JADX INFO: compiled from: Address.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C12261a {

    /* JADX INFO: renamed from: a */
    public final C12379w f25353a;

    /* JADX INFO: renamed from: b */
    public final List<EnumC12381y> f25354b;

    /* JADX INFO: renamed from: c */
    public final List<C12369m> f25355c;

    /* JADX INFO: renamed from: d */
    public final InterfaceC12375s f25356d;

    /* JADX INFO: renamed from: e */
    public final SocketFactory f25357e;

    /* JADX INFO: renamed from: f */
    public final SSLSocketFactory f25358f;

    /* JADX INFO: renamed from: g */
    public final HostnameVerifier f25359g;

    /* JADX INFO: renamed from: h */
    public final C12363g f25360h;

    /* JADX INFO: renamed from: i */
    public final InterfaceC12265c f25361i;

    /* JADX INFO: renamed from: j */
    public final Proxy f25362j;

    /* JADX INFO: renamed from: k */
    public final ProxySelector f25363k;

    public C12261a(String str, int i, InterfaceC12375s interfaceC12375s, SocketFactory socketFactory, SSLSocketFactory sSLSocketFactory, HostnameVerifier hostnameVerifier, C12363g c12363g, InterfaceC12265c interfaceC12265c, Proxy proxy, List<? extends EnumC12381y> list, List<C12369m> list2, ProxySelector proxySelector) {
        C12238m.checkParameterIsNotNull(str, "uriHost");
        C12238m.checkParameterIsNotNull(interfaceC12375s, "dns");
        C12238m.checkParameterIsNotNull(socketFactory, "socketFactory");
        C12238m.checkParameterIsNotNull(interfaceC12265c, "proxyAuthenticator");
        C12238m.checkParameterIsNotNull(list, "protocols");
        C12238m.checkParameterIsNotNull(list2, "connectionSpecs");
        C12238m.checkParameterIsNotNull(proxySelector, "proxySelector");
        this.f25356d = interfaceC12375s;
        this.f25357e = socketFactory;
        this.f25358f = sSLSocketFactory;
        this.f25359g = hostnameVerifier;
        this.f25360h = c12363g;
        this.f25361i = interfaceC12265c;
        this.f25362j = proxy;
        this.f25363k = proxySelector;
        C12379w.a aVar = new C12379w.a();
        String str2 = sSLSocketFactory != null ? Constants.SCHEME : "http";
        C12238m.checkParameterIsNotNull(str2, "scheme");
        if (C12103t.equals(str2, "http", true)) {
            aVar.f25986b = "http";
        } else {
            if (!C12103t.equals(str2, Constants.SCHEME, true)) {
                throw new IllegalArgumentException(C1643a.m883w("unexpected scheme: ", str2));
            }
            aVar.f25986b = Constants.SCHEME;
        }
        C12238m.checkParameterIsNotNull(str, "host");
        String strM4337r1 = C3404f.m4337r1(C12379w.b.m10414d(C12379w.f25974b, str, 0, 0, false, 7));
        if (strM4337r1 == null) {
            throw new IllegalArgumentException(C1643a.m883w("unexpected host: ", str));
        }
        aVar.f25989e = strM4337r1;
        if (!(1 <= i && 65535 >= i)) {
            throw new IllegalArgumentException(C1643a.m871q("unexpected port: ", i).toString());
        }
        aVar.f25990f = i;
        this.f25353a = aVar.m10409b();
        this.f25354b = C12272c.m10145z(list);
        this.f25355c = C12272c.m10145z(list2);
    }

    /* JADX INFO: renamed from: a */
    public final boolean m10101a(C12261a c12261a) {
        C12238m.checkParameterIsNotNull(c12261a, "that");
        return C12238m.areEqual(this.f25356d, c12261a.f25356d) && C12238m.areEqual(this.f25361i, c12261a.f25361i) && C12238m.areEqual(this.f25354b, c12261a.f25354b) && C12238m.areEqual(this.f25355c, c12261a.f25355c) && C12238m.areEqual(this.f25363k, c12261a.f25363k) && C12238m.areEqual(this.f25362j, c12261a.f25362j) && C12238m.areEqual(this.f25358f, c12261a.f25358f) && C12238m.areEqual(this.f25359g, c12261a.f25359g) && C12238m.areEqual(this.f25360h, c12261a.f25360h) && this.f25353a.f25980h == c12261a.f25353a.f25980h;
    }

    public boolean equals(Object obj) {
        if (obj instanceof C12261a) {
            C12261a c12261a = (C12261a) obj;
            if (C12238m.areEqual(this.f25353a, c12261a.f25353a) && m10101a(c12261a)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return Objects.hashCode(this.f25360h) + ((Objects.hashCode(this.f25359g) + ((Objects.hashCode(this.f25358f) + ((Objects.hashCode(this.f25362j) + ((this.f25363k.hashCode() + ((this.f25355c.hashCode() + ((this.f25354b.hashCode() + ((this.f25361i.hashCode() + ((this.f25356d.hashCode() + ((this.f25353a.hashCode() + 527) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31);
    }

    public String toString() {
        StringBuilder sbM833U;
        Object obj;
        StringBuilder sbM833U2 = C1643a.m833U("Address{");
        sbM833U2.append(this.f25353a.f25979g);
        sbM833U2.append(MentionUtilsKt.EMOJIS_AND_STICKERS_CHAR);
        sbM833U2.append(this.f25353a.f25980h);
        sbM833U2.append(", ");
        if (this.f25362j != null) {
            sbM833U = C1643a.m833U("proxy=");
            obj = this.f25362j;
        } else {
            sbM833U = C1643a.m833U("proxySelector=");
            obj = this.f25363k;
        }
        sbM833U.append(obj);
        sbM833U2.append(sbM833U.toString());
        sbM833U2.append("}");
        return sbM833U2.toString();
    }
}
