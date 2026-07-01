package com.discord.widgets.channels.permissions;

import android.content.Context;
import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import b.a.d.g0;
import b.a.d.i0;
import b.d.b.a.a;
import com.discord.R$layout;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.app.AppFragment;
import com.discord.app.AppViewFlipper;
import com.discord.databinding.WidgetChannelSettingsPermissionsOverviewBinding;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.views.segmentedcontrol.SegmentedControlContainer;
import d0.z.d.a0;
import d0.z.d.m;
import kotlin.Lazy;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;
import rx.Observable;

/* JADX INFO: compiled from: WidgetChannelSettingsPermissionsOverview.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelSettingsPermissionsOverview extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetChannelSettingsPermissionsOverview.class, "viewBinding", "getViewBinding()Lcom/discord/databinding/WidgetChannelSettingsPermissionsOverviewBinding;", 0)};
    public static final WidgetChannelSettingsPermissionsOverview$Companion Companion = new WidgetChannelSettingsPermissionsOverview$Companion(null);
    private static final int TAB_INDEX_ADVANCED = 1;
    private static final int TAB_INDEX_MODERATOR = 0;
    private static final int VIEW_INDEX_ADVANCED = 1;
    private static final int VIEW_INDEX_STAGE_MODERATOR = 0;

    /* JADX INFO: renamed from: viewBinding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate viewBinding;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    public WidgetChannelSettingsPermissionsOverview() {
        super(R$layout.widget_channel_settings_permissions_overview);
        this.viewBinding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetChannelSettingsPermissionsOverview$viewBinding$2.INSTANCE, null, 2, null);
        WidgetChannelSettingsPermissionsOverview$viewModel$2 widgetChannelSettingsPermissionsOverview$viewModel$2 = new WidgetChannelSettingsPermissionsOverview$viewModel$2(this);
        g0 g0Var = new g0(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, a0.getOrCreateKotlinClass(WidgetChannelSettingsPermissionsOverviewViewModel.class), new WidgetChannelSettingsPermissionsOverview$appViewModels$$inlined$viewModels$1(g0Var), new i0(widgetChannelSettingsPermissionsOverview$viewModel$2));
    }

    public static final /* synthetic */ void access$configureTabs(WidgetChannelSettingsPermissionsOverview widgetChannelSettingsPermissionsOverview, WidgetChannelSettingsPermissionsOverviewViewModel$ViewState widgetChannelSettingsPermissionsOverviewViewModel$ViewState) {
        widgetChannelSettingsPermissionsOverview.configureTabs(widgetChannelSettingsPermissionsOverviewViewModel$ViewState);
    }

    public static final /* synthetic */ void access$configureUI(WidgetChannelSettingsPermissionsOverview widgetChannelSettingsPermissionsOverview, WidgetChannelSettingsPermissionsOverview$Model widgetChannelSettingsPermissionsOverview$Model) {
        widgetChannelSettingsPermissionsOverview.configureUI(widgetChannelSettingsPermissionsOverview$Model);
    }

    public static final /* synthetic */ long access$getChannelIdFromIntent(WidgetChannelSettingsPermissionsOverview widgetChannelSettingsPermissionsOverview) {
        return widgetChannelSettingsPermissionsOverview.getChannelIdFromIntent();
    }

    public static final /* synthetic */ WidgetChannelSettingsPermissionsOverviewViewModel access$getViewModel$p(WidgetChannelSettingsPermissionsOverview widgetChannelSettingsPermissionsOverview) {
        return widgetChannelSettingsPermissionsOverview.getViewModel();
    }

    private final void configureTabs(WidgetChannelSettingsPermissionsOverviewViewModel$ViewState viewState) {
        int i;
        int iOrdinal = viewState.getSelectedTab().ordinal();
        if (iOrdinal == 0) {
            AppViewFlipper appViewFlipper = getViewBinding().f2279b;
            m.checkNotNullExpressionValue(appViewFlipper, "viewBinding.flipper");
            appViewFlipper.setDisplayedChild(0);
        } else if (iOrdinal == 1) {
            AppViewFlipper appViewFlipper2 = getViewBinding().f2279b;
            m.checkNotNullExpressionValue(appViewFlipper2, "viewBinding.flipper");
            appViewFlipper2.setDisplayedChild(1);
        }
        SegmentedControlContainer segmentedControlContainer = getViewBinding().c;
        int iOrdinal2 = viewState.getSelectedTab().ordinal();
        if (iOrdinal2 == 0) {
            i = 0;
        } else {
            if (iOrdinal2 != 1) {
                throw new NoWhenBranchMatchedException();
            }
            i = 1;
        }
        segmentedControlContainer.a(i);
        getViewBinding().c.setOnSegmentSelectedChangeListener(new WidgetChannelSettingsPermissionsOverview$configureTabs$1(this));
        SegmentedControlContainer segmentedControlContainer2 = getViewBinding().c;
        m.checkNotNullExpressionValue(segmentedControlContainer2, "viewBinding.segmentedControl");
        segmentedControlContainer2.setVisibility(viewState.getAvailableTabs().size() > 1 ? 0 : 8);
    }

    private final void configureToolbar(Channel channel) {
        setActionBarTitle(ChannelUtils.k(channel) ? 2131887472 : 2131887604);
        setActionBarSubtitle(ChannelUtils.d(channel, requireContext(), true));
    }

    private final void configureUI(WidgetChannelSettingsPermissionsOverview$Model model) {
        if (model == null || !model.getCanManage()) {
            requireActivity().finish();
        } else {
            configureToolbar(model.getChannel());
        }
    }

    private final long getChannelIdFromIntent() {
        return getMostRecentIntent().getLongExtra("com.discord.intent.extra.EXTRA_CHANNEL_ID", -1L);
    }

    private final WidgetChannelSettingsPermissionsOverviewBinding getViewBinding() {
        return (WidgetChannelSettingsPermissionsOverviewBinding) this.viewBinding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final WidgetChannelSettingsPermissionsOverviewViewModel getViewModel() {
        return (WidgetChannelSettingsPermissionsOverviewViewModel) this.viewModel.getValue();
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        AppFragment.setActionBarDisplayHomeAsUpEnabled$default(this, false, 1, null);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        Observable<WidgetChannelSettingsPermissionsOverview$Model> observableR = WidgetChannelSettingsPermissionsOverview$Model.Companion.get(getMostRecentIntent().getLongExtra("com.discord.intent.extra.EXTRA_CHANNEL_ID", -1L)).r();
        m.checkNotNullExpressionValue(observableR, "Model\n        .get(chann…  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observableR), this, null, 2, null), WidgetChannelSettingsPermissionsOverview.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetChannelSettingsPermissionsOverview$onViewBoundOrOnResume$1(this), 62, (Object) null);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), WidgetChannelSettingsPermissionsOverview.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetChannelSettingsPermissionsOverview$onViewBoundOrOnResume$2(this), 62, (Object) null);
    }
}
