package com.discord.views;

import android.view.View;
import android.view.View$OnClickListener;

/* JADX INFO: compiled from: java-style lambda group */
/* JADX INFO: loaded from: classes.dex */
public final class CheckedSetting$a implements View$OnClickListener {
    public final /* synthetic */ int j;
    public final /* synthetic */ Object k;

    public CheckedSetting$a(int i, Object obj) {
        this.j = i;
        this.k = obj;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        int i = this.j;
        if (i == 0) {
            CheckedSetting.a((CheckedSetting) this.k).c().setChecked(true);
        } else {
            if (i != 1) {
                throw null;
            }
            CheckedSetting.a((CheckedSetting) this.k).c().setChecked(true ^ CheckedSetting.a((CheckedSetting) this.k).c().isChecked());
        }
    }
}
