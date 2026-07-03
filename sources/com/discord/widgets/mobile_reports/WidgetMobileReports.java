package com.discord.widgets.mobile_reports;

import android.content.Context;
import android.view.View;
import android.widget.ProgressBar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import com.discord.C5419R;
import com.discord.api.report.NodeElementResult;
import com.discord.api.report.ReportNodeChild;
import com.discord.app.AppActivity;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetMobileReportsBinding;
import com.discord.utilities.error.Error;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.widgets.mobile_reports.MobileReportArgs;
import com.discord.widgets.mobile_reports.MobileReportsViewModel;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p007b.p008a.p018d.C0865g0;
import p007b.p008a.p018d.C0869i0;
import p007b.p008a.p018d.C0870j;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.C12083g;
import p507d0.p580t.C12163u;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12216a0;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;
import p658rx.Subscription;
import p658rx.functions.Func0;

/* JADX INFO: compiled from: WidgetMobileReports.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetMobileReports extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {C1643a.m846d0(WidgetMobileReports.class, "binding", "getBinding()Lcom/discord/databinding/WidgetMobileReportsBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: args$delegate, reason: from kotlin metadata */
    private final Lazy args;

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* JADX INFO: compiled from: WidgetMobileReports.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void launchDirectoryServerReport(Context context, long guildId, long hubId, long channelId) {
            C12238m.checkNotNullParameter(context, "context");
            C0870j.m156d(context, WidgetMobileReports.class, new MobileReportArgs.DirectoryServer(guildId, hubId, channelId));
        }

        public final void launchGuildScheduledEventReport(Context context, long guildId, long eventId) {
            C12238m.checkNotNullParameter(context, "context");
            C0870j.m156d(context, WidgetMobileReports.class, new MobileReportArgs.GuildScheduledEvent(guildId, eventId));
        }

        public final void launchMessageReport(Context context, long messageId, long channelId) {
            C12238m.checkNotNullParameter(context, "context");
            C0870j.m156d(context, WidgetMobileReports.class, new MobileReportArgs.Message(messageId, channelId));
        }

        public final void launchStageChannelReport(Context context, long channelId) {
            C12238m.checkNotNullParameter(context, "context");
            C0870j.m156d(context, WidgetMobileReports.class, new MobileReportArgs.StageChannel(channelId));
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.mobile_reports.WidgetMobileReports$configureUI$1 */
    /* JADX INFO: compiled from: WidgetMobileReports.kt */
    public static final class C90821 extends AbstractC12240o implements Function0<Unit> {
        public final /* synthetic */ MobileReportsViewModel.ViewState.Menu $viewState;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C90821(MobileReportsViewModel.ViewState.Menu menu) {
            super(0);
            this.$viewState = menu;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            WidgetMobileReports.this.setActionBarDisplayHomeAsUpEnabled(!this.$viewState.shouldHideBackArrow());
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.mobile_reports.WidgetMobileReports$configureUI$2 */
    /* JADX INFO: compiled from: WidgetMobileReports.kt */
    public static final class C90832 extends AbstractC12240o implements Function0<Unit> {
        public final /* synthetic */ ReportsMenuNode $nextNodeView;
        public final /* synthetic */ MobileReportsViewModel.ViewState.Menu $viewState;

        /* JADX INFO: renamed from: com.discord.widgets.mobile_reports.WidgetMobileReports$configureUI$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: WidgetMobileReports.kt */
        public static final class AnonymousClass1 extends AbstractC12240o implements Function0<Unit> {
            public AnonymousClass1() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.f27425a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                C90832 c90832 = C90832.this;
                WidgetMobileReports.this.setActionBarDisplayHomeAsUpEnabled(!c90832.$viewState.shouldHideBackArrow());
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C90832(ReportsMenuNode reportsMenuNode, MobileReportsViewModel.ViewState.Menu menu) {
            super(0);
            this.$nextNodeView = reportsMenuNode;
            this.$viewState = menu;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            WidgetMobileReports.this.getBinding().f17268b.removeAllViewsInLayout();
            WidgetMobileReports.this.getBinding().f17268b.addView(this.$nextNodeView);
            ViewExtensions.fadeIn$default(this.$nextNodeView, 0L, null, null, new AnonymousClass1(), 7, null);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.mobile_reports.WidgetMobileReports$createNodeView$1 */
    /* JADX INFO: compiled from: WidgetMobileReports.kt */
    public static final class C90841 extends AbstractC12240o implements Function2<ReportNodeChild, MobileReportsViewModel.NodeState, Unit> {
        public C90841() {
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(ReportNodeChild reportNodeChild, MobileReportsViewModel.NodeState nodeState) {
            invoke2(reportNodeChild, nodeState);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ReportNodeChild reportNodeChild, MobileReportsViewModel.NodeState nodeState) {
            C12238m.checkNotNullParameter(reportNodeChild, "destination");
            C12238m.checkNotNullParameter(nodeState, "nodeState");
            MobileReportsViewModel viewModel = WidgetMobileReports.this.getViewModel();
            MobileReportsViewModel.CheckboxElement checkboxElement = nodeState.getCheckboxElement();
            viewModel.handleNext(reportNodeChild, checkboxElement != null ? new NodeElementResult(checkboxElement.getName(), C12163u.toList(checkboxElement.getSelections())) : null);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.mobile_reports.WidgetMobileReports$createNodeView$2 */
    /* JADX INFO: compiled from: WidgetMobileReports.kt */
    public static final class C90852 extends AbstractC12240o implements Function0<Unit> {
        public C90852() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            WidgetMobileReports.this.getViewModel().handleBlockUser();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.mobile_reports.WidgetMobileReports$createNodeView$3 */
    /* JADX INFO: compiled from: WidgetMobileReports.kt */
    public static final class C90863 extends AbstractC12240o implements Function0<Unit> {
        public C90863() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            AppActivity appActivity = WidgetMobileReports.this.getAppActivity();
            if (appActivity != null) {
                appActivity.finish();
            }
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.mobile_reports.WidgetMobileReports$createNodeView$4 */
    /* JADX INFO: compiled from: WidgetMobileReports.kt */
    public static final class C90874 extends AbstractC12240o implements Function0<Unit> {
        public C90874() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            WidgetMobileReports.this.getViewModel().handleSubmit();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.mobile_reports.WidgetMobileReports$onViewBound$1 */
    /* JADX INFO: compiled from: WidgetMobileReports.kt */
    public static final /* synthetic */ class C90881 extends C12236k implements Function0<Boolean> {
        public C90881(MobileReportsViewModel mobileReportsViewModel) {
            super(0, mobileReportsViewModel, MobileReportsViewModel.class, "handleBack", "handleBack()Z", 0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Boolean invoke() {
            return Boolean.valueOf(invoke2());
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final boolean invoke2() {
            return ((MobileReportsViewModel) this.receiver).handleBack();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.mobile_reports.WidgetMobileReports$onViewBoundOrOnResume$1 */
    /* JADX INFO: compiled from: WidgetMobileReports.kt */
    public static final class C90891 extends AbstractC12240o implements Function1<MobileReportsViewModel.ViewState, Unit> {
        public C90891() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(MobileReportsViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(MobileReportsViewModel.ViewState viewState) {
            AppActivity appActivity;
            C12238m.checkNotNullParameter(viewState, "viewState");
            if (viewState instanceof MobileReportsViewModel.ViewState.Menu) {
                WidgetMobileReports.this.configureUI((MobileReportsViewModel.ViewState.Menu) viewState);
            } else {
                if (!(viewState instanceof MobileReportsViewModel.ViewState.Invalid) || (appActivity = WidgetMobileReports.this.getAppActivity()) == null) {
                    return;
                }
                appActivity.finish();
            }
        }
    }

    public WidgetMobileReports() {
        super(C5419R.layout.widget_mobile_reports);
        this.args = C12083g.lazy(new WidgetMobileReports$$special$$inlined$args$1(this, "intent_args_key"));
        WidgetMobileReports$viewModel$2 widgetMobileReports$viewModel$2 = new WidgetMobileReports$viewModel$2(this);
        C0865g0 c0865g0 = new C0865g0(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, C12216a0.getOrCreateKotlinClass(MobileReportsViewModel.class), new WidgetMobileReports$appViewModels$$inlined$viewModels$1(c0865g0), new C0869i0(widgetMobileReports$viewModel$2));
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetMobileReports$binding$2.INSTANCE, null, 2, null);
    }

    private final void configureUI(MobileReportsViewModel.ViewState.Menu viewState) {
        setActionBarDisplayHomeAsUpEnabled(!viewState.shouldHideBackArrow());
        ProgressBar progressBar = getBinding().f17269c;
        C12238m.checkNotNullExpressionValue(progressBar, "binding.mobileReportsProgressBar");
        progressBar.setVisibility(8);
        ReportsMenuNode reportsMenuNode = (ReportsMenuNode) getBinding().f17268b.getChildAt(0);
        MobileReportsViewModel.NodeState nodeStateGenNodeState = viewState.genNodeState();
        if (reportsMenuNode == null) {
            ReportsMenuNode reportsMenuNodeCreateNodeView = createNodeView(viewState);
            reportsMenuNodeCreateNodeView.setVisibility(8);
            getBinding().f17268b.addView(reportsMenuNodeCreateNodeView);
            ViewExtensions.fadeIn$default(reportsMenuNodeCreateNodeView, 0L, null, null, new C90821(viewState), 7, null);
            return;
        }
        MobileReportsViewModel.NodeState viewState2 = reportsMenuNode.getPrevViewState();
        if (!(!C12238m.areEqual(viewState2 != null ? viewState2.getNode() : null, nodeStateGenNodeState.getNode()))) {
            reportsMenuNode.setup(nodeStateGenNodeState);
            setActionBarDisplayHomeAsUpEnabled(!viewState.shouldHideBackArrow());
        } else {
            ReportsMenuNode reportsMenuNodeCreateNodeView2 = createNodeView(viewState);
            reportsMenuNodeCreateNodeView2.setVisibility(8);
            ViewExtensions.fadeOut$default(reportsMenuNode, 0L, null, new C90832(reportsMenuNodeCreateNodeView2, viewState), 3, null);
        }
    }

    private final ReportsMenuNode createNodeView(MobileReportsViewModel.ViewState.Menu viewState) {
        ReportsMenuNode reportsMenuNode = new ReportsMenuNode(requireContext());
        reportsMenuNode.setHandleSelectChild(new C90841());
        reportsMenuNode.setHandleBlock(new C90852());
        reportsMenuNode.setHandleCancel(new C90863());
        reportsMenuNode.setHandleSubmit(new C90874());
        reportsMenuNode.setup(viewState.genNodeState());
        return reportsMenuNode;
    }

    private final MobileReportArgs getArgs() {
        return (MobileReportArgs) this.args.getValue();
    }

    private final WidgetMobileReportsBinding getBinding() {
        return (WidgetMobileReportsBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final MobileReportsViewModel getViewModel() {
        return (MobileReportsViewModel) this.viewModel.getValue();
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        C12238m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        setActionBarDisplayHomeAsUpEnabled(false);
        final C90881 c90881 = new C90881(getViewModel());
        AppFragment.setOnBackPressed$default(this, new Func0() { // from class: com.discord.widgets.mobile_reports.WidgetMobileReports$sam$rx_functions_Func0$0
            @Override // p658rx.functions.Func0, java.util.concurrent.Callable
            public final /* synthetic */ Object call() {
                return c90881.invoke();
            }
        }, 0, 2, null);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), (Class<?>) WidgetMobileReports.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C90891());
    }
}
