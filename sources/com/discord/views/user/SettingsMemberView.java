package com.discord.views.user;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import androidx.annotation.ColorInt;
import androidx.constraintlayout.widget.ConstraintLayout;
import b.a.i.m1;
import b.f.g.f.c;
import com.discord.R$a;
import com.discord.R$id;
import com.discord.R$layout;
import com.discord.models.member.GuildMember;
import com.discord.models.user.User;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.user.UserUtils;
import com.discord.views.UsernameView;
import com.discord.widgets.user.profile.DraweeSpanStringBuilderExtensionsKt;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.span.DraweeSpanStringBuilder;
import com.facebook.drawee.span.SimpleDraweeSpanTextView;
import com.facebook.drawee.view.SimpleDraweeView;
import d0.g0.t;
import d0.z.d.m;

/* JADX INFO: compiled from: SettingsMemberView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class SettingsMemberView extends ConstraintLayout {

    /* JADX INFO: renamed from: j, reason: from kotlin metadata */
    public final m1 binding;

    /* JADX INFO: renamed from: k, reason: from kotlin metadata */
    public int avatarBackgroundColor;

    /* JADX INFO: renamed from: l, reason: from kotlin metadata */
    public User user;

    /* JADX INFO: renamed from: m, reason: from kotlin metadata */
    public GuildMember guildMember;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SettingsMemberView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        m.checkNotNullParameter(context, "context");
        LayoutInflater.from(context).inflate(R$layout.settings_member_view, this);
        int i = R$id.large_avatar;
        SimpleDraweeView simpleDraweeView = (SimpleDraweeView) findViewById(R$id.large_avatar);
        if (simpleDraweeView != null) {
            i = R$id.member_subtitle;
            SimpleDraweeSpanTextView simpleDraweeSpanTextView = (SimpleDraweeSpanTextView) findViewById(R$id.member_subtitle);
            if (simpleDraweeSpanTextView != null) {
                i = R$id.member_title;
                UsernameView usernameView = (UsernameView) findViewById(R$id.member_title);
                if (usernameView != null) {
                    m1 m1Var = new m1(this, simpleDraweeView, simpleDraweeSpanTextView, usernameView);
                    m.checkNotNullExpressionValue(m1Var, "SettingsMemberViewBindin…ater.from(context), this)");
                    this.binding = m1Var;
                    this.avatarBackgroundColor = ColorCompat.getThemedColor(this, 2130968911);
                    TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$a.SettingsMemberView);
                    m.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "context.obtainStyledAttr…eable.SettingsMemberView)");
                    this.avatarBackgroundColor = typedArrayObtainStyledAttributes.getColor(0, ColorCompat.getThemedColor(this, 2130968911));
                    typedArrayObtainStyledAttributes.recycle();
                    setAvatarBackgroundColor(this.avatarBackgroundColor);
                    return;
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(i)));
    }

    public final void a(User user, GuildMember guildMember) {
        m.checkNotNullParameter(user, "user");
        this.user = user;
        this.guildMember = guildMember;
        String nick = guildMember != null ? guildMember.getNick() : null;
        boolean z2 = true;
        boolean z3 = !(nick == null || t.isBlank(nick));
        SimpleDraweeView simpleDraweeView = this.binding.f158b;
        m.checkNotNullExpressionValue(simpleDraweeView, "binding.largeAvatar");
        IconUtils.setIcon$default(simpleDraweeView, user, 2131165293, null, null, guildMember, 24, null);
        UsernameView usernameView = this.binding.d;
        if (nick == null) {
            nick = user.getUsername();
        }
        UsernameView.c(usernameView, nick, null, false, null, null, 30);
        UsernameView usernameView2 = this.binding.d;
        boolean isBot = user.getIsBot();
        int i = user.getIsSystemUser() ? 2131896165 : 2131887281;
        UserUtils userUtils = UserUtils.INSTANCE;
        usernameView2.a(isBot, i, userUtils.isVerifiedBot(user));
        boolean z4 = guildMember != null && guildMember.hasAvatar();
        DraweeSpanStringBuilder draweeSpanStringBuilder = new DraweeSpanStringBuilder();
        if (z4) {
            int dimension = (int) getResources().getDimension(2131165295);
            Context context = getContext();
            m.checkNotNullExpressionValue(context, "context");
            DraweeSpanStringBuilderExtensionsKt.setAvatar$default(draweeSpanStringBuilder, context, IconUtils.getForUser$default(user, false, Integer.valueOf(dimension), 2, null), false, Integer.valueOf(dimension), Integer.valueOf(this.avatarBackgroundColor), (char) 8194, 4, null);
        }
        draweeSpanStringBuilder.append(UserUtils.getUserNameWithDiscriminator$default(userUtils, user, null, null, 3, null));
        this.binding.c.setDraweeSpanStringBuilder(draweeSpanStringBuilder);
        SimpleDraweeSpanTextView simpleDraweeSpanTextView = this.binding.c;
        m.checkNotNullExpressionValue(simpleDraweeSpanTextView, "binding.memberSubtitle");
        if (!z4 && !z3) {
            z2 = false;
        }
        simpleDraweeSpanTextView.setVisibility(z2 ? 0 : 8);
    }

    public final void setAvatarBackgroundColor(@ColorInt int backgroundColor) {
        GuildMember guildMember;
        this.avatarBackgroundColor = backgroundColor;
        SimpleDraweeView simpleDraweeView = this.binding.f158b;
        m.checkNotNullExpressionValue(simpleDraweeView, "binding.largeAvatar");
        c cVarA = c.a(simpleDraweeView.getWidth() / 2);
        m.checkNotNullExpressionValue(cVarA, "roundingParams");
        cVarA.f523b = true;
        cVarA.d = backgroundColor;
        cVarA.a = 1;
        SimpleDraweeView simpleDraweeView2 = this.binding.f158b;
        m.checkNotNullExpressionValue(simpleDraweeView2, "binding.largeAvatar");
        GenericDraweeHierarchy hierarchy = simpleDraweeView2.getHierarchy();
        m.checkNotNullExpressionValue(hierarchy, "binding.largeAvatar.hierarchy");
        hierarchy.s(cVarA);
        User user = this.user;
        if (user == null || (guildMember = this.guildMember) == null) {
            return;
        }
        a(user, guildMember);
    }
}
