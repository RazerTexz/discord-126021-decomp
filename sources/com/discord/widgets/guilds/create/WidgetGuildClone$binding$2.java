package com.discord.widgets.guilds.create;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.discord.C5419R;
import com.discord.app.AppViewFlipper;
import com.discord.databinding.WidgetGuildCloneBinding;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.views.LoadingButton;
import com.discord.widgets.roles.RolesListView;
import com.google.android.material.textfield.TextInputLayout;
import kotlin.jvm.functions.Function1;
import p007b.p008a.p025i.C1038r0;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetGuildClone.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetGuildClone$binding$2 extends C12236k implements Function1<View, WidgetGuildCloneBinding> {
    public static final WidgetGuildClone$binding$2 INSTANCE = new WidgetGuildClone$binding$2();

    public WidgetGuildClone$binding$2() {
        super(1, WidgetGuildCloneBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetGuildCloneBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetGuildCloneBinding invoke(View view) {
        C12238m.checkNotNullParameter(view, "p1");
        int i = C5419R.id.guild_create_button;
        LoadingButton loadingButton = (LoadingButton) view.findViewById(C5419R.id.guild_create_button);
        if (loadingButton != null) {
            i = C5419R.id.guild_create_flipper;
            AppViewFlipper appViewFlipper = (AppViewFlipper) view.findViewById(C5419R.id.guild_create_flipper);
            if (appViewFlipper != null) {
                i = C5419R.id.guild_create_guidelines;
                LinkifiedTextView linkifiedTextView = (LinkifiedTextView) view.findViewById(C5419R.id.guild_create_guidelines);
                if (linkifiedTextView != null) {
                    i = C5419R.id.guild_create_icon_uploader;
                    View viewFindViewById = view.findViewById(C5419R.id.guild_create_icon_uploader);
                    if (viewFindViewById != null) {
                        C1038r0 c1038r0M204a = C1038r0.m204a(viewFindViewById);
                        i = C5419R.id.guild_create_name;
                        TextInputLayout textInputLayout = (TextInputLayout) view.findViewById(C5419R.id.guild_create_name);
                        if (textInputLayout != null) {
                            i = C5419R.id.guild_create_protip;
                            TextView textView = (TextView) view.findViewById(C5419R.id.guild_create_protip);
                            if (textView != null) {
                                i = C5419R.id.guild_template_name;
                                TextView textView2 = (TextView) view.findViewById(C5419R.id.guild_template_name);
                                if (textView2 != null) {
                                    i = C5419R.id.guild_template_preview_channels;
                                    GuildTemplateChannelsView guildTemplateChannelsView = (GuildTemplateChannelsView) view.findViewById(C5419R.id.guild_template_preview_channels);
                                    if (guildTemplateChannelsView != null) {
                                        i = C5419R.id.guild_template_preview_roles;
                                        RolesListView rolesListView = (RolesListView) view.findViewById(C5419R.id.guild_template_preview_roles);
                                        if (rolesListView != null) {
                                            i = C5419R.id.guild_template_preview_roles_layout;
                                            LinearLayout linearLayout = (LinearLayout) view.findViewById(C5419R.id.guild_template_preview_roles_layout);
                                            if (linearLayout != null) {
                                                i = C5419R.id.loading_button_progress;
                                                ProgressBar progressBar = (ProgressBar) view.findViewById(C5419R.id.loading_button_progress);
                                                if (progressBar != null) {
                                                    return new WidgetGuildCloneBinding((CoordinatorLayout) view, loadingButton, appViewFlipper, linkifiedTextView, c1038r0M204a, textInputLayout, textView, textView2, guildTemplateChannelsView, rolesListView, linearLayout, progressBar);
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
