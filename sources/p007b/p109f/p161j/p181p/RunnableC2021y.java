package p007b.p109f.p161j.p181p;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.util.Objects;

/* JADX INFO: renamed from: b.f.j.p.y */
/* JADX INFO: compiled from: HttpUrlConnectionNetworkFetcher.java */
/* JADX INFO: loaded from: classes3.dex */
public class RunnableC2021y implements Runnable {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ C1963a0.a f4261j;

    /* JADX INFO: renamed from: k */
    public final /* synthetic */ InterfaceC2002o0.a f4262k;

    /* JADX INFO: renamed from: l */
    public final /* synthetic */ C1963a0 f4263l;

    public RunnableC2021y(C1963a0 c1963a0, C1963a0.a aVar, InterfaceC2002o0.a aVar2) {
        this.f4263l = c1963a0;
        this.f4261j = aVar;
        this.f4262k = aVar2;
    }

    /* JADX WARN: Code duplicated, block: B:33:0x0059  */
    /* JADX WARN: Code duplicated, block: B:37:0x0052 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:48:? A[SYNTHETIC] */
    @Override // java.lang.Runnable
    public void run() throws Throwable {
        HttpURLConnection httpURLConnectionM1418a;
        C1963a0 c1963a0 = this.f4263l;
        C1963a0.a aVar = this.f4261j;
        InterfaceC2002o0.a aVar2 = this.f4262k;
        Objects.requireNonNull(c1963a0);
        InputStream inputStream = null;
        try {
            httpURLConnectionM1418a = c1963a0.m1418a(aVar.f4259b.mo1447e().f19585c, 5);
            try {
                try {
                    aVar.f3991e = c1963a0.f3989c.now();
                    if (httpURLConnectionM1418a != null) {
                        inputStream = httpURLConnectionM1418a.getInputStream();
                        ((C2000n0.a) aVar2).m1509b(inputStream, -1);
                    }
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException unused) {
                        }
                    }
                    if (httpURLConnectionM1418a == null) {
                        return;
                    }
                } catch (IOException e) {
                    e = e;
                    ((C2000n0.a) aVar2).m1508a(e);
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException unused2) {
                        }
                    }
                    if (httpURLConnectionM1418a == null) {
                        return;
                    }
                }
            } catch (Throwable th) {
                th = th;
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException unused3) {
                    }
                }
                if (httpURLConnectionM1418a != null) {
                    throw th;
                }
                httpURLConnectionM1418a.disconnect();
                throw th;
            }
        } catch (IOException e2) {
            e = e2;
            httpURLConnectionM1418a = null;
        } catch (Throwable th2) {
            th = th2;
            httpURLConnectionM1418a = null;
            if (inputStream != null) {
                inputStream.close();
            }
            if (httpURLConnectionM1418a != null) {
                throw th;
            }
            httpURLConnectionM1418a.disconnect();
            throw th;
        }
        httpURLConnectionM1418a.disconnect();
    }
}
