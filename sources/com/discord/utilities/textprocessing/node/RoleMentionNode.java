package com.discord.utilities.textprocessing.node;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import androidx.core.graphics.ColorUtils;
import androidx.exifinterface.media.ExifInterface;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.api.role.GuildRole;
import com.discord.simpleast.core.node.Node;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.guilds.RoleUtils;
import com.discord.utilities.textprocessing.node.RoleMentionNode.RenderContext;
import com.discord.widgets.chat.input.MentionUtils;
import d0.t.Collections2;
import d0.z.d.Intrinsics3;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: RoleMentionNode.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class RoleMentionNode<T extends RenderContext> extends Node<T> {
    private final long roleId;

    /* JADX INFO: compiled from: RoleMentionNode.kt */
    public interface RenderContext {
        Context getContext();

        Map<Long, GuildRole> getRoles();
    }

    public RoleMentionNode(long j) {
        super(null, 1, null);
        this.roleId = j;
    }

    public boolean equals(Object other) {
        return (other instanceof RoleMentionNode) && ((RoleMentionNode) other).roleId == this.roleId;
    }

    public final long getRoleId() {
        return this.roleId;
    }

    @Override // com.discord.simpleast.core.node.Node
    public void render(SpannableStringBuilder builder, T renderContext) {
        Intrinsics3.checkNotNullParameter(builder, "builder");
        Intrinsics3.checkNotNullParameter(renderContext, "renderContext");
        int length = builder.length();
        Map<Long, GuildRole> roles = renderContext.getRoles();
        GuildRole guildRole = roles != null ? roles.get(Long.valueOf(this.roleId)) : null;
        if (guildRole == null) {
            builder.append("deleted-role");
            return;
        }
        StringBuilder sbQ = outline.Q(MentionUtils.MENTIONS_CHAR);
        sbQ.append(guildRole.getName());
        String string = sbQ.toString();
        List listListOf = Collections2.listOf(new StyleSpan(1), new ForegroundColorSpan(!RoleUtils.isDefaultColor(guildRole) ? ColorUtils.setAlphaComponent(guildRole.getColor(), 255) : ColorCompat.getThemedColor(renderContext.getContext(), R.attr.theme_chat_mention_foreground)), new BackgroundColorSpan(!RoleUtils.isDefaultColor(guildRole) ? ColorUtils.setAlphaComponent(guildRole.getColor(), 25) : ColorCompat.getThemedColor(renderContext.getContext(), R.attr.theme_chat_mention_background)));
        builder.append((CharSequence) string);
        Iterator it = listListOf.iterator();
        while (it.hasNext()) {
            builder.setSpan(it.next(), length, builder.length(), 33);
        }
    }
}
