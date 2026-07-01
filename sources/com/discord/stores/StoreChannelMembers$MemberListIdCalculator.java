package com.discord.stores;

import b.d.b.a.a;
import com.discord.api.channel.Channel;
import com.discord.api.permission.Permission;
import com.discord.api.permission.PermissionOverwrite;
import com.discord.models.domain.ModelGuildMemberListUpdate;
import com.discord.utilities.PermissionOverwriteUtilsKt;
import com.discord.utilities.permissions.PermissionUtils;
import d0.t.h0;
import d0.t.u;
import j0.l.e.m;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StoreChannelMembers.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreChannelMembers$MemberListIdCalculator {
    public static final StoreChannelMembers$MemberListIdCalculator INSTANCE = new StoreChannelMembers$MemberListIdCalculator();

    private StoreChannelMembers$MemberListIdCalculator() {
    }

    /* JADX WARN: Code duplicated, block: B:17:0x0079  */
    private final String computeIdFromOverwrites(List<PermissionOverwrite> permissionOverwrites) {
        String strValueOf;
        String strJoinToString$default;
        if (permissionOverwrites != null) {
            ArrayList arrayList = new ArrayList();
            for (PermissionOverwrite permissionOverwrite : permissionOverwrites) {
                if (PermissionOverwriteUtilsKt.allows(permissionOverwrite, Permission.VIEW_CHANNEL)) {
                    StringBuilder sbU = a.U("allow:");
                    sbU.append(permissionOverwrite.e());
                    arrayList.add(sbU.toString());
                } else if (PermissionOverwriteUtilsKt.denies(permissionOverwrite, Permission.VIEW_CHANNEL)) {
                    StringBuilder sbU2 = a.U("deny:");
                    sbU2.append(permissionOverwrite.e());
                    arrayList.add(sbU2.toString());
                }
            }
            List listSorted = u.sorted(arrayList);
            if (listSorted == null || (strJoinToString$default = u.joinToString$default(listSorted, ",", null, null, 0, null, null, 62, null)) == null) {
                strValueOf = null;
            } else {
                strValueOf = String.valueOf(INSTANCE.toUnsignedLong(m.a(strJoinToString$default, 0, strJoinToString$default.length(), 0)));
            }
        } else {
            strValueOf = null;
        }
        return strValueOf != null ? strValueOf : "";
    }

    private final long toUnsignedLong(int i) {
        return ((long) i) & 4294967295L;
    }

    public final String computeMemberListId(Function1<? super Long, Channel> channelsProvider, long channelId, StoreGuilds storeGuilds) {
        d0.z.d.m.checkNotNullParameter(channelsProvider, "channelsProvider");
        d0.z.d.m.checkNotNullParameter(storeGuilds, "storeGuilds");
        Channel channelInvoke = channelsProvider.invoke(Long.valueOf(channelId));
        String memberListId = channelInvoke != null ? channelInvoke.getMemberListId() : null;
        if (channelInvoke != null) {
            if (memberListId != null) {
                return memberListId;
            }
            Map mapEmptyMap = (Map) a.c(channelInvoke, storeGuilds.getRoles());
            if (mapEmptyMap == null) {
                mapEmptyMap = h0.emptyMap();
            }
            if (!PermissionUtils.canEveryone(Permission.VIEW_CHANNEL, channelInvoke, null, mapEmptyMap)) {
                return computeIdFromOverwrites(channelInvoke.v());
            }
        }
        return ModelGuildMemberListUpdate.EVERYONE_ID;
    }
}
