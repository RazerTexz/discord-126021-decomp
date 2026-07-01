package com.discord.widgets.guilds.join;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.LayoutRes;
import androidx.fragment.app.Fragment;
import b.a.d.AppScreen2;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.app.AppActivity;
import com.discord.app.AppFragment;
import com.discord.app.AppLogger2;
import com.discord.databinding.WidgetGuildJoinBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.stores.StoreInviteSettings;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.intent.IntentUtils;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.google.android.material.textfield.TextInputLayout;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: WidgetGuildJoin.kt */
/* JADX INFO: loaded from: classes2.dex */
public class WidgetGuildJoin extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetGuildJoin.class, "binding", "getBinding()Lcom/discord/databinding/WidgetGuildJoinBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private final AppLogger2 loggingConfig;

    /* JADX INFO: compiled from: WidgetGuildJoin.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void show(Context context, String location) {
            Intrinsics3.checkNotNullParameter(context, "context");
            Intrinsics3.checkNotNullParameter(location, ModelAuditLogEntry.CHANGE_KEY_LOCATION);
            AnalyticsTracker.openModal$default("Join Guild", location, null, 4, null);
            AppScreen2.e(context, ToolbarButton.class, null, 4);
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
            Intrinsics3.checkNotNullParameter(view, "view");
            super.onViewBound(view);
            AnalyticsTracker.INSTANCE.joinGuildViewed();
            AppActivity appActivity = getAppActivity();
            if (appActivity == null || (window = appActivity.getWindow()) == null) {
                return;
            }
            window.setSoftInputMode(36);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.guilds.join.WidgetGuildJoin$onViewBound$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetGuildJoin.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<TextView, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(TextView textView) {
            invoke2(textView);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(TextView textView) {
            Intrinsics3.checkNotNullParameter(textView, "it");
            WidgetGuildJoin.this.handleGuildJoin();
        }
    }

    public WidgetGuildJoin() {
        this(0, 1, null);
    }

    public WidgetGuildJoin(@LayoutRes int i) {
        super(i);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetGuildJoin2.INSTANCE, null, 2, null);
        this.loggingConfig = new AppLogger2(false, null, WidgetGuildJoin3.INSTANCE, 3);
    }

    public final WidgetGuildJoinBinding getBinding() {
        return (WidgetGuildJoinBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    @Override // com.discord.app.AppFragment, com.discord.app.AppLogger.a
    public AppLogger2 getLoggingConfig() {
        return this.loggingConfig;
    }

    public final void handleGuildJoin() {
        TextInputLayout textInputLayout = getBinding().c;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.guildJoinInvite");
        String textOrEmpty = ViewExtensions.getTextOrEmpty(textInputLayout);
        if (textOrEmpty.length() > 0) {
            Intent intentSelectInvite = IntentUtils.RouteBuilders.INSTANCE.selectInvite(textOrEmpty, StoreInviteSettings.LOCATION_JOIN);
            IntentUtils intentUtils = IntentUtils.INSTANCE;
            TextInputLayout textInputLayout2 = getBinding().c;
            Intrinsics3.checkNotNullExpressionValue(textInputLayout2, "binding.guildJoinInvite");
            Context context = textInputLayout2.getContext();
            Intrinsics3.checkNotNullExpressionValue(context, "binding.guildJoinInvite.context");
            IntentUtils.consumeRoutingIntent$default(intentUtils, intentSelectInvite, context, null, 4, null);
        }
    }

    @Override // com.discord.app.AppFragment
    @CallSuper
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        TextInputLayout textInputLayout = getBinding().c;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.guildJoinInvite");
        ViewExtensions.setOnImeActionDone$default(textInputLayout, false, new AnonymousClass1(), 1, null);
        getBinding().f2423b.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.guilds.join.WidgetGuildJoin.onViewBound.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                WidgetGuildJoin.this.handleGuildJoin();
            }
        });
    }

    public /* synthetic */ WidgetGuildJoin(int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? R.layout.widget_guild_join : i);
    }
}
