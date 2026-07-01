package com.discord.widgets.servers.community;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import b.a.d.AppScreen2;
import b.a.d.AppToast;
import b.a.d.AppViewModelDelegates2;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.app.AppActivity;
import com.discord.app.AppFragment;
import com.discord.app.AppLogger2;
import com.discord.databinding.WidgetServerSettingsCommunityOverviewBinding;
import com.discord.stores.StoreStream;
import com.discord.utilities.error.Error;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.widgets.channels.WidgetChannelSelector;
import com.discord.widgets.servers.community.WidgetConfirmRemoveCommunityDialog;
import com.discord.widgets.servers.community.WidgetServerSettingsCommunityOverviewViewModel;
import com.discord.widgets.servers.community.WidgetServerSettingsEnableCommunitySteps;
import com.discord.widgets.settings.WidgetSettingsLanguage;
import com.discord.widgets.settings.WidgetSettingsLanguageSelect;
import d0.LazyJVM;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import d0.z.d.Reflection2;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import rx.Observable;
import rx.Subscription;

/* JADX INFO: compiled from: WidgetServerSettingsCommunityOverview.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsCommunityOverview extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetServerSettingsCommunityOverview.class, "binding", "getBinding()Lcom/discord/databinding/WidgetServerSettingsCommunityOverviewBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String INTENT_EXTRA_GUILD_ID = "INTENT_EXTRA_GUILD_ID";
    private static final String REQUEST_KEY_RULES_CHANNEL = "REQUEST_KEY_RULES_CHANNEL";
    private static final String REQUEST_KEY_UPDATES_CHANNEL = "REQUEST_KEY_UPDATES_CHANNEL";

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* JADX INFO: renamed from: guildId$delegate, reason: from kotlin metadata */
    private final Lazy guildId;
    private final AppLogger2 loggingConfig;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* JADX INFO: compiled from: WidgetServerSettingsCommunityOverview.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void create(Context context, long guildId) {
            Intrinsics3.checkNotNullParameter(context, "context");
            StoreStream.INSTANCE.getAnalytics().onGuildSettingsPaneViewed("COMMUNITY_OVERVIEW", guildId);
            Intent intentPutExtra = new Intent().putExtra("INTENT_EXTRA_GUILD_ID", guildId);
            Intrinsics3.checkNotNullExpressionValue(intentPutExtra, "Intent()\n          .putE…_EXTRA_GUILD_ID, guildId)");
            AppScreen2.d(context, WidgetServerSettingsCommunityOverview.class, intentPutExtra);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.servers.community.WidgetServerSettingsCommunityOverview$onViewBound$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetServerSettingsCommunityOverview.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<String, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(String str) {
            invoke2(str);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(String str) {
            Intrinsics3.checkNotNullParameter(str, "locale");
            WidgetServerSettingsCommunityOverview.this.getViewModel().saveLocale(str);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.servers.community.WidgetServerSettingsCommunityOverview$onViewBound$2, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetServerSettingsCommunityOverview.kt */
    public static final class AnonymousClass2 extends Lambda implements Function2<Long, String, Unit> {
        public AnonymousClass2() {
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Long l, String str) {
            invoke(l.longValue(), str);
            return Unit.a;
        }

        public final void invoke(long j, String str) {
            Intrinsics3.checkNotNullParameter(str, "<anonymous parameter 1>");
            WidgetServerSettingsCommunityOverview.this.getViewModel().saveRulesChannel(j);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.servers.community.WidgetServerSettingsCommunityOverview$onViewBound$3, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetServerSettingsCommunityOverview.kt */
    public static final class AnonymousClass3 extends Lambda implements Function2<Long, String, Unit> {
        public AnonymousClass3() {
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Long l, String str) {
            invoke(l.longValue(), str);
            return Unit.a;
        }

        public final void invoke(long j, String str) {
            Intrinsics3.checkNotNullParameter(str, "<anonymous parameter 1>");
            WidgetServerSettingsCommunityOverview.this.getViewModel().saveCommunityUpdatesChannel(j);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.servers.community.WidgetServerSettingsCommunityOverview$onViewBoundOrOnResume$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetServerSettingsCommunityOverview.kt */
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<WidgetServerSettingsCommunityOverviewViewModel.ViewState, Unit> {
        public AnonymousClass1(WidgetServerSettingsCommunityOverview widgetServerSettingsCommunityOverview) {
            super(1, widgetServerSettingsCommunityOverview, WidgetServerSettingsCommunityOverview.class, "configureUI", "configureUI(Lcom/discord/widgets/servers/community/WidgetServerSettingsCommunityOverviewViewModel$ViewState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetServerSettingsCommunityOverviewViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetServerSettingsCommunityOverviewViewModel.ViewState viewState) {
            Intrinsics3.checkNotNullParameter(viewState, "p1");
            ((WidgetServerSettingsCommunityOverview) this.receiver).configureUI(viewState);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.servers.community.WidgetServerSettingsCommunityOverview$onViewBoundOrOnResume$2, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetServerSettingsCommunityOverview.kt */
    public static final class AnonymousClass2 extends Lambda implements Function1<WidgetServerSettingsCommunityOverviewViewModel.Event, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetServerSettingsCommunityOverviewViewModel.Event event) {
            invoke2(event);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetServerSettingsCommunityOverviewViewModel.Event event) {
            Intrinsics3.checkNotNullParameter(event, "event");
            if (Intrinsics3.areEqual(event, WidgetServerSettingsCommunityOverviewViewModel.Event.DisableCommunitySuccess.INSTANCE)) {
                WidgetServerSettingsCommunityOverview.this.requireActivity().finish();
                WidgetServerSettingsEnableCommunitySteps.Companion companion = WidgetServerSettingsEnableCommunitySteps.INSTANCE;
                FragmentActivity fragmentActivityRequireActivity = WidgetServerSettingsCommunityOverview.this.requireActivity();
                Intrinsics3.checkNotNullExpressionValue(fragmentActivityRequireActivity, "requireActivity()");
                companion.create(fragmentActivityRequireActivity, WidgetServerSettingsCommunityOverview.this.getGuildId());
                return;
            }
            if (Intrinsics3.areEqual(event, WidgetServerSettingsCommunityOverviewViewModel.Event.SaveSuccess.INSTANCE)) {
                AppToast.i(WidgetServerSettingsCommunityOverview.this, R.string.server_settings_updated, 0, 4);
            } else if (Intrinsics3.areEqual(event, WidgetServerSettingsCommunityOverviewViewModel.Event.Error.INSTANCE)) {
                AppToast.i(WidgetServerSettingsCommunityOverview.this, R.string.guild_settings_public_update_failed, 0, 4);
            }
        }
    }

    public WidgetServerSettingsCommunityOverview() {
        super(R.layout.widget_server_settings_community_overview);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetServerSettingsCommunityOverview2.INSTANCE, null, 2, null);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(WidgetServerSettingsCommunityOverviewViewModel.class), new WidgetServerSettingsCommunityOverview$appActivityViewModels$$inlined$activityViewModels$1(this), new AppViewModelDelegates2(new WidgetServerSettingsCommunityOverview5(this)));
        this.guildId = LazyJVM.lazy(new WidgetServerSettingsCommunityOverview3(this));
        this.loggingConfig = new AppLogger2(false, null, WidgetServerSettingsCommunityOverview4.INSTANCE, 3);
    }

    private final void configureUI(WidgetServerSettingsCommunityOverviewViewModel.ViewState viewState) {
        if (Intrinsics3.areEqual(viewState, WidgetServerSettingsCommunityOverviewViewModel.ViewState.Invalid.INSTANCE)) {
            requireActivity().finish();
        } else if (viewState instanceof WidgetServerSettingsCommunityOverviewViewModel.ViewState.Loaded) {
            configureValidUI((WidgetServerSettingsCommunityOverviewViewModel.ViewState.Loaded) viewState);
        } else if (viewState instanceof WidgetServerSettingsCommunityOverviewViewModel.ViewState.DisableCommunityLoading) {
            getBinding().e.setIsLoading(((WidgetServerSettingsCommunityOverviewViewModel.ViewState.DisableCommunityLoading) viewState).isLoading());
        }
    }

    private final void configureValidUI(final WidgetServerSettingsCommunityOverviewViewModel.ViewState.Loaded viewState) {
        String strE;
        getBinding().e.setIsLoading(false);
        String string = viewState.getRulesChannel() == null ? requireContext().getString(R.string.guild_settings_public_no_option_selected) : ChannelUtils.e(viewState.getRulesChannel(), requireContext(), false, 2);
        Intrinsics3.checkNotNullExpressionValue(string, "when (viewState.rulesCha…t(requireContext())\n    }");
        if (viewState.getUpdatesChannel() == null) {
            strE = requireContext().getString(R.string.guild_settings_public_no_option_selected);
        } else {
            Channel updatesChannel = viewState.getUpdatesChannel();
            FragmentActivity fragmentActivityRequireActivity = requireActivity();
            Intrinsics3.checkNotNullExpressionValue(fragmentActivityRequireActivity, "requireActivity()");
            strE = ChannelUtils.e(updatesChannel, fragmentActivityRequireActivity, false, 2);
        }
        Intrinsics3.checkNotNullExpressionValue(strE, "when (viewState.updatesC…(requireActivity())\n    }");
        getBinding().f2553b.setSubtitle(string);
        getBinding().c.setSubtitle(strE);
        getBinding().d.setSubtitle(WidgetSettingsLanguage.INSTANCE.getAsStringInLocale(viewState.getGuild().getPreferredLocale()));
        getBinding().f2553b.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.servers.community.WidgetServerSettingsCommunityOverview.configureValidUI.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetChannelSelector.INSTANCE.launchForText(WidgetServerSettingsCommunityOverview.this, viewState.getGuild().getId(), WidgetServerSettingsCommunityOverview.REQUEST_KEY_RULES_CHANNEL, (24 & 8) != 0 ? false : false, (24 & 16) != 0 ? R.string.none : 0);
            }
        });
        getBinding().c.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.servers.community.WidgetServerSettingsCommunityOverview.configureValidUI.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetChannelSelector.INSTANCE.launchForText(WidgetServerSettingsCommunityOverview.this, viewState.getGuild().getId(), WidgetServerSettingsCommunityOverview.REQUEST_KEY_UPDATES_CHANNEL, (24 & 8) != 0 ? false : false, (24 & 16) != 0 ? R.string.none : 0);
            }
        });
        getBinding().d.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.servers.community.WidgetServerSettingsCommunityOverview.configureValidUI.3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetSettingsLanguageSelect.INSTANCE.show(WidgetServerSettingsCommunityOverview.this);
            }
        });
        getBinding().e.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.servers.community.WidgetServerSettingsCommunityOverview.configureValidUI.4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AppActivity appActivity = WidgetServerSettingsCommunityOverview.this.getAppActivity();
                if (appActivity != null) {
                    WidgetConfirmRemoveCommunityDialog.Companion companion = WidgetConfirmRemoveCommunityDialog.INSTANCE;
                    FragmentManager supportFragmentManager = appActivity.getSupportFragmentManager();
                    Intrinsics3.checkNotNullExpressionValue(supportFragmentManager, "appActivity.supportFragmentManager");
                    companion.show(supportFragmentManager, viewState.getGuild().getId());
                }
            }
        });
    }

    public static final void create(Context context, long j) {
        INSTANCE.create(context, j);
    }

    private final WidgetServerSettingsCommunityOverviewBinding getBinding() {
        return (WidgetServerSettingsCommunityOverviewBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final WidgetServerSettingsCommunityOverviewViewModel getViewModel() {
        return (WidgetServerSettingsCommunityOverviewViewModel) this.viewModel.getValue();
    }

    public final long getGuildId() {
        return ((Number) this.guildId.getValue()).longValue();
    }

    @Override // com.discord.app.AppFragment, com.discord.app.AppLogger.a
    public AppLogger2 getLoggingConfig() {
        return this.loggingConfig;
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        WidgetSettingsLanguageSelect.INSTANCE.registerForResult(this, new AnonymousClass1());
        WidgetChannelSelector.Companion companion = WidgetChannelSelector.INSTANCE;
        WidgetChannelSelector.Companion.registerForResult$default(companion, this, REQUEST_KEY_RULES_CHANNEL, false, new AnonymousClass2(), 4, null);
        WidgetChannelSelector.Companion.registerForResult$default(companion, this, REQUEST_KEY_UPDATES_CHANNEL, false, new AnonymousClass3(), 4, null);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        AppFragment.setActionBarDisplayHomeAsUpEnabled$default(this, false, 1, null);
        setActionBarTitle(R.string.guild_settings_community);
        Observable<WidgetServerSettingsCommunityOverviewViewModel.ViewState> observableR = getViewModel().observeViewState().r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "viewModel\n        .obser…  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.bindToComponentLifecycle$default(observableR, this, null, 2, null), (Class<?>) WidgetServerSettingsCommunityOverview.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass1(this));
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeEvents(), this, null, 2, null), (Class<?>) WidgetServerSettingsCommunityOverview.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass2());
    }
}
