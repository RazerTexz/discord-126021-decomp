package b.f.j.d;

import android.graphics.Bitmap$Config;
import b.f.d.d.i;

/* JADX INFO: compiled from: ImageDecodeOptions.java */
/* JADX INFO: loaded from: classes.dex */
public class b {
    public static final b a = new b(new c());

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f564b = 100;
    public final int c = Integer.MAX_VALUE;
    public final Bitmap$Config d;
    public final Bitmap$Config e;

    public b(c cVar) {
        this.d = cVar.a;
        this.e = cVar.f565b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || b.class != obj.getClass()) {
            return false;
        }
        b bVar = (b) obj;
        return this.f564b == bVar.f564b && this.c == bVar.c && this.d == bVar.d && this.e == bVar.e;
    }

    public int hashCode() {
        int iOrdinal = (this.d.ordinal() + (((((((((((this.f564b * 31) + this.c) * 31) + 0) * 31) + 0) * 31) + 0) * 31) + 0) * 31)) * 31;
        Bitmap$Config bitmap$Config = this.e;
        return ((((((iOrdinal + (bitmap$Config != null ? bitmap$Config.ordinal() : 0)) * 31) + 0) * 31) + 0) * 31) + 0;
    }

    public String toString() {
        StringBuilder sbU = b.d.b.a.a.U("ImageDecodeOptions{");
        i iVarH2 = b.c.a.a0.d.h2(this);
        iVarH2.a("minDecodeIntervalMs", this.f564b);
        iVarH2.a("maxDimensionPx", this.c);
        iVarH2.b("decodePreviewFrame", false);
        iVarH2.b("useLastFrameForPreview", false);
        iVarH2.b("decodeAllFrames", false);
        iVarH2.b("forceStaticImage", false);
        iVarH2.c("bitmapConfigName", this.d.name());
        iVarH2.c("animatedBitmapConfigName", this.e.name());
        iVarH2.c("customImageDecoder", null);
        iVarH2.c("bitmapTransformation", null);
        iVarH2.c("colorSpace", null);
        return b.d.b.a.a.J(sbU, iVarH2.toString(), "}");
    }
}
