package p600f0.p601e0.p608j;

import p600f0.p601e0.p604f.AbstractC12277a;

/* JADX INFO: renamed from: f0.e0.j.j */
/* JADX INFO: compiled from: TaskQueue.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C12316j extends AbstractC12277a {

    /* JADX INFO: renamed from: e */
    public final /* synthetic */ C12311e f25688e;

    /* JADX INFO: renamed from: f */
    public final /* synthetic */ int f25689f;

    /* JADX INFO: renamed from: g */
    public final /* synthetic */ EnumC12307a f25690g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C12316j(String str, boolean z2, String str2, boolean z3, C12311e c12311e, int i, EnumC12307a enumC12307a) {
        super(str2, z3);
        this.f25688e = c12311e;
        this.f25689f = i;
        this.f25690g = enumC12307a;
    }

    @Override // p600f0.p601e0.p604f.AbstractC12277a
    /* JADX INFO: renamed from: a */
    public long mo10150a() {
        this.f25688e.f25641w.mo10310c(this.f25689f, this.f25690g);
        synchronized (this.f25688e) {
            this.f25688e.f25629M.remove(Integer.valueOf(this.f25689f));
        }
        return -1L;
    }
}
