package com.discord.widgets.nux;

import android.view.View;
import com.discord.R$layout;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.time.ClockFactory;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.widgets.guilds.join.WidgetGuildJoin;
import com.google.android.material.textfield.TextInputLayout;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetNuxPostRegistrationJoin.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetNuxPostRegistrationJoin extends WidgetGuildJoin {
    public static final WidgetNuxPostRegistrationJoin$Companion Companion = new WidgetNuxPostRegistrationJoin$Companion(null);
    private static final String NUX_FLOW_TYPE = "Mobile NUX Post Reg";
    private static final String NUX_STEP = "Ask to join";

    public WidgetNuxPostRegistrationJoin() {
        super(R$layout.widget_nux_post_registration);
    }

    public static final /* synthetic */ void access$handleGuildJoin(WidgetNuxPostRegistrationJoin widgetNuxPostRegistrationJoin) {
        widgetNuxPostRegistrationJoin.handleGuildJoin();
    }

    @Override // com.discord.widgets.guilds.join.WidgetGuildJoin, com.discord.app.AppFragment
    public void onViewBound(View view) {
        m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        setActionBarDisplayHomeAsUpEnabled(false);
        AnalyticsTracker.newUserOnboarding$default(AnalyticsTracker.INSTANCE, NUX_FLOW_TYPE, GuildTemplateAnalytics.STEP_REGISTRATION, NUX_STEP, null, false, 24, null);
        getBinding().f2423b.setOnClickListener(new WidgetNuxPostRegistrationJoin$onViewBound$1(this, ClockFactory.get().currentTimeMillis()));
        TextInputLayout textInputLayout = getBinding().c;
        m.checkNotNullExpressionValue(textInputLayout, "binding.guildJoinInvite");
        ViewExtensions.addBindedTextWatcher(textInputLayout, this, new WidgetNuxPostRegistrationJoin$onViewBound$2(this));
    }
}
