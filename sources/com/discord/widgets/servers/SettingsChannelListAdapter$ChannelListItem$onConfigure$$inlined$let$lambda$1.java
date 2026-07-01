package com.discord.widgets.servers;

import android.view.View;
import android.view.View$OnClickListener;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: SettingsChannelListAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class SettingsChannelListAdapter$ChannelListItem$onConfigure$$inlined$let$lambda$1 implements View$OnClickListener {
    public final /* synthetic */ SettingsChannelListAdapter$ChannelItem $it$inlined;
    public final /* synthetic */ Function1 $onClick;
    public final /* synthetic */ SettingsChannelListAdapter$ChannelListItem this$0;

    public SettingsChannelListAdapter$ChannelListItem$onConfigure$$inlined$let$lambda$1(Function1 function1, SettingsChannelListAdapter$ChannelItem settingsChannelListAdapter$ChannelItem, SettingsChannelListAdapter$ChannelListItem settingsChannelListAdapter$ChannelListItem) {
        this.$onClick = function1;
        this.$it$inlined = settingsChannelListAdapter$ChannelItem;
        this.this$0 = settingsChannelListAdapter$ChannelListItem;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        this.$onClick.invoke(Long.valueOf(this.$it$inlined.getChannel().getId()));
    }
}
