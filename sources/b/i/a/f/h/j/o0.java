package b.i.a.f.h.j;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Build$VERSION;
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
import java.util.Map$Entry;
import java.util.Objects;
import java.util.zip.GZIPOutputStream;

/* JADX INFO: loaded from: classes3.dex */
public final class o0 extends e {
    public static final byte[] l = "\n".getBytes();
    public final String m;
    public final y0 n;

    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    public o0(g gVar) {
        String string;
        super(gVar);
        String str = f.a;
        String str2 = Build$VERSION.RELEASE;
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
        this.m = String.format("%s/%s (Linux; U; Android %s; %s; %s Build/%s)", "GoogleAnalytics", str, str2, string, Build.MODEL, Build.ID);
        this.n = new y0(gVar.d);
    }

    public static void S(StringBuilder sb, String str, String str2) throws UnsupportedEncodingException {
        if (sb.length() != 0) {
            sb.append('&');
        }
        sb.append(URLEncoder.encode(str, Constants.ENCODING));
        sb.append('=');
        sb.append(URLEncoder.encode(str2, Constants.ENCODING));
    }

    @Override // b.i.a.f.h.j.e
    public final void L() {
        b("Network initialized. User agent", this.m);
    }

    /* JADX WARN: Code duplicated, block: B:42:0x009f  */
    /* JADX WARN: Code duplicated, block: B:44:0x0095 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:55:? A[SYNTHETIC] */
    public final int O(URL url, byte[] bArr) throws Throwable {
        HttpURLConnection httpURLConnection;
        IOException e;
        HttpURLConnection httpURLConnectionU;
        Objects.requireNonNull(bArr, "null reference");
        a(3, "POST bytes, url", Integer.valueOf(bArr.length), url, null);
        if (Log.isLoggable(e0.f1411b.a, 2)) {
            b("Post payload\n", new String(bArr));
        }
        OutputStream outputStream = null;
        try {
            this.j.f1417b.getPackageName();
            httpURLConnectionU = U(url);
            try {
                try {
                    httpURLConnectionU.setDoOutput(true);
                    httpURLConnectionU.setFixedLengthStreamingMode(bArr.length);
                    httpURLConnectionU.connect();
                    outputStream = httpURLConnectionU.getOutputStream();
                    outputStream.write(bArr);
                    T(httpURLConnectionU);
                    int responseCode = httpURLConnectionU.getResponseCode();
                    if (responseCode == 200) {
                        s().O();
                    }
                    d("POST status", Integer.valueOf(responseCode));
                    try {
                        outputStream.close();
                    } catch (IOException e2) {
                        A("Error closing http post connection output stream", e2);
                    }
                    httpURLConnectionU.disconnect();
                    return responseCode;
                } catch (IOException e3) {
                    e = e3;
                    x("Network POST connection error", e);
                    if (outputStream != null) {
                        try {
                            outputStream.close();
                        } catch (IOException e4) {
                            A("Error closing http post connection output stream", e4);
                        }
                    }
                    if (httpURLConnectionU == null) {
                        return 0;
                    }
                    httpURLConnectionU.disconnect();
                    return 0;
                }
            } catch (Throwable th) {
                httpURLConnection = httpURLConnectionU;
                th = th;
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (IOException e5) {
                        A("Error closing http post connection output stream", e5);
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
            httpURLConnectionU = null;
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

    public final String R(j0 j0Var, boolean z2) {
        long j;
        StringBuilder sb = new StringBuilder();
        try {
            for (Map$Entry<String, String> map$Entry : j0Var.a.entrySet()) {
                String key = map$Entry.getKey();
                if (!"ht".equals(key) && !"qt".equals(key) && !"AppUID".equals(key) && !"z".equals(key) && !"_gmsv".equals(key)) {
                    S(sb, key, map$Entry.getValue());
                }
            }
            S(sb, "ht", String.valueOf(j0Var.d));
            Objects.requireNonNull((b.i.a.f.e.o.c) this.j.d);
            S(sb, "qt", String.valueOf(System.currentTimeMillis() - j0Var.d));
            if (z2) {
                b.c.a.a0.d.w("_s");
                b.c.a.a0.d.o(true, "Short param name required");
                String str = j0Var.a.get("_s");
                if (str == null) {
                    str = "0";
                }
                try {
                    j = Long.parseLong(str);
                } catch (NumberFormatException unused) {
                    j = 0;
                }
                S(sb, "z", j != 0 ? String.valueOf(j) : String.valueOf(j0Var.c));
            }
            return sb.toString();
        } catch (UnsupportedEncodingException e) {
            A("Failed to encode name or value", e);
            return null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0014, code lost:
    
        r4 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0015, code lost:
    
        A("Error closing http connection input stream", r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0018, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void T(HttpURLConnection httpURLConnection) throws Throwable {
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
                        A("Error closing http connection input stream", e);
                    }
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            inputStream = null;
        }
    }

    public final HttpURLConnection U(URL url) throws IOException {
        URLConnection uRLConnectionOpenConnection = url.openConnection();
        if (!(uRLConnectionOpenConnection instanceof HttpURLConnection)) {
            throw new IOException("Failed to obtain http connection");
        }
        HttpURLConnection httpURLConnection = (HttpURLConnection) uRLConnectionOpenConnection;
        httpURLConnection.setDefaultUseCaches(false);
        httpURLConnection.setConnectTimeout(e0.u.a.intValue());
        httpURLConnection.setReadTimeout(e0.v.a.intValue());
        httpURLConnection.setInstanceFollowRedirects(false);
        httpURLConnection.setRequestProperty("User-Agent", this.m);
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
    public final List<Long> V(List<j0> list) throws Throwable {
        boolean z2;
        boolean z3;
        ArrayList arrayList;
        String strR;
        String strR2;
        byte[] bytes;
        String strValueOf;
        String strValueOf2;
        String str;
        String strConcat;
        URL url;
        String strValueOf3;
        String strValueOf4;
        boolean z4;
        String strL;
        URL url2;
        HttpURLConnection httpURLConnection;
        HttpURLConnection httpURLConnectionU;
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
        String strR3;
        byte[] bytes2;
        int length;
        w wVar;
        x xVar = x.GZIP;
        w wVar2 = w.NONE;
        b.i.a.f.b.f.b();
        N();
        int iO = 0;
        if (!this.j.e.g().isEmpty() && this.n.b(((long) e0.t.a.intValue()) * 1000)) {
            String str5 = e0.n.a;
            if ("BATCH_BY_SESSION".equalsIgnoreCase(str5)) {
                wVar = w.BATCH_BY_SESSION;
            } else if ("BATCH_BY_TIME".equalsIgnoreCase(str5)) {
                wVar = w.BATCH_BY_TIME;
            } else if ("BATCH_BY_BRUTE_FORCE".equalsIgnoreCase(str5)) {
                wVar = w.BATCH_BY_BRUTE_FORCE;
            } else if ("BATCH_BY_COUNT".equalsIgnoreCase(str5)) {
                wVar = w.BATCH_BY_COUNT;
            } else {
                wVar = "BATCH_BY_SIZE".equalsIgnoreCase(str5) ? w.BATCH_BY_SIZE : wVar2;
            }
            z2 = wVar != wVar2;
            z3 = ("GZIP".equalsIgnoreCase(e0.o.a) ? xVar : x.NONE) == xVar;
            if (z2) {
                arrayList = new ArrayList(list.size());
                for (j0 j0Var : list) {
                    Objects.requireNonNull(j0Var, "null reference");
                    strR = R(j0Var, !j0Var.f);
                    if (strR == null) {
                        if (strR.length() <= e0.m.a.intValue()) {
                            if (j0Var.f) {
                                String strD = z.d();
                                String strF = z.f();
                                strL = b.d.b.a.a.l(strR.length() + b.d.b.a.a.b(strF, b.d.b.a.a.b(strD, 1)), strD, strF, "?", strR);
                            } else {
                                String strE = z.e();
                                String strF2 = z.f();
                                strL = b.d.b.a.a.l(strR.length() + b.d.b.a.a.b(strF2, b.d.b.a.a.b(strE, 1)), strE, strF2, "?", strR);
                            }
                            try {
                                url2 = new URL(strL);
                            } catch (MalformedURLException e) {
                                A("Error trying to parse the hardcoded host url", e);
                                url2 = null;
                            }
                            if (url2 == null) {
                                H("Failed to build collect GET endpoint url");
                            } else {
                                d("GET request", url2);
                                try {
                                    httpURLConnectionU = U(url2);
                                    try {
                                        try {
                                            httpURLConnectionU.connect();
                                            T(httpURLConnectionU);
                                            responseCode = httpURLConnectionU.getResponseCode();
                                            if (responseCode == 200) {
                                                s().O();
                                            }
                                            d("GET status", Integer.valueOf(responseCode));
                                            httpURLConnectionU.disconnect();
                                        } catch (Throwable th2) {
                                            th = th2;
                                            httpURLConnection = httpURLConnectionU;
                                            if (httpURLConnection != null) {
                                                httpURLConnection.disconnect();
                                            }
                                            throw th;
                                        }
                                    } catch (IOException e2) {
                                        e = e2;
                                        x("Network GET connection error", e);
                                        if (httpURLConnectionU != null) {
                                            httpURLConnectionU.disconnect();
                                        }
                                        responseCode = 0;
                                    }
                                } catch (IOException e3) {
                                    e = e3;
                                    httpURLConnectionU = null;
                                } catch (Throwable th3) {
                                    th = th3;
                                    httpURLConnection = null;
                                }
                                if (responseCode == 200) {
                                }
                            }
                            z4 = false;
                        } else {
                            strR2 = R(j0Var, false);
                            if (strR2 == null) {
                                n().O(j0Var, "Error formatting hit for POST upload");
                            } else {
                                bytes = strR2.getBytes();
                                if (bytes.length > e0.q.a.intValue()) {
                                    n().O(j0Var, "Hit payload exceeds size limit");
                                } else {
                                    if (j0Var.f) {
                                        strValueOf3 = String.valueOf(z.d());
                                        strValueOf4 = String.valueOf(z.f());
                                        if (strValueOf4.length() != 0) {
                                            strConcat = strValueOf3.concat(strValueOf4);
                                        } else {
                                            str = new String(strValueOf3);
                                            strConcat = str;
                                        }
                                    } else {
                                        strValueOf = String.valueOf(z.e());
                                        strValueOf2 = String.valueOf(z.f());
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
                                        A("Error trying to parse the hardcoded host url", e4);
                                        url = null;
                                    }
                                    if (url == null) {
                                        H("Failed to build collect POST endpoint url");
                                    } else if (O(url, bytes) == 200) {
                                    }
                                    z4 = false;
                                }
                            }
                        }
                        if (z4) {
                            break;
                        }
                        arrayList.add(Long.valueOf(j0Var.c));
                        if (arrayList.size() >= z.c()) {
                            break;
                        }
                    } else {
                        n().O(j0Var, "Error formatting hit for upload");
                    }
                    z4 = true;
                    if (z4) {
                        break;
                        break;
                    }
                    arrayList.add(Long.valueOf(j0Var.c));
                    if (arrayList.size() >= z.c()) {
                        break;
                        break;
                    }
                }
                return arrayList;
            }
            b.c.a.a0.d.l(!list.isEmpty());
            a(2, "Uploading batched hits. compression, count", Boolean.valueOf(z3), Integer.valueOf(list.size()), null);
            byteArrayOutputStream = new ByteArrayOutputStream();
            arrayList2 = new ArrayList();
            i = 0;
            for (j0 j0Var2 : list) {
                Objects.requireNonNull(j0Var2, "null reference");
                i3 = i + 1;
                if (i3 <= e0.h.a.intValue()) {
                    strR3 = R(j0Var2, false);
                    if (strR3 == null) {
                        n().O(j0Var2, "Error formatting hit");
                    } else {
                        bytes2 = strR3.getBytes();
                        length = bytes2.length;
                        if (length > e0.p.a.intValue()) {
                            n().O(j0Var2, "Hit size exceeds the maximum size limit");
                        } else {
                            if (byteArrayOutputStream.size() > 0) {
                                length++;
                            }
                            if (byteArrayOutputStream.size() + length > e0.r.a.intValue()) {
                                z5 = false;
                            } else {
                                try {
                                    if (byteArrayOutputStream.size() > 0) {
                                        byteArrayOutputStream.write(l);
                                    }
                                    byteArrayOutputStream.write(bytes2);
                                    i = i3;
                                } catch (IOException e5) {
                                    A("Failed to write payload when batching hits", e5);
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
                arrayList2.add(Long.valueOf(j0Var2.c));
            }
            i2 = i;
            if (i2 == 0) {
                return arrayList2;
            }
            strValueOf5 = String.valueOf(z.d());
            strValueOf6 = String.valueOf(e0.l.a);
            if (strValueOf6.length() != 0) {
                str2 = strValueOf5.concat(strValueOf6);
            } else {
                str2 = new String(strValueOf5);
            }
            try {
                url3 = new URL(str2);
            } catch (MalformedURLException e6) {
                A("Error trying to parse the hardcoded host url", e6);
                url3 = null;
            }
            r0 = url3;
            if (r0 == 0) {
                H("Failed to build batching endpoint url");
            } else {
                if (z3) {
                    byteArray = byteArrayOutputStream.toByteArray();
                    Objects.requireNonNull(byteArray, "null reference");
                    try {
                        try {
                            this.j.f1417b.getPackageName();
                            ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
                            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream2);
                            gZIPOutputStream.write(byteArray);
                            gZIPOutputStream.close();
                            byteArrayOutputStream2.close();
                            byteArray2 = byteArrayOutputStream2.toByteArray();
                            a(3, "POST compressed size, ratio %, url", Integer.valueOf(byteArray2.length), Long.valueOf((((long) byteArray2.length) * 100) / ((long) byteArray.length)), r0);
                            if (byteArray2.length > byteArray.length) {
                                f("Compressed payload is larger then uncompressed. compressed, uncompressed", Integer.valueOf(byteArray2.length), Integer.valueOf(byteArray.length));
                            }
                            if (Log.isLoggable(e0.f1411b.a, 2)) {
                                str3 = new String(byteArray);
                                if (str3.length() != 0) {
                                    str4 = "\n".concat(str3);
                                } else {
                                    str4 = new String("\n");
                                }
                                b("Post payload", str4);
                            }
                            byteArrayOutputStream = U(r0);
                            try {
                                byteArrayOutputStream.setDoOutput(true);
                                byteArrayOutputStream.addRequestProperty("Content-Encoding", "gzip");
                                byteArrayOutputStream.setFixedLengthStreamingMode(byteArray2.length);
                                byteArrayOutputStream.connect();
                                outputStream = byteArrayOutputStream.getOutputStream();
                                try {
                                    outputStream.write(byteArray2);
                                    outputStream.close();
                                    T(byteArrayOutputStream);
                                    responseCode2 = byteArrayOutputStream.getResponseCode();
                                    if (responseCode2 == 200) {
                                        s().O();
                                    }
                                    url3 = "POST status";
                                    d("POST status", Integer.valueOf(responseCode2));
                                    byteArrayOutputStream.disconnect();
                                    iO = responseCode2;
                                } catch (IOException e7) {
                                    e = e7;
                                    x("Network compressed POST connection error", e);
                                    url3 = outputStream;
                                    if (outputStream != null) {
                                        try {
                                            outputStream.close();
                                            url3 = outputStream;
                                        } catch (IOException e8) {
                                            IOException iOException = e8;
                                            A("Error closing http compressed post connection output stream", iOException);
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
                                x("Network compressed POST connection error", e);
                                url3 = outputStream;
                                if (outputStream != null) {
                                    outputStream.close();
                                    url3 = outputStream;
                                }
                                if (byteArrayOutputStream != 0) {
                                    byteArrayOutputStream.disconnect();
                                }
                                if (200 == iO) {
                                    b("Batched upload completed. Hits batched", Integer.valueOf(i2));
                                    return arrayList2;
                                }
                                b("Network error uploading hits. status code", Integer.valueOf(iO));
                                if (this.j.e.g().contains(Integer.valueOf(iO))) {
                                    D("Server instructed the client to stop batching");
                                    this.n.a();
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
                                        A("Error closing http compressed post connection output stream", e10);
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
                    iO = O(r0, byteArrayOutputStream.toByteArray());
                }
                if (200 == iO) {
                    b("Batched upload completed. Hits batched", Integer.valueOf(i2));
                    return arrayList2;
                }
                b("Network error uploading hits. status code", Integer.valueOf(iO));
                if (this.j.e.g().contains(Integer.valueOf(iO))) {
                    D("Server instructed the client to stop batching");
                    this.n.a();
                }
            }
            return Collections.emptyList();
        }
        z2 = false;
        if (z2) {
            arrayList = new ArrayList(list.size());
            while (r2.hasNext()) {
                Objects.requireNonNull(j0Var, "null reference");
                strR = R(j0Var, !j0Var.f);
                if (strR == null) {
                    if (strR.length() <= e0.m.a.intValue()) {
                        if (j0Var.f) {
                            String strD2 = z.d();
                            String strF3 = z.f();
                            strL = b.d.b.a.a.l(strR.length() + b.d.b.a.a.b(strF3, b.d.b.a.a.b(strD2, 1)), strD2, strF3, "?", strR);
                        } else {
                            String strE2 = z.e();
                            String strF4 = z.f();
                            strL = b.d.b.a.a.l(strR.length() + b.d.b.a.a.b(strF4, b.d.b.a.a.b(strE2, 1)), strE2, strF4, "?", strR);
                        }
                        url2 = new URL(strL);
                        if (url2 == null) {
                            H("Failed to build collect GET endpoint url");
                        } else {
                            d("GET request", url2);
                            httpURLConnectionU = U(url2);
                            httpURLConnectionU.connect();
                            T(httpURLConnectionU);
                            responseCode = httpURLConnectionU.getResponseCode();
                            if (responseCode == 200) {
                                s().O();
                            }
                            d("GET status", Integer.valueOf(responseCode));
                            httpURLConnectionU.disconnect();
                            if (responseCode == 200) {
                            }
                        }
                        z4 = false;
                    } else {
                        strR2 = R(j0Var, false);
                        if (strR2 == null) {
                            n().O(j0Var, "Error formatting hit for POST upload");
                        } else {
                            bytes = strR2.getBytes();
                            if (bytes.length > e0.q.a.intValue()) {
                                n().O(j0Var, "Hit payload exceeds size limit");
                            } else {
                                if (j0Var.f) {
                                    strValueOf3 = String.valueOf(z.d());
                                    strValueOf4 = String.valueOf(z.f());
                                    if (strValueOf4.length() != 0) {
                                        strConcat = strValueOf3.concat(strValueOf4);
                                    } else {
                                        str = new String(strValueOf3);
                                        strConcat = str;
                                    }
                                } else {
                                    strValueOf = String.valueOf(z.e());
                                    strValueOf2 = String.valueOf(z.f());
                                    if (strValueOf2.length() != 0) {
                                        strConcat = strValueOf.concat(strValueOf2);
                                    } else {
                                        str = new String(strValueOf);
                                        strConcat = str;
                                    }
                                }
                                url = new URL(strConcat);
                                if (url == null) {
                                    H("Failed to build collect POST endpoint url");
                                } else if (O(url, bytes) == 200) {
                                }
                                z4 = false;
                            }
                        }
                    }
                    if (z4) {
                        break;
                        break;
                    }
                    arrayList.add(Long.valueOf(j0Var.c));
                    if (arrayList.size() >= z.c()) {
                        break;
                        break;
                    }
                } else {
                    n().O(j0Var, "Error formatting hit for upload");
                }
                z4 = true;
                if (z4) {
                    break;
                    break;
                }
                arrayList.add(Long.valueOf(j0Var.c));
                if (arrayList.size() >= z.c()) {
                    break;
                    break;
                }
            }
            return arrayList;
        }
        b.c.a.a0.d.l(!list.isEmpty());
        a(2, "Uploading batched hits. compression, count", Boolean.valueOf(z3), Integer.valueOf(list.size()), null);
        byteArrayOutputStream = new ByteArrayOutputStream();
        arrayList2 = new ArrayList();
        i = 0;
        while (r2.hasNext()) {
            Objects.requireNonNull(j0Var2, "null reference");
            i3 = i + 1;
            if (i3 <= e0.h.a.intValue()) {
                strR3 = R(j0Var2, false);
                if (strR3 == null) {
                    n().O(j0Var2, "Error formatting hit");
                } else {
                    bytes2 = strR3.getBytes();
                    length = bytes2.length;
                    if (length > e0.p.a.intValue()) {
                        n().O(j0Var2, "Hit size exceeds the maximum size limit");
                    } else {
                        if (byteArrayOutputStream.size() > 0) {
                            length++;
                        }
                        if (byteArrayOutputStream.size() + length > e0.r.a.intValue()) {
                            z5 = false;
                        } else {
                            if (byteArrayOutputStream.size() > 0) {
                                byteArrayOutputStream.write(l);
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
            arrayList2.add(Long.valueOf(j0Var2.c));
        }
        i2 = i;
        if (i2 == 0) {
            return arrayList2;
        }
        strValueOf5 = String.valueOf(z.d());
        strValueOf6 = String.valueOf(e0.l.a);
        if (strValueOf6.length() != 0) {
            str2 = strValueOf5.concat(strValueOf6);
        } else {
            str2 = new String(strValueOf5);
        }
        url3 = new URL(str2);
        r0 = url3;
        if (r0 == 0) {
            H("Failed to build batching endpoint url");
        } else {
            if (z3) {
                byteArray = byteArrayOutputStream.toByteArray();
                Objects.requireNonNull(byteArray, "null reference");
                this.j.f1417b.getPackageName();
                ByteArrayOutputStream byteArrayOutputStream3 = new ByteArrayOutputStream();
                GZIPOutputStream gZIPOutputStream2 = new GZIPOutputStream(byteArrayOutputStream3);
                gZIPOutputStream2.write(byteArray);
                gZIPOutputStream2.close();
                byteArrayOutputStream3.close();
                byteArray2 = byteArrayOutputStream3.toByteArray();
                a(3, "POST compressed size, ratio %, url", Integer.valueOf(byteArray2.length), Long.valueOf((((long) byteArray2.length) * 100) / ((long) byteArray.length)), r0);
                if (byteArray2.length > byteArray.length) {
                    f("Compressed payload is larger then uncompressed. compressed, uncompressed", Integer.valueOf(byteArray2.length), Integer.valueOf(byteArray.length));
                }
                if (Log.isLoggable(e0.f1411b.a, 2)) {
                    str3 = new String(byteArray);
                    if (str3.length() != 0) {
                        str4 = "\n".concat(str3);
                    } else {
                        str4 = new String("\n");
                    }
                    b("Post payload", str4);
                }
                byteArrayOutputStream = U(r0);
                byteArrayOutputStream.setDoOutput(true);
                byteArrayOutputStream.addRequestProperty("Content-Encoding", "gzip");
                byteArrayOutputStream.setFixedLengthStreamingMode(byteArray2.length);
                byteArrayOutputStream.connect();
                outputStream = byteArrayOutputStream.getOutputStream();
                outputStream.write(byteArray2);
                outputStream.close();
                T(byteArrayOutputStream);
                responseCode2 = byteArrayOutputStream.getResponseCode();
                if (responseCode2 == 200) {
                    s().O();
                }
                url3 = "POST status";
                d("POST status", Integer.valueOf(responseCode2));
                byteArrayOutputStream.disconnect();
                iO = responseCode2;
            } else {
                iO = O(r0, byteArrayOutputStream.toByteArray());
            }
            if (200 == iO) {
                b("Batched upload completed. Hits batched", Integer.valueOf(i2));
                return arrayList2;
            }
            b("Network error uploading hits. status code", Integer.valueOf(iO));
            if (this.j.e.g().contains(Integer.valueOf(iO))) {
                D("Server instructed the client to stop batching");
                this.n.a();
            }
        }
        return Collections.emptyList();
    }

    public final boolean W() {
        b.i.a.f.b.f.b();
        N();
        NetworkInfo activeNetworkInfo = null;
        try {
            activeNetworkInfo = ((ConnectivityManager) this.j.f1417b.getSystemService("connectivity")).getActiveNetworkInfo();
        } catch (SecurityException unused) {
        }
        if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
            return true;
        }
        C("No network connectivity");
        return false;
    }
}
