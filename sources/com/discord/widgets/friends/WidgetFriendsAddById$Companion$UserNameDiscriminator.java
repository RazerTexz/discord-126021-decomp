package com.discord.widgets.friends;

import b.d.b.a.a;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetFriendsAddById.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class WidgetFriendsAddById$Companion$UserNameDiscriminator {
    private final Integer discriminator;
    private final String username;

    public WidgetFriendsAddById$Companion$UserNameDiscriminator(String str, Integer num) {
        m.checkNotNullParameter(str, "username");
        this.username = str;
        this.discriminator = num;
    }

    public static /* synthetic */ WidgetFriendsAddById$Companion$UserNameDiscriminator copy$default(WidgetFriendsAddById$Companion$UserNameDiscriminator widgetFriendsAddById$Companion$UserNameDiscriminator, String str, Integer num, int i, Object obj) {
        if ((i & 1) != 0) {
            str = widgetFriendsAddById$Companion$UserNameDiscriminator.username;
        }
        if ((i & 2) != 0) {
            num = widgetFriendsAddById$Companion$UserNameDiscriminator.discriminator;
        }
        return widgetFriendsAddById$Companion$UserNameDiscriminator.copy(str, num);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getUsername() {
        return this.username;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Integer getDiscriminator() {
        return this.discriminator;
    }

    public final WidgetFriendsAddById$Companion$UserNameDiscriminator copy(String username, Integer discriminator) {
        m.checkNotNullParameter(username, "username");
        return new WidgetFriendsAddById$Companion$UserNameDiscriminator(username, discriminator);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetFriendsAddById$Companion$UserNameDiscriminator)) {
            return false;
        }
        WidgetFriendsAddById$Companion$UserNameDiscriminator widgetFriendsAddById$Companion$UserNameDiscriminator = (WidgetFriendsAddById$Companion$UserNameDiscriminator) other;
        return m.areEqual(this.username, widgetFriendsAddById$Companion$UserNameDiscriminator.username) && m.areEqual(this.discriminator, widgetFriendsAddById$Companion$UserNameDiscriminator.discriminator);
    }

    public final Integer getDiscriminator() {
        return this.discriminator;
    }

    public final String getUsername() {
        return this.username;
    }

    public int hashCode() {
        String str = this.username;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        Integer num = this.discriminator;
        return iHashCode + (num != null ? num.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("UserNameDiscriminator(username=");
        sbU.append(this.username);
        sbU.append(", discriminator=");
        return a.F(sbU, this.discriminator, ")");
    }
}
