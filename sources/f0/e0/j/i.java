package f0.e0.j;

import java.io.IOException;
import java.util.List;

/* JADX INFO: compiled from: TaskQueue.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class i extends f0.e0.f.a {
    public final /* synthetic */ e e;
    public final /* synthetic */ int f;
    public final /* synthetic */ List g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(String str, boolean z2, String str2, boolean z3, e eVar, int i, List list) {
        super(str2, z3);
        this.e = eVar;
        this.f = i;
        this.g = list;
    }

    @Override // f0.e0.f.a
    public long a() {
        if (!this.e.w.a(this.f, this.g)) {
            return -1L;
        }
        try {
            this.e.K.n(this.f, a.CANCEL);
            synchronized (this.e) {
                this.e.M.remove(Integer.valueOf(this.f));
            }
            return -1L;
        } catch (IOException unused) {
            return -1L;
        }
    }
}
