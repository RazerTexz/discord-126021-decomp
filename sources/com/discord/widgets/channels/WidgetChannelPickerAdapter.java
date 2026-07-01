package com.discord.widgets.channels;

import b.d.b.a.outline;
import com.discord.api.channel.Channel;
import com.discord.utilities.recycler.DiffKeyProvider;
import d0.z.d.Intrinsics3;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: renamed from: com.discord.widgets.channels.ChannelPickerAdapterItem, reason: use source file name */
/* JADX INFO: compiled from: WidgetChannelPickerAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class WidgetChannelPickerAdapter implements DiffKeyProvider {

    /* JADX INFO: renamed from: com.discord.widgets.channels.ChannelPickerAdapterItem$ChannelItem */
    /* JADX INFO: compiled from: WidgetChannelPickerAdapter.kt */
    public static final /* data */ class ChannelItem extends WidgetChannelPickerAdapter {
        private final Channel channel;
        private final boolean isSelected;
        private final String key;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ChannelItem(Channel channel, boolean z2) {
            super(null);
            Intrinsics3.checkNotNullParameter(channel, "channel");
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
            Intrinsics3.checkNotNullParameter(channel, "channel");
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
            return Intrinsics3.areEqual(this.channel, channelItem.channel) && this.isSelected == channelItem.isSelected;
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
            StringBuilder sbU = outline.U("ChannelItem(channel=");
            sbU.append(this.channel);
            sbU.append(", isSelected=");
            return outline.O(sbU, this.isSelected, ")");
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.channels.ChannelPickerAdapterItem$CreateChannelItem */
    /* JADX INFO: compiled from: WidgetChannelPickerAdapter.kt */
    public static final class CreateChannelItem extends WidgetChannelPickerAdapter {
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

    private WidgetChannelPickerAdapter() {
    }

    public /* synthetic */ WidgetChannelPickerAdapter(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
