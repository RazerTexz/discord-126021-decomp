package b.f.g.f;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import androidx.annotation.VisibleForTesting;
import b.f.d.e.FLog;
import b.f.g.b.DraweeEventTracker;
import b.f.g.e.ForwardingDrawable;
import b.f.g.e.VisibilityAwareDrawable;
import b.f.g.e.VisibilityCallback;
import com.facebook.drawee.view.DraweeHolder;

/* JADX INFO: renamed from: b.f.g.f.b, reason: use source file name */
/* JADX INFO: compiled from: RootDrawable.java */
/* JADX INFO: loaded from: classes.dex */
public class RootDrawable extends ForwardingDrawable implements VisibilityAwareDrawable {

    @VisibleForTesting
    public Drawable n;
    public VisibilityCallback o;

    public RootDrawable(Drawable drawable) {
        super(drawable);
        this.n = null;
    }

    @Override // b.f.g.e.ForwardingDrawable, android.graphics.drawable.Drawable
    @SuppressLint({"WrongCall"})
    public void draw(Canvas canvas) {
        if (isVisible()) {
            VisibilityCallback visibilityCallback = this.o;
            if (visibilityCallback != null) {
                DraweeHolder draweeHolder = (DraweeHolder) visibilityCallback;
                if (!draweeHolder.a) {
                    FLog.m(DraweeEventTracker.class, "%x: Draw requested for a non-attached controller %x. %s", Integer.valueOf(System.identityHashCode(draweeHolder)), Integer.valueOf(System.identityHashCode(draweeHolder.e)), draweeHolder.toString());
                    draweeHolder.f2893b = true;
                    draweeHolder.c = true;
                    draweeHolder.b();
                }
            }
            Drawable drawable = this.k;
            if (drawable != null) {
                drawable.draw(canvas);
            }
            Drawable drawable2 = this.n;
            if (drawable2 != null) {
                drawable2.setBounds(getBounds());
                this.n.draw(canvas);
            }
        }
    }

    @Override // b.f.g.e.ForwardingDrawable, android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return -1;
    }

    @Override // b.f.g.e.ForwardingDrawable, android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return -1;
    }

    @Override // b.f.g.e.VisibilityAwareDrawable
    public void k(VisibilityCallback visibilityCallback) {
        this.o = visibilityCallback;
    }

    @Override // b.f.g.e.ForwardingDrawable, android.graphics.drawable.Drawable
    public boolean setVisible(boolean z2, boolean z3) {
        VisibilityCallback visibilityCallback = this.o;
        if (visibilityCallback != null) {
            ((DraweeHolder) visibilityCallback).f(z2);
        }
        return super.setVisible(z2, z3);
    }
}
