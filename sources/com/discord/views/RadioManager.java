package com.discord.views;

import android.widget.Checkable;
import java.util.Iterator;
import java.util.List;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: RadioManager.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class RadioManager {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    public final List<Checkable> buttons;

    /* JADX WARN: Multi-variable type inference failed */
    public RadioManager(List<? extends Checkable> list) {
        C12238m.checkNotNullParameter(list, "buttons");
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

    /* JADX INFO: renamed from: a */
    public final void m8550a(Checkable targetButton) {
        C12238m.checkNotNullParameter(targetButton, "targetButton");
        for (Checkable checkable : this.buttons) {
            checkable.setChecked(C12238m.areEqual(checkable, targetButton));
        }
    }

    /* JADX INFO: renamed from: b */
    public final int m8551b() {
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
