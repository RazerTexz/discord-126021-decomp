package i0;

import retrofit2.Response;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: compiled from: DefaultCallAdapterFactory.java */
/* JADX INFO: loaded from: classes3.dex */
public class i$b$a<T> implements f<T> {
    public final /* synthetic */ f a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ i$b f3741b;

    public i$b$a(i$b i_b, f fVar) {
        this.f3741b = i_b;
        this.a = fVar;
    }

    @Override // i0.f
    public void a(d<T> dVar, Throwable th) {
        this.f3741b.j.execute(new a(this, this.a, th));
    }

    @Override // i0.f
    public void b(d<T> dVar, Response<T> response) {
        this.f3741b.j.execute(new b(this, this.a, response));
    }
}
