package com.discord.widgets.servers.community;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import com.discord.C5419R;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.app.AppActivity;
import com.discord.app.AppFragment;
import com.discord.app.LoggingConfig;
import com.discord.databinding.WidgetServerSettingsCommunityOverviewBinding;
import com.discord.stores.StoreStream;
import com.discord.utilities.error.Error;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.widgets.channels.WidgetChannelSelector;
import com.discord.widgets.servers.community.WidgetConfirmRemoveCommunityDialog;
import com.discord.widgets.servers.community.WidgetServerSettingsCommunityOverviewViewModel;
import com.discord.widgets.servers.community.WidgetServerSettingsEnableCommunitySteps;
import com.discord.widgets.settings.WidgetSettingsLanguage;
import com.discord.widgets.settings.WidgetSettingsLanguageSelect;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p007b.p008a.p018d.C0863f0;
import p007b.p008a.p018d.C0870j;
import p007b.p008a.p018d.C0876m;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.C12083g;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12216a0;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;
import p658rx.Observable;
import p658rx.Subscription;

/* JADX INFO: compiled from: WidgetServerSettingsCommunityOverview.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsCommunityOverview extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {C1643a.m846d0(WidgetServerSettingsCommunityOverview.class, "binding", "getBinding()Lcom/discord/databinding/WidgetServerSettingsCommunityOverviewBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String INTENT_EXTRA_GUILD_ID = "INTENT_EXTRA_GUILD_ID";
    private static final String REQUEST_KEY_RULES_CHANNEL = "REQUEST_KEY_RULES_CHANNEL";
    private static final String REQUEST_KEY_UPDATES_CHANNEL = "REQUEST_KEY_UPDATES_CHANNEL";

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* JADX INFO: renamed from: guildId$delegate, reason: from kotlin metadata */
    private final Lazy guildId;
    private final LoggingConfig loggingConfig;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* JADX INFO: compiled from: WidgetServerSettingsCommunityOverview.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void create(Context context, long guildId) {
            C12238m.checkNotNullParameter(context, "context");
            StoreStream.INSTANCE.getAnalytics().onGuildSettingsPaneViewed("COMMUNITY_OVERVIEW", guildId);
            Intent intentPutExtra = new Intent().putExtra("INTENT_EXTRA_GUILD_ID", guildId);
            C12238m.checkNotNullExpressionValue(intentPutExtra, "Intent()\n          .putE…_EXTRA_GUILD_ID, guildId)");
            C0870j.m156d(context, WidgetServerSettingsCommunityOverview.class, intentPutExtra);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.servers.community.WidgetServerSettingsCommunityOverview$onViewBound$1 */
    /* JADX INFO: compiled from: WidgetServerSettingsCommunityOverview.kt */
    public static final class C93641 extends AbstractC12240o implements Function1<String, Unit> {
        public C93641() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(String str) {
            invoke2(str);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(String str) {
            C12238m.checkNotNullParameter(str, "locale");
            WidgetServerSettingsCommunityOverview.this.getViewModel().saveLocale(str);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.servers.community.WidgetServerSettingsCommunityOverview$onViewBound$2 */
    /* JADX INFO: compiled from: WidgetServerSettingsCommunityOverview.kt */
    public static final class C93652 extends AbstractC12240o implements Function2<Long, String, Unit> {
        public C93652() {
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Long l, String str) {
            invoke(l.longValue(), str);
            return Unit.f27425a;
        }

        public final void invoke(long j, String str) {
            C12238m.checkNotNullParameter(str, "<anonymous parameter 1>");
            WidgetServerSettingsCommunityOverview.this.getViewModel().saveRulesChannel(j);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.servers.community.WidgetServerSettingsCommunityOverview$onViewBound$3 */
    /* JADX INFO: compiled from: WidgetServerSettingsCommunityOverview.kt */
    public static final class C93663 extends AbstractC12240o implements Function2<Long, String, Unit> {
        public C93663() {
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Long l, String str) {
            invoke(l.longValue(), str);
            return Unit.f27425a;
        }

        public final void invoke(long j, String str) {
            C12238m.checkNotNullParameter(str, "<anonymous parameter 1>");
            WidgetServerSettingsCommunityOverview.this.getViewModel().saveCommunityUpdatesChannel(j);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.servers.community.WidgetServerSettingsCommunityOverview$onViewBoundOrOnResume$1 */
    /* JADX INFO: compiled from: WidgetServerSettingsCommunityOverview.kt */
    public static final /* synthetic */ class C93671 extends C12236k implements Function1<WidgetServerSettingsCommunityOverviewViewModel.ViewState, Unit> {
        public C93671(WidgetServerSettingsCommunityOverview widgetServerSettingsCommunityOverview) {
            super(1, widgetServerSettingsCommunityOverview, WidgetServerSettingsCommunityOverview.class, "configureUI", "configureUI(Lcom/discord/widgets/servers/community/WidgetServerSettingsCommunityOverviewViewModel$ViewState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetServerSettingsCommunityOverviewViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetServerSettingsCommunityOverviewViewModel.ViewState viewState) {
            C12238m.checkNotNullParameter(viewState, "p1");
            ((WidgetServerSettingsCommunityOverview) this.receiver).configureUI(viewState);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.servers.community.WidgetServerSettingsCommunityOverview$onViewBoundOrOnResume$2 */
    /* JADX INFO: compiled from: WidgetServerSettingsCommunityOverview.kt */
    public static final class C93682 extends AbstractC12240o implements Function1<WidgetServerSettingsCommunityOverviewViewModel.Event, Unit> {
        public C93682() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetServerSettingsCommunityOverviewViewModel.Event event) {
            invoke2(event);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetServerSettingsCommunityOverviewViewModel.Event event) {
            C12238m.checkNotNullParameter(event, "event");
            if (C12238m.areEqual(event, WidgetServerSettingsCommunityOverviewViewModel.Event.DisableCommunitySuccess.INSTANCE)) {
                WidgetServerSettingsCommunityOverview.this.requireActivity().finish();
                WidgetServerSettingsEnableCommunitySteps.Companion companion = WidgetServerSettingsEnableCommunitySteps.INSTANCE;
                FragmentActivity fragmentActivityRequireActivity = WidgetServerSettingsCommunityOverview.this.requireActivity();
                C12238m.checkNotNullExpressionValue(fragmentActivityRequireActivity, "requireActivity()");
                companion.create(fragmentActivityRequireActivity, WidgetServerSettingsCommunityOverview.this.getGuildId());
                return;
            }
            if (C12238m.areEqual(event, WidgetServerSettingsCommunityOverviewViewModel.Event.SaveSuccess.INSTANCE)) {
                C0876m.m171i(WidgetServerSettingsCommunityOverview.this, C5419R.string.server_settings_updated, 0, 4);
            } else if (C12238m.areEqual(event, WidgetServerSettingsCommunityOverviewViewModel.Event.Error.INSTANCE)) {
                C0876m.m171i(WidgetServerSettingsCommunityOverview.this, C5419R.string.guild_settings_public_update_failed, 0, 4);
            }
        }
    }

    public WidgetServerSettingsCommunityOverview() {
        super(C5419R.layout.widget_server_settings_community_overview);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetServerSettingsCommunityOverview$binding$2.INSTANCE, null, 2, null);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, C12216a0.getOrCreateKotlinClass(WidgetServerSettingsCommunityOverviewViewModel.class), new C9358xb2c7ca17(this), new C0863f0(new WidgetServerSettingsCommunityOverview$viewModel$2(this)));
        this.guildId = C12083g.lazy(new WidgetServerSettingsCommunityOverview$guildId$2(this));
        this.loggingConfig = new LoggingConfig(false, null, WidgetServerSettingsCommunityOverview$loggingConfig$1.INSTANCE, 3);
    }

    private final void configureUI(WidgetServerSettingsCommunityOverviewViewModel.ViewState viewState) {
        if (C12238m.areEqual(viewState, WidgetServerSettingsCommunityOverviewViewModel.ViewState.Invalid.INSTANCE)) {
            requireActivity().finish();
        } else if (viewState instanceof WidgetServerSettingsCommunityOverviewViewModel.ViewState.Loaded) {
            configureValidUI((WidgetServerSettingsCommunityOverviewViewModel.ViewState.Loaded) viewState);
        } else if (viewState instanceof WidgetServerSettingsCommunityOverviewViewModel.ViewState.DisableCommunityLoading) {
            getBinding().f17580e.setIsLoading(((WidgetServerSettingsCommunityOverviewViewModel.ViewState.DisableCommunityLoading) viewState).isLoading());
        }
    }

    private final void configureValidUI(final WidgetServerSettingsCommunityOverviewViewModel.ViewState.Loaded viewState) {
        String strM7681e;
        getBinding().f17580e.setIsLoading(false);
        String string = viewState.getRulesChannel() == null ? requireContext().getString(C5419R.string.guild_settings_public_no_option_selected) : ChannelUtils.m7681e(viewState.getRulesChannel(), requireContext(), false, 2);
        C12238m.checkNotNullExpressionValue(string, "when (viewState.rulesCha…t(requireContext())\n    }");
        if (viewState.getUpdatesChannel() == null) {
            strM7681e = requireContext().getString(C5419R.string.guild_settings_public_no_option_selected);
        } else {
            Channel updatesChannel = viewState.getUpdatesChannel();
            FragmentActivity fragmentActivityRequireActivity = requireActivity();
            C12238m.checkNotNullExpressionValue(fragmentActivityRequireActivity, "requireActivity()");
            strM7681e = ChannelUtils.m7681e(updatesChannel, fragmentActivityRequireActivity, false, 2);
        }
        C12238m.checkNotNullExpressionValue(strM7681e, "when (viewState.updatesC…(requireActivity())\n    }");
        getBinding().f17577b.setSubtitle(string);
        getBinding().f17578c.setSubtitle(strM7681e);
        getBinding().f17579d.setSubtitle(WidgetSettingsLanguage.INSTANCE.getAsStringInLocale(viewState.getGuild().getPreferredLocale()));
        getBinding().f17577b.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.servers.community.WidgetServerSettingsCommunityOverview.configureValidUI.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetChannelSelector.INSTANCE.launchForText(WidgetServerSettingsCommunityOverview.this, viewState.getGuild().getId(), WidgetServerSettingsCommunityOverview.REQUEST_KEY_RULES_CHANNEL, (24 & 8) != 0 ? false : false, (24 & 16) != 0 ? C5419R.string.none : 0);
            }
        });
        getBinding().f17578c.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.servers.community.WidgetServerSettingsCommunityOverview.configureValidUI.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetChannelSelector.INSTANCE.launchForText(WidgetServerSettingsCommunityOverview.this, viewState.getGuild().getId(), WidgetServerSettingsCommunityOverview.REQUEST_KEY_UPDATES_CHANNEL, (24 & 8) != 0 ? false : false, (24 & 16) != 0 ? C5419R.string.none : 0);
            }
        });
        getBinding().f17579d.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.servers.community.WidgetServerSettingsCommunityOverview.configureValidUI.3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetSettingsLanguageSelect.INSTANCE.show(WidgetServerSettingsCommunityOverview.this);
            }
        });
        getBinding().f17580e.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.servers.community.WidgetServerSettingsCommunityOverview.configureValidUI.4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AppActivity appActivity = WidgetServerSettingsCommunityOverview.this.getAppActivity();
                if (appActivity != null) {
                    WidgetConfirmRemoveCommunityDialog.Companion companion = WidgetConfirmRemoveCommunityDialog.INSTANCE;
                    FragmentManager supportFragmentManager = appActivity.getSupportFragmentManager();
                    C12238m.checkNotNullExpressionValue(supportFragmentManager, "appActivity.supportFragmentManager");
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

    @Override // com.discord.app.AppFragment, com.discord.app.AppLogger.InterfaceC5455a
    public LoggingConfig getLoggingConfig() {
        return this.loggingConfig;
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        C12238m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        WidgetSettingsLanguageSelect.INSTANCE.registerForResult(this, new C93641());
        WidgetChannelSelector.Companion companion = WidgetChannelSelector.INSTANCE;
        WidgetChannelSelector.Companion.registerForResult$default(companion, this, REQUEST_KEY_RULES_CHANNEL, false, new C93652(), 4, null);
        WidgetChannelSelector.Companion.registerForResult$default(companion, this, REQUEST_KEY_UPDATES_CHANNEL, false, new C93663(), 4, null);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        AppFragment.setActionBarDisplayHomeAsUpEnabled$default(this, false, 1, null);
        setActionBarTitle(C5419R.string.guild_settings_community);
        Observable<WidgetServerSettingsCommunityOverviewViewModel.ViewState> observableM11112r = getViewModel().observeViewState().m11112r();
        C12238m.checkNotNullExpressionValue(observableM11112r, "viewModel\n        .obser…  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.bindToComponentLifecycle$default(observableM11112r, this, null, 2, null), (Class<?>) WidgetServerSettingsCommunityOverview.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C93671(this));
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeEvents(), this, null, 2, null), (Class<?>) WidgetServerSettingsCommunityOverview.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C93682());
    }
}
