package com.discord.widgets.channels.invite;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.LayoutRes;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.databinding.GroupInviteFriendsSheetItemBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.user.User;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.mg_recycler.MGRecyclerAdapterSimple;
import com.discord.utilities.mg_recycler.MGRecyclerDataPayload;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import com.discord.widgets.channels.invite.GroupInviteFriendsSheetAdapter;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.checkbox.MaterialCheckBox;
import d0.z.d.Intrinsics3;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: GroupInviteFriendsSheetAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GroupInviteFriendsSheetAdapter extends MGRecyclerAdapterSimple<FriendItem> {
    private final Function2<User, Boolean, Unit> onUserChecked;

    /* JADX INFO: compiled from: GroupInviteFriendsSheetAdapter.kt */
    public static final /* data */ class FriendItem implements MGRecyclerDataPayload {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        public static final int TYPE_FRIEND = 0;
        private final boolean isSelected;
        private final String key;
        private final int type;
        private final User user;

        /* JADX INFO: compiled from: GroupInviteFriendsSheetAdapter.kt */
        public static final class Companion {
            private Companion() {
            }

            public final ArrayList<FriendItem> createItems(Collection<? extends User> users, Set<? extends User> checkedUsers) {
                Intrinsics3.checkNotNullParameter(users, "users");
                Intrinsics3.checkNotNullParameter(checkedUsers, "checkedUsers");
                ArrayList<FriendItem> arrayList = new ArrayList<>();
                for (User user : users) {
                    arrayList.add(new FriendItem(user, checkedUsers.contains(user)));
                }
                return arrayList;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public FriendItem(User user, boolean z2) {
            Intrinsics3.checkNotNullParameter(user, "user");
            this.user = user;
            this.isSelected = z2;
            this.key = String.valueOf(user.getId());
        }

        public static /* synthetic */ FriendItem copy$default(FriendItem friendItem, User user, boolean z2, int i, Object obj) {
            if ((i & 1) != 0) {
                user = friendItem.user;
            }
            if ((i & 2) != 0) {
                z2 = friendItem.isSelected;
            }
            return friendItem.copy(user, z2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final User getUser() {
            return this.user;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final boolean getIsSelected() {
            return this.isSelected;
        }

        public final FriendItem copy(User user, boolean isSelected) {
            Intrinsics3.checkNotNullParameter(user, "user");
            return new FriendItem(user, isSelected);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof FriendItem)) {
                return false;
            }
            FriendItem friendItem = (FriendItem) other;
            return Intrinsics3.areEqual(this.user, friendItem.user) && this.isSelected == friendItem.isSelected;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
        public String getKey() {
            return this.key;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
        public int getType() {
            return this.type;
        }

        public final User getUser() {
            return this.user;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v4, types: [int] */
        /* JADX WARN: Type inference failed for: r1v1, types: [int] */
        /* JADX WARN: Type inference failed for: r1v2 */
        /* JADX WARN: Type inference failed for: r1v3 */
        public int hashCode() {
            User user = this.user;
            int iHashCode = (user != null ? user.hashCode() : 0) * 31;
            boolean z2 = this.isSelected;
            ?? r1 = z2;
            if (z2) {
                r1 = 1;
            }
            return iHashCode + r1;
        }

        public final boolean isSelected() {
            return this.isSelected;
        }

        public String toString() {
            StringBuilder sbU = outline.U("FriendItem(user=");
            sbU.append(this.user);
            sbU.append(", isSelected=");
            return outline.O(sbU, this.isSelected, ")");
        }
    }

    /* JADX INFO: compiled from: GroupInviteFriendsSheetAdapter.kt */
    public static final class GroupInviteFriendsListItem extends MGRecyclerViewHolder<GroupInviteFriendsSheetAdapter, FriendItem> {
        private final GroupInviteFriendsSheetItemBinding binding;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public GroupInviteFriendsListItem(@LayoutRes int i, GroupInviteFriendsSheetAdapter groupInviteFriendsSheetAdapter) {
            super(i, groupInviteFriendsSheetAdapter);
            Intrinsics3.checkNotNullParameter(groupInviteFriendsSheetAdapter, "adapter");
            View view = this.itemView;
            int i2 = R.id.friends_list_item_avatar;
            SimpleDraweeView simpleDraweeView = (SimpleDraweeView) view.findViewById(R.id.friends_list_item_avatar);
            if (simpleDraweeView != null) {
                i2 = R.id.friends_list_item_name;
                TextView textView = (TextView) view.findViewById(R.id.friends_list_item_name);
                if (textView != null) {
                    i2 = R.id.user_selected_checkbox;
                    MaterialCheckBox materialCheckBox = (MaterialCheckBox) view.findViewById(R.id.user_selected_checkbox);
                    if (materialCheckBox != null) {
                        GroupInviteFriendsSheetItemBinding groupInviteFriendsSheetItemBinding = new GroupInviteFriendsSheetItemBinding((ConstraintLayout) view, simpleDraweeView, textView, materialCheckBox);
                        Intrinsics3.checkNotNullExpressionValue(groupInviteFriendsSheetItemBinding, "GroupInviteFriendsSheetItemBinding.bind(itemView)");
                        this.binding = groupInviteFriendsSheetItemBinding;
                        return;
                    }
                }
            }
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i2)));
        }

        public static final /* synthetic */ GroupInviteFriendsSheetAdapter access$getAdapter$p(GroupInviteFriendsListItem groupInviteFriendsListItem) {
            return (GroupInviteFriendsSheetAdapter) groupInviteFriendsListItem.adapter;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
        public void onConfigure(int position, FriendItem data) {
            Intrinsics3.checkNotNullParameter(data, "data");
            super.onConfigure(position, data);
            final User user = data.getUser();
            TextView textView = this.binding.c;
            Intrinsics3.checkNotNullExpressionValue(textView, "binding.friendsListItemName");
            textView.setText(user.getUsername());
            SimpleDraweeView simpleDraweeView = this.binding.f2115b;
            Intrinsics3.checkNotNullExpressionValue(simpleDraweeView, "binding.friendsListItemAvatar");
            IconUtils.setIcon$default(simpleDraweeView, user, R.dimen.avatar_size_standard, null, null, null, 56, null);
            MaterialCheckBox materialCheckBox = this.binding.d;
            Intrinsics3.checkNotNullExpressionValue(materialCheckBox, "binding.userSelectedCheckbox");
            materialCheckBox.setChecked(data.isSelected());
            this.binding.d.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.channels.invite.GroupInviteFriendsSheetAdapter$GroupInviteFriendsListItem$onConfigure$1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MaterialCheckBox materialCheckBox2 = this.this$0.binding.d;
                    Intrinsics3.checkNotNullExpressionValue(materialCheckBox2, "binding.userSelectedCheckbox");
                    GroupInviteFriendsSheetAdapter.GroupInviteFriendsListItem.access$getAdapter$p(this.this$0).getOnUserChecked().invoke(user, Boolean.valueOf(materialCheckBox2.isChecked()));
                }
            });
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public GroupInviteFriendsSheetAdapter(RecyclerView recyclerView, Function2<? super User, ? super Boolean, Unit> function2) {
        super(recyclerView, false, 2, null);
        Intrinsics3.checkNotNullParameter(recyclerView, "recycler");
        Intrinsics3.checkNotNullParameter(function2, "onUserChecked");
        this.onUserChecked = function2;
    }

    public final Function2<User, Boolean, Unit> getOnUserChecked() {
        return this.onUserChecked;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public MGRecyclerViewHolder<?, FriendItem> onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics3.checkNotNullParameter(parent, "parent");
        if (viewType == 0) {
            return new GroupInviteFriendsListItem(R.layout.group_invite_friends_sheet_item, this);
        }
        throw invalidViewTypeException(viewType);
    }
}
