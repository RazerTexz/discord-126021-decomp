package com.discord.widgets.channels.permissions;

import androidx.core.os.BundleKt;
import androidx.fragment.app.FragmentManager;
import d0.o;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetChannelSettingsAddMemberSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelSettingsAddMemberSheet$Companion {
    private WidgetChannelSettingsAddMemberSheet$Companion() {
    }

    public final void show(FragmentManager fragmentManager, long channelId) {
        m.checkNotNullParameter(fragmentManager, "fragmentManager");
        WidgetChannelSettingsAddMemberSheet widgetChannelSettingsAddMemberSheet = new WidgetChannelSettingsAddMemberSheet();
        widgetChannelSettingsAddMemberSheet.setArguments(BundleKt.bundleOf(o.to("com.discord.intent.extra.EXTRA_CHANNEL_ID", Long.valueOf(channelId))));
        widgetChannelSettingsAddMemberSheet.show(fragmentManager, WidgetChannelSettingsAddMemberSheet.class.getName());
    }

    public /* synthetic */ WidgetChannelSettingsAddMemberSheet$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
