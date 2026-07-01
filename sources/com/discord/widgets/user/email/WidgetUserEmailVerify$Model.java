package com.discord.widgets.user.email;

import androidx.core.app.NotificationCompat;
import b.d.b.a.a;
import com.discord.models.user.MeUser;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetUserEmailVerify.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class WidgetUserEmailVerify$Model {
    public static final WidgetUserEmailVerify$Model$Companion Companion = new WidgetUserEmailVerify$Model$Companion(null);
    private final String email;
    private final MeUser me;
    private final boolean verified;

    public WidgetUserEmailVerify$Model(MeUser meUser) {
        m.checkNotNullParameter(meUser, "me");
        this.me = meUser;
        this.email = meUser.getEmail();
        this.verified = meUser.isVerified();
    }

    public static /* synthetic */ WidgetUserEmailVerify$Model copy$default(WidgetUserEmailVerify$Model widgetUserEmailVerify$Model, MeUser meUser, int i, Object obj) {
        if ((i & 1) != 0) {
            meUser = widgetUserEmailVerify$Model.me;
        }
        return widgetUserEmailVerify$Model.copy(meUser);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final MeUser getMe() {
        return this.me;
    }

    public final WidgetUserEmailVerify$Model copy(MeUser me2) {
        m.checkNotNullParameter(me2, "me");
        return new WidgetUserEmailVerify$Model(me2);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof WidgetUserEmailVerify$Model) && m.areEqual(this.me, ((WidgetUserEmailVerify$Model) other).me);
        }
        return true;
    }

    public final String getEmail() {
        return this.email;
    }

    public final MeUser getMe() {
        return this.me;
    }

    public final boolean getVerified() {
        return this.verified;
    }

    public int hashCode() {
        MeUser meUser = this.me;
        if (meUser != null) {
            return meUser.hashCode();
        }
        return 0;
    }

    public String toString() {
        StringBuilder sbU = a.U("Model(me=");
        sbU.append(this.me);
        sbU.append(")");
        return sbU.toString();
    }
}
