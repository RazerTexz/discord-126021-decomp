package com.discord.widgets.stage.start;

import com.discord.utilities.analytics.Traits$Location$Section;
import com.discord.utilities.mg_recycler.MGRecyclerDataPayload;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: ModeratorStartStageItem.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class ModeratorStartStageItem implements MGRecyclerDataPayload {
    public static final ModeratorStartStageItem$Companion Companion = new ModeratorStartStageItem$Companion(null);
    public static final String KEY_SCHEDULE_EVENT = "KEY_SCHEDULE_EVENT";
    public static final String KEY_START_STAGE = "KEY_START_STAGE";
    public static final int TYPE_CONTINUE = 2;
    public static final int TYPE_HEADER = 0;
    public static final int TYPE_LIST_ITEM = 1;
    public static final int TYPE_WAITING = 3;

    private ModeratorStartStageItem() {
    }

    public /* synthetic */ ModeratorStartStageItem(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
