package com.discord.widgets.servers.guildboost;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import com.discord.C5419R;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetGuildBoostTransferBinding;
import com.discord.models.domain.ModelAppliedGuildBoost;
import com.discord.models.domain.ModelGuildBoostSlot;
import com.discord.utilities.dimmer.DimmerView;
import com.discord.utilities.error.Error;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.resources.StringResourceUtilsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.google.android.material.button.MaterialButton;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p007b.p008a.p009a.p010a.C0793c;
import p007b.p008a.p018d.C0865g0;
import p007b.p008a.p018d.C0869i0;
import p007b.p008a.p018d.C0870j;
import p007b.p008a.p027k.C1107b;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12216a0;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;
import p658rx.Observable;
import p658rx.Subscription;

/* JADX INFO: compiled from: WidgetGuildBoostTransfer.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildBoostTransfer extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {C1643a.m846d0(WidgetGuildBoostTransfer.class, "binding", "getBinding()Lcom/discord/databinding/WidgetGuildBoostTransferBinding;", 0)};

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
            C12238m.checkNotNullParameter(context, "context");
            Long lValueOf = null;
            Intent intentPutExtra = new Intent().putExtra(WidgetGuildBoostTransfer.INTENT_EXTRA_PREVIOUS_GUILD_ID, previousGuildId).putExtra(WidgetGuildBoostTransfer.INTENT_EXTRA_TARGET_GUILD_ID, targetGuildId).putExtra(WidgetGuildBoostTransfer.INTENT_EXTRA_SLOT_ID, slot != null ? Long.valueOf(slot.getId()) : null);
            if (slot != null && (premiumGuildSubscription = slot.getPremiumGuildSubscription()) != null) {
                lValueOf = Long.valueOf(premiumGuildSubscription.getId());
            }
            Intent intentPutExtra2 = intentPutExtra.putExtra(WidgetGuildBoostTransfer.INTENT_EXTRA_SUBSCRIPTION_ID, lValueOf);
            C12238m.checkNotNullExpressionValue(intentPutExtra2, "Intent()\n          .putE…iumGuildSubscription?.id)");
            C0870j.m156d(context, WidgetGuildBoostTransfer.class, intentPutExtra2);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.servers.guildboost.WidgetGuildBoostTransfer$configureUI$1 */
    /* JADX INFO: compiled from: WidgetGuildBoostTransfer.kt */
    public static final class C95201 extends AbstractC12240o implements Function0<Unit> {
        public C95201() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            FragmentActivity fragmentActivityM95e = WidgetGuildBoostTransfer.this.m95e();
            if (fragmentActivityM95e != null) {
                fragmentActivityM95e.finish();
            }
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.servers.guildboost.WidgetGuildBoostTransfer$onViewBoundOrOnResume$1 */
    /* JADX INFO: compiled from: WidgetGuildBoostTransfer.kt */
    public static final /* synthetic */ class C95221 extends C12236k implements Function1<GuildBoostTransferInProgressViewModel.ViewState, Unit> {
        public C95221(WidgetGuildBoostTransfer widgetGuildBoostTransfer) {
            super(1, widgetGuildBoostTransfer, WidgetGuildBoostTransfer.class, "configureUI", "configureUI(Lcom/discord/widgets/servers/guildboost/GuildBoostTransferInProgressViewModel$ViewState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(GuildBoostTransferInProgressViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(GuildBoostTransferInProgressViewModel.ViewState viewState) {
            C12238m.checkNotNullParameter(viewState, "p1");
            ((WidgetGuildBoostTransfer) this.receiver).configureUI(viewState);
        }
    }

    public WidgetGuildBoostTransfer() {
        super(C5419R.layout.widget_guild_boost_transfer);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetGuildBoostTransfer$binding$2.INSTANCE, null, 2, null);
        WidgetGuildBoostTransfer$viewModel$2 widgetGuildBoostTransfer$viewModel$2 = new WidgetGuildBoostTransfer$viewModel$2(this);
        C0865g0 c0865g0 = new C0865g0(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, C12216a0.getOrCreateKotlinClass(GuildBoostTransferInProgressViewModel.class), new WidgetGuildBoostTransfer$appViewModels$$inlined$viewModels$1(c0865g0), new C0869i0(widgetGuildBoostTransfer$viewModel$2));
    }

    private final void configureUI(GuildBoostTransferInProgressViewModel.ViewState state) {
        if (state instanceof GuildBoostTransferInProgressViewModel.ViewState.ErrorLoading) {
            FragmentActivity fragmentActivityM95e = m95e();
            if (fragmentActivityM95e != null) {
                fragmentActivityM95e.finish();
                return;
            }
            return;
        }
        if (state instanceof GuildBoostTransferInProgressViewModel.ViewState.Loading) {
            DimmerView.setDimmed$default(getBinding().f16741b, true, false, 2, null);
            TextView textView = getBinding().f16743d;
            C12238m.checkNotNullExpressionValue(textView, "binding.guildBoostTransferError");
            textView.setVisibility(4);
            return;
        }
        if (state instanceof GuildBoostTransferInProgressViewModel.ViewState.ErrorTransfer) {
            DimmerView.setDimmed$default(getBinding().f16741b, false, false, 2, null);
            TextView textView2 = getBinding().f16743d;
            C12238m.checkNotNullExpressionValue(textView2, "binding.guildBoostTransferError");
            textView2.setVisibility(0);
            return;
        }
        if (state instanceof GuildBoostTransferInProgressViewModel.ViewState.PreTransfer) {
            GuildBoostTransferInProgressViewModel.ViewState.PreTransfer preTransfer = (GuildBoostTransferInProgressViewModel.ViewState.PreTransfer) state;
            DimmerView.setDimmed$default(getBinding().f16741b, preTransfer.isTransferInProgress(), false, 2, null);
            TextView textView3 = getBinding().f16743d;
            C12238m.checkNotNullExpressionValue(textView3, "binding.guildBoostTransferError");
            textView3.setVisibility(4);
            getBinding().f16744e.m8592b(preTransfer.getPreviousGuild(), -1);
            getBinding().f16747h.m8592b(preTransfer.getTargetGuild(), 1);
            return;
        }
        if (state instanceof GuildBoostTransferInProgressViewModel.ViewState.PostTransfer) {
            C0793c.Companion companion = C0793c.INSTANCE;
            FragmentManager parentFragmentManager = getParentFragmentManager();
            C12238m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
            GuildBoostTransferInProgressViewModel.ViewState.PostTransfer postTransfer = (GuildBoostTransferInProgressViewModel.ViewState.PostTransfer) state;
            companion.m101a(parentFragmentManager, requireContext(), postTransfer.getTargetGuild().getName(), postTransfer.getTargetGuildSubscriptionCount() + 1, true, new C95201());
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
        C12238m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        AppFragment.setActionBarDisplayHomeAsUpEnabled$default(this, false, 1, null);
        TextView textView = getBinding().f16742c;
        C12238m.checkNotNullExpressionValue(textView, "binding.guildBoostTransferConfirmationBlurb");
        textView.setText(C1107b.m213e(this, C5419R.string.premium_guild_subscribe_confirm_transfer_blurb, new Object[]{StringResourceUtilsKt.getI18nPluralString(requireContext(), C5419R.plurals.premium_guild_subscribe_confirm_transfer_blurb_slotCount, 1, 1), StringResourceUtilsKt.getI18nPluralString(requireContext(), C5419R.plurals.premium_guild_subscribe_confirm_transfer_blurb_guildCount, 1, 1)}, (4 & 4) != 0 ? C1107b.a.f1490j : null));
        TextView textView2 = getBinding().f16745f;
        C12238m.checkNotNullExpressionValue(textView2, "binding.guildBoostTransferPreviousGuildHeader");
        textView2.setText(C1107b.m213e(this, C5419R.string.premium_guild_subscribe_confirm_transfer_from_guild, new Object[]{StringResourceUtilsKt.getI18nPluralString(requireContext(), C5419R.plurals.premium_guild_subscribe_confirm_transfer_from_guild_guildCount, 1, 1)}, (4 & 4) != 0 ? C1107b.a.f1490j : null));
        TextView textView3 = getBinding().f16748i;
        C12238m.checkNotNullExpressionValue(textView3, "binding.guildBoostTransferTargetGuildHeader");
        textView3.setText(C1107b.m213e(this, C5419R.string.premium_guild_subscribe_confirm_transfer_to_guild, new Object[]{StringResourceUtilsKt.getI18nPluralString(requireContext(), C5419R.plurals.premium_guild_subscribe_confirm_transfer_to_guild_slotCount, 1, 1)}, (4 & 4) != 0 ? C1107b.a.f1490j : null));
        getBinding().f16746g.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.servers.guildboost.WidgetGuildBoostTransfer.onViewBound.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                WidgetGuildBoostTransfer.this.getViewModel().transferGuildBoost();
            }
        });
        MaterialButton materialButton = getBinding().f16746g;
        C12238m.checkNotNullExpressionValue(materialButton, "binding.guildBoostTransferSelect");
        materialButton.setText(C1107b.m213e(this, C5419R.string.premium_guild_subscribe_transfer_confirm_confirmation, new Object[]{StringResourceUtilsKt.getI18nPluralString(requireContext(), C5419R.plurals.premium_guild_subscribe_transfer_confirm_confirmation_slotCount, 1, 1)}, (4 & 4) != 0 ? C1107b.a.f1490j : null));
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        Observable observableM11112r = ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null).m11112r();
        C12238m.checkNotNullExpressionValue(observableM11112r, "viewModel\n        .obser…  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe(observableM11112r, (Class<?>) WidgetGuildBoostTransfer.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C95221(this));
    }
}
