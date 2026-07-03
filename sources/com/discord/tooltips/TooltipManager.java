package com.discord.tooltips;

import android.content.SharedPreferences;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.MainThread;
import androidx.core.view.ViewCompat;
import com.discord.floating_view_manager.FloatingViewGravity;
import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p008a.p026j.C1100a;
import p007b.p008a.p026j.C1103d;
import p007b.p008a.p026j.C1104e;
import p007b.p008a.p026j.ViewOnLayoutChangeListenerC1101b;
import p007b.p008a.p026j.ViewOnLayoutChangeListenerC1102c;
import p007b.p008a.p026j.ViewTreeObserverOnPreDrawListenerC1105f;
import p007b.p008a.p058v.C1311a;
import p007b.p008a.p058v.C1315e;
import p507d0.C12083g;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;
import p658rx.Observable;

/* JADX INFO: compiled from: TooltipManager.kt */
/* JADX INFO: loaded from: classes2.dex */
public class TooltipManager {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    public Map<String, Integer> tooltipNameToTooltipViewIdMap;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    public final C1311a acknowledgedTooltipsCache;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    public final Set<String> shownTooltipNames;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    public final int maxTooltipsPerColdStart;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    public final C1100a floatingViewManager;

    /* JADX INFO: renamed from: com.discord.tooltips.TooltipManager$a */
    /* JADX INFO: compiled from: TooltipManager.kt */
    public static final class C6647a {

        /* JADX INFO: renamed from: a */
        public static WeakReference<TooltipManager> f18972a;

        /* JADX INFO: renamed from: b */
        public static final Lazy f18973b = C12083g.lazy(a.f18976j);

        /* JADX INFO: renamed from: c */
        public static final Lazy f18974c = C12083g.lazy(b.f18977j);

        /* JADX INFO: renamed from: d */
        public static final C6647a f18975d = null;

        /* JADX INFO: renamed from: com.discord.tooltips.TooltipManager$a$a */
        /* JADX INFO: compiled from: TooltipManager.kt */
        public static final class a extends AbstractC12240o implements Function0<C1311a> {

            /* JADX INFO: renamed from: j */
            public static final a f18976j = new a();

            public a() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public C1311a invoke() {
                return new C1311a(null, 1);
            }
        }

        /* JADX INFO: renamed from: com.discord.tooltips.TooltipManager$a$b */
        /* JADX INFO: compiled from: TooltipManager.kt */
        public static final class b extends AbstractC12240o implements Function0<Set<String>> {

            /* JADX INFO: renamed from: j */
            public static final b f18977j = new b();

            public b() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public Set<String> invoke() {
                return new LinkedHashSet();
            }
        }
    }

    /* JADX INFO: renamed from: com.discord.tooltips.TooltipManager$b */
    /* JADX INFO: compiled from: TooltipManager.kt */
    public static class C6648b {
        private final String cacheKey;
        private final String tooltipName;

        public C6648b(String str, String str2) {
            C12238m.checkNotNullParameter(str2, "tooltipName");
            this.cacheKey = str;
            this.tooltipName = str2;
        }

        public final String getCacheKey() {
            return this.cacheKey;
        }

        public final String getTooltipName() {
            return this.tooltipName;
        }

        public /* synthetic */ C6648b(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str, str2);
        }
    }

    public TooltipManager(C1311a c1311a, Set set, int i, C1100a c1100a, int i2) {
        i = (i2 & 4) != 0 ? 1 : i;
        C12238m.checkNotNullParameter(c1311a, "acknowledgedTooltipsCache");
        C12238m.checkNotNullParameter(set, "shownTooltipNames");
        C12238m.checkNotNullParameter(c1100a, "floatingViewManager");
        this.acknowledgedTooltipsCache = c1311a;
        this.shownTooltipNames = set;
        this.maxTooltipsPerColdStart = i;
        this.floatingViewManager = c1100a;
        c1100a.f1454a = new C1315e(this);
        this.tooltipNameToTooltipViewIdMap = new LinkedHashMap();
    }

    @MainThread
    /* JADX INFO: renamed from: a */
    public final void m8512a(C6648b tooltip) {
        C12238m.checkNotNullParameter(tooltip, "tooltip");
        m8514c(tooltip);
        String cacheKey = tooltip.getCacheKey();
        if (cacheKey != null) {
            C1311a c1311a = this.acknowledgedTooltipsCache;
            Objects.requireNonNull(c1311a);
            C12238m.checkNotNullParameter(cacheKey, "tooltipCacheKey");
            if (c1311a.f1999a.getBoolean(cacheKey, false)) {
                return;
            }
            C1311a c1311a2 = this.acknowledgedTooltipsCache;
            Objects.requireNonNull(c1311a2);
            C12238m.checkNotNullParameter(cacheKey, "tooltipCacheKey");
            SharedPreferences.Editor editorEdit = c1311a2.f1999a.edit();
            C12238m.checkNotNullExpressionValue(editorEdit, "editor");
            editorEdit.putBoolean(cacheKey, true);
            editorEdit.apply();
        }
    }

    @MainThread
    /* JADX INFO: renamed from: b */
    public final boolean m8513b(C6648b tooltip, boolean ignoreMaxTooltips) {
        C12238m.checkNotNullParameter(tooltip, "tooltip");
        String cacheKey = tooltip.getCacheKey();
        if (cacheKey != null) {
            C1311a c1311a = this.acknowledgedTooltipsCache;
            Objects.requireNonNull(c1311a);
            C12238m.checkNotNullParameter(cacheKey, "tooltipCacheKey");
            boolean z2 = c1311a.f1999a.getBoolean(cacheKey, false);
            boolean zContains = this.shownTooltipNames.contains(tooltip.getTooltipName());
            int size = this.shownTooltipNames.size();
            if (z2) {
                return false;
            }
            if (!zContains && !ignoreMaxTooltips && size >= this.maxTooltipsPerColdStart) {
                return false;
            }
        }
        return true;
    }

    @MainThread
    /* JADX INFO: renamed from: c */
    public final void m8514c(C6648b tooltip) {
        C12238m.checkNotNullParameter(tooltip, "tooltip");
        Integer num = this.tooltipNameToTooltipViewIdMap.get(tooltip.getTooltipName());
        if (num != null) {
            this.floatingViewManager.m208b(num.intValue());
        }
    }

    @MainThread
    /* JADX INFO: renamed from: d */
    public final void m8515d(View anchorView, View tooltipView, C6648b tooltip, FloatingViewGravity tooltipGravity, int xOffset, int yOffset, boolean ignoreMaxTooltips, Observable<Unit> componentPausedObservable) {
        C12238m.checkNotNullParameter(anchorView, "anchorView");
        C12238m.checkNotNullParameter(tooltipView, "tooltipView");
        C12238m.checkNotNullParameter(tooltip, "tooltip");
        C12238m.checkNotNullParameter(tooltipGravity, "tooltipGravity");
        C12238m.checkNotNullParameter(componentPausedObservable, "componentPausedObservable");
        if (m8513b(tooltip, ignoreMaxTooltips)) {
            m8514c(tooltip);
            this.shownTooltipNames.add(tooltip.getTooltipName());
            this.tooltipNameToTooltipViewIdMap.put(tooltip.getTooltipName(), Integer.valueOf(tooltipView.getId()));
            C1100a c1100a = this.floatingViewManager;
            Objects.requireNonNull(c1100a);
            C12238m.checkNotNullParameter(anchorView, "anchorView");
            C12238m.checkNotNullParameter(tooltipView, "floatingView");
            C12238m.checkNotNullParameter(tooltipGravity, "floatingViewGravity");
            C12238m.checkNotNullParameter(componentPausedObservable, "componentPausedObservable");
            View rootView = anchorView.getRootView();
            Objects.requireNonNull(rootView, "null cannot be cast to non-null type android.view.ViewGroup");
            ViewGroup viewGroup = (ViewGroup) rootView;
            tooltipView.setVisibility(4);
            if (!c1100a.f1455b.containsKey(Integer.valueOf(tooltipView.getId()))) {
                viewGroup.addView(tooltipView);
            }
            if (!ViewCompat.isLaidOut(tooltipView) || tooltipView.isLayoutRequested()) {
                tooltipView.addOnLayoutChangeListener(new ViewOnLayoutChangeListenerC1101b(c1100a, anchorView, tooltipView, tooltipGravity, xOffset, yOffset));
            } else if (!ViewCompat.isLaidOut(anchorView) || anchorView.isLayoutRequested()) {
                anchorView.addOnLayoutChangeListener(new ViewOnLayoutChangeListenerC1102c(c1100a, anchorView, tooltipView, tooltipGravity, xOffset, yOffset));
            } else {
                C1100a.m207a(c1100a, tooltipView, anchorView, tooltipGravity, xOffset, yOffset);
                tooltipView.setVisibility(0);
            }
            ViewTreeObserverOnPreDrawListenerC1105f viewTreeObserverOnPreDrawListenerC1105f = new ViewTreeObserverOnPreDrawListenerC1105f(c1100a, tooltipView, anchorView, tooltipGravity, xOffset, yOffset);
            viewGroup.getViewTreeObserver().addOnPreDrawListener(viewTreeObserverOnPreDrawListenerC1105f);
            c1100a.f1455b.put(Integer.valueOf(tooltipView.getId()), new C1100a.a(tooltipView, viewGroup, viewTreeObserverOnPreDrawListenerC1105f));
            componentPausedObservable.m11100Z(1).m11097W(new C1103d(c1100a, tooltipView), new C1104e(c1100a));
        }
    }
}
