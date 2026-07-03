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

    /* JADX INFO: renamed from: a */
    @NonNull
    public final RelativeLayout f17739a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final View f17740b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final ImageView f17741c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final TextView f17742d;

    /* JADX INFO: renamed from: e */
    @NonNull
    public final RoleIconView f17743e;

    public WidgetServerSettingsRoleItemBinding(@NonNull RelativeLayout relativeLayout, @NonNull View view, @NonNull View view2, @NonNull View view3, @NonNull ImageView imageView, @NonNull TextView textView, @NonNull RoleIconView roleIconView) {
        this.f17739a = relativeLayout;
        this.f17740b = view3;
        this.f17741c = imageView;
        this.f17742d = textView;
        this.f17743e = roleIconView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f17739a;
    }
}
