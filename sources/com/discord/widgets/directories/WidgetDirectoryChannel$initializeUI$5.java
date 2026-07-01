package com.discord.widgets.directories;

import android.content.Context;
import b.a.d.j;
import com.discord.models.guild.Guild;
import com.discord.models.member.GuildMember;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreStream$Companion;
import com.discord.utilities.features.GrowthTeamFeatures;
import com.discord.widgets.hubs.HubAddNameArgs;
import com.discord.widgets.hubs.WidgetHubAddName;
import d0.g0.t;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetDirectoryChannel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetDirectoryChannel$initializeUI$5 extends o implements Function1<Long, Unit> {
    public final /* synthetic */ WidgetDirectoryChannel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetDirectoryChannel$initializeUI$5(WidgetDirectoryChannel widgetDirectoryChannel) {
        super(1);
        this.this$0 = widgetDirectoryChannel;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Long l) {
        invoke(l.longValue());
        return Unit.a;
    }

    public final void invoke(long j) {
        Guild guild;
        Context context;
        StoreStream$Companion storeStream$Companion = StoreStream.Companion;
        long selectedGuildId = storeStream$Companion.getGuildSelected().getSelectedGuildId();
        GuildMember member = storeStream$Companion.getGuilds().getMember(selectedGuildId, storeStream$Companion.getUsers().getMeSnapshot().getId());
        if (member == null || (guild = storeStream$Companion.getGuilds().getGuild(selectedGuildId)) == null || (context = this.this$0.getContext()) == null) {
            return;
        }
        m.checkNotNullExpressionValue(context, "context ?: return@appSubscribe");
        if (this.this$0.isVisible() && selectedGuildId == j && guild.isHub()) {
            String nick = member.getNick();
            if (!(nick == null || t.isBlank(nick)) || storeStream$Companion.getDirectories().getAndSetSeenNamePrompt(selectedGuildId) || GrowthTeamFeatures.INSTANCE.isHubNameKillSwitchEnabled()) {
                return;
            }
            j.d(context, WidgetHubAddName.class, new HubAddNameArgs(guild.getId()));
        }
    }
}
