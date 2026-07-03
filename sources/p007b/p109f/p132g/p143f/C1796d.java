package p007b.p109f.p132g.p143f;

import android.content.res.Resources;
import android.graphics.PointF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import com.facebook.drawee.drawable.ScalingUtils$ScaleType;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p109f.p115d.p120e.C1691a;
import p007b.p109f.p132g.p142e.C1772g;
import p007b.p109f.p132g.p142e.C1777k;
import p007b.p109f.p132g.p142e.C1778l;
import p007b.p109f.p132g.p142e.C1779m;
import p007b.p109f.p132g.p142e.C1781o;
import p007b.p109f.p132g.p142e.C1782p;
import p007b.p109f.p132g.p142e.InterfaceC1766d;
import p007b.p109f.p132g.p142e.InterfaceC1776j;
import p007b.p109f.p161j.p183r.C2030b;

/* JADX INFO: renamed from: b.f.g.f.d */
/* JADX INFO: compiled from: WrappingUtils.java */
/* JADX INFO: loaded from: classes.dex */
public class C1796d {

    /* JADX INFO: renamed from: a */
    public static final Drawable f3479a = new ColorDrawable(0);

    /* JADX INFO: renamed from: a */
    public static Drawable m1126a(Drawable drawable, C1795c c1795c, Resources resources) {
        if (drawable instanceof BitmapDrawable) {
            BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
            C1777k c1777k = new C1777k(resources, bitmapDrawable.getBitmap(), bitmapDrawable.getPaint());
            m1127b(c1777k, c1795c);
            return c1777k;
        }
        if (drawable instanceof NinePatchDrawable) {
            C1781o c1781o = new C1781o((NinePatchDrawable) drawable);
            m1127b(c1781o, c1795c);
            return c1781o;
        }
        if (!(drawable instanceof ColorDrawable)) {
            C1691a.m987o("WrappingUtils", "Don't know how to round that drawable: %s", drawable);
            return drawable;
        }
        C1778l c1778l = new C1778l(((ColorDrawable) drawable).getColor());
        m1127b(c1778l, c1795c);
        return c1778l;
    }

    /* JADX INFO: renamed from: b */
    public static void m1127b(InterfaceC1776j interfaceC1776j, C1795c c1795c) {
        interfaceC1776j.mo1107c(c1795c.f3472b);
        interfaceC1776j.mo1112m(c1795c.f3473c);
        interfaceC1776j.mo1106a(c1795c.f3476f, c1795c.f3475e);
        interfaceC1776j.mo1110i(c1795c.f3477g);
        interfaceC1776j.mo1109f(false);
        interfaceC1776j.mo1108e(c1795c.f3478h);
    }

    /* JADX INFO: renamed from: c */
    public static Drawable m1128c(Drawable drawable, C1795c c1795c, Resources resources) {
        try {
            C2030b.m1527b();
            if (drawable != null && c1795c != null && c1795c.f3471a == 2) {
                if (!(drawable instanceof C1772g)) {
                    return m1126a(drawable, c1795c, resources);
                }
                InterfaceC1766d interfaceC1766d = (C1772g) drawable;
                while (true) {
                    Object objMo1091l = interfaceC1766d.mo1091l();
                    if (objMo1091l == interfaceC1766d || !(objMo1091l instanceof InterfaceC1766d)) {
                        break;
                        break;
                    }
                    interfaceC1766d = (InterfaceC1766d) objMo1091l;
                }
                interfaceC1766d.mo1090g(m1126a(interfaceC1766d.mo1090g(f3479a), c1795c, resources));
                return drawable;
            }
            return drawable;
        } finally {
            C2030b.m1527b();
        }
    }

    /* JADX INFO: renamed from: d */
    public static Drawable m1129d(Drawable drawable, C1795c c1795c) {
        try {
            C2030b.m1527b();
            if (drawable != null && c1795c != null && c1795c.f3471a == 1) {
                C1779m c1779m = new C1779m(drawable);
                m1127b(c1779m, c1795c);
                c1779m.f3403x = c1795c.f3474d;
                c1779m.invalidateSelf();
                return c1779m;
            }
            return drawable;
        } finally {
            C2030b.m1527b();
        }
    }

    /* JADX INFO: renamed from: e */
    public static Drawable m1130e(Drawable drawable, ScalingUtils$ScaleType scalingUtils$ScaleType, PointF pointF) {
        C2030b.m1527b();
        if (drawable == null || scalingUtils$ScaleType == null) {
            C2030b.m1527b();
            return drawable;
        }
        C1782p c1782p = new C1782p(drawable, scalingUtils$ScaleType);
        if (pointF != null && !C1460d.m520g0(c1782p.f3437p, pointF)) {
            if (c1782p.f3437p == null) {
                c1782p.f3437p = new PointF();
            }
            c1782p.f3437p.set(pointF);
            c1782p.m1118p();
            c1782p.invalidateSelf();
        }
        C2030b.m1527b();
        return c1782p;
    }
}
