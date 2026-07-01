package f0.e0.n;

import java.io.IOException;

/* JADX INFO: compiled from: RealWebSocket.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class d$d extends f0.e0.f.a {
    public final /* synthetic */ d e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d$d(d dVar) {
        super(b.d.b.a.a.J(new StringBuilder(), dVar.h, " writer"), false, 2);
        this.e = dVar;
    }

    @Override // f0.e0.f.a
    public long a() {
        try {
            return this.e.m() ? 0L : -1L;
        } catch (IOException e) {
            this.e.i(e, null);
            return -1L;
        }
    }
}
