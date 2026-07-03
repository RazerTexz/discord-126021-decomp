package com.discord.overlay;

import android.content.Context;
import android.view.View;
import android.view.WindowManager;
import com.discord.overlay.views.OverlayBubbleWrap;
import com.discord.utilities.display.DisplayUtils;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p000.C12928n;
import p007b.p008a.p036n.C1167b;
import p007b.p008a.p036n.InterfaceC1171f;
import p007b.p008a.p036n.ViewOnTouchListenerC1166a;
import p007b.p008a.p036n.p038h.C1173a;
import p507d0.p580t.C12160r;
import p507d0.p592z.p594d.C12238m;

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
    public C1173a trashWrap;

    /* JADX INFO: renamed from: o, reason: from kotlin metadata */
    public InterfaceC1171f trashEventListener;

    /* JADX INFO: renamed from: p, reason: from kotlin metadata */
    public View.OnTouchListener bubbleOnTouchListener;

    /* JADX INFO: renamed from: q, reason: from kotlin metadata */
    public OverlayBubbleWrap bubbleInTrashZone;

    /* JADX INFO: renamed from: r, reason: from kotlin metadata */
    public final Context context;

    /* JADX INFO: renamed from: s, reason: from kotlin metadata */
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
        C12238m.checkNotNullParameter(context, "context");
        C12238m.checkNotNullParameter(windowManager2, "windowManager");
        this.context = context;
        this.windowManager = windowManager2;
        ArrayList<OverlayBubbleWrap> arrayList = new ArrayList<>(5);
        this.overlaysOnDisplay = arrayList;
        this.activeBubbles = arrayList;
        this.onOverlayBubbleAdded = C12928n.f27501j;
        this.onOverlayBubbleRemoved = C12928n.f27502k;
        this.bubbleOnTouchListener = new ViewOnTouchListenerC1166a(this);
    }

    /* JADX INFO: renamed from: a */
    public final void m8430a(OverlayBubbleWrap bubble) {
        C12238m.checkNotNullParameter(bubble, "bubble");
        this.windowManager.addView(bubble, bubble.getWindowLayoutParams());
        this.overlaysOnDisplay.add(bubble);
        this.onOverlayBubbleAdded.invoke(bubble);
    }

    /* JADX INFO: renamed from: b */
    public final void m8431b(OverlayBubbleWrap bubble) {
        C12238m.checkNotNullParameter(bubble, "bubble");
        if (bubble.getCenterX() > DisplayUtils.getScreenSize(this.context).centerX()) {
            OverlayBubbleWrap.m8434c(bubble, Integer.MAX_VALUE, (int) bubble.getY(), null, 4, null);
        } else {
            OverlayBubbleWrap.m8434c(bubble, Integer.MIN_VALUE, (int) bubble.getY(), null, 4, null);
        }
    }

    /* JADX INFO: renamed from: c */
    public final void m8432c(OverlayBubbleWrap bubble) {
        if (C12238m.areEqual(this.bubbleInTrashZone, bubble)) {
            return;
        }
        this.bubbleInTrashZone = bubble;
        C1173a c1173a = this.trashWrap;
        if (c1173a != null) {
            c1173a.mo227a(bubble);
        }
        InterfaceC1171f interfaceC1171f = this.trashEventListener;
        if (interfaceC1171f != null) {
            interfaceC1171f.mo227a(bubble);
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        C12160r.removeAll((List) this.overlaysOnDisplay, (Function1) new C1167b(this));
        C1173a c1173a = this.trashWrap;
        if (c1173a != null) {
            this.windowManager.removeView(c1173a);
        }
        this.trashWrap = null;
    }

    /* JADX INFO: renamed from: d */
    public final void m8433d(OverlayBubbleWrap bubble) {
        C12238m.checkNotNullParameter(bubble, "bubble");
        if (this.overlaysOnDisplay.remove(bubble)) {
            this.windowManager.removeViewImmediate(bubble);
            this.onOverlayBubbleRemoved.invoke(bubble);
        }
    }
}
