package com.discord.widgets.guilds.profile;

import androidx.fragment.app.FragmentManager;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetPublicAnnouncementProfileSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetPublicAnnouncementProfileSheet$Companion {
    private WidgetPublicAnnouncementProfileSheet$Companion() {
    }

    public final void show(FragmentManager fragmentManager) {
        m.checkNotNullParameter(fragmentManager, "fragmentManager");
        new WidgetPublicAnnouncementProfileSheet().show(fragmentManager, WidgetPublicAnnouncementProfileSheet.class.getName());
    }

    public /* synthetic */ WidgetPublicAnnouncementProfileSheet$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
