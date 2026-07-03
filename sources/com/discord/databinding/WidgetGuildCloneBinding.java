package com.discord.databinding;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.viewbinding.ViewBinding;
import com.discord.app.AppViewFlipper;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.views.LoadingButton;
import com.discord.widgets.guilds.create.GuildTemplateChannelsView;
import com.discord.widgets.roles.RolesListView;
import com.google.android.material.textfield.TextInputLayout;
import p007b.p008a.p025i.C1038r0;

/* JADX INFO: loaded from: classes.dex */
public final class WidgetGuildCloneBinding implements ViewBinding {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final CoordinatorLayout f16751a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final LoadingButton f16752b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final AppViewFlipper f16753c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final LinkifiedTextView f16754d;

    /* JADX INFO: renamed from: e */
    @NonNull
    public final C1038r0 f16755e;

    /* JADX INFO: renamed from: f */
    @NonNull
    public final TextInputLayout f16756f;

    /* JADX INFO: renamed from: g */
    @NonNull
    public final TextView f16757g;

    /* JADX INFO: renamed from: h */
    @NonNull
    public final GuildTemplateChannelsView f16758h;

    /* JADX INFO: renamed from: i */
    @NonNull
    public final RolesListView f16759i;

    /* JADX INFO: renamed from: j */
    @NonNull
    public final LinearLayout f16760j;

    public WidgetGuildCloneBinding(@NonNull CoordinatorLayout coordinatorLayout, @NonNull LoadingButton loadingButton, @NonNull AppViewFlipper appViewFlipper, @NonNull LinkifiedTextView linkifiedTextView, @NonNull C1038r0 c1038r0, @NonNull TextInputLayout textInputLayout, @NonNull TextView textView, @NonNull TextView textView2, @NonNull GuildTemplateChannelsView guildTemplateChannelsView, @NonNull RolesListView rolesListView, @NonNull LinearLayout linearLayout, @NonNull ProgressBar progressBar) {
        this.f16751a = coordinatorLayout;
        this.f16752b = loadingButton;
        this.f16753c = appViewFlipper;
        this.f16754d = linkifiedTextView;
        this.f16755e = c1038r0;
        this.f16756f = textInputLayout;
        this.f16757g = textView2;
        this.f16758h = guildTemplateChannelsView;
        this.f16759i = rolesListView;
        this.f16760j = linearLayout;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f16751a;
    }
}
