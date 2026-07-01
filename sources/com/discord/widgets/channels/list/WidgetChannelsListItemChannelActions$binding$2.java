package com.discord.widgets.channels.list;

import android.view.View;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import com.discord.R$id;
import com.discord.databinding.WidgetChannelsListItemActionsBinding;
import com.facebook.drawee.view.SimpleDraweeView;
import d0.z.d.k;
import d0.z.d.m;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetChannelsListItemChannelActions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetChannelsListItemChannelActions$binding$2 extends k implements Function1<View, WidgetChannelsListItemActionsBinding> {
    public static final WidgetChannelsListItemChannelActions$binding$2 INSTANCE = new WidgetChannelsListItemChannelActions$binding$2();

    public WidgetChannelsListItemChannelActions$binding$2() {
        super(1, WidgetChannelsListItemActionsBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetChannelsListItemActionsBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetChannelsListItemActionsBinding invoke(View view) {
        return invoke2(view);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetChannelsListItemActionsBinding invoke2(View view) {
        m.checkNotNullParameter(view, "p1");
        int i = R$id.action_channel_notifications;
        TextView textView = (TextView) view.findViewById(R$id.action_channel_notifications);
        if (textView != null) {
            i = R$id.action_channel_settings;
            TextView textView2 = (TextView) view.findViewById(R$id.action_channel_settings);
            if (textView2 != null) {
                i = R$id.action_copy_id;
                TextView textView3 = (TextView) view.findViewById(R$id.action_copy_id);
                if (textView3 != null) {
                    i = R$id.action_invite;
                    TextView textView4 = (TextView) view.findViewById(R$id.action_invite);
                    if (textView4 != null) {
                        i = R$id.channels_list_item_text_actions_icon;
                        SimpleDraweeView simpleDraweeView = (SimpleDraweeView) view.findViewById(R$id.channels_list_item_text_actions_icon);
                        if (simpleDraweeView != null) {
                            i = R$id.channels_list_item_text_actions_title;
                            TextView textView5 = (TextView) view.findViewById(R$id.channels_list_item_text_actions_title);
                            if (textView5 != null) {
                                i = R$id.developer_divider;
                                View viewFindViewById = view.findViewById(R$id.developer_divider);
                                if (viewFindViewById != null) {
                                    i = R$id.dm_action_profile;
                                    TextView textView6 = (TextView) view.findViewById(R$id.dm_action_profile);
                                    if (textView6 != null) {
                                        i = R$id.text_action_mark_as_read;
                                        TextView textView7 = (TextView) view.findViewById(R$id.text_action_mark_as_read);
                                        if (textView7 != null) {
                                            i = R$id.text_action_mute;
                                            TextView textView8 = (TextView) view.findViewById(R$id.text_action_mute);
                                            if (textView8 != null) {
                                                i = R$id.text_action_thread_browser;
                                                TextView textView9 = (TextView) view.findViewById(R$id.text_action_thread_browser);
                                                if (textView9 != null) {
                                                    return new WidgetChannelsListItemActionsBinding((NestedScrollView) view, textView, textView2, textView3, textView4, simpleDraweeView, textView5, viewFindViewById, textView6, textView7, textView8, textView9);
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
