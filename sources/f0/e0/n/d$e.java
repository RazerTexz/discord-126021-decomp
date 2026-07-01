package f0.e0.n;

import d0.z.d.m;
import java.io.IOException;
import java.net.SocketTimeoutException;
import okio.ByteString;

/* JADX INFO: compiled from: TaskQueue.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class d$e extends f0.e0.f.a {
    public final /* synthetic */ long e;
    public final /* synthetic */ d f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d$e(String str, String str2, long j, d dVar, String str3, d$c d_c, f fVar) {
        super(str2, true);
        this.e = j;
        this.f = dVar;
    }

    @Override // f0.e0.f.a
    public long a() {
        i iVar;
        d dVar = this.f;
        synchronized (dVar) {
            if (!dVar.p && (iVar = dVar.f) != null) {
                int i = dVar.t ? dVar.q : -1;
                dVar.q++;
                dVar.t = true;
                if (i != -1) {
                    StringBuilder sbU = b.d.b.a.a.U("sent ping but didn't receive pong within ");
                    sbU.append(dVar.f3658x);
                    sbU.append("ms (after ");
                    sbU.append(i - 1);
                    sbU.append(" successful ping/pongs)");
                    dVar.i(new SocketTimeoutException(sbU.toString()), null);
                } else {
                    try {
                        ByteString byteString = ByteString.j;
                        m.checkParameterIsNotNull(byteString, "payload");
                        iVar.b(9, byteString);
                    } catch (IOException e) {
                        dVar.i(e, null);
                    }
                }
            }
        }
        return this.e;
    }
}
