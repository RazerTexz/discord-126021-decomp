package com.discord.widgets.channels.list;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import com.discord.C5419R;
import com.discord.databinding.WidgetChannelsListItemThreadActionsBinding;
import com.facebook.drawee.view.SimpleDraweeView;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetChannelsListItemThreadActions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetChannelsListItemThreadActions$binding$2 extends C12236k implements Function1<View, WidgetChannelsListItemThreadActionsBinding> {
    public static final WidgetChannelsListItemThreadActions$binding$2 INSTANCE = new WidgetChannelsListItemThreadActions$binding$2();

    public WidgetChannelsListItemThreadActions$binding$2() {
        super(1, WidgetChannelsListItemThreadActionsBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetChannelsListItemThreadActionsBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetChannelsListItemThreadActionsBinding invoke(View view) {
        C12238m.checkNotNullParameter(view, "p1");
        int i = C5419R.id.channels_list_item_thread_actions_archive_settings;
        LinearLayout linearLayout = (LinearLayout) view.findViewById(C5419R.id.channels_list_item_thread_actions_archive_settings);
        if (linearLayout != null) {
            i = C5419R.id.channels_list_item_thread_actions_archive_settings_header;
            TextView textView = (TextView) view.findViewById(C5419R.id.channels_list_item_thread_actions_archive_settings_header);
            if (textView != null) {
                i = C5419R.id.channels_list_item_thread_actions_archive_settings_subheader;
                TextView textView2 = (TextView) view.findViewById(C5419R.id.channels_list_item_thread_actions_archive_settings_subheader);
                if (textView2 != null) {
                    i = C5419R.id.channels_list_item_thread_actions_channel_notifications;
                    TextView textView3 = (TextView) view.findViewById(C5419R.id.channels_list_item_thread_actions_channel_notifications);
                    if (textView3 != null) {
                        i = C5419R.id.channels_list_item_thread_actions_copy_id;
                        TextView textView4 = (TextView) view.findViewById(C5419R.id.channels_list_item_thread_actions_copy_id);
                        if (textView4 != null) {
                            i = C5419R.id.channels_list_item_thread_actions_developer_divider;
                            View viewFindViewById = view.findViewById(C5419R.id.channels_list_item_thread_actions_developer_divider);
                            if (viewFindViewById != null) {
                                i = C5419R.id.channels_list_item_thread_actions_divider;
                                View viewFindViewById2 = view.findViewById(C5419R.id.channels_list_item_thread_actions_divider);
                                if (viewFindViewById2 != null) {
                                    i = C5419R.id.channels_list_item_thread_actions_edit;
                                    TextView textView5 = (TextView) view.findViewById(C5419R.id.channels_list_item_thread_actions_edit);
                                    if (textView5 != null) {
                                        i = C5419R.id.channels_list_item_thread_actions_icon;
                                        SimpleDraweeView simpleDraweeView = (SimpleDraweeView) view.findViewById(C5419R.id.channels_list_item_thread_actions_icon);
                                        if (simpleDraweeView != null) {
                                            i = C5419R.id.channels_list_item_thread_actions_leave;
                                            TextView textView6 = (TextView) view.findViewById(C5419R.id.channels_list_item_thread_actions_leave);
                                            if (textView6 != null) {
                                                i = C5419R.id.channels_list_item_thread_actions_mark_as_read;
                                                TextView textView7 = (TextView) view.findViewById(C5419R.id.channels_list_item_thread_actions_mark_as_read);
                                                if (textView7 != null) {
                                                    i = C5419R.id.channels_list_item_thread_actions_mute;
                                                    TextView textView8 = (TextView) view.findViewById(C5419R.id.channels_list_item_thread_actions_mute);
                                                    if (textView8 != null) {
                                                        i = C5419R.id.channels_list_item_thread_actions_title;
                                                        TextView textView9 = (TextView) view.findViewById(C5419R.id.channels_list_item_thread_actions_title);
                                                        if (textView9 != null) {
                                                            i = C5419R.id.channels_list_item_thread_actions_unarchive;
                                                            TextView textView10 = (TextView) view.findViewById(C5419R.id.channels_list_item_thread_actions_unarchive);
                                                            if (textView10 != null) {
                                                                return new WidgetChannelsListItemThreadActionsBinding((NestedScrollView) view, linearLayout, textView, textView2, textView3, textView4, viewFindViewById, viewFindViewById2, textView5, simpleDraweeView, textView6, textView7, textView8, textView9, textView10);
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
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
