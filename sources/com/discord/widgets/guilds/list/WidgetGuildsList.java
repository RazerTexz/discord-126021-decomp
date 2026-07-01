package com.discord.widgets.guilds.list;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import b.a.d.AppScreen2;
import b.a.d.AppToast;
import b.a.d.AppViewModelDelegates3;
import b.a.d.AppViewModelDelegates5;
import b.a.k.FormatUtils;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.api.channel.Channel;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetGuildsListBinding;
import com.discord.panels.PanelState;
import com.discord.stores.StoreConnectionOpen;
import com.discord.stores.StoreNux;
import com.discord.stores.StoreStream;
import com.discord.utilities.accessibility.AccessibilityUtils;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.dimen.DimenUtils;
import com.discord.utilities.drawable.DrawableCompat;
import com.discord.utilities.error.Error;
import com.discord.utilities.resources.StringResourceUtils;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.widgets.channels.list.WidgetChannelListUnreads;
import com.discord.widgets.channels.list.WidgetChannelsListItemChannelActions;
import com.discord.widgets.guilds.contextmenu.WidgetFolderContextMenu;
import com.discord.widgets.guilds.contextmenu.WidgetGuildContextMenu;
import com.discord.widgets.guilds.create.CreateGuildTrigger;
import com.discord.widgets.guilds.list.GuildListItem;
import com.discord.widgets.guilds.list.WidgetGuildListAdapter;
import com.discord.widgets.guilds.list.WidgetGuildsList;
import com.discord.widgets.guilds.list.WidgetGuildsListViewModel;
import com.discord.widgets.home.WidgetHome;
import com.discord.widgets.hubs.WidgetHubEmailFlow;
import com.discord.widgets.hubs.WidgetHubEmailViewModel2;
import com.discord.widgets.nux.WidgetGuildTemplates;
import com.discord.widgets.nux.WidgetNavigationHelp;
import com.discord.widgets.tabs.BottomNavViewObserver;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import d0.z.d.Reflection2;
import j0.k.Func1;
import java.util.Map;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import rx.Observable;
import rx.Subscription;
import rx.functions.Func3;

/* JADX INFO: compiled from: WidgetGuildsList.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildsList extends AppFragment implements WidgetGuildListAdapter.InteractionListener {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetGuildsList.class, "binding", "getBinding()Lcom/discord/databinding/WidgetGuildsListBinding;", 0)};
    private WidgetGuildListAdapter adapter;

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private final BottomNavViewObserver bottomNavViewObserver;
    private View guildListAddHint;
    private WidgetChannelListUnreads guildListUnreads;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* JADX INFO: compiled from: WidgetGuildsList.kt */
    public static final /* data */ class AddGuildHint {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final boolean isAddGuildHint;
        private final boolean isEligible;

        /* JADX INFO: compiled from: WidgetGuildsList.kt */
        public static final class Companion {
            private Companion() {
            }

            public final Observable<AddGuildHint> get() {
                StoreStream.Companion companion = StoreStream.INSTANCE;
                Observable observableY = Observable.i(companion.getNux().getNuxState(), StoreConnectionOpen.observeConnectionOpen$default(companion.getConnectionOpen(), false, 1, null), companion.getChannels().observeGuildAndPrivateChannels(), new Func3<StoreNux.NuxState, Boolean, Map<Long, ? extends Channel>, AddGuildHint>() { // from class: com.discord.widgets.guilds.list.WidgetGuildsList$AddGuildHint$Companion$get$1
                    @Override // rx.functions.Func3
                    public /* bridge */ /* synthetic */ WidgetGuildsList.AddGuildHint call(StoreNux.NuxState nuxState, Boolean bool, Map<Long, ? extends Channel> map) {
                        return call2(nuxState, bool, (Map<Long, Channel>) map);
                    }

                    /* JADX WARN: Code duplicated, block: B:9:0x001b  */
                    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
                    public final WidgetGuildsList.AddGuildHint call2(StoreNux.NuxState nuxState, Boolean bool, Map<Long, Channel> map) {
                        boolean z2;
                        if (nuxState.getAddGuildHint()) {
                            Intrinsics3.checkNotNullExpressionValue(bool, "connectionOpen");
                            if (bool.booleanValue() && map.isEmpty()) {
                                z2 = true;
                            } else {
                                z2 = false;
                            }
                        } else {
                            z2 = false;
                        }
                        return new WidgetGuildsList.AddGuildHint(z2, nuxState.getAddGuildHint());
                    }
                }).y(new Func1<AddGuildHint, Boolean>() { // from class: com.discord.widgets.guilds.list.WidgetGuildsList$AddGuildHint$Companion$get$2
                    @Override // j0.k.Func1
                    public final Boolean call(WidgetGuildsList.AddGuildHint addGuildHint) {
                        return Boolean.valueOf(addGuildHint.isEligible());
                    }
                });
                Intrinsics3.checkNotNullExpressionValue(observableY, "Observable\n             ….filter { it.isEligible }");
                Observable<AddGuildHint> observableM = ObservableExtensionsKt.takeSingleUntilTimeout$default(observableY, 0L, false, 3, null).M(new Func1<Throwable, AddGuildHint>() { // from class: com.discord.widgets.guilds.list.WidgetGuildsList$AddGuildHint$Companion$get$3
                    @Override // j0.k.Func1
                    public final WidgetGuildsList.AddGuildHint call(Throwable th) {
                        boolean z2 = false;
                        return new WidgetGuildsList.AddGuildHint(z2, z2, 2, null);
                    }
                });
                Intrinsics3.checkNotNullExpressionValue(observableM, "Observable\n             … = false)\n              }");
                return observableM;
            }

            public final Observable<Boolean> getDismissAction() {
                Observable observableG = StoreStream.INSTANCE.getNavigation().observeLeftPanelState().G(new Func1<PanelState, Boolean>() { // from class: com.discord.widgets.guilds.list.WidgetGuildsList$AddGuildHint$Companion$getDismissAction$1
                    @Override // j0.k.Func1
                    public final Boolean call(PanelState panelState) {
                        return Boolean.valueOf(Intrinsics3.areEqual(panelState, PanelState.a.a));
                    }
                });
                Intrinsics3.checkNotNullExpressionValue(observableG, "StoreStream\n            …te == PanelState.Closed }");
                return observableG;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public AddGuildHint(boolean z2, boolean z3) {
            this.isEligible = z2;
            this.isAddGuildHint = z3;
        }

        public static /* synthetic */ AddGuildHint copy$default(AddGuildHint addGuildHint, boolean z2, boolean z3, int i, Object obj) {
            if ((i & 1) != 0) {
                z2 = addGuildHint.isEligible;
            }
            if ((i & 2) != 0) {
                z3 = addGuildHint.isAddGuildHint;
            }
            return addGuildHint.copy(z2, z3);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final boolean getIsEligible() {
            return this.isEligible;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final boolean getIsAddGuildHint() {
            return this.isAddGuildHint;
        }

        public final AddGuildHint copy(boolean isEligible, boolean isAddGuildHint) {
            return new AddGuildHint(isEligible, isAddGuildHint);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof AddGuildHint)) {
                return false;
            }
            AddGuildHint addGuildHint = (AddGuildHint) other;
            return this.isEligible == addGuildHint.isEligible && this.isAddGuildHint == addGuildHint.isAddGuildHint;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v3, types: [int] */
        /* JADX WARN: Type inference failed for: r0v4 */
        /* JADX WARN: Type inference failed for: r0v5 */
        /* JADX WARN: Type inference failed for: r1v0 */
        /* JADX WARN: Type inference failed for: r1v1, types: [int] */
        /* JADX WARN: Type inference failed for: r1v2 */
        public int hashCode() {
            boolean z2 = this.isEligible;
            ?? r0 = z2;
            if (z2) {
                r0 = 1;
            }
            int i = r0 * 31;
            boolean z3 = this.isAddGuildHint;
            return i + (z3 ? 1 : z3);
        }

        public final boolean isAddGuildHint() {
            return this.isAddGuildHint;
        }

        public final boolean isEligible() {
            return this.isEligible;
        }

        public String toString() {
            StringBuilder sbU = outline.U("AddGuildHint(isEligible=");
            sbU.append(this.isEligible);
            sbU.append(", isAddGuildHint=");
            return outline.O(sbU, this.isAddGuildHint, ")");
        }

        public /* synthetic */ AddGuildHint(boolean z2, boolean z3, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(z2, (i & 2) != 0 ? false : z3);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.guilds.list.WidgetGuildsList$configureAddGuildHint$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetGuildsList.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<StoreNux.NuxState, StoreNux.NuxState> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final StoreNux.NuxState invoke(StoreNux.NuxState nuxState) {
            Intrinsics3.checkNotNullParameter(nuxState, "nux");
            return StoreNux.NuxState.copy$default(nuxState, false, false, false, false, false, null, 47, null);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.guilds.list.WidgetGuildsList$configureBottomNavSpace$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetGuildsList.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<Integer, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
            invoke(num.intValue());
            return Unit.a;
        }

        public final void invoke(int i) {
            WidgetGuildsList.access$getAdapter$p(WidgetGuildsList.this).handleBottomNavHeight(i);
            ViewStub viewStub = WidgetGuildsList.this.getBinding().c;
            Intrinsics3.checkNotNullExpressionValue(viewStub, "binding.guildListUnreadsStub");
            ViewGroup.LayoutParams layoutParams = viewStub.getLayoutParams();
            Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.setMargins(marginLayoutParams.leftMargin, marginLayoutParams.topMargin, marginLayoutParams.rightMargin, i);
            ViewStub viewStub2 = WidgetGuildsList.this.getBinding().c;
            Intrinsics3.checkNotNullExpressionValue(viewStub2, "binding.guildListUnreadsStub");
            viewStub2.setLayoutParams(marginLayoutParams);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.guilds.list.WidgetGuildsList$onResume$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetGuildsList.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<WidgetGuildsListViewModel.ViewState, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetGuildsListViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetGuildsListViewModel.ViewState viewState) {
            Intrinsics3.checkNotNullParameter(viewState, "it");
            WidgetGuildsList.this.configureUI(viewState);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.guilds.list.WidgetGuildsList$onResume$2, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetGuildsList.kt */
    public static final class AnonymousClass2 extends Lambda implements Function1<WidgetGuildsListViewModel.Event, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetGuildsListViewModel.Event event) {
            invoke2(event);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetGuildsListViewModel.Event event) {
            Intrinsics3.checkNotNullParameter(event, "it");
            WidgetGuildsList.this.handleEvent(event);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.guilds.list.WidgetGuildsList$onResume$3, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetGuildsList.kt */
    public static final class AnonymousClass3 extends Lambda implements Function1<AddGuildHint, Unit> {
        public AnonymousClass3() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(AddGuildHint addGuildHint) {
            invoke2(addGuildHint);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(AddGuildHint addGuildHint) {
            Intrinsics3.checkNotNullParameter(addGuildHint, "it");
            WidgetGuildsList.this.configureAddGuildHint(addGuildHint);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.guilds.list.WidgetGuildsList$onResume$4, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetGuildsList.kt */
    public static final class AnonymousClass4 extends Lambda implements Function1<Boolean, Unit> {
        public AnonymousClass4() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
            invoke(bool.booleanValue());
            return Unit.a;
        }

        public final void invoke(boolean z2) {
            if (z2) {
                WidgetGuildsList.this.dismissAddGuildHint(false);
            }
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.guilds.list.WidgetGuildsList$onViewBound$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetGuildsList.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<Integer> {
        public AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Integer invoke() {
            return Integer.valueOf(invoke2());
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final int invoke2() {
            return WidgetGuildsList.access$getAdapter$p(WidgetGuildsList.this).getPageSize();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.guilds.list.WidgetGuildsList$onViewBound$2, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetGuildsList.kt */
    public static final class AnonymousClass2 extends Lambda implements Function1<View, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(View view) {
            invoke2(view);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(View view) {
            Intrinsics3.checkNotNullParameter(view, "it");
            WidgetGuildsList.this.guildListAddHint = view;
            View view2 = WidgetGuildsList.this.guildListAddHint;
            if (view2 != null) {
                view2.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.guilds.list.WidgetGuildsList.onViewBound.2.1
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view3) {
                        WidgetGuildsList.this.dismissAddGuildHint(true);
                    }
                });
            }
        }
    }

    public WidgetGuildsList() {
        super(R.layout.widget_guilds_list);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetGuildsList6.INSTANCE, null, 2, null);
        this.bottomNavViewObserver = BottomNavViewObserver.INSTANCE.getINSTANCE();
        WidgetGuildsList7 widgetGuildsList7 = WidgetGuildsList7.INSTANCE;
        AppViewModelDelegates3 appViewModelDelegates3 = new AppViewModelDelegates3(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(WidgetGuildsListViewModel.class), new WidgetGuildsList$appViewModels$$inlined$viewModels$1(appViewModelDelegates3), new AppViewModelDelegates5(widgetGuildsList7));
    }

    public static final /* synthetic */ WidgetGuildListAdapter access$getAdapter$p(WidgetGuildsList widgetGuildsList) {
        WidgetGuildListAdapter widgetGuildListAdapter = widgetGuildsList.adapter;
        if (widgetGuildListAdapter == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("adapter");
        }
        return widgetGuildListAdapter;
    }

    private final void announceFolderToggle(GuildListItem.FolderItem item) {
        Object[] objArr = new Object[2];
        objArr[0] = FormatUtils.e(this, item.isOpen() ? R.string.collapsed : R.string.expanded, new Object[0], (4 & 4) != 0 ? FormatUtils.a.j : null);
        String name = item.getName();
        if (name == null) {
            name = "";
        }
        objArr[1] = name;
        AccessibilityUtils.INSTANCE.sendAnnouncement(requireContext(), outline.P(objArr, 2, "%s, %s", "java.lang.String.format(this, *args)"));
    }

    private final void configureAddGuildHint(AddGuildHint addGuildHint) {
        if (addGuildHint.isAddGuildHint()) {
            StoreStream.INSTANCE.getNux().updateNux(AnonymousClass1.INSTANCE);
        }
        if (addGuildHint.isEligible()) {
            AnalyticsTracker.INSTANCE.showFirstServerTipTutorial();
            View view = this.guildListAddHint;
            if (view != null) {
                ViewExtensions.fadeIn$default(view, 0L, null, null, null, 15, null);
            }
        }
    }

    private final void configureBottomNavSpace() {
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(this.bottomNavViewObserver.observeHeight(), this, null, 2, null), (Class<?>) WidgetGuildsList.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass1());
    }

    private final void configureUI(WidgetGuildsListViewModel.ViewState viewState) {
        View view;
        if (viewState instanceof WidgetGuildsListViewModel.ViewState.Loaded) {
            WidgetGuildListAdapter widgetGuildListAdapter = this.adapter;
            if (widgetGuildListAdapter == null) {
                Intrinsics3.throwUninitializedPropertyAccessException("adapter");
            }
            WidgetGuildsListViewModel.ViewState.Loaded loaded = (WidgetGuildsListViewModel.ViewState.Loaded) viewState;
            widgetGuildListAdapter.setItems(loaded.getItems(), !loaded.getWasDragResult());
            WidgetChannelListUnreads widgetChannelListUnreads = this.guildListUnreads;
            if (widgetChannelListUnreads != null) {
                widgetChannelListUnreads.onDatasetChanged(loaded.getItems());
            }
            if (loaded.getHasChannels() && (view = this.guildListAddHint) != null && view.getVisibility() == 0) {
                dismissAddGuildHint(false);
            }
        }
    }

    private final void dismissAddGuildHint(boolean wasAcknowledged) {
        if (wasAcknowledged) {
            View view = this.guildListAddHint;
            if (view != null) {
                ViewExtensions.fadeOut$default(view, 0L, null, null, 7, null);
            }
            AnalyticsTracker.INSTANCE.closeFirstServerTipTutorial(true);
            return;
        }
        View view2 = this.guildListAddHint;
        if (view2 == null || view2.getVisibility() != 0) {
            return;
        }
        View view3 = this.guildListAddHint;
        if (view3 != null) {
            view3.setVisibility(8);
        }
        AnalyticsTracker.INSTANCE.closeFirstServerTipTutorial(false);
    }

    private final void focusFirstElement() {
        View childAt = getBinding().f2458b.getChildAt(0);
        if (childAt != null) {
            childAt.sendAccessibilityEvent(8);
        }
    }

    private final WidgetGuildsListBinding getBinding() {
        return (WidgetGuildsListBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final WidgetGuildsListViewModel getViewModel() {
        return (WidgetGuildsListViewModel) this.viewModel.getValue();
    }

    private final void handleEvent(WidgetGuildsListViewModel.Event event) {
        if (event instanceof WidgetGuildsListViewModel.Event.ShowChannelActions) {
            showChannelActions(((WidgetGuildsListViewModel.Event.ShowChannelActions) event).getChannelId());
            return;
        }
        if (event instanceof WidgetGuildsListViewModel.Event.ShowUnavailableGuilds) {
            showUnavailableGuildsToast(((WidgetGuildsListViewModel.Event.ShowUnavailableGuilds) event).getUnavailableGuildCount());
            return;
        }
        if (event instanceof WidgetGuildsListViewModel.Event.AnnounceFolderToggleForAccessibility) {
            announceFolderToggle(((WidgetGuildsListViewModel.Event.AnnounceFolderToggleForAccessibility) event).getItem());
            return;
        }
        if (Intrinsics3.areEqual(event, WidgetGuildsListViewModel.Event.ShowCreateGuild.INSTANCE)) {
            showCreateGuild();
            return;
        }
        if (Intrinsics3.areEqual(event, WidgetGuildsListViewModel.Event.ShowHubVerification.INSTANCE)) {
            showHubVerification();
        } else if (Intrinsics3.areEqual(event, WidgetGuildsListViewModel.Event.ShowHelp.INSTANCE)) {
            showHelp();
        } else {
            if (!Intrinsics3.areEqual(event, WidgetGuildsListViewModel.Event.FocusFirstElement.INSTANCE)) {
                throw new NoWhenBranchMatchedException();
            }
            focusFirstElement();
        }
    }

    private final void setupRecycler() {
        RecyclerView recyclerView = getBinding().f2458b;
        Intrinsics3.checkNotNullExpressionValue(recyclerView, "binding.guildList");
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(recyclerView.getContext(), 1, false);
        WidgetGuildListAdapter widgetGuildListAdapter = new WidgetGuildListAdapter(linearLayoutManager, this);
        this.adapter = widgetGuildListAdapter;
        if (widgetGuildListAdapter == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("adapter");
        }
        widgetGuildListAdapter.setHasStableIds(true);
        RecyclerView recyclerView2 = getBinding().f2458b;
        Intrinsics3.checkNotNullExpressionValue(recyclerView2, "binding.guildList");
        recyclerView2.setItemAnimator(null);
        RecyclerView recyclerView3 = getBinding().f2458b;
        Intrinsics3.checkNotNullExpressionValue(recyclerView3, "binding.guildList");
        recyclerView3.setLayoutManager(linearLayoutManager);
        RecyclerView recyclerView4 = getBinding().f2458b;
        Intrinsics3.checkNotNullExpressionValue(recyclerView4, "binding.guildList");
        WidgetGuildListAdapter widgetGuildListAdapter2 = this.adapter;
        if (widgetGuildListAdapter2 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("adapter");
        }
        recyclerView4.setAdapter(widgetGuildListAdapter2);
        WidgetGuildListAdapter widgetGuildListAdapter3 = this.adapter;
        if (widgetGuildListAdapter3 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("adapter");
        }
        new ItemTouchHelper(new GuildsDragAndDropCallback(widgetGuildListAdapter3)).attachToRecyclerView(getBinding().f2458b);
        RecyclerView recyclerView5 = getBinding().f2458b;
        Drawable drawable = ContextCompat.getDrawable(requireContext(), DrawableCompat.getThemedDrawableRes$default(requireContext(), R.attr.bg_folder_no_children, 0, 2, (Object) null));
        Intrinsics3.checkNotNull(drawable);
        Intrinsics3.checkNotNullExpressionValue(drawable, "ContextCompat.getDrawabl…children)\n            )!!");
        Drawable drawable2 = ContextCompat.getDrawable(requireContext(), DrawableCompat.getThemedDrawableRes$default(requireContext(), R.attr.bg_folder_tintable_no_children, 0, 2, (Object) null));
        Intrinsics3.checkNotNull(drawable2);
        Intrinsics3.checkNotNullExpressionValue(drawable2, "ContextCompat.getDrawabl…children)\n            )!!");
        Drawable drawable3 = ContextCompat.getDrawable(requireContext(), DrawableCompat.getThemedDrawableRes$default(requireContext(), R.attr.bg_folder_with_children, 0, 2, (Object) null));
        Intrinsics3.checkNotNull(drawable3);
        Intrinsics3.checkNotNullExpressionValue(drawable3, "ContextCompat.getDrawabl…children)\n            )!!");
        recyclerView5.addItemDecoration(new FolderItemDecoration(drawable, drawable2, drawable3, requireContext().getResources().getDimensionPixelSize(R.dimen.avatar_size_large)));
    }

    private final void showChannelActions(long channelId) {
        WidgetChannelsListItemChannelActions.Companion companion = WidgetChannelsListItemChannelActions.INSTANCE;
        FragmentManager parentFragmentManager = getParentFragmentManager();
        Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        companion.show(parentFragmentManager, channelId);
    }

    private final void showCreateGuild() {
        dismissAddGuildHint(true);
        WidgetGuildTemplates.INSTANCE.launch(requireContext(), CreateGuildTrigger.IN_APP, false);
    }

    private final void showHelp() {
        dismissAddGuildHint(true);
        WidgetNavigationHelp.Companion companion = WidgetNavigationHelp.INSTANCE;
        FragmentManager parentFragmentManager = getParentFragmentManager();
        Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        companion.show(parentFragmentManager);
    }

    private final void showHubVerification() {
        AppScreen2.d(requireContext(), WidgetHubEmailFlow.class, new WidgetHubEmailViewModel2(null, 0, null, 7, null));
    }

    private final void showUnavailableGuildsToast(int unavailableGuildCount) {
        Resources resources = getResources();
        Intrinsics3.checkNotNullExpressionValue(resources, "resources");
        AppToast.h(getContext(), FormatUtils.g(StringResourceUtils.getQuantityString(resources, requireContext(), R.plurals.partial_outage_count, unavailableGuildCount, Integer.valueOf(unavailableGuildCount)), new Object[0], (2 & 2) != 0 ? FormatUtils.e.j : null), 0, null, 12);
    }

    @Override // com.discord.widgets.guilds.list.WidgetGuildListAdapter.InteractionListener
    public boolean onDrop() {
        return getViewModel().onDrop();
    }

    @Override // com.discord.widgets.guilds.list.WidgetGuildListAdapter.InteractionListener
    public void onItemClicked(View view, GuildListItem item) {
        Intrinsics3.checkNotNullParameter(view, "view");
        Intrinsics3.checkNotNullParameter(item, "item");
        WidgetGuildsListViewModel viewModel = getViewModel();
        Context contextRequireContext = requireContext();
        FragmentManager parentFragmentManager = getParentFragmentManager();
        Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        viewModel.onItemClicked(item, contextRequireContext, parentFragmentManager);
    }

    @Override // com.discord.widgets.guilds.list.WidgetGuildListAdapter.InteractionListener
    public void onItemLongPressed(View view, GuildListItem item) {
        Intrinsics3.checkNotNullParameter(view, "view");
        Intrinsics3.checkNotNullParameter(item, "item");
        boolean z2 = item instanceof GuildListItem.GuildItem;
        if (!z2 && !(item instanceof GuildListItem.FolderItem)) {
            getViewModel().onItemLongPressed(item);
            return;
        }
        int[] iArr = new int[2];
        view.getLocationInWindow(iArr);
        PointF pointF = new PointF(iArr[0] + DimenUtils.dpToPixels(64), iArr[1]);
        if (z2) {
            WidgetGuildContextMenu.Companion companion = WidgetGuildContextMenu.INSTANCE;
            FragmentActivity fragmentActivityRequireActivity = requireActivity();
            Intrinsics3.checkNotNullExpressionValue(fragmentActivityRequireActivity, "requireActivity()");
            companion.show(fragmentActivityRequireActivity, pointF, ((GuildListItem.GuildItem) item).getGuild().getId());
            return;
        }
        if (item instanceof GuildListItem.FolderItem) {
            WidgetFolderContextMenu.Companion companion2 = WidgetFolderContextMenu.INSTANCE;
            FragmentActivity fragmentActivityRequireActivity2 = requireActivity();
            Intrinsics3.checkNotNullExpressionValue(fragmentActivityRequireActivity2, "requireActivity()");
            companion2.show(fragmentActivityRequireActivity2, pointF, ((GuildListItem.FolderItem) item).getFolderId());
        }
    }

    @Override // com.discord.widgets.guilds.list.WidgetGuildListAdapter.InteractionListener
    public void onItemMoved() {
        WidgetGuildContextMenu.Companion companion = WidgetGuildContextMenu.INSTANCE;
        FragmentActivity fragmentActivityRequireActivity = requireActivity();
        Intrinsics3.checkNotNullExpressionValue(fragmentActivityRequireActivity, "requireActivity()");
        companion.hide(fragmentActivityRequireActivity, true);
        WidgetFolderContextMenu.Companion companion2 = WidgetFolderContextMenu.INSTANCE;
        FragmentActivity fragmentActivityRequireActivity2 = requireActivity();
        Intrinsics3.checkNotNullExpressionValue(fragmentActivityRequireActivity2, "requireActivity()");
        companion2.hide(fragmentActivityRequireActivity2, true);
    }

    @Override // com.discord.widgets.guilds.list.WidgetGuildListAdapter.InteractionListener
    public void onOperation(WidgetGuildListAdapter.Operation operation) {
        Intrinsics3.checkNotNullParameter(operation, "operation");
        if (operation instanceof WidgetGuildListAdapter.Operation.MoveAbove) {
            WidgetGuildListAdapter.Operation.MoveAbove moveAbove = (WidgetGuildListAdapter.Operation.MoveAbove) operation;
            getViewModel().moveAbove(moveAbove.getFromPosition(), moveAbove.getTargetPosition());
        } else if (operation instanceof WidgetGuildListAdapter.Operation.MoveBelow) {
            WidgetGuildListAdapter.Operation.MoveBelow moveBelow = (WidgetGuildListAdapter.Operation.MoveBelow) operation;
            getViewModel().moveBelow(moveBelow.getFromPosition(), moveBelow.getTargetPosition());
        } else if (operation instanceof WidgetGuildListAdapter.Operation.TargetOperation) {
            WidgetGuildListAdapter.Operation.TargetOperation targetOperation = (WidgetGuildListAdapter.Operation.TargetOperation) operation;
            getViewModel().target(targetOperation.getFromPosition(), targetOperation.getTargetPosition());
        }
    }

    @Override // com.discord.app.AppFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), (Class<?>) WidgetGuildsList.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass1());
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().listenForEvents(), this, null, 2, null), (Class<?>) WidgetGuildsList.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass2());
        AddGuildHint.Companion companion = AddGuildHint.INSTANCE;
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(companion.get(), this, null, 2, null), (Class<?>) WidgetGuildsList.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass3());
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(companion.getDismissAction(), this, null, 2, null), (Class<?>) WidgetGuildsList.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass4());
        configureBottomNavSpace();
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        setupRecycler();
        ViewStub viewStub = getBinding().c;
        Intrinsics3.checkNotNullExpressionValue(viewStub, "binding.guildListUnreadsStub");
        RecyclerView recyclerView = getBinding().f2458b;
        Intrinsics3.checkNotNullExpressionValue(recyclerView, "binding.guildList");
        WidgetChannelListUnreads widgetChannelListUnreads = new WidgetChannelListUnreads(viewStub, recyclerView, null, new AnonymousClass1(), 0, 0, false, 116, null);
        this.guildListUnreads = widgetChannelListUnreads;
        if (widgetChannelListUnreads != null) {
            widgetChannelListUnreads.setMentionResId(R.string._new);
        }
        WidgetChannelListUnreads widgetChannelListUnreads2 = this.guildListUnreads;
        if (widgetChannelListUnreads2 != null) {
            widgetChannelListUnreads2.setUnreadsEnabled(false);
        }
        Fragment parentFragment = getParentFragment();
        if (!(parentFragment instanceof WidgetHome)) {
            parentFragment = null;
        }
        WidgetHome widgetHome = (WidgetHome) parentFragment;
        if (widgetHome != null) {
            widgetHome.setOnGuildListAddHintCreate(new AnonymousClass2());
        }
    }
}
