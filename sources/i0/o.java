package i0;

import androidx.core.app.NotificationCompat;
import d0.k$a;
import kotlinx.coroutines.CancellableContinuation;
import retrofit2.Response;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: compiled from: KotlinExtensions.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class o<T> implements f<T> {
    public final /* synthetic */ CancellableContinuation a;

    public o(CancellableContinuation cancellableContinuation) {
        this.a = cancellableContinuation;
    }

    @Override // i0.f
    public void a(d<T> dVar, Throwable th) {
        d0.z.d.m.checkParameterIsNotNull(dVar, NotificationCompat.CATEGORY_CALL);
        d0.z.d.m.checkParameterIsNotNull(th, "t");
        CancellableContinuation cancellableContinuation = this.a;
        k$a k_a = d0.k.j;
        cancellableContinuation.resumeWith(d0.k.m97constructorimpl(d0.l.createFailure(th)));
    }

    @Override // i0.f
    public void b(d<T> dVar, Response<T> response) {
        d0.z.d.m.checkParameterIsNotNull(dVar, NotificationCompat.CATEGORY_CALL);
        d0.z.d.m.checkParameterIsNotNull(response, "response");
        CancellableContinuation cancellableContinuation = this.a;
        k$a k_a = d0.k.j;
        cancellableContinuation.resumeWith(d0.k.m97constructorimpl(response));
    }
}
