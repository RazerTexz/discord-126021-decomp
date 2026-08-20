package com.discord.widgets.stage.sheet;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.core.os.BundleKt;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import com.discord.C5419R;
import com.discord.app.AppBottomSheet;
import com.discord.databinding.WidgetStageAudienceBlockedBottomSheetBinding;
import com.discord.utilities.error.Error;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.view.recycler.MaxHeightRecyclerView;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.widgets.stage.StageChannelJoinHelper;
import kotlin.Lazy;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p007b.p008a.p018d.C0865g0;
import p007b.p008a.p018d.C0869i0;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.C12083g;
import p507d0.C12116o;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12216a0;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;
import p658rx.Subscription;

/* JADX INFO: compiled from: WidgetStageAudienceBlockedBottomSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetStageAudienceBlockedBottomSheet extends AppBottomSheet {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {C1643a.m846d0(WidgetStageAudienceBlockedBottomSheet.class, "binding", "getBinding()Lcom/discord/databinding/WidgetStageAudienceBlockedBottomSheetBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
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

    /* JADX INFO: compiled from: WidgetStageAudienceBlockedBottomSheet.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void show(FragmentManager fragmentManager, long channelId, boolean launchStageFullScreen) {
            C12238m.checkNotNullParameter(fragmentManager, "fragmentManager");
            WidgetStageAudienceBlockedBottomSheet widgetStageAudienceBlockedBottomSheet = new WidgetStageAudienceBlockedBottomSheet();
            widgetStageAudienceBlockedBottomSheet.setArguments(BundleKt.bundleOf(C12116o.m10073to("com.discord.intent.extra.EXTRA_CHANNEL_ID", Long.valueOf(channelId)), C12116o.m10073to(WidgetStageAudienceBlockedBottomSheet.EXTRA_LAUNCH_FULL_SCREEN, Boolean.valueOf(launchStageFullScreen))));
            widgetStageAudienceBlockedBottomSheet.show(fragmentManager, WidgetStageAudienceBlockedBottomSheet.class.getSimpleName());
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.stage.sheet.WidgetStageAudienceBlockedBottomSheet$onResume$1 */
    /* JADX INFO: compiled from: WidgetStageAudienceBlockedBottomSheet.kt */
    public static final /* synthetic */ class C100241 extends C12236k implements Function1<StageAudienceBlockedBottomSheetViewModel.ViewState, Unit> {
        public C100241(WidgetStageAudienceBlockedBottomSheet widgetStageAudienceBlockedBottomSheet) {
            super(1, widgetStageAudienceBlockedBottomSheet, WidgetStageAudienceBlockedBottomSheet.class, "configureUI", "configureUI(Lcom/discord/widgets/stage/sheet/StageAudienceBlockedBottomSheetViewModel$ViewState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(StageAudienceBlockedBottomSheetViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(StageAudienceBlockedBottomSheetViewModel.ViewState viewState) {
            C12238m.checkNotNullParameter(viewState, "p1");
            ((WidgetStageAudienceBlockedBottomSheet) this.receiver).configureUI(viewState);
        }
    }

    public WidgetStageAudienceBlockedBottomSheet() {
        super(false, 1, null);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetStageAudienceBlockedBottomSheet$binding$2.INSTANCE, null, 2, null);
        this.channelId = C12083g.lazy(new WidgetStageAudienceBlockedBottomSheet$channelId$2(this));
        this.launchStageFullScreen = C12083g.lazy(new WidgetStageAudienceBlockedBottomSheet$launchStageFullScreen$2(this));
        WidgetStageAudienceBlockedBottomSheet$viewModel$2 widgetStageAudienceBlockedBottomSheet$viewModel$2 = new WidgetStageAudienceBlockedBottomSheet$viewModel$2(this);
        C0865g0 c0865g0 = new C0865g0(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, C12216a0.getOrCreateKotlinClass(StageAudienceBlockedBottomSheetViewModel.class), new C10021xd168dac7(c0865g0), new C0869i0(widgetStageAudienceBlockedBottomSheet$viewModel$2));
    }

    private final void configureUI(final StageAudienceBlockedBottomSheetViewModel.ViewState viewState) {
        if (viewState instanceof StageAudienceBlockedBottomSheetViewModel.ViewState.Invalid) {
            dismiss();
            return;
        }
        if (!(viewState instanceof StageAudienceBlockedBottomSheetViewModel.ViewState.Loaded)) {
            throw new NoWhenBranchMatchedException();
        }
        getBinding().f18125b.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.stage.sheet.WidgetStageAudienceBlockedBottomSheet.configureUI.1

            /* JADX INFO: renamed from: com.discord.widgets.stage.sheet.WidgetStageAudienceBlockedBottomSheet$configureUI$1$1, reason: invalid class name */
            /* JADX INFO: compiled from: WidgetStageAudienceBlockedBottomSheet.kt */
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
                    WidgetStageAudienceBlockedBottomSheet.this.dismiss();
                }
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                StageChannelJoinHelper stageChannelJoinHelper = StageChannelJoinHelper.INSTANCE;
                Context contextRequireContext = WidgetStageAudienceBlockedBottomSheet.this.requireContext();
                C12238m.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
                FragmentManager parentFragmentManager = WidgetStageAudienceBlockedBottomSheet.this.getParentFragmentManager();
                C12238m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
                StageChannelJoinHelper.connectToStage$default(stageChannelJoinHelper, contextRequireContext, parentFragmentManager, ((StageAudienceBlockedBottomSheetViewModel.ViewState.Loaded) viewState).getChannel().getId(), true, WidgetStageAudienceBlockedBottomSheet.this.getLaunchStageFullScreen(), null, null, null, null, new AnonymousClass1(), 480, null);
            }
        });
        getBinding().f18127d.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.stage.sheet.WidgetStageAudienceBlockedBottomSheet.configureUI.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetStageAudienceBlockedBottomSheet.this.dismiss();
            }
        });
        StageAudienceBlockedBottomSheetAdapter stageAudienceBlockedBottomSheetAdapter = this.adapter;
        if (stageAudienceBlockedBottomSheetAdapter == null) {
            C12238m.throwUninitializedPropertyAccessException("adapter");
        }
        stageAudienceBlockedBottomSheetAdapter.setData(((StageAudienceBlockedBottomSheetViewModel.ViewState.Loaded) viewState).getListItems());
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
        return C5419R.layout.widget_stage_audience_blocked_bottom_sheet;
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), (Class<?>) WidgetStageAudienceBlockedBottomSheet.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C100241(this));
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        C12238m.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        WidgetStageAudienceBlockedBottomSheetBinding binding = getBinding();
        C12238m.checkNotNullExpressionValue(binding, "binding");
        setPeekHeightBottomView(binding.f18124a);
        MaxHeightRecyclerView maxHeightRecyclerView = getBinding().f18126c;
        C12238m.checkNotNullExpressionValue(maxHeightRecyclerView, "binding.blockedUsers");
        this.adapter = new StageAudienceBlockedBottomSheetAdapter(maxHeightRecyclerView);
    }
}
