package com.discord.widgets.guilds.invite;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import b.a.d.g0;
import b.a.d.i0;
import b.a.k.b;
import b.d.b.a.a;
import com.discord.BuildConfig;
import com.discord.R$layout;
import com.discord.R$plurals;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetGuildInviteShareEmptySuggestionsBinding;
import com.discord.models.domain.ModelInvite;
import com.discord.models.domain.ModelInvite$Settings;
import com.discord.utilities.drawable.DrawableCompat;
import com.discord.utilities.resources.StringResourceUtilsKt;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import d0.g;
import d0.z.d.a0;
import d0.z.d.m;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;
import rx.Observable;

/* JADX INFO: compiled from: WidgetGuildInviteShareEmptySuggestions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildInviteShareEmptySuggestions extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetGuildInviteShareEmptySuggestions.class, "binding", "getBinding()Lcom/discord/databinding/WidgetGuildInviteShareEmptySuggestionsBinding;", 0)};

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private BottomSheetBehavior<ViewInviteSettingsSheet> bottomSheetBehavior;

    /* JADX INFO: renamed from: guildId$delegate, reason: from kotlin metadata */
    private final Lazy guildId;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    public WidgetGuildInviteShareEmptySuggestions() {
        super(R$layout.widget_guild_invite_share_empty_suggestions);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetGuildInviteShareEmptySuggestions$binding$2.INSTANCE, null, 2, null);
        WidgetGuildInviteShareEmptySuggestions$viewModel$2 widgetGuildInviteShareEmptySuggestions$viewModel$2 = new WidgetGuildInviteShareEmptySuggestions$viewModel$2(this);
        g0 g0Var = new g0(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, a0.getOrCreateKotlinClass(WidgetGuildInviteShareViewModel.class), new WidgetGuildInviteShareEmptySuggestions$appViewModels$$inlined$viewModels$1(g0Var), new i0(widgetGuildInviteShareEmptySuggestions$viewModel$2));
        this.guildId = g.lazy(new WidgetGuildInviteShareEmptySuggestions$guildId$2(this));
    }

    public static final /* synthetic */ WidgetGuildInviteShareEmptySuggestionsBinding access$getBinding$p(WidgetGuildInviteShareEmptySuggestions widgetGuildInviteShareEmptySuggestions) {
        return widgetGuildInviteShareEmptySuggestions.getBinding();
    }

    public static final /* synthetic */ BottomSheetBehavior access$getBottomSheetBehavior$p(WidgetGuildInviteShareEmptySuggestions widgetGuildInviteShareEmptySuggestions) {
        BottomSheetBehavior<ViewInviteSettingsSheet> bottomSheetBehavior = widgetGuildInviteShareEmptySuggestions.bottomSheetBehavior;
        if (bottomSheetBehavior == null) {
            m.throwUninitializedPropertyAccessException("bottomSheetBehavior");
        }
        return bottomSheetBehavior;
    }

    public static final /* synthetic */ WidgetGuildInviteShareViewModel access$getViewModel$p(WidgetGuildInviteShareEmptySuggestions widgetGuildInviteShareEmptySuggestions) {
        return widgetGuildInviteShareEmptySuggestions.getViewModel();
    }

    public static final /* synthetic */ void access$setBottomSheetBehavior$p(WidgetGuildInviteShareEmptySuggestions widgetGuildInviteShareEmptySuggestions, BottomSheetBehavior bottomSheetBehavior) {
        widgetGuildInviteShareEmptySuggestions.bottomSheetBehavior = bottomSheetBehavior;
    }

    public static final /* synthetic */ void access$updateUi(WidgetGuildInviteShareEmptySuggestions widgetGuildInviteShareEmptySuggestions, WidgetGuildInviteShareViewModel$ViewState$Loaded widgetGuildInviteShareViewModel$ViewState$Loaded) {
        widgetGuildInviteShareEmptySuggestions.updateUi(widgetGuildInviteShareViewModel$ViewState$Loaded);
    }

    private final WidgetGuildInviteShareEmptySuggestionsBinding getBinding() {
        return (WidgetGuildInviteShareEmptySuggestionsBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final CharSequence getHoursExpirationString(int hours, CharSequence maxUses) {
        Resources resources = getResources();
        m.checkNotNullExpressionValue(resources, "resources");
        CharSequence quantityString = StringResourceUtilsKt.getQuantityString(resources, requireContext(), R$plurals.duration_hours_hours, hours, Integer.valueOf(hours));
        Resources resources2 = getResources();
        m.checkNotNullExpressionValue(resources2, "resources");
        return b.i(resources2, 2131892324, new Object[]{quantityString, maxUses}, null, 4);
    }

    private final String getInviteLink(ModelInvite modelInvite) {
        return modelInvite == null ? BuildConfig.HOST_INVITE : modelInvite.toLink(getResources(), BuildConfig.HOST_INVITE);
    }

    private final WidgetGuildInviteShareViewModel getViewModel() {
        return (WidgetGuildInviteShareViewModel) this.viewModel.getValue();
    }

    private final void initBottomSheet() {
        getBinding().g.setOnGenerateLinkListener(new WidgetGuildInviteShareEmptySuggestions$initBottomSheet$1(this));
        getBinding().g.setViewModel(getViewModel());
    }

    private final void initBottomSheetBehavior(BottomSheetBehavior<ViewInviteSettingsSheet> bottomSheetBehavior) {
        bottomSheetBehavior.setState(5);
        bottomSheetBehavior.addBottomSheetCallback(new WidgetGuildInviteShareEmptySuggestions$initBottomSheetBehavior$1(this));
    }

    private final void updateUi(WidgetGuildInviteShareViewModel$ViewState$Loaded viewState) {
        CharSequence quantityString;
        WidgetInviteModel widgetInviteModel = viewState.getWidgetInviteModel();
        getBinding().g.configureUi(widgetInviteModel);
        ModelInvite invite = widgetInviteModel.getInvite();
        TextView textView = getBinding().c;
        m.checkNotNullExpressionValue(textView, "binding.guildInviteEmptySuggestionsInviteLink");
        textView.setText(getInviteLink(invite));
        getBinding().c.setOnClickListener(new WidgetGuildInviteShareEmptySuggestions$updateUi$1(this, invite));
        getBinding().d.setOnClickListener(new WidgetGuildInviteShareEmptySuggestions$updateUi$2(this, invite));
        getBinding().e.setOnClickListener(new WidgetGuildInviteShareEmptySuggestions$updateUi$3(this));
        ModelInvite$Settings settings = widgetInviteModel.getSettings();
        if (settings != null) {
            if (settings.getMaxUses() == 0) {
                quantityString = getResources().getString(2131892769);
                m.checkNotNullExpressionValue(quantityString, "resources.getString(R.st…scription_unlimited_uses)");
            } else {
                Resources resources = getResources();
                m.checkNotNullExpressionValue(resources, "resources");
                quantityString = StringResourceUtilsKt.getQuantityString(resources, requireContext(), R$plurals.max_uses_description_mobile_maxUses, settings.getMaxUses(), Integer.valueOf(settings.getMaxUses()));
            }
            int maxAge = widgetInviteModel.getSettings().getMaxAge();
            if (maxAge == 0) {
                String str = getResources().getString(2131892764) + ", " + quantityString;
                m.checkNotNullExpressionValue(str, "StringBuilder()\n        …              .toString()");
                TextView textView2 = getBinding().f;
                m.checkNotNullExpressionValue(textView2, "binding.guildInviteEmpty…SettingsInviteLinkSubtext");
                textView2.setText(str);
                return;
            }
            if (maxAge == 1800) {
                Resources resources2 = getResources();
                m.checkNotNullExpressionValue(resources2, "resources");
                CharSequence quantityString2 = StringResourceUtilsKt.getQuantityString(resources2, requireContext(), R$plurals.duration_minutes_minutes, 30, 30);
                TextView textView3 = getBinding().f;
                m.checkNotNullExpressionValue(textView3, "binding.guildInviteEmpty…SettingsInviteLinkSubtext");
                Resources resources3 = getResources();
                m.checkNotNullExpressionValue(resources3, "resources");
                textView3.setText(b.i(resources3, 2131892324, new Object[]{quantityString2, quantityString}, null, 4));
                return;
            }
            if (maxAge == 3600) {
                TextView textView4 = getBinding().f;
                m.checkNotNullExpressionValue(textView4, "binding.guildInviteEmpty…SettingsInviteLinkSubtext");
                textView4.setText(getHoursExpirationString(1, quantityString));
                return;
            }
            if (maxAge == 21600) {
                TextView textView5 = getBinding().f;
                m.checkNotNullExpressionValue(textView5, "binding.guildInviteEmpty…SettingsInviteLinkSubtext");
                textView5.setText(getHoursExpirationString(6, quantityString));
                return;
            }
            if (maxAge == 43200) {
                TextView textView6 = getBinding().f;
                m.checkNotNullExpressionValue(textView6, "binding.guildInviteEmpty…SettingsInviteLinkSubtext");
                textView6.setText(getHoursExpirationString(12, quantityString));
                return;
            }
            if (maxAge == 86400) {
                Resources resources4 = getResources();
                m.checkNotNullExpressionValue(resources4, "resources");
                CharSequence quantityString3 = StringResourceUtilsKt.getQuantityString(resources4, requireContext(), R$plurals.duration_days_days, 1, 1);
                TextView textView7 = getBinding().f;
                m.checkNotNullExpressionValue(textView7, "binding.guildInviteEmpty…SettingsInviteLinkSubtext");
                Resources resources5 = getResources();
                m.checkNotNullExpressionValue(resources5, "resources");
                textView7.setText(b.i(resources5, 2131892324, new Object[]{quantityString3, quantityString}, null, 4));
                return;
            }
            if (maxAge != 604800) {
                return;
            }
            Resources resources6 = getResources();
            m.checkNotNullExpressionValue(resources6, "resources");
            CharSequence quantityString4 = StringResourceUtilsKt.getQuantityString(resources6, requireContext(), R$plurals.duration_days_days, 7, 7);
            TextView textView8 = getBinding().f;
            m.checkNotNullExpressionValue(textView8, "binding.guildInviteEmpty…SettingsInviteLinkSubtext");
            Resources resources7 = getResources();
            m.checkNotNullExpressionValue(resources7, "resources");
            textView8.setText(b.i(resources7, 2131892324, new Object[]{quantityString4, quantityString}, null, 4));
        }
    }

    public final long getGuildId() {
        return ((Number) this.guildId.getValue()).longValue();
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        if (getMostRecentIntent().getLongExtra("com.discord.intent.extra.EXTRA_GUILD_ID", 0L) <= 0) {
            requireActivity().finish();
            return;
        }
        long longExtra = getMostRecentIntent().getLongExtra("com.discord.intent.extra.EXTRA_CHANNEL_ID", 0L);
        if (longExtra != 0) {
            getViewModel().selectChannel(longExtra);
        }
        boolean booleanExtra = getMostRecentIntent().getBooleanExtra(WidgetGuildInviteShare.INTENT_IS_NUX_FLOW, false);
        setActionBarDisplayHomeAsUpEnabled(true, booleanExtra ? Integer.valueOf(DrawableCompat.getThemedDrawableRes$default(requireContext(), 2130969481, 0, 2, (Object) null)) : null, booleanExtra ? 2131887680 : null);
        AppFragment.setOnBackPressed$default(this, new WidgetGuildInviteShareEmptySuggestions$onViewBound$1(this, booleanExtra), 0, 2, null);
        BottomSheetBehavior<ViewInviteSettingsSheet> bottomSheetBehaviorFrom = BottomSheetBehavior.from(getBinding().g);
        m.checkNotNullExpressionValue(bottomSheetBehaviorFrom, "BottomSheetBehavior.from…nviteSettingsBottomSheet)");
        this.bottomSheetBehavior = bottomSheetBehaviorFrom;
        if (bottomSheetBehaviorFrom == null) {
            m.throwUninitializedPropertyAccessException("bottomSheetBehavior");
        }
        initBottomSheetBehavior(bottomSheetBehaviorFrom);
        initBottomSheet();
        getBinding().f2420b.setOnClickListener(new WidgetGuildInviteShareEmptySuggestions$onViewBound$2(this));
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        Observable<WidgetGuildInviteShareViewModel$ViewState> observableK = getViewModel().observeViewState().K();
        m.checkNotNullExpressionValue(observableK, "viewModel.observeViewSta…  .onBackpressureBuffer()");
        Observable<R> observableG = observableK.y(WidgetGuildInviteShareEmptySuggestions$onViewBoundOrOnResume$$inlined$filterIs$1.INSTANCE).G(WidgetGuildInviteShareEmptySuggestions$onViewBoundOrOnResume$$inlined$filterIs$2.INSTANCE);
        m.checkNotNullExpressionValue(observableG, "filter { it is T }.map { it as T }");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(observableG, this, null, 2, null), WidgetGuildInviteShareEmptySuggestions.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetGuildInviteShareEmptySuggestions$onViewBoundOrOnResume$1(this), 62, (Object) null);
    }
}
