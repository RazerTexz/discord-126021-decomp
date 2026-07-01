package com.discord.utilities.textprocessing.node;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: SpoilerNode.kt */
/* JADX INFO: loaded from: classes2.dex */
public interface SpoilerNode$RenderContext extends BasicRenderContext {
    int getSpoilerColorRes();

    Function1<SpoilerNode<?>, Unit> getSpoilerOnClick();

    int getSpoilerRevealedColorRes();
}
