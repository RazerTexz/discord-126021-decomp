package f0.e0.j;

import java.io.IOException;
import java.util.List;

/* JADX INFO: compiled from: TaskQueue.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class h extends f0.e0.f.a {
    public final /* synthetic */ e e;
    public final /* synthetic */ int f;
    public final /* synthetic */ List g;
    public final /* synthetic */ boolean h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(String str, boolean z2, String str2, boolean z3, e eVar, int i, List list, boolean z4) {
        super(str2, z3);
        this.e = eVar;
        this.f = i;
        this.g = list;
        this.h = z4;
    }

    @Override // f0.e0.f.a
    public long a() {
        boolean zB = this.e.w.b(this.f, this.g, this.h);
        if (zB) {
            try {
                this.e.K.n(this.f, a.CANCEL);
            } catch (IOException unused) {
                return -1L;
            }
        }
        if (!zB && !this.h) {
            return -1L;
        }
        synchronized (this.e) {
            this.e.M.remove(Integer.valueOf(this.f));
        }
        return -1L;
    }
}
