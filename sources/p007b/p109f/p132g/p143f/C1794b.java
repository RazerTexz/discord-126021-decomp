package p007b.p109f.p132g.p143f;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import androidx.annotation.VisibleForTesting;
import com.facebook.drawee.view.DraweeHolder;
import p007b.p109f.p115d.p120e.C1691a;
import p007b.p109f.p132g.p138b.C1751c;
import p007b.p109f.p132g.p142e.C1772g;
import p007b.p109f.p132g.p142e.InterfaceC1771f0;
import p007b.p109f.p132g.p142e.InterfaceC1773g0;

/* JADX INFO: renamed from: b.f.g.f.b */
/* JADX INFO: compiled from: RootDrawable.java */
/* JADX INFO: loaded from: classes.dex */
public class C1794b extends C1772g implements InterfaceC1771f0 {

    /* JADX INFO: renamed from: n */
    @VisibleForTesting
    public Drawable f3469n;

    /* JADX INFO: renamed from: o */
    public InterfaceC1773g0 f3470o;

    public C1794b(Drawable drawable) {
        super(drawable);
        this.f3469n = null;
    }

    @Override // p007b.p109f.p132g.p142e.C1772g, android.graphics.drawable.Drawable
    @SuppressLint({"WrongCall"})
    public void draw(Canvas canvas) {
        if (isVisible()) {
            InterfaceC1773g0 interfaceC1773g0 = this.f3470o;
            if (interfaceC1773g0 != null) {
                DraweeHolder draweeHolder = (DraweeHolder) interfaceC1773g0;
                if (!draweeHolder.f19525a) {
                    C1691a.m985m(C1751c.class, "%x: Draw requested for a non-attached controller %x. %s", Integer.valueOf(System.identityHashCode(draweeHolder)), Integer.valueOf(System.identityHashCode(draweeHolder.f19529e)), draweeHolder.toString());
                    draweeHolder.f19526b = true;
                    draweeHolder.f19527c = true;
                    draweeHolder.m8688b();
                }
            }
            Drawable drawable = this.f3360k;
            if (drawable != null) {
                drawable.draw(canvas);
            }
            Drawable drawable2 = this.f3469n;
            if (drawable2 != null) {
                drawable2.setBounds(getBounds());
                this.f3469n.draw(canvas);
            }
        }
    }

    @Override // p007b.p109f.p132g.p142e.C1772g, android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return -1;
    }

    @Override // p007b.p109f.p132g.p142e.C1772g, android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return -1;
    }

    @Override // p007b.p109f.p132g.p142e.InterfaceC1771f0
    /* JADX INFO: renamed from: k */
    public void mo1102k(InterfaceC1773g0 interfaceC1773g0) {
        this.f3470o = interfaceC1773g0;
    }

    @Override // p007b.p109f.p132g.p142e.C1772g, android.graphics.drawable.Drawable
    public boolean setVisible(boolean z2, boolean z3) {
        InterfaceC1773g0 interfaceC1773g0 = this.f3470o;
        if (interfaceC1773g0 != null) {
            ((DraweeHolder) interfaceC1773g0).m8692f(z2);
        }
        return super.setVisible(z2, z3);
    }
}
