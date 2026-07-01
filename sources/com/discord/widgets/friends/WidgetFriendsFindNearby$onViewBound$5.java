package com.discord.widgets.friends;

import android.view.View;
import android.view.View$OnClickListener;

/* JADX INFO: compiled from: WidgetFriendsFindNearby.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetFriendsFindNearby$onViewBound$5 implements View$OnClickListener {
    public final /* synthetic */ WidgetFriendsFindNearby this$0;

    public WidgetFriendsFindNearby$onViewBound$5(WidgetFriendsFindNearby widgetFriendsFindNearby) {
        this.this$0 = widgetFriendsFindNearby;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        WidgetFriendsFindNearby.access$enableScanning(this.this$0);
    }
}
