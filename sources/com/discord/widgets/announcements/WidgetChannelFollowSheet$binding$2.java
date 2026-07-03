package com.discord.widgets.announcements;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import com.discord.C5419R;
import com.discord.app.AppViewFlipper;
import com.discord.databinding.WidgetChannelFollowSheetBinding;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.card.MaterialCardView;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetChannelFollowSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetChannelFollowSheet$binding$2 extends C12236k implements Function1<View, WidgetChannelFollowSheetBinding> {
    public static final WidgetChannelFollowSheet$binding$2 INSTANCE = new WidgetChannelFollowSheet$binding$2();

    public WidgetChannelFollowSheet$binding$2() {
        super(1, WidgetChannelFollowSheetBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetChannelFollowSheetBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetChannelFollowSheetBinding invoke(View view) {
        C12238m.checkNotNullParameter(view, "p1");
        int i = C5419R.id.channel_follow_channel_dropdown_icon;
        ImageView imageView = (ImageView) view.findViewById(C5419R.id.channel_follow_channel_dropdown_icon);
        if (imageView != null) {
            i = C5419R.id.channel_follow_channel_name;
            TextView textView = (TextView) view.findViewById(C5419R.id.channel_follow_channel_name);
            if (textView != null) {
                i = C5419R.id.channel_follow_error_text;
                TextView textView2 = (TextView) view.findViewById(C5419R.id.channel_follow_error_text);
                if (textView2 != null) {
                    i = C5419R.id.channel_follow_guild_dropdown_icon;
                    ImageView imageView2 = (ImageView) view.findViewById(C5419R.id.channel_follow_guild_dropdown_icon);
                    if (imageView2 != null) {
                        i = C5419R.id.channel_follow_guild_icon;
                        SimpleDraweeView simpleDraweeView = (SimpleDraweeView) view.findViewById(C5419R.id.channel_follow_guild_icon);
                        if (simpleDraweeView != null) {
                            i = C5419R.id.channel_follow_select_channel;
                            MaterialCardView materialCardView = (MaterialCardView) view.findViewById(C5419R.id.channel_follow_select_channel);
                            if (materialCardView != null) {
                                i = C5419R.id.channel_follow_select_guild;
                                MaterialCardView materialCardView2 = (MaterialCardView) view.findViewById(C5419R.id.channel_follow_select_guild);
                                if (materialCardView2 != null) {
                                    i = C5419R.id.channel_follow_selected_channel_name;
                                    TextView textView3 = (TextView) view.findViewById(C5419R.id.channel_follow_selected_channel_name);
                                    if (textView3 != null) {
                                        i = C5419R.id.channel_follow_selected_guild_name;
                                        TextView textView4 = (TextView) view.findViewById(C5419R.id.channel_follow_selected_guild_name);
                                        if (textView4 != null) {
                                            i = C5419R.id.create_channel_follower_button;
                                            MaterialButton materialButton = (MaterialButton) view.findViewById(C5419R.id.create_channel_follower_button);
                                            if (materialButton != null) {
                                                i = C5419R.id.follow_sheet_view_flipper;
                                                AppViewFlipper appViewFlipper = (AppViewFlipper) view.findViewById(C5419R.id.follow_sheet_view_flipper);
                                                if (appViewFlipper != null) {
                                                    return new WidgetChannelFollowSheetBinding((NestedScrollView) view, imageView, textView, textView2, imageView2, simpleDraweeView, materialCardView, materialCardView2, textView3, textView4, materialButton, appViewFlipper);
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
