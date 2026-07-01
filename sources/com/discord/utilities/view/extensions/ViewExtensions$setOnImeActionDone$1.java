package com.discord.utilities.view.extensions;

import android.view.KeyEvent;
import android.widget.TextView;
import com.google.android.material.textfield.TextInputLayout;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;

/* JADX INFO: compiled from: ViewExtensions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ViewExtensions$setOnImeActionDone$1 extends o implements Function3<TextView, Integer, KeyEvent, Boolean> {
    public final /* synthetic */ boolean $isEventConsumed;
    public final /* synthetic */ Function1 $onImeActionDone;
    public final /* synthetic */ TextInputLayout $this_setOnImeActionDone;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ViewExtensions$setOnImeActionDone$1(TextInputLayout textInputLayout, Function1 function1, boolean z2) {
        super(3);
        this.$this_setOnImeActionDone = textInputLayout;
        this.$onImeActionDone = function1;
        this.$isEventConsumed = z2;
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Boolean invoke(TextView textView, Integer num, KeyEvent keyEvent) {
        return Boolean.valueOf(invoke(textView, num.intValue(), keyEvent));
    }

    public final boolean invoke(TextView textView, int i, KeyEvent keyEvent) {
        m.checkNotNullParameter(textView, "textView");
        if (i == 6) {
            if (ViewExtensions.getTextOrEmpty(this.$this_setOnImeActionDone).length() > 0) {
                this.$onImeActionDone.invoke(textView);
            }
        }
        return this.$isEventConsumed;
    }
}
