package b.g.a.c.e0.h;

import b.g.a.a.c0$a;

/* JADX INFO: compiled from: AsExternalTypeSerializer.java */
/* JADX INFO: loaded from: classes3.dex */
public class c extends m {
    public final String c;

    public c(b.g.a.c.e0.e eVar, b.g.a.c.d dVar, String str) {
        super(eVar, dVar);
        this.c = str;
    }

    @Override // b.g.a.c.e0.g
    public b.g.a.c.e0.g a(b.g.a.c.d dVar) {
        return this.f699b == dVar ? this : new c(this.a, dVar, this.c);
    }

    @Override // b.g.a.c.e0.h.m, b.g.a.c.e0.g
    public String b() {
        return this.c;
    }

    @Override // b.g.a.c.e0.g
    public c0$a c() {
        return c0$a.EXTERNAL_PROPERTY;
    }
}
