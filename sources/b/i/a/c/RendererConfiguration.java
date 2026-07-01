package b.i.a.c;

import androidx.annotation.Nullable;

/* JADX INFO: renamed from: b.i.a.c.h2, reason: use source file name */
/* JADX INFO: compiled from: RendererConfiguration.java */
/* JADX INFO: loaded from: classes3.dex */
public final class RendererConfiguration {
    public static final RendererConfiguration a = new RendererConfiguration(false);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f1015b;

    public RendererConfiguration(boolean z2) {
        this.f1015b = z2;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && RendererConfiguration.class == obj.getClass() && this.f1015b == ((RendererConfiguration) obj).f1015b;
    }

    public int hashCode() {
        return !this.f1015b ? 1 : 0;
    }
}
