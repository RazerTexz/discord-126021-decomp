package com.facebook.drawee.controller;

import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Looper;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import b.f.d.d.f;
import b.f.d.d.i;
import b.f.g.b.a;
import b.f.g.b.a$a;
import b.f.g.b.c;
import b.f.g.b.c$a;
import b.f.g.b.d;
import b.f.g.e.p;
import b.f.h.b.a.b$a;
import b.f.j.r.b;
import com.facebook.datasource.DataSource;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.interfaces.DraweeHierarchy;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractDraweeController<T, INFO> implements DraweeController, a$a, b.f.g.g.a$a {
    public static final Map<String, Object> a = f.of("component_tag", "drawee");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map<String, Object> f2885b = f.of("origin", "memory_bitmap", "origin_sub", "shortcut");
    public static final Class<?> c = AbstractDraweeController.class;
    public final c d;
    public final a e;
    public final Executor f;
    public d g;
    public b.f.g.g.a h;
    public ControllerListener<INFO> i;
    public b.f.h.b.a.c<INFO> j;
    public b.f.g.h.a k;
    public Drawable l;
    public String m;
    public Object n;
    public boolean o;
    public boolean p;
    public boolean q;
    public boolean r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public String f2886s;
    public DataSource<T> t;
    public T u;
    public boolean v;
    public Drawable w;

    public AbstractDraweeController(a aVar, Executor executor, String str, Object obj) {
        this.d = c.f494b ? new c() : c.a;
        this.j = new b.f.h.b.a.c<>();
        this.v = true;
        this.e = aVar;
        this.f = executor;
        n(null, null);
    }

    public void A(ControllerListener<? super INFO> controllerListener) {
        Objects.requireNonNull(controllerListener);
        ControllerListener<INFO> controllerListener2 = this.i;
        if (!(controllerListener2 instanceof AbstractDraweeController$b)) {
            if (controllerListener2 == controllerListener) {
                this.i = null;
            }
        } else {
            AbstractDraweeController$b abstractDraweeController$b = (AbstractDraweeController$b) controllerListener2;
            synchronized (abstractDraweeController$b) {
                int iIndexOf = abstractDraweeController$b.a.indexOf(controllerListener);
                if (iIndexOf != -1) {
                    abstractDraweeController$b.a.set(iIndexOf, null);
                }
            }
        }
    }

    public void B(DataSource<T> dataSource, INFO info) {
        i().onSubmit(this.m, this.n);
        this.j.a(this.m, this.n, r(dataSource, info, m()));
    }

    public final void C(String str, T t, DataSource<T> dataSource) {
        INFO infoL = l(t);
        i().onFinalImageSet(str, infoL, c());
        this.j.d(str, infoL, r(dataSource, infoL, null));
    }

    public final boolean D() {
        d dVar;
        if (this.q && (dVar = this.g) != null) {
            if (dVar.a && dVar.c < dVar.f499b) {
                return true;
            }
        }
        return false;
    }

    public void E() {
        b.b();
        T tH = h();
        if (tH != null) {
            b.b();
            this.t = null;
            this.p = true;
            this.q = false;
            this.d.a(c$a.ON_SUBMIT_CACHE_HIT);
            B(this.t, l(tH));
            v(this.m, tH);
            w(this.m, this.t, tH, 1.0f, true, true, true);
            b.b();
            b.b();
            return;
        }
        this.d.a(c$a.ON_DATASOURCE_SUBMIT);
        this.k.d(0.0f, true);
        this.p = true;
        this.q = false;
        DataSource<T> dataSourceJ = j();
        this.t = dataSourceJ;
        B(dataSourceJ, null);
        if (b.f.d.e.a.h(2)) {
            b.f.d.e.a.j(c, "controller %x %s: submitRequest: dataSource: %x", Integer.valueOf(System.identityHashCode(this)), this.m, Integer.valueOf(System.identityHashCode(this.t)));
        }
        this.t.f(new AbstractDraweeController$a(this, this.m, this.t.b()), this.f);
        b.b();
    }

    @Override // com.facebook.drawee.interfaces.DraweeController
    public void a() {
        b.b();
        if (b.f.d.e.a.h(2)) {
            System.identityHashCode(this);
        }
        this.d.a(c$a.ON_DETACH_CONTROLLER);
        this.o = false;
        b.f.g.b.b bVar = (b.f.g.b.b) this.e;
        Objects.requireNonNull(bVar);
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            synchronized (bVar.f493b) {
                if (!bVar.d.contains(this)) {
                    bVar.d.add(this);
                    boolean z2 = bVar.d.size() == 1;
                    if (z2) {
                        bVar.c.post(bVar.f);
                    }
                }
            }
        } else {
            release();
        }
        b.b();
    }

    @Override // com.facebook.drawee.interfaces.DraweeController
    public DraweeHierarchy b() {
        return this.k;
    }

    @Override // com.facebook.drawee.interfaces.DraweeController
    public Animatable c() {
        Object obj = this.w;
        if (obj instanceof Animatable) {
            return (Animatable) obj;
        }
        return null;
    }

    @Override // com.facebook.drawee.interfaces.DraweeController
    public void d() {
        b.b();
        if (b.f.d.e.a.h(2)) {
            b.f.d.e.a.j(c, "controller %x %s: onAttach: %s", Integer.valueOf(System.identityHashCode(this)), this.m, this.p ? "request already submitted" : "request needs submit");
        }
        this.d.a(c$a.ON_ATTACH_CONTROLLER);
        Objects.requireNonNull(this.k);
        this.e.a(this);
        this.o = true;
        if (!this.p) {
            E();
        }
        b.b();
    }

    @Override // com.facebook.drawee.interfaces.DraweeController
    public void e(DraweeHierarchy draweeHierarchy) {
        if (b.f.d.e.a.h(2)) {
            b.f.d.e.a.j(c, "controller %x %s: setHierarchy: %s", Integer.valueOf(System.identityHashCode(this)), this.m, draweeHierarchy);
        }
        this.d.a(draweeHierarchy != null ? c$a.ON_SET_HIERARCHY : c$a.ON_CLEAR_HIERARCHY);
        if (this.p) {
            this.e.a(this);
            release();
        }
        b.f.g.h.a aVar = this.k;
        if (aVar != null) {
            aVar.a(null);
            this.k = null;
        }
        if (draweeHierarchy != null) {
            b.c.a.a0.d.i(Boolean.valueOf(draweeHierarchy instanceof b.f.g.h.a));
            b.f.g.h.a aVar2 = (b.f.g.h.a) draweeHierarchy;
            this.k = aVar2;
            aVar2.a(this.l);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void f(ControllerListener<? super INFO> controllerListener) {
        Objects.requireNonNull(controllerListener);
        ControllerListener<INFO> controllerListener2 = this.i;
        if (controllerListener2 instanceof AbstractDraweeController$b) {
            ((AbstractDraweeController$b) controllerListener2).a(controllerListener);
            return;
        }
        if (controllerListener2 == null) {
            this.i = controllerListener;
            return;
        }
        b.b();
        AbstractDraweeController$b abstractDraweeController$b = new AbstractDraweeController$b();
        abstractDraweeController$b.a(controllerListener2);
        abstractDraweeController$b.a(controllerListener);
        b.b();
        this.i = abstractDraweeController$b;
    }

    public abstract Drawable g(T t);

    public T h() {
        return null;
    }

    public ControllerListener<INFO> i() {
        ControllerListener<INFO> controllerListener = this.i;
        return controllerListener == null ? b.f.g.c.c.getNoOpListener() : controllerListener;
    }

    public abstract DataSource<T> j();

    public int k(T t) {
        return System.identityHashCode(t);
    }

    public abstract INFO l(T t);

    public Uri m() {
        return null;
    }

    public final synchronized void n(String str, Object obj) {
        a aVar;
        b.b();
        this.d.a(c$a.ON_INIT_CONTROLLER);
        if (!this.v && (aVar = this.e) != null) {
            aVar.a(this);
        }
        this.o = false;
        y();
        this.r = false;
        d dVar = this.g;
        if (dVar != null) {
            dVar.a = false;
            dVar.f499b = 4;
            dVar.c = 0;
        }
        b.f.g.g.a aVar2 = this.h;
        if (aVar2 != null) {
            aVar2.a = null;
            aVar2.c = false;
            aVar2.d = false;
            aVar2.a = this;
        }
        ControllerListener<INFO> controllerListener = this.i;
        if (controllerListener instanceof AbstractDraweeController$b) {
            AbstractDraweeController$b abstractDraweeController$b = (AbstractDraweeController$b) controllerListener;
            synchronized (abstractDraweeController$b) {
                abstractDraweeController$b.a.clear();
            }
        } else {
            this.i = null;
        }
        b.f.g.h.a aVar3 = this.k;
        if (aVar3 != null) {
            aVar3.reset();
            this.k.a(null);
            this.k = null;
        }
        this.l = null;
        if (b.f.d.e.a.h(2)) {
            b.f.d.e.a.j(c, "controller %x %s -> %s: initialize", Integer.valueOf(System.identityHashCode(this)), this.m, str);
        }
        this.m = str;
        this.n = obj;
        b.b();
    }

    public final boolean o(String str, DataSource<T> dataSource) {
        if (dataSource == null && this.t == null) {
            return true;
        }
        return str.equals(this.m) && dataSource == this.t && this.p;
    }

    @Override // com.facebook.drawee.interfaces.DraweeController
    public boolean onTouchEvent(MotionEvent motionEvent) {
        b.f.g.g.a$a a_a;
        boolean zH = b.f.d.e.a.h(2);
        if (zH) {
            b.f.d.e.a.j(c, "controller %x %s: onTouchEvent %s", Integer.valueOf(System.identityHashCode(this)), this.m, motionEvent);
        }
        b.f.g.g.a aVar = this.h;
        if (aVar == null) {
            return false;
        }
        if (!aVar.c && !D()) {
            return false;
        }
        b.f.g.g.a aVar2 = this.h;
        Objects.requireNonNull(aVar2);
        int action = motionEvent.getAction();
        if (action == 0) {
            aVar2.c = true;
            aVar2.d = true;
            aVar2.e = motionEvent.getEventTime();
            aVar2.f = motionEvent.getX();
            aVar2.g = motionEvent.getY();
        } else if (action == 1) {
            aVar2.c = false;
            if (Math.abs(motionEvent.getX() - aVar2.f) > aVar2.f524b || Math.abs(motionEvent.getY() - aVar2.g) > aVar2.f524b) {
                aVar2.d = false;
            }
            if (aVar2.d && motionEvent.getEventTime() - aVar2.e <= ViewConfiguration.getLongPressTimeout() && (a_a = aVar2.a) != null) {
                AbstractDraweeController abstractDraweeController = (AbstractDraweeController) a_a;
                if (zH) {
                    System.identityHashCode(abstractDraweeController);
                }
                if (abstractDraweeController.D()) {
                    abstractDraweeController.g.c++;
                    abstractDraweeController.k.reset();
                    abstractDraweeController.E();
                }
            }
            aVar2.d = false;
        } else if (action != 2) {
            if (action == 3) {
                aVar2.c = false;
                aVar2.d = false;
            }
        } else if (Math.abs(motionEvent.getX() - aVar2.f) > aVar2.f524b || Math.abs(motionEvent.getY() - aVar2.g) > aVar2.f524b) {
            aVar2.d = false;
        }
        return true;
    }

    public final void p(String str, Throwable th) {
        if (b.f.d.e.a.h(2)) {
            System.identityHashCode(this);
        }
    }

    public final void q(String str, T t) {
        if (b.f.d.e.a.h(2)) {
            System.identityHashCode(this);
            if (t != null) {
                t.getClass().getSimpleName();
            }
            k(t);
        }
    }

    public final b$a r(DataSource<T> dataSource, INFO info, Uri uri) {
        return s(dataSource == null ? null : dataSource.a(), t(info), uri);
    }

    @Override // b.f.g.b.a$a
    public void release() {
        this.d.a(c$a.ON_RELEASE_CONTROLLER);
        d dVar = this.g;
        if (dVar != null) {
            dVar.c = 0;
        }
        b.f.g.g.a aVar = this.h;
        if (aVar != null) {
            aVar.c = false;
            aVar.d = false;
        }
        b.f.g.h.a aVar2 = this.k;
        if (aVar2 != null) {
            aVar2.reset();
        }
        y();
    }

    public final b$a s(Map<String, Object> map, Map<String, Object> map2, Uri uri) {
        b.f.g.h.a aVar = this.k;
        if (aVar instanceof GenericDraweeHierarchy) {
            GenericDraweeHierarchy genericDraweeHierarchy = (GenericDraweeHierarchy) aVar;
            String.valueOf(!(genericDraweeHierarchy.k(2) instanceof p) ? null : genericDraweeHierarchy.l(2).n);
            if (genericDraweeHierarchy.k(2) instanceof p) {
                PointF pointF = genericDraweeHierarchy.l(2).p;
            }
        }
        Map<String, Object> map3 = a;
        Map<String, Object> map4 = f2885b;
        b.f.g.h.a aVar2 = this.k;
        Rect bounds = aVar2 != null ? aVar2.getBounds() : null;
        Object obj = this.n;
        b$a b_a = new b$a();
        if (bounds != null) {
            bounds.width();
            bounds.height();
        }
        b_a.e = obj;
        b_a.c = map;
        b_a.d = map2;
        b_a.f538b = map4;
        b_a.a = map3;
        return b_a;
    }

    public abstract Map<String, Object> t(INFO info);

    public String toString() {
        i iVarH2 = b.c.a.a0.d.h2(this);
        iVarH2.b("isAttached", this.o);
        iVarH2.b("isRequestSubmitted", this.p);
        iVarH2.b("hasFetchFailed", this.q);
        iVarH2.a("fetchedImage", k(this.u));
        iVarH2.c("events", this.d.toString());
        return iVarH2.toString();
    }

    public final void u(String str, DataSource<T> dataSource, Throwable th, boolean z2) {
        Drawable drawable;
        b.b();
        if (!o(str, dataSource)) {
            p("ignore_old_datasource @ onFailure", th);
            dataSource.close();
            b.b();
            return;
        }
        this.d.a(z2 ? c$a.ON_DATASOURCE_FAILURE : c$a.ON_DATASOURCE_FAILURE_INT);
        if (z2) {
            p("final_failed @ onFailure", th);
            this.t = null;
            this.q = true;
            b.f.g.h.a aVar = this.k;
            if (aVar != null) {
                if (this.r && (drawable = this.w) != null) {
                    aVar.f(drawable, 1.0f, true);
                } else if (D()) {
                    aVar.b(th);
                } else {
                    aVar.c(th);
                }
            }
            b$a b_aR = r(dataSource, null, null);
            i().onFailure(this.m, th);
            this.j.b(this.m, th, b_aR);
        } else {
            p("intermediate_failed @ onFailure", th);
            i().onIntermediateImageFailed(this.m, th);
            Objects.requireNonNull(this.j);
        }
        b.b();
    }

    public void v(String str, T t) {
    }

    public final void w(String str, DataSource<T> dataSource, T t, float f, boolean z2, boolean z3, boolean z4) {
        try {
            b.b();
            if (!o(str, dataSource)) {
                q("ignore_old_datasource @ onNewResult", t);
                z(t);
                dataSource.close();
                b.b();
                return;
            }
            this.d.a(z2 ? c$a.ON_DATASOURCE_RESULT : c$a.ON_DATASOURCE_RESULT_INT);
            try {
                Drawable drawableG = g(t);
                T t2 = this.u;
                Drawable drawable = this.w;
                this.u = t;
                this.w = drawableG;
                try {
                    if (z2) {
                        q("set_final_result @ onNewResult", t);
                        this.t = null;
                        this.k.f(drawableG, 1.0f, z3);
                        C(str, t, dataSource);
                    } else if (z4) {
                        q("set_temporary_result @ onNewResult", t);
                        this.k.f(drawableG, 1.0f, z3);
                        C(str, t, dataSource);
                    } else {
                        q("set_intermediate_result @ onNewResult", t);
                        this.k.f(drawableG, f, z3);
                        i().onIntermediateImageSet(str, l(t));
                        Objects.requireNonNull(this.j);
                    }
                    if (drawable != null && drawable != drawableG) {
                        x(drawable);
                    }
                    if (t2 != null && t2 != t) {
                        q("release_previous_result @ onNewResult", t2);
                        z(t2);
                    }
                    b.b();
                } catch (Throwable th) {
                    if (drawable != null && drawable != drawableG) {
                        x(drawable);
                    }
                    if (t2 != null && t2 != t) {
                        q("release_previous_result @ onNewResult", t2);
                        z(t2);
                    }
                    throw th;
                }
            } catch (Exception e) {
                q("drawable_failed @ onNewResult", t);
                z(t);
                u(str, dataSource, e, z2);
                b.b();
            }
        } catch (Throwable th2) {
            b.b();
            throw th2;
        }
    }

    public abstract void x(Drawable drawable);

    public final void y() {
        Map<String, Object> mapA;
        Map<String, Object> mapT;
        boolean z2 = this.p;
        this.p = false;
        this.q = false;
        DataSource<T> dataSource = this.t;
        if (dataSource != null) {
            mapA = dataSource.a();
            this.t.close();
            this.t = null;
        } else {
            mapA = null;
        }
        Drawable drawable = this.w;
        if (drawable != null) {
            x(drawable);
        }
        if (this.f2886s != null) {
            this.f2886s = null;
        }
        this.w = null;
        T t = this.u;
        if (t != null) {
            mapT = t(l(t));
            q("release", this.u);
            z(this.u);
            this.u = null;
        } else {
            mapT = null;
        }
        if (z2) {
            i().onRelease(this.m);
            this.j.c(this.m, s(mapA, mapT, null));
        }
    }

    public abstract void z(T t);
}
