package com.discord.widgets.guilds.invite;

import android.content.res.Resources;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import com.discord.BuildConfig;
import com.discord.C5419R;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetGuildInviteShareEmptySuggestionsBinding;
import com.discord.models.domain.ModelInvite;
import com.discord.utilities.drawable.DrawableCompat;
import com.discord.utilities.error.Error;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.resources.StringResourceUtilsKt;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.widgets.guilds.invite.WidgetGuildInviteShareViewModel;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;
import p007b.p008a.p018d.C0865g0;
import p007b.p008a.p018d.C0869i0;
import p007b.p008a.p018d.C0870j;
import p007b.p008a.p027k.C1107b;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.C12083g;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12216a0;
import p507d0.p592z.p594d.C12238m;
import p637j0.p641k.InterfaceC12589b;
import p658rx.Observable;
import p658rx.Subscription;
import p658rx.functions.Func0;

/* JADX INFO: compiled from: WidgetGuildInviteShareEmptySuggestions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildInviteShareEmptySuggestions extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {C1643a.m846d0(WidgetGuildInviteShareEmptySuggestions.class, "binding", "getBinding()Lcom/discord/databinding/WidgetGuildInviteShareEmptySuggestionsBinding;", 0)};

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private BottomSheetBehavior<ViewInviteSettingsSheet> bottomSheetBehavior;

    /* JADX INFO: renamed from: guildId$delegate, reason: from kotlin metadata */
    private final Lazy guildId;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* JADX INFO: renamed from: com.discord.widgets.guilds.invite.WidgetGuildInviteShareEmptySuggestions$initBottomSheet$1 */
    /* JADX INFO: compiled from: WidgetGuildInviteShareEmptySuggestions.kt */
    public static final class C86851 extends AbstractC12240o implements Function0<Unit> {
        public C86851() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            WidgetGuildInviteShareEmptySuggestions.access$getBottomSheetBehavior$p(WidgetGuildInviteShareEmptySuggestions.this).setState(5);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.guilds.invite.WidgetGuildInviteShareEmptySuggestions$onViewBoundOrOnResume$1 */
    /* JADX INFO: compiled from: WidgetGuildInviteShareEmptySuggestions.kt */
    public static final class C86911 extends AbstractC12240o implements Function1<WidgetGuildInviteShareViewModel.ViewState.Loaded, Unit> {
        public C86911() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetGuildInviteShareViewModel.ViewState.Loaded loaded) {
            invoke2(loaded);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetGuildInviteShareViewModel.ViewState.Loaded loaded) {
            C12238m.checkNotNullParameter(loaded, "viewState");
            WidgetGuildInviteShareEmptySuggestions.this.updateUi(loaded);
        }
    }

    public WidgetGuildInviteShareEmptySuggestions() {
        super(C5419R.layout.widget_guild_invite_share_empty_suggestions);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetGuildInviteShareEmptySuggestions$binding$2.INSTANCE, null, 2, null);
        WidgetGuildInviteShareEmptySuggestions$viewModel$2 widgetGuildInviteShareEmptySuggestions$viewModel$2 = new WidgetGuildInviteShareEmptySuggestions$viewModel$2(this);
        C0865g0 c0865g0 = new C0865g0(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, C12216a0.getOrCreateKotlinClass(WidgetGuildInviteShareViewModel.class), new C8684xdbf0d98a(c0865g0), new C0869i0(widgetGuildInviteShareEmptySuggestions$viewModel$2));
        this.guildId = C12083g.lazy(new WidgetGuildInviteShareEmptySuggestions$guildId$2(this));
    }

    public static final /* synthetic */ BottomSheetBehavior access$getBottomSheetBehavior$p(WidgetGuildInviteShareEmptySuggestions widgetGuildInviteShareEmptySuggestions) {
        BottomSheetBehavior<ViewInviteSettingsSheet> bottomSheetBehavior = widgetGuildInviteShareEmptySuggestions.bottomSheetBehavior;
        if (bottomSheetBehavior == null) {
            C12238m.throwUninitializedPropertyAccessException("bottomSheetBehavior");
        }
        return bottomSheetBehavior;
    }

    private final WidgetGuildInviteShareEmptySuggestionsBinding getBinding() {
        return (WidgetGuildInviteShareEmptySuggestionsBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final CharSequence getHoursExpirationString(int hours, CharSequence maxUses) {
        Resources resources = getResources();
        C12238m.checkNotNullExpressionValue(resources, "resources");
        CharSequence quantityString = StringResourceUtilsKt.getQuantityString(resources, requireContext(), C5419R.plurals.duration_hours_hours, hours, Integer.valueOf(hours));
        Resources resources2 = getResources();
        C12238m.checkNotNullExpressionValue(resources2, "resources");
        return C1107b.m211c(resources2, C5419R.string.invite_settings_expired_description, new Object[]{quantityString, maxUses}, (4 & 4) != 0 ? C1107b.d.f1493j : null);
    }

    private final String getInviteLink(ModelInvite modelInvite) {
        return modelInvite == null ? BuildConfig.HOST_INVITE : modelInvite.toLink(getResources(), BuildConfig.HOST_INVITE);
    }

    private final WidgetGuildInviteShareViewModel getViewModel() {
        return (WidgetGuildInviteShareViewModel) this.viewModel.getValue();
    }

    private final void initBottomSheet() {
        getBinding().f16831g.setOnGenerateLinkListener(new C86851());
        getBinding().f16831g.setViewModel(getViewModel());
    }

    private final void initBottomSheetBehavior(BottomSheetBehavior<ViewInviteSettingsSheet> bottomSheetBehavior) {
        bottomSheetBehavior.setState(5);
        bottomSheetBehavior.addBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() { // from class: com.discord.widgets.guilds.invite.WidgetGuildInviteShareEmptySuggestions.initBottomSheetBehavior.1
            @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
            public void onSlide(View bottomSheet, float slideOffset) {
                C12238m.checkNotNullParameter(bottomSheet, "bottomSheet");
            }

            @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
            public void onStateChanged(View bottomSheet, int newState) {
                C12238m.checkNotNullParameter(bottomSheet, "bottomSheet");
                if (newState == 5) {
                    WidgetGuildInviteShareEmptySuggestions.this.getViewModel().refreshUi();
                }
                ViewExtensions.fadeBy$default(WidgetGuildInviteShareEmptySuggestions.this.getBinding().f16826b, newState != 5, 0L, 2, null);
            }
        });
    }

    private final void updateUi(WidgetGuildInviteShareViewModel.ViewState.Loaded viewState) {
        CharSequence quantityString;
        WidgetInviteModel widgetInviteModel = viewState.getWidgetInviteModel();
        getBinding().f16831g.configureUi(widgetInviteModel);
        final ModelInvite invite = widgetInviteModel.getInvite();
        TextView textView = getBinding().f16827c;
        C12238m.checkNotNullExpressionValue(textView, "binding.guildInviteEmptySuggestionsInviteLink");
        textView.setText(getInviteLink(invite));
        getBinding().f16827c.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.guilds.invite.WidgetGuildInviteShareEmptySuggestions.updateUi.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GuildInviteUiHelperKt.copyLinkClick(C1643a.m885x(view, "it", "it.context"), invite, WidgetGuildInviteShareEmptySuggestions.this.getMostRecentIntent());
            }
        });
        getBinding().f16828d.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.guilds.invite.WidgetGuildInviteShareEmptySuggestions.updateUi.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ModelInvite modelInvite = invite;
                if (modelInvite != null) {
                    GuildInviteUiHelperKt.shareLinkClick(WidgetGuildInviteShareEmptySuggestions.this.getContext(), modelInvite);
                }
            }
        });
        getBinding().f16829e.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.guilds.invite.WidgetGuildInviteShareEmptySuggestions.updateUi.3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetGuildInviteShareEmptySuggestions.access$getBottomSheetBehavior$p(WidgetGuildInviteShareEmptySuggestions.this).setState(3);
            }
        });
        ModelInvite.Settings settings = widgetInviteModel.getSettings();
        if (settings != null) {
            if (settings.getMaxUses() == 0) {
                quantityString = getResources().getString(C5419R.string.max_uses_description_unlimited_uses);
                C12238m.checkNotNullExpressionValue(quantityString, "resources.getString(R.st…scription_unlimited_uses)");
            } else {
                Resources resources = getResources();
                C12238m.checkNotNullExpressionValue(resources, "resources");
                quantityString = StringResourceUtilsKt.getQuantityString(resources, requireContext(), C5419R.plurals.max_uses_description_mobile_maxUses, settings.getMaxUses(), Integer.valueOf(settings.getMaxUses()));
            }
            int maxAge = widgetInviteModel.getSettings().getMaxAge();
            if (maxAge == 0) {
                String str = getResources().getString(C5419R.string.max_age_never_description_mobile) + ", " + quantityString;
                C12238m.checkNotNullExpressionValue(str, "StringBuilder()\n        …              .toString()");
                TextView textView2 = getBinding().f16830f;
                C12238m.checkNotNullExpressionValue(textView2, "binding.guildInviteEmpty…SettingsInviteLinkSubtext");
                textView2.setText(str);
                return;
            }
            if (maxAge == 1800) {
                Resources resources2 = getResources();
                C12238m.checkNotNullExpressionValue(resources2, "resources");
                CharSequence quantityString2 = StringResourceUtilsKt.getQuantityString(resources2, requireContext(), C5419R.plurals.duration_minutes_minutes, 30, 30);
                TextView textView3 = getBinding().f16830f;
                C12238m.checkNotNullExpressionValue(textView3, "binding.guildInviteEmpty…SettingsInviteLinkSubtext");
                Resources resources3 = getResources();
                C12238m.checkNotNullExpressionValue(resources3, "resources");
                textView3.setText(C1107b.m211c(resources3, C5419R.string.invite_settings_expired_description, new Object[]{quantityString2, quantityString}, (4 & 4) != 0 ? C1107b.d.f1493j : null));
                return;
            }
            if (maxAge == 3600) {
                TextView textView4 = getBinding().f16830f;
                C12238m.checkNotNullExpressionValue(textView4, "binding.guildInviteEmpty…SettingsInviteLinkSubtext");
                textView4.setText(getHoursExpirationString(1, quantityString));
                return;
            }
            if (maxAge == 21600) {
                TextView textView5 = getBinding().f16830f;
                C12238m.checkNotNullExpressionValue(textView5, "binding.guildInviteEmpty…SettingsInviteLinkSubtext");
                textView5.setText(getHoursExpirationString(6, quantityString));
                return;
            }
            if (maxAge == 43200) {
                TextView textView6 = getBinding().f16830f;
                C12238m.checkNotNullExpressionValue(textView6, "binding.guildInviteEmpty…SettingsInviteLinkSubtext");
                textView6.setText(getHoursExpirationString(12, quantityString));
                return;
            }
            if (maxAge == 86400) {
                Resources resources4 = getResources();
                C12238m.checkNotNullExpressionValue(resources4, "resources");
                CharSequence quantityString3 = StringResourceUtilsKt.getQuantityString(resources4, requireContext(), C5419R.plurals.duration_days_days, 1, 1);
                TextView textView7 = getBinding().f16830f;
                C12238m.checkNotNullExpressionValue(textView7, "binding.guildInviteEmpty…SettingsInviteLinkSubtext");
                Resources resources5 = getResources();
                C12238m.checkNotNullExpressionValue(resources5, "resources");
                textView7.setText(C1107b.m211c(resources5, C5419R.string.invite_settings_expired_description, new Object[]{quantityString3, quantityString}, (4 & 4) != 0 ? C1107b.d.f1493j : null));
                return;
            }
            if (maxAge != 604800) {
                return;
            }
            Resources resources6 = getResources();
            C12238m.checkNotNullExpressionValue(resources6, "resources");
            CharSequence quantityString4 = StringResourceUtilsKt.getQuantityString(resources6, requireContext(), C5419R.plurals.duration_days_days, 7, 7);
            TextView textView8 = getBinding().f16830f;
            C12238m.checkNotNullExpressionValue(textView8, "binding.guildInviteEmpty…SettingsInviteLinkSubtext");
            Resources resources7 = getResources();
            C12238m.checkNotNullExpressionValue(resources7, "resources");
            textView8.setText(C1107b.m211c(resources7, C5419R.string.invite_settings_expired_description, new Object[]{quantityString4, quantityString}, (4 & 4) != 0 ? C1107b.d.f1493j : null));
        }
    }

    public final long getGuildId() {
        return ((Number) this.guildId.getValue()).longValue();
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        C12238m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        if (getMostRecentIntent().getLongExtra("com.discord.intent.extra.EXTRA_GUILD_ID", 0L) <= 0) {
            requireActivity().finish();
            return;
        }
        long longExtra = getMostRecentIntent().getLongExtra("com.discord.intent.extra.EXTRA_CHANNEL_ID", 0L);
        if (longExtra != 0) {
            getViewModel().selectChannel(longExtra);
        }
        final boolean booleanExtra = getMostRecentIntent().getBooleanExtra(WidgetGuildInviteShare.INTENT_IS_NUX_FLOW, false);
        setActionBarDisplayHomeAsUpEnabled(true, booleanExtra ? Integer.valueOf(DrawableCompat.getThemedDrawableRes$default(requireContext(), C5419R.attr.ic_close_24dp, 0, 2, (Object) null)) : null, booleanExtra ? Integer.valueOf(C5419R.string.close) : null);
        AppFragment.setOnBackPressed$default(this, new Func0<Boolean>() { // from class: com.discord.widgets.guilds.invite.WidgetGuildInviteShareEmptySuggestions.onViewBound.1
            @Override // p658rx.functions.Func0, java.util.concurrent.Callable
            public final Boolean call() {
                if (WidgetGuildInviteShareEmptySuggestions.access$getBottomSheetBehavior$p(WidgetGuildInviteShareEmptySuggestions.this).getState() != 5) {
                    WidgetGuildInviteShareEmptySuggestions.access$getBottomSheetBehavior$p(WidgetGuildInviteShareEmptySuggestions.this).setState(5);
                    return Boolean.TRUE;
                }
                if (!booleanExtra) {
                    return Boolean.FALSE;
                }
                C0870j.m155c(WidgetGuildInviteShareEmptySuggestions.this.requireContext(), false, null, 6);
                return Boolean.TRUE;
            }
        }, 0, 2, null);
        BottomSheetBehavior<ViewInviteSettingsSheet> bottomSheetBehaviorFrom = BottomSheetBehavior.from(getBinding().f16831g);
        C12238m.checkNotNullExpressionValue(bottomSheetBehaviorFrom, "BottomSheetBehavior.from…nviteSettingsBottomSheet)");
        this.bottomSheetBehavior = bottomSheetBehaviorFrom;
        if (bottomSheetBehaviorFrom == null) {
            C12238m.throwUninitializedPropertyAccessException("bottomSheetBehavior");
        }
        initBottomSheetBehavior(bottomSheetBehaviorFrom);
        initBottomSheet();
        getBinding().f16826b.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.guilds.invite.WidgetGuildInviteShareEmptySuggestions.onViewBound.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                WidgetGuildInviteShareEmptySuggestions.access$getBottomSheetBehavior$p(WidgetGuildInviteShareEmptySuggestions.this).setState(5);
            }
        });
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        Observable<WidgetGuildInviteShareViewModel.ViewState> observableM11085K = getViewModel().observeViewState().m11085K();
        C12238m.checkNotNullExpressionValue(observableM11085K, "viewModel.observeViewSta…  .onBackpressureBuffer()");
        Observable<R> observableM11083G = observableM11085K.m11118y(new InterfaceC12589b<Object, Boolean>() { // from class: com.discord.widgets.guilds.invite.WidgetGuildInviteShareEmptySuggestions$onViewBoundOrOnResume$$inlined$filterIs$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // p637j0.p641k.InterfaceC12589b
            public final Boolean call(Object obj) {
                return Boolean.valueOf(obj instanceof WidgetGuildInviteShareViewModel.ViewState.Loaded);
            }
        }).m11083G(new InterfaceC12589b<Object, T>() { // from class: com.discord.widgets.guilds.invite.WidgetGuildInviteShareEmptySuggestions$onViewBoundOrOnResume$$inlined$filterIs$2
            @Override // p637j0.p641k.InterfaceC12589b
            public final T call(Object obj) {
                Objects.requireNonNull(obj, "null cannot be cast to non-null type com.discord.widgets.guilds.invite.WidgetGuildInviteShareViewModel.ViewState.Loaded");
                return (T) ((WidgetGuildInviteShareViewModel.ViewState.Loaded) obj);
            }
        });
        C12238m.checkNotNullExpressionValue(observableM11083G, "filter { it is T }.map { it as T }");
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.bindToComponentLifecycle$default(observableM11083G, this, null, 2, null), (Class<?>) WidgetGuildInviteShareEmptySuggestions.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C86911());
    }
}
