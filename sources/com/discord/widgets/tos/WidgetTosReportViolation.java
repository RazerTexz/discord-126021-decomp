package com.discord.widgets.tos;

import a0.a.a.b;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import b.a.d.AppScreen2;
import b.a.d.AppToast;
import b.a.d.AppViewModelDelegates3;
import b.a.d.AppViewModelDelegates5;
import b.a.k.FormatUtils;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.api.report.ReportReason;
import com.discord.app.AppActivity;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetTosReportViolationBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.error.Error;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.views.LoadingButton;
import com.discord.widgets.notice.WidgetNoticeDialog;
import com.discord.widgets.tos.WidgetTosReportViolationViewModel;
import d0.LazyJVM;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import d0.z.d.Reflection2;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import rx.Subscription;

/* JADX INFO: compiled from: WidgetTosReportViolation.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetTosReportViolation extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetTosReportViolation.class, "binding", "getBinding()Lcom/discord/databinding/WidgetTosReportViolationBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String EXTRA_CHANNEL_ID = "EXTRA_CHANNEL_ID";
    private static final String EXTRA_MESSAGE_ID = "EXTRA_MESSAGE_ID";
    private static final String EXTRA_TARGET = "EXTRA_TARGET";

    /* JADX INFO: renamed from: args$delegate, reason: from kotlin metadata */
    private final Lazy args;

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* JADX INFO: compiled from: WidgetTosReportViolation.kt */
    public static final class Companion {

        /* JADX INFO: compiled from: WidgetTosReportViolation.kt */
        public static final /* data */ class Arguments {
            private final long channelId;
            private final long messageId;
            private final String target;

            public Arguments(String str, long j, long j2) {
                Intrinsics3.checkNotNullParameter(str, "target");
                this.target = str;
                this.channelId = j;
                this.messageId = j2;
            }

            public static /* synthetic */ Arguments copy$default(Arguments arguments, String str, long j, long j2, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = arguments.target;
                }
                if ((i & 2) != 0) {
                    j = arguments.channelId;
                }
                long j3 = j;
                if ((i & 4) != 0) {
                    j2 = arguments.messageId;
                }
                return arguments.copy(str, j3, j2);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final String getTarget() {
                return this.target;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final long getChannelId() {
                return this.channelId;
            }

            /* JADX INFO: renamed from: component3, reason: from getter */
            public final long getMessageId() {
                return this.messageId;
            }

            public final Arguments copy(String target, long channelId, long messageId) {
                Intrinsics3.checkNotNullParameter(target, "target");
                return new Arguments(target, channelId, messageId);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Arguments)) {
                    return false;
                }
                Arguments arguments = (Arguments) other;
                return Intrinsics3.areEqual(this.target, arguments.target) && this.channelId == arguments.channelId && this.messageId == arguments.messageId;
            }

            public final long getChannelId() {
                return this.channelId;
            }

            public final long getMessageId() {
                return this.messageId;
            }

            public final String getTarget() {
                return this.target;
            }

            public int hashCode() {
                String str = this.target;
                return b.a(this.messageId) + ((b.a(this.channelId) + ((str != null ? str.hashCode() : 0) * 31)) * 31);
            }

            public String toString() {
                StringBuilder sbU = outline.U("Arguments(target=");
                sbU.append(this.target);
                sbU.append(", channelId=");
                sbU.append(this.channelId);
                sbU.append(", messageId=");
                return outline.C(sbU, this.messageId, ")");
            }
        }

        private Companion() {
        }

        public static /* synthetic */ void show$default(Companion companion, Context context, String str, Long l, Long l2, int i, Object obj) {
            if ((i & 4) != 0) {
                l = null;
            }
            if ((i & 8) != 0) {
                l2 = null;
            }
            companion.show(context, str, l, l2);
        }

        public final void show(Context context, String target, Long channelId, Long messageId) {
            Intrinsics3.checkNotNullParameter(context, "context");
            Intrinsics3.checkNotNullParameter(target, "target");
            Intent intent = new Intent();
            intent.putExtra(WidgetTosReportViolation.EXTRA_CHANNEL_ID, channelId);
            intent.putExtra(WidgetTosReportViolation.EXTRA_MESSAGE_ID, messageId);
            intent.putExtra(WidgetTosReportViolation.EXTRA_TARGET, target);
            AppScreen2.d(context, WidgetTosReportViolation.class, intent);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.tos.WidgetTosReportViolation$handleReportSubmissionError$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetTosReportViolation.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            WidgetTosReportViolation.this.getViewModel().handleDismissError();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.tos.WidgetTosReportViolation$onViewBoundOrOnResume$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetTosReportViolation.kt */
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<WidgetTosReportViolationViewModel.ViewState, Unit> {
        public AnonymousClass1(WidgetTosReportViolation widgetTosReportViolation) {
            super(1, widgetTosReportViolation, WidgetTosReportViolation.class, "configureUI", "configureUI(Lcom/discord/widgets/tos/WidgetTosReportViolationViewModel$ViewState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetTosReportViolationViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetTosReportViolationViewModel.ViewState viewState) {
            Intrinsics3.checkNotNullParameter(viewState, "p1");
            ((WidgetTosReportViolation) this.receiver).configureUI(viewState);
        }
    }

    public WidgetTosReportViolation() {
        super(R.layout.widget_tos_report_violation);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetTosReportViolation3.INSTANCE, null, 2, null);
        WidgetTosReportViolation5 widgetTosReportViolation5 = new WidgetTosReportViolation5(this);
        AppViewModelDelegates3 appViewModelDelegates3 = new AppViewModelDelegates3(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(WidgetTosReportViolationViewModel.class), new WidgetTosReportViolation$appViewModels$$inlined$viewModels$1(appViewModelDelegates3), new AppViewModelDelegates5(widgetTosReportViolation5));
        this.args = LazyJVM.lazy(new WidgetTosReportViolation2(this));
    }

    private final void configureUI(WidgetTosReportViolationViewModel.ViewState viewState) {
        if (viewState instanceof WidgetTosReportViolationViewModel.ViewState.Loading) {
            handleLoading();
            return;
        }
        if (viewState instanceof WidgetTosReportViolationViewModel.ViewState.Loaded) {
            handleLoaded(((WidgetTosReportViolationViewModel.ViewState.Loaded) viewState).getReasons());
            return;
        }
        if (viewState instanceof WidgetTosReportViolationViewModel.ViewState.Submitting) {
            handleReportSubmitting(((WidgetTosReportViolationViewModel.ViewState.Submitting) viewState).getReason());
        } else if (viewState instanceof WidgetTosReportViolationViewModel.ViewState.Submitted) {
            handleReportSubmitted();
        } else {
            if (!(viewState instanceof WidgetTosReportViolationViewModel.ViewState.SubmissionError)) {
                throw new NoWhenBranchMatchedException();
            }
            handleReportSubmissionError();
        }
    }

    private final Companion.Arguments getArgs() {
        return (Companion.Arguments) this.args.getValue();
    }

    private final WidgetTosReportViolationBinding getBinding() {
        return (WidgetTosReportViolationBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final WidgetTosReportViolationViewModel getViewModel() {
        return (WidgetTosReportViolationViewModel) this.viewModel.getValue();
    }

    private final void handleLoaded(List<ReportReason> reasons) {
        ProgressBar progressBar = getBinding().f;
        Intrinsics3.checkNotNullExpressionValue(progressBar, "binding.reportReasonsLoading");
        progressBar.setVisibility(8);
        LoadingButton loadingButton = getBinding().f2675b;
        Intrinsics3.checkNotNullExpressionValue(loadingButton, "binding.reportButton");
        loadingButton.setEnabled(getViewModel().getReasonSelected() != null);
        getBinding().f2675b.setIsLoading(false);
        getBinding().f2675b.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.tos.WidgetTosReportViolation.handleLoaded.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetTosReportViolation.this.getViewModel().sendReport();
            }
        });
        TextView textView = getBinding().e;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.reportReasonsHeader");
        textView.setVisibility(0);
        getBinding().d.removeAllViews();
        for (final ReportReason reportReason : reasons) {
            final WidgetTosReportViolationReasonView widgetTosReportViolationReasonView = new WidgetTosReportViolationReasonView(requireContext(), null, 0, 6, null);
            if (!ViewCompat.isLaidOut(widgetTosReportViolationReasonView) || widgetTosReportViolationReasonView.isLayoutRequested()) {
                widgetTosReportViolationReasonView.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: com.discord.widgets.tos.WidgetTosReportViolation$handleLoaded$$inlined$forEach$lambda$2
                    @Override // android.view.View.OnLayoutChangeListener
                    public void onLayoutChange(View view, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {
                        Intrinsics3.checkNotNullParameter(view, "view");
                        view.removeOnLayoutChangeListener(this);
                        widgetTosReportViolationReasonView.setReason(reportReason);
                        widgetTosReportViolationReasonView.setChecked(Intrinsics3.areEqual(reportReason, this.getViewModel().getReasonSelected()));
                        widgetTosReportViolationReasonView.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.tos.WidgetTosReportViolation$handleLoaded$$inlined$forEach$lambda$2.1
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view2) {
                                if (!Intrinsics3.areEqual(this.getViewModel().getReasonSelected(), widgetTosReportViolationReasonView.getReason())) {
                                    this.getViewModel().setReasonSelected(widgetTosReportViolationReasonView.getReason());
                                    LoadingButton loadingButton2 = this.getBinding().f2675b;
                                    Intrinsics3.checkNotNullExpressionValue(loadingButton2, "binding.reportButton");
                                    loadingButton2.setEnabled(false);
                                    LinearLayout linearLayout = this.getBinding().d;
                                    Intrinsics3.checkNotNullExpressionValue(linearLayout, "binding.reportReasonsContainer");
                                    for (View view3 : ViewGroup.getChildren(linearLayout)) {
                                        Objects.requireNonNull(view3, "null cannot be cast to non-null type com.discord.widgets.tos.WidgetTosReportViolationReasonView");
                                        ((WidgetTosReportViolationReasonView) view3).setChecked(false);
                                    }
                                    widgetTosReportViolationReasonView.setChecked(true);
                                }
                                LoadingButton loadingButton3 = this.getBinding().f2675b;
                                Intrinsics3.checkNotNullExpressionValue(loadingButton3, "binding.reportButton");
                                loadingButton3.setEnabled(this.getViewModel().getReasonSelected() != null);
                            }
                        });
                    }
                });
            } else {
                widgetTosReportViolationReasonView.setReason(reportReason);
                widgetTosReportViolationReasonView.setChecked(Intrinsics3.areEqual(reportReason, getViewModel().getReasonSelected()));
                widgetTosReportViolationReasonView.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.tos.WidgetTosReportViolation$handleLoaded$$inlined$forEach$lambda$1
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        if (!Intrinsics3.areEqual(this.getViewModel().getReasonSelected(), widgetTosReportViolationReasonView.getReason())) {
                            this.getViewModel().setReasonSelected(widgetTosReportViolationReasonView.getReason());
                            LoadingButton loadingButton2 = this.getBinding().f2675b;
                            Intrinsics3.checkNotNullExpressionValue(loadingButton2, "binding.reportButton");
                            loadingButton2.setEnabled(false);
                            LinearLayout linearLayout = this.getBinding().d;
                            Intrinsics3.checkNotNullExpressionValue(linearLayout, "binding.reportReasonsContainer");
                            for (View view2 : ViewGroup.getChildren(linearLayout)) {
                                Objects.requireNonNull(view2, "null cannot be cast to non-null type com.discord.widgets.tos.WidgetTosReportViolationReasonView");
                                ((WidgetTosReportViolationReasonView) view2).setChecked(false);
                            }
                            widgetTosReportViolationReasonView.setChecked(true);
                        }
                        LoadingButton loadingButton3 = this.getBinding().f2675b;
                        Intrinsics3.checkNotNullExpressionValue(loadingButton3, "binding.reportButton");
                        loadingButton3.setEnabled(this.getViewModel().getReasonSelected() != null);
                    }
                });
            }
            getBinding().d.addView(widgetTosReportViolationReasonView);
        }
    }

    private final void handleLoading() {
        ProgressBar progressBar = getBinding().f;
        Intrinsics3.checkNotNullExpressionValue(progressBar, "binding.reportReasonsLoading");
        progressBar.setVisibility(0);
        LoadingButton loadingButton = getBinding().f2675b;
        Intrinsics3.checkNotNullExpressionValue(loadingButton, "binding.reportButton");
        loadingButton.setEnabled(false);
        getBinding().d.removeAllViews();
    }

    private final void handleReportSubmissionError() {
        LoadingButton loadingButton = getBinding().f2675b;
        Intrinsics3.checkNotNullExpressionValue(loadingButton, "binding.reportButton");
        loadingButton.setEnabled(false);
        getBinding().f2675b.setIsLoading(false);
        WidgetNoticeDialog.Companion companion = WidgetNoticeDialog.INSTANCE;
        FragmentManager parentFragmentManager = getParentFragmentManager();
        Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        WidgetNoticeDialog.Companion.show$default(companion, parentFragmentManager, FormatUtils.e(this, R.string.notice_dispatch_error, new Object[0], (4 & 4) != 0 ? FormatUtils.a.j : null), FormatUtils.e(this, R.string.report_modal_error, new Object[]{"https://dis.gd/request"}, (4 & 4) != 0 ? FormatUtils.a.j : null), FormatUtils.e(this, R.string.okay, new Object[0], (4 & 4) != 0 ? FormatUtils.a.j : null), null, null, null, null, null, null, null, null, 0, new AnonymousClass1(), 8176, null);
    }

    private final void handleReportSubmitted() {
        AppToast.i(this, R.string.report_modal_submitted, 0, 4);
        AppActivity appActivity = getAppActivity();
        if (appActivity != null) {
            appActivity.finish();
        }
    }

    private final void handleReportSubmitting(int reason) {
        LinearLayout linearLayout = getBinding().d;
        Intrinsics3.checkNotNullExpressionValue(linearLayout, "binding.reportReasonsContainer");
        Iterator<View> it = ViewGroup.getChildren(linearLayout).iterator();
        while (it.hasNext()) {
            it.next().setEnabled(false);
        }
        LoadingButton loadingButton = getBinding().f2675b;
        Intrinsics3.checkNotNullExpressionValue(loadingButton, "binding.reportButton");
        loadingButton.setEnabled(false);
        getBinding().f2675b.setIsLoading(true);
        getViewModel().sendReportAPICall(reason, getArgs().getChannelId(), getArgs().getMessageId());
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        setActionBarTitle(R.string.report);
        AppFragment.setActionBarDisplayHomeAsUpEnabled$default(this, false, 1, null);
        TextView textView = getBinding().c;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.reportHeader");
        FormatUtils.m(textView, R.string.report_message, new Object[]{getArgs().getTarget()}, (4 & 4) != 0 ? FormatUtils.g.j : null);
        LinkifiedTextView linkifiedTextView = getBinding().g;
        Intrinsics3.checkNotNullExpressionValue(linkifiedTextView, "binding.reportTooltip");
        FormatUtils.m(linkifiedTextView, R.string.form_report_help_text, new Object[]{"https://discord.com/guidelines"}, (4 & 4) != 0 ? FormatUtils.g.j : null);
        getBinding().f2675b.setIsLoading(false);
        LoadingButton loadingButton = getBinding().f2675b;
        Intrinsics3.checkNotNullExpressionValue(loadingButton, "binding.reportButton");
        loadingButton.setEnabled(false);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), (Class<?>) WidgetTosReportViolation.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass1(this));
    }
}
