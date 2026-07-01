package com.discord.api.channel;

import java.util.Comparator;

/* JADX INFO: compiled from: ChannelUtils.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ChannelUtils$getSortByNameAndType$1<T> implements Comparator<Channel> {
    public final /* synthetic */ Channel$Companion $this_getSortByNameAndType;

    public ChannelUtils$getSortByNameAndType$1(Channel$Companion channel$Companion) {
        this.$this_getSortByNameAndType = channel$Companion;
    }

    @Override // java.util.Comparator
    public int compare(Channel channel, Channel channel2) {
        long id2;
        long id3;
        int position;
        int position2;
        Channel channel3 = channel;
        Channel channel4 = channel2;
        if (channel3 == null) {
            return channel4 == null ? 0 : -1;
        }
        if (channel4 != null) {
            if (channel3.getType() == 4 && channel4.getType() == 4) {
                if (channel3.getPosition() != channel4.getPosition()) {
                    position = channel3.getPosition();
                    position2 = channel4.getPosition();
                    return position - position2;
                }
                id2 = channel3.getId();
                id3 = channel4.getId();
                return (id2 > id3 ? 1 : (id2 == id3 ? 0 : -1));
            }
            if (channel3.getType() == 4) {
                return -1;
            }
            if (channel4.getType() != 4) {
                if (channel3.getType() == 0 && ChannelUtils.w(channel4)) {
                    return -1;
                }
                if (!ChannelUtils.w(channel3) || channel4.getType() != 0) {
                    if (channel3.getPosition() != channel4.getPosition()) {
                        position = channel3.getPosition();
                        position2 = channel4.getPosition();
                        return position - position2;
                    }
                    id2 = channel3.getId();
                    id3 = channel4.getId();
                    return (id2 > id3 ? 1 : (id2 == id3 ? 0 : -1));
                }
            }
        }
        return 1;
    }
}
