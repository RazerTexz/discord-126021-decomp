package p630i0;

import androidx.core.app.NotificationCompat;
import java.lang.reflect.Method;
import java.util.Objects;
import kotlin.KotlinNullPointerException;
import kotlinx.coroutines.CancellableContinuation;
import okhttp3.Request;
import p507d0.C12112k;
import p507d0.C12113l;
import p507d0.p592z.p594d.C12238m;
import retrofit2.HttpException;
import retrofit2.Response;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: renamed from: i0.m */
/* JADX INFO: compiled from: KotlinExtensions.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C12559m<T> implements InterfaceC12527f<T> {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ CancellableContinuation f26549a;

    public C12559m(CancellableContinuation cancellableContinuation) {
        this.f26549a = cancellableContinuation;
    }

    @Override // p630i0.InterfaceC12527f
    /* JADX INFO: renamed from: a */
    public void mo10708a(InterfaceC12504d<T> interfaceC12504d, Throwable th) {
        C12238m.checkParameterIsNotNull(interfaceC12504d, NotificationCompat.CATEGORY_CALL);
        C12238m.checkParameterIsNotNull(th, "t");
        CancellableContinuation cancellableContinuation = this.f26549a;
        C12112k.a aVar = C12112k.f25169j;
        cancellableContinuation.resumeWith(C12112k.m11474constructorimpl(C12113l.createFailure(th)));
    }

    @Override // p630i0.InterfaceC12527f
    /* JADX INFO: renamed from: b */
    public void mo10709b(InterfaceC12504d<T> interfaceC12504d, Response<T> response) {
        C12238m.checkParameterIsNotNull(interfaceC12504d, NotificationCompat.CATEGORY_CALL);
        C12238m.checkParameterIsNotNull(response, "response");
        if (!response.m11057a()) {
            CancellableContinuation cancellableContinuation = this.f26549a;
            HttpException httpException = new HttpException(response);
            C12112k.a aVar = C12112k.f25169j;
            cancellableContinuation.resumeWith(C12112k.m11474constructorimpl(C12113l.createFailure(httpException)));
            return;
        }
        T t = response.f27632b;
        if (t != null) {
            CancellableContinuation cancellableContinuation2 = this.f26549a;
            C12112k.a aVar2 = C12112k.f25169j;
            cancellableContinuation2.resumeWith(C12112k.m11474constructorimpl(t));
            return;
        }
        Request requestMo10699c = interfaceC12504d.mo10699c();
        Objects.requireNonNull(requestMo10699c);
        C12238m.checkParameterIsNotNull(C12557k.class, "type");
        Object objCast = C12557k.class.cast(requestMo10699c.com.discord.models.domain.ModelAuditLogEntry.CHANGE_KEY_TAGS java.lang.String.get(C12557k.class));
        if (objCast == null) {
            C12238m.throwNpe();
        }
        C12238m.checkExpressionValueIsNotNull(objCast, "call.request().tag(Invocation::class.java)!!");
        Method method = ((C12557k) objCast).f26547a;
        StringBuilder sb = new StringBuilder();
        sb.append("Response from ");
        C12238m.checkExpressionValueIsNotNull(method, "method");
        Class<?> declaringClass = method.getDeclaringClass();
        C12238m.checkExpressionValueIsNotNull(declaringClass, "method.declaringClass");
        sb.append(declaringClass.getName());
        sb.append('.');
        sb.append(method.getName());
        sb.append(" was null but response body type was declared as non-null");
        KotlinNullPointerException kotlinNullPointerException = new KotlinNullPointerException(sb.toString());
        CancellableContinuation cancellableContinuation3 = this.f26549a;
        C12112k.a aVar3 = C12112k.f25169j;
        cancellableContinuation3.resumeWith(C12112k.m11474constructorimpl(C12113l.createFailure(kotlinNullPointerException)));
    }
}
