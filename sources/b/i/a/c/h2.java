package b.i.a.c;

import androidx.annotation.Nullable;

/* JADX INFO: compiled from: RendererConfiguration.java */
/* JADX INFO: loaded from: classes3.dex */
public final class h2 {
    public static final h2 a = new h2(false);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f1015b;

    public h2(boolean z2) {
        this.f1015b = z2;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && h2.class == obj.getClass() && this.f1015b == ((h2) obj).f1015b;
    }

    public int hashCode() {
        return !this.f1015b ? 1 : 0;
    }
}
