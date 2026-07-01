package com.discord.widgets.auth;

import b.d.b.a.a;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetRemoteAuthViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class WidgetRemoteAuthViewModel$ViewState$Loaded extends WidgetRemoteAuthViewModel$ViewState {
    private final String handshakeToken;
    private final boolean isTemporary;
    private final boolean loginAllowed;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetRemoteAuthViewModel$ViewState$Loaded(String str, boolean z2, boolean z3) {
        super(null);
        m.checkNotNullParameter(str, "handshakeToken");
        this.handshakeToken = str;
        this.isTemporary = z2;
        this.loginAllowed = z3;
    }

    public static /* synthetic */ WidgetRemoteAuthViewModel$ViewState$Loaded copy$default(WidgetRemoteAuthViewModel$ViewState$Loaded widgetRemoteAuthViewModel$ViewState$Loaded, String str, boolean z2, boolean z3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = widgetRemoteAuthViewModel$ViewState$Loaded.handshakeToken;
        }
        if ((i & 2) != 0) {
            z2 = widgetRemoteAuthViewModel$ViewState$Loaded.isTemporary;
        }
        if ((i & 4) != 0) {
            z3 = widgetRemoteAuthViewModel$ViewState$Loaded.loginAllowed;
        }
        return widgetRemoteAuthViewModel$ViewState$Loaded.copy(str, z2, z3);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getHandshakeToken() {
        return this.handshakeToken;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getIsTemporary() {
        return this.isTemporary;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getLoginAllowed() {
        return this.loginAllowed;
    }

    public final WidgetRemoteAuthViewModel$ViewState$Loaded copy(String handshakeToken, boolean isTemporary, boolean loginAllowed) {
        m.checkNotNullParameter(handshakeToken, "handshakeToken");
        return new WidgetRemoteAuthViewModel$ViewState$Loaded(handshakeToken, isTemporary, loginAllowed);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetRemoteAuthViewModel$ViewState$Loaded)) {
            return false;
        }
        WidgetRemoteAuthViewModel$ViewState$Loaded widgetRemoteAuthViewModel$ViewState$Loaded = (WidgetRemoteAuthViewModel$ViewState$Loaded) other;
        return m.areEqual(this.handshakeToken, widgetRemoteAuthViewModel$ViewState$Loaded.handshakeToken) && this.isTemporary == widgetRemoteAuthViewModel$ViewState$Loaded.isTemporary && this.loginAllowed == widgetRemoteAuthViewModel$ViewState$Loaded.loginAllowed;
    }

    public final String getHandshakeToken() {
        return this.handshakeToken;
    }

    public final boolean getLoginAllowed() {
        return this.loginAllowed;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v2 */
    public int hashCode() {
        String str = this.handshakeToken;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        boolean z2 = this.isTemporary;
        ?? r1 = z2;
        if (z2) {
            r1 = 1;
        }
        int i = (iHashCode + r1) * 31;
        boolean z3 = this.loginAllowed;
        return i + (z3 ? 1 : z3);
    }

    public final boolean isTemporary() {
        return this.isTemporary;
    }

    public String toString() {
        StringBuilder sbU = a.U("Loaded(handshakeToken=");
        sbU.append(this.handshakeToken);
        sbU.append(", isTemporary=");
        sbU.append(this.isTemporary);
        sbU.append(", loginAllowed=");
        return a.O(sbU, this.loginAllowed, ")");
    }
}
