package com.facebook.drawee.controller;

import android.content.Context;
import android.graphics.drawable.Animatable;
import com.facebook.common.internal.Supplier;
import com.facebook.datasource.DataSource;
import com.facebook.drawee.controller.AbstractDraweeControllerBuilder;
import com.facebook.drawee.interfaces.DraweeController;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p109f.p129e.C1725e;
import p007b.p109f.p129e.C1727g;
import p007b.p109f.p132g.p138b.C1752d;
import p007b.p109f.p132g.p139c.C1754b;
import p007b.p109f.p132g.p139c.C1755c;
import p007b.p109f.p132g.p144g.C1797a;
import p007b.p109f.p148h.p158b.p159a.C1828c;
import p007b.p109f.p148h.p158b.p159a.InterfaceC1827b;
import p007b.p109f.p161j.p183r.C2030b;

/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractDraweeControllerBuilder<BUILDER extends AbstractDraweeControllerBuilder<BUILDER, REQUEST, IMAGE, INFO>, REQUEST, IMAGE, INFO> {

    /* JADX INFO: renamed from: a */
    public static final ControllerListener<Object> f19477a = new C10642a();

    /* JADX INFO: renamed from: b */
    public static final NullPointerException f19478b = new NullPointerException("No image request was specified!");

    /* JADX INFO: renamed from: c */
    public static final AtomicLong f19479c = new AtomicLong();

    /* JADX INFO: renamed from: d */
    public final Context f19480d;

    /* JADX INFO: renamed from: e */
    public final Set<ControllerListener> f19481e;

    /* JADX INFO: renamed from: f */
    public final Set<InterfaceC1827b> f19482f;

    /* JADX INFO: renamed from: g */
    public Object f19483g = null;

    /* JADX INFO: renamed from: h */
    public REQUEST f19484h = null;

    /* JADX INFO: renamed from: i */
    public REQUEST[] f19485i = null;

    /* JADX INFO: renamed from: j */
    public boolean f19486j = true;

    /* JADX INFO: renamed from: k */
    public ControllerListener<? super INFO> f19487k = null;

    /* JADX INFO: renamed from: l */
    public boolean f19488l = false;

    /* JADX INFO: renamed from: m */
    public boolean f19489m = false;

    /* JADX INFO: renamed from: n */
    public DraweeController f19490n = null;

    /* JADX INFO: renamed from: com.facebook.drawee.controller.AbstractDraweeControllerBuilder$a */
    public static class C10642a extends C1755c<Object> {
        @Override // p007b.p109f.p132g.p139c.C1755c, com.facebook.drawee.controller.ControllerListener
        public void onFinalImageSet(String str, Object obj, Animatable animatable) {
            if (animatable != null) {
                animatable.start();
            }
        }
    }

    /* JADX INFO: renamed from: com.facebook.drawee.controller.AbstractDraweeControllerBuilder$b */
    public enum EnumC10643b {
        FULL_FETCH,
        DISK_CACHE,
        BITMAP_MEMORY_CACHE
    }

    public AbstractDraweeControllerBuilder(Context context, Set<ControllerListener> set, Set<InterfaceC1827b> set2) {
        this.f19480d = context;
        this.f19481e = set;
        this.f19482f = set2;
    }

    /* JADX INFO: renamed from: a */
    public AbstractDraweeController m8667a() {
        C1460d.m423C(this.f19485i == null || this.f19484h == null, "Cannot specify both ImageRequest and FirstAvailableImageRequests!");
        C1460d.m423C(true, "Cannot specify DataSourceSupplier with other ImageRequests! Use one or the other.");
        if (this.f19484h == null) {
            REQUEST[] requestArr = this.f19485i;
        }
        C2030b.m1527b();
        AbstractDraweeController abstractDraweeControllerMo1057d = mo1057d();
        abstractDraweeControllerMo1057d.f19468r = false;
        abstractDraweeControllerMo1057d.f19469s = null;
        boolean z2 = this.f19488l;
        if (z2) {
            if (abstractDraweeControllerMo1057d.f19457g == null) {
                abstractDraweeControllerMo1057d.f19457g = new C1752d();
            }
            abstractDraweeControllerMo1057d.f19457g.f3288a = z2;
            if (abstractDraweeControllerMo1057d.f19458h == null) {
                C1797a c1797a = new C1797a(this.f19480d);
                abstractDraweeControllerMo1057d.f19458h = c1797a;
                c1797a.f3480a = abstractDraweeControllerMo1057d;
            }
        }
        Set<ControllerListener> set = this.f19481e;
        if (set != null) {
            Iterator<ControllerListener> it = set.iterator();
            while (it.hasNext()) {
                abstractDraweeControllerMo1057d.m8656f(it.next());
            }
        }
        Set<InterfaceC1827b> set2 = this.f19482f;
        if (set2 != null) {
            for (InterfaceC1827b<INFO> interfaceC1827b : set2) {
                C1828c<INFO> c1828c = abstractDraweeControllerMo1057d.f19460j;
                synchronized (c1828c) {
                    c1828c.f3568j.add(interfaceC1827b);
                }
            }
        }
        ControllerListener<? super INFO> controllerListener = this.f19487k;
        if (controllerListener != null) {
            abstractDraweeControllerMo1057d.m8656f(controllerListener);
        }
        if (this.f19489m) {
            abstractDraweeControllerMo1057d.m8656f(f19477a);
        }
        C2030b.m1527b();
        return abstractDraweeControllerMo1057d;
    }

    /* JADX INFO: renamed from: b */
    public abstract DataSource<IMAGE> mo1056b(DraweeController draweeController, String str, REQUEST request, Object obj, EnumC10643b enumC10643b);

    /* JADX INFO: renamed from: c */
    public Supplier<DataSource<IMAGE>> m8668c(DraweeController draweeController, String str, REQUEST request) {
        return new C1754b(this, draweeController, str, request, this.f19483g, EnumC10643b.FULL_FETCH);
    }

    /* JADX INFO: renamed from: d */
    public abstract AbstractDraweeController mo1057d();

    /* JADX INFO: renamed from: e */
    public Supplier<DataSource<IMAGE>> m8669e(DraweeController draweeController, String str) {
        Supplier<DataSource<IMAGE>> c1727g;
        REQUEST request = this.f19484h;
        if (request != null) {
            c1727g = m8668c(draweeController, str, request);
        } else {
            REQUEST[] requestArr = this.f19485i;
            if (requestArr != null) {
                boolean z2 = this.f19486j;
                ArrayList arrayList = new ArrayList(requestArr.length * 2);
                if (z2) {
                    for (REQUEST request2 : requestArr) {
                        arrayList.add(new C1754b(this, draweeController, str, request2, this.f19483g, EnumC10643b.BITMAP_MEMORY_CACHE));
                    }
                }
                for (REQUEST request3 : requestArr) {
                    arrayList.add(m8668c(draweeController, str, request3));
                }
                c1727g = new C1727g<>(arrayList);
            } else {
                c1727g = null;
            }
        }
        return c1727g == null ? new C1725e(f19478b) : c1727g;
    }
}
