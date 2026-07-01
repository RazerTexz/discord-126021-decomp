package com.discord.widgets.channels.list;

import d0.d0.f;
import d0.t.n;
import d0.t.u;
import d0.z.d.m;
import java.util.Collection;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.IntProgression;
import kotlin.ranges.IntRange;

/* JADX INFO: compiled from: WidgetChannelListUnreads.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelListUnreads$Model$Companion {
    private WidgetChannelListUnreads$Model$Companion() {
    }

    private final WidgetChannelListUnreads$Model$Indicator findIndicator(List<? extends Object> list, IntProgression intProgression, boolean z2, boolean z3) {
        int i;
        int first = intProgression.getFirst();
        int last = intProgression.getLast();
        int step = intProgression.getStep();
        if (step < 0 ? first < last : first > last) {
            i = -1;
        } else {
            i = -1;
            while (true) {
                Object obj = list.get(first);
                if (!(obj instanceof WidgetChannelListUnreads$UnreadItem)) {
                    obj = null;
                }
                WidgetChannelListUnreads$UnreadItem widgetChannelListUnreads$UnreadItem = (WidgetChannelListUnreads$UnreadItem) obj;
                if (widgetChannelListUnreads$UnreadItem != null) {
                    if (widgetChannelListUnreads$UnreadItem.getMentionCount() > 0) {
                        return new WidgetChannelListUnreads$Model$Indicator(0, first);
                    }
                    if (z3 && !z2 && i == -1 && widgetChannelListUnreads$UnreadItem.getIsUnread()) {
                        i = first;
                    }
                }
                if (first != last) {
                    first += step;
                }
            }
        }
        if (i != -1) {
            return new WidgetChannelListUnreads$Model$Indicator(1, i);
        }
        return null;
    }

    public static /* synthetic */ WidgetChannelListUnreads$Model get$default(WidgetChannelListUnreads$Model$Companion widgetChannelListUnreads$Model$Companion, IntRange intRange, List list, boolean z2, int i, Object obj) {
        if ((i & 4) != 0) {
            z2 = true;
        }
        return widgetChannelListUnreads$Model$Companion.get(intRange, list, z2);
    }

    private final boolean hasUnread(List<? extends Object> list, IntRange intRange) {
        List listSlice = u.slice(list, intRange);
        if (!(listSlice instanceof Collection) || !listSlice.isEmpty()) {
            for (Object obj : listSlice) {
                if (!(obj instanceof WidgetChannelListUnreads$UnreadItem)) {
                    obj = null;
                }
                WidgetChannelListUnreads$UnreadItem widgetChannelListUnreads$UnreadItem = (WidgetChannelListUnreads$UnreadItem) obj;
                if (widgetChannelListUnreads$UnreadItem != null && widgetChannelListUnreads$UnreadItem.getIsUnread()) {
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0017  */
    public final WidgetChannelListUnreads$Model get(IntRange visibleRange, List<? extends Object> items, boolean unreadsEnabled) {
        boolean z2;
        m.checkNotNullParameter(visibleRange, "visibleRange");
        m.checkNotNullParameter(items, "items");
        if (unreadsEnabled) {
            try {
                if (hasUnread(items, visibleRange)) {
                    z2 = true;
                } else {
                    z2 = false;
                }
            } catch (IndexOutOfBoundsException unused) {
                return new WidgetChannelListUnreads$Model(null, null, 3, null);
            }
        } else {
            z2 = false;
        }
        return new WidgetChannelListUnreads$Model(findIndicator(items, f.until(0, visibleRange.getFirst()), z2, unreadsEnabled), findIndicator(items, f.downTo(n.getLastIndex(items), visibleRange.getLast() + 1), z2, unreadsEnabled));
    }

    public /* synthetic */ WidgetChannelListUnreads$Model$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
