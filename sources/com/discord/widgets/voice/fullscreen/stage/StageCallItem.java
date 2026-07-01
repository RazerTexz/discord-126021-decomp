package com.discord.widgets.voice.fullscreen.stage;

import com.discord.utilities.mg_recycler.MGRecyclerDataPayload;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: StageCallItem.kt */
/* JADX INFO: loaded from: classes.dex */
public abstract class StageCallItem implements MGRecyclerDataPayload {
    public static final StageCallItem$Companion Companion = new StageCallItem$Companion(null);
    public static final int TYPE_AUDIENCE = 3;
    public static final int TYPE_AUDIENCE_HEADER = 2;
    public static final int TYPE_DETAILS = 0;
    public static final int TYPE_DIVIDER = 4;
    public static final int TYPE_MEDIA = 6;
    public static final int TYPE_PRESTART_DETAILS = 5;
    public static final int TYPE_SPEAKER = 1;
    private final String key;
    private final int type;

    private StageCallItem(String str, int i) {
        this.key = str;
        this.type = i;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
    public String getKey() {
        return this.key;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
    public int getType() {
        return this.type;
    }

    public /* synthetic */ StageCallItem(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, i);
    }
}
