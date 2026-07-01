package com.discord.widgets.servers.community;

import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetServerSettingsEnableCommunitySteps.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsEnableCommunitySteps$onViewBoundOrOnResume$2 extends o implements Function1<WidgetServerSettingsEnableCommunityViewModel$ViewState$Loaded, Unit> {
    public final /* synthetic */ WidgetServerSettingsEnableCommunitySteps this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetServerSettingsEnableCommunitySteps$onViewBoundOrOnResume$2(WidgetServerSettingsEnableCommunitySteps widgetServerSettingsEnableCommunitySteps) {
        super(1);
        this.this$0 = widgetServerSettingsEnableCommunitySteps;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(WidgetServerSettingsEnableCommunityViewModel$ViewState$Loaded widgetServerSettingsEnableCommunityViewModel$ViewState$Loaded) {
        invoke2(widgetServerSettingsEnableCommunityViewModel$ViewState$Loaded);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(WidgetServerSettingsEnableCommunityViewModel$ViewState$Loaded widgetServerSettingsEnableCommunityViewModel$ViewState$Loaded) {
        m.checkNotNullParameter(widgetServerSettingsEnableCommunityViewModel$ViewState$Loaded, "it");
        int currentPage = widgetServerSettingsEnableCommunityViewModel$ViewState$Loaded.getCurrentPage();
        if (currentPage < 0) {
            this.this$0.requireActivity().finish();
        } else {
            WidgetServerSettingsEnableCommunitySteps.access$getBinding$p(this.this$0).f2378b.b(currentPage);
        }
        WidgetServerSettingsEnableCommunitySteps.access$getBinding$p(this.this$0).f2378b.setIsNextButtonEnabled(widgetServerSettingsEnableCommunityViewModel$ViewState$Loaded.getCommunityGuildConfig().getExplicitContentFilter() && widgetServerSettingsEnableCommunityViewModel$ViewState$Loaded.getCommunityGuildConfig().getVerificationLevel());
        WidgetServerSettingsEnableCommunitySteps.access$getBinding$p(this.this$0).f2378b.setIsDoneButtonEnabled(widgetServerSettingsEnableCommunityViewModel$ViewState$Loaded.getCommunityGuildConfig().isPrivacyPolicyAccepted());
        WidgetServerSettingsEnableCommunitySteps.access$getBinding$p(this.this$0).f2378b.setIsLoading(widgetServerSettingsEnableCommunityViewModel$ViewState$Loaded.isLoading());
    }
}
