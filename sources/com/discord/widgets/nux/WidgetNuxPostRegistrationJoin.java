package com.discord.widgets.nux;

import android.content.Context;
import android.text.Editable;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import b.a.d.AppScreen2;
import com.discord.R;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.time.ClockFactory;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.widgets.guilds.join.WidgetGuildJoin;
import com.google.android.material.textfield.TextInputLayout;
import d0.g0.StringsJVM;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

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
            Intrinsics3.checkNotNullParameter(context, "context");
            AppScreen2.e(context, WidgetNuxPostRegistrationJoin.class, null, 4);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.nux.WidgetNuxPostRegistrationJoin$onViewBound$2, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetNuxPostRegistrationJoin.kt */
    public static final class AnonymousClass2 extends Lambda implements Function1<Editable, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Editable editable) {
            invoke2(editable);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Editable editable) {
            Intrinsics3.checkNotNullParameter(editable, "editable");
            WidgetNuxPostRegistrationJoin.this.getBinding().f2423b.setText(StringsJVM.isBlank(editable) ? R.string.nux_post_reg_join_server_skip : R.string.join);
        }
    }

    public WidgetNuxPostRegistrationJoin() {
        super(R.layout.widget_nux_post_registration);
    }

    @Override // com.discord.widgets.guilds.join.WidgetGuildJoin, com.discord.app.AppFragment
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        setActionBarDisplayHomeAsUpEnabled(false);
        AnalyticsTracker.newUserOnboarding$default(AnalyticsTracker.INSTANCE, NUX_FLOW_TYPE, GuildTemplateAnalytics.STEP_REGISTRATION, NUX_STEP, null, false, 24, null);
        final long jCurrentTimeMillis = ClockFactory.get().currentTimeMillis();
        getBinding().f2423b.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.nux.WidgetNuxPostRegistrationJoin.onViewBound.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                TextInputLayout textInputLayout = WidgetNuxPostRegistrationJoin.this.getBinding().c;
                Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.guildJoinInvite");
                if (StringsJVM.isBlank(ViewExtensions.getTextOrEmpty(textInputLayout))) {
                    AnalyticsTracker.INSTANCE.newUserOnboarding(WidgetNuxPostRegistrationJoin.NUX_FLOW_TYPE, WidgetNuxPostRegistrationJoin.NUX_STEP, "Friend List", Long.valueOf(jCurrentTimeMillis), true);
                    FragmentActivity fragmentActivityE = WidgetNuxPostRegistrationJoin.this.e();
                    if (fragmentActivityE != null) {
                        fragmentActivityE.onBackPressed();
                        return;
                    }
                    return;
                }
                AnalyticsTracker.INSTANCE.newUserOnboarding(WidgetNuxPostRegistrationJoin.NUX_FLOW_TYPE, WidgetNuxPostRegistrationJoin.NUX_STEP, "Accept Instant Invite", Long.valueOf(jCurrentTimeMillis), false);
                WidgetNuxPostRegistrationJoin.this.handleGuildJoin();
                FragmentActivity fragmentActivityE2 = WidgetNuxPostRegistrationJoin.this.e();
                if (fragmentActivityE2 != null) {
                    fragmentActivityE2.finish();
                }
            }
        });
        TextInputLayout textInputLayout = getBinding().c;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.guildJoinInvite");
        ViewExtensions.addBindedTextWatcher(textInputLayout, this, new AnonymousClass2());
    }
}
