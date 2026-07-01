package b.i.d.q;

import java.lang.reflect.Type;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: compiled from: ConstructorConstructor.java */
/* JADX INFO: loaded from: classes3.dex */
public class g$a<T> implements r<T> {
    public final /* synthetic */ b.i.d.f a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Type f1809b;

    public g$a(g gVar, b.i.d.f fVar, Type type) {
        this.a = fVar;
        this.f1809b = type;
    }

    @Override // b.i.d.q.r
    public T a() {
        return (T) this.a.a(this.f1809b);
    }
}
