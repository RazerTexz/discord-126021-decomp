package com.discord.widgets.user;

import android.view.View;
import android.view.View$OnClickListener;

/* JADX INFO: compiled from: WidgetUserSetCustomStatus.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetUserSetCustomStatus$setExpirationOnCheck$1 implements View$OnClickListener {
    public final /* synthetic */ WidgetUserSetCustomStatusViewModel$FormState$Expiration $expiration;
    public final /* synthetic */ WidgetUserSetCustomStatus this$0;

    public WidgetUserSetCustomStatus$setExpirationOnCheck$1(WidgetUserSetCustomStatus widgetUserSetCustomStatus, WidgetUserSetCustomStatusViewModel$FormState$Expiration widgetUserSetCustomStatusViewModel$FormState$Expiration) {
        this.this$0 = widgetUserSetCustomStatus;
        this.$expiration = widgetUserSetCustomStatusViewModel$FormState$Expiration;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        WidgetUserSetCustomStatus.access$getViewModel$p(this.this$0).setExpiration(this.$expiration);
    }
}
