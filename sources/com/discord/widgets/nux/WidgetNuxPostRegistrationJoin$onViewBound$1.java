package com.discord.widgets.nux;

import android.view.View;
import android.view.View$OnClickListener;
import androidx.fragment.app.FragmentActivity;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.google.android.material.textfield.TextInputLayout;
import d0.g0.t;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetNuxPostRegistrationJoin.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetNuxPostRegistrationJoin$onViewBound$1 implements View$OnClickListener {
    public final /* synthetic */ long $startTimeMs;
    public final /* synthetic */ WidgetNuxPostRegistrationJoin this$0;

    public WidgetNuxPostRegistrationJoin$onViewBound$1(WidgetNuxPostRegistrationJoin widgetNuxPostRegistrationJoin, long j) {
        this.this$0 = widgetNuxPostRegistrationJoin;
        this.$startTimeMs = j;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        TextInputLayout textInputLayout = this.this$0.getBinding().c;
        m.checkNotNullExpressionValue(textInputLayout, "binding.guildJoinInvite");
        if (t.isBlank(ViewExtensions.getTextOrEmpty(textInputLayout))) {
            AnalyticsTracker.INSTANCE.newUserOnboarding("Mobile NUX Post Reg", "Ask to join", "Friend List", Long.valueOf(this.$startTimeMs), true);
            FragmentActivity activity = this.this$0.getActivity();
            if (activity != null) {
                activity.onBackPressed();
                return;
            }
            return;
        }
        AnalyticsTracker.INSTANCE.newUserOnboarding("Mobile NUX Post Reg", "Ask to join", "Accept Instant Invite", Long.valueOf(this.$startTimeMs), false);
        WidgetNuxPostRegistrationJoin.access$handleGuildJoin(this.this$0);
        FragmentActivity activity2 = this.this$0.getActivity();
        if (activity2 != null) {
            activity2.finish();
        }
    }
}
