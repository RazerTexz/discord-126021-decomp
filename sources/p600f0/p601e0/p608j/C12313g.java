package p600f0.p601e0.p608j;

import java.io.IOException;
import p600f0.p601e0.p604f.AbstractC12277a;
import p615g0.C12388e;

/* JADX INFO: renamed from: f0.e0.j.g */
/* JADX INFO: compiled from: TaskQueue.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C12313g extends AbstractC12277a {

    /* JADX INFO: renamed from: e */
    public final /* synthetic */ C12311e f25676e;

    /* JADX INFO: renamed from: f */
    public final /* synthetic */ int f25677f;

    /* JADX INFO: renamed from: g */
    public final /* synthetic */ C12388e f25678g;

    /* JADX INFO: renamed from: h */
    public final /* synthetic */ int f25679h;

    /* JADX INFO: renamed from: i */
    public final /* synthetic */ boolean f25680i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C12313g(String str, boolean z2, String str2, boolean z3, C12311e c12311e, int i, C12388e c12388e, int i2, boolean z4) {
        super(str2, z3);
        this.f25676e = c12311e;
        this.f25677f = i;
        this.f25678g = c12388e;
        this.f25679h = i2;
        this.f25680i = z4;
    }

    @Override // p600f0.p601e0.p604f.AbstractC12277a
    /* JADX INFO: renamed from: a */
    public long mo10150a() {
        try {
            boolean zMo10311d = this.f25676e.f25641w.mo10311d(this.f25677f, this.f25678g, this.f25679h, this.f25680i);
            if (zMo10311d) {
                this.f25676e.f25627K.m10304n(this.f25677f, EnumC12307a.CANCEL);
            }
            if (!zMo10311d && !this.f25680i) {
                return -1L;
            }
            synchronized (this.f25676e) {
                this.f25676e.f25629M.remove(Integer.valueOf(this.f25677f));
            }
            return -1L;
        } catch (IOException unused) {
            return -1L;
        }
    }
}
