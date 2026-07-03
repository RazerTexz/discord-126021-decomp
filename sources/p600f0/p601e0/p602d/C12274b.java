package p600f0.p601e0.p602d;

import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.widgets.chat.input.MentionUtilsKt;
import com.discord.widgets.settings.account.WidgetSettingsAccountChangePassword;
import java.io.EOFException;
import java.io.IOException;
import java.net.Authenticator;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.PasswordAuthentication;
import java.net.Proxy;
import java.net.SocketAddress;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.TypeCastException;
import okhttp3.Headers;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okio.ByteString;
import p507d0.p579g0.C12103t;
import p507d0.p580t.C12136h0;
import p507d0.p580t.C12147n;
import p507d0.p580t.C12163u;
import p507d0.p592z.p594d.C12238m;
import p600f0.C12261a;
import p600f0.C12266c0;
import p600f0.C12365i;
import p600f0.C12379w;
import p600f0.InterfaceC12265c;
import p600f0.InterfaceC12375s;
import p600f0.p601e0.C12272c;
import p600f0.p601e0.p606h.C12299e;
import p600f0.p601e0.p609k.C12333h;
import p615g0.C12388e;

/* JADX INFO: renamed from: f0.e0.d.b */
/* JADX INFO: compiled from: JavaNetAuthenticator.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C12274b implements InterfaceC12265c {

    /* JADX INFO: renamed from: b */
    public final InterfaceC12375s f25405b;

    public C12274b(InterfaceC12375s interfaceC12375s, int i) {
        InterfaceC12375s interfaceC12375s2 = (i & 1) != 0 ? InterfaceC12375s.f25961a : null;
        C12238m.checkParameterIsNotNull(interfaceC12375s2, "defaultDns");
        this.f25405b = interfaceC12375s2;
    }

    /* JADX WARN: Code duplicated, block: B:21:0x006f  */
    /* JADX WARN: Code duplicated, block: B:26:0x0077  */
    /* JADX WARN: Code duplicated, block: B:30:0x0083  */
    /* JADX WARN: Code duplicated, block: B:33:0x0095  */
    /* JADX WARN: Code duplicated, block: B:39:0x00a0  */
    /* JADX WARN: Code duplicated, block: B:42:0x00a8  */
    /* JADX WARN: Code duplicated, block: B:44:0x00ae  */
    /* JADX WARN: Code duplicated, block: B:52:0x00ee  */
    /* JADX WARN: Code duplicated, block: B:57:0x0119  */
    /* JADX WARN: Code duplicated, block: B:58:0x011c  */
    /* JADX WARN: Code duplicated, block: B:63:0x014b  */
    /* JADX WARN: Code duplicated, block: B:66:0x01a6  */
    /* JADX WARN: Code duplicated, block: B:67:0x01ac  */
    /* JADX WARN: Code duplicated, block: B:70:0x01d8  */
    /* JADX WARN: Code duplicated, block: B:72:0x01e7  */
    /* JADX WARN: Code duplicated, block: B:81:0x0141 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:89:0x00e6 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:90:0x0117 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:92:0x01f3 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:93:0x01f3 A[SYNTHETIC] */
    @Override // p600f0.InterfaceC12265c
    /* JADX INFO: renamed from: a */
    public Request mo10102a(C12266c0 c12266c0, Response response) throws IOException {
        String str;
        List<C12365i> listEmptyList;
        Request request;
        C12379w c12379w;
        boolean z2;
        Proxy proxy;
        InterfaceC12375s interfaceC12375s;
        PasswordAuthentication passwordAuthenticationRequestPasswordAuthentication;
        String str2;
        String str3;
        Charset charsetForName;
        C12379w c12379w2;
        String str4;
        RequestBody requestBody;
        Map mutableMap;
        Headers.C12930a c12930aM10956e;
        SocketAddress socketAddressAddress;
        C12261a c12261a;
        C12238m.checkParameterIsNotNull(response, "response");
        Headers headers = response.headers;
        int i = response.com.discord.models.domain.ModelAuditLogEntry.CHANGE_KEY_CODE java.lang.String;
        boolean z3 = true;
        if (i != 401) {
            if (i != 407) {
                listEmptyList = C12147n.emptyList();
            } else {
                str = "Proxy-Authenticate";
            }
            request = response.request;
            c12379w = request.url;
            z2 = response.com.discord.models.domain.ModelAuditLogEntry.CHANGE_KEY_CODE java.lang.String == 407;
            if (c12266c0 != null || (proxy = c12266c0.f25371b) == null) {
                proxy = Proxy.NO_PROXY;
            }
            for (C12365i c12365i : listEmptyList) {
                if (C12103t.equals("Basic", c12365i.f25908b, z3)) {
                    if (c12266c0 != null || (c12261a = c12266c0.f25370a) == null || (interfaceC12375s = c12261a.f25356d) == null) {
                        interfaceC12375s = this.f25405b;
                    }
                    if (z2) {
                        socketAddressAddress = proxy.address();
                        if (socketAddressAddress != null) {
                            throw new TypeCastException("null cannot be cast to non-null type java.net.InetSocketAddress");
                        }
                        InetSocketAddress inetSocketAddress = (InetSocketAddress) socketAddressAddress;
                        String hostName = inetSocketAddress.getHostName();
                        C12238m.checkExpressionValueIsNotNull(proxy, "proxy");
                        try {
                            passwordAuthenticationRequestPasswordAuthentication = Authenticator.requestPasswordAuthentication(hostName, m10146b(proxy, c12379w, interfaceC12375s), inetSocketAddress.getPort(), c12379w.f25976d, c12365i.f25907a.get("realm"), c12365i.f25908b, new URL(c12379w.f25984l), Authenticator.RequestorType.PROXY);
                        } catch (MalformedURLException e) {
                            throw new RuntimeException(e);
                        }
                    } else {
                        String str5 = c12379w.f25979g;
                        C12238m.checkExpressionValueIsNotNull(proxy, "proxy");
                        try {
                            passwordAuthenticationRequestPasswordAuthentication = Authenticator.requestPasswordAuthentication(str5, m10146b(proxy, c12379w, interfaceC12375s), c12379w.f25980h, c12379w.f25976d, c12365i.f25907a.get("realm"), c12365i.f25908b, new URL(c12379w.f25984l), Authenticator.RequestorType.SERVER);
                        } catch (MalformedURLException e2) {
                            throw new RuntimeException(e2);
                        }
                    }
                    if (passwordAuthenticationRequestPasswordAuthentication != null) {
                        if (z2) {
                            str2 = "Proxy-Authorization";
                        } else {
                            str2 = "Authorization";
                        }
                        String userName = passwordAuthenticationRequestPasswordAuthentication.getUserName();
                        C12238m.checkExpressionValueIsNotNull(userName, "auth.userName");
                        char[] password = passwordAuthenticationRequestPasswordAuthentication.getPassword();
                        C12238m.checkExpressionValueIsNotNull(password, "auth.password");
                        String str6 = new String(password);
                        str3 = c12365i.f25907a.get("charset");
                        if (str3 != null) {
                            try {
                                charsetForName = Charset.forName(str3);
                                C12238m.checkExpressionValueIsNotNull(charsetForName, "Charset.forName(charset)");
                            } catch (Exception unused) {
                                charsetForName = StandardCharsets.ISO_8859_1;
                                C12238m.checkExpressionValueIsNotNull(charsetForName, "ISO_8859_1");
                            }
                        } else {
                            charsetForName = StandardCharsets.ISO_8859_1;
                            C12238m.checkExpressionValueIsNotNull(charsetForName, "ISO_8859_1");
                        }
                        C12238m.checkParameterIsNotNull(userName, "username");
                        C12238m.checkParameterIsNotNull(str6, WidgetSettingsAccountChangePassword.CURRENT_PASSWORD_FIELD);
                        C12238m.checkParameterIsNotNull(charsetForName, "charset");
                        String strMo10500f = ByteString.INSTANCE.m11011b(userName + MentionUtilsKt.EMOJIS_AND_STICKERS_CHAR + str6, charsetForName).mo10500f();
                        StringBuilder sb = new StringBuilder();
                        sb.append("Basic ");
                        sb.append(strMo10500f);
                        String string = sb.toString();
                        C12238m.checkParameterIsNotNull(request, "request");
                        new LinkedHashMap();
                        c12379w2 = request.url;
                        str4 = request.method;
                        requestBody = request.body;
                        if (request.com.discord.models.domain.ModelAuditLogEntry.CHANGE_KEY_TAGS java.lang.String.isEmpty()) {
                            mutableMap = new LinkedHashMap();
                        } else {
                            mutableMap = C12136h0.toMutableMap(request.com.discord.models.domain.ModelAuditLogEntry.CHANGE_KEY_TAGS java.lang.String);
                        }
                        c12930aM10956e = request.headers.m10956e();
                        C12238m.checkParameterIsNotNull(str2, ModelAuditLogEntry.CHANGE_KEY_NAME);
                        C12238m.checkParameterIsNotNull(string, "value");
                        C12238m.checkParameterIsNotNull(str2, ModelAuditLogEntry.CHANGE_KEY_NAME);
                        C12238m.checkParameterIsNotNull(string, "value");
                        Headers.Companion companion = Headers.INSTANCE;
                        companion.m10962a(str2);
                        companion.m10963b(string, str2);
                        c12930aM10956e.m10961d(str2);
                        c12930aM10956e.m10959b(str2, string);
                        if (c12379w2 != null) {
                            return new Request(c12379w2, str4, c12930aM10956e.m10960c(), requestBody, C12272c.m10116A(mutableMap));
                        }
                        throw new IllegalStateException("url == null".toString());
                    }
                }
                z3 = true;
            }
            return null;
        }
        str = "WWW-Authenticate";
        String str7 = str;
        ByteString byteString = C12299e.f25529a;
        C12238m.checkParameterIsNotNull(headers, "$this$parseChallenges");
        C12238m.checkParameterIsNotNull(str7, "headerName");
        ArrayList arrayList = new ArrayList();
        int size = headers.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (C12103t.equals(str7, headers.m10955d(i2), true)) {
                C12388e c12388e = new C12388e();
                c12388e.m10452b0(headers.m10957g(i2));
                try {
                    C12299e.m10222b(c12388e, arrayList);
                } catch (EOFException e3) {
                    C12333h.a aVar = C12333h.f25785c;
                    C12333h.f25783a.m10330i("Unable to parse challenge", 5, e3);
                }
            }
        }
        listEmptyList = arrayList;
        request = response.request;
        c12379w = request.url;
        if (response.com.discord.models.domain.ModelAuditLogEntry.CHANGE_KEY_CODE java.lang.String == 407) {
        }
        if (c12266c0 != null) {
            proxy = Proxy.NO_PROXY;
        } else {
            proxy = Proxy.NO_PROXY;
        }
        while (r0.hasNext()) {
            if (C12103t.equals("Basic", c12365i.f25908b, z3)) {
                if (c12266c0 != null) {
                    interfaceC12375s = this.f25405b;
                } else {
                    interfaceC12375s = this.f25405b;
                }
                if (z2) {
                    socketAddressAddress = proxy.address();
                    if (socketAddressAddress != null) {
                        throw new TypeCastException("null cannot be cast to non-null type java.net.InetSocketAddress");
                    }
                    InetSocketAddress inetSocketAddress2 = (InetSocketAddress) socketAddressAddress;
                    String hostName2 = inetSocketAddress2.getHostName();
                    C12238m.checkExpressionValueIsNotNull(proxy, "proxy");
                    passwordAuthenticationRequestPasswordAuthentication = Authenticator.requestPasswordAuthentication(hostName2, m10146b(proxy, c12379w, interfaceC12375s), inetSocketAddress2.getPort(), c12379w.f25976d, c12365i.f25907a.get("realm"), c12365i.f25908b, new URL(c12379w.f25984l), Authenticator.RequestorType.PROXY);
                } else {
                    String str8 = c12379w.f25979g;
                    C12238m.checkExpressionValueIsNotNull(proxy, "proxy");
                    passwordAuthenticationRequestPasswordAuthentication = Authenticator.requestPasswordAuthentication(str8, m10146b(proxy, c12379w, interfaceC12375s), c12379w.f25980h, c12379w.f25976d, c12365i.f25907a.get("realm"), c12365i.f25908b, new URL(c12379w.f25984l), Authenticator.RequestorType.SERVER);
                }
                if (passwordAuthenticationRequestPasswordAuthentication != null) {
                    if (z2) {
                        str2 = "Proxy-Authorization";
                    } else {
                        str2 = "Authorization";
                    }
                    String userName2 = passwordAuthenticationRequestPasswordAuthentication.getUserName();
                    C12238m.checkExpressionValueIsNotNull(userName2, "auth.userName");
                    char[] password2 = passwordAuthenticationRequestPasswordAuthentication.getPassword();
                    C12238m.checkExpressionValueIsNotNull(password2, "auth.password");
                    String str9 = new String(password2);
                    str3 = c12365i.f25907a.get("charset");
                    if (str3 != null) {
                        charsetForName = Charset.forName(str3);
                        C12238m.checkExpressionValueIsNotNull(charsetForName, "Charset.forName(charset)");
                    } else {
                        charsetForName = StandardCharsets.ISO_8859_1;
                        C12238m.checkExpressionValueIsNotNull(charsetForName, "ISO_8859_1");
                    }
                    C12238m.checkParameterIsNotNull(userName2, "username");
                    C12238m.checkParameterIsNotNull(str9, WidgetSettingsAccountChangePassword.CURRENT_PASSWORD_FIELD);
                    C12238m.checkParameterIsNotNull(charsetForName, "charset");
                    String strMo10500f2 = ByteString.INSTANCE.m11011b(userName2 + MentionUtilsKt.EMOJIS_AND_STICKERS_CHAR + str9, charsetForName).mo10500f();
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Basic ");
                    sb2.append(strMo10500f2);
                    String string2 = sb2.toString();
                    C12238m.checkParameterIsNotNull(request, "request");
                    new LinkedHashMap();
                    c12379w2 = request.url;
                    str4 = request.method;
                    requestBody = request.body;
                    if (request.com.discord.models.domain.ModelAuditLogEntry.CHANGE_KEY_TAGS java.lang.String.isEmpty()) {
                        mutableMap = new LinkedHashMap();
                    } else {
                        mutableMap = C12136h0.toMutableMap(request.com.discord.models.domain.ModelAuditLogEntry.CHANGE_KEY_TAGS java.lang.String);
                    }
                    c12930aM10956e = request.headers.m10956e();
                    C12238m.checkParameterIsNotNull(str2, ModelAuditLogEntry.CHANGE_KEY_NAME);
                    C12238m.checkParameterIsNotNull(string2, "value");
                    C12238m.checkParameterIsNotNull(str2, ModelAuditLogEntry.CHANGE_KEY_NAME);
                    C12238m.checkParameterIsNotNull(string2, "value");
                    Headers.Companion companion2 = Headers.INSTANCE;
                    companion2.m10962a(str2);
                    companion2.m10963b(string2, str2);
                    c12930aM10956e.m10961d(str2);
                    c12930aM10956e.m10959b(str2, string2);
                    if (c12379w2 != null) {
                        return new Request(c12379w2, str4, c12930aM10956e.m10960c(), requestBody, C12272c.m10116A(mutableMap));
                    }
                    throw new IllegalStateException("url == null".toString());
                }
            }
            z3 = true;
        }
        return null;
    }

    /* JADX INFO: renamed from: b */
    public final InetAddress m10146b(Proxy proxy, C12379w c12379w, InterfaceC12375s interfaceC12375s) throws IOException {
        Proxy.Type type = proxy.type();
        if (type != null && C12273a.f25404a[type.ordinal()] == 1) {
            return (InetAddress) C12163u.first((List) interfaceC12375s.mo10392a(c12379w.f25979g));
        }
        SocketAddress socketAddressAddress = proxy.address();
        if (socketAddressAddress == null) {
            throw new TypeCastException("null cannot be cast to non-null type java.net.InetSocketAddress");
        }
        InetAddress address = ((InetSocketAddress) socketAddressAddress).getAddress();
        C12238m.checkExpressionValueIsNotNull(address, "(address() as InetSocketAddress).address");
        return address;
    }
}
