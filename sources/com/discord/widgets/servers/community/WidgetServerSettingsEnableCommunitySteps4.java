package com.discord.widgets.servers.community;

import android.view.View;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: com.discord.widgets.servers.community.WidgetServerSettingsEnableCommunitySteps$onViewBound$steps$1, reason: use source file name */
/* JADX INFO: compiled from: WidgetServerSettingsEnableCommunitySteps.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsEnableCommunitySteps4 extends Lambda implements Function1<View, Unit> {
    public final /* synthetic */ WidgetServerSettingsEnableCommunitySteps this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetServerSettingsEnableCommunitySteps4(WidgetServerSettingsEnableCommunitySteps widgetServerSettingsEnableCommunitySteps) {
        super(1);
        this.this$0 = widgetServerSettingsEnableCommunitySteps;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(View view) {
        invoke2(view);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "it");
        this.this$0.getViewModel().updateGuild();
    }
}
