package com.discord.widgets.settings.account;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.recyclerview.widget.RecyclerView;
import b.a.d.AppScreen2;
import b.a.d.AppToast;
import b.a.d.AppViewModelDelegates3;
import b.a.d.AppViewModelDelegates5;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.app.AppFragment;
import com.discord.app.AppViewFlipper;
import com.discord.databinding.WidgetSettingsBlockedUsersBinding;
import com.discord.models.user.User;
import com.discord.utilities.error.Error;
import com.discord.utilities.mg_recycler.MGRecyclerAdapter;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.widgets.settings.account.WidgetSettingsBlockedUsersViewModel;
import com.discord.widgets.user.usersheet.WidgetUserSheet;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import d0.z.d.Reflection2;
import kotlin.Lazy;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import rx.Subscription;

/* JADX INFO: compiled from: WidgetSettingsBlockedUsers.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsBlockedUsers extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetSettingsBlockedUsers.class, "binding", "getBinding()Lcom/discord/databinding/WidgetSettingsBlockedUsersBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final int VIEW_INDEX_EMPTY = 1;
    private static final int VIEW_INDEX_RECYCLER = 0;
    private WidgetSettingsBlockedUsersAdapter adapter;

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* JADX INFO: compiled from: WidgetSettingsBlockedUsers.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void launch(Context context) {
            Intrinsics3.checkNotNullParameter(context, "context");
            AppScreen2.e(context, WidgetSettingsBlockedUsers.class, null, 4);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.account.WidgetSettingsBlockedUsers$onViewBoundOrOnResume$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetSettingsBlockedUsers.kt */
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<WidgetSettingsBlockedUsersViewModel.ViewState, Unit> {
        public AnonymousClass1(WidgetSettingsBlockedUsers widgetSettingsBlockedUsers) {
            super(1, widgetSettingsBlockedUsers, WidgetSettingsBlockedUsers.class, "configureUI", "configureUI(Lcom/discord/widgets/settings/account/WidgetSettingsBlockedUsersViewModel$ViewState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetSettingsBlockedUsersViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetSettingsBlockedUsersViewModel.ViewState viewState) {
            Intrinsics3.checkNotNullParameter(viewState, "p1");
            ((WidgetSettingsBlockedUsers) this.receiver).configureUI(viewState);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.account.WidgetSettingsBlockedUsers$onViewBoundOrOnResume$2, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetSettingsBlockedUsers.kt */
    public static final /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function1<WidgetSettingsBlockedUsersViewModel.Event, Unit> {
        public AnonymousClass2(WidgetSettingsBlockedUsers widgetSettingsBlockedUsers) {
            super(1, widgetSettingsBlockedUsers, WidgetSettingsBlockedUsers.class, "handleEvent", "handleEvent(Lcom/discord/widgets/settings/account/WidgetSettingsBlockedUsersViewModel$Event;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetSettingsBlockedUsersViewModel.Event event) {
            invoke2(event);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetSettingsBlockedUsersViewModel.Event event) {
            Intrinsics3.checkNotNullParameter(event, "p1");
            ((WidgetSettingsBlockedUsers) this.receiver).handleEvent(event);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.account.WidgetSettingsBlockedUsers$onViewCreated$2, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetSettingsBlockedUsers.kt */
    public static final class AnonymousClass2 extends Lambda implements Function1<User, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(User user) {
            invoke2(user);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(User user) {
            Intrinsics3.checkNotNullParameter(user, "user");
            WidgetSettingsBlockedUsers.this.getViewModel().onClickUnblock(user.getId());
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.account.WidgetSettingsBlockedUsers$onViewCreated$3, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetSettingsBlockedUsers.kt */
    public static final class AnonymousClass3 extends Lambda implements Function1<User, Unit> {
        public AnonymousClass3() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(User user) {
            invoke2(user);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(User user) {
            Intrinsics3.checkNotNullParameter(user, "user");
            WidgetUserSheet.Companion companion = WidgetUserSheet.INSTANCE;
            long id2 = user.getId();
            FragmentManager parentFragmentManager = WidgetSettingsBlockedUsers.this.getParentFragmentManager();
            Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
            WidgetUserSheet.Companion.show$default(companion, id2, null, parentFragmentManager, null, null, null, null, 122, null);
        }
    }

    public WidgetSettingsBlockedUsers() {
        super(R.layout.widget_settings_blocked_users);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetSettingsBlockedUsers2.INSTANCE, null, 2, null);
        WidgetSettingsBlockedUsers3 widgetSettingsBlockedUsers3 = WidgetSettingsBlockedUsers3.INSTANCE;
        AppViewModelDelegates3 appViewModelDelegates3 = new AppViewModelDelegates3(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(WidgetSettingsBlockedUsersViewModel.class), new WidgetSettingsBlockedUsers$appViewModels$$inlined$viewModels$1(appViewModelDelegates3), new AppViewModelDelegates5(widgetSettingsBlockedUsers3));
    }

    private final void configureUI(WidgetSettingsBlockedUsersViewModel.ViewState viewState) {
        if (Intrinsics3.areEqual(viewState, WidgetSettingsBlockedUsersViewModel.ViewState.Uninitialized.INSTANCE)) {
            return;
        }
        if (Intrinsics3.areEqual(viewState, WidgetSettingsBlockedUsersViewModel.ViewState.Empty.INSTANCE)) {
            showEmptyView();
        } else {
            if (!(viewState instanceof WidgetSettingsBlockedUsersViewModel.ViewState.Loaded)) {
                throw new NoWhenBranchMatchedException();
            }
            showBlockedUsers((WidgetSettingsBlockedUsersViewModel.ViewState.Loaded) viewState);
        }
    }

    private final WidgetSettingsBlockedUsersBinding getBinding() {
        return (WidgetSettingsBlockedUsersBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final WidgetSettingsBlockedUsersViewModel getViewModel() {
        return (WidgetSettingsBlockedUsersViewModel) this.viewModel.getValue();
    }

    private final void handleEvent(WidgetSettingsBlockedUsersViewModel.Event event) {
        if (!(event instanceof WidgetSettingsBlockedUsersViewModel.Event.ShowToast)) {
            throw new NoWhenBranchMatchedException();
        }
        handleShowToast((WidgetSettingsBlockedUsersViewModel.Event.ShowToast) event);
    }

    private final void handleShowToast(WidgetSettingsBlockedUsersViewModel.Event.ShowToast event) {
        AppToast.i(this, event.getStringRes(), 0, 4);
    }

    private final void showBlockedUsers(WidgetSettingsBlockedUsersViewModel.ViewState.Loaded viewState) {
        AppViewFlipper appViewFlipper = getBinding().f2611b;
        Intrinsics3.checkNotNullExpressionValue(appViewFlipper, "binding.blockedUsersFlipper");
        appViewFlipper.setDisplayedChild(0);
        WidgetSettingsBlockedUsersAdapter widgetSettingsBlockedUsersAdapter = this.adapter;
        if (widgetSettingsBlockedUsersAdapter == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("adapter");
        }
        widgetSettingsBlockedUsersAdapter.setData(viewState.getItems());
    }

    private final void showEmptyView() {
        AppViewFlipper appViewFlipper = getBinding().f2611b;
        Intrinsics3.checkNotNullExpressionValue(appViewFlipper, "binding.blockedUsersFlipper");
        appViewFlipper.setDisplayedChild(1);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), (Class<?>) WidgetSettingsBlockedUsers.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass1(this));
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeEvents(), this, null, 2, null), (Class<?>) WidgetSettingsBlockedUsers.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass2(this));
    }

    @Override // com.discord.app.AppFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        setActionBarTitle(R.string.user_settings_blocked_users);
        AppFragment.setActionBarDisplayHomeAsUpEnabled$default(this, false, 1, null);
        RecyclerView recyclerView = getBinding().c;
        MGRecyclerAdapter.Companion companion = MGRecyclerAdapter.INSTANCE;
        Intrinsics3.checkNotNullExpressionValue(recyclerView, "it");
        WidgetSettingsBlockedUsersAdapter widgetSettingsBlockedUsersAdapter = (WidgetSettingsBlockedUsersAdapter) companion.configure(new WidgetSettingsBlockedUsersAdapter(recyclerView));
        this.adapter = widgetSettingsBlockedUsersAdapter;
        if (widgetSettingsBlockedUsersAdapter == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("adapter");
        }
        widgetSettingsBlockedUsersAdapter.setOnClickUnblock(new AnonymousClass2());
        WidgetSettingsBlockedUsersAdapter widgetSettingsBlockedUsersAdapter2 = this.adapter;
        if (widgetSettingsBlockedUsersAdapter2 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("adapter");
        }
        widgetSettingsBlockedUsersAdapter2.setOnClickUserProfile(new AnonymousClass3());
    }
}
