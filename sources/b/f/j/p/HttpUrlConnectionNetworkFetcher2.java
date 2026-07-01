package b.f.j.p;

import b.f.j.p.HttpUrlConnectionNetworkFetcher;
import b.f.j.p.NetworkFetchProducer;
import b.f.j.p.NetworkFetcher2;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.util.Objects;

/* JADX INFO: renamed from: b.f.j.p.y, reason: use source file name */
/* JADX INFO: compiled from: HttpUrlConnectionNetworkFetcher.java */
/* JADX INFO: loaded from: classes3.dex */
public class HttpUrlConnectionNetworkFetcher2 implements Runnable {
    public final /* synthetic */ HttpUrlConnectionNetworkFetcher.a j;
    public final /* synthetic */ NetworkFetcher2.a k;
    public final /* synthetic */ HttpUrlConnectionNetworkFetcher l;

    public HttpUrlConnectionNetworkFetcher2(HttpUrlConnectionNetworkFetcher httpUrlConnectionNetworkFetcher, HttpUrlConnectionNetworkFetcher.a aVar, NetworkFetcher2.a aVar2) {
        this.l = httpUrlConnectionNetworkFetcher;
        this.j = aVar;
        this.k = aVar2;
    }

    /* JADX WARN: Code duplicated, block: B:33:0x0059  */
    /* JADX WARN: Code duplicated, block: B:37:0x0052 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:48:? A[SYNTHETIC] */
    @Override // java.lang.Runnable
    public void run() throws Throwable {
        HttpURLConnection httpURLConnectionA;
        HttpUrlConnectionNetworkFetcher httpUrlConnectionNetworkFetcher = this.l;
        HttpUrlConnectionNetworkFetcher.a aVar = this.j;
        NetworkFetcher2.a aVar2 = this.k;
        Objects.requireNonNull(httpUrlConnectionNetworkFetcher);
        InputStream inputStream = null;
        try {
            httpURLConnectionA = httpUrlConnectionNetworkFetcher.a(aVar.f642b.e().c, 5);
            try {
                try {
                    aVar.e = httpUrlConnectionNetworkFetcher.c.now();
                    if (httpURLConnectionA != null) {
                        inputStream = httpURLConnectionA.getInputStream();
                        ((NetworkFetchProducer.a) aVar2).b(inputStream, -1);
                    }
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException unused) {
                        }
                    }
                    if (httpURLConnectionA == null) {
                        return;
                    }
                } catch (IOException e) {
                    e = e;
                    ((NetworkFetchProducer.a) aVar2).a(e);
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException unused2) {
                        }
                    }
                    if (httpURLConnectionA == null) {
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
                if (httpURLConnectionA != null) {
                    throw th;
                }
                httpURLConnectionA.disconnect();
                throw th;
            }
        } catch (IOException e2) {
            e = e2;
            httpURLConnectionA = null;
        } catch (Throwable th2) {
            th = th2;
            httpURLConnectionA = null;
            if (inputStream != null) {
                inputStream.close();
            }
            if (httpURLConnectionA != null) {
                throw th;
            }
            httpURLConnectionA.disconnect();
            throw th;
        }
        httpURLConnectionA.disconnect();
    }
}
