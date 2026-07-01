package com.discord.widgets.chat.input;

import android.annotation.TargetApi;
import android.os.Build$VERSION;
import android.view.View;
import d0.z.d.m;

/* JADX INFO: compiled from: SmoothKeyboardReactionHelper.kt */
/* JADX INFO: loaded from: classes2.dex */
@TargetApi(30)
public final class SmoothKeyboardReactionHelper {
    public static final SmoothKeyboardReactionHelper INSTANCE = new SmoothKeyboardReactionHelper();

    private SmoothKeyboardReactionHelper() {
    }

    public final void install(View view) {
        m.checkNotNullParameter(view, "view");
        if (Build$VERSION.SDK_INT >= 30) {
            view.setWindowInsetsAnimationCallback(new SmoothKeyboardReactionHelper$Callback(view));
        }
    }
}
