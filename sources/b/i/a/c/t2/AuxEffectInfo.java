package b.i.a.c.t2;

import androidx.annotation.Nullable;

/* JADX INFO: renamed from: b.i.a.c.t2.u, reason: use source file name */
/* JADX INFO: compiled from: AuxEffectInfo.java */
/* JADX INFO: loaded from: classes3.dex */
public final class AuxEffectInfo {
    public final int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f1134b;

    public AuxEffectInfo(int i, float f) {
        this.a = i;
        this.f1134b = f;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || AuxEffectInfo.class != obj.getClass()) {
            return false;
        }
        AuxEffectInfo auxEffectInfo = (AuxEffectInfo) obj;
        return this.a == auxEffectInfo.a && Float.compare(auxEffectInfo.f1134b, this.f1134b) == 0;
    }

    public int hashCode() {
        return Float.floatToIntBits(this.f1134b) + ((527 + this.a) * 31);
    }
}
