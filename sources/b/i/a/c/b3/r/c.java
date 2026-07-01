package b.i.a.c.b3.r;

import android.graphics.Color;
import android.util.Log;
import androidx.annotation.ColorInt;
import androidx.annotation.Nullable;
import b.i.a.c.f3.q;
import b.i.a.f.e.o.f;

/* JADX INFO: compiled from: SsaStyle.java */
/* JADX INFO: loaded from: classes3.dex */
public final class c {
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

    public c(String str, int i, @Nullable @ColorInt Integer num, float f, boolean z2, boolean z3, boolean z4, boolean z5) {
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
            q.c("SsaStyle", b.d.b.a.a.k(b.d.b.a.a.b(str, 33), "Failed to parse boolean value: '", str, "'"), e);
            return false;
        }
    }

    @Nullable
    @ColorInt
    public static Integer c(String str) {
        try {
            long j = str.startsWith("&H") ? Long.parseLong(str.substring(2), 16) : Long.parseLong(str);
            b.c.a.a0.d.j(j <= 4294967295L);
            return Integer.valueOf(Color.argb(f.H(((j >> 24) & 255) ^ 255), f.H(j & 255), f.H((j >> 8) & 255), f.H((j >> 16) & 255)));
        } catch (IllegalArgumentException e) {
            q.c("SsaStyle", b.d.b.a.a.k(b.d.b.a.a.b(str, 36), "Failed to parse color expression: '", str, "'"), e);
            return null;
        }
    }
}
