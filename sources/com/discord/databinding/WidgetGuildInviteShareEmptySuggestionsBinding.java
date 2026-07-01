package com.discord.databinding;

import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.viewbinding.ViewBinding;
import com.discord.widgets.guilds.invite.ViewInviteSettingsSheet;
import com.google.android.material.button.MaterialButton;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetGuildInviteShareEmptySuggestionsBinding implements ViewBinding {

    @NonNull
    public final CoordinatorLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final View f2420b;

    @NonNull
    public final TextView c;

    @NonNull
    public final MaterialButton d;

    @NonNull
    public final ImageButton e;

    @NonNull
    public final TextView f;

    @NonNull
    public final ViewInviteSettingsSheet g;

    public WidgetGuildInviteShareEmptySuggestionsBinding(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view, @NonNull TextView textView, @NonNull MaterialButton materialButton, @NonNull ImageButton imageButton, @NonNull TextView textView2, @NonNull ViewInviteSettingsSheet viewInviteSettingsSheet) {
        this.a = coordinatorLayout;
        this.f2420b = view;
        this.c = textView;
        this.d = materialButton;
        this.e = imageButton;
        this.f = textView2;
        this.g = viewInviteSettingsSheet;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
