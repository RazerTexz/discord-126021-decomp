package p007b.p225i.p226a.p242c.p245b3;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.Layout;
import android.text.Spanned;
import android.text.SpannedString;
import android.text.TextUtils;
import androidx.annotation.ColorInt;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import java.util.Arrays;
import java.util.Objects;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p225i.p226a.p242c.InterfaceC2963w0;

/* JADX INFO: renamed from: b.i.a.c.b3.b */
/* JADX INFO: compiled from: Cue.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C2578b implements InterfaceC2963w0 {

    /* JADX INFO: renamed from: j */
    public static final C2578b f5754j = new C2578b("", null, null, null, -3.4028235E38f, Integer.MIN_VALUE, Integer.MIN_VALUE, -3.4028235E38f, Integer.MIN_VALUE, Integer.MIN_VALUE, -3.4028235E38f, -3.4028235E38f, -3.4028235E38f, false, ViewCompat.MEASURED_STATE_MASK, Integer.MIN_VALUE, 0.0f, null);

    /* JADX INFO: renamed from: k */
    public static final InterfaceC2963w0.a<C2578b> f5755k = new InterfaceC2963w0.a() { // from class: b.i.a.c.b3.a
        @Override // p007b.p225i.p226a.p242c.InterfaceC2963w0.a
        /* JADX INFO: renamed from: a */
        public final InterfaceC2963w0 mo2576a(Bundle bundle) {
            float f;
            int i;
            int i2;
            float f2;
            boolean z2;
            int i3;
            CharSequence charSequence = bundle.getCharSequence(C2578b.m2604b(0));
            CharSequence charSequence2 = charSequence != null ? charSequence : null;
            Layout.Alignment alignment = (Layout.Alignment) bundle.getSerializable(C2578b.m2604b(1));
            Layout.Alignment alignment2 = alignment != null ? alignment : null;
            Layout.Alignment alignment3 = (Layout.Alignment) bundle.getSerializable(C2578b.m2604b(2));
            Layout.Alignment alignment4 = alignment3 != null ? alignment3 : null;
            Bitmap bitmap = (Bitmap) bundle.getParcelable(C2578b.m2604b(3));
            Bitmap bitmap2 = bitmap != null ? bitmap : null;
            if (bundle.containsKey(C2578b.m2604b(4)) && bundle.containsKey(C2578b.m2604b(5))) {
                f = bundle.getFloat(C2578b.m2604b(4));
                i = bundle.getInt(C2578b.m2604b(5));
            } else {
                f = -3.4028235E38f;
                i = Integer.MIN_VALUE;
            }
            int i4 = bundle.containsKey(C2578b.m2604b(6)) ? bundle.getInt(C2578b.m2604b(6)) : Integer.MIN_VALUE;
            float f3 = bundle.containsKey(C2578b.m2604b(7)) ? bundle.getFloat(C2578b.m2604b(7)) : -3.4028235E38f;
            int i5 = bundle.containsKey(C2578b.m2604b(8)) ? bundle.getInt(C2578b.m2604b(8)) : Integer.MIN_VALUE;
            if (bundle.containsKey(C2578b.m2604b(10)) && bundle.containsKey(C2578b.m2604b(9))) {
                f2 = bundle.getFloat(C2578b.m2604b(10));
                i2 = bundle.getInt(C2578b.m2604b(9));
            } else {
                i2 = Integer.MIN_VALUE;
                f2 = -3.4028235E38f;
            }
            float f4 = bundle.containsKey(C2578b.m2604b(11)) ? bundle.getFloat(C2578b.m2604b(11)) : -3.4028235E38f;
            float f5 = bundle.containsKey(C2578b.m2604b(12)) ? bundle.getFloat(C2578b.m2604b(12)) : -3.4028235E38f;
            if (bundle.containsKey(C2578b.m2604b(13))) {
                i3 = bundle.getInt(C2578b.m2604b(13));
                z2 = true;
            } else {
                z2 = false;
                i3 = ViewCompat.MEASURED_STATE_MASK;
            }
            return new C2578b(charSequence2, alignment2, alignment4, bitmap2, f, i, i4, f3, i5, i2, f2, f4, f5, bundle.getBoolean(C2578b.m2604b(14), false) ? z2 : false, i3, bundle.containsKey(C2578b.m2604b(15)) ? bundle.getInt(C2578b.m2604b(15)) : Integer.MIN_VALUE, bundle.containsKey(C2578b.m2604b(16)) ? bundle.getFloat(C2578b.m2604b(16)) : 0.0f, null);
        }
    };

    /* JADX INFO: renamed from: A */
    public final int f5756A;

    /* JADX INFO: renamed from: B */
    public final float f5757B;

    /* JADX INFO: renamed from: l */
    @Nullable
    public final CharSequence f5758l;

    /* JADX INFO: renamed from: m */
    @Nullable
    public final Layout.Alignment f5759m;

    /* JADX INFO: renamed from: n */
    @Nullable
    public final Layout.Alignment f5760n;

    /* JADX INFO: renamed from: o */
    @Nullable
    public final Bitmap f5761o;

    /* JADX INFO: renamed from: p */
    public final float f5762p;

    /* JADX INFO: renamed from: q */
    public final int f5763q;

    /* JADX INFO: renamed from: r */
    public final int f5764r;

    /* JADX INFO: renamed from: s */
    public final float f5765s;

    /* JADX INFO: renamed from: t */
    public final int f5766t;

    /* JADX INFO: renamed from: u */
    public final float f5767u;

    /* JADX INFO: renamed from: v */
    public final float f5768v;

    /* JADX INFO: renamed from: w */
    public final boolean f5769w;

    /* JADX INFO: renamed from: x */
    public final int f5770x;

    /* JADX INFO: renamed from: y */
    public final int f5771y;

    /* JADX INFO: renamed from: z */
    public final float f5772z;

    public C2578b(CharSequence charSequence, Layout.Alignment alignment, Layout.Alignment alignment2, Bitmap bitmap, float f, int i, int i2, float f2, int i3, int i4, float f3, float f4, float f5, boolean z2, int i5, int i6, float f6, a aVar) {
        if (charSequence == null) {
            Objects.requireNonNull(bitmap);
        } else {
            C1460d.m531j(bitmap == null);
        }
        if (charSequence instanceof Spanned) {
            this.f5758l = SpannedString.valueOf(charSequence);
        } else if (charSequence != null) {
            this.f5758l = charSequence.toString();
        } else {
            this.f5758l = null;
        }
        this.f5759m = alignment;
        this.f5760n = alignment2;
        this.f5761o = bitmap;
        this.f5762p = f;
        this.f5763q = i;
        this.f5764r = i2;
        this.f5765s = f2;
        this.f5766t = i3;
        this.f5767u = f4;
        this.f5768v = f5;
        this.f5769w = z2;
        this.f5770x = i5;
        this.f5771y = i4;
        this.f5772z = f3;
        this.f5756A = i6;
        this.f5757B = f6;
    }

    /* JADX INFO: renamed from: b */
    public static String m2604b(int i) {
        return Integer.toString(i, 36);
    }

    /* JADX INFO: renamed from: a */
    public b m2605a() {
        return new b(this, null);
    }

    public boolean equals(@Nullable Object obj) {
        Bitmap bitmap;
        Bitmap bitmap2;
        if (this == obj) {
            return true;
        }
        if (obj == null || C2578b.class != obj.getClass()) {
            return false;
        }
        C2578b c2578b = (C2578b) obj;
        return TextUtils.equals(this.f5758l, c2578b.f5758l) && this.f5759m == c2578b.f5759m && this.f5760n == c2578b.f5760n && ((bitmap = this.f5761o) != null ? !((bitmap2 = c2578b.f5761o) == null || !bitmap.sameAs(bitmap2)) : c2578b.f5761o == null) && this.f5762p == c2578b.f5762p && this.f5763q == c2578b.f5763q && this.f5764r == c2578b.f5764r && this.f5765s == c2578b.f5765s && this.f5766t == c2578b.f5766t && this.f5767u == c2578b.f5767u && this.f5768v == c2578b.f5768v && this.f5769w == c2578b.f5769w && this.f5770x == c2578b.f5770x && this.f5771y == c2578b.f5771y && this.f5772z == c2578b.f5772z && this.f5756A == c2578b.f5756A && this.f5757B == c2578b.f5757B;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.f5758l, this.f5759m, this.f5760n, this.f5761o, Float.valueOf(this.f5762p), Integer.valueOf(this.f5763q), Integer.valueOf(this.f5764r), Float.valueOf(this.f5765s), Integer.valueOf(this.f5766t), Float.valueOf(this.f5767u), Float.valueOf(this.f5768v), Boolean.valueOf(this.f5769w), Integer.valueOf(this.f5770x), Integer.valueOf(this.f5771y), Float.valueOf(this.f5772z), Integer.valueOf(this.f5756A), Float.valueOf(this.f5757B)});
    }

    /* JADX INFO: renamed from: b.i.a.c.b3.b$b */
    /* JADX INFO: compiled from: Cue.java */
    public static final class b {

        /* JADX INFO: renamed from: a */
        @Nullable
        public CharSequence f5773a;

        /* JADX INFO: renamed from: b */
        @Nullable
        public Bitmap f5774b;

        /* JADX INFO: renamed from: c */
        @Nullable
        public Layout.Alignment f5775c;

        /* JADX INFO: renamed from: d */
        @Nullable
        public Layout.Alignment f5776d;

        /* JADX INFO: renamed from: e */
        public float f5777e;

        /* JADX INFO: renamed from: f */
        public int f5778f;

        /* JADX INFO: renamed from: g */
        public int f5779g;

        /* JADX INFO: renamed from: h */
        public float f5780h;

        /* JADX INFO: renamed from: i */
        public int f5781i;

        /* JADX INFO: renamed from: j */
        public int f5782j;

        /* JADX INFO: renamed from: k */
        public float f5783k;

        /* JADX INFO: renamed from: l */
        public float f5784l;

        /* JADX INFO: renamed from: m */
        public float f5785m;

        /* JADX INFO: renamed from: n */
        public boolean f5786n;

        /* JADX INFO: renamed from: o */
        @ColorInt
        public int f5787o;

        /* JADX INFO: renamed from: p */
        public int f5788p;

        /* JADX INFO: renamed from: q */
        public float f5789q;

        public b() {
            this.f5773a = null;
            this.f5774b = null;
            this.f5775c = null;
            this.f5776d = null;
            this.f5777e = -3.4028235E38f;
            this.f5778f = Integer.MIN_VALUE;
            this.f5779g = Integer.MIN_VALUE;
            this.f5780h = -3.4028235E38f;
            this.f5781i = Integer.MIN_VALUE;
            this.f5782j = Integer.MIN_VALUE;
            this.f5783k = -3.4028235E38f;
            this.f5784l = -3.4028235E38f;
            this.f5785m = -3.4028235E38f;
            this.f5786n = false;
            this.f5787o = ViewCompat.MEASURED_STATE_MASK;
            this.f5788p = Integer.MIN_VALUE;
        }

        /* JADX INFO: renamed from: a */
        public C2578b m2606a() {
            return new C2578b(this.f5773a, this.f5775c, this.f5776d, this.f5774b, this.f5777e, this.f5778f, this.f5779g, this.f5780h, this.f5781i, this.f5782j, this.f5783k, this.f5784l, this.f5785m, this.f5786n, this.f5787o, this.f5788p, this.f5789q, null);
        }

        public b(C2578b c2578b, a aVar) {
            this.f5773a = c2578b.f5758l;
            this.f5774b = c2578b.f5761o;
            this.f5775c = c2578b.f5759m;
            this.f5776d = c2578b.f5760n;
            this.f5777e = c2578b.f5762p;
            this.f5778f = c2578b.f5763q;
            this.f5779g = c2578b.f5764r;
            this.f5780h = c2578b.f5765s;
            this.f5781i = c2578b.f5766t;
            this.f5782j = c2578b.f5771y;
            this.f5783k = c2578b.f5772z;
            this.f5784l = c2578b.f5767u;
            this.f5785m = c2578b.f5768v;
            this.f5786n = c2578b.f5769w;
            this.f5787o = c2578b.f5770x;
            this.f5788p = c2578b.f5756A;
            this.f5789q = c2578b.f5757B;
        }
    }
}
