package com.discord.widgets.user.usersheet;

import android.widget.CompoundButton;
import android.widget.CompoundButton$OnCheckedChangeListener;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: UserProfileVoiceSettingsView.kt */
/* JADX INFO: loaded from: classes.dex */
public final class UserProfileVoiceSettingsView$setOnDeafenChecked$1 implements CompoundButton$OnCheckedChangeListener {
    public final /* synthetic */ Function1 $onChecked;

    public UserProfileVoiceSettingsView$setOnDeafenChecked$1(Function1 function1) {
        this.$onChecked = function1;
    }

    @Override // android.widget.CompoundButton$OnCheckedChangeListener
    public final void onCheckedChanged(CompoundButton compoundButton, boolean z2) {
        this.$onChecked.invoke(Boolean.valueOf(z2));
    }
}
