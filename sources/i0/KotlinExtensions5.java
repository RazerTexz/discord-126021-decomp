package i0;

import androidx.core.app.NotificationCompat;
import d0.Result2;
import d0.Result3;
import d0.z.d.Intrinsics3;
import kotlinx.coroutines.CancellableContinuation;
import retrofit2.Response;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: renamed from: i0.o, reason: use source file name */
/* JADX INFO: compiled from: KotlinExtensions.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class KotlinExtensions5<T> implements Callback3<T> {
    public final /* synthetic */ CancellableContinuation a;

    public KotlinExtensions5(CancellableContinuation cancellableContinuation) {
        this.a = cancellableContinuation;
    }

    @Override // i0.Callback3
    public void a(Call3<T> call3, Throwable th) {
        Intrinsics3.checkParameterIsNotNull(call3, NotificationCompat.CATEGORY_CALL);
        Intrinsics3.checkParameterIsNotNull(th, "t");
        CancellableContinuation cancellableContinuation = this.a;
        Result2.a aVar = Result2.j;
        cancellableContinuation.resumeWith(Result2.m97constructorimpl(Result3.createFailure(th)));
    }

    @Override // i0.Callback3
    public void b(Call3<T> call3, Response<T> response) {
        Intrinsics3.checkParameterIsNotNull(call3, NotificationCompat.CATEGORY_CALL);
        Intrinsics3.checkParameterIsNotNull(response, "response");
        CancellableContinuation cancellableContinuation = this.a;
        Result2.a aVar = Result2.j;
        cancellableContinuation.resumeWith(Result2.m97constructorimpl(response));
    }
}
