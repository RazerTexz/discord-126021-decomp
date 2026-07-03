package p007b.p225i.p226a.p242c.p263t2;

import androidx.annotation.Nullable;

/* JADX INFO: renamed from: b.i.a.c.t2.u */
/* JADX INFO: compiled from: AuxEffectInfo.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C2937u {

    /* JADX INFO: renamed from: a */
    public final int f7835a;

    /* JADX INFO: renamed from: b */
    public final float f7836b;

    public C2937u(int i, float f) {
        this.f7835a = i;
        this.f7836b = f;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || C2937u.class != obj.getClass()) {
            return false;
        }
        C2937u c2937u = (C2937u) obj;
        return this.f7835a == c2937u.f7835a && Float.compare(c2937u.f7836b, this.f7836b) == 0;
    }

    public int hashCode() {
        return Float.floatToIntBits(this.f7836b) + ((527 + this.f7835a) * 31);
    }
}
