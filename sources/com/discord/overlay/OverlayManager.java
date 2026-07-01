package com.discord.overlay;

import android.content.Context;
import android.view.View;
import android.view.WindowManager;
import b.a.n.OverlayManager2;
import b.a.n.OverlayManager3;
import b.a.n.TrashEventListener;
import b.a.n.h.OverlayTrashWrap;
import com.discord.overlay.views.OverlayBubbleWrap;
import com.discord.utilities.display.DisplayUtils;
import d0.t.MutableCollections;
import d0.z.d.Intrinsics3;
import defpackage.n;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: OverlayManager.kt */
/* JADX INFO: loaded from: classes.dex */
public class OverlayManager implements Closeable {

    /* JADX INFO: renamed from: j, reason: from kotlin metadata */
    public final ArrayList<OverlayBubbleWrap> overlaysOnDisplay;

    /* JADX INFO: renamed from: k, reason: from kotlin metadata */
    public final List<OverlayBubbleWrap> activeBubbles;

    /* JADX INFO: renamed from: l, reason: from kotlin metadata */
    public Function1<? super View, Unit> onOverlayBubbleAdded;

    /* JADX INFO: renamed from: m, reason: from kotlin metadata */
    public Function1<? super View, Unit> onOverlayBubbleRemoved;

    /* JADX INFO: renamed from: n, reason: from kotlin metadata */
    public OverlayTrashWrap trashWrap;

    /* JADX INFO: renamed from: o, reason: from kotlin metadata */
    public TrashEventListener trashEventListener;

    /* JADX INFO: renamed from: p, reason: from kotlin metadata */
    public View.OnTouchListener bubbleOnTouchListener;

    /* JADX INFO: renamed from: q, reason: from kotlin metadata */
    public OverlayBubbleWrap bubbleInTrashZone;

    /* JADX INFO: renamed from: r, reason: from kotlin metadata */
    public final Context context;

    /* JADX INFO: renamed from: s, reason: collision with root package name and from kotlin metadata */
    public final WindowManager windowManager;

    public OverlayManager(Context context, WindowManager windowManager, int i) {
        WindowManager windowManager2;
        if ((i & 2) != 0) {
            Object systemService = context.getSystemService("window");
            Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.view.WindowManager");
            windowManager2 = (WindowManager) systemService;
        } else {
            windowManager2 = null;
        }
        Intrinsics3.checkNotNullParameter(context, "context");
        Intrinsics3.checkNotNullParameter(windowManager2, "windowManager");
        this.context = context;
        this.windowManager = windowManager2;
        ArrayList<OverlayBubbleWrap> arrayList = new ArrayList<>(5);
        this.overlaysOnDisplay = arrayList;
        this.activeBubbles = arrayList;
        this.onOverlayBubbleAdded = n.j;
        this.onOverlayBubbleRemoved = n.k;
        this.bubbleOnTouchListener = new OverlayManager2(this);
    }

    public final void a(OverlayBubbleWrap bubble) {
        Intrinsics3.checkNotNullParameter(bubble, "bubble");
        this.windowManager.addView(bubble, bubble.getWindowLayoutParams());
        this.overlaysOnDisplay.add(bubble);
        this.onOverlayBubbleAdded.invoke(bubble);
    }

    public final void b(OverlayBubbleWrap bubble) {
        Intrinsics3.checkNotNullParameter(bubble, "bubble");
        if (bubble.getCenterX() > DisplayUtils.getScreenSize(this.context).centerX()) {
            OverlayBubbleWrap.c(bubble, Integer.MAX_VALUE, (int) bubble.getY(), null, 4, null);
        } else {
            OverlayBubbleWrap.c(bubble, Integer.MIN_VALUE, (int) bubble.getY(), null, 4, null);
        }
    }

    public final void c(OverlayBubbleWrap bubble) {
        if (Intrinsics3.areEqual(this.bubbleInTrashZone, bubble)) {
            return;
        }
        this.bubbleInTrashZone = bubble;
        OverlayTrashWrap overlayTrashWrap = this.trashWrap;
        if (overlayTrashWrap != null) {
            overlayTrashWrap.a(bubble);
        }
        TrashEventListener trashEventListener = this.trashEventListener;
        if (trashEventListener != null) {
            trashEventListener.a(bubble);
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        MutableCollections.removeAll((List) this.overlaysOnDisplay, (Function1) new OverlayManager3(this));
        OverlayTrashWrap overlayTrashWrap = this.trashWrap;
        if (overlayTrashWrap != null) {
            this.windowManager.removeView(overlayTrashWrap);
        }
        this.trashWrap = null;
    }

    public final void d(OverlayBubbleWrap bubble) {
        Intrinsics3.checkNotNullParameter(bubble, "bubble");
        if (this.overlaysOnDisplay.remove(bubble)) {
            this.windowManager.removeViewImmediate(bubble);
            this.onOverlayBubbleRemoved.invoke(bubble);
        }
    }
}
