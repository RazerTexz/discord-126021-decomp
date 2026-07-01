package com.discord.widgets.forums;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.style.StyleSpan;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.Barrier;
import androidx.constraintlayout.widget.ConstraintLayout;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.message.attachment.MessageAttachment;
import com.discord.api.message.reaction.MessageReaction;
import com.discord.api.utcdatetime.UtcDateTime;
import com.discord.databinding.ForumBrowserPostViewBinding;
import com.discord.embed.RenderableEmbedMedia;
import com.discord.models.guild.UserGuildMember;
import com.discord.models.member.GuildMember;
import com.discord.models.message.Message;
import com.discord.models.user.User;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.dimen.DimenUtils;
import com.discord.utilities.embed.EmbedResourceUtils;
import com.discord.utilities.extensions.SimpleDraweeViewExtensions;
import com.discord.utilities.images.MGImages;
import com.discord.utilities.message.MessageUtils;
import com.discord.utilities.textprocessing.DiscordParser;
import com.discord.utilities.textprocessing.MessagePreprocessor;
import com.discord.utilities.textprocessing.MessageRenderContext;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.view.text.SimpleDraweeSpanTextView;
import com.discord.views.ReactionView;
import com.discord.views.typing.TypingDots;
import com.discord.views.user.UserSummaryView;
import com.facebook.drawee.span.DraweeSpanStringBuilder;
import com.facebook.drawee.view.SimpleDraweeView;
import d0.LazyJVM;
import d0.d0._Ranges;
import d0.g0.StringsJVM;
import d0.z.d.Intrinsics3;
import java.util.List;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: ForumBrowserPostView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ForumBrowserPostView extends ConstraintLayout {
    private final int avatarSizePx;
    private final ForumBrowserPostViewBinding binding;

    /* JADX INFO: renamed from: cardPressHighlight$delegate, reason: from kotlin metadata */
    private final Lazy cardPressHighlight;

    /* JADX INFO: renamed from: defaultReactionMeTextColor$delegate, reason: from kotlin metadata */
    private final Lazy defaultReactionMeTextColor;
    private final int overlapAmountPx;

    /* JADX INFO: renamed from: reactionMeTextColor$delegate, reason: from kotlin metadata */
    private final Lazy reactionMeTextColor;

    public ForumBrowserPostView(Context context) {
        this(context, null, 0, 6, null);
    }

    public ForumBrowserPostView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    public /* synthetic */ ForumBrowserPostView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    private final void configureAttachments(List<MessageAttachment> attachments) {
        MessageAttachment messageAttachment = null;
        Object obj = null;
        if (attachments != null) {
            for (Object obj2 : attachments) {
                if (!((MessageAttachment) obj2).h()) {
                    obj = obj2;
                    break;
                }
            }
            messageAttachment = (MessageAttachment) obj;
        }
        if (messageAttachment == null) {
            SimpleDraweeView simpleDraweeView = this.binding.g;
            Intrinsics3.checkNotNullExpressionValue(simpleDraweeView, "binding.inlineMediaImagePreview");
            simpleDraweeView.setVisibility(8);
            return;
        }
        EmbedResourceUtils embedResourceUtils = EmbedResourceUtils.INSTANCE;
        RenderableEmbedMedia renderableEmbedMediaCreateRenderableEmbedMediaFromAttachment = embedResourceUtils.createRenderableEmbedMediaFromAttachment(messageAttachment);
        if (renderableEmbedMediaCreateRenderableEmbedMediaFromAttachment.url == null) {
            SimpleDraweeView simpleDraweeView2 = this.binding.g;
            Intrinsics3.checkNotNullExpressionValue(simpleDraweeView2, "binding.inlineMediaImagePreview");
            simpleDraweeView2.setVisibility(8);
        } else {
            SimpleDraweeView simpleDraweeView3 = this.binding.g;
            Intrinsics3.checkNotNullExpressionValue(simpleDraweeView3, "binding.inlineMediaImagePreview");
            simpleDraweeView3.setVisibility(0);
            SimpleDraweeView simpleDraweeView4 = this.binding.g;
            Intrinsics3.checkNotNullExpressionValue(simpleDraweeView4, "binding.inlineMediaImagePreview");
            MGImages.setImage$default(simpleDraweeView4, embedResourceUtils.getPreviewUrls(renderableEmbedMediaCreateRenderableEmbedMediaFromAttachment.url, DimenUtils.dpToPixels(64), DimenUtils.dpToPixels(64), false), 0, 0, false, null, null, null, 252, null);
        }
    }

    private final void configureFirstMessage(PostData post, Message message, String messageContent) {
        String string;
        if (message == null || messageContent == null) {
            SimpleDraweeSpanTextView simpleDraweeSpanTextView = this.binding.c;
            Intrinsics3.checkNotNullExpressionValue(simpleDraweeSpanTextView, "binding.forumPostDescText");
            simpleDraweeSpanTextView.setVisibility(8);
            return;
        }
        SimpleDraweeSpanTextView simpleDraweeSpanTextView2 = this.binding.c;
        Intrinsics3.checkNotNullExpressionValue(simpleDraweeSpanTextView2, "binding.forumPostDescText");
        simpleDraweeSpanTextView2.setVisibility(0);
        Context context = getContext();
        Intrinsics3.checkNotNullExpressionValue(context, "context");
        MessageRenderContext messageRenderContext = new MessageRenderContext(context, post.getMyUserId(), true, MessageUtils.getNickOrUsernames$default(message, post.getChannel(), post.getGuildMembers(), null, 8, null), post.getChannelNames(), post.getGuildRoles(), 0, null, null, ColorCompat.getThemedColor(getContext(), R.attr.theme_chat_spoiler_inapp_bg), 0, null, null, null, 15808, null);
        DraweeSpanStringBuilder channelMessage = null;
        if (post.isFirstMessageBlocked()) {
            string = getContext().getString(R.string.reply_quote_message_blocked);
        } else if (message.hasStickers()) {
            string = getContext().getString(R.string.reply_quote_sticker_mobile);
        } else {
            string = message.hasEmbeds() ? getContext().getString(R.string.reply_quote_no_text_content_mobile) : null;
        }
        if (string != null) {
            channelMessage = new DraweeSpanStringBuilder();
            channelMessage.append((CharSequence) (string + (char) 160));
            channelMessage.setSpan(new StyleSpan(2), 0, string.length(), 33);
        } else if (!StringsJVM.isBlank(messageContent)) {
            Context context2 = getContext();
            Intrinsics3.checkNotNullExpressionValue(context2, "context");
            MessagePreprocessor messagePreprocessor = new MessagePreprocessor(post.getMyUserId(), null, null, false, null, 30, null);
            DiscordParser.ParserOptions parserOptions = DiscordParser.ParserOptions.FORUM_POST_FIRST_MESSAGE;
            UtcDateTime editedTimestamp = message.getEditedTimestamp();
            channelMessage = DiscordParser.parseChannelMessage(context2, messageContent, messageRenderContext, messagePreprocessor, parserOptions, (editedTimestamp != null ? editedTimestamp.getDateTimeMillis() : 0L) > 0);
        }
        if (channelMessage != null) {
            this.binding.c.setDraweeSpanStringBuilder(channelMessage);
        }
    }

    private final void configureMessageCount(PostData post) {
        ForumUtils forumUtils = ForumUtils.INSTANCE;
        String messageCountString = forumUtils.getMessageCountString(post.getMessageCount());
        Context context = getContext();
        Intrinsics3.checkNotNullExpressionValue(context, "context");
        CharSequence unreadMessageCountString = forumUtils.getUnreadMessageCountString(context, post.getUnreadCount());
        if (messageCountString == null) {
            LinearLayout linearLayout = this.binding.i;
            Intrinsics3.checkNotNullExpressionValue(linearLayout, "binding.messageCountContainer");
            linearLayout.setVisibility(8);
            return;
        }
        LinearLayout linearLayout2 = this.binding.i;
        Intrinsics3.checkNotNullExpressionValue(linearLayout2, "binding.messageCountContainer");
        linearLayout2.setVisibility(0);
        TextView textView = this.binding.h;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.messageCount");
        textView.setText(messageCountString);
        if (post.getReadState().getHasSeenBefore()) {
            TextView textView2 = this.binding.p;
            Intrinsics3.checkNotNullExpressionValue(textView2, "binding.unreadMessageCount");
            ViewExtensions.setTextAndVisibilityBy(textView2, unreadMessageCountString);
        } else {
            TextView textView3 = this.binding.p;
            Intrinsics3.checkNotNullExpressionValue(textView3, "binding.unreadMessageCount");
            textView3.setVisibility(8);
        }
    }

    private final void configurePostOwner(PostData post) {
        String username;
        User owner = post.getOwner();
        SimpleDraweeView simpleDraweeView = this.binding.d;
        Intrinsics3.checkNotNullExpressionValue(simpleDraweeView, "binding.forumPostOwnerAvatar");
        simpleDraweeView.setVisibility(owner != null ? 0 : 8);
        TextView textView = this.binding.e;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.forumPostOwnerName");
        textView.setVisibility(owner != null ? 0 : 8);
        if (owner != null) {
            GuildMember guildMember = (GuildMember) outline.f(owner, post.getGuildMembers());
            TextView textView2 = this.binding.e;
            Intrinsics3.checkNotNullExpressionValue(textView2, "binding.forumPostOwnerName");
            if (guildMember == null || (username = guildMember.getNick()) == null) {
                username = owner.getUsername();
            }
            textView2.setText(username);
            this.binding.e.setTextColor(GuildMember.INSTANCE.getColor(guildMember, ColorCompat.getThemedColor(getContext(), R.attr.colorInteractiveNormal)));
            SimpleDraweeView simpleDraweeView2 = this.binding.d;
            Intrinsics3.checkNotNullExpressionValue(simpleDraweeView2, "binding.forumPostOwnerAvatar");
            SimpleDraweeViewExtensions.setAvatar(simpleDraweeView2, post.getOwner(), false, R.dimen.avatar_size_small, guildMember);
        }
    }

    private final void configureReaction(MessageReaction reaction, boolean isDefaultReaction, Long messageId) {
        ColorStateList defaultReactionMeTextColor = isDefaultReaction ? getDefaultReactionMeTextColor() : getReactionMeTextColor();
        if (defaultReactionMeTextColor != null) {
            this.binding.l.setMeTextColor(defaultReactionMeTextColor);
        }
        ReactionView reactionView = this.binding.l;
        Intrinsics3.checkNotNullExpressionValue(reactionView, "binding.reaction");
        reactionView.setVisibility(reaction != null && messageId != null ? 0 : 8);
        if (reaction == null || messageId == null) {
            return;
        }
        this.binding.l.a(reaction, messageId.longValue(), true);
    }

    private final void configureReadState(PostData post) {
        ForumPostReadState readState = post.getReadState();
        ImageView imageView = this.binding.j;
        Intrinsics3.checkNotNullExpressionValue(imageView, "binding.neverSeenBefore");
        imageView.setVisibility(!readState.getHasSeenBefore() && !post.getIsMe() ? 0 : 8);
        float f = readState.getHasUnread() ? 1.0f : 0.8f;
        SimpleDraweeView simpleDraweeView = this.binding.d;
        Intrinsics3.checkNotNullExpressionValue(simpleDraweeView, "binding.forumPostOwnerAvatar");
        simpleDraweeView.setAlpha(f);
        TextView textView = this.binding.e;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.forumPostOwnerName");
        textView.setAlpha(f);
        if (readState.getHasUnread()) {
            this.binding.f2109b.setTextColor(ColorCompat.getThemedColor(getContext(), R.attr.colorHeaderPrimary));
            this.binding.c.setTextColor(ColorCompat.getThemedColor(getContext(), R.attr.colorHeaderSecondary));
        } else {
            int themedColor = ColorCompat.getThemedColor(getContext(), R.attr.primary_300);
            this.binding.f2109b.setTextColor(themedColor);
            this.binding.c.setTextColor(themedColor);
        }
    }

    private final void configureTag(PostData2 tag) {
        if (tag == null) {
            ForumPostTagView forumPostTagView = this.binding.f;
            Intrinsics3.checkNotNullExpressionValue(forumPostTagView, "binding.forumPostTag");
            forumPostTagView.setVisibility(8);
        } else {
            ForumPostTagView forumPostTagView2 = this.binding.f;
            forumPostTagView2.setVisibility(0);
            forumPostTagView2.configureTag(tag);
        }
    }

    private final void configureTypingIndicator(List<UserGuildMember> typingUsers) {
        this.binding.o.a(typingUsers, false);
        TypingDots.b(this.binding.n, false, 1);
        int iCoerceAtMost = _Ranges.coerceAtMost(typingUsers.size(), 3);
        TypingDots typingDots = this.binding.n;
        Intrinsics3.checkNotNullExpressionValue(typingDots, "binding.typingIndicator");
        ViewGroup.LayoutParams layoutParams = typingDots.getLayoutParams();
        Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        marginLayoutParams.setMarginStart(((this.avatarSizePx - this.overlapAmountPx) * iCoerceAtMost) - DimenUtils.dpToPixels(8));
        typingDots.setLayoutParams(marginLayoutParams);
    }

    private final Drawable getCardPressHighlight() {
        return (Drawable) this.cardPressHighlight.getValue();
    }

    private final ColorStateList getDefaultReactionMeTextColor() {
        return (ColorStateList) this.defaultReactionMeTextColor.getValue();
    }

    private final ColorStateList getReactionMeTextColor() {
        return (ColorStateList) this.reactionMeTextColor.getValue();
    }

    public final void configurePost(PostData post) {
        Intrinsics3.checkNotNullParameter(post, "post");
        TextView textView = this.binding.f2109b;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.formPostTitle");
        textView.setText(post.getChannel().getName());
        Message firstMessage = post.getFirstMessage();
        String content = firstMessage != null ? firstMessage.getContent() : null;
        ForumUtils forumUtils = ForumUtils.INSTANCE;
        Context context = getContext();
        Intrinsics3.checkNotNullExpressionValue(context, "context");
        CharSequence activeAgoTimestamp = forumUtils.getActiveAgoTimestamp(context, post.getMostRecentMessageTimestamp());
        TextView textView2 = this.binding.m;
        Intrinsics3.checkNotNullExpressionValue(textView2, "binding.timestamp");
        ViewExtensions.setTextAndVisibilityBy(textView2, activeAgoTimestamp);
        configureFirstMessage(post, firstMessage, content);
        configurePostOwner(post);
        configureAttachments(firstMessage != null ? firstMessage.getAttachments() : null);
        configureReaction(post.getMostCommonReaction(), post.isDefaultReaction(), firstMessage != null ? Long.valueOf(firstMessage.getId()) : null);
        configureMessageCount(post);
        configureTag(post.getTag());
        configureReadState(post);
        boolean z2 = !post.getTypingUsers().isEmpty();
        if (z2) {
            configureTypingIndicator(post.getTypingUsers());
        }
        ImageView imageView = this.binding.k;
        Intrinsics3.checkNotNullExpressionValue(imageView, "binding.pinnedIcon");
        imageView.setVisibility(ChannelUtils.A(post.getChannel()) ? 0 : 8);
        TextView textView3 = this.binding.m;
        Intrinsics3.checkNotNullExpressionValue(textView3, "binding.timestamp");
        textView3.setVisibility(z2 ^ true ? 0 : 8);
        UserSummaryView userSummaryView = this.binding.o;
        Intrinsics3.checkNotNullExpressionValue(userSummaryView, "binding.typingUserSummary");
        userSummaryView.setVisibility(z2 ? 0 : 8);
        TypingDots typingDots = this.binding.n;
        Intrinsics3.checkNotNullExpressionValue(typingDots, "binding.typingIndicator");
        typingDots.setVisibility(z2 ? 0 : 8);
        if (Build.VERSION.SDK_INT >= 23) {
            View view = this.binding.a;
            Intrinsics3.checkNotNullExpressionValue(view, "binding.root");
            view.setForeground(getCardPressHighlight());
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ForumBrowserPostView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics3.checkNotNullParameter(context, "context");
        LayoutInflater.from(context).inflate(R.layout.forum_browser_post_view, this);
        int i2 = R.id.footer_barrier;
        Barrier barrier = (Barrier) findViewById(R.id.footer_barrier);
        if (barrier != null) {
            i2 = R.id.form_post_title;
            TextView textView = (TextView) findViewById(R.id.form_post_title);
            if (textView != null) {
                i2 = R.id.forum_post_desc_text;
                SimpleDraweeSpanTextView simpleDraweeSpanTextView = (SimpleDraweeSpanTextView) findViewById(R.id.forum_post_desc_text);
                if (simpleDraweeSpanTextView != null) {
                    i2 = R.id.forum_post_owner_avatar;
                    SimpleDraweeView simpleDraweeView = (SimpleDraweeView) findViewById(R.id.forum_post_owner_avatar);
                    if (simpleDraweeView != null) {
                        i2 = R.id.forum_post_owner_name;
                        TextView textView2 = (TextView) findViewById(R.id.forum_post_owner_name);
                        if (textView2 != null) {
                            i2 = R.id.forum_post_tag;
                            ForumPostTagView forumPostTagView = (ForumPostTagView) findViewById(R.id.forum_post_tag);
                            if (forumPostTagView != null) {
                                i2 = R.id.header_barrier;
                                Barrier barrier2 = (Barrier) findViewById(R.id.header_barrier);
                                if (barrier2 != null) {
                                    i2 = R.id.inline_media_image_preview;
                                    SimpleDraweeView simpleDraweeView2 = (SimpleDraweeView) findViewById(R.id.inline_media_image_preview);
                                    if (simpleDraweeView2 != null) {
                                        i2 = R.id.message_count;
                                        TextView textView3 = (TextView) findViewById(R.id.message_count);
                                        if (textView3 != null) {
                                            i2 = R.id.message_count_container;
                                            LinearLayout linearLayout = (LinearLayout) findViewById(R.id.message_count_container);
                                            if (linearLayout != null) {
                                                i2 = R.id.never_seen_before;
                                                ImageView imageView = (ImageView) findViewById(R.id.never_seen_before);
                                                if (imageView != null) {
                                                    i2 = R.id.pinned_icon;
                                                    ImageView imageView2 = (ImageView) findViewById(R.id.pinned_icon);
                                                    if (imageView2 != null) {
                                                        i2 = R.id.reaction;
                                                        ReactionView reactionView = (ReactionView) findViewById(R.id.reaction);
                                                        if (reactionView != null) {
                                                            i2 = R.id.timestamp;
                                                            TextView textView4 = (TextView) findViewById(R.id.timestamp);
                                                            if (textView4 != null) {
                                                                i2 = R.id.typing_indicator;
                                                                TypingDots typingDots = (TypingDots) findViewById(R.id.typing_indicator);
                                                                if (typingDots != null) {
                                                                    i2 = R.id.typing_user_summary;
                                                                    UserSummaryView userSummaryView = (UserSummaryView) findViewById(R.id.typing_user_summary);
                                                                    if (userSummaryView != null) {
                                                                        i2 = R.id.unread_message_count;
                                                                        TextView textView5 = (TextView) findViewById(R.id.unread_message_count);
                                                                        if (textView5 != null) {
                                                                            ForumBrowserPostViewBinding forumBrowserPostViewBinding = new ForumBrowserPostViewBinding(this, barrier, textView, simpleDraweeSpanTextView, simpleDraweeView, textView2, forumPostTagView, barrier2, simpleDraweeView2, textView3, linearLayout, imageView, imageView2, reactionView, textView4, typingDots, userSummaryView, textView5);
                                                                            Intrinsics3.checkNotNullExpressionValue(forumBrowserPostViewBinding, "ForumBrowserPostViewBind…ater.from(context), this)");
                                                                            this.binding = forumBrowserPostViewBinding;
                                                                            this.defaultReactionMeTextColor = LazyJVM.lazy(new ForumBrowserPostView3(context));
                                                                            this.reactionMeTextColor = LazyJVM.lazy(new ForumBrowserPostView4(context));
                                                                            this.cardPressHighlight = LazyJVM.lazy(new ForumBrowserPostView2(context));
                                                                            this.avatarSizePx = DimenUtils.dpToPixels(16);
                                                                            this.overlapAmountPx = DimenUtils.dpToPixels(4);
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
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(i2)));
    }
}
