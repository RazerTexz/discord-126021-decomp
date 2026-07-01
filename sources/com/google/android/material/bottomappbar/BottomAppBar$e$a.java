package com.google.android.material.bottomappbar;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.floatingactionbutton.FloatingActionButton$OnVisibilityChangedListener;

/* JADX INFO: loaded from: classes3.dex */
public class BottomAppBar$e$a extends FloatingActionButton$OnVisibilityChangedListener {
    public final /* synthetic */ BottomAppBar$e a;

    public BottomAppBar$e$a(BottomAppBar$e bottomAppBar$e) {
        this.a = bottomAppBar$e;
    }

    @Override // com.google.android.material.floatingactionbutton.FloatingActionButton$OnVisibilityChangedListener
    public void onShown(FloatingActionButton floatingActionButton) {
        BottomAppBar.access$1600(this.a.f3029b);
    }
}
