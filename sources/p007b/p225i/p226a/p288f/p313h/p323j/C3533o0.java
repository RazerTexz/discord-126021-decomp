package p007b.p225i.p226a.p288f.p313h.p323j;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import com.adjust.sdk.Constants;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.zip.GZIPOutputStream;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p225i.p226a.p288f.p291b.C3180f;
import p007b.p225i.p226a.p288f.p299e.p308o.C3401c;

/* JADX INFO: renamed from: b.i.a.f.h.j.o0 */
/* JADX INFO: loaded from: classes3.dex */
public final class C3533o0 extends AbstractC3509e {

    /* JADX INFO: renamed from: l */
    public static final byte[] f9773l = "\n".getBytes();

    /* JADX INFO: renamed from: m */
    public final String f9774m;

    /* JADX INFO: renamed from: n */
    public final C3553y0 f9775n;

    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    public C3533o0(C3515g c3515g) {
        String string;
        super(c3515g);
        String str = C3512f.f9715a;
        String str2 = Build.VERSION.RELEASE;
        Locale locale = Locale.getDefault();
        if (locale == null) {
            string = null;
        } else {
            String language = locale.getLanguage();
            if (TextUtils.isEmpty(language)) {
                string = null;
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append(language.toLowerCase(locale));
                if (!TextUtils.isEmpty(locale.getCountry())) {
                    sb.append("-");
                    sb.append(locale.getCountry().toLowerCase(locale));
                }
                string = sb.toString();
            }
        }
        this.f9774m = String.format("%s/%s (Linux; U; Android %s; %s; %s Build/%s)", "GoogleAnalytics", str, str2, string, Build.MODEL, Build.ID);
        this.f9775n = new C3553y0(c3515g.f9724d);
    }

    /* JADX INFO: renamed from: S */
    public static void m4476S(StringBuilder sb, String str, String str2) throws UnsupportedEncodingException {
        if (sb.length() != 0) {
            sb.append('&');
        }
        sb.append(URLEncoder.encode(str, Constants.ENCODING));
        sb.append('=');
        sb.append(URLEncoder.encode(str2, Constants.ENCODING));
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p323j.AbstractC3509e
    /* JADX INFO: renamed from: L */
    public final void mo4414L() {
        m4431b("Network initialized. User agent", this.f9774m);
    }

    /* JADX WARN: Code duplicated, block: B:42:0x009f  */
    /* JADX WARN: Code duplicated, block: B:44:0x0095 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:55:? A[SYNTHETIC] */
    /* JADX INFO: renamed from: O */
    public final int m4477O(URL url, byte[] bArr) throws Throwable {
        HttpURLConnection httpURLConnection;
        IOException e;
        HttpURLConnection httpURLConnectionM4480U;
        Objects.requireNonNull(bArr, "null reference");
        m4430a(3, "POST bytes, url", Integer.valueOf(bArr.length), url, null);
        if (Log.isLoggable(C3510e0.f9690b.f9716a, 2)) {
            m4431b("Post payload\n", new String(bArr));
        }
        OutputStream outputStream = null;
        try {
            this.f9684j.f9722b.getPackageName();
            httpURLConnectionM4480U = m4480U(url);
            try {
                try {
                    httpURLConnectionM4480U.setDoOutput(true);
                    httpURLConnectionM4480U.setFixedLengthStreamingMode(bArr.length);
                    httpURLConnectionM4480U.connect();
                    outputStream = httpURLConnectionM4480U.getOutputStream();
                    outputStream.write(bArr);
                    m4479T(httpURLConnectionM4480U);
                    int responseCode = httpURLConnectionM4480U.getResponseCode();
                    if (responseCode == 200) {
                        m4436s().m4415O();
                    }
                    m4432d("POST status", Integer.valueOf(responseCode));
                    try {
                        outputStream.close();
                    } catch (IOException e2) {
                        m4426A("Error closing http post connection output stream", e2);
                    }
                    httpURLConnectionM4480U.disconnect();
                    return responseCode;
                } catch (IOException e3) {
                    e = e3;
                    m4439x("Network POST connection error", e);
                    if (outputStream != null) {
                        try {
                            outputStream.close();
                        } catch (IOException e4) {
                            m4426A("Error closing http post connection output stream", e4);
                        }
                    }
                    if (httpURLConnectionM4480U == null) {
                        return 0;
                    }
                    httpURLConnectionM4480U.disconnect();
                    return 0;
                }
            } catch (Throwable th) {
                httpURLConnection = httpURLConnectionM4480U;
                th = th;
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (IOException e5) {
                        m4426A("Error closing http post connection output stream", e5);
                    }
                }
                if (httpURLConnection != null) {
                    throw th;
                }
                httpURLConnection.disconnect();
                throw th;
            }
        } catch (IOException e6) {
            e = e6;
            httpURLConnectionM4480U = null;
        } catch (Throwable th2) {
            th = th2;
            httpURLConnection = null;
            if (outputStream != null) {
                outputStream.close();
            }
            if (httpURLConnection != null) {
                throw th;
            }
            httpURLConnection.disconnect();
            throw th;
        }
    }

    /* JADX INFO: renamed from: R */
    public final String m4478R(C3523j0 c3523j0, boolean z2) {
        long j;
        StringBuilder sb = new StringBuilder();
        try {
            for (Map.Entry<String, String> entry : c3523j0.f9746a.entrySet()) {
                String key = entry.getKey();
                if (!"ht".equals(key) && !"qt".equals(key) && !"AppUID".equals(key) && !"z".equals(key) && !"_gmsv".equals(key)) {
                    m4476S(sb, key, entry.getValue());
                }
            }
            m4476S(sb, "ht", String.valueOf(c3523j0.f9749d));
            Objects.requireNonNull((C3401c) this.f9684j.f9724d);
            m4476S(sb, "qt", String.valueOf(System.currentTimeMillis() - c3523j0.f9749d));
            if (z2) {
                C1460d.m583w("_s");
                C1460d.m551o(true, "Short param name required");
                String str = c3523j0.f9746a.get("_s");
                if (str == null) {
                    str = "0";
                }
                try {
                    j = Long.parseLong(str);
                } catch (NumberFormatException unused) {
                    j = 0;
                }
                m4476S(sb, "z", j != 0 ? String.valueOf(j) : String.valueOf(c3523j0.f9748c));
            }
            return sb.toString();
        } catch (UnsupportedEncodingException e) {
            m4426A("Failed to encode name or value", e);
            return null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0014, code lost:
    
        r4 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0015, code lost:
    
        m4426A("Error closing http connection input stream", r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0018, code lost:
    
        return;
     */
    /* JADX INFO: renamed from: T */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void m4479T(HttpURLConnection httpURLConnection) throws Throwable {
        InputStream inputStream;
        try {
            inputStream = httpURLConnection.getInputStream();
            try {
                do {
                } while (inputStream.read(new byte[1024]) > 0);
                inputStream.close();
            } catch (Throwable th) {
                th = th;
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e) {
                        m4426A("Error closing http connection input stream", e);
                    }
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            inputStream = null;
        }
    }

    /* JADX INFO: renamed from: U */
    public final HttpURLConnection m4480U(URL url) throws IOException {
        URLConnection uRLConnectionOpenConnection = url.openConnection();
        if (!(uRLConnectionOpenConnection instanceof HttpURLConnection)) {
            throw new IOException("Failed to obtain http connection");
        }
        HttpURLConnection httpURLConnection = (HttpURLConnection) uRLConnectionOpenConnection;
        httpURLConnection.setDefaultUseCaches(false);
        httpURLConnection.setConnectTimeout(C3510e0.f9709u.f9716a.intValue());
        httpURLConnection.setReadTimeout(C3510e0.f9710v.f9716a.intValue());
        httpURLConnection.setInstanceFollowRedirects(false);
        httpURLConnection.setRequestProperty("User-Agent", this.f9774m);
        httpURLConnection.setDoInput(true);
        return httpURLConnection;
    }

    /* JADX WARN: Code duplicated, block: B:119:0x026e  */
    /* JADX WARN: Code duplicated, block: B:127:0x0281  */
    /* JADX WARN: Code duplicated, block: B:129:0x0285  */
    /* JADX WARN: Code duplicated, block: B:131:0x028f  */
    /* JADX WARN: Code duplicated, block: B:133:0x0299  */
    /* JADX WARN: Code duplicated, block: B:135:0x02b4  */
    /* JADX WARN: Code duplicated, block: B:138:0x02c3  */
    /* JADX WARN: Code duplicated, block: B:141:0x02d6  */
    /* JADX WARN: Code duplicated, block: B:143:0x02e9  */
    /* JADX WARN: Code duplicated, block: B:144:0x02f4  */
    /* JADX WARN: Code duplicated, block: B:146:0x0304  */
    /* JADX WARN: Code duplicated, block: B:148:0x030a  */
    /* JADX WARN: Code duplicated, block: B:149:0x0324  */
    /* JADX WARN: Code duplicated, block: B:155:0x034a  */
    /* JADX WARN: Code duplicated, block: B:156:0x0351  */
    /* JADX WARN: Code duplicated, block: B:160:0x0366 A[Catch: all -> 0x037a, IOException -> 0x037c, TryCatch #12 {all -> 0x037a, blocks: (B:158:0x035a, B:160:0x0366, B:161:0x036d, B:171:0x0383), top: B:227:0x035a }] */
    /* JADX WARN: Code duplicated, block: B:181:0x0399  */
    /* JADX WARN: Code duplicated, block: B:183:0x039f  */
    /* JADX WARN: Code duplicated, block: B:184:0x03aa  */
    /* JADX WARN: Code duplicated, block: B:186:0x03bb  */
    /* JADX WARN: Code duplicated, block: B:187:0x03c5  */
    /* JADX WARN: Code duplicated, block: B:189:0x03c9  */
    /* JADX WARN: Code duplicated, block: B:191:0x03df  */
    /* JADX WARN: Code duplicated, block: B:192:0x03e4  */
    /* JADX WARN: Code duplicated, block: B:193:0x03ea  */
    /* JADX WARN: Code duplicated, block: B:195:0x0400  */
    /* JADX WARN: Code duplicated, block: B:196:0x0405  */
    /* JADX WARN: Code duplicated, block: B:203:0x0418  */
    /* JADX WARN: Code duplicated, block: B:204:0x041e  */
    /* JADX WARN: Code duplicated, block: B:209:0x0429  */
    /* JADX WARN: Code duplicated, block: B:212:0x0276 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:223:0x0263 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:229:0x012b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:237:0x014f A[EDGE_INSN: B:237:0x014f->B:64:0x014f BREAK  A[LOOP:0: B:37:0x00c6->B:63:0x0144], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:239:0x043c A[EDGE_INSN: B:239:0x043c->B:211:0x043c BREAK  A[LOOP:1: B:139:0x02d0->B:241:?], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:240:0x043c A[EDGE_INSN: B:240:0x043c->B:211:0x043c BREAK  A[LOOP:1: B:139:0x02d0->B:241:?], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:241:? A[LOOP:1: B:139:0x02d0->B:241:?, LOOP_END, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:242:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:36:0x0099  */
    /* JADX WARN: Code duplicated, block: B:39:0x00cc  */
    /* JADX WARN: Code duplicated, block: B:42:0x00e5  */
    /* JADX WARN: Code duplicated, block: B:44:0x00eb  */
    /* JADX WARN: Code duplicated, block: B:45:0x00f5  */
    /* JADX WARN: Code duplicated, block: B:47:0x0106  */
    /* JADX WARN: Code duplicated, block: B:48:0x0110  */
    /* JADX WARN: Code duplicated, block: B:50:0x0116  */
    /* JADX WARN: Code duplicated, block: B:53:0x0129  */
    /* JADX WARN: Code duplicated, block: B:56:0x0131 A[Catch: IOException -> 0x013b, TryCatch #14 {IOException -> 0x013b, blocks: (B:54:0x012b, B:56:0x0131, B:57:0x0136), top: B:229:0x012b }] */
    /* JADX WARN: Code duplicated, block: B:63:0x0144 A[LOOP:0: B:37:0x00c6->B:63:0x0144, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:66:0x0152 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:67:0x0153  */
    /* JADX WARN: Code duplicated, block: B:69:0x016b  */
    /* JADX WARN: Code duplicated, block: B:70:0x0170  */
    /* JADX WARN: Code duplicated, block: B:77:0x0184  */
    /* JADX WARN: Code duplicated, block: B:78:0x018b A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:79:0x018d  */
    /* JADX WARN: Code duplicated, block: B:82:0x01d3 A[Catch: all -> 0x0252, IOException -> 0x0259, TryCatch #16 {IOException -> 0x0259, all -> 0x0252, blocks: (B:80:0x0196, B:82:0x01d3, B:83:0x01e2, B:85:0x01ef, B:87:0x01fe, B:89:0x0209, B:88:0x0203, B:90:0x020c), top: B:215:0x0196 }] */
    /* JADX WARN: Code duplicated, block: B:85:0x01ef A[Catch: all -> 0x0252, IOException -> 0x0259, TryCatch #16 {IOException -> 0x0259, all -> 0x0252, blocks: (B:80:0x0196, B:82:0x01d3, B:83:0x01e2, B:85:0x01ef, B:87:0x01fe, B:89:0x0209, B:88:0x0203, B:90:0x020c), top: B:215:0x0196 }] */
    /* JADX WARN: Code duplicated, block: B:87:0x01fe A[Catch: all -> 0x0252, IOException -> 0x0259, TryCatch #16 {IOException -> 0x0259, all -> 0x0252, blocks: (B:80:0x0196, B:82:0x01d3, B:83:0x01e2, B:85:0x01ef, B:87:0x01fe, B:89:0x0209, B:88:0x0203, B:90:0x020c), top: B:215:0x0196 }] */
    /* JADX WARN: Code duplicated, block: B:88:0x0203 A[Catch: all -> 0x0252, IOException -> 0x0259, TryCatch #16 {IOException -> 0x0259, all -> 0x0252, blocks: (B:80:0x0196, B:82:0x01d3, B:83:0x01e2, B:85:0x01ef, B:87:0x01fe, B:89:0x0209, B:88:0x0203, B:90:0x020c), top: B:215:0x0196 }] */
    /* JADX WARN: Code duplicated, block: B:95:0x0234 A[Catch: all -> 0x024d, IOException -> 0x0250, TryCatch #15 {IOException -> 0x0250, all -> 0x024d, blocks: (B:91:0x0210, B:93:0x022b, B:95:0x0234, B:96:0x023b), top: B:232:0x0210 }] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v55, types: [java.lang.Object, java.net.URL] */
    /* JADX WARN: Type inference failed for: r16v0, types: [b.i.a.f.h.j.d, b.i.a.f.h.j.e, b.i.a.f.h.j.o0] */
    /* JADX WARN: Type inference failed for: r1v15 */
    /* JADX WARN: Type inference failed for: r1v16 */
    /* JADX WARN: Type inference failed for: r1v18 */
    /* JADX WARN: Type inference failed for: r1v19 */
    /* JADX WARN: Type inference failed for: r1v20, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r1v21 */
    /* JADX WARN: Type inference failed for: r1v35, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r1v9, types: [java.io.ByteArrayOutputStream] */
    /* JADX WARN: Type inference failed for: r2v15 */
    /* JADX WARN: Type inference failed for: r2v17, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r2v65 */
    /* JADX WARN: Type inference failed for: r3v10, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r3v11 */
    /* JADX WARN: Type inference failed for: r3v9 */
    /* JADX INFO: renamed from: V */
    public final List<Long> m4481V(List<C3523j0> list) throws Throwable {
        boolean z2;
        boolean z3;
        ArrayList arrayList;
        String strM4478R;
        String strM4478R2;
        byte[] bytes;
        String strValueOf;
        String strValueOf2;
        String str;
        String strConcat;
        URL url;
        String strValueOf3;
        String strValueOf4;
        boolean z4;
        String strM861l;
        URL url2;
        HttpURLConnection httpURLConnection;
        HttpURLConnection httpURLConnectionM4480U;
        int responseCode;
        ?? byteArrayOutputStream;
        ArrayList arrayList2;
        int i;
        int i2;
        String strValueOf5;
        String strValueOf6;
        String str2;
        Object url3;
        ?? r0;
        byte[] byteArray;
        ?? r3;
        ?? r2;
        Throwable th;
        OutputStream outputStream;
        byte[] byteArray2;
        int responseCode2;
        String str3;
        String str4;
        int i3;
        boolean z5;
        String strM4478R3;
        byte[] bytes2;
        int length;
        EnumC3548w enumC3548w;
        EnumC3550x enumC3550x = EnumC3550x.GZIP;
        EnumC3548w enumC3548w2 = EnumC3548w.NONE;
        C3180f.m3967b();
        m4444N();
        int iM4477O = 0;
        if (!this.f9684j.f9725e.m4514g().isEmpty() && this.f9775n.m4507b(((long) C3510e0.f9708t.f9716a.intValue()) * 1000)) {
            String str5 = C3510e0.f9702n.f9716a;
            if ("BATCH_BY_SESSION".equalsIgnoreCase(str5)) {
                enumC3548w = EnumC3548w.BATCH_BY_SESSION;
            } else if ("BATCH_BY_TIME".equalsIgnoreCase(str5)) {
                enumC3548w = EnumC3548w.BATCH_BY_TIME;
            } else if ("BATCH_BY_BRUTE_FORCE".equalsIgnoreCase(str5)) {
                enumC3548w = EnumC3548w.BATCH_BY_BRUTE_FORCE;
            } else if ("BATCH_BY_COUNT".equalsIgnoreCase(str5)) {
                enumC3548w = EnumC3548w.BATCH_BY_COUNT;
            } else {
                enumC3548w = "BATCH_BY_SIZE".equalsIgnoreCase(str5) ? EnumC3548w.BATCH_BY_SIZE : enumC3548w2;
            }
            z2 = enumC3548w != enumC3548w2;
            z3 = ("GZIP".equalsIgnoreCase(C3510e0.f9703o.f9716a) ? enumC3550x : EnumC3550x.NONE) == enumC3550x;
            if (z2) {
                arrayList = new ArrayList(list.size());
                for (C3523j0 c3523j0 : list) {
                    Objects.requireNonNull(c3523j0, "null reference");
                    strM4478R = m4478R(c3523j0, !c3523j0.f9751f);
                    if (strM4478R == null) {
                        if (strM4478R.length() <= C3510e0.f9701m.f9716a.intValue()) {
                            if (c3523j0.f9751f) {
                                String strM4510d = C3554z.m4510d();
                                String strM4512f = C3554z.m4512f();
                                strM861l = C1643a.m861l(strM4478R.length() + C1643a.m841b(strM4512f, C1643a.m841b(strM4510d, 1)), strM4510d, strM4512f, "?", strM4478R);
                            } else {
                                String strM4511e = C3554z.m4511e();
                                String strM4512f2 = C3554z.m4512f();
                                strM861l = C1643a.m861l(strM4478R.length() + C1643a.m841b(strM4512f2, C1643a.m841b(strM4511e, 1)), strM4511e, strM4512f2, "?", strM4478R);
                            }
                            try {
                                url2 = new URL(strM861l);
                            } catch (MalformedURLException e) {
                                m4426A("Error trying to parse the hardcoded host url", e);
                                url2 = null;
                            }
                            if (url2 == null) {
                                m4429H("Failed to build collect GET endpoint url");
                            } else {
                                m4432d("GET request", url2);
                                try {
                                    httpURLConnectionM4480U = m4480U(url2);
                                    try {
                                        try {
                                            httpURLConnectionM4480U.connect();
                                            m4479T(httpURLConnectionM4480U);
                                            responseCode = httpURLConnectionM4480U.getResponseCode();
                                            if (responseCode == 200) {
                                                m4436s().m4415O();
                                            }
                                            m4432d("GET status", Integer.valueOf(responseCode));
                                            httpURLConnectionM4480U.disconnect();
                                        } catch (Throwable th2) {
                                            th = th2;
                                            httpURLConnection = httpURLConnectionM4480U;
                                            if (httpURLConnection != null) {
                                                httpURLConnection.disconnect();
                                            }
                                            throw th;
                                        }
                                    } catch (IOException e2) {
                                        e = e2;
                                        m4439x("Network GET connection error", e);
                                        if (httpURLConnectionM4480U != null) {
                                            httpURLConnectionM4480U.disconnect();
                                        }
                                        responseCode = 0;
                                    }
                                } catch (IOException e3) {
                                    e = e3;
                                    httpURLConnectionM4480U = null;
                                } catch (Throwable th3) {
                                    th = th3;
                                    httpURLConnection = null;
                                }
                                if (responseCode == 200) {
                                }
                            }
                            z4 = false;
                        } else {
                            strM4478R2 = m4478R(c3523j0, false);
                            if (strM4478R2 == null) {
                                m4434n().m4465O(c3523j0, "Error formatting hit for POST upload");
                            } else {
                                bytes = strM4478R2.getBytes();
                                if (bytes.length > C3510e0.f9705q.f9716a.intValue()) {
                                    m4434n().m4465O(c3523j0, "Hit payload exceeds size limit");
                                } else {
                                    if (c3523j0.f9751f) {
                                        strValueOf3 = String.valueOf(C3554z.m4510d());
                                        strValueOf4 = String.valueOf(C3554z.m4512f());
                                        if (strValueOf4.length() != 0) {
                                            strConcat = strValueOf3.concat(strValueOf4);
                                        } else {
                                            str = new String(strValueOf3);
                                            strConcat = str;
                                        }
                                    } else {
                                        strValueOf = String.valueOf(C3554z.m4511e());
                                        strValueOf2 = String.valueOf(C3554z.m4512f());
                                        if (strValueOf2.length() != 0) {
                                            strConcat = strValueOf.concat(strValueOf2);
                                        } else {
                                            str = new String(strValueOf);
                                            strConcat = str;
                                        }
                                    }
                                    try {
                                        url = new URL(strConcat);
                                    } catch (MalformedURLException e4) {
                                        m4426A("Error trying to parse the hardcoded host url", e4);
                                        url = null;
                                    }
                                    if (url == null) {
                                        m4429H("Failed to build collect POST endpoint url");
                                    } else if (m4477O(url, bytes) == 200) {
                                    }
                                    z4 = false;
                                }
                            }
                        }
                        if (z4) {
                            break;
                        }
                        arrayList.add(Long.valueOf(c3523j0.f9748c));
                        if (arrayList.size() >= C3554z.m4509c()) {
                            break;
                        }
                    } else {
                        m4434n().m4465O(c3523j0, "Error formatting hit for upload");
                    }
                    z4 = true;
                    if (z4) {
                        break;
                        break;
                    }
                    arrayList.add(Long.valueOf(c3523j0.f9748c));
                    if (arrayList.size() >= C3554z.m4509c()) {
                        break;
                        break;
                    }
                }
                return arrayList;
            }
            C1460d.m539l(!list.isEmpty());
            m4430a(2, "Uploading batched hits. compression, count", Boolean.valueOf(z3), Integer.valueOf(list.size()), null);
            byteArrayOutputStream = new ByteArrayOutputStream();
            arrayList2 = new ArrayList();
            i = 0;
            for (C3523j0 c3523j1 : list) {
                Objects.requireNonNull(c3523j1, "null reference");
                i3 = i + 1;
                if (i3 <= C3510e0.f9696h.f9716a.intValue()) {
                    strM4478R3 = m4478R(c3523j1, false);
                    if (strM4478R3 == null) {
                        m4434n().m4465O(c3523j1, "Error formatting hit");
                    } else {
                        bytes2 = strM4478R3.getBytes();
                        length = bytes2.length;
                        if (length > C3510e0.f9704p.f9716a.intValue()) {
                            m4434n().m4465O(c3523j1, "Hit size exceeds the maximum size limit");
                        } else {
                            if (byteArrayOutputStream.size() > 0) {
                                length++;
                            }
                            if (byteArrayOutputStream.size() + length > C3510e0.f9706r.f9716a.intValue()) {
                                z5 = false;
                            } else {
                                try {
                                    if (byteArrayOutputStream.size() > 0) {
                                        byteArrayOutputStream.write(f9773l);
                                    }
                                    byteArrayOutputStream.write(bytes2);
                                    i = i3;
                                } catch (IOException e5) {
                                    m4426A("Failed to write payload when batching hits", e5);
                                }
                            }
                        }
                    }
                    z5 = true;
                } else {
                    z5 = false;
                }
                if (z5) {
                    break;
                }
                arrayList2.add(Long.valueOf(c3523j1.f9748c));
            }
            i2 = i;
            if (i2 == 0) {
                return arrayList2;
            }
            strValueOf5 = String.valueOf(C3554z.m4510d());
            strValueOf6 = String.valueOf(C3510e0.f9700l.f9716a);
            if (strValueOf6.length() != 0) {
                str2 = strValueOf5.concat(strValueOf6);
            } else {
                str2 = new String(strValueOf5);
            }
            try {
                url3 = new URL(str2);
            } catch (MalformedURLException e6) {
                m4426A("Error trying to parse the hardcoded host url", e6);
                url3 = null;
            }
            r0 = url3;
            if (r0 == 0) {
                m4429H("Failed to build batching endpoint url");
            } else {
                if (z3) {
                    byteArray = byteArrayOutputStream.toByteArray();
                    Objects.requireNonNull(byteArray, "null reference");
                    try {
                        try {
                            this.f9684j.f9722b.getPackageName();
                            ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
                            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream2);
                            gZIPOutputStream.write(byteArray);
                            gZIPOutputStream.close();
                            byteArrayOutputStream2.close();
                            byteArray2 = byteArrayOutputStream2.toByteArray();
                            m4430a(3, "POST compressed size, ratio %, url", Integer.valueOf(byteArray2.length), Long.valueOf((((long) byteArray2.length) * 100) / ((long) byteArray.length)), r0);
                            if (byteArray2.length > byteArray.length) {
                                m4433f("Compressed payload is larger then uncompressed. compressed, uncompressed", Integer.valueOf(byteArray2.length), Integer.valueOf(byteArray.length));
                            }
                            if (Log.isLoggable(C3510e0.f9690b.f9716a, 2)) {
                                str3 = new String(byteArray);
                                if (str3.length() != 0) {
                                    str4 = "\n".concat(str3);
                                } else {
                                    str4 = new String("\n");
                                }
                                m4431b("Post payload", str4);
                            }
                            byteArrayOutputStream = m4480U(r0);
                            try {
                                byteArrayOutputStream.setDoOutput(true);
                                byteArrayOutputStream.addRequestProperty("Content-Encoding", "gzip");
                                byteArrayOutputStream.setFixedLengthStreamingMode(byteArray2.length);
                                byteArrayOutputStream.connect();
                                outputStream = byteArrayOutputStream.getOutputStream();
                                try {
                                    outputStream.write(byteArray2);
                                    outputStream.close();
                                    m4479T(byteArrayOutputStream);
                                    responseCode2 = byteArrayOutputStream.getResponseCode();
                                    if (responseCode2 == 200) {
                                        m4436s().m4415O();
                                    }
                                    url3 = "POST status";
                                    m4432d("POST status", Integer.valueOf(responseCode2));
                                    byteArrayOutputStream.disconnect();
                                    iM4477O = responseCode2;
                                } catch (IOException e7) {
                                    e = e7;
                                    m4439x("Network compressed POST connection error", e);
                                    url3 = outputStream;
                                    if (outputStream != null) {
                                        try {
                                            outputStream.close();
                                            url3 = outputStream;
                                        } catch (IOException e8) {
                                            IOException iOException = e8;
                                            m4426A("Error closing http compressed post connection output stream", iOException);
                                            url3 = iOException;
                                        }
                                    }
                                    if (byteArrayOutputStream != 0) {
                                        byteArrayOutputStream.disconnect();
                                    }
                                }
                            } catch (IOException e9) {
                                e = e9;
                                outputStream = null;
                                m4439x("Network compressed POST connection error", e);
                                url3 = outputStream;
                                if (outputStream != null) {
                                    outputStream.close();
                                    url3 = outputStream;
                                }
                                if (byteArrayOutputStream != 0) {
                                    byteArrayOutputStream.disconnect();
                                }
                                if (200 == iM4477O) {
                                    m4431b("Batched upload completed. Hits batched", Integer.valueOf(i2));
                                    return arrayList2;
                                }
                                m4431b("Network error uploading hits. status code", Integer.valueOf(iM4477O));
                                if (this.f9684j.f9725e.m4514g().contains(Integer.valueOf(iM4477O))) {
                                    m4428D("Server instructed the client to stop batching");
                                    this.f9775n.m4506a();
                                }
                                return Collections.emptyList();
                            } catch (Throwable th4) {
                                th = th4;
                                url3 = null;
                                r3 = byteArrayOutputStream;
                                r2 = url3;
                                th = th;
                                if (r2 != 0) {
                                    try {
                                        r2.close();
                                    } catch (IOException e10) {
                                        m4426A("Error closing http compressed post connection output stream", e10);
                                    }
                                }
                                if (r3 != 0) {
                                    throw th;
                                }
                                r3.disconnect();
                                throw th;
                            }
                        } catch (Throwable th5) {
                            th = th5;
                        }
                    } catch (IOException e11) {
                        e = e11;
                        byteArrayOutputStream = 0;
                    } catch (Throwable th6) {
                        th = th6;
                        r3 = 0;
                        r2 = 0;
                        th = th;
                        if (r2 != 0) {
                            r2.close();
                        }
                        if (r3 != 0) {
                            throw th;
                        }
                        r3.disconnect();
                        throw th;
                    }
                } else {
                    iM4477O = m4477O(r0, byteArrayOutputStream.toByteArray());
                }
                if (200 == iM4477O) {
                    m4431b("Batched upload completed. Hits batched", Integer.valueOf(i2));
                    return arrayList2;
                }
                m4431b("Network error uploading hits. status code", Integer.valueOf(iM4477O));
                if (this.f9684j.f9725e.m4514g().contains(Integer.valueOf(iM4477O))) {
                    m4428D("Server instructed the client to stop batching");
                    this.f9775n.m4506a();
                }
            }
            return Collections.emptyList();
        }
        z2 = false;
        if (z2) {
            arrayList = new ArrayList(list.size());
            while (r2.hasNext()) {
                Objects.requireNonNull(c3523j0, "null reference");
                strM4478R = m4478R(c3523j0, !c3523j0.f9751f);
                if (strM4478R == null) {
                    if (strM4478R.length() <= C3510e0.f9701m.f9716a.intValue()) {
                        if (c3523j0.f9751f) {
                            String strM4510d2 = C3554z.m4510d();
                            String strM4512f3 = C3554z.m4512f();
                            strM861l = C1643a.m861l(strM4478R.length() + C1643a.m841b(strM4512f3, C1643a.m841b(strM4510d2, 1)), strM4510d2, strM4512f3, "?", strM4478R);
                        } else {
                            String strM4511e2 = C3554z.m4511e();
                            String strM4512f4 = C3554z.m4512f();
                            strM861l = C1643a.m861l(strM4478R.length() + C1643a.m841b(strM4512f4, C1643a.m841b(strM4511e2, 1)), strM4511e2, strM4512f4, "?", strM4478R);
                        }
                        url2 = new URL(strM861l);
                        if (url2 == null) {
                            m4429H("Failed to build collect GET endpoint url");
                        } else {
                            m4432d("GET request", url2);
                            httpURLConnectionM4480U = m4480U(url2);
                            httpURLConnectionM4480U.connect();
                            m4479T(httpURLConnectionM4480U);
                            responseCode = httpURLConnectionM4480U.getResponseCode();
                            if (responseCode == 200) {
                                m4436s().m4415O();
                            }
                            m4432d("GET status", Integer.valueOf(responseCode));
                            httpURLConnectionM4480U.disconnect();
                            if (responseCode == 200) {
                            }
                        }
                        z4 = false;
                    } else {
                        strM4478R2 = m4478R(c3523j0, false);
                        if (strM4478R2 == null) {
                            m4434n().m4465O(c3523j0, "Error formatting hit for POST upload");
                        } else {
                            bytes = strM4478R2.getBytes();
                            if (bytes.length > C3510e0.f9705q.f9716a.intValue()) {
                                m4434n().m4465O(c3523j0, "Hit payload exceeds size limit");
                            } else {
                                if (c3523j0.f9751f) {
                                    strValueOf3 = String.valueOf(C3554z.m4510d());
                                    strValueOf4 = String.valueOf(C3554z.m4512f());
                                    if (strValueOf4.length() != 0) {
                                        strConcat = strValueOf3.concat(strValueOf4);
                                    } else {
                                        str = new String(strValueOf3);
                                        strConcat = str;
                                    }
                                } else {
                                    strValueOf = String.valueOf(C3554z.m4511e());
                                    strValueOf2 = String.valueOf(C3554z.m4512f());
                                    if (strValueOf2.length() != 0) {
                                        strConcat = strValueOf.concat(strValueOf2);
                                    } else {
                                        str = new String(strValueOf);
                                        strConcat = str;
                                    }
                                }
                                url = new URL(strConcat);
                                if (url == null) {
                                    m4429H("Failed to build collect POST endpoint url");
                                } else if (m4477O(url, bytes) == 200) {
                                }
                                z4 = false;
                            }
                        }
                    }
                    if (z4) {
                        break;
                        break;
                    }
                    arrayList.add(Long.valueOf(c3523j0.f9748c));
                    if (arrayList.size() >= C3554z.m4509c()) {
                        break;
                        break;
                    }
                } else {
                    m4434n().m4465O(c3523j0, "Error formatting hit for upload");
                }
                z4 = true;
                if (z4) {
                    break;
                    break;
                }
                arrayList.add(Long.valueOf(c3523j0.f9748c));
                if (arrayList.size() >= C3554z.m4509c()) {
                    break;
                    break;
                }
            }
            return arrayList;
        }
        C1460d.m539l(!list.isEmpty());
        m4430a(2, "Uploading batched hits. compression, count", Boolean.valueOf(z3), Integer.valueOf(list.size()), null);
        byteArrayOutputStream = new ByteArrayOutputStream();
        arrayList2 = new ArrayList();
        i = 0;
        while (r2.hasNext()) {
            Objects.requireNonNull(c3523j1, "null reference");
            i3 = i + 1;
            if (i3 <= C3510e0.f9696h.f9716a.intValue()) {
                strM4478R3 = m4478R(c3523j1, false);
                if (strM4478R3 == null) {
                    m4434n().m4465O(c3523j1, "Error formatting hit");
                } else {
                    bytes2 = strM4478R3.getBytes();
                    length = bytes2.length;
                    if (length > C3510e0.f9704p.f9716a.intValue()) {
                        m4434n().m4465O(c3523j1, "Hit size exceeds the maximum size limit");
                    } else {
                        if (byteArrayOutputStream.size() > 0) {
                            length++;
                        }
                        if (byteArrayOutputStream.size() + length > C3510e0.f9706r.f9716a.intValue()) {
                            z5 = false;
                        } else {
                            if (byteArrayOutputStream.size() > 0) {
                                byteArrayOutputStream.write(f9773l);
                            }
                            byteArrayOutputStream.write(bytes2);
                            i = i3;
                        }
                    }
                }
                z5 = true;
            } else {
                z5 = false;
            }
            if (z5) {
                break;
                break;
            }
            arrayList2.add(Long.valueOf(c3523j1.f9748c));
        }
        i2 = i;
        if (i2 == 0) {
            return arrayList2;
        }
        strValueOf5 = String.valueOf(C3554z.m4510d());
        strValueOf6 = String.valueOf(C3510e0.f9700l.f9716a);
        if (strValueOf6.length() != 0) {
            str2 = strValueOf5.concat(strValueOf6);
        } else {
            str2 = new String(strValueOf5);
        }
        url3 = new URL(str2);
        r0 = url3;
        if (r0 == 0) {
            m4429H("Failed to build batching endpoint url");
        } else {
            if (z3) {
                byteArray = byteArrayOutputStream.toByteArray();
                Objects.requireNonNull(byteArray, "null reference");
                this.f9684j.f9722b.getPackageName();
                ByteArrayOutputStream byteArrayOutputStream3 = new ByteArrayOutputStream();
                GZIPOutputStream gZIPOutputStream2 = new GZIPOutputStream(byteArrayOutputStream3);
                gZIPOutputStream2.write(byteArray);
                gZIPOutputStream2.close();
                byteArrayOutputStream3.close();
                byteArray2 = byteArrayOutputStream3.toByteArray();
                m4430a(3, "POST compressed size, ratio %, url", Integer.valueOf(byteArray2.length), Long.valueOf((((long) byteArray2.length) * 100) / ((long) byteArray.length)), r0);
                if (byteArray2.length > byteArray.length) {
                    m4433f("Compressed payload is larger then uncompressed. compressed, uncompressed", Integer.valueOf(byteArray2.length), Integer.valueOf(byteArray.length));
                }
                if (Log.isLoggable(C3510e0.f9690b.f9716a, 2)) {
                    str3 = new String(byteArray);
                    if (str3.length() != 0) {
                        str4 = "\n".concat(str3);
                    } else {
                        str4 = new String("\n");
                    }
                    m4431b("Post payload", str4);
                }
                byteArrayOutputStream = m4480U(r0);
                byteArrayOutputStream.setDoOutput(true);
                byteArrayOutputStream.addRequestProperty("Content-Encoding", "gzip");
                byteArrayOutputStream.setFixedLengthStreamingMode(byteArray2.length);
                byteArrayOutputStream.connect();
                outputStream = byteArrayOutputStream.getOutputStream();
                outputStream.write(byteArray2);
                outputStream.close();
                m4479T(byteArrayOutputStream);
                responseCode2 = byteArrayOutputStream.getResponseCode();
                if (responseCode2 == 200) {
                    m4436s().m4415O();
                }
                url3 = "POST status";
                m4432d("POST status", Integer.valueOf(responseCode2));
                byteArrayOutputStream.disconnect();
                iM4477O = responseCode2;
            } else {
                iM4477O = m4477O(r0, byteArrayOutputStream.toByteArray());
            }
            if (200 == iM4477O) {
                m4431b("Batched upload completed. Hits batched", Integer.valueOf(i2));
                return arrayList2;
            }
            m4431b("Network error uploading hits. status code", Integer.valueOf(iM4477O));
            if (this.f9684j.f9725e.m4514g().contains(Integer.valueOf(iM4477O))) {
                m4428D("Server instructed the client to stop batching");
                this.f9775n.m4506a();
            }
        }
        return Collections.emptyList();
    }

    /* JADX INFO: renamed from: W */
    public final boolean m4482W() {
        C3180f.m3967b();
        m4444N();
        NetworkInfo activeNetworkInfo = null;
        try {
            activeNetworkInfo = ((ConnectivityManager) this.f9684j.f9722b.getSystemService("connectivity")).getActiveNetworkInfo();
        } catch (SecurityException unused) {
        }
        if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
            return true;
        }
        m4427C("No network connectivity");
        return false;
    }
}
