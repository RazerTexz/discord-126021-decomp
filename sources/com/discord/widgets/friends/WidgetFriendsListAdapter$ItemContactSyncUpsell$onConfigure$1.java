package com.discord.widgets.friends;

import android.view.View;
import android.view.View$OnClickListener;

/* JADX INFO: compiled from: WidgetFriendsListAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetFriendsListAdapter$ItemContactSyncUpsell$onConfigure$1 implements View$OnClickListener {
    public final /* synthetic */ WidgetFriendsListAdapter$ItemContactSyncUpsell this$0;

    public WidgetFriendsListAdapter$ItemContactSyncUpsell$onConfigure$1(WidgetFriendsListAdapter$ItemContactSyncUpsell widgetFriendsListAdapter$ItemContactSyncUpsell) {
        this.this$0 = widgetFriendsListAdapter$ItemContactSyncUpsell;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        WidgetFriendsListAdapter$ItemContactSyncUpsell.access$getAdapter$p(this.this$0).getOnClickContactSyncUpsell().invoke();
    }
}
