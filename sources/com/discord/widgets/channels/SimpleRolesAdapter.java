package com.discord.widgets.channels;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.api.role.GuildRole;
import com.discord.databinding.SimpleRoleListItemBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.guilds.RoleUtils;
import com.discord.utilities.mg_recycler.MGRecyclerAdapterSimple;
import com.discord.utilities.mg_recycler.MGRecyclerDataPayload;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import com.discord.widgets.channels.SimpleRolesAdapter;
import d0.z.d.Intrinsics3;
import java.util.List;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: SimpleRolesAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class SimpleRolesAdapter extends MGRecyclerAdapterSimple<RoleItem> {
    private Function1<? super GuildRole, Unit> onRoleClickedListener;

    /* JADX INFO: compiled from: SimpleRolesAdapter.kt */
    public static final class RoleAdapterItem extends MGRecyclerViewHolder<SimpleRolesAdapter, RoleItem> {
        private final SimpleRoleListItemBinding binding;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public RoleAdapterItem(SimpleRolesAdapter simpleRolesAdapter) {
            super(R.layout.simple_role_list_item, simpleRolesAdapter);
            Intrinsics3.checkNotNullParameter(simpleRolesAdapter, "adapter");
            View view = this.itemView;
            Objects.requireNonNull(view, "rootView");
            TextView textView = (TextView) view;
            SimpleRoleListItemBinding simpleRoleListItemBinding = new SimpleRoleListItemBinding(textView, textView);
            Intrinsics3.checkNotNullExpressionValue(simpleRoleListItemBinding, "SimpleRoleListItemBinding.bind(itemView)");
            this.binding = simpleRoleListItemBinding;
        }

        public static final /* synthetic */ SimpleRolesAdapter access$getAdapter$p(RoleAdapterItem roleAdapterItem) {
            return (SimpleRolesAdapter) roleAdapterItem.adapter;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
        public void onConfigure(int position, final RoleItem data) {
            Intrinsics3.checkNotNullParameter(data, "data");
            super.onConfigure(position, data);
            TextView textView = this.binding.f2143b;
            Intrinsics3.checkNotNullExpressionValue(textView, "binding.serverSettingsRoleItemName");
            textView.setText(data.getRole().getName());
            this.binding.a.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.channels.SimpleRolesAdapter$RoleAdapterItem$onConfigure$1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    Function1 function1 = SimpleRolesAdapter.RoleAdapterItem.access$getAdapter$p(this.this$0).onRoleClickedListener;
                    if (function1 != null) {
                    }
                }
            });
            TextView textView2 = this.binding.f2143b;
            GuildRole role = data.getRole();
            TextView textView3 = this.binding.f2143b;
            Intrinsics3.checkNotNullExpressionValue(textView3, "binding.serverSettingsRoleItemName");
            Context context = textView3.getContext();
            Intrinsics3.checkNotNullExpressionValue(context, "binding.serverSettingsRoleItemName.context");
            textView2.setTextColor(RoleUtils.getRoleColor$default(role, context, null, 2, null));
        }
    }

    /* JADX INFO: compiled from: SimpleRolesAdapter.kt */
    public static final /* data */ class RoleItem implements MGRecyclerDataPayload, Comparable<RoleItem> {
        public static final int TYPE_ROLE = 0;
        private final String key;
        private final GuildRole role;
        private final int type;

        public RoleItem(GuildRole guildRole) {
            Intrinsics3.checkNotNullParameter(guildRole, "role");
            this.role = guildRole;
            this.key = String.valueOf(guildRole.getId());
        }

        public static /* synthetic */ RoleItem copy$default(RoleItem roleItem, GuildRole guildRole, int i, Object obj) {
            if ((i & 1) != 0) {
                guildRole = roleItem.role;
            }
            return roleItem.copy(guildRole);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final GuildRole getRole() {
            return this.role;
        }

        public final RoleItem copy(GuildRole role) {
            Intrinsics3.checkNotNullParameter(role, "role");
            return new RoleItem(role);
        }

        public boolean equals(Object other) {
            if (this != other) {
                return (other instanceof RoleItem) && Intrinsics3.areEqual(this.role, ((RoleItem) other).role);
            }
            return true;
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

        public int hashCode() {
            GuildRole guildRole = this.role;
            if (guildRole != null) {
                return guildRole.hashCode();
            }
            return 0;
        }

        public String toString() {
            StringBuilder sbU = outline.U("RoleItem(role=");
            sbU.append(this.role);
            sbU.append(")");
            return sbU.toString();
        }

        @Override // java.lang.Comparable
        public int compareTo(RoleItem other) {
            Intrinsics3.checkNotNullParameter(other, "other");
            return RoleUtils.getROLE_COMPARATOR().compare(this.role, other.role);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SimpleRolesAdapter(RecyclerView recyclerView) {
        super(recyclerView, false, 2, null);
        Intrinsics3.checkNotNullParameter(recyclerView, "recycler");
    }

    public final void setData(List<RoleItem> data, Function1<? super GuildRole, Unit> onRoleClickedListener) {
        Intrinsics3.checkNotNullParameter(data, "data");
        Intrinsics3.checkNotNullParameter(onRoleClickedListener, "onRoleClickedListener");
        super.setData(data);
        this.onRoleClickedListener = onRoleClickedListener;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RoleAdapterItem onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics3.checkNotNullParameter(parent, "parent");
        if (viewType == 0) {
            return new RoleAdapterItem(this);
        }
        throw invalidViewTypeException(viewType);
    }
}
