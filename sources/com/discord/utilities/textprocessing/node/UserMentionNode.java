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
import com.discord.simpleast.core.node.Node;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.spans.ClickableSpan;
import com.discord.utilities.textprocessing.node.UserMentionNode.RenderContext;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p580t.C12147n;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: UserMentionNode.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class UserMentionNode<T extends RenderContext> extends Node<T> {
    private final Type type;
    private final long userId;

    /* JADX INFO: compiled from: UserMentionNode.kt */
    public interface RenderContext {
        Context getContext();

        long getMyId();

        Function1<Long, Unit> getUserMentionOnClick();

        Map<Long, String> getUserNames();
    }

    /* JADX INFO: compiled from: UserMentionNode.kt */
    public enum Type {
        USER,
        HERE,
        EVERYONE
    }

    /* JADX INFO: renamed from: com.discord.utilities.textprocessing.node.UserMentionNode$renderUserMention$1 */
    /* JADX INFO: compiled from: UserMentionNode.kt */
    public static final class C69761 extends AbstractC12240o implements Function1<View, Unit> {
        public final /* synthetic */ Function1 $onClick;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C69761(Function1 function1) {
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
            this.$onClick.invoke(Long.valueOf(UserMentionNode.this.getUserId()));
        }
    }

    public /* synthetic */ UserMentionNode(Type type, long j, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(type, (i & 2) != 0 ? -1L : j);
    }

    private final void renderUserMention(SpannableStringBuilder builder, T renderContext) {
        String str;
        Map<Long, String> userNames = renderContext.getUserNames();
        Context context = renderContext.getContext();
        int length = builder.length();
        boolean zContainsKey = userNames != null ? userNames.containsKey(Long.valueOf(this.userId)) : false;
        StringBuilder sbM833U = C1643a.m833U("@");
        if (userNames == null || (str = userNames.get(Long.valueOf(this.userId))) == null) {
            str = "invalid-user";
        }
        sbM833U.append(str);
        String string = sbM833U.toString();
        ArrayList arrayList = new ArrayList();
        arrayList.add(new StyleSpan(1));
        arrayList.add(new BackgroundColorSpan(ColorCompat.getThemedColor(context, C5419R.attr.theme_chat_mention_background)));
        Function1<Long, Unit> userMentionOnClick = renderContext.getUserMentionOnClick();
        if (!zContainsKey || userMentionOnClick == null) {
            arrayList.add(new ForegroundColorSpan(ColorCompat.getThemedColor(context, C5419R.attr.theme_chat_mention_foreground)));
        } else {
            arrayList.add(new ClickableSpan(Integer.valueOf(ColorCompat.getThemedColor(context, C5419R.attr.theme_chat_mention_foreground)), false, null, new C69761(userMentionOnClick), 4, null));
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

    public final Type getType() {
        return this.type;
    }

    public final long getUserId() {
        return this.userId;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UserMentionNode(Type type, long j) {
        super(null, 1, null);
        C12238m.checkNotNullParameter(type, "type");
        this.type = type;
        this.userId = j;
    }

    @Override // com.discord.simpleast.core.node.Node
    public void render(SpannableStringBuilder builder, T renderContext) {
        C12238m.checkNotNullParameter(builder, "builder");
        C12238m.checkNotNullParameter(renderContext, "renderContext");
        if (this.type == Type.USER) {
            renderUserMention(builder, renderContext);
            return;
        }
        List listListOf = C12147n.listOf(new StyleSpan(1), new BackgroundColorSpan(ColorCompat.getThemedColor(renderContext.getContext(), C5419R.attr.theme_chat_mention_background)), new ForegroundColorSpan(ColorCompat.getThemedColor(renderContext.getContext(), C5419R.attr.theme_chat_mention_foreground)));
        int length = builder.length();
        builder.append((CharSequence) (this.type == Type.HERE ? "@here" : "@everyone"));
        Iterator it = listListOf.iterator();
        while (it.hasNext()) {
            builder.setSpan(it.next(), length, builder.length(), 33);
        }
    }
}
