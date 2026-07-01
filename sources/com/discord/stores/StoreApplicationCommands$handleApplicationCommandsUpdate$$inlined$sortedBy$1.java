package com.discord.stores;

import androidx.exifinterface.media.ExifInterface;
import com.discord.models.commands.Application;
import d0.u.a;
import java.util.Comparator;

/* JADX INFO: compiled from: Comparisons.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreApplicationCommands$handleApplicationCommandsUpdate$$inlined$sortedBy$1<T> implements Comparator {
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Comparator
    public final int compare(T t, T t2) {
        return a.compareValues(((Application) t).getName(), ((Application) t2).getName());
    }
}
