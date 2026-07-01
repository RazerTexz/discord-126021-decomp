package com.discord.widgets.channels.list;

import android.os.Bundle;
import androidx.fragment.app.FragmentManager;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetChannelsListItemChannelActions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelsListItemChannelActions$Companion {
    private WidgetChannelsListItemChannelActions$Companion() {
    }

    public final void show(FragmentManager fragmentManager, long channelId) {
        m.checkNotNullParameter(fragmentManager, "fragmentManager");
        WidgetChannelsListItemChannelActions widgetChannelsListItemChannelActions = new WidgetChannelsListItemChannelActions();
        Bundle bundle = new Bundle();
        bundle.putLong("INTENT_EXTRA_CHANNEL_ID", channelId);
        widgetChannelsListItemChannelActions.setArguments(bundle);
        widgetChannelsListItemChannelActions.show(fragmentManager, WidgetChannelsListItemChannelActions.class.getName());
    }

    public /* synthetic */ WidgetChannelsListItemChannelActions$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
