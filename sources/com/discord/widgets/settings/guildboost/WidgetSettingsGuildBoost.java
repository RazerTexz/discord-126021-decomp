package com.discord.widgets.settings.guildboost;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.recyclerview.widget.RecyclerView;
import b.a.a.a.GuildBoostCancelDialog;
import b.a.a.a.GuildBoostUncancelDialog;
import b.a.d.AppHelpDesk;
import b.a.d.AppScreen2;
import b.a.d.AppViewModelDelegates3;
import b.a.d.AppViewModelDelegates5;
import b.a.k.FormatUtils;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.app.AppFragment;
import com.discord.app.AppViewFlipper;
import com.discord.databinding.WidgetSettingsBoostBinding;
import com.discord.models.domain.ModelGuildBoostSlot;
import com.discord.stores.StoreStream;
import com.discord.utilities.error.Error;
import com.discord.utilities.mg_recycler.MGRecyclerAdapter;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.uri.UriHandler;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.widgets.guilds.WidgetGuildSelector;
import com.discord.widgets.servers.guildboost.WidgetGuildBoostConfirmation;
import com.discord.widgets.servers.guildboost.WidgetGuildBoostTransfer;
import com.discord.widgets.settings.guildboost.SettingsGuildBoostViewModel;
import com.discord.widgets.settings.premium.WidgetSettingsPremium;
import d0.t._Sets;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import d0.z.d.Reflection2;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import rx.Observable;
import rx.Subscription;

/* JADX INFO: compiled from: WidgetSettingsGuildBoost.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsGuildBoost extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetSettingsGuildBoost.class, "binding", "getBinding()Lcom/discord/databinding/WidgetSettingsBoostBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int VIEW_INDEX_FAILURE = 1;
    public static final int VIEW_INDEX_LOADED = 2;
    public static final int VIEW_INDEX_LOADING = 0;

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private WidgetSettingsGuildBoostSubscriptionAdapter guildBoostSubscriptionsAdapter;
    private SettingsGuildBoostSampleGuildAdapter sampleGuildsAdapter;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* JADX INFO: compiled from: WidgetSettingsGuildBoost.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void launch(Context context) {
            Intrinsics3.checkNotNullParameter(context, "context");
            AppScreen2.e(context, WidgetSettingsGuildBoost.class, null, 4);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.guildboost.WidgetSettingsGuildBoost$onViewBound$3, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetSettingsGuildBoost.kt */
    public static final class AnonymousClass3 extends Lambda implements Function2<Long, String, Unit> {
        public AnonymousClass3() {
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Long l, String str) {
            invoke(l.longValue(), str);
            return Unit.a;
        }

        public final void invoke(long j, String str) {
            Intrinsics3.checkNotNullParameter(str, "<anonymous parameter 1>");
            WidgetSettingsGuildBoost.this.getViewModel().handleGuildSearchCallback(j);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.guildboost.WidgetSettingsGuildBoost$onViewBoundOrOnResume$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetSettingsGuildBoost.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<SettingsGuildBoostViewModel.ViewState, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(SettingsGuildBoostViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(SettingsGuildBoostViewModel.ViewState viewState) {
            if (viewState instanceof SettingsGuildBoostViewModel.ViewState.Loaded) {
                WidgetSettingsGuildBoost.this.showContent((SettingsGuildBoostViewModel.ViewState.Loaded) viewState);
            } else if (viewState instanceof SettingsGuildBoostViewModel.ViewState.Loading) {
                WidgetSettingsGuildBoost.this.showLoadingUI();
            } else if (viewState instanceof SettingsGuildBoostViewModel.ViewState.Failure) {
                WidgetSettingsGuildBoost.this.showFailureUI();
            }
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.guildboost.WidgetSettingsGuildBoost$showContent$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetSettingsGuildBoost.kt */
    public static final class AnonymousClass1 extends Lambda implements Function2<ModelGuildBoostSlot, Long, Unit> {
        public AnonymousClass1() {
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(ModelGuildBoostSlot modelGuildBoostSlot, Long l) {
            invoke(modelGuildBoostSlot, l.longValue());
            return Unit.a;
        }

        public final void invoke(ModelGuildBoostSlot modelGuildBoostSlot, long j) {
            Intrinsics3.checkNotNullParameter(modelGuildBoostSlot, "slot");
            WidgetSettingsGuildBoost.this.getViewModel().transferClicked(modelGuildBoostSlot, j);
            WidgetGuildSelector.Companion.launch$default(WidgetGuildSelector.INSTANCE, WidgetSettingsGuildBoost.this, null, false, 0, new WidgetGuildSelector.GuildFilterFunction(_Sets.minus(StoreStream.INSTANCE.getGuilds().getGuilds().keySet(), Long.valueOf(j))), 14, null);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.guildboost.WidgetSettingsGuildBoost$showContent$2, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetSettingsGuildBoost.kt */
    public static final class AnonymousClass2 extends Lambda implements Function2<Long, Boolean, Unit> {
        public AnonymousClass2() {
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Long l, Boolean bool) {
            invoke(l.longValue(), bool.booleanValue());
            return Unit.a;
        }

        public final void invoke(long j, boolean z2) {
            WidgetSettingsGuildBoost.this.getViewModel().cancelClicked(j, z2);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.guildboost.WidgetSettingsGuildBoost$showContent$3, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetSettingsGuildBoost.kt */
    public static final class AnonymousClass3 extends Lambda implements Function1<Long, Unit> {
        public AnonymousClass3() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Long l) {
            invoke(l.longValue());
            return Unit.a;
        }

        public final void invoke(long j) {
            WidgetSettingsGuildBoost.this.getViewModel().subscribeClicked(j);
            WidgetGuildSelector.Companion.launch$default(WidgetGuildSelector.INSTANCE, WidgetSettingsGuildBoost.this, null, false, 0, null, 30, null);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.guildboost.WidgetSettingsGuildBoost$showContent$4, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetSettingsGuildBoost.kt */
    public static final /* synthetic */ class AnonymousClass4 extends FunctionReferenceImpl implements Function1<Long, Unit> {
        public AnonymousClass4(WidgetSettingsGuildBoost widgetSettingsGuildBoost) {
            super(1, widgetSettingsGuildBoost, WidgetSettingsGuildBoost.class, "handleSampleGuildSelected", "handleSampleGuildSelected(J)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Long l) {
            invoke(l.longValue());
            return Unit.a;
        }

        public final void invoke(long j) {
            ((WidgetSettingsGuildBoost) this.receiver).handleSampleGuildSelected(j);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.guildboost.WidgetSettingsGuildBoost$showContent$7, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetSettingsGuildBoost.kt */
    public static final class AnonymousClass7 extends Lambda implements Function0<Unit> {
        public AnonymousClass7() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            WidgetSettingsPremium.Companion.launch$default(WidgetSettingsPremium.INSTANCE, WidgetSettingsGuildBoost.this.requireContext(), null, null, 6, null);
        }
    }

    public WidgetSettingsGuildBoost() {
        super(R.layout.widget_settings_boost);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetSettingsGuildBoost2.INSTANCE, null, 2, null);
        WidgetSettingsGuildBoost3 widgetSettingsGuildBoost3 = WidgetSettingsGuildBoost3.INSTANCE;
        AppViewModelDelegates3 appViewModelDelegates3 = new AppViewModelDelegates3(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(SettingsGuildBoostViewModel.class), new WidgetSettingsGuildBoost$appViewModels$$inlined$viewModels$1(appViewModelDelegates3), new AppViewModelDelegates5(widgetSettingsGuildBoost3));
    }

    private final void configureNoGuildsViews(boolean hasNoGuilds) {
        ImageView imageView = getBinding().f2612b.f204b;
        Intrinsics3.checkNotNullExpressionValue(imageView, "binding.noGuilds.settingsBoostNoGuildsImage");
        imageView.setVisibility(hasNoGuilds ? 0 : 8);
        TextView textView = getBinding().f2612b.d;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.noGuilds.settingsBoostNoGuildsTitle");
        textView.setVisibility(hasNoGuilds ? 0 : 8);
        TextView textView2 = getBinding().f2612b.c;
        Intrinsics3.checkNotNullExpressionValue(textView2, "binding.noGuilds.settingsBoostNoGuildsSubtitle");
        textView2.setVisibility(hasNoGuilds ? 0 : 8);
    }

    private final WidgetSettingsBoostBinding getBinding() {
        return (WidgetSettingsBoostBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final SettingsGuildBoostViewModel getViewModel() {
        return (SettingsGuildBoostViewModel) this.viewModel.getValue();
    }

    private final void handleSampleGuildSelected(long selectedGuildId) {
        StoreStream.INSTANCE.getGuildSelected().dispatchSampleGuildIdSelected(selectedGuildId);
        Intent intent = new Intent();
        intent.putExtra("com.discord.intent.extra.EXTRA_OPEN_PANEL", true);
        intent.addFlags(268468224);
        AppScreen2.c(requireContext(), false, intent, 2);
    }

    public static final void launch(Context context) {
        INSTANCE.launch(context);
    }

    private final void showContent(SettingsGuildBoostViewModel.ViewState.Loaded viewState) {
        AppViewFlipper appViewFlipper = getBinding().c;
        Intrinsics3.checkNotNullExpressionValue(appViewFlipper, "binding.settingsBoostFlipper");
        appViewFlipper.setDisplayedChild(2);
        boolean z2 = !viewState.getGuildBoostItems().isEmpty();
        LinearLayout linearLayout = getBinding().i;
        Intrinsics3.checkNotNullExpressionValue(linearLayout, "binding.settingsBoostSubtextContainer");
        linearLayout.setVisibility(z2 ? 0 : 8);
        if (z2) {
            WidgetSettingsGuildBoostSubscriptionAdapter widgetSettingsGuildBoostSubscriptionAdapter = this.guildBoostSubscriptionsAdapter;
            if (widgetSettingsGuildBoostSubscriptionAdapter == null) {
                Intrinsics3.throwUninitializedPropertyAccessException("guildBoostSubscriptionsAdapter");
            }
            widgetSettingsGuildBoostSubscriptionAdapter.configure(viewState.getGuildBoostItems(), new AnonymousClass3(), new AnonymousClass1(), new AnonymousClass2(), viewState.getCanCancelBoosts(), viewState.getCanUncancelBoosts());
        }
        SettingsGuildBoostSampleGuildAdapter settingsGuildBoostSampleGuildAdapter = this.sampleGuildsAdapter;
        if (settingsGuildBoostSampleGuildAdapter == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("sampleGuildsAdapter");
        }
        settingsGuildBoostSampleGuildAdapter.configure(viewState.getSampleGuildItems(), new AnonymousClass4(this));
        SettingsGuildBoostViewModel.PendingAction pendingAction = viewState.getPendingAction();
        if (pendingAction instanceof SettingsGuildBoostViewModel.PendingAction.Subscribe) {
            SettingsGuildBoostViewModel.PendingAction.Subscribe subscribe = (SettingsGuildBoostViewModel.PendingAction.Subscribe) pendingAction;
            Long targetGuildId = subscribe.getTargetGuildId();
            if (targetGuildId != null) {
                targetGuildId.longValue();
                WidgetGuildBoostConfirmation.INSTANCE.create(requireContext(), subscribe.getTargetGuildId().longValue(), subscribe.getSlotId());
                getViewModel().consumePendingAction();
            }
        } else if (pendingAction instanceof SettingsGuildBoostViewModel.PendingAction.Transfer) {
            SettingsGuildBoostViewModel.PendingAction.Transfer transfer = (SettingsGuildBoostViewModel.PendingAction.Transfer) pendingAction;
            Long targetGuildId2 = transfer.getTargetGuildId();
            if (targetGuildId2 != null) {
                targetGuildId2.longValue();
                WidgetGuildBoostTransfer.INSTANCE.create(requireContext(), transfer.getPreviousGuildId(), transfer.getTargetGuildId().longValue(), transfer.getSlot());
                getViewModel().consumePendingAction();
            }
        } else if (pendingAction instanceof SettingsGuildBoostViewModel.PendingAction.Cancel) {
            GuildBoostCancelDialog.Companion bVar = GuildBoostCancelDialog.INSTANCE;
            FragmentManager parentFragmentManager = getParentFragmentManager();
            Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
            long slotId = ((SettingsGuildBoostViewModel.PendingAction.Cancel) pendingAction).getSlotId();
            Objects.requireNonNull(bVar);
            Intrinsics3.checkNotNullParameter(parentFragmentManager, "fragmentManager");
            GuildBoostCancelDialog guildBoostCancelDialog = new GuildBoostCancelDialog();
            Bundle bundle = new Bundle();
            bundle.putLong("extra_slot_id", slotId);
            guildBoostCancelDialog.setArguments(bundle);
            guildBoostCancelDialog.show(parentFragmentManager, GuildBoostCancelDialog.class.getName());
            getViewModel().consumePendingAction();
        } else if (pendingAction instanceof SettingsGuildBoostViewModel.PendingAction.Uncancel) {
            GuildBoostUncancelDialog.Companion bVar2 = GuildBoostUncancelDialog.INSTANCE;
            FragmentManager parentFragmentManager2 = getParentFragmentManager();
            Intrinsics3.checkNotNullExpressionValue(parentFragmentManager2, "parentFragmentManager");
            long slotId2 = ((SettingsGuildBoostViewModel.PendingAction.Uncancel) pendingAction).getSlotId();
            Objects.requireNonNull(bVar2);
            Intrinsics3.checkNotNullParameter(parentFragmentManager2, "fragmentManager");
            GuildBoostUncancelDialog guildBoostUncancelDialog = new GuildBoostUncancelDialog();
            Bundle bundle2 = new Bundle();
            bundle2.putLong("extra_slot_id", slotId2);
            guildBoostUncancelDialog.setArguments(bundle2);
            guildBoostUncancelDialog.show(parentFragmentManager2, GuildBoostUncancelDialog.class.getName());
            getViewModel().consumePendingAction();
        }
        getBinding().d.a(viewState.getUserPremiumTier(), new AnonymousClass7());
        getBinding().j.a(viewState.getUserPremiumTier(), !viewState.getSampleGuildItems().isEmpty());
        configureNoGuildsViews(viewState.getSampleGuildItems().isEmpty());
    }

    private final void showFailureUI() {
        AppViewFlipper appViewFlipper = getBinding().c;
        Intrinsics3.checkNotNullExpressionValue(appViewFlipper, "binding.settingsBoostFlipper");
        appViewFlipper.setDisplayedChild(1);
    }

    private final void showLoadingUI() {
        AppViewFlipper appViewFlipper = getBinding().c;
        Intrinsics3.checkNotNullExpressionValue(appViewFlipper, "binding.settingsBoostFlipper");
        appViewFlipper.setDisplayedChild(0);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        AppFragment.setActionBarDisplayHomeAsUpEnabled$default(this, false, 1, null);
        setActionBarSubtitle(R.string.user_settings);
        setActionBarTitle(R.string.premium_guild_subscription_title);
        MGRecyclerAdapter.Companion companion = MGRecyclerAdapter.INSTANCE;
        RecyclerView recyclerView = getBinding().e;
        Intrinsics3.checkNotNullExpressionValue(recyclerView, "binding.settingsBoostRecycler");
        this.guildBoostSubscriptionsAdapter = (WidgetSettingsGuildBoostSubscriptionAdapter) companion.configure(new WidgetSettingsGuildBoostSubscriptionAdapter(recyclerView));
        RecyclerView recyclerView2 = getBinding().g;
        Intrinsics3.checkNotNullExpressionValue(recyclerView2, "binding.settingsBoostSampleGuilds");
        this.sampleGuildsAdapter = (SettingsGuildBoostSampleGuildAdapter) companion.configure(new SettingsGuildBoostSampleGuildAdapter(recyclerView2));
        final String strA = AppHelpDesk.a.a(360028038352L, null);
        LinkifiedTextView linkifiedTextView = getBinding().h;
        Intrinsics3.checkNotNullExpressionValue(linkifiedTextView, "binding.settingsBoostSubtext");
        FormatUtils.m(linkifiedTextView, R.string.premium_guild_subscription_subtitle_mobile_2, new Object[]{strA}, (4 & 4) != 0 ? FormatUtils.g.j : null);
        getBinding().h.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.settings.guildboost.WidgetSettingsGuildBoost.onViewBound.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                UriHandler.handle$default(UriHandler.INSTANCE, outline.x(view2, "it", "it.context"), strA, false, false, null, 28, null);
            }
        });
        getBinding().f.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.settings.guildboost.WidgetSettingsGuildBoost.onViewBound.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                WidgetSettingsGuildBoost.this.getViewModel().retryClicked();
            }
        });
        getBinding().e.setHasFixedSize(false);
        WidgetGuildSelector.Companion.registerForResult$default(WidgetGuildSelector.INSTANCE, this, null, false, new AnonymousClass3(), 6, null);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        Observable<SettingsGuildBoostViewModel.ViewState> observableR = getViewModel().observeViewState().r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "viewModel\n        .obser…  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.bindToComponentLifecycle$default(observableR, this, null, 2, null), (Class<?>) WidgetSettingsPremium.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass1());
    }
}
