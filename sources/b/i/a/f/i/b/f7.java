package b.i.a.f.i.b;

import androidx.annotation.WorkerThread;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
@WorkerThread
public final class f7 implements Runnable {
    public final URL j;
    public final x4 k;
    public final String l;
    public final /* synthetic */ d7 m;

    public f7(d7 d7Var, String str, URL url, x4 x4Var) {
        this.m = d7Var;
        b.c.a.a0.d.w(str);
        this.j = url;
        this.k = x4Var;
        this.l = str;
    }

    public final void a(int i, Exception exc, byte[] bArr, Map<String, List<String>> map) {
        this.m.f().v(new e7(this, i, exc, bArr, map));
    }

    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        HttpURLConnection httpURLConnectionS;
        Map<String, List<String>> headerFields;
        this.m.a();
        int responseCode = 0;
        try {
            httpURLConnectionS = this.m.s(this.j);
            try {
                responseCode = httpURLConnectionS.getResponseCode();
                headerFields = httpURLConnectionS.getHeaderFields();
                try {
                    byte[] bArrT = d7.t(httpURLConnectionS);
                    httpURLConnectionS.disconnect();
                    a(responseCode, null, bArrT, headerFields);
                } catch (IOException e) {
                    e = e;
                    if (httpURLConnectionS != null) {
                        httpURLConnectionS.disconnect();
                    }
                    a(responseCode, e, null, headerFields);
                } catch (Throwable th) {
                    th = th;
                    if (httpURLConnectionS != null) {
                        httpURLConnectionS.disconnect();
                    }
                    a(responseCode, null, null, headerFields);
                    throw th;
                }
            } catch (IOException e2) {
                e = e2;
                headerFields = null;
            } catch (Throwable th2) {
                th = th2;
                headerFields = null;
            }
        } catch (IOException e3) {
            e = e3;
            httpURLConnectionS = null;
            headerFields = null;
        } catch (Throwable th3) {
            th = th3;
            httpURLConnectionS = null;
            headerFields = null;
        }
    }
}
