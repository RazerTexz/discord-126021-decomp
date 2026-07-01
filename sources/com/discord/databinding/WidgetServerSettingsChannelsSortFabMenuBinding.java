package com.discord.databinding;

import android.view.View;
import android.widget.TableLayout;
import android.widget.TableRow;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetServerSettingsChannelsSortFabMenuBinding implements ViewBinding {

    @NonNull
    public final TableLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final FloatingActionButton f2552b;

    @NonNull
    public final TableLayout c;

    public WidgetServerSettingsChannelsSortFabMenuBinding(@NonNull TableLayout tableLayout, @NonNull TableRow tableRow, @NonNull TableRow tableRow2, @NonNull TableRow tableRow3, @NonNull TableRow tableRow4, @NonNull FloatingActionButton floatingActionButton, @NonNull TableLayout tableLayout2) {
        this.a = tableLayout;
        this.f2552b = floatingActionButton;
        this.c = tableLayout2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
