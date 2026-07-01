package com.discord.widgets.servers.role_members;

import androidx.recyclerview.widget.RecyclerView$ViewHolder;
import com.discord.databinding.RemovablePermissionOwnerViewBinding;
import com.discord.models.member.GuildMember;
import com.discord.models.user.User;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: WidgetServerSettingsRoleMembers.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ServerSettingsRoleMembersViewHolder extends RecyclerView$ViewHolder {
    private final RemovablePermissionOwnerViewBinding binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ServerSettingsRoleMembersViewHolder(RemovablePermissionOwnerViewBinding removablePermissionOwnerViewBinding) {
        super(removablePermissionOwnerViewBinding.a);
        m.checkNotNullParameter(removablePermissionOwnerViewBinding, "binding");
        this.binding = removablePermissionOwnerViewBinding;
    }

    public final void configureUI(ServerSettingsRoleMemberAdapterItem adapterItem, Function2<? super GuildMember, ? super User, Unit> removeMemberClickListener) {
        m.checkNotNullParameter(adapterItem, "adapterItem");
        m.checkNotNullParameter(removeMemberClickListener, "removeMemberClickListener");
        this.binding.f2138b.a(adapterItem.getPermissionOwner());
        this.binding.c.setOnClickListener(new ServerSettingsRoleMembersViewHolder$configureUI$1(removeMemberClickListener, adapterItem));
    }
}
