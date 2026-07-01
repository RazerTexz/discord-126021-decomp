package f0.e0.d;

import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.widgets.chat.input.MentionUtils;
import com.discord.widgets.settings.account.WidgetSettingsAccountChangePassword;
import d0.g0.StringsJVM;
import d0.t.Collections2;
import d0.t.Maps6;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import f0.Address;
import f0.Authenticator2;
import f0.Challenge;
import f0.Dns2;
import f0.HttpUrl;
import f0.Route;
import f0.e0.Util7;
import f0.e0.h.HttpHeaders;
import f0.e0.k.Platform2;
import g0.Buffer3;
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

/* JADX INFO: renamed from: f0.e0.d.b, reason: use source file name */
/* JADX INFO: compiled from: JavaNetAuthenticator.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class JavaNetAuthenticator implements Authenticator2 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Dns2 f3606b;

    public JavaNetAuthenticator(Dns2 dns2, int i) {
        Dns2 dns3 = (i & 1) != 0 ? Dns2.a : null;
        Intrinsics3.checkParameterIsNotNull(dns3, "defaultDns");
        this.f3606b = dns3;
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
    @Override // f0.Authenticator2
    public Request a(Route route, Response response) throws IOException {
        String str;
        List<Challenge> listEmptyList;
        Request request;
        HttpUrl httpUrl;
        boolean z2;
        Proxy proxy;
        Dns2 dns2;
        PasswordAuthentication passwordAuthenticationRequestPasswordAuthentication;
        String str2;
        String str3;
        Charset charsetForName;
        HttpUrl httpUrl2;
        String str4;
        RequestBody requestBody;
        Map mutableMap;
        Headers.a aVarE;
        SocketAddress socketAddressAddress;
        Address address;
        Intrinsics3.checkParameterIsNotNull(response, "response");
        Headers headers = response.headers;
        int i = response.com.discord.models.domain.ModelAuditLogEntry.CHANGE_KEY_CODE java.lang.String;
        boolean z3 = true;
        if (i != 401) {
            if (i != 407) {
                listEmptyList = Collections2.emptyList();
            } else {
                str = "Proxy-Authenticate";
            }
            request = response.request;
            httpUrl = request.url;
            z2 = response.com.discord.models.domain.ModelAuditLogEntry.CHANGE_KEY_CODE java.lang.String == 407;
            if (route != null || (proxy = route.f3603b) == null) {
                proxy = Proxy.NO_PROXY;
            }
            for (Challenge challenge : listEmptyList) {
                if (StringsJVM.equals("Basic", challenge.f3671b, z3)) {
                    if (route != null || (address = route.a) == null || (dns2 = address.d) == null) {
                        dns2 = this.f3606b;
                    }
                    if (z2) {
                        socketAddressAddress = proxy.address();
                        if (socketAddressAddress != null) {
                            throw new TypeCastException("null cannot be cast to non-null type java.net.InetSocketAddress");
                        }
                        InetSocketAddress inetSocketAddress = (InetSocketAddress) socketAddressAddress;
                        String hostName = inetSocketAddress.getHostName();
                        Intrinsics3.checkExpressionValueIsNotNull(proxy, "proxy");
                        try {
                            passwordAuthenticationRequestPasswordAuthentication = Authenticator.requestPasswordAuthentication(hostName, b(proxy, httpUrl, dns2), inetSocketAddress.getPort(), httpUrl.d, challenge.a.get("realm"), challenge.f3671b, new URL(httpUrl.l), Authenticator.RequestorType.PROXY);
                        } catch (MalformedURLException e) {
                            throw new RuntimeException(e);
                        }
                    } else {
                        String str5 = httpUrl.g;
                        Intrinsics3.checkExpressionValueIsNotNull(proxy, "proxy");
                        try {
                            passwordAuthenticationRequestPasswordAuthentication = Authenticator.requestPasswordAuthentication(str5, b(proxy, httpUrl, dns2), httpUrl.h, httpUrl.d, challenge.a.get("realm"), challenge.f3671b, new URL(httpUrl.l), Authenticator.RequestorType.SERVER);
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
                        Intrinsics3.checkExpressionValueIsNotNull(userName, "auth.userName");
                        char[] password = passwordAuthenticationRequestPasswordAuthentication.getPassword();
                        Intrinsics3.checkExpressionValueIsNotNull(password, "auth.password");
                        String str6 = new String(password);
                        str3 = challenge.a.get("charset");
                        if (str3 != null) {
                            try {
                                charsetForName = Charset.forName(str3);
                                Intrinsics3.checkExpressionValueIsNotNull(charsetForName, "Charset.forName(charset)");
                            } catch (Exception unused) {
                                charsetForName = StandardCharsets.ISO_8859_1;
                                Intrinsics3.checkExpressionValueIsNotNull(charsetForName, "ISO_8859_1");
                            }
                        } else {
                            charsetForName = StandardCharsets.ISO_8859_1;
                            Intrinsics3.checkExpressionValueIsNotNull(charsetForName, "ISO_8859_1");
                        }
                        Intrinsics3.checkParameterIsNotNull(userName, "username");
                        Intrinsics3.checkParameterIsNotNull(str6, WidgetSettingsAccountChangePassword.CURRENT_PASSWORD_FIELD);
                        Intrinsics3.checkParameterIsNotNull(charsetForName, "charset");
                        String strF = ByteString.INSTANCE.b(userName + MentionUtils.EMOJIS_AND_STICKERS_CHAR + str6, charsetForName).f();
                        StringBuilder sb = new StringBuilder();
                        sb.append("Basic ");
                        sb.append(strF);
                        String string = sb.toString();
                        Intrinsics3.checkParameterIsNotNull(request, "request");
                        new LinkedHashMap();
                        httpUrl2 = request.url;
                        str4 = request.method;
                        requestBody = request.body;
                        if (request.com.discord.models.domain.ModelAuditLogEntry.CHANGE_KEY_TAGS java.lang.String.isEmpty()) {
                            mutableMap = new LinkedHashMap();
                        } else {
                            mutableMap = Maps6.toMutableMap(request.com.discord.models.domain.ModelAuditLogEntry.CHANGE_KEY_TAGS java.lang.String);
                        }
                        aVarE = request.headers.e();
                        Intrinsics3.checkParameterIsNotNull(str2, ModelAuditLogEntry.CHANGE_KEY_NAME);
                        Intrinsics3.checkParameterIsNotNull(string, "value");
                        Intrinsics3.checkParameterIsNotNull(str2, ModelAuditLogEntry.CHANGE_KEY_NAME);
                        Intrinsics3.checkParameterIsNotNull(string, "value");
                        Headers.Companion companion = Headers.INSTANCE;
                        companion.a(str2);
                        companion.b(string, str2);
                        aVarE.d(str2);
                        aVarE.b(str2, string);
                        if (httpUrl2 != null) {
                            return new Request(httpUrl2, str4, aVarE.c(), requestBody, Util7.A(mutableMap));
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
        ByteString byteString = HttpHeaders.a;
        Intrinsics3.checkParameterIsNotNull(headers, "$this$parseChallenges");
        Intrinsics3.checkParameterIsNotNull(str7, "headerName");
        ArrayList arrayList = new ArrayList();
        int size = headers.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (StringsJVM.equals(str7, headers.d(i2), true)) {
                Buffer3 buffer3 = new Buffer3();
                buffer3.b0(headers.g(i2));
                try {
                    HttpHeaders.b(buffer3, arrayList);
                } catch (EOFException e3) {
                    Platform2.a aVar = Platform2.c;
                    Platform2.a.i("Unable to parse challenge", 5, e3);
                }
            }
        }
        listEmptyList = arrayList;
        request = response.request;
        httpUrl = request.url;
        if (response.com.discord.models.domain.ModelAuditLogEntry.CHANGE_KEY_CODE java.lang.String == 407) {
        }
        if (route != null) {
            proxy = Proxy.NO_PROXY;
        } else {
            proxy = Proxy.NO_PROXY;
        }
        while (r0.hasNext()) {
            if (StringsJVM.equals("Basic", challenge.f3671b, z3)) {
                if (route != null) {
                    dns2 = this.f3606b;
                } else {
                    dns2 = this.f3606b;
                }
                if (z2) {
                    socketAddressAddress = proxy.address();
                    if (socketAddressAddress != null) {
                        throw new TypeCastException("null cannot be cast to non-null type java.net.InetSocketAddress");
                    }
                    InetSocketAddress inetSocketAddress2 = (InetSocketAddress) socketAddressAddress;
                    String hostName2 = inetSocketAddress2.getHostName();
                    Intrinsics3.checkExpressionValueIsNotNull(proxy, "proxy");
                    passwordAuthenticationRequestPasswordAuthentication = Authenticator.requestPasswordAuthentication(hostName2, b(proxy, httpUrl, dns2), inetSocketAddress2.getPort(), httpUrl.d, challenge.a.get("realm"), challenge.f3671b, new URL(httpUrl.l), Authenticator.RequestorType.PROXY);
                } else {
                    String str8 = httpUrl.g;
                    Intrinsics3.checkExpressionValueIsNotNull(proxy, "proxy");
                    passwordAuthenticationRequestPasswordAuthentication = Authenticator.requestPasswordAuthentication(str8, b(proxy, httpUrl, dns2), httpUrl.h, httpUrl.d, challenge.a.get("realm"), challenge.f3671b, new URL(httpUrl.l), Authenticator.RequestorType.SERVER);
                }
                if (passwordAuthenticationRequestPasswordAuthentication != null) {
                    if (z2) {
                        str2 = "Proxy-Authorization";
                    } else {
                        str2 = "Authorization";
                    }
                    String userName2 = passwordAuthenticationRequestPasswordAuthentication.getUserName();
                    Intrinsics3.checkExpressionValueIsNotNull(userName2, "auth.userName");
                    char[] password2 = passwordAuthenticationRequestPasswordAuthentication.getPassword();
                    Intrinsics3.checkExpressionValueIsNotNull(password2, "auth.password");
                    String str9 = new String(password2);
                    str3 = challenge.a.get("charset");
                    if (str3 != null) {
                        charsetForName = Charset.forName(str3);
                        Intrinsics3.checkExpressionValueIsNotNull(charsetForName, "Charset.forName(charset)");
                    } else {
                        charsetForName = StandardCharsets.ISO_8859_1;
                        Intrinsics3.checkExpressionValueIsNotNull(charsetForName, "ISO_8859_1");
                    }
                    Intrinsics3.checkParameterIsNotNull(userName2, "username");
                    Intrinsics3.checkParameterIsNotNull(str9, WidgetSettingsAccountChangePassword.CURRENT_PASSWORD_FIELD);
                    Intrinsics3.checkParameterIsNotNull(charsetForName, "charset");
                    String strF2 = ByteString.INSTANCE.b(userName2 + MentionUtils.EMOJIS_AND_STICKERS_CHAR + str9, charsetForName).f();
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Basic ");
                    sb2.append(strF2);
                    String string2 = sb2.toString();
                    Intrinsics3.checkParameterIsNotNull(request, "request");
                    new LinkedHashMap();
                    httpUrl2 = request.url;
                    str4 = request.method;
                    requestBody = request.body;
                    if (request.com.discord.models.domain.ModelAuditLogEntry.CHANGE_KEY_TAGS java.lang.String.isEmpty()) {
                        mutableMap = new LinkedHashMap();
                    } else {
                        mutableMap = Maps6.toMutableMap(request.com.discord.models.domain.ModelAuditLogEntry.CHANGE_KEY_TAGS java.lang.String);
                    }
                    aVarE = request.headers.e();
                    Intrinsics3.checkParameterIsNotNull(str2, ModelAuditLogEntry.CHANGE_KEY_NAME);
                    Intrinsics3.checkParameterIsNotNull(string2, "value");
                    Intrinsics3.checkParameterIsNotNull(str2, ModelAuditLogEntry.CHANGE_KEY_NAME);
                    Intrinsics3.checkParameterIsNotNull(string2, "value");
                    Headers.Companion companion2 = Headers.INSTANCE;
                    companion2.a(str2);
                    companion2.b(string2, str2);
                    aVarE.d(str2);
                    aVarE.b(str2, string2);
                    if (httpUrl2 != null) {
                        return new Request(httpUrl2, str4, aVarE.c(), requestBody, Util7.A(mutableMap));
                    }
                    throw new IllegalStateException("url == null".toString());
                }
            }
            z3 = true;
        }
        return null;
    }

    public final InetAddress b(Proxy proxy, HttpUrl httpUrl, Dns2 dns2) throws IOException {
        Proxy.Type type = proxy.type();
        if (type != null && a.a[type.ordinal()] == 1) {
            return (InetAddress) _Collections.first((List) dns2.a(httpUrl.g));
        }
        SocketAddress socketAddressAddress = proxy.address();
        if (socketAddressAddress == null) {
            throw new TypeCastException("null cannot be cast to non-null type java.net.InetSocketAddress");
        }
        InetAddress address = ((InetSocketAddress) socketAddressAddress).getAddress();
        Intrinsics3.checkExpressionValueIsNotNull(address, "(address() as InetSocketAddress).address");
        return address;
    }
}
