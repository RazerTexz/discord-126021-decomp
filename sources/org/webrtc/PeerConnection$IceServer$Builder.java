package org.webrtc;

import androidx.annotation.Nullable;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class PeerConnection$IceServer$Builder {
    private String hostname;
    private String password;
    private List<String> tlsAlpnProtocols;
    private PeerConnection$TlsCertPolicy tlsCertPolicy;
    private List<String> tlsEllipticCurves;

    @Nullable
    private final List<String> urls;
    private String username;

    public /* synthetic */ PeerConnection$IceServer$Builder(List list, PeerConnection$1 peerConnection$1) {
        this(list);
    }

    public PeerConnection$IceServer createIceServer() {
        return new PeerConnection$IceServer(this.urls.get(0), this.urls, this.username, this.password, this.tlsCertPolicy, this.hostname, this.tlsAlpnProtocols, this.tlsEllipticCurves, null);
    }

    public PeerConnection$IceServer$Builder setHostname(String str) {
        this.hostname = str;
        return this;
    }

    public PeerConnection$IceServer$Builder setPassword(String str) {
        this.password = str;
        return this;
    }

    public PeerConnection$IceServer$Builder setTlsAlpnProtocols(List<String> list) {
        this.tlsAlpnProtocols = list;
        return this;
    }

    public PeerConnection$IceServer$Builder setTlsCertPolicy(PeerConnection$TlsCertPolicy peerConnection$TlsCertPolicy) {
        this.tlsCertPolicy = peerConnection$TlsCertPolicy;
        return this;
    }

    public PeerConnection$IceServer$Builder setTlsEllipticCurves(List<String> list) {
        this.tlsEllipticCurves = list;
        return this;
    }

    public PeerConnection$IceServer$Builder setUsername(String str) {
        this.username = str;
        return this;
    }

    private PeerConnection$IceServer$Builder(List<String> list) {
        this.username = "";
        this.password = "";
        this.tlsCertPolicy = PeerConnection$TlsCertPolicy.TLS_CERT_POLICY_SECURE;
        this.hostname = "";
        if (list != null && !list.isEmpty()) {
            this.urls = list;
            return;
        }
        throw new IllegalArgumentException("urls == null || urls.isEmpty(): " + list);
    }
}
