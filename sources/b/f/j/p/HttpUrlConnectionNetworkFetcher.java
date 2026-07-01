package b.f.j.p;

import android.net.Uri;
import b.c.a.a0.AnimatableValueParser;
import b.f.d.k.MonotonicClock;
import b.f.d.l.UriUtil;
import b.f.j.j.EncodedImage2;
import com.facebook.common.time.RealtimeSinceBootClock;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Locale;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: renamed from: b.f.j.p.a0, reason: use source file name */
/* JADX INFO: compiled from: HttpUrlConnectionNetworkFetcher.java */
/* JADX INFO: loaded from: classes3.dex */
public class HttpUrlConnectionNetworkFetcher extends BaseNetworkFetcher<a> {
    public int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ExecutorService f604b;
    public final MonotonicClock c;

    /* JADX INFO: renamed from: b.f.j.p.a0$a */
    /* JADX INFO: compiled from: HttpUrlConnectionNetworkFetcher.java */
    public static class a extends FetchState2 {
        public long d;
        public long e;
        public long f;

        public a(Consumer2<EncodedImage2> consumer2, ProducerContext producerContext) {
            super(consumer2, producerContext);
        }
    }

    public HttpUrlConnectionNetworkFetcher(int i) {
        RealtimeSinceBootClock realtimeSinceBootClock = RealtimeSinceBootClock.get();
        this.f604b = Executors.newFixedThreadPool(3);
        this.c = realtimeSinceBootClock;
        this.a = i;
    }

    /* JADX WARN: Code duplicated, block: B:20:0x003c  */
    public final HttpURLConnection a(Uri uri, int i) throws IOException {
        URL url;
        boolean z2;
        Uri uri2 = UriUtil.a;
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
        httpURLConnection.setConnectTimeout(this.a);
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
        if (i <= 0 || uri3 == null || AnimatableValueParser.g0(uri3.getScheme(), scheme)) {
            throw new IOException(i == 0 ? String.format(Locale.getDefault(), "URL %s follows too many redirects", uri.toString()) : String.format(Locale.getDefault(), "URL %s returned %d without a valid redirect", uri.toString(), Integer.valueOf(responseCode)));
        }
        return a(uri3, i - 1);
    }
}
