package com.discord.overlay;

import android.content.Context;
import android.view.View;
import android.view.View$OnTouchListener;
import android.view.WindowManager;
import b.a.n.b;
import b.a.n.f;
import b.a.n.h.a;
import com.discord.overlay.views.OverlayBubbleWrap;
import com.discord.utilities.display.DisplayUtils;
import d0.t.r;
import d0.z.d.m;
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
    public a trashWrap;

    /* JADX INFO: renamed from: o, reason: from kotlin metadata */
    public f trashEventListener;

    /* JADX INFO: renamed from: p, reason: from kotlin metadata */
    public View$OnTouchListener bubbleOnTouchListener;

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
        m.checkNotNullParameter(context, "context");
        m.checkNotNullParameter(windowManager2, "windowManager");
        this.context = context;
        this.windowManager = windowManager2;
        ArrayList<OverlayBubbleWrap> arrayList = new ArrayList<>(5);
        this.overlaysOnDisplay = arrayList;
        this.activeBubbles = arrayList;
        this.onOverlayBubbleAdded = n.j;
        this.onOverlayBubbleRemoved = n.k;
        this.bubbleOnTouchListener = new b.a.n.a(this);
    }

    public final void a(OverlayBubbleWrap bubble) {
        m.checkNotNullParameter(bubble, "bubble");
        this.windowManager.addView(bubble, bubble.getWindowLayoutParams());
        this.overlaysOnDisplay.add(bubble);
        this.onOverlayBubbleAdded.invoke(bubble);
    }

    public final void b(OverlayBubbleWrap bubble) {
        m.checkNotNullParameter(bubble, "bubble");
        if (bubble.getCenterX() > DisplayUtils.getScreenSize(this.context).centerX()) {
            OverlayBubbleWrap.c(bubble, Integer.MAX_VALUE, (int) bubble.getY(), null, 4, null);
        } else {
            OverlayBubbleWrap.c(bubble, Integer.MIN_VALUE, (int) bubble.getY(), null, 4, null);
        }
    }

    public final void c(OverlayBubbleWrap bubble) {
        if (m.areEqual(this.bubbleInTrashZone, bubble)) {
            return;
        }
        this.bubbleInTrashZone = bubble;
        a aVar = this.trashWrap;
        if (aVar != null) {
            aVar.a(bubble);
        }
        f fVar = this.trashEventListener;
        if (fVar != null) {
            fVar.a(bubble);
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        r.removeAll((List) this.overlaysOnDisplay, (Function1) new b(this));
        a aVar = this.trashWrap;
        if (aVar != null) {
            this.windowManager.removeView(aVar);
        }
        this.trashWrap = null;
    }

    public final void d(OverlayBubbleWrap bubble) {
        m.checkNotNullParameter(bubble, "bubble");
        if (this.overlaysOnDisplay.remove(bubble)) {
            this.windowManager.removeViewImmediate(bubble);
            this.onOverlayBubbleRemoved.invoke(bubble);
        }
    }
}
