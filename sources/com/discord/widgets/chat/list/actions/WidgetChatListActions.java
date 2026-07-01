package com.discord.widgets.chat.list.actions;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.MainThread;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;
import b.d.b.a.a;
import com.discord.R$layout;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.user.User;
import com.discord.app.AppBottomSheet;
import com.discord.databinding.WidgetChatListActionsBinding;
import com.discord.models.domain.emoji.Emoji;
import com.discord.models.guild.Guild;
import com.discord.models.message.Message;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreStream$Companion;
import com.discord.utilities.dimen.DimenUtils;
import com.discord.utilities.mg_recycler.MGRecyclerAdapter;
import com.discord.utilities.mg_recycler.MGRecyclerAdapter$Companion;
import com.discord.utilities.permissions.PermissionUtils;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.threads.ThreadUtils;
import com.discord.utilities.view.recycler.PaddedItemDecorator;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.widgets.notice.WidgetNoticeDialog;
import com.discord.widgets.notice.WidgetNoticeDialog$Companion;
import d0.o;
import d0.t.g0;
import d0.z.d.m;
import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;
import rx.Observable;

/* JADX INFO: compiled from: WidgetChatListActions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatListActions extends AppBottomSheet {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetChatListActions.class, "binding", "getBinding()Lcom/discord/databinding/WidgetChatListActionsBinding;", 0)};
    public static final WidgetChatListActions$Companion Companion = new WidgetChatListActions$Companion(null);
    private static final String INTENT_EXTRA_MESSAGE_CHANNEL_ID = "INTENT_EXTRA_MESSAGE_CHANNEL_ID";
    private static final String INTENT_EXTRA_MESSAGE_CONTENT = "INTENT_EXTRA_MESSAGE_CONTENT";
    private static final String INTENT_EXTRA_MESSAGE_ID = "INTENT_EXTRA_MESSAGE_ID";
    private static final String INTENT_EXTRA_TYPE = "INTENT_EXTRA_TYPE";
    private static final int TYPE_CHAT = 0;
    private static final int TYPE_PINS = 1;
    private WidgetChatListActionsEmojisAdapter adapter;

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private long channelId;
    private PaddedItemDecorator itemDecorator;
    private long messageId;

    public WidgetChatListActions() {
        super(false, 1, null);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetChatListActions$binding$2.INSTANCE, null, 2, null);
    }

    public static final /* synthetic */ void access$addReaction(WidgetChatListActions widgetChatListActions, Emoji emoji) {
        widgetChatListActions.addReaction(emoji);
    }

    public static final /* synthetic */ void access$configureUI(WidgetChatListActions widgetChatListActions, WidgetChatListActions$Model widgetChatListActions$Model) {
        widgetChatListActions.configureUI(widgetChatListActions$Model);
    }

    public static final /* synthetic */ void access$confirmPublishMessage(WidgetChatListActions widgetChatListActions, Message message) {
        widgetChatListActions.confirmPublishMessage(message);
    }

    public static final /* synthetic */ void access$deleteMessage(WidgetChatListActions widgetChatListActions, Message message) {
        widgetChatListActions.deleteMessage(message);
    }

    public static final /* synthetic */ void access$editMessage(WidgetChatListActions widgetChatListActions, Message message) {
        widgetChatListActions.editMessage(message);
    }

    public static final /* synthetic */ long access$getChannelId$p(WidgetChatListActions widgetChatListActions) {
        return widgetChatListActions.channelId;
    }

    public static final /* synthetic */ long access$getMessageId$p(WidgetChatListActions widgetChatListActions) {
        return widgetChatListActions.messageId;
    }

    public static final /* synthetic */ void access$removeAllReactions(WidgetChatListActions widgetChatListActions, WidgetChatListActions$Model widgetChatListActions$Model) {
        widgetChatListActions.removeAllReactions(widgetChatListActions$Model);
    }

    public static final /* synthetic */ void access$replyMessage(WidgetChatListActions widgetChatListActions, Message message, Channel channel) {
        widgetChatListActions.replyMessage(message, channel);
    }

    public static final /* synthetic */ void access$setChannelId$p(WidgetChatListActions widgetChatListActions, long j) {
        widgetChatListActions.channelId = j;
    }

    public static final /* synthetic */ void access$setMessageId$p(WidgetChatListActions widgetChatListActions, long j) {
        widgetChatListActions.messageId = j;
    }

    public static final /* synthetic */ void access$toggleMessagePin(WidgetChatListActions widgetChatListActions, Message message) {
        widgetChatListActions.toggleMessagePin(message);
    }

    private final void addReaction(Emoji emoji) {
        RestAPI api = RestAPI.Companion.getApi();
        long j = this.channelId;
        long j2 = this.messageId;
        String reactionKey = emoji.getReactionKey();
        m.checkNotNullExpressionValue(reactionKey, "emoji.reactionKey");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(api.addReaction(j, j2, reactionKey), false, 1, null), this, null, 2, null), getContext(), "REST: addReaction", (Function1) null, new WidgetChatListActions$addReaction$1(this, emoji), (Function1) null, (Function0) null, (Function0) null, 116, (Object) null);
    }

    private final void configureAddReactionEmojisList(List<? extends Emoji> recentEmojis, boolean isLocalMessage, boolean canAddReactions) {
        if (recentEmojis.isEmpty() || isLocalMessage || !canAddReactions) {
            RecyclerView recyclerView = getBinding().f2307b;
            m.checkNotNullExpressionValue(recyclerView, "binding.dialogChatActionsAddReactionEmojisList");
            recyclerView.setVisibility(8);
            return;
        }
        RecyclerView recyclerView2 = getBinding().f2307b;
        m.checkNotNullExpressionValue(recyclerView2, "binding.dialogChatActionsAddReactionEmojisList");
        recyclerView2.setVisibility(0);
        RecyclerView recyclerView3 = getBinding().f2307b;
        m.checkNotNullExpressionValue(recyclerView3, "binding.dialogChatActionsAddReactionEmojisList");
        int width = recyclerView3.getWidth();
        RecyclerView recyclerView4 = getBinding().f2307b;
        m.checkNotNullExpressionValue(recyclerView4, "binding.dialogChatActionsAddReactionEmojisList");
        int paddingStart = recyclerView4.getPaddingStart();
        RecyclerView recyclerView5 = getBinding().f2307b;
        m.checkNotNullExpressionValue(recyclerView5, "binding.dialogChatActionsAddReactionEmojisList");
        int paddingEnd = recyclerView5.getPaddingEnd() + paddingStart;
        int dimensionPixelSize = getResources().getDimensionPixelSize(2131165319);
        int iDpToPixels = DimenUtils.dpToPixels(8);
        int i = width - paddingEnd;
        int iMin = Math.min(recentEmojis.size() + 1, (i + iDpToPixels) / (dimensionPixelSize + iDpToPixels));
        int i2 = iMin - 1;
        int iMax = Math.max(i - ((i2 * iDpToPixels) + (dimensionPixelSize * iMin)), 0);
        PaddedItemDecorator paddedItemDecorator = this.itemDecorator;
        if (paddedItemDecorator != null) {
            getBinding().f2307b.removeItemDecoration(paddedItemDecorator);
        }
        PaddedItemDecorator paddedItemDecorator2 = new PaddedItemDecorator(0, (iMax / i2) + iDpToPixels, 0, true);
        getBinding().f2307b.addItemDecoration(paddedItemDecorator2);
        this.itemDecorator = paddedItemDecorator2;
        WidgetChatListActionsEmojisAdapter widgetChatListActionsEmojisAdapter = this.adapter;
        if (widgetChatListActionsEmojisAdapter == null) {
            m.throwUninitializedPropertyAccessException("adapter");
        }
        widgetChatListActionsEmojisAdapter.setData(recentEmojis, iMin);
    }

    /* JADX WARN: Code duplicated, block: B:79:0x01e1  */
    private final void configureUI(WidgetChatListActions$Model data) {
        Channel channel;
        Integer type;
        if (data == null) {
            dismiss();
            return;
        }
        Guild guild = data.getGuild();
        long id2 = guild != null ? guild.getId() : 0L;
        boolean zIsLocal = data.getMessage().isLocal();
        boolean zIsCrossposted = data.getMessage().isCrossposted();
        boolean z2 = true;
        boolean z3 = data.getManageMessageContext().getCanEdit() || data.getManageMessageContext().getCanManageMessages();
        configureAddReactionEmojisList(data.getRecentEmojis(), zIsLocal, data.getManageMessageContext().getCanAddReactions());
        int type2 = data.getType();
        if (type2 == 0) {
            TextView textView = getBinding().f;
            m.checkNotNullExpressionValue(textView, "binding.dialogChatActionsEdit");
            textView.setVisibility(data.getManageMessageContext().getCanEdit() ? 0 : 8);
            getBinding().f.setOnClickListener(new WidgetChatListActions$configureUI$1(this, data));
        } else if (type2 == 1) {
            TextView textView2 = getBinding().f;
            m.checkNotNullExpressionValue(textView2, "binding.dialogChatActionsEdit");
            textView2.setVisibility(8);
        }
        TextView textView3 = getBinding().k;
        m.checkNotNullExpressionValue(textView3, "binding.dialogChatActionsPublish");
        textView3.setVisibility(z3 && (channel = data.getChannel()) != null && channel.getType() == 5 && (type = data.getMessage().getType()) != null && type.intValue() == 0 && !zIsCrossposted ? 0 : 8);
        getBinding().k.setOnClickListener(new WidgetChatListActions$configureUI$2(this, data));
        TextView textView4 = getBinding().g;
        m.checkNotNullExpressionValue(textView4, "binding.dialogChatActionsManageReactions");
        textView4.setVisibility(data.getMessage().getReactionsMap().isEmpty() ^ true ? 0 : 8);
        getBinding().g.setOnClickListener(new WidgetChatListActions$configureUI$3(this));
        TextView textView5 = getBinding().l;
        m.checkNotNullExpressionValue(textView5, "binding.dialogChatActionsRemoveAllReactions");
        textView5.setVisibility((data.getMessage().getReactionsMap().isEmpty() ^ true) && data.getManageMessageContext().getCanManageMessages() ? 0 : 8);
        getBinding().l.setOnClickListener(new WidgetChatListActions$configureUI$4(this, data));
        TextView textView6 = getBinding().o;
        m.checkNotNullExpressionValue(textView6, "binding.dialogChatActionsResend");
        textView6.setVisibility(data.getMessage().canResend() ? 0 : 8);
        getBinding().o.setOnClickListener(new WidgetChatListActions$configureUI$5(this, data));
        TextView textView7 = getBinding().h;
        m.checkNotNullExpressionValue(textView7, "binding.dialogChatActionsMarkUnread");
        textView7.setVisibility(!data.getMessage().isFailed() && data.getManageMessageContext().getCanMarkUnread() ? 0 : 8);
        getBinding().h.setOnClickListener(new WidgetChatListActions$configureUI$6(this, data));
        if (data.getMessageContent() == null) {
            TextView textView8 = getBinding().c;
            m.checkNotNullExpressionValue(textView8, "binding.dialogChatActionsCopy");
            textView8.setVisibility(8);
        } else {
            if (!(data.getMessageContent().length() > 0) || data.getMessage().isLocalApplicationCommand()) {
                TextView textView9 = getBinding().c;
                m.checkNotNullExpressionValue(textView9, "binding.dialogChatActionsCopy");
                textView9.setVisibility(8);
            } else {
                TextView textView10 = getBinding().c;
                m.checkNotNullExpressionValue(textView10, "binding.dialogChatActionsCopy");
                textView10.setVisibility(0);
                getBinding().c.setOnClickListener(new WidgetChatListActions$configureUI$7(this, data));
            }
        }
        TextView textView11 = getBinding().d;
        m.checkNotNullExpressionValue(textView11, "binding.dialogChatActionsCopyId");
        textView11.setVisibility(data.isDeveloper() && !zIsLocal ? 0 : 8);
        getBinding().d.setOnClickListener(new WidgetChatListActions$configureUI$8(this, data));
        TextView textView12 = getBinding().n;
        m.checkNotNullExpressionValue(textView12, "binding.dialogChatActionsReport");
        User author = data.getMessage().getAuthor();
        textView12.setVisibility(author == null || (author.getId() > data.getMe().getId() ? 1 : (author.getId() == data.getMe().getId() ? 0 : -1)) != 0 ? 0 : 8);
        getBinding().n.setOnClickListener(new WidgetChatListActions$configureUI$9(this, data));
        TextView textView13 = getBinding().p;
        m.checkNotNullExpressionValue(textView13, "binding.dialogChatActionsShare");
        textView13.setVisibility(data.isDeveloper() && !zIsLocal ? 0 : 8);
        getBinding().p.setOnClickListener(new WidgetChatListActions$configureUI$10(this, data, id2));
        TextView textView14 = getBinding().i;
        m.checkNotNullExpressionValue(textView14, "binding.dialogChatActionsPin");
        textView14.setVisibility(data.getManageMessageContext().getCanTogglePinned() ? 0 : 8);
        getBinding().i.setText(m.areEqual(data.getMessage().getPinned(), Boolean.TRUE) ? 2131896596 : 2131893800);
        getBinding().i.setOnClickListener(new WidgetChatListActions$configureUI$11(this, data));
        TextView textView15 = getBinding().e;
        m.checkNotNullExpressionValue(textView15, "binding.dialogChatActionsDelete");
        textView15.setVisibility(data.getManageMessageContext().getCanDelete() ? 0 : 8);
        getBinding().e.setOnClickListener(new WidgetChatListActions$configureUI$12(this, data));
        getBinding().j.setOnClickListener(new WidgetChatListActions$configureUI$13(this, data));
        boolean z4 = (data.getChannel() == null || !ChannelUtils.B(data.getChannel()) || ChannelUtils.E(data.getChannel())) ? false : true;
        boolean z5 = data.getMessage().isUserMessage() || data.getMessage().isApplicationMessage();
        if (zIsLocal || data.getType() != 0 || !z5 || (!z4 && !PermissionUtils.can(67584L, data.getPermissions()))) {
            z2 = false;
        }
        TextView textView16 = getBinding().m;
        m.checkNotNullExpressionValue(textView16, "binding.dialogChatActionsReply");
        textView16.setVisibility(z2 ? 0 : 8);
        getBinding().m.setOnClickListener(new WidgetChatListActions$configureUI$14(this, data));
        TextView textView17 = getBinding().q;
        m.checkNotNullExpressionValue(textView17, "binding.dialogChatActionsStartThread");
        textView17.setVisibility(ThreadUtils.INSTANCE.canCreatePublicThread(data.getPermissions(), data.getChannel(), data.getMessage(), data.getGuild()) ? 0 : 8);
        getBinding().q.setOnClickListener(new WidgetChatListActions$configureUI$15(this, id2, data));
    }

    @MainThread
    private final void confirmPublishMessage(Message message) {
        MessageActionDialogs messageActionDialogs = MessageActionDialogs.INSTANCE;
        FragmentManager parentFragmentManager = getParentFragmentManager();
        m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        messageActionDialogs.showPublishMessageConfirmation(parentFragmentManager, message, new WidgetChatListActions$confirmPublishMessage$1(this));
    }

    @MainThread
    private final void deleteMessage(Message message) {
        MessageActionDialogs messageActionDialogs = MessageActionDialogs.INSTANCE;
        FragmentManager parentFragmentManager = getParentFragmentManager();
        m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        Context contextRequireContext = requireContext();
        m.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
        messageActionDialogs.showDeleteMessageConfirmation(parentFragmentManager, contextRequireContext, message, new WidgetChatListActions$deleteMessage$1(this));
    }

    private final void editMessage(Message message) {
        Observable<R> observableY = StoreStream.Companion.getChannels().observeGuildAndPrivateChannels().Y(new WidgetChatListActions$editMessage$1(message));
        m.checkNotNullExpressionValue(observableY, "StoreStream\n        .get…              }\n        }");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.takeSingleUntilTimeout$default(ObservableExtensionsKt.computationBuffered(observableY), 0L, false, 3, null), (Context) null, "editMessage", (Function1) null, new WidgetChatListActions$editMessage$2(message), (Function1) null, (Function0) null, (Function0) null, 117, (Object) null);
    }

    private final WidgetChatListActionsBinding getBinding() {
        return (WidgetChatListActionsBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    @MainThread
    private final void removeAllReactions(WidgetChatListActions$Model model) {
        WidgetNoticeDialog$Companion widgetNoticeDialog$Companion = WidgetNoticeDialog.Companion;
        FragmentManager parentFragmentManager = getParentFragmentManager();
        m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        String string = getString(2131894740);
        String string2 = getString(2131894739);
        m.checkNotNullExpressionValue(string2, "getString(R.string.remov…l_reactions_confirm_body)");
        WidgetNoticeDialog$Companion.show$default(widgetNoticeDialog$Companion, parentFragmentManager, string, string2, getString(2131897275), getString(2131893287), g0.mapOf(o.to(2131364555, new WidgetChatListActions$removeAllReactions$1(this, model))), null, null, null, null, null, null, 0, null, 16320, null);
    }

    private final void replyMessage(Message message, Channel channel) {
        StoreStream$Companion storeStream$Companion = StoreStream.Companion;
        long id2 = storeStream$Companion.getUsers().getMeSnapshot().getId();
        boolean zB = ChannelUtils.B(channel);
        boolean zIsWebhook = message.isWebhook();
        User author = message.getAuthor();
        boolean z2 = author != null && author.getId() == id2;
        storeStream$Companion.getPendingReplies().onCreatePendingReply(channel, message, (zIsWebhook || z2) ? false : true, (zB || zIsWebhook || z2) ? false : true);
    }

    public static final void showForChat(FragmentManager fragmentManager, long j, long j2, CharSequence charSequence) {
        Companion.showForChat(fragmentManager, j, j2, charSequence);
    }

    public static final void showForPin(FragmentManager fragmentManager, long j, long j2, CharSequence charSequence) {
        Companion.showForPin(fragmentManager, j, j2, charSequence);
    }

    @MainThread
    private final void toggleMessagePin(Message message) {
        MessageActionDialogs messageActionDialogs = MessageActionDialogs.INSTANCE;
        FragmentManager parentFragmentManager = getParentFragmentManager();
        m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        Context contextRequireContext = requireContext();
        m.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
        messageActionDialogs.showPinMessageConfirmation(parentFragmentManager, contextRequireContext, message, this, new WidgetChatListActions$toggleMessagePin$1(this));
    }

    @Override // com.discord.app.AppBottomSheet
    public int getContentViewResId() {
        return R$layout.widget_chat_list_actions;
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        AppBottomSheet.hideKeyboard$default(this, null, 1, null);
        Observable observableR = ObservableExtensionsKt.computationLatest(WidgetChatListActions$Model.Companion.get(this.channelId, this.messageId, getArgumentsOrDefault().getCharSequence(INTENT_EXTRA_MESSAGE_CONTENT), getArgumentsOrDefault().getInt(INTENT_EXTRA_TYPE))).r();
        m.checkNotNullExpressionValue(observableR, "Model.get(channelId, mes…  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(observableR, this, null, 2, null), WidgetChatListActions.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetChatListActions$onResume$1(this), 62, (Object) null);
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        m.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        this.channelId = getArgumentsOrDefault().getLong(INTENT_EXTRA_MESSAGE_CHANNEL_ID);
        this.messageId = getArgumentsOrDefault().getLong(INTENT_EXTRA_MESSAGE_ID);
        MGRecyclerAdapter$Companion mGRecyclerAdapter$Companion = MGRecyclerAdapter.Companion;
        RecyclerView recyclerView = getBinding().f2307b;
        m.checkNotNullExpressionValue(recyclerView, "binding.dialogChatActionsAddReactionEmojisList");
        WidgetChatListActionsEmojisAdapter widgetChatListActionsEmojisAdapter = (WidgetChatListActionsEmojisAdapter) mGRecyclerAdapter$Companion.configure(new WidgetChatListActionsEmojisAdapter(recyclerView));
        this.adapter = widgetChatListActionsEmojisAdapter;
        if (widgetChatListActionsEmojisAdapter == null) {
            m.throwUninitializedPropertyAccessException("adapter");
        }
        widgetChatListActionsEmojisAdapter.setOnClickEmoji(new WidgetChatListActions$onViewCreated$1(this));
        WidgetChatListActionsEmojisAdapter widgetChatListActionsEmojisAdapter2 = this.adapter;
        if (widgetChatListActionsEmojisAdapter2 == null) {
            m.throwUninitializedPropertyAccessException("adapter");
        }
        widgetChatListActionsEmojisAdapter2.setOnClickMoreEmojis(new WidgetChatListActions$onViewCreated$2(this));
        RecyclerView recyclerView2 = getBinding().f2307b;
        m.checkNotNullExpressionValue(recyclerView2, "binding.dialogChatActionsAddReactionEmojisList");
        WidgetChatListActionsEmojisAdapter widgetChatListActionsEmojisAdapter3 = this.adapter;
        if (widgetChatListActionsEmojisAdapter3 == null) {
            m.throwUninitializedPropertyAccessException("adapter");
        }
        recyclerView2.setAdapter(widgetChatListActionsEmojisAdapter3);
        getBinding().f2307b.setHasFixedSize(true);
    }
}
