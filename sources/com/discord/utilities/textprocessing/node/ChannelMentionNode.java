package com.discord.utilities.textprocessing.node;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.style.BackgroundColorSpan;
import android.text.style.CharacterStyle;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import androidx.exifinterface.media.ExifInterface;
import com.discord.api.channel.Channel;
import com.discord.simpleast.core.node.Node;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.spans.ClickableSpan;
import com.discord.utilities.textprocessing.node.ChannelMentionNode$RenderContext;
import d0.z.d.m;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: ChannelMentionNode.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ChannelMentionNode<T extends ChannelMentionNode$RenderContext> extends Node<T> {
    private final long channelId;

    public ChannelMentionNode(long j) {
        super(null, 1, null);
        this.channelId = j;
    }

    public boolean equals(Object other) {
        return (other instanceof ChannelMentionNode) && ((ChannelMentionNode) other).channelId == this.channelId;
    }

    public final long getChannelId() {
        return this.channelId;
    }

    @Override // com.discord.simpleast.core.node.Node
    public /* bridge */ /* synthetic */ void render(SpannableStringBuilder spannableStringBuilder, Object obj) {
        render(spannableStringBuilder, (ChannelMentionNode$RenderContext) obj);
    }

    public void render(SpannableStringBuilder builder, T renderContext) {
        String str;
        m.checkNotNullParameter(builder, "builder");
        m.checkNotNullParameter(renderContext, "renderContext");
        Context context = renderContext.getContext();
        int length = builder.length();
        ArrayList arrayList = new ArrayList(3);
        arrayList.add(new StyleSpan(1));
        Map<Long, String> channelNames = renderContext.getChannelNames();
        if (channelNames == null || (str = channelNames.get(Long.valueOf(this.channelId))) == null) {
            str = "deleted-channel";
        }
        Function1<Long, Unit> channelMentionOnClick = renderContext.getChannelMentionOnClick();
        if (channelMentionOnClick != null) {
            arrayList.add(new ClickableSpan(Integer.valueOf(ColorCompat.getThemedColor(context, 2130970287)), false, null, new ChannelMentionNode$render$1(this, channelMentionOnClick), 4, null));
        } else {
            arrayList.add(new ForegroundColorSpan(ColorCompat.getThemedColor(context, 2130970287)));
        }
        arrayList.add(new BackgroundColorSpan(ColorCompat.getThemedColor(context, 2130970286)));
        StringBuilder sb = new StringBuilder();
        m.checkNotNullParameter(Channel.Companion, "$this$DISPLAY_PREFIX_GUILD");
        sb.append("#");
        sb.append(str);
        builder.append((CharSequence) sb.toString());
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            builder.setSpan((CharacterStyle) it.next(), length, builder.length(), 33);
        }
    }
}
