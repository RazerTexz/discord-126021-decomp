package com.discord.widgets.settings.guildboost;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView$ViewHolder;
import com.discord.models.domain.ModelGuildBoostSlot;
import com.discord.utilities.mg_recycler.MGRecyclerAdapterSimple;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import d0.z.d.m;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: WidgetSettingsGuildBoostSubscriptionAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsGuildBoostSubscriptionAdapter extends MGRecyclerAdapterSimple<WidgetSettingsGuildBoostSubscriptionAdapter$Item> {
    private boolean canCancelBoosts;
    private boolean canUncancelBoosts;
    private Function2<? super Long, ? super Boolean, Unit> cancelListener;
    private Function1<? super Long, Unit> subscribeListener;
    private Function2<? super ModelGuildBoostSlot, ? super Long, Unit> transferListener;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetSettingsGuildBoostSubscriptionAdapter(RecyclerView recyclerView) {
        super(recyclerView, false, 2, null);
        m.checkNotNullParameter(recyclerView, "recycler");
        this.subscribeListener = WidgetSettingsGuildBoostSubscriptionAdapter$subscribeListener$1.INSTANCE;
        this.transferListener = WidgetSettingsGuildBoostSubscriptionAdapter$transferListener$1.INSTANCE;
        this.cancelListener = WidgetSettingsGuildBoostSubscriptionAdapter$cancelListener$1.INSTANCE;
    }

    public static final /* synthetic */ boolean access$getCanCancelBoosts$p(WidgetSettingsGuildBoostSubscriptionAdapter widgetSettingsGuildBoostSubscriptionAdapter) {
        return widgetSettingsGuildBoostSubscriptionAdapter.canCancelBoosts;
    }

    public static final /* synthetic */ boolean access$getCanUncancelBoosts$p(WidgetSettingsGuildBoostSubscriptionAdapter widgetSettingsGuildBoostSubscriptionAdapter) {
        return widgetSettingsGuildBoostSubscriptionAdapter.canUncancelBoosts;
    }

    public static final /* synthetic */ Function2 access$getCancelListener$p(WidgetSettingsGuildBoostSubscriptionAdapter widgetSettingsGuildBoostSubscriptionAdapter) {
        return widgetSettingsGuildBoostSubscriptionAdapter.cancelListener;
    }

    public static final /* synthetic */ Function1 access$getSubscribeListener$p(WidgetSettingsGuildBoostSubscriptionAdapter widgetSettingsGuildBoostSubscriptionAdapter) {
        return widgetSettingsGuildBoostSubscriptionAdapter.subscribeListener;
    }

    public static final /* synthetic */ Function2 access$getTransferListener$p(WidgetSettingsGuildBoostSubscriptionAdapter widgetSettingsGuildBoostSubscriptionAdapter) {
        return widgetSettingsGuildBoostSubscriptionAdapter.transferListener;
    }

    public static final /* synthetic */ void access$setCanCancelBoosts$p(WidgetSettingsGuildBoostSubscriptionAdapter widgetSettingsGuildBoostSubscriptionAdapter, boolean z2) {
        widgetSettingsGuildBoostSubscriptionAdapter.canCancelBoosts = z2;
    }

    public static final /* synthetic */ void access$setCanUncancelBoosts$p(WidgetSettingsGuildBoostSubscriptionAdapter widgetSettingsGuildBoostSubscriptionAdapter, boolean z2) {
        widgetSettingsGuildBoostSubscriptionAdapter.canUncancelBoosts = z2;
    }

    public static final /* synthetic */ void access$setCancelListener$p(WidgetSettingsGuildBoostSubscriptionAdapter widgetSettingsGuildBoostSubscriptionAdapter, Function2 function2) {
        widgetSettingsGuildBoostSubscriptionAdapter.cancelListener = function2;
    }

    public static final /* synthetic */ void access$setSubscribeListener$p(WidgetSettingsGuildBoostSubscriptionAdapter widgetSettingsGuildBoostSubscriptionAdapter, Function1 function1) {
        widgetSettingsGuildBoostSubscriptionAdapter.subscribeListener = function1;
    }

    public static final /* synthetic */ void access$setTransferListener$p(WidgetSettingsGuildBoostSubscriptionAdapter widgetSettingsGuildBoostSubscriptionAdapter, Function2 function2) {
        widgetSettingsGuildBoostSubscriptionAdapter.transferListener = function2;
    }

    public final void configure(List<? extends WidgetSettingsGuildBoostSubscriptionAdapter$Item> guildBoostItems, Function1<? super Long, Unit> subscribeListener, Function2<? super ModelGuildBoostSlot, ? super Long, Unit> transferListener, Function2<? super Long, ? super Boolean, Unit> cancelListener, boolean canCancelBoosts, boolean canUncancelBoosts) {
        m.checkNotNullParameter(guildBoostItems, "guildBoostItems");
        m.checkNotNullParameter(subscribeListener, "subscribeListener");
        m.checkNotNullParameter(transferListener, "transferListener");
        m.checkNotNullParameter(cancelListener, "cancelListener");
        setData(guildBoostItems);
        this.subscribeListener = subscribeListener;
        this.transferListener = transferListener;
        this.cancelListener = cancelListener;
        this.canCancelBoosts = canCancelBoosts;
        this.canUncancelBoosts = canUncancelBoosts;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$Adapter
    public /* bridge */ /* synthetic */ RecyclerView$ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return onCreateViewHolder(viewGroup, i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$Adapter
    public MGRecyclerViewHolder<WidgetSettingsGuildBoostSubscriptionAdapter, WidgetSettingsGuildBoostSubscriptionAdapter$Item> onCreateViewHolder(ViewGroup parent, int viewType) {
        m.checkNotNullParameter(parent, "parent");
        if (viewType == 0) {
            return new WidgetSettingsGuildBoostSubscriptionAdapter$GuildListItem(this);
        }
        if (viewType == 1) {
            return new WidgetSettingsGuildBoostSubscriptionAdapter$GuildBoostListItem(this);
        }
        if (viewType == 2) {
            return new WidgetSettingsGuildBoostSubscriptionAdapter$HeaderListItem(this);
        }
        throw invalidViewTypeException(viewType);
    }
}
