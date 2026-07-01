package org.webrtc;

/* JADX INFO: loaded from: classes3.dex */
public class PeerConnectionDependencies$Builder {
    private PeerConnection$Observer observer;
    private SSLCertificateVerifier sslCertificateVerifier;

    public /* synthetic */ PeerConnectionDependencies$Builder(PeerConnection$Observer peerConnection$Observer, PeerConnectionDependencies$1 peerConnectionDependencies$1) {
        this(peerConnection$Observer);
    }

    public PeerConnectionDependencies createPeerConnectionDependencies() {
        return new PeerConnectionDependencies(this.observer, this.sslCertificateVerifier, null);
    }

    public PeerConnectionDependencies$Builder setSSLCertificateVerifier(SSLCertificateVerifier sSLCertificateVerifier) {
        this.sslCertificateVerifier = sSLCertificateVerifier;
        return this;
    }

    private PeerConnectionDependencies$Builder(PeerConnection$Observer peerConnection$Observer) {
        this.observer = peerConnection$Observer;
    }
}
