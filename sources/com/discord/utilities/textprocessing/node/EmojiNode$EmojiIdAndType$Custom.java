package com.discord.utilities.textprocessing.node;

import a0.a.a.b;
import b.d.b.a.a;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.m;

/* JADX INFO: compiled from: EmojiNode.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class EmojiNode$EmojiIdAndType$Custom extends EmojiNode$EmojiIdAndType {
    private final long id;
    private final boolean isAnimated;
    private final String name;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EmojiNode$EmojiIdAndType$Custom(long j, boolean z2, String str) {
        super(null);
        m.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
        this.id = j;
        this.isAnimated = z2;
        this.name = str;
    }

    public static /* synthetic */ EmojiNode$EmojiIdAndType$Custom copy$default(EmojiNode$EmojiIdAndType$Custom emojiNode$EmojiIdAndType$Custom, long j, boolean z2, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            j = emojiNode$EmojiIdAndType$Custom.id;
        }
        if ((i & 2) != 0) {
            z2 = emojiNode$EmojiIdAndType$Custom.isAnimated;
        }
        if ((i & 4) != 0) {
            str = emojiNode$EmojiIdAndType$Custom.name;
        }
        return emojiNode$EmojiIdAndType$Custom.copy(j, z2, str);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final long getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getIsAnimated() {
        return this.isAnimated;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getName() {
        return this.name;
    }

    public final EmojiNode$EmojiIdAndType$Custom copy(long id2, boolean isAnimated, String name) {
        m.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
        return new EmojiNode$EmojiIdAndType$Custom(id2, isAnimated, name);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof EmojiNode$EmojiIdAndType$Custom)) {
            return false;
        }
        EmojiNode$EmojiIdAndType$Custom emojiNode$EmojiIdAndType$Custom = (EmojiNode$EmojiIdAndType$Custom) other;
        return this.id == emojiNode$EmojiIdAndType$Custom.id && this.isAnimated == emojiNode$EmojiIdAndType$Custom.isAnimated && m.areEqual(this.name, emojiNode$EmojiIdAndType$Custom.name);
    }

    public final long getId() {
        return this.id;
    }

    public final String getName() {
        return this.name;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v7 */
    public int hashCode() {
        int iA = b.a(this.id) * 31;
        boolean z2 = this.isAnimated;
        ?? r1 = z2;
        if (z2) {
            r1 = 1;
        }
        int i = (iA + r1) * 31;
        String str = this.name;
        return i + (str != null ? str.hashCode() : 0);
    }

    public final boolean isAnimated() {
        return this.isAnimated;
    }

    public String toString() {
        StringBuilder sbU = a.U("Custom(id=");
        sbU.append(this.id);
        sbU.append(", isAnimated=");
        sbU.append(this.isAnimated);
        sbU.append(", name=");
        return a.J(sbU, this.name, ")");
    }
}
