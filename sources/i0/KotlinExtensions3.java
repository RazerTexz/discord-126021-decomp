package i0;

import androidx.core.app.NotificationCompat;
import d0.Result2;
import d0.Result3;
import d0.z.d.Intrinsics3;
import java.lang.reflect.Method;
import java.util.Objects;
import kotlin.KotlinNullPointerException;
import kotlinx.coroutines.CancellableContinuation;
import okhttp3.Request;
import retrofit2.HttpException;
import retrofit2.Response;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: renamed from: i0.m, reason: use source file name */
/* JADX INFO: compiled from: KotlinExtensions.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class KotlinExtensions3<T> implements Callback3<T> {
    public final /* synthetic */ CancellableContinuation a;

    public KotlinExtensions3(CancellableContinuation cancellableContinuation) {
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
        if (!response.a()) {
            CancellableContinuation cancellableContinuation = this.a;
            HttpException httpException = new HttpException(response);
            Result2.a aVar = Result2.j;
            cancellableContinuation.resumeWith(Result2.m97constructorimpl(Result3.createFailure(httpException)));
            return;
        }
        T t = response.f3824b;
        if (t != null) {
            CancellableContinuation cancellableContinuation2 = this.a;
            Result2.a aVar2 = Result2.j;
            cancellableContinuation2.resumeWith(Result2.m97constructorimpl(t));
            return;
        }
        Request requestC = call3.c();
        Objects.requireNonNull(requestC);
        Intrinsics3.checkParameterIsNotNull(Invocation.class, "type");
        Object objCast = Invocation.class.cast(requestC.com.discord.models.domain.ModelAuditLogEntry.CHANGE_KEY_TAGS java.lang.String.get(Invocation.class));
        if (objCast == null) {
            Intrinsics3.throwNpe();
        }
        Intrinsics3.checkExpressionValueIsNotNull(objCast, "call.request().tag(Invocation::class.java)!!");
        Method method = ((Invocation) objCast).a;
        StringBuilder sb = new StringBuilder();
        sb.append("Response from ");
        Intrinsics3.checkExpressionValueIsNotNull(method, "method");
        Class<?> declaringClass = method.getDeclaringClass();
        Intrinsics3.checkExpressionValueIsNotNull(declaringClass, "method.declaringClass");
        sb.append(declaringClass.getName());
        sb.append('.');
        sb.append(method.getName());
        sb.append(" was null but response body type was declared as non-null");
        KotlinNullPointerException kotlinNullPointerException = new KotlinNullPointerException(sb.toString());
        CancellableContinuation cancellableContinuation3 = this.a;
        Result2.a aVar3 = Result2.j;
        cancellableContinuation3.resumeWith(Result2.m97constructorimpl(Result3.createFailure(kotlinNullPointerException)));
    }
}
