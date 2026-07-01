package com.discord.widgets.announcements;

import androidx.fragment.app.FragmentManager;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetChannelFollowSuccessDialog.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelFollowSuccessDialog$Companion {
    private WidgetChannelFollowSuccessDialog$Companion() {
    }

    public final void show(FragmentManager fragmentManager) {
        m.checkNotNullParameter(fragmentManager, "fragmentManager");
        new WidgetChannelFollowSuccessDialog().show(fragmentManager, WidgetChannelFollowSuccessDialog.class.getSimpleName());
    }

    public /* synthetic */ WidgetChannelFollowSuccessDialog$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
