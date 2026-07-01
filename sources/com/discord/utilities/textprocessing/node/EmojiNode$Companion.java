package com.discord.utilities.textprocessing.node;

import android.text.SpannableStringBuilder;
import androidx.exifinterface.media.ExifInterface;
import com.discord.api.activity.ActivityEmoji;
import com.discord.api.message.reaction.MessageReactionEmoji;
import com.discord.models.domain.emoji.ModelEmojiCustom;
import com.discord.models.domain.emoji.ModelEmojiUnicode;
import com.discord.stores.StoreStream;
import com.discord.utilities.view.text.SimpleDraweeSpanTextView;
import com.facebook.drawee.span.DraweeSpanStringBuilder;
import d0.z.d.m;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: EmojiNode.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class EmojiNode$Companion {
    private EmojiNode$Companion() {
    }

    public static /* synthetic */ EmojiNode from$default(EmojiNode$Companion emojiNode$Companion, ModelEmojiCustom modelEmojiCustom, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = EmojiNode.access$getEMOJI_SIZE$cp();
        }
        return emojiNode$Companion.from(modelEmojiCustom, i);
    }

    public static /* synthetic */ void renderEmoji$default(EmojiNode$Companion emojiNode$Companion, SimpleDraweeSpanTextView simpleDraweeSpanTextView, MessageReactionEmoji messageReactionEmoji, boolean z2, int i, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            i = EmojiNode.access$getEMOJI_SIZE$cp();
        }
        emojiNode$Companion.renderEmoji(simpleDraweeSpanTextView, messageReactionEmoji, z2, i);
    }

    public final <T extends EmojiNode$RenderContext> EmojiNode<T> from(ModelEmojiCustom customEmoji, int sizePx) {
        m.checkNotNullParameter(customEmoji, "customEmoji");
        String name = customEmoji.getName();
        m.checkNotNullExpressionValue(name, "customEmoji.name");
        return from(name, customEmoji.getId(), customEmoji.isAnimated(), sizePx, generateEmojiIdAndType(customEmoji));
    }

    public final EmojiNode$EmojiIdAndType$Custom generateEmojiIdAndType(ModelEmojiCustom modelEmojiCustom) {
        m.checkNotNullParameter(modelEmojiCustom, "$this$generateEmojiIdAndType");
        long id2 = modelEmojiCustom.getId();
        boolean zIsAnimated = modelEmojiCustom.isAnimated();
        String name = modelEmojiCustom.getName();
        m.checkNotNullExpressionValue(name, "this.name");
        return new EmojiNode$EmojiIdAndType$Custom(id2, zIsAnimated, name);
    }

    public final void renderEmoji(SimpleDraweeSpanTextView simpleDraweeSpanTextView, MessageReactionEmoji messageReactionEmoji, boolean z2) {
        renderEmoji$default(this, simpleDraweeSpanTextView, messageReactionEmoji, z2, 0, 4, null);
    }

    public final void renderEmoji(SimpleDraweeSpanTextView simpleDraweeSpanTextView, MessageReactionEmoji messageReactionEmoji, boolean z2, int i) {
        EmojiNode$EmojiIdAndType emojiNode$EmojiIdAndType$Unicode;
        String name;
        m.checkNotNullParameter(simpleDraweeSpanTextView, "$this$renderEmoji");
        String str = "";
        if (messageReactionEmoji == null || !messageReactionEmoji.e()) {
            if (messageReactionEmoji != null && (name = messageReactionEmoji.getName()) != null) {
                str = name;
            }
            emojiNode$EmojiIdAndType$Unicode = new EmojiNode$EmojiIdAndType$Unicode(str);
        } else {
            String id2 = messageReactionEmoji.getId();
            long j = id2 != null ? Long.parseLong(id2) : 0L;
            boolean animated = messageReactionEmoji.getAnimated();
            String name2 = messageReactionEmoji.getName();
            emojiNode$EmojiIdAndType$Unicode = new EmojiNode$EmojiIdAndType$Custom(j, animated, name2 != null ? name2 : "");
        }
        EmojiNode emojiNodeFrom = messageReactionEmoji != null ? EmojiNode.Companion.from(i, emojiNode$EmojiIdAndType$Unicode) : null;
        DraweeSpanStringBuilder draweeSpanStringBuilder = new DraweeSpanStringBuilder();
        draweeSpanStringBuilder.append((char) 8202);
        if (emojiNodeFrom == null) {
            simpleDraweeSpanTextView.setText(messageReactionEmoji != null ? messageReactionEmoji.getName() : null);
        } else {
            emojiNodeFrom.render((SpannableStringBuilder) draweeSpanStringBuilder, new EmojiNode$Companion$renderEmoji$1(simpleDraweeSpanTextView, z2));
            simpleDraweeSpanTextView.setDraweeSpanStringBuilder(draweeSpanStringBuilder);
        }
    }

    public /* synthetic */ EmojiNode$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public static /* synthetic */ EmojiNode from$default(EmojiNode$Companion emojiNode$Companion, ModelEmojiUnicode modelEmojiUnicode, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = EmojiNode.access$getEMOJI_SIZE$cp();
        }
        return emojiNode$Companion.from(modelEmojiUnicode, i);
    }

    public final EmojiNode$EmojiIdAndType$Unicode generateEmojiIdAndType(ModelEmojiUnicode modelEmojiUnicode) {
        m.checkNotNullParameter(modelEmojiUnicode, "$this$generateEmojiIdAndType");
        String firstName = modelEmojiUnicode.getFirstName();
        m.checkNotNullExpressionValue(firstName, "this.firstName");
        return new EmojiNode$EmojiIdAndType$Unicode(firstName);
    }

    public static /* synthetic */ EmojiNode from$default(EmojiNode$Companion emojiNode$Companion, int i, EmojiNode$EmojiIdAndType emojiNode$EmojiIdAndType, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = EmojiNode.access$getEMOJI_SIZE$cp();
        }
        return emojiNode$Companion.from(i, emojiNode$EmojiIdAndType);
    }

    public final EmojiNode$EmojiIdAndType generateEmojiIdAndType(MessageReactionEmoji messageReactionEmoji) {
        EmojiNode$EmojiIdAndType emojiNode$EmojiIdAndType$Unicode;
        m.checkNotNullParameter(messageReactionEmoji, "$this$generateEmojiIdAndType");
        if (messageReactionEmoji.e()) {
            String id2 = messageReactionEmoji.getId();
            long j = id2 != null ? Long.parseLong(id2) : 0L;
            boolean animated = messageReactionEmoji.getAnimated();
            String name = messageReactionEmoji.getName();
            emojiNode$EmojiIdAndType$Unicode = new EmojiNode$EmojiIdAndType$Custom(j, animated, name != null ? name : "");
        } else {
            String name2 = messageReactionEmoji.getName();
            emojiNode$EmojiIdAndType$Unicode = new EmojiNode$EmojiIdAndType$Unicode(name2 != null ? name2 : "");
        }
        return emojiNode$EmojiIdAndType$Unicode;
    }

    public final <T extends EmojiNode$RenderContext> EmojiNode<T> from(ModelEmojiUnicode unicodeEmoji, int sizePx) {
        m.checkNotNullParameter(unicodeEmoji, "unicodeEmoji");
        String codePoints = unicodeEmoji.getCodePoints();
        String firstName = unicodeEmoji.getFirstName();
        m.checkNotNullExpressionValue(firstName, "unicodeEmoji.firstName");
        return new EmojiNode<>(firstName, new EmojiNode$Companion$from$1(codePoints), generateEmojiIdAndType(unicodeEmoji), sizePx, sizePx);
    }

    public final EmojiNode$EmojiIdAndType generateEmojiIdAndType(ActivityEmoji activityEmoji) {
        EmojiNode$EmojiIdAndType emojiNode$EmojiIdAndType$Unicode;
        m.checkNotNullParameter(activityEmoji, "$this$generateEmojiIdAndType");
        if (activityEmoji.getId() != null) {
            String id2 = activityEmoji.getId();
            m.checkNotNull(id2);
            long j = Long.parseLong(id2);
            boolean animated = activityEmoji.getAnimated();
            String name = activityEmoji.getName();
            emojiNode$EmojiIdAndType$Unicode = new EmojiNode$EmojiIdAndType$Custom(j, animated, name != null ? name : "");
        } else {
            String name2 = activityEmoji.getName();
            emojiNode$EmojiIdAndType$Unicode = new EmojiNode$EmojiIdAndType$Unicode(name2 != null ? name2 : "");
        }
        return emojiNode$EmojiIdAndType$Unicode;
    }

    public final <T extends EmojiNode$RenderContext> EmojiNode<T> from(int sizePx, EmojiNode$EmojiIdAndType emojiIdAndType) {
        m.checkNotNullParameter(emojiIdAndType, "emojiIdAndType");
        if (emojiIdAndType instanceof EmojiNode$EmojiIdAndType$Unicode) {
            ModelEmojiUnicode modelEmojiUnicode = StoreStream.Companion.getEmojis().getUnicodeEmojiSurrogateMap().get(((EmojiNode$EmojiIdAndType$Unicode) emojiIdAndType).getName());
            if (modelEmojiUnicode != null) {
                return EmojiNode.Companion.from(modelEmojiUnicode, sizePx);
            }
            return null;
        }
        if (!(emojiIdAndType instanceof EmojiNode$EmojiIdAndType$Custom)) {
            throw new NoWhenBranchMatchedException();
        }
        EmojiNode$EmojiIdAndType$Custom emojiNode$EmojiIdAndType$Custom = (EmojiNode$EmojiIdAndType$Custom) emojiIdAndType;
        return from(emojiNode$EmojiIdAndType$Custom.getName(), emojiNode$EmojiIdAndType$Custom.getId(), emojiNode$EmojiIdAndType$Custom.isAnimated(), sizePx, emojiIdAndType);
    }

    private final <T extends EmojiNode$RenderContext> EmojiNode<T> from(String emojiName, long emojiId, boolean isAnimated, int sizePx, EmojiNode$EmojiIdAndType emojiIdAndType) {
        return new EmojiNode<>(emojiName, new EmojiNode$Companion$from$3(emojiId, isAnimated), emojiIdAndType, sizePx, sizePx);
    }
}
