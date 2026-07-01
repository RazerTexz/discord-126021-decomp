package b.o.a.x;

import androidx.annotation.NonNull;

/* JADX INFO: renamed from: b.o.a.x.d, reason: use source file name */
/* JADX INFO: compiled from: SizeSelectors.java */
/* JADX INFO: loaded from: classes3.dex */
public class SizeSelectors implements SizeSelectors7 {
    public final /* synthetic */ float a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ float f1958b;

    public SizeSelectors(float f, float f2) {
        this.a = f;
        this.f1958b = f2;
    }

    @Override // b.o.a.x.SizeSelectors7
    public boolean a(@NonNull Size3 size3) {
        float fI = AspectRatio2.f(size3.j, size3.k).i();
        float f = this.a;
        float f2 = this.f1958b;
        return fI >= f - f2 && fI <= f + f2;
    }
}
