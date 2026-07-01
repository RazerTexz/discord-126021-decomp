package com.discord.widgets.servers;

import androidx.recyclerview.widget.RecyclerView$ViewHolder;
import com.discord.api.channel.Channel;
import com.discord.models.domain.ModelNotificationSettings;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUserGuildSettings;
import com.discord.utilities.views.SwipeableItemTouchHelper;
import com.discord.utilities.views.SwipeableItemTouchHelper$SwipeRevealConfiguration;
import d0.t.u;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetServerNotifications.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerNotifications$createSwipeableItemTouchHelper$1 extends SwipeableItemTouchHelper {
    public final /* synthetic */ SwipeableItemTouchHelper$SwipeRevealConfiguration $deleteConfig;
    public final /* synthetic */ WidgetServerNotifications this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetServerNotifications$createSwipeableItemTouchHelper$1(WidgetServerNotifications widgetServerNotifications, SwipeableItemTouchHelper$SwipeRevealConfiguration swipeableItemTouchHelper$SwipeRevealConfiguration, SwipeableItemTouchHelper$SwipeRevealConfiguration swipeableItemTouchHelper$SwipeRevealConfiguration2, SwipeableItemTouchHelper$SwipeRevealConfiguration swipeableItemTouchHelper$SwipeRevealConfiguration3) {
        super(0, 0, swipeableItemTouchHelper$SwipeRevealConfiguration2, swipeableItemTouchHelper$SwipeRevealConfiguration3, 3, null);
        this.this$0 = widgetServerNotifications;
        this.$deleteConfig = swipeableItemTouchHelper$SwipeRevealConfiguration;
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper$Callback
    public void onSwiped(RecyclerView$ViewHolder viewHolder, int direction) {
        m.checkNotNullParameter(viewHolder, "viewHolder");
        NotificationsOverridesAdapter$Item notificationsOverridesAdapter$Item = (NotificationsOverridesAdapter$Item) u.getOrNull(WidgetServerNotifications.access$getOverrideAdapter$p(this.this$0).getData(), viewHolder.getAdapterPosition());
        if (notificationsOverridesAdapter$Item != null) {
            Channel channel = notificationsOverridesAdapter$Item.getChannel();
            if (notificationsOverridesAdapter$Item.getOverrideSettings().isMuted()) {
                StoreUserGuildSettings.setChannelMuted$default(StoreStream.Companion.getUserGuildSettings(), this.this$0.requireContext(), channel.getId(), false, null, 8, null);
            }
            StoreStream.Companion.getUserGuildSettings().setChannelFrequency(this.this$0.requireContext(), channel, ModelNotificationSettings.FREQUENCY_UNSET);
        }
    }
}
