package com.discord.widgets.home;

import androidx.core.app.NotificationCompat;
import com.discord.api.permission.Permission;
import com.discord.models.guild.Guild;
import com.discord.stores.StoreGuildWelcomeScreens$State;
import com.discord.utilities.permissions.PermissionUtils;
import d0.z.d.m;
import rx.functions.Func5;

/* JADX INFO: compiled from: WidgetHomeViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetHomeViewModel$Companion$observeStoreState$guildInfoObservable$1$1<T1, T2, T3, T4, T5, R> implements Func5<Guild, Boolean, StoreGuildWelcomeScreens$State, Long, Boolean, WidgetHomeViewModel$GuildInfo> {
    public final /* synthetic */ Long $selectedGuildId;

    public WidgetHomeViewModel$Companion$observeStoreState$guildInfoObservable$1$1(Long l) {
        this.$selectedGuildId = l;
    }

    @Override // rx.functions.Func5
    public /* bridge */ /* synthetic */ WidgetHomeViewModel$GuildInfo call(Guild guild, Boolean bool, StoreGuildWelcomeScreens$State storeGuildWelcomeScreens$State, Long l, Boolean bool2) {
        return call2(guild, bool, storeGuildWelcomeScreens$State, l, bool2);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final WidgetHomeViewModel$GuildInfo call2(Guild guild, Boolean bool, StoreGuildWelcomeScreens$State storeGuildWelcomeScreens$State, Long l, Boolean bool2) {
        Long l2 = this.$selectedGuildId;
        m.checkNotNullExpressionValue(l2, "selectedGuildId");
        long jLongValue = l2.longValue();
        m.checkNotNullExpressionValue(bool, "isLurking");
        return new WidgetHomeViewModel$GuildInfo(jLongValue, guild, bool.booleanValue(), storeGuildWelcomeScreens$State, !bool2.booleanValue(), l != null ? PermissionUtils.can(Permission.MANAGE_EVENTS, Long.valueOf(l.longValue())) : false);
    }
}
