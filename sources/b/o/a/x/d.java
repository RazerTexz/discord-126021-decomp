package b.o.a.x;

import androidx.annotation.NonNull;

/* JADX INFO: compiled from: SizeSelectors.java */
/* JADX INFO: loaded from: classes3.dex */
public class d implements j {
    public final /* synthetic */ float a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ float f1958b;

    public d(float f, float f2) {
        this.a = f;
        this.f1958b = f2;
    }

    @Override // b.o.a.x.j
    public boolean a(@NonNull b bVar) {
        float fI = a.f(bVar.j, bVar.k).i();
        float f = this.a;
        float f2 = this.f1958b;
        return fI >= f - f2 && fI <= f + f2;
    }
}
