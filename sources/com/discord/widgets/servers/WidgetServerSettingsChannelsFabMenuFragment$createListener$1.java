package com.discord.widgets.servers;

import android.view.View;
import android.view.View$OnClickListener;

/* JADX INFO: compiled from: WidgetServerSettingsChannelsFabMenuFragment.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsChannelsFabMenuFragment$createListener$1 implements View$OnClickListener {
    public final /* synthetic */ View$OnClickListener $onClickListener;
    public final /* synthetic */ WidgetServerSettingsChannelsFabMenuFragment this$0;

    public WidgetServerSettingsChannelsFabMenuFragment$createListener$1(WidgetServerSettingsChannelsFabMenuFragment widgetServerSettingsChannelsFabMenuFragment, View$OnClickListener view$OnClickListener) {
        this.this$0 = widgetServerSettingsChannelsFabMenuFragment;
        this.$onClickListener = view$OnClickListener;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        View$OnClickListener view$OnClickListener = this.$onClickListener;
        if (view$OnClickListener != null) {
            view$OnClickListener.onClick(view);
        }
        WidgetServerSettingsChannelsFabMenuFragment.access$dismiss(this.this$0);
    }
}
