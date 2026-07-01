package org.webrtc;

import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes3.dex */
public final class PeerConnectionDependencies {
    private final PeerConnection$Observer observer;
    private final SSLCertificateVerifier sslCertificateVerifier;

    public /* synthetic */ PeerConnectionDependencies(PeerConnection$Observer peerConnection$Observer, SSLCertificateVerifier sSLCertificateVerifier, PeerConnectionDependencies$1 peerConnectionDependencies$1) {
        this(peerConnection$Observer, sSLCertificateVerifier);
    }

    public static PeerConnectionDependencies$Builder builder(PeerConnection$Observer peerConnection$Observer) {
        return new PeerConnectionDependencies$Builder(peerConnection$Observer, null);
    }

    public PeerConnection$Observer getObserver() {
        return this.observer;
    }

    @Nullable
    public SSLCertificateVerifier getSSLCertificateVerifier() {
        return this.sslCertificateVerifier;
    }

    private PeerConnectionDependencies(PeerConnection$Observer peerConnection$Observer, SSLCertificateVerifier sSLCertificateVerifier) {
        this.observer = peerConnection$Observer;
        this.sslCertificateVerifier = sSLCertificateVerifier;
    }
}
