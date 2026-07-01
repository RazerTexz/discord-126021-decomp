package com.discord.utilities.textprocessing.node;

import android.content.Context;
import androidx.annotation.AttrRes;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;

/* JADX INFO: compiled from: UrlNode.kt */
/* JADX INFO: loaded from: classes2.dex */
public interface UrlNode$RenderContext extends BasicRenderContext {
    @AttrRes
    int getLinkColorAttrResId();

    Function3<Context, String, String, Unit> getOnClickUrl();

    Function1<String, Unit> getOnLongPressUrl();
}
