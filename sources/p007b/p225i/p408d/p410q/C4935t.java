package p007b.p225i.p408d.p410q;

import java.lang.reflect.Method;

/* JADX INFO: renamed from: b.i.d.q.t */
/* JADX INFO: compiled from: UnsafeAllocator.java */
/* JADX INFO: loaded from: classes3.dex */
public class C4935t extends AbstractC4938w {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ Method f13127a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ int f13128b;

    public C4935t(Method method, int i) {
        this.f13127a = method;
        this.f13128b = i;
    }

    @Override // p007b.p225i.p408d.p410q.AbstractC4938w
    /* JADX INFO: renamed from: b */
    public <T> T mo6871b(Class<T> cls) throws Exception {
        AbstractC4938w.m6872a(cls);
        return (T) this.f13127a.invoke(null, cls, Integer.valueOf(this.f13128b));
    }
}
