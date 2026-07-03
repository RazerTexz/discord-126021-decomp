package com.discord.widgets.chat.list.adapter;

import android.content.Context;
import android.graphics.Typeface;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.discord.C5419R;
import com.discord.api.channel.ForumTag;
import com.discord.databinding.WidgetChatListAdapterItemStartBinding;
import com.discord.i18n.Hook;
import com.discord.i18n.RenderContext;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.member.GuildMember;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.dimen.DimenUtils;
import com.discord.utilities.font.FontUtils;
import com.discord.utilities.spans.TypefaceSpanCompat;
import com.discord.utilities.threads.ThreadUtils;
import com.discord.widgets.channels.settings.WidgetTextChannelSettings;
import com.discord.widgets.channels.settings.WidgetThreadSettings;
import com.discord.widgets.chat.list.entries.ChatListEntry;
import com.discord.widgets.chat.list.entries.StartOfChatEntry;
import com.discord.widgets.forums.ForumPostTagView;
import com.discord.widgets.forums.PostTagData;
import com.google.android.flexbox.FlexboxLayout;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p007b.p008a.p027k.C1107b;
import p507d0.p580t.C12147n;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetChatListAdapterItemStart.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatListAdapterItemStart extends WidgetChatListItem {
    private final WidgetChatListAdapterItemStartBinding binding;

    /* JADX INFO: renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemStart$configureThread$1 */
    /* JADX INFO: compiled from: WidgetChatListAdapterItemStart.kt */
    public static final class C81241 extends AbstractC12240o implements Function1<RenderContext, Unit> {
        public final /* synthetic */ Context $context;
        public final /* synthetic */ GuildMember $threadCreatorMember;
        public final /* synthetic */ String $threadCreatorName;

        /* JADX INFO: renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemStart$configureThread$1$1, reason: invalid class name */
        /* JADX INFO: compiled from: WidgetChatListAdapterItemStart.kt */
        public static final class AnonymousClass1 extends AbstractC12240o implements Function1<Hook, Unit> {
            public AnonymousClass1() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Hook hook) {
                invoke2(hook);
                return Unit.f27425a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Hook hook) {
                C12238m.checkNotNullParameter(hook, "$receiver");
                C81241 c81241 = C81241.this;
                hook.replacementText = c81241.$threadCreatorName;
                FontUtils fontUtils = FontUtils.INSTANCE;
                Context context = c81241.$context;
                C12238m.checkNotNullExpressionValue(context, "context");
                Typeface themedFont = fontUtils.getThemedFont(context, C5419R.attr.font_primary_semibold);
                if (themedFont != null) {
                    hook.styles.add(new TypefaceSpanCompat(themedFont));
                }
                List<Object> list = hook.styles;
                C81241 c81242 = C81241.this;
                list.add(new ForegroundColorSpan(WidgetChatListAdapterItemStart.this.getAuthorTextColor(c81242.$threadCreatorMember)));
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C81241(String str, Context context, GuildMember guildMember) {
            super(1);
            this.$threadCreatorName = str;
            this.$context = context;
            this.$threadCreatorMember = guildMember;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(RenderContext renderContext) {
            invoke2(renderContext);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(RenderContext renderContext) {
            C12238m.checkNotNullParameter(renderContext, "$receiver");
            renderContext.m8422a("usernameHook", new AnonymousClass1());
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemStart$configureThread$2 */
    /* JADX INFO: compiled from: WidgetChatListAdapterItemStart.kt */
    public static final class C81252 extends AbstractC12240o implements Function1<RenderContext, Unit> {
        public final /* synthetic */ String $autoArchiveString;
        public final /* synthetic */ Context $context;

        /* JADX INFO: renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemStart$configureThread$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: WidgetChatListAdapterItemStart.kt */
        public static final class AnonymousClass1 extends AbstractC12240o implements Function1<Hook, Unit> {
            public AnonymousClass1() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Hook hook) {
                invoke2(hook);
                return Unit.f27425a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Hook hook) {
                C12238m.checkNotNullParameter(hook, "$receiver");
                C81252 c81252 = C81252.this;
                hook.replacementText = c81252.$autoArchiveString;
                FontUtils fontUtils = FontUtils.INSTANCE;
                Context context = c81252.$context;
                C12238m.checkNotNullExpressionValue(context, "context");
                Typeface themedFont = fontUtils.getThemedFont(context, C5419R.attr.font_primary_normal);
                if (themedFont != null) {
                    hook.styles.add(new TypefaceSpanCompat(themedFont));
                }
                hook.styles.add(new ForegroundColorSpan(ColorCompat.getThemedColor(C81252.this.$context, C5419R.attr.colorHeaderPrimary)));
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C81252(String str, Context context) {
            super(1);
            this.$autoArchiveString = str;
            this.$context = context;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(RenderContext renderContext) {
            invoke2(renderContext);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(RenderContext renderContext) {
            C12238m.checkNotNullParameter(renderContext, "$receiver");
            renderContext.m8422a("autoArchiveDurationHook", new AnonymousClass1());
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChatListAdapterItemStart(WidgetChatListAdapter widgetChatListAdapter) {
        super(C5419R.layout.widget_chat_list_adapter_item_start, widgetChatListAdapter);
        C12238m.checkNotNullParameter(widgetChatListAdapter, "adapter");
        View view = this.itemView;
        int i = C5419R.id.chat_list_adapter_item_edit_channel;
        TextView textView = (TextView) view.findViewById(C5419R.id.chat_list_adapter_item_edit_channel);
        if (textView != null) {
            i = C5419R.id.chat_list_adapter_item_header;
            TextView textView2 = (TextView) view.findViewById(C5419R.id.chat_list_adapter_item_header);
            if (textView2 != null) {
                i = C5419R.id.chat_list_adapter_item_subheader1;
                TextView textView3 = (TextView) view.findViewById(C5419R.id.chat_list_adapter_item_subheader1);
                if (textView3 != null) {
                    i = C5419R.id.chat_list_adapter_item_subheader2;
                    TextView textView4 = (TextView) view.findViewById(C5419R.id.chat_list_adapter_item_subheader2);
                    if (textView4 != null) {
                        i = C5419R.id.chat_list_adapter_tags;
                        FlexboxLayout flexboxLayout = (FlexboxLayout) view.findViewById(C5419R.id.chat_list_adapter_tags);
                        if (flexboxLayout != null) {
                            i = C5419R.id.chat_list_adapter_thread_header_icon;
                            ImageView imageView = (ImageView) view.findViewById(C5419R.id.chat_list_adapter_thread_header_icon);
                            if (imageView != null) {
                                WidgetChatListAdapterItemStartBinding widgetChatListAdapterItemStartBinding = new WidgetChatListAdapterItemStartBinding((LinearLayout) view, textView, textView2, textView3, textView4, flexboxLayout, imageView);
                                C12238m.checkNotNullExpressionValue(widgetChatListAdapterItemStartBinding, "WidgetChatListAdapterIte…artBinding.bind(itemView)");
                                this.binding = widgetChatListAdapterItemStartBinding;
                                return;
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static final /* synthetic */ WidgetChatListAdapter access$getAdapter$p(WidgetChatListAdapterItemStart widgetChatListAdapterItemStart) {
        return (WidgetChatListAdapter) widgetChatListAdapterItemStart.adapter;
    }

    private final void configureChannel(final long channelId, String channelName, boolean isTextInVoice, boolean canReadMessageHistory, boolean canManageChannel) {
        TextView textView = this.binding.f16292c;
        C12238m.checkNotNullExpressionValue(textView, "binding.chatListAdapterItemHeader");
        C1107b.m221m(textView, C5419R.string.android_welcome_message_title_channel, new Object[]{channelName}, (4 & 4) != 0 ? C1107b.g.f1495j : null);
        TextView textView2 = this.binding.f16293d;
        C12238m.checkNotNullExpressionValue(textView2, "binding.chatListAdapterItemSubheader1");
        textView2.setVisibility(8);
        if (isTextInVoice) {
            ImageView imageView = this.binding.f16296g;
            C12238m.checkNotNullExpressionValue(imageView, "binding.chatListAdapterThreadHeaderIcon");
            imageView.setVisibility(0);
            this.binding.f16296g.setImageResource(C5419R.drawable.ic_chat_message_white_24dp);
        } else {
            ImageView imageView2 = this.binding.f16296g;
            C12238m.checkNotNullExpressionValue(imageView2, "binding.chatListAdapterThreadHeaderIcon");
            imageView2.setVisibility(8);
        }
        if (canReadMessageHistory) {
            TextView textView3 = this.binding.f16294e;
            C12238m.checkNotNullExpressionValue(textView3, "binding.chatListAdapterItemSubheader2");
            C1107b.m221m(textView3, C5419R.string.android_welcome_message_subtitle_channel, new Object[]{channelName}, (4 & 4) != 0 ? C1107b.g.f1495j : null);
        } else {
            TextView textView4 = this.binding.f16294e;
            C12238m.checkNotNullExpressionValue(textView4, "binding.chatListAdapterItemSubheader2");
            C1107b.m221m(textView4, C5419R.string.beginning_channel_no_history, new Object[]{channelName}, (4 & 4) != 0 ? C1107b.g.f1495j : null);
        }
        this.binding.f16291b.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemStart.configureChannel.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetTextChannelSettings.INSTANCE.launch(channelId, WidgetChatListAdapterItemStart.access$getAdapter$p(WidgetChatListAdapterItemStart.this).getContext());
            }
        });
        TextView textView5 = this.binding.f16291b;
        C12238m.checkNotNullExpressionValue(textView5, "binding.chatListAdapterItemEditChannel");
        C1107b.m221m(textView5, C5419R.string.edit_channel, new Object[0], (4 & 4) != 0 ? C1107b.g.f1495j : null);
        TextView textView6 = this.binding.f16291b;
        C12238m.checkNotNullExpressionValue(textView6, "binding.chatListAdapterItemEditChannel");
        textView6.setVisibility(canManageChannel ? 0 : 8);
    }

    private final void configureForumPost(String channelName, List<Long> appliedTags, List<ForumTag> availableTags) {
        List listEmptyList;
        ForumPostTagView forumPostTagView;
        TextView textView = this.binding.f16293d;
        C12238m.checkNotNullExpressionValue(textView, "binding.chatListAdapterItemSubheader1");
        textView.setVisibility(8);
        TextView textView2 = this.binding.f16294e;
        C12238m.checkNotNullExpressionValue(textView2, "binding.chatListAdapterItemSubheader2");
        textView2.setVisibility(8);
        TextView textView3 = this.binding.f16291b;
        C12238m.checkNotNullExpressionValue(textView3, "binding.chatListAdapterItemEditChannel");
        textView3.setVisibility(8);
        ImageView imageView = this.binding.f16296g;
        C12238m.checkNotNullExpressionValue(imageView, "binding.chatListAdapterThreadHeaderIcon");
        imageView.setVisibility(0);
        TextView textView4 = this.binding.f16292c;
        C12238m.checkNotNullExpressionValue(textView4, "binding.chatListAdapterItemHeader");
        textView4.setText(channelName);
        this.binding.f16296g.setImageResource(C5419R.drawable.ic_channel_forum_post);
        if (availableTags != null) {
            listEmptyList = new ArrayList();
            for (Object obj : availableTags) {
                if (appliedTags != null ? appliedTags.contains(Long.valueOf(((ForumTag) obj).getId())) : false) {
                    listEmptyList.add(obj);
                }
            }
        } else {
            listEmptyList = C12147n.emptyList();
        }
        FlexboxLayout flexboxLayout = this.binding.f16295f;
        C12238m.checkNotNullExpressionValue(flexboxLayout, "binding.chatListAdapterTags");
        flexboxLayout.setVisibility(listEmptyList.isEmpty() ^ true ? 0 : 8);
        FlexboxLayout flexboxLayout2 = this.binding.f16295f;
        C12238m.checkNotNullExpressionValue(flexboxLayout2, "binding.chatListAdapterTags");
        int childCount = flexboxLayout2.getChildCount();
        for (int size = listEmptyList.size(); size < childCount; size++) {
            View childAt = this.binding.f16295f.getChildAt(size);
            C12238m.checkNotNullExpressionValue(childAt, "binding.chatListAdapterTags.getChildAt(i)");
            childAt.setVisibility(8);
        }
        int i = 0;
        int i2 = 0;
        for (Object obj2 : listEmptyList) {
            int i3 = i + 1;
            if (i < 0) {
                C12147n.throwIndexOverflow();
            }
            ForumTag forumTag = (ForumTag) obj2;
            if (i2 < childCount) {
                View childAt2 = this.binding.f16295f.getChildAt(i2);
                Objects.requireNonNull(childAt2, "null cannot be cast to non-null type com.discord.widgets.forums.ForumPostTagView");
                forumPostTagView = (ForumPostTagView) childAt2;
                i2++;
            } else {
                FlexboxLayout flexboxLayout3 = this.binding.f16295f;
                C12238m.checkNotNullExpressionValue(flexboxLayout3, "binding.chatListAdapterTags");
                Context context = flexboxLayout3.getContext();
                C12238m.checkNotNullExpressionValue(context, "binding.chatListAdapterTags.context");
                forumPostTagView = new ForumPostTagView(context, null, 0, 6, null);
                this.binding.f16295f.addView(forumPostTagView);
            }
            forumPostTagView.setVisibility(0);
            ViewGroup.LayoutParams layoutParams = forumPostTagView.getLayoutParams();
            Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.setMargins(marginLayoutParams.leftMargin, marginLayoutParams.topMargin, DimenUtils.dpToPixels(6), DimenUtils.dpToPixels(6));
            forumPostTagView.setLayoutParams(marginLayoutParams);
            forumPostTagView.configureTag(PostTagData.INSTANCE.fromTag(forumTag, false));
            i = i3;
        }
    }

    private final void configureThread(final long channelId, String channelName, boolean canReadMessageHistory, boolean canManageThread, GuildMember threadCreatorMember, String threadCreatorName, Integer threadAutoArchiveDuration) {
        TextView textView = this.binding.f16292c;
        C12238m.checkNotNullExpressionValue(textView, "binding.chatListAdapterItemHeader");
        Context context = textView.getContext();
        TextView textView2 = this.binding.f16292c;
        C12238m.checkNotNullExpressionValue(textView2, "binding.chatListAdapterItemHeader");
        textView2.setText(channelName);
        TextView textView3 = this.binding.f16293d;
        C12238m.checkNotNullExpressionValue(textView3, "binding.chatListAdapterItemSubheader1");
        textView3.setVisibility(0);
        TextView textView4 = this.binding.f16294e;
        C12238m.checkNotNullExpressionValue(textView4, "binding.chatListAdapterItemSubheader2");
        textView4.setVisibility(0);
        ImageView imageView = this.binding.f16296g;
        C12238m.checkNotNullExpressionValue(imageView, "binding.chatListAdapterThreadHeaderIcon");
        imageView.setVisibility(0);
        FlexboxLayout flexboxLayout = this.binding.f16295f;
        C12238m.checkNotNullExpressionValue(flexboxLayout, "binding.chatListAdapterTags");
        flexboxLayout.setVisibility(8);
        this.binding.f16296g.setImageResource(C5419R.drawable.ic_thread);
        TextView textView5 = this.binding.f16293d;
        C12238m.checkNotNullExpressionValue(textView5, "binding.chatListAdapterItemSubheader1");
        C1107b.m221m(textView5, C5419R.string.thread_started_by, new Object[]{threadCreatorName}, new C81241(threadCreatorName, context, threadCreatorMember));
        if (canReadMessageHistory) {
            ThreadUtils threadUtils = ThreadUtils.INSTANCE;
            C12238m.checkNotNullExpressionValue(context, "context");
            String strAutoArchiveDurationName = threadUtils.autoArchiveDurationName(context, threadAutoArchiveDuration != null ? threadAutoArchiveDuration.intValue() : 0);
            TextView textView6 = this.binding.f16294e;
            C12238m.checkNotNullExpressionValue(textView6, "binding.chatListAdapterItemSubheader2");
            C1107b.m221m(textView6, C5419R.string.beginning_thread_archive_description, new Object[]{strAutoArchiveDurationName}, new C81252(strAutoArchiveDurationName, context));
        } else {
            TextView textView7 = this.binding.f16294e;
            C12238m.checkNotNullExpressionValue(textView7, "binding.chatListAdapterItemSubheader2");
            C1107b.m221m(textView7, C5419R.string.beginning_channel_no_history, new Object[]{channelName}, (4 & 4) != 0 ? C1107b.g.f1495j : null);
        }
        this.binding.f16291b.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemStart.configureThread.3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetThreadSettings.INSTANCE.launch(channelId, WidgetChatListAdapterItemStart.access$getAdapter$p(WidgetChatListAdapterItemStart.this).getContext());
            }
        });
        TextView textView8 = this.binding.f16291b;
        C12238m.checkNotNullExpressionValue(textView8, "binding.chatListAdapterItemEditChannel");
        C1107b.m221m(textView8, C5419R.string.edit_thread, new Object[0], (4 & 4) != 0 ? C1107b.g.f1495j : null);
        TextView textView9 = this.binding.f16291b;
        C12238m.checkNotNullExpressionValue(textView9, "binding.chatListAdapterItemEditChannel");
        textView9.setVisibility(canManageThread ? 0 : 8);
    }

    private final int getAuthorTextColor(GuildMember member) {
        View view = this.itemView;
        C12238m.checkNotNullExpressionValue(view, "itemView");
        return GuildMember.INSTANCE.getColor(member, ColorCompat.getThemedColor(view.getContext(), C5419R.attr.colorHeaderPrimary));
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListItem, com.discord.utilities.mg_recycler.MGRecyclerViewHolder
    public void onConfigure(int position, ChatListEntry data) {
        C12238m.checkNotNullParameter(data, "data");
        super.onConfigure(position, data);
        StartOfChatEntry startOfChatEntry = (StartOfChatEntry) data;
        long jComponent1 = startOfChatEntry.getChannelId();
        String strComponent2 = startOfChatEntry.getChannelName();
        boolean zComponent3 = startOfChatEntry.getCanReadMessageHistory();
        boolean zComponent4 = startOfChatEntry.getCanManageChannel();
        boolean zComponent5 = startOfChatEntry.getCanManageThread();
        if (startOfChatEntry.isGuildForumPost() && startOfChatEntry.getCanAccessRedesignedForumChannels()) {
            configureForumPost(strComponent2, startOfChatEntry.getAppliedTags(), startOfChatEntry.getAvailableTags());
        } else if (startOfChatEntry.isThread()) {
            configureThread(jComponent1, strComponent2, zComponent3, zComponent5, startOfChatEntry.getThreadCreatorMember(), startOfChatEntry.getThreadCreatorName(), startOfChatEntry.getThreadAutoArchiveDuration());
        } else {
            configureChannel(jComponent1, strComponent2, startOfChatEntry.isTextInVoice(), zComponent3, zComponent4);
        }
    }
}
