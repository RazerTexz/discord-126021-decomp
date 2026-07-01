package b.f.h.a.b;

import android.graphics.Bitmap;
import android.graphics.Bitmap$Config;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import androidx.annotation.IntRange;
import b.f.h.a.a.c$b;
import b.f.h.a.a.d;
import b.f.h.a.b.e.c$a;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;
import java.util.Objects;

/* JADX INFO: compiled from: BitmapAnimationBackend.java */
/* JADX INFO: loaded from: classes.dex */
public class a implements b.f.h.a.a.a, c$b {
    public final PlatformBitmapFactory a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f526b;
    public final d c;
    public final c d;
    public final b.f.h.a.b.e.a e;
    public final b.f.h.a.b.e.b f;
    public Rect h;
    public int i;
    public int j;
    public Bitmap$Config k = Bitmap$Config.ARGB_8888;
    public final Paint g = new Paint(6);

    public a(PlatformBitmapFactory platformBitmapFactory, b bVar, d dVar, c cVar, b.f.h.a.b.e.a aVar, b.f.h.a.b.e.b bVar2) {
        this.a = platformBitmapFactory;
        this.f526b = bVar;
        this.c = dVar;
        this.d = cVar;
        this.e = aVar;
        this.f = bVar2;
        n();
    }

    @Override // b.f.h.a.a.d
    public int a() {
        return this.c.a();
    }

    @Override // b.f.h.a.a.d
    public int b() {
        return this.c.b();
    }

    @Override // b.f.h.a.a.c$b
    public void c() {
        this.f526b.clear();
    }

    @Override // b.f.h.a.a.a
    public void clear() {
        this.f526b.clear();
    }

    @Override // b.f.h.a.a.a
    public void d(ColorFilter colorFilter) {
        this.g.setColorFilter(colorFilter);
    }

    @Override // b.f.h.a.a.d
    public int e(int i) {
        return this.c.e(i);
    }

    @Override // b.f.h.a.a.a
    public void f(@IntRange(from = 0, to = 255) int i) {
        this.g.setAlpha(i);
    }

    @Override // b.f.h.a.a.a
    public int g() {
        return this.j;
    }

    @Override // b.f.h.a.a.a
    public void h(Rect rect) {
        this.h = rect;
        b.f.h.a.b.f.b bVar = (b.f.h.a.b.f.b) this.d;
        b.f.j.a.c.a aVar = (b.f.j.a.c.a) bVar.f531b;
        if (!b.f.j.a.c.a.a(aVar.c, rect).equals(aVar.d)) {
            aVar = new b.f.j.a.c.a(aVar.a, aVar.f548b, rect, aVar.i);
        }
        if (aVar != bVar.f531b) {
            bVar.f531b = aVar;
            bVar.c = new b.f.j.a.c.d(aVar, bVar.d);
        }
        n();
    }

    @Override // b.f.h.a.a.a
    public int i() {
        return this.i;
    }

    @Override // b.f.h.a.a.a
    public boolean j(Drawable drawable, Canvas canvas, int i) {
        b.f.h.a.b.e.b bVar;
        int i2 = i;
        boolean zL = l(canvas, i2, 0);
        b.f.h.a.b.e.a aVar = this.e;
        if (aVar != null && (bVar = this.f) != null) {
            b bVar2 = this.f526b;
            b.f.h.a.b.e.d dVar = (b.f.h.a.b.e.d) aVar;
            int i3 = 1;
            while (i3 <= dVar.a) {
                int iA = (i2 + i3) % a();
                b.f.d.e.a.h(2);
                b.f.h.a.b.e.c cVar = (b.f.h.a.b.e.c) bVar;
                Objects.requireNonNull(cVar);
                int iHashCode = (hashCode() * 31) + iA;
                synchronized (cVar.e) {
                    if (cVar.e.get(iHashCode) != null) {
                        int i4 = b.f.d.e.a.a;
                    } else if (bVar2.c(iA)) {
                        int i5 = b.f.d.e.a.a;
                    } else {
                        c$a c_a = new c$a(cVar, this, bVar2, iA, iHashCode);
                        cVar.e.put(iHashCode, c_a);
                        cVar.d.execute(c_a);
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
                    b.f.d.e.a.l(a.class, "Failed to create frame bitmap", e);
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
        boolean zA = ((b.f.h.a.b.f.b) this.d).a(i, closeableReference.u());
        if (!zA) {
            closeableReference.close();
        }
        return zA;
    }

    public final void n() {
        int width = ((b.f.j.a.c.a) ((b.f.h.a.b.f.b) this.d).f531b).c.getWidth();
        this.i = width;
        if (width == -1) {
            Rect rect = this.h;
            this.i = rect == null ? -1 : rect.width();
        }
        int height = ((b.f.j.a.c.a) ((b.f.h.a.b.f.b) this.d).f531b).c.getHeight();
        this.j = height;
        if (height == -1) {
            Rect rect2 = this.h;
            this.j = rect2 != null ? rect2.height() : -1;
        }
    }
}
