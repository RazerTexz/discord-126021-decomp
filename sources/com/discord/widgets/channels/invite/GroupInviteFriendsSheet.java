package com.discord.widgets.channels.invite;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.recyclerview.widget.RecyclerView;
import b.a.d.AppToast;
import b.a.d.AppViewModelDelegates3;
import b.a.d.AppViewModelDelegates5;
import b.a.k.FormatUtils;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.app.AppBottomSheet;
import com.discord.chips_view.ChipsView;
import com.discord.databinding.GroupInviteFriendsBottomSheetBinding;
import com.discord.models.user.User;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.error.Error;
import com.discord.utilities.mg_recycler.MGRecyclerAdapter;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.widgets.channels.invite.GroupInviteFriendsSheetViewModel;
import d0.t.Iterables2;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import d0.z.d.Reflection2;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import rx.Subscription;

/* JADX INFO: compiled from: GroupInviteFriendsSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GroupInviteFriendsSheet extends AppBottomSheet {
    public static final float BOTTOM_SHEET_HEIGHT_PERCENT = 0.9f;
    public static final long NO_CHANNEL_ID = -1;
    private GroupInviteFriendsSheetAdapter adapter;

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(GroupInviteFriendsSheet.class, "binding", "getBinding()Lcom/discord/databinding/GroupInviteFriendsBottomSheetBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: compiled from: GroupInviteFriendsSheet.kt */
    public static final class Companion {
        private Companion() {
        }

        public static /* synthetic */ GroupInviteFriendsSheet show$default(Companion companion, FragmentManager fragmentManager, long j, String str, int i, Object obj) {
            if ((i & 2) != 0) {
                j = -1;
            }
            return companion.show(fragmentManager, j, str);
        }

        public final GroupInviteFriendsSheet show(FragmentManager fragmentManager, long channelId, String source) {
            Intrinsics3.checkNotNullParameter(fragmentManager, "fragmentManager");
            Intrinsics3.checkNotNullParameter(source, "source");
            GroupInviteFriendsSheet groupInviteFriendsSheet = new GroupInviteFriendsSheet();
            Bundle bundleT = outline.T("com.discord.intent.extra.EXTRA_CHANNEL_ID", channelId);
            if (channelId == -1) {
                AnalyticsTracker.openModal$default("DM Group Create", source, null, 4, null);
            } else {
                AnalyticsTracker.openModal$default("DM Group Add", source, null, 4, null);
            }
            groupInviteFriendsSheet.setArguments(bundleT);
            groupInviteFriendsSheet.show(fragmentManager, GroupInviteFriendsSheet.class.getSimpleName());
            return groupInviteFriendsSheet;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: GroupInviteFriendsSheet.kt */
    public static final class UserDataContract implements ChipsView.a {
        private final String displayString;
        private final User modelUser;

        public UserDataContract(User user) {
            Intrinsics3.checkNotNullParameter(user, "modelUser");
            this.modelUser = user;
            this.displayString = user.getUsername();
        }

        @Override // com.discord.chips_view.ChipsView.a
        public String getDisplayString() {
            return this.displayString;
        }

        public final User getModelUser() {
            return this.modelUser;
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.channels.invite.GroupInviteFriendsSheet$onResume$1, reason: invalid class name */
    /* JADX INFO: compiled from: GroupInviteFriendsSheet.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<GroupInviteFriendsSheetViewModel.ViewState, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(GroupInviteFriendsSheetViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(GroupInviteFriendsSheetViewModel.ViewState viewState) {
            Intrinsics3.checkNotNullParameter(viewState, "viewState");
            GroupInviteFriendsSheet.this.updateView(viewState);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.channels.invite.GroupInviteFriendsSheet$onResume$2, reason: invalid class name */
    /* JADX INFO: compiled from: GroupInviteFriendsSheet.kt */
    public static final /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function1<GroupInviteFriendsSheetViewModel.Event, Unit> {
        public AnonymousClass2(GroupInviteFriendsSheet groupInviteFriendsSheet) {
            super(1, groupInviteFriendsSheet, GroupInviteFriendsSheet.class, "handleEvent", "handleEvent(Lcom/discord/widgets/channels/invite/GroupInviteFriendsSheetViewModel$Event;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(GroupInviteFriendsSheetViewModel.Event event) {
            invoke2(event);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(GroupInviteFriendsSheetViewModel.Event event) {
            Intrinsics3.checkNotNullParameter(event, "p1");
            ((GroupInviteFriendsSheet) this.receiver).handleEvent(event);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.channels.invite.GroupInviteFriendsSheet$onViewCreated$1, reason: invalid class name */
    /* JADX INFO: compiled from: GroupInviteFriendsSheet.kt */
    public static final class AnonymousClass1 extends Lambda implements Function2<User, Boolean, Unit> {
        public AnonymousClass1() {
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(User user, Boolean bool) {
            invoke(user, bool.booleanValue());
            return Unit.a;
        }

        public final void invoke(User user, boolean z2) {
            Intrinsics3.checkNotNullParameter(user, "user");
            GroupInviteFriendsSheet.this.getViewModel().onChangeUserChecked(user, z2);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.channels.invite.GroupInviteFriendsSheet$onViewCreated$2, reason: invalid class name */
    /* JADX INFO: compiled from: GroupInviteFriendsSheet.kt */
    public static final class AnonymousClass2 extends Lambda implements Function1<UserDataContract, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(UserDataContract userDataContract) {
            invoke2(userDataContract);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(UserDataContract userDataContract) {
            User modelUser;
            if (userDataContract == null || (modelUser = userDataContract.getModelUser()) == null) {
                return;
            }
            GroupInviteFriendsSheet.this.getViewModel().onChangeUserChecked(modelUser, false);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.channels.invite.GroupInviteFriendsSheet$onViewCreated$3, reason: invalid class name */
    /* JADX INFO: compiled from: GroupInviteFriendsSheet.kt */
    public static final class AnonymousClass3 extends Lambda implements Function1<Object, Unit> {
        public AnonymousClass3() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Object obj) {
            invoke2(obj);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Object obj) {
            GroupInviteFriendsSheet.this.getViewModel().onSearchTextChanged(String.valueOf(obj));
        }
    }

    public GroupInviteFriendsSheet() {
        super(false, 1, null);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, GroupInviteFriendsSheet2.INSTANCE, null, 2, null);
        GroupInviteFriendsSheet3 groupInviteFriendsSheet3 = new GroupInviteFriendsSheet3(this);
        AppViewModelDelegates3 appViewModelDelegates3 = new AppViewModelDelegates3(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(GroupInviteFriendsSheetViewModel.class), new GroupInviteFriendsSheet$appViewModels$$inlined$viewModels$1(appViewModelDelegates3), new AppViewModelDelegates5(groupInviteFriendsSheet3));
    }

    private final GroupInviteFriendsBottomSheetBinding getBinding() {
        return (GroupInviteFriendsBottomSheetBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final GroupInviteFriendsSheetViewModel getViewModel() {
        return (GroupInviteFriendsSheetViewModel) this.viewModel.getValue();
    }

    private final void handleEvent(GroupInviteFriendsSheetViewModel.Event event) {
        if (event instanceof GroupInviteFriendsSheetViewModel.Event.ChannelFull) {
            AppToast.i(this, R.string.group_dm_invite_full_sub, 0, 4);
        }
    }

    private final void resizeSheetHeight() {
        ConstraintLayout constraintLayout = getBinding().d;
        Intrinsics3.checkNotNullExpressionValue(constraintLayout, "binding.root");
        if (!ViewCompat.isLaidOut(constraintLayout) || constraintLayout.isLayoutRequested()) {
            constraintLayout.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: com.discord.widgets.channels.invite.GroupInviteFriendsSheet$resizeSheetHeight$$inlined$doOnLayout$1
                @Override // android.view.View.OnLayoutChangeListener
                public void onLayoutChange(View view, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {
                    Intrinsics3.checkNotNullParameter(view, "view");
                    view.removeOnLayoutChangeListener(this);
                    ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                    Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
                    Resources resources = this.this$0.getResources();
                    Intrinsics3.checkNotNullExpressionValue(resources, "resources");
                    layoutParams.height = (int) (resources.getDisplayMetrics().heightPixels * 0.9f);
                    view.setLayoutParams(layoutParams);
                }
            });
        } else {
            ViewGroup.LayoutParams layoutParams = constraintLayout.getLayoutParams();
            Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
            Resources resources = getResources();
            Intrinsics3.checkNotNullExpressionValue(resources, "resources");
            layoutParams.height = (int) (resources.getDisplayMetrics().heightPixels * 0.9f);
            constraintLayout.setLayoutParams(layoutParams);
        }
        getBinding().c.requestLayout();
    }

    private final void scrollToTopIfDeletingChar(int previousCount, int currentCount) {
        if (previousCount < currentCount) {
            getBinding().c.smoothScrollToPosition(0);
        }
    }

    private final void updateView(GroupInviteFriendsSheetViewModel.ViewState viewState) {
        GroupInviteFriendsSheetAdapter groupInviteFriendsSheetAdapter = this.adapter;
        if (groupInviteFriendsSheetAdapter == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("adapter");
        }
        int itemCount = groupInviteFriendsSheetAdapter.getPageSize();
        GroupInviteFriendsSheetAdapter groupInviteFriendsSheetAdapter2 = this.adapter;
        if (groupInviteFriendsSheetAdapter2 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("adapter");
        }
        groupInviteFriendsSheetAdapter2.setData(viewState.getFriendItems());
        scrollToTopIfDeletingChar(itemCount, viewState.getFriendItems().size());
        AppCompatImageView appCompatImageView = getBinding().e;
        Intrinsics3.checkNotNullExpressionValue(appCompatImageView, "binding.searchIcon");
        appCompatImageView.setVisibility(viewState.getShowSearchIcon() ? 0 : 8);
        for (User user : viewState.getCheckedUsers()) {
            ChipsView chipsView = getBinding().f2114b;
            String username = user.getUsername();
            String string = FormatUtils.e(this, R.string.remove, new Object[]{user.getUsername()}, (4 & 4) != 0 ? FormatUtils.a.j : null).toString();
            Long lValueOf = Long.valueOf(user.getId());
            Intrinsics3.checkNotNullExpressionValue(user, "user");
            chipsView.b(username, string, lValueOf, new UserDataContract(user));
        }
        ChipsView chipsView2 = getBinding().f2114b;
        HashSet<User> checkedUsers = viewState.getCheckedUsers();
        ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(checkedUsers, 10));
        Iterator<T> it = checkedUsers.iterator();
        while (it.hasNext()) {
            arrayList.add(Long.valueOf(((User) it.next()).getId()));
        }
        chipsView2.d(arrayList);
    }

    @Override // com.discord.app.AppBottomSheet
    public int getContentViewResId() {
        return R.layout.group_invite_friends_bottom_sheet;
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), (Class<?>) GroupInviteFriendsSheet.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass1());
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeEvents(), this, null, 2, null), (Class<?>) GroupInviteFriendsSheet.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass2(this));
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        MGRecyclerAdapter.Companion companion = MGRecyclerAdapter.INSTANCE;
        RecyclerView recyclerView = getBinding().c;
        Intrinsics3.checkNotNullExpressionValue(recyclerView, "binding.recyclerView");
        this.adapter = (GroupInviteFriendsSheetAdapter) companion.configure(new GroupInviteFriendsSheetAdapter(recyclerView, new AnonymousClass1()));
        ChipsView chipsView = getBinding().f2114b;
        Objects.requireNonNull(chipsView, "null cannot be cast to non-null type com.discord.chips_view.ChipsView<com.discord.primitives.UserId /* = kotlin.Long */, com.discord.widgets.channels.invite.GroupInviteFriendsSheet.UserDataContract>");
        chipsView.setChipDeletedListener(new AnonymousClass2());
        getBinding().f2114b.setTextChangedListener(new AnonymousClass3());
        setBottomSheetCollapsedStateDisabled();
        resizeSheetHeight();
    }
}
