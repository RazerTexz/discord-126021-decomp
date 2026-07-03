package com.discord.widgets.channels.list;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.discord.C5419R;
import com.discord.databinding.WidgetChannelsListUnreadsBinding;
import kotlin.jvm.functions.Function0;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetChannelListUnreads.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelListUnreads$binding$2 extends AbstractC12240o implements Function0<WidgetChannelsListUnreadsBinding> {
    public final /* synthetic */ WidgetChannelListUnreads this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChannelListUnreads$binding$2(WidgetChannelListUnreads widgetChannelListUnreads) {
        super(0);
        this.this$0 = widgetChannelListUnreads;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final WidgetChannelsListUnreadsBinding invoke() {
        View viewInflate = this.this$0.unreadsStub.inflate();
        int i = C5419R.id.channels_list_unreads;
        TextView textView = (TextView) viewInflate.findViewById(C5419R.id.channels_list_unreads);
        if (textView != null) {
            i = C5419R.id.channels_list_unreads_background;
            RelativeLayout relativeLayout = (RelativeLayout) viewInflate.findViewById(C5419R.id.channels_list_unreads_background);
            if (relativeLayout != null) {
                WidgetChannelsListUnreadsBinding widgetChannelsListUnreadsBinding = new WidgetChannelsListUnreadsBinding((FrameLayout) viewInflate, textView, relativeLayout);
                C12238m.checkNotNullExpressionValue(widgetChannelsListUnreadsBinding, "WidgetChannelsListUnread…nd(unreadsStub.inflate())");
                return widgetChannelsListUnreadsBinding;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i)));
    }
}
