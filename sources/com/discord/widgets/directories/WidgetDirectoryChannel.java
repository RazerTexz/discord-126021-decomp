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
import b.a.d.AppScreen2;
import b.a.d.AppViewModelDelegates2;
import b.a.i.WidgetDirectoryChannelEmptyBinding;
import b.a.k.FormatUtils;
import b.a.o.PanelsChildGestureRegionObserver;
import b.d.b.a.outline;
import com.discord.R;
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
import com.discord.utilities.hubs.HubUtils;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.view.recycler.ViewPager2Extensions;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.views.directories.ServerDiscoveryHeader;
import com.discord.widgets.directories.WidgetDirectoriesViewModel;
import com.discord.widgets.guilds.invite.WidgetGuildInviteShare;
import com.discord.widgets.hubs.WidgetHubAddName;
import com.discord.widgets.hubs.WidgetHubAddNameViewModel3;
import com.discord.widgets.hubs.WidgetHubAddServer;
import com.google.android.material.tabs.TabLayout;
import d0.LazyJVM;
import d0.g0.StringsJVM;
import d0.t.Iterables2;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import d0.z.d.Reflection2;
import j0.k.Func1;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.Tuples2;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import rx.Observable;
import rx.Subscription;

/* JADX INFO: compiled from: WidgetDirectoryChannel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetDirectoryChannel extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetDirectoryChannel.class, "binding", "getBinding()Lcom/discord/databinding/WidgetDirectoryChannelBinding;", 0)};

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

    /* JADX INFO: renamed from: com.discord.widgets.directories.WidgetDirectoryChannel$initializeUI$5, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetDirectoryChannel.kt */
    public static final class AnonymousClass5 extends Lambda implements Function1<Long, Unit> {
        public AnonymousClass5() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Long l) {
            invoke(l.longValue());
            return Unit.a;
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
            Intrinsics3.checkNotNullExpressionValue(context, "context ?: return@appSubscribe");
            if (WidgetDirectoryChannel.this.isVisible() && selectedGuildId == j && guild.isHub()) {
                String nick = member.getNick();
                if (!(nick == null || StringsJVM.isBlank(nick)) || companion.getDirectories().getAndSetSeenNamePrompt(selectedGuildId) || GrowthTeamFeatures.INSTANCE.isHubNameKillSwitchEnabled()) {
                    return;
                }
                AppScreen2.d(context, WidgetHubAddName.class, new WidgetHubAddNameViewModel3(guild.getId()));
            }
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.directories.WidgetDirectoryChannel$onViewBoundOrOnResume$2, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetDirectoryChannel.kt */
    public static final class AnonymousClass2 extends Lambda implements Function1<WidgetDirectoriesViewModel.ViewState, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetDirectoriesViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetDirectoriesViewModel.ViewState viewState) {
            WidgetDirectoryChannel.this.initializeUI();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.directories.WidgetDirectoryChannel$onViewBoundOrOnResume$4, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetDirectoryChannel.kt */
    public static final class AnonymousClass4 extends Lambda implements Function1<WidgetDirectoriesViewModel.ViewState, Unit> {
        public AnonymousClass4() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetDirectoriesViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetDirectoriesViewModel.ViewState viewState) {
            WidgetDirectoryChannel widgetDirectoryChannel = WidgetDirectoryChannel.this;
            Intrinsics3.checkNotNullExpressionValue(viewState, "it");
            widgetDirectoryChannel.configureUi(viewState);
        }
    }

    public WidgetDirectoryChannel() {
        super(R.layout.widget_directory_channel);
        this.binding = FragmentViewBindingDelegate3.viewBinding(this, WidgetDirectoryChannel3.INSTANCE, new WidgetDirectoryChannel4(this));
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(WidgetDirectoriesViewModel.class), new WidgetDirectoryChannel$appActivityViewModels$$inlined$activityViewModels$1(this), new AppViewModelDelegates2(WidgetDirectoryChannel8.INSTANCE));
        this.adapter = LazyJVM.lazy(new WidgetDirectoryChannel2(this));
        this.activityResult = HubUtils.getAddServerActivityResultHandler(this);
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
            getBinding().f.d.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.directories.WidgetDirectoryChannel$configureUi$$inlined$let$lambda$1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    WidgetGuildInviteShare.Companion companion = WidgetGuildInviteShare.INSTANCE;
                    Context contextX = outline.x(view, "it", "it.context");
                    FragmentManager childFragmentManager = this.getChildFragmentManager();
                    Intrinsics3.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
                    companion.launch(contextX, childFragmentManager, guild.getId(), (16 & 8) != 0 ? null : null, (16 & 16) != 0 ? false : false, (16 & 32) != 0 ? null : null, (16 & 64) != 0 ? null : null, "Guild Header");
                }
            });
            TextView textView = getBinding().f.f100b;
            Intrinsics3.checkNotNullExpressionValue(textView, "binding.widgetDirectoryC….itemDirectoryEmptyHeader");
            textView.setText(FormatUtils.e(this, R.string.hub_directory_channel_empty_title, new Object[]{guild.getName()}, (4 & 4) != 0 ? FormatUtils.a.j : null));
        }
        final ServerDiscoveryHeader serverDiscoveryHeader = getBinding().c;
        serverDiscoveryHeader.setButtonOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.directories.WidgetDirectoryChannel$configureUi$$inlined$apply$lambda$1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Channel channel = state.getChannel();
                if (channel != null) {
                    long id2 = channel.getId();
                    Context context = serverDiscoveryHeader.getContext();
                    Intrinsics3.checkNotNullExpressionValue(context, "context");
                    AppScreen2.d(context, WidgetDirectoriesSearch.class, new WidgetDirectoriesSearch2(id2));
                }
            }
        });
        List<DirectoryEntryGuild> listInvoke = state.getDirectories().invoke();
        boolean z2 = listInvoke != null && (listInvoke.isEmpty() ^ true);
        ServerDiscoveryHeader serverDiscoveryHeader2 = getBinding().c;
        Intrinsics3.checkNotNullExpressionValue(serverDiscoveryHeader2, "binding.header");
        serverDiscoveryHeader2.setVisibility(z2 ? 0 : 8);
        ViewPager2 viewPager2 = getBinding().e;
        Intrinsics3.checkNotNullExpressionValue(viewPager2, "binding.viewPager");
        viewPager2.setVisibility(z2 ? 0 : 8);
        WidgetDirectoryChannelEmptyBinding widgetDirectoryChannelEmptyBinding = getBinding().f;
        Intrinsics3.checkNotNullExpressionValue(widgetDirectoryChannelEmptyBinding, "binding.widgetDirectoryChannelEmpty");
        LinearLayout linearLayout = widgetDirectoryChannelEmptyBinding.a;
        Intrinsics3.checkNotNullExpressionValue(linearLayout, "binding.widgetDirectoryChannelEmpty.root");
        linearLayout.setVisibility(z2 ^ true ? 0 : 8);
        Map<Integer, Integer> mapInvoke = state.getTabs().invoke();
        boolean z3 = !(mapInvoke == null || mapInvoke.isEmpty());
        toggleHeaderMargins(z3);
        TabLayout tabLayout = getBinding().d;
        Intrinsics3.checkNotNullExpressionValue(tabLayout, "binding.tabs");
        tabLayout.setVisibility(z3 ? 0 : 8);
        WidgetDirectoryChannelViewPagerAdapter adapter = getAdapter();
        List<Tuples2<DirectoryEntryCategory, Integer>> mappedTabs = state.getMappedTabs();
        ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(mappedTabs, 10));
        Iterator<T> it = mappedTabs.iterator();
        while (it.hasNext()) {
            arrayList.add((DirectoryEntryCategory) ((Tuples2) it.next()).getFirst());
        }
        adapter.setTabs(_Collections.toList(arrayList));
    }

    private final void onViewBindingDestroy(WidgetDirectoryChannelBinding binding) {
        bindGestureObservers(false, binding);
    }

    private final void toggleHeaderMargins(boolean showTabLayout) {
        int i = showTabLayout ? TAB_LAYOUT_MARGINS : 0;
        ServerDiscoveryHeader serverDiscoveryHeader = getBinding().c;
        Intrinsics3.checkNotNullExpressionValue(serverDiscoveryHeader, "binding.header");
        ViewGroup.LayoutParams layoutParams = serverDiscoveryHeader.getLayoutParams();
        Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        marginLayoutParams.bottomMargin = i;
        serverDiscoveryHeader.setLayoutParams(marginLayoutParams);
        Toolbar toolbar = getBinding().f2365b;
        Intrinsics3.checkNotNullExpressionValue(toolbar, "binding.actionBarToolbar");
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
            PanelsChildGestureRegionObserver panelsChildGestureRegionObserverA = PanelsChildGestureRegionObserver.b.a();
            TabLayout tabLayout = binding.d;
            Intrinsics3.checkNotNullExpressionValue(tabLayout, "nonNullBinding.tabs");
            panelsChildGestureRegionObserverA.b(tabLayout);
            PanelsChildGestureRegionObserver panelsChildGestureRegionObserverA2 = PanelsChildGestureRegionObserver.b.a();
            ViewPager2 viewPager2 = binding.e;
            Intrinsics3.checkNotNullExpressionValue(viewPager2, "nonNullBinding.viewPager");
            panelsChildGestureRegionObserverA2.b(viewPager2);
            this.hasBound = true;
            return;
        }
        if (bind) {
            return;
        }
        PanelsChildGestureRegionObserver panelsChildGestureRegionObserverA3 = PanelsChildGestureRegionObserver.b.a();
        TabLayout tabLayout2 = binding.d;
        Intrinsics3.checkNotNullExpressionValue(tabLayout2, "nonNullBinding.tabs");
        panelsChildGestureRegionObserverA3.c(tabLayout2);
        PanelsChildGestureRegionObserver panelsChildGestureRegionObserverA4 = PanelsChildGestureRegionObserver.b.a();
        ViewPager2 viewPager3 = binding.e;
        Intrinsics3.checkNotNullExpressionValue(viewPager3, "nonNullBinding.viewPager");
        panelsChildGestureRegionObserverA4.c(viewPager3);
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
        getBinding().f.c.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.directories.WidgetDirectoryChannel.initializeUI.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AppScreen2.g.f(WidgetDirectoryChannel.this.requireContext(), WidgetDirectoryChannel.this.activityResult, WidgetHubAddServer.class, null);
            }
        });
        ServerDiscoveryHeader serverDiscoveryHeader = getBinding().c;
        serverDiscoveryHeader.setTitle(getString(R.string.hub_directory_search_title));
        serverDiscoveryHeader.setDescription(getString(R.string.hub_directory_search_subtitle));
        getBinding().e.setAdapter(getAdapter());
        TabLayout tabLayout = getBinding().d;
        ViewPager2 viewPager2 = getBinding().e;
        Intrinsics3.checkNotNullExpressionValue(viewPager2, "binding.viewPager");
        ViewPager2Extensions.setUpWithViewPager2(tabLayout, viewPager2, new WidgetDirectoryChannel7(tabLayout, this));
        bindGestureObservers$default(this, true, null, 2, null);
        Observable<Long> observableR = StoreStream.INSTANCE.getGuildSelected().observeSelectedGuildId().r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "StoreStream\n        .get…  .distinctUntilChanged()");
        Observable<R> observableG = observableR.y(ObservableExtensionsKt.AnonymousClass1.INSTANCE).G(ObservableExtensionsKt.AnonymousClass2.INSTANCE);
        Intrinsics3.checkNotNullExpressionValue(observableG, "filter { it != null }.map { it!! }");
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui(observableG), (Class<?>) WidgetDirectoryChannel.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass5());
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        Observable<WidgetDirectoriesViewModel.ViewState> observableZ = getViewModel().observeViewState().y(new Func1<WidgetDirectoriesViewModel.ViewState, Boolean>() { // from class: com.discord.widgets.directories.WidgetDirectoryChannel.onViewBoundOrOnResume.1
            @Override // j0.k.Func1
            public final Boolean call(WidgetDirectoriesViewModel.ViewState viewState) {
                return Boolean.valueOf(viewState != null);
            }
        }).z();
        Intrinsics3.checkNotNullExpressionValue(observableZ, "viewModel\n        .obser…= null }\n        .first()");
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.bindToComponentLifecycle$default(observableZ, this, null, 2, null), (Class<?>) WidgetDirectoryChannel.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass2());
        Observable<WidgetDirectoriesViewModel.ViewState> observableY = getViewModel().observeViewState().y(new Func1<WidgetDirectoriesViewModel.ViewState, Boolean>() { // from class: com.discord.widgets.directories.WidgetDirectoryChannel.onViewBoundOrOnResume.3
            @Override // j0.k.Func1
            public final Boolean call(WidgetDirectoriesViewModel.ViewState viewState) {
                return Boolean.valueOf(viewState != null);
            }
        });
        Intrinsics3.checkNotNullExpressionValue(observableY, "viewModel\n        .obser…   .filter { it != null }");
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.bindToComponentLifecycle$default(observableY, this, null, 2, null), (Class<?>) WidgetDirectoryChannel.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass4());
    }
}
