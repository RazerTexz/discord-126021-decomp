package com.discord.widgets.hubs;

import com.discord.api.hubs.EmailVerification;
import com.discord.api.hubs.GuildInfo;
import java.util.List;
import kotlin.jvm.functions.Function0;
import p507d0.p592z.p594d.AbstractC12240o;

/* JADX INFO: compiled from: WidgetHubEmailViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class HubEmailState$hasMultipleDomains$2 extends AbstractC12240o implements Function0<Boolean> {
    public final /* synthetic */ HubEmailState this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HubEmailState$hasMultipleDomains$2(HubEmailState hubEmailState) {
        super(0);
        this.this$0 = hubEmailState;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Boolean invoke() {
        return Boolean.valueOf(invoke2());
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final boolean invoke2() {
        List<GuildInfo> listM7998a;
        EmailVerification emailVerificationInvoke = this.this$0.getVerifyEmailAsync().invoke();
        return (emailVerificationInvoke == null || (listM7998a = emailVerificationInvoke.m7998a()) == null || !(listM7998a.isEmpty() ^ true)) ? false : true;
    }
}
