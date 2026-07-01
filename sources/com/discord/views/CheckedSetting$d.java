package com.discord.views;

import android.content.res.Resources;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import d0.z.d.m;
import kotlin.NoWhenBranchMatchedException;

/* JADX INFO: compiled from: CheckedSetting.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class CheckedSetting$d extends AccessibilityDelegateCompat {
    public final /* synthetic */ CheckedSetting a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ CheckedSetting$ViewType f2825b;

    public CheckedSetting$d(CheckedSetting checkedSetting, CheckedSetting$ViewType checkedSetting$ViewType) {
        this.a = checkedSetting;
        this.f2825b = checkedSetting$ViewType;
    }

    @Override // androidx.core.view.AccessibilityDelegateCompat
    public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        m.checkNotNullParameter(view, "host");
        m.checkNotNullParameter(accessibilityEvent, "event");
        super.onInitializeAccessibilityEvent(view, accessibilityEvent);
        accessibilityEvent.setChecked(this.a.isChecked());
    }

    @Override // androidx.core.view.AccessibilityDelegateCompat
    public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        int i;
        m.checkNotNullParameter(view, "host");
        m.checkNotNullParameter(accessibilityNodeInfoCompat, "info");
        super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
        accessibilityNodeInfoCompat.setCheckable(true);
        accessibilityNodeInfoCompat.setChecked(this.a.isChecked());
        Resources resources = view.getResources();
        int iOrdinal = this.f2825b.ordinal();
        if (iOrdinal == 0) {
            i = 2131886096;
        } else if (iOrdinal == 1) {
            i = 2131886097;
        } else {
            if (iOrdinal != 2) {
                throw new NoWhenBranchMatchedException();
            }
            i = 2131886098;
        }
        accessibilityNodeInfoCompat.setRoleDescription(resources.getString(i));
    }
}
