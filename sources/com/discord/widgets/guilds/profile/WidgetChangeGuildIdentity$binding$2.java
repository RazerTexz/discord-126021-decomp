package com.discord.widgets.guilds.profile;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.discord.R$id;
import com.discord.databinding.WidgetChangeGuildIdentityBinding;
import com.discord.utilities.dimmer.DimmerView;
import com.discord.views.premium.ShinyButton;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputLayout;
import d0.z.d.k;
import d0.z.d.m;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetChangeGuildIdentity.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetChangeGuildIdentity$binding$2 extends k implements Function1<View, WidgetChangeGuildIdentityBinding> {
    public static final WidgetChangeGuildIdentity$binding$2 INSTANCE = new WidgetChangeGuildIdentity$binding$2();

    public WidgetChangeGuildIdentity$binding$2() {
        super(1, WidgetChangeGuildIdentityBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetChangeGuildIdentityBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetChangeGuildIdentityBinding invoke(View view) {
        return invoke2(view);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetChangeGuildIdentityBinding invoke2(View view) {
        m.checkNotNullParameter(view, "p1");
        int i = R$id.avatar_header;
        TextView textView = (TextView) view.findViewById(R$id.avatar_header);
        if (textView != null) {
            i = R$id.banner_edit;
            CardView cardView = (CardView) view.findViewById(R$id.banner_edit);
            if (cardView != null) {
                i = 2131363051;
                DimmerView dimmerView = (DimmerView) view.findViewById(2131363051);
                if (dimmerView != null) {
                    i = R$id.get_premium_button;
                    ShinyButton shinyButton = (ShinyButton) view.findViewById(R$id.get_premium_button);
                    if (shinyButton != null) {
                        i = R$id.guild_avatar;
                        SimpleDraweeView simpleDraweeView = (SimpleDraweeView) view.findViewById(R$id.guild_avatar);
                        if (simpleDraweeView != null) {
                            i = R$id.guild_avatar_card;
                            CardView cardView2 = (CardView) view.findViewById(R$id.guild_avatar_card);
                            if (cardView2 != null) {
                                i = R$id.guild_avatar_container;
                                RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R$id.guild_avatar_container);
                                if (relativeLayout != null) {
                                    i = R$id.nickname_editor_card;
                                    CardView cardView3 = (CardView) view.findViewById(R$id.nickname_editor_card);
                                    if (cardView3 != null) {
                                        i = R$id.save_fab;
                                        FloatingActionButton floatingActionButton = (FloatingActionButton) view.findViewById(R$id.save_fab);
                                        if (floatingActionButton != null) {
                                            i = R$id.set_nickname_text;
                                            TextInputLayout textInputLayout = (TextInputLayout) view.findViewById(R$id.set_nickname_text);
                                            if (textInputLayout != null) {
                                                i = R$id.upsell_section;
                                                LinearLayout linearLayout = (LinearLayout) view.findViewById(R$id.upsell_section);
                                                if (linearLayout != null) {
                                                    return new WidgetChangeGuildIdentityBinding((CoordinatorLayout) view, textView, cardView, dimmerView, shinyButton, simpleDraweeView, cardView2, relativeLayout, cardView3, floatingActionButton, textInputLayout, linearLayout);
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
