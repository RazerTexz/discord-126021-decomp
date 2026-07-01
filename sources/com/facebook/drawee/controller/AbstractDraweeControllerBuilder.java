package com.facebook.drawee.controller;

import android.content.Context;
import b.c.a.a0.d;
import b.f.e.e;
import b.f.e.g;
import b.f.g.g.a;
import b.f.h.b.a.b;
import b.f.h.b.a.c;
import com.facebook.common.internal.Supplier;
import com.facebook.datasource.DataSource;
import com.facebook.drawee.controller.AbstractDraweeControllerBuilder;
import com.facebook.drawee.interfaces.DraweeController;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractDraweeControllerBuilder<BUILDER extends AbstractDraweeControllerBuilder<BUILDER, REQUEST, IMAGE, INFO>, REQUEST, IMAGE, INFO> {
    public static final ControllerListener<Object> a = new AbstractDraweeControllerBuilder$a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final NullPointerException f2888b = new NullPointerException("No image request was specified!");
    public static final AtomicLong c = new AtomicLong();
    public final Context d;
    public final Set<ControllerListener> e;
    public final Set<b> f;
    public Object g = null;
    public REQUEST h = null;
    public REQUEST[] i = null;
    public boolean j = true;
    public ControllerListener<? super INFO> k = null;
    public boolean l = false;
    public boolean m = false;
    public DraweeController n = null;

    public AbstractDraweeControllerBuilder(Context context, Set<ControllerListener> set, Set<b> set2) {
        this.d = context;
        this.e = set;
        this.f = set2;
    }

    public AbstractDraweeController a() {
        d.C(this.i == null || this.h == null, "Cannot specify both ImageRequest and FirstAvailableImageRequests!");
        d.C(true, "Cannot specify DataSourceSupplier with other ImageRequests! Use one or the other.");
        if (this.h == null) {
            REQUEST[] requestArr = this.i;
        }
        b.f.j.r.b.b();
        AbstractDraweeController abstractDraweeControllerD = d();
        abstractDraweeControllerD.r = false;
        abstractDraweeControllerD.f2886s = null;
        boolean z2 = this.l;
        if (z2) {
            if (abstractDraweeControllerD.g == null) {
                abstractDraweeControllerD.g = new b.f.g.b.d();
            }
            abstractDraweeControllerD.g.a = z2;
            if (abstractDraweeControllerD.h == null) {
                a aVar = new a(this.d);
                abstractDraweeControllerD.h = aVar;
                aVar.a = abstractDraweeControllerD;
            }
        }
        Set<ControllerListener> set = this.e;
        if (set != null) {
            Iterator<ControllerListener> it = set.iterator();
            while (it.hasNext()) {
                abstractDraweeControllerD.f(it.next());
            }
        }
        Set<b> set2 = this.f;
        if (set2 != null) {
            for (b<INFO> bVar : set2) {
                c<INFO> cVar = abstractDraweeControllerD.j;
                synchronized (cVar) {
                    cVar.j.add(bVar);
                }
            }
        }
        ControllerListener<? super INFO> controllerListener = this.k;
        if (controllerListener != null) {
            abstractDraweeControllerD.f(controllerListener);
        }
        if (this.m) {
            abstractDraweeControllerD.f(a);
        }
        b.f.j.r.b.b();
        return abstractDraweeControllerD;
    }

    public abstract DataSource<IMAGE> b(DraweeController draweeController, String str, REQUEST request, Object obj, AbstractDraweeControllerBuilder$b abstractDraweeControllerBuilder$b);

    public Supplier<DataSource<IMAGE>> c(DraweeController draweeController, String str, REQUEST request) {
        return new b.f.g.c.b(this, draweeController, str, request, this.g, AbstractDraweeControllerBuilder$b.FULL_FETCH);
    }

    public abstract AbstractDraweeController d();

    public Supplier<DataSource<IMAGE>> e(DraweeController draweeController, String str) {
        Supplier<DataSource<IMAGE>> gVar;
        REQUEST request = this.h;
        if (request != null) {
            gVar = c(draweeController, str, request);
        } else {
            REQUEST[] requestArr = this.i;
            if (requestArr != null) {
                boolean z2 = this.j;
                ArrayList arrayList = new ArrayList(requestArr.length * 2);
                if (z2) {
                    for (REQUEST request2 : requestArr) {
                        arrayList.add(new b.f.g.c.b(this, draweeController, str, request2, this.g, AbstractDraweeControllerBuilder$b.BITMAP_MEMORY_CACHE));
                    }
                }
                for (REQUEST request3 : requestArr) {
                    arrayList.add(c(draweeController, str, request3));
                }
                gVar = new g<>(arrayList);
            } else {
                gVar = null;
            }
        }
        return gVar == null ? new e(f2888b) : gVar;
    }
}
