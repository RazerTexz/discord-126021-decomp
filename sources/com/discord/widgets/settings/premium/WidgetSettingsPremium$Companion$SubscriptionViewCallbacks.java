package com.discord.widgets.settings.premium;

import b.d.b.a.a;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: WidgetSettingsPremium.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class WidgetSettingsPremium$Companion$SubscriptionViewCallbacks {
    private final Function0<Unit> cancelCallback;
    private final Function0<Unit> manageBillingCallback;
    private final Function0<Unit> manageGuildBoostCallback;
    private final Function0<Unit> managePlanCallback;
    private final Function0<Unit> restoreCallback;

    public WidgetSettingsPremium$Companion$SubscriptionViewCallbacks(Function0<Unit> function0, Function0<Unit> function1, Function0<Unit> function2, Function0<Unit> function3, Function0<Unit> function4) {
        this.restoreCallback = function0;
        this.managePlanCallback = function1;
        this.cancelCallback = function2;
        this.manageGuildBoostCallback = function3;
        this.manageBillingCallback = function4;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ WidgetSettingsPremium$Companion$SubscriptionViewCallbacks copy$default(WidgetSettingsPremium$Companion$SubscriptionViewCallbacks widgetSettingsPremium$Companion$SubscriptionViewCallbacks, Function0 function0, Function0 function1, Function0 function2, Function0 function3, Function0 function4, int i, Object obj) {
        if ((i & 1) != 0) {
            function0 = widgetSettingsPremium$Companion$SubscriptionViewCallbacks.restoreCallback;
        }
        if ((i & 2) != 0) {
            function1 = widgetSettingsPremium$Companion$SubscriptionViewCallbacks.managePlanCallback;
        }
        Function0 function5 = function1;
        if ((i & 4) != 0) {
            function2 = widgetSettingsPremium$Companion$SubscriptionViewCallbacks.cancelCallback;
        }
        Function0 function6 = function2;
        if ((i & 8) != 0) {
            function3 = widgetSettingsPremium$Companion$SubscriptionViewCallbacks.manageGuildBoostCallback;
        }
        Function0 function7 = function3;
        if ((i & 16) != 0) {
            function4 = widgetSettingsPremium$Companion$SubscriptionViewCallbacks.manageBillingCallback;
        }
        return widgetSettingsPremium$Companion$SubscriptionViewCallbacks.copy(function0, function5, function6, function7, function4);
    }

    public final Function0<Unit> component1() {
        return this.restoreCallback;
    }

    public final Function0<Unit> component2() {
        return this.managePlanCallback;
    }

    public final Function0<Unit> component3() {
        return this.cancelCallback;
    }

    public final Function0<Unit> component4() {
        return this.manageGuildBoostCallback;
    }

    public final Function0<Unit> component5() {
        return this.manageBillingCallback;
    }

    public final WidgetSettingsPremium$Companion$SubscriptionViewCallbacks copy(Function0<Unit> restoreCallback, Function0<Unit> managePlanCallback, Function0<Unit> cancelCallback, Function0<Unit> manageGuildBoostCallback, Function0<Unit> manageBillingCallback) {
        return new WidgetSettingsPremium$Companion$SubscriptionViewCallbacks(restoreCallback, managePlanCallback, cancelCallback, manageGuildBoostCallback, manageBillingCallback);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetSettingsPremium$Companion$SubscriptionViewCallbacks)) {
            return false;
        }
        WidgetSettingsPremium$Companion$SubscriptionViewCallbacks widgetSettingsPremium$Companion$SubscriptionViewCallbacks = (WidgetSettingsPremium$Companion$SubscriptionViewCallbacks) other;
        return m.areEqual(this.restoreCallback, widgetSettingsPremium$Companion$SubscriptionViewCallbacks.restoreCallback) && m.areEqual(this.managePlanCallback, widgetSettingsPremium$Companion$SubscriptionViewCallbacks.managePlanCallback) && m.areEqual(this.cancelCallback, widgetSettingsPremium$Companion$SubscriptionViewCallbacks.cancelCallback) && m.areEqual(this.manageGuildBoostCallback, widgetSettingsPremium$Companion$SubscriptionViewCallbacks.manageGuildBoostCallback) && m.areEqual(this.manageBillingCallback, widgetSettingsPremium$Companion$SubscriptionViewCallbacks.manageBillingCallback);
    }

    public final Function0<Unit> getCancelCallback() {
        return this.cancelCallback;
    }

    public final Function0<Unit> getManageBillingCallback() {
        return this.manageBillingCallback;
    }

    public final Function0<Unit> getManageGuildBoostCallback() {
        return this.manageGuildBoostCallback;
    }

    public final Function0<Unit> getManagePlanCallback() {
        return this.managePlanCallback;
    }

    public final Function0<Unit> getRestoreCallback() {
        return this.restoreCallback;
    }

    public int hashCode() {
        Function0<Unit> function0 = this.restoreCallback;
        int iHashCode = (function0 != null ? function0.hashCode() : 0) * 31;
        Function0<Unit> function1 = this.managePlanCallback;
        int iHashCode2 = (iHashCode + (function1 != null ? function1.hashCode() : 0)) * 31;
        Function0<Unit> function2 = this.cancelCallback;
        int iHashCode3 = (iHashCode2 + (function2 != null ? function2.hashCode() : 0)) * 31;
        Function0<Unit> function3 = this.manageGuildBoostCallback;
        int iHashCode4 = (iHashCode3 + (function3 != null ? function3.hashCode() : 0)) * 31;
        Function0<Unit> function4 = this.manageBillingCallback;
        return iHashCode4 + (function4 != null ? function4.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("SubscriptionViewCallbacks(restoreCallback=");
        sbU.append(this.restoreCallback);
        sbU.append(", managePlanCallback=");
        sbU.append(this.managePlanCallback);
        sbU.append(", cancelCallback=");
        sbU.append(this.cancelCallback);
        sbU.append(", manageGuildBoostCallback=");
        sbU.append(this.manageGuildBoostCallback);
        sbU.append(", manageBillingCallback=");
        sbU.append(this.manageBillingCallback);
        sbU.append(")");
        return sbU.toString();
    }
}
