package com.discord.widgets.settings.premium;

import android.view.ViewGroup;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView$ViewHolder;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.view.recycler.SimpleItemCallback;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetSettingsGiftingOutboundPromosAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsGiftingOutboundPromosAdapter extends ListAdapter<SettingsGiftingViewModel$OutboundPromoItem, WidgetSettingsGiftingOutboundPromosAdapter$OutboundPromoViewHolder> {
    public static final WidgetSettingsGiftingOutboundPromosAdapter$Companion Companion = new WidgetSettingsGiftingOutboundPromosAdapter$Companion(null);
    private static final SimpleItemCallback<SettingsGiftingViewModel$OutboundPromoItem> DIFF_CALLBACK = new SimpleItemCallback<>(WidgetSettingsGiftingOutboundPromosAdapter$Companion$DIFF_CALLBACK$1.INSTANCE);
    private final Function1<SettingsGiftingViewModel$OutboundPromoItem, Unit> onButtonClick;
    private final Function1<SettingsGiftingViewModel$OutboundPromoItem, Unit> onMoreDetailsClick;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public WidgetSettingsGiftingOutboundPromosAdapter(Function1<? super SettingsGiftingViewModel$OutboundPromoItem, Unit> function1, Function1<? super SettingsGiftingViewModel$OutboundPromoItem, Unit> function2) {
        super(DIFF_CALLBACK);
        m.checkNotNullParameter(function1, "onMoreDetailsClick");
        m.checkNotNullParameter(function2, "onButtonClick");
        this.onMoreDetailsClick = function1;
        this.onButtonClick = function2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$Adapter
    public /* bridge */ /* synthetic */ void onBindViewHolder(RecyclerView$ViewHolder recyclerView$ViewHolder, int i) {
        onBindViewHolder((WidgetSettingsGiftingOutboundPromosAdapter$OutboundPromoViewHolder) recyclerView$ViewHolder, i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$Adapter
    public /* bridge */ /* synthetic */ RecyclerView$ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return onCreateViewHolder(viewGroup, i);
    }

    public void onBindViewHolder(WidgetSettingsGiftingOutboundPromosAdapter$OutboundPromoViewHolder holder, int position) {
        m.checkNotNullParameter(holder, "holder");
        SettingsGiftingViewModel$OutboundPromoItem item = getItem(position);
        m.checkNotNullExpressionValue(item, "getItem(position)");
        holder.bindTo(item);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$Adapter
    public WidgetSettingsGiftingOutboundPromosAdapter$OutboundPromoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        m.checkNotNullParameter(parent, "parent");
        return new WidgetSettingsGiftingOutboundPromosAdapter$OutboundPromoViewHolder(parent, this.onMoreDetailsClick, this.onButtonClick);
    }
}
