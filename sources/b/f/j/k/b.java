package b.f.j.k;

import b.f.j.p.x0;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: ForwardingRequestListener2.java */
/* JADX INFO: loaded from: classes.dex */
public class b implements d {
    public final List<d> a;

    public b(Set<d> set) {
        this.a = new ArrayList(set.size());
        for (d dVar : set) {
            if (dVar != null) {
                this.a.add(dVar);
            }
        }
    }

    @Override // b.f.j.p.z0
    public void a(x0 x0Var, String str, String str2) {
        int size = this.a.size();
        for (int i = 0; i < size; i++) {
            try {
                this.a.get(i).a(x0Var, str, str2);
            } catch (Exception e) {
                b.f.d.e.a.f("ForwardingRequestListener2", "InternalListener exception in onIntermediateChunkStart", e);
            }
        }
    }

    @Override // b.f.j.k.d
    public void b(x0 x0Var) {
        int size = this.a.size();
        for (int i = 0; i < size; i++) {
            try {
                this.a.get(i).b(x0Var);
            } catch (Exception e) {
                b.f.d.e.a.f("ForwardingRequestListener2", "InternalListener exception in onRequestStart", e);
            }
        }
    }

    @Override // b.f.j.p.z0
    public void c(x0 x0Var, String str, boolean z2) {
        int size = this.a.size();
        for (int i = 0; i < size; i++) {
            try {
                this.a.get(i).c(x0Var, str, z2);
            } catch (Exception e) {
                b.f.d.e.a.f("ForwardingRequestListener2", "InternalListener exception in onProducerFinishWithSuccess", e);
            }
        }
    }

    @Override // b.f.j.p.z0
    public void d(x0 x0Var, String str, Map<String, String> map) {
        int size = this.a.size();
        for (int i = 0; i < size; i++) {
            try {
                this.a.get(i).d(x0Var, str, map);
            } catch (Exception e) {
                b.f.d.e.a.f("ForwardingRequestListener2", "InternalListener exception in onProducerFinishWithCancellation", e);
            }
        }
    }

    @Override // b.f.j.p.z0
    public void e(x0 x0Var, String str) {
        int size = this.a.size();
        for (int i = 0; i < size; i++) {
            try {
                this.a.get(i).e(x0Var, str);
            } catch (Exception e) {
                b.f.d.e.a.f("ForwardingRequestListener2", "InternalListener exception in onProducerStart", e);
            }
        }
    }

    @Override // b.f.j.k.d
    public void f(x0 x0Var) {
        int size = this.a.size();
        for (int i = 0; i < size; i++) {
            try {
                this.a.get(i).f(x0Var);
            } catch (Exception e) {
                b.f.d.e.a.f("ForwardingRequestListener2", "InternalListener exception in onRequestSuccess", e);
            }
        }
    }

    @Override // b.f.j.p.z0
    public boolean g(x0 x0Var, String str) {
        int size = this.a.size();
        for (int i = 0; i < size; i++) {
            if (this.a.get(i).g(x0Var, str)) {
                return true;
            }
        }
        return false;
    }

    @Override // b.f.j.k.d
    public void h(x0 x0Var, Throwable th) {
        int size = this.a.size();
        for (int i = 0; i < size; i++) {
            try {
                this.a.get(i).h(x0Var, th);
            } catch (Exception e) {
                b.f.d.e.a.f("ForwardingRequestListener2", "InternalListener exception in onRequestFailure", e);
            }
        }
    }

    @Override // b.f.j.k.d
    public void i(x0 x0Var) {
        int size = this.a.size();
        for (int i = 0; i < size; i++) {
            try {
                this.a.get(i).i(x0Var);
            } catch (Exception e) {
                b.f.d.e.a.f("ForwardingRequestListener2", "InternalListener exception in onRequestCancellation", e);
            }
        }
    }

    @Override // b.f.j.p.z0
    public void j(x0 x0Var, String str, Map<String, String> map) {
        int size = this.a.size();
        for (int i = 0; i < size; i++) {
            try {
                this.a.get(i).j(x0Var, str, map);
            } catch (Exception e) {
                b.f.d.e.a.f("ForwardingRequestListener2", "InternalListener exception in onProducerFinishWithSuccess", e);
            }
        }
    }

    @Override // b.f.j.p.z0
    public void k(x0 x0Var, String str, Throwable th, Map<String, String> map) {
        int size = this.a.size();
        for (int i = 0; i < size; i++) {
            try {
                this.a.get(i).k(x0Var, str, th, map);
            } catch (Exception e) {
                b.f.d.e.a.f("ForwardingRequestListener2", "InternalListener exception in onProducerFinishWithFailure", e);
            }
        }
    }
}
