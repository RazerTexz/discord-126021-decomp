package b.f.g.a.a;

import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import b.f.g.e.OrientedDrawable;
import b.f.j.i.DrawableFactory;
import b.f.j.j.CloseableImage;
import b.f.j.j.CloseableStaticBitmap;
import b.f.j.r.FrescoSystrace;

/* JADX INFO: renamed from: b.f.g.a.a.a, reason: use source file name */
/* JADX INFO: compiled from: DefaultDrawableFactory.java */
/* JADX INFO: loaded from: classes.dex */
public class DefaultDrawableFactory implements DrawableFactory {
    public final Resources a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final DrawableFactory f476b;

    public DefaultDrawableFactory(Resources resources, DrawableFactory drawableFactory) {
        this.a = resources;
        this.f476b = drawableFactory;
    }

    @Override // b.f.j.i.DrawableFactory
    public boolean a(CloseableImage closeableImage) {
        return true;
    }

    @Override // b.f.j.i.DrawableFactory
    public Drawable b(CloseableImage closeableImage) {
        try {
            FrescoSystrace.b();
            if (!(closeableImage instanceof CloseableStaticBitmap)) {
                DrawableFactory drawableFactory = this.f476b;
                if (drawableFactory == null || !drawableFactory.a(closeableImage)) {
                    return null;
                }
                return this.f476b.b(closeableImage);
            }
            CloseableStaticBitmap closeableStaticBitmap = (CloseableStaticBitmap) closeableImage;
            BitmapDrawable bitmapDrawable = new BitmapDrawable(this.a, closeableStaticBitmap.m);
            int i = closeableStaticBitmap.o;
            if (!((i == 0 || i == -1) ? false : true)) {
                int i2 = closeableStaticBitmap.p;
                if (!((i2 == 1 || i2 == 0) ? false : true)) {
                    return bitmapDrawable;
                }
            }
            return new OrientedDrawable(bitmapDrawable, closeableStaticBitmap.o, closeableStaticBitmap.p);
        } finally {
            FrescoSystrace.b();
        }
    }
}
