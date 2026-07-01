package f0.e0.j;

import java.net.Socket;
import okio.BufferedSink;

/* JADX INFO: compiled from: Http2Connection.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class e$b {
    public Socket a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f3642b;
    public g0.g c;
    public BufferedSink d;
    public e$c e;
    public r f;
    public int g;
    public boolean h;
    public final f0.e0.f.d i;

    public e$b(boolean z2, f0.e0.f.d dVar) {
        d0.z.d.m.checkParameterIsNotNull(dVar, "taskRunner");
        this.h = z2;
        this.i = dVar;
        this.e = e$c.a;
        this.f = r.a;
    }
}
