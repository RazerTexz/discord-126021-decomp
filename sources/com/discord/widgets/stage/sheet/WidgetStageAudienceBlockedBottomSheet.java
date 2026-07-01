package com.discord.widgets.stage.sheet;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import b.a.d.g0;
import b.a.d.i0;
import b.d.b.a.a;
import com.discord.R$layout;
import com.discord.app.AppBottomSheet;
import com.discord.databinding.WidgetStageAudienceBlockedBottomSheetBinding;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.view.recycler.MaxHeightRecyclerView;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import d0.g;
import d0.z.d.a0;
import d0.z.d.m;
import kotlin.Lazy;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: WidgetStageAudienceBlockedBottomSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetStageAudienceBlockedBottomSheet extends AppBottomSheet {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetStageAudienceBlockedBottomSheet.class, "binding", "getBinding()Lcom/discord/databinding/WidgetStageAudienceBlockedBottomSheetBinding;", 0)};
    public static final WidgetStageAudienceBlockedBottomSheet$Companion Companion = new WidgetStageAudienceBlockedBottomSheet$Companion(null);
    private static final String EXTRA_LAUNCH_FULL_SCREEN = "LAUNCH_FULL_SCREEN";
    private StageAudienceBlockedBottomSheetAdapter adapter;

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* JADX INFO: renamed from: channelId$delegate, reason: from kotlin metadata */
    private final Lazy channelId;

    /* JADX INFO: renamed from: launchStageFullScreen$delegate, reason: from kotlin metadata */
    private final Lazy launchStageFullScreen;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    public WidgetStageAudienceBlockedBottomSheet() {
        super(false, 1, null);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetStageAudienceBlockedBottomSheet$binding$2.INSTANCE, null, 2, null);
        this.channelId = g.lazy(new WidgetStageAudienceBlockedBottomSheet$channelId$2(this));
        this.launchStageFullScreen = g.lazy(new WidgetStageAudienceBlockedBottomSheet$launchStageFullScreen$2(this));
        WidgetStageAudienceBlockedBottomSheet$viewModel$2 widgetStageAudienceBlockedBottomSheet$viewModel$2 = new WidgetStageAudienceBlockedBottomSheet$viewModel$2(this);
        g0 g0Var = new g0(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, a0.getOrCreateKotlinClass(StageAudienceBlockedBottomSheetViewModel.class), new WidgetStageAudienceBlockedBottomSheet$appViewModels$$inlined$viewModels$1(g0Var), new i0(widgetStageAudienceBlockedBottomSheet$viewModel$2));
    }

    public static final /* synthetic */ void access$configureUI(WidgetStageAudienceBlockedBottomSheet widgetStageAudienceBlockedBottomSheet, StageAudienceBlockedBottomSheetViewModel$ViewState stageAudienceBlockedBottomSheetViewModel$ViewState) {
        widgetStageAudienceBlockedBottomSheet.configureUI(stageAudienceBlockedBottomSheetViewModel$ViewState);
    }

    public static final /* synthetic */ Bundle access$getArgumentsOrDefault$p(WidgetStageAudienceBlockedBottomSheet widgetStageAudienceBlockedBottomSheet) {
        return widgetStageAudienceBlockedBottomSheet.getArgumentsOrDefault();
    }

    public static final /* synthetic */ long access$getChannelId$p(WidgetStageAudienceBlockedBottomSheet widgetStageAudienceBlockedBottomSheet) {
        return widgetStageAudienceBlockedBottomSheet.getChannelId();
    }

    public static final /* synthetic */ boolean access$getLaunchStageFullScreen$p(WidgetStageAudienceBlockedBottomSheet widgetStageAudienceBlockedBottomSheet) {
        return widgetStageAudienceBlockedBottomSheet.getLaunchStageFullScreen();
    }

    private final void configureUI(StageAudienceBlockedBottomSheetViewModel$ViewState viewState) {
        if (viewState instanceof StageAudienceBlockedBottomSheetViewModel$ViewState$Invalid) {
            dismiss();
            return;
        }
        if (!(viewState instanceof StageAudienceBlockedBottomSheetViewModel$ViewState$Loaded)) {
            throw new NoWhenBranchMatchedException();
        }
        getBinding().f2647b.setOnClickListener(new WidgetStageAudienceBlockedBottomSheet$configureUI$1(this, viewState));
        getBinding().d.setOnClickListener(new WidgetStageAudienceBlockedBottomSheet$configureUI$2(this));
        StageAudienceBlockedBottomSheetAdapter stageAudienceBlockedBottomSheetAdapter = this.adapter;
        if (stageAudienceBlockedBottomSheetAdapter == null) {
            m.throwUninitializedPropertyAccessException("adapter");
        }
        stageAudienceBlockedBottomSheetAdapter.setData(((StageAudienceBlockedBottomSheetViewModel$ViewState$Loaded) viewState).getListItems());
    }

    private final WidgetStageAudienceBlockedBottomSheetBinding getBinding() {
        return (WidgetStageAudienceBlockedBottomSheetBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final long getChannelId() {
        return ((Number) this.channelId.getValue()).longValue();
    }

    private final boolean getLaunchStageFullScreen() {
        return ((Boolean) this.launchStageFullScreen.getValue()).booleanValue();
    }

    private final StageAudienceBlockedBottomSheetViewModel getViewModel() {
        return (StageAudienceBlockedBottomSheetViewModel) this.viewModel.getValue();
    }

    @Override // com.discord.app.AppBottomSheet
    public int getContentViewResId() {
        return R$layout.widget_stage_audience_blocked_bottom_sheet;
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), WidgetStageAudienceBlockedBottomSheet.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetStageAudienceBlockedBottomSheet$onResume$1(this), 62, (Object) null);
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        m.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        WidgetStageAudienceBlockedBottomSheetBinding binding = getBinding();
        m.checkNotNullExpressionValue(binding, "binding");
        setPeekHeightBottomView(binding.a);
        MaxHeightRecyclerView maxHeightRecyclerView = getBinding().c;
        m.checkNotNullExpressionValue(maxHeightRecyclerView, "binding.blockedUsers");
        this.adapter = new StageAudienceBlockedBottomSheetAdapter(maxHeightRecyclerView);
    }
}
