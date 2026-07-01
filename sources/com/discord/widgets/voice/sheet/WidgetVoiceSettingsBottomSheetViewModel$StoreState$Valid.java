package com.discord.widgets.voice.sheet;

import b.d.b.a.a;
import com.discord.widgets.stage.StageRoles;
import com.discord.widgets.voice.model.CallModel;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetVoiceSettingsBottomSheetViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class WidgetVoiceSettingsBottomSheetViewModel$StoreState$Valid extends WidgetVoiceSettingsBottomSheetViewModel$StoreState {
    private final CallModel callModel;
    private final StageRoles myStageRoles;

    public /* synthetic */ WidgetVoiceSettingsBottomSheetViewModel$StoreState$Valid(CallModel callModel, StageRoles stageRoles, DefaultConstructorMarker defaultConstructorMarker) {
        this(callModel, stageRoles);
    }

    /* JADX INFO: renamed from: copy-FZvHQiQ$default, reason: not valid java name */
    public static /* synthetic */ WidgetVoiceSettingsBottomSheetViewModel$StoreState$Valid m73copyFZvHQiQ$default(WidgetVoiceSettingsBottomSheetViewModel$StoreState$Valid widgetVoiceSettingsBottomSheetViewModel$StoreState$Valid, CallModel callModel, StageRoles stageRoles, int i, Object obj) {
        if ((i & 1) != 0) {
            callModel = widgetVoiceSettingsBottomSheetViewModel$StoreState$Valid.callModel;
        }
        if ((i & 2) != 0) {
            stageRoles = widgetVoiceSettingsBottomSheetViewModel$StoreState$Valid.myStageRoles;
        }
        return widgetVoiceSettingsBottomSheetViewModel$StoreState$Valid.m75copyFZvHQiQ(callModel, stageRoles);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final CallModel getCallModel() {
        return this.callModel;
    }

    /* JADX INFO: renamed from: component2-twRsX-0, reason: not valid java name and from getter */
    public final StageRoles getMyStageRoles() {
        return this.myStageRoles;
    }

    /* JADX INFO: renamed from: copy-FZvHQiQ, reason: not valid java name */
    public final WidgetVoiceSettingsBottomSheetViewModel$StoreState$Valid m75copyFZvHQiQ(CallModel callModel, StageRoles myStageRoles) {
        m.checkNotNullParameter(callModel, "callModel");
        return new WidgetVoiceSettingsBottomSheetViewModel$StoreState$Valid(callModel, myStageRoles);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetVoiceSettingsBottomSheetViewModel$StoreState$Valid)) {
            return false;
        }
        WidgetVoiceSettingsBottomSheetViewModel$StoreState$Valid widgetVoiceSettingsBottomSheetViewModel$StoreState$Valid = (WidgetVoiceSettingsBottomSheetViewModel$StoreState$Valid) other;
        return m.areEqual(this.callModel, widgetVoiceSettingsBottomSheetViewModel$StoreState$Valid.callModel) && m.areEqual(this.myStageRoles, widgetVoiceSettingsBottomSheetViewModel$StoreState$Valid.myStageRoles);
    }

    public final CallModel getCallModel() {
        return this.callModel;
    }

    /* JADX INFO: renamed from: getMyStageRoles-twRsX-0, reason: not valid java name */
    public final StageRoles m76getMyStageRolestwRsX0() {
        return this.myStageRoles;
    }

    public int hashCode() {
        CallModel callModel = this.callModel;
        int iHashCode = (callModel != null ? callModel.hashCode() : 0) * 31;
        StageRoles stageRoles = this.myStageRoles;
        return iHashCode + (stageRoles != null ? stageRoles.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("Valid(callModel=");
        sbU.append(this.callModel);
        sbU.append(", myStageRoles=");
        sbU.append(this.myStageRoles);
        sbU.append(")");
        return sbU.toString();
    }

    private WidgetVoiceSettingsBottomSheetViewModel$StoreState$Valid(CallModel callModel, StageRoles stageRoles) {
        super(null);
        this.callModel = callModel;
        this.myStageRoles = stageRoles;
    }
}
