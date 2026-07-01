package com.discord.databinding;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.viewbinding.ViewBinding;
import com.discord.views.CheckedSetting;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetSettingsAppearanceBinding implements ViewBinding {

    @NonNull
    public final CoordinatorLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final WidgetChatListAdapterItemTextBinding f2602b;

    @NonNull
    public final TextView c;

    @NonNull
    public final TextView d;

    @NonNull
    public final TextView e;

    @NonNull
    public final SeekBar f;

    @NonNull
    public final View g;

    @NonNull
    public final TextView h;

    @NonNull
    public final CheckedSetting i;

    @NonNull
    public final CheckedSetting j;

    @NonNull
    public final TextView k;

    @NonNull
    public final CheckedSetting l;

    @NonNull
    public final CheckedSetting m;

    public WidgetSettingsAppearanceBinding(@NonNull CoordinatorLayout coordinatorLayout, @NonNull WidgetChatListAdapterItemTextBinding widgetChatListAdapterItemTextBinding, @NonNull TextView textView, @NonNull TextView textView2, @NonNull LinearLayout linearLayout, @NonNull TextView textView3, @NonNull SeekBar seekBar, @NonNull TextView textView4, @NonNull TextView textView5, @NonNull View view, @NonNull TextView textView6, @NonNull CheckedSetting checkedSetting, @NonNull CheckedSetting checkedSetting2, @NonNull TextView textView7, @NonNull CheckedSetting checkedSetting3, @NonNull CheckedSetting checkedSetting4) {
        this.a = coordinatorLayout;
        this.f2602b = widgetChatListAdapterItemTextBinding;
        this.c = textView;
        this.d = textView2;
        this.e = textView3;
        this.f = seekBar;
        this.g = view;
        this.h = textView6;
        this.i = checkedSetting;
        this.j = checkedSetting2;
        this.k = textView7;
        this.l = checkedSetting3;
        this.m = checkedSetting4;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
