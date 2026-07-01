package b.f.j.k;

import b.f.d.e.FLog;
import com.facebook.imagepipeline.request.ImageRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: renamed from: b.f.j.k.c, reason: use source file name */
/* JADX INFO: compiled from: ForwardingRequestListener.java */
/* JADX INFO: loaded from: classes.dex */
public class ForwardingRequestListener implements RequestListener {
    public final List<RequestListener> a;

    public ForwardingRequestListener(Set<RequestListener> set) {
        this.a = new ArrayList(set.size());
        for (RequestListener requestListener : set) {
            if (requestListener != null) {
                this.a.add(requestListener);
            }
        }
    }

    @Override // b.f.j.k.RequestListener
    public void a(ImageRequest imageRequest, Object obj, String str, boolean z2) {
        int size = this.a.size();
        for (int i = 0; i < size; i++) {
            try {
                this.a.get(i).a(imageRequest, obj, str, z2);
            } catch (Exception e) {
                FLog.f("ForwardingRequestListener", "InternalListener exception in onRequestStart", e);
            }
        }
    }

    @Override // b.f.j.p.ProducerListener
    public void b(String str, String str2) {
        int size = this.a.size();
        for (int i = 0; i < size; i++) {
            try {
                this.a.get(i).b(str, str2);
            } catch (Exception e) {
                FLog.f("ForwardingRequestListener", "InternalListener exception in onProducerStart", e);
            }
        }
    }

    @Override // b.f.j.k.RequestListener
    public void c(ImageRequest imageRequest, String str, boolean z2) {
        int size = this.a.size();
        for (int i = 0; i < size; i++) {
            try {
                this.a.get(i).c(imageRequest, str, z2);
            } catch (Exception e) {
                FLog.f("ForwardingRequestListener", "InternalListener exception in onRequestSuccess", e);
            }
        }
    }

    @Override // b.f.j.p.ProducerListener
    public void d(String str, String str2, Map<String, String> map) {
        int size = this.a.size();
        for (int i = 0; i < size; i++) {
            try {
                this.a.get(i).d(str, str2, map);
            } catch (Exception e) {
                FLog.f("ForwardingRequestListener", "InternalListener exception in onProducerFinishWithCancellation", e);
            }
        }
    }

    @Override // b.f.j.p.ProducerListener
    public void e(String str, String str2, boolean z2) {
        int size = this.a.size();
        for (int i = 0; i < size; i++) {
            try {
                this.a.get(i).e(str, str2, z2);
            } catch (Exception e) {
                FLog.f("ForwardingRequestListener", "InternalListener exception in onProducerFinishWithSuccess", e);
            }
        }
    }

    @Override // b.f.j.p.ProducerListener
    public boolean f(String str) {
        int size = this.a.size();
        for (int i = 0; i < size; i++) {
            if (this.a.get(i).f(str)) {
                return true;
            }
        }
        return false;
    }

    @Override // b.f.j.k.RequestListener
    public void g(ImageRequest imageRequest, String str, Throwable th, boolean z2) {
        int size = this.a.size();
        for (int i = 0; i < size; i++) {
            try {
                this.a.get(i).g(imageRequest, str, th, z2);
            } catch (Exception e) {
                FLog.f("ForwardingRequestListener", "InternalListener exception in onRequestFailure", e);
            }
        }
    }

    @Override // b.f.j.p.ProducerListener
    public void h(String str, String str2, String str3) {
        int size = this.a.size();
        for (int i = 0; i < size; i++) {
            try {
                this.a.get(i).h(str, str2, str3);
            } catch (Exception e) {
                FLog.f("ForwardingRequestListener", "InternalListener exception in onIntermediateChunkStart", e);
            }
        }
    }

    @Override // b.f.j.p.ProducerListener
    public void i(String str, String str2, Map<String, String> map) {
        int size = this.a.size();
        for (int i = 0; i < size; i++) {
            try {
                this.a.get(i).i(str, str2, map);
            } catch (Exception e) {
                FLog.f("ForwardingRequestListener", "InternalListener exception in onProducerFinishWithSuccess", e);
            }
        }
    }

    @Override // b.f.j.p.ProducerListener
    public void j(String str, String str2, Throwable th, Map<String, String> map) {
        int size = this.a.size();
        for (int i = 0; i < size; i++) {
            try {
                this.a.get(i).j(str, str2, th, map);
            } catch (Exception e) {
                FLog.f("ForwardingRequestListener", "InternalListener exception in onProducerFinishWithFailure", e);
            }
        }
    }

    @Override // b.f.j.k.RequestListener
    public void k(String str) {
        int size = this.a.size();
        for (int i = 0; i < size; i++) {
            try {
                this.a.get(i).k(str);
            } catch (Exception e) {
                FLog.f("ForwardingRequestListener", "InternalListener exception in onRequestCancellation", e);
            }
        }
    }

    public ForwardingRequestListener(RequestListener... requestListenerArr) {
        this.a = new ArrayList(requestListenerArr.length);
        for (RequestListener requestListener : requestListenerArr) {
            if (requestListener != null) {
                this.a.add(requestListener);
            }
        }
    }
}
