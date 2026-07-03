package p007b.p225i.p226a.p242c.p257e3;

import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.Map;
import java.util.Objects;
import p007b.p225i.p226a.p242c.p259f3.C2738e0;

/* JADX INFO: renamed from: b.i.a.c.e3.g */
/* JADX INFO: compiled from: BaseDataSource.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC2705g implements InterfaceC2710l {

    /* JADX INFO: renamed from: a */
    public final boolean f6528a;

    /* JADX INFO: renamed from: b */
    public final ArrayList<InterfaceC2680a0> f6529b = new ArrayList<>(1);

    /* JADX INFO: renamed from: c */
    public int f6530c;

    /* JADX INFO: renamed from: d */
    @Nullable
    public C2712n f6531d;

    public AbstractC2705g(boolean z2) {
        this.f6528a = z2;
    }

    @Override // p007b.p225i.p226a.p242c.p257e3.InterfaceC2710l
    /* JADX INFO: renamed from: d */
    public final void mo2587d(InterfaceC2680a0 interfaceC2680a0) {
        Objects.requireNonNull(interfaceC2680a0);
        if (this.f6529b.contains(interfaceC2680a0)) {
            return;
        }
        this.f6529b.add(interfaceC2680a0);
        this.f6530c++;
    }

    @Override // p007b.p225i.p226a.p242c.p257e3.InterfaceC2710l
    /* JADX INFO: renamed from: j */
    public /* synthetic */ Map mo2588j() {
        return C2709k.m2853a(this);
    }

    /* JADX INFO: renamed from: p */
    public final void m2848p(int i) {
        C2712n c2712n = this.f6531d;
        int i2 = C2738e0.f6708a;
        for (int i3 = 0; i3 < this.f6530c; i3++) {
            this.f6529b.get(i3).mo2775e(this, c2712n, this.f6528a, i);
        }
    }

    /* JADX INFO: renamed from: q */
    public final void m2849q() {
        C2712n c2712n = this.f6531d;
        int i = C2738e0.f6708a;
        for (int i2 = 0; i2 < this.f6530c; i2++) {
            this.f6529b.get(i2).mo2773a(this, c2712n, this.f6528a);
        }
        this.f6531d = null;
    }

    /* JADX INFO: renamed from: r */
    public final void m2850r(C2712n c2712n) {
        for (int i = 0; i < this.f6530c; i++) {
            this.f6529b.get(i).mo2776g(this, c2712n, this.f6528a);
        }
    }

    /* JADX INFO: renamed from: s */
    public final void m2851s(C2712n c2712n) {
        this.f6531d = c2712n;
        for (int i = 0; i < this.f6530c; i++) {
            this.f6529b.get(i).mo2774b(this, c2712n, this.f6528a);
        }
    }
}
