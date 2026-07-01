package com.discord.widgets.settings.account;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.recyclerview.widget.RecyclerView;
import b.a.d.g0;
import b.a.d.i0;
import b.d.b.a.a;
import com.discord.R$layout;
import com.discord.app.AppFragment;
import com.discord.app.AppViewFlipper;
import com.discord.databinding.WidgetSettingsBlockedUsersBinding;
import com.discord.utilities.mg_recycler.MGRecyclerAdapter;
import com.discord.utilities.mg_recycler.MGRecyclerAdapter$Companion;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import d0.z.d.a0;
import d0.z.d.m;
import kotlin.Lazy;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: WidgetSettingsBlockedUsers.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsBlockedUsers extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetSettingsBlockedUsers.class, "binding", "getBinding()Lcom/discord/databinding/WidgetSettingsBlockedUsersBinding;", 0)};
    public static final WidgetSettingsBlockedUsers$Companion Companion = new WidgetSettingsBlockedUsers$Companion(null);
    private static final int VIEW_INDEX_EMPTY = 1;
    private static final int VIEW_INDEX_RECYCLER = 0;
    private WidgetSettingsBlockedUsersAdapter adapter;

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    public WidgetSettingsBlockedUsers() {
        super(R$layout.widget_settings_blocked_users);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetSettingsBlockedUsers$binding$2.INSTANCE, null, 2, null);
        WidgetSettingsBlockedUsers$viewModel$2 widgetSettingsBlockedUsers$viewModel$2 = WidgetSettingsBlockedUsers$viewModel$2.INSTANCE;
        g0 g0Var = new g0(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, a0.getOrCreateKotlinClass(WidgetSettingsBlockedUsersViewModel.class), new WidgetSettingsBlockedUsers$appViewModels$$inlined$viewModels$1(g0Var), new i0(widgetSettingsBlockedUsers$viewModel$2));
    }

    public static final /* synthetic */ void access$configureUI(WidgetSettingsBlockedUsers widgetSettingsBlockedUsers, WidgetSettingsBlockedUsersViewModel$ViewState widgetSettingsBlockedUsersViewModel$ViewState) {
        widgetSettingsBlockedUsers.configureUI(widgetSettingsBlockedUsersViewModel$ViewState);
    }

    public static final /* synthetic */ WidgetSettingsBlockedUsersViewModel access$getViewModel$p(WidgetSettingsBlockedUsers widgetSettingsBlockedUsers) {
        return widgetSettingsBlockedUsers.getViewModel();
    }

    public static final /* synthetic */ void access$handleEvent(WidgetSettingsBlockedUsers widgetSettingsBlockedUsers, WidgetSettingsBlockedUsersViewModel$Event widgetSettingsBlockedUsersViewModel$Event) {
        widgetSettingsBlockedUsers.handleEvent(widgetSettingsBlockedUsersViewModel$Event);
    }

    private final void configureUI(WidgetSettingsBlockedUsersViewModel$ViewState viewState) {
        if (m.areEqual(viewState, WidgetSettingsBlockedUsersViewModel$ViewState$Uninitialized.INSTANCE)) {
            return;
        }
        if (m.areEqual(viewState, WidgetSettingsBlockedUsersViewModel$ViewState$Empty.INSTANCE)) {
            showEmptyView();
        } else {
            if (!(viewState instanceof WidgetSettingsBlockedUsersViewModel$ViewState$Loaded)) {
                throw new NoWhenBranchMatchedException();
            }
            showBlockedUsers((WidgetSettingsBlockedUsersViewModel$ViewState$Loaded) viewState);
        }
    }

    private final WidgetSettingsBlockedUsersBinding getBinding() {
        return (WidgetSettingsBlockedUsersBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final WidgetSettingsBlockedUsersViewModel getViewModel() {
        return (WidgetSettingsBlockedUsersViewModel) this.viewModel.getValue();
    }

    private final void handleEvent(WidgetSettingsBlockedUsersViewModel$Event event) {
        if (!(event instanceof WidgetSettingsBlockedUsersViewModel$Event$ShowToast)) {
            throw new NoWhenBranchMatchedException();
        }
        handleShowToast((WidgetSettingsBlockedUsersViewModel$Event$ShowToast) event);
    }

    private final void handleShowToast(WidgetSettingsBlockedUsersViewModel$Event$ShowToast event) {
        b.a.d.m.i(this, event.getStringRes(), 0, 4);
    }

    private final void showBlockedUsers(WidgetSettingsBlockedUsersViewModel$ViewState$Loaded viewState) {
        AppViewFlipper appViewFlipper = getBinding().f2611b;
        m.checkNotNullExpressionValue(appViewFlipper, "binding.blockedUsersFlipper");
        appViewFlipper.setDisplayedChild(0);
        WidgetSettingsBlockedUsersAdapter widgetSettingsBlockedUsersAdapter = this.adapter;
        if (widgetSettingsBlockedUsersAdapter == null) {
            m.throwUninitializedPropertyAccessException("adapter");
        }
        widgetSettingsBlockedUsersAdapter.setData(viewState.getItems());
    }

    private final void showEmptyView() {
        AppViewFlipper appViewFlipper = getBinding().f2611b;
        m.checkNotNullExpressionValue(appViewFlipper, "binding.blockedUsersFlipper");
        appViewFlipper.setDisplayedChild(1);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), WidgetSettingsBlockedUsers.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetSettingsBlockedUsers$onViewBoundOrOnResume$1(this), 62, (Object) null);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeEvents(), this, null, 2, null), WidgetSettingsBlockedUsers.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetSettingsBlockedUsers$onViewBoundOrOnResume$2(this), 62, (Object) null);
    }

    @Override // com.discord.app.AppFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        m.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        setActionBarTitle(2131896856);
        AppFragment.setActionBarDisplayHomeAsUpEnabled$default(this, false, 1, null);
        RecyclerView recyclerView = getBinding().c;
        MGRecyclerAdapter$Companion mGRecyclerAdapter$Companion = MGRecyclerAdapter.Companion;
        m.checkNotNullExpressionValue(recyclerView, "it");
        WidgetSettingsBlockedUsersAdapter widgetSettingsBlockedUsersAdapter = (WidgetSettingsBlockedUsersAdapter) mGRecyclerAdapter$Companion.configure(new WidgetSettingsBlockedUsersAdapter(recyclerView));
        this.adapter = widgetSettingsBlockedUsersAdapter;
        if (widgetSettingsBlockedUsersAdapter == null) {
            m.throwUninitializedPropertyAccessException("adapter");
        }
        widgetSettingsBlockedUsersAdapter.setOnClickUnblock(new WidgetSettingsBlockedUsers$onViewCreated$2(this));
        WidgetSettingsBlockedUsersAdapter widgetSettingsBlockedUsersAdapter2 = this.adapter;
        if (widgetSettingsBlockedUsersAdapter2 == null) {
            m.throwUninitializedPropertyAccessException("adapter");
        }
        widgetSettingsBlockedUsersAdapter2.setOnClickUserProfile(new WidgetSettingsBlockedUsers$onViewCreated$3(this));
    }
}
