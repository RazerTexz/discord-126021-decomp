package com.discord.widgets.accessibility;

import androidx.appcompat.widget.ActivityChooserModel;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import b.a.a.h;
import b.a.a.h$b;
import d0.z.d.m;
import d0.z.d.o;
import java.util.Objects;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: AccessibilityDetectionNavigator.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class AccessibilityDetectionNavigator$showAccessibilityDetectionDialog$1 extends o implements Function1<FragmentActivity, Boolean> {
    public static final AccessibilityDetectionNavigator$showAccessibilityDetectionDialog$1 INSTANCE = new AccessibilityDetectionNavigator$showAccessibilityDetectionDialog$1();

    public AccessibilityDetectionNavigator$showAccessibilityDetectionDialog$1() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(FragmentActivity fragmentActivity) {
        return Boolean.valueOf(invoke2(fragmentActivity));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final boolean invoke2(FragmentActivity fragmentActivity) {
        m.checkNotNullParameter(fragmentActivity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
        h$b h_b = h.k;
        FragmentManager supportFragmentManager = fragmentActivity.getSupportFragmentManager();
        m.checkNotNullExpressionValue(supportFragmentManager, "activity.supportFragmentManager");
        Objects.requireNonNull(h_b);
        m.checkNotNullParameter(supportFragmentManager, "fragmentManager");
        new h().show(supportFragmentManager, "ALLOW_ACCESSIBILITY_DETECTION_DIALOG");
        return true;
    }
}
