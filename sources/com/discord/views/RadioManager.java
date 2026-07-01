package com.discord.views;

import android.widget.Checkable;
import d0.z.d.Intrinsics3;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: RadioManager.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class RadioManager {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    public final List<Checkable> buttons;

    /* JADX WARN: Multi-variable type inference failed */
    public RadioManager(List<? extends Checkable> list) {
        Intrinsics3.checkNotNullParameter(list, "buttons");
        this.buttons = list;
        boolean z2 = false;
        for (Checkable checkable : list) {
            if (!z2 && checkable.isChecked()) {
                z2 = true;
            }
            checkable.setChecked(false);
        }
        if (z2) {
            return;
        }
        this.buttons.get(0).setChecked(true);
    }

    public final void a(Checkable targetButton) {
        Intrinsics3.checkNotNullParameter(targetButton, "targetButton");
        for (Checkable checkable : this.buttons) {
            checkable.setChecked(Intrinsics3.areEqual(checkable, targetButton));
        }
    }

    public final int b() {
        Iterator<Checkable> it = this.buttons.iterator();
        int i = 0;
        while (it.hasNext()) {
            if (it.next().isChecked()) {
                return i;
            }
            i++;
        }
        return -1;
    }
}
