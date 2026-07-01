package com.discord.widgets.settings.guildboost;

import android.view.View;
import android.view.View$OnClickListener;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: SettingsGuildBoostSampleGuildAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class SettingsGuildBoostSampleGuildAdapter$GuildListItem$onConfigure$1 implements View$OnClickListener {
    public final /* synthetic */ SettingsGuildBoostSampleGuildAdapter$Item $data;
    public final /* synthetic */ SettingsGuildBoostSampleGuildAdapter$GuildListItem this$0;

    public SettingsGuildBoostSampleGuildAdapter$GuildListItem$onConfigure$1(SettingsGuildBoostSampleGuildAdapter$GuildListItem settingsGuildBoostSampleGuildAdapter$GuildListItem, SettingsGuildBoostSampleGuildAdapter$Item settingsGuildBoostSampleGuildAdapter$Item) {
        this.this$0 = settingsGuildBoostSampleGuildAdapter$GuildListItem;
        this.$data = settingsGuildBoostSampleGuildAdapter$Item;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        Function1 function1Access$getOnGuildClickedListener$p = SettingsGuildBoostSampleGuildAdapter.access$getOnGuildClickedListener$p(SettingsGuildBoostSampleGuildAdapter$GuildListItem.access$getAdapter$p(this.this$0));
        if (function1Access$getOnGuildClickedListener$p != null) {
        }
    }
}
