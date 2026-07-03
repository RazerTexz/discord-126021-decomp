package com.discord.utilities.textprocessing.node;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import androidx.core.graphics.ColorUtils;
import androidx.exifinterface.media.ExifInterface;
import com.discord.C5419R;
import com.discord.api.role.GuildRole;
import com.discord.simpleast.core.node.Node;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.guilds.RoleUtils;
import com.discord.utilities.textprocessing.node.RoleMentionNode.RenderContext;
import com.discord.widgets.chat.input.MentionUtilsKt;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p580t.C12147n;
import p507d0.p592z.p594d.C12238m;

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
        C12238m.checkNotNullParameter(builder, "builder");
        C12238m.checkNotNullParameter(renderContext, "renderContext");
        int length = builder.length();
        Map<Long, GuildRole> roles = renderContext.getRoles();
        GuildRole guildRole = roles != null ? roles.get(Long.valueOf(this.roleId)) : null;
        if (guildRole == null) {
            builder.append("deleted-role");
            return;
        }
        StringBuilder sbM829Q = C1643a.m829Q(MentionUtilsKt.MENTIONS_CHAR);
        sbM829Q.append(guildRole.getName());
        String string = sbM829Q.toString();
        List listListOf = C12147n.listOf(new StyleSpan(1), new ForegroundColorSpan(!RoleUtils.isDefaultColor(guildRole) ? ColorUtils.setAlphaComponent(guildRole.getColor(), 255) : ColorCompat.getThemedColor(renderContext.getContext(), C5419R.attr.theme_chat_mention_foreground)), new BackgroundColorSpan(!RoleUtils.isDefaultColor(guildRole) ? ColorUtils.setAlphaComponent(guildRole.getColor(), 25) : ColorCompat.getThemedColor(renderContext.getContext(), C5419R.attr.theme_chat_mention_background)));
        builder.append((CharSequence) string);
        Iterator it = listListOf.iterator();
        while (it.hasNext()) {
            builder.setSpan(it.next(), length, builder.length(), 33);
        }
    }
}
