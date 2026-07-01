package com.discord.widgets.user;

import androidx.core.app.NotificationCompat$MessagingStyle$Message;
import b.d.b.a.a;
import com.discord.models.domain.emoji.Emoji;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetUserSetCustomStatusViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class WidgetUserSetCustomStatusViewModel$FormState {
    private final Emoji emoji;
    private final WidgetUserSetCustomStatusViewModel$FormState$Expiration expiration;
    private final String text;

    public WidgetUserSetCustomStatusViewModel$FormState(Emoji emoji, String str, WidgetUserSetCustomStatusViewModel$FormState$Expiration widgetUserSetCustomStatusViewModel$FormState$Expiration) {
        m.checkNotNullParameter(str, NotificationCompat$MessagingStyle$Message.KEY_TEXT);
        m.checkNotNullParameter(widgetUserSetCustomStatusViewModel$FormState$Expiration, "expiration");
        this.emoji = emoji;
        this.text = str;
        this.expiration = widgetUserSetCustomStatusViewModel$FormState$Expiration;
    }

    public static /* synthetic */ WidgetUserSetCustomStatusViewModel$FormState copy$default(WidgetUserSetCustomStatusViewModel$FormState widgetUserSetCustomStatusViewModel$FormState, Emoji emoji, String str, WidgetUserSetCustomStatusViewModel$FormState$Expiration widgetUserSetCustomStatusViewModel$FormState$Expiration, int i, Object obj) {
        if ((i & 1) != 0) {
            emoji = widgetUserSetCustomStatusViewModel$FormState.emoji;
        }
        if ((i & 2) != 0) {
            str = widgetUserSetCustomStatusViewModel$FormState.text;
        }
        if ((i & 4) != 0) {
            widgetUserSetCustomStatusViewModel$FormState$Expiration = widgetUserSetCustomStatusViewModel$FormState.expiration;
        }
        return widgetUserSetCustomStatusViewModel$FormState.copy(emoji, str, widgetUserSetCustomStatusViewModel$FormState$Expiration);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Emoji getEmoji() {
        return this.emoji;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getText() {
        return this.text;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final WidgetUserSetCustomStatusViewModel$FormState$Expiration getExpiration() {
        return this.expiration;
    }

    public final WidgetUserSetCustomStatusViewModel$FormState copy(Emoji emoji, String text, WidgetUserSetCustomStatusViewModel$FormState$Expiration expiration) {
        m.checkNotNullParameter(text, NotificationCompat$MessagingStyle$Message.KEY_TEXT);
        m.checkNotNullParameter(expiration, "expiration");
        return new WidgetUserSetCustomStatusViewModel$FormState(emoji, text, expiration);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetUserSetCustomStatusViewModel$FormState)) {
            return false;
        }
        WidgetUserSetCustomStatusViewModel$FormState widgetUserSetCustomStatusViewModel$FormState = (WidgetUserSetCustomStatusViewModel$FormState) other;
        return m.areEqual(this.emoji, widgetUserSetCustomStatusViewModel$FormState.emoji) && m.areEqual(this.text, widgetUserSetCustomStatusViewModel$FormState.text) && m.areEqual(this.expiration, widgetUserSetCustomStatusViewModel$FormState.expiration);
    }

    public final Emoji getEmoji() {
        return this.emoji;
    }

    public final WidgetUserSetCustomStatusViewModel$FormState$Expiration getExpiration() {
        return this.expiration;
    }

    public final String getText() {
        return this.text;
    }

    public int hashCode() {
        Emoji emoji = this.emoji;
        int iHashCode = (emoji != null ? emoji.hashCode() : 0) * 31;
        String str = this.text;
        int iHashCode2 = (iHashCode + (str != null ? str.hashCode() : 0)) * 31;
        WidgetUserSetCustomStatusViewModel$FormState$Expiration widgetUserSetCustomStatusViewModel$FormState$Expiration = this.expiration;
        return iHashCode2 + (widgetUserSetCustomStatusViewModel$FormState$Expiration != null ? widgetUserSetCustomStatusViewModel$FormState$Expiration.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("FormState(emoji=");
        sbU.append(this.emoji);
        sbU.append(", text=");
        sbU.append(this.text);
        sbU.append(", expiration=");
        sbU.append(this.expiration);
        sbU.append(")");
        return sbU.toString();
    }
}
