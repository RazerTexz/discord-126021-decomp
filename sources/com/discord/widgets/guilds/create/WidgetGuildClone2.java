package com.discord.widgets.guilds.create;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import b.a.i.LayoutIconUploaderBinding;
import com.discord.R;
import com.discord.app.AppViewFlipper;
import com.discord.databinding.WidgetGuildCloneBinding;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.views.LoadingButton;
import com.discord.widgets.roles.RolesListView;
import com.google.android.material.textfield.TextInputLayout;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: com.discord.widgets.guilds.create.WidgetGuildClone$binding$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetGuildClone.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetGuildClone2 extends FunctionReferenceImpl implements Function1<View, WidgetGuildCloneBinding> {
    public static final WidgetGuildClone2 INSTANCE = new WidgetGuildClone2();

    public WidgetGuildClone2() {
        super(1, WidgetGuildCloneBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetGuildCloneBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetGuildCloneBinding invoke(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = R.id.guild_create_button;
        LoadingButton loadingButton = (LoadingButton) view.findViewById(R.id.guild_create_button);
        if (loadingButton != null) {
            i = R.id.guild_create_flipper;
            AppViewFlipper appViewFlipper = (AppViewFlipper) view.findViewById(R.id.guild_create_flipper);
            if (appViewFlipper != null) {
                i = R.id.guild_create_guidelines;
                LinkifiedTextView linkifiedTextView = (LinkifiedTextView) view.findViewById(R.id.guild_create_guidelines);
                if (linkifiedTextView != null) {
                    i = R.id.guild_create_icon_uploader;
                    View viewFindViewById = view.findViewById(R.id.guild_create_icon_uploader);
                    if (viewFindViewById != null) {
                        LayoutIconUploaderBinding layoutIconUploaderBindingA = LayoutIconUploaderBinding.a(viewFindViewById);
                        i = R.id.guild_create_name;
                        TextInputLayout textInputLayout = (TextInputLayout) view.findViewById(R.id.guild_create_name);
                        if (textInputLayout != null) {
                            i = R.id.guild_create_protip;
                            TextView textView = (TextView) view.findViewById(R.id.guild_create_protip);
                            if (textView != null) {
                                i = R.id.guild_template_name;
                                TextView textView2 = (TextView) view.findViewById(R.id.guild_template_name);
                                if (textView2 != null) {
                                    i = R.id.guild_template_preview_channels;
                                    GuildTemplateChannelsView guildTemplateChannelsView = (GuildTemplateChannelsView) view.findViewById(R.id.guild_template_preview_channels);
                                    if (guildTemplateChannelsView != null) {
                                        i = R.id.guild_template_preview_roles;
                                        RolesListView rolesListView = (RolesListView) view.findViewById(R.id.guild_template_preview_roles);
                                        if (rolesListView != null) {
                                            i = R.id.guild_template_preview_roles_layout;
                                            LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.guild_template_preview_roles_layout);
                                            if (linearLayout != null) {
                                                i = R.id.loading_button_progress;
                                                ProgressBar progressBar = (ProgressBar) view.findViewById(R.id.loading_button_progress);
                                                if (progressBar != null) {
                                                    return new WidgetGuildCloneBinding((CoordinatorLayout) view, loadingButton, appViewFlipper, linkifiedTextView, layoutIconUploaderBindingA, textInputLayout, textView, textView2, guildTemplateChannelsView, rolesListView, linearLayout, progressBar);
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
