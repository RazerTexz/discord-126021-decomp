package com.discord.widgets.guilds.invite;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.R$id;
import com.discord.app.AppViewFlipper;
import com.discord.databinding.WidgetGuildInviteShareCompactBinding;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputLayout;
import d0.z.d.k;
import d0.z.d.m;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetGuildInviteShareCompact.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetGuildInviteShareCompact$binding$2 extends k implements Function1<View, WidgetGuildInviteShareCompactBinding> {
    public static final WidgetGuildInviteShareCompact$binding$2 INSTANCE = new WidgetGuildInviteShareCompact$binding$2();

    public WidgetGuildInviteShareCompact$binding$2() {
        super(1, WidgetGuildInviteShareCompactBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetGuildInviteShareCompactBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetGuildInviteShareCompactBinding invoke(View view) {
        return invoke2(view);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetGuildInviteShareCompactBinding invoke2(View view) {
        m.checkNotNullParameter(view, "p1");
        int i = R$id.bottom_sheet_tint;
        View viewFindViewById = view.findViewById(R$id.bottom_sheet_tint);
        if (viewFindViewById != null) {
            i = R$id.guild_invite_empty_results;
            TextView textView = (TextView) view.findViewById(R$id.guild_invite_empty_results);
            if (textView != null) {
                i = R$id.guild_invite_never_expire;
                TextView textView2 = (TextView) view.findViewById(R$id.guild_invite_never_expire);
                if (textView2 != null) {
                    i = R$id.guild_invite_settings_edit;
                    ImageView imageView = (ImageView) view.findViewById(R$id.guild_invite_settings_edit);
                    if (imageView != null) {
                        i = R$id.guild_invite_share_btn;
                        MaterialButton materialButton = (MaterialButton) view.findViewById(R$id.guild_invite_share_btn);
                        if (materialButton != null) {
                            i = R$id.guild_invite_share_compact_search;
                            TextInputLayout textInputLayout = (TextInputLayout) view.findViewById(R$id.guild_invite_share_compact_search);
                            if (textInputLayout != null) {
                                i = R$id.guild_invite_suggestion_list;
                                RecyclerView recyclerView = (RecyclerView) view.findViewById(R$id.guild_invite_suggestion_list);
                                if (recyclerView != null) {
                                    i = R$id.guild_invite_suggestions_flipper;
                                    AppViewFlipper appViewFlipper = (AppViewFlipper) view.findViewById(R$id.guild_invite_suggestions_flipper);
                                    if (appViewFlipper != null) {
                                        i = R$id.invite_settings_bottom_sheet;
                                        ViewInviteSettingsSheet viewInviteSettingsSheet = (ViewInviteSettingsSheet) view.findViewById(R$id.invite_settings_bottom_sheet);
                                        if (viewInviteSettingsSheet != null) {
                                            return new WidgetGuildInviteShareCompactBinding((CoordinatorLayout) view, viewFindViewById, textView, textView2, imageView, materialButton, textInputLayout, recyclerView, appViewFlipper, viewInviteSettingsSheet);
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
