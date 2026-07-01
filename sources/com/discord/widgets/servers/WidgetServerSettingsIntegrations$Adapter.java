package com.discord.widgets.servers;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView$ViewHolder;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.mg_recycler.MGRecyclerAdapterSimple;
import d0.z.d.m;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetServerSettingsIntegrations.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsIntegrations$Adapter extends MGRecyclerAdapterSimple<WidgetServerSettingsIntegrations$Model$IntegrationItem> {
    private Function1<? super Long, Unit> onIntegrationSelectedListener;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetServerSettingsIntegrations$Adapter(RecyclerView recyclerView) {
        super(recyclerView, false, 2, null);
        m.checkNotNullParameter(recyclerView, "recycler");
    }

    public final void configure(List<WidgetServerSettingsIntegrations$Model$IntegrationItem> data, Function1<? super Long, Unit> onIntegrationSelectedListener) {
        m.checkNotNullParameter(data, "data");
        this.onIntegrationSelectedListener = onIntegrationSelectedListener;
        setData(data);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$Adapter
    public /* bridge */ /* synthetic */ RecyclerView$ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return onCreateViewHolder(viewGroup, i);
    }

    public final void onIntegrationSelected(long id2) {
        Function1<? super Long, Unit> function1 = this.onIntegrationSelectedListener;
        if (function1 != null) {
            function1.invoke(Long.valueOf(id2));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView$Adapter
    public WidgetServerSettingsIntegrationsListItem onCreateViewHolder(ViewGroup parent, int viewType) {
        m.checkNotNullParameter(parent, "parent");
        if (viewType == 0) {
            return new WidgetServerSettingsIntegrationsListItem(this);
        }
        throw invalidViewTypeException(viewType);
    }
}
