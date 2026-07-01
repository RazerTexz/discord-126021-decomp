package com.discord.widgets.voice.fullscreen.stage;

import b.d.b.a.a;
import d0.z.d.m;

/* JADX INFO: compiled from: StageCallItem.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class StageCallItem$PreStartDetailsItem extends StageCallItem {
    private final int numAudience;
    private final int numSpeakers;
    private final String subtitle;
    private final String title;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StageCallItem$PreStartDetailsItem(String str, String str2, int i, int i2) {
        super("pre-start-details", 5, null);
        m.checkNotNullParameter(str, "title");
        m.checkNotNullParameter(str2, "subtitle");
        this.title = str;
        this.subtitle = str2;
        this.numSpeakers = i;
        this.numAudience = i2;
    }

    public static /* synthetic */ StageCallItem$PreStartDetailsItem copy$default(StageCallItem$PreStartDetailsItem stageCallItem$PreStartDetailsItem, String str, String str2, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = stageCallItem$PreStartDetailsItem.title;
        }
        if ((i3 & 2) != 0) {
            str2 = stageCallItem$PreStartDetailsItem.subtitle;
        }
        if ((i3 & 4) != 0) {
            i = stageCallItem$PreStartDetailsItem.numSpeakers;
        }
        if ((i3 & 8) != 0) {
            i2 = stageCallItem$PreStartDetailsItem.numAudience;
        }
        return stageCallItem$PreStartDetailsItem.copy(str, str2, i, i2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getSubtitle() {
        return this.subtitle;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getNumSpeakers() {
        return this.numSpeakers;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final int getNumAudience() {
        return this.numAudience;
    }

    public final StageCallItem$PreStartDetailsItem copy(String title, String subtitle, int numSpeakers, int numAudience) {
        m.checkNotNullParameter(title, "title");
        m.checkNotNullParameter(subtitle, "subtitle");
        return new StageCallItem$PreStartDetailsItem(title, subtitle, numSpeakers, numAudience);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof StageCallItem$PreStartDetailsItem)) {
            return false;
        }
        StageCallItem$PreStartDetailsItem stageCallItem$PreStartDetailsItem = (StageCallItem$PreStartDetailsItem) other;
        return m.areEqual(this.title, stageCallItem$PreStartDetailsItem.title) && m.areEqual(this.subtitle, stageCallItem$PreStartDetailsItem.subtitle) && this.numSpeakers == stageCallItem$PreStartDetailsItem.numSpeakers && this.numAudience == stageCallItem$PreStartDetailsItem.numAudience;
    }

    public final int getNumAudience() {
        return this.numAudience;
    }

    public final int getNumSpeakers() {
        return this.numSpeakers;
    }

    public final String getSubtitle() {
        return this.subtitle;
    }

    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        String str = this.title;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.subtitle;
        return ((((iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31) + this.numSpeakers) * 31) + this.numAudience;
    }

    public String toString() {
        StringBuilder sbU = a.U("PreStartDetailsItem(title=");
        sbU.append(this.title);
        sbU.append(", subtitle=");
        sbU.append(this.subtitle);
        sbU.append(", numSpeakers=");
        sbU.append(this.numSpeakers);
        sbU.append(", numAudience=");
        return a.B(sbU, this.numAudience, ")");
    }
}
