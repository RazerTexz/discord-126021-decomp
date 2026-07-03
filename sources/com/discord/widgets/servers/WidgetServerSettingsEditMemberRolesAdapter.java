package com.discord.widgets.servers;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.C5419R;
import com.discord.api.role.GuildRole;
import com.discord.databinding.ViewCheckableRoleListItemBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.guilds.RoleUtils;
import com.discord.utilities.mg_recycler.MGRecyclerAdapterSimple;
import com.discord.utilities.mg_recycler.MGRecyclerDataPayload;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import com.discord.views.CheckedSetting;
import com.discord.widgets.servers.WidgetServerSettingsEditMemberRolesAdapter;
import java.util.List;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetServerSettingsEditMemberRolesAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsEditMemberRolesAdapter extends MGRecyclerAdapterSimple<RoleItem> {
    private Function1<? super Long, Unit> roleClickListener;

    /* JADX INFO: compiled from: WidgetServerSettingsEditMemberRolesAdapter.kt */
    public static final class RoleListItem extends MGRecyclerViewHolder<WidgetServerSettingsEditMemberRolesAdapter, RoleItem> {
        private final ViewCheckableRoleListItemBinding binding;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public RoleListItem(WidgetServerSettingsEditMemberRolesAdapter widgetServerSettingsEditMemberRolesAdapter) {
            super(C5419R.layout.view_checkable_role_list_item, widgetServerSettingsEditMemberRolesAdapter);
            C12238m.checkNotNullParameter(widgetServerSettingsEditMemberRolesAdapter, "adapter");
            View view = this.itemView;
            Objects.requireNonNull(view, "rootView");
            CheckedSetting checkedSetting = (CheckedSetting) view;
            ViewCheckableRoleListItemBinding viewCheckableRoleListItemBinding = new ViewCheckableRoleListItemBinding(checkedSetting, checkedSetting);
            C12238m.checkNotNullExpressionValue(viewCheckableRoleListItemBinding, "ViewCheckableRoleListItemBinding.bind(itemView)");
            this.binding = viewCheckableRoleListItemBinding;
        }

        public static final /* synthetic */ WidgetServerSettingsEditMemberRolesAdapter access$getAdapter$p(RoleListItem roleListItem) {
            return (WidgetServerSettingsEditMemberRolesAdapter) roleListItem.adapter;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
        public void onConfigure(int position, final RoleItem data) {
            C12238m.checkNotNullParameter(data, "data");
            super.onConfigure(position, data);
            this.binding.f15398b.setText(data.getRole().getName());
            CheckedSetting checkedSetting = this.binding.f15398b;
            GuildRole role = data.getRole();
            CheckedSetting checkedSetting2 = this.binding.f15398b;
            C12238m.checkNotNullExpressionValue(checkedSetting2, "binding.roleItemCheckedSetting");
            Context context = checkedSetting2.getContext();
            C12238m.checkNotNullExpressionValue(context, "binding.roleItemCheckedSetting.context");
            checkedSetting.setTextColor(RoleUtils.getRoleColor$default(role, context, null, 2, null));
            CheckedSetting checkedSetting3 = this.binding.f15398b;
            C12238m.checkNotNullExpressionValue(checkedSetting3, "binding.roleItemCheckedSetting");
            checkedSetting3.setChecked(data.isUserHasRole());
            if (data.isManageable()) {
                this.binding.f15398b.m8527e(new View.OnClickListener() { // from class: com.discord.widgets.servers.WidgetServerSettingsEditMemberRolesAdapter$RoleListItem$onConfigure$1
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        Function1 function1 = WidgetServerSettingsEditMemberRolesAdapter.RoleListItem.access$getAdapter$p(this.this$0).roleClickListener;
                        if (function1 != null) {
                        }
                    }
                });
            } else if (data.isRoleManaged()) {
                this.binding.f15398b.m8525b(C5419R.string.managed_role_explaination);
            } else {
                CheckedSetting.m8523d(this.binding.f15398b, null, 1);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetServerSettingsEditMemberRolesAdapter(RecyclerView recyclerView) {
        super(recyclerView, false, 2, null);
        C12238m.checkNotNullParameter(recyclerView, "recycler");
    }

    public final void configure(List<RoleItem> roleItems, Function1<? super Long, Unit> roleClickListener) {
        C12238m.checkNotNullParameter(roleItems, "roleItems");
        C12238m.checkNotNullParameter(roleClickListener, "roleClickListener");
        this.roleClickListener = roleClickListener;
        setData(roleItems);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RoleListItem onCreateViewHolder(ViewGroup parent, int viewType) {
        C12238m.checkNotNullParameter(parent, "parent");
        if (viewType == 1) {
            return new RoleListItem(this);
        }
        throw invalidViewTypeException(viewType);
    }

    /* JADX INFO: compiled from: WidgetServerSettingsEditMemberRolesAdapter.kt */
    public static final /* data */ class RoleItem implements MGRecyclerDataPayload {
        public static final int TYPE_ROLE = 1;
        private final boolean isManageable;
        private final boolean isUserHasRole;
        private final String key;
        private final GuildRole role;
        private final int type;

        public RoleItem(GuildRole guildRole, boolean z2, boolean z3) {
            C12238m.checkNotNullParameter(guildRole, "role");
            this.role = guildRole;
            this.isUserHasRole = z2;
            this.isManageable = z3;
            this.type = 1;
            this.key = String.valueOf(guildRole.getId());
        }

        public static /* synthetic */ RoleItem copy$default(RoleItem roleItem, GuildRole guildRole, boolean z2, boolean z3, int i, Object obj) {
            if ((i & 1) != 0) {
                guildRole = roleItem.role;
            }
            if ((i & 2) != 0) {
                z2 = roleItem.isUserHasRole;
            }
            if ((i & 4) != 0) {
                z3 = roleItem.isManageable;
            }
            return roleItem.copy(guildRole, z2, z3);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final GuildRole getRole() {
            return this.role;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final boolean getIsUserHasRole() {
            return this.isUserHasRole;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final boolean getIsManageable() {
            return this.isManageable;
        }

        public final RoleItem copy(GuildRole role, boolean isUserHasRole, boolean isManageable) {
            C12238m.checkNotNullParameter(role, "role");
            return new RoleItem(role, isUserHasRole, isManageable);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof RoleItem)) {
                return false;
            }
            RoleItem roleItem = (RoleItem) other;
            return C12238m.areEqual(this.role, roleItem.role) && this.isUserHasRole == roleItem.isUserHasRole && this.isManageable == roleItem.isManageable;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
        public String getKey() {
            return this.key;
        }

        public final GuildRole getRole() {
            return this.role;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
        public int getType() {
            return this.type;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v4, types: [int] */
        /* JADX WARN: Type inference failed for: r0v6, types: [int] */
        /* JADX WARN: Type inference failed for: r1v1, types: [int] */
        /* JADX WARN: Type inference failed for: r1v3 */
        /* JADX WARN: Type inference failed for: r1v4 */
        /* JADX WARN: Type inference failed for: r2v0 */
        /* JADX WARN: Type inference failed for: r2v1, types: [int] */
        /* JADX WARN: Type inference failed for: r2v2 */
        public int hashCode() {
            GuildRole guildRole = this.role;
            int iHashCode = (guildRole != null ? guildRole.hashCode() : 0) * 31;
            boolean z2 = this.isUserHasRole;
            ?? r1 = z2;
            if (z2) {
                r1 = 1;
            }
            int i = (iHashCode + r1) * 31;
            boolean z3 = this.isManageable;
            return i + (z3 ? 1 : z3);
        }

        public final boolean isManageable() {
            return this.isManageable;
        }

        public final boolean isRoleManaged() {
            return this.role.getManaged();
        }

        public final boolean isUserHasRole() {
            return this.isUserHasRole;
        }

        public String toString() {
            StringBuilder sbM833U = C1643a.m833U("RoleItem(role=");
            sbM833U.append(this.role);
            sbM833U.append(", isUserHasRole=");
            sbM833U.append(this.isUserHasRole);
            sbM833U.append(", isManageable=");
            return C1643a.m827O(sbM833U, this.isManageable, ")");
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public RoleItem(GuildRole guildRole, boolean z2, GuildRole guildRole2, boolean z3, boolean z4) {
            this(guildRole, z2, !guildRole.getManaged() && (z3 || RoleUtils.rankIsHigher(guildRole2, guildRole)) && z4);
            C12238m.checkNotNullParameter(guildRole, "role");
        }
    }
}
