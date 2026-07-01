package com.discord.widgets.roles;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import b.a.k.b;
import com.discord.R$id;
import com.discord.R$layout;
import com.discord.api.role.GuildRole;
import com.discord.databinding.RoleIconViewBinding;
import com.discord.models.domain.emoji.ModelEmojiUnicode;
import com.discord.models.guild.Guild;
import com.discord.stores.StoreStream;
import com.discord.utilities.dimen.DimenUtils;
import com.discord.utilities.guilds.GuildUtilsKt;
import com.discord.utilities.guilds.RoleIconUtils;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.images.MGImages$ChangeDetector;
import com.discord.utilities.textprocessing.AstRenderer;
import com.discord.utilities.textprocessing.node.EmojiNode;
import com.discord.utilities.textprocessing.node.EmojiNode$EmojiIdAndType$Unicode;
import com.discord.utilities.view.ToastManager;
import com.facebook.drawee.view.SimpleDraweeView;
import d0.g0.t;
import d0.z.d.m;
import java.util.Collections;
import java.util.Set;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: RoleIconView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class RoleIconView extends FrameLayout {
    private final RoleIconViewBinding binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RoleIconView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m.checkNotNullParameter(context, "context");
        m.checkNotNullParameter(attributeSet, "attrs");
        LayoutInflater.from(context).inflate(R$layout.role_icon_view, this);
        SimpleDraweeView simpleDraweeView = (SimpleDraweeView) findViewById(R$id.role_icon_iv);
        if (simpleDraweeView == null) {
            throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(R$id.role_icon_iv)));
        }
        RoleIconViewBinding roleIconViewBinding = new RoleIconViewBinding(this, simpleDraweeView);
        m.checkNotNullExpressionValue(roleIconViewBinding, "RoleIconViewBinding.infl…ater.from(context), this)");
        this.binding = roleIconViewBinding;
    }

    public static final /* synthetic */ void access$showRoleIconToast(RoleIconView roleIconView, Context context, GuildRole guildRole) {
        roleIconView.showRoleIconToast(context, guildRole);
    }

    private final boolean hasIcon(GuildRole guildRole) {
        if (guildRole.getIcon() != null) {
            String icon = guildRole.getIcon();
            m.checkNotNull(icon);
            if (icon.length() > 0) {
                return true;
            }
        }
        return false;
    }

    private final boolean hasIconOrUnicodeEmoji(GuildRole guildRole) {
        return hasIcon(guildRole) || hasUnicodeEmoji(guildRole);
    }

    private final boolean hasUnicodeEmoji(GuildRole guildRole) {
        if (guildRole.getUnicodeEmoji() != null) {
            String unicodeEmoji = guildRole.getUnicodeEmoji();
            m.checkNotNull(unicodeEmoji);
            if (unicodeEmoji.length() > 0) {
                return true;
            }
        }
        return false;
    }

    private final void setIcon(GuildRole guildRole) {
        if (hasIcon(guildRole)) {
            SimpleDraweeView simpleDraweeView = this.binding.f2139b;
            m.checkNotNullExpressionValue(simpleDraweeView, "binding.roleIconIv");
            IconUtils.setIcon$default(simpleDraweeView, guildRole, 2131165732, (MGImages$ChangeDetector) null, 8, (Object) null);
        } else if (hasUnicodeEmoji(guildRole)) {
            ModelEmojiUnicode modelEmojiUnicode = StoreStream.Companion.getEmojis().getUnicodeEmojiSurrogateMap().get(guildRole.getUnicodeEmoji());
            String imageUri = ModelEmojiUnicode.getImageUri(modelEmojiUnicode != null ? modelEmojiUnicode.getCodePoints() : null, getContext());
            SimpleDraweeView simpleDraweeView2 = this.binding.f2139b;
            m.checkNotNullExpressionValue(simpleDraweeView2, "binding.roleIconIv");
            IconUtils.setIcon$default(simpleDraweeView2, imageUri, 0, (Function1) null, (MGImages$ChangeDetector) null, 28, (Object) null);
        }
    }

    private final void showRoleIconToast(Context context, GuildRole role) {
        EmojiNode emojiNodeFrom;
        ModelEmojiUnicode modelEmojiUnicode;
        if (hasIcon(role)) {
            emojiNodeFrom = new EmojiNode(role.getName(), new RoleIconView$showRoleIconToast$1(role), new EmojiNode$EmojiIdAndType$Unicode(""), DimenUtils.dpToPixels(24), DimenUtils.dpToPixels(24));
        } else {
            emojiNodeFrom = (!hasUnicodeEmoji(role) || (modelEmojiUnicode = StoreStream.Companion.getEmojis().getUnicodeEmojiSurrogateMap().get(role.getUnicodeEmoji())) == null) ? null : EmojiNode.Companion.from(modelEmojiUnicode, DimenUtils.dpToPixels(24));
        }
        if (emojiNodeFrom == null) {
            return;
        }
        RoleIconView$showRoleIconToast$renderContext$1 roleIconView$showRoleIconToast$renderContext$1 = new RoleIconView$showRoleIconToast$renderContext$1(context);
        Set setSingleton = Collections.singleton(emojiNodeFrom);
        m.checkNotNullExpressionValue(setSingleton, "Collections.singleton(iconNode)");
        ToastManager.show$default(new ToastManager(), context, AstRenderer.render(setSingleton, roleIconView$showRoleIconToast$renderContext$1).append((CharSequence) " ").append(b.h(context, 2131894936, new Object[]{role.getName()}, null, 4)), 0, 4, (Object) null);
    }

    public final void setRole(GuildRole role, Long guildId) {
        Guild guild = guildId != null ? StoreStream.Companion.getGuilds().getGuild(guildId.longValue()) : null;
        if (role == null || !hasIconOrUnicodeEmoji(role) || guild == null || !RoleIconUtils.INSTANCE.canUseRoleIcons(guild, role)) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        setIcon(role);
        Context context = getContext();
        m.checkNotNullExpressionValue(context, "context");
        setContentDescription(b.h(context, 2131894929, new Object[]{role.getName()}, null, 4));
        setOnClickListener(new RoleIconView$setRole$1(this, role));
    }

    public final void setRoleIconPreview(GuildRole guildRole) {
        if (guildRole == null || !hasIconOrUnicodeEmoji(guildRole)) {
            setVisibility(8);
        } else {
            setVisibility(0);
            setIcon(guildRole);
        }
    }

    public final void setRoleIconPreview(String icon) {
        if (icon == null || t.isBlank(icon)) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        SimpleDraweeView simpleDraweeView = this.binding.f2139b;
        m.checkNotNullExpressionValue(simpleDraweeView, "binding.roleIconIv");
        IconUtils.setIcon$default(simpleDraweeView, icon, 2131165732, (Function1) null, (MGImages$ChangeDetector) null, 24, (Object) null);
    }

    public final void setRole(Long roleId, Long guildId) {
        setRole(GuildUtilsKt.getGuildRole(roleId), guildId);
    }
}
