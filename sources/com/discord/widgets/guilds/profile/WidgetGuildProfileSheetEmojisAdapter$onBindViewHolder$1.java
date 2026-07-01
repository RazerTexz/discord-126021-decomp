package com.discord.widgets.guilds.profile;

import android.view.View;
import android.view.View$OnClickListener;

/* JADX INFO: compiled from: WidgetGuildProfileSheetEmojisAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildProfileSheetEmojisAdapter$onBindViewHolder$1 implements View$OnClickListener {
    public final /* synthetic */ WidgetGuildProfileSheetEmojisAdapter this$0;

    public WidgetGuildProfileSheetEmojisAdapter$onBindViewHolder$1(WidgetGuildProfileSheetEmojisAdapter widgetGuildProfileSheetEmojisAdapter) {
        this.this$0 = widgetGuildProfileSheetEmojisAdapter;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        this.this$0.getOnClickEmoji().invoke();
    }
}
