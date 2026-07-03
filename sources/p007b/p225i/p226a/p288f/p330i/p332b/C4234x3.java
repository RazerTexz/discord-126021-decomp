package p007b.p225i.p226a.p288f.p330i.p332b;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import androidx.annotation.WorkerThread;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

/* JADX INFO: renamed from: b.i.a.f.i.b.x3 */
/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class C4234x3 extends AbstractC4074i9 {
    public C4234x3(C4097k9 c4097k9) {
        super(c4097k9);
    }

    /* JADX INFO: renamed from: t */
    public static byte[] m5961t(HttpURLConnection httpURLConnection) throws IOException {
        InputStream inputStream = null;
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            inputStream = httpURLConnection.getInputStream();
            byte[] bArr = new byte[1024];
            while (true) {
                int i = inputStream.read(bArr);
                if (i <= 0) {
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    inputStream.close();
                    return byteArray;
                }
                byteArrayOutputStream.write(bArr, 0, i);
            }
        } catch (Throwable th) {
            if (inputStream != null) {
                inputStream.close();
            }
            throw th;
        }
    }

    @Override // p007b.p225i.p226a.p288f.p330i.p332b.AbstractC4074i9
    /* JADX INFO: renamed from: p */
    public final boolean mo5515p() {
        return false;
    }

    @WorkerThread
    /* JADX INFO: renamed from: s */
    public final HttpURLConnection m5962s(URL url) throws IOException {
        URLConnection uRLConnectionOpenConnection = url.openConnection();
        if (!(uRLConnectionOpenConnection instanceof HttpURLConnection)) {
            throw new IOException("Failed to obtain HTTP connection");
        }
        HttpURLConnection httpURLConnection = (HttpURLConnection) uRLConnectionOpenConnection;
        httpURLConnection.setDefaultUseCaches(false);
        httpURLConnection.setConnectTimeout(60000);
        httpURLConnection.setReadTimeout(61000);
        httpURLConnection.setInstanceFollowRedirects(false);
        httpURLConnection.setDoInput(true);
        return httpURLConnection;
    }

    /* JADX INFO: renamed from: u */
    public final boolean m5963u() {
        m5684n();
        NetworkInfo activeNetworkInfo = null;
        try {
            activeNetworkInfo = ((ConnectivityManager) this.f11202a.f11254b.getSystemService("connectivity")).getActiveNetworkInfo();
        } catch (SecurityException unused) {
        }
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }
}
