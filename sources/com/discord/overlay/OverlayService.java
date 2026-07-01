package com.discord.overlay;

import android.app.Notification;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import b.a.n.h.a;
import com.discord.overlay.views.OverlayBubbleWrap;
import d0.z.d.m;
import java.util.Objects;

/* JADX INFO: compiled from: OverlayService.kt */
/* JADX INFO: loaded from: classes.dex */
public abstract class OverlayService extends Service {
    public static final OverlayService$Companion Companion = new OverlayService$Companion(null);
    public static final int NOTIFICATION_ID = 5858;
    public OverlayManager overlayManager;

    private final boolean attachBubbleToWindow(Intent intent) {
        OverlayBubbleWrap overlayBubbleWrapCreateOverlayBubble = createOverlayBubble(intent);
        if (overlayBubbleWrapCreateOverlayBubble == null) {
            return false;
        }
        OverlayManager overlayManager = this.overlayManager;
        if (overlayManager == null) {
            m.throwUninitializedPropertyAccessException("overlayManager");
        }
        overlayManager.a(overlayBubbleWrapCreateOverlayBubble);
        overlayBubbleWrapCreateOverlayBubble.post(new OverlayService$a(this, overlayBubbleWrapCreateOverlayBubble));
        OverlayManager overlayManager2 = this.overlayManager;
        if (overlayManager2 == null) {
            m.throwUninitializedPropertyAccessException("overlayManager");
        }
        if (overlayManager2.trashWrap != null) {
            return true;
        }
        Context applicationContext = getApplicationContext();
        m.checkNotNullExpressionValue(applicationContext, "applicationContext");
        a aVar = new a(applicationContext);
        OverlayManager overlayManager3 = this.overlayManager;
        if (overlayManager3 == null) {
            m.throwUninitializedPropertyAccessException("overlayManager");
        }
        Objects.requireNonNull(overlayManager3);
        m.checkNotNullParameter(aVar, "trashWrap");
        overlayManager3.trashWrap = aVar;
        overlayManager3.windowManager.addView(aVar, aVar.getWindowLayoutParams());
        return true;
    }

    public abstract Notification createNotification(Intent intent);

    public abstract OverlayBubbleWrap createOverlayBubble(Intent intent);

    public final OverlayManager getOverlayManager() {
        OverlayManager overlayManager = this.overlayManager;
        if (overlayManager == null) {
            m.throwUninitializedPropertyAccessException("overlayManager");
        }
        return overlayManager;
    }

    public final void handleStart(Intent intent) {
        if (intent == null) {
            intent = new Intent();
        }
        if (attachBubbleToWindow(intent)) {
            startForeground(NOTIFICATION_ID, createNotification(intent));
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        Context applicationContext = getApplicationContext();
        m.checkNotNullExpressionValue(applicationContext, "applicationContext");
        OverlayManager overlayManager = new OverlayManager(applicationContext, null, 2);
        this.overlayManager = overlayManager;
        overlayManager.trashEventListener = new OverlayService$b(this);
        if (overlayManager == null) {
            m.throwUninitializedPropertyAccessException("overlayManager");
        }
        OverlayService$c overlayService$c = new OverlayService$c(this);
        Objects.requireNonNull(overlayManager);
        m.checkNotNullParameter(overlayService$c, "<set-?>");
        overlayManager.onOverlayBubbleRemoved = overlayService$c;
    }

    @Override // android.app.Service
    public void onDestroy() {
        OverlayManager overlayManager = this.overlayManager;
        if (overlayManager == null) {
            m.throwUninitializedPropertyAccessException("overlayManager");
        }
        overlayManager.close();
        super.onDestroy();
    }

    public final void setOverlayManager(OverlayManager overlayManager) {
        m.checkNotNullParameter(overlayManager, "<set-?>");
        this.overlayManager = overlayManager;
    }
}
