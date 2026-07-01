package org.webrtc;

/* JADX INFO: loaded from: classes3.dex */
public class RtcCertificatePem {
    private static final long DEFAULT_EXPIRY = 2592000;
    public final String certificate;
    public final String privateKey;

    @CalledByNative
    public RtcCertificatePem(String str, String str2) {
        this.privateKey = str;
        this.certificate = str2;
    }

    public static RtcCertificatePem generateCertificate() {
        return nativeGenerateCertificate(PeerConnection$KeyType.ECDSA, DEFAULT_EXPIRY);
    }

    private static native RtcCertificatePem nativeGenerateCertificate(PeerConnection$KeyType peerConnection$KeyType, long j);

    @CalledByNative
    public String getCertificate() {
        return this.certificate;
    }

    @CalledByNative
    public String getPrivateKey() {
        return this.privateKey;
    }

    public static RtcCertificatePem generateCertificate(PeerConnection$KeyType peerConnection$KeyType) {
        return nativeGenerateCertificate(peerConnection$KeyType, DEFAULT_EXPIRY);
    }

    public static RtcCertificatePem generateCertificate(long j) {
        return nativeGenerateCertificate(PeerConnection$KeyType.ECDSA, j);
    }

    public static RtcCertificatePem generateCertificate(PeerConnection$KeyType peerConnection$KeyType, long j) {
        return nativeGenerateCertificate(peerConnection$KeyType, j);
    }
}
