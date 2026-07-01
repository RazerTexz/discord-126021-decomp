package com.discord.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.discord.widgets.roles.RoleIconView;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetServerSettingsRoleItemBinding implements ViewBinding {

    @NonNull
    public final RelativeLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final View f2583b;

    @NonNull
    public final ImageView c;

    @NonNull
    public final TextView d;

    @NonNull
    public final RoleIconView e;

    public WidgetServerSettingsRoleItemBinding(@NonNull RelativeLayout relativeLayout, @NonNull View view, @NonNull View view2, @NonNull View view3, @NonNull ImageView imageView, @NonNull TextView textView, @NonNull RoleIconView roleIconView) {
        this.a = relativeLayout;
        this.f2583b = view3;
        this.c = imageView;
        this.d = textView;
        this.e = roleIconView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
