package com.discord.widgets.tos;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewGroupKt;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import b.a.d.g0;
import b.a.d.i0;
import b.a.k.b;
import b.d.b.a.a;
import com.discord.R$layout;
import com.discord.api.report.ReportReason;
import com.discord.app.AppActivity;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetTosReportViolationBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.views.LoadingButton;
import com.discord.widgets.notice.WidgetNoticeDialog;
import com.discord.widgets.notice.WidgetNoticeDialog$Companion;
import d0.g;
import d0.z.d.a0;
import d0.z.d.m;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: WidgetTosReportViolation.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetTosReportViolation extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetTosReportViolation.class, "binding", "getBinding()Lcom/discord/databinding/WidgetTosReportViolationBinding;", 0)};
    public static final WidgetTosReportViolation$Companion Companion = new WidgetTosReportViolation$Companion(null);
    private static final String EXTRA_CHANNEL_ID = "EXTRA_CHANNEL_ID";
    private static final String EXTRA_MESSAGE_ID = "EXTRA_MESSAGE_ID";
    private static final String EXTRA_TARGET = "EXTRA_TARGET";

    /* JADX INFO: renamed from: args$delegate, reason: from kotlin metadata */
    private final Lazy args;

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    public WidgetTosReportViolation() {
        super(R$layout.widget_tos_report_violation);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetTosReportViolation$binding$2.INSTANCE, null, 2, null);
        WidgetTosReportViolation$viewModel$2 widgetTosReportViolation$viewModel$2 = new WidgetTosReportViolation$viewModel$2(this);
        g0 g0Var = new g0(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, a0.getOrCreateKotlinClass(WidgetTosReportViolationViewModel.class), new WidgetTosReportViolation$appViewModels$$inlined$viewModels$1(g0Var), new i0(widgetTosReportViolation$viewModel$2));
        this.args = g.lazy(new WidgetTosReportViolation$args$2(this));
    }

    public static final /* synthetic */ void access$configureUI(WidgetTosReportViolation widgetTosReportViolation, WidgetTosReportViolationViewModel$ViewState widgetTosReportViolationViewModel$ViewState) {
        widgetTosReportViolation.configureUI(widgetTosReportViolationViewModel$ViewState);
    }

    public static final /* synthetic */ WidgetTosReportViolation$Companion$Arguments access$getArgs$p(WidgetTosReportViolation widgetTosReportViolation) {
        return widgetTosReportViolation.getArgs();
    }

    public static final /* synthetic */ WidgetTosReportViolationBinding access$getBinding$p(WidgetTosReportViolation widgetTosReportViolation) {
        return widgetTosReportViolation.getBinding();
    }

    public static final /* synthetic */ WidgetTosReportViolationViewModel access$getViewModel$p(WidgetTosReportViolation widgetTosReportViolation) {
        return widgetTosReportViolation.getViewModel();
    }

    private final void configureUI(WidgetTosReportViolationViewModel$ViewState viewState) {
        if (viewState instanceof WidgetTosReportViolationViewModel$ViewState$Loading) {
            handleLoading();
            return;
        }
        if (viewState instanceof WidgetTosReportViolationViewModel$ViewState$Loaded) {
            handleLoaded(((WidgetTosReportViolationViewModel$ViewState$Loaded) viewState).getReasons());
            return;
        }
        if (viewState instanceof WidgetTosReportViolationViewModel$ViewState$Submitting) {
            handleReportSubmitting(((WidgetTosReportViolationViewModel$ViewState$Submitting) viewState).getReason());
        } else if (viewState instanceof WidgetTosReportViolationViewModel$ViewState$Submitted) {
            handleReportSubmitted();
        } else {
            if (!(viewState instanceof WidgetTosReportViolationViewModel$ViewState$SubmissionError)) {
                throw new NoWhenBranchMatchedException();
            }
            handleReportSubmissionError();
        }
    }

    private final WidgetTosReportViolation$Companion$Arguments getArgs() {
        return (WidgetTosReportViolation$Companion$Arguments) this.args.getValue();
    }

    private final WidgetTosReportViolationBinding getBinding() {
        return (WidgetTosReportViolationBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final WidgetTosReportViolationViewModel getViewModel() {
        return (WidgetTosReportViolationViewModel) this.viewModel.getValue();
    }

    private final void handleLoaded(List<ReportReason> reasons) {
        ProgressBar progressBar = getBinding().f;
        m.checkNotNullExpressionValue(progressBar, "binding.reportReasonsLoading");
        progressBar.setVisibility(8);
        LoadingButton loadingButton = getBinding().f2675b;
        m.checkNotNullExpressionValue(loadingButton, "binding.reportButton");
        loadingButton.setEnabled(getViewModel().getReasonSelected() != null);
        getBinding().f2675b.setIsLoading(false);
        getBinding().f2675b.setOnClickListener(new WidgetTosReportViolation$handleLoaded$1(this));
        TextView textView = getBinding().e;
        m.checkNotNullExpressionValue(textView, "binding.reportReasonsHeader");
        textView.setVisibility(0);
        getBinding().d.removeAllViews();
        for (ReportReason reportReason : reasons) {
            WidgetTosReportViolationReasonView widgetTosReportViolationReasonView = new WidgetTosReportViolationReasonView(requireContext(), null, 0, 6, null);
            if (!ViewCompat.isLaidOut(widgetTosReportViolationReasonView) || widgetTosReportViolationReasonView.isLayoutRequested()) {
                widgetTosReportViolationReasonView.addOnLayoutChangeListener(new WidgetTosReportViolation$handleLoaded$$inlined$forEach$lambda$2(widgetTosReportViolationReasonView, reportReason, this));
            } else {
                widgetTosReportViolationReasonView.setReason(reportReason);
                widgetTosReportViolationReasonView.setChecked(m.areEqual(reportReason, access$getViewModel$p(this).getReasonSelected()));
                widgetTosReportViolationReasonView.setOnClickListener(new WidgetTosReportViolation$handleLoaded$$inlined$forEach$lambda$1(widgetTosReportViolationReasonView, reportReason, this));
            }
            getBinding().d.addView(widgetTosReportViolationReasonView);
        }
    }

    private final void handleLoading() {
        ProgressBar progressBar = getBinding().f;
        m.checkNotNullExpressionValue(progressBar, "binding.reportReasonsLoading");
        progressBar.setVisibility(0);
        LoadingButton loadingButton = getBinding().f2675b;
        m.checkNotNullExpressionValue(loadingButton, "binding.reportButton");
        loadingButton.setEnabled(false);
        getBinding().d.removeAllViews();
    }

    private final void handleReportSubmissionError() {
        LoadingButton loadingButton = getBinding().f2675b;
        m.checkNotNullExpressionValue(loadingButton, "binding.reportButton");
        loadingButton.setEnabled(false);
        getBinding().f2675b.setIsLoading(false);
        WidgetNoticeDialog$Companion widgetNoticeDialog$Companion = WidgetNoticeDialog.Companion;
        FragmentManager parentFragmentManager = getParentFragmentManager();
        m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        WidgetNoticeDialog$Companion.show$default(widgetNoticeDialog$Companion, parentFragmentManager, b.k(this, 2131893325, new Object[0], null, 4), b.k(this, 2131894787, new Object[]{"https://dis.gd/request"}, null, 4), b.k(this, 2131893499, new Object[0], null, 4), null, null, null, null, null, null, null, null, 0, new WidgetTosReportViolation$handleReportSubmissionError$1(this), 8176, null);
    }

    private final void handleReportSubmitted() {
        b.a.d.m.i(this, 2131894798, 0, 4);
        AppActivity appActivity = getAppActivity();
        if (appActivity != null) {
            appActivity.finish();
        }
    }

    private final void handleReportSubmitting(int reason) {
        LinearLayout linearLayout = getBinding().d;
        m.checkNotNullExpressionValue(linearLayout, "binding.reportReasonsContainer");
        Iterator<View> it = ViewGroupKt.getChildren(linearLayout).iterator();
        while (it.hasNext()) {
            it.next().setEnabled(false);
        }
        LoadingButton loadingButton = getBinding().f2675b;
        m.checkNotNullExpressionValue(loadingButton, "binding.reportButton");
        loadingButton.setEnabled(false);
        getBinding().f2675b.setIsLoading(true);
        getViewModel().sendReportAPICall(reason, getArgs().getChannelId(), getArgs().getMessageId());
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        setActionBarTitle(2131894778);
        AppFragment.setActionBarDisplayHomeAsUpEnabled$default(this, false, 1, null);
        TextView textView = getBinding().c;
        m.checkNotNullExpressionValue(textView, "binding.reportHeader");
        b.n(textView, 2131894781, new Object[]{getArgs().getTarget()}, null, 4);
        LinkifiedTextView linkifiedTextView = getBinding().g;
        m.checkNotNullExpressionValue(linkifiedTextView, "binding.reportTooltip");
        b.n(linkifiedTextView, 2131889311, new Object[]{"https://discord.com/guidelines"}, null, 4);
        getBinding().f2675b.setIsLoading(false);
        LoadingButton loadingButton = getBinding().f2675b;
        m.checkNotNullExpressionValue(loadingButton, "binding.reportButton");
        loadingButton.setEnabled(false);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), WidgetTosReportViolation.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetTosReportViolation$onViewBoundOrOnResume$1(this), 62, (Object) null);
    }
}
