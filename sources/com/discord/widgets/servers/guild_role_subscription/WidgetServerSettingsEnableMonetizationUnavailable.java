package com.discord.widgets.servers.guild_role_subscription;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import com.discord.R$layout;
import com.discord.app.AppFragment;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetServerSettingsEnableMonetizationUnavailable.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsEnableMonetizationUnavailable extends AppFragment {
    public static final WidgetServerSettingsEnableMonetizationUnavailable$Companion Companion = new WidgetServerSettingsEnableMonetizationUnavailable$Companion(null);

    public WidgetServerSettingsEnableMonetizationUnavailable() {
        super(R$layout.view_server_settings_guild_role_subscription_unavailable_notice);
    }

    public static final void launch(Context context) {
        Companion.launch(context);
    }

    @Override // com.discord.app.AppFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        m.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        AppFragment.setActionBarDisplayHomeAsUpEnabled$default(this, false, 1, null);
    }
}
