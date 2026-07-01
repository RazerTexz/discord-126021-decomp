package com.discord.widgets.voice.feedback;

import android.content.Context;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import b.a.d.f;
import b.a.d.g0;
import b.a.d.i0;
import b.a.k.b;
import b.d.b.a.a;
import com.discord.R$layout;
import com.discord.app.AppActivity;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetIssueDetailsFormBinding;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputLayout;
import d0.z.d.a0;
import d0.z.d.m;
import java.io.Serializable;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: WidgetIssueDetailsForm.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetIssueDetailsForm extends AppFragment {
    public static final String ARG_PENDING_VOICE_FEEDBACK = "ARG_PENDING_VOICE_FEEDBACK";
    public static final String ARG_SHOW_CX_PROMPT = "ARG_SHOW_CX_PROMPT";

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetIssueDetailsForm.class, "binding", "getBinding()Lcom/discord/databinding/WidgetIssueDetailsFormBinding;", 0)};
    public static final WidgetIssueDetailsForm$Companion Companion = new WidgetIssueDetailsForm$Companion(null);

    public WidgetIssueDetailsForm() {
        super(R$layout.widget_issue_details_form);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetIssueDetailsForm$binding$2.INSTANCE, null, 2, null);
        WidgetIssueDetailsForm$viewModel$2 widgetIssueDetailsForm$viewModel$2 = new WidgetIssueDetailsForm$viewModel$2(this);
        g0 g0Var = new g0(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, a0.getOrCreateKotlinClass(IssueDetailsFormViewModel.class), new WidgetIssueDetailsForm$appViewModels$$inlined$viewModels$1(g0Var), new i0(widgetIssueDetailsForm$viewModel$2));
    }

    public static final /* synthetic */ WidgetIssueDetailsFormBinding access$getBinding$p(WidgetIssueDetailsForm widgetIssueDetailsForm) {
        return widgetIssueDetailsForm.getBinding();
    }

    public static final /* synthetic */ PendingFeedback access$getPendingFeedback(WidgetIssueDetailsForm widgetIssueDetailsForm) {
        return widgetIssueDetailsForm.getPendingFeedback();
    }

    public static final /* synthetic */ IssueDetailsFormViewModel access$getViewModel$p(WidgetIssueDetailsForm widgetIssueDetailsForm) {
        return widgetIssueDetailsForm.getViewModel();
    }

    public static final /* synthetic */ void access$handleEvent(WidgetIssueDetailsForm widgetIssueDetailsForm, IssueDetailsFormViewModel$Event issueDetailsFormViewModel$Event) {
        widgetIssueDetailsForm.handleEvent(issueDetailsFormViewModel$Event);
    }

    private final WidgetIssueDetailsFormBinding getBinding() {
        return (WidgetIssueDetailsFormBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final PendingFeedback getPendingFeedback() {
        Serializable serializableExtra = getMostRecentIntent().getSerializableExtra(ARG_PENDING_VOICE_FEEDBACK);
        Objects.requireNonNull(serializableExtra, "null cannot be cast to non-null type com.discord.widgets.voice.feedback.PendingFeedback");
        return (PendingFeedback) serializableExtra;
    }

    private final IssueDetailsFormViewModel getViewModel() {
        return (IssueDetailsFormViewModel) this.viewModel.getValue();
    }

    private final void handleEvent(IssueDetailsFormViewModel$Event event) {
        if (m.areEqual(event, IssueDetailsFormViewModel$Event$Close.INSTANCE)) {
            b.a.d.m.i(this, 2131887364, 0, 4);
            AppActivity appActivity = getAppActivity();
            if (appActivity != null) {
                appActivity.hideKeyboard(getBinding().c);
            }
            requireActivity().onBackPressed();
        }
    }

    private final boolean shouldShowCxPrompt() {
        return getMostRecentIntent().getBooleanExtra(ARG_SHOW_CX_PROMPT, false);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        setActionBarTitle(2131889018);
        MaterialButton materialButton = getBinding().d;
        m.checkNotNullExpressionValue(materialButton, "binding.issueDetailsSubmitButton");
        materialButton.setEnabled(false);
        getBinding().d.setOnClickListener(new WidgetIssueDetailsForm$onViewBound$1(this));
        TextInputLayout textInputLayout = getBinding().c;
        m.checkNotNullExpressionValue(textInputLayout, "binding.issueDetailsInput");
        ViewExtensions.addBindedTextWatcher(textInputLayout, this, new WidgetIssueDetailsForm$onViewBound$2(this));
        TextInputLayout textInputLayout2 = getBinding().c;
        m.checkNotNullExpressionValue(textInputLayout2, "binding.issueDetailsInput");
        showKeyboard(textInputLayout2);
        LinkifiedTextView linkifiedTextView = getBinding().f2480b;
        m.checkNotNullExpressionValue(linkifiedTextView, "binding.issueDetailsCxPrompt");
        linkifiedTextView.setVisibility(shouldShowCxPrompt() ? 0 : 8);
        LinkifiedTextView linkifiedTextView2 = getBinding().f2480b;
        m.checkNotNullExpressionValue(linkifiedTextView2, "binding.issueDetailsCxPrompt");
        b.n(linkifiedTextView2, 2131889019, new Object[]{f.c()}, null, 4);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeEvents(), this, null, 2, null), WidgetIssueDetailsForm.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetIssueDetailsForm$onViewBoundOrOnResume$1(this), 62, (Object) null);
    }
}
