package com.discord.utilities.analytics;

import android.app.Application;
import com.adjust.sdk.Adjust;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: AdjustConfig.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class AdjustConfig$init$3 extends o implements Function1<String, Unit> {
    public final /* synthetic */ Application $application;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AdjustConfig$init$3(Application application) {
        super(1);
        this.$application = application;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(String str) {
        invoke2(str);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(String str) {
        m.checkNotNullParameter(str, "referrerUrl");
        Adjust.setReferrer(str, this.$application);
        AnalyticSuperProperties.INSTANCE.setCampaignProperties(str);
    }
}
