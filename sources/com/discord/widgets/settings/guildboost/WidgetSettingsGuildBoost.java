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
import com.discord.C5419R;
import com.discord.app.AppFragment;
import com.discord.app.AppViewFlipper;
import com.discord.databinding.WidgetSettingsBoostBinding;
import com.discord.models.domain.ModelGuildBoostSlot;
import com.discord.stores.StoreStream;
import com.discord.utilities.error.Error;
import com.discord.utilities.mg_recycler.MGRecyclerAdapter;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.uri.UriHandler;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.widgets.guilds.WidgetGuildSelector;
import com.discord.widgets.servers.guildboost.WidgetGuildBoostConfirmation;
import com.discord.widgets.servers.guildboost.WidgetGuildBoostTransfer;
import com.discord.widgets.settings.premium.WidgetSettingsPremium;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p007b.p008a.p009a.p010a.C0791a;
import p007b.p008a.p009a.p010a.C0792b;
import p007b.p008a.p018d.C0862f;
import p007b.p008a.p018d.C0865g0;
import p007b.p008a.p018d.C0869i0;
import p007b.p008a.p018d.C0870j;
import p007b.p008a.p027k.C1107b;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p580t.C12150o0;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12216a0;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;
import p658rx.Observable;
import p658rx.Subscription;

/* JADX INFO: compiled from: WidgetSettingsGuildBoost.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsGuildBoost extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {C1643a.m846d0(WidgetSettingsGuildBoost.class, "binding", "getBinding()Lcom/discord/databinding/WidgetSettingsBoostBinding;", 0)};

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
            C12238m.checkNotNullParameter(context, "context");
            C0870j.m157e(context, WidgetSettingsGuildBoost.class, null, 4);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.guildboost.WidgetSettingsGuildBoost$onViewBound$3 */
    /* JADX INFO: compiled from: WidgetSettingsGuildBoost.kt */
    public static final class C98583 extends AbstractC12240o implements Function2<Long, String, Unit> {
        public C98583() {
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Long l, String str) {
            invoke(l.longValue(), str);
            return Unit.f27425a;
        }

        public final void invoke(long j, String str) {
            C12238m.checkNotNullParameter(str, "<anonymous parameter 1>");
            WidgetSettingsGuildBoost.this.getViewModel().handleGuildSearchCallback(j);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.guildboost.WidgetSettingsGuildBoost$onViewBoundOrOnResume$1 */
    /* JADX INFO: compiled from: WidgetSettingsGuildBoost.kt */
    public static final class C98591 extends AbstractC12240o implements Function1<SettingsGuildBoostViewModel.ViewState, Unit> {
        public C98591() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(SettingsGuildBoostViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.f27425a;
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

    /* JADX INFO: renamed from: com.discord.widgets.settings.guildboost.WidgetSettingsGuildBoost$showContent$1 */
    /* JADX INFO: compiled from: WidgetSettingsGuildBoost.kt */
    public static final class C98601 extends AbstractC12240o implements Function2<ModelGuildBoostSlot, Long, Unit> {
        public C98601() {
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(ModelGuildBoostSlot modelGuildBoostSlot, Long l) {
            invoke(modelGuildBoostSlot, l.longValue());
            return Unit.f27425a;
        }

        public final void invoke(ModelGuildBoostSlot modelGuildBoostSlot, long j) {
            C12238m.checkNotNullParameter(modelGuildBoostSlot, "slot");
            WidgetSettingsGuildBoost.this.getViewModel().transferClicked(modelGuildBoostSlot, j);
            WidgetGuildSelector.Companion.launch$default(WidgetGuildSelector.INSTANCE, WidgetSettingsGuildBoost.this, null, false, 0, new WidgetGuildSelector.GuildFilterFunction(C12150o0.minus(StoreStream.INSTANCE.getGuilds().getGuilds().keySet(), Long.valueOf(j))), 14, null);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.guildboost.WidgetSettingsGuildBoost$showContent$2 */
    /* JADX INFO: compiled from: WidgetSettingsGuildBoost.kt */
    public static final class C98612 extends AbstractC12240o implements Function2<Long, Boolean, Unit> {
        public C98612() {
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Long l, Boolean bool) {
            invoke(l.longValue(), bool.booleanValue());
            return Unit.f27425a;
        }

        public final void invoke(long j, boolean z2) {
            WidgetSettingsGuildBoost.this.getViewModel().cancelClicked(j, z2);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.guildboost.WidgetSettingsGuildBoost$showContent$3 */
    /* JADX INFO: compiled from: WidgetSettingsGuildBoost.kt */
    public static final class C98623 extends AbstractC12240o implements Function1<Long, Unit> {
        public C98623() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Long l) {
            invoke(l.longValue());
            return Unit.f27425a;
        }

        public final void invoke(long j) {
            WidgetSettingsGuildBoost.this.getViewModel().subscribeClicked(j);
            WidgetGuildSelector.Companion.launch$default(WidgetGuildSelector.INSTANCE, WidgetSettingsGuildBoost.this, null, false, 0, null, 30, null);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.guildboost.WidgetSettingsGuildBoost$showContent$4 */
    /* JADX INFO: compiled from: WidgetSettingsGuildBoost.kt */
    public static final /* synthetic */ class C98634 extends C12236k implements Function1<Long, Unit> {
        public C98634(WidgetSettingsGuildBoost widgetSettingsGuildBoost) {
            super(1, widgetSettingsGuildBoost, WidgetSettingsGuildBoost.class, "handleSampleGuildSelected", "handleSampleGuildSelected(J)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Long l) {
            invoke(l.longValue());
            return Unit.f27425a;
        }

        public final void invoke(long j) {
            ((WidgetSettingsGuildBoost) this.receiver).handleSampleGuildSelected(j);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.guildboost.WidgetSettingsGuildBoost$showContent$7 */
    /* JADX INFO: compiled from: WidgetSettingsGuildBoost.kt */
    public static final class C98647 extends AbstractC12240o implements Function0<Unit> {
        public C98647() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            WidgetSettingsPremium.Companion.launch$default(WidgetSettingsPremium.INSTANCE, WidgetSettingsGuildBoost.this.requireContext(), null, null, 6, null);
        }
    }

    public WidgetSettingsGuildBoost() {
        super(C5419R.layout.widget_settings_boost);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetSettingsGuildBoost$binding$2.INSTANCE, null, 2, null);
        WidgetSettingsGuildBoost$viewModel$2 widgetSettingsGuildBoost$viewModel$2 = WidgetSettingsGuildBoost$viewModel$2.INSTANCE;
        C0865g0 c0865g0 = new C0865g0(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, C12216a0.getOrCreateKotlinClass(SettingsGuildBoostViewModel.class), new WidgetSettingsGuildBoost$appViewModels$$inlined$viewModels$1(c0865g0), new C0869i0(widgetSettingsGuildBoost$viewModel$2));
    }

    private final void configureNoGuildsViews(boolean hasNoGuilds) {
        ImageView imageView = getBinding().f17921b.f1251b;
        C12238m.checkNotNullExpressionValue(imageView, "binding.noGuilds.settingsBoostNoGuildsImage");
        imageView.setVisibility(hasNoGuilds ? 0 : 8);
        TextView textView = getBinding().f17921b.f1253d;
        C12238m.checkNotNullExpressionValue(textView, "binding.noGuilds.settingsBoostNoGuildsTitle");
        textView.setVisibility(hasNoGuilds ? 0 : 8);
        TextView textView2 = getBinding().f17921b.f1252c;
        C12238m.checkNotNullExpressionValue(textView2, "binding.noGuilds.settingsBoostNoGuildsSubtitle");
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
        C0870j.m155c(requireContext(), false, intent, 2);
    }

    public static final void launch(Context context) {
        INSTANCE.launch(context);
    }

    private final void showContent(SettingsGuildBoostViewModel.ViewState.Loaded viewState) {
        AppViewFlipper appViewFlipper = getBinding().f17922c;
        C12238m.checkNotNullExpressionValue(appViewFlipper, "binding.settingsBoostFlipper");
        appViewFlipper.setDisplayedChild(2);
        boolean z2 = !viewState.getGuildBoostItems().isEmpty();
        LinearLayout linearLayout = getBinding().f17928i;
        C12238m.checkNotNullExpressionValue(linearLayout, "binding.settingsBoostSubtextContainer");
        linearLayout.setVisibility(z2 ? 0 : 8);
        if (z2) {
            WidgetSettingsGuildBoostSubscriptionAdapter widgetSettingsGuildBoostSubscriptionAdapter = this.guildBoostSubscriptionsAdapter;
            if (widgetSettingsGuildBoostSubscriptionAdapter == null) {
                C12238m.throwUninitializedPropertyAccessException("guildBoostSubscriptionsAdapter");
            }
            widgetSettingsGuildBoostSubscriptionAdapter.configure(viewState.getGuildBoostItems(), new C98623(), new C98601(), new C98612(), viewState.getCanCancelBoosts(), viewState.getCanUncancelBoosts());
        }
        SettingsGuildBoostSampleGuildAdapter settingsGuildBoostSampleGuildAdapter = this.sampleGuildsAdapter;
        if (settingsGuildBoostSampleGuildAdapter == null) {
            C12238m.throwUninitializedPropertyAccessException("sampleGuildsAdapter");
        }
        settingsGuildBoostSampleGuildAdapter.configure(viewState.getSampleGuildItems(), new C98634(this));
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
            C0792b.Companion bVar = C0792b.INSTANCE;
            FragmentManager parentFragmentManager = getParentFragmentManager();
            C12238m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
            long slotId = ((SettingsGuildBoostViewModel.PendingAction.Cancel) pendingAction).getSlotId();
            Objects.requireNonNull(bVar);
            C12238m.checkNotNullParameter(parentFragmentManager, "fragmentManager");
            C0792b c0792b = new C0792b();
            Bundle bundle = new Bundle();
            bundle.putLong("extra_slot_id", slotId);
            c0792b.setArguments(bundle);
            c0792b.show(parentFragmentManager, C0792b.class.getName());
            getViewModel().consumePendingAction();
        } else if (pendingAction instanceof SettingsGuildBoostViewModel.PendingAction.Uncancel) {
            C0791a.Companion bVar2 = C0791a.INSTANCE;
            FragmentManager parentFragmentManager2 = getParentFragmentManager();
            C12238m.checkNotNullExpressionValue(parentFragmentManager2, "parentFragmentManager");
            long slotId2 = ((SettingsGuildBoostViewModel.PendingAction.Uncancel) pendingAction).getSlotId();
            Objects.requireNonNull(bVar2);
            C12238m.checkNotNullParameter(parentFragmentManager2, "fragmentManager");
            C0791a c0791a = new C0791a();
            Bundle bundle2 = new Bundle();
            bundle2.putLong("extra_slot_id", slotId2);
            c0791a.setArguments(bundle2);
            c0791a.show(parentFragmentManager2, C0791a.class.getName());
            getViewModel().consumePendingAction();
        }
        getBinding().f17923d.m8595a(viewState.getUserPremiumTier(), new C98647());
        getBinding().f17929j.m8597a(viewState.getUserPremiumTier(), !viewState.getSampleGuildItems().isEmpty());
        configureNoGuildsViews(viewState.getSampleGuildItems().isEmpty());
    }

    private final void showFailureUI() {
        AppViewFlipper appViewFlipper = getBinding().f17922c;
        C12238m.checkNotNullExpressionValue(appViewFlipper, "binding.settingsBoostFlipper");
        appViewFlipper.setDisplayedChild(1);
    }

    private final void showLoadingUI() {
        AppViewFlipper appViewFlipper = getBinding().f17922c;
        C12238m.checkNotNullExpressionValue(appViewFlipper, "binding.settingsBoostFlipper");
        appViewFlipper.setDisplayedChild(0);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        C12238m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        AppFragment.setActionBarDisplayHomeAsUpEnabled$default(this, false, 1, null);
        setActionBarSubtitle(C5419R.string.user_settings);
        setActionBarTitle(C5419R.string.premium_guild_subscription_title);
        MGRecyclerAdapter.Companion companion = MGRecyclerAdapter.INSTANCE;
        RecyclerView recyclerView = getBinding().f17924e;
        C12238m.checkNotNullExpressionValue(recyclerView, "binding.settingsBoostRecycler");
        this.guildBoostSubscriptionsAdapter = (WidgetSettingsGuildBoostSubscriptionAdapter) companion.configure(new WidgetSettingsGuildBoostSubscriptionAdapter(recyclerView));
        RecyclerView recyclerView2 = getBinding().f17926g;
        C12238m.checkNotNullExpressionValue(recyclerView2, "binding.settingsBoostSampleGuilds");
        this.sampleGuildsAdapter = (SettingsGuildBoostSampleGuildAdapter) companion.configure(new SettingsGuildBoostSampleGuildAdapter(recyclerView2));
        final String strM149a = C0862f.f507a.m149a(360028038352L, null);
        LinkifiedTextView linkifiedTextView = getBinding().f17927h;
        C12238m.checkNotNullExpressionValue(linkifiedTextView, "binding.settingsBoostSubtext");
        C1107b.m221m(linkifiedTextView, C5419R.string.premium_guild_subscription_subtitle_mobile_2, new Object[]{strM149a}, (4 & 4) != 0 ? C1107b.g.f1495j : null);
        getBinding().f17927h.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.settings.guildboost.WidgetSettingsGuildBoost.onViewBound.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                UriHandler.handle$default(UriHandler.INSTANCE, C1643a.m885x(view2, "it", "it.context"), strM149a, false, false, null, 28, null);
            }
        });
        getBinding().f17925f.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.settings.guildboost.WidgetSettingsGuildBoost.onViewBound.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                WidgetSettingsGuildBoost.this.getViewModel().retryClicked();
            }
        });
        getBinding().f17924e.setHasFixedSize(false);
        WidgetGuildSelector.Companion.registerForResult$default(WidgetGuildSelector.INSTANCE, this, null, false, new C98583(), 6, null);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        Observable<SettingsGuildBoostViewModel.ViewState> observableM11112r = getViewModel().observeViewState().m11112r();
        C12238m.checkNotNullExpressionValue(observableM11112r, "viewModel\n        .obser…  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.bindToComponentLifecycle$default(observableM11112r, this, null, 2, null), (Class<?>) WidgetSettingsPremium.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C98591());
    }
}
