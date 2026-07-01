package com.discord.widgets.guilds.create;

import androidx.exifinterface.media.ExifInterface;
import com.discord.api.role.GuildRole;
import d0.u.a;
import java.util.Comparator;

/* JADX INFO: compiled from: Comparisons.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildClone$configureUI$$inlined$sortedBy$2<T> implements Comparator {
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Comparator
    public final int compare(T t, T t2) {
        return a.compareValues(Long.valueOf(-((GuildRole) t).getId()), Long.valueOf(-((GuildRole) t2).getId()));
    }
}
