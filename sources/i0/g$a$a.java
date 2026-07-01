package i0;

import java.util.concurrent.CompletableFuture;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;
import retrofit2.HttpException;
import retrofit2.Response;

/* JADX INFO: Add missing generic type declarations: [R] */
/* JADX INFO: compiled from: CompletableFutureCallAdapterFactory.java */
/* JADX INFO: loaded from: classes3.dex */
@IgnoreJRERequirement
public class g$a$a<R> implements f<R> {
    public final CompletableFuture<R> a;

    public g$a$a(g$a g_a, CompletableFuture<R> completableFuture) {
        this.a = completableFuture;
    }

    @Override // i0.f
    public void a(d<R> dVar, Throwable th) {
        this.a.completeExceptionally(th);
    }

    @Override // i0.f
    public void b(d<R> dVar, Response<R> response) {
        if (response.a()) {
            this.a.complete(response.f3824b);
        } else {
            this.a.completeExceptionally(new HttpException(response));
        }
    }
}
