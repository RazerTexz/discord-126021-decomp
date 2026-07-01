package b.f.j.k;

import com.facebook.imagepipeline.request.ImageRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: ForwardingRequestListener.java */
/* JADX INFO: loaded from: classes.dex */
public class c implements e {
    public final List<e> a;

    public c(Set<e> set) {
        this.a = new ArrayList(set.size());
        for (e eVar : set) {
            if (eVar != null) {
                this.a.add(eVar);
            }
        }
    }

    @Override // b.f.j.k.e
    public void a(ImageRequest imageRequest, Object obj, String str, boolean z2) {
        int size = this.a.size();
        for (int i = 0; i < size; i++) {
            try {
                this.a.get(i).a(imageRequest, obj, str, z2);
            } catch (Exception e) {
                b.f.d.e.a.f("ForwardingRequestListener", "InternalListener exception in onRequestStart", e);
            }
        }
    }

    @Override // b.f.j.p.a1
    public void b(String str, String str2) {
        int size = this.a.size();
        for (int i = 0; i < size; i++) {
            try {
                this.a.get(i).b(str, str2);
            } catch (Exception e) {
                b.f.d.e.a.f("ForwardingRequestListener", "InternalListener exception in onProducerStart", e);
            }
        }
    }

    @Override // b.f.j.k.e
    public void c(ImageRequest imageRequest, String str, boolean z2) {
        int size = this.a.size();
        for (int i = 0; i < size; i++) {
            try {
                this.a.get(i).c(imageRequest, str, z2);
            } catch (Exception e) {
                b.f.d.e.a.f("ForwardingRequestListener", "InternalListener exception in onRequestSuccess", e);
            }
        }
    }

    @Override // b.f.j.p.a1
    public void d(String str, String str2, Map<String, String> map) {
        int size = this.a.size();
        for (int i = 0; i < size; i++) {
            try {
                this.a.get(i).d(str, str2, map);
            } catch (Exception e) {
                b.f.d.e.a.f("ForwardingRequestListener", "InternalListener exception in onProducerFinishWithCancellation", e);
            }
        }
    }

    @Override // b.f.j.p.a1
    public void e(String str, String str2, boolean z2) {
        int size = this.a.size();
        for (int i = 0; i < size; i++) {
            try {
                this.a.get(i).e(str, str2, z2);
            } catch (Exception e) {
                b.f.d.e.a.f("ForwardingRequestListener", "InternalListener exception in onProducerFinishWithSuccess", e);
            }
        }
    }

    @Override // b.f.j.p.a1
    public boolean f(String str) {
        int size = this.a.size();
        for (int i = 0; i < size; i++) {
            if (this.a.get(i).f(str)) {
                return true;
            }
        }
        return false;
    }

    @Override // b.f.j.k.e
    public void g(ImageRequest imageRequest, String str, Throwable th, boolean z2) {
        int size = this.a.size();
        for (int i = 0; i < size; i++) {
            try {
                this.a.get(i).g(imageRequest, str, th, z2);
            } catch (Exception e) {
                b.f.d.e.a.f("ForwardingRequestListener", "InternalListener exception in onRequestFailure", e);
            }
        }
    }

    @Override // b.f.j.p.a1
    public void h(String str, String str2, String str3) {
        int size = this.a.size();
        for (int i = 0; i < size; i++) {
            try {
                this.a.get(i).h(str, str2, str3);
            } catch (Exception e) {
                b.f.d.e.a.f("ForwardingRequestListener", "InternalListener exception in onIntermediateChunkStart", e);
            }
        }
    }

    @Override // b.f.j.p.a1
    public void i(String str, String str2, Map<String, String> map) {
        int size = this.a.size();
        for (int i = 0; i < size; i++) {
            try {
                this.a.get(i).i(str, str2, map);
            } catch (Exception e) {
                b.f.d.e.a.f("ForwardingRequestListener", "InternalListener exception in onProducerFinishWithSuccess", e);
            }
        }
    }

    @Override // b.f.j.p.a1
    public void j(String str, String str2, Throwable th, Map<String, String> map) {
        int size = this.a.size();
        for (int i = 0; i < size; i++) {
            try {
                this.a.get(i).j(str, str2, th, map);
            } catch (Exception e) {
                b.f.d.e.a.f("ForwardingRequestListener", "InternalListener exception in onProducerFinishWithFailure", e);
            }
        }
    }

    @Override // b.f.j.k.e
    public void k(String str) {
        int size = this.a.size();
        for (int i = 0; i < size; i++) {
            try {
                this.a.get(i).k(str);
            } catch (Exception e) {
                b.f.d.e.a.f("ForwardingRequestListener", "InternalListener exception in onRequestCancellation", e);
            }
        }
    }

    public c(e... eVarArr) {
        this.a = new ArrayList(eVarArr.length);
        for (e eVar : eVarArr) {
            if (eVar != null) {
                this.a.add(eVar);
            }
        }
    }
}
