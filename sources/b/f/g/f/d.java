package b.f.g.f;

import android.content.res.Resources;
import android.graphics.PointF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import b.f.g.e.g;
import b.f.g.e.j;
import b.f.g.e.k;
import b.f.g.e.l;
import b.f.g.e.m;
import b.f.g.e.o;
import b.f.g.e.p;
import com.facebook.drawee.drawable.ScalingUtils$ScaleType;

/* JADX INFO: compiled from: WrappingUtils.java */
/* JADX INFO: loaded from: classes.dex */
public class d {
    public static final Drawable a = new ColorDrawable(0);

    public static Drawable a(Drawable drawable, c cVar, Resources resources) {
        if (drawable instanceof BitmapDrawable) {
            BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
            k kVar = new k(resources, bitmapDrawable.getBitmap(), bitmapDrawable.getPaint());
            b(kVar, cVar);
            return kVar;
        }
        if (drawable instanceof NinePatchDrawable) {
            o oVar = new o((NinePatchDrawable) drawable);
            b(oVar, cVar);
            return oVar;
        }
        if (!(drawable instanceof ColorDrawable)) {
            b.f.d.e.a.o("WrappingUtils", "Don't know how to round that drawable: %s", drawable);
            return drawable;
        }
        l lVar = new l(((ColorDrawable) drawable).getColor());
        b(lVar, cVar);
        return lVar;
    }

    public static void b(j jVar, c cVar) {
        jVar.c(cVar.f523b);
        jVar.m(cVar.c);
        jVar.a(cVar.f, cVar.e);
        jVar.i(cVar.g);
        jVar.f(false);
        jVar.e(cVar.h);
    }

    public static Drawable c(Drawable drawable, c cVar, Resources resources) {
        try {
            b.f.j.r.b.b();
            if (drawable != null && cVar != null && cVar.a == 2) {
                if (!(drawable instanceof g)) {
                    return a(drawable, cVar, resources);
                }
                b.f.g.e.d dVar = (g) drawable;
                while (true) {
                    Object objL = dVar.l();
                    if (objL == dVar || !(objL instanceof b.f.g.e.d)) {
                        break;
                        break;
                    }
                    dVar = (b.f.g.e.d) objL;
                }
                dVar.g(a(dVar.g(a), cVar, resources));
                return drawable;
            }
            return drawable;
        } finally {
            b.f.j.r.b.b();
        }
    }

    public static Drawable d(Drawable drawable, c cVar) {
        try {
            b.f.j.r.b.b();
            if (drawable != null && cVar != null && cVar.a == 1) {
                m mVar = new m(drawable);
                b(mVar, cVar);
                mVar.f514x = cVar.d;
                mVar.invalidateSelf();
                return mVar;
            }
            return drawable;
        } finally {
            b.f.j.r.b.b();
        }
    }

    public static Drawable e(Drawable drawable, ScalingUtils$ScaleType scalingUtils$ScaleType, PointF pointF) {
        b.f.j.r.b.b();
        if (drawable == null || scalingUtils$ScaleType == null) {
            b.f.j.r.b.b();
            return drawable;
        }
        p pVar = new p(drawable, scalingUtils$ScaleType);
        if (pointF != null && !b.c.a.a0.d.g0(pVar.p, pointF)) {
            if (pVar.p == null) {
                pVar.p = new PointF();
            }
            pVar.p.set(pointF);
            pVar.p();
            pVar.invalidateSelf();
        }
        b.f.j.r.b.b();
        return pVar;
    }
}
