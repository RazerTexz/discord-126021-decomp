package com.facebook.drawee.generic;

import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import com.facebook.drawee.drawable.ScalingUtils$ScaleType;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p109f.p132g.p142e.C1760a;
import p007b.p109f.p132g.p142e.C1770f;
import p007b.p109f.p132g.p142e.C1772g;
import p007b.p109f.p132g.p142e.C1774h;
import p007b.p109f.p132g.p142e.C1779m;
import p007b.p109f.p132g.p142e.C1782p;
import p007b.p109f.p132g.p142e.C1792z;
import p007b.p109f.p132g.p142e.InterfaceC1766d;
import p007b.p109f.p132g.p142e.InterfaceC1776j;
import p007b.p109f.p132g.p143f.C1793a;
import p007b.p109f.p132g.p143f.C1794b;
import p007b.p109f.p132g.p143f.C1795c;
import p007b.p109f.p132g.p143f.C1796d;
import p007b.p109f.p132g.p145h.InterfaceC1798a;
import p007b.p109f.p161j.p183r.C2030b;

/* JADX INFO: loaded from: classes.dex */
public class GenericDraweeHierarchy implements InterfaceC1798a {

    /* JADX INFO: renamed from: a */
    public final Drawable f19506a;

    /* JADX INFO: renamed from: b */
    public final Resources f19507b;

    /* JADX INFO: renamed from: c */
    public C1795c f19508c;

    /* JADX INFO: renamed from: d */
    public final C1794b f19509d;

    /* JADX INFO: renamed from: e */
    public final C1770f f19510e;

    /* JADX INFO: renamed from: f */
    public final C1772g f19511f;

    public GenericDraweeHierarchy(C1793a c1793a) {
        int i;
        ColorDrawable colorDrawable = new ColorDrawable(0);
        this.f19506a = colorDrawable;
        C2030b.m1527b();
        this.f19507b = c1793a.f3453c;
        this.f19508c = c1793a.f3468r;
        C1772g c1772g = new C1772g(colorDrawable);
        this.f19511f = c1772g;
        List<Drawable> list = c1793a.f3466p;
        int size = list != null ? list.size() : 1;
        int i2 = (size == 0 ? 1 : size) + (c1793a.f3467q != null ? 1 : 0);
        Drawable[] drawableArr = new Drawable[i2 + 6];
        drawableArr[0] = m8671g(c1793a.f3465o, null);
        drawableArr[1] = m8671g(c1793a.f3456f, c1793a.f3457g);
        ScalingUtils$ScaleType scalingUtils$ScaleType = c1793a.f3464n;
        c1772g.setColorFilter(null);
        drawableArr[2] = C1796d.m1130e(c1772g, scalingUtils$ScaleType, null);
        drawableArr[3] = m8671g(c1793a.f3462l, c1793a.f3463m);
        drawableArr[4] = m8671g(c1793a.f3458h, c1793a.f3459i);
        drawableArr[5] = m8671g(c1793a.f3460j, c1793a.f3461k);
        if (i2 > 0) {
            List<Drawable> list2 = c1793a.f3466p;
            if (list2 != null) {
                Iterator<Drawable> it = list2.iterator();
                i = 0;
                while (it.hasNext()) {
                    drawableArr[i + 6] = m8671g(it.next(), null);
                    i++;
                }
            } else {
                i = 1;
            }
            Drawable drawable = c1793a.f3467q;
            if (drawable != null) {
                drawableArr[i + 6] = m8671g(drawable, null);
            }
        }
        C1770f c1770f = new C1770f(drawableArr, false, 2);
        this.f19510e = c1770f;
        c1770f.f3355w = c1793a.f3454d;
        if (c1770f.f3354v == 1) {
            c1770f.f3354v = 0;
        }
        C1794b c1794b = new C1794b(C1796d.m1129d(c1770f, this.f19508c));
        this.f19509d = c1794b;
        c1794b.mutate();
        m8677m();
        C2030b.m1527b();
    }

    @Override // p007b.p109f.p132g.p145h.InterfaceC1798a
    /* JADX INFO: renamed from: a */
    public void mo1131a(Drawable drawable) {
        C1794b c1794b = this.f19509d;
        c1794b.f3469n = drawable;
        c1794b.invalidateSelf();
    }

    @Override // p007b.p109f.p132g.p145h.InterfaceC1798a
    /* JADX INFO: renamed from: b */
    public void mo1132b(Throwable th) {
        this.f19510e.m1098e();
        m8673i();
        if (this.f19510e.m1093a(4) != null) {
            m8672h(4);
        } else {
            m8672h(1);
        }
        this.f19510e.m1099f();
    }

    @Override // p007b.p109f.p132g.p145h.InterfaceC1798a
    /* JADX INFO: renamed from: c */
    public void mo1133c(Throwable th) {
        this.f19510e.m1098e();
        m8673i();
        if (this.f19510e.m1093a(5) != null) {
            m8672h(5);
        } else {
            m8672h(1);
        }
        this.f19510e.m1099f();
    }

    @Override // p007b.p109f.p132g.p145h.InterfaceC1798a
    /* JADX INFO: renamed from: d */
    public void mo1134d(float f, boolean z2) {
        if (this.f19510e.m1093a(3) == null) {
            return;
        }
        this.f19510e.m1098e();
        m8682r(f);
        if (z2) {
            this.f19510e.m1100g();
        }
        this.f19510e.m1099f();
    }

    @Override // com.facebook.drawee.interfaces.DraweeHierarchy
    /* JADX INFO: renamed from: e */
    public Drawable mo8670e() {
        return this.f19509d;
    }

    @Override // p007b.p109f.p132g.p145h.InterfaceC1798a
    /* JADX INFO: renamed from: f */
    public void mo1135f(Drawable drawable, float f, boolean z2) {
        Drawable drawableM1128c = C1796d.m1128c(drawable, this.f19508c, this.f19507b);
        drawableM1128c.mutate();
        this.f19511f.mo1104o(drawableM1128c);
        this.f19510e.m1098e();
        m8673i();
        m8672h(2);
        m8682r(f);
        if (z2) {
            this.f19510e.m1100g();
        }
        this.f19510e.m1099f();
    }

    /* JADX INFO: renamed from: g */
    public final Drawable m8671g(Drawable drawable, ScalingUtils$ScaleType scalingUtils$ScaleType) {
        return C1796d.m1130e(C1796d.m1128c(drawable, this.f19508c, this.f19507b), scalingUtils$ScaleType, null);
    }

    @Override // com.facebook.drawee.interfaces.DraweeHierarchy
    public Rect getBounds() {
        return this.f19509d.getBounds();
    }

    /* JADX INFO: renamed from: h */
    public final void m8672h(int i) {
        if (i >= 0) {
            C1770f c1770f = this.f19510e;
            c1770f.f3354v = 0;
            c1770f.f3345B[i] = true;
            c1770f.invalidateSelf();
        }
    }

    /* JADX INFO: renamed from: i */
    public final void m8673i() {
        m8674j(1);
        m8674j(2);
        m8674j(3);
        m8674j(4);
        m8674j(5);
    }

    /* JADX INFO: renamed from: j */
    public final void m8674j(int i) {
        if (i >= 0) {
            C1770f c1770f = this.f19510e;
            c1770f.f3354v = 0;
            c1770f.f3345B[i] = false;
            c1770f.invalidateSelf();
        }
    }

    /* JADX INFO: renamed from: k */
    public final InterfaceC1766d m8675k(int i) {
        C1770f c1770f = this.f19510e;
        Objects.requireNonNull(c1770f);
        C1460d.m527i(Boolean.valueOf(i >= 0));
        C1460d.m527i(Boolean.valueOf(i < c1770f.f3329m.length));
        InterfaceC1766d[] interfaceC1766dArr = c1770f.f3329m;
        if (interfaceC1766dArr[i] == null) {
            interfaceC1766dArr[i] = new C1760a(c1770f, i);
        }
        InterfaceC1766d interfaceC1766d = interfaceC1766dArr[i];
        if (interfaceC1766d.mo1091l() instanceof C1774h) {
            interfaceC1766d = (C1774h) interfaceC1766d.mo1091l();
        }
        return interfaceC1766d.mo1091l() instanceof C1782p ? (C1782p) interfaceC1766d.mo1091l() : interfaceC1766d;
    }

    /* JADX INFO: renamed from: l */
    public final C1782p m8676l(int i) {
        InterfaceC1766d interfaceC1766dM8675k = m8675k(i);
        if (interfaceC1766dM8675k instanceof C1782p) {
            return (C1782p) interfaceC1766dM8675k;
        }
        ScalingUtils$ScaleType scalingUtils$ScaleType = ScalingUtils$ScaleType.f19495a;
        Drawable drawableM1130e = C1796d.m1130e(interfaceC1766dM8675k.mo1090g(C1796d.f3479a), C1792z.f3450l, null);
        interfaceC1766dM8675k.mo1090g(drawableM1130e);
        C1460d.m591y(drawableM1130e, "Parent has no child drawable!");
        return (C1782p) drawableM1130e;
    }

    /* JADX INFO: renamed from: m */
    public final void m8677m() {
        C1770f c1770f = this.f19510e;
        if (c1770f != null) {
            c1770f.m1098e();
            C1770f c1770f2 = this.f19510e;
            c1770f2.f3354v = 0;
            Arrays.fill(c1770f2.f3345B, true);
            c1770f2.invalidateSelf();
            m8673i();
            m8672h(1);
            this.f19510e.m1100g();
            this.f19510e.m1099f();
        }
    }

    /* JADX INFO: renamed from: n */
    public void m8678n(ScalingUtils$ScaleType scalingUtils$ScaleType) {
        Objects.requireNonNull(scalingUtils$ScaleType);
        m8676l(2).m1120r(scalingUtils$ScaleType);
    }

    /* JADX INFO: renamed from: o */
    public final void m8679o(int i, Drawable drawable) {
        if (drawable == null) {
            this.f19510e.m1095c(i, null);
        } else {
            m8675k(i).mo1090g(C1796d.m1128c(drawable, this.f19508c, this.f19507b));
        }
    }

    /* JADX INFO: renamed from: p */
    public void m8680p(int i) {
        m8679o(1, this.f19507b.getDrawable(i));
    }

    /* JADX INFO: renamed from: q */
    public void m8681q(Drawable drawable, ScalingUtils$ScaleType scalingUtils$ScaleType) {
        m8679o(1, drawable);
        m8676l(1).m1120r(scalingUtils$ScaleType);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: r */
    public final void m8682r(float f) {
        Drawable drawableM1093a = this.f19510e.m1093a(3);
        if (drawableM1093a == 0) {
            return;
        }
        if (f >= 0.999f) {
            if (drawableM1093a instanceof Animatable) {
                ((Animatable) drawableM1093a).stop();
            }
            m8674j(3);
        } else {
            if (drawableM1093a instanceof Animatable) {
                ((Animatable) drawableM1093a).start();
            }
            m8672h(3);
        }
        drawableM1093a.setLevel(Math.round(f * 10000.0f));
    }

    @Override // p007b.p109f.p132g.p145h.InterfaceC1798a
    public void reset() {
        this.f19511f.mo1104o(this.f19506a);
        m8677m();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: s */
    public void m8683s(C1795c c1795c) {
        this.f19508c = c1795c;
        C1794b c1794b = this.f19509d;
        Drawable drawable = C1796d.f3479a;
        Drawable drawable2 = c1794b.f3360k;
        if (c1795c == null || c1795c.f3471a != 1) {
            if (drawable2 instanceof C1779m) {
                Drawable drawable3 = C1796d.f3479a;
                c1794b.mo1104o(((C1779m) drawable2).mo1104o(drawable3));
                drawable3.setCallback(null);
            }
        } else if (drawable2 instanceof C1779m) {
            C1779m c1779m = (C1779m) drawable2;
            C1796d.m1127b(c1779m, c1795c);
            c1779m.f3403x = c1795c.f3474d;
            c1779m.invalidateSelf();
        } else {
            c1794b.mo1104o(C1796d.m1129d(c1794b.mo1104o(C1796d.f3479a), c1795c));
        }
        for (int i = 0; i < this.f19510e.f3328l.length; i++) {
            InterfaceC1766d interfaceC1766dM8675k = m8675k(i);
            C1795c c1795c2 = this.f19508c;
            Resources resources = this.f19507b;
            while (true) {
                Object objMo1091l = interfaceC1766dM8675k.mo1091l();
                if (objMo1091l == interfaceC1766dM8675k || !(objMo1091l instanceof InterfaceC1766d)) {
                    break;
                } else {
                    interfaceC1766dM8675k = (InterfaceC1766d) objMo1091l;
                }
            }
            Drawable drawableMo1091l = interfaceC1766dM8675k.mo1091l();
            if (c1795c2 == null || c1795c2.f3471a != 2) {
                if (drawableMo1091l instanceof InterfaceC1776j) {
                    InterfaceC1776j interfaceC1776j = (InterfaceC1776j) drawableMo1091l;
                    interfaceC1776j.mo1107c(false);
                    interfaceC1776j.mo1111j(0.0f);
                    interfaceC1776j.mo1106a(0, 0.0f);
                    interfaceC1776j.mo1110i(0.0f);
                    interfaceC1776j.mo1109f(false);
                    interfaceC1776j.mo1108e(false);
                }
            } else if (drawableMo1091l instanceof InterfaceC1776j) {
                C1796d.m1127b((InterfaceC1776j) drawableMo1091l, c1795c2);
            } else if (drawableMo1091l != 0) {
                interfaceC1766dM8675k.mo1090g(C1796d.f3479a);
                interfaceC1766dM8675k.mo1090g(C1796d.m1126a(drawableMo1091l, c1795c2, resources));
            }
        }
    }
}
