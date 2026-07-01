package com.discord.widgets.guilds;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.discord.R$id;
import com.discord.databinding.WidgetGuildFolderSettingsBinding;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputLayout;
import d0.z.d.k;
import d0.z.d.m;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetGuildFolderSettings.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetGuildFolderSettings$binding$2 extends k implements Function1<View, WidgetGuildFolderSettingsBinding> {
    public static final WidgetGuildFolderSettings$binding$2 INSTANCE = new WidgetGuildFolderSettings$binding$2();

    public WidgetGuildFolderSettings$binding$2() {
        super(1, WidgetGuildFolderSettingsBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetGuildFolderSettingsBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetGuildFolderSettingsBinding invoke(View view) {
        return invoke2(view);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetGuildFolderSettingsBinding invoke2(View view) {
        m.checkNotNullParameter(view, "p1");
        int i = R$id.edit_guild_folder_name;
        TextInputLayout textInputLayout = (TextInputLayout) view.findViewById(R$id.edit_guild_folder_name);
        if (textInputLayout != null) {
            i = R$id.guild_folder_color_name;
            TextView textView = (TextView) view.findViewById(R$id.guild_folder_color_name);
            if (textView != null) {
                i = R$id.guild_folder_settings_color;
                RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R$id.guild_folder_settings_color);
                if (relativeLayout != null) {
                    i = R$id.guild_folder_settings_color_display;
                    View viewFindViewById = view.findViewById(R$id.guild_folder_settings_color_display);
                    if (viewFindViewById != null) {
                        i = R$id.guild_folder_settings_save;
                        FloatingActionButton floatingActionButton = (FloatingActionButton) view.findViewById(R$id.guild_folder_settings_save);
                        if (floatingActionButton != null) {
                            return new WidgetGuildFolderSettingsBinding((CoordinatorLayout) view, textInputLayout, textView, relativeLayout, viewFindViewById, floatingActionButton);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
