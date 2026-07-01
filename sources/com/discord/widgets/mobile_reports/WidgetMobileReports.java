package com.discord.widgets.mobile_reports;

import android.content.Context;
import android.view.View;
import android.widget.ProgressBar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import b.a.d.g0;
import b.a.d.i0;
import b.d.b.a.a;
import com.discord.R$layout;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetMobileReportsBinding;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import d0.g;
import d0.z.d.a0;
import d0.z.d.m;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: WidgetMobileReports.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetMobileReports extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetMobileReports.class, "binding", "getBinding()Lcom/discord/databinding/WidgetMobileReportsBinding;", 0)};
    public static final WidgetMobileReports$Companion Companion = new WidgetMobileReports$Companion(null);

    /* JADX INFO: renamed from: args$delegate, reason: from kotlin metadata */
    private final Lazy args;

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    public WidgetMobileReports() {
        super(R$layout.widget_mobile_reports);
        this.args = g.lazy(new WidgetMobileReports$$special$$inlined$args$1(this, "intent_args_key"));
        WidgetMobileReports$viewModel$2 widgetMobileReports$viewModel$2 = new WidgetMobileReports$viewModel$2(this);
        g0 g0Var = new g0(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, a0.getOrCreateKotlinClass(MobileReportsViewModel.class), new WidgetMobileReports$appViewModels$$inlined$viewModels$1(g0Var), new i0(widgetMobileReports$viewModel$2));
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetMobileReports$binding$2.INSTANCE, null, 2, null);
    }

    public static final /* synthetic */ void access$configureUI(WidgetMobileReports widgetMobileReports, MobileReportsViewModel$ViewState$Menu mobileReportsViewModel$ViewState$Menu) {
        widgetMobileReports.configureUI(mobileReportsViewModel$ViewState$Menu);
    }

    public static final /* synthetic */ MobileReportArgs access$getArgs$p(WidgetMobileReports widgetMobileReports) {
        return widgetMobileReports.getArgs();
    }

    public static final /* synthetic */ WidgetMobileReportsBinding access$getBinding$p(WidgetMobileReports widgetMobileReports) {
        return widgetMobileReports.getBinding();
    }

    public static final /* synthetic */ MobileReportsViewModel access$getViewModel$p(WidgetMobileReports widgetMobileReports) {
        return widgetMobileReports.getViewModel();
    }

    private final void configureUI(MobileReportsViewModel$ViewState$Menu viewState) {
        setActionBarDisplayHomeAsUpEnabled(!viewState.shouldHideBackArrow());
        ProgressBar progressBar = getBinding().c;
        m.checkNotNullExpressionValue(progressBar, "binding.mobileReportsProgressBar");
        progressBar.setVisibility(8);
        ReportsMenuNode reportsMenuNode = (ReportsMenuNode) getBinding().f2496b.getChildAt(0);
        MobileReportsViewModel$NodeState mobileReportsViewModel$NodeStateGenNodeState = viewState.genNodeState();
        if (reportsMenuNode == null) {
            ReportsMenuNode reportsMenuNodeCreateNodeView = createNodeView(viewState);
            reportsMenuNodeCreateNodeView.setVisibility(8);
            getBinding().f2496b.addView(reportsMenuNodeCreateNodeView);
            ViewExtensions.fadeIn$default(reportsMenuNodeCreateNodeView, 0L, null, null, new WidgetMobileReports$configureUI$1(this, viewState), 7, null);
            return;
        }
        MobileReportsViewModel$NodeState viewState2 = reportsMenuNode.getPrevViewState();
        if (!(!m.areEqual(viewState2 != null ? viewState2.getNode() : null, mobileReportsViewModel$NodeStateGenNodeState.getNode()))) {
            reportsMenuNode.setup(mobileReportsViewModel$NodeStateGenNodeState);
            setActionBarDisplayHomeAsUpEnabled(!viewState.shouldHideBackArrow());
        } else {
            ReportsMenuNode reportsMenuNodeCreateNodeView2 = createNodeView(viewState);
            reportsMenuNodeCreateNodeView2.setVisibility(8);
            ViewExtensions.fadeOut$default(reportsMenuNode, 0L, null, new WidgetMobileReports$configureUI$2(this, reportsMenuNodeCreateNodeView2, viewState), 3, null);
        }
    }

    private final ReportsMenuNode createNodeView(MobileReportsViewModel$ViewState$Menu viewState) {
        ReportsMenuNode reportsMenuNode = new ReportsMenuNode(requireContext());
        reportsMenuNode.setHandleSelectChild(new WidgetMobileReports$createNodeView$1(this));
        reportsMenuNode.setHandleBlock(new WidgetMobileReports$createNodeView$2(this));
        reportsMenuNode.setHandleCancel(new WidgetMobileReports$createNodeView$3(this));
        reportsMenuNode.setHandleSubmit(new WidgetMobileReports$createNodeView$4(this));
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
        m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        setActionBarDisplayHomeAsUpEnabled(false);
        AppFragment.setOnBackPressed$default(this, new WidgetMobileReports$sam$rx_functions_Func0$0(new WidgetMobileReports$onViewBound$1(getViewModel())), 0, 2, null);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), WidgetMobileReports.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetMobileReports$onViewBoundOrOnResume$1(this), 62, (Object) null);
    }
}
