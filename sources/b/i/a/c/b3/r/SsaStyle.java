package b.i.a.c.b3.r;

import android.graphics.Color;
import android.graphics.PointF;
import android.util.Log;
import androidx.annotation.ColorInt;
import androidx.annotation.Nullable;
import b.c.a.a0.AnimatableValueParser;
import b.d.b.a.outline;
import b.i.a.c.f3.Log2;
import b.i.a.c.f3.Util2;
import b.i.a.f.e.o.f;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: renamed from: b.i.a.c.b3.r.c, reason: use source file name */
/* JADX INFO: compiled from: SsaStyle.java */
/* JADX INFO: loaded from: classes3.dex */
public final class SsaStyle {
    public final String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f876b;

    @Nullable
    @ColorInt
    public final Integer c;
    public final float d;
    public final boolean e;
    public final boolean f;
    public final boolean g;
    public final boolean h;

    /* JADX INFO: renamed from: b.i.a.c.b3.r.c$a */
    /* JADX INFO: compiled from: SsaStyle.java */
    public static final class a {
        public final int a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f877b;
        public final int c;
        public final int d;
        public final int e;
        public final int f;
        public final int g;
        public final int h;
        public final int i;

        public a(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
            this.a = i;
            this.f877b = i2;
            this.c = i3;
            this.d = i4;
            this.e = i5;
            this.f = i6;
            this.g = i7;
            this.h = i8;
            this.i = i9;
        }
    }

    /* JADX INFO: renamed from: b.i.a.c.b3.r.c$b */
    /* JADX INFO: compiled from: SsaStyle.java */
    public static final class b {
        public static final Pattern a = Pattern.compile("\\{([^}]*)\\}");

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final Pattern f878b = Pattern.compile(Util2.k("\\\\pos\\((%1$s),(%1$s)\\)", "\\s*\\d+(?:\\.\\d+)?\\s*"));
        public static final Pattern c = Pattern.compile(Util2.k("\\\\move\\(%1$s,%1$s,(%1$s),(%1$s)(?:,%1$s,%1$s)?\\)", "\\s*\\d+(?:\\.\\d+)?\\s*"));
        public static final Pattern d = Pattern.compile("\\\\an(\\d+)");

        @Nullable
        public static PointF a(String str) {
            String strGroup;
            String strGroup2;
            Matcher matcher = f878b.matcher(str);
            Matcher matcher2 = c.matcher(str);
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

    public SsaStyle(String str, int i, @Nullable @ColorInt Integer num, float f, boolean z2, boolean z3, boolean z4, boolean z5) {
        this.a = str;
        this.f876b = i;
        this.c = num;
        this.d = f;
        this.e = z2;
        this.f = z3;
        this.g = z4;
        this.h = z5;
    }

    public static int a(String str) {
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

    public static boolean b(String str) {
        try {
            int i = Integer.parseInt(str);
            return i == 1 || i == -1;
        } catch (NumberFormatException e) {
            Log2.c("SsaStyle", outline.k(outline.b(str, 33), "Failed to parse boolean value: '", str, "'"), e);
            return false;
        }
    }

    @Nullable
    @ColorInt
    public static Integer c(String str) {
        try {
            long j = str.startsWith("&H") ? Long.parseLong(str.substring(2), 16) : Long.parseLong(str);
            AnimatableValueParser.j(j <= 4294967295L);
            return Integer.valueOf(Color.argb(f.H(((j >> 24) & 255) ^ 255), f.H(j & 255), f.H((j >> 8) & 255), f.H((j >> 16) & 255)));
        } catch (IllegalArgumentException e) {
            Log2.c("SsaStyle", outline.k(outline.b(str, 36), "Failed to parse color expression: '", str, "'"), e);
            return null;
        }
    }
}
