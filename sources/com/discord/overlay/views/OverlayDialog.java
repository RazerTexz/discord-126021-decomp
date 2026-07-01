package com.discord.overlay.views;

import android.content.Context;
import android.content.res.Configuration;
import android.util.Log;
import android.view.WindowManager;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: OverlayDialog.kt */
/* JADX INFO: loaded from: classes.dex */
public class OverlayDialog extends OverlayBubbleWrap {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OverlayDialog(Context context) {
        super(context);
        Intrinsics3.checkNotNullParameter(context, "context");
        WindowManager.LayoutParams windowLayoutParams = getWindowLayoutParams();
        windowLayoutParams.width = -1;
        windowLayoutParams.height = -1;
        windowLayoutParams.x = 0;
        windowLayoutParams.y = 0;
        Intrinsics3.checkNotNullParameter(windowLayoutParams, "$this$addFlag");
        windowLayoutParams.flags |= 2;
        windowLayoutParams.dimAmount = 0.5f;
        setStateListAnimator(null);
    }

    @Override // com.discord.overlay.views.OverlayBubbleWrap
    public boolean f() {
        return false;
    }

    @Override // com.discord.overlay.views.OverlayBubbleWrap, android.view.View
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        getWindowLayoutParams().x = 0;
        getWindowLayoutParams().y = 0;
        getWindowManager().updateViewLayout(this, getWindowLayoutParams());
    }

    public final void setFlag(int flag) {
        getWindowLayoutParams().flags = flag | getWindowLayoutParams().flags;
    }

    @Override // com.discord.overlay.views.OverlayBubbleWrap
    public void setMoving(boolean z2) {
        Log.w(getClass().getSimpleName(), "Move disabled");
    }
}
