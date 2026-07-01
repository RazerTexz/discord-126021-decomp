package f0.e0.h;

import d0.z.d.m;
import okhttp3.MediaType;
import okhttp3.MediaType$a;
import okhttp3.ResponseBody;

/* JADX INFO: compiled from: RealResponseBody.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class h extends ResponseBody {
    public final String l;
    public final long m;
    public final g0.g n;

    public h(String str, long j, g0.g gVar) {
        m.checkParameterIsNotNull(gVar, "source");
        this.l = str;
        this.m = j;
        this.n = gVar;
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
        MediaType$a mediaType$a = MediaType.c;
        return MediaType$a.b(str);
    }

    @Override // okhttp3.ResponseBody
    public g0.g c() {
        return this.n;
    }
}
