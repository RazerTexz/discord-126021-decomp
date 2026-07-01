package com.discord.utilities.textprocessing;

import android.text.style.BackgroundColorSpan;
import androidx.exifinterface.media.ExifInterface;
import com.discord.simpleast.core.node.StyleNode$a;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.textprocessing.node.BasicRenderContext;
import d0.z.d.m;

/* JADX INFO: compiled from: Rules.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class Rules$createInlineCodeRule$2<RC> implements StyleNode$a<RC> {
    public static final Rules$createInlineCodeRule$2 INSTANCE = new Rules$createInlineCodeRule$2();

    @Override // com.discord.simpleast.core.node.StyleNode$a
    public /* bridge */ /* synthetic */ Iterable get(Object obj) {
        return get((BasicRenderContext) obj);
    }

    /* JADX WARN: Incorrect types in method signature: (TRC;)Ljava/lang/Iterable<*>; */
    public final Iterable get(BasicRenderContext basicRenderContext) {
        m.checkNotNullParameter(basicRenderContext, "it");
        return d0.t.m.listOf(new BackgroundColorSpan(ColorCompat.getThemedColor(basicRenderContext.getContext(), 2130970275)));
    }
}
