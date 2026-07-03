package p007b.p225i.p408d.p410q;

import java.lang.reflect.Method;

/* JADX INFO: renamed from: b.i.d.q.u */
/* JADX INFO: compiled from: UnsafeAllocator.java */
/* JADX INFO: loaded from: classes3.dex */
public class C4936u extends AbstractC4938w {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ Method f13129a;

    public C4936u(Method method) {
        this.f13129a = method;
    }

    @Override // p007b.p225i.p408d.p410q.AbstractC4938w
    /* JADX INFO: renamed from: b */
    public <T> T mo6871b(Class<T> cls) throws Exception {
        AbstractC4938w.m6872a(cls);
        return (T) this.f13129a.invoke(null, cls, Object.class);
    }
}
