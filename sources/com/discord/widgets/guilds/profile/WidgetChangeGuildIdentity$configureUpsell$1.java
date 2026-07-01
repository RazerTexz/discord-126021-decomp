package com.discord.widgets.guilds.profile;

import android.view.View;
import android.view.View$OnClickListener;

/* JADX INFO: compiled from: WidgetChangeGuildIdentity.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChangeGuildIdentity$configureUpsell$1 implements View$OnClickListener {
    public final /* synthetic */ WidgetChangeGuildIdentity this$0;

    public WidgetChangeGuildIdentity$configureUpsell$1(WidgetChangeGuildIdentity widgetChangeGuildIdentity) {
        this.this$0 = widgetChangeGuildIdentity;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        WidgetChangeGuildIdentity.access$navigateToUpsellModal(this.this$0);
    }
}
