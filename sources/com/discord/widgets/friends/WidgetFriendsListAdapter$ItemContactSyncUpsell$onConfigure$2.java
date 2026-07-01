package com.discord.widgets.friends;

import android.view.View;
import android.view.View$OnLongClickListener;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetFriendsListAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetFriendsListAdapter$ItemContactSyncUpsell$onConfigure$2 implements View$OnLongClickListener {
    public final /* synthetic */ WidgetFriendsListAdapter$ItemContactSyncUpsell this$0;

    public WidgetFriendsListAdapter$ItemContactSyncUpsell$onConfigure$2(WidgetFriendsListAdapter$ItemContactSyncUpsell widgetFriendsListAdapter$ItemContactSyncUpsell) {
        this.this$0 = widgetFriendsListAdapter$ItemContactSyncUpsell;
    }

    @Override // android.view.View$OnLongClickListener
    public final boolean onLongClick(View view) {
        Function1<View, Unit> onClickContactSyncUpsellLongClick = WidgetFriendsListAdapter$ItemContactSyncUpsell.access$getAdapter$p(this.this$0).getOnClickContactSyncUpsellLongClick();
        m.checkNotNullExpressionValue(view, "it");
        onClickContactSyncUpsellLongClick.invoke(view);
        return true;
    }
}
