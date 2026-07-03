package p007b.p225i.p226a.p242c;

import androidx.annotation.Nullable;

/* JADX INFO: renamed from: b.i.a.c.h2 */
/* JADX INFO: compiled from: RendererConfiguration.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C2804h2 {

    /* JADX INFO: renamed from: a */
    public static final C2804h2 f7117a = new C2804h2(false);

    /* JADX INFO: renamed from: b */
    public final boolean f7118b;

    public C2804h2(boolean z2) {
        this.f7118b = z2;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && C2804h2.class == obj.getClass() && this.f7118b == ((C2804h2) obj).f7118b;
    }

    public int hashCode() {
        return !this.f7118b ? 1 : 0;
    }
}
