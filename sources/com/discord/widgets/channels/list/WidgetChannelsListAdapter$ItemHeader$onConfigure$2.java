package com.discord.widgets.channels.list;

import android.view.View;
import android.view.View$OnClickListener;
import b.d.b.a.a;
import com.discord.widgets.channels.WidgetCreateChannel;
import com.discord.widgets.channels.WidgetCreateChannel$Companion;

/* JADX INFO: compiled from: WidgetChannelsListAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelsListAdapter$ItemHeader$onConfigure$2 implements View$OnClickListener {
    public final /* synthetic */ long $selectedGuildId;

    public WidgetChannelsListAdapter$ItemHeader$onConfigure$2(long j) {
        this.$selectedGuildId = j;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        WidgetCreateChannel$Companion.show$default(WidgetCreateChannel.Companion, a.x(view, "v", "v.context"), this.$selectedGuildId, 2, null, 8, null);
    }
}
