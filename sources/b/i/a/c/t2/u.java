package b.i.a.c.t2;

import androidx.annotation.Nullable;

/* JADX INFO: compiled from: AuxEffectInfo.java */
/* JADX INFO: loaded from: classes3.dex */
public final class u {
    public final int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f1134b;

    public u(int i, float f) {
        this.a = i;
        this.f1134b = f;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || u.class != obj.getClass()) {
            return false;
        }
        u uVar = (u) obj;
        return this.a == uVar.a && Float.compare(uVar.f1134b, this.f1134b) == 0;
    }

    public int hashCode() {
        return Float.floatToIntBits(this.f1134b) + ((527 + this.a) * 31);
    }
}
