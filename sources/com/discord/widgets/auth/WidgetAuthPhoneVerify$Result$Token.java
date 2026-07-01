package com.discord.widgets.auth;

import b.d.b.a.a;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetAuthPhoneVerify.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class WidgetAuthPhoneVerify$Result$Token extends WidgetAuthPhoneVerify$Result {
    private final String token;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetAuthPhoneVerify$Result$Token(String str) {
        super(null);
        m.checkNotNullParameter(str, "token");
        this.token = str;
    }

    public static /* synthetic */ WidgetAuthPhoneVerify$Result$Token copy$default(WidgetAuthPhoneVerify$Result$Token widgetAuthPhoneVerify$Result$Token, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = widgetAuthPhoneVerify$Result$Token.token;
        }
        return widgetAuthPhoneVerify$Result$Token.copy(str);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getToken() {
        return this.token;
    }

    public final WidgetAuthPhoneVerify$Result$Token copy(String token) {
        m.checkNotNullParameter(token, "token");
        return new WidgetAuthPhoneVerify$Result$Token(token);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof WidgetAuthPhoneVerify$Result$Token) && m.areEqual(this.token, ((WidgetAuthPhoneVerify$Result$Token) other).token);
        }
        return true;
    }

    public final String getToken() {
        return this.token;
    }

    public int hashCode() {
        String str = this.token;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    public String toString() {
        return a.J(a.U("Token(token="), this.token, ")");
    }
}
