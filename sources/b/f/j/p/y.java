package b.f.j.p;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.util.Objects;

/* JADX INFO: compiled from: HttpUrlConnectionNetworkFetcher.java */
/* JADX INFO: loaded from: classes3.dex */
public class y implements Runnable {
    public final /* synthetic */ a0$a j;
    public final /* synthetic */ o0$a k;
    public final /* synthetic */ a0 l;

    public y(a0 a0Var, a0$a a0_a, o0$a o0_a) {
        this.l = a0Var;
        this.j = a0_a;
        this.k = o0_a;
    }

    /* JADX WARN: Code duplicated, block: B:33:0x0059  */
    /* JADX WARN: Code duplicated, block: B:37:0x0052 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:48:? A[SYNTHETIC] */
    @Override // java.lang.Runnable
    public void run() throws Throwable {
        HttpURLConnection httpURLConnectionA;
        a0 a0Var = this.l;
        a0$a a0_a = this.j;
        o0$a o0_a = this.k;
        Objects.requireNonNull(a0Var);
        InputStream inputStream = null;
        try {
            httpURLConnectionA = a0Var.a(a0_a.f642b.e().c, 5);
            try {
                try {
                    a0_a.e = a0Var.c.now();
                    if (httpURLConnectionA != null) {
                        inputStream = httpURLConnectionA.getInputStream();
                        ((n0$a) o0_a).b(inputStream, -1);
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
                    ((n0$a) o0_a).a(e);
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
