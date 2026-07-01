package f0.e0.j;

import java.io.IOException;

/* JADX INFO: compiled from: TaskQueue.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class e$f extends f0.e0.f.a {
    public final /* synthetic */ e e;
    public final /* synthetic */ int f;
    public final /* synthetic */ long g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e$f(String str, boolean z2, String str2, boolean z3, e eVar, int i, long j) {
        super(str2, z3);
        this.e = eVar;
        this.f = i;
        this.g = j;
    }

    @Override // f0.e0.f.a
    public long a() {
        try {
            this.e.K.q(this.f, this.g);
            return -1L;
        } catch (IOException e) {
            e eVar = this.e;
            a aVar = a.PROTOCOL_ERROR;
            eVar.a(aVar, aVar, e);
            return -1L;
        }
    }
}
