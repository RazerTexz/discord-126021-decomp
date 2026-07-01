package com.discord.utilities.textprocessing.node;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.text.SpannableStringBuilder;
import androidx.exifinterface.media.ExifInterface;
import b.a.t.b.a.a;
import b.f.g.a.a.b;
import b.f.g.a.a.d;
import b.f.g.e.v;
import com.discord.api.message.reaction.MessageReactionEmoji;
import com.discord.app.AppLog;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.dimen.DimenUtils;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.images.MGImages;
import com.discord.utilities.logging.Logger;
import com.discord.utilities.spans.ClickableSpan;
import com.discord.utilities.textprocessing.node.EmojiNode$RenderContext;
import com.discord.utilities.view.text.SimpleDraweeSpanTextView;
import com.facebook.drawee.controller.AbstractDraweeController;
import com.facebook.drawee.drawable.ScalingUtils$ScaleType;
import com.facebook.drawee.span.DraweeSpanStringBuilder;
import d0.z.d.m;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: EmojiNode.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class EmojiNode<T extends EmojiNode$RenderContext> extends a<T> implements Spoilerable {
    public static final EmojiNode$Companion Companion = new EmojiNode$Companion(null);
    private static final int EMOJI_SIZE = DimenUtils.dpToPixels(16);
    private static final int JUMBOIFY_SCALE_FACTOR = 3;
    private final EmojiNode$EmojiIdAndType emojiIdAndType;
    private final int height;
    private boolean isJumbo;
    private boolean isRevealed;
    private final Function3<Boolean, Integer, Context, String> urlProvider;
    private final int width;

    public EmojiNode(String str, Function3<? super Boolean, ? super Integer, ? super Context, String> function3, EmojiNode$EmojiIdAndType emojiNode$EmojiIdAndType) {
        this(str, function3, emojiNode$EmojiIdAndType, 0, 0, 24, null);
    }

    public EmojiNode(String str, Function3<? super Boolean, ? super Integer, ? super Context, String> function3, EmojiNode$EmojiIdAndType emojiNode$EmojiIdAndType, int i) {
        this(str, function3, emojiNode$EmojiIdAndType, i, 0, 16, null);
    }

    public /* synthetic */ EmojiNode(String str, Function3 function3, EmojiNode$EmojiIdAndType emojiNode$EmojiIdAndType, int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, function3, emojiNode$EmojiIdAndType, (i3 & 8) != 0 ? EMOJI_SIZE : i, (i3 & 16) != 0 ? EMOJI_SIZE : i2);
    }

    public static final /* synthetic */ int access$getEMOJI_SIZE$cp() {
        return EMOJI_SIZE;
    }

    public static final /* synthetic */ EmojiNode$EmojiIdAndType access$getEmojiIdAndType$p(EmojiNode emojiNode) {
        return emojiNode.emojiIdAndType;
    }

    public static final void renderEmoji(SimpleDraweeSpanTextView simpleDraweeSpanTextView, MessageReactionEmoji messageReactionEmoji, boolean z2) {
        EmojiNode$Companion.renderEmoji$default(Companion, simpleDraweeSpanTextView, messageReactionEmoji, z2, 0, 4, null);
    }

    public static final void renderEmoji(SimpleDraweeSpanTextView simpleDraweeSpanTextView, MessageReactionEmoji messageReactionEmoji, boolean z2, int i) {
        Companion.renderEmoji(simpleDraweeSpanTextView, messageReactionEmoji, z2, i);
    }

    public boolean equals(Object other) {
        if (other instanceof EmojiNode) {
            EmojiNode emojiNode = (EmojiNode) other;
            if (m.areEqual(emojiNode.getContent(), getContent()) && emojiNode.width == this.width && emojiNode.height == this.height && emojiNode.isJumbo == this.isJumbo) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: renamed from: isJumbo, reason: from getter */
    public final boolean getIsJumbo() {
        return this.isJumbo;
    }

    @Override // com.discord.utilities.textprocessing.node.Spoilerable
    /* JADX INFO: renamed from: isRevealed, reason: from getter */
    public boolean getIsRevealed() {
        return this.isRevealed;
    }

    @Override // b.a.t.b.a.a, com.discord.simpleast.core.node.Node
    public /* bridge */ /* synthetic */ void render(SpannableStringBuilder spannableStringBuilder, Object obj) {
        render(spannableStringBuilder, (EmojiNode$RenderContext) obj);
    }

    public final void setJumbo(boolean z2) {
        this.isJumbo = z2;
    }

    @Override // com.discord.utilities.textprocessing.node.Spoilerable
    public void setRevealed(boolean z2) {
        this.isRevealed = z2;
    }

    /* JADX WARN: Type inference failed for: r1v9, types: [REQUEST, com.facebook.imagepipeline.request.ImageRequest] */
    public void render(SpannableStringBuilder builder, T renderContext) {
        m.checkNotNullParameter(builder, "builder");
        m.checkNotNullParameter(renderContext, "renderContext");
        Context context = renderContext.getContext();
        int length = builder.length();
        builder.append((CharSequence) getContent());
        boolean z2 = this.isJumbo;
        int i = this.width;
        if (z2) {
            i *= 3;
        }
        int i2 = i;
        int i3 = this.height;
        if (z2) {
            i3 *= 3;
        }
        int i4 = i3;
        int i5 = z2 ? 1 : 2;
        ?? A = MGImages.getImageRequest(this.urlProvider.invoke(Boolean.valueOf(renderContext.getIsAnimationEnabled()), Integer.valueOf(IconUtils.getMediaProxySize(i2)), renderContext.getContext()), 0, 0, true).a();
        d dVarA = b.a();
        dVarA.h = A;
        dVarA.m = getIsRevealed();
        AbstractDraweeController abstractDraweeControllerA = dVarA.a();
        b.f.g.f.a aVar = new b.f.g.f.a(context.getResources());
        aVar.f = new ColorDrawable(0);
        ScalingUtils$ScaleType scalingUtils$ScaleType = ScalingUtils$ScaleType.a;
        aVar.n = v.l;
        if (!getIsRevealed()) {
            SpoilerNode$RenderContext spoilerNode$RenderContext = (SpoilerNode$RenderContext) (!(renderContext instanceof SpoilerNode$RenderContext) ? null : renderContext);
            aVar.b(new ColorDrawable(spoilerNode$RenderContext != null ? spoilerNode$RenderContext.getSpoilerColorRes() : ColorCompat.getThemedColor(context, 2130970291)));
        }
        int length2 = builder.length() - 1;
        ((DraweeSpanStringBuilder) builder).c(context, aVar.a(), abstractDraweeControllerA, length, length2, i2, i4, false, i5);
        if (getContent().length() == 0) {
            return;
        }
        ClickableSpan clickableSpan = new ClickableSpan(Integer.valueOf(ColorCompat.getThemedColor(context, 2130969062)), false, null, new EmojiNode$render$clickableSpan$1(this, renderContext), 4, null);
        if (length <= length2) {
            builder.setSpan(clickableSpan, length, length2 + 1, 33);
            return;
        }
        AppLog appLog = AppLog.g;
        StringBuilder sbU = b.d.b.a.a.U("Span content: ");
        sbU.append(getContent());
        sbU.append('.');
        Logger.e$default(appLog, "Unable to render emoji tappable span.", new Exception(sbU.toString()), null, 4, null);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public EmojiNode(String str, Function3<? super Boolean, ? super Integer, ? super Context, String> function3, EmojiNode$EmojiIdAndType emojiNode$EmojiIdAndType, int i, int i2) {
        super(str);
        m.checkNotNullParameter(str, "emojiName");
        m.checkNotNullParameter(function3, "urlProvider");
        m.checkNotNullParameter(emojiNode$EmojiIdAndType, "emojiIdAndType");
        this.urlProvider = function3;
        this.emojiIdAndType = emojiNode$EmojiIdAndType;
        this.width = i;
        this.height = i2;
        this.isRevealed = true;
    }
}
