package com.discord.utilities.views;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver$OnGlobalLayoutListener;

/* JADX INFO: compiled from: FloatingButtonMenuInitializer.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class FloatingButtonMenuInitializer$initialize$1 implements ViewTreeObserver$OnGlobalLayoutListener {
    public final /* synthetic */ View $mainFab;
    public final /* synthetic */ ViewGroup $menuContainer;
    public final /* synthetic */ FloatingButtonMenuInitializer this$0;

    public FloatingButtonMenuInitializer$initialize$1(FloatingButtonMenuInitializer floatingButtonMenuInitializer, ViewGroup viewGroup, View view) {
        this.this$0 = floatingButtonMenuInitializer;
        this.$menuContainer = viewGroup;
        this.$mainFab = view;
    }

    @Override // android.view.ViewTreeObserver$OnGlobalLayoutListener
    public void onGlobalLayout() {
        FloatingButtonMenuInitializer floatingButtonMenuInitializer = this.this$0;
        FloatingButtonMenuInitializer.access$configureEntranceAnimator(floatingButtonMenuInitializer, FloatingButtonMenuInitializer.access$getMenuAnimators(floatingButtonMenuInitializer, this.$menuContainer, this.$mainFab)).start();
        this.$menuContainer.getViewTreeObserver().removeOnGlobalLayoutListener(this);
    }
}
