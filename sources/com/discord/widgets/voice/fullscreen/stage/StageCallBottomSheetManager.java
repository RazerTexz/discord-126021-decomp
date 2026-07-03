package com.discord.widgets.voice.fullscreen.stage;

import androidx.fragment.app.FragmentManager;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.stores.StoreStream;
import com.discord.widgets.stage.StageRoles;
import com.discord.widgets.stage.sheet.WidgetStageAudienceNoticeBottomSheet;
import com.discord.widgets.stage.sheet.WidgetStageModeratorJoinBottomSheet;
import com.discord.widgets.stage.sheet.WidgetStageStartEventBottomSheet;
import java.util.Map;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: StageCallBottomSheetManager.kt */
/* JADX INFO: loaded from: classes.dex */
public final class StageCallBottomSheetManager {
    public final boolean configureBottomSheet(FragmentManager fragmentManager, Channel channel) {
        C12238m.checkNotNullParameter(fragmentManager, "fragmentManager");
        C12238m.checkNotNullParameter(channel, "channel");
        StoreStream.Companion companion = StoreStream.INSTANCE;
        Map map = (Map) C1643a.m843c(channel, companion.getVoiceStates().get());
        boolean z2 = false;
        if (map != null) {
            StageRoles stageRolesM11392getMyRolesvisDeB4 = companion.getStageChannels().m11392getMyRolesvisDeB4(channel.getId());
            long id2 = companion.getUsers().getMeSnapshot().getId();
            if (ChannelUtils.m7669D(channel) && stageRolesM11392getMyRolesvisDeB4 != null && map.containsKey(Long.valueOf(id2))) {
                if (StageRoles.m11409isModeratorimpl(stageRolesM11392getMyRolesvisDeB4.m11412unboximpl()) && companion.getStageInstances().getStageInstanceForChannel(channel.getId()) == null) {
                    z2 = true;
                }
                if (StageRoles.m11407isAudienceimpl(stageRolesM11392getMyRolesvisDeB4.m11412unboximpl())) {
                    WidgetStageAudienceNoticeBottomSheet.INSTANCE.show(fragmentManager, channel.getId());
                } else if (z2) {
                    WidgetStageStartEventBottomSheet.Companion.show$default(WidgetStageStartEventBottomSheet.INSTANCE, fragmentManager, channel.getId(), null, 4, null);
                } else if (StageRoles.m11409isModeratorimpl(stageRolesM11392getMyRolesvisDeB4.m11412unboximpl()) && !StageRoles.m11410isSpeakerimpl(stageRolesM11392getMyRolesvisDeB4.m11412unboximpl())) {
                    WidgetStageModeratorJoinBottomSheet.INSTANCE.show(fragmentManager, channel.getId());
                }
                return true;
            }
        }
        return false;
    }
}
