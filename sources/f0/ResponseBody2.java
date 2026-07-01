package f0;

import g0.BufferedSource;
import okhttp3.MediaType;
import okhttp3.ResponseBody;

/* JADX INFO: renamed from: f0.b0, reason: use source file name */
/* JADX INFO: compiled from: ResponseBody.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class ResponseBody2 extends ResponseBody {
    public final /* synthetic */ BufferedSource l;
    public final /* synthetic */ MediaType m;
    public final /* synthetic */ long n;

    public ResponseBody2(BufferedSource bufferedSource, MediaType mediaType, long j) {
        this.l = bufferedSource;
        this.m = mediaType;
        this.n = j;
    }

    @Override // okhttp3.ResponseBody
    public long a() {
        return this.n;
    }

    @Override // okhttp3.ResponseBody
    public MediaType b() {
        return this.m;
    }

    @Override // okhttp3.ResponseBody
    public BufferedSource c() {
        return this.l;
    }
}
