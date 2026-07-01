package com.discord.widgets.channels.list;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.discord.R;
import com.discord.databinding.WidgetChannelsListUnreadsBinding;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.jvm.functions.Function0;

/* JADX INFO: renamed from: com.discord.widgets.channels.list.WidgetChannelListUnreads$binding$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetChannelListUnreads.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelListUnreads2 extends Lambda implements Function0<WidgetChannelsListUnreadsBinding> {
    public final /* synthetic */ WidgetChannelListUnreads this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChannelListUnreads2(WidgetChannelListUnreads widgetChannelListUnreads) {
        super(0);
        this.this$0 = widgetChannelListUnreads;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final WidgetChannelsListUnreadsBinding invoke() {
        View viewInflate = this.this$0.unreadsStub.inflate();
        int i = R.id.channels_list_unreads;
        TextView textView = (TextView) viewInflate.findViewById(R.id.channels_list_unreads);
        if (textView != null) {
            i = R.id.channels_list_unreads_background;
            RelativeLayout relativeLayout = (RelativeLayout) viewInflate.findViewById(R.id.channels_list_unreads_background);
            if (relativeLayout != null) {
                WidgetChannelsListUnreadsBinding widgetChannelsListUnreadsBinding = new WidgetChannelsListUnreadsBinding((FrameLayout) viewInflate, textView, relativeLayout);
                Intrinsics3.checkNotNullExpressionValue(widgetChannelsListUnreadsBinding, "WidgetChannelsListUnread…nd(unreadsStub.inflate())");
                return widgetChannelsListUnreadsBinding;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i)));
    }
}
