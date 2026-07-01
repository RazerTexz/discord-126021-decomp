package f0.e0.j;

import java.io.IOException;

/* JADX INFO: compiled from: TaskQueue.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class g extends f0.e0.f.a {
    public final /* synthetic */ e e;
    public final /* synthetic */ int f;
    public final /* synthetic */ g0.e g;
    public final /* synthetic */ int h;
    public final /* synthetic */ boolean i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(String str, boolean z2, String str2, boolean z3, e eVar, int i, g0.e eVar2, int i2, boolean z4) {
        super(str2, z3);
        this.e = eVar;
        this.f = i;
        this.g = eVar2;
        this.h = i2;
        this.i = z4;
    }

    @Override // f0.e0.f.a
    public long a() {
        try {
            boolean zD = this.e.w.d(this.f, this.g, this.h, this.i);
            if (zD) {
                this.e.K.n(this.f, a.CANCEL);
            }
            if (!zD && !this.i) {
                return -1L;
            }
            synchronized (this.e) {
                this.e.M.remove(Integer.valueOf(this.f));
            }
            return -1L;
        } catch (IOException unused) {
            return -1L;
        }
    }
}
