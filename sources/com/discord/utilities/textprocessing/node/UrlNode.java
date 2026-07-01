package com.discord.utilities.textprocessing.node;

import android.text.SpannableStringBuilder;
import androidx.exifinterface.media.ExifInterface;
import com.discord.simpleast.core.node.Node;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.spans.ClickableSpan;
import com.discord.utilities.string.StringUtilsKt;
import com.discord.utilities.textprocessing.node.UrlNode$RenderContext;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: UrlNode.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class UrlNode<T extends UrlNode$RenderContext> extends Node<T> {
    private final String mask;
    private final String url;

    public /* synthetic */ UrlNode(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? null : str2);
    }

    public static final /* synthetic */ String access$getMask$p(UrlNode urlNode) {
        return urlNode.mask;
    }

    public final String getUrl() {
        return this.url;
    }

    @Override // com.discord.simpleast.core.node.Node
    public /* bridge */ /* synthetic */ void render(SpannableStringBuilder spannableStringBuilder, Object obj) {
        render(spannableStringBuilder, (UrlNode$RenderContext) obj);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UrlNode(String str, String str2) {
        super(null, 1, null);
        m.checkNotNullParameter(str, "url");
        this.url = str;
        this.mask = str2;
    }

    public void render(SpannableStringBuilder builder, T renderContext) {
        m.checkNotNullParameter(builder, "builder");
        m.checkNotNullParameter(renderContext, "renderContext");
        try {
            String punyCodeASCIIUrl = StringUtilsKt.toPunyCodeASCIIUrl(this.url);
            Object clickableSpan = new ClickableSpan(Integer.valueOf(ColorCompat.getThemedColor(renderContext.getContext(), renderContext.getLinkColorAttrResId())), false, new UrlNode$render$style$1(renderContext, punyCodeASCIIUrl), new UrlNode$render$style$2(this, renderContext, punyCodeASCIIUrl));
            int length = builder.length();
            String str = this.mask;
            if (str != null) {
                punyCodeASCIIUrl = str;
            }
            builder.append((CharSequence) punyCodeASCIIUrl);
            builder.setSpan(clickableSpan, length, builder.length(), 33);
        } catch (Exception unused) {
            builder.append(this.url);
        }
    }
}
