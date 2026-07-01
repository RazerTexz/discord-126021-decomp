package com.discord.widgets.chat.list.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.Barrier;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.exifinterface.media.ExifInterface;
import b.a.d.j;
import b.a.k.b;
import com.discord.R$id;
import com.discord.R$layout;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.guild.GuildFeature;
import com.discord.databinding.WidgetChatListAdapterItemInviteBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.domain.ModelInvite;
import com.discord.models.guild.Guild;
import com.discord.models.user.User;
import com.discord.stores.StoreInstantInvites;
import com.discord.stores.StoreStream;
import com.discord.utilities.SnowflakeUtils;
import com.discord.utilities.analytics.Traits$Payment$Type;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.drawable.DrawableCompat;
import com.discord.utilities.features.GrowthTeamFeatures;
import com.discord.utilities.guilds.GuildUtilsKt;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.images.MGImages$ChangeDetector;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.view.rounded.RoundedRelativeLayout;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.views.guilds.ServerMemberCount;
import com.discord.widgets.chat.list.entries.ChatListEntry;
import com.discord.widgets.chat.list.entries.InviteEntry;
import com.discord.widgets.hubs.HubEmailArgs;
import com.discord.widgets.hubs.WidgetHubEmailFlow;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.button.MaterialButton;
import d0.z.d.m;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import rx.Subscription;

/* JADX INFO: compiled from: WidgetChatListAdapterItemInvite.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatListAdapterItemInvite extends WidgetChatListAdapterItemInviteBase {
    private final WidgetChatListAdapterItemInviteBinding binding;
    private String iconUrl;
    private InviteEntry item;
    private Subscription subscription;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChatListAdapterItemInvite(WidgetChatListAdapter widgetChatListAdapter) {
        super(R$layout.widget_chat_list_adapter_item_invite, widgetChatListAdapter);
        m.checkNotNullParameter(widgetChatListAdapter, "adapter");
        View view = this.itemView;
        int i = R$id.barrier_button;
        Barrier barrier = (Barrier) view.findViewById(R$id.barrier_button);
        if (barrier != null) {
            i = R$id.barrier_header;
            Barrier barrier2 = (Barrier) view.findViewById(R$id.barrier_header);
            if (barrier2 != null) {
                i = R$id.item_invite_button_layout;
                FrameLayout frameLayout = (FrameLayout) view.findViewById(R$id.item_invite_button_layout);
                if (frameLayout != null) {
                    i = R$id.item_invite_channel_name;
                    TextView textView = (TextView) view.findViewById(R$id.item_invite_channel_name);
                    if (textView != null) {
                        i = R$id.item_invite_header;
                        TextView textView2 = (TextView) view.findViewById(R$id.item_invite_header);
                        if (textView2 != null) {
                            i = R$id.item_invite_hub_layout;
                            FrameLayout frameLayout2 = (FrameLayout) view.findViewById(R$id.item_invite_hub_layout);
                            if (frameLayout2 != null) {
                                i = R$id.item_invite_hub_link;
                                LinkifiedTextView linkifiedTextView = (LinkifiedTextView) view.findViewById(R$id.item_invite_hub_link);
                                if (linkifiedTextView != null) {
                                    i = R$id.item_invite_image;
                                    SimpleDraweeView simpleDraweeView = (SimpleDraweeView) view.findViewById(R$id.item_invite_image);
                                    if (simpleDraweeView != null) {
                                        i = R$id.item_invite_image_text;
                                        TextView textView3 = (TextView) view.findViewById(R$id.item_invite_image_text);
                                        if (textView3 != null) {
                                            i = R$id.item_invite_join_button;
                                            MaterialButton materialButton = (MaterialButton) view.findViewById(R$id.item_invite_join_button);
                                            if (materialButton != null) {
                                                i = R$id.item_invite_joined_button;
                                                MaterialButton materialButton2 = (MaterialButton) view.findViewById(R$id.item_invite_joined_button);
                                                if (materialButton2 != null) {
                                                    i = R$id.item_invite_loading_button;
                                                    View viewFindViewById = view.findViewById(R$id.item_invite_loading_button);
                                                    if (viewFindViewById != null) {
                                                        i = R$id.item_invite_member_container;
                                                        ServerMemberCount serverMemberCount = (ServerMemberCount) view.findViewById(R$id.item_invite_member_container);
                                                        if (serverMemberCount != null) {
                                                            i = R$id.item_invite_mention_button;
                                                            MaterialButton materialButton3 = (MaterialButton) view.findViewById(R$id.item_invite_mention_button);
                                                            if (materialButton3 != null) {
                                                                i = R$id.item_invite_name;
                                                                TextView textView4 = (TextView) view.findViewById(R$id.item_invite_name);
                                                                if (textView4 != null) {
                                                                    i = R$id.item_invite_splash;
                                                                    SimpleDraweeView simpleDraweeView2 = (SimpleDraweeView) view.findViewById(R$id.item_invite_splash);
                                                                    if (simpleDraweeView2 != null) {
                                                                        i = R$id.item_invite_splash_container;
                                                                        RoundedRelativeLayout roundedRelativeLayout = (RoundedRelativeLayout) view.findViewById(R$id.item_invite_splash_container);
                                                                        if (roundedRelativeLayout != null) {
                                                                            ConstraintLayout constraintLayout = (ConstraintLayout) view;
                                                                            WidgetChatListAdapterItemInviteBinding widgetChatListAdapterItemInviteBinding = new WidgetChatListAdapterItemInviteBinding(constraintLayout, barrier, barrier2, frameLayout, textView, textView2, frameLayout2, linkifiedTextView, simpleDraweeView, textView3, materialButton, materialButton2, viewFindViewById, serverMemberCount, materialButton3, textView4, simpleDraweeView2, roundedRelativeLayout, constraintLayout);
                                                                            m.checkNotNullExpressionValue(widgetChatListAdapterItemInviteBinding, "WidgetChatListAdapterIte…iteBinding.bind(itemView)");
                                                                            this.binding = widgetChatListAdapterItemInviteBinding;
                                                                            return;
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static final /* synthetic */ void access$configureInvalidUI(WidgetChatListAdapterItemInvite widgetChatListAdapterItemInvite, WidgetChatListAdapterItemInvite$Model$Invalid widgetChatListAdapterItemInvite$Model$Invalid) {
        widgetChatListAdapterItemInvite.configureInvalidUI(widgetChatListAdapterItemInvite$Model$Invalid);
    }

    public static final /* synthetic */ void access$configureUI(WidgetChatListAdapterItemInvite widgetChatListAdapterItemInvite, WidgetChatListAdapterItemInvite$Model widgetChatListAdapterItemInvite$Model) {
        widgetChatListAdapterItemInvite.configureUI(widgetChatListAdapterItemInvite$Model);
    }

    public static final /* synthetic */ WidgetChatListAdapter access$getAdapter$p(WidgetChatListAdapterItemInvite widgetChatListAdapterItemInvite) {
        return (WidgetChatListAdapter) widgetChatListAdapterItemInvite.adapter;
    }

    public static final /* synthetic */ InviteEntry access$getItem$p(WidgetChatListAdapterItemInvite widgetChatListAdapterItemInvite) {
        InviteEntry inviteEntry = widgetChatListAdapterItemInvite.item;
        if (inviteEntry == null) {
            m.throwUninitializedPropertyAccessException("item");
        }
        return inviteEntry;
    }

    public static final /* synthetic */ Subscription access$getSubscription$p(WidgetChatListAdapterItemInvite widgetChatListAdapterItemInvite) {
        return widgetChatListAdapterItemInvite.subscription;
    }

    public static final /* synthetic */ void access$launchHubsEmail(WidgetChatListAdapterItemInvite widgetChatListAdapterItemInvite, HubEmailArgs hubEmailArgs) {
        widgetChatListAdapterItemInvite.launchHubsEmail(hubEmailArgs);
    }

    public static final /* synthetic */ void access$setItem$p(WidgetChatListAdapterItemInvite widgetChatListAdapterItemInvite, InviteEntry inviteEntry) {
        widgetChatListAdapterItemInvite.item = inviteEntry;
    }

    public static final /* synthetic */ void access$setSubscription$p(WidgetChatListAdapterItemInvite widgetChatListAdapterItemInvite, Subscription subscription) {
        widgetChatListAdapterItemInvite.subscription = subscription;
    }

    private final void configureForTextChannel(boolean isGroupDM, ModelInvite invite) {
        ServerMemberCount serverMemberCount = this.binding.k;
        m.checkNotNullExpressionValue(serverMemberCount, "binding.itemInviteMemberContainer");
        serverMemberCount.setVisibility(invite.getChannel() != null ? 0 : 8);
        this.binding.k.setOnline(!isGroupDM ? Integer.valueOf(invite.getApproximatePresenceCount()) : null);
        this.binding.k.setMembers(Integer.valueOf(invite.getApproximateMemberCount()));
    }

    private final void configureForVocalChannel(Channel channel, Context context) {
        int themedDrawableRes$default;
        ServerMemberCount serverMemberCount = this.binding.k;
        m.checkNotNullExpressionValue(serverMemberCount, "binding.itemInviteMemberContainer");
        serverMemberCount.setVisibility(8);
        TextView textView = this.binding.f2325b;
        int type = channel.getType();
        if (type != 2) {
            themedDrawableRes$default = type != 13 ? 0 : 2131231625;
        } else {
            View view = this.itemView;
            m.checkNotNullExpressionValue(view, "itemView");
            themedDrawableRes$default = DrawableCompat.getThemedDrawableRes$default(view, 2130969567, 0, 2, (Object) null);
        }
        DrawableCompat.setCompoundDrawablesCompat$default(textView, themedDrawableRes$default, 0, 0, 0, 14, (Object) null);
        ViewExtensions.setTextAndVisibilityBy(textView, ChannelUtils.d(channel, context, false));
    }

    /* JADX WARN: Code duplicated, block: B:22:0x00ab  */
    /* JADX WARN: Code duplicated, block: B:23:0x00ad A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:24:0x00af  */
    /* JADX WARN: Code duplicated, block: B:25:0x00b4  */
    /* JADX WARN: Code duplicated, block: B:27:0x00b7  */
    /* JADX WARN: Code duplicated, block: B:28:0x00c4 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:29:0x00c6  */
    /* JADX WARN: Code duplicated, block: B:30:0x00d3  */
    private final void configureInvalidUI(WidgetChatListAdapterItemInvite$Model$Invalid model) {
        CharSequence charSequenceH;
        User authorUser;
        Channel channel;
        User authorUser2;
        View view = this.itemView;
        m.checkNotNullExpressionValue(view, "itemView");
        Context context = view.getContext();
        Long lValueOf = null;
        boolean zAreEqual = m.areEqual((model == null || (authorUser2 = model.getAuthorUser()) == null) ? null : Long.valueOf(authorUser2.getId()), model != null ? Long.valueOf(model.getMeId()) : null);
        TextView textView = this.binding.c;
        m.checkNotNullExpressionValue(textView, "binding.itemInviteHeader");
        b.n(textView, zAreEqual ? 2131892249 : 2131892241, new Object[0], null, 4);
        TextView textView2 = this.binding.m;
        m.checkNotNullExpressionValue(textView2, "binding.itemInviteName");
        b.n(textView2, 2131892228, new Object[0], null, 4);
        this.binding.m.setTextColor(ColorCompat.getColor(context, 2131100382));
        this.binding.m.setBackgroundResource(0);
        this.binding.f.setActualImageResource(2131232459);
        TextView textView3 = this.binding.g;
        m.checkNotNullExpressionValue(textView3, "binding.itemInviteImageText");
        textView3.setVisibility(8);
        boolean z2 = true;
        if (!zAreEqual) {
            if ((model != null ? model.getAuthorUser() : null) != null) {
                m.checkNotNullExpressionValue(context, "context");
                charSequenceH = b.h(context, 2131892055, new Object[]{model.getAuthorUser().getUsername()}, null, 4);
            } else if (zAreEqual) {
                if (model != null) {
                    authorUser = model.getAuthorUser();
                } else {
                    authorUser = null;
                }
                if (authorUser == null) {
                    m.checkNotNullExpressionValue(context, "context");
                    charSequenceH = b.h(context, 2131892054, new Object[0], null, 4);
                } else if (zAreEqual) {
                    m.checkNotNullExpressionValue(context, "context");
                    charSequenceH = b.h(context, 2131892229, new Object[0], null, 4);
                } else {
                    charSequenceH = null;
                }
            } else if (zAreEqual) {
                m.checkNotNullExpressionValue(context, "context");
                charSequenceH = b.h(context, 2131892229, new Object[0], null, 4);
            } else {
                charSequenceH = null;
            }
        } else if (zAreEqual) {
            if (model != null) {
                authorUser = model.getAuthorUser();
            } else {
                authorUser = null;
            }
            if (authorUser == null) {
                m.checkNotNullExpressionValue(context, "context");
                charSequenceH = b.h(context, 2131892054, new Object[0], null, 4);
            } else if (zAreEqual) {
                m.checkNotNullExpressionValue(context, "context");
                charSequenceH = b.h(context, 2131892229, new Object[0], null, 4);
            } else {
                charSequenceH = null;
            }
        } else if (zAreEqual) {
            m.checkNotNullExpressionValue(context, "context");
            charSequenceH = b.h(context, 2131892229, new Object[0], null, 4);
        } else {
            charSequenceH = null;
        }
        TextView textView4 = this.binding.f2325b;
        m.checkNotNullExpressionValue(textView4, "binding.itemInviteChannelName");
        textView4.setVisibility(8);
        ServerMemberCount serverMemberCount = this.binding.k;
        m.checkNotNullExpressionValue(serverMemberCount, "binding.itemInviteMemberContainer");
        serverMemberCount.setVisibility(0);
        this.binding.k.setInvalidText(charSequenceH);
        MaterialButton materialButton = this.binding.l;
        m.checkNotNullExpressionValue(materialButton, "binding.itemInviteMentionButton");
        b.n(materialButton, zAreEqual ? 2131888237 : 2131892939, new Object[0], null, 4);
        MaterialButton materialButton2 = this.binding.l;
        m.checkNotNullExpressionValue(materialButton2, "binding.itemInviteMentionButton");
        if (zAreEqual) {
            if (model != null && (channel = model.getChannel()) != null) {
                lValueOf = Long.valueOf(channel.getGuildId());
            }
            if (lValueOf == null) {
                z2 = false;
            }
        }
        materialButton2.setVisibility(z2 ? 0 : 8);
        this.binding.l.setOnClickListener(new WidgetChatListAdapterItemInvite$configureInvalidUI$1(this, zAreEqual, model, context));
        MaterialButton materialButton3 = this.binding.h;
        m.checkNotNullExpressionValue(materialButton3, "binding.itemInviteJoinButton");
        materialButton3.setVisibility(8);
        MaterialButton materialButton4 = this.binding.i;
        m.checkNotNullExpressionValue(materialButton4, "binding.itemInviteJoinedButton");
        materialButton4.setVisibility(8);
        View view2 = this.binding.j;
        m.checkNotNullExpressionValue(view2, "binding.itemInviteLoadingButton");
        view2.setVisibility(8);
    }

    private final void configureLoadingUI() {
        View view = this.itemView;
        m.checkNotNullExpressionValue(view, "itemView");
        Context context = view.getContext();
        this.binding.c.setText(2131892077);
        TextView textView = this.binding.m;
        m.checkNotNullExpressionValue(textView, "binding.itemInviteName");
        textView.setText((CharSequence) null);
        this.binding.m.setTextColor(ColorCompat.getThemedColor(context, 2130969971));
        this.binding.m.setBackgroundResource(2131231211);
        this.binding.f.setImageResource(2131231211);
        TextView textView2 = this.binding.g;
        m.checkNotNullExpressionValue(textView2, "binding.itemInviteImageText");
        textView2.setVisibility(8);
        TextView textView3 = this.binding.f2325b;
        m.checkNotNullExpressionValue(textView3, "binding.itemInviteChannelName");
        textView3.setVisibility(8);
        ServerMemberCount serverMemberCount = this.binding.k;
        m.checkNotNullExpressionValue(serverMemberCount, "binding.itemInviteMemberContainer");
        serverMemberCount.setVisibility(8);
        MaterialButton materialButton = this.binding.l;
        m.checkNotNullExpressionValue(materialButton, "binding.itemInviteMentionButton");
        materialButton.setVisibility(8);
        MaterialButton materialButton2 = this.binding.h;
        m.checkNotNullExpressionValue(materialButton2, "binding.itemInviteJoinButton");
        materialButton2.setVisibility(8);
        MaterialButton materialButton3 = this.binding.i;
        m.checkNotNullExpressionValue(materialButton3, "binding.itemInviteJoinedButton");
        materialButton3.setVisibility(8);
        View view2 = this.binding.j;
        m.checkNotNullExpressionValue(view2, "binding.itemInviteLoadingButton");
        view2.setVisibility(0);
    }

    /* JADX WARN: Code duplicated, block: B:120:0x023d  */
    /* JADX WARN: Code duplicated, block: B:88:0x0197  */
    /* JADX WARN: Code duplicated, block: B:90:0x019d  */
    /* JADX WARN: Code duplicated, block: B:91:0x01a5  */
    private final void configureResolvedUI(WidgetChatListAdapterItemInvite$Model$Resolved model) {
        Guild guild;
        CharSequence charSequenceH;
        String name;
        boolean z2;
        com.discord.api.guild.Guild guild2;
        String name2;
        String icon;
        Channel channel;
        List<GuildFeature> listM;
        ModelInvite invite = model.getInvite();
        long meId = model.getMeId();
        User authorUser = model.getAuthorUser();
        boolean isMemberOfGuild = model.getIsMemberOfGuild();
        Channel channel2 = model.getChannel();
        View view = this.itemView;
        m.checkNotNullExpressionValue(view, "itemView");
        Context context = view.getContext();
        boolean z3 = authorUser != null && authorUser.getId() == meId;
        com.discord.api.guild.Guild guild3 = invite.guild;
        boolean z4 = (guild3 != null ? guild3.getMemberCount() : 0) < 200;
        Channel channel3 = invite.getChannel();
        boolean z5 = channel3 != null ? ChannelUtils.z(channel3) : false;
        com.discord.api.guild.Guild guild4 = invite.guild;
        boolean z6 = (guild4 == null || (listM = guild4.m()) == null || !listM.contains(GuildFeature.HUB)) ? false : true;
        boolean z7 = invite.getChannel() == null && invite.guild == null && invite.getInviter() != null;
        com.discord.api.guild.Guild guild5 = invite.guild;
        if (guild5 != null) {
            m.checkNotNullExpressionValue(guild5, "it");
            guild = new Guild(guild5);
        } else {
            guild = null;
        }
        SimpleDraweeView simpleDraweeView = this.binding.n;
        m.checkNotNullExpressionValue(simpleDraweeView, "binding.itemInviteSplash");
        IconUtils iconUtils = IconUtils.INSTANCE;
        View view2 = this.itemView;
        m.checkNotNullExpressionValue(view2, "itemView");
        Resources resources = view2.getResources();
        m.checkNotNullExpressionValue(resources, "itemView.resources");
        DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        IconUtils.setIcon$default(simpleDraweeView, iconUtils.getGuildSplashUrl(guild, displayMetrics != null ? Integer.valueOf(displayMetrics.widthPixels) : null), 0, (Function1) null, (MGImages$ChangeDetector) null, 28, (Object) null);
        RoundedRelativeLayout roundedRelativeLayout = this.binding.o;
        m.checkNotNullExpressionValue(roundedRelativeLayout, "binding.itemInviteSplashContainer");
        roundedRelativeLayout.setVisibility((guild != null ? guild.getSplash() : null) != null ? 0 : 8);
        TextView textView = this.binding.c;
        m.checkNotNullExpressionValue(textView, "binding.itemInviteHeader");
        if (z5 && z3) {
            m.checkNotNullExpressionValue(context, "context");
            charSequenceH = b.h(context, 2131892247, new Object[0], null, 4);
        } else if (z3) {
            m.checkNotNullExpressionValue(context, "context");
            charSequenceH = b.h(context, 2131892245, new Object[0], null, 4);
        } else if (z5 && !z3) {
            m.checkNotNullExpressionValue(context, "context");
            charSequenceH = b.h(context, 2131892239, new Object[0], null, 4);
        } else if (z6) {
            charSequenceH = context.getString(2131892240);
        } else if (z7) {
            m.checkNotNullExpressionValue(context, "context");
            Object[] objArr = new Object[1];
            com.discord.api.user.User inviter = invite.getInviter();
            objArr[0] = inviter != null ? inviter.getUsername() : null;
            charSequenceH = b.h(context, 2131892080, objArr, null, 4);
        } else if (!z4 || invite.getInviter() == null) {
            m.checkNotNullExpressionValue(context, "context");
            charSequenceH = b.h(context, 2131892237, new Object[0], null, 4);
        } else {
            m.checkNotNullExpressionValue(context, "context");
            Object[] objArr2 = new Object[1];
            com.discord.api.user.User inviter2 = invite.getInviter();
            objArr2[0] = inviter2 != null ? inviter2.getUsername() : null;
            charSequenceH = b.h(context, 2131892083, objArr2, null, 4);
        }
        textView.setText(charSequenceH);
        TextView textView2 = this.binding.m;
        m.checkNotNullExpressionValue(textView2, "binding.itemInviteName");
        if (!z5) {
            com.discord.api.guild.Guild guild6 = invite.guild;
            if (guild6 != null) {
                name = guild6.getName();
            } else {
                name = null;
            }
        } else if (channel2 != null) {
            m.checkNotNullExpressionValue(context, "context");
            name = ChannelUtils.e(channel2, context, false, 2);
            if (name == null) {
                channel = invite.getChannel();
                if (channel != null) {
                    m.checkNotNullExpressionValue(context, "context");
                    name = ChannelUtils.e(channel, context, false, 2);
                } else {
                    name = null;
                }
            }
        } else {
            channel = invite.getChannel();
            if (channel != null) {
                m.checkNotNullExpressionValue(context, "context");
                name = ChannelUtils.e(channel, context, false, 2);
            } else {
                name = null;
            }
        }
        textView2.setText(name);
        this.binding.m.setTextColor(ColorCompat.getThemedColor(context, 2130969971));
        this.binding.m.setBackgroundResource(0);
        if (z7) {
            SimpleDraweeView simpleDraweeView2 = this.binding.f;
            m.checkNotNullExpressionValue(simpleDraweeView2, "binding.itemInviteImage");
            simpleDraweeView2.setVisibility(8);
        } else if (z5) {
            updateIconUrlIfChanged(IconUtils.getForChannel$default(invite.getChannel(), null, 2, null));
            TextView textView3 = this.binding.g;
            m.checkNotNullExpressionValue(textView3, "binding.itemInviteImageText");
            textView3.setVisibility(8);
        } else {
            String strComputeShortName = null;
            com.discord.api.guild.Guild guild7 = invite.guild;
            Long lValueOf = guild7 != null ? Long.valueOf(guild7.getId()) : null;
            com.discord.api.guild.Guild guild8 = invite.guild;
            updateIconUrlIfChanged(IconUtils.getForGuild$default(lValueOf, guild8 != null ? guild8.getIcon() : null, IconUtils.DEFAULT_ICON_BLURPLE, model.getShouldAnimateGuildIcon(), null, 16, null));
            com.discord.api.guild.Guild guild9 = invite.guild;
            if (guild9 == null || (icon = guild9.getIcon()) == null) {
                z2 = false;
            } else {
                if (icon.length() > 0) {
                    z2 = true;
                } else {
                    z2 = false;
                }
            }
            TextView textView4 = this.binding.g;
            m.checkNotNullExpressionValue(textView4, "binding.itemInviteImageText");
            if (!z2 && (guild2 = invite.guild) != null && (name2 = guild2.getName()) != null) {
                strComputeShortName = GuildUtilsKt.computeShortName(name2);
            }
            ViewExtensions.setTextAndVisibilityBy(textView4, strComputeShortName);
        }
        if (channel2 == null || !ChannelUtils.w(channel2)) {
            configureForTextChannel(z5, invite);
        } else {
            m.checkNotNullExpressionValue(context, "context");
            configureForVocalChannel(channel2, context);
        }
        if (z5) {
            isMemberOfGuild = channel2 != null;
        }
        boolean z8 = z6 && GrowthTeamFeatures.INSTANCE.isHubEmailConnectionEnabled();
        View view3 = this.binding.j;
        m.checkNotNullExpressionValue(view3, "binding.itemInviteLoadingButton");
        view3.setVisibility(8);
        MaterialButton materialButton = this.binding.i;
        m.checkNotNullExpressionValue(materialButton, "binding.itemInviteJoinedButton");
        materialButton.setVisibility(isMemberOfGuild ? 0 : 8);
        MaterialButton materialButton2 = this.binding.h;
        m.checkNotNullExpressionValue(materialButton2, "binding.itemInviteJoinButton");
        materialButton2.setVisibility(true ^ isMemberOfGuild ? 0 : 8);
        MaterialButton materialButton3 = this.binding.l;
        m.checkNotNullExpressionValue(materialButton3, "binding.itemInviteMentionButton");
        materialButton3.setVisibility(8);
        this.binding.h.setOnClickListener(new WidgetChatListAdapterItemInvite$configureResolvedUI$2(this, invite));
        this.binding.i.setOnClickListener(new WidgetChatListAdapterItemInvite$configureResolvedUI$3(this, invite));
        FrameLayout frameLayout = this.binding.d;
        m.checkNotNullExpressionValue(frameLayout, "binding.itemInviteHubLayout");
        frameLayout.setVisibility(z8 ? 0 : 8);
        if (z8) {
            LinkifiedTextView linkifiedTextView = this.binding.e;
            m.checkNotNullExpressionValue(linkifiedTextView, "binding.itemInviteHubLink");
            m.checkNotNullExpressionValue(context, "context");
            linkifiedTextView.setText(b.b(context, 2131891821, new Object[0], new WidgetChatListAdapterItemInvite$configureResolvedUI$4(this)));
        }
    }

    private final void configureUI(WidgetChatListAdapterItemInvite$Model model) {
        if (model instanceof WidgetChatListAdapterItemInvite$Model$Loading) {
            configureLoadingUI();
        } else if (model instanceof WidgetChatListAdapterItemInvite$Model$Resolved) {
            configureResolvedUI((WidgetChatListAdapterItemInvite$Model$Resolved) model);
        } else {
            if (!(model instanceof WidgetChatListAdapterItemInvite$Model$Invalid)) {
                throw new NoWhenBranchMatchedException();
            }
            configureInvalidUI((WidgetChatListAdapterItemInvite$Model$Invalid) model);
        }
    }

    private final void launchHubsEmail(HubEmailArgs args) {
        View view = this.itemView;
        m.checkNotNullExpressionValue(view, "itemView");
        Context context = view.getContext();
        m.checkNotNullExpressionValue(context, "itemView.context");
        j.d(context, WidgetHubEmailFlow.class, args);
    }

    private final void updateIconUrlIfChanged(String iconUrl) {
        if (!m.areEqual(this.iconUrl, iconUrl)) {
            SimpleDraweeView simpleDraweeView = this.binding.f;
            m.checkNotNullExpressionValue(simpleDraweeView, "binding.itemInviteImage");
            IconUtils.setIcon$default(simpleDraweeView, iconUrl, 2131165293, (Function1) null, (MGImages$ChangeDetector) null, 24, (Object) null);
            this.iconUrl = iconUrl;
        }
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
    public Subscription getSubscription() {
        return this.subscription;
    }

    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListItem, com.discord.utilities.mg_recycler.MGRecyclerViewHolder
    public /* bridge */ /* synthetic */ void onConfigure(int i, ChatListEntry chatListEntry) {
        onConfigure(i, chatListEntry);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListItem
    public void onConfigure(int position, ChatListEntry data) {
        m.checkNotNullParameter(data, "data");
        super.onConfigure(position, data);
        this.item = (InviteEntry) data;
        StoreInstantInvites instantInvites = StoreStream.Companion.getInstantInvites();
        InviteEntry inviteEntry = this.item;
        if (inviteEntry == null) {
            m.throwUninitializedPropertyAccessException("item");
        }
        String inviteCode = inviteEntry.getInviteCode();
        InviteEntry inviteEntry2 = this.item;
        if (inviteEntry2 == null) {
            m.throwUninitializedPropertyAccessException("item");
        }
        String eventId = inviteEntry2.getEventId();
        StoreInstantInvites.fetchInviteIfNotLoaded$default(instantInvites, inviteCode, eventId != null ? SnowflakeUtils.INSTANCE.toSnowflake(eventId) : null, "Invite Button Embed", null, null, 24, null);
        WidgetChatListAdapterItemInvite$ModelProvider widgetChatListAdapterItemInvite$ModelProvider = WidgetChatListAdapterItemInvite$ModelProvider.INSTANCE;
        InviteEntry inviteEntry3 = this.item;
        if (inviteEntry3 == null) {
            m.throwUninitializedPropertyAccessException("item");
        }
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui(widgetChatListAdapterItemInvite$ModelProvider.get(inviteEntry3)), WidgetChatListAdapterItemInvite.class, (Context) null, new WidgetChatListAdapterItemInvite$onConfigure$3(this), new WidgetChatListAdapterItemInvite$onConfigure$2(this), (Function0) null, (Function0) null, new WidgetChatListAdapterItemInvite$onConfigure$1(this), 50, (Object) null);
    }
}
