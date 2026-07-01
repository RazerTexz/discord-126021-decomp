package com.discord.widgets.guilds.create;

import android.view.View;
import android.view.View$OnClickListener;

/* JADX INFO: compiled from: WidgetCreationIntent.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetCreationIntent$configureCommunityButton$1 implements View$OnClickListener {
    public final /* synthetic */ WidgetCreationIntent this$0;

    public WidgetCreationIntent$configureCommunityButton$1(WidgetCreationIntent widgetCreationIntent) {
        this.this$0 = widgetCreationIntent;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        WidgetCreationIntent.access$onSelectionPressed(this.this$0, Boolean.TRUE);
    }
}
