package p007b.p225i.p226a.p242c.p245b3.p250r;

import android.graphics.Color;
import android.graphics.PointF;
import android.util.Log;
import androidx.annotation.ColorInt;
import androidx.annotation.Nullable;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p225i.p226a.p242c.p259f3.C2738e0;
import p007b.p225i.p226a.p242c.p259f3.C2750q;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;

/* JADX INFO: renamed from: b.i.a.c.b3.r.c */
/* JADX INFO: compiled from: SsaStyle.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C2607c {

    /* JADX INFO: renamed from: a */
    public final String f5997a;

    /* JADX INFO: renamed from: b */
    public final int f5998b;

    /* JADX INFO: renamed from: c */
    @Nullable
    @ColorInt
    public final Integer f5999c;

    /* JADX INFO: renamed from: d */
    public final float f6000d;

    /* JADX INFO: renamed from: e */
    public final boolean f6001e;

    /* JADX INFO: renamed from: f */
    public final boolean f6002f;

    /* JADX INFO: renamed from: g */
    public final boolean f6003g;

    /* JADX INFO: renamed from: h */
    public final boolean f6004h;

    /* JADX INFO: renamed from: b.i.a.c.b3.r.c$a */
    /* JADX INFO: compiled from: SsaStyle.java */
    public static final class a {

        /* JADX INFO: renamed from: a */
        public final int f6005a;

        /* JADX INFO: renamed from: b */
        public final int f6006b;

        /* JADX INFO: renamed from: c */
        public final int f6007c;

        /* JADX INFO: renamed from: d */
        public final int f6008d;

        /* JADX INFO: renamed from: e */
        public final int f6009e;

        /* JADX INFO: renamed from: f */
        public final int f6010f;

        /* JADX INFO: renamed from: g */
        public final int f6011g;

        /* JADX INFO: renamed from: h */
        public final int f6012h;

        /* JADX INFO: renamed from: i */
        public final int f6013i;

        public a(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
            this.f6005a = i;
            this.f6006b = i2;
            this.f6007c = i3;
            this.f6008d = i4;
            this.f6009e = i5;
            this.f6010f = i6;
            this.f6011g = i7;
            this.f6012h = i8;
            this.f6013i = i9;
        }
    }

    /* JADX INFO: renamed from: b.i.a.c.b3.r.c$b */
    /* JADX INFO: compiled from: SsaStyle.java */
    public static final class b {

        /* JADX INFO: renamed from: a */
        public static final Pattern f6014a = Pattern.compile("\\{([^}]*)\\}");

        /* JADX INFO: renamed from: b */
        public static final Pattern f6015b = Pattern.compile(C2738e0.m3003k("\\\\pos\\((%1$s),(%1$s)\\)", "\\s*\\d+(?:\\.\\d+)?\\s*"));

        /* JADX INFO: renamed from: c */
        public static final Pattern f6016c = Pattern.compile(C2738e0.m3003k("\\\\move\\(%1$s,%1$s,(%1$s),(%1$s)(?:,%1$s,%1$s)?\\)", "\\s*\\d+(?:\\.\\d+)?\\s*"));

        /* JADX INFO: renamed from: d */
        public static final Pattern f6017d = Pattern.compile("\\\\an(\\d+)");

        @Nullable
        /* JADX INFO: renamed from: a */
        public static PointF m2676a(String str) {
            String strGroup;
            String strGroup2;
            Matcher matcher = f6015b.matcher(str);
            Matcher matcher2 = f6016c.matcher(str);
            boolean zFind = matcher.find();
            boolean zFind2 = matcher2.find();
            if (zFind) {
                if (zFind2) {
                    StringBuilder sb = new StringBuilder(str.length() + 82);
                    sb.append("Override has both \\pos(x,y) and \\move(x1,y1,x2,y2); using \\pos values. override='");
                    sb.append(str);
                    sb.append("'");
                    Log.i("SsaStyle.Overrides", sb.toString());
                }
                strGroup = matcher.group(1);
                strGroup2 = matcher.group(2);
            } else {
                if (!zFind2) {
                    return null;
                }
                strGroup = matcher2.group(1);
                strGroup2 = matcher2.group(2);
            }
            Objects.requireNonNull(strGroup);
            float f = Float.parseFloat(strGroup.trim());
            Objects.requireNonNull(strGroup2);
            return new PointF(f, Float.parseFloat(strGroup2.trim()));
        }
    }

    public C2607c(String str, int i, @Nullable @ColorInt Integer num, float f, boolean z2, boolean z3, boolean z4, boolean z5) {
        this.f5997a = str;
        this.f5998b = i;
        this.f5999c = num;
        this.f6000d = f;
        this.f6001e = z2;
        this.f6002f = z3;
        this.f6003g = z4;
        this.f6004h = z5;
    }

    /* JADX INFO: renamed from: a */
    public static int m2673a(String str) {
        boolean z2;
        try {
            int i = Integer.parseInt(str.trim());
            switch (i) {
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                case 8:
                case 9:
                    z2 = true;
                    break;
                default:
                    z2 = false;
                    break;
            }
            if (z2) {
                return i;
            }
        } catch (NumberFormatException unused) {
        }
        String strValueOf = String.valueOf(str);
        Log.w("SsaStyle", strValueOf.length() != 0 ? "Ignoring unknown alignment: ".concat(strValueOf) : new String("Ignoring unknown alignment: "));
        return -1;
    }

    /* JADX INFO: renamed from: b */
    public static boolean m2674b(String str) {
        try {
            int i = Integer.parseInt(str);
            return i == 1 || i == -1;
        } catch (NumberFormatException e) {
            C2750q.m3040c("SsaStyle", C1643a.m859k(C1643a.m841b(str, 33), "Failed to parse boolean value: '", str, "'"), e);
            return false;
        }
    }

    @Nullable
    @ColorInt
    /* JADX INFO: renamed from: c */
    public static Integer m2675c(String str) {
        try {
            long j = str.startsWith("&H") ? Long.parseLong(str.substring(2), 16) : Long.parseLong(str);
            C1460d.m531j(j <= 4294967295L);
            return Integer.valueOf(Color.argb(C3404f.m4210H(((j >> 24) & 255) ^ 255), C3404f.m4210H(j & 255), C3404f.m4210H((j >> 8) & 255), C3404f.m4210H((j >> 16) & 255)));
        } catch (IllegalArgumentException e) {
            C2750q.m3040c("SsaStyle", C1643a.m859k(C1643a.m841b(str, 36), "Failed to parse color expression: '", str, "'"), e);
            return null;
        }
    }
}
