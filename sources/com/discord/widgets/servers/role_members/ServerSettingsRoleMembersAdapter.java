package com.discord.widgets.servers.role_members;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.app.AppComponent;
import com.discord.databinding.RemovablePermissionOwnerViewBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.member.GuildMember;
import com.discord.models.user.User;
import com.discord.utilities.recycler.DiffCreator;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p507d0.p580t.C12147n;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetServerSettingsRoleMembers.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ServerSettingsRoleMembersAdapter extends RecyclerView.Adapter<ServerSettingsRoleMembersViewHolder> {
    private final DiffCreator<List<ServerSettingsRoleMemberAdapterItem>, ServerSettingsRoleMembersViewHolder> diffCreator;
    private List<ServerSettingsRoleMemberAdapterItem> items;
    private Function2<? super GuildMember, ? super User, Unit> removeMemberClickListener;

    /* JADX INFO: renamed from: com.discord.widgets.servers.role_members.ServerSettingsRoleMembersAdapter$setItems$1 */
    /* JADX INFO: compiled from: WidgetServerSettingsRoleMembers.kt */
    public static final class C95681 extends AbstractC12240o implements Function1<List<? extends ServerSettingsRoleMemberAdapterItem>, Unit> {
        public C95681() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(List<? extends ServerSettingsRoleMemberAdapterItem> list) {
            invoke2((List<ServerSettingsRoleMemberAdapterItem>) list);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(List<ServerSettingsRoleMemberAdapterItem> list) {
            C12238m.checkNotNullParameter(list, "items");
            ServerSettingsRoleMembersAdapter.this.items = list;
        }
    }

    public /* synthetic */ ServerSettingsRoleMembersAdapter(AppComponent appComponent, DiffCreator diffCreator, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(appComponent, (i & 2) != 0 ? new DiffCreator(appComponent) : diffCreator);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: getItemCount */
    public int getPageSize() {
        return this.items.size();
    }

    public final void setItems(List<ServerSettingsRoleMemberAdapterItem> newItems) {
        C12238m.checkNotNullParameter(newItems, "newItems");
        this.diffCreator.dispatchDiffUpdatesAsync(this, new C95681(), this.items, newItems);
    }

    public final void setRemoveMemberClickListener(Function2<? super GuildMember, ? super User, Unit> removeMemberClickListener) {
        C12238m.checkNotNullParameter(removeMemberClickListener, "removeMemberClickListener");
        this.removeMemberClickListener = removeMemberClickListener;
    }

    public ServerSettingsRoleMembersAdapter(AppComponent appComponent, DiffCreator<List<ServerSettingsRoleMemberAdapterItem>, ServerSettingsRoleMembersViewHolder> diffCreator) {
        C12238m.checkNotNullParameter(appComponent, "appComponent");
        C12238m.checkNotNullParameter(diffCreator, "diffCreator");
        this.diffCreator = diffCreator;
        this.items = C12147n.emptyList();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(ServerSettingsRoleMembersViewHolder holder, int position) {
        C12238m.checkNotNullParameter(holder, "holder");
        ServerSettingsRoleMemberAdapterItem serverSettingsRoleMemberAdapterItem = this.items.get(position);
        Function2<? super GuildMember, ? super User, Unit> function2 = this.removeMemberClickListener;
        if (function2 == null) {
            C12238m.throwUninitializedPropertyAccessException("removeMemberClickListener");
        }
        holder.configureUI(serverSettingsRoleMemberAdapterItem, function2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public ServerSettingsRoleMembersViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        C12238m.checkNotNullParameter(parent, "parent");
        RemovablePermissionOwnerViewBinding removablePermissionOwnerViewBindingM8389a = RemovablePermissionOwnerViewBinding.m8389a(LayoutInflater.from(parent.getContext()), parent, false);
        C12238m.checkNotNullExpressionValue(removablePermissionOwnerViewBindingM8389a, "RemovablePermissionOwner…rent,\n        false\n    )");
        return new ServerSettingsRoleMembersViewHolder(removablePermissionOwnerViewBindingM8389a);
    }
}
