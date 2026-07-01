package f0.e0.h;

import d0.z.d.Intrinsics3;
import g0.BufferedSource;
import okhttp3.MediaType;
import okhttp3.ResponseBody;

/* JADX INFO: renamed from: f0.e0.h.h, reason: use source file name */
/* JADX INFO: compiled from: RealResponseBody.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class RealResponseBody extends ResponseBody {
    public final String l;
    public final long m;
    public final BufferedSource n;

    public RealResponseBody(String str, long j, BufferedSource bufferedSource) {
        Intrinsics3.checkParameterIsNotNull(bufferedSource, "source");
        this.l = str;
        this.m = j;
        this.n = bufferedSource;
    }

    @Override // okhttp3.ResponseBody
    public long a() {
        return this.m;
    }

    @Override // okhttp3.ResponseBody
    public MediaType b() {
        String str = this.l;
        if (str == null) {
            return null;
        }
        MediaType.Companion companion = MediaType.INSTANCE;
        return MediaType.Companion.b(str);
    }

    @Override // okhttp3.ResponseBody
    public BufferedSource c() {
        return this.n;
    }
}
