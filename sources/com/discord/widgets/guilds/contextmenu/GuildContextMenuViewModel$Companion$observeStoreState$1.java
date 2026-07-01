package com.discord.widgets.guilds.contextmenu;

import androidx.core.app.NotificationCompat;
import com.discord.models.guild.Guild;
import com.discord.models.user.MeUser;
import d0.z.d.m;
import rx.functions.Func4;

/* JADX INFO: compiled from: GuildContextMenuViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GuildContextMenuViewModel$Companion$observeStoreState$1<T1, T2, T3, T4, R> implements Func4<Guild, MeUser, Boolean, Long, GuildContextMenuViewModel$StoreState> {
    public static final GuildContextMenuViewModel$Companion$observeStoreState$1 INSTANCE = new GuildContextMenuViewModel$Companion$observeStoreState$1();

    @Override // rx.functions.Func4
    public /* bridge */ /* synthetic */ GuildContextMenuViewModel$StoreState call(Guild guild, MeUser meUser, Boolean bool, Long l) {
        return call2(guild, meUser, bool, l);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final GuildContextMenuViewModel$StoreState call2(Guild guild, MeUser meUser, Boolean bool, Long l) {
        if (guild == null) {
            return GuildContextMenuViewModel$StoreState$Invalid.INSTANCE;
        }
        long id2 = meUser.getId();
        m.checkNotNullExpressionValue(bool, "isUnread");
        boolean zBooleanValue = bool.booleanValue();
        m.checkNotNullExpressionValue(l, "selectedGuildId");
        return new GuildContextMenuViewModel$StoreState$Valid(guild, id2, zBooleanValue, l.longValue());
    }
}
