package b.i.a.c.c3;

import android.content.Context;
import android.graphics.Point;
import android.hardware.display.DisplayManager;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;
import android.view.accessibility.CaptioningManager;
import androidx.annotation.Nullable;
import b.i.a.c.Bundleable;
import b.i.a.c.f3.Util2;
import b.i.b.b.AbstractIndexedListIterator;
import b.i.b.b.ImmutableList2;
import b.i.b.b.ImmutableSet2;
import b.i.b.b.RegularImmutableList;
import b.i.b.b.RegularImmutableSet;
import java.util.Locale;
import java.util.Objects;

/* JADX INFO: renamed from: b.i.a.c.c3.p, reason: use source file name */
/* JADX INFO: compiled from: TrackSelectionParameters.java */
/* JADX INFO: loaded from: classes3.dex */
public class TrackSelectionParameters implements Bundleable {
    public static final TrackSelectionParameters j = new TrackSelectionParameters(new a());
    public final ImmutableList2<String> A;
    public final ImmutableList2<String> B;
    public final int C;
    public final boolean D;
    public final boolean E;
    public final boolean F;
    public final TrackSelectionOverrides G;
    public final ImmutableSet2<Integer> H;
    public final int k;
    public final int l;
    public final int m;
    public final int n;
    public final int o;
    public final int p;
    public final int q;
    public final int r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final int f905s;
    public final int t;
    public final boolean u;
    public final ImmutableList2<String> v;
    public final ImmutableList2<String> w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final int f906x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final int f907y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final int f908z;

    /* JADX INFO: renamed from: b.i.a.c.c3.p$a */
    /* JADX INFO: compiled from: TrackSelectionParameters.java */
    public static class a {
        public int e;
        public int f;
        public int g;
        public int h;
        public ImmutableList2<String> l;
        public ImmutableList2<String> m;
        public int n;
        public int o;
        public int p;
        public ImmutableList2<String> q;
        public ImmutableList2<String> r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public int f910s;
        public boolean t;
        public boolean u;
        public boolean v;
        public TrackSelectionOverrides w;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        public ImmutableSet2<Integer> f911x;
        public int a = Integer.MAX_VALUE;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f909b = Integer.MAX_VALUE;
        public int c = Integer.MAX_VALUE;
        public int d = Integer.MAX_VALUE;
        public int i = Integer.MAX_VALUE;
        public int j = Integer.MAX_VALUE;
        public boolean k = true;

        @Deprecated
        public a() {
            AbstractIndexedListIterator<Object> abstractIndexedListIterator = ImmutableList2.k;
            ImmutableList2 immutableList2 = RegularImmutableList.l;
            this.l = immutableList2;
            this.m = immutableList2;
            this.n = 0;
            this.o = Integer.MAX_VALUE;
            this.p = Integer.MAX_VALUE;
            this.q = immutableList2;
            this.r = immutableList2;
            this.f910s = 0;
            this.t = false;
            this.u = false;
            this.v = false;
            this.w = TrackSelectionOverrides.j;
            int i = ImmutableSet2.k;
            this.f911x = RegularImmutableSet.m;
        }

        public a a(Context context) {
            CaptioningManager captioningManager;
            int i = Util2.a;
            if (i >= 19 && ((i >= 23 || Looper.myLooper() != null) && (captioningManager = (CaptioningManager) context.getSystemService("captioning")) != null && captioningManager.isEnabled())) {
                this.f910s = 1088;
                Locale locale = captioningManager.getLocale();
                if (locale != null) {
                    this.r = ImmutableList2.u(i >= 21 ? locale.toLanguageTag() : locale.toString());
                }
            }
            return this;
        }

        public a b(int i, int i2, boolean z2) {
            this.i = i;
            this.j = i2;
            this.k = z2;
            return this;
        }

        /* JADX WARN: Code duplicated, block: B:40:0x00b8  */
        /* JADX WARN: Code duplicated, block: B:42:0x00c3  */
        /* JADX WARN: Code duplicated, block: B:43:0x00d4 A[DONT_INVERT] */
        /* JADX WARN: Code duplicated, block: B:44:0x00d6  */
        /* JADX WARN: Code duplicated, block: B:45:0x00da  */
        public a c(Context context, boolean z2) {
            Point point;
            int i;
            DisplayManager displayManager;
            int i2 = Util2.a;
            Display display = (i2 < 17 || (displayManager = (DisplayManager) context.getSystemService("display")) == null) ? null : displayManager.getDisplay(0);
            if (display == null) {
                WindowManager windowManager = (WindowManager) context.getSystemService("window");
                Objects.requireNonNull(windowManager);
                display = windowManager.getDefaultDisplay();
            }
            if (display.getDisplayId() == 0 && Util2.A(context)) {
                String strV = i2 < 28 ? Util2.v("sys.display-size") : Util2.v("vendor.display-size");
                if (!TextUtils.isEmpty(strV)) {
                    try {
                        String[] strArrH = Util2.H(strV.trim(), "x");
                        if (strArrH.length == 2) {
                            int i3 = Integer.parseInt(strArrH[0]);
                            int i4 = Integer.parseInt(strArrH[1]);
                            if (i3 > 0 && i4 > 0) {
                                point = new Point(i3, i4);
                            }
                        }
                    } catch (NumberFormatException unused) {
                    }
                    String strValueOf = String.valueOf(strV);
                    Log.e("Util", strValueOf.length() != 0 ? "Invalid display size: ".concat(strValueOf) : new String("Invalid display size: "));
                    if (!"Sony".equals(Util2.c) && Util2.d.startsWith("BRAVIA") && context.getPackageManager().hasSystemFeature("com.sony.dtv.hardware.panel.qfhd")) {
                        point = new Point(3840, 2160);
                    } else {
                        point = new Point();
                        i = Util2.a;
                        if (i >= 23) {
                            Display.Mode mode = display.getMode();
                            point.x = mode.getPhysicalWidth();
                            point.y = mode.getPhysicalHeight();
                        } else if (i >= 17) {
                            display.getRealSize(point);
                        } else {
                            display.getSize(point);
                        }
                    }
                } else if (!"Sony".equals(Util2.c)) {
                    point = new Point();
                    i = Util2.a;
                    if (i >= 23) {
                        Display.Mode mode2 = display.getMode();
                        point.x = mode2.getPhysicalWidth();
                        point.y = mode2.getPhysicalHeight();
                    } else if (i >= 17) {
                        display.getRealSize(point);
                    } else {
                        display.getSize(point);
                    }
                } else {
                    point = new Point();
                    i = Util2.a;
                    if (i >= 23) {
                        Display.Mode mode3 = display.getMode();
                        point.x = mode3.getPhysicalWidth();
                        point.y = mode3.getPhysicalHeight();
                    } else if (i >= 17) {
                        display.getRealSize(point);
                    } else {
                        display.getSize(point);
                    }
                }
            } else {
                point = new Point();
                i = Util2.a;
                if (i >= 23) {
                    Display.Mode mode4 = display.getMode();
                    point.x = mode4.getPhysicalWidth();
                    point.y = mode4.getPhysicalHeight();
                } else if (i >= 17) {
                    display.getRealSize(point);
                } else {
                    display.getSize(point);
                }
            }
            return b(point.x, point.y, z2);
        }
    }

    public TrackSelectionParameters(a aVar) {
        this.k = aVar.a;
        this.l = aVar.f909b;
        this.m = aVar.c;
        this.n = aVar.d;
        this.o = aVar.e;
        this.p = aVar.f;
        this.q = aVar.g;
        this.r = aVar.h;
        this.f905s = aVar.i;
        this.t = aVar.j;
        this.u = aVar.k;
        this.v = aVar.l;
        this.w = aVar.m;
        this.f906x = aVar.n;
        this.f907y = aVar.o;
        this.f908z = aVar.p;
        this.A = aVar.q;
        this.B = aVar.r;
        this.C = aVar.f910s;
        this.D = aVar.t;
        this.E = aVar.u;
        this.F = aVar.v;
        this.G = aVar.w;
        this.H = aVar.f911x;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        TrackSelectionParameters trackSelectionParameters = (TrackSelectionParameters) obj;
        return this.k == trackSelectionParameters.k && this.l == trackSelectionParameters.l && this.m == trackSelectionParameters.m && this.n == trackSelectionParameters.n && this.o == trackSelectionParameters.o && this.p == trackSelectionParameters.p && this.q == trackSelectionParameters.q && this.r == trackSelectionParameters.r && this.u == trackSelectionParameters.u && this.f905s == trackSelectionParameters.f905s && this.t == trackSelectionParameters.t && this.v.equals(trackSelectionParameters.v) && this.w.equals(trackSelectionParameters.w) && this.f906x == trackSelectionParameters.f906x && this.f907y == trackSelectionParameters.f907y && this.f908z == trackSelectionParameters.f908z && this.A.equals(trackSelectionParameters.A) && this.B.equals(trackSelectionParameters.B) && this.C == trackSelectionParameters.C && this.D == trackSelectionParameters.D && this.E == trackSelectionParameters.E && this.F == trackSelectionParameters.F && this.G.equals(trackSelectionParameters.G) && this.H.equals(trackSelectionParameters.H);
    }

    public int hashCode() {
        return this.H.hashCode() + ((this.G.hashCode() + ((((((((((this.B.hashCode() + ((this.A.hashCode() + ((((((((this.w.hashCode() + ((this.v.hashCode() + ((((((((((((((((((((((this.k + 31) * 31) + this.l) * 31) + this.m) * 31) + this.n) * 31) + this.o) * 31) + this.p) * 31) + this.q) * 31) + this.r) * 31) + (this.u ? 1 : 0)) * 31) + this.f905s) * 31) + this.t) * 31)) * 31)) * 31) + this.f906x) * 31) + this.f907y) * 31) + this.f908z) * 31)) * 31)) * 31) + this.C) * 31) + (this.D ? 1 : 0)) * 31) + (this.E ? 1 : 0)) * 31) + (this.F ? 1 : 0)) * 31)) * 31);
    }
}
