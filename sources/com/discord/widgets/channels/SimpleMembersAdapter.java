package com.discord.widgets.channels;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.databinding.SimpleMemberListItemBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.member.GuildMember;
import com.discord.models.user.User;
import com.discord.utilities.mg_recycler.MGRecyclerAdapterSimple;
import com.discord.utilities.mg_recycler.MGRecyclerDataPayload;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import com.discord.views.user.SettingsMemberView;
import com.discord.widgets.channels.SimpleMembersAdapter;
import d0.z.d.Intrinsics3;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: SimpleMembersAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class SimpleMembersAdapter extends MGRecyclerAdapterSimple<MemberItem> {
    private Function1<? super User, Unit> onUserClickedListener;

    /* JADX INFO: compiled from: SimpleMembersAdapter.kt */
    public static final class MemberAdapterItem extends MGRecyclerViewHolder<SimpleMembersAdapter, MemberItem> {
        private final SimpleMemberListItemBinding binding;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public MemberAdapterItem(SimpleMembersAdapter simpleMembersAdapter) {
            super(R.layout.simple_member_list_item, simpleMembersAdapter);
            Intrinsics3.checkNotNullParameter(simpleMembersAdapter, "adapter");
            View view = this.itemView;
            SettingsMemberView settingsMemberView = (SettingsMemberView) view.findViewById(R.id.member_view);
            if (settingsMemberView == null) {
                throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.member_view)));
            }
            SimpleMemberListItemBinding simpleMemberListItemBinding = new SimpleMemberListItemBinding((FrameLayout) view, settingsMemberView);
            Intrinsics3.checkNotNullExpressionValue(simpleMemberListItemBinding, "SimpleMemberListItemBinding.bind(itemView)");
            this.binding = simpleMemberListItemBinding;
        }

        public static final /* synthetic */ SimpleMembersAdapter access$getAdapter$p(MemberAdapterItem memberAdapterItem) {
            return (SimpleMembersAdapter) memberAdapterItem.adapter;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
        public void onConfigure(int position, MemberItem data) {
            Intrinsics3.checkNotNullParameter(data, "data");
            super.onConfigure(position, data);
            final User user = data.getUser();
            this.binding.f2142b.a(user, data.getGuildMember());
            this.binding.a.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.channels.SimpleMembersAdapter$MemberAdapterItem$onConfigure$1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    Function1 function1 = SimpleMembersAdapter.MemberAdapterItem.access$getAdapter$p(this.this$0).onUserClickedListener;
                    if (function1 != null) {
                    }
                }
            });
        }
    }

    /* JADX INFO: compiled from: SimpleMembersAdapter.kt */
    public static final /* data */ class MemberItem implements MGRecyclerDataPayload {
        public static final int TYPE_MEMBER = 0;
        private final GuildMember guildMember;
        private final String key;
        private final int type;
        private final User user;

        public MemberItem(User user, GuildMember guildMember) {
            Intrinsics3.checkNotNullParameter(user, "user");
            this.user = user;
            this.guildMember = guildMember;
            this.key = String.valueOf(user.getId());
        }

        public static /* synthetic */ MemberItem copy$default(MemberItem memberItem, User user, GuildMember guildMember, int i, Object obj) {
            if ((i & 1) != 0) {
                user = memberItem.user;
            }
            if ((i & 2) != 0) {
                guildMember = memberItem.guildMember;
            }
            return memberItem.copy(user, guildMember);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final User getUser() {
            return this.user;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final GuildMember getGuildMember() {
            return this.guildMember;
        }

        public final MemberItem copy(User user, GuildMember guildMember) {
            Intrinsics3.checkNotNullParameter(user, "user");
            return new MemberItem(user, guildMember);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof MemberItem)) {
                return false;
            }
            MemberItem memberItem = (MemberItem) other;
            return Intrinsics3.areEqual(this.user, memberItem.user) && Intrinsics3.areEqual(this.guildMember, memberItem.guildMember);
        }

        public final GuildMember getGuildMember() {
            return this.guildMember;
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

        public int hashCode() {
            User user = this.user;
            int iHashCode = (user != null ? user.hashCode() : 0) * 31;
            GuildMember guildMember = this.guildMember;
            return iHashCode + (guildMember != null ? guildMember.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("MemberItem(user=");
            sbU.append(this.user);
            sbU.append(", guildMember=");
            sbU.append(this.guildMember);
            sbU.append(")");
            return sbU.toString();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SimpleMembersAdapter(RecyclerView recyclerView) {
        super(recyclerView, false, 2, null);
        Intrinsics3.checkNotNullParameter(recyclerView, "recycler");
    }

    public final void setData(List<MemberItem> data, Function1<? super User, Unit> onUserClickedListener) {
        Intrinsics3.checkNotNullParameter(data, "data");
        Intrinsics3.checkNotNullParameter(onUserClickedListener, "onUserClickedListener");
        super.setData(data);
        this.onUserClickedListener = onUserClickedListener;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public MemberAdapterItem onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics3.checkNotNullParameter(parent, "parent");
        if (viewType == 0) {
            return new MemberAdapterItem(this);
        }
        throw invalidViewTypeException(viewType);
    }
}
