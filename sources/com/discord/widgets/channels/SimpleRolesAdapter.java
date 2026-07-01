package com.discord.widgets.channels;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView$ViewHolder;
import com.discord.api.role.GuildRole;
import com.discord.utilities.mg_recycler.MGRecyclerAdapterSimple;
import d0.z.d.m;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: SimpleRolesAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class SimpleRolesAdapter extends MGRecyclerAdapterSimple<SimpleRolesAdapter$RoleItem> {
    private Function1<? super GuildRole, Unit> onRoleClickedListener;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SimpleRolesAdapter(RecyclerView recyclerView) {
        super(recyclerView, false, 2, null);
        m.checkNotNullParameter(recyclerView, "recycler");
    }

    public static final /* synthetic */ Function1 access$getOnRoleClickedListener$p(SimpleRolesAdapter simpleRolesAdapter) {
        return simpleRolesAdapter.onRoleClickedListener;
    }

    public static final /* synthetic */ void access$setOnRoleClickedListener$p(SimpleRolesAdapter simpleRolesAdapter, Function1 function1) {
        simpleRolesAdapter.onRoleClickedListener = function1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$Adapter
    public /* bridge */ /* synthetic */ RecyclerView$ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return onCreateViewHolder(viewGroup, i);
    }

    public final void setData(List<SimpleRolesAdapter$RoleItem> data, Function1<? super GuildRole, Unit> onRoleClickedListener) {
        m.checkNotNullParameter(data, "data");
        m.checkNotNullParameter(onRoleClickedListener, "onRoleClickedListener");
        super.setData(data);
        this.onRoleClickedListener = onRoleClickedListener;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$Adapter
    public SimpleRolesAdapter$RoleAdapterItem onCreateViewHolder(ViewGroup parent, int viewType) {
        m.checkNotNullParameter(parent, "parent");
        if (viewType == 0) {
            return new SimpleRolesAdapter$RoleAdapterItem(this);
        }
        throw invalidViewTypeException(viewType);
    }
}
