package p007b.p225i.p226a.p228b.p231j.p236t.p238i;

import android.content.Context;
import p496c0.p497a.InterfaceC5318a;

/* JADX INFO: renamed from: b.i.a.b.j.t.i.a0 */
/* JADX INFO: compiled from: SchemaManager_Factory.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C2492a0 implements InterfaceC5318a {

    /* JADX INFO: renamed from: a */
    public final InterfaceC5318a<Context> f5414a;

    /* JADX INFO: renamed from: b */
    public final InterfaceC5318a<String> f5415b;

    /* JADX INFO: renamed from: c */
    public final InterfaceC5318a<Integer> f5416c;

    public C2492a0(InterfaceC5318a<Context> interfaceC5318a, InterfaceC5318a<String> interfaceC5318a2, InterfaceC5318a<Integer> interfaceC5318a3) {
        this.f5414a = interfaceC5318a;
        this.f5415b = interfaceC5318a2;
        this.f5416c = interfaceC5318a3;
    }

    @Override // p496c0.p497a.InterfaceC5318a
    public Object get() {
        return new C2517z(this.f5414a.get(), this.f5415b.get(), this.f5416c.get().intValue());
    }
}
