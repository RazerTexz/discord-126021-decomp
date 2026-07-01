package com.discord.widgets.guilds.profile;

import com.discord.api.guildmember.GuildMember;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetChangeGuildIdentityViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChangeGuildIdentityViewModel$saveMemberChanges$2 extends o implements Function1<GuildMember, Unit> {
    public final /* synthetic */ WidgetChangeGuildIdentityViewModel$ViewState$Loaded $viewState;
    public final /* synthetic */ WidgetChangeGuildIdentityViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChangeGuildIdentityViewModel$saveMemberChanges$2(WidgetChangeGuildIdentityViewModel widgetChangeGuildIdentityViewModel, WidgetChangeGuildIdentityViewModel$ViewState$Loaded widgetChangeGuildIdentityViewModel$ViewState$Loaded) {
        super(1);
        this.this$0 = widgetChangeGuildIdentityViewModel;
        this.$viewState = widgetChangeGuildIdentityViewModel$ViewState$Loaded;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(GuildMember guildMember) {
        invoke2(guildMember);
        return Unit.a;
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(GuildMember guildMember) {
        m.checkNotNullParameter(guildMember, "it");
        WidgetChangeGuildIdentityViewModel.access$getEventSubject$p(this.this$0).k.onNext((T) WidgetChangeGuildIdentityViewModel$Event$MemberUpdateSucceeded.INSTANCE);
        WidgetChangeGuildIdentityViewModel.access$updateViewState(this.this$0, WidgetChangeGuildIdentityViewModel$ViewState$Loaded.copy$default(this.$viewState, null, null, null, false, null, null, false, 63, null));
    }
}
