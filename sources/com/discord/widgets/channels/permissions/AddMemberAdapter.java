package com.discord.widgets.channels.permissions;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.api.permission.PermissionOverwrite;
import com.discord.databinding.WidgetChannelSettingsAddMemberCategoryBinding;
import com.discord.databinding.WidgetChannelSettingsAddMemberItemBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.mg_recycler.MGRecyclerAdapterSimple;
import com.discord.utilities.mg_recycler.MGRecyclerDataPayload;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.views.permissions.ChannelPermissionOwnerView;
import com.discord.widgets.channels.permissions.PermissionOwner;
import com.google.android.material.checkbox.MaterialCheckBox;
import d0.z.d.Intrinsics3;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: AddMemberAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class AddMemberAdapter extends MGRecyclerAdapterSimple<Item> {
    private Function2<? super Long, ? super PermissionOverwrite.Type, Unit> onClickListener;

    /* JADX INFO: compiled from: AddMemberAdapter.kt */
    public static final class AddMemberAdapterCategoryItem extends MGRecyclerViewHolder<AddMemberAdapter, Item> {
        private final WidgetChannelSettingsAddMemberCategoryBinding binding;

        public final /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                Item.CategoryItem.Companion.CategoryType.values();
                int[] iArr = new int[2];
                $EnumSwitchMapping$0 = iArr;
                iArr[Item.CategoryItem.Companion.CategoryType.ROLE.ordinal()] = 1;
                iArr[Item.CategoryItem.Companion.CategoryType.MEMBER.ordinal()] = 2;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AddMemberAdapterCategoryItem(AddMemberAdapter addMemberAdapter) {
            super(R.layout.widget_channel_settings_add_member_category, addMemberAdapter);
            Intrinsics3.checkNotNullParameter(addMemberAdapter, "adapter");
            View view = this.itemView;
            TextView textView = (TextView) view.findViewById(R.id.label);
            if (textView == null) {
                throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.label)));
            }
            WidgetChannelSettingsAddMemberCategoryBinding widgetChannelSettingsAddMemberCategoryBinding = new WidgetChannelSettingsAddMemberCategoryBinding((LinearLayout) view, textView);
            Intrinsics3.checkNotNullExpressionValue(widgetChannelSettingsAddMemberCategoryBinding, "WidgetChannelSettingsAdd…oryBinding.bind(itemView)");
            this.binding = widgetChannelSettingsAddMemberCategoryBinding;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
        public void onConfigure(int position, Item data) {
            String string;
            Intrinsics3.checkNotNullParameter(data, "data");
            super.onConfigure(position, data);
            TextView textView = this.binding.f2270b;
            Intrinsics3.checkNotNullExpressionValue(textView, "binding.label");
            int iOrdinal = ((Item.CategoryItem) data).getCategoryType().ordinal();
            if (iOrdinal == 0) {
                string = ((AddMemberAdapter) this.adapter).getRecycler().getContext().getString(R.string.roles);
            } else {
                if (iOrdinal != 1) {
                    throw new NoWhenBranchMatchedException();
                }
                string = ((AddMemberAdapter) this.adapter).getRecycler().getContext().getString(R.string.members);
            }
            textView.setText(string);
        }
    }

    /* JADX INFO: compiled from: AddMemberAdapter.kt */
    public static final class AddMemberAdapterItemItem extends MGRecyclerViewHolder<AddMemberAdapter, Item> {
        private final WidgetChannelSettingsAddMemberItemBinding binding;

        public final /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                Item.PermissionOwnerItem.Companion.AddStatus.CannotAdd.Reason.values();
                int[] iArr = new int[1];
                $EnumSwitchMapping$0 = iArr;
                iArr[Item.PermissionOwnerItem.Companion.AddStatus.CannotAdd.Reason.HAS_GUILD_PERMISSIONS.ordinal()] = 1;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AddMemberAdapterItemItem(AddMemberAdapter addMemberAdapter) {
            super(R.layout.widget_channel_settings_add_member_item, addMemberAdapter);
            Intrinsics3.checkNotNullParameter(addMemberAdapter, "adapter");
            View view = this.itemView;
            int i = R.id.channel_permission_owner_view;
            ChannelPermissionOwnerView channelPermissionOwnerView = (ChannelPermissionOwnerView) view.findViewById(R.id.channel_permission_owner_view);
            if (channelPermissionOwnerView != null) {
                i = R.id.checkbox;
                MaterialCheckBox materialCheckBox = (MaterialCheckBox) view.findViewById(R.id.checkbox);
                if (materialCheckBox != null) {
                    i = R.id.container;
                    ConstraintLayout constraintLayout = (ConstraintLayout) view.findViewById(R.id.container);
                    if (constraintLayout != null) {
                        WidgetChannelSettingsAddMemberItemBinding widgetChannelSettingsAddMemberItemBinding = new WidgetChannelSettingsAddMemberItemBinding((FrameLayout) view, channelPermissionOwnerView, materialCheckBox, constraintLayout);
                        Intrinsics3.checkNotNullExpressionValue(widgetChannelSettingsAddMemberItemBinding, "WidgetChannelSettingsAdd…temBinding.bind(itemView)");
                        this.binding = widgetChannelSettingsAddMemberItemBinding;
                        return;
                    }
                }
            }
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
        }

        private final void handleClick(Item.PermissionOwnerItem item) {
            PermissionOwner permissionOwner = item.getPermissionOwner();
            Item.PermissionOwnerItem.Companion.AddStatus addStatus = item.getAddStatus();
            if (Intrinsics3.areEqual(addStatus, Item.PermissionOwnerItem.Companion.AddStatus.CanAdd.INSTANCE)) {
                handleOnClickForPermissionOwner(permissionOwner);
            } else if ((addStatus instanceof Item.PermissionOwnerItem.Companion.AddStatus.CannotAdd) && ((Item.PermissionOwnerItem.Companion.AddStatus.CannotAdd) item.getAddStatus()).getReason().ordinal() == 0) {
                FrameLayout frameLayout = this.binding.a;
                Intrinsics3.checkNotNullExpressionValue(frameLayout, "binding.root");
                Toast.makeText(frameLayout.getContext(), R.string.channel_permissions_add_has_guild_permissions, 0).show();
            }
        }

        private final void handleOnClickForPermissionOwner(PermissionOwner permissionOwner) {
            Function2 function2 = ((AddMemberAdapter) this.adapter).onClickListener;
            if (function2 != null) {
                if (permissionOwner instanceof PermissionOwner.Member) {
                    function2.invoke(Long.valueOf(((PermissionOwner.Member) permissionOwner).getUser().getId()), PermissionOverwrite.Type.MEMBER);
                } else if (permissionOwner instanceof PermissionOwner.Role) {
                    function2.invoke(Long.valueOf(((PermissionOwner.Role) permissionOwner).getRole().getId()), PermissionOverwrite.Type.ROLE);
                }
            }
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
        public void onConfigure(int position, Item data) {
            Intrinsics3.checkNotNullParameter(data, "data");
            super.onConfigure(position, data);
            final Item.PermissionOwnerItem permissionOwnerItem = (Item.PermissionOwnerItem) data;
            this.binding.f2271b.a(permissionOwnerItem.getPermissionOwner());
            MaterialCheckBox materialCheckBox = this.binding.c;
            Intrinsics3.checkNotNullExpressionValue(materialCheckBox, "binding.checkbox");
            materialCheckBox.setChecked(permissionOwnerItem.getChecked());
            this.binding.c.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.channels.permissions.AddMemberAdapter$AddMemberAdapterItemItem$onConfigure$1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.this$0.handleClick(permissionOwnerItem);
                }
            });
            this.binding.d.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.channels.permissions.AddMemberAdapter$AddMemberAdapterItemItem$onConfigure$2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.this$0.handleClick(permissionOwnerItem);
                }
            });
            ConstraintLayout constraintLayout = this.binding.d;
            Intrinsics3.checkNotNullExpressionValue(constraintLayout, "binding.container");
            ViewExtensions.setEnabledAlpha$default(constraintLayout, Intrinsics3.areEqual(permissionOwnerItem.getAddStatus(), Item.PermissionOwnerItem.Companion.AddStatus.CanAdd.INSTANCE), 0.0f, 2, null);
        }
    }

    /* JADX INFO: compiled from: AddMemberAdapter.kt */
    public static abstract class Item implements MGRecyclerDataPayload {
        public static final int TYPE_CATEGORY = 0;
        public static final int TYPE_PERMISSION_OWNER = 1;

        /* JADX INFO: compiled from: AddMemberAdapter.kt */
        public static final /* data */ class CategoryItem extends Item {
            private final Companion.CategoryType categoryType;
            private final String key;
            private final int type;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public CategoryItem(Companion.CategoryType categoryType) {
                super(null);
                Intrinsics3.checkNotNullParameter(categoryType, "categoryType");
                this.categoryType = categoryType;
                this.key = categoryType.toString();
            }

            public static /* synthetic */ CategoryItem copy$default(CategoryItem categoryItem, Companion.CategoryType categoryType, int i, Object obj) {
                if ((i & 1) != 0) {
                    categoryType = categoryItem.categoryType;
                }
                return categoryItem.copy(categoryType);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final Companion.CategoryType getCategoryType() {
                return this.categoryType;
            }

            public final CategoryItem copy(Companion.CategoryType categoryType) {
                Intrinsics3.checkNotNullParameter(categoryType, "categoryType");
                return new CategoryItem(categoryType);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof CategoryItem) && Intrinsics3.areEqual(this.categoryType, ((CategoryItem) other).categoryType);
                }
                return true;
            }

            public final Companion.CategoryType getCategoryType() {
                return this.categoryType;
            }

            @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
            public String getKey() {
                return this.key;
            }

            @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
            public int getType() {
                return this.type;
            }

            public int hashCode() {
                Companion.CategoryType categoryType = this.categoryType;
                if (categoryType != null) {
                    return categoryType.hashCode();
                }
                return 0;
            }

            public String toString() {
                StringBuilder sbU = outline.U("CategoryItem(categoryType=");
                sbU.append(this.categoryType);
                sbU.append(")");
                return sbU.toString();
            }
        }

        /* JADX INFO: compiled from: AddMemberAdapter.kt */
        public static final /* data */ class PermissionOwnerItem extends Item {
            private final Companion.AddStatus addStatus;
            private final boolean checked;
            private final String key;
            private final PermissionOwner permissionOwner;
            private final int type;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public PermissionOwnerItem(PermissionOwner permissionOwner, boolean z2, Companion.AddStatus addStatus) {
                String strValueOf;
                super(null);
                Intrinsics3.checkNotNullParameter(permissionOwner, "permissionOwner");
                Intrinsics3.checkNotNullParameter(addStatus, "addStatus");
                this.permissionOwner = permissionOwner;
                this.checked = z2;
                this.addStatus = addStatus;
                this.type = 1;
                if (permissionOwner instanceof PermissionOwner.Member) {
                    strValueOf = String.valueOf(((PermissionOwner.Member) permissionOwner).getUser().getId());
                } else {
                    if (!(permissionOwner instanceof PermissionOwner.Role)) {
                        throw new NoWhenBranchMatchedException();
                    }
                    strValueOf = String.valueOf(((PermissionOwner.Role) permissionOwner).getRole().getId());
                }
                this.key = strValueOf;
            }

            public static /* synthetic */ PermissionOwnerItem copy$default(PermissionOwnerItem permissionOwnerItem, PermissionOwner permissionOwner, boolean z2, Companion.AddStatus addStatus, int i, Object obj) {
                if ((i & 1) != 0) {
                    permissionOwner = permissionOwnerItem.permissionOwner;
                }
                if ((i & 2) != 0) {
                    z2 = permissionOwnerItem.checked;
                }
                if ((i & 4) != 0) {
                    addStatus = permissionOwnerItem.addStatus;
                }
                return permissionOwnerItem.copy(permissionOwner, z2, addStatus);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final PermissionOwner getPermissionOwner() {
                return this.permissionOwner;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final boolean getChecked() {
                return this.checked;
            }

            /* JADX INFO: renamed from: component3, reason: from getter */
            public final Companion.AddStatus getAddStatus() {
                return this.addStatus;
            }

            public final PermissionOwnerItem copy(PermissionOwner permissionOwner, boolean checked, Companion.AddStatus addStatus) {
                Intrinsics3.checkNotNullParameter(permissionOwner, "permissionOwner");
                Intrinsics3.checkNotNullParameter(addStatus, "addStatus");
                return new PermissionOwnerItem(permissionOwner, checked, addStatus);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof PermissionOwnerItem)) {
                    return false;
                }
                PermissionOwnerItem permissionOwnerItem = (PermissionOwnerItem) other;
                return Intrinsics3.areEqual(this.permissionOwner, permissionOwnerItem.permissionOwner) && this.checked == permissionOwnerItem.checked && Intrinsics3.areEqual(this.addStatus, permissionOwnerItem.addStatus);
            }

            public final Companion.AddStatus getAddStatus() {
                return this.addStatus;
            }

            public final boolean getChecked() {
                return this.checked;
            }

            @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
            public String getKey() {
                return this.key;
            }

            public final PermissionOwner getPermissionOwner() {
                return this.permissionOwner;
            }

            @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
            public int getType() {
                return this.type;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r0v4, types: [int] */
            /* JADX WARN: Type inference failed for: r2v1, types: [int] */
            /* JADX WARN: Type inference failed for: r2v3 */
            /* JADX WARN: Type inference failed for: r2v4 */
            public int hashCode() {
                PermissionOwner permissionOwner = this.permissionOwner;
                int iHashCode = (permissionOwner != null ? permissionOwner.hashCode() : 0) * 31;
                boolean z2 = this.checked;
                ?? r2 = z2;
                if (z2) {
                    r2 = 1;
                }
                int i = (iHashCode + r2) * 31;
                Companion.AddStatus addStatus = this.addStatus;
                return i + (addStatus != null ? addStatus.hashCode() : 0);
            }

            public String toString() {
                StringBuilder sbU = outline.U("PermissionOwnerItem(permissionOwner=");
                sbU.append(this.permissionOwner);
                sbU.append(", checked=");
                sbU.append(this.checked);
                sbU.append(", addStatus=");
                sbU.append(this.addStatus);
                sbU.append(")");
                return sbU.toString();
            }
        }

        private Item() {
        }

        public /* synthetic */ Item(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AddMemberAdapter(RecyclerView recyclerView) {
        super(recyclerView, false, 2, null);
        Intrinsics3.checkNotNullParameter(recyclerView, "recyclerView");
    }

    public final void setOnClickListener(Function2<? super Long, ? super PermissionOverwrite.Type, Unit> onClickListener) {
        this.onClickListener = onClickListener;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public MGRecyclerViewHolder<AddMemberAdapter, Item> onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics3.checkNotNullParameter(parent, "parent");
        if (viewType == 0) {
            return new AddMemberAdapterCategoryItem(this);
        }
        if (viewType == 1) {
            return new AddMemberAdapterItemItem(this);
        }
        throw invalidViewTypeException(viewType);
    }
}
