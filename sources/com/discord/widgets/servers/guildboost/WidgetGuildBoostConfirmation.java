package com.discord.widgets.servers.guildboost;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
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
import com.discord.app.AppActivity;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetServerBoostConfirmationBinding;
import com.discord.utilities.dimmer.DimmerView;
import com.discord.utilities.resources.StringResourceUtilsKt;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.google.android.material.button.MaterialButton;
import d0.g;
import d0.z.d.a0;
import d0.z.d.m;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;
import rx.Observable;

/* JADX INFO: compiled from: WidgetGuildBoostConfirmation.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildBoostConfirmation extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetGuildBoostConfirmation.class, "binding", "getBinding()Lcom/discord/databinding/WidgetServerBoostConfirmationBinding;", 0)};
    public static final WidgetGuildBoostConfirmation$Companion Companion = new WidgetGuildBoostConfirmation$Companion(null);
    private static final String INTENT_EXTRA_GUILD_ID = "GUILD_ID";
    private static final String INTENT_EXTRA_SLOT_ID = "SLOT_ID";

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* JADX INFO: renamed from: guildId$delegate, reason: from kotlin metadata */
    private final Lazy guildId;

    /* JADX INFO: renamed from: slotId$delegate, reason: from kotlin metadata */
    private final Lazy slotId;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    public WidgetGuildBoostConfirmation() {
        super(R$layout.widget_server_boost_confirmation);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetGuildBoostConfirmation$binding$2.INSTANCE, null, 2, null);
        WidgetGuildBoostConfirmation$viewModel$2 widgetGuildBoostConfirmation$viewModel$2 = new WidgetGuildBoostConfirmation$viewModel$2(this);
        g0 g0Var = new g0(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, a0.getOrCreateKotlinClass(GuildBoostInProgressViewModel.class), new WidgetGuildBoostConfirmation$appViewModels$$inlined$viewModels$1(g0Var), new i0(widgetGuildBoostConfirmation$viewModel$2));
        this.guildId = g.lazy(new WidgetGuildBoostConfirmation$guildId$2(this));
        this.slotId = g.lazy(new WidgetGuildBoostConfirmation$slotId$2(this));
    }

    public static final /* synthetic */ void access$configureUI(WidgetGuildBoostConfirmation widgetGuildBoostConfirmation, GuildBoostInProgressViewModel$ViewState guildBoostInProgressViewModel$ViewState) {
        widgetGuildBoostConfirmation.configureUI(guildBoostInProgressViewModel$ViewState);
    }

    public static final /* synthetic */ long access$getGuildId$p(WidgetGuildBoostConfirmation widgetGuildBoostConfirmation) {
        return widgetGuildBoostConfirmation.getGuildId();
    }

    public static final /* synthetic */ long access$getSlotId$p(WidgetGuildBoostConfirmation widgetGuildBoostConfirmation) {
        return widgetGuildBoostConfirmation.getSlotId();
    }

    public static final /* synthetic */ GuildBoostInProgressViewModel access$getViewModel$p(WidgetGuildBoostConfirmation widgetGuildBoostConfirmation) {
        return widgetGuildBoostConfirmation.getViewModel();
    }

    private final void configureToolbar(String guildName) {
        setActionBarTitle(2131894037);
        setActionBarSubtitle(guildName);
    }

    private final void configureUI(GuildBoostInProgressViewModel$ViewState viewModelViewState) {
        if (viewModelViewState instanceof GuildBoostInProgressViewModel$ViewState$Uninitialized) {
            return;
        }
        Objects.requireNonNull(viewModelViewState, "null cannot be cast to non-null type com.discord.widgets.servers.guildboost.GuildBoostInProgressViewModel.ViewState.Loaded");
        GuildBoostInProgressViewModel$ViewState$Loaded guildBoostInProgressViewModel$ViewState$Loaded = (GuildBoostInProgressViewModel$ViewState$Loaded) viewModelViewState;
        if (guildBoostInProgressViewModel$ViewState$Loaded.getGuild() == null) {
            requireActivity().finish();
            return;
        }
        configureToolbar(guildBoostInProgressViewModel$ViewState$Loaded.getGuild().getName());
        getBinding().f2534b.b(guildBoostInProgressViewModel$ViewState$Loaded.getGuild(), 1);
        int iOrdinal = guildBoostInProgressViewModel$ViewState$Loaded.getGuildBoostState().ordinal();
        if (iOrdinal == 0) {
            DimmerView.setDimmed$default(getBinding().f, false, false, 2, null);
            TextView textView = getBinding().d;
            m.checkNotNullExpressionValue(textView, "binding.boostConfirmationError");
            textView.setVisibility(4);
            return;
        }
        if (iOrdinal == 1) {
            DimmerView.setDimmed$default(getBinding().f, true, false, 2, null);
            TextView textView2 = getBinding().d;
            m.checkNotNullExpressionValue(textView2, "binding.boostConfirmationError");
            textView2.setVisibility(4);
            return;
        }
        if (iOrdinal != 2) {
            if (iOrdinal != 3) {
                return;
            }
            DimmerView.setDimmed$default(getBinding().f, false, false, 2, null);
            TextView textView3 = getBinding().d;
            m.checkNotNullExpressionValue(textView3, "binding.boostConfirmationError");
            textView3.setVisibility(0);
            return;
        }
        if (guildBoostInProgressViewModel$ViewState$Loaded.getCanShowConfirmationDialog()) {
            c$a c_a = c.l;
            FragmentManager parentFragmentManager = getParentFragmentManager();
            m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
            c_a.a(parentFragmentManager, requireContext(), guildBoostInProgressViewModel$ViewState$Loaded.getGuild().getName(), guildBoostInProgressViewModel$ViewState$Loaded.getSubscriptionCount() + 1, false, new WidgetGuildBoostConfirmation$configureUI$1(this));
        }
    }

    public static final void create(Context context, long j, long j2) {
        Companion.create(context, j, j2);
    }

    private final WidgetServerBoostConfirmationBinding getBinding() {
        return (WidgetServerBoostConfirmationBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final long getGuildId() {
        return ((Number) this.guildId.getValue()).longValue();
    }

    private final long getSlotId() {
        return ((Number) this.slotId.getValue()).longValue();
    }

    private final GuildBoostInProgressViewModel getViewModel() {
        return (GuildBoostInProgressViewModel) this.viewModel.getValue();
    }

    @Override // com.discord.app.AppFragment, androidx.fragment.app.Fragment
    public void onResume() {
        AppActivity appActivity;
        super.onResume();
        if ((getGuildId() == 0 || getGuildId() == -1) && (appActivity = getAppActivity()) != null) {
            appActivity.finish();
        }
        Observable observableR = ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null).r();
        m.checkNotNullExpressionValue(observableR, "viewModel\n        .obser…  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe$default(observableR, WidgetGuildBoostConfirmation.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetGuildBoostConfirmation$onResume$1(this), 62, (Object) null);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        AppFragment.setActionBarDisplayHomeAsUpEnabled$default(this, false, 1, null);
        getBinding().e.setOnClickListener(new WidgetGuildBoostConfirmation$onViewBound$1(this));
        MaterialButton materialButton = getBinding().e;
        m.checkNotNullExpressionValue(materialButton, "binding.boostConfirmationSelect");
        materialButton.setText(b.k(this, 2131894058, new Object[]{StringResourceUtilsKt.getI18nPluralString(requireContext(), R$plurals.premium_guild_subscribe_confirm_confirmation_slotCount, 1, 1)}, null, 4));
        CharSequence i18nPluralString = StringResourceUtilsKt.getI18nPluralString(requireContext(), R$plurals.premium_guild_subscribe_confirm_cooldown_warning_days, 7, 7);
        CharSequence i18nPluralString2 = StringResourceUtilsKt.getI18nPluralString(requireContext(), R$plurals.premium_guild_subscribe_confirm_cooldown_warning_slotCount, 1, 1);
        TextView textView = getBinding().c;
        m.checkNotNullExpressionValue(textView, "binding.boostConfirmationCooldownWarning");
        textView.setText(b.k(this, 2131894060, new Object[]{i18nPluralString2, i18nPluralString}, null, 4));
    }
}
