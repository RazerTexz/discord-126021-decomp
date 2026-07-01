package com.discord.widgets.guild_role_subscriptions.entrypoint;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import b.a.d.g0;
import b.a.d.i0;
import b.a.k.b;
import b.d.b.a.a;
import com.discord.R$layout;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetGuildRoleSubscriptionEntryPointBinding;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import d0.z.d.a0;
import d0.z.d.m;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: WidgetGuildRoleSubscriptionEntryPoint.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildRoleSubscriptionEntryPoint extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetGuildRoleSubscriptionEntryPoint.class, "viewBinding", "getViewBinding()Lcom/discord/databinding/WidgetGuildRoleSubscriptionEntryPointBinding;", 0)};
    public static final WidgetGuildRoleSubscriptionEntryPoint$Companion Companion = new WidgetGuildRoleSubscriptionEntryPoint$Companion(null);
    private static final String INTENT_EXTRA_TRACKING_SOURCE_LOCATION = "INTENT_EXTRA_TRACKING_SOURCE_LOCATION";

    /* JADX INFO: renamed from: viewBinding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate viewBinding;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    public WidgetGuildRoleSubscriptionEntryPoint() {
        super(R$layout.widget_guild_role_subscription_entry_point);
        this.viewBinding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetGuildRoleSubscriptionEntryPoint$viewBinding$2.INSTANCE, null, 2, null);
        WidgetGuildRoleSubscriptionEntryPoint$viewModel$2 widgetGuildRoleSubscriptionEntryPoint$viewModel$2 = WidgetGuildRoleSubscriptionEntryPoint$viewModel$2.INSTANCE;
        g0 g0Var = new g0(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, a0.getOrCreateKotlinClass(WidgetGuildRoleSubscriptionEntryPointViewModel.class), new WidgetGuildRoleSubscriptionEntryPoint$appViewModels$$inlined$viewModels$1(g0Var), new i0(widgetGuildRoleSubscriptionEntryPoint$viewModel$2));
    }

    public static final /* synthetic */ void access$configureUI(WidgetGuildRoleSubscriptionEntryPoint widgetGuildRoleSubscriptionEntryPoint, WidgetGuildRoleSubscriptionEntryPointViewModel$ViewState widgetGuildRoleSubscriptionEntryPointViewModel$ViewState) {
        widgetGuildRoleSubscriptionEntryPoint.configureUI(widgetGuildRoleSubscriptionEntryPointViewModel$ViewState);
    }

    private final void configureUI(WidgetGuildRoleSubscriptionEntryPointViewModel$ViewState viewState) {
        if (viewState instanceof WidgetGuildRoleSubscriptionEntryPointViewModel$ViewState$Uninitialized) {
            TextView textView = getViewBinding().f2434b;
            m.checkNotNullExpressionValue(textView, "viewBinding.description");
            textView.setVisibility(8);
        } else {
            if (viewState instanceof WidgetGuildRoleSubscriptionEntryPointViewModel$ViewState$Invalid) {
                requireActivity().onBackPressed();
                return;
            }
            if (viewState instanceof WidgetGuildRoleSubscriptionEntryPointViewModel$ViewState$Valid) {
                TextView textView2 = getViewBinding().c;
                m.checkNotNullExpressionValue(textView2, "viewBinding.title");
                b.m(textView2, 2131890546, new Object[0], new WidgetGuildRoleSubscriptionEntryPoint$configureUI$1(this, viewState));
                TextView textView3 = getViewBinding().f2434b;
                m.checkNotNullExpressionValue(textView3, "viewBinding.description");
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
        Companion.launch(context, j, str);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        m.checkNotNullParameter(inflater, "inflater");
        getViewModel().setGuildId(getGuildId());
        getViewModel().setTrackingSourceLocation(getTrackingSourceLocation());
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), WidgetGuildRoleSubscriptionEntryPoint.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetGuildRoleSubscriptionEntryPoint$onViewBoundOrOnResume$1(this), 62, (Object) null);
    }

    @Override // com.discord.app.AppFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        m.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        AppFragment.setActionBarDisplayHomeAsUpEnabled$default(this, false, 1, null);
    }
}
