package com.discord.widgets.settings.developer;

import androidx.recyclerview.widget.RecyclerView$ViewHolder;
import com.discord.stores.StoreStream;
import com.discord.utilities.views.SwipeableItemTouchHelper;
import com.discord.utilities.views.SwipeableItemTouchHelper$SwipeRevealConfiguration;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetSettingsDeveloper.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsDeveloper$setupNoticesSection$1$1 extends SwipeableItemTouchHelper {
    public final /* synthetic */ SwipeableItemTouchHelper$SwipeRevealConfiguration $deleteConfig;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetSettingsDeveloper$setupNoticesSection$1$1(SwipeableItemTouchHelper$SwipeRevealConfiguration swipeableItemTouchHelper$SwipeRevealConfiguration, SwipeableItemTouchHelper$SwipeRevealConfiguration swipeableItemTouchHelper$SwipeRevealConfiguration2, SwipeableItemTouchHelper$SwipeRevealConfiguration swipeableItemTouchHelper$SwipeRevealConfiguration3) {
        super(0, 0, swipeableItemTouchHelper$SwipeRevealConfiguration2, swipeableItemTouchHelper$SwipeRevealConfiguration3, 3, null);
        this.$deleteConfig = swipeableItemTouchHelper$SwipeRevealConfiguration;
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper$Callback
    public void onSwiped(RecyclerView$ViewHolder viewHolder, int direction) {
        m.checkNotNullParameter(viewHolder, "viewHolder");
        if (viewHolder instanceof WidgetSettingsDeveloper$NoticeViewHolder) {
            StoreStream.Companion.getNotices().clearSeen(((WidgetSettingsDeveloper$NoticeViewHolder) viewHolder).getNoticeName());
        }
    }
}
