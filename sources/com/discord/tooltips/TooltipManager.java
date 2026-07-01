package com.discord.tooltips;

import android.content.SharedPreferences$Editor;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.MainThread;
import androidx.core.view.ViewCompat;
import b.a.j.a$a;
import b.a.j.b;
import b.a.j.c;
import b.a.j.d;
import b.a.j.f;
import b.a.v.a;
import b.a.v.e;
import com.discord.floating_view_manager.FloatingViewGravity;
import d0.z.d.m;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import kotlin.Unit;
import rx.Observable;

/* JADX INFO: compiled from: TooltipManager.kt */
/* JADX INFO: loaded from: classes2.dex */
public class TooltipManager {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    public Map<String, Integer> tooltipNameToTooltipViewIdMap;

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final a acknowledgedTooltipsCache;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    public final Set<String> shownTooltipNames;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    public final int maxTooltipsPerColdStart;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    public final b.a.j.a floatingViewManager;

    public TooltipManager(a aVar, Set set, int i, b.a.j.a aVar2, int i2) {
        i = (i2 & 4) != 0 ? 1 : i;
        m.checkNotNullParameter(aVar, "acknowledgedTooltipsCache");
        m.checkNotNullParameter(set, "shownTooltipNames");
        m.checkNotNullParameter(aVar2, "floatingViewManager");
        this.acknowledgedTooltipsCache = aVar;
        this.shownTooltipNames = set;
        this.maxTooltipsPerColdStart = i;
        this.floatingViewManager = aVar2;
        aVar2.a = new e(this);
        this.tooltipNameToTooltipViewIdMap = new LinkedHashMap();
    }

    @MainThread
    public final void a(TooltipManager$b tooltip) {
        m.checkNotNullParameter(tooltip, "tooltip");
        c(tooltip);
        String cacheKey = tooltip.getCacheKey();
        if (cacheKey != null) {
            a aVar = this.acknowledgedTooltipsCache;
            Objects.requireNonNull(aVar);
            m.checkNotNullParameter(cacheKey, "tooltipCacheKey");
            if (aVar.a.getBoolean(cacheKey, false)) {
                return;
            }
            a aVar2 = this.acknowledgedTooltipsCache;
            Objects.requireNonNull(aVar2);
            m.checkNotNullParameter(cacheKey, "tooltipCacheKey");
            SharedPreferences$Editor sharedPreferences$EditorEdit = aVar2.a.edit();
            m.checkNotNullExpressionValue(sharedPreferences$EditorEdit, "editor");
            sharedPreferences$EditorEdit.putBoolean(cacheKey, true);
            sharedPreferences$EditorEdit.apply();
        }
    }

    @MainThread
    public final boolean b(TooltipManager$b tooltip, boolean ignoreMaxTooltips) {
        m.checkNotNullParameter(tooltip, "tooltip");
        String cacheKey = tooltip.getCacheKey();
        if (cacheKey != null) {
            a aVar = this.acknowledgedTooltipsCache;
            Objects.requireNonNull(aVar);
            m.checkNotNullParameter(cacheKey, "tooltipCacheKey");
            boolean z2 = aVar.a.getBoolean(cacheKey, false);
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
    public final void c(TooltipManager$b tooltip) {
        m.checkNotNullParameter(tooltip, "tooltip");
        Integer num = this.tooltipNameToTooltipViewIdMap.get(tooltip.getTooltipName());
        if (num != null) {
            this.floatingViewManager.b(num.intValue());
        }
    }

    @MainThread
    public final void d(View anchorView, View tooltipView, TooltipManager$b tooltip, FloatingViewGravity tooltipGravity, int xOffset, int yOffset, boolean ignoreMaxTooltips, Observable<Unit> componentPausedObservable) {
        m.checkNotNullParameter(anchorView, "anchorView");
        m.checkNotNullParameter(tooltipView, "tooltipView");
        m.checkNotNullParameter(tooltip, "tooltip");
        m.checkNotNullParameter(tooltipGravity, "tooltipGravity");
        m.checkNotNullParameter(componentPausedObservable, "componentPausedObservable");
        if (b(tooltip, ignoreMaxTooltips)) {
            c(tooltip);
            this.shownTooltipNames.add(tooltip.getTooltipName());
            this.tooltipNameToTooltipViewIdMap.put(tooltip.getTooltipName(), Integer.valueOf(tooltipView.getId()));
            b.a.j.a aVar = this.floatingViewManager;
            Objects.requireNonNull(aVar);
            m.checkNotNullParameter(anchorView, "anchorView");
            m.checkNotNullParameter(tooltipView, "floatingView");
            m.checkNotNullParameter(tooltipGravity, "floatingViewGravity");
            m.checkNotNullParameter(componentPausedObservable, "componentPausedObservable");
            View rootView = anchorView.getRootView();
            Objects.requireNonNull(rootView, "null cannot be cast to non-null type android.view.ViewGroup");
            ViewGroup viewGroup = (ViewGroup) rootView;
            tooltipView.setVisibility(4);
            if (!aVar.f243b.containsKey(Integer.valueOf(tooltipView.getId()))) {
                viewGroup.addView(tooltipView);
            }
            if (!ViewCompat.isLaidOut(tooltipView) || tooltipView.isLayoutRequested()) {
                tooltipView.addOnLayoutChangeListener(new b(aVar, anchorView, tooltipView, tooltipGravity, xOffset, yOffset));
            } else if (!ViewCompat.isLaidOut(anchorView) || anchorView.isLayoutRequested()) {
                anchorView.addOnLayoutChangeListener(new c(aVar, anchorView, tooltipView, tooltipGravity, xOffset, yOffset));
            } else {
                b.a.j.a.a(aVar, tooltipView, anchorView, tooltipGravity, xOffset, yOffset);
                tooltipView.setVisibility(0);
            }
            f fVar = new f(aVar, tooltipView, anchorView, tooltipGravity, xOffset, yOffset);
            viewGroup.getViewTreeObserver().addOnPreDrawListener(fVar);
            aVar.f243b.put(Integer.valueOf(tooltipView.getId()), new a$a(tooltipView, viewGroup, fVar));
            componentPausedObservable.Z(1).W(new d(aVar, tooltipView), new b.a.j.e(aVar));
        }
    }
}
