package com.discord.databinding;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.viewbinding.ViewBinding;
import b.a.i.r0;
import com.discord.app.AppViewFlipper;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.views.LoadingButton;
import com.discord.widgets.guilds.create.GuildTemplateChannelsView;
import com.discord.widgets.roles.RolesListView;
import com.google.android.material.textfield.TextInputLayout;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetGuildCloneBinding implements ViewBinding {

    @NonNull
    public final CoordinatorLayout a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final LoadingButton f2410b;

    @NonNull
    public final AppViewFlipper c;

    @NonNull
    public final LinkifiedTextView d;

    @NonNull
    public final r0 e;

    @NonNull
    public final TextInputLayout f;

    @NonNull
    public final TextView g;

    @NonNull
    public final GuildTemplateChannelsView h;

    @NonNull
    public final RolesListView i;

    @NonNull
    public final LinearLayout j;

    public WidgetGuildCloneBinding(@NonNull CoordinatorLayout coordinatorLayout, @NonNull LoadingButton loadingButton, @NonNull AppViewFlipper appViewFlipper, @NonNull LinkifiedTextView linkifiedTextView, @NonNull r0 r0Var, @NonNull TextInputLayout textInputLayout, @NonNull TextView textView, @NonNull TextView textView2, @NonNull GuildTemplateChannelsView guildTemplateChannelsView, @NonNull RolesListView rolesListView, @NonNull LinearLayout linearLayout, @NonNull ProgressBar progressBar) {
        this.a = coordinatorLayout;
        this.f2410b = loadingButton;
        this.c = appViewFlipper;
        this.d = linkifiedTextView;
        this.e = r0Var;
        this.f = textInputLayout;
        this.g = textView2;
        this.h = guildTemplateChannelsView;
        this.i = rolesListView;
        this.j = linearLayout;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.a;
    }
}
