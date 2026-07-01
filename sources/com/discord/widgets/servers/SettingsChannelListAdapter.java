package com.discord.widgets.servers;

import android.view.ViewGroup;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView$ViewHolder;
import com.discord.utilities.mg_recycler.CategoricalDragAndDropAdapter;
import com.discord.utilities.mg_recycler.CategoricalDragAndDropAdapter$Payload;
import com.discord.utilities.mg_recycler.DragAndDropHelper;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import d0.t.h0;
import d0.t.n;
import d0.z.d.m;
import java.util.HashMap;
import java.util.Map;
import java.util.Map$Entry;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.functions.Action1;

/* JADX INFO: compiled from: SettingsChannelListAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class SettingsChannelListAdapter extends CategoricalDragAndDropAdapter<CategoricalDragAndDropAdapter$Payload> {
    public static final SettingsChannelListAdapter$Companion Companion = new SettingsChannelListAdapter$Companion(null);
    public static final int TYPE_CATEGORY = 1;
    public static final int TYPE_CHANNEL = 0;
    private Function1<? super Long, Unit> onClickListener;
    private Function1<? super Map<Long, SettingsChannelListAdapter$UpdatedPosition>, Unit> onPositionUpdateListener;

    public /* synthetic */ SettingsChannelListAdapter(RecyclerView recyclerView, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(recyclerView, (i & 2) != 0 ? true : z2);
    }

    private final void handleChangedPositions(Map<Long, Integer> changedPositions, Map<Long, Long> changedParentIds) {
        HashMap map = new HashMap();
        for (Map$Entry<Long, Integer> map$Entry : changedPositions.entrySet()) {
            long jLongValue = map$Entry.getKey().longValue();
            map.put(Long.valueOf(jLongValue), new SettingsChannelListAdapter$UpdatedPosition(map$Entry.getValue().intValue(), changedParentIds.get(Long.valueOf(jLongValue))));
        }
        Function1<? super Map<Long, SettingsChannelListAdapter$UpdatedPosition>, Unit> function1 = this.onPositionUpdateListener;
        if (function1 != null) {
            function1.invoke(map);
        }
    }

    @Override // com.discord.utilities.mg_recycler.CategoricalDragAndDropAdapter, com.discord.utilities.mg_recycler.DragAndDropAdapter
    public Map<String, Integer> computeChangedPositions() {
        SettingsChannelListAdapter$computeChangedPositions$1 settingsChannelListAdapter$computeChangedPositions$1 = SettingsChannelListAdapter$computeChangedPositions$1.INSTANCE;
        SettingsChannelListAdapter$computeChangedPositions$2 settingsChannelListAdapter$computeChangedPositions$2 = SettingsChannelListAdapter$computeChangedPositions$2.INSTANCE;
        SettingsChannelListAdapter$computeChangedPositions$3 settingsChannelListAdapter$computeChangedPositions$3 = SettingsChannelListAdapter$computeChangedPositions$3.INSTANCE;
        HashMap map = new HashMap();
        HashMap map2 = new HashMap();
        int i = 0;
        Long lInvoke = null;
        for (Object obj : getDataCopy()) {
            int i2 = i + 1;
            if (i < 0) {
                n.throwIndexOverflow();
            }
            CategoricalDragAndDropAdapter$Payload categoricalDragAndDropAdapter$Payload = (CategoricalDragAndDropAdapter$Payload) obj;
            Long lInvoke2 = SettingsChannelListAdapter$computeChangedPositions$1.INSTANCE.invoke2(categoricalDragAndDropAdapter$Payload);
            long jLongValue = lInvoke2 != null ? lInvoke2.longValue() : 0L;
            if (categoricalDragAndDropAdapter$Payload.getType() == 1) {
                lInvoke = SettingsChannelListAdapter$computeChangedPositions$2.INSTANCE.invoke(jLongValue);
            }
            Long lInvoke3 = categoricalDragAndDropAdapter$Payload.getType() != 0 ? null : SettingsChannelListAdapter$computeChangedPositions$2.INSTANCE.invoke(((SettingsChannelListAdapter$ChannelItem) categoricalDragAndDropAdapter$Payload).getParentId());
            Integer num = getOrigPositions().get(categoricalDragAndDropAdapter$Payload.getKey());
            if ((num == null || num.intValue() != i) && SettingsChannelListAdapter$computeChangedPositions$3.INSTANCE.invoke2(categoricalDragAndDropAdapter$Payload)) {
                map.put(Long.valueOf(jLongValue), Integer.valueOf(i));
                if ((!m.areEqual(lInvoke3, lInvoke)) && categoricalDragAndDropAdapter$Payload.getType() == 0) {
                    map2.put(Long.valueOf(jLongValue), Long.valueOf(lInvoke != null ? lInvoke.longValue() : -1L));
                }
            }
            i = i2;
        }
        handleChangedPositions(map, map2);
        return h0.emptyMap();
    }

    public final Function1<Long, Unit> getOnClickListener() {
        return this.onClickListener;
    }

    @Override // com.discord.utilities.mg_recycler.CategoricalDragAndDropAdapter, com.discord.utilities.mg_recycler.DragAndDropHelper$Adapter
    public boolean isValidMove(int fromPosition, int toPosition) {
        if (toPosition <= 0) {
            return false;
        }
        CategoricalDragAndDropAdapter$Payload categoricalDragAndDropAdapter$Payload = (CategoricalDragAndDropAdapter$Payload) getItem(toPosition - 1);
        int type = categoricalDragAndDropAdapter$Payload.getType();
        if (type == 0) {
            return ((SettingsChannelListAdapter$ChannelItem) categoricalDragAndDropAdapter$Payload).getCanManageCategoryOfChannel();
        }
        if (type != 1) {
            return false;
        }
        return ((SettingsChannelListAdapter$CategoryItem) categoricalDragAndDropAdapter$Payload).getCanManageChannelsOfCategory();
    }

    @Override // androidx.recyclerview.widget.RecyclerView$Adapter
    public /* bridge */ /* synthetic */ RecyclerView$ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return onCreateViewHolder(viewGroup, i);
    }

    @Override // com.discord.utilities.mg_recycler.DragAndDropAdapter
    public void onNewPositions(Map<String, Integer> newPositions) {
        m.checkNotNullParameter(newPositions, "newPositions");
    }

    public final void setOnClickListener(Function1<? super Long, Unit> function1) {
        this.onClickListener = function1;
    }

    public final void setPositionUpdateListener(Action1<Map<Long, SettingsChannelListAdapter$UpdatedPosition>> onPositionUpdateListener) {
        m.checkNotNullParameter(onPositionUpdateListener, "onPositionUpdateListener");
        this.onPositionUpdateListener = new SettingsChannelListAdapter$setPositionUpdateListener$1(onPositionUpdateListener);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SettingsChannelListAdapter(RecyclerView recyclerView, boolean z2) {
        super(recyclerView);
        m.checkNotNullParameter(recyclerView, "recycler");
        if (z2) {
            new ItemTouchHelper(new DragAndDropHelper(this, 0, 2, null)).attachToRecyclerView(recyclerView);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView$Adapter
    public MGRecyclerViewHolder<SettingsChannelListAdapter, CategoricalDragAndDropAdapter$Payload> onCreateViewHolder(ViewGroup parent, int viewType) {
        m.checkNotNullParameter(parent, "parent");
        if (viewType == 0) {
            return new SettingsChannelListAdapter$ChannelListItem(this);
        }
        if (viewType == 1) {
            return new SettingsChannelListAdapter$CategoryListItem(this);
        }
        throw invalidViewTypeException(viewType);
    }
}
