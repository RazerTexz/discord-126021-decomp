package com.discord.widgets.settings.guildboost;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView$ViewHolder;
import com.discord.utilities.mg_recycler.MGRecyclerAdapterSimple;
import d0.z.d.m;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: SettingsGuildBoostSampleGuildAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class SettingsGuildBoostSampleGuildAdapter extends MGRecyclerAdapterSimple<SettingsGuildBoostSampleGuildAdapter$Item> {
    private Function1<? super Long, Unit> onGuildClickedListener;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SettingsGuildBoostSampleGuildAdapter(RecyclerView recyclerView) {
        super(recyclerView, false, 2, null);
        m.checkNotNullParameter(recyclerView, "recycler");
    }

    public static final /* synthetic */ Function1 access$getOnGuildClickedListener$p(SettingsGuildBoostSampleGuildAdapter settingsGuildBoostSampleGuildAdapter) {
        return settingsGuildBoostSampleGuildAdapter.onGuildClickedListener;
    }

    public static final /* synthetic */ void access$setOnGuildClickedListener$p(SettingsGuildBoostSampleGuildAdapter settingsGuildBoostSampleGuildAdapter, Function1 function1) {
        settingsGuildBoostSampleGuildAdapter.onGuildClickedListener = function1;
    }

    public final void configure(List<SettingsGuildBoostSampleGuildAdapter$Item> guildBoostItems, Function1<? super Long, Unit> onGuildClickedListener) {
        m.checkNotNullParameter(guildBoostItems, "guildBoostItems");
        m.checkNotNullParameter(onGuildClickedListener, "onGuildClickedListener");
        setData(guildBoostItems);
        this.onGuildClickedListener = onGuildClickedListener;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$Adapter
    public /* bridge */ /* synthetic */ RecyclerView$ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return onCreateViewHolder(viewGroup, i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$Adapter
    public SettingsGuildBoostSampleGuildAdapter$GuildListItem onCreateViewHolder(ViewGroup parent, int viewType) {
        m.checkNotNullParameter(parent, "parent");
        if (viewType == 1) {
            return new SettingsGuildBoostSampleGuildAdapter$GuildListItem(this);
        }
        throw invalidViewTypeException(viewType);
    }
}
