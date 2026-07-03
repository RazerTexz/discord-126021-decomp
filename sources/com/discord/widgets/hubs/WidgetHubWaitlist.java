package com.discord.widgets.hubs;

import android.content.Context;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import com.discord.C5419R;
import com.discord.api.hubs.WaitlistSignup;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetHubWaitlistBinding;
import com.discord.stores.utilities.Loading;
import com.discord.stores.utilities.RestCallStateKt;
import com.discord.stores.utilities.Success;
import com.discord.utilities.error.Error;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.view.validators.ValidationManager;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.google.android.material.textfield.TextInputEditText;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;
import p007b.p008a.p018d.C0865g0;
import p007b.p008a.p018d.C0869i0;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.C12083g;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12216a0;
import p507d0.p592z.p594d.C12238m;
import p658rx.Subscription;

/* JADX INFO: compiled from: WidgetHubWaitlist.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetHubWaitlist extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {C1643a.m846d0(WidgetHubWaitlist.class, "binding", "getBinding()Lcom/discord/databinding/WidgetHubWaitlistBinding;", 0)};

    /* JADX INFO: renamed from: args$delegate, reason: from kotlin metadata */
    private final Lazy args;

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* JADX INFO: renamed from: validationManager$delegate, reason: from kotlin metadata */
    private final Lazy validationManager;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* JADX INFO: renamed from: com.discord.widgets.hubs.WidgetHubWaitlist$configureUI$1 */
    /* JADX INFO: compiled from: WidgetHubWaitlist.kt */
    public static final class C90441 extends AbstractC12240o implements Function1<Success<? extends WaitlistSignup>, Unit> {
        public C90441() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Success<? extends WaitlistSignup> success) {
            invoke2((Success<WaitlistSignup>) success);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Success<WaitlistSignup> success) {
            C12238m.checkNotNullParameter(success, "it");
            FragmentActivity fragmentActivityM95e = WidgetHubWaitlist.this.m95e();
            if (fragmentActivityM95e != null) {
                fragmentActivityM95e.setResult(-1, C1460d.m522g2(new HubWaitlistResult(success.invoke().getSchool())));
                fragmentActivityM95e.finish();
            }
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.hubs.WidgetHubWaitlist$onViewBoundOrOnResume$1 */
    /* JADX INFO: compiled from: WidgetHubWaitlist.kt */
    public static final class C90451 extends AbstractC12240o implements Function1<HubWaitlistState, Unit> {
        public C90451() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(HubWaitlistState hubWaitlistState) {
            invoke2(hubWaitlistState);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(HubWaitlistState hubWaitlistState) {
            C12238m.checkNotNullParameter(hubWaitlistState, "it");
            WidgetHubWaitlist.this.configureUI(hubWaitlistState);
        }
    }

    public WidgetHubWaitlist() {
        super(C5419R.layout.widget_hub_waitlist);
        this.args = C12083g.lazy(new WidgetHubWaitlist$$special$$inlined$args$1(this, "intent_args_key"));
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetHubWaitlist$binding$2.INSTANCE, null, 2, null);
        WidgetHubWaitlist$viewModel$2 widgetHubWaitlist$viewModel$2 = new WidgetHubWaitlist$viewModel$2(this);
        C0865g0 c0865g0 = new C0865g0(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, C12216a0.getOrCreateKotlinClass(WidgetHubWaitlistViewModel.class), new WidgetHubWaitlist$appViewModels$$inlined$viewModels$1(c0865g0), new C0869i0(widgetHubWaitlist$viewModel$2));
        this.validationManager = C12083g.lazy(new WidgetHubWaitlist$validationManager$2(this));
    }

    private final void configureUI(HubWaitlistState state) {
        Context context = getContext();
        if (context != null) {
            C12238m.checkNotNullExpressionValue(context, "context ?: return");
            getBinding().f17189b.setIsLoading(state.getWaitlistAsync() instanceof Loading);
            RestCallStateKt.handleResponse$default(state.getWaitlistAsync(), context, null, null, new C90441(), 6, null);
        }
    }

    private final ValidationManager getValidationManager() {
        return (ValidationManager) this.validationManager.getValue();
    }

    private final void maybeSubmitSchoolName() {
        if (getValidationManager().validate(true)) {
            WidgetHubWaitlistViewModel viewModel = getViewModel();
            TextInputEditText textInputEditText = getBinding().f17190c;
            C12238m.checkNotNullExpressionValue(textInputEditText, "binding.hubWaitlistEditText");
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
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.m8518ui(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null)), (Class<?>) WidgetHubWaitlist.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C90451());
        getBinding().f17189b.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.hubs.WidgetHubWaitlist.onViewBoundOrOnResume.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetHubWaitlist.this.maybeSubmitSchoolName();
            }
        });
        TextInputEditText textInputEditText = getBinding().f17190c;
        C12238m.checkNotNullExpressionValue(textInputEditText, "binding.hubWaitlistEditText");
        showKeyboard(textInputEditText);
    }
}
