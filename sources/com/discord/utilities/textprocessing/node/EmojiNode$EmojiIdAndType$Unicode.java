package com.discord.utilities.textprocessing.node;

import b.d.b.a.a;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.m;

/* JADX INFO: compiled from: EmojiNode.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class EmojiNode$EmojiIdAndType$Unicode extends EmojiNode$EmojiIdAndType {
    private final String name;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EmojiNode$EmojiIdAndType$Unicode(String str) {
        super(null);
        m.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
        this.name = str;
    }

    public static /* synthetic */ EmojiNode$EmojiIdAndType$Unicode copy$default(EmojiNode$EmojiIdAndType$Unicode emojiNode$EmojiIdAndType$Unicode, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = emojiNode$EmojiIdAndType$Unicode.name;
        }
        return emojiNode$EmojiIdAndType$Unicode.copy(str);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getName() {
        return this.name;
    }

    public final EmojiNode$EmojiIdAndType$Unicode copy(String name) {
        m.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
        return new EmojiNode$EmojiIdAndType$Unicode(name);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof EmojiNode$EmojiIdAndType$Unicode) && m.areEqual(this.name, ((EmojiNode$EmojiIdAndType$Unicode) other).name);
        }
        return true;
    }

    public final String getName() {
        return this.name;
    }

    public int hashCode() {
        String str = this.name;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    public String toString() {
        return a.J(a.U("Unicode(name="), this.name, ")");
    }
}
