package com.discord.utilities.textprocessing;

import android.text.style.RelativeSizeSpan;
import android.text.style.TextAppearanceSpan;
import androidx.exifinterface.media.ExifInterface;
import com.discord.R$style;
import com.discord.simpleast.core.node.StyleNode$a;
import com.discord.utilities.textprocessing.node.BasicRenderContext;
import d0.t.n;
import d0.z.d.m;

/* JADX INFO: compiled from: Rules.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class Rules$createInlineCodeRule$1<RC> implements StyleNode$a<RC> {
    public static final Rules$createInlineCodeRule$1 INSTANCE = new Rules$createInlineCodeRule$1();

    @Override // com.discord.simpleast.core.node.StyleNode$a
    public /* bridge */ /* synthetic */ Iterable get(Object obj) {
        return get((BasicRenderContext) obj);
    }

    /* JADX WARN: Incorrect types in method signature: (TRC;)Ljava/lang/Iterable<*>; */
    public final Iterable get(BasicRenderContext basicRenderContext) {
        m.checkNotNullParameter(basicRenderContext, "it");
        return n.listOf(new TextAppearanceSpan(basicRenderContext.getContext(), R$style.Code_TextAppearance), new RelativeSizeSpan(0.85f));
    }
}
