package com.discord.widgets.contact_sync;

import android.content.Context;
import android.view.View;
import android.view.View$OnClickListener;
import b.a.k.b;
import com.discord.BuildConfig;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.intent.IntentUtils;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetContactSync.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetContactSync$configureUI$10 implements View$OnClickListener {
    public final /* synthetic */ WidgetContactSyncViewModel$ViewState $viewState;
    public final /* synthetic */ WidgetContactSync this$0;

    public WidgetContactSync$configureUI$10(WidgetContactSync widgetContactSync, WidgetContactSyncViewModel$ViewState widgetContactSyncViewModel$ViewState) {
        this.this$0 = widgetContactSync;
        this.$viewState = widgetContactSyncViewModel$ViewState;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        AnalyticsTracker.INSTANCE.friendAddViewed("Invite");
        m.checkNotNullExpressionValue(view, "it");
        Context context = view.getContext();
        m.checkNotNullExpressionValue(context, "it.context");
        IntentUtils.performChooserSendIntent(context, b.k(this.this$0, 2131889506, new Object[]{BuildConfig.HOST, this.$viewState.getUsername()}, null, 4).toString(), b.k(this.this$0, 2131896415, new Object[0], null, 4));
    }
}
