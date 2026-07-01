package com.discord.widgets.guilds.profile;

import android.view.View;
import android.view.View$OnClickListener;

/* JADX INFO: compiled from: WidgetChangeGuildIdentity.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChangeGuildIdentity$configureNickname$$inlined$also$lambda$2 implements View$OnClickListener {
    public final /* synthetic */ WidgetChangeGuildIdentityViewModel$ViewState$Loaded $viewState$inlined;
    public final /* synthetic */ WidgetChangeGuildIdentity this$0;

    public WidgetChangeGuildIdentity$configureNickname$$inlined$also$lambda$2(WidgetChangeGuildIdentity widgetChangeGuildIdentity, WidgetChangeGuildIdentityViewModel$ViewState$Loaded widgetChangeGuildIdentityViewModel$ViewState$Loaded) {
        this.this$0 = widgetChangeGuildIdentity;
        this.$viewState$inlined = widgetChangeGuildIdentityViewModel$ViewState$Loaded;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        WidgetChangeGuildIdentity.access$getViewModel$p(this.this$0).updateNickname("");
    }
}
