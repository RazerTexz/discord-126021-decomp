package com.discord.widgets.auth;

import b.d.b.a.a;
import com.discord.api.channel.Channel;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetAgeVerifyViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class WidgetAgeVerifyViewModel$ViewState {
    private Long dateOfBirth;
    private final int displayedChild;
    private final Integer errorStringId;
    private final boolean isSubmitting;
    private final Channel safeChannel;
    private final boolean shouldClose;
    private String underageMessage;

    public WidgetAgeVerifyViewModel$ViewState(boolean z2, Integer num, int i, Long l, String str, Channel channel, boolean z3) {
        this.isSubmitting = z2;
        this.errorStringId = num;
        this.displayedChild = i;
        this.dateOfBirth = l;
        this.underageMessage = str;
        this.safeChannel = channel;
        this.shouldClose = z3;
    }

    public static /* synthetic */ WidgetAgeVerifyViewModel$ViewState copy$default(WidgetAgeVerifyViewModel$ViewState widgetAgeVerifyViewModel$ViewState, boolean z2, Integer num, int i, Long l, String str, Channel channel, boolean z3, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z2 = widgetAgeVerifyViewModel$ViewState.isSubmitting;
        }
        if ((i2 & 2) != 0) {
            num = widgetAgeVerifyViewModel$ViewState.errorStringId;
        }
        Integer num2 = num;
        if ((i2 & 4) != 0) {
            i = widgetAgeVerifyViewModel$ViewState.displayedChild;
        }
        int i3 = i;
        if ((i2 & 8) != 0) {
            l = widgetAgeVerifyViewModel$ViewState.dateOfBirth;
        }
        Long l2 = l;
        if ((i2 & 16) != 0) {
            str = widgetAgeVerifyViewModel$ViewState.underageMessage;
        }
        String str2 = str;
        if ((i2 & 32) != 0) {
            channel = widgetAgeVerifyViewModel$ViewState.safeChannel;
        }
        Channel channel2 = channel;
        if ((i2 & 64) != 0) {
            z3 = widgetAgeVerifyViewModel$ViewState.shouldClose;
        }
        return widgetAgeVerifyViewModel$ViewState.copy(z2, num2, i3, l2, str2, channel2, z3);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getIsSubmitting() {
        return this.isSubmitting;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Integer getErrorStringId() {
        return this.errorStringId;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getDisplayedChild() {
        return this.displayedChild;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final Long getDateOfBirth() {
        return this.dateOfBirth;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getUnderageMessage() {
        return this.underageMessage;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final Channel getSafeChannel() {
        return this.safeChannel;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final boolean getShouldClose() {
        return this.shouldClose;
    }

    public final WidgetAgeVerifyViewModel$ViewState copy(boolean isSubmitting, Integer errorStringId, int displayedChild, Long dateOfBirth, String underageMessage, Channel safeChannel, boolean shouldClose) {
        return new WidgetAgeVerifyViewModel$ViewState(isSubmitting, errorStringId, displayedChild, dateOfBirth, underageMessage, safeChannel, shouldClose);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetAgeVerifyViewModel$ViewState)) {
            return false;
        }
        WidgetAgeVerifyViewModel$ViewState widgetAgeVerifyViewModel$ViewState = (WidgetAgeVerifyViewModel$ViewState) other;
        return this.isSubmitting == widgetAgeVerifyViewModel$ViewState.isSubmitting && m.areEqual(this.errorStringId, widgetAgeVerifyViewModel$ViewState.errorStringId) && this.displayedChild == widgetAgeVerifyViewModel$ViewState.displayedChild && m.areEqual(this.dateOfBirth, widgetAgeVerifyViewModel$ViewState.dateOfBirth) && m.areEqual(this.underageMessage, widgetAgeVerifyViewModel$ViewState.underageMessage) && m.areEqual(this.safeChannel, widgetAgeVerifyViewModel$ViewState.safeChannel) && this.shouldClose == widgetAgeVerifyViewModel$ViewState.shouldClose;
    }

    public final Long getDateOfBirth() {
        return this.dateOfBirth;
    }

    public final int getDisplayedChild() {
        return this.displayedChild;
    }

    public final Integer getErrorStringId() {
        return this.errorStringId;
    }

    public final Channel getSafeChannel() {
        return this.safeChannel;
    }

    public final boolean getShouldClose() {
        return this.shouldClose;
    }

    public final String getUnderageMessage() {
        return this.underageMessage;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v13, types: [int] */
    /* JADX WARN: Type inference failed for: r0v14 */
    /* JADX WARN: Type inference failed for: r0v15 */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2 */
    public int hashCode() {
        boolean z2 = this.isSubmitting;
        ?? r0 = z2;
        if (z2) {
            r0 = 1;
        }
        int i = r0 * 31;
        Integer num = this.errorStringId;
        int iHashCode = (((i + (num != null ? num.hashCode() : 0)) * 31) + this.displayedChild) * 31;
        Long l = this.dateOfBirth;
        int iHashCode2 = (iHashCode + (l != null ? l.hashCode() : 0)) * 31;
        String str = this.underageMessage;
        int iHashCode3 = (iHashCode2 + (str != null ? str.hashCode() : 0)) * 31;
        Channel channel = this.safeChannel;
        int iHashCode4 = (iHashCode3 + (channel != null ? channel.hashCode() : 0)) * 31;
        boolean z3 = this.shouldClose;
        return iHashCode4 + (z3 ? 1 : z3);
    }

    public final boolean isSubmitting() {
        return this.isSubmitting;
    }

    public final void setDateOfBirth(Long l) {
        this.dateOfBirth = l;
    }

    public final void setUnderageMessage(String str) {
        this.underageMessage = str;
    }

    public String toString() {
        StringBuilder sbU = a.U("ViewState(isSubmitting=");
        sbU.append(this.isSubmitting);
        sbU.append(", errorStringId=");
        sbU.append(this.errorStringId);
        sbU.append(", displayedChild=");
        sbU.append(this.displayedChild);
        sbU.append(", dateOfBirth=");
        sbU.append(this.dateOfBirth);
        sbU.append(", underageMessage=");
        sbU.append(this.underageMessage);
        sbU.append(", safeChannel=");
        sbU.append(this.safeChannel);
        sbU.append(", shouldClose=");
        return a.O(sbU, this.shouldClose, ")");
    }
}
