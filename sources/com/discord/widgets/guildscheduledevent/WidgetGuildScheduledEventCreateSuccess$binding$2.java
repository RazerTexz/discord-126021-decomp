package com.discord.widgets.guildscheduledevent;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.discord.C5419R;
import com.discord.databinding.WidgetGuildScheduledEventCreateSuccessBinding;
import com.discord.views.CheckedSetting;
import com.google.android.material.button.MaterialButton;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetGuildScheduledEventCreateSuccess.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetGuildScheduledEventCreateSuccess$binding$2 extends C12236k implements Function1<View, WidgetGuildScheduledEventCreateSuccessBinding> {
    public static final WidgetGuildScheduledEventCreateSuccess$binding$2 INSTANCE = new WidgetGuildScheduledEventCreateSuccess$binding$2();

    public WidgetGuildScheduledEventCreateSuccess$binding$2() {
        super(1, WidgetGuildScheduledEventCreateSuccessBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetGuildScheduledEventCreateSuccessBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetGuildScheduledEventCreateSuccessBinding invoke(View view) {
        C12238m.checkNotNullParameter(view, "p1");
        int i = C5419R.id.close_button;
        ImageView imageView = (ImageView) view.findViewById(C5419R.id.close_button);
        if (imageView != null) {
            i = C5419R.id.guild_invite_link;
            TextView textView = (TextView) view.findViewById(C5419R.id.guild_invite_link);
            if (textView != null) {
                i = C5419R.id.guild_invite_never_expire;
                CheckedSetting checkedSetting = (CheckedSetting) view.findViewById(C5419R.id.guild_invite_never_expire);
                if (checkedSetting != null) {
                    i = C5419R.id.guild_invite_share_btn;
                    MaterialButton materialButton = (MaterialButton) view.findViewById(C5419R.id.guild_invite_share_btn);
                    if (materialButton != null) {
                        i = C5419R.id.guild_scheduled_event_success_image;
                        ImageView imageView2 = (ImageView) view.findViewById(C5419R.id.guild_scheduled_event_success_image);
                        if (imageView2 != null) {
                            i = C5419R.id.guild_scheduled_event_success_subtitle;
                            TextView textView2 = (TextView) view.findViewById(C5419R.id.guild_scheduled_event_success_subtitle);
                            if (textView2 != null) {
                                i = C5419R.id.guild_scheduled_event_success_title;
                                TextView textView3 = (TextView) view.findViewById(C5419R.id.guild_scheduled_event_success_title);
                                if (textView3 != null) {
                                    return new WidgetGuildScheduledEventCreateSuccessBinding((ConstraintLayout) view, imageView, textView, checkedSetting, materialButton, imageView2, textView2, textView3);
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
