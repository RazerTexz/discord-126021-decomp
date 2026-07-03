package p007b.p225i.p226a.p288f.p330i.p332b;

import androidx.annotation.WorkerThread;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;
import p007b.p085c.p086a.p087a0.C1460d;

/* JADX INFO: renamed from: b.i.a.f.i.b.c4 */
/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
@WorkerThread
public final class RunnableC3997c4 implements Runnable {

    /* JADX INFO: renamed from: j */
    public final URL f10586j;

    /* JADX INFO: renamed from: k */
    public final byte[] f10587k;

    /* JADX INFO: renamed from: l */
    public final InterfaceC4256z3 f10588l;

    /* JADX INFO: renamed from: m */
    public final String f10589m;

    /* JADX INFO: renamed from: n */
    public final Map<String, String> f10590n;

    /* JADX INFO: renamed from: o */
    public final /* synthetic */ C4234x3 f10591o;

    public RunnableC3997c4(C4234x3 c4234x3, String str, URL url, byte[] bArr, Map<String, String> map, InterfaceC4256z3 interfaceC4256z3) {
        this.f10591o = c4234x3;
        C1460d.m583w(str);
        this.f10586j = url;
        this.f10587k = bArr;
        this.f10588l = interfaceC4256z3;
        this.f10589m = str;
        this.f10590n = map;
    }

    /* JADX WARN: Code duplicated, block: B:47:0x00e1  */
    /* JADX WARN: Code duplicated, block: B:60:0x011a  */
    /* JADX WARN: Code duplicated, block: B:63:0x0102 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:65:0x00c9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        HttpURLConnection httpURLConnectionM5962s;
        Map<String, List<String>> map;
        Map<String, List<String>> map2;
        Throwable th;
        IOException iOException;
        int i;
        int responseCode;
        this.f10591o.mo5847a();
        OutputStream outputStream = null;
        try {
            httpURLConnectionM5962s = this.f10591o.m5962s(this.f10586j);
            try {
                Map<String, String> map3 = this.f10590n;
                if (map3 != null) {
                    for (Map.Entry<String, String> entry : map3.entrySet()) {
                        httpURLConnectionM5962s.addRequestProperty(entry.getKey(), entry.getValue());
                    }
                }
                if (this.f10587k != null) {
                    byte[] bArrM5840T = this.f10591o.m5683m().m5840T(this.f10587k);
                    this.f10591o.mo5726g().f11149n.m5861b("Uploading data. size", Integer.valueOf(bArrM5840T.length));
                    httpURLConnectionM5962s.setDoOutput(true);
                    httpURLConnectionM5962s.addRequestProperty("Content-Encoding", "gzip");
                    httpURLConnectionM5962s.setFixedLengthStreamingMode(bArrM5840T.length);
                    httpURLConnectionM5962s.connect();
                    OutputStream outputStream2 = httpURLConnectionM5962s.getOutputStream();
                    try {
                        outputStream2.write(bArrM5840T);
                        outputStream2.close();
                    } catch (IOException e) {
                        map2 = null;
                        iOException = e;
                        outputStream = outputStream2;
                        responseCode = 0;
                        if (outputStream != null) {
                            try {
                                outputStream.close();
                            } catch (IOException e2) {
                                this.f10591o.mo5726g().f11141f.m5862c("Error closing HTTP compressed POST connection output stream. appId", C4157q3.m5788s(this.f10589m), e2);
                            }
                        }
                        if (httpURLConnectionM5962s != null) {
                            httpURLConnectionM5962s.disconnect();
                        }
                        this.f10591o.mo5725f().m5852v(new RunnableC4245y3(this.f10589m, this.f10588l, responseCode, iOException, null, map2, null));
                    } catch (Throwable th2) {
                        map = null;
                        th = th2;
                        outputStream = outputStream2;
                        i = 0;
                        if (outputStream != null) {
                            try {
                                outputStream.close();
                            } catch (IOException e3) {
                                this.f10591o.mo5726g().f11141f.m5862c("Error closing HTTP compressed POST connection output stream. appId", C4157q3.m5788s(this.f10589m), e3);
                            }
                        }
                        if (httpURLConnectionM5962s != null) {
                            httpURLConnectionM5962s.disconnect();
                        }
                        this.f10591o.mo5725f().m5852v(new RunnableC4245y3(this.f10589m, this.f10588l, i, null, null, map, null));
                        throw th;
                    }
                }
                responseCode = httpURLConnectionM5962s.getResponseCode();
                try {
                    Map<String, List<String>> headerFields = httpURLConnectionM5962s.getHeaderFields();
                    try {
                        byte[] bArrM5961t = C4234x3.m5961t(httpURLConnectionM5962s);
                        httpURLConnectionM5962s.disconnect();
                        this.f10591o.mo5725f().m5852v(new RunnableC4245y3(this.f10589m, this.f10588l, responseCode, null, bArrM5961t, headerFields, null));
                    } catch (IOException e4) {
                        e = e4;
                        map2 = headerFields;
                        iOException = e;
                        if (outputStream != null) {
                            outputStream.close();
                        }
                        if (httpURLConnectionM5962s != null) {
                            httpURLConnectionM5962s.disconnect();
                        }
                        this.f10591o.mo5725f().m5852v(new RunnableC4245y3(this.f10589m, this.f10588l, responseCode, iOException, null, map2, null));
                    } catch (Throwable th3) {
                        th = th3;
                        i = responseCode;
                        map = headerFields;
                        if (outputStream != null) {
                            outputStream.close();
                        }
                        if (httpURLConnectionM5962s != null) {
                            httpURLConnectionM5962s.disconnect();
                        }
                        this.f10591o.mo5725f().m5852v(new RunnableC4245y3(this.f10589m, this.f10588l, i, null, null, map, null));
                        throw th;
                    }
                } catch (IOException e5) {
                    e = e5;
                    map2 = null;
                } catch (Throwable th4) {
                    map = null;
                    th = th4;
                    i = responseCode;
                }
            } catch (IOException e6) {
                e = e6;
                map2 = null;
                iOException = e;
                responseCode = 0;
                if (outputStream != null) {
                    outputStream.close();
                }
                if (httpURLConnectionM5962s != null) {
                    httpURLConnectionM5962s.disconnect();
                }
                this.f10591o.mo5725f().m5852v(new RunnableC4245y3(this.f10589m, this.f10588l, responseCode, iOException, null, map2, null));
            } catch (Throwable th5) {
                th = th5;
                map = null;
                th = th;
                i = 0;
                if (outputStream != null) {
                    outputStream.close();
                }
                if (httpURLConnectionM5962s != null) {
                    httpURLConnectionM5962s.disconnect();
                }
                this.f10591o.mo5725f().m5852v(new RunnableC4245y3(this.f10589m, this.f10588l, i, null, null, map, null));
                throw th;
            }
        } catch (IOException e7) {
            e = e7;
            httpURLConnectionM5962s = null;
            map2 = null;
        } catch (Throwable th6) {
            th = th6;
            httpURLConnectionM5962s = null;
            map = null;
        }
    }
}
