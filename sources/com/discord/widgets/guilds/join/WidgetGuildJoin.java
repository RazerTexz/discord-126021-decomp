package com.discord.widgets.guilds.join;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.LayoutRes;
import androidx.fragment.app.Fragment;
import com.discord.C5419R;
import com.discord.app.AppActivity;
import com.discord.app.AppFragment;
import com.discord.app.LoggingConfig;
import com.discord.databinding.WidgetGuildJoinBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.stores.StoreInviteSettings;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.intent.IntentUtils;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.google.android.material.textfield.TextInputLayout;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p007b.p008a.p018d.C0870j;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetGuildJoin.kt */
/* JADX INFO: loaded from: classes2.dex */
public class WidgetGuildJoin extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {C1643a.m846d0(WidgetGuildJoin.class, "binding", "getBinding()Lcom/discord/databinding/WidgetGuildJoinBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private final LoggingConfig loggingConfig;

    /* JADX INFO: compiled from: WidgetGuildJoin.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void show(Context context, String location) {
            C12238m.checkNotNullParameter(context, "context");
            C12238m.checkNotNullParameter(location, ModelAuditLogEntry.CHANGE_KEY_LOCATION);
            AnalyticsTracker.openModal$default("Join Guild", location, null, 4, null);
            C0870j.m157e(context, ToolbarButton.class, null, 4);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: WidgetGuildJoin.kt */
    public static final class ToolbarButton extends WidgetGuildJoin {
        public ToolbarButton() {
            super(0, 1, null);
        }

        @Override // com.discord.widgets.guilds.join.WidgetGuildJoin, com.discord.app.AppFragment
        public void onViewBound(View view) {
            Window window;
            C12238m.checkNotNullParameter(view, "view");
            super.onViewBound(view);
            AnalyticsTracker.INSTANCE.joinGuildViewed();
            AppActivity appActivity = getAppActivity();
            if (appActivity == null || (window = appActivity.getWindow()) == null) {
                return;
            }
            window.setSoftInputMode(36);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.guilds.join.WidgetGuildJoin$onViewBound$1 */
    /* JADX INFO: compiled from: WidgetGuildJoin.kt */
    public static final class C87171 extends AbstractC12240o implements Function1<TextView, Unit> {
        public C87171() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(TextView textView) {
            invoke2(textView);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(TextView textView) {
            C12238m.checkNotNullParameter(textView, "it");
            WidgetGuildJoin.this.handleGuildJoin();
        }
    }

    public WidgetGuildJoin() {
        this(0, 1, null);
    }

    public WidgetGuildJoin(@LayoutRes int i) {
        super(i);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetGuildJoin$binding$2.INSTANCE, null, 2, null);
        this.loggingConfig = new LoggingConfig(false, null, WidgetGuildJoin$loggingConfig$1.INSTANCE, 3);
    }

    public final WidgetGuildJoinBinding getBinding() {
        return (WidgetGuildJoinBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    @Override // com.discord.app.AppFragment, com.discord.app.AppLogger.InterfaceC5455a
    public LoggingConfig getLoggingConfig() {
        return this.loggingConfig;
    }

    public final void handleGuildJoin() {
        TextInputLayout textInputLayout = getBinding().f16853c;
        C12238m.checkNotNullExpressionValue(textInputLayout, "binding.guildJoinInvite");
        String textOrEmpty = ViewExtensions.getTextOrEmpty(textInputLayout);
        if (textOrEmpty.length() > 0) {
            Intent intentSelectInvite = IntentUtils.RouteBuilders.INSTANCE.selectInvite(textOrEmpty, StoreInviteSettings.LOCATION_JOIN);
            IntentUtils intentUtils = IntentUtils.INSTANCE;
            TextInputLayout textInputLayout2 = getBinding().f16853c;
            C12238m.checkNotNullExpressionValue(textInputLayout2, "binding.guildJoinInvite");
            Context context = textInputLayout2.getContext();
            C12238m.checkNotNullExpressionValue(context, "binding.guildJoinInvite.context");
            IntentUtils.consumeRoutingIntent$default(intentUtils, intentSelectInvite, context, null, 4, null);
        }
    }

    @Override // com.discord.app.AppFragment
    @CallSuper
    public void onViewBound(View view) {
        C12238m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        TextInputLayout textInputLayout = getBinding().f16853c;
        C12238m.checkNotNullExpressionValue(textInputLayout, "binding.guildJoinInvite");
        ViewExtensions.setOnImeActionDone$default(textInputLayout, false, new C87171(), 1, null);
        getBinding().f16852b.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.guilds.join.WidgetGuildJoin.onViewBound.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                WidgetGuildJoin.this.handleGuildJoin();
            }
        });
    }

    public /* synthetic */ WidgetGuildJoin(int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? C5419R.layout.widget_guild_join : i);
    }
}
