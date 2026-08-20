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
import com.discord.C5419R;
import com.discord.app.AppBottomSheet;
import com.discord.chips_view.ChipsView;
import com.discord.databinding.GroupInviteFriendsBottomSheetBinding;
import com.discord.models.user.User;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.error.Error;
import com.discord.utilities.mg_recycler.MGRecyclerAdapter;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
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
import p007b.p008a.p018d.C0865g0;
import p007b.p008a.p018d.C0869i0;
import p007b.p008a.p018d.C0876m;
import p007b.p008a.p027k.C1107b;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p580t.C12149o;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12216a0;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;
import p658rx.Subscription;

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
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {C1643a.m846d0(GroupInviteFriendsSheet.class, "binding", "getBinding()Lcom/discord/databinding/GroupInviteFriendsBottomSheetBinding;", 0)};

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
            C12238m.checkNotNullParameter(fragmentManager, "fragmentManager");
            C12238m.checkNotNullParameter(source, "source");
            GroupInviteFriendsSheet groupInviteFriendsSheet = new GroupInviteFriendsSheet();
            Bundle bundleM832T = C1643a.m832T("com.discord.intent.extra.EXTRA_CHANNEL_ID", channelId);
            if (channelId == -1) {
                AnalyticsTracker.openModal$default("DM Group Create", source, null, 4, null);
            } else {
                AnalyticsTracker.openModal$default("DM Group Add", source, null, 4, null);
            }
            groupInviteFriendsSheet.setArguments(bundleM832T);
            groupInviteFriendsSheet.show(fragmentManager, GroupInviteFriendsSheet.class.getSimpleName());
            return groupInviteFriendsSheet;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: GroupInviteFriendsSheet.kt */
    public static final class UserDataContract implements ChipsView.InterfaceC5465a {
        private final String displayString;
        private final User modelUser;

        public UserDataContract(User user) {
            C12238m.checkNotNullParameter(user, "modelUser");
            this.modelUser = user;
            this.displayString = user.getUsername();
        }

        @Override // com.discord.chips_view.ChipsView.InterfaceC5465a
        public String getDisplayString() {
            return this.displayString;
        }

        public final User getModelUser() {
            return this.modelUser;
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.channels.invite.GroupInviteFriendsSheet$onResume$1 */
    /* JADX INFO: compiled from: GroupInviteFriendsSheet.kt */
    public static final class C74051 extends AbstractC12240o implements Function1<GroupInviteFriendsSheetViewModel.ViewState, Unit> {
        public C74051() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(GroupInviteFriendsSheetViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(GroupInviteFriendsSheetViewModel.ViewState viewState) {
            C12238m.checkNotNullParameter(viewState, "viewState");
            GroupInviteFriendsSheet.this.updateView(viewState);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.channels.invite.GroupInviteFriendsSheet$onResume$2 */
    /* JADX INFO: compiled from: GroupInviteFriendsSheet.kt */
    public static final /* synthetic */ class C74062 extends C12236k implements Function1<GroupInviteFriendsSheetViewModel.Event, Unit> {
        public C74062(GroupInviteFriendsSheet groupInviteFriendsSheet) {
            super(1, groupInviteFriendsSheet, GroupInviteFriendsSheet.class, "handleEvent", "handleEvent(Lcom/discord/widgets/channels/invite/GroupInviteFriendsSheetViewModel$Event;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(GroupInviteFriendsSheetViewModel.Event event) {
            invoke2(event);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(GroupInviteFriendsSheetViewModel.Event event) {
            C12238m.checkNotNullParameter(event, "p1");
            ((GroupInviteFriendsSheet) this.receiver).handleEvent(event);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.channels.invite.GroupInviteFriendsSheet$onViewCreated$1 */
    /* JADX INFO: compiled from: GroupInviteFriendsSheet.kt */
    public static final class C74071 extends AbstractC12240o implements Function2<User, Boolean, Unit> {
        public C74071() {
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(User user, Boolean bool) {
            invoke(user, bool.booleanValue());
            return Unit.f27425a;
        }

        public final void invoke(User user, boolean z2) {
            C12238m.checkNotNullParameter(user, "user");
            GroupInviteFriendsSheet.this.getViewModel().onChangeUserChecked(user, z2);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.channels.invite.GroupInviteFriendsSheet$onViewCreated$2 */
    /* JADX INFO: compiled from: GroupInviteFriendsSheet.kt */
    public static final class C74082 extends AbstractC12240o implements Function1<UserDataContract, Unit> {
        public C74082() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(UserDataContract userDataContract) {
            invoke2(userDataContract);
            return Unit.f27425a;
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

    /* JADX INFO: renamed from: com.discord.widgets.channels.invite.GroupInviteFriendsSheet$onViewCreated$3 */
    /* JADX INFO: compiled from: GroupInviteFriendsSheet.kt */
    public static final class C74093 extends AbstractC12240o implements Function1<Object, Unit> {
        public C74093() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Object obj) {
            invoke2(obj);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Object obj) {
            GroupInviteFriendsSheet.this.getViewModel().onSearchTextChanged(String.valueOf(obj));
        }
    }

    public GroupInviteFriendsSheet() {
        super(false, 1, null);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, GroupInviteFriendsSheet$binding$2.INSTANCE, null, 2, null);
        GroupInviteFriendsSheet$viewModel$2 groupInviteFriendsSheet$viewModel$2 = new GroupInviteFriendsSheet$viewModel$2(this);
        C0865g0 c0865g0 = new C0865g0(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, C12216a0.getOrCreateKotlinClass(GroupInviteFriendsSheetViewModel.class), new GroupInviteFriendsSheet$appViewModels$$inlined$viewModels$1(c0865g0), new C0869i0(groupInviteFriendsSheet$viewModel$2));
    }

    private final GroupInviteFriendsBottomSheetBinding getBinding() {
        return (GroupInviteFriendsBottomSheetBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final GroupInviteFriendsSheetViewModel getViewModel() {
        return (GroupInviteFriendsSheetViewModel) this.viewModel.getValue();
    }

    private final void handleEvent(GroupInviteFriendsSheetViewModel.Event event) {
        if (event instanceof GroupInviteFriendsSheetViewModel.Event.ChannelFull) {
            C0876m.m171i(this, C5419R.string.group_dm_invite_full_sub, 0, 4);
        }
    }

    private final void resizeSheetHeight() {
        ConstraintLayout constraintLayout = getBinding().f15111d;
        C12238m.checkNotNullExpressionValue(constraintLayout, "binding.root");
        if (!ViewCompat.isLaidOut(constraintLayout) || constraintLayout.isLayoutRequested()) {
            constraintLayout.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: com.discord.widgets.channels.invite.GroupInviteFriendsSheet$resizeSheetHeight$$inlined$doOnLayout$1
                @Override // android.view.View.OnLayoutChangeListener
                public void onLayoutChange(View view, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {
                    C12238m.checkNotNullParameter(view, "view");
                    view.removeOnLayoutChangeListener(this);
                    ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                    Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
                    Resources resources = this.this$0.getResources();
                    C12238m.checkNotNullExpressionValue(resources, "resources");
                    layoutParams.height = (int) (resources.getDisplayMetrics().heightPixels * 0.9f);
                    view.setLayoutParams(layoutParams);
                }
            });
        } else {
            ViewGroup.LayoutParams layoutParams = constraintLayout.getLayoutParams();
            Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
            Resources resources = getResources();
            C12238m.checkNotNullExpressionValue(resources, "resources");
            layoutParams.height = (int) (resources.getDisplayMetrics().heightPixels * 0.9f);
            constraintLayout.setLayoutParams(layoutParams);
        }
        getBinding().f15110c.requestLayout();
    }

    private final void scrollToTopIfDeletingChar(int previousCount, int currentCount) {
        if (previousCount < currentCount) {
            getBinding().f15110c.smoothScrollToPosition(0);
        }
    }

    private final void updateView(GroupInviteFriendsSheetViewModel.ViewState viewState) {
        GroupInviteFriendsSheetAdapter groupInviteFriendsSheetAdapter = this.adapter;
        if (groupInviteFriendsSheetAdapter == null) {
            C12238m.throwUninitializedPropertyAccessException("adapter");
        }
        int itemCount = groupInviteFriendsSheetAdapter.getPageSize();
        GroupInviteFriendsSheetAdapter groupInviteFriendsSheetAdapter2 = this.adapter;
        if (groupInviteFriendsSheetAdapter2 == null) {
            C12238m.throwUninitializedPropertyAccessException("adapter");
        }
        groupInviteFriendsSheetAdapter2.setData(viewState.getFriendItems());
        scrollToTopIfDeletingChar(itemCount, viewState.getFriendItems().size());
        AppCompatImageView appCompatImageView = getBinding().f15112e;
        C12238m.checkNotNullExpressionValue(appCompatImageView, "binding.searchIcon");
        appCompatImageView.setVisibility(viewState.getShowSearchIcon() ? 0 : 8);
        for (User user : viewState.getCheckedUsers()) {
            ChipsView chipsView = getBinding().f15109b;
            String username = user.getUsername();
            String string = C1107b.m213e(this, C5419R.string.remove, new Object[]{user.getUsername()}, (4 & 4) != 0 ? C1107b.a.f1490j : null).toString();
            Long lValueOf = Long.valueOf(user.getId());
            C12238m.checkNotNullExpressionValue(user, "user");
            chipsView.m8376b(username, string, lValueOf, new UserDataContract(user));
        }
        ChipsView chipsView2 = getBinding().f15109b;
        HashSet<User> checkedUsers = viewState.getCheckedUsers();
        ArrayList arrayList = new ArrayList(C12149o.collectionSizeOrDefault(checkedUsers, 10));
        Iterator<T> it = checkedUsers.iterator();
        while (it.hasNext()) {
            arrayList.add(Long.valueOf(((User) it.next()).getId()));
        }
        chipsView2.m8378d(arrayList);
    }

    @Override // com.discord.app.AppBottomSheet
    public int getContentViewResId() {
        return C5419R.layout.group_invite_friends_bottom_sheet;
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), (Class<?>) GroupInviteFriendsSheet.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C74051());
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeEvents(), this, null, 2, null), (Class<?>) GroupInviteFriendsSheet.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C74062(this));
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        C12238m.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        MGRecyclerAdapter.Companion companion = MGRecyclerAdapter.INSTANCE;
        RecyclerView recyclerView = getBinding().f15110c;
        C12238m.checkNotNullExpressionValue(recyclerView, "binding.recyclerView");
        this.adapter = (GroupInviteFriendsSheetAdapter) companion.configure(new GroupInviteFriendsSheetAdapter(recyclerView, new C74071()));
        ChipsView chipsView = getBinding().f15109b;
        Objects.requireNonNull(chipsView, "null cannot be cast to non-null type com.discord.chips_view.ChipsView<com.discord.primitives.UserId /* = kotlin.Long */, com.discord.widgets.channels.invite.GroupInviteFriendsSheet.UserDataContract>");
        chipsView.setChipDeletedListener(new C74082());
        getBinding().f15109b.setTextChangedListener(new C74093());
        setBottomSheetCollapsedStateDisabled();
        resizeSheetHeight();
    }
}
