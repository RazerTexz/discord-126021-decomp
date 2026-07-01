package com.discord.widgets.channels.threads.browser;

import android.content.Context;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.viewpager.widget.ViewPager;
import b.a.d.AppScreen2;
import b.a.d.AppViewModelDelegates2;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetThreadBrowserBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.stores.StoreChannelsSelected3;
import com.discord.stores.StoreStream;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.channel.ChannelSelector;
import com.discord.utilities.error.Error;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.simple_pager.SimplePager;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.widgets.channels.threads.browser.WidgetThreadBrowserFilterSheet;
import com.discord.widgets.channels.threads.browser.WidgetThreadBrowserViewModel;
import com.google.android.material.tabs.TabLayout;
import d0.LazyJVM;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import d0.z.d.Reflection2;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import rx.Subscription;
import rx.functions.Action1;
import rx.functions.Action2;

/* JADX INFO: compiled from: WidgetThreadBrowser.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetThreadBrowser extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetThreadBrowser.class, "binding", "getBinding()Lcom/discord/databinding/WidgetThreadBrowserBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final int ACTIVE_PAGE;
    private final int ARCHIVED_PAGE;

    /* JADX INFO: renamed from: archivedViewModel$delegate, reason: from kotlin metadata */
    private final Lazy archivedViewModel;

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* JADX INFO: renamed from: channelId$delegate, reason: from kotlin metadata */
    private final Lazy channelId;
    private final ChannelSelector channelSelector;

    /* JADX INFO: renamed from: guildId$delegate, reason: from kotlin metadata */
    private final Lazy guildId;
    private WidgetThreadBrowserViewModel.ViewState previousViewState;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* JADX INFO: compiled from: WidgetThreadBrowser.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void show(Context context, long guildId, long channelId, String location) {
            Intrinsics3.checkNotNullParameter(location, ModelAuditLogEntry.CHANGE_KEY_LOCATION);
            if (context != null) {
                Intent intent = new Intent();
                intent.putExtra("com.discord.intent.extra.EXTRA_GUILD_ID", guildId);
                intent.putExtra("com.discord.intent.extra.EXTRA_CHANNEL_ID", channelId);
                AppScreen2.d(context, WidgetThreadBrowser.class, intent);
                AnalyticsTracker.openModal("Thread Browser", location, Long.valueOf(guildId));
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.channels.threads.browser.WidgetThreadBrowser$initializeAdapter$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetThreadBrowser.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<Fragment> {
        public AnonymousClass1() {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final Fragment invoke() {
            return WidgetThreadBrowserActive.INSTANCE.create(WidgetThreadBrowser.this.getViewModel().getGuildId(), WidgetThreadBrowser.this.getViewModel().getChannelId());
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.channels.threads.browser.WidgetThreadBrowser$initializeAdapter$2, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetThreadBrowser.kt */
    public static final class AnonymousClass2 extends Lambda implements Function0<Fragment> {
        public AnonymousClass2() {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final Fragment invoke() {
            return WidgetThreadBrowserArchived.INSTANCE.create(WidgetThreadBrowser.this.getViewModel().getGuildId(), WidgetThreadBrowser.this.getViewModel().getChannelId());
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.channels.threads.browser.WidgetThreadBrowser$onResume$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetThreadBrowser.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<WidgetThreadBrowserViewModel.ViewState, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetThreadBrowserViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetThreadBrowserViewModel.ViewState viewState) {
            Intrinsics3.checkNotNullParameter(viewState, "viewState");
            WidgetThreadBrowser.this.updateView(viewState);
        }
    }

    public WidgetThreadBrowser() {
        super(R.layout.widget_thread_browser);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetThreadBrowser3.INSTANCE, null, 2, null);
        this.guildId = LazyJVM.lazy(new WidgetThreadBrowser5(this));
        this.channelId = LazyJVM.lazy(new WidgetThreadBrowser4(this));
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(WidgetThreadBrowserViewModel.class), new WidgetThreadBrowser$appActivityViewModels$$inlined$activityViewModels$1(this), new AppViewModelDelegates2(new WidgetThreadBrowser6(this)));
        this.archivedViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(WidgetThreadBrowserArchivedViewModel.class), new WidgetThreadBrowser$appActivityViewModels$$inlined$activityViewModels$3(this), new AppViewModelDelegates2(new WidgetThreadBrowser2(this)));
        this.channelSelector = ChannelSelector.INSTANCE.getInstance();
        this.ARCHIVED_PAGE = 1;
    }

    private final WidgetThreadBrowserArchivedViewModel getArchivedViewModel() {
        return (WidgetThreadBrowserArchivedViewModel) this.archivedViewModel.getValue();
    }

    private final WidgetThreadBrowserBinding getBinding() {
        return (WidgetThreadBrowserBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final long getChannelId() {
        return ((Number) this.channelId.getValue()).longValue();
    }

    private final long getGuildId() {
        return ((Number) this.guildId.getValue()).longValue();
    }

    private final WidgetThreadBrowserViewModel getViewModel() {
        return (WidgetThreadBrowserViewModel) this.viewModel.getValue();
    }

    private final void initializeAdapter(WidgetThreadBrowserViewModel.ViewState.Browser viewState) {
        SimplePager simplePager = getBinding().c;
        Intrinsics3.checkNotNullExpressionValue(simplePager, "binding.threadBrowserViewPager");
        if (simplePager.getAdapter() == null) {
            ArrayList arrayList = new ArrayList();
            String string = getString(R.string.thread_browser_active);
            Intrinsics3.checkNotNullExpressionValue(string, "getString(R.string.thread_browser_active)");
            arrayList.add(new SimplePager.Adapter.Item(string, new AnonymousClass1()));
            if (viewState.getCanViewArchivedThreads()) {
                String string2 = getString(R.string.thread_browser_archived);
                Intrinsics3.checkNotNullExpressionValue(string2, "getString(R.string.thread_browser_archived)");
                arrayList.add(new SimplePager.Adapter.Item(string2, new AnonymousClass2()));
            }
            SimplePager simplePager2 = getBinding().c;
            Intrinsics3.checkNotNullExpressionValue(simplePager2, "binding.threadBrowserViewPager");
            FragmentManager parentFragmentManager = getParentFragmentManager();
            Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
            Object[] array = arrayList.toArray(new SimplePager.Adapter.Item[0]);
            Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
            SimplePager.Adapter.Item[] itemArr = (SimplePager.Adapter.Item[]) array;
            simplePager2.setAdapter(new SimplePager.Adapter(parentFragmentManager, (SimplePager.Adapter.Item[]) Arrays.copyOf(itemArr, itemArr.length)));
            getBinding().c.addOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.discord.widgets.channels.threads.browser.WidgetThreadBrowser.initializeAdapter.3
                @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
                public void onPageScrollStateChanged(int state) {
                }

                @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
                public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                }

                @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
                public void onPageSelected(int position) {
                    WidgetThreadBrowser widgetThreadBrowser = WidgetThreadBrowser.this;
                    WidgetThreadBrowserViewModel.ViewState viewState2 = widgetThreadBrowser.previousViewState;
                    if (!(viewState2 instanceof WidgetThreadBrowserViewModel.ViewState.Browser)) {
                        viewState2 = null;
                    }
                    WidgetThreadBrowserViewModel.ViewState.Browser browser = (WidgetThreadBrowserViewModel.ViewState.Browser) viewState2;
                    widgetThreadBrowser.updateMenu(position, browser != null ? Boolean.valueOf(browser.getCanCreateThread()) : null);
                    if (position == WidgetThreadBrowser.this.ACTIVE_PAGE) {
                        StoreStream.INSTANCE.getAnalytics().trackThreadBrowserTabChanged(WidgetThreadBrowser.this.getChannelId(), "Active Threads");
                    } else if (position == WidgetThreadBrowser.this.ARCHIVED_PAGE) {
                        WidgetThreadBrowser.this.getArchivedViewModel().trackTabChanged();
                    }
                }
            });
            TabLayout tabLayout = getBinding().f2670b;
            Intrinsics3.checkNotNullExpressionValue(tabLayout, "binding.actionBarTabs");
            tabLayout.setVisibility(viewState.getCanViewArchivedThreads() ? 0 : 8);
        }
    }

    public static final void show(Context context, long j, long j2, String str) {
        INSTANCE.show(context, j, j2, str);
    }

    private final void updateMenu(final int selectedPage, final Boolean canCreateThread) {
        setActionBarOptionsMenu(R.menu.menu_thread_browser, new Action2<MenuItem, Context>() { // from class: com.discord.widgets.channels.threads.browser.WidgetThreadBrowser.updateMenu.1
            @Override // rx.functions.Action2
            public final void call(MenuItem menuItem, Context context) {
                Intrinsics3.checkNotNullExpressionValue(menuItem, "menuItem");
                switch (menuItem.getItemId()) {
                    case R.id.menu_thread_browser_create_thread /* 2131364416 */:
                        ChannelSelector.openCreateThread$default(ChannelSelector.INSTANCE.getInstance(), WidgetThreadBrowser.this.getGuildId(), WidgetThreadBrowser.this.getChannelId(), null, "Thread Browser Toolbar", 4, null);
                        WidgetThreadBrowser.this.requireAppActivity().finish();
                        break;
                    case R.id.menu_thread_browser_filters /* 2131364417 */:
                        WidgetThreadBrowserFilterSheet.Companion companion = WidgetThreadBrowserFilterSheet.INSTANCE;
                        FragmentManager parentFragmentManager = WidgetThreadBrowser.this.getParentFragmentManager();
                        Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
                        companion.show(parentFragmentManager, WidgetThreadBrowser.this.getGuildId(), WidgetThreadBrowser.this.getChannelId());
                        break;
                }
            }
        }, new Action1<Menu>() { // from class: com.discord.widgets.channels.threads.browser.WidgetThreadBrowser.updateMenu.2
            @Override // rx.functions.Action1
            public final void call(Menu menu) {
                MenuItem menuItemFindItem = menu.findItem(R.id.menu_thread_browser_filters);
                if (menuItemFindItem != null) {
                    menuItemFindItem.setVisible(selectedPage == WidgetThreadBrowser.this.ARCHIVED_PAGE);
                }
                MenuItem menuItemFindItem2 = menu.findItem(R.id.menu_thread_browser_create_thread);
                if (menuItemFindItem2 != null) {
                    menuItemFindItem2.setVisible(selectedPage == WidgetThreadBrowser.this.ACTIVE_PAGE && Intrinsics3.areEqual(canCreateThread, Boolean.TRUE));
                }
            }
        });
    }

    private final void updateView(WidgetThreadBrowserViewModel.ViewState viewState) {
        this.previousViewState = viewState;
        if (viewState instanceof WidgetThreadBrowserViewModel.ViewState.GoToChannel) {
            ChannelSelector.selectChannel$default(this.channelSelector, ((WidgetThreadBrowserViewModel.ViewState.GoToChannel) viewState).getChannel(), null, StoreChannelsSelected3.THREAD_BROWSER, 2, null);
            requireActivity().onBackPressed();
            return;
        }
        if (viewState instanceof WidgetThreadBrowserViewModel.ViewState.Browser) {
            WidgetThreadBrowserViewModel.ViewState.Browser browser = (WidgetThreadBrowserViewModel.ViewState.Browser) viewState;
            initializeAdapter(browser);
            if (browser.getChannelName() != null && !browser.isForumChannel()) {
                StringBuilder sbU = outline.U("#");
                sbU.append(browser.getChannelName());
                setActionBarSubtitle(sbU.toString());
            }
            if (browser.getChannelName() != null && browser.isForumChannel()) {
                StringBuilder sbU2 = outline.U("#");
                sbU2.append(browser.getChannelName());
                setActionBarTitle(sbU2.toString());
            }
            SimplePager simplePager = getBinding().c;
            Intrinsics3.checkNotNullExpressionValue(simplePager, "binding.threadBrowserViewPager");
            updateMenu(simplePager.getCurrentItem(), Boolean.valueOf(browser.getCanCreateThread()));
        }
    }

    @Override // com.discord.app.AppFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), (Class<?>) WidgetThreadBrowser.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass1());
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        AppFragment.setActionBarDisplayHomeAsUpEnabled$default(this, false, 1, null);
        setActionBarTitle(R.string.thread_browser_title);
    }
}
