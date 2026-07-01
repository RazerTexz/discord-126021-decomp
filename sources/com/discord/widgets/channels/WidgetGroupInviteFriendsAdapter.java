package com.discord.widgets.channels;

import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.R;
import com.discord.databinding.WidgetGroupInviteFriendsItemBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.presence.Presence;
import com.discord.models.user.User;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.mg_recycler.MGRecyclerAdapterSimple;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import com.discord.utilities.presence.PresenceUtils;
import com.discord.utilities.view.text.SimpleDraweeSpanTextView;
import com.discord.views.StatusView;
import com.discord.widgets.channels.WidgetGroupInviteFriends;
import com.discord.widgets.channels.WidgetGroupInviteFriendsAdapter;
import com.facebook.drawee.view.SimpleDraweeView;
import d0.z.d.Intrinsics3;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: WidgetGroupInviteFriendsAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGroupInviteFriendsAdapter extends MGRecyclerAdapterSimple<WidgetGroupInviteFriends.Model.FriendItem> {
    private Function2<? super User, ? super Boolean, Unit> listener;

    /* JADX INFO: compiled from: WidgetGroupInviteFriendsAdapter.kt */
    public final class WidgetGroupInviteFriendsListItem extends MGRecyclerViewHolder<WidgetGroupInviteFriendsAdapter, WidgetGroupInviteFriends.Model.FriendItem> {
        private final WidgetGroupInviteFriendsItemBinding binding;
        public final /* synthetic */ WidgetGroupInviteFriendsAdapter this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public WidgetGroupInviteFriendsListItem(WidgetGroupInviteFriendsAdapter widgetGroupInviteFriendsAdapter, WidgetGroupInviteFriendsAdapter widgetGroupInviteFriendsAdapter2) {
            super(R.layout.widget_group_invite_friends_item, widgetGroupInviteFriendsAdapter2);
            Intrinsics3.checkNotNullParameter(widgetGroupInviteFriendsAdapter2, "adapter");
            this.this$0 = widgetGroupInviteFriendsAdapter;
            View view = this.itemView;
            int i = R.id.friend_container;
            RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.friend_container);
            if (relativeLayout != null) {
                i = R.id.friends_list_item_avatar;
                SimpleDraweeView simpleDraweeView = (SimpleDraweeView) view.findViewById(R.id.friends_list_item_avatar);
                if (simpleDraweeView != null) {
                    i = R.id.friends_list_item_avatar_wrap;
                    RelativeLayout relativeLayout2 = (RelativeLayout) view.findViewById(R.id.friends_list_item_avatar_wrap);
                    if (relativeLayout2 != null) {
                        i = R.id.friends_list_item_game;
                        SimpleDraweeSpanTextView simpleDraweeSpanTextView = (SimpleDraweeSpanTextView) view.findViewById(R.id.friends_list_item_game);
                        if (simpleDraweeSpanTextView != null) {
                            i = R.id.friends_list_item_name;
                            TextView textView = (TextView) view.findViewById(R.id.friends_list_item_name);
                            if (textView != null) {
                                i = R.id.friends_list_item_status;
                                StatusView statusView = (StatusView) view.findViewById(R.id.friends_list_item_status);
                                if (statusView != null) {
                                    i = R.id.user_selected_checkbox;
                                    CheckBox checkBox = (CheckBox) view.findViewById(R.id.user_selected_checkbox);
                                    if (checkBox != null) {
                                        WidgetGroupInviteFriendsItemBinding widgetGroupInviteFriendsItemBinding = new WidgetGroupInviteFriendsItemBinding((LinearLayout) view, relativeLayout, simpleDraweeView, relativeLayout2, simpleDraweeSpanTextView, textView, statusView, checkBox);
                                        Intrinsics3.checkNotNullExpressionValue(widgetGroupInviteFriendsItemBinding, "WidgetGroupInviteFriendsItemBinding.bind(itemView)");
                                        this.binding = widgetGroupInviteFriendsItemBinding;
                                        return;
                                    }
                                }
                            }
                        }
                    }
                }
            }
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
        }

        public static final /* synthetic */ WidgetGroupInviteFriendsAdapter access$getAdapter$p(WidgetGroupInviteFriendsListItem widgetGroupInviteFriendsListItem) {
            return (WidgetGroupInviteFriendsAdapter) widgetGroupInviteFriendsListItem.adapter;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
        public void onConfigure(int position, final WidgetGroupInviteFriends.Model.FriendItem data) {
            Intrinsics3.checkNotNullParameter(data, "data");
            super.onConfigure(position, data);
            TextView textView = this.binding.e;
            Intrinsics3.checkNotNullExpressionValue(textView, "binding.friendsListItemName");
            User user = data.getUser();
            textView.setText(user != null ? user.getUsername() : null);
            this.binding.f.setPresence(data.getPresence());
            CheckBox checkBox = this.binding.g;
            Intrinsics3.checkNotNullExpressionValue(checkBox, "binding.userSelectedCheckbox");
            checkBox.setChecked(data.isSelected());
            this.binding.f2407b.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.channels.WidgetGroupInviteFriendsAdapter$WidgetGroupInviteFriendsListItem$onConfigure$1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    Function2 function2;
                    if (data.getUser() == null || (function2 = WidgetGroupInviteFriendsAdapter.WidgetGroupInviteFriendsListItem.access$getAdapter$p(this.this$0).listener) == null) {
                        return;
                    }
                }
            });
            Presence presence = data.getPresence();
            boolean zIsApplicationStreaming = data.isApplicationStreaming();
            SimpleDraweeSpanTextView simpleDraweeSpanTextView = this.binding.d;
            Intrinsics3.checkNotNullExpressionValue(simpleDraweeSpanTextView, "binding.friendsListItemGame");
            PresenceUtils.setPresenceText$default(presence, zIsApplicationStreaming, simpleDraweeSpanTextView, true, false, 16, null);
            SimpleDraweeView simpleDraweeView = this.binding.c;
            Intrinsics3.checkNotNullExpressionValue(simpleDraweeView, "binding.friendsListItemAvatar");
            IconUtils.setIcon$default(simpleDraweeView, data.getUser(), R.dimen.avatar_size_standard, null, null, null, 56, null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGroupInviteFriendsAdapter(RecyclerView recyclerView) {
        super(recyclerView, false, 2, null);
        Intrinsics3.checkNotNullParameter(recyclerView, "recycler");
    }

    public final void setData(List<WidgetGroupInviteFriends.Model.FriendItem> data, Function2<? super User, ? super Boolean, Unit> friendChosenListener) {
        Intrinsics3.checkNotNullParameter(data, "data");
        Intrinsics3.checkNotNullParameter(friendChosenListener, "friendChosenListener");
        super.setData(data);
        this.listener = friendChosenListener;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public WidgetGroupInviteFriendsListItem onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics3.checkNotNullParameter(parent, "parent");
        if (viewType == 0) {
            return new WidgetGroupInviteFriendsListItem(this, this);
        }
        throw invalidViewTypeException(viewType);
    }
}
