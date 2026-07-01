package com.discord.widgets.channels.invite;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup$LayoutParams;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.recyclerview.widget.RecyclerView;
import b.a.d.g0;
import b.a.d.i0;
import b.a.d.m;
import b.a.k.b;
import b.d.b.a.a;
import com.discord.R$layout;
import com.discord.app.AppBottomSheet;
import com.discord.chips_view.ChipsView;
import com.discord.databinding.GroupInviteFriendsBottomSheetBinding;
import com.discord.models.user.User;
import com.discord.utilities.mg_recycler.MGRecyclerAdapter;
import com.discord.utilities.mg_recycler.MGRecyclerAdapter$Companion;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import d0.t.o;
import d0.z.d.a0;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;

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
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(GroupInviteFriendsSheet.class, "binding", "getBinding()Lcom/discord/databinding/GroupInviteFriendsBottomSheetBinding;", 0)};
    public static final GroupInviteFriendsSheet$Companion Companion = new GroupInviteFriendsSheet$Companion(null);

    public GroupInviteFriendsSheet() {
        super(false, 1, null);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, GroupInviteFriendsSheet$binding$2.INSTANCE, null, 2, null);
        GroupInviteFriendsSheet$viewModel$2 groupInviteFriendsSheet$viewModel$2 = new GroupInviteFriendsSheet$viewModel$2(this);
        g0 g0Var = new g0(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, a0.getOrCreateKotlinClass(GroupInviteFriendsSheetViewModel.class), new GroupInviteFriendsSheet$appViewModels$$inlined$viewModels$1(g0Var), new i0(groupInviteFriendsSheet$viewModel$2));
    }

    public static final /* synthetic */ GroupInviteFriendsSheetViewModel access$getViewModel$p(GroupInviteFriendsSheet groupInviteFriendsSheet) {
        return groupInviteFriendsSheet.getViewModel();
    }

    public static final /* synthetic */ void access$handleEvent(GroupInviteFriendsSheet groupInviteFriendsSheet, GroupInviteFriendsSheetViewModel$Event groupInviteFriendsSheetViewModel$Event) {
        groupInviteFriendsSheet.handleEvent(groupInviteFriendsSheetViewModel$Event);
    }

    public static final /* synthetic */ void access$updateView(GroupInviteFriendsSheet groupInviteFriendsSheet, GroupInviteFriendsSheetViewModel$ViewState groupInviteFriendsSheetViewModel$ViewState) {
        groupInviteFriendsSheet.updateView(groupInviteFriendsSheetViewModel$ViewState);
    }

    private final GroupInviteFriendsBottomSheetBinding getBinding() {
        return (GroupInviteFriendsBottomSheetBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final GroupInviteFriendsSheetViewModel getViewModel() {
        return (GroupInviteFriendsSheetViewModel) this.viewModel.getValue();
    }

    private final void handleEvent(GroupInviteFriendsSheetViewModel$Event event) {
        if (event instanceof GroupInviteFriendsSheetViewModel$Event$ChannelFull) {
            m.i(this, 2131889809, 0, 4);
        }
    }

    private final void resizeSheetHeight() {
        ConstraintLayout constraintLayout = getBinding().d;
        d0.z.d.m.checkNotNullExpressionValue(constraintLayout, "binding.root");
        if (!ViewCompat.isLaidOut(constraintLayout) || constraintLayout.isLayoutRequested()) {
            constraintLayout.addOnLayoutChangeListener(new GroupInviteFriendsSheet$resizeSheetHeight$$inlined$doOnLayout$1(this));
        } else {
            ViewGroup$LayoutParams layoutParams = constraintLayout.getLayoutParams();
            Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
            Resources resources = getResources();
            d0.z.d.m.checkNotNullExpressionValue(resources, "resources");
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

    private final void updateView(GroupInviteFriendsSheetViewModel$ViewState viewState) {
        GroupInviteFriendsSheetAdapter groupInviteFriendsSheetAdapter = this.adapter;
        if (groupInviteFriendsSheetAdapter == null) {
            d0.z.d.m.throwUninitializedPropertyAccessException("adapter");
        }
        int itemCount = groupInviteFriendsSheetAdapter.getItemCount();
        GroupInviteFriendsSheetAdapter groupInviteFriendsSheetAdapter2 = this.adapter;
        if (groupInviteFriendsSheetAdapter2 == null) {
            d0.z.d.m.throwUninitializedPropertyAccessException("adapter");
        }
        groupInviteFriendsSheetAdapter2.setData(viewState.getFriendItems());
        scrollToTopIfDeletingChar(itemCount, viewState.getFriendItems().size());
        AppCompatImageView appCompatImageView = getBinding().e;
        d0.z.d.m.checkNotNullExpressionValue(appCompatImageView, "binding.searchIcon");
        appCompatImageView.setVisibility(viewState.getShowSearchIcon() ? 0 : 8);
        for (User user : viewState.getCheckedUsers()) {
            ChipsView chipsView = getBinding().f2114b;
            String username = user.getUsername();
            String string = b.k(this, 2131894737, new Object[]{user.getUsername()}, null, 4).toString();
            Long lValueOf = Long.valueOf(user.getId());
            d0.z.d.m.checkNotNullExpressionValue(user, "user");
            chipsView.b(username, string, lValueOf, new GroupInviteFriendsSheet$UserDataContract(user));
        }
        ChipsView chipsView2 = getBinding().f2114b;
        HashSet<User> checkedUsers = viewState.getCheckedUsers();
        ArrayList arrayList = new ArrayList(o.collectionSizeOrDefault(checkedUsers, 10));
        Iterator<T> it = checkedUsers.iterator();
        while (it.hasNext()) {
            arrayList.add(Long.valueOf(((User) it.next()).getId()));
        }
        chipsView2.d(arrayList);
    }

    @Override // com.discord.app.AppBottomSheet
    public int getContentViewResId() {
        return R$layout.group_invite_friends_bottom_sheet;
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), GroupInviteFriendsSheet.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new GroupInviteFriendsSheet$onResume$1(this), 62, (Object) null);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeEvents(), this, null, 2, null), GroupInviteFriendsSheet.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new GroupInviteFriendsSheet$onResume$2(this), 62, (Object) null);
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        d0.z.d.m.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        MGRecyclerAdapter$Companion mGRecyclerAdapter$Companion = MGRecyclerAdapter.Companion;
        RecyclerView recyclerView = getBinding().c;
        d0.z.d.m.checkNotNullExpressionValue(recyclerView, "binding.recyclerView");
        this.adapter = (GroupInviteFriendsSheetAdapter) mGRecyclerAdapter$Companion.configure(new GroupInviteFriendsSheetAdapter(recyclerView, new GroupInviteFriendsSheet$onViewCreated$1(this)));
        ChipsView chipsView = getBinding().f2114b;
        Objects.requireNonNull(chipsView, "null cannot be cast to non-null type com.discord.chips_view.ChipsView<com.discord.primitives.UserId /* = kotlin.Long */, com.discord.widgets.channels.invite.GroupInviteFriendsSheet.UserDataContract>");
        chipsView.setChipDeletedListener(new GroupInviteFriendsSheet$onViewCreated$2(this));
        getBinding().f2114b.setTextChangedListener(new GroupInviteFriendsSheet$onViewCreated$3(this));
        setBottomSheetCollapsedStateDisabled();
        resizeSheetHeight();
    }
}
