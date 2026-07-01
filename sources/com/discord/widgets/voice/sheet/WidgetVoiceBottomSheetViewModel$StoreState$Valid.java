package com.discord.widgets.voice.sheet;

import b.d.b.a.a;
import com.discord.widgets.voice.model.CallModel;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetVoiceBottomSheetViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class WidgetVoiceBottomSheetViewModel$StoreState$Valid extends WidgetVoiceBottomSheetViewModel$StoreState {
    private final CallModel callModel;
    private final Long myPermissions;
    private final Boolean noiseCancellation;
    private final boolean textInVoiceEnabled;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetVoiceBottomSheetViewModel$StoreState$Valid(CallModel callModel, Boolean bool, Long l, boolean z2) {
        super(null);
        m.checkNotNullParameter(callModel, "callModel");
        this.callModel = callModel;
        this.noiseCancellation = bool;
        this.myPermissions = l;
        this.textInVoiceEnabled = z2;
    }

    public static /* synthetic */ WidgetVoiceBottomSheetViewModel$StoreState$Valid copy$default(WidgetVoiceBottomSheetViewModel$StoreState$Valid widgetVoiceBottomSheetViewModel$StoreState$Valid, CallModel callModel, Boolean bool, Long l, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            callModel = widgetVoiceBottomSheetViewModel$StoreState$Valid.callModel;
        }
        if ((i & 2) != 0) {
            bool = widgetVoiceBottomSheetViewModel$StoreState$Valid.noiseCancellation;
        }
        if ((i & 4) != 0) {
            l = widgetVoiceBottomSheetViewModel$StoreState$Valid.myPermissions;
        }
        if ((i & 8) != 0) {
            z2 = widgetVoiceBottomSheetViewModel$StoreState$Valid.textInVoiceEnabled;
        }
        return widgetVoiceBottomSheetViewModel$StoreState$Valid.copy(callModel, bool, l, z2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final CallModel getCallModel() {
        return this.callModel;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Boolean getNoiseCancellation() {
        return this.noiseCancellation;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Long getMyPermissions() {
        return this.myPermissions;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final boolean getTextInVoiceEnabled() {
        return this.textInVoiceEnabled;
    }

    public final WidgetVoiceBottomSheetViewModel$StoreState$Valid copy(CallModel callModel, Boolean noiseCancellation, Long myPermissions, boolean textInVoiceEnabled) {
        m.checkNotNullParameter(callModel, "callModel");
        return new WidgetVoiceBottomSheetViewModel$StoreState$Valid(callModel, noiseCancellation, myPermissions, textInVoiceEnabled);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetVoiceBottomSheetViewModel$StoreState$Valid)) {
            return false;
        }
        WidgetVoiceBottomSheetViewModel$StoreState$Valid widgetVoiceBottomSheetViewModel$StoreState$Valid = (WidgetVoiceBottomSheetViewModel$StoreState$Valid) other;
        return m.areEqual(this.callModel, widgetVoiceBottomSheetViewModel$StoreState$Valid.callModel) && m.areEqual(this.noiseCancellation, widgetVoiceBottomSheetViewModel$StoreState$Valid.noiseCancellation) && m.areEqual(this.myPermissions, widgetVoiceBottomSheetViewModel$StoreState$Valid.myPermissions) && this.textInVoiceEnabled == widgetVoiceBottomSheetViewModel$StoreState$Valid.textInVoiceEnabled;
    }

    public final CallModel getCallModel() {
        return this.callModel;
    }

    public final Long getMyPermissions() {
        return this.myPermissions;
    }

    public final Boolean getNoiseCancellation() {
        return this.noiseCancellation;
    }

    public final boolean getTextInVoiceEnabled() {
        return this.textInVoiceEnabled;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v8, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v6 */
    public int hashCode() {
        CallModel callModel = this.callModel;
        int iHashCode = (callModel != null ? callModel.hashCode() : 0) * 31;
        Boolean bool = this.noiseCancellation;
        int iHashCode2 = (iHashCode + (bool != null ? bool.hashCode() : 0)) * 31;
        Long l = this.myPermissions;
        int iHashCode3 = (iHashCode2 + (l != null ? l.hashCode() : 0)) * 31;
        boolean z2 = this.textInVoiceEnabled;
        ?? r1 = z2;
        if (z2) {
            r1 = 1;
        }
        return iHashCode3 + r1;
    }

    public String toString() {
        StringBuilder sbU = a.U("Valid(callModel=");
        sbU.append(this.callModel);
        sbU.append(", noiseCancellation=");
        sbU.append(this.noiseCancellation);
        sbU.append(", myPermissions=");
        sbU.append(this.myPermissions);
        sbU.append(", textInVoiceEnabled=");
        return a.O(sbU, this.textInVoiceEnabled, ")");
    }
}
