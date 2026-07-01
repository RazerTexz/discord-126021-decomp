package com.discord.widgets.servers.guildboost;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import b.a.a.a.GuildBoostActivatedDialog;
import b.a.d.AppScreen2;
import b.a.d.AppViewModelDelegates3;
import b.a.d.AppViewModelDelegates5;
import b.a.k.FormatUtils;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetGuildBoostTransferBinding;
import com.discord.models.domain.ModelAppliedGuildBoost;
import com.discord.models.domain.ModelGuildBoostSlot;
import com.discord.utilities.dimmer.DimmerView;
import com.discord.utilities.error.Error;
import com.discord.utilities.resources.StringResourceUtils;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.widgets.servers.guildboost.GuildBoostTransferInProgressViewModel;
import com.google.android.material.button.MaterialButton;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import d0.z.d.Reflection2;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import rx.Observable;
import rx.Subscription;

/* JADX INFO: compiled from: WidgetGuildBoostTransfer.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildBoostTransfer extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetGuildBoostTransfer.class, "binding", "getBinding()Lcom/discord/databinding/WidgetGuildBoostTransferBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String INTENT_EXTRA_PREVIOUS_GUILD_ID = "PREVIOUS_GUILD_ID";
    private static final String INTENT_EXTRA_SLOT_ID = "SLOT_ID";
    private static final String INTENT_EXTRA_SUBSCRIPTION_ID = "SUBSCRIPTION_ID";
    private static final String INTENT_EXTRA_TARGET_GUILD_ID = "TARGET_GUILD_ID";

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* JADX INFO: compiled from: WidgetGuildBoostTransfer.kt */
    public static final class Companion {
        private Companion() {
        }

        public static /* synthetic */ void create$default(Companion companion, Context context, long j, long j2, ModelGuildBoostSlot modelGuildBoostSlot, int i, Object obj) {
            if ((i & 8) != 0) {
                modelGuildBoostSlot = null;
            }
            companion.create(context, j, j2, modelGuildBoostSlot);
        }

        public final void create(Context context, long previousGuildId, long targetGuildId, ModelGuildBoostSlot slot) {
            ModelAppliedGuildBoost premiumGuildSubscription;
            Intrinsics3.checkNotNullParameter(context, "context");
            Long lValueOf = null;
            Intent intentPutExtra = new Intent().putExtra(WidgetGuildBoostTransfer.INTENT_EXTRA_PREVIOUS_GUILD_ID, previousGuildId).putExtra(WidgetGuildBoostTransfer.INTENT_EXTRA_TARGET_GUILD_ID, targetGuildId).putExtra(WidgetGuildBoostTransfer.INTENT_EXTRA_SLOT_ID, slot != null ? Long.valueOf(slot.getId()) : null);
            if (slot != null && (premiumGuildSubscription = slot.getPremiumGuildSubscription()) != null) {
                lValueOf = Long.valueOf(premiumGuildSubscription.getId());
            }
            Intent intentPutExtra2 = intentPutExtra.putExtra(WidgetGuildBoostTransfer.INTENT_EXTRA_SUBSCRIPTION_ID, lValueOf);
            Intrinsics3.checkNotNullExpressionValue(intentPutExtra2, "Intent()\n          .putE…iumGuildSubscription?.id)");
            AppScreen2.d(context, WidgetGuildBoostTransfer.class, intentPutExtra2);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.servers.guildboost.WidgetGuildBoostTransfer$configureUI$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetGuildBoostTransfer.kt */
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
            FragmentActivity fragmentActivityE = WidgetGuildBoostTransfer.this.e();
            if (fragmentActivityE != null) {
                fragmentActivityE.finish();
            }
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.servers.guildboost.WidgetGuildBoostTransfer$onViewBoundOrOnResume$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetGuildBoostTransfer.kt */
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<GuildBoostTransferInProgressViewModel.ViewState, Unit> {
        public AnonymousClass1(WidgetGuildBoostTransfer widgetGuildBoostTransfer) {
            super(1, widgetGuildBoostTransfer, WidgetGuildBoostTransfer.class, "configureUI", "configureUI(Lcom/discord/widgets/servers/guildboost/GuildBoostTransferInProgressViewModel$ViewState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(GuildBoostTransferInProgressViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(GuildBoostTransferInProgressViewModel.ViewState viewState) {
            Intrinsics3.checkNotNullParameter(viewState, "p1");
            ((WidgetGuildBoostTransfer) this.receiver).configureUI(viewState);
        }
    }

    public WidgetGuildBoostTransfer() {
        super(R.layout.widget_guild_boost_transfer);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetGuildBoostTransfer2.INSTANCE, null, 2, null);
        WidgetGuildBoostTransfer3 widgetGuildBoostTransfer3 = new WidgetGuildBoostTransfer3(this);
        AppViewModelDelegates3 appViewModelDelegates3 = new AppViewModelDelegates3(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(GuildBoostTransferInProgressViewModel.class), new WidgetGuildBoostTransfer$appViewModels$$inlined$viewModels$1(appViewModelDelegates3), new AppViewModelDelegates5(widgetGuildBoostTransfer3));
    }

    private final void configureUI(GuildBoostTransferInProgressViewModel.ViewState state) {
        if (state instanceof GuildBoostTransferInProgressViewModel.ViewState.ErrorLoading) {
            FragmentActivity fragmentActivityE = e();
            if (fragmentActivityE != null) {
                fragmentActivityE.finish();
                return;
            }
            return;
        }
        if (state instanceof GuildBoostTransferInProgressViewModel.ViewState.Loading) {
            DimmerView.setDimmed$default(getBinding().f2408b, true, false, 2, null);
            TextView textView = getBinding().d;
            Intrinsics3.checkNotNullExpressionValue(textView, "binding.guildBoostTransferError");
            textView.setVisibility(4);
            return;
        }
        if (state instanceof GuildBoostTransferInProgressViewModel.ViewState.ErrorTransfer) {
            DimmerView.setDimmed$default(getBinding().f2408b, false, false, 2, null);
            TextView textView2 = getBinding().d;
            Intrinsics3.checkNotNullExpressionValue(textView2, "binding.guildBoostTransferError");
            textView2.setVisibility(0);
            return;
        }
        if (state instanceof GuildBoostTransferInProgressViewModel.ViewState.PreTransfer) {
            GuildBoostTransferInProgressViewModel.ViewState.PreTransfer preTransfer = (GuildBoostTransferInProgressViewModel.ViewState.PreTransfer) state;
            DimmerView.setDimmed$default(getBinding().f2408b, preTransfer.isTransferInProgress(), false, 2, null);
            TextView textView3 = getBinding().d;
            Intrinsics3.checkNotNullExpressionValue(textView3, "binding.guildBoostTransferError");
            textView3.setVisibility(4);
            getBinding().e.b(preTransfer.getPreviousGuild(), -1);
            getBinding().h.b(preTransfer.getTargetGuild(), 1);
            return;
        }
        if (state instanceof GuildBoostTransferInProgressViewModel.ViewState.PostTransfer) {
            GuildBoostActivatedDialog.Companion companion = GuildBoostActivatedDialog.INSTANCE;
            FragmentManager parentFragmentManager = getParentFragmentManager();
            Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
            GuildBoostTransferInProgressViewModel.ViewState.PostTransfer postTransfer = (GuildBoostTransferInProgressViewModel.ViewState.PostTransfer) state;
            companion.a(parentFragmentManager, requireContext(), postTransfer.getTargetGuild().getName(), postTransfer.getTargetGuildSubscriptionCount() + 1, true, new AnonymousClass1());
        }
    }

    public static final void create(Context context, long j, long j2, ModelGuildBoostSlot modelGuildBoostSlot) {
        INSTANCE.create(context, j, j2, modelGuildBoostSlot);
    }

    private final WidgetGuildBoostTransferBinding getBinding() {
        return (WidgetGuildBoostTransferBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final GuildBoostTransferInProgressViewModel getViewModel() {
        return (GuildBoostTransferInProgressViewModel) this.viewModel.getValue();
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        AppFragment.setActionBarDisplayHomeAsUpEnabled$default(this, false, 1, null);
        TextView textView = getBinding().c;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.guildBoostTransferConfirmationBlurb");
        textView.setText(FormatUtils.e(this, R.string.premium_guild_subscribe_confirm_transfer_blurb, new Object[]{StringResourceUtils.getI18nPluralString(requireContext(), R.plurals.premium_guild_subscribe_confirm_transfer_blurb_slotCount, 1, 1), StringResourceUtils.getI18nPluralString(requireContext(), R.plurals.premium_guild_subscribe_confirm_transfer_blurb_guildCount, 1, 1)}, (4 & 4) != 0 ? FormatUtils.a.j : null));
        TextView textView2 = getBinding().f;
        Intrinsics3.checkNotNullExpressionValue(textView2, "binding.guildBoostTransferPreviousGuildHeader");
        textView2.setText(FormatUtils.e(this, R.string.premium_guild_subscribe_confirm_transfer_from_guild, new Object[]{StringResourceUtils.getI18nPluralString(requireContext(), R.plurals.premium_guild_subscribe_confirm_transfer_from_guild_guildCount, 1, 1)}, (4 & 4) != 0 ? FormatUtils.a.j : null));
        TextView textView3 = getBinding().i;
        Intrinsics3.checkNotNullExpressionValue(textView3, "binding.guildBoostTransferTargetGuildHeader");
        textView3.setText(FormatUtils.e(this, R.string.premium_guild_subscribe_confirm_transfer_to_guild, new Object[]{StringResourceUtils.getI18nPluralString(requireContext(), R.plurals.premium_guild_subscribe_confirm_transfer_to_guild_slotCount, 1, 1)}, (4 & 4) != 0 ? FormatUtils.a.j : null));
        getBinding().g.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.servers.guildboost.WidgetGuildBoostTransfer.onViewBound.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                WidgetGuildBoostTransfer.this.getViewModel().transferGuildBoost();
            }
        });
        MaterialButton materialButton = getBinding().g;
        Intrinsics3.checkNotNullExpressionValue(materialButton, "binding.guildBoostTransferSelect");
        materialButton.setText(FormatUtils.e(this, R.string.premium_guild_subscribe_transfer_confirm_confirmation, new Object[]{StringResourceUtils.getI18nPluralString(requireContext(), R.plurals.premium_guild_subscribe_transfer_confirm_confirmation_slotCount, 1, 1)}, (4 & 4) != 0 ? FormatUtils.a.j : null));
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        Observable observableR = ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "viewModel\n        .obser…  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe(observableR, (Class<?>) WidgetGuildBoostTransfer.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass1(this));
    }
}
