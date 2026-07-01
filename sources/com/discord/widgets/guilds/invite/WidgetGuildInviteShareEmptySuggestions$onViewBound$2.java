package com.discord.widgets.guilds.invite;

import android.view.View;
import android.view.View$OnClickListener;

/* JADX INFO: compiled from: WidgetGuildInviteShareEmptySuggestions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildInviteShareEmptySuggestions$onViewBound$2 implements View$OnClickListener {
    public final /* synthetic */ WidgetGuildInviteShareEmptySuggestions this$0;

    public WidgetGuildInviteShareEmptySuggestions$onViewBound$2(WidgetGuildInviteShareEmptySuggestions widgetGuildInviteShareEmptySuggestions) {
        this.this$0 = widgetGuildInviteShareEmptySuggestions;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        WidgetGuildInviteShareEmptySuggestions.access$getBottomSheetBehavior$p(this.this$0).setState(5);
    }
}
