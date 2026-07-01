package com.discord.widgets.servers.community;

import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetServerSettingsEnableCommunityViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsEnableCommunityViewModel$patchRole$2 extends o implements Function1<Void, Unit> {
    public final /* synthetic */ WidgetServerSettingsEnableCommunityViewModel$ViewState$Loaded $currentViewState;
    public final /* synthetic */ WidgetServerSettingsEnableCommunityViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetServerSettingsEnableCommunityViewModel$patchRole$2(WidgetServerSettingsEnableCommunityViewModel widgetServerSettingsEnableCommunityViewModel, WidgetServerSettingsEnableCommunityViewModel$ViewState$Loaded widgetServerSettingsEnableCommunityViewModel$ViewState$Loaded) {
        super(1);
        this.this$0 = widgetServerSettingsEnableCommunityViewModel;
        this.$currentViewState = widgetServerSettingsEnableCommunityViewModel$ViewState$Loaded;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
        invoke2(r1);
        return Unit.a;
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Void r7) {
        WidgetServerSettingsEnableCommunityViewModel.access$updateViewState(this.this$0, WidgetServerSettingsEnableCommunityViewModel$ViewState$Loaded.copy$default(this.$currentViewState, 0, false, null, 5, null));
        WidgetServerSettingsEnableCommunityViewModel.access$getEventSubject$p(this.this$0).k.onNext((T) WidgetServerSettingsEnableCommunityViewModel$Event$SaveSuccess.INSTANCE);
    }
}
