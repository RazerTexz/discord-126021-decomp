package com.google.android.material.bottomappbar;

import androidx.annotation.NonNull;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.floatingactionbutton.FloatingActionButton$OnVisibilityChangedListener;

/* JADX INFO: loaded from: classes3.dex */
public class BottomAppBar$e extends FloatingActionButton$OnVisibilityChangedListener {
    public final /* synthetic */ int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ BottomAppBar f3029b;

    public BottomAppBar$e(BottomAppBar bottomAppBar, int i) {
        this.f3029b = bottomAppBar;
        this.a = i;
    }

    @Override // com.google.android.material.floatingactionbutton.FloatingActionButton$OnVisibilityChangedListener
    public void onHidden(@NonNull FloatingActionButton floatingActionButton) {
        floatingActionButton.setTranslationX(BottomAppBar.access$1800(this.f3029b, this.a));
        floatingActionButton.show(new BottomAppBar$e$a(this));
    }
}
