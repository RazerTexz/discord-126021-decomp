package com.discord.widgets.channels;

import android.view.View;
import android.widget.FrameLayout;
import com.discord.R$id;
import com.discord.R$layout;
import com.discord.databinding.SimpleMemberListItemBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.user.User;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import com.discord.views.user.SettingsMemberView;
import d0.z.d.m;

/* JADX INFO: compiled from: SimpleMembersAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class SimpleMembersAdapter$MemberAdapterItem extends MGRecyclerViewHolder<SimpleMembersAdapter, SimpleMembersAdapter$MemberItem> {
    private final SimpleMemberListItemBinding binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SimpleMembersAdapter$MemberAdapterItem(SimpleMembersAdapter simpleMembersAdapter) {
        super(R$layout.simple_member_list_item, simpleMembersAdapter);
        m.checkNotNullParameter(simpleMembersAdapter, "adapter");
        View view = this.itemView;
        SettingsMemberView settingsMemberView = (SettingsMemberView) view.findViewById(R$id.member_view);
        if (settingsMemberView == null) {
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R$id.member_view)));
        }
        SimpleMemberListItemBinding simpleMemberListItemBinding = new SimpleMemberListItemBinding((FrameLayout) view, settingsMemberView);
        m.checkNotNullExpressionValue(simpleMemberListItemBinding, "SimpleMemberListItemBinding.bind(itemView)");
        this.binding = simpleMemberListItemBinding;
    }

    public static final /* synthetic */ SimpleMembersAdapter access$getAdapter$p(SimpleMembersAdapter$MemberAdapterItem simpleMembersAdapter$MemberAdapterItem) {
        return (SimpleMembersAdapter) simpleMembersAdapter$MemberAdapterItem.adapter;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
    public /* bridge */ /* synthetic */ void onConfigure(int i, SimpleMembersAdapter$MemberItem simpleMembersAdapter$MemberItem) {
        onConfigure2(i, simpleMembersAdapter$MemberItem);
    }

    /* JADX INFO: renamed from: onConfigure, reason: avoid collision after fix types in other method */
    public void onConfigure2(int position, SimpleMembersAdapter$MemberItem data) {
        m.checkNotNullParameter(data, "data");
        super.onConfigure(position, data);
        User user = data.getUser();
        this.binding.f2142b.a(user, data.getGuildMember());
        this.binding.a.setOnClickListener(new SimpleMembersAdapter$MemberAdapterItem$onConfigure$1(this, user));
    }
}
