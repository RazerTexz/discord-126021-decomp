package com.discord.widgets.auth;

import com.discord.utilities.auth.GoogleSmartLockManager$SmartLockCredentials;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetAuthLandingViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetAuthLandingViewModel$2 extends o implements Function1<GoogleSmartLockManager$SmartLockCredentials, Unit> {
    public final /* synthetic */ WidgetAuthLandingViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetAuthLandingViewModel$2(WidgetAuthLandingViewModel widgetAuthLandingViewModel) {
        super(1);
        this.this$0 = widgetAuthLandingViewModel;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(GoogleSmartLockManager$SmartLockCredentials googleSmartLockManager$SmartLockCredentials) {
        invoke2(googleSmartLockManager$SmartLockCredentials);
        return Unit.a;
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(GoogleSmartLockManager$SmartLockCredentials googleSmartLockManager$SmartLockCredentials) {
        m.checkNotNullParameter(googleSmartLockManager$SmartLockCredentials, "it");
        WidgetAuthLandingViewModel.access$getEventSubject$p(this.this$0).k.onNext((T) new WidgetAuthLandingViewModel$Event$SmartLockLogin(googleSmartLockManager$SmartLockCredentials));
    }
}
