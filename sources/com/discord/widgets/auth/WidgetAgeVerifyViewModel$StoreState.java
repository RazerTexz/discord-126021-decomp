package com.discord.widgets.auth;

import b.d.b.a.a;
import com.discord.api.channel.Channel;
import com.discord.api.user.NsfwAllowance;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetAgeVerifyViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class WidgetAgeVerifyViewModel$StoreState {
    private final boolean authed;
    private final NsfwAllowance nsfwAllowed;
    private final Channel safeChannel;

    public WidgetAgeVerifyViewModel$StoreState(Channel channel, NsfwAllowance nsfwAllowance, boolean z2) {
        m.checkNotNullParameter(nsfwAllowance, "nsfwAllowed");
        this.safeChannel = channel;
        this.nsfwAllowed = nsfwAllowance;
        this.authed = z2;
    }

    public static /* synthetic */ WidgetAgeVerifyViewModel$StoreState copy$default(WidgetAgeVerifyViewModel$StoreState widgetAgeVerifyViewModel$StoreState, Channel channel, NsfwAllowance nsfwAllowance, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            channel = widgetAgeVerifyViewModel$StoreState.safeChannel;
        }
        if ((i & 2) != 0) {
            nsfwAllowance = widgetAgeVerifyViewModel$StoreState.nsfwAllowed;
        }
        if ((i & 4) != 0) {
            z2 = widgetAgeVerifyViewModel$StoreState.authed;
        }
        return widgetAgeVerifyViewModel$StoreState.copy(channel, nsfwAllowance, z2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Channel getSafeChannel() {
        return this.safeChannel;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final NsfwAllowance getNsfwAllowed() {
        return this.nsfwAllowed;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getAuthed() {
        return this.authed;
    }

    public final WidgetAgeVerifyViewModel$StoreState copy(Channel safeChannel, NsfwAllowance nsfwAllowed, boolean authed) {
        m.checkNotNullParameter(nsfwAllowed, "nsfwAllowed");
        return new WidgetAgeVerifyViewModel$StoreState(safeChannel, nsfwAllowed, authed);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetAgeVerifyViewModel$StoreState)) {
            return false;
        }
        WidgetAgeVerifyViewModel$StoreState widgetAgeVerifyViewModel$StoreState = (WidgetAgeVerifyViewModel$StoreState) other;
        return m.areEqual(this.safeChannel, widgetAgeVerifyViewModel$StoreState.safeChannel) && m.areEqual(this.nsfwAllowed, widgetAgeVerifyViewModel$StoreState.nsfwAllowed) && this.authed == widgetAgeVerifyViewModel$StoreState.authed;
    }

    public final boolean getAuthed() {
        return this.authed;
    }

    public final NsfwAllowance getNsfwAllowed() {
        return this.nsfwAllowed;
    }

    public final Channel getSafeChannel() {
        return this.safeChannel;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v6, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v6 */
    public int hashCode() {
        Channel channel = this.safeChannel;
        int iHashCode = (channel != null ? channel.hashCode() : 0) * 31;
        NsfwAllowance nsfwAllowance = this.nsfwAllowed;
        int iHashCode2 = (iHashCode + (nsfwAllowance != null ? nsfwAllowance.hashCode() : 0)) * 31;
        boolean z2 = this.authed;
        ?? r1 = z2;
        if (z2) {
            r1 = 1;
        }
        return iHashCode2 + r1;
    }

    public String toString() {
        StringBuilder sbU = a.U("StoreState(safeChannel=");
        sbU.append(this.safeChannel);
        sbU.append(", nsfwAllowed=");
        sbU.append(this.nsfwAllowed);
        sbU.append(", authed=");
        return a.O(sbU, this.authed, ")");
    }
}
