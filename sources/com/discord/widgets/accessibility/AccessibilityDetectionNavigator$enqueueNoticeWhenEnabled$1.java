package com.discord.widgets.accessibility;

import com.discord.utilities.accessibility.AccessibilityState;
import d0.z.d.k;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: AccessibilityDetectionNavigator.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class AccessibilityDetectionNavigator$enqueueNoticeWhenEnabled$1 extends k implements Function1<AccessibilityState, Unit> {
    public AccessibilityDetectionNavigator$enqueueNoticeWhenEnabled$1(AccessibilityDetectionNavigator accessibilityDetectionNavigator) {
        super(1, accessibilityDetectionNavigator, AccessibilityDetectionNavigator.class, "showAccessibilityDetectionDialog", "showAccessibilityDetectionDialog(Lcom/discord/utilities/accessibility/AccessibilityState;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(AccessibilityState accessibilityState) {
        invoke2(accessibilityState);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(AccessibilityState accessibilityState) {
        m.checkNotNullParameter(accessibilityState, "p1");
        AccessibilityDetectionNavigator.access$showAccessibilityDetectionDialog((AccessibilityDetectionNavigator) this.receiver, accessibilityState);
    }
}
