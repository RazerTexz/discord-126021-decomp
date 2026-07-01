package com.discord.widgets.servers;

import android.view.View;
import android.view.View$OnClickListener;
import b.a.d.o;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;

/* JADX INFO: compiled from: WidgetServerSettingsInstantInvitesActions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsInstantInvitesActions$onResume$1 implements View$OnClickListener {
    public final /* synthetic */ String $inviteCode;
    public final /* synthetic */ WidgetServerSettingsInstantInvitesActions this$0;

    public WidgetServerSettingsInstantInvitesActions$onResume$1(WidgetServerSettingsInstantInvitesActions widgetServerSettingsInstantInvitesActions, String str) {
        this.this$0 = widgetServerSettingsInstantInvitesActions;
        this.$inviteCode = str;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.Companion.getApi().revokeInvite(this.$inviteCode), false, 1, null), this.this$0, null, 2, null).k(o.h(new WidgetServerSettingsInstantInvitesActions$sam$rx_functions_Action1$0(new WidgetServerSettingsInstantInvitesActions$onResume$1$1(this.this$0)), this.this$0.getContext(), null));
    }
}
