package com.discord.widgets.stage.sheet;

import android.os.Bundle;
import androidx.fragment.app.FragmentManager;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetStageAudienceNoticeBottomSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetStageAudienceNoticeBottomSheet$Companion {
    private WidgetStageAudienceNoticeBottomSheet$Companion() {
    }

    public final void show(FragmentManager fragmentManager, long channelId) {
        m.checkNotNullParameter(fragmentManager, "fragmentManager");
        WidgetStageAudienceNoticeManager widgetStageAudienceNoticeManager = WidgetStageAudienceNoticeManager.INSTANCE;
        if (widgetStageAudienceNoticeManager.hasUserSeenAudienceNotice()) {
            return;
        }
        widgetStageAudienceNoticeManager.markUserSeenAudienceNotice();
        WidgetStageAudienceNoticeBottomSheet widgetStageAudienceNoticeBottomSheet = new WidgetStageAudienceNoticeBottomSheet();
        Bundle bundle = new Bundle();
        bundle.putLong("com.discord.intent.extra.EXTRA_CHANNEL_ID", channelId);
        widgetStageAudienceNoticeBottomSheet.setArguments(bundle);
        widgetStageAudienceNoticeBottomSheet.show(fragmentManager, WidgetStageAudienceNoticeBottomSheet.class.getSimpleName());
    }

    public /* synthetic */ WidgetStageAudienceNoticeBottomSheet$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
