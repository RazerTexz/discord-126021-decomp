package p007b.p225i.p226a.p242c.p257e3;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Nullable;
import com.adjust.sdk.Constants;
import com.discord.analytics.utils.RegistrationSteps;
import com.discord.api.permission.Permission;
import com.google.android.exoplayer2.upstream.DataSourceException;
import com.google.android.exoplayer2.upstream.HttpDataSource$HttpDataSourceException;
import com.google.android.exoplayer2.upstream.HttpDataSource$InvalidResponseCodeException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.NoRouteToHostException;
import java.net.URL;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.GZIPInputStream;
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p225i.p226a.p242c.p259f3.C2738e0;
import p007b.p225i.p226a.p242c.p259f3.C2750q;
import p007b.p225i.p355b.p356a.InterfaceC4488h;

/* JADX INFO: renamed from: b.i.a.c.e3.r */
/* JADX INFO: compiled from: DefaultHttpDataSource.java */
/* JADX INFO: loaded from: classes3.dex */
public class C2716r extends AbstractC2705g implements InterfaceC2710l {

    /* JADX INFO: renamed from: e */
    public final boolean f6607e;

    /* JADX INFO: renamed from: f */
    public final int f6608f;

    /* JADX INFO: renamed from: g */
    public final int f6609g;

    /* JADX INFO: renamed from: h */
    @Nullable
    public final String f6610h;

    /* JADX INFO: renamed from: i */
    @Nullable
    public final C2719u f6611i;

    /* JADX INFO: renamed from: j */
    public final C2719u f6612j;

    /* JADX INFO: renamed from: k */
    public final boolean f6613k;

    /* JADX INFO: renamed from: l */
    @Nullable
    public InterfaceC4488h<String> f6614l;

    /* JADX INFO: renamed from: m */
    @Nullable
    public C2712n f6615m;

    /* JADX INFO: renamed from: n */
    @Nullable
    public HttpURLConnection f6616n;

    /* JADX INFO: renamed from: o */
    @Nullable
    public InputStream f6617o;

    /* JADX INFO: renamed from: p */
    public boolean f6618p;

    /* JADX INFO: renamed from: q */
    public int f6619q;

    /* JADX INFO: renamed from: r */
    public long f6620r;

    /* JADX INFO: renamed from: s */
    public long f6621s;

    /* JADX INFO: renamed from: b.i.a.c.e3.r$b */
    /* JADX INFO: compiled from: DefaultHttpDataSource.java */
    public static final class b implements InterfaceC2718t {

        /* JADX INFO: renamed from: b */
        @Nullable
        public String f6623b;

        /* JADX INFO: renamed from: a */
        public final C2719u f6622a = new C2719u();

        /* JADX INFO: renamed from: c */
        public int f6624c = 8000;

        /* JADX INFO: renamed from: d */
        public int f6625d = 8000;

        @Override // p007b.p225i.p226a.p242c.p257e3.InterfaceC2710l.a
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public C2716r mo234a() {
            return new C2716r(this.f6623b, this.f6624c, this.f6625d, false, this.f6622a, null, false, null);
        }
    }

    public C2716r(String str, int i, int i2, boolean z2, C2719u c2719u, InterfaceC4488h interfaceC4488h, boolean z3, a aVar) {
        super(true);
        this.f6610h = str;
        this.f6608f = i;
        this.f6609g = i2;
        this.f6607e = z2;
        this.f6611i = c2719u;
        this.f6614l = null;
        this.f6612j = new C2719u();
        this.f6613k = z3;
    }

    /* JADX INFO: renamed from: x */
    public static void m2866x(@Nullable HttpURLConnection httpURLConnection, long j) {
        int i;
        if (httpURLConnection == null || (i = C2738e0.f6708a) < 19 || i > 20) {
            return;
        }
        try {
            InputStream inputStream = httpURLConnection.getInputStream();
            if (j == -1) {
                if (inputStream.read() == -1) {
                    return;
                }
            } else if (j <= Permission.SEND_MESSAGES) {
                return;
            }
            String name = inputStream.getClass().getName();
            if ("com.android.okhttp.internal.http.HttpTransport$ChunkedInputStream".equals(name) || "com.android.okhttp.internal.http.HttpTransport$FixedLengthInputStream".equals(name)) {
                Class<? super Object> superclass = inputStream.getClass().getSuperclass();
                Objects.requireNonNull(superclass);
                Method declaredMethod = superclass.getDeclaredMethod("unexpectedEndOfInput", new Class[0]);
                declaredMethod.setAccessible(true);
                declaredMethod.invoke(inputStream, new Object[0]);
            }
        } catch (Exception unused) {
        }
    }

    /* JADX WARN: Code duplicated, block: B:21:0x0053  */
    /* JADX WARN: Code duplicated, block: B:78:0x01c1  */
    @Override // p007b.p225i.p226a.p242c.p257e3.InterfaceC2710l
    /* JADX INFO: renamed from: a */
    public long mo2586a(final C2712n c2712n) throws HttpDataSource$HttpDataSourceException {
        byte[] bArrM2990K;
        boolean z2;
        long j;
        long j2;
        long jMax;
        this.f6615m = c2712n;
        this.f6621s = 0L;
        this.f6620r = 0L;
        m2850r(c2712n);
        try {
            HttpURLConnection httpURLConnectionM2869v = m2869v(c2712n);
            this.f6616n = httpURLConnectionM2869v;
            this.f6619q = httpURLConnectionM2869v.getResponseCode();
            String responseMessage = httpURLConnectionM2869v.getResponseMessage();
            int i = this.f6619q;
            if (i < 200 || i > 299) {
                Map<String, List<String>> headerFields = httpURLConnectionM2869v.getHeaderFields();
                if (this.f6619q == 416) {
                    String headerField = httpURLConnectionM2869v.getHeaderField("Content-Range");
                    Pattern pattern = C2720v.f6628a;
                    if (TextUtils.isEmpty(headerField)) {
                        z2 = true;
                        j = -1;
                    } else {
                        Matcher matcher = C2720v.f6629b.matcher(headerField);
                        if (matcher.matches()) {
                            z2 = true;
                            String strGroup = matcher.group(1);
                            Objects.requireNonNull(strGroup);
                            j = Long.parseLong(strGroup);
                        } else {
                            z2 = true;
                            j = -1;
                        }
                    }
                    if (c2712n.f6547f == j) {
                        this.f6618p = z2;
                        m2851s(c2712n);
                        long j3 = c2712n.f6548g;
                        if (j3 != -1) {
                            return j3;
                        }
                        return 0L;
                    }
                }
                InputStream errorStream = httpURLConnectionM2869v.getErrorStream();
                try {
                    bArrM2990K = errorStream != null ? C2738e0.m2990K(errorStream) : C2738e0.f6713f;
                } catch (IOException unused) {
                    bArrM2990K = C2738e0.f6713f;
                }
                byte[] bArr = bArrM2990K;
                m2867t();
                throw new HttpDataSource$InvalidResponseCodeException(this.f6619q, responseMessage, this.f6619q == 416 ? new DataSourceException(2008) : null, headerFields, c2712n, bArr);
            }
            final String contentType = httpURLConnectionM2869v.getContentType();
            InterfaceC4488h<String> interfaceC4488h = this.f6614l;
            if (interfaceC4488h != null && !interfaceC4488h.apply(contentType)) {
                m2867t();
                throw new HttpDataSource$HttpDataSourceException(contentType, c2712n) { // from class: com.google.android.exoplayer2.upstream.HttpDataSource$InvalidContentTypeException
                    public final String contentType;

                    /* JADX WARN: Illegal instructions before constructor call */
                    {
                        String strValueOf = String.valueOf(contentType);
                        super(strValueOf.length() != 0 ? "Invalid content type: ".concat(strValueOf) : new String("Invalid content type: "), c2712n, 2003, 1);
                        this.contentType = contentType;
                    }
                };
            }
            if (this.f6619q == 200) {
                j2 = c2712n.f6547f;
                if (j2 == 0) {
                    j2 = 0;
                }
            } else {
                j2 = 0;
            }
            boolean zEqualsIgnoreCase = "gzip".equalsIgnoreCase(httpURLConnectionM2869v.getHeaderField("Content-Encoding"));
            if (zEqualsIgnoreCase) {
                this.f6620r = c2712n.f6548g;
            } else {
                long j4 = c2712n.f6548g;
                if (j4 != -1) {
                    this.f6620r = j4;
                } else {
                    String headerField2 = httpURLConnectionM2869v.getHeaderField("Content-Length");
                    String headerField3 = httpURLConnectionM2869v.getHeaderField("Content-Range");
                    Pattern pattern2 = C2720v.f6628a;
                    if (TextUtils.isEmpty(headerField2)) {
                        jMax = -1;
                    } else {
                        try {
                            jMax = Long.parseLong(headerField2);
                        } catch (NumberFormatException unused2) {
                            StringBuilder sb = new StringBuilder(String.valueOf(headerField2).length() + 28);
                            sb.append("Unexpected Content-Length [");
                            sb.append(headerField2);
                            sb.append("]");
                            Log.e("HttpUtil", sb.toString());
                            jMax = -1;
                        }
                    }
                    if (!TextUtils.isEmpty(headerField3)) {
                        Matcher matcher2 = C2720v.f6628a.matcher(headerField3);
                        if (matcher2.matches()) {
                            try {
                                String strGroup2 = matcher2.group(2);
                                Objects.requireNonNull(strGroup2);
                                long j5 = Long.parseLong(strGroup2);
                                String strGroup3 = matcher2.group(1);
                                Objects.requireNonNull(strGroup3);
                                long j6 = (j5 - Long.parseLong(strGroup3)) + 1;
                                if (jMax < 0) {
                                    jMax = j6;
                                } else if (jMax != j6) {
                                    StringBuilder sb2 = new StringBuilder(String.valueOf(headerField2).length() + 26 + String.valueOf(headerField3).length());
                                    sb2.append("Inconsistent headers [");
                                    sb2.append(headerField2);
                                    sb2.append("] [");
                                    sb2.append(headerField3);
                                    sb2.append("]");
                                    Log.w("HttpUtil", sb2.toString());
                                    jMax = Math.max(jMax, j6);
                                }
                            } catch (NumberFormatException unused3) {
                                StringBuilder sb3 = new StringBuilder(String.valueOf(headerField3).length() + 27);
                                sb3.append("Unexpected Content-Range [");
                                sb3.append(headerField3);
                                sb3.append("]");
                                Log.e("HttpUtil", sb3.toString());
                            }
                        }
                    }
                    this.f6620r = jMax != -1 ? jMax - j2 : -1L;
                }
            }
            try {
                this.f6617o = httpURLConnectionM2869v.getInputStream();
                if (zEqualsIgnoreCase) {
                    this.f6617o = new GZIPInputStream(this.f6617o);
                }
                this.f6618p = true;
                m2851s(c2712n);
                try {
                    m2871y(j2, c2712n);
                    return this.f6620r;
                } catch (IOException e) {
                    m2867t();
                    if (e instanceof HttpDataSource$HttpDataSourceException) {
                        throw ((HttpDataSource$HttpDataSourceException) e);
                    }
                    throw new HttpDataSource$HttpDataSourceException(e, c2712n, 2000, 1);
                }
            } catch (IOException e2) {
                m2867t();
                throw new HttpDataSource$HttpDataSourceException(e2, c2712n, 2000, 1);
            }
        } catch (IOException e3) {
            m2867t();
            throw HttpDataSource$HttpDataSourceException.m8938b(e3, c2712n, 1);
        }
    }

    @Override // p007b.p225i.p226a.p242c.p257e3.InterfaceC2710l
    public void close() throws HttpDataSource$HttpDataSourceException {
        try {
            InputStream inputStream = this.f6617o;
            if (inputStream != null) {
                long j = this.f6620r;
                long j2 = -1;
                if (j != -1) {
                    j2 = j - this.f6621s;
                }
                m2866x(this.f6616n, j2);
                try {
                    inputStream.close();
                } catch (IOException e) {
                    C2712n c2712n = this.f6615m;
                    int i = C2738e0.f6708a;
                    throw new HttpDataSource$HttpDataSourceException(e, c2712n, 2000, 3);
                }
            }
            this.f6617o = null;
            m2867t();
            if (this.f6618p) {
                this.f6618p = false;
                m2849q();
            }
        } catch (Throwable th) {
            this.f6617o = null;
            m2867t();
            if (this.f6618p) {
                this.f6618p = false;
                m2849q();
            }
            throw th;
        }
    }

    @Override // p007b.p225i.p226a.p242c.p257e3.AbstractC2705g, p007b.p225i.p226a.p242c.p257e3.InterfaceC2710l
    /* JADX INFO: renamed from: j */
    public Map<String, List<String>> mo2588j() {
        HttpURLConnection httpURLConnection = this.f6616n;
        return httpURLConnection == null ? Collections.emptyMap() : httpURLConnection.getHeaderFields();
    }

    @Override // p007b.p225i.p226a.p242c.p257e3.InterfaceC2710l
    @Nullable
    /* JADX INFO: renamed from: n */
    public Uri mo2589n() {
        HttpURLConnection httpURLConnection = this.f6616n;
        if (httpURLConnection == null) {
            return null;
        }
        return Uri.parse(httpURLConnection.getURL().toString());
    }

    /* JADX WARN: Code duplicated, block: B:15:0x002c A[Catch: IOException -> 0x001e, TRY_LEAVE, TryCatch #0 {IOException -> 0x001e, blocks: (B:4:0x0004, B:6:0x000d, B:9:0x0017, B:12:0x0020, B:15:0x002c), top: B:19:0x0004 }] */
    @Override // p007b.p225i.p226a.p242c.p257e3.InterfaceC2706h
    public int read(byte[] bArr, int i, int i2) throws HttpDataSource$HttpDataSourceException {
        int i3;
        if (i2 == 0) {
            return 0;
        }
        try {
            long j = this.f6620r;
            if (j != -1) {
                long j2 = j - this.f6621s;
                if (j2 != 0) {
                    i2 = (int) Math.min(i2, j2);
                    InputStream inputStream = this.f6617o;
                    int i4 = C2738e0.f6708a;
                    i3 = inputStream.read(bArr, i, i2);
                    if (i3 != -1) {
                        this.f6621s += (long) i3;
                        m2848p(i3);
                        return i3;
                    }
                }
            } else {
                InputStream inputStream2 = this.f6617o;
                int i5 = C2738e0.f6708a;
                i3 = inputStream2.read(bArr, i, i2);
                if (i3 != -1) {
                    this.f6621s += (long) i3;
                    m2848p(i3);
                    return i3;
                }
            }
            return -1;
        } catch (IOException e) {
            C2712n c2712n = this.f6615m;
            int i6 = C2738e0.f6708a;
            throw HttpDataSource$HttpDataSourceException.m8938b(e, c2712n, 2);
        }
    }

    /* JADX INFO: renamed from: t */
    public final void m2867t() {
        HttpURLConnection httpURLConnection = this.f6616n;
        if (httpURLConnection != null) {
            try {
                httpURLConnection.disconnect();
            } catch (Exception e) {
                C2750q.m3039b("DefaultHttpDataSource", "Unexpected error while disconnecting", e);
            }
            this.f6616n = null;
        }
    }

    /* JADX INFO: renamed from: u */
    public final URL m2868u(URL url, @Nullable String str, C2712n c2712n) throws HttpDataSource$HttpDataSourceException {
        if (str == null) {
            throw new HttpDataSource$HttpDataSourceException("Null location redirect", c2712n, 2001, 1);
        }
        try {
            URL url2 = new URL(url, str);
            String protocol = url2.getProtocol();
            if (!Constants.SCHEME.equals(protocol) && !"http".equals(protocol)) {
                String strValueOf = String.valueOf(protocol);
                throw new HttpDataSource$HttpDataSourceException(strValueOf.length() != 0 ? "Unsupported protocol redirect: ".concat(strValueOf) : new String("Unsupported protocol redirect: "), c2712n, 2001, 1);
            }
            if (this.f6607e || protocol.equals(url.getProtocol())) {
                return url2;
            }
            String protocol2 = url.getProtocol();
            StringBuilder sbM831S = C1643a.m831S(protocol.length() + C1643a.m841b(protocol2, 41), "Disallowed cross-protocol redirect (", protocol2, " to ", protocol);
            sbM831S.append(")");
            throw new HttpDataSource$HttpDataSourceException(sbM831S.toString(), c2712n, 2001, 1);
        } catch (MalformedURLException e) {
            throw new HttpDataSource$HttpDataSourceException(e, c2712n, 2001, 1);
        }
    }

    /* JADX INFO: renamed from: v */
    public final HttpURLConnection m2869v(C2712n c2712n) throws IOException {
        URL url = new URL(c2712n.f6542a.toString());
        int i = c2712n.f6544c;
        byte[] bArr = c2712n.f6545d;
        long j = c2712n.f6547f;
        long j2 = c2712n.f6548g;
        boolean zM2856c = c2712n.m2856c(1);
        if (!this.f6607e && !this.f6613k) {
            return m2870w(url, i, bArr, j, j2, zM2856c, true, c2712n.f6546e);
        }
        int i2 = 0;
        URL urlM2868u = url;
        int i3 = i;
        byte[] bArr2 = bArr;
        while (true) {
            int i4 = i2 + 1;
            if (i2 > 20) {
                throw new HttpDataSource$HttpDataSourceException(new NoRouteToHostException(C1643a.m851g(31, "Too many redirects: ", i4)), c2712n, 2001, 1);
            }
            long j3 = j;
            long j4 = j;
            int i5 = i3;
            URL url2 = urlM2868u;
            long j5 = j2;
            HttpURLConnection httpURLConnectionM2870w = m2870w(urlM2868u, i3, bArr2, j3, j2, zM2856c, false, c2712n.f6546e);
            int responseCode = httpURLConnectionM2870w.getResponseCode();
            String headerField = httpURLConnectionM2870w.getHeaderField("Location");
            if ((i5 == 1 || i5 == 3) && (responseCode == 300 || responseCode == 301 || responseCode == 302 || responseCode == 303 || responseCode == 307 || responseCode == 308)) {
                httpURLConnectionM2870w.disconnect();
                urlM2868u = m2868u(url2, headerField, c2712n);
                i3 = i5;
            } else {
                if (i5 != 2 || (responseCode != 300 && responseCode != 301 && responseCode != 302 && responseCode != 303)) {
                    return httpURLConnectionM2870w;
                }
                httpURLConnectionM2870w.disconnect();
                if (this.f6613k && responseCode == 302) {
                    i3 = i5;
                } else {
                    bArr2 = null;
                    i3 = 1;
                }
                urlM2868u = m2868u(url2, headerField, c2712n);
            }
            j = j4;
            i2 = i4;
            j2 = j5;
        }
    }

    /* JADX INFO: renamed from: w */
    public final HttpURLConnection m2870w(URL url, int i, @Nullable byte[] bArr, long j, long j2, boolean z2, boolean z3, Map<String, String> map) throws IOException {
        String string;
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setConnectTimeout(this.f6608f);
        httpURLConnection.setReadTimeout(this.f6609g);
        HashMap map2 = new HashMap();
        C2719u c2719u = this.f6611i;
        if (c2719u != null) {
            map2.putAll(c2719u.m2874a());
        }
        map2.putAll(this.f6612j.m2874a());
        map2.putAll(map);
        for (Map.Entry entry : map2.entrySet()) {
            httpURLConnection.setRequestProperty((String) entry.getKey(), (String) entry.getValue());
        }
        Pattern pattern = C2720v.f6628a;
        if (j == 0 && j2 == -1) {
            string = null;
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("bytes=");
            sb.append(j);
            sb.append("-");
            if (j2 != -1) {
                sb.append((j + j2) - 1);
            }
            string = sb.toString();
        }
        if (string != null) {
            httpURLConnection.setRequestProperty("Range", string);
        }
        String str = this.f6610h;
        if (str != null) {
            httpURLConnection.setRequestProperty("User-Agent", str);
        }
        httpURLConnection.setRequestProperty("Accept-Encoding", z2 ? "gzip" : RegistrationSteps.IDENTITY);
        httpURLConnection.setInstanceFollowRedirects(z3);
        httpURLConnection.setDoOutput(bArr != null);
        httpURLConnection.setRequestMethod(C2712n.m2854b(i));
        if (bArr != null) {
            httpURLConnection.setFixedLengthStreamingMode(bArr.length);
            httpURLConnection.connect();
            OutputStream outputStream = httpURLConnection.getOutputStream();
            outputStream.write(bArr);
            outputStream.close();
        } else {
            httpURLConnection.connect();
        }
        return httpURLConnection;
    }

    /* JADX INFO: renamed from: y */
    public final void m2871y(long j, C2712n c2712n) throws IOException {
        if (j == 0) {
            return;
        }
        byte[] bArr = new byte[4096];
        while (j > 0) {
            int iMin = (int) Math.min(j, 4096);
            InputStream inputStream = this.f6617o;
            int i = C2738e0.f6708a;
            int i2 = inputStream.read(bArr, 0, iMin);
            if (Thread.currentThread().isInterrupted()) {
                throw new HttpDataSource$HttpDataSourceException(new InterruptedIOException(), c2712n, 2000, 1);
            }
            if (i2 == -1) {
                throw new HttpDataSource$HttpDataSourceException(c2712n, 2008, 1);
            }
            j -= (long) i2;
            m2848p(i2);
        }
    }
}
