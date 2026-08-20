package com.discord.widgets.hubs;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.C5419R;
import com.discord.api.directory.DirectoryEntryGuild;
import com.discord.app.AppFragment;
import com.discord.app.LoggingConfig;
import com.discord.databinding.WidgetHubAddServerBinding;
import com.discord.models.guild.Guild;
import com.discord.utilities.directories.DirectoryUtils;
import com.discord.utilities.error.Error;
import com.discord.utilities.hubs.HubUtilsKt;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.utilities.views.SimpleRecyclerAdapter;
import com.discord.views.segmentedcontrol.SegmentedControlContainer;
import com.discord.widgets.guilds.create.CreateGuildTrigger;
import com.discord.widgets.guilds.create.WidgetGuildCreate;
import com.discord.widgets.nux.GuildCreateArgs;
import com.discord.widgets.nux.GuildTemplateAnalytics;
import com.discord.widgets.nux.GuildTemplateArgs;
import com.discord.widgets.nux.GuildTemplateTypes;
import com.discord.widgets.nux.WidgetHubGuildTemplates;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p007b.p008a.p018d.C0863f0;
import p007b.p008a.p018d.C0870j;
import p007b.p008a.p027k.C1107b;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12216a0;
import p507d0.p592z.p594d.C12238m;
import p658rx.Subscription;

/* JADX INFO: compiled from: WidgetHubAddServer.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetHubAddServer extends AppFragment {
    private static final int CHOOSE_GUILD = 0;
    private static final int GUILDS_ADDED = 1;
    private final SimpleRecyclerAdapter<Guild, DiscordHubAddServerViewHolder> adapter;

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private final ActivityResultLauncher<Intent> launcher;
    private final LoggingConfig loggingConfig;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {C1643a.m846d0(WidgetHubAddServer.class, "binding", "getBinding()Lcom/discord/databinding/WidgetHubAddServerBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: compiled from: WidgetHubAddServer.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void startScreenForResult(AppFragment fragment) {
            C12238m.checkNotNullParameter(fragment, "fragment");
            C0870j.f524g.m160f(fragment.requireContext(), HubUtilsKt.getAddServerActivityResultHandler(fragment), WidgetHubAddServer.class, null);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.hubs.WidgetHubAddServer$onServerClickListener$1 */
    /* JADX INFO: compiled from: WidgetHubAddServer.kt */
    public static final class C89951 extends AbstractC12240o implements Function1<HubAddServerState, Unit> {
        public final /* synthetic */ long $channelId;
        public final /* synthetic */ Context $context;
        public final /* synthetic */ long $guildId;
        public final /* synthetic */ boolean $isNewGuild;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C89951(long j, Context context, long j2, boolean z2) {
            super(1);
            this.$guildId = j;
            this.$context = context;
            this.$channelId = j2;
            this.$isNewGuild = z2;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(HubAddServerState hubAddServerState) {
            invoke2(hubAddServerState);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(HubAddServerState hubAddServerState) {
            Object next;
            C12238m.checkNotNullParameter(hubAddServerState, "state");
            Iterator<T> it = hubAddServerState.getAddedDirectories().iterator();
            do {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
            } while (!(((DirectoryEntryGuild) next).getGuild().getId() == this.$guildId));
            DirectoryEntryGuild directoryEntryGuild = (DirectoryEntryGuild) next;
            if (directoryEntryGuild != null) {
                DirectoryUtils.INSTANCE.showServerOptions(WidgetHubAddServer.this, directoryEntryGuild, hubAddServerState.getHubName(), true, new C8996xbc797919(directoryEntryGuild, this, hubAddServerState));
            } else {
                WidgetHubAddServer widgetHubAddServer = WidgetHubAddServer.this;
                C0870j.m158g(C0870j.f524g, widgetHubAddServer.getParentFragmentManager(), this.$context, WidgetHubDescription.class, 0, true, null, new HubDescriptionArgs(this.$guildId, this.$channelId, false, widgetHubAddServer.getViewModel().getHubName(), this.$isNewGuild, null, null, 96, null), 40);
            }
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.hubs.WidgetHubAddServer$onViewBoundOrOnResume$1 */
    /* JADX INFO: compiled from: WidgetHubAddServer.kt */
    public static final class C89971 extends AbstractC12240o implements Function1<HubAddServerState, Unit> {
        public C89971() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(HubAddServerState hubAddServerState) {
            invoke2(hubAddServerState);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(HubAddServerState hubAddServerState) {
            C12238m.checkNotNullParameter(hubAddServerState, "viewState");
            WidgetHubAddServer.this.configureUI(hubAddServerState);
        }
    }

    public WidgetHubAddServer() {
        super(C5419R.layout.widget_hub_add_server);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetHubAddServer$binding$2.INSTANCE, null, 2, null);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, C12216a0.getOrCreateKotlinClass(WidgetHubAddServerViewModel.class), new C8992x73308f52(this), new C0863f0(WidgetHubAddServer$viewModel$2.INSTANCE));
        this.adapter = new SimpleRecyclerAdapter<>(null, new WidgetHubAddServer$adapter$1(this), 1, null);
        ActivityResultLauncher<Intent> activityResultLauncherRegisterForActivityResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() { // from class: com.discord.widgets.hubs.WidgetHubAddServer$launcher$1
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(ActivityResult activityResult) {
                WidgetGuildCreate.Result result;
                C12238m.checkNotNullExpressionValue(activityResult, "activityResult");
                Intent data = activityResult.getData();
                if (data != null) {
                    if (!(activityResult.getResultCode() == -1)) {
                        data = null;
                    }
                    if (data == null || (result = (WidgetGuildCreate.Result) data.getParcelableExtra("intent_args_key")) == null) {
                        return;
                    }
                    this.this$0.onServerClickListener(result.getGuildId(), true);
                }
            }
        });
        C12238m.checkNotNullExpressionValue(activityResultLauncherRegisterForActivityResult, "registerForActivityResul… isNewGuild = true) }\n  }");
        this.launcher = activityResultLauncherRegisterForActivityResult;
        this.loggingConfig = new LoggingConfig(false, null, WidgetHubAddServer$loggingConfig$1.INSTANCE, 3);
    }

    private final void configureUI(final HubAddServerState state) {
        List<Guild> selectableGuilds;
        SimpleRecyclerAdapter<Guild, DiscordHubAddServerViewHolder> simpleRecyclerAdapter = this.adapter;
        int selectedIndex = state.getSelectedIndex();
        if (selectedIndex == 0) {
            selectableGuilds = state.getSelectableGuilds();
        } else if (selectedIndex != 1) {
            return;
        } else {
            selectableGuilds = state.getAddedGuilds();
        }
        simpleRecyclerAdapter.setData(selectableGuilds);
        getBinding().f17148e.setSelectedIndex(state.getSelectedIndex());
        getBinding().f17146c.setTitle(C1107b.m213e(this, C5419R.string.hub_choose_guild_title, new Object[]{state.getHubName()}, (4 & 4) != 0 ? C1107b.a.f1490j : null));
        getBinding().f17145b.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.hubs.WidgetHubAddServer.configureUI.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Context context = WidgetHubAddServer.this.getContext();
                if (context != null) {
                    C12238m.checkNotNullExpressionValue(context, "context ?: return@setOnClickListener");
                    C0870j c0870j = C0870j.f524g;
                    ActivityResultLauncher<Intent> activityResultLauncher = WidgetHubAddServer.this.launcher;
                    CreateGuildTrigger createGuildTrigger = CreateGuildTrigger.DIRECTORY_CHANNEL;
                    String string = C1107b.m216h(context, C5419R.string.hub_create_or_add_guild_title, new Object[]{state.getHubName()}, null, 4).toString();
                    String string2 = context.getString(C5419R.string.hub_create_or_add_guild_subtitle);
                    C12238m.checkNotNullExpressionValue(string2, "context.getString(R.stri…te_or_add_guild_subtitle)");
                    c0870j.m160f(context, activityResultLauncher, WidgetHubGuildTemplates.class, new GuildCreateArgs(false, GuildTemplateAnalytics.IN_APP_LOCATION_TEMPLATE, createGuildTrigger, new GuildTemplateArgs(string, string2, GuildTemplateTypes.INSTANCE.getHUB(), false, true), true));
                }
            }
        });
    }

    private final void onServerClickListener(long guildId, boolean isNewGuild) {
        Context context = getContext();
        if (context != null) {
            C12238m.checkNotNullExpressionValue(context, "context ?: return");
            Long channelId = getViewModel().getChannelId();
            if (channelId != null) {
                getViewModel().withViewState(new C89951(guildId, context, channelId.longValue(), isNewGuild));
            }
        }
    }

    public static /* synthetic */ void onServerClickListener$default(WidgetHubAddServer widgetHubAddServer, long j, boolean z2, int i, Object obj) {
        if ((i & 2) != 0) {
            z2 = false;
        }
        widgetHubAddServer.onServerClickListener(j, z2);
    }

    public final SimpleRecyclerAdapter<Guild, DiscordHubAddServerViewHolder> getAdapter() {
        return this.adapter;
    }

    public final WidgetHubAddServerBinding getBinding() {
        return (WidgetHubAddServerBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    @Override // com.discord.app.AppFragment, com.discord.app.AppLogger.InterfaceC5455a
    public LoggingConfig getLoggingConfig() {
        return this.loggingConfig;
    }

    public final WidgetHubAddServerViewModel getViewModel() {
        return (WidgetHubAddServerViewModel) this.viewModel.getValue();
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        C12238m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        RecyclerView recyclerView = getBinding().f17147d;
        recyclerView.setAdapter(this.adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
        getBinding().f17150g.setText(getString(C5419R.string.hub_choose_guild_choose_tab));
        getBinding().f17149f.setText(getString(C5419R.string.hub_choose_guild_added_tab));
        SegmentedControlContainer segmentedControlContainer = getBinding().f17148e;
        SegmentedControlContainer.m8606b(segmentedControlContainer, 0, 1);
        segmentedControlContainer.setOnSegmentSelectedChangeListener(new WidgetHubAddServer$onViewBound$$inlined$apply$lambda$1(this));
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), (Class<?>) WidgetHubAddServer.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C89971());
    }
}
