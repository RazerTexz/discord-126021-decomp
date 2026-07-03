package com.discord.views.user;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import androidx.annotation.ColorInt;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.discord.C5419R;
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
import p007b.p008a.p025i.C1004m1;
import p007b.p109f.p132g.p143f.C1795c;
import p507d0.p579g0.C12103t;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: SettingsMemberView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class SettingsMemberView extends ConstraintLayout {

    /* JADX INFO: renamed from: j, reason: from kotlin metadata */
    public final C1004m1 binding;

    /* JADX INFO: renamed from: k, reason: from kotlin metadata */
    public int avatarBackgroundColor;

    /* JADX INFO: renamed from: l, reason: from kotlin metadata */
    public User user;

    /* JADX INFO: renamed from: m, reason: from kotlin metadata */
    public GuildMember guildMember;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SettingsMemberView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        C12238m.checkNotNullParameter(context, "context");
        LayoutInflater.from(context).inflate(C5419R.layout.settings_member_view, this);
        int i = C5419R.id.large_avatar;
        SimpleDraweeView simpleDraweeView = (SimpleDraweeView) findViewById(C5419R.id.large_avatar);
        if (simpleDraweeView != null) {
            i = C5419R.id.member_subtitle;
            SimpleDraweeSpanTextView simpleDraweeSpanTextView = (SimpleDraweeSpanTextView) findViewById(C5419R.id.member_subtitle);
            if (simpleDraweeSpanTextView != null) {
                i = C5419R.id.member_title;
                UsernameView usernameView = (UsernameView) findViewById(C5419R.id.member_title);
                if (usernameView != null) {
                    C1004m1 c1004m1 = new C1004m1(this, simpleDraweeView, simpleDraweeSpanTextView, usernameView);
                    C12238m.checkNotNullExpressionValue(c1004m1, "SettingsMemberViewBindin…ater.from(context), this)");
                    this.binding = c1004m1;
                    this.avatarBackgroundColor = ColorCompat.getThemedColor(this, C5419R.attr.colorBackgroundPrimary);
                    TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C5419R.a.SettingsMemberView);
                    C12238m.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "context.obtainStyledAttr…eable.SettingsMemberView)");
                    this.avatarBackgroundColor = typedArrayObtainStyledAttributes.getColor(0, ColorCompat.getThemedColor(this, C5419R.attr.colorBackgroundPrimary));
                    typedArrayObtainStyledAttributes.recycle();
                    setAvatarBackgroundColor(this.avatarBackgroundColor);
                    return;
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(i)));
    }

    /* JADX INFO: renamed from: a */
    public final void m8621a(User user, GuildMember guildMember) {
        C12238m.checkNotNullParameter(user, "user");
        this.user = user;
        this.guildMember = guildMember;
        String nick = guildMember != null ? guildMember.getNick() : null;
        boolean z2 = true;
        boolean z3 = !(nick == null || C12103t.isBlank(nick));
        SimpleDraweeView simpleDraweeView = this.binding.f1044b;
        C12238m.checkNotNullExpressionValue(simpleDraweeView, "binding.largeAvatar");
        IconUtils.setIcon$default(simpleDraweeView, user, C5419R.dimen.avatar_size_large, null, null, guildMember, 24, null);
        UsernameView usernameView = this.binding.f1046d;
        if (nick == null) {
            nick = user.getUsername();
        }
        UsernameView.m8566c(usernameView, nick, null, false, null, null, 30);
        UsernameView usernameView2 = this.binding.f1046d;
        boolean isBot = user.getIsBot();
        int i = user.getIsSystemUser() ? C5419R.string.system_dm_tag_system : C5419R.string.bot_tag;
        UserUtils userUtils = UserUtils.INSTANCE;
        usernameView2.m8567a(isBot, i, userUtils.isVerifiedBot(user));
        boolean z4 = guildMember != null && guildMember.hasAvatar();
        DraweeSpanStringBuilder draweeSpanStringBuilder = new DraweeSpanStringBuilder();
        if (z4) {
            int dimension = (int) getResources().getDimension(C5419R.dimen.avatar_size_profile_small);
            Context context = getContext();
            C12238m.checkNotNullExpressionValue(context, "context");
            DraweeSpanStringBuilderExtensionsKt.setAvatar(draweeSpanStringBuilder, context, (32 & 2) != 0 ? null : IconUtils.getForUser$default(user, false, Integer.valueOf(dimension), 2, null), (32 & 4) != 0 ? false : false, (32 & 8) != 0 ? null : Integer.valueOf(dimension), (32 & 16) == 0 ? Integer.valueOf(this.avatarBackgroundColor) : null, (32 & 32) != 0 ? ' ' : (char) 8194);
        }
        draweeSpanStringBuilder.append(UserUtils.getUserNameWithDiscriminator$default(userUtils, user, null, null, 3, null));
        this.binding.f1045c.setDraweeSpanStringBuilder(draweeSpanStringBuilder);
        SimpleDraweeSpanTextView simpleDraweeSpanTextView = this.binding.f1045c;
        C12238m.checkNotNullExpressionValue(simpleDraweeSpanTextView, "binding.memberSubtitle");
        if (!z4 && !z3) {
            z2 = false;
        }
        simpleDraweeSpanTextView.setVisibility(z2 ? 0 : 8);
    }

    public final void setAvatarBackgroundColor(@ColorInt int backgroundColor) {
        GuildMember guildMember;
        this.avatarBackgroundColor = backgroundColor;
        SimpleDraweeView simpleDraweeView = this.binding.f1044b;
        C12238m.checkNotNullExpressionValue(simpleDraweeView, "binding.largeAvatar");
        C1795c c1795cM1124a = C1795c.m1124a(simpleDraweeView.getWidth() / 2);
        C12238m.checkNotNullExpressionValue(c1795cM1124a, "roundingParams");
        c1795cM1124a.f3472b = true;
        c1795cM1124a.f3474d = backgroundColor;
        c1795cM1124a.f3471a = 1;
        SimpleDraweeView simpleDraweeView2 = this.binding.f1044b;
        C12238m.checkNotNullExpressionValue(simpleDraweeView2, "binding.largeAvatar");
        GenericDraweeHierarchy hierarchy = simpleDraweeView2.getHierarchy();
        C12238m.checkNotNullExpressionValue(hierarchy, "binding.largeAvatar.hierarchy");
        hierarchy.m8683s(c1795cM1124a);
        User user = this.user;
        if (user == null || (guildMember = this.guildMember) == null) {
            return;
        }
        m8621a(user, guildMember);
    }
}
