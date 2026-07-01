package com.discord.widgets.servers.guildboost;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import b.a.a.a.c;
import b.a.a.a.c$a;
import b.a.d.g0;
import b.a.d.i0;
import b.a.k.b;
import b.d.b.a.a;
import com.discord.R$layout;
import com.discord.R$plurals;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetGuildBoostTransferBinding;
import com.discord.models.domain.ModelGuildBoostSlot;
import com.discord.utilities.dimmer.DimmerView;
import com.discord.utilities.resources.StringResourceUtilsKt;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.google.android.material.button.MaterialButton;
import d0.z.d.a0;
import d0.z.d.m;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;
import rx.Observable;

/* JADX INFO: compiled from: WidgetGuildBoostTransfer.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildBoostTransfer extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetGuildBoostTransfer.class, "binding", "getBinding()Lcom/discord/databinding/WidgetGuildBoostTransferBinding;", 0)};
    public static final WidgetGuildBoostTransfer$Companion Companion = new WidgetGuildBoostTransfer$Companion(null);
    private static final String INTENT_EXTRA_PREVIOUS_GUILD_ID = "PREVIOUS_GUILD_ID";
    private static final String INTENT_EXTRA_SLOT_ID = "SLOT_ID";
    private static final String INTENT_EXTRA_SUBSCRIPTION_ID = "SUBSCRIPTION_ID";
    private static final String INTENT_EXTRA_TARGET_GUILD_ID = "TARGET_GUILD_ID";

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    public WidgetGuildBoostTransfer() {
        super(R$layout.widget_guild_boost_transfer);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetGuildBoostTransfer$binding$2.INSTANCE, null, 2, null);
        WidgetGuildBoostTransfer$viewModel$2 widgetGuildBoostTransfer$viewModel$2 = new WidgetGuildBoostTransfer$viewModel$2(this);
        g0 g0Var = new g0(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, a0.getOrCreateKotlinClass(GuildBoostTransferInProgressViewModel.class), new WidgetGuildBoostTransfer$appViewModels$$inlined$viewModels$1(g0Var), new i0(widgetGuildBoostTransfer$viewModel$2));
    }

    public static final /* synthetic */ void access$configureUI(WidgetGuildBoostTransfer widgetGuildBoostTransfer, GuildBoostTransferInProgressViewModel$ViewState guildBoostTransferInProgressViewModel$ViewState) {
        widgetGuildBoostTransfer.configureUI(guildBoostTransferInProgressViewModel$ViewState);
    }

    public static final /* synthetic */ GuildBoostTransferInProgressViewModel access$getViewModel$p(WidgetGuildBoostTransfer widgetGuildBoostTransfer) {
        return widgetGuildBoostTransfer.getViewModel();
    }

    private final void configureUI(GuildBoostTransferInProgressViewModel$ViewState state) {
        if (state instanceof GuildBoostTransferInProgressViewModel$ViewState$ErrorLoading) {
            FragmentActivity activity = getActivity();
            if (activity != null) {
                activity.finish();
                return;
            }
            return;
        }
        if (state instanceof GuildBoostTransferInProgressViewModel$ViewState$Loading) {
            DimmerView.setDimmed$default(getBinding().f2408b, true, false, 2, null);
            TextView textView = getBinding().d;
            m.checkNotNullExpressionValue(textView, "binding.guildBoostTransferError");
            textView.setVisibility(4);
            return;
        }
        if (state instanceof GuildBoostTransferInProgressViewModel$ViewState$ErrorTransfer) {
            DimmerView.setDimmed$default(getBinding().f2408b, false, false, 2, null);
            TextView textView2 = getBinding().d;
            m.checkNotNullExpressionValue(textView2, "binding.guildBoostTransferError");
            textView2.setVisibility(0);
            return;
        }
        if (state instanceof GuildBoostTransferInProgressViewModel$ViewState$PreTransfer) {
            GuildBoostTransferInProgressViewModel$ViewState$PreTransfer guildBoostTransferInProgressViewModel$ViewState$PreTransfer = (GuildBoostTransferInProgressViewModel$ViewState$PreTransfer) state;
            DimmerView.setDimmed$default(getBinding().f2408b, guildBoostTransferInProgressViewModel$ViewState$PreTransfer.isTransferInProgress(), false, 2, null);
            TextView textView3 = getBinding().d;
            m.checkNotNullExpressionValue(textView3, "binding.guildBoostTransferError");
            textView3.setVisibility(4);
            getBinding().e.b(guildBoostTransferInProgressViewModel$ViewState$PreTransfer.getPreviousGuild(), -1);
            getBinding().h.b(guildBoostTransferInProgressViewModel$ViewState$PreTransfer.getTargetGuild(), 1);
            return;
        }
        if (state instanceof GuildBoostTransferInProgressViewModel$ViewState$PostTransfer) {
            c$a c_a = c.l;
            FragmentManager parentFragmentManager = getParentFragmentManager();
            m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
            GuildBoostTransferInProgressViewModel$ViewState$PostTransfer guildBoostTransferInProgressViewModel$ViewState$PostTransfer = (GuildBoostTransferInProgressViewModel$ViewState$PostTransfer) state;
            c_a.a(parentFragmentManager, requireContext(), guildBoostTransferInProgressViewModel$ViewState$PostTransfer.getTargetGuild().getName(), guildBoostTransferInProgressViewModel$ViewState$PostTransfer.getTargetGuildSubscriptionCount() + 1, true, new WidgetGuildBoostTransfer$configureUI$1(this));
        }
    }

    public static final void create(Context context, long j, long j2, ModelGuildBoostSlot modelGuildBoostSlot) {
        Companion.create(context, j, j2, modelGuildBoostSlot);
    }

    private final WidgetGuildBoostTransferBinding getBinding() {
        return (WidgetGuildBoostTransferBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final GuildBoostTransferInProgressViewModel getViewModel() {
        return (GuildBoostTransferInProgressViewModel) this.viewModel.getValue();
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        AppFragment.setActionBarDisplayHomeAsUpEnabled$default(this, false, 1, null);
        TextView textView = getBinding().c;
        m.checkNotNullExpressionValue(textView, "binding.guildBoostTransferConfirmationBlurb");
        textView.setText(b.k(this, 2131894061, new Object[]{StringResourceUtilsKt.getI18nPluralString(requireContext(), R$plurals.premium_guild_subscribe_confirm_transfer_blurb_slotCount, 1, 1), StringResourceUtilsKt.getI18nPluralString(requireContext(), R$plurals.premium_guild_subscribe_confirm_transfer_blurb_guildCount, 1, 1)}, null, 4));
        TextView textView2 = getBinding().f;
        m.checkNotNullExpressionValue(textView2, "binding.guildBoostTransferPreviousGuildHeader");
        textView2.setText(b.k(this, 2131894062, new Object[]{StringResourceUtilsKt.getI18nPluralString(requireContext(), R$plurals.premium_guild_subscribe_confirm_transfer_from_guild_guildCount, 1, 1)}, null, 4));
        TextView textView3 = getBinding().i;
        m.checkNotNullExpressionValue(textView3, "binding.guildBoostTransferTargetGuildHeader");
        textView3.setText(b.k(this, 2131894064, new Object[]{StringResourceUtilsKt.getI18nPluralString(requireContext(), R$plurals.premium_guild_subscribe_confirm_transfer_to_guild_slotCount, 1, 1)}, null, 4));
        getBinding().g.setOnClickListener(new WidgetGuildBoostTransfer$onViewBound$1(this));
        MaterialButton materialButton = getBinding().g;
        m.checkNotNullExpressionValue(materialButton, "binding.guildBoostTransferSelect");
        materialButton.setText(b.k(this, 2131894069, new Object[]{StringResourceUtilsKt.getI18nPluralString(requireContext(), R$plurals.premium_guild_subscribe_transfer_confirm_confirmation_slotCount, 1, 1)}, null, 4));
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        Observable observableR = ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null).r();
        m.checkNotNullExpressionValue(observableR, "viewModel\n        .obser…  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe$default(observableR, WidgetGuildBoostTransfer.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetGuildBoostTransfer$onViewBoundOrOnResume$1(this), 62, (Object) null);
    }
}
