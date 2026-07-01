package com.facebook.drawee.generic;

import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import b.c.a.a0.AnimatableValueParser;
import b.f.g.e.ArrayDrawable;
import b.f.g.e.DrawableParent;
import b.f.g.e.FadeDrawable;
import b.f.g.e.ForwardingDrawable;
import b.f.g.e.MatrixDrawable;
import b.f.g.e.Rounded;
import b.f.g.e.RoundedCornersDrawable;
import b.f.g.e.ScaleTypeDrawable;
import b.f.g.e.z;
import b.f.g.f.GenericDraweeHierarchyBuilder;
import b.f.g.f.RootDrawable;
import b.f.g.f.RoundingParams;
import b.f.g.f.WrappingUtils;
import b.f.g.h.SettableDraweeHierarchy;
import b.f.j.r.FrescoSystrace;
import com.facebook.drawee.drawable.ScalingUtils$ScaleType;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public class GenericDraweeHierarchy implements SettableDraweeHierarchy {
    public final Drawable a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Resources f2890b;
    public RoundingParams c;
    public final RootDrawable d;
    public final FadeDrawable e;
    public final ForwardingDrawable f;

    public GenericDraweeHierarchy(GenericDraweeHierarchyBuilder genericDraweeHierarchyBuilder) {
        int i;
        ColorDrawable colorDrawable = new ColorDrawable(0);
        this.a = colorDrawable;
        FrescoSystrace.b();
        this.f2890b = genericDraweeHierarchyBuilder.c;
        this.c = genericDraweeHierarchyBuilder.r;
        ForwardingDrawable forwardingDrawable = new ForwardingDrawable(colorDrawable);
        this.f = forwardingDrawable;
        List<Drawable> list = genericDraweeHierarchyBuilder.p;
        int size = list != null ? list.size() : 1;
        int i2 = (size == 0 ? 1 : size) + (genericDraweeHierarchyBuilder.q != null ? 1 : 0);
        Drawable[] drawableArr = new Drawable[i2 + 6];
        drawableArr[0] = g(genericDraweeHierarchyBuilder.o, null);
        drawableArr[1] = g(genericDraweeHierarchyBuilder.f, genericDraweeHierarchyBuilder.g);
        ScalingUtils$ScaleType scalingUtils$ScaleType = genericDraweeHierarchyBuilder.n;
        forwardingDrawable.setColorFilter(null);
        drawableArr[2] = WrappingUtils.e(forwardingDrawable, scalingUtils$ScaleType, null);
        drawableArr[3] = g(genericDraweeHierarchyBuilder.l, genericDraweeHierarchyBuilder.m);
        drawableArr[4] = g(genericDraweeHierarchyBuilder.h, genericDraweeHierarchyBuilder.i);
        drawableArr[5] = g(genericDraweeHierarchyBuilder.j, genericDraweeHierarchyBuilder.k);
        if (i2 > 0) {
            List<Drawable> list2 = genericDraweeHierarchyBuilder.p;
            if (list2 != null) {
                Iterator<Drawable> it = list2.iterator();
                i = 0;
                while (it.hasNext()) {
                    drawableArr[i + 6] = g(it.next(), null);
                    i++;
                }
            } else {
                i = 1;
            }
            Drawable drawable = genericDraweeHierarchyBuilder.q;
            if (drawable != null) {
                drawableArr[i + 6] = g(drawable, null);
            }
        }
        FadeDrawable fadeDrawable = new FadeDrawable(drawableArr, false, 2);
        this.e = fadeDrawable;
        fadeDrawable.w = genericDraweeHierarchyBuilder.d;
        if (fadeDrawable.v == 1) {
            fadeDrawable.v = 0;
        }
        RootDrawable rootDrawable = new RootDrawable(WrappingUtils.d(fadeDrawable, this.c));
        this.d = rootDrawable;
        rootDrawable.mutate();
        m();
        FrescoSystrace.b();
    }

    @Override // b.f.g.h.SettableDraweeHierarchy
    public void a(Drawable drawable) {
        RootDrawable rootDrawable = this.d;
        rootDrawable.n = drawable;
        rootDrawable.invalidateSelf();
    }

    @Override // b.f.g.h.SettableDraweeHierarchy
    public void b(Throwable th) {
        this.e.e();
        i();
        if (this.e.a(4) != null) {
            h(4);
        } else {
            h(1);
        }
        this.e.f();
    }

    @Override // b.f.g.h.SettableDraweeHierarchy
    public void c(Throwable th) {
        this.e.e();
        i();
        if (this.e.a(5) != null) {
            h(5);
        } else {
            h(1);
        }
        this.e.f();
    }

    @Override // b.f.g.h.SettableDraweeHierarchy
    public void d(float f, boolean z2) {
        if (this.e.a(3) == null) {
            return;
        }
        this.e.e();
        r(f);
        if (z2) {
            this.e.g();
        }
        this.e.f();
    }

    @Override // com.facebook.drawee.interfaces.DraweeHierarchy
    public Drawable e() {
        return this.d;
    }

    @Override // b.f.g.h.SettableDraweeHierarchy
    public void f(Drawable drawable, float f, boolean z2) {
        Drawable drawableC = WrappingUtils.c(drawable, this.c, this.f2890b);
        drawableC.mutate();
        this.f.o(drawableC);
        this.e.e();
        i();
        h(2);
        r(f);
        if (z2) {
            this.e.g();
        }
        this.e.f();
    }

    public final Drawable g(Drawable drawable, ScalingUtils$ScaleType scalingUtils$ScaleType) {
        return WrappingUtils.e(WrappingUtils.c(drawable, this.c, this.f2890b), scalingUtils$ScaleType, null);
    }

    @Override // com.facebook.drawee.interfaces.DraweeHierarchy
    public Rect getBounds() {
        return this.d.getBounds();
    }

    public final void h(int i) {
        if (i >= 0) {
            FadeDrawable fadeDrawable = this.e;
            fadeDrawable.v = 0;
            fadeDrawable.B[i] = true;
            fadeDrawable.invalidateSelf();
        }
    }

    public final void i() {
        j(1);
        j(2);
        j(3);
        j(4);
        j(5);
    }

    public final void j(int i) {
        if (i >= 0) {
            FadeDrawable fadeDrawable = this.e;
            fadeDrawable.v = 0;
            fadeDrawable.B[i] = false;
            fadeDrawable.invalidateSelf();
        }
    }

    public final DrawableParent k(int i) {
        FadeDrawable fadeDrawable = this.e;
        Objects.requireNonNull(fadeDrawable);
        AnimatableValueParser.i(Boolean.valueOf(i >= 0));
        AnimatableValueParser.i(Boolean.valueOf(i < fadeDrawable.m.length));
        DrawableParent[] drawableParentArr = fadeDrawable.m;
        if (drawableParentArr[i] == null) {
            drawableParentArr[i] = new ArrayDrawable(fadeDrawable, i);
        }
        DrawableParent drawableParent = drawableParentArr[i];
        if (drawableParent.l() instanceof MatrixDrawable) {
            drawableParent = (MatrixDrawable) drawableParent.l();
        }
        return drawableParent.l() instanceof ScaleTypeDrawable ? (ScaleTypeDrawable) drawableParent.l() : drawableParent;
    }

    public final ScaleTypeDrawable l(int i) {
        DrawableParent drawableParentK = k(i);
        if (drawableParentK instanceof ScaleTypeDrawable) {
            return (ScaleTypeDrawable) drawableParentK;
        }
        ScalingUtils$ScaleType scalingUtils$ScaleType = ScalingUtils$ScaleType.a;
        Drawable drawableE = WrappingUtils.e(drawableParentK.g(WrappingUtils.a), z.l, null);
        drawableParentK.g(drawableE);
        AnimatableValueParser.y(drawableE, "Parent has no child drawable!");
        return (ScaleTypeDrawable) drawableE;
    }

    public final void m() {
        FadeDrawable fadeDrawable = this.e;
        if (fadeDrawable != null) {
            fadeDrawable.e();
            FadeDrawable fadeDrawable2 = this.e;
            fadeDrawable2.v = 0;
            Arrays.fill(fadeDrawable2.B, true);
            fadeDrawable2.invalidateSelf();
            i();
            h(1);
            this.e.g();
            this.e.f();
        }
    }

    public void n(ScalingUtils$ScaleType scalingUtils$ScaleType) {
        Objects.requireNonNull(scalingUtils$ScaleType);
        l(2).r(scalingUtils$ScaleType);
    }

    public final void o(int i, Drawable drawable) {
        if (drawable == null) {
            this.e.c(i, null);
        } else {
            k(i).g(WrappingUtils.c(drawable, this.c, this.f2890b));
        }
    }

    public void p(int i) {
        o(1, this.f2890b.getDrawable(i));
    }

    public void q(Drawable drawable, ScalingUtils$ScaleType scalingUtils$ScaleType) {
        o(1, drawable);
        l(1).r(scalingUtils$ScaleType);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void r(float f) {
        Drawable drawableA = this.e.a(3);
        if (drawableA == 0) {
            return;
        }
        if (f >= 0.999f) {
            if (drawableA instanceof Animatable) {
                ((Animatable) drawableA).stop();
            }
            j(3);
        } else {
            if (drawableA instanceof Animatable) {
                ((Animatable) drawableA).start();
            }
            h(3);
        }
        drawableA.setLevel(Math.round(f * 10000.0f));
    }

    @Override // b.f.g.h.SettableDraweeHierarchy
    public void reset() {
        this.f.o(this.a);
        m();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void s(RoundingParams roundingParams) {
        this.c = roundingParams;
        RootDrawable rootDrawable = this.d;
        Drawable drawable = WrappingUtils.a;
        Drawable drawable2 = rootDrawable.k;
        if (roundingParams == null || roundingParams.a != 1) {
            if (drawable2 instanceof RoundedCornersDrawable) {
                Drawable drawable3 = WrappingUtils.a;
                rootDrawable.o(((RoundedCornersDrawable) drawable2).o(drawable3));
                drawable3.setCallback(null);
            }
        } else if (drawable2 instanceof RoundedCornersDrawable) {
            RoundedCornersDrawable roundedCornersDrawable = (RoundedCornersDrawable) drawable2;
            WrappingUtils.b(roundedCornersDrawable, roundingParams);
            roundedCornersDrawable.f514x = roundingParams.d;
            roundedCornersDrawable.invalidateSelf();
        } else {
            rootDrawable.o(WrappingUtils.d(rootDrawable.o(WrappingUtils.a), roundingParams));
        }
        for (int i = 0; i < this.e.l.length; i++) {
            DrawableParent drawableParentK = k(i);
            RoundingParams roundingParams2 = this.c;
            Resources resources = this.f2890b;
            while (true) {
                Object objL = drawableParentK.l();
                if (objL == drawableParentK || !(objL instanceof DrawableParent)) {
                    break;
                } else {
                    drawableParentK = (DrawableParent) objL;
                }
            }
            Drawable drawableL = drawableParentK.l();
            if (roundingParams2 == null || roundingParams2.a != 2) {
                if (drawableL instanceof Rounded) {
                    Rounded rounded = (Rounded) drawableL;
                    rounded.c(false);
                    rounded.j(0.0f);
                    rounded.a(0, 0.0f);
                    rounded.i(0.0f);
                    rounded.f(false);
                    rounded.e(false);
                }
            } else if (drawableL instanceof Rounded) {
                WrappingUtils.b((Rounded) drawableL, roundingParams2);
            } else if (drawableL != 0) {
                drawableParentK.g(WrappingUtils.a);
                drawableParentK.g(WrappingUtils.a(drawableL, roundingParams2, resources));
            }
        }
    }
}
