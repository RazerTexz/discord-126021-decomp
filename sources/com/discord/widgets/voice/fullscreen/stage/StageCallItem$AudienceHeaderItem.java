package com.discord.widgets.voice.fullscreen.stage;

import b.d.b.a.a;

/* JADX INFO: compiled from: StageCallItem.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class StageCallItem$AudienceHeaderItem extends StageCallItem {
    private final int audienceSize;

    public StageCallItem$AudienceHeaderItem(int i) {
        super("audience-header", 2, null);
        this.audienceSize = i;
    }

    public static /* synthetic */ StageCallItem$AudienceHeaderItem copy$default(StageCallItem$AudienceHeaderItem stageCallItem$AudienceHeaderItem, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = stageCallItem$AudienceHeaderItem.audienceSize;
        }
        return stageCallItem$AudienceHeaderItem.copy(i);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getAudienceSize() {
        return this.audienceSize;
    }

    public final StageCallItem$AudienceHeaderItem copy(int audienceSize) {
        return new StageCallItem$AudienceHeaderItem(audienceSize);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof StageCallItem$AudienceHeaderItem) && this.audienceSize == ((StageCallItem$AudienceHeaderItem) other).audienceSize;
        }
        return true;
    }

    public final int getAudienceSize() {
        return this.audienceSize;
    }

    public int hashCode() {
        return this.audienceSize;
    }

    public String toString() {
        return a.B(a.U("AudienceHeaderItem(audienceSize="), this.audienceSize, ")");
    }
}
