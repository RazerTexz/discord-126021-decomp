package com.discord.widgets.channels;

import androidx.core.app.NotificationCompat;
import com.discord.api.guild.GuildFeature;
import com.discord.api.permission.Permission;
import com.discord.api.role.GuildRole;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.guild.Guild;
import com.discord.models.user.MeUser;
import com.discord.utilities.mg_recycler.SingleTypePayload;
import com.discord.utilities.permissions.PermissionUtils;
import d0.z.d.m;
import java.util.ArrayList;
import java.util.List;
import rx.functions.Func6;

/* JADX INFO: compiled from: WidgetCreateChannel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetCreateChannel$Model$Companion$get$1<T1, T2, T3, T4, T5, T6, R> implements Func6<MeUser, Guild, Long, Long, List<? extends GuildRole>, Boolean, WidgetCreateChannel$Model> {
    public static final WidgetCreateChannel$Model$Companion$get$1 INSTANCE = new WidgetCreateChannel$Model$Companion$get$1();

    @Override // rx.functions.Func6
    public /* bridge */ /* synthetic */ WidgetCreateChannel$Model call(MeUser meUser, Guild guild, Long l, Long l2, List<? extends GuildRole> list, Boolean bool) {
        return call2(meUser, guild, l, l2, (List<GuildRole>) list, bool);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final WidgetCreateChannel$Model call2(MeUser meUser, Guild guild, Long l, Long l2, List<GuildRole> list, Boolean bool) {
        if (guild == null || l == null || list == null) {
            return null;
        }
        m.checkNotNullExpressionValue(bool, "canCreateForumChannels");
        boolean zBooleanValue = bool.booleanValue();
        boolean zCanAndIsElevated = PermissionUtils.canAndIsElevated(16L, Long.valueOf(l2 != null ? l2.longValue() : l.longValue()), meUser.getMfaEnabled(), guild.getMfaLevel());
        boolean zContains = guild.getFeatures().contains(GuildFeature.COMMUNITY);
        boolean zCanAndIsElevated2 = PermissionUtils.canAndIsElevated(Permission.MANAGE_ROLES, Long.valueOf(l2 != null ? l2.longValue() : l.longValue()), meUser.getMfaEnabled(), guild.getMfaLevel());
        ArrayList arrayList = new ArrayList();
        for (GuildRole guildRole : list) {
            SingleTypePayload singleTypePayload = guildRole.getId() != guild.getId() ? new SingleTypePayload(guildRole, String.valueOf(guildRole.getId()), 0) : null;
            if (singleTypePayload != null) {
                arrayList.add(singleTypePayload);
            }
        }
        return new WidgetCreateChannel$Model(zBooleanValue, zCanAndIsElevated, zCanAndIsElevated2, zContains, arrayList, null);
    }
}
