package com.discord.widgets.user;

import b.d.b.a.a;
import com.discord.api.activity.Activity;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetUserStatusSheetViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class WidgetUserStatusSheetViewModel$StoreState {
    private final Activity customStatusActivity;

    public WidgetUserStatusSheetViewModel$StoreState(Activity activity) {
        this.customStatusActivity = activity;
    }

    public static /* synthetic */ WidgetUserStatusSheetViewModel$StoreState copy$default(WidgetUserStatusSheetViewModel$StoreState widgetUserStatusSheetViewModel$StoreState, Activity activity, int i, Object obj) {
        if ((i & 1) != 0) {
            activity = widgetUserStatusSheetViewModel$StoreState.customStatusActivity;
        }
        return widgetUserStatusSheetViewModel$StoreState.copy(activity);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Activity getCustomStatusActivity() {
        return this.customStatusActivity;
    }

    public final WidgetUserStatusSheetViewModel$StoreState copy(Activity customStatusActivity) {
        return new WidgetUserStatusSheetViewModel$StoreState(customStatusActivity);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof WidgetUserStatusSheetViewModel$StoreState) && m.areEqual(this.customStatusActivity, ((WidgetUserStatusSheetViewModel$StoreState) other).customStatusActivity);
        }
        return true;
    }

    public final Activity getCustomStatusActivity() {
        return this.customStatusActivity;
    }

    public int hashCode() {
        Activity activity = this.customStatusActivity;
        if (activity != null) {
            return activity.hashCode();
        }
        return 0;
    }

    public String toString() {
        StringBuilder sbU = a.U("StoreState(customStatusActivity=");
        sbU.append(this.customStatusActivity);
        sbU.append(")");
        return sbU.toString();
    }
}
