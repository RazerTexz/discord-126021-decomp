package com.discord.widgets.channels.list;

import android.os.Bundle;
import androidx.fragment.app.FragmentManager;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetChannelsListItemThreadActions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelsListItemThreadActions$Companion {
    private WidgetChannelsListItemThreadActions$Companion() {
    }

    public final void show(FragmentManager fragmentManager, long channelId) {
        m.checkNotNullParameter(fragmentManager, "fragmentManager");
        WidgetChannelsListItemThreadActions widgetChannelsListItemThreadActions = new WidgetChannelsListItemThreadActions();
        Bundle bundle = new Bundle();
        bundle.putLong("INTENT_EXTRA_CHANNEL_ID", channelId);
        widgetChannelsListItemThreadActions.setArguments(bundle);
        widgetChannelsListItemThreadActions.show(fragmentManager, WidgetChannelsListItemThreadActions.class.getName());
    }

    public /* synthetic */ WidgetChannelsListItemThreadActions$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
