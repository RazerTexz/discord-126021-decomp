package com.discord.utilities.textprocessing.node;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.style.BackgroundColorSpan;
import android.text.style.CharacterStyle;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import androidx.exifinterface.media.ExifInterface;
import b.d.b.a.a;
import com.discord.simpleast.core.node.Node;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.spans.ClickableSpan;
import com.discord.utilities.textprocessing.node.UserMentionNode$RenderContext;
import d0.t.n;
import d0.z.d.m;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: UserMentionNode.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class UserMentionNode<T extends UserMentionNode$RenderContext> extends Node<T> {
    private final UserMentionNode$Type type;
    private final long userId;

    public /* synthetic */ UserMentionNode(UserMentionNode$Type userMentionNode$Type, long j, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(userMentionNode$Type, (i & 2) != 0 ? -1L : j);
    }

    private final void renderUserMention(SpannableStringBuilder builder, T renderContext) {
        String str;
        Map<Long, String> userNames = renderContext.getUserNames();
        Context context = renderContext.getContext();
        int length = builder.length();
        boolean zContainsKey = userNames != null ? userNames.containsKey(Long.valueOf(this.userId)) : false;
        StringBuilder sbU = a.U("@");
        if (userNames == null || (str = userNames.get(Long.valueOf(this.userId))) == null) {
            str = "invalid-user";
        }
        sbU.append(str);
        String string = sbU.toString();
        ArrayList arrayList = new ArrayList();
        arrayList.add(new StyleSpan(1));
        arrayList.add(new BackgroundColorSpan(ColorCompat.getThemedColor(context, 2130970286)));
        Function1<Long, Unit> userMentionOnClick = renderContext.getUserMentionOnClick();
        if (!zContainsKey || userMentionOnClick == null) {
            arrayList.add(new ForegroundColorSpan(ColorCompat.getThemedColor(context, 2130970287)));
        } else {
            arrayList.add(new ClickableSpan(Integer.valueOf(ColorCompat.getThemedColor(context, 2130970287)), false, null, new UserMentionNode$renderUserMention$1(this, userMentionOnClick), 4, null));
        }
        builder.append((CharSequence) string);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            builder.setSpan((CharacterStyle) it.next(), length, builder.length(), 33);
        }
    }

    public boolean equals(Object other) {
        return (other instanceof UserMentionNode) && ((UserMentionNode) other).userId == this.userId;
    }

    public final UserMentionNode$Type getType() {
        return this.type;
    }

    public final long getUserId() {
        return this.userId;
    }

    @Override // com.discord.simpleast.core.node.Node
    public /* bridge */ /* synthetic */ void render(SpannableStringBuilder spannableStringBuilder, Object obj) {
        render(spannableStringBuilder, (UserMentionNode$RenderContext) obj);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UserMentionNode(UserMentionNode$Type userMentionNode$Type, long j) {
        super(null, 1, null);
        m.checkNotNullParameter(userMentionNode$Type, "type");
        this.type = userMentionNode$Type;
        this.userId = j;
    }

    public void render(SpannableStringBuilder builder, T renderContext) {
        m.checkNotNullParameter(builder, "builder");
        m.checkNotNullParameter(renderContext, "renderContext");
        if (this.type == UserMentionNode$Type.USER) {
            renderUserMention(builder, renderContext);
            return;
        }
        List listListOf = n.listOf(new StyleSpan(1), new BackgroundColorSpan(ColorCompat.getThemedColor(renderContext.getContext(), 2130970286)), new ForegroundColorSpan(ColorCompat.getThemedColor(renderContext.getContext(), 2130970287)));
        int length = builder.length();
        builder.append((CharSequence) (this.type == UserMentionNode$Type.HERE ? "@here" : "@everyone"));
        Iterator it = listListOf.iterator();
        while (it.hasNext()) {
            builder.setSpan(it.next(), length, builder.length(), 33);
        }
    }
}
