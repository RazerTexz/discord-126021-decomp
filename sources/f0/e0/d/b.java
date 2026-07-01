package f0.e0.d;

import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.widgets.chat.input.MentionUtilsKt;
import com.discord.widgets.settings.account.WidgetSettingsAccountChangePassword;
import d0.g0.t;
import d0.t.h0;
import d0.t.n;
import d0.t.u;
import d0.z.d.m;
import f0.c;
import f0.c0;
import f0.e0.h.e;
import f0.e0.k.h;
import f0.e0.k.h$a;
import f0.i;
import f0.s;
import f0.w;
import java.io.EOFException;
import java.io.IOException;
import java.net.Authenticator;
import java.net.Authenticator$RequestorType;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.PasswordAuthentication;
import java.net.Proxy;
import java.net.Proxy$Type;
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
import okhttp3.Headers$a;
import okhttp3.Headers$b;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okio.ByteString;

/* JADX INFO: compiled from: JavaNetAuthenticator.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class b implements c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final s f3606b;

    public b(s sVar, int i) {
        s sVar2 = (i & 1) != 0 ? s.a : null;
        m.checkParameterIsNotNull(sVar2, "defaultDns");
        this.f3606b = sVar2;
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
    @Override // f0.c
    public Request a(c0 c0Var, Response response) throws IOException {
        String str;
        List<i> listEmptyList;
        Request request;
        w wVar;
        boolean z2;
        Proxy proxy;
        s sVar;
        PasswordAuthentication passwordAuthenticationRequestPasswordAuthentication;
        String str2;
        String str3;
        Charset charsetForName;
        w wVar2;
        String str4;
        RequestBody requestBody;
        Map mutableMap;
        Headers$a headers$aE;
        SocketAddress socketAddressAddress;
        f0.a aVar;
        m.checkParameterIsNotNull(response, "response");
        Headers headers = response.headers;
        int i = response.com.discord.models.domain.ModelAuditLogEntry.CHANGE_KEY_CODE java.lang.String;
        boolean z3 = true;
        if (i != 401) {
            if (i != 407) {
                listEmptyList = n.emptyList();
            } else {
                str = "Proxy-Authenticate";
            }
            request = response.request;
            wVar = request.url;
            z2 = response.com.discord.models.domain.ModelAuditLogEntry.CHANGE_KEY_CODE java.lang.String == 407;
            if (c0Var != null || (proxy = c0Var.f3603b) == null) {
                proxy = Proxy.NO_PROXY;
            }
            for (i iVar : listEmptyList) {
                if (t.equals("Basic", iVar.f3671b, z3)) {
                    if (c0Var != null || (aVar = c0Var.a) == null || (sVar = aVar.d) == null) {
                        sVar = this.f3606b;
                    }
                    if (z2) {
                        socketAddressAddress = proxy.address();
                        if (socketAddressAddress != null) {
                            throw new TypeCastException("null cannot be cast to non-null type java.net.InetSocketAddress");
                        }
                        InetSocketAddress inetSocketAddress = (InetSocketAddress) socketAddressAddress;
                        String hostName = inetSocketAddress.getHostName();
                        m.checkExpressionValueIsNotNull(proxy, "proxy");
                        try {
                            passwordAuthenticationRequestPasswordAuthentication = Authenticator.requestPasswordAuthentication(hostName, b(proxy, wVar, sVar), inetSocketAddress.getPort(), wVar.d, iVar.a.get("realm"), iVar.f3671b, new URL(wVar.l), Authenticator$RequestorType.PROXY);
                        } catch (MalformedURLException e) {
                            throw new RuntimeException(e);
                        }
                    } else {
                        String str5 = wVar.g;
                        m.checkExpressionValueIsNotNull(proxy, "proxy");
                        try {
                            passwordAuthenticationRequestPasswordAuthentication = Authenticator.requestPasswordAuthentication(str5, b(proxy, wVar, sVar), wVar.h, wVar.d, iVar.a.get("realm"), iVar.f3671b, new URL(wVar.l), Authenticator$RequestorType.SERVER);
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
                        m.checkExpressionValueIsNotNull(userName, "auth.userName");
                        char[] password = passwordAuthenticationRequestPasswordAuthentication.getPassword();
                        m.checkExpressionValueIsNotNull(password, "auth.password");
                        String str6 = new String(password);
                        str3 = iVar.a.get("charset");
                        if (str3 != null) {
                            try {
                                charsetForName = Charset.forName(str3);
                                m.checkExpressionValueIsNotNull(charsetForName, "Charset.forName(charset)");
                            } catch (Exception unused) {
                                charsetForName = StandardCharsets.ISO_8859_1;
                                m.checkExpressionValueIsNotNull(charsetForName, "ISO_8859_1");
                            }
                        } else {
                            charsetForName = StandardCharsets.ISO_8859_1;
                            m.checkExpressionValueIsNotNull(charsetForName, "ISO_8859_1");
                        }
                        m.checkParameterIsNotNull(userName, "username");
                        m.checkParameterIsNotNull(str6, WidgetSettingsAccountChangePassword.CURRENT_PASSWORD_FIELD);
                        m.checkParameterIsNotNull(charsetForName, "charset");
                        String strF = ByteString.k.b(userName + MentionUtilsKt.EMOJIS_AND_STICKERS_CHAR + str6, charsetForName).f();
                        StringBuilder sb = new StringBuilder();
                        sb.append("Basic ");
                        sb.append(strF);
                        String string = sb.toString();
                        m.checkParameterIsNotNull(request, "request");
                        new LinkedHashMap();
                        wVar2 = request.url;
                        str4 = request.method;
                        requestBody = request.body;
                        if (request.com.discord.models.domain.ModelAuditLogEntry.CHANGE_KEY_TAGS java.lang.String.isEmpty()) {
                            mutableMap = new LinkedHashMap();
                        } else {
                            mutableMap = h0.toMutableMap(request.com.discord.models.domain.ModelAuditLogEntry.CHANGE_KEY_TAGS java.lang.String);
                        }
                        headers$aE = request.headers.e();
                        m.checkParameterIsNotNull(str2, ModelAuditLogEntry.CHANGE_KEY_NAME);
                        m.checkParameterIsNotNull(string, "value");
                        m.checkParameterIsNotNull(str2, ModelAuditLogEntry.CHANGE_KEY_NAME);
                        m.checkParameterIsNotNull(string, "value");
                        Headers$b headers$b = Headers.j;
                        headers$b.a(str2);
                        headers$b.b(string, str2);
                        headers$aE.d(str2);
                        headers$aE.b(str2, string);
                        if (wVar2 != null) {
                            return new Request(wVar2, str4, headers$aE.c(), requestBody, f0.e0.c.A(mutableMap));
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
        ByteString byteString = e.a;
        m.checkParameterIsNotNull(headers, "$this$parseChallenges");
        m.checkParameterIsNotNull(str7, "headerName");
        ArrayList arrayList = new ArrayList();
        int size = headers.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (t.equals(str7, headers.d(i2), true)) {
                g0.e eVar = new g0.e();
                eVar.b0(headers.g(i2));
                try {
                    e.b(eVar, arrayList);
                } catch (EOFException e3) {
                    h$a h_a = h.c;
                    h.a.i("Unable to parse challenge", 5, e3);
                }
            }
        }
        listEmptyList = arrayList;
        request = response.request;
        wVar = request.url;
        if (response.com.discord.models.domain.ModelAuditLogEntry.CHANGE_KEY_CODE java.lang.String == 407) {
        }
        if (c0Var != null) {
            proxy = Proxy.NO_PROXY;
        } else {
            proxy = Proxy.NO_PROXY;
        }
        while (r0.hasNext()) {
            if (t.equals("Basic", iVar.f3671b, z3)) {
                if (c0Var != null) {
                    sVar = this.f3606b;
                } else {
                    sVar = this.f3606b;
                }
                if (z2) {
                    socketAddressAddress = proxy.address();
                    if (socketAddressAddress != null) {
                        throw new TypeCastException("null cannot be cast to non-null type java.net.InetSocketAddress");
                    }
                    InetSocketAddress inetSocketAddress2 = (InetSocketAddress) socketAddressAddress;
                    String hostName2 = inetSocketAddress2.getHostName();
                    m.checkExpressionValueIsNotNull(proxy, "proxy");
                    passwordAuthenticationRequestPasswordAuthentication = Authenticator.requestPasswordAuthentication(hostName2, b(proxy, wVar, sVar), inetSocketAddress2.getPort(), wVar.d, iVar.a.get("realm"), iVar.f3671b, new URL(wVar.l), Authenticator$RequestorType.PROXY);
                } else {
                    String str8 = wVar.g;
                    m.checkExpressionValueIsNotNull(proxy, "proxy");
                    passwordAuthenticationRequestPasswordAuthentication = Authenticator.requestPasswordAuthentication(str8, b(proxy, wVar, sVar), wVar.h, wVar.d, iVar.a.get("realm"), iVar.f3671b, new URL(wVar.l), Authenticator$RequestorType.SERVER);
                }
                if (passwordAuthenticationRequestPasswordAuthentication != null) {
                    if (z2) {
                        str2 = "Proxy-Authorization";
                    } else {
                        str2 = "Authorization";
                    }
                    String userName2 = passwordAuthenticationRequestPasswordAuthentication.getUserName();
                    m.checkExpressionValueIsNotNull(userName2, "auth.userName");
                    char[] password2 = passwordAuthenticationRequestPasswordAuthentication.getPassword();
                    m.checkExpressionValueIsNotNull(password2, "auth.password");
                    String str9 = new String(password2);
                    str3 = iVar.a.get("charset");
                    if (str3 != null) {
                        charsetForName = Charset.forName(str3);
                        m.checkExpressionValueIsNotNull(charsetForName, "Charset.forName(charset)");
                    } else {
                        charsetForName = StandardCharsets.ISO_8859_1;
                        m.checkExpressionValueIsNotNull(charsetForName, "ISO_8859_1");
                    }
                    m.checkParameterIsNotNull(userName2, "username");
                    m.checkParameterIsNotNull(str9, WidgetSettingsAccountChangePassword.CURRENT_PASSWORD_FIELD);
                    m.checkParameterIsNotNull(charsetForName, "charset");
                    String strF2 = ByteString.k.b(userName2 + MentionUtilsKt.EMOJIS_AND_STICKERS_CHAR + str9, charsetForName).f();
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Basic ");
                    sb2.append(strF2);
                    String string2 = sb2.toString();
                    m.checkParameterIsNotNull(request, "request");
                    new LinkedHashMap();
                    wVar2 = request.url;
                    str4 = request.method;
                    requestBody = request.body;
                    if (request.com.discord.models.domain.ModelAuditLogEntry.CHANGE_KEY_TAGS java.lang.String.isEmpty()) {
                        mutableMap = new LinkedHashMap();
                    } else {
                        mutableMap = h0.toMutableMap(request.com.discord.models.domain.ModelAuditLogEntry.CHANGE_KEY_TAGS java.lang.String);
                    }
                    headers$aE = request.headers.e();
                    m.checkParameterIsNotNull(str2, ModelAuditLogEntry.CHANGE_KEY_NAME);
                    m.checkParameterIsNotNull(string2, "value");
                    m.checkParameterIsNotNull(str2, ModelAuditLogEntry.CHANGE_KEY_NAME);
                    m.checkParameterIsNotNull(string2, "value");
                    Headers$b headers$b2 = Headers.j;
                    headers$b2.a(str2);
                    headers$b2.b(string2, str2);
                    headers$aE.d(str2);
                    headers$aE.b(str2, string2);
                    if (wVar2 != null) {
                        return new Request(wVar2, str4, headers$aE.c(), requestBody, f0.e0.c.A(mutableMap));
                    }
                    throw new IllegalStateException("url == null".toString());
                }
            }
            z3 = true;
        }
        return null;
    }

    public final InetAddress b(Proxy proxy, w wVar, s sVar) throws IOException {
        Proxy$Type proxy$TypeType = proxy.type();
        if (proxy$TypeType != null && a.a[proxy$TypeType.ordinal()] == 1) {
            return (InetAddress) u.first((List) sVar.a(wVar.g));
        }
        SocketAddress socketAddressAddress = proxy.address();
        if (socketAddressAddress == null) {
            throw new TypeCastException("null cannot be cast to non-null type java.net.InetSocketAddress");
        }
        InetAddress address = ((InetSocketAddress) socketAddressAddress).getAddress();
        m.checkExpressionValueIsNotNull(address, "(address() as InetSocketAddress).address");
        return address;
    }
}
