package com.discord.widgets.stage.sheet;

import androidx.core.os.BundleKt;
import androidx.fragment.app.FragmentManager;
import d0.o;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetStageAudienceBlockedBottomSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetStageAudienceBlockedBottomSheet$Companion {
    private WidgetStageAudienceBlockedBottomSheet$Companion() {
    }

    public final void show(FragmentManager fragmentManager, long channelId, boolean launchStageFullScreen) {
        m.checkNotNullParameter(fragmentManager, "fragmentManager");
        WidgetStageAudienceBlockedBottomSheet widgetStageAudienceBlockedBottomSheet = new WidgetStageAudienceBlockedBottomSheet();
        widgetStageAudienceBlockedBottomSheet.setArguments(BundleKt.bundleOf(o.to("com.discord.intent.extra.EXTRA_CHANNEL_ID", Long.valueOf(channelId)), o.to("LAUNCH_FULL_SCREEN", Boolean.valueOf(launchStageFullScreen))));
        widgetStageAudienceBlockedBottomSheet.show(fragmentManager, WidgetStageAudienceBlockedBottomSheet.class.getSimpleName());
    }

    public /* synthetic */ WidgetStageAudienceBlockedBottomSheet$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
