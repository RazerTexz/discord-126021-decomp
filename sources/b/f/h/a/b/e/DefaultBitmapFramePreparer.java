package b.f.h.a.b.e;

import android.graphics.Bitmap;
import android.util.SparseArray;
import b.f.d.e.FLog;
import b.f.h.a.a.AnimationBackend;
import b.f.h.a.b.BitmapFrameCache;
import b.f.h.a.b.BitmapFrameRenderer;
import b.f.h.a.b.f.AnimatedDrawableBackendFrameRenderer;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;
import java.util.concurrent.ExecutorService;

/* JADX INFO: renamed from: b.f.h.a.b.e.c, reason: use source file name */
/* JADX INFO: compiled from: DefaultBitmapFramePreparer.java */
/* JADX INFO: loaded from: classes.dex */
public class DefaultBitmapFramePreparer implements BitmapFramePreparer {
    public final PlatformBitmapFactory a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final BitmapFrameRenderer f530b;
    public final Bitmap.Config c;
    public final ExecutorService d;
    public final SparseArray<Runnable> e = new SparseArray<>();

    /* JADX INFO: renamed from: b.f.h.a.b.e.c$a */
    /* JADX INFO: compiled from: DefaultBitmapFramePreparer.java */
    public class a implements Runnable {
        public final BitmapFrameCache j;
        public final AnimationBackend k;
        public final int l;
        public final int m;

        public a(AnimationBackend animationBackend, BitmapFrameCache bitmapFrameCache, int i, int i2) {
            this.k = animationBackend;
            this.j = bitmapFrameCache;
            this.l = i;
            this.m = i2;
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
        public final boolean a(int i, int i2) {
            CloseableReference closeableReferenceA;
            int i3 = 2;
            CloseableReference closeableReference = null;
            try {
                if (i2 == 1) {
                    closeableReferenceA = this.j.a(i, this.k.i(), this.k.g());
                } else {
                    if (i2 != 2) {
                        Class<CloseableReference> cls = CloseableReference.j;
                        return false;
                    }
                    try {
                        closeableReferenceA = DefaultBitmapFramePreparer.this.a.a(this.k.i(), this.k.g(), DefaultBitmapFramePreparer.this.c);
                        i3 = -1;
                    } catch (RuntimeException e) {
                        FLog.l(DefaultBitmapFramePreparer.class, "Failed to create frame bitmap", e);
                        Class<CloseableReference> cls2 = CloseableReference.j;
                        return false;
                    }
                }
                boolean zB = b(i, closeableReferenceA, i2);
                if (closeableReferenceA != null) {
                    closeableReferenceA.close();
                }
                return (zB || i3 == -1) ? zB : a(i, i3);
            } catch (Throwable th) {
                Class<CloseableReference> cls3 = CloseableReference.j;
                if (0 != 0) {
                    closeableReference.close();
                }
                throw th;
            }
        }

        public final boolean b(int i, CloseableReference<Bitmap> closeableReference, int i2) {
            if (!CloseableReference.y(closeableReference)) {
                return false;
            }
            if (!((AnimatedDrawableBackendFrameRenderer) DefaultBitmapFramePreparer.this.f530b).a(i, closeableReference.u())) {
                return false;
            }
            int i3 = FLog.a;
            synchronized (DefaultBitmapFramePreparer.this.e) {
                this.j.b(this.l, closeableReference, i2);
            }
            return true;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (this.j.c(this.l)) {
                    int i = FLog.a;
                    synchronized (DefaultBitmapFramePreparer.this.e) {
                        DefaultBitmapFramePreparer.this.e.remove(this.m);
                    }
                    return;
                }
                if (a(this.l, 1)) {
                    int i2 = FLog.a;
                } else {
                    FLog.c(DefaultBitmapFramePreparer.class, "Could not prepare frame %d.", Integer.valueOf(this.l));
                }
                synchronized (DefaultBitmapFramePreparer.this.e) {
                    DefaultBitmapFramePreparer.this.e.remove(this.m);
                }
            } catch (Throwable th) {
                synchronized (DefaultBitmapFramePreparer.this.e) {
                    DefaultBitmapFramePreparer.this.e.remove(this.m);
                    throw th;
                }
            }
        }
    }

    public DefaultBitmapFramePreparer(PlatformBitmapFactory platformBitmapFactory, BitmapFrameRenderer bitmapFrameRenderer, Bitmap.Config config, ExecutorService executorService) {
        this.a = platformBitmapFactory;
        this.f530b = bitmapFrameRenderer;
        this.c = config;
        this.d = executorService;
    }
}
