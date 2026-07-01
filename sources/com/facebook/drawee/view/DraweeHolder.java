package com.facebook.drawee.view;

import android.graphics.drawable.Drawable;
import b.c.a.a0.d;
import b.f.d.d.i;
import b.f.g.b.c;
import b.f.g.b.c$a;
import b.f.g.e.f0;
import b.f.g.e.g0;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.interfaces.DraweeHierarchy;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public class DraweeHolder<DH extends DraweeHierarchy> implements g0 {
    public DH d;
    public final c f;
    public boolean a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f2893b = false;
    public boolean c = true;
    public DraweeController e = null;

    public DraweeHolder(DH dh) {
        this.f = c.f494b ? new c() : c.a;
        if (dh != null) {
            h(dh);
        }
    }

    public final void a() {
        if (this.a) {
            return;
        }
        this.f.a(c$a.ON_ATTACH_CONTROLLER);
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
            this.f.a(c$a.ON_DETACH_CONTROLLER);
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
        this.f.a(z2 ? c$a.ON_DRAWABLE_SHOW : c$a.ON_DRAWABLE_HIDE);
        this.c = z2;
        b();
    }

    public void g(DraweeController draweeController) {
        boolean z2 = this.a;
        if (z2) {
            c();
        }
        if (e()) {
            this.f.a(c$a.ON_CLEAR_OLD_CONTROLLER);
            this.e.e(null);
        }
        this.e = draweeController;
        if (draweeController != null) {
            this.f.a(c$a.ON_SET_CONTROLLER);
            this.e.e(this.d);
        } else {
            this.f.a(c$a.ON_CLEAR_CONTROLLER);
        }
        if (z2) {
            a();
        }
    }

    public void h(DH dh) {
        this.f.a(c$a.ON_SET_HIERARCHY);
        boolean zE = e();
        Object objD = d();
        if (objD instanceof f0) {
            ((f0) objD).k(null);
        }
        Objects.requireNonNull(dh);
        this.d = dh;
        Drawable drawableE = dh.e();
        f(drawableE == null || drawableE.isVisible());
        Object objD2 = d();
        if (objD2 instanceof f0) {
            ((f0) objD2).k(this);
        }
        if (zE) {
            this.e.e(dh);
        }
    }

    public String toString() {
        i iVarH2 = d.h2(this);
        iVarH2.b("controllerAttached", this.a);
        iVarH2.b("holderAttached", this.f2893b);
        iVarH2.b("drawableVisible", this.c);
        iVarH2.c("events", this.f.toString());
        return iVarH2.toString();
    }
}
