package com.discord.widgets.tos;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewGroupKt;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import com.discord.C5419R;
import com.discord.api.report.ReportReason;
import com.discord.app.AppActivity;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetTosReportViolationBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.error.Error;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.views.LoadingButton;
import com.discord.widgets.notice.WidgetNoticeDialog;
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
import p001a0.p002a.p003a.C0002b;
import p007b.p008a.p018d.C0865g0;
import p007b.p008a.p018d.C0869i0;
import p007b.p008a.p018d.C0870j;
import p007b.p008a.p018d.C0876m;
import p007b.p008a.p027k.C1107b;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.C12083g;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12216a0;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;
import p658rx.Subscription;

/* JADX INFO: compiled from: WidgetTosReportViolation.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetTosReportViolation extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {C1643a.m846d0(WidgetTosReportViolation.class, "binding", "getBinding()Lcom/discord/databinding/WidgetTosReportViolationBinding;", 0)};

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
                C12238m.checkNotNullParameter(str, "target");
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
                C12238m.checkNotNullParameter(target, "target");
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
                return C12238m.areEqual(this.target, arguments.target) && this.channelId == arguments.channelId && this.messageId == arguments.messageId;
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
                return C0002b.m3a(this.messageId) + ((C0002b.m3a(this.channelId) + ((str != null ? str.hashCode() : 0) * 31)) * 31);
            }

            public String toString() {
                StringBuilder sbM833U = C1643a.m833U("Arguments(target=");
                sbM833U.append(this.target);
                sbM833U.append(", channelId=");
                sbM833U.append(this.channelId);
                sbM833U.append(", messageId=");
                return C1643a.m815C(sbM833U, this.messageId, ")");
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
            C12238m.checkNotNullParameter(context, "context");
            C12238m.checkNotNullParameter(target, "target");
            Intent intent = new Intent();
            intent.putExtra(WidgetTosReportViolation.EXTRA_CHANNEL_ID, channelId);
            intent.putExtra(WidgetTosReportViolation.EXTRA_MESSAGE_ID, messageId);
            intent.putExtra(WidgetTosReportViolation.EXTRA_TARGET, target);
            C0870j.m156d(context, WidgetTosReportViolation.class, intent);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.tos.WidgetTosReportViolation$handleReportSubmissionError$1 */
    /* JADX INFO: compiled from: WidgetTosReportViolation.kt */
    public static final class C101751 extends AbstractC12240o implements Function0<Unit> {
        public C101751() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            WidgetTosReportViolation.this.getViewModel().handleDismissError();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.tos.WidgetTosReportViolation$onViewBoundOrOnResume$1 */
    /* JADX INFO: compiled from: WidgetTosReportViolation.kt */
    public static final /* synthetic */ class C101761 extends C12236k implements Function1<WidgetTosReportViolationViewModel.ViewState, Unit> {
        public C101761(WidgetTosReportViolation widgetTosReportViolation) {
            super(1, widgetTosReportViolation, WidgetTosReportViolation.class, "configureUI", "configureUI(Lcom/discord/widgets/tos/WidgetTosReportViolationViewModel$ViewState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetTosReportViolationViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetTosReportViolationViewModel.ViewState viewState) {
            C12238m.checkNotNullParameter(viewState, "p1");
            ((WidgetTosReportViolation) this.receiver).configureUI(viewState);
        }
    }

    public WidgetTosReportViolation() {
        super(C5419R.layout.widget_tos_report_violation);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetTosReportViolation$binding$2.INSTANCE, null, 2, null);
        WidgetTosReportViolation$viewModel$2 widgetTosReportViolation$viewModel$2 = new WidgetTosReportViolation$viewModel$2(this);
        C0865g0 c0865g0 = new C0865g0(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, C12216a0.getOrCreateKotlinClass(WidgetTosReportViolationViewModel.class), new WidgetTosReportViolation$appViewModels$$inlined$viewModels$1(c0865g0), new C0869i0(widgetTosReportViolation$viewModel$2));
        this.args = C12083g.lazy(new WidgetTosReportViolation$args$2(this));
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
        ProgressBar progressBar = getBinding().f18306f;
        C12238m.checkNotNullExpressionValue(progressBar, "binding.reportReasonsLoading");
        progressBar.setVisibility(8);
        LoadingButton loadingButton = getBinding().f18302b;
        C12238m.checkNotNullExpressionValue(loadingButton, "binding.reportButton");
        loadingButton.setEnabled(getViewModel().getReasonSelected() != null);
        getBinding().f18302b.setIsLoading(false);
        getBinding().f18302b.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.tos.WidgetTosReportViolation.handleLoaded.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetTosReportViolation.this.getViewModel().sendReport();
            }
        });
        TextView textView = getBinding().f18305e;
        C12238m.checkNotNullExpressionValue(textView, "binding.reportReasonsHeader");
        textView.setVisibility(0);
        getBinding().f18304d.removeAllViews();
        for (final ReportReason reportReason : reasons) {
            final WidgetTosReportViolationReasonView widgetTosReportViolationReasonView = new WidgetTosReportViolationReasonView(requireContext(), null, 0, 6, null);
            if (!ViewCompat.isLaidOut(widgetTosReportViolationReasonView) || widgetTosReportViolationReasonView.isLayoutRequested()) {
                widgetTosReportViolationReasonView.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: com.discord.widgets.tos.WidgetTosReportViolation$handleLoaded$$inlined$forEach$lambda$2
                    @Override // android.view.View.OnLayoutChangeListener
                    public void onLayoutChange(View view, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {
                        C12238m.checkNotNullParameter(view, "view");
                        view.removeOnLayoutChangeListener(this);
                        widgetTosReportViolationReasonView.setReason(reportReason);
                        widgetTosReportViolationReasonView.setChecked(C12238m.areEqual(reportReason, this.getViewModel().getReasonSelected()));
                        widgetTosReportViolationReasonView.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.tos.WidgetTosReportViolation$handleLoaded$$inlined$forEach$lambda$2.1
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view2) {
                                if (!C12238m.areEqual(this.getViewModel().getReasonSelected(), widgetTosReportViolationReasonView.getReason())) {
                                    this.getViewModel().setReasonSelected(widgetTosReportViolationReasonView.getReason());
                                    LoadingButton loadingButton2 = this.getBinding().f18302b;
                                    C12238m.checkNotNullExpressionValue(loadingButton2, "binding.reportButton");
                                    loadingButton2.setEnabled(false);
                                    LinearLayout linearLayout = this.getBinding().f18304d;
                                    C12238m.checkNotNullExpressionValue(linearLayout, "binding.reportReasonsContainer");
                                    for (View view3 : ViewGroupKt.getChildren(linearLayout)) {
                                        Objects.requireNonNull(view3, "null cannot be cast to non-null type com.discord.widgets.tos.WidgetTosReportViolationReasonView");
                                        ((WidgetTosReportViolationReasonView) view3).setChecked(false);
                                    }
                                    widgetTosReportViolationReasonView.setChecked(true);
                                }
                                LoadingButton loadingButton3 = this.getBinding().f18302b;
                                C12238m.checkNotNullExpressionValue(loadingButton3, "binding.reportButton");
                                loadingButton3.setEnabled(this.getViewModel().getReasonSelected() != null);
                            }
                        });
                    }
                });
            } else {
                widgetTosReportViolationReasonView.setReason(reportReason);
                widgetTosReportViolationReasonView.setChecked(C12238m.areEqual(reportReason, getViewModel().getReasonSelected()));
                widgetTosReportViolationReasonView.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.tos.WidgetTosReportViolation$handleLoaded$$inlined$forEach$lambda$1
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        if (!C12238m.areEqual(this.getViewModel().getReasonSelected(), widgetTosReportViolationReasonView.getReason())) {
                            this.getViewModel().setReasonSelected(widgetTosReportViolationReasonView.getReason());
                            LoadingButton loadingButton2 = this.getBinding().f18302b;
                            C12238m.checkNotNullExpressionValue(loadingButton2, "binding.reportButton");
                            loadingButton2.setEnabled(false);
                            LinearLayout linearLayout = this.getBinding().f18304d;
                            C12238m.checkNotNullExpressionValue(linearLayout, "binding.reportReasonsContainer");
                            for (View view2 : ViewGroupKt.getChildren(linearLayout)) {
                                Objects.requireNonNull(view2, "null cannot be cast to non-null type com.discord.widgets.tos.WidgetTosReportViolationReasonView");
                                ((WidgetTosReportViolationReasonView) view2).setChecked(false);
                            }
                            widgetTosReportViolationReasonView.setChecked(true);
                        }
                        LoadingButton loadingButton3 = this.getBinding().f18302b;
                        C12238m.checkNotNullExpressionValue(loadingButton3, "binding.reportButton");
                        loadingButton3.setEnabled(this.getViewModel().getReasonSelected() != null);
                    }
                });
            }
            getBinding().f18304d.addView(widgetTosReportViolationReasonView);
        }
    }

    private final void handleLoading() {
        ProgressBar progressBar = getBinding().f18306f;
        C12238m.checkNotNullExpressionValue(progressBar, "binding.reportReasonsLoading");
        progressBar.setVisibility(0);
        LoadingButton loadingButton = getBinding().f18302b;
        C12238m.checkNotNullExpressionValue(loadingButton, "binding.reportButton");
        loadingButton.setEnabled(false);
        getBinding().f18304d.removeAllViews();
    }

    private final void handleReportSubmissionError() {
        LoadingButton loadingButton = getBinding().f18302b;
        C12238m.checkNotNullExpressionValue(loadingButton, "binding.reportButton");
        loadingButton.setEnabled(false);
        getBinding().f18302b.setIsLoading(false);
        WidgetNoticeDialog.Companion companion = WidgetNoticeDialog.INSTANCE;
        FragmentManager parentFragmentManager = getParentFragmentManager();
        C12238m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        WidgetNoticeDialog.Companion.show$default(companion, parentFragmentManager, C1107b.m213e(this, C5419R.string.notice_dispatch_error, new Object[0], (4 & 4) != 0 ? C1107b.a.f1490j : null), C1107b.m213e(this, C5419R.string.report_modal_error, new Object[]{"https://dis.gd/request"}, (4 & 4) != 0 ? C1107b.a.f1490j : null), C1107b.m213e(this, C5419R.string.okay, new Object[0], (4 & 4) != 0 ? C1107b.a.f1490j : null), null, null, null, null, null, null, null, null, 0, new C101751(), 8176, null);
    }

    private final void handleReportSubmitted() {
        C0876m.m171i(this, C5419R.string.report_modal_submitted, 0, 4);
        AppActivity appActivity = getAppActivity();
        if (appActivity != null) {
            appActivity.finish();
        }
    }

    private final void handleReportSubmitting(int reason) {
        LinearLayout linearLayout = getBinding().f18304d;
        C12238m.checkNotNullExpressionValue(linearLayout, "binding.reportReasonsContainer");
        Iterator<View> it = ViewGroupKt.getChildren(linearLayout).iterator();
        while (it.hasNext()) {
            it.next().setEnabled(false);
        }
        LoadingButton loadingButton = getBinding().f18302b;
        C12238m.checkNotNullExpressionValue(loadingButton, "binding.reportButton");
        loadingButton.setEnabled(false);
        getBinding().f18302b.setIsLoading(true);
        getViewModel().sendReportAPICall(reason, getArgs().getChannelId(), getArgs().getMessageId());
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        C12238m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        setActionBarTitle(C5419R.string.report);
        AppFragment.setActionBarDisplayHomeAsUpEnabled$default(this, false, 1, null);
        TextView textView = getBinding().f18303c;
        C12238m.checkNotNullExpressionValue(textView, "binding.reportHeader");
        C1107b.m221m(textView, C5419R.string.report_message, new Object[]{getArgs().getTarget()}, (4 & 4) != 0 ? C1107b.g.f1495j : null);
        LinkifiedTextView linkifiedTextView = getBinding().f18307g;
        C12238m.checkNotNullExpressionValue(linkifiedTextView, "binding.reportTooltip");
        C1107b.m221m(linkifiedTextView, C5419R.string.form_report_help_text, new Object[]{"https://discord.com/guidelines"}, (4 & 4) != 0 ? C1107b.g.f1495j : null);
        getBinding().f18302b.setIsLoading(false);
        LoadingButton loadingButton = getBinding().f18302b;
        C12238m.checkNotNullExpressionValue(loadingButton, "binding.reportButton");
        loadingButton.setEnabled(false);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), (Class<?>) WidgetTosReportViolation.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C101761(this));
    }
}
