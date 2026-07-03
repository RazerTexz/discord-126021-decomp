package com.discord.widgets.nux;

import android.content.Context;
import android.text.Editable;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.discord.C5419R;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.time.ClockFactory;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.widgets.guilds.join.WidgetGuildJoin;
import com.google.android.material.textfield.TextInputLayout;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p008a.p018d.C0870j;
import p507d0.p579g0.C12103t;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetNuxPostRegistrationJoin.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetNuxPostRegistrationJoin extends WidgetGuildJoin {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String NUX_FLOW_TYPE = "Mobile NUX Post Reg";
    private static final String NUX_STEP = "Ask to join";

    /* JADX INFO: compiled from: WidgetNuxPostRegistrationJoin.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void show(Context context) {
            C12238m.checkNotNullParameter(context, "context");
            C0870j.m157e(context, WidgetNuxPostRegistrationJoin.class, null, 4);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.nux.WidgetNuxPostRegistrationJoin$onViewBound$2 */
    /* JADX INFO: compiled from: WidgetNuxPostRegistrationJoin.kt */
    public static final class C91142 extends AbstractC12240o implements Function1<Editable, Unit> {
        public C91142() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Editable editable) {
            invoke2(editable);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Editable editable) {
            C12238m.checkNotNullParameter(editable, "editable");
            WidgetNuxPostRegistrationJoin.this.getBinding().f16852b.setText(C12103t.isBlank(editable) ? C5419R.string.nux_post_reg_join_server_skip : C5419R.string.join);
        }
    }

    public WidgetNuxPostRegistrationJoin() {
        super(C5419R.layout.widget_nux_post_registration);
    }

    @Override // com.discord.widgets.guilds.join.WidgetGuildJoin, com.discord.app.AppFragment
    public void onViewBound(View view) {
        C12238m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        setActionBarDisplayHomeAsUpEnabled(false);
        AnalyticsTracker.newUserOnboarding$default(AnalyticsTracker.INSTANCE, NUX_FLOW_TYPE, GuildTemplateAnalytics.STEP_REGISTRATION, NUX_STEP, null, false, 24, null);
        final long jCurrentTimeMillis = ClockFactory.get().currentTimeMillis();
        getBinding().f16852b.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.nux.WidgetNuxPostRegistrationJoin.onViewBound.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                TextInputLayout textInputLayout = WidgetNuxPostRegistrationJoin.this.getBinding().f16853c;
                C12238m.checkNotNullExpressionValue(textInputLayout, "binding.guildJoinInvite");
                if (C12103t.isBlank(ViewExtensions.getTextOrEmpty(textInputLayout))) {
                    AnalyticsTracker.INSTANCE.newUserOnboarding(WidgetNuxPostRegistrationJoin.NUX_FLOW_TYPE, WidgetNuxPostRegistrationJoin.NUX_STEP, "Friend List", Long.valueOf(jCurrentTimeMillis), true);
                    FragmentActivity fragmentActivityM95e = WidgetNuxPostRegistrationJoin.this.m95e();
                    if (fragmentActivityM95e != null) {
                        fragmentActivityM95e.onBackPressed();
                        return;
                    }
                    return;
                }
                AnalyticsTracker.INSTANCE.newUserOnboarding(WidgetNuxPostRegistrationJoin.NUX_FLOW_TYPE, WidgetNuxPostRegistrationJoin.NUX_STEP, "Accept Instant Invite", Long.valueOf(jCurrentTimeMillis), false);
                WidgetNuxPostRegistrationJoin.this.handleGuildJoin();
                FragmentActivity fragmentActivityM95e2 = WidgetNuxPostRegistrationJoin.this.m95e();
                if (fragmentActivityM95e2 != null) {
                    fragmentActivityM95e2.finish();
                }
            }
        });
        TextInputLayout textInputLayout = getBinding().f16853c;
        C12238m.checkNotNullExpressionValue(textInputLayout, "binding.guildJoinInvite");
        ViewExtensions.addBindedTextWatcher(textInputLayout, this, new C91142());
    }
}
