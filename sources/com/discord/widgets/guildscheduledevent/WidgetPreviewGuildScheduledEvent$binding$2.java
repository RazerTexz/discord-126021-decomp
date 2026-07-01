package com.discord.widgets.guildscheduledevent;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.discord.R$id;
import com.discord.databinding.WidgetPreviewGuildScheduledEventBinding;
import com.discord.views.CheckedSetting;
import com.google.android.material.button.MaterialButton;
import d0.z.d.k;
import d0.z.d.m;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetPreviewGuildScheduledEvent.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetPreviewGuildScheduledEvent$binding$2 extends k implements Function1<View, WidgetPreviewGuildScheduledEventBinding> {
    public static final WidgetPreviewGuildScheduledEvent$binding$2 INSTANCE = new WidgetPreviewGuildScheduledEvent$binding$2();

    public WidgetPreviewGuildScheduledEvent$binding$2() {
        super(1, WidgetPreviewGuildScheduledEventBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetPreviewGuildScheduledEventBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetPreviewGuildScheduledEventBinding invoke(View view) {
        return invoke2(view);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetPreviewGuildScheduledEventBinding invoke2(View view) {
        m.checkNotNullParameter(view, "p1");
        int i = R$id.back_button;
        ImageView imageView = (ImageView) view.findViewById(R$id.back_button);
        if (imageView != null) {
            i = R$id.close_button;
            ImageView imageView2 = (ImageView) view.findViewById(R$id.close_button);
            if (imageView2 != null) {
                i = R$id.confirm_guild_scheduled_event_notify;
                CheckedSetting checkedSetting = (CheckedSetting) view.findViewById(R$id.confirm_guild_scheduled_event_notify);
                if (checkedSetting != null) {
                    i = R$id.confirm_guild_scheduled_event_preview;
                    GuildScheduledEventItemView guildScheduledEventItemView = (GuildScheduledEventItemView) view.findViewById(R$id.confirm_guild_scheduled_event_preview);
                    if (guildScheduledEventItemView != null) {
                        i = R$id.confirm_guild_scheduled_event_subtitle;
                        TextView textView = (TextView) view.findViewById(R$id.confirm_guild_scheduled_event_subtitle);
                        if (textView != null) {
                            i = R$id.confirm_guild_scheduled_event_title;
                            TextView textView2 = (TextView) view.findViewById(R$id.confirm_guild_scheduled_event_title);
                            if (textView2 != null) {
                                i = R$id.confirm_guild_scheduled_event_toolbar;
                                ConstraintLayout constraintLayout = (ConstraintLayout) view.findViewById(R$id.confirm_guild_scheduled_event_toolbar);
                                if (constraintLayout != null) {
                                    i = R$id.create_event_subtitle;
                                    TextView textView3 = (TextView) view.findViewById(R$id.create_event_subtitle);
                                    if (textView3 != null) {
                                        i = R$id.guild_scheduled_event_settings_next_button;
                                        MaterialButton materialButton = (MaterialButton) view.findViewById(R$id.guild_scheduled_event_settings_next_button);
                                        if (materialButton != null) {
                                            i = R$id.step_text;
                                            TextView textView4 = (TextView) view.findViewById(R$id.step_text);
                                            if (textView4 != null) {
                                                return new WidgetPreviewGuildScheduledEventBinding((ConstraintLayout) view, imageView, imageView2, checkedSetting, guildScheduledEventItemView, textView, textView2, constraintLayout, textView3, materialButton, textView4);
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
