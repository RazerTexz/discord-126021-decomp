package com.discord.widgets.channels.threads.browser;

import android.content.Context;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import b.a.d.f0;
import b.d.b.a.a;
import com.discord.R$layout;
import com.discord.R$menu;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetThreadBrowserBinding;
import com.discord.stores.SelectedChannelAnalyticsLocation;
import com.discord.utilities.channel.ChannelSelector;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.simple_pager.SimplePager;
import com.discord.utilities.simple_pager.SimplePager$Adapter;
import com.discord.utilities.simple_pager.SimplePager$Adapter$Item;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.google.android.material.tabs.TabLayout;
import d0.g;
import d0.z.d.a0;
import d0.z.d.m;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: WidgetThreadBrowser.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetThreadBrowser extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetThreadBrowser.class, "binding", "getBinding()Lcom/discord/databinding/WidgetThreadBrowserBinding;", 0)};
    public static final WidgetThreadBrowser$Companion Companion = new WidgetThreadBrowser$Companion(null);
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
    private WidgetThreadBrowserViewModel$ViewState previousViewState;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    public WidgetThreadBrowser() {
        super(R$layout.widget_thread_browser);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetThreadBrowser$binding$2.INSTANCE, null, 2, null);
        this.guildId = g.lazy(new WidgetThreadBrowser$guildId$2(this));
        this.channelId = g.lazy(new WidgetThreadBrowser$channelId$2(this));
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, a0.getOrCreateKotlinClass(WidgetThreadBrowserViewModel.class), new WidgetThreadBrowser$appActivityViewModels$$inlined$activityViewModels$1(this), new f0(new WidgetThreadBrowser$viewModel$2(this)));
        this.archivedViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, a0.getOrCreateKotlinClass(WidgetThreadBrowserArchivedViewModel.class), new WidgetThreadBrowser$appActivityViewModels$$inlined$activityViewModels$3(this), new f0(new WidgetThreadBrowser$archivedViewModel$2(this)));
        this.channelSelector = ChannelSelector.Companion.getInstance();
        this.ARCHIVED_PAGE = 1;
    }

    public static final /* synthetic */ int access$getACTIVE_PAGE$p(WidgetThreadBrowser widgetThreadBrowser) {
        return widgetThreadBrowser.ACTIVE_PAGE;
    }

    public static final /* synthetic */ int access$getARCHIVED_PAGE$p(WidgetThreadBrowser widgetThreadBrowser) {
        return widgetThreadBrowser.ARCHIVED_PAGE;
    }

    public static final /* synthetic */ WidgetThreadBrowserArchivedViewModel access$getArchivedViewModel$p(WidgetThreadBrowser widgetThreadBrowser) {
        return widgetThreadBrowser.getArchivedViewModel();
    }

    public static final /* synthetic */ long access$getChannelId$p(WidgetThreadBrowser widgetThreadBrowser) {
        return widgetThreadBrowser.getChannelId();
    }

    public static final /* synthetic */ long access$getGuildId$p(WidgetThreadBrowser widgetThreadBrowser) {
        return widgetThreadBrowser.getGuildId();
    }

    public static final /* synthetic */ WidgetThreadBrowserViewModel$ViewState access$getPreviousViewState$p(WidgetThreadBrowser widgetThreadBrowser) {
        return widgetThreadBrowser.previousViewState;
    }

    public static final /* synthetic */ WidgetThreadBrowserViewModel access$getViewModel$p(WidgetThreadBrowser widgetThreadBrowser) {
        return widgetThreadBrowser.getViewModel();
    }

    public static final /* synthetic */ void access$setPreviousViewState$p(WidgetThreadBrowser widgetThreadBrowser, WidgetThreadBrowserViewModel$ViewState widgetThreadBrowserViewModel$ViewState) {
        widgetThreadBrowser.previousViewState = widgetThreadBrowserViewModel$ViewState;
    }

    public static final /* synthetic */ void access$updateMenu(WidgetThreadBrowser widgetThreadBrowser, int i, Boolean bool) {
        widgetThreadBrowser.updateMenu(i, bool);
    }

    public static final /* synthetic */ void access$updateView(WidgetThreadBrowser widgetThreadBrowser, WidgetThreadBrowserViewModel$ViewState widgetThreadBrowserViewModel$ViewState) {
        widgetThreadBrowser.updateView(widgetThreadBrowserViewModel$ViewState);
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

    private final void initializeAdapter(WidgetThreadBrowserViewModel$ViewState$Browser viewState) {
        SimplePager simplePager = getBinding().c;
        m.checkNotNullExpressionValue(simplePager, "binding.threadBrowserViewPager");
        if (simplePager.getAdapter() == null) {
            ArrayList arrayList = new ArrayList();
            String string = getString(2131896346);
            m.checkNotNullExpressionValue(string, "getString(R.string.thread_browser_active)");
            arrayList.add(new SimplePager$Adapter$Item(string, new WidgetThreadBrowser$initializeAdapter$1(this)));
            if (viewState.getCanViewArchivedThreads()) {
                String string2 = getString(2131896348);
                m.checkNotNullExpressionValue(string2, "getString(R.string.thread_browser_archived)");
                arrayList.add(new SimplePager$Adapter$Item(string2, new WidgetThreadBrowser$initializeAdapter$2(this)));
            }
            SimplePager simplePager2 = getBinding().c;
            m.checkNotNullExpressionValue(simplePager2, "binding.threadBrowserViewPager");
            FragmentManager parentFragmentManager = getParentFragmentManager();
            m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
            Object[] array = arrayList.toArray(new SimplePager$Adapter$Item[0]);
            Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
            SimplePager$Adapter$Item[] simplePager$Adapter$ItemArr = (SimplePager$Adapter$Item[]) array;
            simplePager2.setAdapter(new SimplePager$Adapter(parentFragmentManager, (SimplePager$Adapter$Item[]) Arrays.copyOf(simplePager$Adapter$ItemArr, simplePager$Adapter$ItemArr.length)));
            getBinding().c.addOnPageChangeListener(new WidgetThreadBrowser$initializeAdapter$3(this));
            TabLayout tabLayout = getBinding().f2670b;
            m.checkNotNullExpressionValue(tabLayout, "binding.actionBarTabs");
            tabLayout.setVisibility(viewState.getCanViewArchivedThreads() ? 0 : 8);
        }
    }

    public static final void show(Context context, long j, long j2, String str) {
        Companion.show(context, j, j2, str);
    }

    private final void updateMenu(int selectedPage, Boolean canCreateThread) {
        setActionBarOptionsMenu(R$menu.menu_thread_browser, new WidgetThreadBrowser$updateMenu$1(this), new WidgetThreadBrowser$updateMenu$2(this, selectedPage, canCreateThread));
    }

    private final void updateView(WidgetThreadBrowserViewModel$ViewState viewState) {
        this.previousViewState = viewState;
        if (viewState instanceof WidgetThreadBrowserViewModel$ViewState$GoToChannel) {
            ChannelSelector.selectChannel$default(this.channelSelector, ((WidgetThreadBrowserViewModel$ViewState$GoToChannel) viewState).getChannel(), null, SelectedChannelAnalyticsLocation.THREAD_BROWSER, 2, null);
            requireActivity().onBackPressed();
            return;
        }
        if (viewState instanceof WidgetThreadBrowserViewModel$ViewState$Browser) {
            WidgetThreadBrowserViewModel$ViewState$Browser widgetThreadBrowserViewModel$ViewState$Browser = (WidgetThreadBrowserViewModel$ViewState$Browser) viewState;
            initializeAdapter(widgetThreadBrowserViewModel$ViewState$Browser);
            if (widgetThreadBrowserViewModel$ViewState$Browser.getChannelName() != null && !widgetThreadBrowserViewModel$ViewState$Browser.isForumChannel()) {
                StringBuilder sbU = a.U("#");
                sbU.append(widgetThreadBrowserViewModel$ViewState$Browser.getChannelName());
                setActionBarSubtitle(sbU.toString());
            }
            if (widgetThreadBrowserViewModel$ViewState$Browser.getChannelName() != null && widgetThreadBrowserViewModel$ViewState$Browser.isForumChannel()) {
                StringBuilder sbU2 = a.U("#");
                sbU2.append(widgetThreadBrowserViewModel$ViewState$Browser.getChannelName());
                setActionBarTitle(sbU2.toString());
            }
            SimplePager simplePager = getBinding().c;
            m.checkNotNullExpressionValue(simplePager, "binding.threadBrowserViewPager");
            updateMenu(simplePager.getCurrentItem(), Boolean.valueOf(widgetThreadBrowserViewModel$ViewState$Browser.getCanCreateThread()));
        }
    }

    @Override // com.discord.app.AppFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), WidgetThreadBrowser.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetThreadBrowser$onResume$1(this), 62, (Object) null);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        AppFragment.setActionBarDisplayHomeAsUpEnabled$default(this, false, 1, null);
        setActionBarTitle(2131896372);
    }
}
