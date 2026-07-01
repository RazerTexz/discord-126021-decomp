package com.discord.widgets.bugreports;

import com.discord.api.bugreport.Feature;
import com.discord.api.sticker.Sticker;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: BugReportViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class BugReportViewModel$Companion {
    private BugReportViewModel$Companion() {
    }

    public final List<Feature> getGenericFeatureAreas() {
        return BugReportViewModel.access$getGenericFeatureAreas$cp();
    }

    public final List<Sticker> getSendingStickers() {
        return BugReportViewModel.access$getSendingStickers$cp();
    }

    public final List<Sticker> getSuccessStickers() {
        return BugReportViewModel.access$getSuccessStickers$cp();
    }

    public /* synthetic */ BugReportViewModel$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
