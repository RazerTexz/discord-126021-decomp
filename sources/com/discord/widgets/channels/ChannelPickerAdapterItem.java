package com.discord.widgets.channels;

import com.discord.api.channel.Channel;
import com.discord.utilities.recycler.DiffKeyProvider;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetChannelPickerAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class ChannelPickerAdapterItem implements DiffKeyProvider {

    /* JADX INFO: compiled from: WidgetChannelPickerAdapter.kt */
    public static final /* data */ class ChannelItem extends ChannelPickerAdapterItem {
        private final Channel channel;
        private final boolean isSelected;
        private final String key;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ChannelItem(Channel channel, boolean z2) {
            super(null);
            C12238m.checkNotNullParameter(channel, "channel");
            this.channel = channel;
            this.isSelected = z2;
            this.key = String.valueOf(channel.getId());
        }

        public static /* synthetic */ ChannelItem copy$default(ChannelItem channelItem, Channel channel, boolean z2, int i, Object obj) {
            if ((i & 1) != 0) {
                channel = channelItem.channel;
            }
            if ((i & 2) != 0) {
                z2 = channelItem.isSelected;
            }
            return channelItem.copy(channel, z2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Channel getChannel() {
            return this.channel;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final boolean getIsSelected() {
            return this.isSelected;
        }

        public final ChannelItem copy(Channel channel, boolean isSelected) {
            C12238m.checkNotNullParameter(channel, "channel");
            return new ChannelItem(channel, isSelected);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ChannelItem)) {
                return false;
            }
            ChannelItem channelItem = (ChannelItem) other;
            return C12238m.areEqual(this.channel, channelItem.channel) && this.isSelected == channelItem.isSelected;
        }

        public final Channel getChannel() {
            return this.channel;
        }

        @Override // com.discord.utilities.recycler.DiffKeyProvider
        public String getKey() {
            return this.key;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v4, types: [int] */
        /* JADX WARN: Type inference failed for: r1v1, types: [int] */
        /* JADX WARN: Type inference failed for: r1v2 */
        /* JADX WARN: Type inference failed for: r1v3 */
        public int hashCode() {
            Channel channel = this.channel;
            int iHashCode = (channel != null ? channel.hashCode() : 0) * 31;
            boolean z2 = this.isSelected;
            ?? r1 = z2;
            if (z2) {
                r1 = 1;
            }
            return iHashCode + r1;
        }

        public final boolean isSelected() {
            return this.isSelected;
        }

        public String toString() {
            StringBuilder sbM833U = C1643a.m833U("ChannelItem(channel=");
            sbM833U.append(this.channel);
            sbM833U.append(", isSelected=");
            return C1643a.m827O(sbM833U, this.isSelected, ")");
        }
    }

    /* JADX INFO: compiled from: WidgetChannelPickerAdapter.kt */
    public static final class CreateChannelItem extends ChannelPickerAdapterItem {
        public static final CreateChannelItem INSTANCE = new CreateChannelItem();
        private static final String key = "channel-picker-create-channel-item";

        private CreateChannelItem() {
            super(null);
        }

        @Override // com.discord.utilities.recycler.DiffKeyProvider
        public String getKey() {
            return key;
        }
    }

    private ChannelPickerAdapterItem() {
    }

    public /* synthetic */ ChannelPickerAdapterItem(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
