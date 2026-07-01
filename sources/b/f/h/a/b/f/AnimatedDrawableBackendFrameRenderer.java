package b.f.h.a.b.f;

import android.graphics.Bitmap;
import b.f.d.e.FLog;
import b.f.h.a.b.BitmapFrameCache;
import b.f.h.a.b.BitmapFrameRenderer;
import b.f.j.a.a.AnimatedDrawableBackend;
import b.f.j.a.c.AnimatedImageCompositor;
import com.facebook.common.references.CloseableReference;

/* JADX INFO: renamed from: b.f.h.a.b.f.b, reason: use source file name */
/* JADX INFO: compiled from: AnimatedDrawableBackendFrameRenderer.java */
/* JADX INFO: loaded from: classes.dex */
public class AnimatedDrawableBackendFrameRenderer implements BitmapFrameRenderer {
    public final BitmapFrameCache a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public AnimatedDrawableBackend f531b;
    public AnimatedImageCompositor c;
    public final AnimatedImageCompositor.a d;

    /* JADX INFO: renamed from: b.f.h.a.b.f.b$a */
    /* JADX INFO: compiled from: AnimatedDrawableBackendFrameRenderer.java */
    public class a implements AnimatedImageCompositor.a {
        public a() {
        }

        @Override // b.f.j.a.c.AnimatedImageCompositor.a
        public void a(int i, Bitmap bitmap) {
        }

        @Override // b.f.j.a.c.AnimatedImageCompositor.a
        public CloseableReference<Bitmap> b(int i) {
            return AnimatedDrawableBackendFrameRenderer.this.a.d(i);
        }
    }

    public AnimatedDrawableBackendFrameRenderer(BitmapFrameCache bitmapFrameCache, AnimatedDrawableBackend animatedDrawableBackend) {
        a aVar = new a();
        this.d = aVar;
        this.a = bitmapFrameCache;
        this.f531b = animatedDrawableBackend;
        this.c = new AnimatedImageCompositor(animatedDrawableBackend, aVar);
    }

    public boolean a(int i, Bitmap bitmap) {
        try {
            this.c.d(i, bitmap);
            return true;
        } catch (IllegalStateException e) {
            FLog.d(AnimatedDrawableBackendFrameRenderer.class, e, "Rendering of frame unsuccessful. Frame number: %d", Integer.valueOf(i));
            return false;
        }
    }
}
