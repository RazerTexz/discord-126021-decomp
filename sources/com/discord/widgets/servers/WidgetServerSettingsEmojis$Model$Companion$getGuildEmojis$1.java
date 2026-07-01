package com.discord.widgets.servers;

import com.discord.models.domain.emoji.ModelEmojiGuild;
import com.discord.models.guild.Guild;
import com.discord.models.member.GuildMember;
import com.discord.stores.StoreEmojiGuild;
import com.discord.stores.StoreGuilds;
import com.discord.widgets.servers.WidgetServerSettingsEmojis;
import d0.t.Maps6;
import d0.z.d.Lambda;
import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: WidgetServerSettingsEmojis.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsEmojis$Model$Companion$getGuildEmojis$1 extends Lambda implements Function0<WidgetServerSettingsEmojis.Model> {
    public final /* synthetic */ Guild $guild;
    public final /* synthetic */ StoreGuilds $storeGuild;
    public final /* synthetic */ StoreEmojiGuild $storeGuildEmoji;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetServerSettingsEmojis$Model$Companion$getGuildEmojis$1(Guild guild, StoreEmojiGuild storeEmojiGuild, StoreGuilds storeGuilds) {
        super(0);
        this.$guild = guild;
        this.$storeGuildEmoji = storeEmojiGuild;
        this.$storeGuild = storeGuilds;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final WidgetServerSettingsEmojis.Model invoke() {
        long id2 = this.$guild.getId();
        List<ModelEmojiGuild> guildEmoji = this.$storeGuildEmoji.getGuildEmoji(id2);
        Map<Long, GuildMember> mapEmptyMap = this.$storeGuild.getMembers().get(Long.valueOf(id2));
        if (mapEmptyMap == null) {
            mapEmptyMap = Maps6.emptyMap();
        }
        return WidgetServerSettingsEmojis.Model.INSTANCE.create(this.$guild, guildEmoji, mapEmptyMap);
    }
}
