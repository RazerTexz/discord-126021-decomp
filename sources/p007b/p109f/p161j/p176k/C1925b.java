package p007b.p109f.p161j.p176k;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import p007b.p109f.p115d.p120e.C1691a;
import p007b.p109f.p161j.p181p.InterfaceC2020x0;

/* JADX INFO: renamed from: b.f.j.k.b */
/* JADX INFO: compiled from: ForwardingRequestListener2.java */
/* JADX INFO: loaded from: classes.dex */
public class C1925b implements InterfaceC1927d {

    /* JADX INFO: renamed from: a */
    public final List<InterfaceC1927d> f3912a;

    public C1925b(Set<InterfaceC1927d> set) {
        this.f3912a = new ArrayList(set.size());
        for (InterfaceC1927d interfaceC1927d : set) {
            if (interfaceC1927d != null) {
                this.f3912a.add(interfaceC1927d);
            }
        }
    }

    @Override // p007b.p109f.p161j.p181p.InterfaceC2024z0
    /* JADX INFO: renamed from: a */
    public void mo1354a(InterfaceC2020x0 interfaceC2020x0, String str, String str2) {
        int size = this.f3912a.size();
        for (int i = 0; i < size; i++) {
            try {
                this.f3912a.get(i).mo1354a(interfaceC2020x0, str, str2);
            } catch (Exception e) {
                C1691a.m978f("ForwardingRequestListener2", "InternalListener exception in onIntermediateChunkStart", e);
            }
        }
    }

    @Override // p007b.p109f.p161j.p176k.InterfaceC1927d
    /* JADX INFO: renamed from: b */
    public void mo1355b(InterfaceC2020x0 interfaceC2020x0) {
        int size = this.f3912a.size();
        for (int i = 0; i < size; i++) {
            try {
                this.f3912a.get(i).mo1355b(interfaceC2020x0);
            } catch (Exception e) {
                C1691a.m978f("ForwardingRequestListener2", "InternalListener exception in onRequestStart", e);
            }
        }
    }

    @Override // p007b.p109f.p161j.p181p.InterfaceC2024z0
    /* JADX INFO: renamed from: c */
    public void mo1356c(InterfaceC2020x0 interfaceC2020x0, String str, boolean z2) {
        int size = this.f3912a.size();
        for (int i = 0; i < size; i++) {
            try {
                this.f3912a.get(i).mo1356c(interfaceC2020x0, str, z2);
            } catch (Exception e) {
                C1691a.m978f("ForwardingRequestListener2", "InternalListener exception in onProducerFinishWithSuccess", e);
            }
        }
    }

    @Override // p007b.p109f.p161j.p181p.InterfaceC2024z0
    /* JADX INFO: renamed from: d */
    public void mo1357d(InterfaceC2020x0 interfaceC2020x0, String str, Map<String, String> map) {
        int size = this.f3912a.size();
        for (int i = 0; i < size; i++) {
            try {
                this.f3912a.get(i).mo1357d(interfaceC2020x0, str, map);
            } catch (Exception e) {
                C1691a.m978f("ForwardingRequestListener2", "InternalListener exception in onProducerFinishWithCancellation", e);
            }
        }
    }

    @Override // p007b.p109f.p161j.p181p.InterfaceC2024z0
    /* JADX INFO: renamed from: e */
    public void mo1358e(InterfaceC2020x0 interfaceC2020x0, String str) {
        int size = this.f3912a.size();
        for (int i = 0; i < size; i++) {
            try {
                this.f3912a.get(i).mo1358e(interfaceC2020x0, str);
            } catch (Exception e) {
                C1691a.m978f("ForwardingRequestListener2", "InternalListener exception in onProducerStart", e);
            }
        }
    }

    @Override // p007b.p109f.p161j.p176k.InterfaceC1927d
    /* JADX INFO: renamed from: f */
    public void mo1359f(InterfaceC2020x0 interfaceC2020x0) {
        int size = this.f3912a.size();
        for (int i = 0; i < size; i++) {
            try {
                this.f3912a.get(i).mo1359f(interfaceC2020x0);
            } catch (Exception e) {
                C1691a.m978f("ForwardingRequestListener2", "InternalListener exception in onRequestSuccess", e);
            }
        }
    }

    @Override // p007b.p109f.p161j.p181p.InterfaceC2024z0
    /* JADX INFO: renamed from: g */
    public boolean mo1360g(InterfaceC2020x0 interfaceC2020x0, String str) {
        int size = this.f3912a.size();
        for (int i = 0; i < size; i++) {
            if (this.f3912a.get(i).mo1360g(interfaceC2020x0, str)) {
                return true;
            }
        }
        return false;
    }

    @Override // p007b.p109f.p161j.p176k.InterfaceC1927d
    /* JADX INFO: renamed from: h */
    public void mo1361h(InterfaceC2020x0 interfaceC2020x0, Throwable th) {
        int size = this.f3912a.size();
        for (int i = 0; i < size; i++) {
            try {
                this.f3912a.get(i).mo1361h(interfaceC2020x0, th);
            } catch (Exception e) {
                C1691a.m978f("ForwardingRequestListener2", "InternalListener exception in onRequestFailure", e);
            }
        }
    }

    @Override // p007b.p109f.p161j.p176k.InterfaceC1927d
    /* JADX INFO: renamed from: i */
    public void mo1362i(InterfaceC2020x0 interfaceC2020x0) {
        int size = this.f3912a.size();
        for (int i = 0; i < size; i++) {
            try {
                this.f3912a.get(i).mo1362i(interfaceC2020x0);
            } catch (Exception e) {
                C1691a.m978f("ForwardingRequestListener2", "InternalListener exception in onRequestCancellation", e);
            }
        }
    }

    @Override // p007b.p109f.p161j.p181p.InterfaceC2024z0
    /* JADX INFO: renamed from: j */
    public void mo1363j(InterfaceC2020x0 interfaceC2020x0, String str, Map<String, String> map) {
        int size = this.f3912a.size();
        for (int i = 0; i < size; i++) {
            try {
                this.f3912a.get(i).mo1363j(interfaceC2020x0, str, map);
            } catch (Exception e) {
                C1691a.m978f("ForwardingRequestListener2", "InternalListener exception in onProducerFinishWithSuccess", e);
            }
        }
    }

    @Override // p007b.p109f.p161j.p181p.InterfaceC2024z0
    /* JADX INFO: renamed from: k */
    public void mo1364k(InterfaceC2020x0 interfaceC2020x0, String str, Throwable th, Map<String, String> map) {
        int size = this.f3912a.size();
        for (int i = 0; i < size; i++) {
            try {
                this.f3912a.get(i).mo1364k(interfaceC2020x0, str, th, map);
            } catch (Exception e) {
                C1691a.m978f("ForwardingRequestListener2", "InternalListener exception in onProducerFinishWithFailure", e);
            }
        }
    }
}
