package com.discord.widgets.hubs;

import android.content.Context;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import b.a.d.g0;
import b.a.d.i0;
import b.d.b.a.a;
import com.discord.R$layout;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetHubWaitlistBinding;
import com.discord.stores.utilities.Loading;
import com.discord.stores.utilities.RestCallStateKt;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.view.validators.ValidationManager;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.google.android.material.textfield.TextInputEditText;
import d0.g;
import d0.z.d.a0;
import d0.z.d.m;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: WidgetHubWaitlist.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetHubWaitlist extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetHubWaitlist.class, "binding", "getBinding()Lcom/discord/databinding/WidgetHubWaitlistBinding;", 0)};

    /* JADX INFO: renamed from: args$delegate, reason: from kotlin metadata */
    private final Lazy args;

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* JADX INFO: renamed from: validationManager$delegate, reason: from kotlin metadata */
    private final Lazy validationManager;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    public WidgetHubWaitlist() {
        super(R$layout.widget_hub_waitlist);
        this.args = g.lazy(new WidgetHubWaitlist$$special$$inlined$args$1(this, "intent_args_key"));
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetHubWaitlist$binding$2.INSTANCE, null, 2, null);
        WidgetHubWaitlist$viewModel$2 widgetHubWaitlist$viewModel$2 = new WidgetHubWaitlist$viewModel$2(this);
        g0 g0Var = new g0(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, a0.getOrCreateKotlinClass(WidgetHubWaitlistViewModel.class), new WidgetHubWaitlist$appViewModels$$inlined$viewModels$1(g0Var), new i0(widgetHubWaitlist$viewModel$2));
        this.validationManager = g.lazy(new WidgetHubWaitlist$validationManager$2(this));
    }

    public static final /* synthetic */ void access$configureUI(WidgetHubWaitlist widgetHubWaitlist, HubWaitlistState hubWaitlistState) {
        widgetHubWaitlist.configureUI(hubWaitlistState);
    }

    public static final /* synthetic */ void access$maybeSubmitSchoolName(WidgetHubWaitlist widgetHubWaitlist) {
        widgetHubWaitlist.maybeSubmitSchoolName();
    }

    private final void configureUI(HubWaitlistState state) {
        Context context = getContext();
        if (context != null) {
            m.checkNotNullExpressionValue(context, "context ?: return");
            getBinding().f2478b.setIsLoading(state.getWaitlistAsync() instanceof Loading);
            RestCallStateKt.handleResponse$default(state.getWaitlistAsync(), context, null, null, new WidgetHubWaitlist$configureUI$1(this), 6, null);
        }
    }

    private final ValidationManager getValidationManager() {
        return (ValidationManager) this.validationManager.getValue();
    }

    private final void maybeSubmitSchoolName() {
        if (getValidationManager().validate(true)) {
            WidgetHubWaitlistViewModel viewModel = getViewModel();
            TextInputEditText textInputEditText = getBinding().c;
            m.checkNotNullExpressionValue(textInputEditText, "binding.hubWaitlistEditText");
            viewModel.joinWaitlist(String.valueOf(textInputEditText.getText()));
        }
        hideKeyboard(getView());
    }

    public final HubWaitlistArgs getArgs() {
        return (HubWaitlistArgs) this.args.getValue();
    }

    public final WidgetHubWaitlistBinding getBinding() {
        return (WidgetHubWaitlistBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    public final WidgetHubWaitlistViewModel getViewModel() {
        return (WidgetHubWaitlistViewModel) this.viewModel.getValue();
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null)), WidgetHubWaitlist.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetHubWaitlist$onViewBoundOrOnResume$1(this), 62, (Object) null);
        getBinding().f2478b.setOnClickListener(new WidgetHubWaitlist$onViewBoundOrOnResume$2(this));
        TextInputEditText textInputEditText = getBinding().c;
        m.checkNotNullExpressionValue(textInputEditText, "binding.hubWaitlistEditText");
        showKeyboard(textInputEditText);
    }
}
