package p007b.p225i.p226a.p242c.p255c3;

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
import java.util.Locale;
import java.util.Objects;
import p007b.p225i.p226a.p242c.InterfaceC2963w0;
import p007b.p225i.p226a.p242c.p259f3.C2738e0;
import p007b.p225i.p355b.p357b.AbstractC4493a;
import p007b.p225i.p355b.p357b.AbstractC4523p;
import p007b.p225i.p355b.p357b.AbstractC4527r;
import p007b.p225i.p355b.p357b.C4508h0;
import p007b.p225i.p355b.p357b.C4512j0;

/* JADX INFO: renamed from: b.i.a.c.c3.p */
/* JADX INFO: compiled from: TrackSelectionParameters.java */
/* JADX INFO: loaded from: classes3.dex */
public class C2650p implements InterfaceC2963w0 {

    /* JADX INFO: renamed from: j */
    public static final C2650p f6276j = new C2650p(new a());

    /* JADX INFO: renamed from: A */
    public final AbstractC4523p<String> f6277A;

    /* JADX INFO: renamed from: B */
    public final AbstractC4523p<String> f6278B;

    /* JADX INFO: renamed from: C */
    public final int f6279C;

    /* JADX INFO: renamed from: D */
    public final boolean f6280D;

    /* JADX INFO: renamed from: E */
    public final boolean f6281E;

    /* JADX INFO: renamed from: F */
    public final boolean f6282F;

    /* JADX INFO: renamed from: G */
    public final C2649o f6283G;

    /* JADX INFO: renamed from: H */
    public final AbstractC4527r<Integer> f6284H;

    /* JADX INFO: renamed from: k */
    public final int f6285k;

    /* JADX INFO: renamed from: l */
    public final int f6286l;

    /* JADX INFO: renamed from: m */
    public final int f6287m;

    /* JADX INFO: renamed from: n */
    public final int f6288n;

    /* JADX INFO: renamed from: o */
    public final int f6289o;

    /* JADX INFO: renamed from: p */
    public final int f6290p;

    /* JADX INFO: renamed from: q */
    public final int f6291q;

    /* JADX INFO: renamed from: r */
    public final int f6292r;

    /* JADX INFO: renamed from: s */
    public final int f6293s;

    /* JADX INFO: renamed from: t */
    public final int f6294t;

    /* JADX INFO: renamed from: u */
    public final boolean f6295u;

    /* JADX INFO: renamed from: v */
    public final AbstractC4523p<String> f6296v;

    /* JADX INFO: renamed from: w */
    public final AbstractC4523p<String> f6297w;

    /* JADX INFO: renamed from: x */
    public final int f6298x;

    /* JADX INFO: renamed from: y */
    public final int f6299y;

    /* JADX INFO: renamed from: z */
    public final int f6300z;

    /* JADX INFO: renamed from: b.i.a.c.c3.p$a */
    /* JADX INFO: compiled from: TrackSelectionParameters.java */
    public static class a {

        /* JADX INFO: renamed from: e */
        public int f6305e;

        /* JADX INFO: renamed from: f */
        public int f6306f;

        /* JADX INFO: renamed from: g */
        public int f6307g;

        /* JADX INFO: renamed from: h */
        public int f6308h;

        /* JADX INFO: renamed from: l */
        public AbstractC4523p<String> f6312l;

        /* JADX INFO: renamed from: m */
        public AbstractC4523p<String> f6313m;

        /* JADX INFO: renamed from: n */
        public int f6314n;

        /* JADX INFO: renamed from: o */
        public int f6315o;

        /* JADX INFO: renamed from: p */
        public int f6316p;

        /* JADX INFO: renamed from: q */
        public AbstractC4523p<String> f6317q;

        /* JADX INFO: renamed from: r */
        public AbstractC4523p<String> f6318r;

        /* JADX INFO: renamed from: s */
        public int f6319s;

        /* JADX INFO: renamed from: t */
        public boolean f6320t;

        /* JADX INFO: renamed from: u */
        public boolean f6321u;

        /* JADX INFO: renamed from: v */
        public boolean f6322v;

        /* JADX INFO: renamed from: w */
        public C2649o f6323w;

        /* JADX INFO: renamed from: x */
        public AbstractC4527r<Integer> f6324x;

        /* JADX INFO: renamed from: a */
        public int f6301a = Integer.MAX_VALUE;

        /* JADX INFO: renamed from: b */
        public int f6302b = Integer.MAX_VALUE;

        /* JADX INFO: renamed from: c */
        public int f6303c = Integer.MAX_VALUE;

        /* JADX INFO: renamed from: d */
        public int f6304d = Integer.MAX_VALUE;

        /* JADX INFO: renamed from: i */
        public int f6309i = Integer.MAX_VALUE;

        /* JADX INFO: renamed from: j */
        public int f6310j = Integer.MAX_VALUE;

        /* JADX INFO: renamed from: k */
        public boolean f6311k = true;

        @Deprecated
        public a() {
            AbstractC4493a<Object> abstractC4493a = AbstractC4523p.f12045k;
            AbstractC4523p abstractC4523p = C4508h0.f12012l;
            this.f6312l = abstractC4523p;
            this.f6313m = abstractC4523p;
            this.f6314n = 0;
            this.f6315o = Integer.MAX_VALUE;
            this.f6316p = Integer.MAX_VALUE;
            this.f6317q = abstractC4523p;
            this.f6318r = abstractC4523p;
            this.f6319s = 0;
            this.f6320t = false;
            this.f6321u = false;
            this.f6322v = false;
            this.f6323w = C2649o.f6270j;
            int i = AbstractC4527r.f12057k;
            this.f6324x = C4512j0.f12032m;
        }

        /* JADX INFO: renamed from: a */
        public a mo2742a(Context context) {
            CaptioningManager captioningManager;
            int i = C2738e0.f6708a;
            if (i >= 19 && ((i >= 23 || Looper.myLooper() != null) && (captioningManager = (CaptioningManager) context.getSystemService("captioning")) != null && captioningManager.isEnabled())) {
                this.f6319s = 1088;
                Locale locale = captioningManager.getLocale();
                if (locale != null) {
                    this.f6318r = AbstractC4523p.m6266u(i >= 21 ? locale.toLanguageTag() : locale.toString());
                }
            }
            return this;
        }

        /* JADX INFO: renamed from: b */
        public a mo2743b(int i, int i2, boolean z2) {
            this.f6309i = i;
            this.f6310j = i2;
            this.f6311k = z2;
            return this;
        }

        /* JADX WARN: Code duplicated, block: B:40:0x00b8  */
        /* JADX WARN: Code duplicated, block: B:42:0x00c3  */
        /* JADX WARN: Code duplicated, block: B:43:0x00d4 A[DONT_INVERT] */
        /* JADX WARN: Code duplicated, block: B:44:0x00d6  */
        /* JADX WARN: Code duplicated, block: B:45:0x00da  */
        /* JADX INFO: renamed from: c */
        public a mo2744c(Context context, boolean z2) {
            Point point;
            int i;
            DisplayManager displayManager;
            int i2 = C2738e0.f6708a;
            Display display = (i2 < 17 || (displayManager = (DisplayManager) context.getSystemService("display")) == null) ? null : displayManager.getDisplay(0);
            if (display == null) {
                WindowManager windowManager = (WindowManager) context.getSystemService("window");
                Objects.requireNonNull(windowManager);
                display = windowManager.getDefaultDisplay();
            }
            if (display.getDisplayId() == 0 && C2738e0.m2980A(context)) {
                String strM3014v = i2 < 28 ? C2738e0.m3014v("sys.display-size") : C2738e0.m3014v("vendor.display-size");
                if (!TextUtils.isEmpty(strM3014v)) {
                    try {
                        String[] strArrM2987H = C2738e0.m2987H(strM3014v.trim(), "x");
                        if (strArrM2987H.length == 2) {
                            int i3 = Integer.parseInt(strArrM2987H[0]);
                            int i4 = Integer.parseInt(strArrM2987H[1]);
                            if (i3 > 0 && i4 > 0) {
                                point = new Point(i3, i4);
                            }
                        }
                    } catch (NumberFormatException unused) {
                    }
                    String strValueOf = String.valueOf(strM3014v);
                    Log.e("Util", strValueOf.length() != 0 ? "Invalid display size: ".concat(strValueOf) : new String("Invalid display size: "));
                    if (!"Sony".equals(C2738e0.f6710c) && C2738e0.f6711d.startsWith("BRAVIA") && context.getPackageManager().hasSystemFeature("com.sony.dtv.hardware.panel.qfhd")) {
                        point = new Point(3840, 2160);
                    } else {
                        point = new Point();
                        i = C2738e0.f6708a;
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
                } else if (!"Sony".equals(C2738e0.f6710c)) {
                    point = new Point();
                    i = C2738e0.f6708a;
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
                    i = C2738e0.f6708a;
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
                i = C2738e0.f6708a;
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
            return mo2743b(point.x, point.y, z2);
        }
    }

    public C2650p(a aVar) {
        this.f6285k = aVar.f6301a;
        this.f6286l = aVar.f6302b;
        this.f6287m = aVar.f6303c;
        this.f6288n = aVar.f6304d;
        this.f6289o = aVar.f6305e;
        this.f6290p = aVar.f6306f;
        this.f6291q = aVar.f6307g;
        this.f6292r = aVar.f6308h;
        this.f6293s = aVar.f6309i;
        this.f6294t = aVar.f6310j;
        this.f6295u = aVar.f6311k;
        this.f6296v = aVar.f6312l;
        this.f6297w = aVar.f6313m;
        this.f6298x = aVar.f6314n;
        this.f6299y = aVar.f6315o;
        this.f6300z = aVar.f6316p;
        this.f6277A = aVar.f6317q;
        this.f6278B = aVar.f6318r;
        this.f6279C = aVar.f6319s;
        this.f6280D = aVar.f6320t;
        this.f6281E = aVar.f6321u;
        this.f6282F = aVar.f6322v;
        this.f6283G = aVar.f6323w;
        this.f6284H = aVar.f6324x;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        C2650p c2650p = (C2650p) obj;
        return this.f6285k == c2650p.f6285k && this.f6286l == c2650p.f6286l && this.f6287m == c2650p.f6287m && this.f6288n == c2650p.f6288n && this.f6289o == c2650p.f6289o && this.f6290p == c2650p.f6290p && this.f6291q == c2650p.f6291q && this.f6292r == c2650p.f6292r && this.f6295u == c2650p.f6295u && this.f6293s == c2650p.f6293s && this.f6294t == c2650p.f6294t && this.f6296v.equals(c2650p.f6296v) && this.f6297w.equals(c2650p.f6297w) && this.f6298x == c2650p.f6298x && this.f6299y == c2650p.f6299y && this.f6300z == c2650p.f6300z && this.f6277A.equals(c2650p.f6277A) && this.f6278B.equals(c2650p.f6278B) && this.f6279C == c2650p.f6279C && this.f6280D == c2650p.f6280D && this.f6281E == c2650p.f6281E && this.f6282F == c2650p.f6282F && this.f6283G.equals(c2650p.f6283G) && this.f6284H.equals(c2650p.f6284H);
    }

    public int hashCode() {
        return this.f6284H.hashCode() + ((this.f6283G.hashCode() + ((((((((((this.f6278B.hashCode() + ((this.f6277A.hashCode() + ((((((((this.f6297w.hashCode() + ((this.f6296v.hashCode() + ((((((((((((((((((((((this.f6285k + 31) * 31) + this.f6286l) * 31) + this.f6287m) * 31) + this.f6288n) * 31) + this.f6289o) * 31) + this.f6290p) * 31) + this.f6291q) * 31) + this.f6292r) * 31) + (this.f6295u ? 1 : 0)) * 31) + this.f6293s) * 31) + this.f6294t) * 31)) * 31)) * 31) + this.f6298x) * 31) + this.f6299y) * 31) + this.f6300z) * 31)) * 31)) * 31) + this.f6279C) * 31) + (this.f6280D ? 1 : 0)) * 31) + (this.f6281E ? 1 : 0)) * 31) + (this.f6282F ? 1 : 0)) * 31)) * 31);
    }
}
