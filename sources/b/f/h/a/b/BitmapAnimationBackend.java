package b.f.h.a.b;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import androidx.annotation.IntRange;
import b.f.d.e.FLog;
import b.f.h.a.a.AnimationBackend;
import b.f.h.a.a.AnimationBackendDelegateWithInactivityCheck;
import b.f.h.a.a.AnimationInformation;
import b.f.h.a.b.e.BitmapFramePreparationStrategy;
import b.f.h.a.b.e.BitmapFramePreparer;
import b.f.h.a.b.e.DefaultBitmapFramePreparer;
import b.f.h.a.b.e.DefaultBitmapFramePreparer.a;
import b.f.h.a.b.e.FixedNumberBitmapFramePreparationStrategy;
import b.f.h.a.b.f.AnimatedDrawableBackendFrameRenderer;
import b.f.j.a.c.AnimatedDrawableBackendImpl;
import b.f.j.a.c.AnimatedImageCompositor;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;
import java.util.Objects;

/* JADX INFO: renamed from: b.f.h.a.b.a, reason: use source file name */
/* JADX INFO: compiled from: BitmapAnimationBackend.java */
/* JADX INFO: loaded from: classes.dex */
public class BitmapAnimationBackend implements AnimationBackend, AnimationBackendDelegateWithInactivityCheck.b {
    public final PlatformBitmapFactory a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final BitmapFrameCache f526b;
    public final AnimationInformation c;
    public final BitmapFrameRenderer d;
    public final BitmapFramePreparationStrategy e;
    public final BitmapFramePreparer f;
    public Rect h;
    public int i;
    public int j;
    public Bitmap.Config k = Bitmap.Config.ARGB_8888;
    public final Paint g = new Paint(6);

    public BitmapAnimationBackend(PlatformBitmapFactory platformBitmapFactory, BitmapFrameCache bitmapFrameCache, AnimationInformation animationInformation, BitmapFrameRenderer bitmapFrameRenderer, BitmapFramePreparationStrategy bitmapFramePreparationStrategy, BitmapFramePreparer bitmapFramePreparer) {
        this.a = platformBitmapFactory;
        this.f526b = bitmapFrameCache;
        this.c = animationInformation;
        this.d = bitmapFrameRenderer;
        this.e = bitmapFramePreparationStrategy;
        this.f = bitmapFramePreparer;
        n();
    }

    @Override // b.f.h.a.a.AnimationInformation
    public int a() {
        return this.c.a();
    }

    @Override // b.f.h.a.a.AnimationInformation
    public int b() {
        return this.c.b();
    }

    @Override // b.f.h.a.a.AnimationBackendDelegateWithInactivityCheck.b
    public void c() {
        this.f526b.clear();
    }

    @Override // b.f.h.a.a.AnimationBackend
    public void clear() {
        this.f526b.clear();
    }

    @Override // b.f.h.a.a.AnimationBackend
    public void d(ColorFilter colorFilter) {
        this.g.setColorFilter(colorFilter);
    }

    @Override // b.f.h.a.a.AnimationInformation
    public int e(int i) {
        return this.c.e(i);
    }

    @Override // b.f.h.a.a.AnimationBackend
    public void f(@IntRange(from = 0, to = 255) int i) {
        this.g.setAlpha(i);
    }

    @Override // b.f.h.a.a.AnimationBackend
    public int g() {
        return this.j;
    }

    @Override // b.f.h.a.a.AnimationBackend
    public void h(Rect rect) {
        this.h = rect;
        AnimatedDrawableBackendFrameRenderer animatedDrawableBackendFrameRenderer = (AnimatedDrawableBackendFrameRenderer) this.d;
        AnimatedDrawableBackendImpl animatedDrawableBackendImpl = (AnimatedDrawableBackendImpl) animatedDrawableBackendFrameRenderer.f531b;
        if (!AnimatedDrawableBackendImpl.a(animatedDrawableBackendImpl.c, rect).equals(animatedDrawableBackendImpl.d)) {
            animatedDrawableBackendImpl = new AnimatedDrawableBackendImpl(animatedDrawableBackendImpl.a, animatedDrawableBackendImpl.f548b, rect, animatedDrawableBackendImpl.i);
        }
        if (animatedDrawableBackendImpl != animatedDrawableBackendFrameRenderer.f531b) {
            animatedDrawableBackendFrameRenderer.f531b = animatedDrawableBackendImpl;
            animatedDrawableBackendFrameRenderer.c = new AnimatedImageCompositor(animatedDrawableBackendImpl, animatedDrawableBackendFrameRenderer.d);
        }
        n();
    }

    @Override // b.f.h.a.a.AnimationBackend
    public int i() {
        return this.i;
    }

    @Override // b.f.h.a.a.AnimationBackend
    public boolean j(Drawable drawable, Canvas canvas, int i) {
        BitmapFramePreparer bitmapFramePreparer;
        int i2 = i;
        boolean zL = l(canvas, i2, 0);
        BitmapFramePreparationStrategy bitmapFramePreparationStrategy = this.e;
        if (bitmapFramePreparationStrategy != null && (bitmapFramePreparer = this.f) != null) {
            BitmapFrameCache bitmapFrameCache = this.f526b;
            FixedNumberBitmapFramePreparationStrategy fixedNumberBitmapFramePreparationStrategy = (FixedNumberBitmapFramePreparationStrategy) bitmapFramePreparationStrategy;
            int i3 = 1;
            while (i3 <= fixedNumberBitmapFramePreparationStrategy.a) {
                int iA = (i2 + i3) % a();
                FLog.h(2);
                DefaultBitmapFramePreparer defaultBitmapFramePreparer = (DefaultBitmapFramePreparer) bitmapFramePreparer;
                Objects.requireNonNull(defaultBitmapFramePreparer);
                int iHashCode = (hashCode() * 31) + iA;
                synchronized (defaultBitmapFramePreparer.e) {
                    if (defaultBitmapFramePreparer.e.get(iHashCode) != null) {
                        int i4 = FLog.a;
                    } else if (bitmapFrameCache.c(iA)) {
                        int i5 = FLog.a;
                    } else {
                        DefaultBitmapFramePreparer.a aVar = defaultBitmapFramePreparer.new a(this, bitmapFrameCache, iA, iHashCode);
                        defaultBitmapFramePreparer.e.put(iHashCode, aVar);
                        defaultBitmapFramePreparer.d.execute(aVar);
                    }
                }
                i3++;
                i2 = i;
            }
        }
        return zL;
    }

    public final boolean k(int i, CloseableReference<Bitmap> closeableReference, Canvas canvas, int i2) {
        if (!CloseableReference.y(closeableReference)) {
            return false;
        }
        if (this.h == null) {
            canvas.drawBitmap(closeableReference.u(), 0.0f, 0.0f, this.g);
        } else {
            canvas.drawBitmap(closeableReference.u(), (Rect) null, this.h, this.g);
        }
        if (i2 == 3) {
            return true;
        }
        this.f526b.e(i, closeableReference, i2);
        return true;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final boolean l(Canvas canvas, int i, int i2) {
        CloseableReference closeableReferenceD;
        boolean zK;
        int i3 = 2;
        boolean z2 = true;
        CloseableReference closeableReference = null;
        try {
            if (i2 == 0) {
                closeableReferenceD = this.f526b.d(i);
                zK = k(i, closeableReferenceD, canvas, 0);
                i3 = 1;
            } else if (i2 == 1) {
                closeableReferenceD = this.f526b.a(i, this.i, this.j);
                if (!m(i, closeableReferenceD) || !k(i, closeableReferenceD, canvas, 1)) {
                    z2 = false;
                }
                zK = z2;
            } else if (i2 == 2) {
                try {
                    closeableReferenceD = this.a.a(this.i, this.j, this.k);
                    if (!m(i, closeableReferenceD) || !k(i, closeableReferenceD, canvas, 2)) {
                        z2 = false;
                    }
                    zK = z2;
                    i3 = 3;
                } catch (RuntimeException e) {
                    FLog.l(BitmapAnimationBackend.class, "Failed to create frame bitmap", e);
                    Class<CloseableReference> cls = CloseableReference.j;
                    return false;
                }
            } else {
                if (i2 != 3) {
                    Class<CloseableReference> cls2 = CloseableReference.j;
                    return false;
                }
                closeableReferenceD = this.f526b.f(i);
                zK = k(i, closeableReferenceD, canvas, 3);
                i3 = -1;
            }
            Class<CloseableReference> cls3 = CloseableReference.j;
            if (closeableReferenceD != null) {
                closeableReferenceD.close();
            }
            return (zK || i3 == -1) ? zK : l(canvas, i, i3);
        } catch (Throwable th) {
            Class<CloseableReference> cls4 = CloseableReference.j;
            if (0 != 0) {
                closeableReference.close();
            }
            throw th;
        }
    }

    public final boolean m(int i, CloseableReference<Bitmap> closeableReference) {
        if (!CloseableReference.y(closeableReference)) {
            return false;
        }
        boolean zA = ((AnimatedDrawableBackendFrameRenderer) this.d).a(i, closeableReference.u());
        if (!zA) {
            closeableReference.close();
        }
        return zA;
    }

    public final void n() {
        int width = ((AnimatedDrawableBackendImpl) ((AnimatedDrawableBackendFrameRenderer) this.d).f531b).c.getWidth();
        this.i = width;
        if (width == -1) {
            Rect rect = this.h;
            this.i = rect == null ? -1 : rect.width();
        }
        int height = ((AnimatedDrawableBackendImpl) ((AnimatedDrawableBackendFrameRenderer) this.d).f531b).c.getHeight();
        this.j = height;
        if (height == -1) {
            Rect rect2 = this.h;
            this.j = rect2 != null ? rect2.height() : -1;
        }
    }
}
