package com.discord.widgets.guilds.create;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.LayoutRes;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import b.a.k.b;
import b.d.b.a.a;
import com.discord.R$layout;
import com.discord.app.AppFragment;
import com.discord.app.LoggingConfig;
import com.discord.databinding.WidgetCreationIntentBinding;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.widgets.nux.GuildTemplateAnalytics;
import com.google.android.material.card.MaterialCardView;
import d0.g;
import d0.z.d.m;
import kotlin.Lazy;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: WidgetCreationIntent.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetCreationIntent extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetCreationIntent.class, "binding", "getBinding()Lcom/discord/databinding/WidgetCreationIntentBinding;", 0)};
    public static final WidgetCreationIntent$Companion Companion = new WidgetCreationIntent$Companion(null);
    private static final boolean IS_FRIENDS_FIRST;

    /* JADX INFO: renamed from: args$delegate, reason: from kotlin metadata */
    private final Lazy args;

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private final LoggingConfig loggingConfig;

    static {
        IS_FRIENDS_FIRST = Math.random() < 0.5d;
    }

    public WidgetCreationIntent() {
        this(0, 1, null);
    }

    public WidgetCreationIntent(@LayoutRes int i) {
        super(i);
        this.args = g.lazy(new WidgetCreationIntent$$special$$inlined$args$1(this, "intent_args_key"));
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetCreationIntent$binding$2.INSTANCE, null, 2, null);
        this.loggingConfig = new LoggingConfig(false, null, WidgetCreationIntent$loggingConfig$1.INSTANCE, 3);
    }

    public static final /* synthetic */ void access$onSelectionPressed(WidgetCreationIntent widgetCreationIntent, Boolean bool) {
        widgetCreationIntent.onSelectionPressed(bool);
    }

    private final void configureCommunityButton(View container, TextView textView) {
        textView.setText(getString(2131888271));
        textView.setCompoundDrawablesWithIntrinsicBounds(ContextCompat.getDrawable(requireContext(), 2131231237), (Drawable) null, ContextCompat.getDrawable(requireContext(), 2131232268), (Drawable) null);
        container.setOnClickListener(new WidgetCreationIntent$configureCommunityButton$1(this));
    }

    private final void configureFriendsButton(View container, TextView textView) {
        textView.setText(getString(2131888272));
        textView.setCompoundDrawablesWithIntrinsicBounds(ContextCompat.getDrawable(requireContext(), 2131231235), (Drawable) null, ContextCompat.getDrawable(requireContext(), 2131232268), (Drawable) null);
        container.setOnClickListener(new WidgetCreationIntent$configureFriendsButton$1(this));
    }

    private final WidgetCreationIntentBinding getBinding() {
        return (WidgetCreationIntentBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final void onSelectionPressed(Boolean isCommunity) {
        AnalyticsTracker.INSTANCE.guildCreationIntentSelected(isCommunity);
        if (getArgs().getTrigger() == CreateGuildTrigger.NUF) {
            GuildTemplateAnalytics.INSTANCE.postRegistrationTransition$app_productionGoogleRelease(GuildTemplateAnalytics.STEP_CREATION_INTENT, "Guild Create");
        } else {
            AnalyticsTracker.openModal$default("Create Guild Step 2", getArgs().getCreateGuildOptions().getAnalyticsLocation(), null, 4, null);
        }
        WidgetGuildCreate.Companion.showFragment(this, getArgs().getCreateGuildOptions());
    }

    public final CreationIntentArgs getArgs() {
        return (CreationIntentArgs) this.args.getValue();
    }

    @Override // com.discord.app.AppFragment, com.discord.app.AppLogger$a
    public LoggingConfig getLoggingConfig() {
        return this.loggingConfig;
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        if (IS_FRIENDS_FIRST) {
            MaterialCardView materialCardView = getBinding().f2360b;
            m.checkNotNullExpressionValue(materialCardView, "binding.creationIntentFirstOption");
            TextView textView = getBinding().c;
            m.checkNotNullExpressionValue(textView, "binding.creationIntentFirstOptionText");
            configureFriendsButton(materialCardView, textView);
            MaterialCardView materialCardView2 = getBinding().d;
            m.checkNotNullExpressionValue(materialCardView2, "binding.creationIntentSecondOption");
            TextView textView2 = getBinding().e;
            m.checkNotNullExpressionValue(textView2, "binding.creationIntentSecondOptionText");
            configureCommunityButton(materialCardView2, textView2);
        } else {
            MaterialCardView materialCardView3 = getBinding().f2360b;
            m.checkNotNullExpressionValue(materialCardView3, "binding.creationIntentFirstOption");
            TextView textView3 = getBinding().c;
            m.checkNotNullExpressionValue(textView3, "binding.creationIntentFirstOptionText");
            configureCommunityButton(materialCardView3, textView3);
            MaterialCardView materialCardView4 = getBinding().d;
            m.checkNotNullExpressionValue(materialCardView4, "binding.creationIntentSecondOption");
            TextView textView4 = getBinding().e;
            m.checkNotNullExpressionValue(textView4, "binding.creationIntentSecondOptionText");
            configureFriendsButton(materialCardView4, textView4);
        }
        LinkifiedTextView linkifiedTextView = getBinding().f;
        m.checkNotNullExpressionValue(linkifiedTextView, "binding.creationIntentSkipText");
        b.m(linkifiedTextView, 2131888273, new Object[0], new WidgetCreationIntent$onViewBound$1(this));
    }

    public /* synthetic */ WidgetCreationIntent(int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? R$layout.widget_creation_intent : i);
    }
}
