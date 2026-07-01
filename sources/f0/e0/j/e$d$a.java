package f0.e0.j;

import f0.e0.k.h$a;
import java.io.IOException;
import java.util.List;

/* JADX INFO: compiled from: TaskQueue.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class e$d$a extends f0.e0.f.a {
    public final /* synthetic */ n e;
    public final /* synthetic */ e$d f;
    public final /* synthetic */ List g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e$d$a(String str, boolean z2, String str2, boolean z3, n nVar, e$d e_d, n nVar2, int i, List list, boolean z4) {
        super(str2, z3);
        this.e = nVar;
        this.f = e_d;
        this.g = list;
    }

    @Override // f0.e0.f.a
    public long a() {
        try {
            this.f.k.m.b(this.e);
            return -1L;
        } catch (IOException e) {
            h$a h_a = f0.e0.k.h.c;
            f0.e0.k.h hVar = f0.e0.k.h.a;
            StringBuilder sbU = b.d.b.a.a.U("Http2Connection.Listener failure for ");
            sbU.append(this.f.k.o);
            hVar.i(sbU.toString(), 4, e);
            try {
                this.e.c(a.PROTOCOL_ERROR, e);
                return -1L;
            } catch (IOException unused) {
                return -1L;
            }
        }
    }
}
