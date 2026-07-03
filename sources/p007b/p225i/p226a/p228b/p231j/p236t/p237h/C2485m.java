package p007b.p225i.p226a.p228b.p231j.p236t.p237h;

import android.content.Context;
import java.util.concurrent.Executor;
import p007b.p225i.p226a.p228b.p231j.p232q.InterfaceC2454e;
import p007b.p225i.p226a.p228b.p231j.p236t.p238i.InterfaceC2494c;
import p007b.p225i.p226a.p228b.p231j.p239u.InterfaceC2518a;
import p007b.p225i.p226a.p228b.p231j.p240v.InterfaceC2519a;
import p496c0.p497a.InterfaceC5318a;

/* JADX INFO: renamed from: b.i.a.b.j.t.h.m */
/* JADX INFO: compiled from: Uploader_Factory.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C2485m implements InterfaceC5318a {

    /* JADX INFO: renamed from: a */
    public final InterfaceC5318a<Context> f5392a;

    /* JADX INFO: renamed from: b */
    public final InterfaceC5318a<InterfaceC2454e> f5393b;

    /* JADX INFO: renamed from: c */
    public final InterfaceC5318a<InterfaceC2494c> f5394c;

    /* JADX INFO: renamed from: d */
    public final InterfaceC5318a<InterfaceC2490r> f5395d;

    /* JADX INFO: renamed from: e */
    public final InterfaceC5318a<Executor> f5396e;

    /* JADX INFO: renamed from: f */
    public final InterfaceC5318a<InterfaceC2518a> f5397f;

    /* JADX INFO: renamed from: g */
    public final InterfaceC5318a<InterfaceC2519a> f5398g;

    public C2485m(InterfaceC5318a<Context> interfaceC5318a, InterfaceC5318a<InterfaceC2454e> interfaceC5318a2, InterfaceC5318a<InterfaceC2494c> interfaceC5318a3, InterfaceC5318a<InterfaceC2490r> interfaceC5318a4, InterfaceC5318a<Executor> interfaceC5318a5, InterfaceC5318a<InterfaceC2518a> interfaceC5318a6, InterfaceC5318a<InterfaceC2519a> interfaceC5318a7) {
        this.f5392a = interfaceC5318a;
        this.f5393b = interfaceC5318a2;
        this.f5394c = interfaceC5318a3;
        this.f5395d = interfaceC5318a4;
        this.f5396e = interfaceC5318a5;
        this.f5397f = interfaceC5318a6;
        this.f5398g = interfaceC5318a7;
    }

    @Override // p496c0.p497a.InterfaceC5318a
    public Object get() {
        return new C2484l(this.f5392a.get(), this.f5393b.get(), this.f5394c.get(), this.f5395d.get(), this.f5396e.get(), this.f5397f.get(), this.f5398g.get());
    }
}
