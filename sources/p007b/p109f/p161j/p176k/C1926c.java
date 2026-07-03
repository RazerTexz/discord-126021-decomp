package p007b.p109f.p161j.p176k;

import com.facebook.imagepipeline.request.ImageRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import p007b.p109f.p115d.p120e.C1691a;

/* JADX INFO: renamed from: b.f.j.k.c */
/* JADX INFO: compiled from: ForwardingRequestListener.java */
/* JADX INFO: loaded from: classes.dex */
public class C1926c implements InterfaceC1928e {

    /* JADX INFO: renamed from: a */
    public final List<InterfaceC1928e> f3913a;

    public C1926c(Set<InterfaceC1928e> set) {
        this.f3913a = new ArrayList(set.size());
        for (InterfaceC1928e interfaceC1928e : set) {
            if (interfaceC1928e != null) {
                this.f3913a.add(interfaceC1928e);
            }
        }
    }

    @Override // p007b.p109f.p161j.p176k.InterfaceC1928e
    /* JADX INFO: renamed from: a */
    public void mo1079a(ImageRequest imageRequest, Object obj, String str, boolean z2) {
        int size = this.f3913a.size();
        for (int i = 0; i < size; i++) {
            try {
                this.f3913a.get(i).mo1079a(imageRequest, obj, str, z2);
            } catch (Exception e) {
                C1691a.m978f("ForwardingRequestListener", "InternalListener exception in onRequestStart", e);
            }
        }
    }

    @Override // p007b.p109f.p161j.p181p.InterfaceC1964a1
    /* JADX INFO: renamed from: b */
    public void mo1348b(String str, String str2) {
        int size = this.f3913a.size();
        for (int i = 0; i < size; i++) {
            try {
                this.f3913a.get(i).mo1348b(str, str2);
            } catch (Exception e) {
                C1691a.m978f("ForwardingRequestListener", "InternalListener exception in onProducerStart", e);
            }
        }
    }

    @Override // p007b.p109f.p161j.p176k.InterfaceC1928e
    /* JADX INFO: renamed from: c */
    public void mo1080c(ImageRequest imageRequest, String str, boolean z2) {
        int size = this.f3913a.size();
        for (int i = 0; i < size; i++) {
            try {
                this.f3913a.get(i).mo1080c(imageRequest, str, z2);
            } catch (Exception e) {
                C1691a.m978f("ForwardingRequestListener", "InternalListener exception in onRequestSuccess", e);
            }
        }
    }

    @Override // p007b.p109f.p161j.p181p.InterfaceC1964a1
    /* JADX INFO: renamed from: d */
    public void mo1349d(String str, String str2, Map<String, String> map) {
        int size = this.f3913a.size();
        for (int i = 0; i < size; i++) {
            try {
                this.f3913a.get(i).mo1349d(str, str2, map);
            } catch (Exception e) {
                C1691a.m978f("ForwardingRequestListener", "InternalListener exception in onProducerFinishWithCancellation", e);
            }
        }
    }

    @Override // p007b.p109f.p161j.p181p.InterfaceC1964a1
    /* JADX INFO: renamed from: e */
    public void mo1062e(String str, String str2, boolean z2) {
        int size = this.f3913a.size();
        for (int i = 0; i < size; i++) {
            try {
                this.f3913a.get(i).mo1062e(str, str2, z2);
            } catch (Exception e) {
                C1691a.m978f("ForwardingRequestListener", "InternalListener exception in onProducerFinishWithSuccess", e);
            }
        }
    }

    @Override // p007b.p109f.p161j.p181p.InterfaceC1964a1
    /* JADX INFO: renamed from: f */
    public boolean mo1350f(String str) {
        int size = this.f3913a.size();
        for (int i = 0; i < size; i++) {
            if (this.f3913a.get(i).mo1350f(str)) {
                return true;
            }
        }
        return false;
    }

    @Override // p007b.p109f.p161j.p176k.InterfaceC1928e
    /* JADX INFO: renamed from: g */
    public void mo1081g(ImageRequest imageRequest, String str, Throwable th, boolean z2) {
        int size = this.f3913a.size();
        for (int i = 0; i < size; i++) {
            try {
                this.f3913a.get(i).mo1081g(imageRequest, str, th, z2);
            } catch (Exception e) {
                C1691a.m978f("ForwardingRequestListener", "InternalListener exception in onRequestFailure", e);
            }
        }
    }

    @Override // p007b.p109f.p161j.p181p.InterfaceC1964a1
    /* JADX INFO: renamed from: h */
    public void mo1351h(String str, String str2, String str3) {
        int size = this.f3913a.size();
        for (int i = 0; i < size; i++) {
            try {
                this.f3913a.get(i).mo1351h(str, str2, str3);
            } catch (Exception e) {
                C1691a.m978f("ForwardingRequestListener", "InternalListener exception in onIntermediateChunkStart", e);
            }
        }
    }

    @Override // p007b.p109f.p161j.p181p.InterfaceC1964a1
    /* JADX INFO: renamed from: i */
    public void mo1352i(String str, String str2, Map<String, String> map) {
        int size = this.f3913a.size();
        for (int i = 0; i < size; i++) {
            try {
                this.f3913a.get(i).mo1352i(str, str2, map);
            } catch (Exception e) {
                C1691a.m978f("ForwardingRequestListener", "InternalListener exception in onProducerFinishWithSuccess", e);
            }
        }
    }

    @Override // p007b.p109f.p161j.p181p.InterfaceC1964a1
    /* JADX INFO: renamed from: j */
    public void mo1353j(String str, String str2, Throwable th, Map<String, String> map) {
        int size = this.f3913a.size();
        for (int i = 0; i < size; i++) {
            try {
                this.f3913a.get(i).mo1353j(str, str2, th, map);
            } catch (Exception e) {
                C1691a.m978f("ForwardingRequestListener", "InternalListener exception in onProducerFinishWithFailure", e);
            }
        }
    }

    @Override // p007b.p109f.p161j.p176k.InterfaceC1928e
    /* JADX INFO: renamed from: k */
    public void mo1082k(String str) {
        int size = this.f3913a.size();
        for (int i = 0; i < size; i++) {
            try {
                this.f3913a.get(i).mo1082k(str);
            } catch (Exception e) {
                C1691a.m978f("ForwardingRequestListener", "InternalListener exception in onRequestCancellation", e);
            }
        }
    }

    public C1926c(InterfaceC1928e... interfaceC1928eArr) {
        this.f3913a = new ArrayList(interfaceC1928eArr.length);
        for (InterfaceC1928e interfaceC1928e : interfaceC1928eArr) {
            if (interfaceC1928e != null) {
                this.f3913a.add(interfaceC1928e);
            }
        }
    }
}
