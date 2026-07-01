package com.discord.widgets.directories;

import android.content.Context;
import android.view.View;
import android.view.View$OnClickListener;
import b.a.d.j;
import com.discord.api.channel.Channel;
import com.discord.views.directories.ServerDiscoveryHeader;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetDirectoryChannel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetDirectoryChannel$configureUi$$inlined$apply$lambda$1 implements View$OnClickListener {
    public final /* synthetic */ WidgetDirectoriesViewModel$ViewState $state$inlined;
    public final /* synthetic */ ServerDiscoveryHeader $this_apply;

    public WidgetDirectoryChannel$configureUi$$inlined$apply$lambda$1(ServerDiscoveryHeader serverDiscoveryHeader, WidgetDirectoriesViewModel$ViewState widgetDirectoriesViewModel$ViewState) {
        this.$this_apply = serverDiscoveryHeader;
        this.$state$inlined = widgetDirectoriesViewModel$ViewState;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        Channel channel = this.$state$inlined.getChannel();
        if (channel != null) {
            long id2 = channel.getId();
            Context context = this.$this_apply.getContext();
            m.checkNotNullExpressionValue(context, "context");
            j.d(context, WidgetDirectoriesSearch.class, new DirectoriesSearchArgs(id2));
        }
    }
}
