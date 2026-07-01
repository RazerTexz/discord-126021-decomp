package com.discord.widgets.friends;

import b.d.b.a.a;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetFriendsFindNearby.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class WidgetFriendsFindNearby$Model$Error extends WidgetFriendsFindNearby$Model {
    private final Integer errorCode;

    public WidgetFriendsFindNearby$Model$Error(Integer num) {
        super(null);
        this.errorCode = num;
    }

    public static /* synthetic */ WidgetFriendsFindNearby$Model$Error copy$default(WidgetFriendsFindNearby$Model$Error widgetFriendsFindNearby$Model$Error, Integer num, int i, Object obj) {
        if ((i & 1) != 0) {
            num = widgetFriendsFindNearby$Model$Error.errorCode;
        }
        return widgetFriendsFindNearby$Model$Error.copy(num);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Integer getErrorCode() {
        return this.errorCode;
    }

    public final WidgetFriendsFindNearby$Model$Error copy(Integer errorCode) {
        return new WidgetFriendsFindNearby$Model$Error(errorCode);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof WidgetFriendsFindNearby$Model$Error) && m.areEqual(this.errorCode, ((WidgetFriendsFindNearby$Model$Error) other).errorCode);
        }
        return true;
    }

    public final Integer getErrorCode() {
        return this.errorCode;
    }

    public int hashCode() {
        Integer num = this.errorCode;
        if (num != null) {
            return num.hashCode();
        }
        return 0;
    }

    public String toString() {
        return a.F(a.U("Error(errorCode="), this.errorCode, ")");
    }
}
