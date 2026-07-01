package com.discord.widgets.servers;

import android.os.Bundle;
import androidx.fragment.app.FragmentManager;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetServerSettingsInstantInvitesActions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsInstantInvitesActions$Companion {
    private WidgetServerSettingsInstantInvitesActions$Companion() {
    }

    public final void create(FragmentManager fragmentManager, String inviteCode) {
        m.checkNotNullParameter(fragmentManager, "fragmentManager");
        m.checkNotNullParameter(inviteCode, "inviteCode");
        WidgetServerSettingsInstantInvitesActions widgetServerSettingsInstantInvitesActions = new WidgetServerSettingsInstantInvitesActions();
        Bundle bundle = new Bundle();
        bundle.putString("ARG_INVITE_CODE", inviteCode);
        widgetServerSettingsInstantInvitesActions.setArguments(bundle);
        widgetServerSettingsInstantInvitesActions.show(fragmentManager, WidgetServerSettingsInstantInvitesActions.class.getName());
    }

    public /* synthetic */ WidgetServerSettingsInstantInvitesActions$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
