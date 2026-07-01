package b.i.a.c.c3;

import android.content.Context;
import android.graphics.Point;
import android.hardware.display.DisplayManager;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import android.view.Display;
import android.view.Display$Mode;
import android.view.WindowManager;
import android.view.accessibility.CaptioningManager;
import b.i.a.c.f3.e0;
import b.i.b.b.h0;
import b.i.b.b.j0;
import java.util.Locale;
import java.util.Objects;

/* JADX INFO: compiled from: TrackSelectionParameters.java */
/* JADX INFO: loaded from: classes3.dex */
public class p$a {
    public int e;
    public int f;
    public int g;
    public int h;
    public b.i.b.b.p<String> l;
    public b.i.b.b.p<String> m;
    public int n;
    public int o;
    public int p;
    public b.i.b.b.p<String> q;
    public b.i.b.b.p<String> r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f910s;
    public boolean t;
    public boolean u;
    public boolean v;
    public o w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public b.i.b.b.r<Integer> f911x;
    public int a = Integer.MAX_VALUE;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f909b = Integer.MAX_VALUE;
    public int c = Integer.MAX_VALUE;
    public int d = Integer.MAX_VALUE;
    public int i = Integer.MAX_VALUE;
    public int j = Integer.MAX_VALUE;
    public boolean k = true;

    @Deprecated
    public p$a() {
        b.i.b.b.a<Object> aVar = b.i.b.b.p.k;
        b.i.b.b.p pVar = h0.l;
        this.l = pVar;
        this.m = pVar;
        this.n = 0;
        this.o = Integer.MAX_VALUE;
        this.p = Integer.MAX_VALUE;
        this.q = pVar;
        this.r = pVar;
        this.f910s = 0;
        this.t = false;
        this.u = false;
        this.v = false;
        this.w = o.j;
        int i = b.i.b.b.r.k;
        this.f911x = j0.m;
    }

    public p$a a(Context context) {
        CaptioningManager captioningManager;
        int i = e0.a;
        if (i >= 19 && ((i >= 23 || Looper.myLooper() != null) && (captioningManager = (CaptioningManager) context.getSystemService("captioning")) != null && captioningManager.isEnabled())) {
            this.f910s = 1088;
            Locale locale = captioningManager.getLocale();
            if (locale != null) {
                this.r = b.i.b.b.p.u(i >= 21 ? locale.toLanguageTag() : locale.toString());
            }
        }
        return this;
    }

    public p$a b(int i, int i2, boolean z2) {
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
    public p$a c(Context context, boolean z2) {
        Point point;
        int i;
        DisplayManager displayManager;
        int i2 = e0.a;
        Display display = (i2 < 17 || (displayManager = (DisplayManager) context.getSystemService("display")) == null) ? null : displayManager.getDisplay(0);
        if (display == null) {
            WindowManager windowManager = (WindowManager) context.getSystemService("window");
            Objects.requireNonNull(windowManager);
            display = windowManager.getDefaultDisplay();
        }
        if (display.getDisplayId() == 0 && e0.A(context)) {
            String strV = i2 < 28 ? e0.v("sys.display-size") : e0.v("vendor.display-size");
            if (!TextUtils.isEmpty(strV)) {
                try {
                    String[] strArrH = e0.H(strV.trim(), "x");
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
                if (!"Sony".equals(e0.c) && e0.d.startsWith("BRAVIA") && context.getPackageManager().hasSystemFeature("com.sony.dtv.hardware.panel.qfhd")) {
                    point = new Point(3840, 2160);
                } else {
                    point = new Point();
                    i = e0.a;
                    if (i >= 23) {
                        Display$Mode mode = display.getMode();
                        point.x = mode.getPhysicalWidth();
                        point.y = mode.getPhysicalHeight();
                    } else if (i >= 17) {
                        display.getRealSize(point);
                    } else {
                        display.getSize(point);
                    }
                }
            } else if (!"Sony".equals(e0.c)) {
                point = new Point();
                i = e0.a;
                if (i >= 23) {
                    Display$Mode mode2 = display.getMode();
                    point.x = mode2.getPhysicalWidth();
                    point.y = mode2.getPhysicalHeight();
                } else if (i >= 17) {
                    display.getRealSize(point);
                } else {
                    display.getSize(point);
                }
            } else {
                point = new Point();
                i = e0.a;
                if (i >= 23) {
                    Display$Mode mode3 = display.getMode();
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
            i = e0.a;
            if (i >= 23) {
                Display$Mode mode4 = display.getMode();
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
