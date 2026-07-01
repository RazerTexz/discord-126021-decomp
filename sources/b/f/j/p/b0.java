package b.f.j.p;

import java.util.Map;

/* JADX INFO: compiled from: InternalRequestListener.java */
/* JADX INFO: loaded from: classes3.dex */
public class b0 implements b.f.j.k.d, z0 {
    public final a1 a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final z0 f605b;
    public final b.f.j.k.e c;
    public final b.f.j.k.d d;

    public b0(b.f.j.k.e eVar, b.f.j.k.d dVar) {
        this.a = eVar;
        this.f605b = dVar;
        this.c = eVar;
        this.d = dVar;
    }

    @Override // b.f.j.p.z0
    public void a(x0 x0Var, String str, String str2) {
        a1 a1Var = this.a;
        if (a1Var != null) {
            a1Var.h(x0Var.getId(), str, str2);
        }
        z0 z0Var = this.f605b;
        if (z0Var != null) {
            z0Var.a(x0Var, str, str2);
        }
    }

    @Override // b.f.j.k.d
    public void b(x0 x0Var) {
        b.f.j.k.e eVar = this.c;
        if (eVar != null) {
            eVar.a(x0Var.e(), x0Var.b(), x0Var.getId(), x0Var.k());
        }
        b.f.j.k.d dVar = this.d;
        if (dVar != null) {
            dVar.b(x0Var);
        }
    }

    @Override // b.f.j.p.z0
    public void c(x0 x0Var, String str, boolean z2) {
        a1 a1Var = this.a;
        if (a1Var != null) {
            a1Var.e(x0Var.getId(), str, z2);
        }
        z0 z0Var = this.f605b;
        if (z0Var != null) {
            z0Var.c(x0Var, str, z2);
        }
    }

    @Override // b.f.j.p.z0
    public void d(x0 x0Var, String str, Map map) {
        a1 a1Var = this.a;
        if (a1Var != null) {
            a1Var.d(x0Var.getId(), str, map);
        }
        z0 z0Var = this.f605b;
        if (z0Var != null) {
            z0Var.d(x0Var, str, map);
        }
    }

    @Override // b.f.j.p.z0
    public void e(x0 x0Var, String str) {
        a1 a1Var = this.a;
        if (a1Var != null) {
            a1Var.b(x0Var.getId(), str);
        }
        z0 z0Var = this.f605b;
        if (z0Var != null) {
            z0Var.e(x0Var, str);
        }
    }

    @Override // b.f.j.k.d
    public void f(x0 x0Var) {
        b.f.j.k.e eVar = this.c;
        if (eVar != null) {
            eVar.c(x0Var.e(), x0Var.getId(), x0Var.k());
        }
        b.f.j.k.d dVar = this.d;
        if (dVar != null) {
            dVar.f(x0Var);
        }
    }

    @Override // b.f.j.p.z0
    public boolean g(x0 x0Var, String str) {
        z0 z0Var;
        a1 a1Var = this.a;
        boolean zF = a1Var != null ? a1Var.f(x0Var.getId()) : false;
        return (zF || (z0Var = this.f605b) == null) ? zF : z0Var.g(x0Var, str);
    }

    @Override // b.f.j.k.d
    public void h(x0 x0Var, Throwable th) {
        b.f.j.k.e eVar = this.c;
        if (eVar != null) {
            eVar.g(x0Var.e(), x0Var.getId(), th, x0Var.k());
        }
        b.f.j.k.d dVar = this.d;
        if (dVar != null) {
            dVar.h(x0Var, th);
        }
    }

    @Override // b.f.j.k.d
    public void i(x0 x0Var) {
        b.f.j.k.e eVar = this.c;
        if (eVar != null) {
            eVar.k(x0Var.getId());
        }
        b.f.j.k.d dVar = this.d;
        if (dVar != null) {
            dVar.i(x0Var);
        }
    }

    @Override // b.f.j.p.z0
    public void j(x0 x0Var, String str, Map map) {
        a1 a1Var = this.a;
        if (a1Var != null) {
            a1Var.i(x0Var.getId(), str, map);
        }
        z0 z0Var = this.f605b;
        if (z0Var != null) {
            z0Var.j(x0Var, str, map);
        }
    }

    @Override // b.f.j.p.z0
    public void k(x0 x0Var, String str, Throwable th, Map map) {
        a1 a1Var = this.a;
        if (a1Var != null) {
            a1Var.j(x0Var.getId(), str, th, map);
        }
        z0 z0Var = this.f605b;
        if (z0Var != null) {
            z0Var.k(x0Var, str, th, map);
        }
    }
}
