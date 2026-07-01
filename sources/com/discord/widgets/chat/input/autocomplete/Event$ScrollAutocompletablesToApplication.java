package com.discord.widgets.chat.input.autocomplete;

import a0.a.a.b;
import b.d.b.a.a;

/* JADX INFO: compiled from: AutocompleteViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class Event$ScrollAutocompletablesToApplication extends Event {
    private final long applicationId;
    private final int targetPosition;

    public Event$ScrollAutocompletablesToApplication(long j, int i) {
        super(null);
        this.applicationId = j;
        this.targetPosition = i;
    }

    public static /* synthetic */ Event$ScrollAutocompletablesToApplication copy$default(Event$ScrollAutocompletablesToApplication event$ScrollAutocompletablesToApplication, long j, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            j = event$ScrollAutocompletablesToApplication.applicationId;
        }
        if ((i2 & 2) != 0) {
            i = event$ScrollAutocompletablesToApplication.targetPosition;
        }
        return event$ScrollAutocompletablesToApplication.copy(j, i);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final long getApplicationId() {
        return this.applicationId;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getTargetPosition() {
        return this.targetPosition;
    }

    public final Event$ScrollAutocompletablesToApplication copy(long applicationId, int targetPosition) {
        return new Event$ScrollAutocompletablesToApplication(applicationId, targetPosition);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Event$ScrollAutocompletablesToApplication)) {
            return false;
        }
        Event$ScrollAutocompletablesToApplication event$ScrollAutocompletablesToApplication = (Event$ScrollAutocompletablesToApplication) other;
        return this.applicationId == event$ScrollAutocompletablesToApplication.applicationId && this.targetPosition == event$ScrollAutocompletablesToApplication.targetPosition;
    }

    public final long getApplicationId() {
        return this.applicationId;
    }

    public final int getTargetPosition() {
        return this.targetPosition;
    }

    public int hashCode() {
        return (b.a(this.applicationId) * 31) + this.targetPosition;
    }

    public String toString() {
        StringBuilder sbU = a.U("ScrollAutocompletablesToApplication(applicationId=");
        sbU.append(this.applicationId);
        sbU.append(", targetPosition=");
        return a.B(sbU, this.targetPosition, ")");
    }
}
