package com.facebook.drawee.view;

import android.graphics.drawable.Drawable;
import b.c.a.a0.AnimatableValueParser;
import b.f.d.d.Objects2;
import b.f.g.b.DraweeEventTracker;
import b.f.g.e.VisibilityAwareDrawable;
import b.f.g.e.VisibilityCallback;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.interfaces.DraweeHierarchy;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public class DraweeHolder<DH extends DraweeHierarchy> implements VisibilityCallback {
    public DH d;
    public final DraweeEventTracker f;
    public boolean a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f2893b = false;
    public boolean c = true;
    public DraweeController e = null;

    public DraweeHolder(DH dh) {
        this.f = DraweeEventTracker.f494b ? new DraweeEventTracker() : DraweeEventTracker.a;
        if (dh != null) {
            h(dh);
        }
    }

    public final void a() {
        if (this.a) {
            return;
        }
        this.f.a(DraweeEventTracker.a.ON_ATTACH_CONTROLLER);
        this.a = true;
        DraweeController draweeController = this.e;
        if (draweeController == null || draweeController.b() == null) {
            return;
        }
        this.e.d();
    }

    public final void b() {
        if (this.f2893b && this.c) {
            a();
        } else {
            c();
        }
    }

    public final void c() {
        if (this.a) {
            this.f.a(DraweeEventTracker.a.ON_DETACH_CONTROLLER);
            this.a = false;
            if (e()) {
                this.e.a();
            }
        }
    }

    public Drawable d() {
        DH dh = this.d;
        if (dh == null) {
            return null;
        }
        return dh.e();
    }

    public boolean e() {
        DraweeController draweeController = this.e;
        return draweeController != null && draweeController.b() == this.d;
    }

    public void f(boolean z2) {
        if (this.c == z2) {
            return;
        }
        this.f.a(z2 ? DraweeEventTracker.a.ON_DRAWABLE_SHOW : DraweeEventTracker.a.ON_DRAWABLE_HIDE);
        this.c = z2;
        b();
    }

    public void g(DraweeController draweeController) {
        boolean z2 = this.a;
        if (z2) {
            c();
        }
        if (e()) {
            this.f.a(DraweeEventTracker.a.ON_CLEAR_OLD_CONTROLLER);
            this.e.e(null);
        }
        this.e = draweeController;
        if (draweeController != null) {
            this.f.a(DraweeEventTracker.a.ON_SET_CONTROLLER);
            this.e.e(this.d);
        } else {
            this.f.a(DraweeEventTracker.a.ON_CLEAR_CONTROLLER);
        }
        if (z2) {
            a();
        }
    }

    public void h(DH dh) {
        this.f.a(DraweeEventTracker.a.ON_SET_HIERARCHY);
        boolean zE = e();
        Object objD = d();
        if (objD instanceof VisibilityAwareDrawable) {
            ((VisibilityAwareDrawable) objD).k(null);
        }
        Objects.requireNonNull(dh);
        this.d = dh;
        Drawable drawableE = dh.e();
        f(drawableE == null || drawableE.isVisible());
        Object objD2 = d();
        if (objD2 instanceof VisibilityAwareDrawable) {
            ((VisibilityAwareDrawable) objD2).k(this);
        }
        if (zE) {
            this.e.e(dh);
        }
    }

    public String toString() {
        Objects2 objects2H2 = AnimatableValueParser.h2(this);
        objects2H2.b("controllerAttached", this.a);
        objects2H2.b("holderAttached", this.f2893b);
        objects2H2.b("drawableVisible", this.c);
        objects2H2.c("events", this.f.toString());
        return objects2H2.toString();
    }
}
