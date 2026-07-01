package com.discord.widgets.guilds.create;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.LayoutRes;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import b.a.d.AppScreen2;
import b.a.k.FormatUtils;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.app.AppFragment;
import com.discord.app.AppLogger2;
import com.discord.databinding.WidgetCreationIntentBinding;
import com.discord.i18n.RenderContext;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.widgets.guilds.create.WidgetGuildCreate;
import com.discord.widgets.nux.GuildTemplateAnalytics;
import com.google.android.material.card.MaterialCardView;
import d0.LazyJVM;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: WidgetCreationIntent.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetCreationIntent extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetCreationIntent.class, "binding", "getBinding()Lcom/discord/databinding/WidgetCreationIntentBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final boolean IS_FRIENDS_FIRST;

    /* JADX INFO: renamed from: args$delegate, reason: from kotlin metadata */
    private final Lazy args;

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private final AppLogger2 loggingConfig;

    /* JADX INFO: compiled from: WidgetCreationIntent.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void show(AppFragment fragment, CreateGuildTrigger trigger, WidgetGuildCreate.Options createGuildOptions) {
            Intrinsics3.checkNotNullParameter(fragment, "fragment");
            Intrinsics3.checkNotNullParameter(trigger, "trigger");
            Intrinsics3.checkNotNullParameter(createGuildOptions, "createGuildOptions");
            AppScreen2.g(AppScreen2.g, fragment.getParentFragmentManager(), fragment.requireContext(), WidgetCreationIntent.class, 0, true, null, new WidgetCreationIntent2(trigger, createGuildOptions), 40);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.guilds.create.WidgetCreationIntent$onViewBound$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetCreationIntent.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<RenderContext, Unit> {

        /* JADX INFO: renamed from: com.discord.widgets.guilds.create.WidgetCreationIntent$onViewBound$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: WidgetCreationIntent.kt */
        public static final class C02921 extends Lambda implements Function1<View, Unit> {
            public C02921() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(View view) {
                invoke2(view);
                return Unit.a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(View view) {
                Intrinsics3.checkNotNullParameter(view, "it");
                WidgetCreationIntent.this.onSelectionPressed(null);
            }
        }

        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(RenderContext renderContext) {
            invoke2(renderContext);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(RenderContext renderContext) {
            Intrinsics3.checkNotNullParameter(renderContext, "$receiver");
            renderContext.b("onSkip", new C02921());
        }
    }

    static {
        IS_FRIENDS_FIRST = Math.random() < 0.5d;
    }

    public WidgetCreationIntent() {
        this(0, 1, null);
    }

    public WidgetCreationIntent(@LayoutRes int i) {
        super(i);
        this.args = LazyJVM.lazy(new WidgetCreationIntent$$special$$inlined$args$1(this, "intent_args_key"));
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetCreationIntent3.INSTANCE, null, 2, null);
        this.loggingConfig = new AppLogger2(false, null, WidgetCreationIntent4.INSTANCE, 3);
    }

    private final void configureCommunityButton(View container, TextView textView) {
        textView.setText(getString(R.string.creation_intent_option_community));
        textView.setCompoundDrawablesWithIntrinsicBounds(ContextCompat.getDrawable(requireContext(), R.drawable.drawable_guild_template_creator), (Drawable) null, ContextCompat.getDrawable(requireContext(), R.drawable.icon_carrot), (Drawable) null);
        container.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.guilds.create.WidgetCreationIntent.configureCommunityButton.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetCreationIntent.this.onSelectionPressed(Boolean.TRUE);
            }
        });
    }

    private final void configureFriendsButton(View container, TextView textView) {
        textView.setText(getString(R.string.creation_intent_option_friends));
        textView.setCompoundDrawablesWithIntrinsicBounds(ContextCompat.getDrawable(requireContext(), R.drawable.drawable_guild_template_community), (Drawable) null, ContextCompat.getDrawable(requireContext(), R.drawable.icon_carrot), (Drawable) null);
        container.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.guilds.create.WidgetCreationIntent.configureFriendsButton.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetCreationIntent.this.onSelectionPressed(Boolean.FALSE);
            }
        });
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
        WidgetGuildCreate.INSTANCE.showFragment(this, getArgs().getCreateGuildOptions());
    }

    public final WidgetCreationIntent2 getArgs() {
        return (WidgetCreationIntent2) this.args.getValue();
    }

    @Override // com.discord.app.AppFragment, com.discord.app.AppLogger.a
    public AppLogger2 getLoggingConfig() {
        return this.loggingConfig;
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        if (IS_FRIENDS_FIRST) {
            MaterialCardView materialCardView = getBinding().f2360b;
            Intrinsics3.checkNotNullExpressionValue(materialCardView, "binding.creationIntentFirstOption");
            TextView textView = getBinding().c;
            Intrinsics3.checkNotNullExpressionValue(textView, "binding.creationIntentFirstOptionText");
            configureFriendsButton(materialCardView, textView);
            MaterialCardView materialCardView2 = getBinding().d;
            Intrinsics3.checkNotNullExpressionValue(materialCardView2, "binding.creationIntentSecondOption");
            TextView textView2 = getBinding().e;
            Intrinsics3.checkNotNullExpressionValue(textView2, "binding.creationIntentSecondOptionText");
            configureCommunityButton(materialCardView2, textView2);
        } else {
            MaterialCardView materialCardView3 = getBinding().f2360b;
            Intrinsics3.checkNotNullExpressionValue(materialCardView3, "binding.creationIntentFirstOption");
            TextView textView3 = getBinding().c;
            Intrinsics3.checkNotNullExpressionValue(textView3, "binding.creationIntentFirstOptionText");
            configureCommunityButton(materialCardView3, textView3);
            MaterialCardView materialCardView4 = getBinding().d;
            Intrinsics3.checkNotNullExpressionValue(materialCardView4, "binding.creationIntentSecondOption");
            TextView textView4 = getBinding().e;
            Intrinsics3.checkNotNullExpressionValue(textView4, "binding.creationIntentSecondOptionText");
            configureFriendsButton(materialCardView4, textView4);
        }
        LinkifiedTextView linkifiedTextView = getBinding().f;
        Intrinsics3.checkNotNullExpressionValue(linkifiedTextView, "binding.creationIntentSkipText");
        FormatUtils.m(linkifiedTextView, R.string.creation_intent_skip, new Object[0], new AnonymousClass1());
    }

    public /* synthetic */ WidgetCreationIntent(int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? R.layout.widget_creation_intent : i);
    }
}
