package com.discord.widgets.hubs;

import androidx.core.app.NotificationCompat;
import b.d.b.a.outline;
import com.discord.api.hubs.EmailVerification;
import com.discord.stores.utilities.RestCallState;
import com.discord.stores.utilities.RestCallState2;
import d0.LazyJVM;
import d0.z.d.Intrinsics3;
import kotlin.Lazy;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: renamed from: com.discord.widgets.hubs.HubEmailState, reason: use source file name */
/* JADX INFO: compiled from: WidgetHubEmailViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class WidgetHubEmailViewModel4 {
    private final String email;

    /* JADX INFO: renamed from: hasMultipleDomains$delegate, reason: from kotlin metadata */
    private final Lazy hasMultipleDomains;
    private final Long selectedGuildId;
    private final RestCallState<EmailVerification> verifyEmailAsync;
    private final WidgetHubWaitlist2 waitlistResult;

    public WidgetHubEmailViewModel4() {
        this(null, null, null, null, 15, null);
    }

    public WidgetHubEmailViewModel4(String str, Long l, WidgetHubWaitlist2 widgetHubWaitlist2, RestCallState<EmailVerification> restCallState) {
        Intrinsics3.checkNotNullParameter(restCallState, "verifyEmailAsync");
        this.email = str;
        this.selectedGuildId = l;
        this.waitlistResult = widgetHubWaitlist2;
        this.verifyEmailAsync = restCallState;
        this.hasMultipleDomains = LazyJVM.lazy(new WidgetHubEmailViewModel5(this));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ WidgetHubEmailViewModel4 copy$default(WidgetHubEmailViewModel4 widgetHubEmailViewModel4, String str, Long l, WidgetHubWaitlist2 widgetHubWaitlist2, RestCallState restCallState, int i, Object obj) {
        if ((i & 1) != 0) {
            str = widgetHubEmailViewModel4.email;
        }
        if ((i & 2) != 0) {
            l = widgetHubEmailViewModel4.selectedGuildId;
        }
        if ((i & 4) != 0) {
            widgetHubWaitlist2 = widgetHubEmailViewModel4.waitlistResult;
        }
        if ((i & 8) != 0) {
            restCallState = widgetHubEmailViewModel4.verifyEmailAsync;
        }
        return widgetHubEmailViewModel4.copy(str, l, widgetHubWaitlist2, restCallState);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getEmail() {
        return this.email;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Long getSelectedGuildId() {
        return this.selectedGuildId;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final WidgetHubWaitlist2 getWaitlistResult() {
        return this.waitlistResult;
    }

    public final RestCallState<EmailVerification> component4() {
        return this.verifyEmailAsync;
    }

    public final WidgetHubEmailViewModel4 copy(String email, Long selectedGuildId, WidgetHubWaitlist2 waitlistResult, RestCallState<EmailVerification> verifyEmailAsync) {
        Intrinsics3.checkNotNullParameter(verifyEmailAsync, "verifyEmailAsync");
        return new WidgetHubEmailViewModel4(email, selectedGuildId, waitlistResult, verifyEmailAsync);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetHubEmailViewModel4)) {
            return false;
        }
        WidgetHubEmailViewModel4 widgetHubEmailViewModel4 = (WidgetHubEmailViewModel4) other;
        return Intrinsics3.areEqual(this.email, widgetHubEmailViewModel4.email) && Intrinsics3.areEqual(this.selectedGuildId, widgetHubEmailViewModel4.selectedGuildId) && Intrinsics3.areEqual(this.waitlistResult, widgetHubEmailViewModel4.waitlistResult) && Intrinsics3.areEqual(this.verifyEmailAsync, widgetHubEmailViewModel4.verifyEmailAsync);
    }

    public final String getEmail() {
        return this.email;
    }

    public final boolean getHasMultipleDomains() {
        return ((Boolean) this.hasMultipleDomains.getValue()).booleanValue();
    }

    public final Long getSelectedGuildId() {
        return this.selectedGuildId;
    }

    public final RestCallState<EmailVerification> getVerifyEmailAsync() {
        return this.verifyEmailAsync;
    }

    public final WidgetHubWaitlist2 getWaitlistResult() {
        return this.waitlistResult;
    }

    public int hashCode() {
        String str = this.email;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        Long l = this.selectedGuildId;
        int iHashCode2 = (iHashCode + (l != null ? l.hashCode() : 0)) * 31;
        WidgetHubWaitlist2 widgetHubWaitlist2 = this.waitlistResult;
        int iHashCode3 = (iHashCode2 + (widgetHubWaitlist2 != null ? widgetHubWaitlist2.hashCode() : 0)) * 31;
        RestCallState<EmailVerification> restCallState = this.verifyEmailAsync;
        return iHashCode3 + (restCallState != null ? restCallState.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("HubEmailState(email=");
        sbU.append(this.email);
        sbU.append(", selectedGuildId=");
        sbU.append(this.selectedGuildId);
        sbU.append(", waitlistResult=");
        sbU.append(this.waitlistResult);
        sbU.append(", verifyEmailAsync=");
        sbU.append(this.verifyEmailAsync);
        sbU.append(")");
        return sbU.toString();
    }

    public /* synthetic */ WidgetHubEmailViewModel4(String str, Long l, WidgetHubWaitlist2 widgetHubWaitlist2, RestCallState restCallState, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : l, (i & 4) != 0 ? null : widgetHubWaitlist2, (i & 8) != 0 ? RestCallState2.INSTANCE : restCallState);
    }
}
