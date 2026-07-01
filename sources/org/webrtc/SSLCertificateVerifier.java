package org.webrtc;

/* JADX INFO: loaded from: classes3.dex */
public interface SSLCertificateVerifier {
    @CalledByNative
    boolean verify(byte[] bArr);
}
