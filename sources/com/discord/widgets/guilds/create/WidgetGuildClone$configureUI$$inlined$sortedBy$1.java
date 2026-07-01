package com.discord.widgets.guilds.create;

import androidx.exifinterface.media.ExifInterface;
import com.discord.api.channel.Channel;
import d0.u.a;
import java.util.Comparator;

/* JADX INFO: compiled from: Comparisons.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildClone$configureUI$$inlined$sortedBy$1<T> implements Comparator {
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Comparator
    public final int compare(T t, T t2) {
        Channel channel = (Channel) t;
        Channel channel2 = (Channel) t2;
        return a.compareValues(Long.valueOf(channel.getParentId() == 0 ? channel.getId() * ((long) 10000) : (channel.getParentId() * ((long) 10000)) + channel.getId()), Long.valueOf(channel2.getParentId() == 0 ? channel2.getId() * ((long) 10000) : (channel2.getParentId() * ((long) 10000)) + channel2.getId()));
    }
}
