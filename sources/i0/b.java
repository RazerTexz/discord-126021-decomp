package i0;

import java.io.IOException;
import retrofit2.Response;

/* JADX INFO: compiled from: lambda */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class b implements Runnable {
    public final /* synthetic */ i$b$a j;
    public final /* synthetic */ f k;
    public final /* synthetic */ Response l;

    public /* synthetic */ b(i$b$a i_b_a, f fVar, Response response) {
        this.j = i_b_a;
        this.k = fVar;
        this.l = response;
    }

    @Override // java.lang.Runnable
    public final void run() {
        i$b$a i_b_a = this.j;
        f fVar = this.k;
        Response response = this.l;
        if (i_b_a.f3741b.k.d()) {
            fVar.a(i_b_a.f3741b, new IOException("Canceled"));
        } else {
            fVar.b(i_b_a.f3741b, response);
        }
    }
}
