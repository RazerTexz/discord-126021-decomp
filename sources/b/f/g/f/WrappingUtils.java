package b.f.g.f;

import android.content.res.Resources;
import android.graphics.PointF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import b.c.a.a0.AnimatableValueParser;
import b.f.d.e.FLog;
import b.f.g.e.DrawableParent;
import b.f.g.e.ForwardingDrawable;
import b.f.g.e.Rounded;
import b.f.g.e.RoundedBitmapDrawable2;
import b.f.g.e.RoundedColorDrawable;
import b.f.g.e.RoundedCornersDrawable;
import b.f.g.e.RoundedNinePatchDrawable;
import b.f.g.e.ScaleTypeDrawable;
import b.f.j.r.FrescoSystrace;
import com.facebook.drawee.drawable.ScalingUtils$ScaleType;

/* JADX INFO: renamed from: b.f.g.f.d, reason: use source file name */
/* JADX INFO: compiled from: WrappingUtils.java */
/* JADX INFO: loaded from: classes.dex */
public class WrappingUtils {
    public static final Drawable a = new ColorDrawable(0);

    public static Drawable a(Drawable drawable, RoundingParams roundingParams, Resources resources) {
        if (drawable instanceof BitmapDrawable) {
            BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
            RoundedBitmapDrawable2 roundedBitmapDrawable2 = new RoundedBitmapDrawable2(resources, bitmapDrawable.getBitmap(), bitmapDrawable.getPaint());
            b(roundedBitmapDrawable2, roundingParams);
            return roundedBitmapDrawable2;
        }
        if (drawable instanceof NinePatchDrawable) {
            RoundedNinePatchDrawable roundedNinePatchDrawable = new RoundedNinePatchDrawable((NinePatchDrawable) drawable);
            b(roundedNinePatchDrawable, roundingParams);
            return roundedNinePatchDrawable;
        }
        if (!(drawable instanceof ColorDrawable)) {
            FLog.o("WrappingUtils", "Don't know how to round that drawable: %s", drawable);
            return drawable;
        }
        RoundedColorDrawable roundedColorDrawable = new RoundedColorDrawable(((ColorDrawable) drawable).getColor());
        b(roundedColorDrawable, roundingParams);
        return roundedColorDrawable;
    }

    public static void b(Rounded rounded, RoundingParams roundingParams) {
        rounded.c(roundingParams.f523b);
        rounded.m(roundingParams.c);
        rounded.a(roundingParams.f, roundingParams.e);
        rounded.i(roundingParams.g);
        rounded.f(false);
        rounded.e(roundingParams.h);
    }

    public static Drawable c(Drawable drawable, RoundingParams roundingParams, Resources resources) {
        try {
            FrescoSystrace.b();
            if (drawable != null && roundingParams != null && roundingParams.a == 2) {
                if (!(drawable instanceof ForwardingDrawable)) {
                    return a(drawable, roundingParams, resources);
                }
                DrawableParent drawableParent = (ForwardingDrawable) drawable;
                while (true) {
                    Object objL = drawableParent.l();
                    if (objL == drawableParent || !(objL instanceof DrawableParent)) {
                        break;
                        break;
                    }
                    drawableParent = (DrawableParent) objL;
                }
                drawableParent.g(a(drawableParent.g(a), roundingParams, resources));
                return drawable;
            }
            return drawable;
        } finally {
            FrescoSystrace.b();
        }
    }

    public static Drawable d(Drawable drawable, RoundingParams roundingParams) {
        try {
            FrescoSystrace.b();
            if (drawable != null && roundingParams != null && roundingParams.a == 1) {
                RoundedCornersDrawable roundedCornersDrawable = new RoundedCornersDrawable(drawable);
                b(roundedCornersDrawable, roundingParams);
                roundedCornersDrawable.f514x = roundingParams.d;
                roundedCornersDrawable.invalidateSelf();
                return roundedCornersDrawable;
            }
            return drawable;
        } finally {
            FrescoSystrace.b();
        }
    }

    public static Drawable e(Drawable drawable, ScalingUtils$ScaleType scalingUtils$ScaleType, PointF pointF) {
        FrescoSystrace.b();
        if (drawable == null || scalingUtils$ScaleType == null) {
            FrescoSystrace.b();
            return drawable;
        }
        ScaleTypeDrawable scaleTypeDrawable = new ScaleTypeDrawable(drawable, scalingUtils$ScaleType);
        if (pointF != null && !AnimatableValueParser.g0(scaleTypeDrawable.p, pointF)) {
            if (scaleTypeDrawable.p == null) {
                scaleTypeDrawable.p = new PointF();
            }
            scaleTypeDrawable.p.set(pointF);
            scaleTypeDrawable.p();
            scaleTypeDrawable.invalidateSelf();
        }
        FrescoSystrace.b();
        return scaleTypeDrawable;
    }
}
