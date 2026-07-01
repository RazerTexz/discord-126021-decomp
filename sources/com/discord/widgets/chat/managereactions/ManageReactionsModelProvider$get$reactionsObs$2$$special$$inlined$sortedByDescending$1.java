package com.discord.widgets.chat.managereactions;

import androidx.exifinterface.media.ExifInterface;
import com.discord.api.message.reaction.MessageReaction;
import d0.u.a;
import java.util.Comparator;

/* JADX INFO: compiled from: Comparisons.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ManageReactionsModelProvider$get$reactionsObs$2$$special$$inlined$sortedByDescending$1<T> implements Comparator {
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Comparator
    public final int compare(T t, T t2) {
        return a.compareValues(Integer.valueOf(((MessageReaction) t2).getCount()), Integer.valueOf(((MessageReaction) t).getCount()));
    }
}
