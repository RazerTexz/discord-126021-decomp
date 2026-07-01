package b.i.d.q;

import java.lang.reflect.Method;

/* JADX INFO: compiled from: UnsafeAllocator.java */
/* JADX INFO: loaded from: classes3.dex */
public class t extends w {
    public final /* synthetic */ Method a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f1812b;

    public t(Method method, int i) {
        this.a = method;
        this.f1812b = i;
    }

    @Override // b.i.d.q.w
    public <T> T b(Class<T> cls) throws Exception {
        w.a(cls);
        return (T) this.a.invoke(null, cls, Integer.valueOf(this.f1812b));
    }
}
