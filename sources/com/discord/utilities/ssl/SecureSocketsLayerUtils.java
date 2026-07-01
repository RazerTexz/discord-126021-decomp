package com.discord.utilities.ssl;

import android.content.res.AssetManager;
import d0.y.Closeable;
import d0.z.d.Intrinsics3;
import java.io.IOException;
import java.io.InputStream;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.NoSuchAlgorithmException;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;

/* JADX INFO: compiled from: SecureSocketsLayerUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class SecureSocketsLayerUtils {
    public static final SecureSocketsLayerUtils INSTANCE = new SecureSocketsLayerUtils();

    private SecureSocketsLayerUtils() {
    }

    public static final SSLSocketFactory createSocketFactory() {
        return createSocketFactory$default(null, 1, null);
    }

    public static final SSLSocketFactory createSocketFactory(TrustManagerFactory trustManagerFactory) throws KeyManagementException {
        TrustManager[] trustManagers;
        SSLContext context$default = getContext$default(INSTANCE, null, 1, null);
        if (trustManagerFactory != null) {
            try {
                trustManagers = trustManagerFactory.getTrustManagers();
            } catch (KeyManagementException e) {
                throw e;
            }
        } else {
            trustManagers = null;
        }
        context$default.init(null, trustManagers, null);
        SSLSocketFactory socketFactory = context$default.getSocketFactory();
        Intrinsics3.checkNotNullExpressionValue(socketFactory, "sslContext.socketFactory");
        return socketFactory;
    }

    public static /* synthetic */ SSLSocketFactory createSocketFactory$default(TrustManagerFactory trustManagerFactory, int i, Object obj) {
        if ((i & 1) != 0) {
            trustManagerFactory = null;
        }
        return createSocketFactory(trustManagerFactory);
    }

    private final SSLContext getContext(String protocol) throws NoSuchAlgorithmException {
        try {
            SSLContext sSLContext = SSLContext.getInstance(protocol);
            Intrinsics3.checkNotNullExpressionValue(sSLContext, "SSLContext.getInstance(protocol)");
            return sSLContext;
        } catch (NoSuchAlgorithmException e) {
            throw e;
        }
    }

    public static /* synthetic */ SSLContext getContext$default(SecureSocketsLayerUtils secureSocketsLayerUtils, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = "TLS";
        }
        return secureSocketsLayerUtils.getContext(str);
    }

    public static final TrustManagerFactory getTrustManagerFactory(AssetManager assetManager, String certificatePath) throws NoSuchAlgorithmException, IOException {
        Intrinsics3.checkNotNullParameter(assetManager, "assetManager");
        Intrinsics3.checkNotNullParameter(certificatePath, "certificatePath");
        TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        InputStream inputStreamOpen = assetManager.open(certificatePath);
        try {
            Certificate certificateGenerateCertificate = CertificateFactory.getInstance("X.509").generateCertificate(inputStreamOpen);
            if (certificateGenerateCertificate == null) {
                throw new NullPointerException("null cannot be cast to non-null type java.security.cert.X509Certificate");
            }
            KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
            keyStore.load(null);
            keyStore.setCertificateEntry("caCert", (X509Certificate) certificateGenerateCertificate);
            trustManagerFactory.init(keyStore);
            Intrinsics3.checkNotNullExpressionValue(trustManagerFactory, "tmf");
            Closeable.closeFinally(inputStreamOpen, null);
            return trustManagerFactory;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                Closeable.closeFinally(inputStreamOpen, th);
                throw th2;
            }
        }
    }
}
