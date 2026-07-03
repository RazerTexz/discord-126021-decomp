package com.discord.widgets.guilds.invite;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.C5419R;
import com.discord.app.AppViewFlipper;
import com.discord.databinding.WidgetGuildInviteShareBinding;
import com.discord.views.CheckedSetting;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputLayout;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetGuildInviteShare.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetGuildInviteShare$binding$2 extends C12236k implements Function1<View, WidgetGuildInviteShareBinding> {
    public static final WidgetGuildInviteShare$binding$2 INSTANCE = new WidgetGuildInviteShare$binding$2();

    public WidgetGuildInviteShare$binding$2() {
        super(1, WidgetGuildInviteShareBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetGuildInviteShareBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetGuildInviteShareBinding invoke(View view) {
        C12238m.checkNotNullParameter(view, "p1");
        int i = C5419R.id.bottom_sheet_tint;
        View viewFindViewById = view.findViewById(C5419R.id.bottom_sheet_tint);
        if (viewFindViewById != null) {
            i = C5419R.id.guild_invite_empty_results;
            TextView textView = (TextView) view.findViewById(C5419R.id.guild_invite_empty_results);
            if (textView != null) {
                i = C5419R.id.guild_invite_link;
                TextView textView2 = (TextView) view.findViewById(C5419R.id.guild_invite_link);
                if (textView2 != null) {
                    i = C5419R.id.guild_invite_never_expire;
                    CheckedSetting checkedSetting = (CheckedSetting) view.findViewById(C5419R.id.guild_invite_never_expire);
                    if (checkedSetting != null) {
                        i = C5419R.id.guild_invite_settings_edit;
                        ImageView imageView = (ImageView) view.findViewById(C5419R.id.guild_invite_settings_edit);
                        if (imageView != null) {
                            i = C5419R.id.guild_invite_share_btn;
                            MaterialButton materialButton = (MaterialButton) view.findViewById(C5419R.id.guild_invite_share_btn);
                            if (materialButton != null) {
                                i = C5419R.id.guild_invite_share_search;
                                TextInputLayout textInputLayout = (TextInputLayout) view.findViewById(C5419R.id.guild_invite_share_search);
                                if (textInputLayout != null) {
                                    i = C5419R.id.guild_invite_suggestion_list;
                                    RecyclerView recyclerView = (RecyclerView) view.findViewById(C5419R.id.guild_invite_suggestion_list);
                                    if (recyclerView != null) {
                                        i = C5419R.id.guild_invite_suggestions_flipper;
                                        AppViewFlipper appViewFlipper = (AppViewFlipper) view.findViewById(C5419R.id.guild_invite_suggestions_flipper);
                                        if (appViewFlipper != null) {
                                            i = C5419R.id.invite_settings_bottom_sheet;
                                            ViewInviteSettingsSheet viewInviteSettingsSheet = (ViewInviteSettingsSheet) view.findViewById(C5419R.id.invite_settings_bottom_sheet);
                                            if (viewInviteSettingsSheet != null) {
                                                return new WidgetGuildInviteShareBinding((CoordinatorLayout) view, viewFindViewById, textView, textView2, checkedSetting, imageView, materialButton, textInputLayout, recyclerView, appViewFlipper, viewInviteSettingsSheet);
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
