package com.discord.widgets.guilds.invite;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.discord.C5419R;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.guild.Guild;
import com.discord.api.guild.GuildFeature;
import com.discord.api.user.User;
import com.discord.databinding.WidgetGuildInviteInfoViewBinding;
import com.discord.i18n.RenderContext;
import com.discord.models.domain.ModelInvite;
import com.discord.models.user.CoreUser;
import com.discord.models.user.MeUser;
import com.discord.stores.StoreStream;
import com.discord.utilities.dimen.DimenUtils;
import com.discord.utilities.drawable.DrawableCompat;
import com.discord.utilities.error.Error;
import com.discord.utilities.guilds.GuildUtilsKt;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.images.MGImages;
import com.discord.utilities.user.UserUtils;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.views.GuildView;
import com.discord.views.guilds.ServerMemberCount;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.button.MaterialButton;
import java.util.List;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p008a.p027k.C1107b;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

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

    private final void configureForDirectFriend(ModelInvite model) {
        GuildView guildView = this.binding.f16789c;
        User inviter = model.getInviter();
        String forUser$default = IconUtils.getForUser$default(inviter != null ? new CoreUser(inviter) : null, true, null, 4, null);
        int i = GuildView.f19071j;
        guildView.m8545a(forUser$default, null);
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
        SimpleDraweeView simpleDraweeView = this.binding.f16790d;
        C12238m.checkNotNullExpressionValue(simpleDraweeView, "binding.inviteAvatarSmall");
        simpleDraweeView.setVisibility(8);
        ServerMemberCount serverMemberCount = this.binding.f16791e;
        C12238m.checkNotNullExpressionValue(serverMemberCount, "binding.inviteMemberContainerLayout");
        serverMemberCount.setVisibility(8);
        TextView textView = this.binding.f16793g;
        C12238m.checkNotNullExpressionValue(textView, "binding.inviteTitle");
        textView.setText(getInviteTitleForDirectFriend(username));
        this.binding.f16793g.setTextSize(2, 26.0f);
        TextView textView2 = this.binding.f16792f;
        C12238m.checkNotNullExpressionValue(textView2, "binding.inviteMessage");
        textView2.setText(getInviteSubtitleForDirectFriend(string));
        this.binding.f16792f.setTextSize(2, 18.0f);
    }

    /* JADX WARN: Code duplicated, block: B:32:0x006f  */
    private final void configureForGDM(ModelInvite model) {
        boolean z2;
        String icon;
        Channel channel = model.getChannel();
        if (channel != null) {
            C12238m.checkNotNullExpressionValue(channel, "model.channel ?: return");
            SimpleDraweeView simpleDraweeView = this.binding.f16790d;
            C12238m.checkNotNullExpressionValue(simpleDraweeView, "binding.inviteAvatarSmall");
            User inviter = model.getInviter();
            IconUtils.setIcon$default(simpleDraweeView, inviter != null ? new CoreUser(inviter) : null, C5419R.dimen.avatar_size_hero, null, null, null, 56, null);
            User inviter2 = model.getInviter();
            String username = inviter2 != null ? inviter2.getUsername() : null;
            if (username == null) {
                username = "";
            }
            String strM7679c = ChannelUtils.m7679c(channel).length() > 0 ? ChannelUtils.m7679c(channel) : username;
            if (ChannelUtils.m7702z(channel) && (icon = channel.getIcon()) != null) {
                z2 = icon.length() > 0;
            }
            this.binding.f16789c.m8545a(z2 ? IconUtils.getForChannel$default(channel, null, 2, null) : IconUtils.INSTANCE.getDefaultForGroupDM(channel.getId()), null);
            SimpleDraweeView simpleDraweeView2 = this.binding.f16790d;
            C12238m.checkNotNullExpressionValue(simpleDraweeView2, "binding.inviteAvatarSmall");
            simpleDraweeView2.setVisibility(z2 ? 0 : 8);
            TextView textView = this.binding.f16792f;
            C12238m.checkNotNullExpressionValue(textView, "binding.inviteMessage");
            textView.setText(getFormattedGuildName(strM7679c));
            TextView textView2 = this.binding.f16793g;
            C12238m.checkNotNullExpressionValue(textView2, "binding.inviteTitle");
            textView2.setText(getIntroTextForGroup(username, ChannelUtils.m7679c(channel)));
            this.binding.f16791e.setOnline(null);
            this.binding.f16791e.setMembers(Integer.valueOf(model.getApproximateMemberCount()));
        }
    }

    private final void configureForGuild(ModelInvite model) {
        List<GuildFeature> listM7866m;
        List<GuildFeature> listM7866m2;
        boolean z2 = model.getInviter() != null && model.getApproximateMemberCount() < 200;
        Guild guild = model.guild;
        if (guild != null) {
            GuildView guildView = this.binding.f16789c;
            C12238m.checkNotNullExpressionValue(guild, "it");
            guildView.m8545a(IconUtils.getForGuild$default(new com.discord.models.guild.Guild(guild), null, true, null, 10, null), GuildUtilsKt.computeShortName(guild.getName()));
        }
        if (z2) {
            SimpleDraweeView simpleDraweeView = this.binding.f16790d;
            C12238m.checkNotNullExpressionValue(simpleDraweeView, "binding.inviteAvatarSmall");
            User inviter = model.getInviter();
            IconUtils.setIcon$default(simpleDraweeView, IconUtils.getForUser$default(inviter != null ? new CoreUser(inviter) : null, true, null, 4, null), C5419R.dimen.avatar_size_medium, (Function1) null, (MGImages.ChangeDetector) null, 24, (Object) null);
        }
        this.binding.f16791e.setMembers(!z2 ? Integer.valueOf(model.getApproximateMemberCount()) : null);
        this.binding.f16791e.setOnline(!z2 ? Integer.valueOf(model.getApproximatePresenceCount()) : null);
        SimpleDraweeView simpleDraweeView2 = this.binding.f16790d;
        C12238m.checkNotNullExpressionValue(simpleDraweeView2, "binding.inviteAvatarSmall");
        simpleDraweeView2.setVisibility(z2 ? 0 : 8);
        TextView textView = this.binding.f16792f;
        C12238m.checkNotNullExpressionValue(textView, "binding.inviteMessage");
        Guild guild2 = model.guild;
        String name = guild2 != null ? guild2.getName() : null;
        if (name == null) {
            name = "";
        }
        textView.setText(getFormattedGuildName(name));
        Guild guild3 = model.guild;
        if (guild3 == null || (listM7866m2 = guild3.m7866m()) == null || !listM7866m2.contains(GuildFeature.VERIFIED)) {
            Guild guild4 = model.guild;
            if (guild4 != null && (listM7866m = guild4.m7866m()) != null && listM7866m.contains(GuildFeature.PARTNERED)) {
                TextView textView2 = this.binding.f16792f;
                C12238m.checkNotNullExpressionValue(textView2, "binding.inviteMessage");
                ViewExtensions.setCompoundDrawableWithIntrinsicBounds$default(textView2, C5419R.drawable.ic_partnered_badge, 0, 0, 0, 14, null);
            }
        } else {
            TextView textView3 = this.binding.f16792f;
            C12238m.checkNotNullExpressionValue(textView3, "binding.inviteMessage");
            ViewExtensions.setCompoundDrawableWithIntrinsicBounds$default(textView3, C5419R.drawable.ic_verified_badge, 0, 0, 0, 14, null);
        }
        TextView textView4 = this.binding.f16793g;
        C12238m.checkNotNullExpressionValue(textView4, "binding.inviteTitle");
        User inviter2 = model.getInviter();
        textView4.setText(getIntroText(inviter2 != null ? inviter2.getUsername() : null));
    }

    private final CharSequence getFormattedGuildName(String guildName) {
        return C1107b.m215g(C1643a.m886y("**", guildName, "**"), new Object[0], (2 & 2) != 0 ? C1107b.e.f1494j : null);
    }

    private final CharSequence getIntroText(String userName) {
        return userName == null ? C1107b.m212d(this, C5419R.string.instant_invite_you_have_been_invited_to_join, new Object[0], (4 & 4) != 0 ? C1107b.c.f1492j : null) : C1107b.m212d(this, C5419R.string.auth_message_invited_by, new Object[]{userName}, (4 & 4) != 0 ? C1107b.c.f1492j : null);
    }

    private final CharSequence getIntroTextForGroup(String userName, String channelName) {
        return channelName.length() > 0 ? C1107b.m212d(this, C5419R.string.auth_message_invited_by, new Object[]{userName}, (4 & 4) != 0 ? C1107b.c.f1492j : null) : C1107b.m212d(this, C5419R.string.instant_invite_you_have_been_invited_to_join_group_dm, new Object[0], (4 & 4) != 0 ? C1107b.c.f1492j : null);
    }

    private final CharSequence getInviteSubtitleForDirectFriend(String userName) {
        return C1107b.m212d(this, C5419R.string.instant_invite_direct_friend_description, new Object[]{userName}, (4 & 4) != 0 ? C1107b.c.f1492j : null);
    }

    private final CharSequence getInviteTitleForDirectFriend(String userName) {
        return C1107b.m212d(this, C5419R.string.instant_invite_you_have_been_invited_to_chat, new Object[]{userName}, (4 & 4) != 0 ? C1107b.c.f1492j : null);
    }

    private final void parseAttributeSet(Context context, AttributeSet attributeSet, int defStyleAttr) {
        if (attributeSet == null) {
            return;
        }
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C5419R.a.WidgetInviteInfo, defStyleAttr, 0);
        C12238m.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "context.obtainStyledAttr…iteInfo, defStyleAttr, 0)");
        final int dimension = (int) typedArrayObtainStyledAttributes.getDimension(0, 0.0f);
        final int dimension2 = (int) typedArrayObtainStyledAttributes.getDimension(1, 0.0f);
        typedArrayObtainStyledAttributes.recycle();
        post(new Runnable() { // from class: com.discord.widgets.guilds.invite.WidgetInviteInfo.parseAttributeSet.1
            @Override // java.lang.Runnable
            public final void run() {
                if (dimension != 0) {
                    GuildView guildView = WidgetInviteInfo.this.binding.f16789c;
                    C12238m.checkNotNullExpressionValue(guildView, "binding.inviteAvatar");
                    ViewGroup.LayoutParams layoutParams = guildView.getLayoutParams();
                    Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
                    int i = dimension;
                    layoutParams.height = i;
                    layoutParams.width = i;
                    guildView.setLayoutParams(layoutParams);
                }
                if (dimension2 != 0) {
                    SimpleDraweeView simpleDraweeView = WidgetInviteInfo.this.binding.f16790d;
                    C12238m.checkNotNullExpressionValue(simpleDraweeView, "binding.inviteAvatarSmall");
                    ViewGroup.LayoutParams layoutParams2 = simpleDraweeView.getLayoutParams();
                    Objects.requireNonNull(layoutParams2, "null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
                    int i2 = dimension2;
                    layoutParams2.height = i2;
                    layoutParams2.width = i2;
                    simpleDraweeView.setLayoutParams(layoutParams2);
                }
            }
        });
    }

    public final void configureUI(ModelInvite model, final Function0<Unit> onAcceptClick) {
        C12238m.checkNotNullParameter(model, "model");
        C12238m.checkNotNullParameter(onAcceptClick, "onAcceptClick");
        this.binding.f16789c.m8546b();
        MaterialButton materialButton = this.binding.f16788b;
        C12238m.checkNotNullExpressionValue(materialButton, "binding.guildInviteAccept");
        materialButton.setVisibility(0);
        this.binding.f16788b.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.guilds.invite.WidgetInviteInfo.configureUI.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                onAcceptClick.invoke();
            }
        });
        if (model.guild == null && model.getChannel() == null && model.getInviter() != null) {
            configureForDirectFriend(model);
        } else if (model.guild == null) {
            configureForGDM(model);
        } else {
            configureForGuild(model);
        }
    }

    public final void configureUIFailure(Error e) {
        this.binding.f16793g.setText(C5419R.string.instant_invite_expired);
        this.binding.f16792f.setText(C5419R.string.invite_button_expired);
        MaterialButton materialButton = this.binding.f16788b;
        C12238m.checkNotNullExpressionValue(materialButton, "binding.guildInviteAccept");
        materialButton.setVisibility(8);
        if (e != null) {
            Error.Response response = e.getResponse();
            C12238m.checkNotNullExpressionValue(response, "e.response");
            if (response.getCode() == 30001) {
                MeUser meSnapshot = StoreStream.INSTANCE.getUsers().getMeSnapshot();
                TextView textView = this.binding.f16793g;
                C12238m.checkNotNullExpressionValue(textView, "binding.inviteTitle");
                C1107b.m221m(textView, C5419R.string.too_many_user_guilds_alert_description, new Object[0], new C87131(meSnapshot));
                this.binding.f16792f.setText(C5419R.string.too_many_user_guilds_description);
                this.binding.f16792f.setTextSize(0, getResources().getDimension(C5419R.dimen.uikit_textsize_medium));
            }
        }
        TextView textView2 = this.binding.f16792f;
        C12238m.checkNotNullExpressionValue(textView2, "binding.inviteMessage");
        ViewExtensions.setCompoundDrawableWithIntrinsicBounds$default(textView2, 0, 0, 0, 0, 15, null);
        ServerMemberCount serverMemberCount = this.binding.f16791e;
        C12238m.checkNotNullExpressionValue(serverMemberCount, "binding.inviteMemberContainerLayout");
        serverMemberCount.setVisibility(8);
        GuildView guildView = this.binding.f16789c;
        Context context = getContext();
        C12238m.checkNotNullExpressionValue(context, "context");
        int themedDrawableRes = DrawableCompat.getThemedDrawableRes(context, C5419R.attr.img_poop, C5419R.drawable.img_poop_dark);
        Objects.requireNonNull(guildView);
        MGImages mGImages = MGImages.INSTANCE;
        SimpleDraweeView simpleDraweeView = guildView.binding.f999b;
        C12238m.checkNotNullExpressionValue(simpleDraweeView, "binding.guildAvatar");
        MGImages.setImage$default(mGImages, simpleDraweeView, themedDrawableRes, (MGImages.ChangeDetector) null, 4, (Object) null);
        TextView textView3 = guildView.binding.f1000c;
        C12238m.checkNotNullExpressionValue(textView3, "binding.guildText");
        textView3.setVisibility(8);
        SimpleDraweeView simpleDraweeView2 = this.binding.f16790d;
        C12238m.checkNotNullExpressionValue(simpleDraweeView2, "binding.inviteAvatarSmall");
        simpleDraweeView2.setVisibility(8);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetInviteInfo(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        C12238m.checkNotNullParameter(context, "ctx");
        LayoutInflater.from(getContext()).inflate(C5419R.layout.widget_guild_invite_info_view, this);
        int i2 = C5419R.id.guild_invite_accept;
        MaterialButton materialButton = (MaterialButton) findViewById(C5419R.id.guild_invite_accept);
        if (materialButton != null) {
            i2 = C5419R.id.invite_avatar;
            GuildView guildView = (GuildView) findViewById(C5419R.id.invite_avatar);
            if (guildView != null) {
                i2 = C5419R.id.invite_avatar_small;
                SimpleDraweeView simpleDraweeView = (SimpleDraweeView) findViewById(C5419R.id.invite_avatar_small);
                if (simpleDraweeView != null) {
                    i2 = C5419R.id.invite_member_container_layout;
                    ServerMemberCount serverMemberCount = (ServerMemberCount) findViewById(C5419R.id.invite_member_container_layout);
                    if (serverMemberCount != null) {
                        i2 = C5419R.id.invite_message;
                        TextView textView = (TextView) findViewById(C5419R.id.invite_message);
                        if (textView != null) {
                            i2 = C5419R.id.invite_title;
                            TextView textView2 = (TextView) findViewById(C5419R.id.invite_title);
                            if (textView2 != null) {
                                i2 = C5419R.id.title_layout;
                                LinearLayout linearLayout = (LinearLayout) findViewById(C5419R.id.title_layout);
                                if (linearLayout != null) {
                                    WidgetGuildInviteInfoViewBinding widgetGuildInviteInfoViewBinding = new WidgetGuildInviteInfoViewBinding(this, materialButton, guildView, simpleDraweeView, serverMemberCount, textView, textView2, linearLayout);
                                    C12238m.checkNotNullExpressionValue(widgetGuildInviteInfoViewBinding, "WidgetGuildInviteInfoVie…ater.from(context), this)");
                                    this.binding = widgetGuildInviteInfoViewBinding;
                                    Context context2 = getContext();
                                    C12238m.checkNotNullExpressionValue(context2, "context");
                                    parseAttributeSet(context2, attributeSet, i);
                                    setBackgroundResource(C5419R.drawable.bg_guild_scheduled_event_list_item_primary);
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

    /* JADX INFO: renamed from: com.discord.widgets.guilds.invite.WidgetInviteInfo$configureUIFailure$1 */
    /* JADX INFO: compiled from: WidgetInviteInfo.kt */
    public static final class C87131 extends AbstractC12240o implements Function1<RenderContext, Unit> {
        public final /* synthetic */ MeUser $meUser;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C87131(MeUser meUser) {
            super(1);
            this.$meUser = meUser;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(RenderContext renderContext) {
            C12238m.checkNotNullParameter(renderContext, "$receiver");
            renderContext.args.put("quantity", String.valueOf(UserUtils.INSTANCE.isPremiumTier2(this.$meUser) ? 200 : 100));
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(RenderContext renderContext) {
            invoke2(renderContext);
            return Unit.f27425a;
        }
    }
}
