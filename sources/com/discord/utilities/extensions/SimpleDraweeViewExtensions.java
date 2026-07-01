package com.discord.utilities.extensions;

import android.content.Context;
import androidx.annotation.ColorInt;
import androidx.annotation.DimenRes;
import com.discord.R;
import com.discord.models.guild.Guild;
import com.discord.models.guild.UserGuildMember;
import com.discord.models.member.GuildMember;
import com.discord.models.user.User;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.images.MGImages;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import d0.z.d.Intrinsics3;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: com.discord.utilities.extensions.SimpleDraweeViewExtensionsKt, reason: use source file name */
/* JADX INFO: compiled from: SimpleDraweeViewExtensions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class SimpleDraweeViewExtensions {
    public static final void configureCreator(SimpleDraweeView simpleDraweeView, UserGuildMember userGuildMember) {
        Intrinsics3.checkNotNullParameter(simpleDraweeView, "$this$configureCreator");
        simpleDraweeView.setVisibility(userGuildMember != null ? 0 : 8);
        if (simpleDraweeView.getVisibility() == 0) {
            setAvatar(simpleDraweeView, userGuildMember != null ? userGuildMember.getUser() : null, false, R.dimen.avatar_size_event_creator, userGuildMember != null ? userGuildMember.getGuildMember() : null);
        }
    }

    public static final void setAvatar(SimpleDraweeView simpleDraweeView, User user, boolean z2, @DimenRes int i, GuildMember guildMember) {
        Intrinsics3.checkNotNullParameter(simpleDraweeView, "$this$setAvatar");
        int dimensionPixelSize = simpleDraweeView.getResources().getDimensionPixelSize(i);
        String forGuildMemberOrUser = IconUtils.INSTANCE.getForGuildMemberOrUser(user, guildMember, dimensionPixelSize > 0 ? Integer.valueOf(IconUtils.getMediaProxySize(dimensionPixelSize)) : null, z2);
        if (!Intrinsics3.areEqual(forGuildMemberOrUser, simpleDraweeView.getTag(R.id.uikit_icon_url))) {
            simpleDraweeView.setTag(R.id.uikit_icon_url, forGuildMemberOrUser);
            IconUtils.setIcon$default(simpleDraweeView, forGuildMemberOrUser, i, (Function1) null, (MGImages.ChangeDetector) null, 24, (Object) null);
        }
    }

    public static /* synthetic */ void setAvatar$default(SimpleDraweeView simpleDraweeView, User user, boolean z2, int i, GuildMember guildMember, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z2 = false;
        }
        if ((i2 & 4) != 0) {
            i = R.dimen.avatar_size_unrestricted;
        }
        if ((i2 & 8) != 0) {
            guildMember = null;
        }
        setAvatar(simpleDraweeView, user, z2, i, guildMember);
    }

    public static final void setGuildIcon(SimpleDraweeView simpleDraweeView, boolean z2, Guild guild, float f, Integer num, @ColorInt Integer num2, @ColorInt Integer num3, Float f2, boolean z3, Function1<? super ImageRequestBuilder, Unit> function1) {
        String string;
        Intrinsics3.checkNotNullParameter(simpleDraweeView, "$this$setGuildIcon");
        String forGuild = IconUtils.getForGuild(guild, IconUtils.DEFAULT_ICON_BLURPLE, z3, num);
        if (!Intrinsics3.areEqual(forGuild, simpleDraweeView.getTag(R.id.uikit_icon_url))) {
            simpleDraweeView.setTag(R.id.uikit_icon_url, forGuild);
            IconUtils.setIcon$default(simpleDraweeView, forGuild, 0, function1, (MGImages.ChangeDetector) null, 20, (Object) null);
        }
        MGImages.setRoundingParams(simpleDraweeView, f, !z2, num2, num3, f2);
        if (guild == null || (string = guild.getName()) == null) {
            Context context = simpleDraweeView.getContext();
            string = context != null ? context.getString(R.string.home) : null;
        }
        simpleDraweeView.setContentDescription(string);
    }
}
