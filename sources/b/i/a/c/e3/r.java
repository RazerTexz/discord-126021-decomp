package b.i.a.c.e3;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Nullable;
import b.i.a.c.f3.e0;
import com.adjust.sdk.Constants;
import com.discord.analytics.utils.RegistrationSteps;
import com.discord.api.permission.Permission;
import com.google.android.exoplayer2.upstream.DataSourceException;
import com.google.android.exoplayer2.upstream.HttpDataSource$HttpDataSourceException;
import com.google.android.exoplayer2.upstream.HttpDataSource$InvalidContentTypeException;
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
import java.util.Map$Entry;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.GZIPInputStream;

/* JADX INFO: compiled from: DefaultHttpDataSource.java */
/* JADX INFO: loaded from: classes3.dex */
public class r extends g implements l {
    public final boolean e;
    public final int f;
    public final int g;

    @Nullable
    public final String h;

    @Nullable
    public final u i;
    public final u j;
    public final boolean k;

    @Nullable
    public b.i.b.a.h<String> l;

    @Nullable
    public n m;

    @Nullable
    public HttpURLConnection n;

    @Nullable
    public InputStream o;
    public boolean p;
    public int q;
    public long r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public long f950s;

    public r(String str, int i, int i2, boolean z2, u uVar, b.i.b.a.h hVar, boolean z3, r$a r_a) {
        super(true);
        this.h = str;
        this.f = i;
        this.g = i2;
        this.e = z2;
        this.i = uVar;
        this.l = null;
        this.j = new u();
        this.k = z3;
    }

    public static void x(@Nullable HttpURLConnection httpURLConnection, long j) {
        int i;
        if (httpURLConnection == null || (i = e0.a) < 19 || i > 20) {
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
    @Override // b.i.a.c.e3.l
    public long a(n nVar) throws HttpDataSource$HttpDataSourceException {
        byte[] bArrK;
        boolean z2;
        long j;
        long j2;
        long jMax;
        this.m = nVar;
        this.f950s = 0L;
        this.r = 0L;
        r(nVar);
        try {
            HttpURLConnection httpURLConnectionV = v(nVar);
            this.n = httpURLConnectionV;
            this.q = httpURLConnectionV.getResponseCode();
            String responseMessage = httpURLConnectionV.getResponseMessage();
            int i = this.q;
            if (i < 200 || i > 299) {
                Map<String, List<String>> headerFields = httpURLConnectionV.getHeaderFields();
                if (this.q == 416) {
                    String headerField = httpURLConnectionV.getHeaderField("Content-Range");
                    Pattern pattern = v.a;
                    if (TextUtils.isEmpty(headerField)) {
                        z2 = true;
                        j = -1;
                    } else {
                        Matcher matcher = v.f953b.matcher(headerField);
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
                    if (nVar.f == j) {
                        this.p = z2;
                        s(nVar);
                        long j3 = nVar.g;
                        if (j3 != -1) {
                            return j3;
                        }
                        return 0L;
                    }
                }
                InputStream errorStream = httpURLConnectionV.getErrorStream();
                try {
                    bArrK = errorStream != null ? e0.K(errorStream) : e0.f;
                } catch (IOException unused) {
                    bArrK = e0.f;
                }
                byte[] bArr = bArrK;
                t();
                throw new HttpDataSource$InvalidResponseCodeException(this.q, responseMessage, this.q == 416 ? new DataSourceException(2008) : null, headerFields, nVar, bArr);
            }
            String contentType = httpURLConnectionV.getContentType();
            b.i.b.a.h<String> hVar = this.l;
            if (hVar != null && !hVar.apply(contentType)) {
                t();
                throw new HttpDataSource$InvalidContentTypeException(contentType, nVar);
            }
            if (this.q == 200) {
                j2 = nVar.f;
                if (j2 == 0) {
                    j2 = 0;
                }
            } else {
                j2 = 0;
            }
            boolean zEqualsIgnoreCase = "gzip".equalsIgnoreCase(httpURLConnectionV.getHeaderField("Content-Encoding"));
            if (zEqualsIgnoreCase) {
                this.r = nVar.g;
            } else {
                long j4 = nVar.g;
                if (j4 != -1) {
                    this.r = j4;
                } else {
                    String headerField2 = httpURLConnectionV.getHeaderField("Content-Length");
                    String headerField3 = httpURLConnectionV.getHeaderField("Content-Range");
                    Pattern pattern2 = v.a;
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
                        Matcher matcher2 = v.a.matcher(headerField3);
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
                    this.r = jMax != -1 ? jMax - j2 : -1L;
                }
            }
            try {
                this.o = httpURLConnectionV.getInputStream();
                if (zEqualsIgnoreCase) {
                    this.o = new GZIPInputStream(this.o);
                }
                this.p = true;
                s(nVar);
                try {
                    y(j2, nVar);
                    return this.r;
                } catch (IOException e) {
                    t();
                    if (e instanceof HttpDataSource$HttpDataSourceException) {
                        throw ((HttpDataSource$HttpDataSourceException) e);
                    }
                    throw new HttpDataSource$HttpDataSourceException(e, nVar, 2000, 1);
                }
            } catch (IOException e2) {
                t();
                throw new HttpDataSource$HttpDataSourceException(e2, nVar, 2000, 1);
            }
        } catch (IOException e3) {
            t();
            throw HttpDataSource$HttpDataSourceException.b(e3, nVar, 1);
        }
    }

    @Override // b.i.a.c.e3.l
    public void close() throws HttpDataSource$HttpDataSourceException {
        try {
            InputStream inputStream = this.o;
            if (inputStream != null) {
                long j = this.r;
                long j2 = -1;
                if (j != -1) {
                    j2 = j - this.f950s;
                }
                x(this.n, j2);
                try {
                    inputStream.close();
                } catch (IOException e) {
                    n nVar = this.m;
                    int i = e0.a;
                    throw new HttpDataSource$HttpDataSourceException(e, nVar, 2000, 3);
                }
            }
            this.o = null;
            t();
            if (this.p) {
                this.p = false;
                q();
            }
        } catch (Throwable th) {
            this.o = null;
            t();
            if (this.p) {
                this.p = false;
                q();
            }
            throw th;
        }
    }

    @Override // b.i.a.c.e3.g, b.i.a.c.e3.l
    public Map<String, List<String>> j() {
        HttpURLConnection httpURLConnection = this.n;
        return httpURLConnection == null ? Collections.emptyMap() : httpURLConnection.getHeaderFields();
    }

    @Override // b.i.a.c.e3.l
    @Nullable
    public Uri n() {
        HttpURLConnection httpURLConnection = this.n;
        if (httpURLConnection == null) {
            return null;
        }
        return Uri.parse(httpURLConnection.getURL().toString());
    }

    /* JADX WARN: Code duplicated, block: B:15:0x002c A[Catch: IOException -> 0x001e, TRY_LEAVE, TryCatch #0 {IOException -> 0x001e, blocks: (B:4:0x0004, B:6:0x000d, B:9:0x0017, B:12:0x0020, B:15:0x002c), top: B:19:0x0004 }] */
    @Override // b.i.a.c.e3.h
    public int read(byte[] bArr, int i, int i2) throws HttpDataSource$HttpDataSourceException {
        int i3;
        if (i2 == 0) {
            return 0;
        }
        try {
            long j = this.r;
            if (j != -1) {
                long j2 = j - this.f950s;
                if (j2 != 0) {
                    i2 = (int) Math.min(i2, j2);
                    InputStream inputStream = this.o;
                    int i4 = e0.a;
                    i3 = inputStream.read(bArr, i, i2);
                    if (i3 != -1) {
                        this.f950s += (long) i3;
                        p(i3);
                        return i3;
                    }
                }
            } else {
                InputStream inputStream2 = this.o;
                int i5 = e0.a;
                i3 = inputStream2.read(bArr, i, i2);
                if (i3 != -1) {
                    this.f950s += (long) i3;
                    p(i3);
                    return i3;
                }
            }
            return -1;
        } catch (IOException e) {
            n nVar = this.m;
            int i6 = e0.a;
            throw HttpDataSource$HttpDataSourceException.b(e, nVar, 2);
        }
    }

    public final void t() {
        HttpURLConnection httpURLConnection = this.n;
        if (httpURLConnection != null) {
            try {
                httpURLConnection.disconnect();
            } catch (Exception e) {
                b.i.a.c.f3.q.b("DefaultHttpDataSource", "Unexpected error while disconnecting", e);
            }
            this.n = null;
        }
    }

    public final URL u(URL url, @Nullable String str, n nVar) throws HttpDataSource$HttpDataSourceException {
        if (str == null) {
            throw new HttpDataSource$HttpDataSourceException("Null location redirect", nVar, 2001, 1);
        }
        try {
            URL url2 = new URL(url, str);
            String protocol = url2.getProtocol();
            if (!Constants.SCHEME.equals(protocol) && !"http".equals(protocol)) {
                String strValueOf = String.valueOf(protocol);
                throw new HttpDataSource$HttpDataSourceException(strValueOf.length() != 0 ? "Unsupported protocol redirect: ".concat(strValueOf) : new String("Unsupported protocol redirect: "), nVar, 2001, 1);
            }
            if (this.e || protocol.equals(url.getProtocol())) {
                return url2;
            }
            String protocol2 = url.getProtocol();
            StringBuilder sbS = b.d.b.a.a.S(protocol.length() + b.d.b.a.a.b(protocol2, 41), "Disallowed cross-protocol redirect (", protocol2, " to ", protocol);
            sbS.append(")");
            throw new HttpDataSource$HttpDataSourceException(sbS.toString(), nVar, 2001, 1);
        } catch (MalformedURLException e) {
            throw new HttpDataSource$HttpDataSourceException(e, nVar, 2001, 1);
        }
    }

    public final HttpURLConnection v(n nVar) throws IOException {
        URL url = new URL(nVar.a.toString());
        int i = nVar.c;
        byte[] bArr = nVar.d;
        long j = nVar.f;
        long j2 = nVar.g;
        boolean zC = nVar.c(1);
        if (!this.e && !this.k) {
            return w(url, i, bArr, j, j2, zC, true, nVar.e);
        }
        int i2 = 0;
        URL urlU = url;
        int i3 = i;
        byte[] bArr2 = bArr;
        while (true) {
            int i4 = i2 + 1;
            if (i2 > 20) {
                throw new HttpDataSource$HttpDataSourceException(new NoRouteToHostException(b.d.b.a.a.g(31, "Too many redirects: ", i4)), nVar, 2001, 1);
            }
            long j3 = j;
            long j4 = j;
            int i5 = i3;
            URL url2 = urlU;
            long j5 = j2;
            HttpURLConnection httpURLConnectionW = w(urlU, i3, bArr2, j3, j2, zC, false, nVar.e);
            int responseCode = httpURLConnectionW.getResponseCode();
            String headerField = httpURLConnectionW.getHeaderField("Location");
            if ((i5 == 1 || i5 == 3) && (responseCode == 300 || responseCode == 301 || responseCode == 302 || responseCode == 303 || responseCode == 307 || responseCode == 308)) {
                httpURLConnectionW.disconnect();
                urlU = u(url2, headerField, nVar);
                i3 = i5;
            } else {
                if (i5 != 2 || (responseCode != 300 && responseCode != 301 && responseCode != 302 && responseCode != 303)) {
                    return httpURLConnectionW;
                }
                httpURLConnectionW.disconnect();
                if (this.k && responseCode == 302) {
                    i3 = i5;
                } else {
                    bArr2 = null;
                    i3 = 1;
                }
                urlU = u(url2, headerField, nVar);
            }
            j = j4;
            i2 = i4;
            j2 = j5;
        }
    }

    public final HttpURLConnection w(URL url, int i, @Nullable byte[] bArr, long j, long j2, boolean z2, boolean z3, Map<String, String> map) throws IOException {
        String string;
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setConnectTimeout(this.f);
        httpURLConnection.setReadTimeout(this.g);
        HashMap map2 = new HashMap();
        u uVar = this.i;
        if (uVar != null) {
            map2.putAll(uVar.a());
        }
        map2.putAll(this.j.a());
        map2.putAll(map);
        for (Map$Entry map$Entry : map2.entrySet()) {
            httpURLConnection.setRequestProperty((String) map$Entry.getKey(), (String) map$Entry.getValue());
        }
        Pattern pattern = v.a;
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
        String str = this.h;
        if (str != null) {
            httpURLConnection.setRequestProperty("User-Agent", str);
        }
        httpURLConnection.setRequestProperty("Accept-Encoding", z2 ? "gzip" : RegistrationSteps.IDENTITY);
        httpURLConnection.setInstanceFollowRedirects(z3);
        httpURLConnection.setDoOutput(bArr != null);
        httpURLConnection.setRequestMethod(n.b(i));
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

    public final void y(long j, n nVar) throws IOException {
        if (j == 0) {
            return;
        }
        byte[] bArr = new byte[4096];
        while (j > 0) {
            int iMin = (int) Math.min(j, 4096);
            InputStream inputStream = this.o;
            int i = e0.a;
            int i2 = inputStream.read(bArr, 0, iMin);
            if (Thread.currentThread().isInterrupted()) {
                throw new HttpDataSource$HttpDataSourceException(new InterruptedIOException(), nVar, 2000, 1);
            }
            if (i2 == -1) {
                throw new HttpDataSource$HttpDataSourceException(nVar, 2008, 1);
            }
            j -= (long) i2;
            p(i2);
        }
    }
}
