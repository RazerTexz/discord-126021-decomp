package com.discord.widgets.user.profile;

import b.d.b.a.a;
import com.discord.models.domain.emoji.ModelEmojiUnicode;
import d0.z.d.m;

/* JADX INFO: compiled from: UserStatusPresenceCustomView.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class UserStatusPresenceCustomView$ViewState$WithPlaceholder extends UserStatusPresenceCustomView$ViewState {
    private final ModelEmojiUnicode placeholderEmoji;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UserStatusPresenceCustomView$ViewState$WithPlaceholder(ModelEmojiUnicode modelEmojiUnicode) {
        super(null);
        m.checkNotNullParameter(modelEmojiUnicode, "placeholderEmoji");
        this.placeholderEmoji = modelEmojiUnicode;
    }

    public static /* synthetic */ UserStatusPresenceCustomView$ViewState$WithPlaceholder copy$default(UserStatusPresenceCustomView$ViewState$WithPlaceholder userStatusPresenceCustomView$ViewState$WithPlaceholder, ModelEmojiUnicode modelEmojiUnicode, int i, Object obj) {
        if ((i & 1) != 0) {
            modelEmojiUnicode = userStatusPresenceCustomView$ViewState$WithPlaceholder.placeholderEmoji;
        }
        return userStatusPresenceCustomView$ViewState$WithPlaceholder.copy(modelEmojiUnicode);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final ModelEmojiUnicode getPlaceholderEmoji() {
        return this.placeholderEmoji;
    }

    public final UserStatusPresenceCustomView$ViewState$WithPlaceholder copy(ModelEmojiUnicode placeholderEmoji) {
        m.checkNotNullParameter(placeholderEmoji, "placeholderEmoji");
        return new UserStatusPresenceCustomView$ViewState$WithPlaceholder(placeholderEmoji);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof UserStatusPresenceCustomView$ViewState$WithPlaceholder) && m.areEqual(this.placeholderEmoji, ((UserStatusPresenceCustomView$ViewState$WithPlaceholder) other).placeholderEmoji);
        }
        return true;
    }

    public final ModelEmojiUnicode getPlaceholderEmoji() {
        return this.placeholderEmoji;
    }

    public int hashCode() {
        ModelEmojiUnicode modelEmojiUnicode = this.placeholderEmoji;
        if (modelEmojiUnicode != null) {
            return modelEmojiUnicode.hashCode();
        }
        return 0;
    }

    public String toString() {
        StringBuilder sbU = a.U("WithPlaceholder(placeholderEmoji=");
        sbU.append(this.placeholderEmoji);
        sbU.append(")");
        return sbU.toString();
    }
}
