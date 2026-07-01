package com.discord.widgets.hubs;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.TextView;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts$StartActivityForResult;
import androidx.core.app.NotificationCompat;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import b.a.d.g0;
import b.a.d.i0;
import b.a.i.e5;
import b.a.i.o5;
import b.a.i.p5;
import b.a.k.b;
import b.d.b.a.a;
import com.discord.R$layout;
import com.discord.R$plurals;
import com.discord.api.hubs.EmailVerification;
import com.discord.app.AppFragment;
import com.discord.app.LoggingConfig;
import com.discord.databinding.WidgetHubEmailFlowBinding;
import com.discord.stores.utilities.Loading;
import com.discord.stores.utilities.RestCallStateKt;
import com.discord.stores.utilities.Success;
import com.discord.utilities.resources.StringResourceUtilsKt;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.utilities.view.validators.ValidationManager;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.views.LoadingButton;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import d0.g;
import d0.z.d.a0;
import d0.z.d.m;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;
import rx.Observable;

/* JADX INFO: compiled from: WidgetHubEmailFlow.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetHubEmailFlow extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetHubEmailFlow.class, "binding", "getBinding()Lcom/discord/databinding/WidgetHubEmailFlowBinding;", 0)};
    public static final WidgetHubEmailFlow$Companion Companion = new WidgetHubEmailFlow$Companion(null);
    private static final String NAME = WidgetHubEmailFlow.class.getName();
    private final ActivityResultLauncher<Intent> activityResultHandler;

    /* JADX INFO: renamed from: args$delegate, reason: from kotlin metadata */
    private final Lazy args;

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private final LoggingConfig loggingConfig;

    /* JADX INFO: renamed from: validationManager$delegate, reason: from kotlin metadata */
    private final Lazy validationManager;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    public WidgetHubEmailFlow() {
        super(R$layout.widget_hub_email_flow);
        this.args = g.lazy(new WidgetHubEmailFlow$$special$$inlined$args$1(this, "intent_args_key"));
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetHubEmailFlow$binding$2.INSTANCE, null, 2, null);
        ActivityResultLauncher<Intent> activityResultLauncherRegisterForActivityResult = registerForActivityResult(new ActivityResultContracts$StartActivityForResult(), new WidgetHubEmailFlow$activityResultHandler$1(this));
        m.checkNotNullExpressionValue(activityResultLauncherRegisterForActivityResult, "registerForActivityResul…  }\n            }\n      }");
        this.activityResultHandler = activityResultLauncherRegisterForActivityResult;
        WidgetHubEmailFlow$viewModel$2 widgetHubEmailFlow$viewModel$2 = WidgetHubEmailFlow$viewModel$2.INSTANCE;
        g0 g0Var = new g0(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, a0.getOrCreateKotlinClass(WidgetHubEmailViewModel.class), new WidgetHubEmailFlow$appViewModels$$inlined$viewModels$1(g0Var), new i0(widgetHubEmailFlow$viewModel$2));
        this.validationManager = g.lazy(new WidgetHubEmailFlow$validationManager$2(this));
        this.loggingConfig = new LoggingConfig(false, null, new WidgetHubEmailFlow$loggingConfig$1(this), 3);
    }

    public static final /* synthetic */ ActivityResultLauncher access$getActivityResultHandler$p(WidgetHubEmailFlow widgetHubEmailFlow) {
        return widgetHubEmailFlow.activityResultHandler;
    }

    public static final /* synthetic */ HubEmailArgs access$getArgs$p(WidgetHubEmailFlow widgetHubEmailFlow) {
        return widgetHubEmailFlow.getArgs();
    }

    public static final /* synthetic */ WidgetHubEmailFlowBinding access$getBinding$p(WidgetHubEmailFlow widgetHubEmailFlow) {
        return widgetHubEmailFlow.getBinding();
    }

    public static final /* synthetic */ String access$getNAME$cp() {
        return NAME;
    }

    public static final /* synthetic */ WidgetHubEmailViewModel access$getViewModel$p(WidgetHubEmailFlow widgetHubEmailFlow) {
        return widgetHubEmailFlow.getViewModel();
    }

    public static final /* synthetic */ void access$updateView(WidgetHubEmailFlow widgetHubEmailFlow, HubEmailState hubEmailState) {
        widgetHubEmailFlow.updateView(hubEmailState);
    }

    public static final /* synthetic */ void access$verifyEmail(WidgetHubEmailFlow widgetHubEmailFlow) {
        widgetHubEmailFlow.verifyEmail();
    }

    private final HubEmailArgs getArgs() {
        return (HubEmailArgs) this.args.getValue();
    }

    private final WidgetHubEmailFlowBinding getBinding() {
        return (WidgetHubEmailFlowBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final String getEmail() {
        TextInputEditText textInputEditText = getBinding().c.c;
        m.checkNotNullExpressionValue(textInputEditText, "binding.discordHubEmailI…aderDescriptionEmailInput");
        return String.valueOf(textInputEditText.getText());
    }

    private final ValidationManager getValidationManager() {
        return (ValidationManager) this.validationManager.getValue();
    }

    private final WidgetHubEmailViewModel getViewModel() {
        return (WidgetHubEmailViewModel) this.viewModel.getValue();
    }

    private final void updateView(HubEmailState state) {
        String school;
        Context context = getContext();
        if (context != null) {
            m.checkNotNullExpressionValue(context, "context ?: return");
            EmailVerification emailVerificationInvoke = state.getVerifyEmailAsync().invoke();
            boolean z2 = emailVerificationInvoke != null && emailVerificationInvoke.getHasMatchingGuild();
            boolean z3 = !(state.getVerifyEmailAsync() instanceof Success) && state.getWaitlistResult() == null;
            EmailVerification emailVerificationInvoke2 = state.getVerifyEmailAsync().invoke();
            boolean z4 = ((emailVerificationInvoke2 == null || emailVerificationInvoke2.getHasMatchingGuild()) && state.getWaitlistResult() == null) ? false : true;
            TextInputEditText textInputEditText = getBinding().c.c;
            m.checkNotNullExpressionValue(textInputEditText, "binding.discordHubEmailI…aderDescriptionEmailInput");
            String strValueOf = String.valueOf(textInputEditText.getText());
            e5 e5Var = getBinding().c;
            m.checkNotNullExpressionValue(e5Var, "binding.discordHubEmailInput");
            NestedScrollView nestedScrollView = e5Var.a;
            m.checkNotNullExpressionValue(nestedScrollView, "binding.discordHubEmailInput.root");
            nestedScrollView.setVisibility(z3 ? 0 : 8);
            MaterialButton materialButton = getBinding().d;
            m.checkNotNullExpressionValue(materialButton, "binding.discordHubEmailNo");
            materialButton.setVisibility(z3 ? 0 : 8);
            o5 o5Var = getBinding().f2473b;
            m.checkNotNullExpressionValue(o5Var, "binding.discordHubEmailConfirmation");
            NestedScrollView nestedScrollView2 = o5Var.a;
            m.checkNotNullExpressionValue(nestedScrollView2, "binding.discordHubEmailConfirmation.root");
            nestedScrollView2.setVisibility(z2 ? 0 : 8);
            TextView textView = getBinding().f2473b.c;
            m.checkNotNullExpressionValue(textView, "binding.discordHubEmailC…ilConfirmationHeaderTitle");
            textView.setText(b.k(this, 2131892828, new Object[]{strValueOf}, null, 4));
            p5 p5Var = getBinding().f;
            m.checkNotNullExpressionValue(p5Var, "binding.discordHubWaitlist");
            NestedScrollView nestedScrollView3 = p5Var.a;
            m.checkNotNullExpressionValue(nestedScrollView3, "binding.discordHubWaitlist.root");
            nestedScrollView3.setVisibility(z4 ? 0 : 8);
            HubWaitlistResult waitlistResult = state.getWaitlistResult();
            if (waitlistResult != null && (school = waitlistResult.getSchool()) != null) {
                TextView textView2 = getBinding().f.f182b;
                m.checkNotNullExpressionValue(textView2, "binding.discordHubWaitlist.hubWaitlistDescription");
                textView2.setText(b.k(this, 2131891869, new Object[]{school}, null, 4));
            }
            getBinding().e.setOnClickListener(z4 ? new WidgetHubEmailFlow$updateView$2(this) : new WidgetHubEmailFlow$updateView$3(this));
            LoadingButton loadingButton = getBinding().e;
            m.checkNotNullExpressionValue(loadingButton, "binding.discordHubEmailYes");
            loadingButton.setVisibility(z2 ^ true ? 0 : 8);
            getBinding().e.setText(z4 ? getString(2131891741) : getString(2131891779));
            getBinding().e.setIsLoading(state.getVerifyEmailAsync() instanceof Loading);
            RestCallStateKt.handleResponse$default(state.getVerifyEmailAsync(), context, null, null, new WidgetHubEmailFlow$updateView$4(this, state, context, strValueOf), 6, null);
        }
    }

    private final void verifyEmail() {
        boolean zValidate$default = ValidationManager.validate$default(getValidationManager(), false, 1, null);
        TextView textView = getBinding().c.f;
        m.checkNotNullExpressionValue(textView, "binding.discordHubEmailInput.discordHubEmailLabel");
        textView.setVisibility(zValidate$default ? 0 : 8);
        if (zValidate$default) {
            getViewModel().submitEmail(getEmail());
            hideKeyboard(getView());
        }
    }

    @Override // com.discord.app.AppFragment, com.discord.app.AppLogger$a
    public LoggingConfig getLoggingConfig() {
        return this.loggingConfig;
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        Observable<HubEmailState> observableR = getViewModel().observeViewState().r();
        m.checkNotNullExpressionValue(observableR, "viewModel\n        .obser…  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(observableR, this, null, 2, null), WidgetHubEmailFlow.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetHubEmailFlow$onViewBoundOrOnResume$1(this), 62, (Object) null);
    }

    @Override // com.discord.app.AppFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        CharSequence string;
        int i;
        m.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        getBinding().f2473b.d.setOnClickListener(new WidgetHubEmailFlow$onViewCreated$1(this));
        getBinding().d.setOnClickListener(new WidgetHubEmailFlow$onViewCreated$2(this));
        getBinding().f2473b.f176b.setOnClickListener(new WidgetHubEmailFlow$onViewCreated$3(this));
        TextView textView = getBinding().c.e;
        m.checkNotNullExpressionValue(textView, "binding.discordHubEmailI…iscordHubEmailHeaderTitle");
        int iOrdinal = getArgs().getEntryPoint().ordinal();
        if (iOrdinal == 0) {
            string = getString(2131891797);
        } else if (iOrdinal != 1) {
            string = getString(2131891867);
        } else {
            Context context = view.getContext();
            m.checkNotNullExpressionValue(context, "view.context");
            string = b.k(this, 2131891791, new Object[]{StringResourceUtilsKt.getI18nPluralString(context, R$plurals.hub_email_connection_invite_header_count, getArgs().getGuildMemberCount(), Integer.valueOf(getArgs().getGuildMemberCount())), getArgs().getGuildName()}, null, 4);
        }
        textView.setText(string);
        int iOrdinal2 = getArgs().getEntryPoint().ordinal();
        if (iOrdinal2 != 0) {
            i = iOrdinal2 != 1 ? 2131891868 : 2131891781;
        } else {
            i = 2131891796;
        }
        String string2 = getString(i);
        m.checkNotNullExpressionValue(string2, "getString(\n        when …subheader\n        }\n    )");
        CharSequence charSequenceE = b.e(this, 2131892523, new Object[0], new WidgetHubEmailFlow$onViewCreated$learnMore$1(this));
        LinkifiedTextView linkifiedTextView = getBinding().c.f107b;
        m.checkNotNullExpressionValue(linkifiedTextView, "binding.discordHubEmailI…HubEmailHeaderDescription");
        linkifiedTextView.setText(new SpannableStringBuilder(string2).append((CharSequence) " ").append(charSequenceE));
    }
}
