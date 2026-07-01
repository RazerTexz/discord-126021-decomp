package com.discord.widgets.bugreports;

import a0.a.a.b;
import androidx.annotation.StringRes;
import b.d.b.a.a;
import com.discord.models.domain.ModelAuditLogEntry;

/* JADX INFO: compiled from: WidgetBugReport.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class Priority {
    private final int description;
    private final long emojiId;
    private final int title;

    public Priority(@StringRes int i, @StringRes int i2, long j) {
        this.title = i;
        this.description = i2;
        this.emojiId = j;
    }

    public static /* synthetic */ Priority copy$default(Priority priority, int i, int i2, long j, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = priority.title;
        }
        if ((i3 & 2) != 0) {
            i2 = priority.description;
        }
        if ((i3 & 4) != 0) {
            j = priority.emojiId;
        }
        return priority.copy(i, i2, j);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getTitle() {
        return this.title;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getDescription() {
        return this.description;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final long getEmojiId() {
        return this.emojiId;
    }

    public final Priority copy(@StringRes int title, @StringRes int description, long emojiId) {
        return new Priority(title, description, emojiId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Priority)) {
            return false;
        }
        Priority priority = (Priority) other;
        return this.title == priority.title && this.description == priority.description && this.emojiId == priority.emojiId;
    }

    public final int getDescription() {
        return this.description;
    }

    public final long getEmojiId() {
        return this.emojiId;
    }

    public final int getTitle() {
        return this.title;
    }

    public int hashCode() {
        return b.a(this.emojiId) + (((this.title * 31) + this.description) * 31);
    }

    public String toString() {
        StringBuilder sbU = a.U("Priority(title=");
        sbU.append(this.title);
        sbU.append(", description=");
        sbU.append(this.description);
        sbU.append(", emojiId=");
        return a.C(sbU, this.emojiId, ")");
    }
}
