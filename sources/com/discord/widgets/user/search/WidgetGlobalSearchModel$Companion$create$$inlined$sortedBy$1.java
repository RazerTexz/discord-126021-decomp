package com.discord.widgets.user.search;

import androidx.exifinterface.media.ExifInterface;
import com.discord.api.channel.Channel;
import d0.u.a;
import java.util.Comparator;

/* JADX INFO: compiled from: Comparisons.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetGlobalSearchModel$Companion$create$$inlined$sortedBy$1<T> implements Comparator {
    public final /* synthetic */ WidgetGlobalSearchModel$SearchContext $searchContext$inlined;

    public WidgetGlobalSearchModel$Companion$create$$inlined$sortedBy$1(WidgetGlobalSearchModel$SearchContext widgetGlobalSearchModel$SearchContext) {
        this.$searchContext$inlined = widgetGlobalSearchModel$SearchContext;
    }

    /* JADX WARN: Code duplicated, block: B:13:0x0039  */
    @Override // java.util.Comparator
    public final int compare(T t, T t2) {
        int iIntValue;
        Channel channel = ((WidgetGlobalSearchModel$ItemDataPayload) t).getChannel();
        int iIntValue2 = Integer.MAX_VALUE;
        if (channel != null) {
            Integer numValueOf = Integer.valueOf(this.$searchContext$inlined.getRecentGuildIds().indexOf(Long.valueOf(channel.getGuildId())));
            if (!(numValueOf.intValue() != -1)) {
                numValueOf = null;
            }
            if (numValueOf != null) {
                iIntValue = numValueOf.intValue();
            } else {
                iIntValue = Integer.MAX_VALUE;
            }
        } else {
            iIntValue = Integer.MAX_VALUE;
        }
        Integer numValueOf2 = Integer.valueOf(iIntValue);
        Channel channel2 = ((WidgetGlobalSearchModel$ItemDataPayload) t2).getChannel();
        if (channel2 != null) {
            Integer numValueOf3 = Integer.valueOf(this.$searchContext$inlined.getRecentGuildIds().indexOf(Long.valueOf(channel2.getGuildId())));
            Integer num = numValueOf3.intValue() != -1 ? numValueOf3 : null;
            if (num != null) {
                iIntValue2 = num.intValue();
            }
        }
        return a.compareValues(numValueOf2, Integer.valueOf(iIntValue2));
    }
}
