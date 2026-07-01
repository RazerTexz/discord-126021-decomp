package com.discord.widgets.servers;

import android.os.Bundle;
import androidx.fragment.app.FragmentManager;
import com.discord.R$anim;
import com.discord.R$id;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.functions.Action0;

/* JADX INFO: compiled from: WidgetServerSettingsChannelsFabMenuFragment.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsChannelsFabMenuFragment$Companion {
    private WidgetServerSettingsChannelsFabMenuFragment$Companion() {
    }

    public final void show(long guildId, FragmentManager fragmentManager, Action0 dismissHandler) {
        m.checkNotNullParameter(fragmentManager, "fragmentManager");
        m.checkNotNullParameter(dismissHandler, "dismissHandler");
        WidgetServerSettingsChannelsFabMenuFragment widgetServerSettingsChannelsFabMenuFragment = new WidgetServerSettingsChannelsFabMenuFragment();
        Bundle bundle = new Bundle();
        bundle.putLong(WidgetServerSettingsChannels.INTENT_EXTRA_GUILD_ID, guildId);
        widgetServerSettingsChannelsFabMenuFragment.setArguments(bundle);
        WidgetServerSettingsChannelsFabMenuFragment.access$setDismissHandler$p(widgetServerSettingsChannelsFabMenuFragment, dismissHandler);
        fragmentManager.beginTransaction().setCustomAnimations(R$anim.anim_fade_in, R$anim.anim_fade_out).add(R$id.widget_server_settings_channels_container, widgetServerSettingsChannelsFabMenuFragment, "channels fab menu").addToBackStack("channels fab menu").commit();
    }

    public /* synthetic */ WidgetServerSettingsChannelsFabMenuFragment$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
