package com.discord.widgets.hubs;

import com.discord.api.hubs.EmailVerification;
import com.discord.api.hubs.EmailVerification3;
import d0.z.d.Lambda;
import java.util.List;
import kotlin.jvm.functions.Function0;

/* JADX INFO: renamed from: com.discord.widgets.hubs.HubEmailState$hasMultipleDomains$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetHubEmailViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetHubEmailViewModel5 extends Lambda implements Function0<Boolean> {
    public final /* synthetic */ WidgetHubEmailViewModel4 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetHubEmailViewModel5(WidgetHubEmailViewModel4 widgetHubEmailViewModel4) {
        super(0);
        this.this$0 = widgetHubEmailViewModel4;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Boolean invoke() {
        return Boolean.valueOf(invoke2());
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final boolean invoke2() {
        List<EmailVerification3> listA;
        EmailVerification emailVerificationInvoke = this.this$0.getVerifyEmailAsync().invoke();
        return (emailVerificationInvoke == null || (listA = emailVerificationInvoke.a()) == null || !(listA.isEmpty() ^ true)) ? false : true;
    }
}
