package com.discord.widgets.directories;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.activity.result.ActivityResultLauncher;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.viewpager2.widget.ViewPager2;
import com.discord.C5419R;
import com.discord.api.channel.Channel;
import com.discord.api.directory.DirectoryEntryGuild;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetDirectoryChannelBinding;
import com.discord.models.guild.Guild;
import com.discord.models.hubs.DirectoryEntryCategory;
import com.discord.models.member.GuildMember;
import com.discord.stores.StoreStream;
import com.discord.utilities.dimen.DimenUtils;
import com.discord.utilities.error.Error;
import com.discord.utilities.features.GrowthTeamFeatures;
import com.discord.utilities.hubs.HubUtilsKt;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.view.recycler.ViewPager2ExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.views.directories.ServerDiscoveryHeader;
import com.discord.widgets.directories.WidgetDirectoriesViewModel;
import com.discord.widgets.guilds.invite.WidgetGuildInviteShare;
import com.discord.widgets.hubs.HubAddNameArgs;
import com.discord.widgets.hubs.WidgetHubAddName;
import com.discord.widgets.hubs.WidgetHubAddServer;
import com.google.android.material.tabs.TabLayout;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p007b.p008a.p018d.C0863f0;
import p007b.p008a.p018d.C0870j;
import p007b.p008a.p025i.C0941d5;
import p007b.p008a.p027k.C1107b;
import p007b.p008a.p039o.ViewOnLayoutChangeListenerC1175b;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.C12083g;
import p507d0.p579g0.C12103t;
import p507d0.p580t.C12149o;
import p507d0.p580t.C12163u;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12216a0;
import p507d0.p592z.p594d.C12238m;
import p637j0.p641k.InterfaceC12589b;
import p658rx.Observable;
import p658rx.Subscription;

/* JADX INFO: compiled from: WidgetDirectoryChannel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetDirectoryChannel extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {C1643a.m846d0(WidgetDirectoryChannel.class, "binding", "getBinding()Lcom/discord/databinding/WidgetDirectoryChannelBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final int TAB_LAYOUT_MARGINS = DimenUtils.dpToPixels(48);
    private final ActivityResultLauncher<Intent> activityResult;

    /* JADX INFO: renamed from: adapter$delegate, reason: from kotlin metadata */
    private final Lazy adapter;

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private boolean hasBound;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* JADX INFO: compiled from: WidgetDirectoryChannel.kt */
    public static final class Companion {
        private Companion() {
        }

        public final int getTAB_LAYOUT_MARGINS() {
            return WidgetDirectoryChannel.TAB_LAYOUT_MARGINS;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.directories.WidgetDirectoryChannel$initializeUI$5 */
    /* JADX INFO: compiled from: WidgetDirectoryChannel.kt */
    public static final class C82955 extends AbstractC12240o implements Function1<Long, Unit> {
        public C82955() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Long l) {
            invoke(l.longValue());
            return Unit.f27425a;
        }

        public final void invoke(long j) {
            Guild guild;
            Context context;
            StoreStream.Companion companion = StoreStream.INSTANCE;
            long selectedGuildId = companion.getGuildSelected().getSelectedGuildId();
            GuildMember member = companion.getGuilds().getMember(selectedGuildId, companion.getUsers().getMeSnapshot().getId());
            if (member == null || (guild = companion.getGuilds().getGuild(selectedGuildId)) == null || (context = WidgetDirectoryChannel.this.getContext()) == null) {
                return;
            }
            C12238m.checkNotNullExpressionValue(context, "context ?: return@appSubscribe");
            if (WidgetDirectoryChannel.this.isVisible() && selectedGuildId == j && guild.isHub()) {
                String nick = member.getNick();
                if (!(nick == null || C12103t.isBlank(nick)) || companion.getDirectories().getAndSetSeenNamePrompt(selectedGuildId) || GrowthTeamFeatures.INSTANCE.isHubNameKillSwitchEnabled()) {
                    return;
                }
                C0870j.m156d(context, WidgetHubAddName.class, new HubAddNameArgs(guild.getId()));
            }
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.directories.WidgetDirectoryChannel$onViewBoundOrOnResume$2 */
    /* JADX INFO: compiled from: WidgetDirectoryChannel.kt */
    public static final class C82972 extends AbstractC12240o implements Function1<WidgetDirectoriesViewModel.ViewState, Unit> {
        public C82972() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetDirectoriesViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetDirectoriesViewModel.ViewState viewState) {
            WidgetDirectoryChannel.this.initializeUI();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.directories.WidgetDirectoryChannel$onViewBoundOrOnResume$4 */
    /* JADX INFO: compiled from: WidgetDirectoryChannel.kt */
    public static final class C82994 extends AbstractC12240o implements Function1<WidgetDirectoriesViewModel.ViewState, Unit> {
        public C82994() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetDirectoriesViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetDirectoriesViewModel.ViewState viewState) {
            WidgetDirectoryChannel widgetDirectoryChannel = WidgetDirectoryChannel.this;
            C12238m.checkNotNullExpressionValue(viewState, "it");
            widgetDirectoryChannel.configureUi(viewState);
        }
    }

    public WidgetDirectoryChannel() {
        super(C5419R.layout.widget_directory_channel);
        this.binding = FragmentViewBindingDelegateKt.viewBinding(this, WidgetDirectoryChannel$binding$2.INSTANCE, new WidgetDirectoryChannel$binding$3(this));
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, C12216a0.getOrCreateKotlinClass(WidgetDirectoriesViewModel.class), new C8291x2378b3d9(this), new C0863f0(WidgetDirectoryChannel$viewModel$2.INSTANCE));
        this.adapter = C12083g.lazy(new WidgetDirectoryChannel$adapter$2(this));
        this.activityResult = HubUtilsKt.getAddServerActivityResultHandler(this);
    }

    public static /* synthetic */ void bindGestureObservers$default(WidgetDirectoryChannel widgetDirectoryChannel, boolean z2, WidgetDirectoryChannelBinding widgetDirectoryChannelBinding, int i, Object obj) {
        if ((i & 2) != 0) {
            widgetDirectoryChannelBinding = null;
        }
        widgetDirectoryChannel.bindGestureObservers(z2, widgetDirectoryChannelBinding);
    }

    private final void configureUi(final WidgetDirectoriesViewModel.ViewState state) {
        final Guild guild = state.getGuild();
        if (guild != null) {
            getBinding().f16466f.f791d.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.directories.WidgetDirectoryChannel$configureUi$$inlined$let$lambda$1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    WidgetGuildInviteShare.Companion companion = WidgetGuildInviteShare.INSTANCE;
                    Context contextM885x = C1643a.m885x(view, "it", "it.context");
                    FragmentManager childFragmentManager = this.getChildFragmentManager();
                    C12238m.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
                    companion.launch(contextM885x, childFragmentManager, guild.getId(), (16 & 8) != 0 ? null : null, (16 & 16) != 0 ? false : false, (16 & 32) != 0 ? null : null, (16 & 64) != 0 ? null : null, "Guild Header");
                }
            });
            TextView textView = getBinding().f16466f.f789b;
            C12238m.checkNotNullExpressionValue(textView, "binding.widgetDirectoryC….itemDirectoryEmptyHeader");
            textView.setText(C1107b.m213e(this, C5419R.string.hub_directory_channel_empty_title, new Object[]{guild.getName()}, (4 & 4) != 0 ? C1107b.a.f1490j : null));
        }
        final ServerDiscoveryHeader serverDiscoveryHeader = getBinding().f16463c;
        serverDiscoveryHeader.setButtonOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.directories.WidgetDirectoryChannel$configureUi$$inlined$apply$lambda$1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Channel channel = state.getChannel();
                if (channel != null) {
                    long id2 = channel.getId();
                    Context context = serverDiscoveryHeader.getContext();
                    C12238m.checkNotNullExpressionValue(context, "context");
                    C0870j.m156d(context, WidgetDirectoriesSearch.class, new DirectoriesSearchArgs(id2));
                }
            }
        });
        List<DirectoryEntryGuild> listInvoke = state.getDirectories().invoke();
        boolean z2 = listInvoke != null && (listInvoke.isEmpty() ^ true);
        ServerDiscoveryHeader serverDiscoveryHeader2 = getBinding().f16463c;
        C12238m.checkNotNullExpressionValue(serverDiscoveryHeader2, "binding.header");
        serverDiscoveryHeader2.setVisibility(z2 ? 0 : 8);
        ViewPager2 viewPager2 = getBinding().f16465e;
        C12238m.checkNotNullExpressionValue(viewPager2, "binding.viewPager");
        viewPager2.setVisibility(z2 ? 0 : 8);
        C0941d5 c0941d5 = getBinding().f16466f;
        C12238m.checkNotNullExpressionValue(c0941d5, "binding.widgetDirectoryChannelEmpty");
        LinearLayout linearLayout = c0941d5.f788a;
        C12238m.checkNotNullExpressionValue(linearLayout, "binding.widgetDirectoryChannelEmpty.root");
        linearLayout.setVisibility(z2 ^ true ? 0 : 8);
        Map<Integer, Integer> mapInvoke = state.getTabs().invoke();
        boolean z3 = !(mapInvoke == null || mapInvoke.isEmpty());
        toggleHeaderMargins(z3);
        TabLayout tabLayout = getBinding().f16464d;
        C12238m.checkNotNullExpressionValue(tabLayout, "binding.tabs");
        tabLayout.setVisibility(z3 ? 0 : 8);
        WidgetDirectoryChannelViewPagerAdapter adapter = getAdapter();
        List<Pair<DirectoryEntryCategory, Integer>> mappedTabs = state.getMappedTabs();
        ArrayList arrayList = new ArrayList(C12149o.collectionSizeOrDefault(mappedTabs, 10));
        Iterator<T> it = mappedTabs.iterator();
        while (it.hasNext()) {
            arrayList.add((DirectoryEntryCategory) ((Pair) it.next()).getFirst());
        }
        adapter.setTabs(C12163u.toList(arrayList));
    }

    private final void onViewBindingDestroy(WidgetDirectoryChannelBinding binding) {
        bindGestureObservers(false, binding);
    }

    private final void toggleHeaderMargins(boolean showTabLayout) {
        int i = showTabLayout ? TAB_LAYOUT_MARGINS : 0;
        ServerDiscoveryHeader serverDiscoveryHeader = getBinding().f16463c;
        C12238m.checkNotNullExpressionValue(serverDiscoveryHeader, "binding.header");
        ViewGroup.LayoutParams layoutParams = serverDiscoveryHeader.getLayoutParams();
        Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        marginLayoutParams.bottomMargin = i;
        serverDiscoveryHeader.setLayoutParams(marginLayoutParams);
        Toolbar toolbar = getBinding().f16462b;
        C12238m.checkNotNullExpressionValue(toolbar, "binding.actionBarToolbar");
        ViewGroup.LayoutParams layoutParams2 = toolbar.getLayoutParams();
        Objects.requireNonNull(layoutParams2, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) layoutParams2;
        marginLayoutParams2.bottomMargin = i;
        toolbar.setLayoutParams(marginLayoutParams2);
    }

    public final void bindGestureObservers(boolean bind, WidgetDirectoryChannelBinding binding) {
        if (binding == null) {
            binding = getBinding();
        }
        if (!this.hasBound && bind) {
            ViewOnLayoutChangeListenerC1175b viewOnLayoutChangeListenerC1175bM232a = ViewOnLayoutChangeListenerC1175b.b.m232a();
            TabLayout tabLayout = binding.f16464d;
            C12238m.checkNotNullExpressionValue(tabLayout, "nonNullBinding.tabs");
            viewOnLayoutChangeListenerC1175bM232a.m230b(tabLayout);
            ViewOnLayoutChangeListenerC1175b viewOnLayoutChangeListenerC1175bM232a2 = ViewOnLayoutChangeListenerC1175b.b.m232a();
            ViewPager2 viewPager2 = binding.f16465e;
            C12238m.checkNotNullExpressionValue(viewPager2, "nonNullBinding.viewPager");
            viewOnLayoutChangeListenerC1175bM232a2.m230b(viewPager2);
            this.hasBound = true;
            return;
        }
        if (bind) {
            return;
        }
        ViewOnLayoutChangeListenerC1175b viewOnLayoutChangeListenerC1175bM232a3 = ViewOnLayoutChangeListenerC1175b.b.m232a();
        TabLayout tabLayout2 = binding.f16464d;
        C12238m.checkNotNullExpressionValue(tabLayout2, "nonNullBinding.tabs");
        viewOnLayoutChangeListenerC1175bM232a3.m231c(tabLayout2);
        ViewOnLayoutChangeListenerC1175b viewOnLayoutChangeListenerC1175bM232a4 = ViewOnLayoutChangeListenerC1175b.b.m232a();
        ViewPager2 viewPager3 = binding.f16465e;
        C12238m.checkNotNullExpressionValue(viewPager3, "nonNullBinding.viewPager");
        viewOnLayoutChangeListenerC1175bM232a4.m231c(viewPager3);
        this.hasBound = false;
    }

    public final WidgetDirectoryChannelViewPagerAdapter getAdapter() {
        return (WidgetDirectoryChannelViewPagerAdapter) this.adapter.getValue();
    }

    public final WidgetDirectoryChannelBinding getBinding() {
        return (WidgetDirectoryChannelBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    public final WidgetDirectoriesViewModel getViewModel() {
        return (WidgetDirectoriesViewModel) this.viewModel.getValue();
    }

    @SuppressLint({"SetTextI18n"})
    public final void initializeUI() {
        getBinding().f16466f.f790c.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.directories.WidgetDirectoryChannel.initializeUI.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C0870j.f524g.m160f(WidgetDirectoryChannel.this.requireContext(), WidgetDirectoryChannel.this.activityResult, WidgetHubAddServer.class, null);
            }
        });
        ServerDiscoveryHeader serverDiscoveryHeader = getBinding().f16463c;
        serverDiscoveryHeader.setTitle(getString(C5419R.string.hub_directory_search_title));
        serverDiscoveryHeader.setDescription(getString(C5419R.string.hub_directory_search_subtitle));
        getBinding().f16465e.setAdapter(getAdapter());
        TabLayout tabLayout = getBinding().f16464d;
        ViewPager2 viewPager2 = getBinding().f16465e;
        C12238m.checkNotNullExpressionValue(viewPager2, "binding.viewPager");
        ViewPager2ExtensionsKt.setUpWithViewPager2(tabLayout, viewPager2, new WidgetDirectoryChannel$initializeUI$$inlined$apply$lambda$1(tabLayout, this));
        bindGestureObservers$default(this, true, null, 2, null);
        Observable<Long> observableM11112r = StoreStream.INSTANCE.getGuildSelected().observeSelectedGuildId().m11112r();
        C12238m.checkNotNullExpressionValue(observableM11112r, "StoreStream\n        .get…  .distinctUntilChanged()");
        Observable<R> observableM11083G = observableM11112r.m11118y(ObservableExtensionsKt.C68871.INSTANCE).m11083G(ObservableExtensionsKt.C68882.INSTANCE);
        C12238m.checkNotNullExpressionValue(observableM11083G, "filter { it != null }.map { it!! }");
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.m8518ui(observableM11083G), (Class<?>) WidgetDirectoryChannel.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C82955());
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        Observable<WidgetDirectoriesViewModel.ViewState> observableM11119z = getViewModel().observeViewState().m11118y(new InterfaceC12589b<WidgetDirectoriesViewModel.ViewState, Boolean>() { // from class: com.discord.widgets.directories.WidgetDirectoryChannel.onViewBoundOrOnResume.1
            @Override // p637j0.p641k.InterfaceC12589b
            public final Boolean call(WidgetDirectoriesViewModel.ViewState viewState) {
                return Boolean.valueOf(viewState != null);
            }
        }).m11119z();
        C12238m.checkNotNullExpressionValue(observableM11119z, "viewModel\n        .obser…= null }\n        .first()");
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.bindToComponentLifecycle$default(observableM11119z, this, null, 2, null), (Class<?>) WidgetDirectoryChannel.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C82972());
        Observable<WidgetDirectoriesViewModel.ViewState> observableM11118y = getViewModel().observeViewState().m11118y(new InterfaceC12589b<WidgetDirectoriesViewModel.ViewState, Boolean>() { // from class: com.discord.widgets.directories.WidgetDirectoryChannel.onViewBoundOrOnResume.3
            @Override // p637j0.p641k.InterfaceC12589b
            public final Boolean call(WidgetDirectoriesViewModel.ViewState viewState) {
                return Boolean.valueOf(viewState != null);
            }
        });
        C12238m.checkNotNullExpressionValue(observableM11118y, "viewModel\n        .obser…   .filter { it != null }");
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.bindToComponentLifecycle$default(observableM11118y, this, null, 2, null), (Class<?>) WidgetDirectoryChannel.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C82994());
    }
}
