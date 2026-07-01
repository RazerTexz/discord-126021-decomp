package com.discord.widgets.servers.member_verification;

import android.view.View;
import android.view.View$OnClickListener;

/* JADX INFO: compiled from: WidgetMemberVerification.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetMemberVerification$configureLoadedUI$1 implements View$OnClickListener {
    public final /* synthetic */ WidgetMemberVerification this$0;

    public WidgetMemberVerification$configureLoadedUI$1(WidgetMemberVerification widgetMemberVerification) {
        this.this$0 = widgetMemberVerification;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        WidgetMemberVerification.access$getViewModel$p(this.this$0).applyToJoinGuild();
    }
}
