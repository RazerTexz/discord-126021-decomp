package com.discord.widgets.roles;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import b.a.k.FormatUtils;
import com.discord.R;
import com.discord.api.role.GuildRole;
import com.discord.databinding.RoleIconViewBinding;
import com.discord.models.domain.emoji.ModelEmojiUnicode;
import com.discord.models.guild.Guild;
import com.discord.stores.StoreStream;
import com.discord.utilities.dimen.DimenUtils;
import com.discord.utilities.guilds.GuildUtils;
import com.discord.utilities.guilds.RoleIconUtils;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.images.MGImages;
import com.discord.utilities.textprocessing.AstRenderer;
import com.discord.utilities.textprocessing.node.EmojiNode;
import com.discord.utilities.view.ToastManager;
import com.facebook.drawee.view.SimpleDraweeView;
import d0.g0.StringsJVM;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.Collections;
import java.util.Set;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;

/* JADX INFO: compiled from: RoleIconView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class RoleIconView extends FrameLayout {
    private final RoleIconViewBinding binding;

    /* JADX INFO: renamed from: com.discord.widgets.roles.RoleIconView$showRoleIconToast$1, reason: invalid class name */
    /* JADX INFO: compiled from: RoleIconView.kt */
    public static final class AnonymousClass1 extends Lambda implements Function3<Boolean, Integer, Context, String> {
        public final /* synthetic */ GuildRole $role;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(GuildRole guildRole) {
            super(3);
            this.$role = guildRole;
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ String invoke(Boolean bool, Integer num, Context context) {
            return invoke(bool.booleanValue(), num.intValue(), context);
        }

        public final String invoke(boolean z2, int i, Context context) {
            Intrinsics3.checkNotNullParameter(context, "<anonymous parameter 2>");
            IconUtils iconUtils = IconUtils.INSTANCE;
            long id2 = this.$role.getId();
            String icon = this.$role.getIcon();
            Intrinsics3.checkNotNull(icon);
            return IconUtils.getRoleIconUrl$default(iconUtils, id2, icon, null, 4, null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RoleIconView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics3.checkNotNullParameter(context, "context");
        Intrinsics3.checkNotNullParameter(attributeSet, "attrs");
        LayoutInflater.from(context).inflate(R.layout.role_icon_view, this);
        SimpleDraweeView simpleDraweeView = (SimpleDraweeView) findViewById(R.id.role_icon_iv);
        if (simpleDraweeView == null) {
            throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(R.id.role_icon_iv)));
        }
        RoleIconViewBinding roleIconViewBinding = new RoleIconViewBinding(this, simpleDraweeView);
        Intrinsics3.checkNotNullExpressionValue(roleIconViewBinding, "RoleIconViewBinding.infl…ater.from(context), this)");
        this.binding = roleIconViewBinding;
    }

    private final boolean hasIcon(GuildRole guildRole) {
        if (guildRole.getIcon() != null) {
            String icon = guildRole.getIcon();
            Intrinsics3.checkNotNull(icon);
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
            Intrinsics3.checkNotNull(unicodeEmoji);
            if (unicodeEmoji.length() > 0) {
                return true;
            }
        }
        return false;
    }

    private final void setIcon(GuildRole guildRole) {
        if (hasIcon(guildRole)) {
            SimpleDraweeView simpleDraweeView = this.binding.f2139b;
            Intrinsics3.checkNotNullExpressionValue(simpleDraweeView, "binding.roleIconIv");
            IconUtils.setIcon$default(simpleDraweeView, guildRole, R.dimen.role_icon_size, (MGImages.ChangeDetector) null, 8, (Object) null);
        } else if (hasUnicodeEmoji(guildRole)) {
            ModelEmojiUnicode modelEmojiUnicode = StoreStream.INSTANCE.getEmojis().getUnicodeEmojiSurrogateMap().get(guildRole.getUnicodeEmoji());
            String imageUri = ModelEmojiUnicode.getImageUri(modelEmojiUnicode != null ? modelEmojiUnicode.getCodePoints() : null, getContext());
            SimpleDraweeView simpleDraweeView2 = this.binding.f2139b;
            Intrinsics3.checkNotNullExpressionValue(simpleDraweeView2, "binding.roleIconIv");
            IconUtils.setIcon$default(simpleDraweeView2, imageUri, 0, (Function1) null, (MGImages.ChangeDetector) null, 28, (Object) null);
        }
    }

    private final void showRoleIconToast(final Context context, GuildRole role) {
        EmojiNode emojiNodeFrom;
        ModelEmojiUnicode modelEmojiUnicode;
        if (hasIcon(role)) {
            emojiNodeFrom = new EmojiNode(role.getName(), new AnonymousClass1(role), new EmojiNode.EmojiIdAndType.Unicode(""), DimenUtils.dpToPixels(24), DimenUtils.dpToPixels(24));
        } else {
            emojiNodeFrom = (!hasUnicodeEmoji(role) || (modelEmojiUnicode = StoreStream.INSTANCE.getEmojis().getUnicodeEmojiSurrogateMap().get(role.getUnicodeEmoji())) == null) ? null : EmojiNode.INSTANCE.from(modelEmojiUnicode, DimenUtils.dpToPixels(24));
        }
        if (emojiNodeFrom == null) {
            return;
        }
        EmojiNode.RenderContext renderContext = new EmojiNode.RenderContext(context) { // from class: com.discord.widgets.roles.RoleIconView$showRoleIconToast$renderContext$1
            public final /* synthetic */ Context $context;

            @SuppressLint({"StaticFieldLeak"})
            private final Context context;
            private final boolean isAnimationEnabled;

            {
                this.$context = context;
                this.context = context;
            }

            @Override // com.discord.utilities.textprocessing.node.EmojiNode.RenderContext
            public Context getContext() {
                return this.context;
            }

            @Override // com.discord.utilities.textprocessing.node.EmojiNode.RenderContext
            /* JADX INFO: renamed from: isAnimationEnabled, reason: from getter */
            public boolean getIsAnimationEnabled() {
                return this.isAnimationEnabled;
            }

            @Override // com.discord.utilities.textprocessing.node.EmojiNode.RenderContext
            public void onEmojiClicked(EmojiNode.EmojiIdAndType emojiIdAndType) {
                Intrinsics3.checkNotNullParameter(emojiIdAndType, "emojiIdAndType");
                EmojiNode.RenderContext.DefaultImpls.onEmojiClicked(this, emojiIdAndType);
            }
        };
        Set setSingleton = Collections.singleton(emojiNodeFrom);
        Intrinsics3.checkNotNullExpressionValue(setSingleton, "Collections.singleton(iconNode)");
        ToastManager.show$default(new ToastManager(), context, AstRenderer.render(setSingleton, renderContext).append((CharSequence) " ").append(FormatUtils.b(context, R.string.role_icon_toast_message, new Object[]{role.getName()}, (4 & 4) != 0 ? FormatUtils.b.j : null)), 0, 4, (Object) null);
    }

    public final void setRole(final GuildRole role, Long guildId) {
        Guild guild = guildId != null ? StoreStream.INSTANCE.getGuilds().getGuild(guildId.longValue()) : null;
        if (role == null || !hasIconOrUnicodeEmoji(role) || guild == null || !RoleIconUtils.INSTANCE.canUseRoleIcons(guild, role)) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        setIcon(role);
        Context context = getContext();
        Intrinsics3.checkNotNullExpressionValue(context, "context");
        setContentDescription(FormatUtils.b(context, R.string.role_icon_alt_text, new Object[]{role.getName()}, (4 & 4) != 0 ? FormatUtils.b.j : null));
        setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.roles.RoleIconView.setRole.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RoleIconView roleIconView = RoleIconView.this;
                Context context2 = roleIconView.getContext();
                Intrinsics3.checkNotNullExpressionValue(context2, "context");
                roleIconView.showRoleIconToast(context2, role);
            }
        });
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
        if (icon == null || StringsJVM.isBlank(icon)) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        SimpleDraweeView simpleDraweeView = this.binding.f2139b;
        Intrinsics3.checkNotNullExpressionValue(simpleDraweeView, "binding.roleIconIv");
        IconUtils.setIcon$default(simpleDraweeView, icon, R.dimen.role_icon_size, (Function1) null, (MGImages.ChangeDetector) null, 24, (Object) null);
    }

    public final void setRole(Long roleId, Long guildId) {
        setRole(GuildUtils.getGuildRole(roleId), guildId);
    }
}
