package com.discord.widgets.chat.list.adapter;

import android.content.Context;
import android.graphics.Typeface;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import b.a.k.FormatUtils;
import com.discord.R;
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
import com.discord.widgets.forums.PostData2;
import com.google.android.flexbox.FlexboxLayout;
import d0.t.Collections2;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetChatListAdapterItemStart.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatListAdapterItemStart extends WidgetChatListItem {
    private final WidgetChatListAdapterItemStartBinding binding;

    /* JADX INFO: renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemStart$configureThread$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetChatListAdapterItemStart.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<RenderContext, Unit> {
        public final /* synthetic */ Context $context;
        public final /* synthetic */ GuildMember $threadCreatorMember;
        public final /* synthetic */ String $threadCreatorName;

        /* JADX INFO: renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemStart$configureThread$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: WidgetChatListAdapterItemStart.kt */
        public static final class C02751 extends Lambda implements Function1<Hook, Unit> {
            public C02751() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Hook hook) {
                invoke2(hook);
                return Unit.a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Hook hook) {
                Intrinsics3.checkNotNullParameter(hook, "$receiver");
                AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                hook.replacementText = anonymousClass1.$threadCreatorName;
                FontUtils fontUtils = FontUtils.INSTANCE;
                Context context = anonymousClass1.$context;
                Intrinsics3.checkNotNullExpressionValue(context, "context");
                Typeface themedFont = fontUtils.getThemedFont(context, R.attr.font_primary_semibold);
                if (themedFont != null) {
                    hook.styles.add(new TypefaceSpanCompat(themedFont));
                }
                List<Object> list = hook.styles;
                AnonymousClass1 anonymousClass2 = AnonymousClass1.this;
                list.add(new ForegroundColorSpan(WidgetChatListAdapterItemStart.this.getAuthorTextColor(anonymousClass2.$threadCreatorMember)));
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(String str, Context context, GuildMember guildMember) {
            super(1);
            this.$threadCreatorName = str;
            this.$context = context;
            this.$threadCreatorMember = guildMember;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(RenderContext renderContext) {
            invoke2(renderContext);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(RenderContext renderContext) {
            Intrinsics3.checkNotNullParameter(renderContext, "$receiver");
            renderContext.a("usernameHook", new C02751());
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemStart$configureThread$2, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetChatListAdapterItemStart.kt */
    public static final class AnonymousClass2 extends Lambda implements Function1<RenderContext, Unit> {
        public final /* synthetic */ String $autoArchiveString;
        public final /* synthetic */ Context $context;

        /* JADX INFO: renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemStart$configureThread$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: WidgetChatListAdapterItemStart.kt */
        public static final class AnonymousClass1 extends Lambda implements Function1<Hook, Unit> {
            public AnonymousClass1() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Hook hook) {
                invoke2(hook);
                return Unit.a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Hook hook) {
                Intrinsics3.checkNotNullParameter(hook, "$receiver");
                AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                hook.replacementText = anonymousClass2.$autoArchiveString;
                FontUtils fontUtils = FontUtils.INSTANCE;
                Context context = anonymousClass2.$context;
                Intrinsics3.checkNotNullExpressionValue(context, "context");
                Typeface themedFont = fontUtils.getThemedFont(context, R.attr.font_primary_normal);
                if (themedFont != null) {
                    hook.styles.add(new TypefaceSpanCompat(themedFont));
                }
                hook.styles.add(new ForegroundColorSpan(ColorCompat.getThemedColor(AnonymousClass2.this.$context, R.attr.colorHeaderPrimary)));
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(String str, Context context) {
            super(1);
            this.$autoArchiveString = str;
            this.$context = context;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(RenderContext renderContext) {
            invoke2(renderContext);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(RenderContext renderContext) {
            Intrinsics3.checkNotNullParameter(renderContext, "$receiver");
            renderContext.a("autoArchiveDurationHook", new AnonymousClass1());
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChatListAdapterItemStart(WidgetChatListAdapter widgetChatListAdapter) {
        super(R.layout.widget_chat_list_adapter_item_start, widgetChatListAdapter);
        Intrinsics3.checkNotNullParameter(widgetChatListAdapter, "adapter");
        View view = this.itemView;
        int i = R.id.chat_list_adapter_item_edit_channel;
        TextView textView = (TextView) view.findViewById(R.id.chat_list_adapter_item_edit_channel);
        if (textView != null) {
            i = R.id.chat_list_adapter_item_header;
            TextView textView2 = (TextView) view.findViewById(R.id.chat_list_adapter_item_header);
            if (textView2 != null) {
                i = R.id.chat_list_adapter_item_subheader1;
                TextView textView3 = (TextView) view.findViewById(R.id.chat_list_adapter_item_subheader1);
                if (textView3 != null) {
                    i = R.id.chat_list_adapter_item_subheader2;
                    TextView textView4 = (TextView) view.findViewById(R.id.chat_list_adapter_item_subheader2);
                    if (textView4 != null) {
                        i = R.id.chat_list_adapter_tags;
                        FlexboxLayout flexboxLayout = (FlexboxLayout) view.findViewById(R.id.chat_list_adapter_tags);
                        if (flexboxLayout != null) {
                            i = R.id.chat_list_adapter_thread_header_icon;
                            ImageView imageView = (ImageView) view.findViewById(R.id.chat_list_adapter_thread_header_icon);
                            if (imageView != null) {
                                WidgetChatListAdapterItemStartBinding widgetChatListAdapterItemStartBinding = new WidgetChatListAdapterItemStartBinding((LinearLayout) view, textView, textView2, textView3, textView4, flexboxLayout, imageView);
                                Intrinsics3.checkNotNullExpressionValue(widgetChatListAdapterItemStartBinding, "WidgetChatListAdapterIte…artBinding.bind(itemView)");
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
        TextView textView = this.binding.c;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.chatListAdapterItemHeader");
        FormatUtils.m(textView, R.string.android_welcome_message_title_channel, new Object[]{channelName}, (4 & 4) != 0 ? FormatUtils.g.j : null);
        TextView textView2 = this.binding.d;
        Intrinsics3.checkNotNullExpressionValue(textView2, "binding.chatListAdapterItemSubheader1");
        textView2.setVisibility(8);
        if (isTextInVoice) {
            ImageView imageView = this.binding.g;
            Intrinsics3.checkNotNullExpressionValue(imageView, "binding.chatListAdapterThreadHeaderIcon");
            imageView.setVisibility(0);
            this.binding.g.setImageResource(R.drawable.ic_chat_message_white_24dp);
        } else {
            ImageView imageView2 = this.binding.g;
            Intrinsics3.checkNotNullExpressionValue(imageView2, "binding.chatListAdapterThreadHeaderIcon");
            imageView2.setVisibility(8);
        }
        if (canReadMessageHistory) {
            TextView textView3 = this.binding.e;
            Intrinsics3.checkNotNullExpressionValue(textView3, "binding.chatListAdapterItemSubheader2");
            FormatUtils.m(textView3, R.string.android_welcome_message_subtitle_channel, new Object[]{channelName}, (4 & 4) != 0 ? FormatUtils.g.j : null);
        } else {
            TextView textView4 = this.binding.e;
            Intrinsics3.checkNotNullExpressionValue(textView4, "binding.chatListAdapterItemSubheader2");
            FormatUtils.m(textView4, R.string.beginning_channel_no_history, new Object[]{channelName}, (4 & 4) != 0 ? FormatUtils.g.j : null);
        }
        this.binding.f2333b.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemStart.configureChannel.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetTextChannelSettings.INSTANCE.launch(channelId, WidgetChatListAdapterItemStart.access$getAdapter$p(WidgetChatListAdapterItemStart.this).getContext());
            }
        });
        TextView textView5 = this.binding.f2333b;
        Intrinsics3.checkNotNullExpressionValue(textView5, "binding.chatListAdapterItemEditChannel");
        FormatUtils.m(textView5, R.string.edit_channel, new Object[0], (4 & 4) != 0 ? FormatUtils.g.j : null);
        TextView textView6 = this.binding.f2333b;
        Intrinsics3.checkNotNullExpressionValue(textView6, "binding.chatListAdapterItemEditChannel");
        textView6.setVisibility(canManageChannel ? 0 : 8);
    }

    private final void configureForumPost(String channelName, List<Long> appliedTags, List<ForumTag> availableTags) {
        List listEmptyList;
        ForumPostTagView forumPostTagView;
        TextView textView = this.binding.d;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.chatListAdapterItemSubheader1");
        textView.setVisibility(8);
        TextView textView2 = this.binding.e;
        Intrinsics3.checkNotNullExpressionValue(textView2, "binding.chatListAdapterItemSubheader2");
        textView2.setVisibility(8);
        TextView textView3 = this.binding.f2333b;
        Intrinsics3.checkNotNullExpressionValue(textView3, "binding.chatListAdapterItemEditChannel");
        textView3.setVisibility(8);
        ImageView imageView = this.binding.g;
        Intrinsics3.checkNotNullExpressionValue(imageView, "binding.chatListAdapterThreadHeaderIcon");
        imageView.setVisibility(0);
        TextView textView4 = this.binding.c;
        Intrinsics3.checkNotNullExpressionValue(textView4, "binding.chatListAdapterItemHeader");
        textView4.setText(channelName);
        this.binding.g.setImageResource(R.drawable.ic_channel_forum_post);
        if (availableTags != null) {
            listEmptyList = new ArrayList();
            for (Object obj : availableTags) {
                if (appliedTags != null ? appliedTags.contains(Long.valueOf(((ForumTag) obj).getId())) : false) {
                    listEmptyList.add(obj);
                }
            }
        } else {
            listEmptyList = Collections2.emptyList();
        }
        FlexboxLayout flexboxLayout = this.binding.f;
        Intrinsics3.checkNotNullExpressionValue(flexboxLayout, "binding.chatListAdapterTags");
        flexboxLayout.setVisibility(listEmptyList.isEmpty() ^ true ? 0 : 8);
        FlexboxLayout flexboxLayout2 = this.binding.f;
        Intrinsics3.checkNotNullExpressionValue(flexboxLayout2, "binding.chatListAdapterTags");
        int childCount = flexboxLayout2.getChildCount();
        for (int size = listEmptyList.size(); size < childCount; size++) {
            View childAt = this.binding.f.getChildAt(size);
            Intrinsics3.checkNotNullExpressionValue(childAt, "binding.chatListAdapterTags.getChildAt(i)");
            childAt.setVisibility(8);
        }
        int i = 0;
        int i2 = 0;
        for (Object obj2 : listEmptyList) {
            int i3 = i + 1;
            if (i < 0) {
                Collections2.throwIndexOverflow();
            }
            ForumTag forumTag = (ForumTag) obj2;
            if (i2 < childCount) {
                View childAt2 = this.binding.f.getChildAt(i2);
                Objects.requireNonNull(childAt2, "null cannot be cast to non-null type com.discord.widgets.forums.ForumPostTagView");
                forumPostTagView = (ForumPostTagView) childAt2;
                i2++;
            } else {
                FlexboxLayout flexboxLayout3 = this.binding.f;
                Intrinsics3.checkNotNullExpressionValue(flexboxLayout3, "binding.chatListAdapterTags");
                Context context = flexboxLayout3.getContext();
                Intrinsics3.checkNotNullExpressionValue(context, "binding.chatListAdapterTags.context");
                forumPostTagView = new ForumPostTagView(context, null, 0, 6, null);
                this.binding.f.addView(forumPostTagView);
            }
            forumPostTagView.setVisibility(0);
            ViewGroup.LayoutParams layoutParams = forumPostTagView.getLayoutParams();
            Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.setMargins(marginLayoutParams.leftMargin, marginLayoutParams.topMargin, DimenUtils.dpToPixels(6), DimenUtils.dpToPixels(6));
            forumPostTagView.setLayoutParams(marginLayoutParams);
            forumPostTagView.configureTag(PostData2.INSTANCE.fromTag(forumTag, false));
            i = i3;
        }
    }

    private final void configureThread(final long channelId, String channelName, boolean canReadMessageHistory, boolean canManageThread, GuildMember threadCreatorMember, String threadCreatorName, Integer threadAutoArchiveDuration) {
        TextView textView = this.binding.c;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.chatListAdapterItemHeader");
        Context context = textView.getContext();
        TextView textView2 = this.binding.c;
        Intrinsics3.checkNotNullExpressionValue(textView2, "binding.chatListAdapterItemHeader");
        textView2.setText(channelName);
        TextView textView3 = this.binding.d;
        Intrinsics3.checkNotNullExpressionValue(textView3, "binding.chatListAdapterItemSubheader1");
        textView3.setVisibility(0);
        TextView textView4 = this.binding.e;
        Intrinsics3.checkNotNullExpressionValue(textView4, "binding.chatListAdapterItemSubheader2");
        textView4.setVisibility(0);
        ImageView imageView = this.binding.g;
        Intrinsics3.checkNotNullExpressionValue(imageView, "binding.chatListAdapterThreadHeaderIcon");
        imageView.setVisibility(0);
        FlexboxLayout flexboxLayout = this.binding.f;
        Intrinsics3.checkNotNullExpressionValue(flexboxLayout, "binding.chatListAdapterTags");
        flexboxLayout.setVisibility(8);
        this.binding.g.setImageResource(R.drawable.ic_thread);
        TextView textView5 = this.binding.d;
        Intrinsics3.checkNotNullExpressionValue(textView5, "binding.chatListAdapterItemSubheader1");
        FormatUtils.m(textView5, R.string.thread_started_by, new Object[]{threadCreatorName}, new AnonymousClass1(threadCreatorName, context, threadCreatorMember));
        if (canReadMessageHistory) {
            ThreadUtils threadUtils = ThreadUtils.INSTANCE;
            Intrinsics3.checkNotNullExpressionValue(context, "context");
            String strAutoArchiveDurationName = threadUtils.autoArchiveDurationName(context, threadAutoArchiveDuration != null ? threadAutoArchiveDuration.intValue() : 0);
            TextView textView6 = this.binding.e;
            Intrinsics3.checkNotNullExpressionValue(textView6, "binding.chatListAdapterItemSubheader2");
            FormatUtils.m(textView6, R.string.beginning_thread_archive_description, new Object[]{strAutoArchiveDurationName}, new AnonymousClass2(strAutoArchiveDurationName, context));
        } else {
            TextView textView7 = this.binding.e;
            Intrinsics3.checkNotNullExpressionValue(textView7, "binding.chatListAdapterItemSubheader2");
            FormatUtils.m(textView7, R.string.beginning_channel_no_history, new Object[]{channelName}, (4 & 4) != 0 ? FormatUtils.g.j : null);
        }
        this.binding.f2333b.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemStart.configureThread.3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetThreadSettings.INSTANCE.launch(channelId, WidgetChatListAdapterItemStart.access$getAdapter$p(WidgetChatListAdapterItemStart.this).getContext());
            }
        });
        TextView textView8 = this.binding.f2333b;
        Intrinsics3.checkNotNullExpressionValue(textView8, "binding.chatListAdapterItemEditChannel");
        FormatUtils.m(textView8, R.string.edit_thread, new Object[0], (4 & 4) != 0 ? FormatUtils.g.j : null);
        TextView textView9 = this.binding.f2333b;
        Intrinsics3.checkNotNullExpressionValue(textView9, "binding.chatListAdapterItemEditChannel");
        textView9.setVisibility(canManageThread ? 0 : 8);
    }

    private final int getAuthorTextColor(GuildMember member) {
        View view = this.itemView;
        Intrinsics3.checkNotNullExpressionValue(view, "itemView");
        return GuildMember.INSTANCE.getColor(member, ColorCompat.getThemedColor(view.getContext(), R.attr.colorHeaderPrimary));
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListItem, com.discord.utilities.mg_recycler.MGRecyclerViewHolder
    public void onConfigure(int position, ChatListEntry data) {
        Intrinsics3.checkNotNullParameter(data, "data");
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
