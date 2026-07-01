package com.discord.widgets.channels;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.discord.R;
import com.discord.databinding.WidgetChannelTopicBinding;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.facebook.drawee.view.SimpleDraweeView;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: com.discord.widgets.channels.WidgetChannelTopic$binding$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetChannelTopic.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetChannelTopic2 extends FunctionReferenceImpl implements Function1<View, WidgetChannelTopicBinding> {
    public static final WidgetChannelTopic2 INSTANCE = new WidgetChannelTopic2();

    public WidgetChannelTopic2() {
        super(1, WidgetChannelTopicBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetChannelTopicBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetChannelTopicBinding invoke(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = R.id.channel_aka;
        UserAkaView userAkaView = (UserAkaView) view.findViewById(R.id.channel_aka);
        if (userAkaView != null) {
            LinearLayout linearLayout = (LinearLayout) view;
            i = R.id.channel_topic_channel_icon;
            SimpleDraweeView simpleDraweeView = (SimpleDraweeView) view.findViewById(R.id.channel_topic_channel_icon);
            if (simpleDraweeView != null) {
                i = R.id.channel_topic_ellipsis;
                ImageView imageView = (ImageView) view.findViewById(R.id.channel_topic_ellipsis);
                if (imageView != null) {
                    i = R.id.channel_topic_more_icon;
                    ImageView imageView2 = (ImageView) view.findViewById(R.id.channel_topic_more_icon);
                    if (imageView2 != null) {
                        i = R.id.channel_topic_name;
                        TextView textView = (TextView) view.findViewById(R.id.channel_topic_name);
                        if (textView != null) {
                            i = R.id.channel_topic_title;
                            LinkifiedTextView linkifiedTextView = (LinkifiedTextView) view.findViewById(R.id.channel_topic_title);
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
