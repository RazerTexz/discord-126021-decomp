package com.discord.widgets.settings.account;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.C5419R;
import com.discord.app.AppFragment;
import com.discord.app.AppViewFlipper;
import com.discord.databinding.WidgetSettingsBlockedUsersBinding;
import com.discord.models.user.User;
import com.discord.utilities.error.Error;
import com.discord.utilities.mg_recycler.MGRecyclerAdapter;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.widgets.settings.account.WidgetSettingsBlockedUsersViewModel;
import com.discord.widgets.user.usersheet.WidgetUserSheet;
import kotlin.Lazy;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p007b.p008a.p018d.C0865g0;
import p007b.p008a.p018d.C0869i0;
import p007b.p008a.p018d.C0870j;
import p007b.p008a.p018d.C0876m;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12216a0;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;
import p658rx.Subscription;

/* JADX INFO: compiled from: WidgetSettingsBlockedUsers.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsBlockedUsers extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {C1643a.m846d0(WidgetSettingsBlockedUsers.class, "binding", "getBinding()Lcom/discord/databinding/WidgetSettingsBlockedUsersBinding;", 0)};

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
            C12238m.checkNotNullParameter(context, "context");
            C0870j.m157e(context, WidgetSettingsBlockedUsers.class, null, 4);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.account.WidgetSettingsBlockedUsers$onViewBoundOrOnResume$1 */
    /* JADX INFO: compiled from: WidgetSettingsBlockedUsers.kt */
    public static final /* synthetic */ class C97741 extends C12236k implements Function1<WidgetSettingsBlockedUsersViewModel.ViewState, Unit> {
        public C97741(WidgetSettingsBlockedUsers widgetSettingsBlockedUsers) {
            super(1, widgetSettingsBlockedUsers, WidgetSettingsBlockedUsers.class, "configureUI", "configureUI(Lcom/discord/widgets/settings/account/WidgetSettingsBlockedUsersViewModel$ViewState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetSettingsBlockedUsersViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetSettingsBlockedUsersViewModel.ViewState viewState) {
            C12238m.checkNotNullParameter(viewState, "p1");
            ((WidgetSettingsBlockedUsers) this.receiver).configureUI(viewState);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.account.WidgetSettingsBlockedUsers$onViewBoundOrOnResume$2 */
    /* JADX INFO: compiled from: WidgetSettingsBlockedUsers.kt */
    public static final /* synthetic */ class C97752 extends C12236k implements Function1<WidgetSettingsBlockedUsersViewModel.Event, Unit> {
        public C97752(WidgetSettingsBlockedUsers widgetSettingsBlockedUsers) {
            super(1, widgetSettingsBlockedUsers, WidgetSettingsBlockedUsers.class, "handleEvent", "handleEvent(Lcom/discord/widgets/settings/account/WidgetSettingsBlockedUsersViewModel$Event;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetSettingsBlockedUsersViewModel.Event event) {
            invoke2(event);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetSettingsBlockedUsersViewModel.Event event) {
            C12238m.checkNotNullParameter(event, "p1");
            ((WidgetSettingsBlockedUsers) this.receiver).handleEvent(event);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.account.WidgetSettingsBlockedUsers$onViewCreated$2 */
    /* JADX INFO: compiled from: WidgetSettingsBlockedUsers.kt */
    public static final class C97762 extends AbstractC12240o implements Function1<User, Unit> {
        public C97762() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(User user) {
            invoke2(user);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(User user) {
            C12238m.checkNotNullParameter(user, "user");
            WidgetSettingsBlockedUsers.this.getViewModel().onClickUnblock(user.getId());
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.account.WidgetSettingsBlockedUsers$onViewCreated$3 */
    /* JADX INFO: compiled from: WidgetSettingsBlockedUsers.kt */
    public static final class C97773 extends AbstractC12240o implements Function1<User, Unit> {
        public C97773() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(User user) {
            invoke2(user);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(User user) {
            C12238m.checkNotNullParameter(user, "user");
            WidgetUserSheet.Companion companion = WidgetUserSheet.INSTANCE;
            long id2 = user.getId();
            FragmentManager parentFragmentManager = WidgetSettingsBlockedUsers.this.getParentFragmentManager();
            C12238m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
            WidgetUserSheet.Companion.show$default(companion, id2, null, parentFragmentManager, null, null, null, null, 122, null);
        }
    }

    public WidgetSettingsBlockedUsers() {
        super(C5419R.layout.widget_settings_blocked_users);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetSettingsBlockedUsers$binding$2.INSTANCE, null, 2, null);
        WidgetSettingsBlockedUsers$viewModel$2 widgetSettingsBlockedUsers$viewModel$2 = WidgetSettingsBlockedUsers$viewModel$2.INSTANCE;
        C0865g0 c0865g0 = new C0865g0(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, C12216a0.getOrCreateKotlinClass(WidgetSettingsBlockedUsersViewModel.class), new WidgetSettingsBlockedUsers$appViewModels$$inlined$viewModels$1(c0865g0), new C0869i0(widgetSettingsBlockedUsers$viewModel$2));
    }

    private final void configureUI(WidgetSettingsBlockedUsersViewModel.ViewState viewState) {
        if (C12238m.areEqual(viewState, WidgetSettingsBlockedUsersViewModel.ViewState.Uninitialized.INSTANCE)) {
            return;
        }
        if (C12238m.areEqual(viewState, WidgetSettingsBlockedUsersViewModel.ViewState.Empty.INSTANCE)) {
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
        C0876m.m171i(this, event.getStringRes(), 0, 4);
    }

    private final void showBlockedUsers(WidgetSettingsBlockedUsersViewModel.ViewState.Loaded viewState) {
        AppViewFlipper appViewFlipper = getBinding().f17918b;
        C12238m.checkNotNullExpressionValue(appViewFlipper, "binding.blockedUsersFlipper");
        appViewFlipper.setDisplayedChild(0);
        WidgetSettingsBlockedUsersAdapter widgetSettingsBlockedUsersAdapter = this.adapter;
        if (widgetSettingsBlockedUsersAdapter == null) {
            C12238m.throwUninitializedPropertyAccessException("adapter");
        }
        widgetSettingsBlockedUsersAdapter.setData(viewState.getItems());
    }

    private final void showEmptyView() {
        AppViewFlipper appViewFlipper = getBinding().f17918b;
        C12238m.checkNotNullExpressionValue(appViewFlipper, "binding.blockedUsersFlipper");
        appViewFlipper.setDisplayedChild(1);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), (Class<?>) WidgetSettingsBlockedUsers.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C97741(this));
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeEvents(), this, null, 2, null), (Class<?>) WidgetSettingsBlockedUsers.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C97752(this));
    }

    @Override // com.discord.app.AppFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        C12238m.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        setActionBarTitle(C5419R.string.user_settings_blocked_users);
        AppFragment.setActionBarDisplayHomeAsUpEnabled$default(this, false, 1, null);
        RecyclerView recyclerView = getBinding().f17919c;
        MGRecyclerAdapter.Companion companion = MGRecyclerAdapter.INSTANCE;
        C12238m.checkNotNullExpressionValue(recyclerView, "it");
        WidgetSettingsBlockedUsersAdapter widgetSettingsBlockedUsersAdapter = (WidgetSettingsBlockedUsersAdapter) companion.configure(new WidgetSettingsBlockedUsersAdapter(recyclerView));
        this.adapter = widgetSettingsBlockedUsersAdapter;
        if (widgetSettingsBlockedUsersAdapter == null) {
            C12238m.throwUninitializedPropertyAccessException("adapter");
        }
        widgetSettingsBlockedUsersAdapter.setOnClickUnblock(new C97762());
        WidgetSettingsBlockedUsersAdapter widgetSettingsBlockedUsersAdapter2 = this.adapter;
        if (widgetSettingsBlockedUsersAdapter2 == null) {
            C12238m.throwUninitializedPropertyAccessException("adapter");
        }
        widgetSettingsBlockedUsersAdapter2.setOnClickUserProfile(new C97773());
    }
}
