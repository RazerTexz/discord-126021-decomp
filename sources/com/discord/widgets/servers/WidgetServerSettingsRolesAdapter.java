package com.discord.widgets.servers;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView$ViewHolder;
import com.discord.api.role.GuildRole;
import com.discord.utilities.mg_recycler.DragAndDropAdapter;
import com.discord.utilities.mg_recycler.DragAndDropAdapter$Payload;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import d0.d0.f;
import d0.z.d.m;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetServerSettingsRolesAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsRolesAdapter extends DragAndDropAdapter<DragAndDropAdapter$Payload> {
    public static final WidgetServerSettingsRolesAdapter$Companion Companion = new WidgetServerSettingsRolesAdapter$Companion(null);
    public static final int TYPE_HELP = 0;
    public static final int TYPE_ROLE = 1;
    private Function1<? super Map<String, Integer>, Unit> roleDropListener;
    private Function1<? super GuildRole, Unit> roleSelectedListener;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetServerSettingsRolesAdapter(RecyclerView recyclerView) {
        super(recyclerView);
        m.checkNotNullParameter(recyclerView, "recycler");
        this.roleSelectedListener = WidgetServerSettingsRolesAdapter$roleSelectedListener$1.INSTANCE;
        this.roleDropListener = WidgetServerSettingsRolesAdapter$roleDropListener$1.INSTANCE;
    }

    public static final /* synthetic */ Function1 access$getRoleSelectedListener$p(WidgetServerSettingsRolesAdapter widgetServerSettingsRolesAdapter) {
        return widgetServerSettingsRolesAdapter.roleSelectedListener;
    }

    public static final /* synthetic */ void access$setRoleSelectedListener$p(WidgetServerSettingsRolesAdapter widgetServerSettingsRolesAdapter, Function1 function1) {
        widgetServerSettingsRolesAdapter.roleSelectedListener = function1;
    }

    @Override // com.discord.utilities.mg_recycler.DragAndDropAdapter
    public Map<String, Integer> computeChangedPositions() {
        HashMap map = new HashMap();
        int size = getDataCopy().size();
        for (int i = 0; i < size; i++) {
            DragAndDropAdapter$Payload dragAndDropAdapter$Payload = getDataCopy().get(i);
            if (dragAndDropAdapter$Payload.getType() == 1) {
                WidgetServerSettingsRolesAdapter$RoleItem widgetServerSettingsRolesAdapter$RoleItem = (WidgetServerSettingsRolesAdapter$RoleItem) dragAndDropAdapter$Payload;
                if (!widgetServerSettingsRolesAdapter$RoleItem.getEveryoneRole()) {
                    int i2 = (size - 1) - i;
                    Integer num = getOrigPositions().get(widgetServerSettingsRolesAdapter$RoleItem.getKey());
                    if (num == null || i2 != num.intValue()) {
                        map.put(widgetServerSettingsRolesAdapter$RoleItem.getKey(), Integer.valueOf(i2));
                    }
                }
            }
        }
        return map;
    }

    public final void configure(List<? extends DragAndDropAdapter$Payload> roles, Function1<? super GuildRole, Unit> roleSelectedListener, Function1<? super Map<String, Integer>, Unit> roleDropListener) {
        m.checkNotNullParameter(roles, "roles");
        m.checkNotNullParameter(roleSelectedListener, "roleSelectedListener");
        m.checkNotNullParameter(roleDropListener, "roleDropListener");
        this.roleSelectedListener = roleSelectedListener;
        this.roleDropListener = roleDropListener;
        setData(roles);
    }

    @Override // com.discord.utilities.mg_recycler.DragAndDropHelper$Adapter
    public boolean isValidMove(int fromPosition, int toPosition) {
        int iCoerceAtMost = f.coerceAtMost(fromPosition, toPosition);
        int iCoerceAtLeast = f.coerceAtLeast(fromPosition, toPosition);
        if (iCoerceAtMost <= iCoerceAtLeast) {
            while (true) {
                DragAndDropAdapter$Payload dragAndDropAdapter$Payload = getDataCopy().get(iCoerceAtMost);
                if (dragAndDropAdapter$Payload.getType() != 1 || !((WidgetServerSettingsRolesAdapter$RoleItem) dragAndDropAdapter$Payload).canReorder()) {
                    return false;
                }
                if (iCoerceAtMost != iCoerceAtLeast) {
                    iCoerceAtMost++;
                }
            }
        }
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$Adapter
    public /* bridge */ /* synthetic */ RecyclerView$ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return onCreateViewHolder(viewGroup, i);
    }

    @Override // com.discord.utilities.mg_recycler.DragAndDropAdapter
    public void onNewPositions(Map<String, Integer> newPositions) {
        m.checkNotNullParameter(newPositions, "newPositions");
        this.roleDropListener.invoke(newPositions);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$Adapter
    public MGRecyclerViewHolder<?, DragAndDropAdapter$Payload> onCreateViewHolder(ViewGroup parent, int viewType) {
        m.checkNotNullParameter(parent, "parent");
        if (viewType == 0) {
            return new WidgetServerSettingsRolesAdapter$RoleListHelpItem(this);
        }
        if (viewType == 1) {
            return new WidgetServerSettingsRolesAdapter$RoleListItem(this);
        }
        throw invalidViewTypeException(viewType);
    }
}
