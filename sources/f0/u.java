package f0;

import androidx.browser.trusted.sharing.ShareTarget;
import java.io.EOFException;
import java.io.IOException;
import java.util.List;
import okhttp3.MediaType;
import okhttp3.MediaType$a;
import okhttp3.RequestBody;
import okio.BufferedSink;

/* JADX INFO: compiled from: FormBody.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class u extends RequestBody {
    public static final MediaType a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<String> f3678b;
    public final List<String> c;

    static {
        MediaType$a mediaType$a = MediaType.c;
        a = MediaType$a.a(ShareTarget.ENCODING_TYPE_URL_ENCODED);
    }

    public u(List<String> list, List<String> list2) {
        d0.z.d.m.checkParameterIsNotNull(list, "encodedNames");
        d0.z.d.m.checkParameterIsNotNull(list2, "encodedValues");
        this.f3678b = f0.e0.c.z(list);
        this.c = f0.e0.c.z(list2);
    }

    public final long a(BufferedSink bufferedSink, boolean z2) throws EOFException {
        g0.e eVarG;
        if (z2) {
            eVarG = new g0.e();
        } else {
            if (bufferedSink == null) {
                d0.z.d.m.throwNpe();
            }
            eVarG = bufferedSink.g();
        }
        int size = this.f3678b.size();
        for (int i = 0; i < size; i++) {
            if (i > 0) {
                eVarG.T(38);
            }
            eVarG.b0(this.f3678b.get(i));
            eVarG.T(61);
            eVarG.b0(this.c.get(i));
        }
        if (!z2) {
            return 0L;
        }
        long j = eVarG.k;
        eVarG.skip(j);
        return j;
    }

    @Override // okhttp3.RequestBody
    /* JADX INFO: renamed from: contentLength */
    public long getSize() {
        return a(null, true);
    }

    @Override // okhttp3.RequestBody
    public MediaType contentType() {
        return a;
    }

    @Override // okhttp3.RequestBody
    public void writeTo(BufferedSink bufferedSink) throws IOException {
        d0.z.d.m.checkParameterIsNotNull(bufferedSink, "sink");
        a(bufferedSink, false);
    }
}
