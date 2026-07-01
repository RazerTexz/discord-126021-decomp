package b.i.d.q;

import java.lang.reflect.Method;

/* JADX INFO: renamed from: b.i.d.q.s, reason: use source file name */
/* JADX INFO: compiled from: UnsafeAllocator.java */
/* JADX INFO: loaded from: classes3.dex */
public class UnsafeAllocator extends UnsafeAllocator5 {
    public final /* synthetic */ Method a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f1811b;

    public UnsafeAllocator(Method method, Object obj) {
        this.a = method;
        this.f1811b = obj;
    }

    @Override // b.i.d.q.UnsafeAllocator5
    public <T> T b(Class<T> cls) throws Exception {
        UnsafeAllocator5.a(cls);
        return (T) this.a.invoke(this.f1811b, cls);
    }
}
