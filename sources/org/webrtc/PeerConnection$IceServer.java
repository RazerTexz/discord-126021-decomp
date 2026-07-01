package org.webrtc;

import androidx.annotation.Nullable;
import b.d.b.a.a;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class PeerConnection$IceServer {
    public final String hostname;
    public final String password;
    public final List<String> tlsAlpnProtocols;
    public final PeerConnection$TlsCertPolicy tlsCertPolicy;
    public final List<String> tlsEllipticCurves;

    @Deprecated
    public final String uri;
    public final List<String> urls;
    public final String username;

    public /* synthetic */ PeerConnection$IceServer(String str, List list, String str2, String str3, PeerConnection$TlsCertPolicy peerConnection$TlsCertPolicy, String str4, List list2, List list3, PeerConnection$1 peerConnection$1) {
        this(str, list, str2, str3, peerConnection$TlsCertPolicy, str4, list2, list3);
    }

    public static PeerConnection$IceServer$Builder builder(String str) {
        return new PeerConnection$IceServer$Builder(Collections.singletonList(str), null);
    }

    public boolean equals(@Nullable Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof PeerConnection$IceServer)) {
            return false;
        }
        PeerConnection$IceServer peerConnection$IceServer = (PeerConnection$IceServer) obj;
        return this.uri.equals(peerConnection$IceServer.uri) && this.urls.equals(peerConnection$IceServer.urls) && this.username.equals(peerConnection$IceServer.username) && this.password.equals(peerConnection$IceServer.password) && this.tlsCertPolicy.equals(peerConnection$IceServer.tlsCertPolicy) && this.hostname.equals(peerConnection$IceServer.hostname) && this.tlsAlpnProtocols.equals(peerConnection$IceServer.tlsAlpnProtocols) && this.tlsEllipticCurves.equals(peerConnection$IceServer.tlsEllipticCurves);
    }

    @Nullable
    @CalledByNative("IceServer")
    public String getHostname() {
        return this.hostname;
    }

    @Nullable
    @CalledByNative("IceServer")
    public String getPassword() {
        return this.password;
    }

    @CalledByNative("IceServer")
    public List<String> getTlsAlpnProtocols() {
        return this.tlsAlpnProtocols;
    }

    @CalledByNative("IceServer")
    public PeerConnection$TlsCertPolicy getTlsCertPolicy() {
        return this.tlsCertPolicy;
    }

    @CalledByNative("IceServer")
    public List<String> getTlsEllipticCurves() {
        return this.tlsEllipticCurves;
    }

    @Nullable
    @CalledByNative("IceServer")
    public List<String> getUrls() {
        return this.urls;
    }

    @Nullable
    @CalledByNative("IceServer")
    public String getUsername() {
        return this.username;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.uri, this.urls, this.username, this.password, this.tlsCertPolicy, this.hostname, this.tlsAlpnProtocols, this.tlsEllipticCurves});
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.urls);
        sb.append(" [");
        sb.append(this.username);
        sb.append(":");
        sb.append(this.password);
        sb.append("] [");
        sb.append(this.tlsCertPolicy);
        sb.append("] [");
        sb.append(this.hostname);
        sb.append("] [");
        sb.append(this.tlsAlpnProtocols);
        sb.append("] [");
        return a.L(sb, this.tlsEllipticCurves, "]");
    }

    @Deprecated
    public PeerConnection$IceServer(String str) {
        this(str, "", "");
    }

    public static PeerConnection$IceServer$Builder builder(List<String> list) {
        return new PeerConnection$IceServer$Builder(list, null);
    }

    @Deprecated
    public PeerConnection$IceServer(String str, String str2, String str3) {
        this(str, str2, str3, PeerConnection$TlsCertPolicy.TLS_CERT_POLICY_SECURE);
    }

    @Deprecated
    public PeerConnection$IceServer(String str, String str2, String str3, PeerConnection$TlsCertPolicy peerConnection$TlsCertPolicy) {
        this(str, str2, str3, peerConnection$TlsCertPolicy, "");
    }

    @Deprecated
    public PeerConnection$IceServer(String str, String str2, String str3, PeerConnection$TlsCertPolicy peerConnection$TlsCertPolicy, String str4) {
        this(str, Collections.singletonList(str), str2, str3, peerConnection$TlsCertPolicy, str4, null, null);
    }

    private PeerConnection$IceServer(String str, List<String> list, String str2, String str3, PeerConnection$TlsCertPolicy peerConnection$TlsCertPolicy, String str4, List<String> list2, List<String> list3) {
        if (str != null && list != null && !list.isEmpty()) {
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                if (it.next() == null) {
                    throw new IllegalArgumentException("urls element is null: " + list);
                }
            }
            if (str2 == null) {
                throw new IllegalArgumentException("username == null");
            }
            if (str3 == null) {
                throw new IllegalArgumentException("password == null");
            }
            if (str4 != null) {
                this.uri = str;
                this.urls = list;
                this.username = str2;
                this.password = str3;
                this.tlsCertPolicy = peerConnection$TlsCertPolicy;
                this.hostname = str4;
                this.tlsAlpnProtocols = list2;
                this.tlsEllipticCurves = list3;
                return;
            }
            throw new IllegalArgumentException("hostname == null");
        }
        throw new IllegalArgumentException("uri == null || urls == null || urls.isEmpty()");
    }
}
