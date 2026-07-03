package com.discord.widgets.guild_role_subscriptions.entrypoint;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import com.discord.C5419R;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetGuildRoleSubscriptionEntryPointBinding;
import com.discord.i18n.Hook;
import com.discord.i18n.RenderContext;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.error.Error;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.widgets.guild_role_subscriptions.entrypoint.WidgetGuildRoleSubscriptionEntryPointViewModel;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p007b.p008a.p018d.C0865g0;
import p007b.p008a.p018d.C0869i0;
import p007b.p008a.p018d.C0870j;
import p007b.p008a.p027k.C1107b;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12216a0;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;
import p658rx.Subscription;

/* JADX INFO: compiled from: WidgetGuildRoleSubscriptionEntryPoint.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildRoleSubscriptionEntryPoint extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {C1643a.m846d0(WidgetGuildRoleSubscriptionEntryPoint.class, "viewBinding", "getViewBinding()Lcom/discord/databinding/WidgetGuildRoleSubscriptionEntryPointBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String INTENT_EXTRA_TRACKING_SOURCE_LOCATION = "INTENT_EXTRA_TRACKING_SOURCE_LOCATION";

    /* JADX INFO: renamed from: viewBinding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate viewBinding;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* JADX INFO: compiled from: WidgetGuildRoleSubscriptionEntryPoint.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void launch(Context context, long guildId, String trackingSourceLocation) {
            C12238m.checkNotNullParameter(context, "context");
            C12238m.checkNotNullParameter(trackingSourceLocation, "trackingSourceLocation");
            Intent intent = new Intent();
            intent.putExtra("com.discord.intent.extra.EXTRA_GUILD_ID", guildId);
            intent.putExtra(WidgetGuildRoleSubscriptionEntryPoint.INTENT_EXTRA_TRACKING_SOURCE_LOCATION, trackingSourceLocation);
            C0870j.m156d(context, WidgetGuildRoleSubscriptionEntryPoint.class, intent);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.guild_role_subscriptions.entrypoint.WidgetGuildRoleSubscriptionEntryPoint$configureUI$1 */
    /* JADX INFO: compiled from: WidgetGuildRoleSubscriptionEntryPoint.kt */
    public static final class C84441 extends AbstractC12240o implements Function1<RenderContext, Unit> {
        public final /* synthetic */ WidgetGuildRoleSubscriptionEntryPointViewModel.ViewState $viewState;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C84441(WidgetGuildRoleSubscriptionEntryPointViewModel.ViewState viewState) {
            super(1);
            this.$viewState = viewState;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(RenderContext renderContext) {
            C12238m.checkNotNullParameter(renderContext, "$receiver");
            renderContext.args.put("serverName", ((WidgetGuildRoleSubscriptionEntryPointViewModel.ViewState.Valid) this.$viewState).getGuild().getName());
            renderContext.m8422a("serverNameHook", new AnonymousClass1());
        }

        /* JADX INFO: renamed from: com.discord.widgets.guild_role_subscriptions.entrypoint.WidgetGuildRoleSubscriptionEntryPoint$configureUI$1$1, reason: invalid class name */
        /* JADX INFO: compiled from: WidgetGuildRoleSubscriptionEntryPoint.kt */
        public static final class AnonymousClass1 extends AbstractC12240o implements Function1<Hook, Unit> {
            public AnonymousClass1() {
                super(1);
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Hook hook) {
                C12238m.checkNotNullParameter(hook, "$receiver");
                hook.styles.add(new ForegroundColorSpan(ColorCompat.getThemedColor(WidgetGuildRoleSubscriptionEntryPoint.this.getContext(), C5419R.attr.primary_000)));
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Hook hook) {
                invoke2(hook);
                return Unit.f27425a;
            }
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(RenderContext renderContext) {
            invoke2(renderContext);
            return Unit.f27425a;
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.guild_role_subscriptions.entrypoint.WidgetGuildRoleSubscriptionEntryPoint$onViewBoundOrOnResume$1 */
    /* JADX INFO: compiled from: WidgetGuildRoleSubscriptionEntryPoint.kt */
    public static final /* synthetic */ class C84451 extends C12236k implements Function1<WidgetGuildRoleSubscriptionEntryPointViewModel.ViewState, Unit> {
        public C84451(WidgetGuildRoleSubscriptionEntryPoint widgetGuildRoleSubscriptionEntryPoint) {
            super(1, widgetGuildRoleSubscriptionEntryPoint, WidgetGuildRoleSubscriptionEntryPoint.class, "configureUI", "configureUI(Lcom/discord/widgets/guild_role_subscriptions/entrypoint/WidgetGuildRoleSubscriptionEntryPointViewModel$ViewState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetGuildRoleSubscriptionEntryPointViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetGuildRoleSubscriptionEntryPointViewModel.ViewState viewState) {
            C12238m.checkNotNullParameter(viewState, "p1");
            ((WidgetGuildRoleSubscriptionEntryPoint) this.receiver).configureUI(viewState);
        }
    }

    public WidgetGuildRoleSubscriptionEntryPoint() {
        super(C5419R.layout.widget_guild_role_subscription_entry_point);
        this.viewBinding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetGuildRoleSubscriptionEntryPoint$viewBinding$2.INSTANCE, null, 2, null);
        WidgetGuildRoleSubscriptionEntryPoint$viewModel$2 widgetGuildRoleSubscriptionEntryPoint$viewModel$2 = WidgetGuildRoleSubscriptionEntryPoint$viewModel$2.INSTANCE;
        C0865g0 c0865g0 = new C0865g0(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, C12216a0.getOrCreateKotlinClass(WidgetGuildRoleSubscriptionEntryPointViewModel.class), new C8443x20004241(c0865g0), new C0869i0(widgetGuildRoleSubscriptionEntryPoint$viewModel$2));
    }

    private final void configureUI(WidgetGuildRoleSubscriptionEntryPointViewModel.ViewState viewState) {
        if (viewState instanceof WidgetGuildRoleSubscriptionEntryPointViewModel.ViewState.Uninitialized) {
            TextView textView = getViewBinding().f16922b;
            C12238m.checkNotNullExpressionValue(textView, "viewBinding.description");
            textView.setVisibility(8);
        } else {
            if (viewState instanceof WidgetGuildRoleSubscriptionEntryPointViewModel.ViewState.Invalid) {
                requireActivity().onBackPressed();
                return;
            }
            if (viewState instanceof WidgetGuildRoleSubscriptionEntryPointViewModel.ViewState.Valid) {
                TextView textView2 = getViewBinding().f16923c;
                C12238m.checkNotNullExpressionValue(textView2, "viewBinding.title");
                C1107b.m221m(textView2, C5419R.string.guild_role_subscription_purchase_page_unavailable_cta_hook, new Object[0], new C84441(viewState));
                TextView textView3 = getViewBinding().f16922b;
                C12238m.checkNotNullExpressionValue(textView3, "viewBinding.description");
                textView3.setVisibility(0);
            }
        }
    }

    private final long getGuildId() {
        return getMostRecentIntent().getLongExtra("com.discord.intent.extra.EXTRA_GUILD_ID", -1L);
    }

    private final String getTrackingSourceLocation() {
        return getMostRecentIntent().getStringExtra(INTENT_EXTRA_TRACKING_SOURCE_LOCATION);
    }

    private final WidgetGuildRoleSubscriptionEntryPointBinding getViewBinding() {
        return (WidgetGuildRoleSubscriptionEntryPointBinding) this.viewBinding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final WidgetGuildRoleSubscriptionEntryPointViewModel getViewModel() {
        return (WidgetGuildRoleSubscriptionEntryPointViewModel) this.viewModel.getValue();
    }

    public static final void launch(Context context, long j, String str) {
        INSTANCE.launch(context, j, str);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        C12238m.checkNotNullParameter(inflater, "inflater");
        getViewModel().setGuildId(getGuildId());
        getViewModel().setTrackingSourceLocation(getTrackingSourceLocation());
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), (Class<?>) WidgetGuildRoleSubscriptionEntryPoint.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C84451(this));
    }

    @Override // com.discord.app.AppFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        C12238m.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        AppFragment.setActionBarDisplayHomeAsUpEnabled$default(this, false, 1, null);
    }
}
