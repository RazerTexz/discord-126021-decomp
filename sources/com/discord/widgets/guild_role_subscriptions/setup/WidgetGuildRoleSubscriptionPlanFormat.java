package com.discord.widgets.guild_role_subscriptions.setup;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.core.os.BundleKt;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import com.discord.C5419R;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetGuildRoleSubscriptionPlanFormatBinding;
import com.discord.utilities.error.Error;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.views.RadioManager;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p007b.p008a.p018d.C0863f0;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.C12116o;
import p507d0.p580t.C12147n;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12216a0;
import p507d0.p592z.p594d.C12238m;
import p658rx.Subscription;

/* JADX INFO: compiled from: WidgetGuildRoleSubscriptionPlanFormat.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildRoleSubscriptionPlanFormat extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {C1643a.m846d0(WidgetGuildRoleSubscriptionPlanFormat.class, "binding", "getBinding()Lcom/discord/databinding/WidgetGuildRoleSubscriptionPlanFormatBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String INTENT_EXTRA_HIDE_HEADER = "INTENT_EXTRA_HIDE_HEADER";

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private RadioManager radioManager;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* JADX INFO: compiled from: WidgetGuildRoleSubscriptionPlanFormat.kt */
    public static final class Companion {
        private Companion() {
        }

        public static /* synthetic */ WidgetGuildRoleSubscriptionPlanFormat newInstance$default(Companion companion, boolean z2, int i, Object obj) {
            if ((i & 1) != 0) {
                z2 = false;
            }
            return companion.newInstance(z2);
        }

        public final WidgetGuildRoleSubscriptionPlanFormat newInstance(boolean hideHeader) {
            WidgetGuildRoleSubscriptionPlanFormat widgetGuildRoleSubscriptionPlanFormat = new WidgetGuildRoleSubscriptionPlanFormat();
            widgetGuildRoleSubscriptionPlanFormat.setArguments(BundleKt.bundleOf(C12116o.m10073to(WidgetGuildRoleSubscriptionPlanFormat.INTENT_EXTRA_HIDE_HEADER, Boolean.valueOf(hideHeader))));
            return widgetGuildRoleSubscriptionPlanFormat;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.guild_role_subscriptions.setup.WidgetGuildRoleSubscriptionPlanFormat$onViewBoundOrOnResume$1 */
    /* JADX INFO: compiled from: WidgetGuildRoleSubscriptionPlanFormat.kt */
    public static final class C84611 extends AbstractC12240o implements Function1<GuildRoleSubscriptionPlanDetailsViewModel.ViewState, Unit> {
        public C84611() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(GuildRoleSubscriptionPlanDetailsViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(GuildRoleSubscriptionPlanDetailsViewModel.ViewState viewState) {
            C12238m.checkNotNullParameter(viewState, "it");
            WidgetGuildRoleSubscriptionPlanFormat.this.configureUI(viewState);
        }
    }

    public WidgetGuildRoleSubscriptionPlanFormat() {
        super(C5419R.layout.widget_guild_role_subscription_plan_format);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetGuildRoleSubscriptionPlanFormat$binding$2.INSTANCE, null, 2, null);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, C12216a0.getOrCreateKotlinClass(GuildRoleSubscriptionPlanDetailsViewModel.class), new C8457x31680061(this), new C0863f0(WidgetGuildRoleSubscriptionPlanFormat$viewModel$2.INSTANCE));
    }

    private final void configureUI(GuildRoleSubscriptionPlanDetailsViewModel.ViewState viewState) {
        if (viewState.isFullServerGate()) {
            RadioManager radioManager = this.radioManager;
            if (radioManager == null) {
                C12238m.throwUninitializedPropertyAccessException("radioManager");
            }
            GuildRoleSubscriptionPlanFormatRadioButton guildRoleSubscriptionPlanFormatRadioButton = getBinding().f16937e;
            C12238m.checkNotNullExpressionValue(guildRoleSubscriptionPlanFormatRadioButton, "binding.guildRoleSubscri…ionPlanEntireServerFormat");
            radioManager.m8550a(guildRoleSubscriptionPlanFormatRadioButton);
            return;
        }
        RadioManager radioManager2 = this.radioManager;
        if (radioManager2 == null) {
            C12238m.throwUninitializedPropertyAccessException("radioManager");
        }
        GuildRoleSubscriptionPlanFormatRadioButton guildRoleSubscriptionPlanFormatRadioButton2 = getBinding().f16938f;
        C12238m.checkNotNullExpressionValue(guildRoleSubscriptionPlanFormatRadioButton2, "binding.guildRoleSubscri…ionPlanSomeChannelsFormat");
        radioManager2.m8550a(guildRoleSubscriptionPlanFormatRadioButton2);
    }

    private final WidgetGuildRoleSubscriptionPlanFormatBinding getBinding() {
        return (WidgetGuildRoleSubscriptionPlanFormatBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final boolean getHideHeader() {
        Bundle arguments = getArguments();
        if (arguments != null) {
            return arguments.getBoolean(INTENT_EXTRA_HIDE_HEADER, false);
        }
        return false;
    }

    private final GuildRoleSubscriptionPlanDetailsViewModel getViewModel() {
        return (GuildRoleSubscriptionPlanDetailsViewModel) this.viewModel.getValue();
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        C12238m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        this.radioManager = new RadioManager(C12147n.listOf((Object[]) new GuildRoleSubscriptionPlanFormatRadioButton[]{getBinding().f16937e, getBinding().f16938f}));
        getBinding().f16937e.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.guild_role_subscriptions.setup.WidgetGuildRoleSubscriptionPlanFormat.onViewBound.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                WidgetGuildRoleSubscriptionPlanFormat.this.getViewModel().updateFullServerGate(true);
            }
        });
        getBinding().f16938f.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.guild_role_subscriptions.setup.WidgetGuildRoleSubscriptionPlanFormat.onViewBound.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                WidgetGuildRoleSubscriptionPlanFormat.this.getViewModel().updateFullServerGate(false);
            }
        });
        TextView textView = getBinding().f16936d;
        C12238m.checkNotNullExpressionValue(textView, "binding.guildRoleSubscriptionFormatTitle");
        textView.setVisibility(getHideHeader() ^ true ? 0 : 8);
        TextView textView2 = getBinding().f16935c;
        C12238m.checkNotNullExpressionValue(textView2, "binding.guildRoleSubscriptionFormatSubtitle");
        textView2.setVisibility(getHideHeader() ^ true ? 0 : 8);
        View view2 = getBinding().f16934b;
        C12238m.checkNotNullExpressionValue(view2, "binding.guildRoleSubscriptionFormatDivider");
        view2.setVisibility(getHideHeader() ^ true ? 0 : 8);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), (Class<?>) WidgetGuildRoleSubscriptionPlanFormat.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C84611());
    }
}
