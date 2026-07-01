package com.discord.utilities.channel.permissions;

import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.permission.PermissionOverwrite;
import com.discord.api.permission.PermissionOverwrite$Type;
import com.discord.restapi.RestAPIParams$ChannelPermissionOverwrites;
import com.discord.stores.StoreStream;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.z.d.m;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map$Entry;
import kotlin.NoWhenBranchMatchedException;
import rx.Observable;

/* JADX INFO: compiled from: ChannelPermissionsAddMemberUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ChannelPermissionsAddMemberUtils {
    public static final ChannelPermissionsAddMemberUtils INSTANCE = new ChannelPermissionsAddMemberUtils();

    private ChannelPermissionsAddMemberUtils() {
    }

    public final Observable<List<Void>> addPermissionOverwrites(long channelId, Map<Long, ? extends PermissionOverwrite$Type> selectedItems, long permission) {
        RestAPIParams$ChannelPermissionOverwrites restAPIParams$ChannelPermissionOverwritesCreateForRole;
        m.checkNotNullParameter(selectedItems, "selectedItems");
        Channel channel = StoreStream.Companion.getChannels().getChannel(channelId);
        ArrayList arrayList = new ArrayList(selectedItems.size());
        for (Map$Entry<Long, ? extends PermissionOverwrite$Type> map$Entry : selectedItems.entrySet()) {
            long jLongValue = map$Entry.getKey().longValue();
            PermissionOverwrite$Type value = map$Entry.getValue();
            PermissionOverwrite permissionOverwriteF = channel != null ? ChannelUtils.f(channel, jLongValue) : null;
            long allow = permissionOverwriteF != null ? permissionOverwriteF.getAllow() : 0L;
            long deny = permissionOverwriteF != null ? permissionOverwriteF.getDeny() : 0L;
            int iOrdinal = value.ordinal();
            if (iOrdinal == 0) {
                restAPIParams$ChannelPermissionOverwritesCreateForRole = RestAPIParams$ChannelPermissionOverwrites.Companion.createForRole(jLongValue, Long.valueOf(allow | permission), Long.valueOf((~permission) & deny));
            } else {
                if (iOrdinal != 1) {
                    throw new NoWhenBranchMatchedException();
                }
                restAPIParams$ChannelPermissionOverwritesCreateForRole = RestAPIParams$ChannelPermissionOverwrites.Companion.createForMember(jLongValue, Long.valueOf(allow | permission), Long.valueOf((~permission) & deny));
            }
            arrayList.add(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.Companion.getApi().updatePermissionOverwrites(channelId, jLongValue, restAPIParams$ChannelPermissionOverwritesCreateForRole), false, 1, null));
        }
        Observable<List<Void>> observableF0 = Observable.l(arrayList).f0();
        m.checkNotNullExpressionValue(observableF0, "Observable.concat(overwr…quests)\n        .toList()");
        return observableF0;
    }
}
