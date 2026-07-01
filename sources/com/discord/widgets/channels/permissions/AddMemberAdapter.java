package com.discord.widgets.channels.permissions;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView$ViewHolder;
import com.discord.api.permission.PermissionOverwrite$Type;
import com.discord.utilities.mg_recycler.MGRecyclerAdapterSimple;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: AddMemberAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class AddMemberAdapter extends MGRecyclerAdapterSimple<AddMemberAdapter$Item> {
    private Function2<? super Long, ? super PermissionOverwrite$Type, Unit> onClickListener;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AddMemberAdapter(RecyclerView recyclerView) {
        super(recyclerView, false, 2, null);
        m.checkNotNullParameter(recyclerView, "recyclerView");
    }

    public static final /* synthetic */ Function2 access$getOnClickListener$p(AddMemberAdapter addMemberAdapter) {
        return addMemberAdapter.onClickListener;
    }

    public static final /* synthetic */ void access$setOnClickListener$p(AddMemberAdapter addMemberAdapter, Function2 function2) {
        addMemberAdapter.onClickListener = function2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$Adapter
    public /* bridge */ /* synthetic */ RecyclerView$ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return onCreateViewHolder(viewGroup, i);
    }

    public final void setOnClickListener(Function2<? super Long, ? super PermissionOverwrite$Type, Unit> onClickListener) {
        this.onClickListener = onClickListener;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$Adapter
    public MGRecyclerViewHolder<AddMemberAdapter, AddMemberAdapter$Item> onCreateViewHolder(ViewGroup parent, int viewType) {
        m.checkNotNullParameter(parent, "parent");
        if (viewType == 0) {
            return new AddMemberAdapter$AddMemberAdapterCategoryItem(this);
        }
        if (viewType == 1) {
            return new AddMemberAdapter$AddMemberAdapterItemItem(this);
        }
        throw invalidViewTypeException(viewType);
    }
}
