package com.discord.widgets.hubs;

import android.content.Context;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import b.a.d.g0;
import b.a.d.i0;
import b.a.k.b;
import b.d.b.a.a;
import com.discord.R$layout;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetHubAuthenticationBinding;
import com.discord.stores.utilities.RestCallStateKt;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.views.CodeVerificationView;
import d0.g;
import d0.z.d.a0;
import d0.z.d.m;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: WidgetHubAuthentication.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetHubAuthentication extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetHubAuthentication.class, "binding", "getBinding()Lcom/discord/databinding/WidgetHubAuthenticationBinding;", 0)};

    /* JADX INFO: renamed from: args$delegate, reason: from kotlin metadata */
    private final Lazy args;

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    public WidgetHubAuthentication() {
        super(R$layout.widget_hub_authentication);
        this.args = g.lazy(new WidgetHubAuthentication$$special$$inlined$args$1(this, "intent_args_key"));
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetHubAuthentication$binding$2.INSTANCE, null, 2, null);
        WidgetHubAuthentication$viewModel$2 widgetHubAuthentication$viewModel$2 = new WidgetHubAuthentication$viewModel$2(this);
        g0 g0Var = new g0(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, a0.getOrCreateKotlinClass(WidgetHubAuthenticationViewModel.class), new WidgetHubAuthentication$appViewModels$$inlined$viewModels$1(g0Var), new i0(widgetHubAuthentication$viewModel$2));
    }

    public static final /* synthetic */ void access$configureUi(WidgetHubAuthentication widgetHubAuthentication, HubAuthenticationState hubAuthenticationState) {
        widgetHubAuthentication.configureUi(hubAuthenticationState);
    }

    public static final /* synthetic */ WidgetHubAuthenticationViewModel access$getViewModel$p(WidgetHubAuthentication widgetHubAuthentication) {
        return widgetHubAuthentication.getViewModel();
    }

    private final void configureUi(HubAuthenticationState state) {
        Context context = getContext();
        if (context != null) {
            m.checkNotNullExpressionValue(context, "context ?: return");
            RestCallStateKt.handleResponse$default(state.getAuthenticationAsync(), context, null, null, new WidgetHubAuthentication$configureUi$1(this), 6, null);
            RestCallStateKt.handleResponse$default(state.getResendEmailAsync(), context, null, null, new WidgetHubAuthentication$configureUi$2(this), 6, null);
        }
    }

    private final WidgetHubAuthenticationBinding getBinding() {
        return (WidgetHubAuthenticationBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final WidgetHubAuthenticationViewModel getViewModel() {
        return (WidgetHubAuthenticationViewModel) this.viewModel.getValue();
    }

    public final HubAuthenticationArgs getArgs() {
        return (HubAuthenticationArgs) this.args.getValue();
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        getBinding().c.setOnCodeEntered(new WidgetHubAuthentication$onViewBound$1(this));
        LinkifiedTextView linkifiedTextView = getBinding().f2469b;
        m.checkNotNullExpressionValue(linkifiedTextView, "binding.description");
        linkifiedTextView.setText(b.e(this, 2131891836, new Object[]{getArgs().getEmail()}, new WidgetHubAuthentication$onViewBound$2(this)));
        CodeVerificationView codeVerificationView = getBinding().c;
        m.checkNotNullExpressionValue(codeVerificationView, "binding.verification");
        showKeyboard(codeVerificationView);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), WidgetHubAuthentication.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetHubAuthentication$onViewBoundOrOnResume$1(this), 62, (Object) null);
    }
}
