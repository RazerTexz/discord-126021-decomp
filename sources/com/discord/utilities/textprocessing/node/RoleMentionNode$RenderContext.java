package com.discord.utilities.textprocessing.node;

import android.content.Context;
import com.discord.api.role.GuildRole;
import java.util.Map;

/* JADX INFO: compiled from: RoleMentionNode.kt */
/* JADX INFO: loaded from: classes2.dex */
public interface RoleMentionNode$RenderContext {
    Context getContext();

    Map<Long, GuildRole> getRoles();
}
