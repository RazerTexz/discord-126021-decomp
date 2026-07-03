package com.discord.utilities.textprocessing.node;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.style.BackgroundColorSpan;
import android.text.style.CharacterStyle;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import com.discord.C5419R;
import com.discord.api.channel.Channel;
import com.discord.simpleast.core.node.Node;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.spans.ClickableSpan;
import com.discord.utilities.textprocessing.node.ChannelMentionNode.RenderContext;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: ChannelMentionNode.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ChannelMentionNode<T extends RenderContext> extends Node<T> {
    private final long channelId;

    /* JADX INFO: compiled from: ChannelMentionNode.kt */
    public interface RenderContext extends BasicRenderContext {
        Function1<Long, Unit> getChannelMentionOnClick();

        Map<Long, String> getChannelNames();
    }

    /* JADX INFO: renamed from: com.discord.utilities.textprocessing.node.ChannelMentionNode$render$1 */
    /* JADX INFO: compiled from: ChannelMentionNode.kt */
    public static final class C69751 extends AbstractC12240o implements Function1<View, Unit> {
        public final /* synthetic */ Function1 $onClick;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C69751(Function1 function1) {
            super(1);
            this.$onClick = function1;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(View view) {
            invoke2(view);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(View view) {
            C12238m.checkNotNullParameter(view, "it");
            this.$onClick.invoke(Long.valueOf(ChannelMentionNode.this.getChannelId()));
        }
    }

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
    public void render(SpannableStringBuilder builder, T renderContext) {
        String str;
        C12238m.checkNotNullParameter(builder, "builder");
        C12238m.checkNotNullParameter(renderContext, "renderContext");
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
            arrayList.add(new ClickableSpan(Integer.valueOf(ColorCompat.getThemedColor(context, C5419R.attr.theme_chat_mention_foreground)), false, null, new C69751(channelMentionOnClick), 4, null));
        } else {
            arrayList.add(new ForegroundColorSpan(ColorCompat.getThemedColor(context, C5419R.attr.theme_chat_mention_foreground)));
        }
        arrayList.add(new BackgroundColorSpan(ColorCompat.getThemedColor(context, C5419R.attr.theme_chat_mention_background)));
        StringBuilder sb = new StringBuilder();
        C12238m.checkNotNullParameter(Channel.INSTANCE, "$this$DISPLAY_PREFIX_GUILD");
        sb.append("#");
        sb.append(str);
        builder.append((CharSequence) sb.toString());
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            builder.setSpan((CharacterStyle) it.next(), length, builder.length(), 33);
        }
    }
}
