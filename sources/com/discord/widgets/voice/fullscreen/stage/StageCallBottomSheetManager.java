package com.discord.widgets.voice.fullscreen.stage;

import androidx.fragment.app.FragmentManager;
import b.d.b.a.a;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreStream$Companion;
import com.discord.widgets.stage.StageRoles;
import com.discord.widgets.stage.sheet.WidgetStageAudienceNoticeBottomSheet;
import com.discord.widgets.stage.sheet.WidgetStageModeratorJoinBottomSheet;
import com.discord.widgets.stage.sheet.WidgetStageStartEventBottomSheet;
import com.discord.widgets.stage.sheet.WidgetStageStartEventBottomSheet$Companion;
import d0.z.d.m;
import java.util.Map;

/* JADX INFO: compiled from: StageCallBottomSheetManager.kt */
/* JADX INFO: loaded from: classes.dex */
public final class StageCallBottomSheetManager {
    public final boolean configureBottomSheet(FragmentManager fragmentManager, Channel channel) {
        m.checkNotNullParameter(fragmentManager, "fragmentManager");
        m.checkNotNullParameter(channel, "channel");
        StoreStream$Companion storeStream$Companion = StoreStream.Companion;
        Map map = (Map) a.c(channel, storeStream$Companion.getVoiceStates().get());
        boolean z2 = false;
        if (map != null) {
            StageRoles stageRolesM15getMyRolesvisDeB4 = storeStream$Companion.getStageChannels().m15getMyRolesvisDeB4(channel.getId());
            long id2 = storeStream$Companion.getUsers().getMeSnapshot().getId();
            if (ChannelUtils.D(channel) && stageRolesM15getMyRolesvisDeB4 != null && map.containsKey(Long.valueOf(id2))) {
                if (StageRoles.m32isModeratorimpl(stageRolesM15getMyRolesvisDeB4.m35unboximpl()) && storeStream$Companion.getStageInstances().getStageInstanceForChannel(channel.getId()) == null) {
                    z2 = true;
                }
                if (StageRoles.m30isAudienceimpl(stageRolesM15getMyRolesvisDeB4.m35unboximpl())) {
                    WidgetStageAudienceNoticeBottomSheet.Companion.show(fragmentManager, channel.getId());
                } else if (z2) {
                    WidgetStageStartEventBottomSheet$Companion.show$default(WidgetStageStartEventBottomSheet.Companion, fragmentManager, channel.getId(), null, 4, null);
                } else if (StageRoles.m32isModeratorimpl(stageRolesM15getMyRolesvisDeB4.m35unboximpl()) && !StageRoles.m33isSpeakerimpl(stageRolesM15getMyRolesvisDeB4.m35unboximpl())) {
                    WidgetStageModeratorJoinBottomSheet.Companion.show(fragmentManager, channel.getId());
                }
                return true;
            }
        }
        return false;
    }
}
