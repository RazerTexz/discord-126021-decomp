package com.discord.widgets.servers;

import a0.a.a.b;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import b.a.k.FormatUtils;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.api.role.GuildRole;
import com.discord.databinding.WidgetServerSettingsHelpItemBinding;
import com.discord.databinding.WidgetServerSettingsRoleItemBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.guilds.RoleUtils;
import com.discord.utilities.mg_recycler.DragAndDropAdapter;
import com.discord.utilities.mg_recycler.DragAndDropHelper;
import com.discord.utilities.mg_recycler.MGRecyclerAdapter;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.widgets.roles.RoleIconView;
import d0.d0._Ranges;
import d0.z.d.Intrinsics3;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetServerSettingsRolesAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsRolesAdapter extends DragAndDropAdapter<DragAndDropAdapter.Payload> {
    public static final int TYPE_HELP = 0;
    public static final int TYPE_ROLE = 1;
    private Function1<? super Map<String, Integer>, Unit> roleDropListener;
    private Function1<? super GuildRole, Unit> roleSelectedListener;

    /* JADX INFO: compiled from: WidgetServerSettingsRolesAdapter.kt */
    public static final /* data */ class HelpItem implements DragAndDropAdapter.Payload {
        private final long guildId;
        private final String key = "key0";
        private final int type;

        public HelpItem(long j) {
            this.guildId = j;
        }

        public static /* synthetic */ HelpItem copy$default(HelpItem helpItem, long j, int i, Object obj) {
            if ((i & 1) != 0) {
                j = helpItem.guildId;
            }
            return helpItem.copy(j);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final long getGuildId() {
            return this.guildId;
        }

        public final HelpItem copy(long guildId) {
            return new HelpItem(guildId);
        }

        public boolean equals(Object other) {
            if (this != other) {
                return (other instanceof HelpItem) && this.guildId == ((HelpItem) other).guildId;
            }
            return true;
        }

        public final long getGuildId() {
            return this.guildId;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
        public String getKey() {
            return this.key;
        }

        @Override // com.discord.utilities.mg_recycler.DragAndDropAdapter.Payload
        public int getPosition() {
            return 0;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
        public int getType() {
            return this.type;
        }

        public int hashCode() {
            return b.a(this.guildId);
        }

        public String toString() {
            return outline.C(outline.U("HelpItem(guildId="), this.guildId, ")");
        }
    }

    /* JADX INFO: compiled from: WidgetServerSettingsRolesAdapter.kt */
    public static final class RoleListHelpItem extends MGRecyclerViewHolder<MGRecyclerAdapter<DragAndDropAdapter.Payload>, DragAndDropAdapter.Payload> implements DragAndDropHelper.DraggableViewHolder {
        private final WidgetServerSettingsHelpItemBinding binding;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public RoleListHelpItem(WidgetServerSettingsRolesAdapter widgetServerSettingsRolesAdapter) {
            super(R.layout.widget_server_settings_help_item, widgetServerSettingsRolesAdapter);
            Intrinsics3.checkNotNullParameter(widgetServerSettingsRolesAdapter, "adapter");
            View view = this.itemView;
            Objects.requireNonNull(view, "rootView");
            LinkifiedTextView linkifiedTextView = (LinkifiedTextView) view;
            WidgetServerSettingsHelpItemBinding widgetServerSettingsHelpItemBinding = new WidgetServerSettingsHelpItemBinding(linkifiedTextView, linkifiedTextView);
            Intrinsics3.checkNotNullExpressionValue(widgetServerSettingsHelpItemBinding, "WidgetServerSettingsHelpItemBinding.bind(itemView)");
            this.binding = widgetServerSettingsHelpItemBinding;
        }

        @Override // com.discord.utilities.mg_recycler.DragAndDropHelper.DraggableViewHolder
        /* JADX INFO: renamed from: canDrag */
        public boolean getCanDrag() {
            return false;
        }

        @Override // com.discord.utilities.mg_recycler.DragAndDropHelper.DraggableViewHolder
        public void onDragStateChanged(boolean dragging) {
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
        public void onConfigure(int position, DragAndDropAdapter.Payload data) {
            Intrinsics3.checkNotNullParameter(data, "data");
            super.onConfigure(position, data);
            LinkifiedTextView linkifiedTextView = this.binding.f2572b;
            Intrinsics3.checkNotNullExpressionValue(linkifiedTextView, "binding.serverSettingsHelpItem");
            FormatUtils.m(linkifiedTextView, R.string.help_roles_description, new Object[0], new WidgetServerSettingsRolesAdapter2(data));
        }
    }

    /* JADX INFO: compiled from: WidgetServerSettingsRolesAdapter.kt */
    public static final class RoleListItem extends MGRecyclerViewHolder<MGRecyclerAdapter<DragAndDropAdapter.Payload>, DragAndDropAdapter.Payload> implements DragAndDropHelper.DraggableViewHolder {
        private final WidgetServerSettingsRoleItemBinding binding;
        private boolean canDrag;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public RoleListItem(WidgetServerSettingsRolesAdapter widgetServerSettingsRolesAdapter) {
            super(R.layout.widget_server_settings_role_item, widgetServerSettingsRolesAdapter);
            Intrinsics3.checkNotNullParameter(widgetServerSettingsRolesAdapter, "adapter");
            View view = this.itemView;
            int i = R.id.server_settings_role_item_bottom_divider;
            View viewFindViewById = view.findViewById(R.id.server_settings_role_item_bottom_divider);
            if (viewFindViewById != null) {
                i = R.id.server_settings_role_item_divider_targeted;
                View viewFindViewById2 = view.findViewById(R.id.server_settings_role_item_divider_targeted);
                if (viewFindViewById2 != null) {
                    i = R.id.server_settings_role_item_drag_overlay;
                    View viewFindViewById3 = view.findViewById(R.id.server_settings_role_item_drag_overlay);
                    if (viewFindViewById3 != null) {
                        i = R.id.server_settings_role_item_lock_indicator;
                        ImageView imageView = (ImageView) view.findViewById(R.id.server_settings_role_item_lock_indicator);
                        if (imageView != null) {
                            i = R.id.server_settings_role_item_name;
                            TextView textView = (TextView) view.findViewById(R.id.server_settings_role_item_name);
                            if (textView != null) {
                                i = R.id.server_settings_role_item_role_icon;
                                RoleIconView roleIconView = (RoleIconView) view.findViewById(R.id.server_settings_role_item_role_icon);
                                if (roleIconView != null) {
                                    WidgetServerSettingsRoleItemBinding widgetServerSettingsRoleItemBinding = new WidgetServerSettingsRoleItemBinding((RelativeLayout) view, viewFindViewById, viewFindViewById2, viewFindViewById3, imageView, textView, roleIconView);
                                    Intrinsics3.checkNotNullExpressionValue(widgetServerSettingsRoleItemBinding, "WidgetServerSettingsRoleItemBinding.bind(itemView)");
                                    this.binding = widgetServerSettingsRoleItemBinding;
                                    return;
                                }
                            }
                        }
                    }
                }
            }
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
        }

        @Override // com.discord.utilities.mg_recycler.DragAndDropHelper.DraggableViewHolder
        /* JADX INFO: renamed from: canDrag, reason: from getter */
        public boolean getCanDrag() {
            return this.canDrag;
        }

        @Override // com.discord.utilities.mg_recycler.DragAndDropHelper.DraggableViewHolder
        public void onDragStateChanged(boolean dragging) {
            View view = this.binding.f2583b;
            Intrinsics3.checkNotNullExpressionValue(view, "binding.serverSettingsRoleItemDragOverlay");
            view.setVisibility(dragging ? 0 : 8);
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
        public void onConfigure(int position, DragAndDropAdapter.Payload data) {
            Intrinsics3.checkNotNullParameter(data, "data");
            super.onConfigure(position, data);
            final RoleItem roleItem = (RoleItem) data;
            this.canDrag = roleItem.canReorder();
            TextView textView = this.binding.d;
            Intrinsics3.checkNotNullExpressionValue(textView, "binding.serverSettingsRoleItemName");
            textView.setText(roleItem.getRole().getName());
            TextView textView2 = this.binding.d;
            GuildRole role = roleItem.getRole();
            RelativeLayout relativeLayout = this.binding.a;
            Intrinsics3.checkNotNullExpressionValue(relativeLayout, "binding.root");
            Context context = relativeLayout.getContext();
            Intrinsics3.checkNotNullExpressionValue(context, "binding.root.context");
            textView2.setTextColor(RoleUtils.getRoleColor$default(role, context, null, 2, null));
            this.binding.a.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.servers.WidgetServerSettingsRolesAdapter$RoleListItem$onConfigure$1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MGRecyclerAdapter mGRecyclerAdapter = this.this$0.adapter;
                    Objects.requireNonNull(mGRecyclerAdapter, "null cannot be cast to non-null type com.discord.widgets.servers.WidgetServerSettingsRolesAdapter");
                    ((WidgetServerSettingsRolesAdapter) mGRecyclerAdapter).roleSelectedListener.invoke(roleItem.getRole());
                }
            });
            if (roleItem.getEveryoneRole()) {
                RelativeLayout relativeLayout2 = this.binding.a;
                Intrinsics3.checkNotNullExpressionValue(relativeLayout2, "binding.root");
                ViewExtensions.setOnLongClickListenerConsumeClick(relativeLayout2, WidgetServerSettingsRolesAdapter4.INSTANCE);
            } else if (!roleItem.getUserAbleToManageRoles()) {
                RelativeLayout relativeLayout3 = this.binding.a;
                Intrinsics3.checkNotNullExpressionValue(relativeLayout3, "binding.root");
                ViewExtensions.setOnLongClickListenerConsumeClick(relativeLayout3, WidgetServerSettingsRolesAdapter5.INSTANCE);
            } else if (roleItem.getElevated()) {
                this.binding.a.setOnLongClickListener(null);
            } else {
                RelativeLayout relativeLayout4 = this.binding.a;
                Intrinsics3.checkNotNullExpressionValue(relativeLayout4, "binding.root");
                ViewExtensions.setOnLongClickListenerConsumeClick(relativeLayout4, WidgetServerSettingsRolesAdapter6.INSTANCE);
            }
            ImageView imageView = this.binding.c;
            Intrinsics3.checkNotNullExpressionValue(imageView, "binding.serverSettingsRoleItemLockIndicator");
            imageView.setVisibility(roleItem.getLocked() ? 0 : 8);
            this.binding.e.setRole(roleItem.getRole(), Long.valueOf(roleItem.getGuildId()));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetServerSettingsRolesAdapter(RecyclerView recyclerView) {
        super(recyclerView);
        Intrinsics3.checkNotNullParameter(recyclerView, "recycler");
        this.roleSelectedListener = WidgetServerSettingsRolesAdapter8.INSTANCE;
        this.roleDropListener = WidgetServerSettingsRolesAdapter7.INSTANCE;
    }

    @Override // com.discord.utilities.mg_recycler.DragAndDropAdapter
    public Map<String, Integer> computeChangedPositions() {
        HashMap map = new HashMap();
        int size = getDataCopy().size();
        for (int i = 0; i < size; i++) {
            DragAndDropAdapter.Payload payload = getDataCopy().get(i);
            if (payload.getType() == 1) {
                RoleItem roleItem = (RoleItem) payload;
                if (!roleItem.getEveryoneRole()) {
                    int i2 = (size - 1) - i;
                    Integer num = getOrigPositions().get(roleItem.getKey());
                    if (num == null || i2 != num.intValue()) {
                        map.put(roleItem.getKey(), Integer.valueOf(i2));
                    }
                }
            }
        }
        return map;
    }

    public final void configure(List<? extends DragAndDropAdapter.Payload> roles, Function1<? super GuildRole, Unit> roleSelectedListener, Function1<? super Map<String, Integer>, Unit> roleDropListener) {
        Intrinsics3.checkNotNullParameter(roles, "roles");
        Intrinsics3.checkNotNullParameter(roleSelectedListener, "roleSelectedListener");
        Intrinsics3.checkNotNullParameter(roleDropListener, "roleDropListener");
        this.roleSelectedListener = roleSelectedListener;
        this.roleDropListener = roleDropListener;
        setData(roles);
    }

    @Override // com.discord.utilities.mg_recycler.DragAndDropHelper.Adapter
    public boolean isValidMove(int fromPosition, int toPosition) {
        int iCoerceAtMost = _Ranges.coerceAtMost(fromPosition, toPosition);
        int iCoerceAtLeast = _Ranges.coerceAtLeast(fromPosition, toPosition);
        if (iCoerceAtMost <= iCoerceAtLeast) {
            while (true) {
                DragAndDropAdapter.Payload payload = getDataCopy().get(iCoerceAtMost);
                if (payload.getType() != 1 || !((RoleItem) payload).canReorder()) {
                    return false;
                }
                if (iCoerceAtMost != iCoerceAtLeast) {
                    iCoerceAtMost++;
                }
            }
        }
        return true;
    }

    @Override // com.discord.utilities.mg_recycler.DragAndDropAdapter
    public void onNewPositions(Map<String, Integer> newPositions) {
        Intrinsics3.checkNotNullParameter(newPositions, "newPositions");
        this.roleDropListener.invoke(newPositions);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public MGRecyclerViewHolder<?, DragAndDropAdapter.Payload> onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics3.checkNotNullParameter(parent, "parent");
        if (viewType == 0) {
            return new RoleListHelpItem(this);
        }
        if (viewType == 1) {
            return new RoleListItem(this);
        }
        throw invalidViewTypeException(viewType);
    }

    /* JADX INFO: compiled from: WidgetServerSettingsRolesAdapter.kt */
    public static final /* data */ class RoleItem implements DragAndDropAdapter.Payload {
        private final boolean elevated;
        private final boolean everyoneRole;
        private final long guildId;
        private final String key;
        private final boolean locked;
        private final GuildRole role;
        private final int type;
        private final boolean userAbleToManageRoles;

        public RoleItem(GuildRole guildRole, boolean z2, boolean z3, boolean z4, boolean z5, long j) {
            Intrinsics3.checkNotNullParameter(guildRole, "role");
            this.role = guildRole;
            this.everyoneRole = z2;
            this.locked = z3;
            this.userAbleToManageRoles = z4;
            this.elevated = z5;
            this.guildId = j;
            this.key = String.valueOf(guildRole.getId());
            this.type = 1;
        }

        public static /* synthetic */ RoleItem copy$default(RoleItem roleItem, GuildRole guildRole, boolean z2, boolean z3, boolean z4, boolean z5, long j, int i, Object obj) {
            if ((i & 1) != 0) {
                guildRole = roleItem.role;
            }
            if ((i & 2) != 0) {
                z2 = roleItem.everyoneRole;
            }
            boolean z6 = z2;
            if ((i & 4) != 0) {
                z3 = roleItem.locked;
            }
            boolean z7 = z3;
            if ((i & 8) != 0) {
                z4 = roleItem.userAbleToManageRoles;
            }
            boolean z8 = z4;
            if ((i & 16) != 0) {
                z5 = roleItem.elevated;
            }
            boolean z9 = z5;
            if ((i & 32) != 0) {
                j = roleItem.guildId;
            }
            return roleItem.copy(guildRole, z6, z7, z8, z9, j);
        }

        public final boolean canReorder() {
            return !this.everyoneRole && !this.locked && this.userAbleToManageRoles && this.elevated;
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final GuildRole getRole() {
            return this.role;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final boolean getEveryoneRole() {
            return this.everyoneRole;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final boolean getLocked() {
            return this.locked;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final boolean getUserAbleToManageRoles() {
            return this.userAbleToManageRoles;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final boolean getElevated() {
            return this.elevated;
        }

        /* JADX INFO: renamed from: component6, reason: from getter */
        public final long getGuildId() {
            return this.guildId;
        }

        public final RoleItem copy(GuildRole role, boolean everyoneRole, boolean locked, boolean userAbleToManageRoles, boolean elevated, long guildId) {
            Intrinsics3.checkNotNullParameter(role, "role");
            return new RoleItem(role, everyoneRole, locked, userAbleToManageRoles, elevated, guildId);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof RoleItem)) {
                return false;
            }
            RoleItem roleItem = (RoleItem) other;
            return Intrinsics3.areEqual(this.role, roleItem.role) && this.everyoneRole == roleItem.everyoneRole && this.locked == roleItem.locked && this.userAbleToManageRoles == roleItem.userAbleToManageRoles && this.elevated == roleItem.elevated && this.guildId == roleItem.guildId;
        }

        public final boolean getElevated() {
            return this.elevated;
        }

        public final boolean getEveryoneRole() {
            return this.everyoneRole;
        }

        public final long getGuildId() {
            return this.guildId;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
        public String getKey() {
            return this.key;
        }

        public final boolean getLocked() {
            return this.locked;
        }

        @Override // com.discord.utilities.mg_recycler.DragAndDropAdapter.Payload
        public int getPosition() {
            return this.role.getPosition();
        }

        public final GuildRole getRole() {
            return this.role;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
        public int getType() {
            return this.type;
        }

        public final boolean getUserAbleToManageRoles() {
            return this.userAbleToManageRoles;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v10, types: [int] */
        /* JADX WARN: Type inference failed for: r0v4, types: [int] */
        /* JADX WARN: Type inference failed for: r0v6, types: [int] */
        /* JADX WARN: Type inference failed for: r0v8, types: [int] */
        /* JADX WARN: Type inference failed for: r1v1, types: [int] */
        /* JADX WARN: Type inference failed for: r1v10 */
        /* JADX WARN: Type inference failed for: r1v11 */
        /* JADX WARN: Type inference failed for: r1v12 */
        /* JADX WARN: Type inference failed for: r1v13 */
        /* JADX WARN: Type inference failed for: r1v14 */
        /* JADX WARN: Type inference failed for: r1v15 */
        /* JADX WARN: Type inference failed for: r1v3, types: [int] */
        /* JADX WARN: Type inference failed for: r1v5, types: [int] */
        /* JADX WARN: Type inference failed for: r2v0 */
        /* JADX WARN: Type inference failed for: r2v1, types: [int] */
        /* JADX WARN: Type inference failed for: r2v2 */
        public int hashCode() {
            GuildRole guildRole = this.role;
            int iHashCode = (guildRole != null ? guildRole.hashCode() : 0) * 31;
            boolean z2 = this.everyoneRole;
            ?? r1 = z2;
            if (z2) {
                r1 = 1;
            }
            int i = (iHashCode + r1) * 31;
            boolean z3 = this.locked;
            ?? r2 = z3;
            if (z3) {
                r2 = 1;
            }
            int i2 = (i + r2) * 31;
            boolean z4 = this.userAbleToManageRoles;
            ?? r3 = z4;
            if (z4) {
                r3 = 1;
            }
            int i3 = (i2 + r3) * 31;
            boolean z5 = this.elevated;
            return b.a(this.guildId) + ((i3 + (z5 ? 1 : z5)) * 31);
        }

        public String toString() {
            StringBuilder sbU = outline.U("RoleItem(role=");
            sbU.append(this.role);
            sbU.append(", everyoneRole=");
            sbU.append(this.everyoneRole);
            sbU.append(", locked=");
            sbU.append(this.locked);
            sbU.append(", userAbleToManageRoles=");
            sbU.append(this.userAbleToManageRoles);
            sbU.append(", elevated=");
            sbU.append(this.elevated);
            sbU.append(", guildId=");
            return outline.C(sbU, this.guildId, ")");
        }

        public /* synthetic */ RoleItem(GuildRole guildRole, boolean z2, boolean z3, boolean z4, boolean z5, long j, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(guildRole, z2, (i & 4) != 0 ? false : z3, z4, z5, j);
        }
    }
}
