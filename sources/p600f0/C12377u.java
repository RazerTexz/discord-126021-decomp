package p600f0;

import androidx.browser.trusted.sharing.ShareTarget;
import java.io.EOFException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okio.BufferedSink;
import p507d0.p592z.p594d.C12238m;
import p600f0.p601e0.C12272c;
import p615g0.C12388e;

/* JADX INFO: renamed from: f0.u */
/* JADX INFO: compiled from: FormBody.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C12377u extends RequestBody {

    /* JADX INFO: renamed from: a */
    public static final MediaType f25963a;

    /* JADX INFO: renamed from: b */
    public final List<String> f25964b;

    /* JADX INFO: renamed from: c */
    public final List<String> f25965c;

    /* JADX INFO: renamed from: f0.u$a */
    /* JADX INFO: compiled from: FormBody.kt */
    public static final class a {

        /* JADX INFO: renamed from: c */
        public final Charset f25968c = null;

        /* JADX INFO: renamed from: a */
        public final List<String> f25966a = new ArrayList();

        /* JADX INFO: renamed from: b */
        public final List<String> f25967b = new ArrayList();
    }

    static {
        MediaType.Companion companion = MediaType.INSTANCE;
        f25963a = MediaType.Companion.m10967a(ShareTarget.ENCODING_TYPE_URL_ENCODED);
    }

    public C12377u(List<String> list, List<String> list2) {
        C12238m.checkParameterIsNotNull(list, "encodedNames");
        C12238m.checkParameterIsNotNull(list2, "encodedValues");
        this.f25964b = C12272c.m10145z(list);
        this.f25965c = C12272c.m10145z(list2);
    }

    /* JADX INFO: renamed from: a */
    public final long m10394a(BufferedSink bufferedSink, boolean z2) throws EOFException {
        C12388e c12388eMo10457g;
        if (z2) {
            c12388eMo10457g = new C12388e();
        } else {
            if (bufferedSink == null) {
                C12238m.throwNpe();
            }
            c12388eMo10457g = bufferedSink.mo10457g();
        }
        int size = this.f25964b.size();
        for (int i = 0; i < size; i++) {
            if (i > 0) {
                c12388eMo10457g.m10444T(38);
            }
            c12388eMo10457g.m10452b0(this.f25964b.get(i));
            c12388eMo10457g.m10444T(61);
            c12388eMo10457g.m10452b0(this.f25965c.get(i));
        }
        if (!z2) {
            return 0L;
        }
        long j = c12388eMo10457g.f26080k;
        c12388eMo10457g.skip(j);
        return j;
    }

    @Override // okhttp3.RequestBody
    public long contentLength() {
        return m10394a(null, true);
    }

    @Override // okhttp3.RequestBody
    public MediaType contentType() {
        return f25963a;
    }

    @Override // okhttp3.RequestBody
    public void writeTo(BufferedSink bufferedSink) throws IOException {
        C12238m.checkParameterIsNotNull(bufferedSink, "sink");
        m10394a(bufferedSink, false);
    }
}
