package com.discord.widgets.servers;

import android.view.View;
import android.view.View$OnClickListener;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: SettingsChannelListAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class SettingsChannelListAdapter$CategoryListItem$onConfigure$$inlined$let$lambda$1 implements View$OnClickListener {
    public final /* synthetic */ SettingsChannelListAdapter$CategoryItem $it$inlined;
    public final /* synthetic */ Function1 $onClick;
    public final /* synthetic */ SettingsChannelListAdapter$CategoryListItem this$0;

    public SettingsChannelListAdapter$CategoryListItem$onConfigure$$inlined$let$lambda$1(Function1 function1, SettingsChannelListAdapter$CategoryItem settingsChannelListAdapter$CategoryItem, SettingsChannelListAdapter$CategoryListItem settingsChannelListAdapter$CategoryListItem) {
        this.$onClick = function1;
        this.$it$inlined = settingsChannelListAdapter$CategoryItem;
        this.this$0 = settingsChannelListAdapter$CategoryListItem;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        this.$onClick.invoke(Long.valueOf(this.$it$inlined.getId()));
    }
}
