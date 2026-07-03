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
import com.discord.app.AppActivity;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetServerBoostConfirmationBinding;
import com.discord.utilities.dimmer.DimmerView;
import com.discord.utilities.error.Error;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.resources.StringResourceUtilsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.widgets.servers.WidgetServerSettingsChannels;
import com.discord.widgets.servers.guildboost.GuildBoostInProgressViewModel;
import com.google.android.material.button.MaterialButton;
import java.util.Objects;
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
import p507d0.C12083g;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12216a0;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;
import p658rx.Observable;
import p658rx.Subscription;

/* JADX INFO: compiled from: WidgetGuildBoostConfirmation.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildBoostConfirmation extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {C1643a.m846d0(WidgetGuildBoostConfirmation.class, "binding", "getBinding()Lcom/discord/databinding/WidgetServerBoostConfirmationBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
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

    /* JADX INFO: compiled from: WidgetGuildBoostConfirmation.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void create(Context context, long guildId, long slotId) {
            C12238m.checkNotNullParameter(context, "context");
            Intent intentPutExtra = new Intent().putExtra(WidgetGuildBoostConfirmation.INTENT_EXTRA_GUILD_ID, guildId).putExtra(WidgetGuildBoostConfirmation.INTENT_EXTRA_SLOT_ID, slotId);
            C12238m.checkNotNullExpressionValue(intentPutExtra, "Intent()\n          .putE…NT_EXTRA_SLOT_ID, slotId)");
            C0870j.m156d(context, WidgetGuildBoostConfirmation.class, intentPutExtra);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            GuildBoostInProgressViewModel.GuildBoostState.values();
            int[] iArr = new int[4];
            $EnumSwitchMapping$0 = iArr;
            iArr[GuildBoostInProgressViewModel.GuildBoostState.NOT_IN_PROGRESS.ordinal()] = 1;
            iArr[GuildBoostInProgressViewModel.GuildBoostState.CALL_IN_PROGRESS.ordinal()] = 2;
            iArr[GuildBoostInProgressViewModel.GuildBoostState.ERROR.ordinal()] = 3;
            iArr[GuildBoostInProgressViewModel.GuildBoostState.COMPLETED.ordinal()] = 4;
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.servers.guildboost.WidgetGuildBoostConfirmation$configureUI$1 */
    /* JADX INFO: compiled from: WidgetGuildBoostConfirmation.kt */
    public static final class C95171 extends AbstractC12240o implements Function0<Unit> {
        public C95171() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            FragmentActivity fragmentActivityM95e = WidgetGuildBoostConfirmation.this.m95e();
            if (fragmentActivityM95e != null) {
                fragmentActivityM95e.finish();
            }
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.servers.guildboost.WidgetGuildBoostConfirmation$onResume$1 */
    /* JADX INFO: compiled from: WidgetGuildBoostConfirmation.kt */
    public static final /* synthetic */ class C95181 extends C12236k implements Function1<GuildBoostInProgressViewModel.ViewState, Unit> {
        public C95181(WidgetGuildBoostConfirmation widgetGuildBoostConfirmation) {
            super(1, widgetGuildBoostConfirmation, WidgetGuildBoostConfirmation.class, "configureUI", "configureUI(Lcom/discord/widgets/servers/guildboost/GuildBoostInProgressViewModel$ViewState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(GuildBoostInProgressViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(GuildBoostInProgressViewModel.ViewState viewState) {
            C12238m.checkNotNullParameter(viewState, "p1");
            ((WidgetGuildBoostConfirmation) this.receiver).configureUI(viewState);
        }
    }

    public WidgetGuildBoostConfirmation() {
        super(C5419R.layout.widget_server_boost_confirmation);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetGuildBoostConfirmation$binding$2.INSTANCE, null, 2, null);
        WidgetGuildBoostConfirmation$viewModel$2 widgetGuildBoostConfirmation$viewModel$2 = new WidgetGuildBoostConfirmation$viewModel$2(this);
        C0865g0 c0865g0 = new C0865g0(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, C12216a0.getOrCreateKotlinClass(GuildBoostInProgressViewModel.class), new WidgetGuildBoostConfirmation$appViewModels$$inlined$viewModels$1(c0865g0), new C0869i0(widgetGuildBoostConfirmation$viewModel$2));
        this.guildId = C12083g.lazy(new WidgetGuildBoostConfirmation$guildId$2(this));
        this.slotId = C12083g.lazy(new WidgetGuildBoostConfirmation$slotId$2(this));
    }

    private final void configureToolbar(String guildName) {
        setActionBarTitle(C5419R.string.premium_guild_perks_modal_header);
        setActionBarSubtitle(guildName);
    }

    private final void configureUI(GuildBoostInProgressViewModel.ViewState viewModelViewState) {
        if (viewModelViewState instanceof GuildBoostInProgressViewModel.ViewState.Uninitialized) {
            return;
        }
        Objects.requireNonNull(viewModelViewState, "null cannot be cast to non-null type com.discord.widgets.servers.guildboost.GuildBoostInProgressViewModel.ViewState.Loaded");
        GuildBoostInProgressViewModel.ViewState.Loaded loaded = (GuildBoostInProgressViewModel.ViewState.Loaded) viewModelViewState;
        if (loaded.getGuild() == null) {
            requireActivity().finish();
            return;
        }
        configureToolbar(loaded.getGuild().getName());
        getBinding().f17462b.m8592b(loaded.getGuild(), 1);
        int iOrdinal = loaded.getGuildBoostState().ordinal();
        if (iOrdinal == 0) {
            DimmerView.setDimmed$default(getBinding().f17466f, false, false, 2, null);
            TextView textView = getBinding().f17464d;
            C12238m.checkNotNullExpressionValue(textView, "binding.boostConfirmationError");
            textView.setVisibility(4);
            return;
        }
        if (iOrdinal == 1) {
            DimmerView.setDimmed$default(getBinding().f17466f, true, false, 2, null);
            TextView textView2 = getBinding().f17464d;
            C12238m.checkNotNullExpressionValue(textView2, "binding.boostConfirmationError");
            textView2.setVisibility(4);
            return;
        }
        if (iOrdinal != 2) {
            if (iOrdinal != 3) {
                return;
            }
            DimmerView.setDimmed$default(getBinding().f17466f, false, false, 2, null);
            TextView textView3 = getBinding().f17464d;
            C12238m.checkNotNullExpressionValue(textView3, "binding.boostConfirmationError");
            textView3.setVisibility(0);
            return;
        }
        if (loaded.getCanShowConfirmationDialog()) {
            C0793c.Companion aVar = C0793c.INSTANCE;
            FragmentManager parentFragmentManager = getParentFragmentManager();
            C12238m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
            aVar.m101a(parentFragmentManager, requireContext(), loaded.getGuild().getName(), loaded.getSubscriptionCount() + 1, false, new C95171());
        }
    }

    public static final void create(Context context, long j, long j2) {
        INSTANCE.create(context, j, j2);
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
        Observable observableM11112r = ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null).m11112r();
        C12238m.checkNotNullExpressionValue(observableM11112r, "viewModel\n        .obser…  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe(observableM11112r, (Class<?>) WidgetGuildBoostConfirmation.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C95181(this));
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        C12238m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        AppFragment.setActionBarDisplayHomeAsUpEnabled$default(this, false, 1, null);
        getBinding().f17465e.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.servers.guildboost.WidgetGuildBoostConfirmation.onViewBound.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                WidgetGuildBoostConfirmation.this.getViewModel().subscribeToGuildBoost(WidgetGuildBoostConfirmation.this.getGuildId(), WidgetGuildBoostConfirmation.this.getSlotId());
            }
        });
        MaterialButton materialButton = getBinding().f17465e;
        C12238m.checkNotNullExpressionValue(materialButton, "binding.boostConfirmationSelect");
        materialButton.setText(C1107b.m213e(this, C5419R.string.premium_guild_subscribe_confirm_confirmation, new Object[]{StringResourceUtilsKt.getI18nPluralString(requireContext(), C5419R.plurals.premium_guild_subscribe_confirm_confirmation_slotCount, 1, 1)}, (4 & 4) != 0 ? C1107b.a.f1490j : null));
        CharSequence i18nPluralString = StringResourceUtilsKt.getI18nPluralString(requireContext(), C5419R.plurals.premium_guild_subscribe_confirm_cooldown_warning_days, 7, 7);
        CharSequence i18nPluralString2 = StringResourceUtilsKt.getI18nPluralString(requireContext(), C5419R.plurals.premium_guild_subscribe_confirm_cooldown_warning_slotCount, 1, 1);
        TextView textView = getBinding().f17463c;
        C12238m.checkNotNullExpressionValue(textView, "binding.boostConfirmationCooldownWarning");
        textView.setText(C1107b.m213e(this, C5419R.string.premium_guild_subscribe_confirm_cooldown_warning, new Object[]{i18nPluralString2, i18nPluralString}, (4 & 4) != 0 ? C1107b.a.f1490j : null));
    }
}
