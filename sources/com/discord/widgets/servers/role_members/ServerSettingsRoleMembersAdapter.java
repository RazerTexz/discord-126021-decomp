package com.discord.widgets.servers.role_members;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView$Adapter;
import androidx.recyclerview.widget.RecyclerView$ViewHolder;
import com.discord.app.AppComponent;
import com.discord.databinding.RemovablePermissionOwnerViewBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.member.GuildMember;
import com.discord.models.user.User;
import com.discord.utilities.recycler.DiffCreator;
import d0.t.n;
import d0.z.d.m;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetServerSettingsRoleMembers.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ServerSettingsRoleMembersAdapter extends RecyclerView$Adapter<ServerSettingsRoleMembersViewHolder> {
    private final DiffCreator<List<ServerSettingsRoleMemberAdapterItem>, ServerSettingsRoleMembersViewHolder> diffCreator;
    private List<ServerSettingsRoleMemberAdapterItem> items;
    private Function2<? super GuildMember, ? super User, Unit> removeMemberClickListener;

    public /* synthetic */ ServerSettingsRoleMembersAdapter(AppComponent appComponent, DiffCreator diffCreator, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(appComponent, (i & 2) != 0 ? new DiffCreator(appComponent) : diffCreator);
    }

    public static final /* synthetic */ List access$getItems$p(ServerSettingsRoleMembersAdapter serverSettingsRoleMembersAdapter) {
        return serverSettingsRoleMembersAdapter.items;
    }

    public static final /* synthetic */ void access$setItems$p(ServerSettingsRoleMembersAdapter serverSettingsRoleMembersAdapter, List list) {
        serverSettingsRoleMembersAdapter.items = list;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$Adapter
    public int getItemCount() {
        return this.items.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView$Adapter
    public /* bridge */ /* synthetic */ void onBindViewHolder(RecyclerView$ViewHolder recyclerView$ViewHolder, int i) {
        onBindViewHolder((ServerSettingsRoleMembersViewHolder) recyclerView$ViewHolder, i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$Adapter
    public /* bridge */ /* synthetic */ RecyclerView$ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return onCreateViewHolder(viewGroup, i);
    }

    public final void setItems(List<ServerSettingsRoleMemberAdapterItem> newItems) {
        m.checkNotNullParameter(newItems, "newItems");
        this.diffCreator.dispatchDiffUpdatesAsync(this, new ServerSettingsRoleMembersAdapter$setItems$1(this), this.items, newItems);
    }

    public final void setRemoveMemberClickListener(Function2<? super GuildMember, ? super User, Unit> removeMemberClickListener) {
        m.checkNotNullParameter(removeMemberClickListener, "removeMemberClickListener");
        this.removeMemberClickListener = removeMemberClickListener;
    }

    public ServerSettingsRoleMembersAdapter(AppComponent appComponent, DiffCreator<List<ServerSettingsRoleMemberAdapterItem>, ServerSettingsRoleMembersViewHolder> diffCreator) {
        m.checkNotNullParameter(appComponent, "appComponent");
        m.checkNotNullParameter(diffCreator, "diffCreator");
        this.diffCreator = diffCreator;
        this.items = n.emptyList();
    }

    public void onBindViewHolder(ServerSettingsRoleMembersViewHolder holder, int position) {
        m.checkNotNullParameter(holder, "holder");
        ServerSettingsRoleMemberAdapterItem serverSettingsRoleMemberAdapterItem = this.items.get(position);
        Function2<? super GuildMember, ? super User, Unit> function2 = this.removeMemberClickListener;
        if (function2 == null) {
            m.throwUninitializedPropertyAccessException("removeMemberClickListener");
        }
        holder.configureUI(serverSettingsRoleMemberAdapterItem, function2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$Adapter
    public ServerSettingsRoleMembersViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        m.checkNotNullParameter(parent, "parent");
        RemovablePermissionOwnerViewBinding removablePermissionOwnerViewBindingA = RemovablePermissionOwnerViewBinding.a(LayoutInflater.from(parent.getContext()), parent, false);
        m.checkNotNullExpressionValue(removablePermissionOwnerViewBindingA, "RemovablePermissionOwner…rent,\n        false\n    )");
        return new ServerSettingsRoleMembersViewHolder(removablePermissionOwnerViewBindingA);
    }
}
