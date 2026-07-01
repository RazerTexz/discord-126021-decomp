package i0;

import androidx.core.app.NotificationCompat;
import d0.k$a;
import java.lang.reflect.Method;
import java.util.Objects;
import kotlin.KotlinNullPointerException;
import kotlinx.coroutines.CancellableContinuation;
import okhttp3.Request;
import retrofit2.HttpException;
import retrofit2.Response;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: compiled from: KotlinExtensions.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class m<T> implements f<T> {
    public final /* synthetic */ CancellableContinuation a;

    public m(CancellableContinuation cancellableContinuation) {
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
        if (!response.a()) {
            CancellableContinuation cancellableContinuation = this.a;
            HttpException httpException = new HttpException(response);
            k$a k_a = d0.k.j;
            cancellableContinuation.resumeWith(d0.k.m97constructorimpl(d0.l.createFailure(httpException)));
            return;
        }
        T t = response.f3824b;
        if (t != null) {
            CancellableContinuation cancellableContinuation2 = this.a;
            k$a k_a2 = d0.k.j;
            cancellableContinuation2.resumeWith(d0.k.m97constructorimpl(t));
            return;
        }
        Request requestC = dVar.c();
        Objects.requireNonNull(requestC);
        d0.z.d.m.checkParameterIsNotNull(k.class, "type");
        Object objCast = k.class.cast(requestC.com.discord.models.domain.ModelAuditLogEntry.CHANGE_KEY_TAGS java.lang.String.get(k.class));
        if (objCast == null) {
            d0.z.d.m.throwNpe();
        }
        d0.z.d.m.checkExpressionValueIsNotNull(objCast, "call.request().tag(Invocation::class.java)!!");
        Method method = ((k) objCast).a;
        StringBuilder sb = new StringBuilder();
        sb.append("Response from ");
        d0.z.d.m.checkExpressionValueIsNotNull(method, "method");
        Class<?> declaringClass = method.getDeclaringClass();
        d0.z.d.m.checkExpressionValueIsNotNull(declaringClass, "method.declaringClass");
        sb.append(declaringClass.getName());
        sb.append('.');
        sb.append(method.getName());
        sb.append(" was null but response body type was declared as non-null");
        KotlinNullPointerException kotlinNullPointerException = new KotlinNullPointerException(sb.toString());
        CancellableContinuation cancellableContinuation3 = this.a;
        k$a k_a3 = d0.k.j;
        cancellableContinuation3.resumeWith(d0.k.m97constructorimpl(d0.l.createFailure(kotlinNullPointerException)));
    }
}
