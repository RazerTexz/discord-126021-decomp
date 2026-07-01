package com.discord.stores;

import b.d.b.a.a;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: StoreThreadDraft.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class StoreThreadDraft$ThreadDraftState {
    private final Integer autoArchiveDuration;
    private final boolean isPrivate;
    private final boolean isSending;
    private final boolean shouldDisplayNameError;
    private final String threadName;

    public StoreThreadDraft$ThreadDraftState() {
        this(false, null, null, false, false, 31, null);
    }

    public StoreThreadDraft$ThreadDraftState(boolean z2, Integer num, String str, boolean z3, boolean z4) {
        this.isPrivate = z2;
        this.autoArchiveDuration = num;
        this.threadName = str;
        this.isSending = z3;
        this.shouldDisplayNameError = z4;
    }

    public static /* synthetic */ StoreThreadDraft$ThreadDraftState copy$default(StoreThreadDraft$ThreadDraftState storeThreadDraft$ThreadDraftState, boolean z2, Integer num, String str, boolean z3, boolean z4, int i, Object obj) {
        if ((i & 1) != 0) {
            z2 = storeThreadDraft$ThreadDraftState.isPrivate;
        }
        if ((i & 2) != 0) {
            num = storeThreadDraft$ThreadDraftState.autoArchiveDuration;
        }
        Integer num2 = num;
        if ((i & 4) != 0) {
            str = storeThreadDraft$ThreadDraftState.threadName;
        }
        String str2 = str;
        if ((i & 8) != 0) {
            z3 = storeThreadDraft$ThreadDraftState.isSending;
        }
        boolean z5 = z3;
        if ((i & 16) != 0) {
            z4 = storeThreadDraft$ThreadDraftState.shouldDisplayNameError;
        }
        return storeThreadDraft$ThreadDraftState.copy(z2, num2, str2, z5, z4);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getIsPrivate() {
        return this.isPrivate;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Integer getAutoArchiveDuration() {
        return this.autoArchiveDuration;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getThreadName() {
        return this.threadName;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final boolean getIsSending() {
        return this.isSending;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final boolean getShouldDisplayNameError() {
        return this.shouldDisplayNameError;
    }

    public final StoreThreadDraft$ThreadDraftState copy(boolean isPrivate, Integer autoArchiveDuration, String threadName, boolean isSending, boolean shouldDisplayNameError) {
        return new StoreThreadDraft$ThreadDraftState(isPrivate, autoArchiveDuration, threadName, isSending, shouldDisplayNameError);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof StoreThreadDraft$ThreadDraftState)) {
            return false;
        }
        StoreThreadDraft$ThreadDraftState storeThreadDraft$ThreadDraftState = (StoreThreadDraft$ThreadDraftState) other;
        return this.isPrivate == storeThreadDraft$ThreadDraftState.isPrivate && m.areEqual(this.autoArchiveDuration, storeThreadDraft$ThreadDraftState.autoArchiveDuration) && m.areEqual(this.threadName, storeThreadDraft$ThreadDraftState.threadName) && this.isSending == storeThreadDraft$ThreadDraftState.isSending && this.shouldDisplayNameError == storeThreadDraft$ThreadDraftState.shouldDisplayNameError;
    }

    public final Integer getAutoArchiveDuration() {
        return this.autoArchiveDuration;
    }

    public final boolean getShouldDisplayNameError() {
        return this.shouldDisplayNameError;
    }

    public final String getThreadName() {
        return this.threadName;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v7, types: [int] */
    /* JADX WARN: Type inference failed for: r0v9, types: [int] */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r2v5, types: [int] */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r2v9 */
    public int hashCode() {
        boolean z2 = this.isPrivate;
        ?? r0 = z2;
        if (z2) {
            r0 = 1;
        }
        int i = r0 * 31;
        Integer num = this.autoArchiveDuration;
        int iHashCode = (i + (num != null ? num.hashCode() : 0)) * 31;
        String str = this.threadName;
        int iHashCode2 = (iHashCode + (str != null ? str.hashCode() : 0)) * 31;
        boolean z3 = this.isSending;
        ?? r2 = z3;
        if (z3) {
            r2 = 1;
        }
        int i2 = (iHashCode2 + r2) * 31;
        boolean z4 = this.shouldDisplayNameError;
        return i2 + (z4 ? 1 : z4);
    }

    public final boolean isPrivate() {
        return this.isPrivate;
    }

    public final boolean isSending() {
        return this.isSending;
    }

    public String toString() {
        StringBuilder sbU = a.U("ThreadDraftState(isPrivate=");
        sbU.append(this.isPrivate);
        sbU.append(", autoArchiveDuration=");
        sbU.append(this.autoArchiveDuration);
        sbU.append(", threadName=");
        sbU.append(this.threadName);
        sbU.append(", isSending=");
        sbU.append(this.isSending);
        sbU.append(", shouldDisplayNameError=");
        return a.O(sbU, this.shouldDisplayNameError, ")");
    }

    public /* synthetic */ StoreThreadDraft$ThreadDraftState(boolean z2, Integer num, String str, boolean z3, boolean z4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z2, (i & 2) != 0 ? null : num, (i & 4) == 0 ? str : null, (i & 8) != 0 ? false : z3, (i & 16) != 0 ? false : z4);
    }
}
