package p007b.p109f.p161j.p181p;

import android.net.Uri;
import com.facebook.common.time.RealtimeSinceBootClock;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Locale;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p109f.p115d.p126k.InterfaceC1714b;
import p007b.p109f.p115d.p127l.C1717b;
import p007b.p109f.p161j.p175j.C1919e;

/* JADX INFO: renamed from: b.f.j.p.a0 */
/* JADX INFO: compiled from: HttpUrlConnectionNetworkFetcher.java */
/* JADX INFO: loaded from: classes3.dex */
public class C1963a0 extends AbstractC1968c<a> {

    /* JADX INFO: renamed from: a */
    public int f3987a;

    /* JADX INFO: renamed from: b */
    public final ExecutorService f3988b;

    /* JADX INFO: renamed from: c */
    public final InterfaceC1714b f3989c;

    /* JADX INFO: renamed from: b.f.j.p.a0$a */
    /* JADX INFO: compiled from: HttpUrlConnectionNetworkFetcher.java */
    public static class a extends C2019x {

        /* JADX INFO: renamed from: d */
        public long f3990d;

        /* JADX INFO: renamed from: e */
        public long f3991e;

        /* JADX INFO: renamed from: f */
        public long f3992f;

        public a(InterfaceC1995l<C1919e> interfaceC1995l, InterfaceC2020x0 interfaceC2020x0) {
            super(interfaceC1995l, interfaceC2020x0);
        }
    }

    public C1963a0(int i) {
        RealtimeSinceBootClock realtimeSinceBootClock = RealtimeSinceBootClock.get();
        this.f3988b = Executors.newFixedThreadPool(3);
        this.f3989c = realtimeSinceBootClock;
        this.f3987a = i;
    }

    /* JADX WARN: Code duplicated, block: B:20:0x003c  */
    /* JADX INFO: renamed from: a */
    public final HttpURLConnection m1418a(Uri uri, int i) throws IOException {
        URL url;
        boolean z2;
        Uri uri2 = C1717b.f3138a;
        if (uri == null) {
            url = null;
        } else {
            try {
                url = new URL(uri.toString());
            } catch (MalformedURLException e) {
                throw new RuntimeException(e);
            }
        }
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setConnectTimeout(this.f3987a);
        int responseCode = httpURLConnection.getResponseCode();
        if (responseCode >= 200 && responseCode < 300) {
            return httpURLConnection;
        }
        if (responseCode != 307 && responseCode != 308) {
            switch (responseCode) {
                case 300:
                case 301:
                case 302:
                case 303:
                    z2 = true;
                    break;
                default:
                    z2 = false;
                    break;
            }
        } else {
            z2 = true;
        }
        if (!z2) {
            httpURLConnection.disconnect();
            throw new IOException(String.format("Image URL %s returned HTTP code %d", uri.toString(), Integer.valueOf(responseCode)));
        }
        String headerField = httpURLConnection.getHeaderField("Location");
        httpURLConnection.disconnect();
        Uri uri3 = headerField != null ? Uri.parse(headerField) : null;
        String scheme = uri.getScheme();
        if (i <= 0 || uri3 == null || C1460d.m520g0(uri3.getScheme(), scheme)) {
            throw new IOException(i == 0 ? String.format(Locale.getDefault(), "URL %s follows too many redirects", uri.toString()) : String.format(Locale.getDefault(), "URL %s returned %d without a valid redirect", uri.toString(), Integer.valueOf(responseCode)));
        }
        return m1418a(uri3, i - 1);
    }
}
