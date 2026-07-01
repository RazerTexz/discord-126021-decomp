package com.discord.overlay;

import android.app.Notification;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.view.View;
import b.a.n.TrashEventListener;
import b.a.n.h.OverlayTrashWrap;
import b.d.b.a.outline;
import com.discord.overlay.views.OverlayBubbleWrap;
import d0.Standard2;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: OverlayService.kt */
/* JADX INFO: loaded from: classes.dex */
public abstract class OverlayService extends Service {
    public static final Companion Companion = new Companion(null);
    public static final int NOTIFICATION_ID = 5858;
    public OverlayManager overlayManager;

    /* JADX INFO: compiled from: OverlayService.kt */
    public static final class Companion {
        public Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    /* JADX INFO: compiled from: OverlayService.kt */
    public static final class a implements Runnable {
        public final /* synthetic */ OverlayBubbleWrap k;

        public a(OverlayBubbleWrap overlayBubbleWrap) {
            this.k = overlayBubbleWrap;
        }

        @Override // java.lang.Runnable
        public final void run() {
            OverlayService.this.getOverlayManager().b(this.k);
        }
    }

    /* JADX INFO: compiled from: OverlayService.kt */
    public static final class b implements TrashEventListener {
        public b() {
        }

        @Override // b.a.n.TrashEventListener
        public void a(OverlayBubbleWrap overlayBubbleWrap) {
        }

        @Override // b.a.n.TrashEventListener
        public void b(OverlayBubbleWrap overlayBubbleWrap) {
            Intrinsics3.checkNotNullParameter(overlayBubbleWrap, "bubble");
            OverlayService.this.getOverlayManager().d(overlayBubbleWrap);
        }
    }

    /* JADX INFO: compiled from: OverlayService.kt */
    public static final class c extends Lambda implements Function1<View, Unit> {
        public c() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(View view) {
            Intrinsics3.checkNotNullParameter(view, "it");
            if (OverlayService.this.getOverlayManager().activeBubbles.isEmpty()) {
                throw new Standard2(outline.w("An operation is not implemented: ", "handle stop service"));
            }
            return Unit.a;
        }
    }

    private final boolean attachBubbleToWindow(Intent intent) {
        OverlayBubbleWrap overlayBubbleWrapCreateOverlayBubble = createOverlayBubble(intent);
        if (overlayBubbleWrapCreateOverlayBubble == null) {
            return false;
        }
        OverlayManager overlayManager = this.overlayManager;
        if (overlayManager == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("overlayManager");
        }
        overlayManager.a(overlayBubbleWrapCreateOverlayBubble);
        overlayBubbleWrapCreateOverlayBubble.post(new a(overlayBubbleWrapCreateOverlayBubble));
        OverlayManager overlayManager2 = this.overlayManager;
        if (overlayManager2 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("overlayManager");
        }
        if (overlayManager2.trashWrap != null) {
            return true;
        }
        Context applicationContext = getApplicationContext();
        Intrinsics3.checkNotNullExpressionValue(applicationContext, "applicationContext");
        OverlayTrashWrap overlayTrashWrap = new OverlayTrashWrap(applicationContext);
        OverlayManager overlayManager3 = this.overlayManager;
        if (overlayManager3 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("overlayManager");
        }
        Objects.requireNonNull(overlayManager3);
        Intrinsics3.checkNotNullParameter(overlayTrashWrap, "trashWrap");
        overlayManager3.trashWrap = overlayTrashWrap;
        overlayManager3.windowManager.addView(overlayTrashWrap, overlayTrashWrap.getWindowLayoutParams());
        return true;
    }

    public abstract Notification createNotification(Intent intent);

    public abstract OverlayBubbleWrap createOverlayBubble(Intent intent);

    public final OverlayManager getOverlayManager() {
        OverlayManager overlayManager = this.overlayManager;
        if (overlayManager == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("overlayManager");
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
        Intrinsics3.checkNotNullExpressionValue(applicationContext, "applicationContext");
        OverlayManager overlayManager = new OverlayManager(applicationContext, null, 2);
        this.overlayManager = overlayManager;
        overlayManager.trashEventListener = new b();
        if (overlayManager == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("overlayManager");
        }
        c cVar = new c();
        Objects.requireNonNull(overlayManager);
        Intrinsics3.checkNotNullParameter(cVar, "<set-?>");
        overlayManager.onOverlayBubbleRemoved = cVar;
    }

    @Override // android.app.Service
    public void onDestroy() {
        OverlayManager overlayManager = this.overlayManager;
        if (overlayManager == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("overlayManager");
        }
        overlayManager.close();
        super.onDestroy();
    }

    public final void setOverlayManager(OverlayManager overlayManager) {
        Intrinsics3.checkNotNullParameter(overlayManager, "<set-?>");
        this.overlayManager = overlayManager;
    }
}
