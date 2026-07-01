package com.discord.widgets.guilds.invite;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import b.a.k.b;
import b.d.b.a.a;
import com.discord.R$a;
import com.discord.R$id;
import com.discord.R$layout;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.guild.Guild;
import com.discord.api.guild.GuildFeature;
import com.discord.api.user.User;
import com.discord.databinding.WidgetGuildInviteInfoViewBinding;
import com.discord.models.domain.ModelInvite;
import com.discord.models.user.CoreUser;
import com.discord.models.user.MeUser;
import com.discord.stores.StoreStream;
import com.discord.utilities.dimen.DimenUtils;
import com.discord.utilities.drawable.DrawableCompat;
import com.discord.utilities.error.Error;
import com.discord.utilities.error.Error$Response;
import com.discord.utilities.guilds.GuildUtilsKt;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.images.MGImages;
import com.discord.utilities.images.MGImages$ChangeDetector;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.views.GuildView;
import com.discord.views.guilds.ServerMemberCount;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.button.MaterialButton;
import d0.z.d.m;
import java.util.List;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetInviteInfo.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetInviteInfo extends ConstraintLayout {
    private final WidgetGuildInviteInfoViewBinding binding;

    public WidgetInviteInfo(Context context) {
        this(context, null, 0, 6, null);
    }

    public WidgetInviteInfo(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    public /* synthetic */ WidgetInviteInfo(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    public static final /* synthetic */ WidgetGuildInviteInfoViewBinding access$getBinding$p(WidgetInviteInfo widgetInviteInfo) {
        return widgetInviteInfo.binding;
    }

    private final void configureForDirectFriend(ModelInvite model) {
        GuildView guildView = this.binding.c;
        User inviter = model.getInviter();
        String forUser$default = IconUtils.getForUser$default(inviter != null ? new CoreUser(inviter) : null, true, null, 4, null);
        int i = GuildView.j;
        guildView.a(forUser$default, null);
        User inviter2 = model.getInviter();
        String username = inviter2 != null ? inviter2.getUsername() : null;
        if (username == null) {
            username = "";
        }
        StringBuilder sb = new StringBuilder();
        User inviter3 = model.getInviter();
        String username2 = inviter3 != null ? inviter3.getUsername() : null;
        if (username2 == null) {
            username2 = "";
        }
        sb.append(username2);
        sb.append("#");
        User inviter4 = model.getInviter();
        String discriminator = inviter4 != null ? inviter4.getDiscriminator() : null;
        sb.append(discriminator != null ? discriminator : "");
        String string = sb.toString();
        SimpleDraweeView simpleDraweeView = this.binding.d;
        m.checkNotNullExpressionValue(simpleDraweeView, "binding.inviteAvatarSmall");
        simpleDraweeView.setVisibility(8);
        ServerMemberCount serverMemberCount = this.binding.e;
        m.checkNotNullExpressionValue(serverMemberCount, "binding.inviteMemberContainerLayout");
        serverMemberCount.setVisibility(8);
        TextView textView = this.binding.g;
        m.checkNotNullExpressionValue(textView, "binding.inviteTitle");
        textView.setText(getInviteTitleForDirectFriend(username));
        this.binding.g.setTextSize(2, 26.0f);
        TextView textView2 = this.binding.f;
        m.checkNotNullExpressionValue(textView2, "binding.inviteMessage");
        textView2.setText(getInviteSubtitleForDirectFriend(string));
        this.binding.f.setTextSize(2, 18.0f);
    }

    /* JADX WARN: Code duplicated, block: B:32:0x006f  */
    private final void configureForGDM(ModelInvite model) {
        boolean z2;
        String icon;
        Channel channel = model.getChannel();
        if (channel != null) {
            m.checkNotNullExpressionValue(channel, "model.channel ?: return");
            SimpleDraweeView simpleDraweeView = this.binding.d;
            m.checkNotNullExpressionValue(simpleDraweeView, "binding.inviteAvatarSmall");
            User inviter = model.getInviter();
            IconUtils.setIcon$default(simpleDraweeView, inviter != null ? new CoreUser(inviter) : null, 2131165291, null, null, null, 56, null);
            User inviter2 = model.getInviter();
            String username = inviter2 != null ? inviter2.getUsername() : null;
            if (username == null) {
                username = "";
            }
            String strC = ChannelUtils.c(channel).length() > 0 ? ChannelUtils.c(channel) : username;
            if (ChannelUtils.z(channel) && (icon = channel.getIcon()) != null) {
                z2 = icon.length() > 0;
            }
            this.binding.c.a(z2 ? IconUtils.getForChannel$default(channel, null, 2, null) : IconUtils.INSTANCE.getDefaultForGroupDM(channel.getId()), null);
            SimpleDraweeView simpleDraweeView2 = this.binding.d;
            m.checkNotNullExpressionValue(simpleDraweeView2, "binding.inviteAvatarSmall");
            simpleDraweeView2.setVisibility(z2 ? 0 : 8);
            TextView textView = this.binding.f;
            m.checkNotNullExpressionValue(textView, "binding.inviteMessage");
            textView.setText(getFormattedGuildName(strC));
            TextView textView2 = this.binding.g;
            m.checkNotNullExpressionValue(textView2, "binding.inviteTitle");
            textView2.setText(getIntroTextForGroup(username, ChannelUtils.c(channel)));
            this.binding.e.setOnline(null);
            this.binding.e.setMembers(Integer.valueOf(model.getApproximateMemberCount()));
        }
    }

    private final void configureForGuild(ModelInvite model) {
        List<GuildFeature> listM;
        List<GuildFeature> listM2;
        boolean z2 = model.getInviter() != null && model.getApproximateMemberCount() < 200;
        Guild guild = model.guild;
        if (guild != null) {
            GuildView guildView = this.binding.c;
            m.checkNotNullExpressionValue(guild, "it");
            guildView.a(IconUtils.getForGuild$default(new com.discord.models.guild.Guild(guild), null, true, null, 10, null), GuildUtilsKt.computeShortName(guild.getName()));
        }
        if (z2) {
            SimpleDraweeView simpleDraweeView = this.binding.d;
            m.checkNotNullExpressionValue(simpleDraweeView, "binding.inviteAvatarSmall");
            User inviter = model.getInviter();
            IconUtils.setIcon$default(simpleDraweeView, IconUtils.getForUser$default(inviter != null ? new CoreUser(inviter) : null, true, null, 4, null), 2131165294, (Function1) null, (MGImages$ChangeDetector) null, 24, (Object) null);
        }
        this.binding.e.setMembers(!z2 ? Integer.valueOf(model.getApproximateMemberCount()) : null);
        this.binding.e.setOnline(!z2 ? Integer.valueOf(model.getApproximatePresenceCount()) : null);
        SimpleDraweeView simpleDraweeView2 = this.binding.d;
        m.checkNotNullExpressionValue(simpleDraweeView2, "binding.inviteAvatarSmall");
        simpleDraweeView2.setVisibility(z2 ? 0 : 8);
        TextView textView = this.binding.f;
        m.checkNotNullExpressionValue(textView, "binding.inviteMessage");
        Guild guild2 = model.guild;
        String name = guild2 != null ? guild2.getName() : null;
        if (name == null) {
            name = "";
        }
        textView.setText(getFormattedGuildName(name));
        Guild guild3 = model.guild;
        if (guild3 == null || (listM2 = guild3.m()) == null || !listM2.contains(GuildFeature.VERIFIED)) {
            Guild guild4 = model.guild;
            if (guild4 != null && (listM = guild4.m()) != null && listM.contains(GuildFeature.PARTNERED)) {
                TextView textView2 = this.binding.f;
                m.checkNotNullExpressionValue(textView2, "binding.inviteMessage");
                ViewExtensions.setCompoundDrawableWithIntrinsicBounds$default(textView2, 2131231995, 0, 0, 0, 14, null);
            }
        } else {
            TextView textView3 = this.binding.f;
            m.checkNotNullExpressionValue(textView3, "binding.inviteMessage");
            ViewExtensions.setCompoundDrawableWithIntrinsicBounds$default(textView3, 2131232241, 0, 0, 0, 14, null);
        }
        TextView textView4 = this.binding.g;
        m.checkNotNullExpressionValue(textView4, "binding.inviteTitle");
        User inviter2 = model.getInviter();
        textView4.setText(getIntroText(inviter2 != null ? inviter2.getUsername() : null));
    }

    private final CharSequence getFormattedGuildName(String guildName) {
        return b.l(a.y("**", guildName, "**"), new Object[0], null, 2);
    }

    private final CharSequence getIntroText(String userName) {
        return userName == null ? b.j(this, 2131892082, new Object[0], null, 4) : b.j(this, 2131886920, new Object[]{userName}, null, 4);
    }

    private final CharSequence getIntroTextForGroup(String userName, String channelName) {
        return channelName.length() > 0 ? b.j(this, 2131886920, new Object[]{userName}, null, 4) : b.j(this, 2131892084, new Object[0], null, 4);
    }

    private final CharSequence getInviteSubtitleForDirectFriend(String userName) {
        return b.j(this, 2131892058, new Object[]{userName}, null, 4);
    }

    private final CharSequence getInviteTitleForDirectFriend(String userName) {
        return b.j(this, 2131892080, new Object[]{userName}, null, 4);
    }

    private final void parseAttributeSet(Context context, AttributeSet attributeSet, int defStyleAttr) {
        if (attributeSet == null) {
            return;
        }
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$a.WidgetInviteInfo, defStyleAttr, 0);
        m.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "context.obtainStyledAttr…iteInfo, defStyleAttr, 0)");
        int dimension = (int) typedArrayObtainStyledAttributes.getDimension(0, 0.0f);
        int dimension2 = (int) typedArrayObtainStyledAttributes.getDimension(1, 0.0f);
        typedArrayObtainStyledAttributes.recycle();
        post(new WidgetInviteInfo$parseAttributeSet$1(this, dimension, dimension2));
    }

    public final void configureUI(ModelInvite model, Function0<Unit> onAcceptClick) {
        m.checkNotNullParameter(model, "model");
        m.checkNotNullParameter(onAcceptClick, "onAcceptClick");
        this.binding.c.b();
        MaterialButton materialButton = this.binding.f2415b;
        m.checkNotNullExpressionValue(materialButton, "binding.guildInviteAccept");
        materialButton.setVisibility(0);
        this.binding.f2415b.setOnClickListener(new WidgetInviteInfo$configureUI$1(onAcceptClick));
        if (model.guild == null && model.getChannel() == null && model.getInviter() != null) {
            configureForDirectFriend(model);
        } else if (model.guild == null) {
            configureForGDM(model);
        } else {
            configureForGuild(model);
        }
    }

    public final void configureUIFailure(Error e) {
        this.binding.g.setText(2131892063);
        this.binding.f.setText(2131892227);
        MaterialButton materialButton = this.binding.f2415b;
        m.checkNotNullExpressionValue(materialButton, "binding.guildInviteAccept");
        materialButton.setVisibility(8);
        if (e != null) {
            Error$Response response = e.getResponse();
            m.checkNotNullExpressionValue(response, "e.response");
            if (response.getCode() == 30001) {
                MeUser meSnapshot = StoreStream.Companion.getUsers().getMeSnapshot();
                TextView textView = this.binding.g;
                m.checkNotNullExpressionValue(textView, "binding.inviteTitle");
                b.m(textView, 2131896458, new Object[0], new WidgetInviteInfo$configureUIFailure$1(meSnapshot));
                this.binding.f.setText(2131896460);
                this.binding.f.setTextSize(0, getResources().getDimension(2131165796));
            }
        }
        TextView textView2 = this.binding.f;
        m.checkNotNullExpressionValue(textView2, "binding.inviteMessage");
        ViewExtensions.setCompoundDrawableWithIntrinsicBounds$default(textView2, 0, 0, 0, 0, 15, null);
        ServerMemberCount serverMemberCount = this.binding.e;
        m.checkNotNullExpressionValue(serverMemberCount, "binding.inviteMemberContainerLayout");
        serverMemberCount.setVisibility(8);
        GuildView guildView = this.binding.c;
        Context context = getContext();
        m.checkNotNullExpressionValue(context, "context");
        int themedDrawableRes = DrawableCompat.getThemedDrawableRes(context, 2130969610, 2131232414);
        Objects.requireNonNull(guildView);
        MGImages mGImages = MGImages.INSTANCE;
        SimpleDraweeView simpleDraweeView = guildView.binding.f146b;
        m.checkNotNullExpressionValue(simpleDraweeView, "binding.guildAvatar");
        MGImages.setImage$default(mGImages, simpleDraweeView, themedDrawableRes, (MGImages$ChangeDetector) null, 4, (Object) null);
        TextView textView3 = guildView.binding.c;
        m.checkNotNullExpressionValue(textView3, "binding.guildText");
        textView3.setVisibility(8);
        SimpleDraweeView simpleDraweeView2 = this.binding.d;
        m.checkNotNullExpressionValue(simpleDraweeView2, "binding.inviteAvatarSmall");
        simpleDraweeView2.setVisibility(8);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetInviteInfo(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m.checkNotNullParameter(context, "ctx");
        LayoutInflater.from(getContext()).inflate(R$layout.widget_guild_invite_info_view, this);
        int i2 = R$id.guild_invite_accept;
        MaterialButton materialButton = (MaterialButton) findViewById(R$id.guild_invite_accept);
        if (materialButton != null) {
            i2 = R$id.invite_avatar;
            GuildView guildView = (GuildView) findViewById(R$id.invite_avatar);
            if (guildView != null) {
                i2 = R$id.invite_avatar_small;
                SimpleDraweeView simpleDraweeView = (SimpleDraweeView) findViewById(R$id.invite_avatar_small);
                if (simpleDraweeView != null) {
                    i2 = R$id.invite_member_container_layout;
                    ServerMemberCount serverMemberCount = (ServerMemberCount) findViewById(R$id.invite_member_container_layout);
                    if (serverMemberCount != null) {
                        i2 = R$id.invite_message;
                        TextView textView = (TextView) findViewById(R$id.invite_message);
                        if (textView != null) {
                            i2 = R$id.invite_title;
                            TextView textView2 = (TextView) findViewById(R$id.invite_title);
                            if (textView2 != null) {
                                i2 = R$id.title_layout;
                                LinearLayout linearLayout = (LinearLayout) findViewById(R$id.title_layout);
                                if (linearLayout != null) {
                                    WidgetGuildInviteInfoViewBinding widgetGuildInviteInfoViewBinding = new WidgetGuildInviteInfoViewBinding(this, materialButton, guildView, simpleDraweeView, serverMemberCount, textView, textView2, linearLayout);
                                    m.checkNotNullExpressionValue(widgetGuildInviteInfoViewBinding, "WidgetGuildInviteInfoVie…ater.from(context), this)");
                                    this.binding = widgetGuildInviteInfoViewBinding;
                                    Context context2 = getContext();
                                    m.checkNotNullExpressionValue(context2, "context");
                                    parseAttributeSet(context2, attributeSet, i);
                                    setBackgroundResource(2131231011);
                                    int iDpToPixels = DimenUtils.dpToPixels(24);
                                    setPadding(iDpToPixels, iDpToPixels, iDpToPixels, iDpToPixels);
                                    return;
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(i2)));
    }
}
