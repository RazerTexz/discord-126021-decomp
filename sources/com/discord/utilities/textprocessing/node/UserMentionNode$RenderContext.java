package com.discord.utilities.textprocessing.node;

import android.content.Context;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: UserMentionNode.kt */
/* JADX INFO: loaded from: classes2.dex */
public interface UserMentionNode$RenderContext {
    Context getContext();

    long getMyId();

    Function1<Long, Unit> getUserMentionOnClick();

    Map<Long, String> getUserNames();
}
