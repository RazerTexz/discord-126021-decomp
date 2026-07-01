package com.discord.widgets.guilds.invite;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.api.stageinstance.StageInstance;
import com.discord.models.domain.ModelInvite$Settings;
import com.discord.models.guild.Guild;
import com.discord.models.user.MeUser;
import d0.z.d.m;
import java.util.List;
import java.util.Map;
import rx.functions.Func7;

/* JADX INFO: compiled from: GuildInviteShareSheetViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GuildInviteShareSheetViewModel$Companion$observeStoreState$1<T1, T2, T3, T4, T5, T6, T7, R> implements Func7<ModelInvite$Settings, Map<Long, ? extends Channel>, MeUser, List<? extends Channel>, Guild, List<? extends InviteSuggestion>, Map<Long, ? extends StageInstance>, GuildInviteShareSheetViewModel$StoreState> {
    public static final GuildInviteShareSheetViewModel$Companion$observeStoreState$1 INSTANCE = new GuildInviteShareSheetViewModel$Companion$observeStoreState$1();

    @Override // rx.functions.Func7
    public /* bridge */ /* synthetic */ GuildInviteShareSheetViewModel$StoreState call(ModelInvite$Settings modelInvite$Settings, Map<Long, ? extends Channel> map, MeUser meUser, List<? extends Channel> list, Guild guild, List<? extends InviteSuggestion> list2, Map<Long, ? extends StageInstance> map2) {
        return call2(modelInvite$Settings, (Map<Long, Channel>) map, meUser, (List<Channel>) list, guild, list2, (Map<Long, StageInstance>) map2);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final GuildInviteShareSheetViewModel$StoreState call2(ModelInvite$Settings modelInvite$Settings, Map<Long, Channel> map, MeUser meUser, List<Channel> list, Guild guild, List<? extends InviteSuggestion> list2, Map<Long, StageInstance> map2) {
        if (guild == null) {
            return GuildInviteShareSheetViewModel$StoreState$Invalid.INSTANCE;
        }
        m.checkNotNullExpressionValue(modelInvite$Settings, "inviteSettings");
        m.checkNotNullExpressionValue(map, "invitableChannels");
        m.checkNotNullExpressionValue(meUser, "me");
        m.checkNotNullExpressionValue(list, "dms");
        m.checkNotNullExpressionValue(list2, "inviteSuggestions");
        m.checkNotNullExpressionValue(map2, "guildStageInstances");
        return new GuildInviteShareSheetViewModel$StoreState$Valid(modelInvite$Settings, map, meUser, list, guild, list2, map2);
    }
}
