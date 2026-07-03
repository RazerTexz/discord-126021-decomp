package p007b.p225i.p226a.p228b.p231j.p236t.p238i;

import p007b.p225i.p226a.p228b.p231j.p240v.InterfaceC2519a;
import p496c0.p497a.InterfaceC5318a;

/* JADX INFO: renamed from: b.i.a.b.j.t.i.u */
/* JADX INFO: compiled from: SQLiteEventStore_Factory.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C2512u implements InterfaceC5318a {

    /* JADX INFO: renamed from: a */
    public final InterfaceC5318a<InterfaceC2519a> f5448a;

    /* JADX INFO: renamed from: b */
    public final InterfaceC5318a<InterfaceC2519a> f5449b;

    /* JADX INFO: renamed from: c */
    public final InterfaceC5318a<AbstractC2495d> f5450c;

    /* JADX INFO: renamed from: d */
    public final InterfaceC5318a<C2517z> f5451d;

    public C2512u(InterfaceC5318a<InterfaceC2519a> interfaceC5318a, InterfaceC5318a<InterfaceC2519a> interfaceC5318a2, InterfaceC5318a<AbstractC2495d> interfaceC5318a3, InterfaceC5318a<C2517z> interfaceC5318a4) {
        this.f5448a = interfaceC5318a;
        this.f5449b = interfaceC5318a2;
        this.f5450c = interfaceC5318a3;
        this.f5451d = interfaceC5318a4;
    }

    @Override // p496c0.p497a.InterfaceC5318a
    public Object get() {
        return new C2511t(this.f5448a.get(), this.f5449b.get(), this.f5450c.get(), this.f5451d.get());
    }
}
