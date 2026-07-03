package com.facebook.drawee.controller;

import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Looper;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import com.facebook.datasource.DataSource;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.interfaces.DraweeHierarchy;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Executor;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p109f.p115d.p119d.C1683f;
import p007b.p109f.p115d.p119d.C1686i;
import p007b.p109f.p115d.p120e.C1691a;
import p007b.p109f.p129e.AbstractC1723c;
import p007b.p109f.p129e.AbstractC1724d;
import p007b.p109f.p132g.p138b.AbstractC1749a;
import p007b.p109f.p132g.p138b.C1750b;
import p007b.p109f.p132g.p138b.C1751c;
import p007b.p109f.p132g.p138b.C1752d;
import p007b.p109f.p132g.p139c.C1755c;
import p007b.p109f.p132g.p139c.C1756d;
import p007b.p109f.p132g.p142e.C1782p;
import p007b.p109f.p132g.p144g.C1797a;
import p007b.p109f.p132g.p145h.InterfaceC1798a;
import p007b.p109f.p148h.p158b.p159a.C1828c;
import p007b.p109f.p148h.p158b.p159a.InterfaceC1827b;
import p007b.p109f.p161j.p183r.C2030b;

/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractDraweeController<T, INFO> implements DraweeController, AbstractC1749a.a, C1797a.a {

    /* JADX INFO: renamed from: a */
    public static final Map<String, Object> f19451a = C1683f.m967of("component_tag", "drawee");

    /* JADX INFO: renamed from: b */
    public static final Map<String, Object> f19452b = C1683f.m968of("origin", "memory_bitmap", "origin_sub", "shortcut");

    /* JADX INFO: renamed from: c */
    public static final Class<?> f19453c = AbstractDraweeController.class;

    /* JADX INFO: renamed from: d */
    public final C1751c f19454d;

    /* JADX INFO: renamed from: e */
    public final AbstractC1749a f19455e;

    /* JADX INFO: renamed from: f */
    public final Executor f19456f;

    /* JADX INFO: renamed from: g */
    public C1752d f19457g;

    /* JADX INFO: renamed from: h */
    public C1797a f19458h;

    /* JADX INFO: renamed from: i */
    public ControllerListener<INFO> f19459i;

    /* JADX INFO: renamed from: j */
    public C1828c<INFO> f19460j;

    /* JADX INFO: renamed from: k */
    public InterfaceC1798a f19461k;

    /* JADX INFO: renamed from: l */
    public Drawable f19462l;

    /* JADX INFO: renamed from: m */
    public String f19463m;

    /* JADX INFO: renamed from: n */
    public Object f19464n;

    /* JADX INFO: renamed from: o */
    public boolean f19465o;

    /* JADX INFO: renamed from: p */
    public boolean f19466p;

    /* JADX INFO: renamed from: q */
    public boolean f19467q;

    /* JADX INFO: renamed from: r */
    public boolean f19468r;

    /* JADX INFO: renamed from: s */
    public String f19469s;

    /* JADX INFO: renamed from: t */
    public DataSource<T> f19470t;

    /* JADX INFO: renamed from: u */
    public T f19471u;

    /* JADX INFO: renamed from: v */
    public boolean f19472v;

    /* JADX INFO: renamed from: w */
    public Drawable f19473w;

    /* JADX INFO: renamed from: com.facebook.drawee.controller.AbstractDraweeController$a */
    public class C10640a extends AbstractC1724d<T> {

        /* JADX INFO: renamed from: a */
        public final /* synthetic */ String f19474a;

        /* JADX INFO: renamed from: b */
        public final /* synthetic */ boolean f19475b;

        public C10640a(String str, boolean z2) {
            this.f19474a = str;
            this.f19475b = z2;
        }

        @Override // p007b.p109f.p129e.AbstractC1724d
        public void onFailureImpl(DataSource<T> dataSource) {
            AbstractDraweeController abstractDraweeController = AbstractDraweeController.this;
            String str = this.f19474a;
            Throwable thMo1020d = dataSource.mo1020d();
            Map<String, Object> map = AbstractDraweeController.f19451a;
            abstractDraweeController.m8664u(str, dataSource, thMo1020d, true);
        }

        @Override // p007b.p109f.p129e.AbstractC1724d
        public void onNewResultImpl(DataSource<T> dataSource) {
            boolean zMo1019c = dataSource.mo1019c();
            boolean zMo1021e = dataSource.mo1021e();
            float progress = dataSource.getProgress();
            T result = dataSource.getResult();
            if (result != null) {
                AbstractDraweeController abstractDraweeController = AbstractDraweeController.this;
                String str = this.f19474a;
                boolean z2 = this.f19475b;
                Map<String, Object> map = AbstractDraweeController.f19451a;
                abstractDraweeController.m8665w(str, dataSource, result, progress, zMo1019c, z2, zMo1021e);
                return;
            }
            if (zMo1019c) {
                AbstractDraweeController abstractDraweeController2 = AbstractDraweeController.this;
                String str2 = this.f19474a;
                NullPointerException nullPointerException = new NullPointerException();
                Map<String, Object> map2 = AbstractDraweeController.f19451a;
                abstractDraweeController2.m8664u(str2, dataSource, nullPointerException, true);
            }
        }

        @Override // p007b.p109f.p129e.AbstractC1724d, p007b.p109f.p129e.InterfaceC1726f
        public void onProgressUpdate(DataSource<T> dataSource) {
            AbstractC1723c abstractC1723c = (AbstractC1723c) dataSource;
            boolean zMo1019c = abstractC1723c.mo1019c();
            float progress = abstractC1723c.getProgress();
            AbstractDraweeController abstractDraweeController = AbstractDraweeController.this;
            String str = this.f19474a;
            Map<String, Object> map = AbstractDraweeController.f19451a;
            if (!abstractDraweeController.m8659o(str, abstractC1723c)) {
                abstractDraweeController.m8660p("ignore_old_datasource @ onProgress", null);
                abstractC1723c.close();
            } else {
                if (zMo1019c) {
                    return;
                }
                abstractDraweeController.f19461k.mo1134d(progress, false);
            }
        }
    }

    /* JADX INFO: renamed from: com.facebook.drawee.controller.AbstractDraweeController$b */
    public static class C10641b<INFO> extends C1756d<INFO> {
    }

    public AbstractDraweeController(AbstractC1749a abstractC1749a, Executor executor, String str, Object obj) {
        this.f19454d = C1751c.f3261b ? new C1751c() : C1751c.f3260a;
        this.f19460j = new C1828c<>();
        this.f19472v = true;
        this.f19455e = abstractC1749a;
        this.f19456f = executor;
        m8658n(null, null);
    }

    /* JADX INFO: renamed from: A */
    public void m8647A(ControllerListener<? super INFO> controllerListener) {
        Objects.requireNonNull(controllerListener);
        ControllerListener<INFO> controllerListener2 = this.f19459i;
        if (!(controllerListener2 instanceof C10641b)) {
            if (controllerListener2 == controllerListener) {
                this.f19459i = null;
            }
        } else {
            C10641b c10641b = (C10641b) controllerListener2;
            synchronized (c10641b) {
                int iIndexOf = c10641b.f3298a.indexOf(controllerListener);
                if (iIndexOf != -1) {
                    c10641b.f3298a.set(iIndexOf, null);
                }
            }
        }
    }

    /* JADX INFO: renamed from: B */
    public void m8648B(DataSource<T> dataSource, INFO info) {
        m8657i().onSubmit(this.f19463m, this.f19464n);
        this.f19460j.mo1071a(this.f19463m, this.f19464n, m8662r(dataSource, info, mo1051m()));
    }

    /* JADX INFO: renamed from: C */
    public final void m8649C(String str, T t, DataSource<T> dataSource) {
        INFO infoMo1050l = mo1050l(t);
        m8657i().onFinalImageSet(str, infoMo1050l, mo8654c());
        this.f19460j.mo1074d(str, infoMo1050l, m8662r(dataSource, infoMo1050l, null));
    }

    /* JADX INFO: renamed from: D */
    public final boolean m8650D() {
        C1752d c1752d;
        if (this.f19467q && (c1752d = this.f19457g) != null) {
            if (c1752d.f3288a && c1752d.f3290c < c1752d.f3289b) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: renamed from: E */
    public void m8651E() {
        C2030b.m1527b();
        T tMo1047h = mo1047h();
        if (tMo1047h != null) {
            C2030b.m1527b();
            this.f19470t = null;
            this.f19466p = true;
            this.f19467q = false;
            this.f19454d.m1084a(C1751c.a.ON_SUBMIT_CACHE_HIT);
            m8648B(this.f19470t, mo1050l(tMo1047h));
            mo1053v(this.f19463m, tMo1047h);
            m8665w(this.f19463m, this.f19470t, tMo1047h, 1.0f, true, true, true);
            C2030b.m1527b();
            C2030b.m1527b();
            return;
        }
        this.f19454d.m1084a(C1751c.a.ON_DATASOURCE_SUBMIT);
        this.f19461k.mo1134d(0.0f, true);
        this.f19466p = true;
        this.f19467q = false;
        DataSource<T> dataSourceMo1048j = mo1048j();
        this.f19470t = dataSourceMo1048j;
        m8648B(dataSourceMo1048j, null);
        if (C1691a.m980h(2)) {
            C1691a.m982j(f19453c, "controller %x %s: submitRequest: dataSource: %x", Integer.valueOf(System.identityHashCode(this)), this.f19463m, Integer.valueOf(System.identityHashCode(this.f19470t)));
        }
        this.f19470t.mo1022f(new C10640a(this.f19463m, this.f19470t.mo1018b()), this.f19456f);
        C2030b.m1527b();
    }

    @Override // com.facebook.drawee.interfaces.DraweeController
    /* JADX INFO: renamed from: a */
    public void mo8652a() {
        C2030b.m1527b();
        if (C1691a.m980h(2)) {
            System.identityHashCode(this);
        }
        this.f19454d.m1084a(C1751c.a.ON_DETACH_CONTROLLER);
        this.f19465o = false;
        C1750b c1750b = (C1750b) this.f19455e;
        Objects.requireNonNull(c1750b);
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            synchronized (c1750b.f3254b) {
                if (!c1750b.f3256d.contains(this)) {
                    c1750b.f3256d.add(this);
                    boolean z2 = c1750b.f3256d.size() == 1;
                    if (z2) {
                        c1750b.f3255c.post(c1750b.f3258f);
                    }
                }
            }
        } else {
            release();
        }
        C2030b.m1527b();
    }

    @Override // com.facebook.drawee.interfaces.DraweeController
    /* JADX INFO: renamed from: b */
    public DraweeHierarchy mo8653b() {
        return this.f19461k;
    }

    @Override // com.facebook.drawee.interfaces.DraweeController
    /* JADX INFO: renamed from: c */
    public Animatable mo8654c() {
        Object obj = this.f19473w;
        if (obj instanceof Animatable) {
            return (Animatable) obj;
        }
        return null;
    }

    @Override // com.facebook.drawee.interfaces.DraweeController
    /* JADX INFO: renamed from: d */
    public void mo8655d() {
        C2030b.m1527b();
        if (C1691a.m980h(2)) {
            C1691a.m982j(f19453c, "controller %x %s: onAttach: %s", Integer.valueOf(System.identityHashCode(this)), this.f19463m, this.f19466p ? "request already submitted" : "request needs submit");
        }
        this.f19454d.m1084a(C1751c.a.ON_ATTACH_CONTROLLER);
        Objects.requireNonNull(this.f19461k);
        this.f19455e.mo1083a(this);
        this.f19465o = true;
        if (!this.f19466p) {
            m8651E();
        }
        C2030b.m1527b();
    }

    @Override // com.facebook.drawee.interfaces.DraweeController
    /* JADX INFO: renamed from: e */
    public void mo1045e(DraweeHierarchy draweeHierarchy) {
        if (C1691a.m980h(2)) {
            C1691a.m982j(f19453c, "controller %x %s: setHierarchy: %s", Integer.valueOf(System.identityHashCode(this)), this.f19463m, draweeHierarchy);
        }
        this.f19454d.m1084a(draweeHierarchy != null ? C1751c.a.ON_SET_HIERARCHY : C1751c.a.ON_CLEAR_HIERARCHY);
        if (this.f19466p) {
            this.f19455e.mo1083a(this);
            release();
        }
        InterfaceC1798a interfaceC1798a = this.f19461k;
        if (interfaceC1798a != null) {
            interfaceC1798a.mo1131a(null);
            this.f19461k = null;
        }
        if (draweeHierarchy != null) {
            C1460d.m527i(Boolean.valueOf(draweeHierarchy instanceof InterfaceC1798a));
            InterfaceC1798a interfaceC1798a2 = (InterfaceC1798a) draweeHierarchy;
            this.f19461k = interfaceC1798a2;
            interfaceC1798a2.mo1131a(this.f19462l);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: f */
    public void m8656f(ControllerListener<? super INFO> controllerListener) {
        Objects.requireNonNull(controllerListener);
        ControllerListener<INFO> controllerListener2 = this.f19459i;
        if (controllerListener2 instanceof C10641b) {
            ((C10641b) controllerListener2).m1085a(controllerListener);
            return;
        }
        if (controllerListener2 == null) {
            this.f19459i = controllerListener;
            return;
        }
        C2030b.m1527b();
        C10641b c10641b = new C10641b();
        c10641b.m1085a(controllerListener2);
        c10641b.m1085a(controllerListener);
        C2030b.m1527b();
        this.f19459i = c10641b;
    }

    /* JADX INFO: renamed from: g */
    public abstract Drawable mo1046g(T t);

    /* JADX INFO: renamed from: h */
    public T mo1047h() {
        return null;
    }

    /* JADX INFO: renamed from: i */
    public ControllerListener<INFO> m8657i() {
        ControllerListener<INFO> controllerListener = this.f19459i;
        return controllerListener == null ? C1755c.getNoOpListener() : controllerListener;
    }

    /* JADX INFO: renamed from: j */
    public abstract DataSource<T> mo1048j();

    /* JADX INFO: renamed from: k */
    public int mo1049k(T t) {
        return System.identityHashCode(t);
    }

    /* JADX INFO: renamed from: l */
    public abstract INFO mo1050l(T t);

    /* JADX INFO: renamed from: m */
    public Uri mo1051m() {
        return null;
    }

    /* JADX INFO: renamed from: n */
    public final synchronized void m8658n(String str, Object obj) {
        AbstractC1749a abstractC1749a;
        C2030b.m1527b();
        this.f19454d.m1084a(C1751c.a.ON_INIT_CONTROLLER);
        if (!this.f19472v && (abstractC1749a = this.f19455e) != null) {
            abstractC1749a.mo1083a(this);
        }
        this.f19465o = false;
        m8666y();
        this.f19468r = false;
        C1752d c1752d = this.f19457g;
        if (c1752d != null) {
            c1752d.f3288a = false;
            c1752d.f3289b = 4;
            c1752d.f3290c = 0;
        }
        C1797a c1797a = this.f19458h;
        if (c1797a != null) {
            c1797a.f3480a = null;
            c1797a.f3482c = false;
            c1797a.f3483d = false;
            c1797a.f3480a = this;
        }
        ControllerListener<INFO> controllerListener = this.f19459i;
        if (controllerListener instanceof C10641b) {
            C10641b c10641b = (C10641b) controllerListener;
            synchronized (c10641b) {
                c10641b.f3298a.clear();
            }
        } else {
            this.f19459i = null;
        }
        InterfaceC1798a interfaceC1798a = this.f19461k;
        if (interfaceC1798a != null) {
            interfaceC1798a.reset();
            this.f19461k.mo1131a(null);
            this.f19461k = null;
        }
        this.f19462l = null;
        if (C1691a.m980h(2)) {
            C1691a.m982j(f19453c, "controller %x %s -> %s: initialize", Integer.valueOf(System.identityHashCode(this)), this.f19463m, str);
        }
        this.f19463m = str;
        this.f19464n = obj;
        C2030b.m1527b();
    }

    /* JADX INFO: renamed from: o */
    public final boolean m8659o(String str, DataSource<T> dataSource) {
        if (dataSource == null && this.f19470t == null) {
            return true;
        }
        return str.equals(this.f19463m) && dataSource == this.f19470t && this.f19466p;
    }

    @Override // com.facebook.drawee.interfaces.DraweeController
    public boolean onTouchEvent(MotionEvent motionEvent) {
        C1797a.a aVar;
        boolean zM980h = C1691a.m980h(2);
        if (zM980h) {
            C1691a.m982j(f19453c, "controller %x %s: onTouchEvent %s", Integer.valueOf(System.identityHashCode(this)), this.f19463m, motionEvent);
        }
        C1797a c1797a = this.f19458h;
        if (c1797a == null) {
            return false;
        }
        if (!c1797a.f3482c && !m8650D()) {
            return false;
        }
        C1797a c1797a2 = this.f19458h;
        Objects.requireNonNull(c1797a2);
        int action = motionEvent.getAction();
        if (action == 0) {
            c1797a2.f3482c = true;
            c1797a2.f3483d = true;
            c1797a2.f3484e = motionEvent.getEventTime();
            c1797a2.f3485f = motionEvent.getX();
            c1797a2.f3486g = motionEvent.getY();
        } else if (action == 1) {
            c1797a2.f3482c = false;
            if (Math.abs(motionEvent.getX() - c1797a2.f3485f) > c1797a2.f3481b || Math.abs(motionEvent.getY() - c1797a2.f3486g) > c1797a2.f3481b) {
                c1797a2.f3483d = false;
            }
            if (c1797a2.f3483d && motionEvent.getEventTime() - c1797a2.f3484e <= ViewConfiguration.getLongPressTimeout() && (aVar = c1797a2.f3480a) != null) {
                AbstractDraweeController abstractDraweeController = (AbstractDraweeController) aVar;
                if (zM980h) {
                    System.identityHashCode(abstractDraweeController);
                }
                if (abstractDraweeController.m8650D()) {
                    abstractDraweeController.f19457g.f3290c++;
                    abstractDraweeController.f19461k.reset();
                    abstractDraweeController.m8651E();
                }
            }
            c1797a2.f3483d = false;
        } else if (action != 2) {
            if (action == 3) {
                c1797a2.f3482c = false;
                c1797a2.f3483d = false;
            }
        } else if (Math.abs(motionEvent.getX() - c1797a2.f3485f) > c1797a2.f3481b || Math.abs(motionEvent.getY() - c1797a2.f3486g) > c1797a2.f3481b) {
            c1797a2.f3483d = false;
        }
        return true;
    }

    /* JADX INFO: renamed from: p */
    public final void m8660p(String str, Throwable th) {
        if (C1691a.m980h(2)) {
            System.identityHashCode(this);
        }
    }

    /* JADX INFO: renamed from: q */
    public final void m8661q(String str, T t) {
        if (C1691a.m980h(2)) {
            System.identityHashCode(this);
            if (t != null) {
                t.getClass().getSimpleName();
            }
            mo1049k(t);
        }
    }

    /* JADX INFO: renamed from: r */
    public final InterfaceC1827b.a m8662r(DataSource<T> dataSource, INFO info, Uri uri) {
        return m8663s(dataSource == null ? null : dataSource.mo1017a(), mo1052t(info), uri);
    }

    @Override // p007b.p109f.p132g.p138b.AbstractC1749a.a
    public void release() {
        this.f19454d.m1084a(C1751c.a.ON_RELEASE_CONTROLLER);
        C1752d c1752d = this.f19457g;
        if (c1752d != null) {
            c1752d.f3290c = 0;
        }
        C1797a c1797a = this.f19458h;
        if (c1797a != null) {
            c1797a.f3482c = false;
            c1797a.f3483d = false;
        }
        InterfaceC1798a interfaceC1798a = this.f19461k;
        if (interfaceC1798a != null) {
            interfaceC1798a.reset();
        }
        m8666y();
    }

    /* JADX INFO: renamed from: s */
    public final InterfaceC1827b.a m8663s(Map<String, Object> map, Map<String, Object> map2, Uri uri) {
        InterfaceC1798a interfaceC1798a = this.f19461k;
        if (interfaceC1798a instanceof GenericDraweeHierarchy) {
            GenericDraweeHierarchy genericDraweeHierarchy = (GenericDraweeHierarchy) interfaceC1798a;
            String.valueOf(!(genericDraweeHierarchy.m8675k(2) instanceof C1782p) ? null : genericDraweeHierarchy.m8676l(2).f3435n);
            if (genericDraweeHierarchy.m8675k(2) instanceof C1782p) {
                PointF pointF = genericDraweeHierarchy.m8676l(2).f3437p;
            }
        }
        Map<String, Object> map3 = f19451a;
        Map<String, Object> map4 = f19452b;
        InterfaceC1798a interfaceC1798a2 = this.f19461k;
        Rect bounds = interfaceC1798a2 != null ? interfaceC1798a2.getBounds() : null;
        Object obj = this.f19464n;
        InterfaceC1827b.a aVar = new InterfaceC1827b.a();
        if (bounds != null) {
            bounds.width();
            bounds.height();
        }
        aVar.f3567e = obj;
        aVar.f3565c = map;
        aVar.f3566d = map2;
        aVar.f3564b = map4;
        aVar.f3563a = map3;
        return aVar;
    }

    /* JADX INFO: renamed from: t */
    public abstract Map<String, Object> mo1052t(INFO info);

    public String toString() {
        C1686i c1686iM526h2 = C1460d.m526h2(this);
        c1686iM526h2.m970b("isAttached", this.f19465o);
        c1686iM526h2.m970b("isRequestSubmitted", this.f19466p);
        c1686iM526h2.m970b("hasFetchFailed", this.f19467q);
        c1686iM526h2.m969a("fetchedImage", mo1049k(this.f19471u));
        c1686iM526h2.m971c("events", this.f19454d.toString());
        return c1686iM526h2.toString();
    }

    /* JADX INFO: renamed from: u */
    public final void m8664u(String str, DataSource<T> dataSource, Throwable th, boolean z2) {
        Drawable drawable;
        C2030b.m1527b();
        if (!m8659o(str, dataSource)) {
            m8660p("ignore_old_datasource @ onFailure", th);
            dataSource.close();
            C2030b.m1527b();
            return;
        }
        this.f19454d.m1084a(z2 ? C1751c.a.ON_DATASOURCE_FAILURE : C1751c.a.ON_DATASOURCE_FAILURE_INT);
        if (z2) {
            m8660p("final_failed @ onFailure", th);
            this.f19470t = null;
            this.f19467q = true;
            InterfaceC1798a interfaceC1798a = this.f19461k;
            if (interfaceC1798a != null) {
                if (this.f19468r && (drawable = this.f19473w) != null) {
                    interfaceC1798a.mo1135f(drawable, 1.0f, true);
                } else if (m8650D()) {
                    interfaceC1798a.mo1132b(th);
                } else {
                    interfaceC1798a.mo1133c(th);
                }
            }
            InterfaceC1827b.a aVarM8662r = m8662r(dataSource, null, null);
            m8657i().onFailure(this.f19463m, th);
            this.f19460j.mo1072b(this.f19463m, th, aVarM8662r);
        } else {
            m8660p("intermediate_failed @ onFailure", th);
            m8657i().onIntermediateImageFailed(this.f19463m, th);
            Objects.requireNonNull(this.f19460j);
        }
        C2030b.m1527b();
    }

    /* JADX INFO: renamed from: v */
    public void mo1053v(String str, T t) {
    }

    /* JADX INFO: renamed from: w */
    public final void m8665w(String str, DataSource<T> dataSource, T t, float f, boolean z2, boolean z3, boolean z4) {
        try {
            C2030b.m1527b();
            if (!m8659o(str, dataSource)) {
                m8661q("ignore_old_datasource @ onNewResult", t);
                mo1055z(t);
                dataSource.close();
                C2030b.m1527b();
                return;
            }
            this.f19454d.m1084a(z2 ? C1751c.a.ON_DATASOURCE_RESULT : C1751c.a.ON_DATASOURCE_RESULT_INT);
            try {
                Drawable drawableMo1046g = mo1046g(t);
                T t2 = this.f19471u;
                Drawable drawable = this.f19473w;
                this.f19471u = t;
                this.f19473w = drawableMo1046g;
                try {
                    if (z2) {
                        m8661q("set_final_result @ onNewResult", t);
                        this.f19470t = null;
                        this.f19461k.mo1135f(drawableMo1046g, 1.0f, z3);
                        m8649C(str, t, dataSource);
                    } else if (z4) {
                        m8661q("set_temporary_result @ onNewResult", t);
                        this.f19461k.mo1135f(drawableMo1046g, 1.0f, z3);
                        m8649C(str, t, dataSource);
                    } else {
                        m8661q("set_intermediate_result @ onNewResult", t);
                        this.f19461k.mo1135f(drawableMo1046g, f, z3);
                        m8657i().onIntermediateImageSet(str, mo1050l(t));
                        Objects.requireNonNull(this.f19460j);
                    }
                    if (drawable != null && drawable != drawableMo1046g) {
                        mo1054x(drawable);
                    }
                    if (t2 != null && t2 != t) {
                        m8661q("release_previous_result @ onNewResult", t2);
                        mo1055z(t2);
                    }
                    C2030b.m1527b();
                } catch (Throwable th) {
                    if (drawable != null && drawable != drawableMo1046g) {
                        mo1054x(drawable);
                    }
                    if (t2 != null && t2 != t) {
                        m8661q("release_previous_result @ onNewResult", t2);
                        mo1055z(t2);
                    }
                    throw th;
                }
            } catch (Exception e) {
                m8661q("drawable_failed @ onNewResult", t);
                mo1055z(t);
                m8664u(str, dataSource, e, z2);
                C2030b.m1527b();
            }
        } catch (Throwable th2) {
            C2030b.m1527b();
            throw th2;
        }
    }

    /* JADX INFO: renamed from: x */
    public abstract void mo1054x(Drawable drawable);

    /* JADX INFO: renamed from: y */
    public final void m8666y() {
        Map<String, Object> mapMo1017a;
        Map<String, Object> mapMo1052t;
        boolean z2 = this.f19466p;
        this.f19466p = false;
        this.f19467q = false;
        DataSource<T> dataSource = this.f19470t;
        if (dataSource != null) {
            mapMo1017a = dataSource.mo1017a();
            this.f19470t.close();
            this.f19470t = null;
        } else {
            mapMo1017a = null;
        }
        Drawable drawable = this.f19473w;
        if (drawable != null) {
            mo1054x(drawable);
        }
        if (this.f19469s != null) {
            this.f19469s = null;
        }
        this.f19473w = null;
        T t = this.f19471u;
        if (t != null) {
            mapMo1052t = mo1052t(mo1050l(t));
            m8661q("release", this.f19471u);
            mo1055z(this.f19471u);
            this.f19471u = null;
        } else {
            mapMo1052t = null;
        }
        if (z2) {
            m8657i().onRelease(this.f19463m);
            this.f19460j.mo1073c(this.f19463m, m8663s(mapMo1017a, mapMo1052t, null));
        }
    }

    /* JADX INFO: renamed from: z */
    public abstract void mo1055z(T t);
}
