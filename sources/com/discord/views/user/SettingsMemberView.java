package com.discord.views.user;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import androidx.annotation.ColorInt;
import androidx.constraintlayout.widget.ConstraintLayout;
import b.a.i.SettingsMemberViewBinding;
import b.f.g.f.RoundingParams;
import com.discord.R;
import com.discord.models.member.GuildMember;
import com.discord.models.user.User;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.user.UserUtils;
import com.discord.views.UsernameView;
import com.discord.widgets.user.profile.DraweeSpanStringBuilderExtensions;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.span.DraweeSpanStringBuilder;
import com.facebook.drawee.span.SimpleDraweeSpanTextView;
import com.facebook.drawee.view.SimpleDraweeView;
import d0.g0.StringsJVM;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: SettingsMemberView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class SettingsMemberView extends ConstraintLayout {

    /* JADX INFO: renamed from: j, reason: from kotlin metadata */
    public final SettingsMemberViewBinding binding;

    /* JADX INFO: renamed from: k, reason: from kotlin metadata */
    public int avatarBackgroundColor;

    /* JADX INFO: renamed from: l, reason: from kotlin metadata */
    public User user;

    /* JADX INFO: renamed from: m, reason: from kotlin metadata */
    public GuildMember guildMember;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SettingsMemberView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        Intrinsics3.checkNotNullParameter(context, "context");
        LayoutInflater.from(context).inflate(R.layout.settings_member_view, this);
        int i = R.id.large_avatar;
        SimpleDraweeView simpleDraweeView = (SimpleDraweeView) findViewById(R.id.large_avatar);
        if (simpleDraweeView != null) {
            i = R.id.member_subtitle;
            SimpleDraweeSpanTextView simpleDraweeSpanTextView = (SimpleDraweeSpanTextView) findViewById(R.id.member_subtitle);
            if (simpleDraweeSpanTextView != null) {
                i = R.id.member_title;
                UsernameView usernameView = (UsernameView) findViewById(R.id.member_title);
                if (usernameView != null) {
                    SettingsMemberViewBinding settingsMemberViewBinding = new SettingsMemberViewBinding(this, simpleDraweeView, simpleDraweeSpanTextView, usernameView);
                    Intrinsics3.checkNotNullExpressionValue(settingsMemberViewBinding, "SettingsMemberViewBindin…ater.from(context), this)");
                    this.binding = settingsMemberViewBinding;
                    this.avatarBackgroundColor = ColorCompat.getThemedColor(this, R.attr.colorBackgroundPrimary);
                    TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.a.SettingsMemberView);
                    Intrinsics3.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "context.obtainStyledAttr…eable.SettingsMemberView)");
                    this.avatarBackgroundColor = typedArrayObtainStyledAttributes.getColor(0, ColorCompat.getThemedColor(this, R.attr.colorBackgroundPrimary));
                    typedArrayObtainStyledAttributes.recycle();
                    setAvatarBackgroundColor(this.avatarBackgroundColor);
                    return;
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(i)));
    }

    public final void a(User user, GuildMember guildMember) {
        Intrinsics3.checkNotNullParameter(user, "user");
        this.user = user;
        this.guildMember = guildMember;
        String nick = guildMember != null ? guildMember.getNick() : null;
        boolean z2 = true;
        boolean z3 = !(nick == null || StringsJVM.isBlank(nick));
        SimpleDraweeView simpleDraweeView = this.binding.f158b;
        Intrinsics3.checkNotNullExpressionValue(simpleDraweeView, "binding.largeAvatar");
        IconUtils.setIcon$default(simpleDraweeView, user, R.dimen.avatar_size_large, null, null, guildMember, 24, null);
        UsernameView usernameView = this.binding.d;
        if (nick == null) {
            nick = user.getUsername();
        }
        UsernameView.c(usernameView, nick, null, false, null, null, 30);
        UsernameView usernameView2 = this.binding.d;
        boolean isBot = user.getIsBot();
        int i = user.getIsSystemUser() ? R.string.system_dm_tag_system : R.string.bot_tag;
        UserUtils userUtils = UserUtils.INSTANCE;
        usernameView2.a(isBot, i, userUtils.isVerifiedBot(user));
        boolean z4 = guildMember != null && guildMember.hasAvatar();
        DraweeSpanStringBuilder draweeSpanStringBuilder = new DraweeSpanStringBuilder();
        if (z4) {
            int dimension = (int) getResources().getDimension(R.dimen.avatar_size_profile_small);
            Context context = getContext();
            Intrinsics3.checkNotNullExpressionValue(context, "context");
            DraweeSpanStringBuilderExtensions.setAvatar(draweeSpanStringBuilder, context, (32 & 2) != 0 ? null : IconUtils.getForUser$default(user, false, Integer.valueOf(dimension), 2, null), (32 & 4) != 0 ? false : false, (32 & 8) != 0 ? null : Integer.valueOf(dimension), (32 & 16) == 0 ? Integer.valueOf(this.avatarBackgroundColor) : null, (32 & 32) != 0 ? ' ' : (char) 8194);
        }
        draweeSpanStringBuilder.append(UserUtils.getUserNameWithDiscriminator$default(userUtils, user, null, null, 3, null));
        this.binding.c.setDraweeSpanStringBuilder(draweeSpanStringBuilder);
        SimpleDraweeSpanTextView simpleDraweeSpanTextView = this.binding.c;
        Intrinsics3.checkNotNullExpressionValue(simpleDraweeSpanTextView, "binding.memberSubtitle");
        if (!z4 && !z3) {
            z2 = false;
        }
        simpleDraweeSpanTextView.setVisibility(z2 ? 0 : 8);
    }

    public final void setAvatarBackgroundColor(@ColorInt int backgroundColor) {
        GuildMember guildMember;
        this.avatarBackgroundColor = backgroundColor;
        SimpleDraweeView simpleDraweeView = this.binding.f158b;
        Intrinsics3.checkNotNullExpressionValue(simpleDraweeView, "binding.largeAvatar");
        RoundingParams roundingParamsA = RoundingParams.a(simpleDraweeView.getWidth() / 2);
        Intrinsics3.checkNotNullExpressionValue(roundingParamsA, "roundingParams");
        roundingParamsA.f523b = true;
        roundingParamsA.d = backgroundColor;
        roundingParamsA.a = 1;
        SimpleDraweeView simpleDraweeView2 = this.binding.f158b;
        Intrinsics3.checkNotNullExpressionValue(simpleDraweeView2, "binding.largeAvatar");
        GenericDraweeHierarchy hierarchy = simpleDraweeView2.getHierarchy();
        Intrinsics3.checkNotNullExpressionValue(hierarchy, "binding.largeAvatar.hierarchy");
        hierarchy.s(roundingParamsA);
        User user = this.user;
        if (user == null || (guildMember = this.guildMember) == null) {
            return;
        }
        a(user, guildMember);
    }
}
