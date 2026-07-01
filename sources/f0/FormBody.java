package f0;

import androidx.browser.trusted.sharing.ShareTarget;
import d0.z.d.Intrinsics3;
import f0.e0.Util7;
import g0.Buffer3;
import java.io.EOFException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okio.BufferedSink;

/* JADX INFO: renamed from: f0.u, reason: use source file name */
/* JADX INFO: compiled from: FormBody.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class FormBody extends RequestBody {
    public static final MediaType a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<String> f3678b;
    public final List<String> c;

    /* JADX INFO: renamed from: f0.u$a */
    /* JADX INFO: compiled from: FormBody.kt */
    public static final class a {
        public final Charset c = null;
        public final List<String> a = new ArrayList();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final List<String> f3679b = new ArrayList();
    }

    static {
        MediaType.Companion companion = MediaType.INSTANCE;
        a = MediaType.Companion.a(ShareTarget.ENCODING_TYPE_URL_ENCODED);
    }

    public FormBody(List<String> list, List<String> list2) {
        Intrinsics3.checkParameterIsNotNull(list, "encodedNames");
        Intrinsics3.checkParameterIsNotNull(list2, "encodedValues");
        this.f3678b = Util7.z(list);
        this.c = Util7.z(list2);
    }

    public final long a(BufferedSink bufferedSink, boolean z2) throws EOFException {
        Buffer3 buffer3G;
        if (z2) {
            buffer3G = new Buffer3();
        } else {
            if (bufferedSink == null) {
                Intrinsics3.throwNpe();
            }
            buffer3G = bufferedSink.g();
        }
        int size = this.f3678b.size();
        for (int i = 0; i < size; i++) {
            if (i > 0) {
                buffer3G.T(38);
            }
            buffer3G.b0(this.f3678b.get(i));
            buffer3G.T(61);
            buffer3G.b0(this.c.get(i));
        }
        if (!z2) {
            return 0L;
        }
        long j = buffer3G.k;
        buffer3G.skip(j);
        return j;
    }

    @Override // okhttp3.RequestBody
    public long contentLength() {
        return a(null, true);
    }

    @Override // okhttp3.RequestBody
    public MediaType contentType() {
        return a;
    }

    @Override // okhttp3.RequestBody
    public void writeTo(BufferedSink bufferedSink) throws IOException {
        Intrinsics3.checkParameterIsNotNull(bufferedSink, "sink");
        a(bufferedSink, false);
    }
}
