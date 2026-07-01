package com.discord.widgets.servers.member_verification;

import com.discord.models.domain.ModelMemberVerificationFormResponse;
import com.discord.models.guild.Guild;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import rx.subjects.PublishSubject;

/* JADX INFO: compiled from: WidgetMemberVerificationViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetMemberVerificationViewModel$applyToJoinGuild$4 extends o implements Function1<ModelMemberVerificationFormResponse, Unit> {
    public final /* synthetic */ WidgetMemberVerificationViewModel$ViewState$Loaded $currentViewState;
    public final /* synthetic */ WidgetMemberVerificationViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetMemberVerificationViewModel$applyToJoinGuild$4(WidgetMemberVerificationViewModel widgetMemberVerificationViewModel, WidgetMemberVerificationViewModel$ViewState$Loaded widgetMemberVerificationViewModel$ViewState$Loaded) {
        super(1);
        this.this$0 = widgetMemberVerificationViewModel;
        this.$currentViewState = widgetMemberVerificationViewModel$ViewState$Loaded;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(ModelMemberVerificationFormResponse modelMemberVerificationFormResponse) {
        invoke2(modelMemberVerificationFormResponse);
        return Unit.a;
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(ModelMemberVerificationFormResponse modelMemberVerificationFormResponse) {
        m.checkNotNullParameter(modelMemberVerificationFormResponse, "it");
        WidgetMemberVerificationViewModel.access$updateViewState(this.this$0, WidgetMemberVerificationViewModel$ViewState$Loaded.copy$default(this.$currentViewState, false, false, false, null, false, null, null, null, null, false, false, false, null, 8189, null));
        PublishSubject publishSubjectAccess$getEventSubject$p = WidgetMemberVerificationViewModel.access$getEventSubject$p(this.this$0);
        Guild guild = this.$currentViewState.getGuild();
        Long lValueOf = guild != null ? Long.valueOf(guild.getId()) : null;
        Guild guild2 = this.$currentViewState.getGuild();
        publishSubjectAccess$getEventSubject$p.k.onNext((T) new WidgetMemberVerificationViewModel$Event$Success(lValueOf, guild2 != null ? guild2.getName() : null, modelMemberVerificationFormResponse.getApplicationStatus(), modelMemberVerificationFormResponse.getLastSeen()));
    }
}
