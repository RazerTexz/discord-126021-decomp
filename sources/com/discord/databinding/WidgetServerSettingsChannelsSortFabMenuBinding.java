package com.discord.databinding;

import android.view.View;
import android.widget.TableLayout;
import android.widget.TableRow;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetServerSettingsChannelsSortFabMenuBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final TableLayout f17573a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final FloatingActionButton f17574b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final TableLayout f17575c;

    public WidgetServerSettingsChannelsSortFabMenuBinding(@NonNull TableLayout tableLayout, @NonNull TableRow tableRow, @NonNull TableRow tableRow2, @NonNull TableRow tableRow3, @NonNull TableRow tableRow4, @NonNull FloatingActionButton floatingActionButton, @NonNull TableLayout tableLayout2) {
        this.f17573a = tableLayout;
        this.f17574b = floatingActionButton;
        this.f17575c = tableLayout2;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f17573a;
    }
}
