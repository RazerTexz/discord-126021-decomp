package com.discord.utilities.view.extensions;

import android.view.KeyEvent;
import android.widget.TextView;
import android.widget.TextView$OnEditorActionListener;
import d0.z.d.m;
import kotlin.jvm.functions.Function3;

/* JADX INFO: compiled from: ViewExtensions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ViewExtensions$sam$android_widget_TextView_OnEditorActionListener$0 implements TextView$OnEditorActionListener {
    private final /* synthetic */ Function3 function;

    public ViewExtensions$sam$android_widget_TextView_OnEditorActionListener$0(Function3 function3) {
        this.function = function3;
    }

    @Override // android.widget.TextView$OnEditorActionListener
    public final /* synthetic */ boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        Object objInvoke = this.function.invoke(textView, Integer.valueOf(i), keyEvent);
        m.checkNotNullExpressionValue(objInvoke, "invoke(...)");
        return ((Boolean) objInvoke).booleanValue();
    }
}
