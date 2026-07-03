package com.discord.widgets.servers.role_members;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.databinding.RemovablePermissionOwnerViewBinding;
import com.discord.models.member.GuildMember;
import com.discord.models.user.User;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetServerSettingsRoleMembers.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ServerSettingsRoleMembersViewHolder extends RecyclerView.ViewHolder {
    private final RemovablePermissionOwnerViewBinding binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ServerSettingsRoleMembersViewHolder(RemovablePermissionOwnerViewBinding removablePermissionOwnerViewBinding) {
        super(removablePermissionOwnerViewBinding.f15225a);
        C12238m.checkNotNullParameter(removablePermissionOwnerViewBinding, "binding");
        this.binding = removablePermissionOwnerViewBinding;
    }

    public final void configureUI(final ServerSettingsRoleMemberAdapterItem adapterItem, final Function2<? super GuildMember, ? super User, Unit> removeMemberClickListener) {
        C12238m.checkNotNullParameter(adapterItem, "adapterItem");
        C12238m.checkNotNullParameter(removeMemberClickListener, "removeMemberClickListener");
        this.binding.f15226b.m8598a(adapterItem.getPermissionOwner());
        this.binding.f15227c.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.servers.role_members.ServerSettingsRoleMembersViewHolder.configureUI.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                removeMemberClickListener.invoke(adapterItem.getGuildMember(), adapterItem.getPermissionOwner().getUser());
            }
        });
    }
}
