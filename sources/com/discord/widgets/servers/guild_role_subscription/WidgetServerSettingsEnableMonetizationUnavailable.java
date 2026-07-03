package com.discord.widgets.servers.guild_role_subscription;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import com.discord.C5419R;
import com.discord.app.AppFragment;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p008a.p018d.C0870j;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetServerSettingsEnableMonetizationUnavailable.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsEnableMonetizationUnavailable extends AppFragment {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: compiled from: WidgetServerSettingsEnableMonetizationUnavailable.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void launch(Context context) {
            C12238m.checkNotNullParameter(context, "context");
            C0870j.m157e(context, WidgetServerSettingsEnableMonetizationUnavailable.class, null, 4);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public WidgetServerSettingsEnableMonetizationUnavailable() {
        super(C5419R.layout.view_server_settings_guild_role_subscription_unavailable_notice);
    }

    public static final void launch(Context context) {
        INSTANCE.launch(context);
    }

    @Override // com.discord.app.AppFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        C12238m.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        AppFragment.setActionBarDisplayHomeAsUpEnabled$default(this, false, 1, null);
    }
}
