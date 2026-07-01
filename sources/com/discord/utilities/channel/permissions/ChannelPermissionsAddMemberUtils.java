package com.discord.utilities.channel.permissions;

import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.permission.PermissionOverwrite;
import com.discord.restapi.RestAPIParams;
import com.discord.stores.StoreStream;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.z.d.Intrinsics3;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.NoWhenBranchMatchedException;
import rx.Observable;

/* JADX INFO: compiled from: ChannelPermissionsAddMemberUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ChannelPermissionsAddMemberUtils {
    public static final ChannelPermissionsAddMemberUtils INSTANCE = new ChannelPermissionsAddMemberUtils();

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            PermissionOverwrite.Type.values();
            int[] iArr = new int[2];
            $EnumSwitchMapping$0 = iArr;
            iArr[PermissionOverwrite.Type.ROLE.ordinal()] = 1;
            iArr[PermissionOverwrite.Type.MEMBER.ordinal()] = 2;
        }
    }

    private ChannelPermissionsAddMemberUtils() {
    }

    public final Observable<List<Void>> addPermissionOverwrites(long channelId, Map<Long, ? extends PermissionOverwrite.Type> selectedItems, long permission) {
        RestAPIParams.ChannelPermissionOverwrites channelPermissionOverwritesCreateForRole;
        Intrinsics3.checkNotNullParameter(selectedItems, "selectedItems");
        Channel channel = StoreStream.INSTANCE.getChannels().getChannel(channelId);
        ArrayList arrayList = new ArrayList(selectedItems.size());
        for (Map.Entry<Long, ? extends PermissionOverwrite.Type> entry : selectedItems.entrySet()) {
            long jLongValue = entry.getKey().longValue();
            PermissionOverwrite.Type value = entry.getValue();
            PermissionOverwrite permissionOverwriteF = channel != null ? ChannelUtils.f(channel, jLongValue) : null;
            long allow = permissionOverwriteF != null ? permissionOverwriteF.getAllow() : 0L;
            long deny = permissionOverwriteF != null ? permissionOverwriteF.getDeny() : 0L;
            int iOrdinal = value.ordinal();
            if (iOrdinal == 0) {
                channelPermissionOverwritesCreateForRole = RestAPIParams.ChannelPermissionOverwrites.INSTANCE.createForRole(jLongValue, Long.valueOf(allow | permission), Long.valueOf((~permission) & deny));
            } else {
                if (iOrdinal != 1) {
                    throw new NoWhenBranchMatchedException();
                }
                channelPermissionOverwritesCreateForRole = RestAPIParams.ChannelPermissionOverwrites.INSTANCE.createForMember(jLongValue, Long.valueOf(allow | permission), Long.valueOf((~permission) & deny));
            }
            arrayList.add(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().updatePermissionOverwrites(channelId, jLongValue, channelPermissionOverwritesCreateForRole), false, 1, null));
        }
        Observable<List<Void>> observableF0 = Observable.l(arrayList).f0();
        Intrinsics3.checkNotNullExpressionValue(observableF0, "Observable.concat(overwr…quests)\n        .toList()");
        return observableF0;
    }
}
