package com.discord.widgets.channels;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.discord.C5419R;
import com.discord.databinding.WidgetChannelTopicBinding;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.facebook.drawee.view.SimpleDraweeView;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetChannelTopic.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetChannelTopic$binding$2 extends C12236k implements Function1<View, WidgetChannelTopicBinding> {
    public static final WidgetChannelTopic$binding$2 INSTANCE = new WidgetChannelTopic$binding$2();

    public WidgetChannelTopic$binding$2() {
        super(1, WidgetChannelTopicBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetChannelTopicBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetChannelTopicBinding invoke(View view) {
        C12238m.checkNotNullParameter(view, "p1");
        int i = C5419R.id.channel_aka;
        UserAkaView userAkaView = (UserAkaView) view.findViewById(C5419R.id.channel_aka);
        if (userAkaView != null) {
            LinearLayout linearLayout = (LinearLayout) view;
            i = C5419R.id.channel_topic_channel_icon;
            SimpleDraweeView simpleDraweeView = (SimpleDraweeView) view.findViewById(C5419R.id.channel_topic_channel_icon);
            if (simpleDraweeView != null) {
                i = C5419R.id.channel_topic_ellipsis;
                ImageView imageView = (ImageView) view.findViewById(C5419R.id.channel_topic_ellipsis);
                if (imageView != null) {
                    i = C5419R.id.channel_topic_more_icon;
                    ImageView imageView2 = (ImageView) view.findViewById(C5419R.id.channel_topic_more_icon);
                    if (imageView2 != null) {
                        i = C5419R.id.channel_topic_name;
                        TextView textView = (TextView) view.findViewById(C5419R.id.channel_topic_name);
                        if (textView != null) {
                            i = C5419R.id.channel_topic_title;
                            LinkifiedTextView linkifiedTextView = (LinkifiedTextView) view.findViewById(C5419R.id.channel_topic_title);
                            if (linkifiedTextView != null) {
                                return new WidgetChannelTopicBinding(linearLayout, userAkaView, linearLayout, simpleDraweeView, imageView, imageView2, textView, linkifiedTextView);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
