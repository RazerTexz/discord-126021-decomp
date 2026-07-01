package b.i.a.c.b3.v;

import android.text.Layout$Alignment;
import b.i.a.c.b3.b$b;

/* JADX INFO: compiled from: WebvttCueParser.java */
/* JADX INFO: loaded from: classes3.dex */
public final class h$e {
    public CharSequence c;
    public long a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f894b = 0;
    public int d = 2;
    public float e = -3.4028235E38f;
    public int f = 1;
    public int g = 0;
    public float h = -3.4028235E38f;
    public int i = Integer.MIN_VALUE;
    public float j = 1.0f;
    public int k = Integer.MIN_VALUE;

    /* JADX WARN: Code duplicated, block: B:20:0x0034  */
    /* JADX WARN: Code duplicated, block: B:21:0x0036  */
    /* JADX WARN: Code duplicated, block: B:29:0x0053  */
    /* JADX WARN: Code duplicated, block: B:31:0x0059  */
    /* JADX WARN: Code duplicated, block: B:43:0x0076  */
    public b$b a() {
        Layout$Alignment layout$Alignment;
        float f = this.h;
        float f2 = -3.4028235E38f;
        if (f == -3.4028235E38f) {
            int i = this.d;
            if (i != 4) {
                f = i != 5 ? 0.5f : 1.0f;
            } else {
                f = 0.0f;
            }
        }
        int i2 = this.i;
        if (i2 == Integer.MIN_VALUE) {
            int i3 = this.d;
            if (i3 == 1) {
                i2 = 0;
            } else if (i3 == 3) {
                i2 = 2;
            } else if (i3 == 4) {
                i2 = 0;
            } else if (i3 != 5) {
                i2 = 1;
            } else {
                i2 = 2;
            }
        }
        b$b b_b = new b$b();
        int i4 = this.d;
        if (i4 == 1) {
            layout$Alignment = Layout$Alignment.ALIGN_NORMAL;
        } else if (i4 == 2) {
            layout$Alignment = Layout$Alignment.ALIGN_CENTER;
        } else if (i4 == 3) {
            layout$Alignment = Layout$Alignment.ALIGN_OPPOSITE;
        } else if (i4 == 4) {
            layout$Alignment = Layout$Alignment.ALIGN_NORMAL;
        } else if (i4 != 5) {
            b.d.b.a.a.g0(34, "Unknown textAlignment: ", i4, "WebvttCueParser");
            layout$Alignment = null;
        } else {
            layout$Alignment = Layout$Alignment.ALIGN_OPPOSITE;
        }
        b_b.c = layout$Alignment;
        float f3 = this.e;
        int i5 = this.f;
        if (f3 != -3.4028235E38f && i5 == 0 && (f3 < 0.0f || f3 > 1.0f)) {
            f2 = 1.0f;
        } else if (f3 != -3.4028235E38f) {
            f2 = f3;
        } else if (i5 == 0) {
            f2 = 1.0f;
        }
        b_b.e = f2;
        b_b.f = i5;
        b_b.g = this.g;
        b_b.h = f;
        b_b.i = i2;
        float f4 = this.j;
        if (i2 == 0) {
            f = 1.0f - f;
        } else if (i2 == 1) {
            f = f <= 0.5f ? f * 2.0f : (1.0f - f) * 2.0f;
        } else if (i2 != 2) {
            throw new IllegalStateException(String.valueOf(i2));
        }
        b_b.l = Math.min(f4, f);
        b_b.p = this.k;
        CharSequence charSequence = this.c;
        if (charSequence != null) {
            b_b.a = charSequence;
        }
        return b_b;
    }
}
