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

    /* JADX INFO: renamed from: a */
    @NonNull
    public final CoordinatorLayout f17848a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final WidgetChatListAdapterItemTextBinding f17849b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final TextView f17850c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final TextView f17851d;

    /* JADX INFO: renamed from: e */
    @NonNull
    public final TextView f17852e;

    /* JADX INFO: renamed from: f */
    @NonNull
    public final SeekBar f17853f;

    /* JADX INFO: renamed from: g */
    @NonNull
    public final View f17854g;

    /* JADX INFO: renamed from: h */
    @NonNull
    public final TextView f17855h;

    /* JADX INFO: renamed from: i */
    @NonNull
    public final CheckedSetting f17856i;

    /* JADX INFO: renamed from: j */
    @NonNull
    public final CheckedSetting f17857j;

    /* JADX INFO: renamed from: k */
    @NonNull
    public final TextView f17858k;

    /* JADX INFO: renamed from: l */
    @NonNull
    public final CheckedSetting f17859l;

    /* JADX INFO: renamed from: m */
    @NonNull
    public final CheckedSetting f17860m;

    public WidgetSettingsAppearanceBinding(@NonNull CoordinatorLayout coordinatorLayout, @NonNull WidgetChatListAdapterItemTextBinding widgetChatListAdapterItemTextBinding, @NonNull TextView textView, @NonNull TextView textView2, @NonNull LinearLayout linearLayout, @NonNull TextView textView3, @NonNull SeekBar seekBar, @NonNull TextView textView4, @NonNull TextView textView5, @NonNull View view, @NonNull TextView textView6, @NonNull CheckedSetting checkedSetting, @NonNull CheckedSetting checkedSetting2, @NonNull TextView textView7, @NonNull CheckedSetting checkedSetting3, @NonNull CheckedSetting checkedSetting4) {
        this.f17848a = coordinatorLayout;
        this.f17849b = widgetChatListAdapterItemTextBinding;
        this.f17850c = textView;
        this.f17851d = textView2;
        this.f17852e = textView3;
        this.f17853f = seekBar;
        this.f17854g = view;
        this.f17855h = textView6;
        this.f17856i = checkedSetting;
        this.f17857j = checkedSetting2;
        this.f17858k = textView7;
        this.f17859l = checkedSetting3;
        this.f17860m = checkedSetting4;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f17848a;
    }
}
