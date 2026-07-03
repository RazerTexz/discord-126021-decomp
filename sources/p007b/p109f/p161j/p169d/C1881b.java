package p007b.p109f.p161j.p169d;

import android.graphics.Bitmap;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p109f.p115d.p119d.C1686i;

/* JADX INFO: renamed from: b.f.j.d.b */
/* JADX INFO: compiled from: ImageDecodeOptions.java */
/* JADX INFO: loaded from: classes.dex */
public class C1881b {

    /* JADX INFO: renamed from: a */
    public static final C1881b f3706a = new C1881b(new C1882c());

    /* JADX INFO: renamed from: b */
    public final int f3707b = 100;

    /* JADX INFO: renamed from: c */
    public final int f3708c = Integer.MAX_VALUE;

    /* JADX INFO: renamed from: d */
    public final Bitmap.Config f3709d;

    /* JADX INFO: renamed from: e */
    public final Bitmap.Config f3710e;

    public C1881b(C1882c c1882c) {
        this.f3709d = c1882c.f3711a;
        this.f3710e = c1882c.f3712b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || C1881b.class != obj.getClass()) {
            return false;
        }
        C1881b c1881b = (C1881b) obj;
        return this.f3707b == c1881b.f3707b && this.f3708c == c1881b.f3708c && this.f3709d == c1881b.f3709d && this.f3710e == c1881b.f3710e;
    }

    public int hashCode() {
        int iOrdinal = (this.f3709d.ordinal() + (((((((((((this.f3707b * 31) + this.f3708c) * 31) + 0) * 31) + 0) * 31) + 0) * 31) + 0) * 31)) * 31;
        Bitmap.Config config = this.f3710e;
        return ((((((iOrdinal + (config != null ? config.ordinal() : 0)) * 31) + 0) * 31) + 0) * 31) + 0;
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("ImageDecodeOptions{");
        C1686i c1686iM526h2 = C1460d.m526h2(this);
        c1686iM526h2.m969a("minDecodeIntervalMs", this.f3707b);
        c1686iM526h2.m969a("maxDimensionPx", this.f3708c);
        c1686iM526h2.m970b("decodePreviewFrame", false);
        c1686iM526h2.m970b("useLastFrameForPreview", false);
        c1686iM526h2.m970b("decodeAllFrames", false);
        c1686iM526h2.m970b("forceStaticImage", false);
        c1686iM526h2.m971c("bitmapConfigName", this.f3709d.name());
        c1686iM526h2.m971c("animatedBitmapConfigName", this.f3710e.name());
        c1686iM526h2.m971c("customImageDecoder", null);
        c1686iM526h2.m971c("bitmapTransformation", null);
        c1686iM526h2.m971c("colorSpace", null);
        return C1643a.m822J(sbM833U, c1686iM526h2.toString(), "}");
    }
}
