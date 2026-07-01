package com.discord.widgets.settings.profile;

import com.discord.api.guildmember.GuildMember;
import com.discord.models.member.GuildMember$Companion;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: EditUserOrGuildMemberProfileViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class SettingsUserProfileViewModel$saveGuildMemberChanges$2 extends o implements Function1<GuildMember, Unit> {
    public final /* synthetic */ SettingsUserProfileViewModel$ViewState$Loaded $viewState;
    public final /* synthetic */ SettingsUserProfileViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SettingsUserProfileViewModel$saveGuildMemberChanges$2(SettingsUserProfileViewModel settingsUserProfileViewModel, SettingsUserProfileViewModel$ViewState$Loaded settingsUserProfileViewModel$ViewState$Loaded) {
        super(1);
        this.this$0 = settingsUserProfileViewModel;
        this.$viewState = settingsUserProfileViewModel$ViewState$Loaded;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(GuildMember guildMember) {
        invoke2(guildMember);
        return Unit.a;
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(GuildMember guildMember) {
        m.checkNotNullParameter(guildMember, "apiMember");
        SettingsUserProfileViewModel.access$getStoreGuilds$p(this.this$0).handleGuildMember(GuildMember.a(guildMember, SettingsUserProfileViewModel.access$getGuildId$p(this.this$0).longValue(), null, null, null, null, null, false, null, null, null, null, null, null, 8190), SettingsUserProfileViewModel.access$getGuildId$p(this.this$0).longValue(), true);
        SettingsUserProfileViewModel.access$updateViewState(this.this$0, SettingsUserProfileViewModel$ViewState$Loaded.copy$default(this.$viewState, null, null, GuildMember$Companion.from$default(com.discord.models.member.GuildMember.Companion, guildMember, SettingsUserProfileViewModel.access$getGuildId$p(this.this$0).longValue(), null, SettingsUserProfileViewModel.access$getStoreGuilds$p(this.this$0), 4, null), null, null, null, null, null, null, null, false, false, 3979, null));
        SettingsUserProfileViewModel.access$getEventSubject$p(this.this$0).k.onNext((T) SettingsUserProfileViewModel$Event$UserUpdateRequestCompleted.INSTANCE);
    }
}
