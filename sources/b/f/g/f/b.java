package b.f.g.f;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import androidx.annotation.VisibleForTesting;
import b.f.g.e.f0;
import b.f.g.e.g;
import b.f.g.e.g0;
import com.facebook.drawee.view.DraweeHolder;

/* JADX INFO: compiled from: RootDrawable.java */
/* JADX INFO: loaded from: classes.dex */
public class b extends g implements f0 {

    @VisibleForTesting
    public Drawable n;
    public g0 o;

    public b(Drawable drawable) {
        super(drawable);
        this.n = null;
    }

    @Override // b.f.g.e.g, android.graphics.drawable.Drawable
    @SuppressLint({"WrongCall"})
    public void draw(Canvas canvas) {
        if (isVisible()) {
            g0 g0Var = this.o;
            if (g0Var != null) {
                DraweeHolder draweeHolder = (DraweeHolder) g0Var;
                if (!draweeHolder.a) {
                    b.f.d.e.a.m(b.f.g.b.c.class, "%x: Draw requested for a non-attached controller %x. %s", Integer.valueOf(System.identityHashCode(draweeHolder)), Integer.valueOf(System.identityHashCode(draweeHolder.e)), draweeHolder.toString());
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

    @Override // b.f.g.e.g, android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return -1;
    }

    @Override // b.f.g.e.g, android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return -1;
    }

    @Override // b.f.g.e.f0
    public void k(g0 g0Var) {
        this.o = g0Var;
    }

    @Override // b.f.g.e.g, android.graphics.drawable.Drawable
    public boolean setVisible(boolean z2, boolean z3) {
        g0 g0Var = this.o;
        if (g0Var != null) {
            ((DraweeHolder) g0Var).f(z2);
        }
        return super.setVisible(z2, z3);
    }
}
