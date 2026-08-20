package com.discord.widgets.voice.feedback;

import android.content.Context;
import android.content.Intent;
import android.text.Editable;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import com.discord.C5419R;
import com.discord.app.AppActivity;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetIssueDetailsFormBinding;
import com.discord.utilities.error.Error;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputLayout;
import java.io.Serializable;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p007b.p008a.p018d.C0862f;
import p007b.p008a.p018d.C0865g0;
import p007b.p008a.p018d.C0869i0;
import p007b.p008a.p018d.C0870j;
import p007b.p008a.p018d.C0876m;
import p007b.p008a.p027k.C1107b;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12216a0;
import p507d0.p592z.p594d.C12238m;
import p658rx.Subscription;

/* JADX INFO: compiled from: WidgetIssueDetailsForm.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetIssueDetailsForm extends AppFragment {
    public static final String ARG_PENDING_VOICE_FEEDBACK = "ARG_PENDING_VOICE_FEEDBACK";
    public static final String ARG_SHOW_CX_PROMPT = "ARG_SHOW_CX_PROMPT";

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {C1643a.m846d0(WidgetIssueDetailsForm.class, "binding", "getBinding()Lcom/discord/databinding/WidgetIssueDetailsFormBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: compiled from: WidgetIssueDetailsForm.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void launch(Context context, PendingFeedback pendingFeedback, boolean showCxPrompt) {
            C12238m.checkNotNullParameter(context, "context");
            C12238m.checkNotNullParameter(pendingFeedback, "pendingFeedback");
            Intent intent = new Intent();
            intent.putExtra(WidgetIssueDetailsForm.ARG_PENDING_VOICE_FEEDBACK, pendingFeedback);
            intent.putExtra(WidgetIssueDetailsForm.ARG_SHOW_CX_PROMPT, showCxPrompt);
            C0870j.m156d(context, WidgetIssueDetailsForm.class, intent);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.voice.feedback.WidgetIssueDetailsForm$onViewBound$2 */
    /* JADX INFO: compiled from: WidgetIssueDetailsForm.kt */
    public static final class C104512 extends AbstractC12240o implements Function1<Editable, Unit> {
        public C104512() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Editable editable) {
            invoke2(editable);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Editable editable) {
            C12238m.checkNotNullParameter(editable, "editable");
            MaterialButton materialButton = WidgetIssueDetailsForm.this.getBinding().f17208d;
            C12238m.checkNotNullExpressionValue(materialButton, "binding.issueDetailsSubmitButton");
            materialButton.setEnabled(editable.length() > 0);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.voice.feedback.WidgetIssueDetailsForm$onViewBoundOrOnResume$1 */
    /* JADX INFO: compiled from: WidgetIssueDetailsForm.kt */
    public static final class C104521 extends AbstractC12240o implements Function1<IssueDetailsFormViewModel.Event, Unit> {
        public C104521() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(IssueDetailsFormViewModel.Event event) {
            invoke2(event);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(IssueDetailsFormViewModel.Event event) {
            C12238m.checkNotNullParameter(event, "event");
            WidgetIssueDetailsForm.this.handleEvent(event);
        }
    }

    public WidgetIssueDetailsForm() {
        super(C5419R.layout.widget_issue_details_form);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetIssueDetailsForm$binding$2.INSTANCE, null, 2, null);
        WidgetIssueDetailsForm$viewModel$2 widgetIssueDetailsForm$viewModel$2 = new WidgetIssueDetailsForm$viewModel$2(this);
        C0865g0 c0865g0 = new C0865g0(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, C12216a0.getOrCreateKotlinClass(IssueDetailsFormViewModel.class), new WidgetIssueDetailsForm$appViewModels$$inlined$viewModels$1(c0865g0), new C0869i0(widgetIssueDetailsForm$viewModel$2));
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

    private final void handleEvent(IssueDetailsFormViewModel.Event event) {
        if (C12238m.areEqual(event, IssueDetailsFormViewModel.Event.Close.INSTANCE)) {
            C0876m.m171i(this, C5419R.string.call_feedback_confirmation, 0, 4);
            AppActivity appActivity = getAppActivity();
            if (appActivity != null) {
                appActivity.hideKeyboard(getBinding().f17207c);
            }
            requireActivity().onBackPressed();
        }
    }

    private final boolean shouldShowCxPrompt() {
        return getMostRecentIntent().getBooleanExtra(ARG_SHOW_CX_PROMPT, false);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        C12238m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        setActionBarTitle(C5419R.string.feedback_modal_title);
        MaterialButton materialButton = getBinding().f17208d;
        C12238m.checkNotNullExpressionValue(materialButton, "binding.issueDetailsSubmitButton");
        materialButton.setEnabled(false);
        getBinding().f17208d.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.voice.feedback.WidgetIssueDetailsForm.onViewBound.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                TextInputLayout textInputLayout = WidgetIssueDetailsForm.this.getBinding().f17207c;
                C12238m.checkNotNullExpressionValue(textInputLayout, "binding.issueDetailsInput");
                WidgetIssueDetailsForm.this.getViewModel().submitForm(ViewExtensions.getTextOrEmpty(textInputLayout));
            }
        });
        TextInputLayout textInputLayout = getBinding().f17207c;
        C12238m.checkNotNullExpressionValue(textInputLayout, "binding.issueDetailsInput");
        ViewExtensions.addBindedTextWatcher(textInputLayout, this, new C104512());
        TextInputLayout textInputLayout2 = getBinding().f17207c;
        C12238m.checkNotNullExpressionValue(textInputLayout2, "binding.issueDetailsInput");
        showKeyboard(textInputLayout2);
        LinkifiedTextView linkifiedTextView = getBinding().f17206b;
        C12238m.checkNotNullExpressionValue(linkifiedTextView, "binding.issueDetailsCxPrompt");
        linkifiedTextView.setVisibility(shouldShowCxPrompt() ? 0 : 8);
        LinkifiedTextView linkifiedTextView2 = getBinding().f17206b;
        C12238m.checkNotNullExpressionValue(linkifiedTextView2, "binding.issueDetailsCxPrompt");
        C1107b.m221m(linkifiedTextView2, C5419R.string.feedback_need_more_help, new Object[]{C0862f.m148c()}, (4 & 4) != 0 ? C1107b.g.f1495j : null);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeEvents(), this, null, 2, null), (Class<?>) WidgetIssueDetailsForm.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C104521());
    }
}
