package p007b.p452o.p453a.p473x;

import androidx.annotation.NonNull;

/* JADX INFO: renamed from: b.o.a.x.d */
/* JADX INFO: compiled from: SizeSelectors.java */
/* JADX INFO: loaded from: classes3.dex */
public class C5238d implements InterfaceC5244j {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ float f14253a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ float f14254b;

    public C5238d(float f, float f2) {
        this.f14253a = f;
        this.f14254b = f2;
    }

    @Override // p007b.p452o.p453a.p473x.InterfaceC5244j
    /* JADX INFO: renamed from: a */
    public boolean mo4369a(@NonNull C5236b c5236b) {
        float fM7450i = C5235a.m7447f(c5236b.f14251j, c5236b.f14252k).m7450i();
        float f = this.f14253a;
        float f2 = this.f14254b;
        return fM7450i >= f - f2 && fM7450i <= f + f2;
    }
}
