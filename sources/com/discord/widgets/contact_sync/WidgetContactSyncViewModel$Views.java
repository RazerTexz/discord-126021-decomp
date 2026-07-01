package com.discord.widgets.contact_sync;


/* JADX INFO: compiled from: WidgetContactSyncViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public enum WidgetContactSyncViewModel$Views {
    VIEW_LANDING("Landing"),
    VIEW_ADD_PHONE("Add Phone Number"),
    VIEW_VERIFY_PHONE("Verify Phone Number"),
    VIEW_NAME_INPUT("Name Input"),
    VIEW_SUGGESTIONS("Suggestions Results"),
    VIEW_SUGGESTIONS_EMPTY("Suggestions Results");

    private final String trackingStep;

    WidgetContactSyncViewModel$Views(String str) {
        this.trackingStep = str;
    }

    public final String getTrackingStep() {
        return this.trackingStep;
    }
}
