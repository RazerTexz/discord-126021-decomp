package p007b.p225i.p226a.p228b.p231j.p236t;

import android.content.Context;
import p007b.p225i.p226a.p228b.p231j.p236t.p237h.AbstractC2478f;
import p007b.p225i.p226a.p228b.p231j.p236t.p237h.C2476d;
import p007b.p225i.p226a.p228b.p231j.p236t.p238i.InterfaceC2494c;
import p007b.p225i.p226a.p228b.p231j.p240v.InterfaceC2519a;
import p496c0.p497a.InterfaceC5318a;

/* JADX INFO: renamed from: b.i.a.b.j.t.g */
/* JADX INFO: compiled from: SchedulingModule_WorkSchedulerFactory.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C2472g implements InterfaceC5318a {

    /* JADX INFO: renamed from: a */
    public final InterfaceC5318a<Context> f5348a;

    /* JADX INFO: renamed from: b */
    public final InterfaceC5318a<InterfaceC2494c> f5349b;

    /* JADX INFO: renamed from: c */
    public final InterfaceC5318a<AbstractC2478f> f5350c;

    /* JADX INFO: renamed from: d */
    public final InterfaceC5318a<InterfaceC2519a> f5351d;

    public C2472g(InterfaceC5318a<Context> interfaceC5318a, InterfaceC5318a<InterfaceC2494c> interfaceC5318a2, InterfaceC5318a<AbstractC2478f> interfaceC5318a3, InterfaceC5318a<InterfaceC2519a> interfaceC5318a4) {
        this.f5348a = interfaceC5318a;
        this.f5349b = interfaceC5318a2;
        this.f5350c = interfaceC5318a3;
        this.f5351d = interfaceC5318a4;
    }

    @Override // p496c0.p497a.InterfaceC5318a
    public Object get() {
        Context context = this.f5348a.get();
        InterfaceC2494c interfaceC2494c = this.f5349b.get();
        AbstractC2478f abstractC2478f = this.f5350c.get();
        this.f5351d.get();
        return new C2476d(context, interfaceC2494c, abstractC2478f);
    }
}
