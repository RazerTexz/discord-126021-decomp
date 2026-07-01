package b.i.a.c.b3;

import android.graphics.Bitmap;
import android.text.Layout$Alignment;
import android.text.Spanned;
import android.text.SpannedString;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import b.i.a.c.w0;
import b.i.a.c.w0$a;
import java.util.Arrays;
import java.util.Objects;

/* JADX INFO: compiled from: Cue.java */
/* JADX INFO: loaded from: classes3.dex */
public final class b implements w0 {
    public static final b j = new b("", null, null, null, -3.4028235E38f, Integer.MIN_VALUE, Integer.MIN_VALUE, -3.4028235E38f, Integer.MIN_VALUE, Integer.MIN_VALUE, -3.4028235E38f, -3.4028235E38f, -3.4028235E38f, false, ViewCompat.MEASURED_STATE_MASK, Integer.MIN_VALUE, 0.0f, null);
    public static final w0$a<b> k = a.a;
    public final int A;
    public final float B;

    @Nullable
    public final CharSequence l;

    @Nullable
    public final Layout$Alignment m;

    @Nullable
    public final Layout$Alignment n;

    @Nullable
    public final Bitmap o;
    public final float p;
    public final int q;
    public final int r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final float f838s;
    public final int t;
    public final float u;
    public final float v;
    public final boolean w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final int f839x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final int f840y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final float f841z;

    public b(CharSequence charSequence, Layout$Alignment layout$Alignment, Layout$Alignment layout$Alignment2, Bitmap bitmap, float f, int i, int i2, float f2, int i3, int i4, float f3, float f4, float f5, boolean z2, int i5, int i6, float f6, b$a b_a) {
        if (charSequence == null) {
            Objects.requireNonNull(bitmap);
        } else {
            b.c.a.a0.d.j(bitmap == null);
        }
        if (charSequence instanceof Spanned) {
            this.l = SpannedString.valueOf(charSequence);
        } else if (charSequence != null) {
            this.l = charSequence.toString();
        } else {
            this.l = null;
        }
        this.m = layout$Alignment;
        this.n = layout$Alignment2;
        this.o = bitmap;
        this.p = f;
        this.q = i;
        this.r = i2;
        this.f838s = f2;
        this.t = i3;
        this.u = f4;
        this.v = f5;
        this.w = z2;
        this.f839x = i5;
        this.f840y = i4;
        this.f841z = f3;
        this.A = i6;
        this.B = f6;
    }

    public static String b(int i) {
        return Integer.toString(i, 36);
    }

    public b$b a() {
        return new b$b(this, null);
    }

    public boolean equals(@Nullable Object obj) {
        Bitmap bitmap;
        Bitmap bitmap2;
        if (this == obj) {
            return true;
        }
        if (obj == null || b.class != obj.getClass()) {
            return false;
        }
        b bVar = (b) obj;
        return TextUtils.equals(this.l, bVar.l) && this.m == bVar.m && this.n == bVar.n && ((bitmap = this.o) != null ? !((bitmap2 = bVar.o) == null || !bitmap.sameAs(bitmap2)) : bVar.o == null) && this.p == bVar.p && this.q == bVar.q && this.r == bVar.r && this.f838s == bVar.f838s && this.t == bVar.t && this.u == bVar.u && this.v == bVar.v && this.w == bVar.w && this.f839x == bVar.f839x && this.f840y == bVar.f840y && this.f841z == bVar.f841z && this.A == bVar.A && this.B == bVar.B;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.l, this.m, this.n, this.o, Float.valueOf(this.p), Integer.valueOf(this.q), Integer.valueOf(this.r), Float.valueOf(this.f838s), Integer.valueOf(this.t), Float.valueOf(this.u), Float.valueOf(this.v), Boolean.valueOf(this.w), Integer.valueOf(this.f839x), Integer.valueOf(this.f840y), Float.valueOf(this.f841z), Integer.valueOf(this.A), Float.valueOf(this.B)});
    }
}
