package com.discord.widgets.guilds;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.discord.C5419R;
import com.discord.databinding.WidgetGuildFolderSettingsBinding;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputLayout;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetGuildFolderSettings.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetGuildFolderSettings$binding$2 extends C12236k implements Function1<View, WidgetGuildFolderSettingsBinding> {
    public static final WidgetGuildFolderSettings$binding$2 INSTANCE = new WidgetGuildFolderSettings$binding$2();

    public WidgetGuildFolderSettings$binding$2() {
        super(1, WidgetGuildFolderSettingsBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetGuildFolderSettingsBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetGuildFolderSettingsBinding invoke(View view) {
        C12238m.checkNotNullParameter(view, "p1");
        int i = C5419R.id.edit_guild_folder_name;
        TextInputLayout textInputLayout = (TextInputLayout) view.findViewById(C5419R.id.edit_guild_folder_name);
        if (textInputLayout != null) {
            i = C5419R.id.guild_folder_color_name;
            TextView textView = (TextView) view.findViewById(C5419R.id.guild_folder_color_name);
            if (textView != null) {
                i = C5419R.id.guild_folder_settings_color;
                RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(C5419R.id.guild_folder_settings_color);
                if (relativeLayout != null) {
                    i = C5419R.id.guild_folder_settings_color_display;
                    View viewFindViewById = view.findViewById(C5419R.id.guild_folder_settings_color_display);
                    if (viewFindViewById != null) {
                        i = C5419R.id.guild_folder_settings_save;
                        FloatingActionButton floatingActionButton = (FloatingActionButton) view.findViewById(C5419R.id.guild_folder_settings_save);
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
