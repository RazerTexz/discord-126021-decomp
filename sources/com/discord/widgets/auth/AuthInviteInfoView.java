package com.discord.widgets.auth;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import b.a.k.b;
import b.d.b.a.a;
import com.discord.R$id;
import com.discord.R$layout;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.guild.Guild;
import com.discord.api.user.User;
import com.discord.databinding.ViewAuthInviteInfoBinding;
import com.discord.models.domain.ModelGuildTemplate;
import com.discord.models.domain.ModelInvite;
import com.discord.models.user.CoreUser;
import com.discord.nullserializable.NullSerializable;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.images.MGImages$ChangeDetector;
import com.facebook.drawee.view.SimpleDraweeView;
import d0.g0.t;
import d0.z.d.m;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: AuthInviteInfoView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class AuthInviteInfoView extends RelativeLayout {
    private final ViewAuthInviteInfoBinding binding;

    public AuthInviteInfoView(Context context) {
        this(context, null, 0, 6, null);
    }

    public AuthInviteInfoView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    public /* synthetic */ AuthInviteInfoView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: Code duplicated, block: B:29:0x0060 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:31:0x0073  */
    /* JADX WARN: Code duplicated, block: B:33:0x0082  */
    /* JADX WARN: Code duplicated, block: B:34:0x0087  */
    private final CharSequence getIntroText(ModelInvite modelInvite) {
        User inviter;
        String username;
        User inviter2 = modelInvite.getInviter();
        String username2 = inviter2 != null ? inviter2.getUsername() : null;
        boolean z2 = username2 != null && (t.isBlank(username2) ^ true);
        if (modelInvite.getChannel() == null && modelInvite.guild == null && z2) {
            Context context = getContext();
            m.checkNotNullExpressionValue(context, "context");
            return b.h(context, 2131892081, new Object[0], null, 4);
        }
        Channel channel = modelInvite.getChannel();
        if (channel == null || !ChannelUtils.z(channel)) {
            if (modelInvite.getApproximateMemberCount() >= 200 || !z2) {
                Context context2 = getContext();
                m.checkNotNullExpressionValue(context2, "context");
                return b.h(context2, 2131892082, new Object[0], null, 4);
            }
            Context context3 = getContext();
            m.checkNotNullExpressionValue(context3, "context");
            return b.h(context3, 2131886920, new Object[]{username2}, null, 4);
        }
        Channel channel2 = modelInvite.getChannel();
        if (channel2 != null) {
            if (!(ChannelUtils.c(channel2).length() == 0)) {
                if (z2) {
                    Context context4 = getContext();
                    m.checkNotNullExpressionValue(context4, "context");
                    Object[] objArr = new Object[1];
                    inviter = modelInvite.getInviter();
                    if (inviter != null) {
                        username = inviter.getUsername();
                    } else {
                        username = null;
                    }
                    objArr[0] = username;
                    return b.h(context4, 2131886920, objArr, null, 4);
                }
            }
        } else if (z2) {
            Context context5 = getContext();
            m.checkNotNullExpressionValue(context5, "context");
            Object[] objArr2 = new Object[1];
            inviter = modelInvite.getInviter();
            if (inviter != null) {
                username = inviter.getUsername();
            } else {
                username = null;
            }
            objArr2[0] = username;
            return b.h(context5, 2131886920, objArr2, null, 4);
        }
        Context context6 = getContext();
        m.checkNotNullExpressionValue(context6, "context");
        return b.h(context6, 2131892084, new Object[0], null, 4);
    }

    public final void configureGuildTemplate(ModelGuildTemplate guildTemplate) {
        m.checkNotNullParameter(guildTemplate, "guildTemplate");
        SimpleDraweeView simpleDraweeView = this.binding.f2174b;
        m.checkNotNullExpressionValue(simpleDraweeView, "binding.authInviteInfoGuildAvatar");
        simpleDraweeView.setVisibility(8);
        ImageView imageView = this.binding.e;
        m.checkNotNullExpressionValue(imageView, "binding.authInviteInfoTemplateIcon");
        imageView.setVisibility(0);
        TextView textView = this.binding.d;
        m.checkNotNullExpressionValue(textView, "binding.authInviteInfoInvitedText");
        b.n(textView, 2131891589, new Object[0], null, 4);
        TextView textView2 = this.binding.c;
        m.checkNotNullExpressionValue(textView2, "binding.authInviteInfoGuildName");
        textView2.setText(guildTemplate.getName());
    }

    public final void configureInvite(ModelInvite invite) {
        String username;
        String discriminator;
        NullSerializable<String> nullSerializableA;
        String username2;
        m.checkNotNullParameter(invite, "invite");
        SimpleDraweeView simpleDraweeView = this.binding.f2174b;
        m.checkNotNullExpressionValue(simpleDraweeView, "binding.authInviteInfoGuildAvatar");
        simpleDraweeView.setVisibility(0);
        ImageView imageView = this.binding.e;
        m.checkNotNullExpressionValue(imageView, "binding.authInviteInfoTemplateIcon");
        imageView.setVisibility(8);
        Channel channel = invite.getChannel();
        Integer numValueOf = channel != null ? Integer.valueOf(channel.getType()) : null;
        if ((numValueOf != null && numValueOf.intValue() == 5) || ((numValueOf != null && numValueOf.intValue() == 0) || ((numValueOf != null && numValueOf.intValue() == 2) || (numValueOf != null && numValueOf.intValue() == 13)))) {
            Guild guild = invite.guild;
            if (guild != null) {
                SimpleDraweeView simpleDraweeView2 = this.binding.f2174b;
                m.checkNotNullExpressionValue(simpleDraweeView2, "binding.authInviteInfoGuildAvatar");
                m.checkNotNullExpressionValue(guild, "inviteGuild");
                IconUtils.setIcon$default(simpleDraweeView2, IconUtils.getForGuild$default(new com.discord.models.guild.Guild(guild), IconUtils.DEFAULT_ICON_BLURPLE, true, null, 8, null), 2131165293, (Function1) null, (MGImages$ChangeDetector) null, 24, (Object) null);
                TextView textView = this.binding.d;
                m.checkNotNullExpressionValue(textView, "binding.authInviteInfoInvitedText");
                textView.setText(b.l(getIntroText(invite), new Object[0], null, 2));
                TextView textView2 = this.binding.c;
                m.checkNotNullExpressionValue(textView2, "binding.authInviteInfoGuildName");
                textView2.setText(guild.getName());
                return;
            }
            return;
        }
        String strC = "";
        if (numValueOf != null && numValueOf.intValue() == 3) {
            User inviter = invite.getInviter();
            if (inviter != null && (username2 = inviter.getUsername()) != null) {
                strC = username2;
            }
            SimpleDraweeView simpleDraweeView3 = this.binding.f2174b;
            m.checkNotNullExpressionValue(simpleDraweeView3, "binding.authInviteInfoGuildAvatar");
            User inviter2 = invite.getInviter();
            IconUtils.setIcon$default(simpleDraweeView3, (inviter2 == null || (nullSerializableA = inviter2.a()) == null) ? null : nullSerializableA.a(), 2131165293, (Function1) null, (MGImages$ChangeDetector) null, 24, (Object) null);
            TextView textView3 = this.binding.d;
            m.checkNotNullExpressionValue(textView3, "binding.authInviteInfoInvitedText");
            textView3.setText(b.l(getIntroText(invite), new Object[0], null, 2));
            TextView textView4 = this.binding.c;
            m.checkNotNullExpressionValue(textView4, "binding.authInviteInfoGuildName");
            Channel channel2 = invite.getChannel();
            if (channel2 != null) {
                if (ChannelUtils.c(channel2).length() > 0) {
                    Channel channel3 = invite.getChannel();
                    strC = channel3 != null ? ChannelUtils.c(channel3) : null;
                }
            }
            textView4.setText(strC);
            return;
        }
        if (numValueOf == null) {
            User inviter3 = invite.getInviter();
            if (inviter3 == null || (username = inviter3.getUsername()) == null) {
                username = "";
            }
            StringBuilder sbX = a.X(username, "#");
            User inviter4 = invite.getInviter();
            if (inviter4 != null && (discriminator = inviter4.getDiscriminator()) != null) {
                strC = discriminator;
            }
            sbX.append(strC);
            String string = sbX.toString();
            SimpleDraweeView simpleDraweeView4 = this.binding.f2174b;
            m.checkNotNullExpressionValue(simpleDraweeView4, "binding.authInviteInfoGuildAvatar");
            User inviter5 = invite.getInviter();
            IconUtils.setIcon$default(simpleDraweeView4, inviter5 != null ? new CoreUser(inviter5) : null, 2131165293, null, null, null, 56, null);
            TextView textView5 = this.binding.d;
            m.checkNotNullExpressionValue(textView5, "binding.authInviteInfoInvitedText");
            textView5.setText(b.l(getIntroText(invite), new Object[0], null, 2));
            TextView textView6 = this.binding.c;
            m.checkNotNullExpressionValue(textView6, "binding.authInviteInfoGuildName");
            textView6.setText(string);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AuthInviteInfoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m.checkNotNullParameter(context, "context");
        View viewInflate = LayoutInflater.from(context).inflate(R$layout.view_auth_invite_info, (ViewGroup) this, false);
        addView(viewInflate);
        int i2 = R$id.auth_invite_info_content;
        LinearLayout linearLayout = (LinearLayout) viewInflate.findViewById(R$id.auth_invite_info_content);
        if (linearLayout != null) {
            i2 = R$id.auth_invite_info_guild_avatar;
            SimpleDraweeView simpleDraweeView = (SimpleDraweeView) viewInflate.findViewById(R$id.auth_invite_info_guild_avatar);
            if (simpleDraweeView != null) {
                i2 = R$id.auth_invite_info_guild_name;
                TextView textView = (TextView) viewInflate.findViewById(R$id.auth_invite_info_guild_name);
                if (textView != null) {
                    i2 = R$id.auth_invite_info_invited_text;
                    TextView textView2 = (TextView) viewInflate.findViewById(R$id.auth_invite_info_invited_text);
                    if (textView2 != null) {
                        i2 = R$id.auth_invite_info_template_icon;
                        ImageView imageView = (ImageView) viewInflate.findViewById(R$id.auth_invite_info_template_icon);
                        if (imageView != null) {
                            ViewAuthInviteInfoBinding viewAuthInviteInfoBinding = new ViewAuthInviteInfoBinding((RelativeLayout) viewInflate, linearLayout, simpleDraweeView, textView, textView2, imageView);
                            m.checkNotNullExpressionValue(viewAuthInviteInfoBinding, "ViewAuthInviteInfoBindin…rom(context), this, true)");
                            this.binding = viewAuthInviteInfoBinding;
                            return;
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i2)));
    }
}
