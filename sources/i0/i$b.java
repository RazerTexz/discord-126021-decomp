package i0;

import java.io.IOException;
import java.util.concurrent.Executor;
import okhttp3.Request;
import retrofit2.Response;

/* JADX INFO: compiled from: DefaultCallAdapterFactory.java */
/* JADX INFO: loaded from: classes3.dex */
public final class i$b<T> implements d<T> {
    public final Executor j;
    public final d<T> k;

    public i$b(Executor executor, d<T> dVar) {
        this.j = executor;
        this.k = dVar;
    }

    @Override // i0.d
    public void C(f<T> fVar) {
        this.k.C(new i$b$a(this, fVar));
    }

    @Override // i0.d
    public d<T> L() {
        return new i$b(this.j, this.k.L());
    }

    @Override // i0.d
    public Request c() {
        return this.k.c();
    }

    @Override // i0.d
    public void cancel() {
        this.k.cancel();
    }

    public /* bridge */ /* synthetic */ Object clone() throws CloneNotSupportedException {
        return L();
    }

    @Override // i0.d
    public boolean d() {
        return this.k.d();
    }

    @Override // i0.d
    public Response<T> execute() throws IOException {
        return this.k.execute();
    }
}
