package b.i.a.c.b3.n;

import android.graphics.Color;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import java.util.ArrayList;
import java.util.List;
import org.objectweb.asm.Opcodes;

/* JADX INFO: compiled from: Cea708Decoder.java */
/* JADX INFO: loaded from: classes3.dex */
public final class d$b {
    public static final int a = d(2, 2, 2, 0);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f854b;
    public static final int c;
    public static final int[] d;
    public static final int[] e;
    public static final int[] f;
    public static final boolean[] g;
    public static final int[] h;
    public static final int[] i;
    public static final int[] j;
    public static final int[] k;
    public int A;
    public int B;
    public int C;
    public int D;
    public int E;
    public int F;
    public int G;
    public final List<SpannableString> l = new ArrayList();
    public final SpannableStringBuilder m = new SpannableStringBuilder();
    public boolean n;
    public boolean o;
    public int p;
    public boolean q;
    public int r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f855s;
    public int t;
    public int u;
    public boolean v;
    public int w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f856x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f857y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f858z;

    static {
        int iD = d(0, 0, 0, 0);
        f854b = iD;
        int iD2 = d(0, 0, 0, 3);
        c = iD2;
        d = new int[]{0, 0, 0, 0, 0, 2, 0};
        e = new int[]{0, 0, 0, 0, 0, 0, 2};
        f = new int[]{3, 3, 3, 3, 3, 3, 1};
        g = new boolean[]{false, false, false, true, true, true, false};
        h = new int[]{iD, iD2, iD, iD, iD2, iD, iD};
        i = new int[]{0, 1, 2, 3, 4, 3, 4};
        j = new int[]{0, 0, 0, 0, 0, 3, 3};
        k = new int[]{iD, iD, iD, iD, iD, iD2, iD2};
    }

    public d$b() {
        f();
    }

    /* JADX WARN: Code duplicated, block: B:12:0x0021  */
    public static int d(int i2, int i3, int i4, int i5) {
        int i6;
        b.c.a.a0.d.t(i2, 0, 4);
        b.c.a.a0.d.t(i3, 0, 4);
        b.c.a.a0.d.t(i4, 0, 4);
        b.c.a.a0.d.t(i5, 0, 4);
        if (i5 == 0 || i5 == 1) {
            i6 = 255;
        } else if (i5 == 2) {
            i6 = Opcodes.LAND;
        } else if (i5 != 3) {
            i6 = 255;
        } else {
            i6 = 0;
        }
        return Color.argb(i6, i2 > 1 ? 255 : 0, i3 > 1 ? 255 : 0, i4 > 1 ? 255 : 0);
    }

    public void a(char c2) {
        if (c2 != '\n') {
            this.m.append(c2);
            return;
        }
        this.l.add(b());
        this.m.clear();
        if (this.A != -1) {
            this.A = 0;
        }
        if (this.B != -1) {
            this.B = 0;
        }
        if (this.C != -1) {
            this.C = 0;
        }
        if (this.E != -1) {
            this.E = 0;
        }
        while (true) {
            if ((!this.v || this.l.size() < this.u) && this.l.size() < 15) {
                return;
            } else {
                this.l.remove(0);
            }
        }
    }

    public SpannableString b() {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.m);
        int length = spannableStringBuilder.length();
        if (length > 0) {
            if (this.A != -1) {
                spannableStringBuilder.setSpan(new StyleSpan(2), this.A, length, 33);
            }
            if (this.B != -1) {
                spannableStringBuilder.setSpan(new UnderlineSpan(), this.B, length, 33);
            }
            if (this.C != -1) {
                spannableStringBuilder.setSpan(new ForegroundColorSpan(this.D), this.C, length, 33);
            }
            if (this.E != -1) {
                spannableStringBuilder.setSpan(new BackgroundColorSpan(this.F), this.E, length, 33);
            }
        }
        return new SpannableString(spannableStringBuilder);
    }

    public void c() {
        this.l.clear();
        this.m.clear();
        this.A = -1;
        this.B = -1;
        this.C = -1;
        this.E = -1;
        this.G = 0;
    }

    public boolean e() {
        return !this.n || (this.l.isEmpty() && this.m.length() == 0);
    }

    public void f() {
        c();
        this.n = false;
        this.o = false;
        this.p = 4;
        this.q = false;
        this.r = 0;
        this.f855s = 0;
        this.t = 0;
        this.u = 15;
        this.v = true;
        this.w = 0;
        this.f856x = 0;
        this.f857y = 0;
        int i2 = f854b;
        this.f858z = i2;
        this.D = a;
        this.F = i2;
    }

    public void g(boolean z2, boolean z3) {
        if (this.A != -1) {
            if (!z2) {
                this.m.setSpan(new StyleSpan(2), this.A, this.m.length(), 33);
                this.A = -1;
            }
        } else if (z2) {
            this.A = this.m.length();
        }
        if (this.B == -1) {
            if (z3) {
                this.B = this.m.length();
            }
        } else {
            if (z3) {
                return;
            }
            this.m.setSpan(new UnderlineSpan(), this.B, this.m.length(), 33);
            this.B = -1;
        }
    }

    public void h(int i2, int i3) {
        if (this.C != -1 && this.D != i2) {
            this.m.setSpan(new ForegroundColorSpan(this.D), this.C, this.m.length(), 33);
        }
        if (i2 != a) {
            this.C = this.m.length();
            this.D = i2;
        }
        if (this.E != -1 && this.F != i3) {
            this.m.setSpan(new BackgroundColorSpan(this.F), this.E, this.m.length(), 33);
        }
        if (i3 != f854b) {
            this.E = this.m.length();
            this.F = i3;
        }
    }
}
