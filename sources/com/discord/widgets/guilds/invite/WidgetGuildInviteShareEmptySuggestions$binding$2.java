package com.discord.widgets.guilds.invite;

import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.discord.R$id;
import com.discord.databinding.WidgetGuildInviteShareEmptySuggestionsBinding;
import com.google.android.material.button.MaterialButton;
import d0.z.d.k;
import d0.z.d.m;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetGuildInviteShareEmptySuggestions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetGuildInviteShareEmptySuggestions$binding$2 extends k implements Function1<View, WidgetGuildInviteShareEmptySuggestionsBinding> {
    public static final WidgetGuildInviteShareEmptySuggestions$binding$2 INSTANCE = new WidgetGuildInviteShareEmptySuggestions$binding$2();

    public WidgetGuildInviteShareEmptySuggestions$binding$2() {
        super(1, WidgetGuildInviteShareEmptySuggestionsBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetGuildInviteShareEmptySuggestionsBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetGuildInviteShareEmptySuggestionsBinding invoke(View view) {
        return invoke2(view);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetGuildInviteShareEmptySuggestionsBinding invoke2(View view) {
        m.checkNotNullParameter(view, "p1");
        int i = R$id.bottom_sheet_tint;
        View viewFindViewById = view.findViewById(R$id.bottom_sheet_tint);
        if (viewFindViewById != null) {
            i = R$id.guild_invite_empty_suggestions_invite_link;
            TextView textView = (TextView) view.findViewById(R$id.guild_invite_empty_suggestions_invite_link);
            if (textView != null) {
                i = R$id.guild_invite_empty_suggestions_invite_share_btn;
                MaterialButton materialButton = (MaterialButton) view.findViewById(R$id.guild_invite_empty_suggestions_invite_share_btn);
                if (materialButton != null) {
                    i = R$id.guild_invite_empty_suggestions_settings_edit;
                    ImageButton imageButton = (ImageButton) view.findViewById(R$id.guild_invite_empty_suggestions_settings_edit);
                    if (imageButton != null) {
                        i = R$id.guild_invite_empty_suggestions_settings_invite_link_subtext;
                        TextView textView2 = (TextView) view.findViewById(R$id.guild_invite_empty_suggestions_settings_invite_link_subtext);
                        if (textView2 != null) {
                            i = R$id.invite_settings_bottom_sheet;
                            ViewInviteSettingsSheet viewInviteSettingsSheet = (ViewInviteSettingsSheet) view.findViewById(R$id.invite_settings_bottom_sheet);
                            if (viewInviteSettingsSheet != null) {
                                return new WidgetGuildInviteShareEmptySuggestionsBinding((CoordinatorLayout) view, viewFindViewById, textView, materialButton, imageButton, textView2, viewInviteSettingsSheet);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
