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
import b.a.a.a.a$b;
import b.a.a.a.b;
import b.a.a.a.b$b;
import b.a.d.f;
import b.a.d.g0;
import b.a.d.i0;
import b.a.d.j;
import b.d.b.a.a;
import com.discord.R$layout;
import com.discord.app.AppFragment;
import com.discord.app.AppViewFlipper;
import com.discord.databinding.WidgetSettingsBoostBinding;
import com.discord.stores.StoreStream;
import com.discord.utilities.mg_recycler.MGRecyclerAdapter;
import com.discord.utilities.mg_recycler.MGRecyclerAdapter$Companion;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.widgets.guilds.WidgetGuildSelector;
import com.discord.widgets.guilds.WidgetGuildSelector$Companion;
import com.discord.widgets.servers.guildboost.WidgetGuildBoostConfirmation;
import com.discord.widgets.servers.guildboost.WidgetGuildBoostTransfer;
import com.discord.widgets.settings.premium.WidgetSettingsPremium;
import d0.z.d.a0;
import d0.z.d.m;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;
import rx.Observable;

/* JADX INFO: compiled from: WidgetSettingsGuildBoost.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsGuildBoost extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetSettingsGuildBoost.class, "binding", "getBinding()Lcom/discord/databinding/WidgetSettingsBoostBinding;", 0)};
    public static final WidgetSettingsGuildBoost$Companion Companion = new WidgetSettingsGuildBoost$Companion(null);
    public static final int VIEW_INDEX_FAILURE = 1;
    public static final int VIEW_INDEX_LOADED = 2;
    public static final int VIEW_INDEX_LOADING = 0;

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private WidgetSettingsGuildBoostSubscriptionAdapter guildBoostSubscriptionsAdapter;
    private SettingsGuildBoostSampleGuildAdapter sampleGuildsAdapter;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    public WidgetSettingsGuildBoost() {
        super(R$layout.widget_settings_boost);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetSettingsGuildBoost$binding$2.INSTANCE, null, 2, null);
        WidgetSettingsGuildBoost$viewModel$2 widgetSettingsGuildBoost$viewModel$2 = WidgetSettingsGuildBoost$viewModel$2.INSTANCE;
        g0 g0Var = new g0(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, a0.getOrCreateKotlinClass(SettingsGuildBoostViewModel.class), new WidgetSettingsGuildBoost$appViewModels$$inlined$viewModels$1(g0Var), new i0(widgetSettingsGuildBoost$viewModel$2));
    }

    public static final /* synthetic */ SettingsGuildBoostViewModel access$getViewModel$p(WidgetSettingsGuildBoost widgetSettingsGuildBoost) {
        return widgetSettingsGuildBoost.getViewModel();
    }

    public static final /* synthetic */ void access$handleSampleGuildSelected(WidgetSettingsGuildBoost widgetSettingsGuildBoost, long j) {
        widgetSettingsGuildBoost.handleSampleGuildSelected(j);
    }

    public static final /* synthetic */ void access$showContent(WidgetSettingsGuildBoost widgetSettingsGuildBoost, SettingsGuildBoostViewModel$ViewState$Loaded settingsGuildBoostViewModel$ViewState$Loaded) {
        widgetSettingsGuildBoost.showContent(settingsGuildBoostViewModel$ViewState$Loaded);
    }

    public static final /* synthetic */ void access$showFailureUI(WidgetSettingsGuildBoost widgetSettingsGuildBoost) {
        widgetSettingsGuildBoost.showFailureUI();
    }

    public static final /* synthetic */ void access$showLoadingUI(WidgetSettingsGuildBoost widgetSettingsGuildBoost) {
        widgetSettingsGuildBoost.showLoadingUI();
    }

    private final void configureNoGuildsViews(boolean hasNoGuilds) {
        ImageView imageView = getBinding().f2612b.f204b;
        m.checkNotNullExpressionValue(imageView, "binding.noGuilds.settingsBoostNoGuildsImage");
        imageView.setVisibility(hasNoGuilds ? 0 : 8);
        TextView textView = getBinding().f2612b.d;
        m.checkNotNullExpressionValue(textView, "binding.noGuilds.settingsBoostNoGuildsTitle");
        textView.setVisibility(hasNoGuilds ? 0 : 8);
        TextView textView2 = getBinding().f2612b.c;
        m.checkNotNullExpressionValue(textView2, "binding.noGuilds.settingsBoostNoGuildsSubtitle");
        textView2.setVisibility(hasNoGuilds ? 0 : 8);
    }

    private final WidgetSettingsBoostBinding getBinding() {
        return (WidgetSettingsBoostBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final SettingsGuildBoostViewModel getViewModel() {
        return (SettingsGuildBoostViewModel) this.viewModel.getValue();
    }

    private final void handleSampleGuildSelected(long selectedGuildId) {
        StoreStream.Companion.getGuildSelected().dispatchSampleGuildIdSelected(selectedGuildId);
        Intent intent = new Intent();
        intent.putExtra("com.discord.intent.extra.EXTRA_OPEN_PANEL", true);
        intent.addFlags(268468224);
        j.c(requireContext(), false, intent, 2);
    }

    public static final void launch(Context context) {
        Companion.launch(context);
    }

    private final void showContent(SettingsGuildBoostViewModel$ViewState$Loaded viewState) {
        AppViewFlipper appViewFlipper = getBinding().c;
        m.checkNotNullExpressionValue(appViewFlipper, "binding.settingsBoostFlipper");
        appViewFlipper.setDisplayedChild(2);
        boolean z2 = !viewState.getGuildBoostItems().isEmpty();
        LinearLayout linearLayout = getBinding().i;
        m.checkNotNullExpressionValue(linearLayout, "binding.settingsBoostSubtextContainer");
        linearLayout.setVisibility(z2 ? 0 : 8);
        if (z2) {
            WidgetSettingsGuildBoostSubscriptionAdapter widgetSettingsGuildBoostSubscriptionAdapter = this.guildBoostSubscriptionsAdapter;
            if (widgetSettingsGuildBoostSubscriptionAdapter == null) {
                m.throwUninitializedPropertyAccessException("guildBoostSubscriptionsAdapter");
            }
            widgetSettingsGuildBoostSubscriptionAdapter.configure(viewState.getGuildBoostItems(), new WidgetSettingsGuildBoost$showContent$3(this), new WidgetSettingsGuildBoost$showContent$1(this), new WidgetSettingsGuildBoost$showContent$2(this), viewState.getCanCancelBoosts(), viewState.getCanUncancelBoosts());
        }
        SettingsGuildBoostSampleGuildAdapter settingsGuildBoostSampleGuildAdapter = this.sampleGuildsAdapter;
        if (settingsGuildBoostSampleGuildAdapter == null) {
            m.throwUninitializedPropertyAccessException("sampleGuildsAdapter");
        }
        settingsGuildBoostSampleGuildAdapter.configure(viewState.getSampleGuildItems(), new WidgetSettingsGuildBoost$showContent$4(this));
        SettingsGuildBoostViewModel$PendingAction pendingAction = viewState.getPendingAction();
        if (pendingAction instanceof SettingsGuildBoostViewModel$PendingAction$Subscribe) {
            SettingsGuildBoostViewModel$PendingAction$Subscribe settingsGuildBoostViewModel$PendingAction$Subscribe = (SettingsGuildBoostViewModel$PendingAction$Subscribe) pendingAction;
            Long targetGuildId = settingsGuildBoostViewModel$PendingAction$Subscribe.getTargetGuildId();
            if (targetGuildId != null) {
                targetGuildId.longValue();
                WidgetGuildBoostConfirmation.Companion.create(requireContext(), settingsGuildBoostViewModel$PendingAction$Subscribe.getTargetGuildId().longValue(), settingsGuildBoostViewModel$PendingAction$Subscribe.getSlotId());
                getViewModel().consumePendingAction();
            }
        } else if (pendingAction instanceof SettingsGuildBoostViewModel$PendingAction$Transfer) {
            SettingsGuildBoostViewModel$PendingAction$Transfer settingsGuildBoostViewModel$PendingAction$Transfer = (SettingsGuildBoostViewModel$PendingAction$Transfer) pendingAction;
            Long targetGuildId2 = settingsGuildBoostViewModel$PendingAction$Transfer.getTargetGuildId();
            if (targetGuildId2 != null) {
                targetGuildId2.longValue();
                WidgetGuildBoostTransfer.Companion.create(requireContext(), settingsGuildBoostViewModel$PendingAction$Transfer.getPreviousGuildId(), settingsGuildBoostViewModel$PendingAction$Transfer.getTargetGuildId().longValue(), settingsGuildBoostViewModel$PendingAction$Transfer.getSlot());
                getViewModel().consumePendingAction();
            }
        } else if (pendingAction instanceof SettingsGuildBoostViewModel$PendingAction$Cancel) {
            b$b b_b = b.k;
            FragmentManager parentFragmentManager = getParentFragmentManager();
            m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
            long slotId = ((SettingsGuildBoostViewModel$PendingAction$Cancel) pendingAction).getSlotId();
            Objects.requireNonNull(b_b);
            m.checkNotNullParameter(parentFragmentManager, "fragmentManager");
            b bVar = new b();
            Bundle bundle = new Bundle();
            bundle.putLong("extra_slot_id", slotId);
            bVar.setArguments(bundle);
            bVar.show(parentFragmentManager, b.class.getName());
            getViewModel().consumePendingAction();
        } else if (pendingAction instanceof SettingsGuildBoostViewModel$PendingAction$Uncancel) {
            a$b a_b = b.a.a.a.a.k;
            FragmentManager parentFragmentManager2 = getParentFragmentManager();
            m.checkNotNullExpressionValue(parentFragmentManager2, "parentFragmentManager");
            long slotId2 = ((SettingsGuildBoostViewModel$PendingAction$Uncancel) pendingAction).getSlotId();
            Objects.requireNonNull(a_b);
            m.checkNotNullParameter(parentFragmentManager2, "fragmentManager");
            b.a.a.a.a aVar = new b.a.a.a.a();
            Bundle bundle2 = new Bundle();
            bundle2.putLong("extra_slot_id", slotId2);
            aVar.setArguments(bundle2);
            aVar.show(parentFragmentManager2, b.a.a.a.a.class.getName());
            getViewModel().consumePendingAction();
        }
        getBinding().d.a(viewState.getUserPremiumTier(), new WidgetSettingsGuildBoost$showContent$7(this));
        getBinding().j.a(viewState.getUserPremiumTier(), !viewState.getSampleGuildItems().isEmpty());
        configureNoGuildsViews(viewState.getSampleGuildItems().isEmpty());
    }

    private final void showFailureUI() {
        AppViewFlipper appViewFlipper = getBinding().c;
        m.checkNotNullExpressionValue(appViewFlipper, "binding.settingsBoostFlipper");
        appViewFlipper.setDisplayedChild(1);
    }

    private final void showLoadingUI() {
        AppViewFlipper appViewFlipper = getBinding().c;
        m.checkNotNullExpressionValue(appViewFlipper, "binding.settingsBoostFlipper");
        appViewFlipper.setDisplayedChild(0);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        AppFragment.setActionBarDisplayHomeAsUpEnabled$default(this, false, 1, null);
        setActionBarSubtitle(2131896797);
        setActionBarTitle(2131894154);
        MGRecyclerAdapter$Companion mGRecyclerAdapter$Companion = MGRecyclerAdapter.Companion;
        RecyclerView recyclerView = getBinding().e;
        m.checkNotNullExpressionValue(recyclerView, "binding.settingsBoostRecycler");
        this.guildBoostSubscriptionsAdapter = (WidgetSettingsGuildBoostSubscriptionAdapter) mGRecyclerAdapter$Companion.configure(new WidgetSettingsGuildBoostSubscriptionAdapter(recyclerView));
        RecyclerView recyclerView2 = getBinding().g;
        m.checkNotNullExpressionValue(recyclerView2, "binding.settingsBoostSampleGuilds");
        this.sampleGuildsAdapter = (SettingsGuildBoostSampleGuildAdapter) mGRecyclerAdapter$Companion.configure(new SettingsGuildBoostSampleGuildAdapter(recyclerView2));
        String strA = f.a.a(360028038352L, null);
        LinkifiedTextView linkifiedTextView = getBinding().h;
        m.checkNotNullExpressionValue(linkifiedTextView, "binding.settingsBoostSubtext");
        b.a.k.b.n(linkifiedTextView, 2131894153, new Object[]{strA}, null, 4);
        getBinding().h.setOnClickListener(new WidgetSettingsGuildBoost$onViewBound$1(strA));
        getBinding().f.setOnClickListener(new WidgetSettingsGuildBoost$onViewBound$2(this));
        getBinding().e.setHasFixedSize(false);
        WidgetGuildSelector$Companion.registerForResult$default(WidgetGuildSelector.Companion, this, null, false, new WidgetSettingsGuildBoost$onViewBound$3(this), 6, null);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        Observable<SettingsGuildBoostViewModel$ViewState> observableR = getViewModel().observeViewState().r();
        m.checkNotNullExpressionValue(observableR, "viewModel\n        .obser…  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(observableR, this, null, 2, null), WidgetSettingsPremium.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetSettingsGuildBoost$onViewBoundOrOnResume$1(this), 62, (Object) null);
    }
}
