package com.discord.utilities.textprocessing.node;

import android.content.Context;
import android.text.SpannableStringBuilder;
import androidx.annotation.AttrRes;
import androidx.exifinterface.media.ExifInterface;
import com.discord.simpleast.core.node.Node;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.spans.ClickableSpan;
import com.discord.utilities.string.StringUtils2;
import com.discord.utilities.textprocessing.node.UrlNode.RenderContext;
import d0.z.d.Intrinsics3;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: UrlNode.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class UrlNode<T extends RenderContext> extends Node<T> {
    private final String mask;
    private final String url;

    /* JADX INFO: compiled from: UrlNode.kt */
    public interface RenderContext extends BasicRenderContext {
        @AttrRes
        int getLinkColorAttrResId();

        Function3<Context, String, String, Unit> getOnClickUrl();

        Function1<String, Unit> getOnLongPressUrl();
    }

    public /* synthetic */ UrlNode(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? null : str2);
    }

    public final String getUrl() {
        return this.url;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UrlNode(String str, String str2) {
        super(null, 1, null);
        Intrinsics3.checkNotNullParameter(str, "url");
        this.url = str;
        this.mask = str2;
    }

    @Override // com.discord.simpleast.core.node.Node
    public void render(SpannableStringBuilder builder, T renderContext) {
        Intrinsics3.checkNotNullParameter(builder, "builder");
        Intrinsics3.checkNotNullParameter(renderContext, "renderContext");
        try {
            String punyCodeASCIIUrl = StringUtils2.toPunyCodeASCIIUrl(this.url);
            Object clickableSpan = new ClickableSpan(Integer.valueOf(ColorCompat.getThemedColor(renderContext.getContext(), renderContext.getLinkColorAttrResId())), false, new UrlNode2(renderContext, punyCodeASCIIUrl), new UrlNode3(this, renderContext, punyCodeASCIIUrl));
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
