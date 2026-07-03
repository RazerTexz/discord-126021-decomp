package p600f0.p601e0.p608j;

import java.io.IOException;
import java.util.List;
import p600f0.p601e0.p604f.AbstractC12277a;

/* JADX INFO: renamed from: f0.e0.j.h */
/* JADX INFO: compiled from: TaskQueue.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C12314h extends AbstractC12277a {

    /* JADX INFO: renamed from: e */
    public final /* synthetic */ C12311e f25681e;

    /* JADX INFO: renamed from: f */
    public final /* synthetic */ int f25682f;

    /* JADX INFO: renamed from: g */
    public final /* synthetic */ List f25683g;

    /* JADX INFO: renamed from: h */
    public final /* synthetic */ boolean f25684h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C12314h(String str, boolean z2, String str2, boolean z3, C12311e c12311e, int i, List list, boolean z4) {
        super(str2, z3);
        this.f25681e = c12311e;
        this.f25682f = i;
        this.f25683g = list;
        this.f25684h = z4;
    }

    @Override // p600f0.p601e0.p604f.AbstractC12277a
    /* JADX INFO: renamed from: a */
    public long mo10150a() {
        boolean zMo10309b = this.f25681e.f25641w.mo10309b(this.f25682f, this.f25683g, this.f25684h);
        if (zMo10309b) {
            try {
                this.f25681e.f25627K.m10304n(this.f25682f, EnumC12307a.CANCEL);
            } catch (IOException unused) {
                return -1L;
            }
        }
        if (!zMo10309b && !this.f25684h) {
            return -1L;
        }
        synchronized (this.f25681e) {
            this.f25681e.f25629M.remove(Integer.valueOf(this.f25682f));
        }
        return -1L;
    }
}
