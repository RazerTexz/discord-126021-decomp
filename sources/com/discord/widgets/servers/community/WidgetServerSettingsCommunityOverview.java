package com.discord.widgets.servers.community;

import android.content.Context;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import b.a.d.f0;
import b.d.b.a.a;
import com.discord.R$layout;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.app.AppFragment;
import com.discord.app.LoggingConfig;
import com.discord.databinding.WidgetServerSettingsCommunityOverviewBinding;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.widgets.channels.WidgetChannelSelector;
import com.discord.widgets.channels.WidgetChannelSelector$Companion;
import com.discord.widgets.settings.WidgetSettingsLanguage;
import com.discord.widgets.settings.WidgetSettingsLanguageSelect;
import d0.g;
import d0.z.d.a0;
import d0.z.d.m;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;
import rx.Observable;

/* JADX INFO: compiled from: WidgetServerSettingsCommunityOverview.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsCommunityOverview extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetServerSettingsCommunityOverview.class, "binding", "getBinding()Lcom/discord/databinding/WidgetServerSettingsCommunityOverviewBinding;", 0)};
    public static final WidgetServerSettingsCommunityOverview$Companion Companion = new WidgetServerSettingsCommunityOverview$Companion(null);
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

    public WidgetServerSettingsCommunityOverview() {
        super(R$layout.widget_server_settings_community_overview);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetServerSettingsCommunityOverview$binding$2.INSTANCE, null, 2, null);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, a0.getOrCreateKotlinClass(WidgetServerSettingsCommunityOverviewViewModel.class), new WidgetServerSettingsCommunityOverview$appActivityViewModels$$inlined$activityViewModels$1(this), new f0(new WidgetServerSettingsCommunityOverview$viewModel$2(this)));
        this.guildId = g.lazy(new WidgetServerSettingsCommunityOverview$guildId$2(this));
        this.loggingConfig = new LoggingConfig(false, null, WidgetServerSettingsCommunityOverview$loggingConfig$1.INSTANCE, 3);
    }

    public static final /* synthetic */ void access$configureUI(WidgetServerSettingsCommunityOverview widgetServerSettingsCommunityOverview, WidgetServerSettingsCommunityOverviewViewModel$ViewState widgetServerSettingsCommunityOverviewViewModel$ViewState) {
        widgetServerSettingsCommunityOverview.configureUI(widgetServerSettingsCommunityOverviewViewModel$ViewState);
    }

    public static final /* synthetic */ WidgetServerSettingsCommunityOverviewViewModel access$getViewModel$p(WidgetServerSettingsCommunityOverview widgetServerSettingsCommunityOverview) {
        return widgetServerSettingsCommunityOverview.getViewModel();
    }

    private final void configureUI(WidgetServerSettingsCommunityOverviewViewModel$ViewState viewState) {
        if (m.areEqual(viewState, WidgetServerSettingsCommunityOverviewViewModel$ViewState$Invalid.INSTANCE)) {
            requireActivity().finish();
        } else if (viewState instanceof WidgetServerSettingsCommunityOverviewViewModel$ViewState$Loaded) {
            configureValidUI((WidgetServerSettingsCommunityOverviewViewModel$ViewState$Loaded) viewState);
        } else if (viewState instanceof WidgetServerSettingsCommunityOverviewViewModel$ViewState$DisableCommunityLoading) {
            getBinding().e.setIsLoading(((WidgetServerSettingsCommunityOverviewViewModel$ViewState$DisableCommunityLoading) viewState).isLoading());
        }
    }

    private final void configureValidUI(WidgetServerSettingsCommunityOverviewViewModel$ViewState$Loaded viewState) {
        String strE;
        getBinding().e.setIsLoading(false);
        String string = viewState.getRulesChannel() == null ? requireContext().getString(2131891377) : ChannelUtils.e(viewState.getRulesChannel(), requireContext(), false, 2);
        m.checkNotNullExpressionValue(string, "when (viewState.rulesCha…t(requireContext())\n    }");
        if (viewState.getUpdatesChannel() == null) {
            strE = requireContext().getString(2131891377);
        } else {
            Channel updatesChannel = viewState.getUpdatesChannel();
            FragmentActivity fragmentActivityRequireActivity = requireActivity();
            m.checkNotNullExpressionValue(fragmentActivityRequireActivity, "requireActivity()");
            strE = ChannelUtils.e(updatesChannel, fragmentActivityRequireActivity, false, 2);
        }
        m.checkNotNullExpressionValue(strE, "when (viewState.updatesC…(requireActivity())\n    }");
        getBinding().f2553b.setSubtitle(string);
        getBinding().c.setSubtitle(strE);
        getBinding().d.setSubtitle(WidgetSettingsLanguage.Companion.getAsStringInLocale(viewState.getGuild().getPreferredLocale()));
        getBinding().f2553b.setOnClickListener(new WidgetServerSettingsCommunityOverview$configureValidUI$1(this, viewState));
        getBinding().c.setOnClickListener(new WidgetServerSettingsCommunityOverview$configureValidUI$2(this, viewState));
        getBinding().d.setOnClickListener(new WidgetServerSettingsCommunityOverview$configureValidUI$3(this));
        getBinding().e.setOnClickListener(new WidgetServerSettingsCommunityOverview$configureValidUI$4(this, viewState));
    }

    public static final void create(Context context, long j) {
        Companion.create(context, j);
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

    @Override // com.discord.app.AppFragment, com.discord.app.AppLogger$a
    public LoggingConfig getLoggingConfig() {
        return this.loggingConfig;
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        WidgetSettingsLanguageSelect.Companion.registerForResult(this, new WidgetServerSettingsCommunityOverview$onViewBound$1(this));
        WidgetChannelSelector$Companion widgetChannelSelector$Companion = WidgetChannelSelector.Companion;
        WidgetChannelSelector$Companion.registerForResult$default(widgetChannelSelector$Companion, this, REQUEST_KEY_RULES_CHANNEL, false, new WidgetServerSettingsCommunityOverview$onViewBound$2(this), 4, null);
        WidgetChannelSelector$Companion.registerForResult$default(widgetChannelSelector$Companion, this, REQUEST_KEY_UPDATES_CHANNEL, false, new WidgetServerSettingsCommunityOverview$onViewBound$3(this), 4, null);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        AppFragment.setActionBarDisplayHomeAsUpEnabled$default(this, false, 1, null);
        setActionBarTitle(2131891054);
        Observable<WidgetServerSettingsCommunityOverviewViewModel$ViewState> observableR = getViewModel().observeViewState().r();
        m.checkNotNullExpressionValue(observableR, "viewModel\n        .obser…  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(observableR, this, null, 2, null), WidgetServerSettingsCommunityOverview.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetServerSettingsCommunityOverview$onViewBoundOrOnResume$1(this), 62, (Object) null);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeEvents(), this, null, 2, null), WidgetServerSettingsCommunityOverview.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetServerSettingsCommunityOverview$onViewBoundOrOnResume$2(this), 62, (Object) null);
    }
}
