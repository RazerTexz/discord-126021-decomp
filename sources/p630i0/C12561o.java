package p630i0;

import androidx.core.app.NotificationCompat;
import kotlinx.coroutines.CancellableContinuation;
import p507d0.C12112k;
import p507d0.C12113l;
import p507d0.p592z.p594d.C12238m;
import retrofit2.Response;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: renamed from: i0.o */
/* JADX INFO: compiled from: KotlinExtensions.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C12561o<T> implements InterfaceC12527f<T> {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ CancellableContinuation f26550a;

    public C12561o(CancellableContinuation cancellableContinuation) {
        this.f26550a = cancellableContinuation;
    }

    @Override // p630i0.InterfaceC12527f
    /* JADX INFO: renamed from: a */
    public void mo10708a(InterfaceC12504d<T> interfaceC12504d, Throwable th) {
        C12238m.checkParameterIsNotNull(interfaceC12504d, NotificationCompat.CATEGORY_CALL);
        C12238m.checkParameterIsNotNull(th, "t");
        CancellableContinuation cancellableContinuation = this.f26550a;
        C12112k.a aVar = C12112k.f25169j;
        cancellableContinuation.resumeWith(C12112k.m11474constructorimpl(C12113l.createFailure(th)));
    }

    @Override // p630i0.InterfaceC12527f
    /* JADX INFO: renamed from: b */
    public void mo10709b(InterfaceC12504d<T> interfaceC12504d, Response<T> response) {
        C12238m.checkParameterIsNotNull(interfaceC12504d, NotificationCompat.CATEGORY_CALL);
        C12238m.checkParameterIsNotNull(response, "response");
        CancellableContinuation cancellableContinuation = this.f26550a;
        C12112k.a aVar = C12112k.f25169j;
        cancellableContinuation.resumeWith(C12112k.m11474constructorimpl(response));
    }
}
