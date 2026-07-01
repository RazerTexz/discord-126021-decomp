package com.discord.widgets.servers.community;

import com.discord.api.guild.Guild;
import com.discord.api.role.GuildRole;
import com.discord.restapi.RestAPIParams$Role;
import d0.z.d.m;
import d0.z.d.o;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.objectweb.asm.Opcodes;

/* JADX INFO: compiled from: WidgetServerSettingsEnableCommunityViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsEnableCommunityViewModel$updateGuild$2 extends o implements Function1<Guild, Unit> {
    public final /* synthetic */ WidgetServerSettingsEnableCommunityViewModel$CommunityGuildConfig $currentConfig;
    public final /* synthetic */ WidgetServerSettingsEnableCommunityViewModel$ViewState$Loaded $currentViewState;
    public final /* synthetic */ WidgetServerSettingsEnableCommunityViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetServerSettingsEnableCommunityViewModel$updateGuild$2(WidgetServerSettingsEnableCommunityViewModel widgetServerSettingsEnableCommunityViewModel, WidgetServerSettingsEnableCommunityViewModel$CommunityGuildConfig widgetServerSettingsEnableCommunityViewModel$CommunityGuildConfig, WidgetServerSettingsEnableCommunityViewModel$ViewState$Loaded widgetServerSettingsEnableCommunityViewModel$ViewState$Loaded) {
        super(1);
        this.this$0 = widgetServerSettingsEnableCommunityViewModel;
        this.$currentConfig = widgetServerSettingsEnableCommunityViewModel$CommunityGuildConfig;
        this.$currentViewState = widgetServerSettingsEnableCommunityViewModel$ViewState$Loaded;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Guild guild) {
        invoke2(guild);
        return Unit.a;
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Guild guild) {
        GuildRole guildRole;
        m.checkNotNullParameter(guild, "it");
        if (this.$currentConfig.getEveryonePermissions()) {
            Map<Long, GuildRole> roles = this.$currentConfig.getRoles();
            WidgetServerSettingsEnableCommunityViewModel.access$patchRole(this.this$0, new RestAPIParams$Role(null, null, null, null, null, Long.valueOf((-1116960071743L) & ((roles == null || (guildRole = roles.get(Long.valueOf(this.this$0.getGuildId()))) == null) ? 0L : guildRole.getPermissions())), guild.getId(), null, Opcodes.IF_ICMPEQ, null));
        } else {
            WidgetServerSettingsEnableCommunityViewModel.access$updateViewState(this.this$0, WidgetServerSettingsEnableCommunityViewModel$ViewState$Loaded.copy$default(this.$currentViewState, 0, false, null, 5, null));
            WidgetServerSettingsEnableCommunityViewModel.access$getEventSubject$p(this.this$0).k.onNext((T) WidgetServerSettingsEnableCommunityViewModel$Event$SaveSuccess.INSTANCE);
        }
    }
}
