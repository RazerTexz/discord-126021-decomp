package com.discord.widgets.directories;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.ViewGroup$LayoutParams;
import android.view.ViewGroup$MarginLayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.activity.result.ActivityResultLauncher;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.viewpager2.widget.ViewPager2;
import b.a.d.f0;
import b.a.i.d5;
import b.a.k.b;
import b.a.o.b$b;
import b.d.b.a.a;
import com.discord.R$layout;
import com.discord.api.directory.DirectoryEntryGuild;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetDirectoryChannelBinding;
import com.discord.models.guild.Guild;
import com.discord.models.hubs.DirectoryEntryCategory;
import com.discord.stores.StoreStream;
import com.discord.utilities.dimen.DimenUtils;
import com.discord.utilities.hubs.HubUtilsKt;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.rx.ObservableExtensionsKt$filterNull$1;
import com.discord.utilities.rx.ObservableExtensionsKt$filterNull$2;
import com.discord.utilities.view.recycler.ViewPager2ExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.views.directories.ServerDiscoveryHeader;
import com.google.android.material.tabs.TabLayout;
import d0.g;
import d0.t.o;
import d0.t.u;
import d0.z.d.a0;
import d0.z.d.m;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;
import rx.Observable;

/* JADX INFO: compiled from: WidgetDirectoryChannel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetDirectoryChannel extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetDirectoryChannel.class, "binding", "getBinding()Lcom/discord/databinding/WidgetDirectoryChannelBinding;", 0)};
    public static final WidgetDirectoryChannel$Companion Companion = new WidgetDirectoryChannel$Companion(null);
    private static final int TAB_LAYOUT_MARGINS = DimenUtils.dpToPixels(48);
    private final ActivityResultLauncher<Intent> activityResult;

    /* JADX INFO: renamed from: adapter$delegate, reason: from kotlin metadata */
    private final Lazy adapter;

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private boolean hasBound;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    public WidgetDirectoryChannel() {
        super(R$layout.widget_directory_channel);
        this.binding = FragmentViewBindingDelegateKt.viewBinding(this, WidgetDirectoryChannel$binding$2.INSTANCE, new WidgetDirectoryChannel$binding$3(this));
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, a0.getOrCreateKotlinClass(WidgetDirectoriesViewModel.class), new WidgetDirectoryChannel$appActivityViewModels$$inlined$activityViewModels$1(this), new f0(WidgetDirectoryChannel$viewModel$2.INSTANCE));
        this.adapter = g.lazy(new WidgetDirectoryChannel$adapter$2(this));
        this.activityResult = HubUtilsKt.getAddServerActivityResultHandler(this);
    }

    public static final /* synthetic */ void access$configureUi(WidgetDirectoryChannel widgetDirectoryChannel, WidgetDirectoriesViewModel$ViewState widgetDirectoriesViewModel$ViewState) {
        widgetDirectoryChannel.configureUi(widgetDirectoriesViewModel$ViewState);
    }

    public static final /* synthetic */ ActivityResultLauncher access$getActivityResult$p(WidgetDirectoryChannel widgetDirectoryChannel) {
        return widgetDirectoryChannel.activityResult;
    }

    public static final /* synthetic */ int access$getTAB_LAYOUT_MARGINS$cp() {
        return TAB_LAYOUT_MARGINS;
    }

    public static final /* synthetic */ void access$onViewBindingDestroy(WidgetDirectoryChannel widgetDirectoryChannel, WidgetDirectoryChannelBinding widgetDirectoryChannelBinding) {
        widgetDirectoryChannel.onViewBindingDestroy(widgetDirectoryChannelBinding);
    }

    public static /* synthetic */ void bindGestureObservers$default(WidgetDirectoryChannel widgetDirectoryChannel, boolean z2, WidgetDirectoryChannelBinding widgetDirectoryChannelBinding, int i, Object obj) {
        if ((i & 2) != 0) {
            widgetDirectoryChannelBinding = null;
        }
        widgetDirectoryChannel.bindGestureObservers(z2, widgetDirectoryChannelBinding);
    }

    private final void configureUi(WidgetDirectoriesViewModel$ViewState state) {
        Guild guild = state.getGuild();
        if (guild != null) {
            getBinding().f.d.setOnClickListener(new WidgetDirectoryChannel$configureUi$$inlined$let$lambda$1(guild, this));
            TextView textView = getBinding().f.f100b;
            m.checkNotNullExpressionValue(textView, "binding.widgetDirectoryC….itemDirectoryEmptyHeader");
            textView.setText(b.k(this, 2131891768, new Object[]{guild.getName()}, null, 4));
        }
        ServerDiscoveryHeader serverDiscoveryHeader = getBinding().c;
        serverDiscoveryHeader.setButtonOnClickListener(new WidgetDirectoryChannel$configureUi$$inlined$apply$lambda$1(serverDiscoveryHeader, state));
        List<DirectoryEntryGuild> listInvoke = state.getDirectories().invoke();
        boolean z2 = listInvoke != null && (listInvoke.isEmpty() ^ true);
        ServerDiscoveryHeader serverDiscoveryHeader2 = getBinding().c;
        m.checkNotNullExpressionValue(serverDiscoveryHeader2, "binding.header");
        serverDiscoveryHeader2.setVisibility(z2 ? 0 : 8);
        ViewPager2 viewPager2 = getBinding().e;
        m.checkNotNullExpressionValue(viewPager2, "binding.viewPager");
        viewPager2.setVisibility(z2 ? 0 : 8);
        d5 d5Var = getBinding().f;
        m.checkNotNullExpressionValue(d5Var, "binding.widgetDirectoryChannelEmpty");
        LinearLayout linearLayout = d5Var.a;
        m.checkNotNullExpressionValue(linearLayout, "binding.widgetDirectoryChannelEmpty.root");
        linearLayout.setVisibility(z2 ^ true ? 0 : 8);
        Map<Integer, Integer> mapInvoke = state.getTabs().invoke();
        boolean z3 = !(mapInvoke == null || mapInvoke.isEmpty());
        toggleHeaderMargins(z3);
        TabLayout tabLayout = getBinding().d;
        m.checkNotNullExpressionValue(tabLayout, "binding.tabs");
        tabLayout.setVisibility(z3 ? 0 : 8);
        WidgetDirectoryChannelViewPagerAdapter adapter = getAdapter();
        List<Pair<DirectoryEntryCategory, Integer>> mappedTabs = state.getMappedTabs();
        ArrayList arrayList = new ArrayList(o.collectionSizeOrDefault(mappedTabs, 10));
        Iterator<T> it = mappedTabs.iterator();
        while (it.hasNext()) {
            arrayList.add((DirectoryEntryCategory) ((Pair) it.next()).getFirst());
        }
        adapter.setTabs(u.toList(arrayList));
    }

    private final void onViewBindingDestroy(WidgetDirectoryChannelBinding binding) {
        bindGestureObservers(false, binding);
    }

    private final void toggleHeaderMargins(boolean showTabLayout) {
        int i = showTabLayout ? TAB_LAYOUT_MARGINS : 0;
        ServerDiscoveryHeader serverDiscoveryHeader = getBinding().c;
        m.checkNotNullExpressionValue(serverDiscoveryHeader, "binding.header");
        ViewGroup$LayoutParams layoutParams = serverDiscoveryHeader.getLayoutParams();
        Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup$MarginLayoutParams viewGroup$MarginLayoutParams = (ViewGroup$MarginLayoutParams) layoutParams;
        viewGroup$MarginLayoutParams.bottomMargin = i;
        serverDiscoveryHeader.setLayoutParams(viewGroup$MarginLayoutParams);
        Toolbar toolbar = getBinding().f2365b;
        m.checkNotNullExpressionValue(toolbar, "binding.actionBarToolbar");
        ViewGroup$LayoutParams layoutParams2 = toolbar.getLayoutParams();
        Objects.requireNonNull(layoutParams2, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup$MarginLayoutParams viewGroup$MarginLayoutParams2 = (ViewGroup$MarginLayoutParams) layoutParams2;
        viewGroup$MarginLayoutParams2.bottomMargin = i;
        toolbar.setLayoutParams(viewGroup$MarginLayoutParams2);
    }

    public final void bindGestureObservers(boolean bind, WidgetDirectoryChannelBinding binding) {
        if (binding == null) {
            binding = getBinding();
        }
        if (!this.hasBound && bind) {
            b.a.o.b bVarA = b$b.a();
            TabLayout tabLayout = binding.d;
            m.checkNotNullExpressionValue(tabLayout, "nonNullBinding.tabs");
            bVarA.b(tabLayout);
            b.a.o.b bVarA2 = b$b.a();
            ViewPager2 viewPager2 = binding.e;
            m.checkNotNullExpressionValue(viewPager2, "nonNullBinding.viewPager");
            bVarA2.b(viewPager2);
            this.hasBound = true;
            return;
        }
        if (bind) {
            return;
        }
        b.a.o.b bVarA3 = b$b.a();
        TabLayout tabLayout2 = binding.d;
        m.checkNotNullExpressionValue(tabLayout2, "nonNullBinding.tabs");
        bVarA3.c(tabLayout2);
        b.a.o.b bVarA4 = b$b.a();
        ViewPager2 viewPager3 = binding.e;
        m.checkNotNullExpressionValue(viewPager3, "nonNullBinding.viewPager");
        bVarA4.c(viewPager3);
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
        getBinding().f.c.setOnClickListener(new WidgetDirectoryChannel$initializeUI$1(this));
        ServerDiscoveryHeader serverDiscoveryHeader = getBinding().c;
        serverDiscoveryHeader.setTitle(getString(2131891771));
        serverDiscoveryHeader.setDescription(getString(2131891770));
        getBinding().e.setAdapter(getAdapter());
        TabLayout tabLayout = getBinding().d;
        ViewPager2 viewPager2 = getBinding().e;
        m.checkNotNullExpressionValue(viewPager2, "binding.viewPager");
        ViewPager2ExtensionsKt.setUpWithViewPager2(tabLayout, viewPager2, new WidgetDirectoryChannel$initializeUI$$inlined$apply$lambda$1(tabLayout, this));
        bindGestureObservers$default(this, true, null, 2, null);
        Observable<Long> observableR = StoreStream.Companion.getGuildSelected().observeSelectedGuildId().r();
        m.checkNotNullExpressionValue(observableR, "StoreStream\n        .get…  .distinctUntilChanged()");
        Observable<R> observableG = observableR.y(ObservableExtensionsKt$filterNull$1.INSTANCE).G(ObservableExtensionsKt$filterNull$2.INSTANCE);
        m.checkNotNullExpressionValue(observableG, "filter { it != null }.map { it!! }");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui(observableG), WidgetDirectoryChannel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetDirectoryChannel$initializeUI$5(this), 62, (Object) null);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        Observable<WidgetDirectoriesViewModel$ViewState> observableZ = getViewModel().observeViewState().y(WidgetDirectoryChannel$onViewBoundOrOnResume$1.INSTANCE).z();
        m.checkNotNullExpressionValue(observableZ, "viewModel\n        .obser…= null }\n        .first()");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(observableZ, this, null, 2, null), WidgetDirectoryChannel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetDirectoryChannel$onViewBoundOrOnResume$2(this), 62, (Object) null);
        Observable<WidgetDirectoriesViewModel$ViewState> observableY = getViewModel().observeViewState().y(WidgetDirectoryChannel$onViewBoundOrOnResume$3.INSTANCE);
        m.checkNotNullExpressionValue(observableY, "viewModel\n        .obser…   .filter { it != null }");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(observableY, this, null, 2, null), WidgetDirectoryChannel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetDirectoryChannel$onViewBoundOrOnResume$4(this), 62, (Object) null);
    }
}
