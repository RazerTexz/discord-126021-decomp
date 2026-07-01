package com.discord.widgets.guilds.profile;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.discord.R;
import com.discord.databinding.WidgetChangeGuildIdentityBinding;
import com.discord.utilities.dimmer.DimmerView;
import com.discord.views.premium.ShinyButton;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputLayout;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: com.discord.widgets.guilds.profile.WidgetChangeGuildIdentity$binding$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetChangeGuildIdentity.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetChangeGuildIdentity3 extends FunctionReferenceImpl implements Function1<View, WidgetChangeGuildIdentityBinding> {
    public static final WidgetChangeGuildIdentity3 INSTANCE = new WidgetChangeGuildIdentity3();

    public WidgetChangeGuildIdentity3() {
        super(1, WidgetChangeGuildIdentityBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetChangeGuildIdentityBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetChangeGuildIdentityBinding invoke(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = R.id.avatar_header;
        TextView textView = (TextView) view.findViewById(R.id.avatar_header);
        if (textView != null) {
            i = R.id.banner_edit;
            CardView cardView = (CardView) view.findViewById(R.id.banner_edit);
            if (cardView != null) {
                i = R.id.dimmer_view;
                DimmerView dimmerView = (DimmerView) view.findViewById(R.id.dimmer_view);
                if (dimmerView != null) {
                    i = R.id.get_premium_button;
                    ShinyButton shinyButton = (ShinyButton) view.findViewById(R.id.get_premium_button);
                    if (shinyButton != null) {
                        i = R.id.guild_avatar;
                        SimpleDraweeView simpleDraweeView = (SimpleDraweeView) view.findViewById(R.id.guild_avatar);
                        if (simpleDraweeView != null) {
                            i = R.id.guild_avatar_card;
                            CardView cardView2 = (CardView) view.findViewById(R.id.guild_avatar_card);
                            if (cardView2 != null) {
                                i = R.id.guild_avatar_container;
                                RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.guild_avatar_container);
                                if (relativeLayout != null) {
                                    i = R.id.nickname_editor_card;
                                    CardView cardView3 = (CardView) view.findViewById(R.id.nickname_editor_card);
                                    if (cardView3 != null) {
                                        i = R.id.save_fab;
                                        FloatingActionButton floatingActionButton = (FloatingActionButton) view.findViewById(R.id.save_fab);
                                        if (floatingActionButton != null) {
                                            i = R.id.set_nickname_text;
                                            TextInputLayout textInputLayout = (TextInputLayout) view.findViewById(R.id.set_nickname_text);
                                            if (textInputLayout != null) {
                                                i = R.id.upsell_section;
                                                LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.upsell_section);
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
