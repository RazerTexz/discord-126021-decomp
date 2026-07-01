package com.discord.widgets.servers;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView$ViewHolder;
import com.discord.models.domain.ModelBan;
import com.discord.utilities.mg_recycler.MGRecyclerAdapterSimple;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetServerSettingsBans.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsBans$Adapter extends MGRecyclerAdapterSimple<WidgetServerSettingsBans$Model$BanItem> {
    private Function1<? super ModelBan, Unit> onBanSelectedListener;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetServerSettingsBans$Adapter(RecyclerView recyclerView) {
        super(recyclerView, false, 2, null);
        m.checkNotNullParameter(recyclerView, "recycler");
    }

    public final Function1<ModelBan, Unit> getOnBanSelectedListener() {
        return this.onBanSelectedListener;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$Adapter
    public /* bridge */ /* synthetic */ RecyclerView$ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return onCreateViewHolder(viewGroup, i);
    }

    public final void setOnBanSelectedListener(Function1<? super ModelBan, Unit> function1) {
        this.onBanSelectedListener = function1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$Adapter
    public WidgetServerSettingsBans$Adapter$BanListItem onCreateViewHolder(ViewGroup parent, int viewType) {
        m.checkNotNullParameter(parent, "parent");
        if (viewType == 1) {
            return new WidgetServerSettingsBans$Adapter$BanListItem(this, this);
        }
        throw invalidViewTypeException(viewType);
    }
}
