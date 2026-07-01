package com.discord.utilities.textprocessing;

import android.text.SpannableStringBuilder;
import androidx.exifinterface.media.ExifInterface;
import b.a.t.b.b.h;
import com.discord.simpleast.core.node.Node;
import com.facebook.drawee.span.DraweeSpanStringBuilder;
import d0.z.d.m;
import java.util.Collection;

/* JADX INFO: compiled from: AstRenderer.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class AstRenderer {
    public static final AstRenderer INSTANCE = new AstRenderer();

    private AstRenderer() {
    }

    public static final <T> DraweeSpanStringBuilder render(Collection<? extends Node<T>> ast, T renderContext) {
        m.checkNotNullParameter(ast, "ast");
        DraweeSpanStringBuilder draweeSpanStringBuilder = new DraweeSpanStringBuilder();
        h.a(draweeSpanStringBuilder, ast, renderContext);
        INSTANCE.trim(draweeSpanStringBuilder);
        return draweeSpanStringBuilder;
    }

    private final void trim(SpannableStringBuilder builder) {
        if (builder.length() == 0) {
            return;
        }
        char[] cArr = new char[1];
        builder.getChars(builder.length() - 1, builder.length(), cArr, 0);
        if (cArr[0] == '\n') {
            builder.delete(builder.length() - 1, builder.length());
        }
    }
}
