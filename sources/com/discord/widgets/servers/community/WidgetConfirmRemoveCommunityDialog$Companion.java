package com.discord.widgets.servers.community;

import android.os.Bundle;
import androidx.fragment.app.FragmentManager;
import com.discord.widgets.servers.WidgetServerSettingsChannels;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetConfirmRemoveCommunityDialog.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetConfirmRemoveCommunityDialog$Companion {
    private WidgetConfirmRemoveCommunityDialog$Companion() {
    }

    public final void show(FragmentManager supportFragmentManager, long guildId) {
        m.checkNotNullParameter(supportFragmentManager, "supportFragmentManager");
        WidgetConfirmRemoveCommunityDialog widgetConfirmRemoveCommunityDialog = new WidgetConfirmRemoveCommunityDialog();
        Bundle bundle = new Bundle();
        bundle.putLong(WidgetServerSettingsChannels.INTENT_EXTRA_GUILD_ID, guildId);
        widgetConfirmRemoveCommunityDialog.setArguments(bundle);
        widgetConfirmRemoveCommunityDialog.show(supportFragmentManager, WidgetConfirmRemoveCommunityDialog.class.getSimpleName());
    }

    public /* synthetic */ WidgetConfirmRemoveCommunityDialog$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
