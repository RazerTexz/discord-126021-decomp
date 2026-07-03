package com.discord.widgets.servers.community;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import com.discord.C5419R;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetServerSettingsCommunitySetupSecondStepBinding;
import com.discord.stores.StoreStream;
import com.discord.utilities.error.Error;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.widgets.channels.WidgetChannelSelector;
import com.discord.widgets.servers.community.WidgetServerSettingsEnableCommunityViewModel;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p007b.p008a.p018d.C0863f0;
import p007b.p008a.p018d.C0870j;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12216a0;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;
import p637j0.p641k.InterfaceC12589b;
import p658rx.Observable;
import p658rx.Subscription;

/* JADX INFO: compiled from: WidgetServerSettingsCommunitySecondStep.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsCommunitySecondStep extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {C1643a.m846d0(WidgetServerSettingsCommunitySecondStep.class, "binding", "getBinding()Lcom/discord/databinding/WidgetServerSettingsCommunitySetupSecondStepBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String REQUEST_KEY_RULES_CHANNEL = "REQUEST_KEY_RULES_CHANNEL";
    private static final String REQUEST_KEY_UPDATES_CHANNEL = "REQUEST_KEY_UPDATES_CHANNEL";

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* JADX INFO: compiled from: WidgetServerSettingsCommunitySecondStep.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void create(Context context) {
            C12238m.checkNotNullParameter(context, "context");
            C0870j.m156d(context, WidgetServerSettingsCommunitySecondStep.class, new Intent());
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.servers.community.WidgetServerSettingsCommunitySecondStep$onViewBound$1 */
    /* JADX INFO: compiled from: WidgetServerSettingsCommunitySecondStep.kt */
    public static final class C93771 extends AbstractC12240o implements Function2<Long, String, Unit> {

        /* JADX INFO: renamed from: com.discord.widgets.servers.community.WidgetServerSettingsCommunitySecondStep$onViewBound$1$1, reason: invalid class name */
        /* JADX INFO: compiled from: WidgetServerSettingsCommunitySecondStep.kt */
        public static final class AnonymousClass1 extends AbstractC12240o implements Function1<WidgetServerSettingsEnableCommunityViewModel.CommunityGuildConfig, WidgetServerSettingsEnableCommunityViewModel.CommunityGuildConfig> {
            public final /* synthetic */ Channel $channel;
            public final /* synthetic */ long $channelId;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(long j, Channel channel) {
                super(1);
                this.$channelId = j;
                this.$channel = channel;
            }

            @Override // kotlin.jvm.functions.Function1
            public final WidgetServerSettingsEnableCommunityViewModel.CommunityGuildConfig invoke(WidgetServerSettingsEnableCommunityViewModel.CommunityGuildConfig communityGuildConfig) {
                C12238m.checkNotNullParameter(communityGuildConfig, "guildConfig");
                return communityGuildConfig.copy((4031 & 1) != 0 ? communityGuildConfig.rulesChannel : this.$channel, (4031 & 2) != 0 ? communityGuildConfig.updatesChannel : null, (4031 & 4) != 0 ? communityGuildConfig.rulesChannelId : Long.valueOf(this.$channelId), (4031 & 8) != 0 ? communityGuildConfig.updatesChannelId : null, (4031 & 16) != 0 ? communityGuildConfig.isPrivacyPolicyAccepted : false, (4031 & 32) != 0 ? communityGuildConfig.defaultMessageNotifications : false, (4031 & 64) != 0 ? communityGuildConfig.verificationLevel : false, (4031 & 128) != 0 ? communityGuildConfig.explicitContentFilter : false, (4031 & 256) != 0 ? communityGuildConfig.guild : null, (4031 & 512) != 0 ? communityGuildConfig.everyonePermissions : false, (4031 & 1024) != 0 ? communityGuildConfig.features : null, (4031 & 2048) != 0 ? communityGuildConfig.roles : null);
            }
        }

        public C93771() {
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Long l, String str) {
            invoke(l.longValue(), str);
            return Unit.f27425a;
        }

        public final void invoke(long j, String str) {
            C12238m.checkNotNullParameter(str, "<anonymous parameter 1>");
            WidgetServerSettingsCommunitySecondStep.this.getViewModel().modifyGuildConfig(new AnonymousClass1(j, StoreStream.INSTANCE.getChannels().getChannel(j)));
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.servers.community.WidgetServerSettingsCommunitySecondStep$onViewBound$2 */
    /* JADX INFO: compiled from: WidgetServerSettingsCommunitySecondStep.kt */
    public static final class C93782 extends AbstractC12240o implements Function2<Long, String, Unit> {

        /* JADX INFO: renamed from: com.discord.widgets.servers.community.WidgetServerSettingsCommunitySecondStep$onViewBound$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: WidgetServerSettingsCommunitySecondStep.kt */
        public static final class AnonymousClass1 extends AbstractC12240o implements Function1<WidgetServerSettingsEnableCommunityViewModel.CommunityGuildConfig, WidgetServerSettingsEnableCommunityViewModel.CommunityGuildConfig> {
            public final /* synthetic */ Channel $channel;
            public final /* synthetic */ long $channelId;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(long j, Channel channel) {
                super(1);
                this.$channelId = j;
                this.$channel = channel;
            }

            @Override // kotlin.jvm.functions.Function1
            public final WidgetServerSettingsEnableCommunityViewModel.CommunityGuildConfig invoke(WidgetServerSettingsEnableCommunityViewModel.CommunityGuildConfig communityGuildConfig) {
                C12238m.checkNotNullParameter(communityGuildConfig, "guildConfig");
                return communityGuildConfig.copy((4031 & 1) != 0 ? communityGuildConfig.rulesChannel : null, (4031 & 2) != 0 ? communityGuildConfig.updatesChannel : this.$channel, (4031 & 4) != 0 ? communityGuildConfig.rulesChannelId : null, (4031 & 8) != 0 ? communityGuildConfig.updatesChannelId : Long.valueOf(this.$channelId), (4031 & 16) != 0 ? communityGuildConfig.isPrivacyPolicyAccepted : false, (4031 & 32) != 0 ? communityGuildConfig.defaultMessageNotifications : false, (4031 & 64) != 0 ? communityGuildConfig.verificationLevel : false, (4031 & 128) != 0 ? communityGuildConfig.explicitContentFilter : false, (4031 & 256) != 0 ? communityGuildConfig.guild : null, (4031 & 512) != 0 ? communityGuildConfig.everyonePermissions : false, (4031 & 1024) != 0 ? communityGuildConfig.features : null, (4031 & 2048) != 0 ? communityGuildConfig.roles : null);
            }
        }

        public C93782() {
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Long l, String str) {
            invoke(l.longValue(), str);
            return Unit.f27425a;
        }

        public final void invoke(long j, String str) {
            C12238m.checkNotNullParameter(str, "<anonymous parameter 1>");
            WidgetServerSettingsCommunitySecondStep.this.getViewModel().modifyGuildConfig(new AnonymousClass1(j, StoreStream.INSTANCE.getChannels().getChannel(j)));
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.servers.community.WidgetServerSettingsCommunitySecondStep$onViewBoundOrOnResume$1 */
    /* JADX INFO: compiled from: WidgetServerSettingsCommunitySecondStep.kt */
    public static final /* synthetic */ class C93811 extends C12236k implements Function1<WidgetServerSettingsEnableCommunityViewModel.ViewState.Loaded, Unit> {
        public C93811(WidgetServerSettingsCommunitySecondStep widgetServerSettingsCommunitySecondStep) {
            super(1, widgetServerSettingsCommunitySecondStep, WidgetServerSettingsCommunitySecondStep.class, "configureUI", "configureUI(Lcom/discord/widgets/servers/community/WidgetServerSettingsEnableCommunityViewModel$ViewState$Loaded;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetServerSettingsEnableCommunityViewModel.ViewState.Loaded loaded) {
            invoke2(loaded);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetServerSettingsEnableCommunityViewModel.ViewState.Loaded loaded) {
            C12238m.checkNotNullParameter(loaded, "p1");
            ((WidgetServerSettingsCommunitySecondStep) this.receiver).configureUI(loaded);
        }
    }

    public WidgetServerSettingsCommunitySecondStep() {
        super(C5419R.layout.widget_server_settings_community_setup_second_step);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetServerSettingsCommunitySecondStep$binding$2.INSTANCE, null, 2, null);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, C12216a0.getOrCreateKotlinClass(WidgetServerSettingsEnableCommunityViewModel.class), new C9373x1435c0be(this), new C0863f0(WidgetServerSettingsCommunitySecondStep$viewModel$2.INSTANCE));
    }

    private final void configureUI(WidgetServerSettingsEnableCommunityViewModel.ViewState.Loaded viewState) {
        String string = viewState.getCommunityGuildConfig().getRulesChannel() == null ? requireContext().getString(C5419R.string.enable_public_modal_create_channel) : ChannelUtils.m7681e(viewState.getCommunityGuildConfig().getRulesChannel(), requireContext(), false, 2);
        C12238m.checkNotNullExpressionValue(string, "when (viewState.communit…t(requireContext())\n    }");
        String string2 = viewState.getCommunityGuildConfig().getUpdatesChannel() == null ? requireContext().getString(C5419R.string.enable_public_modal_create_channel) : ChannelUtils.m7681e(viewState.getCommunityGuildConfig().getUpdatesChannel(), requireContext(), false, 2);
        C12238m.checkNotNullExpressionValue(string2, "when (viewState.communit…t(requireContext())\n    }");
        getBinding().f17585b.setSubtitle(string);
        getBinding().f17586c.setSubtitle(string2);
        getBinding().f17585b.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.servers.community.WidgetServerSettingsCommunitySecondStep.configureUI.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetChannelSelector.Companion companion = WidgetChannelSelector.INSTANCE;
                WidgetServerSettingsCommunitySecondStep widgetServerSettingsCommunitySecondStep = WidgetServerSettingsCommunitySecondStep.this;
                companion.launchForText(widgetServerSettingsCommunitySecondStep, widgetServerSettingsCommunitySecondStep.getViewModel().getGuildId(), WidgetServerSettingsCommunitySecondStep.REQUEST_KEY_RULES_CHANNEL, (24 & 8) != 0 ? false : false, (24 & 16) != 0 ? C5419R.string.none : 0);
            }
        });
        getBinding().f17586c.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.servers.community.WidgetServerSettingsCommunitySecondStep.configureUI.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetChannelSelector.Companion companion = WidgetChannelSelector.INSTANCE;
                WidgetServerSettingsCommunitySecondStep widgetServerSettingsCommunitySecondStep = WidgetServerSettingsCommunitySecondStep.this;
                companion.launchForText(widgetServerSettingsCommunitySecondStep, widgetServerSettingsCommunitySecondStep.getViewModel().getGuildId(), WidgetServerSettingsCommunitySecondStep.REQUEST_KEY_UPDATES_CHANNEL, (24 & 8) != 0 ? false : false, (24 & 16) != 0 ? C5419R.string.none : 0);
            }
        });
    }

    public static final void create(Context context) {
        INSTANCE.create(context);
    }

    private final WidgetServerSettingsCommunitySetupSecondStepBinding getBinding() {
        return (WidgetServerSettingsCommunitySetupSecondStepBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final WidgetServerSettingsEnableCommunityViewModel getViewModel() {
        return (WidgetServerSettingsEnableCommunityViewModel) this.viewModel.getValue();
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        C12238m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        WidgetChannelSelector.Companion companion = WidgetChannelSelector.INSTANCE;
        WidgetChannelSelector.Companion.registerForResult$default(companion, this, REQUEST_KEY_RULES_CHANNEL, false, new C93771(), 4, null);
        WidgetChannelSelector.Companion.registerForResult$default(companion, this, REQUEST_KEY_UPDATES_CHANNEL, false, new C93782(), 4, null);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        Observable observableM11083G = ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null).m11118y(new InterfaceC12589b<Object, Boolean>() { // from class: com.discord.widgets.servers.community.WidgetServerSettingsCommunitySecondStep$onViewBoundOrOnResume$$inlined$filterIs$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // p637j0.p641k.InterfaceC12589b
            public final Boolean call(Object obj) {
                return Boolean.valueOf(obj instanceof WidgetServerSettingsEnableCommunityViewModel.ViewState.Loaded);
            }
        }).m11083G(new InterfaceC12589b<Object, T>() { // from class: com.discord.widgets.servers.community.WidgetServerSettingsCommunitySecondStep$onViewBoundOrOnResume$$inlined$filterIs$2
            @Override // p637j0.p641k.InterfaceC12589b
            public final T call(Object obj) {
                Objects.requireNonNull(obj, "null cannot be cast to non-null type com.discord.widgets.servers.community.WidgetServerSettingsEnableCommunityViewModel.ViewState.Loaded");
                return (T) ((WidgetServerSettingsEnableCommunityViewModel.ViewState.Loaded) obj);
            }
        });
        C12238m.checkNotNullExpressionValue(observableM11083G, "filter { it is T }.map { it as T }");
        ObservableExtensionsKt.appSubscribe(observableM11083G, (Class<?>) WidgetServerSettingsCommunitySecondStep.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C93811(this));
    }
}
