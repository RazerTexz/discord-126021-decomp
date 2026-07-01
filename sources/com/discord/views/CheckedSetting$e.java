package com.discord.views;

import android.widget.CompoundButton;
import android.widget.CompoundButton$OnCheckedChangeListener;
import rx.functions.Action1;

/* JADX INFO: compiled from: CheckedSetting.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class CheckedSetting$e implements CompoundButton$OnCheckedChangeListener {
    public final /* synthetic */ Action1 a;

    public CheckedSetting$e(Action1 action1) {
        this.a = action1;
    }

    @Override // android.widget.CompoundButton$OnCheckedChangeListener
    public final void onCheckedChanged(CompoundButton compoundButton, boolean z2) {
        Action1 action1 = this.a;
        if (action1 != null) {
            action1.call(Boolean.valueOf(z2));
        }
    }
}
