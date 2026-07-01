package com.discord.widgets.servers;

import androidx.core.app.NotificationCompat;
import com.discord.api.permission.Permission;
import com.discord.models.guild.Guild;
import com.discord.models.user.MeUser;
import com.discord.utilities.permissions.PermissionUtils;
import rx.functions.Func3;

/* JADX INFO: compiled from: WidgetServerSettingsEmojis.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsEmojis$Model$Companion$canManageEmojisAndStickers$1<T1, T2, T3, R> implements Func3<Long, Guild, MeUser, WidgetServerSettingsEmojis$Model$Permission> {
    public static final WidgetServerSettingsEmojis$Model$Companion$canManageEmojisAndStickers$1 INSTANCE = new WidgetServerSettingsEmojis$Model$Companion$canManageEmojisAndStickers$1();

    @Override // rx.functions.Func3
    public /* bridge */ /* synthetic */ WidgetServerSettingsEmojis$Model$Permission call(Long l, Guild guild, MeUser meUser) {
        return call2(l, guild, meUser);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final WidgetServerSettingsEmojis$Model$Permission call2(Long l, Guild guild, MeUser meUser) {
        if (guild == null || l == null) {
            return null;
        }
        return new WidgetServerSettingsEmojis$Model$Permission(PermissionUtils.canAndIsElevated(Permission.MANAGE_EMOJIS_AND_STICKERS, l, meUser.getMfaEnabled(), guild.getMfaLevel()), guild);
    }
}
