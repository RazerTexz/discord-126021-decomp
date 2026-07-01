package com.discord.widgets.servers.role_members;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.databinding.RemovablePermissionOwnerViewBinding;
import com.discord.models.member.GuildMember;
import com.discord.models.user.User;
import d0.z.d.Intrinsics3;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: renamed from: com.discord.widgets.servers.role_members.ServerSettingsRoleMembersViewHolder, reason: use source file name */
/* JADX INFO: compiled from: WidgetServerSettingsRoleMembers.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsRoleMembers3 extends RecyclerView.ViewHolder {
    private final RemovablePermissionOwnerViewBinding binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetServerSettingsRoleMembers3(RemovablePermissionOwnerViewBinding removablePermissionOwnerViewBinding) {
        super(removablePermissionOwnerViewBinding.a);
        Intrinsics3.checkNotNullParameter(removablePermissionOwnerViewBinding, "binding");
        this.binding = removablePermissionOwnerViewBinding;
    }

    public final void configureUI(final ServerSettingsRoleMemberAdapterItem adapterItem, final Function2<? super GuildMember, ? super User, Unit> removeMemberClickListener) {
        Intrinsics3.checkNotNullParameter(adapterItem, "adapterItem");
        Intrinsics3.checkNotNullParameter(removeMemberClickListener, "removeMemberClickListener");
        this.binding.f2138b.a(adapterItem.getPermissionOwner());
        this.binding.c.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.servers.role_members.ServerSettingsRoleMembersViewHolder.configureUI.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                removeMemberClickListener.invoke(adapterItem.getGuildMember(), adapterItem.getPermissionOwner().getUser());
            }
        });
    }
}
