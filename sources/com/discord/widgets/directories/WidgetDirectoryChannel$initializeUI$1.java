package com.discord.widgets.directories;

import android.view.View;
import android.view.View$OnClickListener;
import b.a.d.j;
import com.discord.widgets.hubs.WidgetHubAddServer;

/* JADX INFO: compiled from: WidgetDirectoryChannel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetDirectoryChannel$initializeUI$1 implements View$OnClickListener {
    public final /* synthetic */ WidgetDirectoryChannel this$0;

    public WidgetDirectoryChannel$initializeUI$1(WidgetDirectoryChannel widgetDirectoryChannel) {
        this.this$0 = widgetDirectoryChannel;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        j.g.f(this.this$0.requireContext(), WidgetDirectoryChannel.access$getActivityResult$p(this.this$0), WidgetHubAddServer.class, null);
    }
}
