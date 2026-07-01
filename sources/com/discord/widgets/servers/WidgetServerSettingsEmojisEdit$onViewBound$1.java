package com.discord.widgets.servers;

import android.view.View;
import android.view.View$OnClickListener;

/* JADX INFO: compiled from: WidgetServerSettingsEmojisEdit.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsEmojisEdit$onViewBound$1 implements View$OnClickListener {
    public final /* synthetic */ WidgetServerSettingsEmojisEdit this$0;

    public WidgetServerSettingsEmojisEdit$onViewBound$1(WidgetServerSettingsEmojisEdit widgetServerSettingsEmojisEdit) {
        this.this$0 = widgetServerSettingsEmojisEdit;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        WidgetServerSettingsEmojisEdit.access$handleSaveAlias(this.this$0);
    }
}
