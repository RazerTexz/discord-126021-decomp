package com.discord.widgets.guilds.invite;

import android.content.res.Resources;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import b.a.d.AppScreen2;
import b.a.d.AppViewModelDelegates3;
import b.a.d.AppViewModelDelegates5;
import b.a.k.FormatUtils;
import b.d.b.a.outline;
import com.discord.BuildConfig;
import com.discord.R;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetGuildInviteShareEmptySuggestionsBinding;
import com.discord.models.domain.ModelInvite;
import com.discord.utilities.drawable.DrawableCompat;
import com.discord.utilities.error.Error;
import com.discord.utilities.resources.StringResourceUtils;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.widgets.guilds.invite.WidgetGuildInviteShareViewModel;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import d0.LazyJVM;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import d0.z.d.Reflection2;
import j0.k.Func1;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;
import rx.Observable;
import rx.Subscription;
import rx.functions.Func0;

/* JADX INFO: compiled from: WidgetGuildInviteShareEmptySuggestions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildInviteShareEmptySuggestions extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetGuildInviteShareEmptySuggestions.class, "binding", "getBinding()Lcom/discord/databinding/WidgetGuildInviteShareEmptySuggestionsBinding;", 0)};

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private BottomSheetBehavior<ViewInviteSettingsSheet> bottomSheetBehavior;

    /* JADX INFO: renamed from: guildId$delegate, reason: from kotlin metadata */
    private final Lazy guildId;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* JADX INFO: renamed from: com.discord.widgets.guilds.invite.WidgetGuildInviteShareEmptySuggestions$initBottomSheet$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetGuildInviteShareEmptySuggestions.kt */
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
            WidgetGuildInviteShareEmptySuggestions.access$getBottomSheetBehavior$p(WidgetGuildInviteShareEmptySuggestions.this).setState(5);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.guilds.invite.WidgetGuildInviteShareEmptySuggestions$onViewBoundOrOnResume$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetGuildInviteShareEmptySuggestions.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<WidgetGuildInviteShareViewModel.ViewState.Loaded, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetGuildInviteShareViewModel.ViewState.Loaded loaded) {
            invoke2(loaded);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetGuildInviteShareViewModel.ViewState.Loaded loaded) {
            Intrinsics3.checkNotNullParameter(loaded, "viewState");
            WidgetGuildInviteShareEmptySuggestions.this.updateUi(loaded);
        }
    }

    public WidgetGuildInviteShareEmptySuggestions() {
        super(R.layout.widget_guild_invite_share_empty_suggestions);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetGuildInviteShareEmptySuggestions2.INSTANCE, null, 2, null);
        WidgetGuildInviteShareEmptySuggestions4 widgetGuildInviteShareEmptySuggestions4 = new WidgetGuildInviteShareEmptySuggestions4(this);
        AppViewModelDelegates3 appViewModelDelegates3 = new AppViewModelDelegates3(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(WidgetGuildInviteShareViewModel.class), new WidgetGuildInviteShareEmptySuggestions$appViewModels$$inlined$viewModels$1(appViewModelDelegates3), new AppViewModelDelegates5(widgetGuildInviteShareEmptySuggestions4));
        this.guildId = LazyJVM.lazy(new WidgetGuildInviteShareEmptySuggestions3(this));
    }

    public static final /* synthetic */ BottomSheetBehavior access$getBottomSheetBehavior$p(WidgetGuildInviteShareEmptySuggestions widgetGuildInviteShareEmptySuggestions) {
        BottomSheetBehavior<ViewInviteSettingsSheet> bottomSheetBehavior = widgetGuildInviteShareEmptySuggestions.bottomSheetBehavior;
        if (bottomSheetBehavior == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("bottomSheetBehavior");
        }
        return bottomSheetBehavior;
    }

    private final WidgetGuildInviteShareEmptySuggestionsBinding getBinding() {
        return (WidgetGuildInviteShareEmptySuggestionsBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final CharSequence getHoursExpirationString(int hours, CharSequence maxUses) {
        Resources resources = getResources();
        Intrinsics3.checkNotNullExpressionValue(resources, "resources");
        CharSequence quantityString = StringResourceUtils.getQuantityString(resources, requireContext(), R.plurals.duration_hours_hours, hours, Integer.valueOf(hours));
        Resources resources2 = getResources();
        Intrinsics3.checkNotNullExpressionValue(resources2, "resources");
        return FormatUtils.c(resources2, R.string.invite_settings_expired_description, new Object[]{quantityString, maxUses}, (4 & 4) != 0 ? FormatUtils.d.j : null);
    }

    private final String getInviteLink(ModelInvite modelInvite) {
        return modelInvite == null ? BuildConfig.HOST_INVITE : modelInvite.toLink(getResources(), BuildConfig.HOST_INVITE);
    }

    private final WidgetGuildInviteShareViewModel getViewModel() {
        return (WidgetGuildInviteShareViewModel) this.viewModel.getValue();
    }

    private final void initBottomSheet() {
        getBinding().g.setOnGenerateLinkListener(new AnonymousClass1());
        getBinding().g.setViewModel(getViewModel());
    }

    private final void initBottomSheetBehavior(BottomSheetBehavior<ViewInviteSettingsSheet> bottomSheetBehavior) {
        bottomSheetBehavior.setState(5);
        bottomSheetBehavior.addBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() { // from class: com.discord.widgets.guilds.invite.WidgetGuildInviteShareEmptySuggestions.initBottomSheetBehavior.1
            @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
            public void onSlide(View bottomSheet, float slideOffset) {
                Intrinsics3.checkNotNullParameter(bottomSheet, "bottomSheet");
            }

            @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
            public void onStateChanged(View bottomSheet, int newState) {
                Intrinsics3.checkNotNullParameter(bottomSheet, "bottomSheet");
                if (newState == 5) {
                    WidgetGuildInviteShareEmptySuggestions.this.getViewModel().refreshUi();
                }
                ViewExtensions.fadeBy$default(WidgetGuildInviteShareEmptySuggestions.this.getBinding().f2420b, newState != 5, 0L, 2, null);
            }
        });
    }

    private final void updateUi(WidgetGuildInviteShareViewModel.ViewState.Loaded viewState) {
        CharSequence quantityString;
        WidgetInviteModel widgetInviteModel = viewState.getWidgetInviteModel();
        getBinding().g.configureUi(widgetInviteModel);
        final ModelInvite invite = widgetInviteModel.getInvite();
        TextView textView = getBinding().c;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.guildInviteEmptySuggestionsInviteLink");
        textView.setText(getInviteLink(invite));
        getBinding().c.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.guilds.invite.WidgetGuildInviteShareEmptySuggestions.updateUi.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GuildInviteUiHelper.copyLinkClick(outline.x(view, "it", "it.context"), invite, WidgetGuildInviteShareEmptySuggestions.this.getMostRecentIntent());
            }
        });
        getBinding().d.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.guilds.invite.WidgetGuildInviteShareEmptySuggestions.updateUi.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ModelInvite modelInvite = invite;
                if (modelInvite != null) {
                    GuildInviteUiHelper.shareLinkClick(WidgetGuildInviteShareEmptySuggestions.this.getContext(), modelInvite);
                }
            }
        });
        getBinding().e.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.guilds.invite.WidgetGuildInviteShareEmptySuggestions.updateUi.3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetGuildInviteShareEmptySuggestions.access$getBottomSheetBehavior$p(WidgetGuildInviteShareEmptySuggestions.this).setState(3);
            }
        });
        ModelInvite.Settings settings = widgetInviteModel.getSettings();
        if (settings != null) {
            if (settings.getMaxUses() == 0) {
                quantityString = getResources().getString(R.string.max_uses_description_unlimited_uses);
                Intrinsics3.checkNotNullExpressionValue(quantityString, "resources.getString(R.st…scription_unlimited_uses)");
            } else {
                Resources resources = getResources();
                Intrinsics3.checkNotNullExpressionValue(resources, "resources");
                quantityString = StringResourceUtils.getQuantityString(resources, requireContext(), R.plurals.max_uses_description_mobile_maxUses, settings.getMaxUses(), Integer.valueOf(settings.getMaxUses()));
            }
            int maxAge = widgetInviteModel.getSettings().getMaxAge();
            if (maxAge == 0) {
                String str = getResources().getString(R.string.max_age_never_description_mobile) + ", " + quantityString;
                Intrinsics3.checkNotNullExpressionValue(str, "StringBuilder()\n        …              .toString()");
                TextView textView2 = getBinding().f;
                Intrinsics3.checkNotNullExpressionValue(textView2, "binding.guildInviteEmpty…SettingsInviteLinkSubtext");
                textView2.setText(str);
                return;
            }
            if (maxAge == 1800) {
                Resources resources2 = getResources();
                Intrinsics3.checkNotNullExpressionValue(resources2, "resources");
                CharSequence quantityString2 = StringResourceUtils.getQuantityString(resources2, requireContext(), R.plurals.duration_minutes_minutes, 30, 30);
                TextView textView3 = getBinding().f;
                Intrinsics3.checkNotNullExpressionValue(textView3, "binding.guildInviteEmpty…SettingsInviteLinkSubtext");
                Resources resources3 = getResources();
                Intrinsics3.checkNotNullExpressionValue(resources3, "resources");
                textView3.setText(FormatUtils.c(resources3, R.string.invite_settings_expired_description, new Object[]{quantityString2, quantityString}, (4 & 4) != 0 ? FormatUtils.d.j : null));
                return;
            }
            if (maxAge == 3600) {
                TextView textView4 = getBinding().f;
                Intrinsics3.checkNotNullExpressionValue(textView4, "binding.guildInviteEmpty…SettingsInviteLinkSubtext");
                textView4.setText(getHoursExpirationString(1, quantityString));
                return;
            }
            if (maxAge == 21600) {
                TextView textView5 = getBinding().f;
                Intrinsics3.checkNotNullExpressionValue(textView5, "binding.guildInviteEmpty…SettingsInviteLinkSubtext");
                textView5.setText(getHoursExpirationString(6, quantityString));
                return;
            }
            if (maxAge == 43200) {
                TextView textView6 = getBinding().f;
                Intrinsics3.checkNotNullExpressionValue(textView6, "binding.guildInviteEmpty…SettingsInviteLinkSubtext");
                textView6.setText(getHoursExpirationString(12, quantityString));
                return;
            }
            if (maxAge == 86400) {
                Resources resources4 = getResources();
                Intrinsics3.checkNotNullExpressionValue(resources4, "resources");
                CharSequence quantityString3 = StringResourceUtils.getQuantityString(resources4, requireContext(), R.plurals.duration_days_days, 1, 1);
                TextView textView7 = getBinding().f;
                Intrinsics3.checkNotNullExpressionValue(textView7, "binding.guildInviteEmpty…SettingsInviteLinkSubtext");
                Resources resources5 = getResources();
                Intrinsics3.checkNotNullExpressionValue(resources5, "resources");
                textView7.setText(FormatUtils.c(resources5, R.string.invite_settings_expired_description, new Object[]{quantityString3, quantityString}, (4 & 4) != 0 ? FormatUtils.d.j : null));
                return;
            }
            if (maxAge != 604800) {
                return;
            }
            Resources resources6 = getResources();
            Intrinsics3.checkNotNullExpressionValue(resources6, "resources");
            CharSequence quantityString4 = StringResourceUtils.getQuantityString(resources6, requireContext(), R.plurals.duration_days_days, 7, 7);
            TextView textView8 = getBinding().f;
            Intrinsics3.checkNotNullExpressionValue(textView8, "binding.guildInviteEmpty…SettingsInviteLinkSubtext");
            Resources resources7 = getResources();
            Intrinsics3.checkNotNullExpressionValue(resources7, "resources");
            textView8.setText(FormatUtils.c(resources7, R.string.invite_settings_expired_description, new Object[]{quantityString4, quantityString}, (4 & 4) != 0 ? FormatUtils.d.j : null));
        }
    }

    public final long getGuildId() {
        return ((Number) this.guildId.getValue()).longValue();
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
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
        setActionBarDisplayHomeAsUpEnabled(true, booleanExtra ? Integer.valueOf(DrawableCompat.getThemedDrawableRes$default(requireContext(), R.attr.ic_close_24dp, 0, 2, (Object) null)) : null, booleanExtra ? Integer.valueOf(R.string.close) : null);
        AppFragment.setOnBackPressed$default(this, new Func0<Boolean>() { // from class: com.discord.widgets.guilds.invite.WidgetGuildInviteShareEmptySuggestions.onViewBound.1
            @Override // rx.functions.Func0, java.util.concurrent.Callable
            public final Boolean call() {
                if (WidgetGuildInviteShareEmptySuggestions.access$getBottomSheetBehavior$p(WidgetGuildInviteShareEmptySuggestions.this).getState() != 5) {
                    WidgetGuildInviteShareEmptySuggestions.access$getBottomSheetBehavior$p(WidgetGuildInviteShareEmptySuggestions.this).setState(5);
                    return Boolean.TRUE;
                }
                if (!booleanExtra) {
                    return Boolean.FALSE;
                }
                AppScreen2.c(WidgetGuildInviteShareEmptySuggestions.this.requireContext(), false, null, 6);
                return Boolean.TRUE;
            }
        }, 0, 2, null);
        BottomSheetBehavior<ViewInviteSettingsSheet> bottomSheetBehaviorFrom = BottomSheetBehavior.from(getBinding().g);
        Intrinsics3.checkNotNullExpressionValue(bottomSheetBehaviorFrom, "BottomSheetBehavior.from…nviteSettingsBottomSheet)");
        this.bottomSheetBehavior = bottomSheetBehaviorFrom;
        if (bottomSheetBehaviorFrom == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("bottomSheetBehavior");
        }
        initBottomSheetBehavior(bottomSheetBehaviorFrom);
        initBottomSheet();
        getBinding().f2420b.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.guilds.invite.WidgetGuildInviteShareEmptySuggestions.onViewBound.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                WidgetGuildInviteShareEmptySuggestions.access$getBottomSheetBehavior$p(WidgetGuildInviteShareEmptySuggestions.this).setState(5);
            }
        });
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        Observable<WidgetGuildInviteShareViewModel.ViewState> observableK = getViewModel().observeViewState().K();
        Intrinsics3.checkNotNullExpressionValue(observableK, "viewModel.observeViewSta…  .onBackpressureBuffer()");
        Observable<R> observableG = observableK.y(new Func1<Object, Boolean>() { // from class: com.discord.widgets.guilds.invite.WidgetGuildInviteShareEmptySuggestions$onViewBoundOrOnResume$$inlined$filterIs$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // j0.k.Func1
            public final Boolean call(Object obj) {
                return Boolean.valueOf(obj instanceof WidgetGuildInviteShareViewModel.ViewState.Loaded);
            }
        }).G(new Func1<Object, T>() { // from class: com.discord.widgets.guilds.invite.WidgetGuildInviteShareEmptySuggestions$onViewBoundOrOnResume$$inlined$filterIs$2
            @Override // j0.k.Func1
            public final T call(Object obj) {
                Objects.requireNonNull(obj, "null cannot be cast to non-null type com.discord.widgets.guilds.invite.WidgetGuildInviteShareViewModel.ViewState.Loaded");
                return (T) ((WidgetGuildInviteShareViewModel.ViewState.Loaded) obj);
            }
        });
        Intrinsics3.checkNotNullExpressionValue(observableG, "filter { it is T }.map { it as T }");
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.bindToComponentLifecycle$default(observableG, this, null, 2, null), (Class<?>) WidgetGuildInviteShareEmptySuggestions.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass1());
    }
}
