package okhttp3;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;
import p507d0.p579g0.C12086c;
import p507d0.p591y.C12201b;
import p507d0.p592z.p594d.C12238m;
import p600f0.p601e0.C12272c;
import p615g0.InterfaceC12390g;

/* JADX INFO: compiled from: ResponseBody.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class ResponseBody implements Closeable {

    /* JADX INFO: renamed from: k, reason: from kotlin metadata */
    public Reader reader;

    /* JADX INFO: renamed from: okhttp3.ResponseBody$a */
    /* JADX INFO: compiled from: ResponseBody.kt */
    public static final class C12938a extends Reader {

        /* JADX INFO: renamed from: j */
        public boolean f27580j;

        /* JADX INFO: renamed from: k */
        public Reader f27581k;

        /* JADX INFO: renamed from: l */
        public final InterfaceC12390g f27582l;

        /* JADX INFO: renamed from: m */
        public final Charset f27583m;

        public C12938a(InterfaceC12390g interfaceC12390g, Charset charset) {
            C12238m.checkParameterIsNotNull(interfaceC12390g, "source");
            C12238m.checkParameterIsNotNull(charset, "charset");
            this.f27582l = interfaceC12390g;
            this.f27583m = charset;
        }

        @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            this.f27580j = true;
            Reader reader = this.f27581k;
            if (reader != null) {
                reader.close();
            } else {
                this.f27582l.close();
            }
        }

        @Override // java.io.Reader
        public int read(char[] cArr, int i, int i2) throws IOException {
            C12238m.checkParameterIsNotNull(cArr, "cbuf");
            if (this.f27580j) {
                throw new IOException("Stream closed");
            }
            Reader inputStreamReader = this.f27581k;
            if (inputStreamReader == null) {
                inputStreamReader = new InputStreamReader(this.f27582l.mo10470u0(), C12272c.m10138s(this.f27582l, this.f27583m));
                this.f27581k = inputStreamReader;
            }
            return inputStreamReader.read(cArr, i, i2);
        }
    }

    /* JADX INFO: renamed from: a */
    public abstract long mo10103a();

    /* JADX INFO: renamed from: b */
    public abstract MediaType mo10104b();

    /* JADX INFO: renamed from: c */
    public abstract InterfaceC12390g mo10105c();

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        C12272c.m10123d(mo10105c());
    }

    /* JADX INFO: renamed from: d */
    public final String m10998d() throws IOException {
        Charset charsetM10966a;
        InterfaceC12390g interfaceC12390gMo10105c = mo10105c();
        try {
            MediaType mediaTypeMo10104b = mo10104b();
            if (mediaTypeMo10104b == null || (charsetM10966a = mediaTypeMo10104b.m10966a(C12086c.f25136a)) == null) {
                charsetM10966a = C12086c.f25136a;
            }
            String strMo10437M = interfaceC12390gMo10105c.mo10437M(C12272c.m10138s(interfaceC12390gMo10105c, charsetM10966a));
            C12201b.closeFinally(interfaceC12390gMo10105c, null);
            return strMo10437M;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                C12201b.closeFinally(interfaceC12390gMo10105c, th);
                throw th2;
            }
        }
    }
}
