package com.discord.utilities.press;

import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: OnPressListener.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class OnPressListener$1 implements OnPressListener$OnPress {
    public final /* synthetic */ Function1 $onPress;

    public OnPressListener$1(Function1 function1) {
        this.$onPress = function1;
    }

    @Override // com.discord.utilities.press.OnPressListener$OnPress
    public void onPress(boolean pressed) {
        this.$onPress.invoke(Boolean.valueOf(pressed));
    }
}
