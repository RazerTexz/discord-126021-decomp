package com.discord.widgets.servers;

import android.os.Bundle;
import androidx.fragment.app.FragmentManager;
import b.d.b.a.a;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetServerSettingsTransferOwnership.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsTransferOwnership$Companion {
    private WidgetServerSettingsTransferOwnership$Companion() {
    }

    public final void create(long guildId, long userId, FragmentManager fragmentManager) {
        m.checkNotNullParameter(fragmentManager, "fragmentManager");
        WidgetServerSettingsTransferOwnership widgetServerSettingsTransferOwnership = new WidgetServerSettingsTransferOwnership();
        Bundle bundleT = a.T("ARG_GUILD_ID", guildId);
        bundleT.putLong("ARG_USER_ID", userId);
        widgetServerSettingsTransferOwnership.setArguments(bundleT);
        widgetServerSettingsTransferOwnership.show(fragmentManager, WidgetServerSettingsTransferOwnership.access$getTAG$cp());
    }

    public /* synthetic */ WidgetServerSettingsTransferOwnership$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
