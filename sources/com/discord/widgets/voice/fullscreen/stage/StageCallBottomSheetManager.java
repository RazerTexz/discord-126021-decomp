package com.discord.widgets.voice.fullscreen.stage;

import androidx.fragment.app.FragmentManager;
import b.d.b.a.outline;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.stores.StoreStream;
import com.discord.widgets.stage.StageRoles;
import com.discord.widgets.stage.sheet.WidgetStageAudienceNoticeBottomSheet;
import com.discord.widgets.stage.sheet.WidgetStageModeratorJoinBottomSheet;
import com.discord.widgets.stage.sheet.WidgetStageStartEventBottomSheet;
import d0.z.d.Intrinsics3;
import java.util.Map;

/* JADX INFO: compiled from: StageCallBottomSheetManager.kt */
/* JADX INFO: loaded from: classes.dex */
public final class StageCallBottomSheetManager {
    public final boolean configureBottomSheet(FragmentManager fragmentManager, Channel channel) {
        Intrinsics3.checkNotNullParameter(fragmentManager, "fragmentManager");
        Intrinsics3.checkNotNullParameter(channel, "channel");
        StoreStream.Companion companion = StoreStream.INSTANCE;
        Map map = (Map) outline.c(channel, companion.getVoiceStates().get());
        boolean z2 = false;
        if (map != null) {
            StageRoles stageRolesM15getMyRolesvisDeB4 = companion.getStageChannels().m15getMyRolesvisDeB4(channel.getId());
            long id2 = companion.getUsers().getMeSnapshot().getId();
            if (ChannelUtils.D(channel) && stageRolesM15getMyRolesvisDeB4 != null && map.containsKey(Long.valueOf(id2))) {
                if (StageRoles.m32isModeratorimpl(stageRolesM15getMyRolesvisDeB4.m35unboximpl()) && companion.getStageInstances().getStageInstanceForChannel(channel.getId()) == null) {
                    z2 = true;
                }
                if (StageRoles.m30isAudienceimpl(stageRolesM15getMyRolesvisDeB4.m35unboximpl())) {
                    WidgetStageAudienceNoticeBottomSheet.INSTANCE.show(fragmentManager, channel.getId());
                } else if (z2) {
                    WidgetStageStartEventBottomSheet.Companion.show$default(WidgetStageStartEventBottomSheet.INSTANCE, fragmentManager, channel.getId(), null, 4, null);
                } else if (StageRoles.m32isModeratorimpl(stageRolesM15getMyRolesvisDeB4.m35unboximpl()) && !StageRoles.m33isSpeakerimpl(stageRolesM15getMyRolesvisDeB4.m35unboximpl())) {
                    WidgetStageModeratorJoinBottomSheet.INSTANCE.show(fragmentManager, channel.getId());
                }
                return true;
            }
        }
        return false;
    }
}
