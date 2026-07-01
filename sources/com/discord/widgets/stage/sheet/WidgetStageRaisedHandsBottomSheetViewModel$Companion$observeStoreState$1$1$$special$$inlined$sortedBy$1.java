package com.discord.widgets.stage.sheet;

import androidx.exifinterface.media.ExifInterface;
import d0.u.a;
import java.util.Comparator;

/* JADX INFO: compiled from: Comparisons.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetStageRaisedHandsBottomSheetViewModel$Companion$observeStoreState$1$1$$special$$inlined$sortedBy$1<T> implements Comparator {
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Comparator
    public final int compare(T t, T t2) {
        return a.compareValues(((WidgetStageRaisedHandsBottomSheetAdapter$ListItem$Participant) t).getRequestToSpeakTimestamp(), ((WidgetStageRaisedHandsBottomSheetAdapter$ListItem$Participant) t2).getRequestToSpeakTimestamp());
    }
}
