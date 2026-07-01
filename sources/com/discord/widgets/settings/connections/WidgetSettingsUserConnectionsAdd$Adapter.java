package com.discord.widgets.settings.connections;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView$ViewHolder;
import com.discord.R$layout;
import com.discord.utilities.mg_recycler.MGRecyclerAdapterSimple;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: WidgetSettingsUserConnectionsAdd.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsUserConnectionsAdd$Adapter extends MGRecyclerAdapterSimple<WidgetSettingsUserConnectionsAdd$PlatformItem> {
    private final Function0<Unit> dialogDismissCallback;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetSettingsUserConnectionsAdd$Adapter(RecyclerView recyclerView, Function0<Unit> function0) {
        super(recyclerView, false, 2, null);
        m.checkNotNullParameter(recyclerView, "recyclerView");
        m.checkNotNullParameter(function0, "dialogDismissCallback");
        this.dialogDismissCallback = function0;
    }

    public final Function0<Unit> getDialogDismissCallback() {
        return this.dialogDismissCallback;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$Adapter
    public /* bridge */ /* synthetic */ RecyclerView$ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return onCreateViewHolder(viewGroup, i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$Adapter
    public MGRecyclerViewHolder<WidgetSettingsUserConnectionsAdd$Adapter, WidgetSettingsUserConnectionsAdd$PlatformItem> onCreateViewHolder(ViewGroup parent, int viewType) {
        m.checkNotNullParameter(parent, "parent");
        return new WidgetSettingsUserConnectionsAdd$Adapter$ViewHolder(R$layout.widget_settings_item_add_connected_account, this, this.dialogDismissCallback);
    }
}
