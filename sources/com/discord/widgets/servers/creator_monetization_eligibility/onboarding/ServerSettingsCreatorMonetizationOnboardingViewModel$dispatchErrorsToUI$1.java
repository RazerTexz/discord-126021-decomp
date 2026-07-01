package com.discord.widgets.servers.creator_monetization_eligibility.onboarding;

import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import d0.z.d.m;
import rx.functions.Action1;
import rx.subjects.PublishSubject;

/* JADX INFO: compiled from: ServerSettingsCreatorMonetizationOnboardingViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ServerSettingsCreatorMonetizationOnboardingViewModel$dispatchErrorsToUI$1<T> implements Action1<Throwable> {
    public final /* synthetic */ ServerSettingsCreatorMonetizationOnboardingViewModel this$0;

    public ServerSettingsCreatorMonetizationOnboardingViewModel$dispatchErrorsToUI$1(ServerSettingsCreatorMonetizationOnboardingViewModel serverSettingsCreatorMonetizationOnboardingViewModel) {
        this.this$0 = serverSettingsCreatorMonetizationOnboardingViewModel;
    }

    @Override // rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(Throwable th) {
        call2(th);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final void call2(Throwable th) {
        PublishSubject publishSubjectAccess$getEventSubject$p = ServerSettingsCreatorMonetizationOnboardingViewModel.access$getEventSubject$p(this.this$0);
        m.checkNotNullExpressionValue(th, "e");
        publishSubjectAccess$getEventSubject$p.k.onNext(new ServerSettingsCreatorMonetizationOnboardingViewModel$Event$ShowErrorToast(th));
    }
}
