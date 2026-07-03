package com.discord.widgets.channels.list;

import android.view.View;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import com.discord.C5419R;
import com.discord.databinding.WidgetChannelsListItemActionsBinding;
import com.facebook.drawee.view.SimpleDraweeView;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetChannelsListItemChannelActions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetChannelsListItemChannelActions$binding$2 extends C12236k implements Function1<View, WidgetChannelsListItemActionsBinding> {
    public static final WidgetChannelsListItemChannelActions$binding$2 INSTANCE = new WidgetChannelsListItemChannelActions$binding$2();

    public WidgetChannelsListItemChannelActions$binding$2() {
        super(1, WidgetChannelsListItemActionsBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetChannelsListItemActionsBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetChannelsListItemActionsBinding invoke(View view) {
        C12238m.checkNotNullParameter(view, "p1");
        int i = C5419R.id.action_channel_notifications;
        TextView textView = (TextView) view.findViewById(C5419R.id.action_channel_notifications);
        if (textView != null) {
            i = C5419R.id.action_channel_settings;
            TextView textView2 = (TextView) view.findViewById(C5419R.id.action_channel_settings);
            if (textView2 != null) {
                i = C5419R.id.action_copy_id;
                TextView textView3 = (TextView) view.findViewById(C5419R.id.action_copy_id);
                if (textView3 != null) {
                    i = C5419R.id.action_invite;
                    TextView textView4 = (TextView) view.findViewById(C5419R.id.action_invite);
                    if (textView4 != null) {
                        i = C5419R.id.channels_list_item_text_actions_icon;
                        SimpleDraweeView simpleDraweeView = (SimpleDraweeView) view.findViewById(C5419R.id.channels_list_item_text_actions_icon);
                        if (simpleDraweeView != null) {
                            i = C5419R.id.channels_list_item_text_actions_title;
                            TextView textView5 = (TextView) view.findViewById(C5419R.id.channels_list_item_text_actions_title);
                            if (textView5 != null) {
                                i = C5419R.id.developer_divider;
                                View viewFindViewById = view.findViewById(C5419R.id.developer_divider);
                                if (viewFindViewById != null) {
                                    i = C5419R.id.dm_action_profile;
                                    TextView textView6 = (TextView) view.findViewById(C5419R.id.dm_action_profile);
                                    if (textView6 != null) {
                                        i = C5419R.id.text_action_mark_as_read;
                                        TextView textView7 = (TextView) view.findViewById(C5419R.id.text_action_mark_as_read);
                                        if (textView7 != null) {
                                            i = C5419R.id.text_action_mute;
                                            TextView textView8 = (TextView) view.findViewById(C5419R.id.text_action_mute);
                                            if (textView8 != null) {
                                                i = C5419R.id.text_action_thread_browser;
                                                TextView textView9 = (TextView) view.findViewById(C5419R.id.text_action_thread_browser);
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
