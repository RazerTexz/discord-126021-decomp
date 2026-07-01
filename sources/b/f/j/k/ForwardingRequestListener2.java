package b.f.j.k;

import b.f.d.e.FLog;
import b.f.j.p.ProducerContext;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: renamed from: b.f.j.k.b, reason: use source file name */
/* JADX INFO: compiled from: ForwardingRequestListener2.java */
/* JADX INFO: loaded from: classes.dex */
public class ForwardingRequestListener2 implements RequestListener2 {
    public final List<RequestListener2> a;

    public ForwardingRequestListener2(Set<RequestListener2> set) {
        this.a = new ArrayList(set.size());
        for (RequestListener2 requestListener2 : set) {
            if (requestListener2 != null) {
                this.a.add(requestListener2);
            }
        }
    }

    @Override // b.f.j.p.ProducerListener2
    public void a(ProducerContext producerContext, String str, String str2) {
        int size = this.a.size();
        for (int i = 0; i < size; i++) {
            try {
                this.a.get(i).a(producerContext, str, str2);
            } catch (Exception e) {
                FLog.f("ForwardingRequestListener2", "InternalListener exception in onIntermediateChunkStart", e);
            }
        }
    }

    @Override // b.f.j.k.RequestListener2
    public void b(ProducerContext producerContext) {
        int size = this.a.size();
        for (int i = 0; i < size; i++) {
            try {
                this.a.get(i).b(producerContext);
            } catch (Exception e) {
                FLog.f("ForwardingRequestListener2", "InternalListener exception in onRequestStart", e);
            }
        }
    }

    @Override // b.f.j.p.ProducerListener2
    public void c(ProducerContext producerContext, String str, boolean z2) {
        int size = this.a.size();
        for (int i = 0; i < size; i++) {
            try {
                this.a.get(i).c(producerContext, str, z2);
            } catch (Exception e) {
                FLog.f("ForwardingRequestListener2", "InternalListener exception in onProducerFinishWithSuccess", e);
            }
        }
    }

    @Override // b.f.j.p.ProducerListener2
    public void d(ProducerContext producerContext, String str, Map<String, String> map) {
        int size = this.a.size();
        for (int i = 0; i < size; i++) {
            try {
                this.a.get(i).d(producerContext, str, map);
            } catch (Exception e) {
                FLog.f("ForwardingRequestListener2", "InternalListener exception in onProducerFinishWithCancellation", e);
            }
        }
    }

    @Override // b.f.j.p.ProducerListener2
    public void e(ProducerContext producerContext, String str) {
        int size = this.a.size();
        for (int i = 0; i < size; i++) {
            try {
                this.a.get(i).e(producerContext, str);
            } catch (Exception e) {
                FLog.f("ForwardingRequestListener2", "InternalListener exception in onProducerStart", e);
            }
        }
    }

    @Override // b.f.j.k.RequestListener2
    public void f(ProducerContext producerContext) {
        int size = this.a.size();
        for (int i = 0; i < size; i++) {
            try {
                this.a.get(i).f(producerContext);
            } catch (Exception e) {
                FLog.f("ForwardingRequestListener2", "InternalListener exception in onRequestSuccess", e);
            }
        }
    }

    @Override // b.f.j.p.ProducerListener2
    public boolean g(ProducerContext producerContext, String str) {
        int size = this.a.size();
        for (int i = 0; i < size; i++) {
            if (this.a.get(i).g(producerContext, str)) {
                return true;
            }
        }
        return false;
    }

    @Override // b.f.j.k.RequestListener2
    public void h(ProducerContext producerContext, Throwable th) {
        int size = this.a.size();
        for (int i = 0; i < size; i++) {
            try {
                this.a.get(i).h(producerContext, th);
            } catch (Exception e) {
                FLog.f("ForwardingRequestListener2", "InternalListener exception in onRequestFailure", e);
            }
        }
    }

    @Override // b.f.j.k.RequestListener2
    public void i(ProducerContext producerContext) {
        int size = this.a.size();
        for (int i = 0; i < size; i++) {
            try {
                this.a.get(i).i(producerContext);
            } catch (Exception e) {
                FLog.f("ForwardingRequestListener2", "InternalListener exception in onRequestCancellation", e);
            }
        }
    }

    @Override // b.f.j.p.ProducerListener2
    public void j(ProducerContext producerContext, String str, Map<String, String> map) {
        int size = this.a.size();
        for (int i = 0; i < size; i++) {
            try {
                this.a.get(i).j(producerContext, str, map);
            } catch (Exception e) {
                FLog.f("ForwardingRequestListener2", "InternalListener exception in onProducerFinishWithSuccess", e);
            }
        }
    }

    @Override // b.f.j.p.ProducerListener2
    public void k(ProducerContext producerContext, String str, Throwable th, Map<String, String> map) {
        int size = this.a.size();
        for (int i = 0; i < size; i++) {
            try {
                this.a.get(i).k(producerContext, str, th, map);
            } catch (Exception e) {
                FLog.f("ForwardingRequestListener2", "InternalListener exception in onProducerFinishWithFailure", e);
            }
        }
    }
}
