package com.discord.widgets.chat.list.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import b.a.k.b;
import b.d.b.a.a;
import com.discord.R$id;
import com.discord.R$layout;
import com.discord.api.message.call.MessageCall;
import com.discord.api.utcdatetime.UtcDateTime;
import com.discord.databinding.WidgetChatListAdapterItemCallBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.message.Message;
import com.discord.models.user.CoreUser;
import com.discord.models.user.User;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreVoiceParticipants$VoiceUser;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.color.ColorCompatKt;
import com.discord.utilities.dimen.DimenUtils;
import com.discord.utilities.duration.DurationUtilsKt;
import com.discord.utilities.mg_recycler.MGRecyclerAdapter;
import com.discord.utilities.mg_recycler.MGRecyclerAdapter$Companion;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.time.Clock;
import com.discord.utilities.time.ClockFactory;
import com.discord.utilities.time.TimeUtils;
import com.discord.widgets.channels.list.WidgetCollapsedUsersListAdapter;
import com.discord.widgets.channels.list.items.CollapsedUser;
import com.discord.widgets.chat.list.FragmentLifecycleListener;
import com.discord.widgets.chat.list.entries.ChatListEntry;
import com.discord.widgets.chat.list.entries.MessageEntry;
import d0.d0.f;
import d0.t.c0;
import d0.t.o;
import d0.t.u;
import d0.z.d.m;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map$Entry;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import rx.Observable;
import rx.Subscription;

/* JADX INFO: compiled from: WidgetChatListAdapterItemCallMessage.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatListAdapterItemCallMessage extends WidgetChatListItem implements FragmentLifecycleListener {
    private final WidgetChatListAdapterItemCallBinding binding;
    private ChatListEntry chatListEntry;
    private final Clock clock;
    private Subscription ongoingCallDurationSubscription;
    private Subscription stateSubscription;
    private final WidgetCollapsedUsersListAdapter usersAdapter;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChatListAdapterItemCallMessage(WidgetChatListAdapter widgetChatListAdapter) {
        super(R$layout.widget_chat_list_adapter_item_call, widgetChatListAdapter);
        m.checkNotNullParameter(widgetChatListAdapter, "adapter");
        View view = this.itemView;
        int i = R$id.chat_list_adapter_item_call_icon;
        ImageView imageView = (ImageView) view.findViewById(R$id.chat_list_adapter_item_call_icon);
        if (imageView != null) {
            i = R$id.chat_list_adapter_item_call_participants;
            RecyclerView recyclerView = (RecyclerView) view.findViewById(R$id.chat_list_adapter_item_call_participants);
            if (recyclerView != null) {
                i = R$id.chat_list_adapter_item_call_subtitle;
                TextView textView = (TextView) view.findViewById(R$id.chat_list_adapter_item_call_subtitle);
                if (textView != null) {
                    i = R$id.chat_list_adapter_item_call_title;
                    TextView textView2 = (TextView) view.findViewById(R$id.chat_list_adapter_item_call_title);
                    if (textView2 != null) {
                        i = R$id.chat_list_adapter_item_call_unjoined_ongoing_subtitle;
                        LinearLayout linearLayout = (LinearLayout) view.findViewById(R$id.chat_list_adapter_item_call_unjoined_ongoing_subtitle);
                        if (linearLayout != null) {
                            i = R$id.chat_list_adapter_item_unjoined_call_duration;
                            TextView textView3 = (TextView) view.findViewById(R$id.chat_list_adapter_item_unjoined_call_duration);
                            if (textView3 != null) {
                                WidgetChatListAdapterItemCallBinding widgetChatListAdapterItemCallBinding = new WidgetChatListAdapterItemCallBinding((CardView) view, imageView, recyclerView, textView, textView2, linearLayout, textView3);
                                m.checkNotNullExpressionValue(widgetChatListAdapterItemCallBinding, "WidgetChatListAdapterIte…allBinding.bind(itemView)");
                                this.binding = widgetChatListAdapterItemCallBinding;
                                this.clock = ClockFactory.get();
                                MGRecyclerAdapter$Companion mGRecyclerAdapter$Companion = MGRecyclerAdapter.Companion;
                                m.checkNotNullExpressionValue(recyclerView, "binding.chatListAdapterItemCallParticipants");
                                this.usersAdapter = (WidgetCollapsedUsersListAdapter) mGRecyclerAdapter$Companion.configure(new WidgetCollapsedUsersListAdapter(recyclerView));
                                this.itemView.addOnAttachStateChangeListener(new WidgetChatListAdapterItemCallMessage$1(this));
                                recyclerView.setHasFixedSize(false);
                                return;
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static final /* synthetic */ void access$clearSubscriptions(WidgetChatListAdapterItemCallMessage widgetChatListAdapterItemCallMessage) {
        widgetChatListAdapterItemCallMessage.clearSubscriptions();
    }

    public static final /* synthetic */ WidgetChatListAdapterItemCallBinding access$getBinding$p(WidgetChatListAdapterItemCallMessage widgetChatListAdapterItemCallMessage) {
        return widgetChatListAdapterItemCallMessage.binding;
    }

    public static final /* synthetic */ Clock access$getClock$p(WidgetChatListAdapterItemCallMessage widgetChatListAdapterItemCallMessage) {
        return widgetChatListAdapterItemCallMessage.clock;
    }

    public static final /* synthetic */ int access$getMinWidthPxForTime(WidgetChatListAdapterItemCallMessage widgetChatListAdapterItemCallMessage, String str) {
        return widgetChatListAdapterItemCallMessage.getMinWidthPxForTime(str);
    }

    public static final /* synthetic */ Subscription access$getOngoingCallDurationSubscription$p(WidgetChatListAdapterItemCallMessage widgetChatListAdapterItemCallMessage) {
        return widgetChatListAdapterItemCallMessage.ongoingCallDurationSubscription;
    }

    public static final /* synthetic */ Subscription access$getStateSubscription$p(WidgetChatListAdapterItemCallMessage widgetChatListAdapterItemCallMessage) {
        return widgetChatListAdapterItemCallMessage.stateSubscription;
    }

    public static final /* synthetic */ void access$handleState(WidgetChatListAdapterItemCallMessage widgetChatListAdapterItemCallMessage, WidgetChatListAdapterItemCallMessage$State widgetChatListAdapterItemCallMessage$State) {
        widgetChatListAdapterItemCallMessage.handleState(widgetChatListAdapterItemCallMessage$State);
    }

    public static final /* synthetic */ void access$onItemClick(WidgetChatListAdapterItemCallMessage widgetChatListAdapterItemCallMessage, WidgetChatListAdapterItemCallMessage$CallStatus widgetChatListAdapterItemCallMessage$CallStatus, long j) {
        widgetChatListAdapterItemCallMessage.onItemClick(widgetChatListAdapterItemCallMessage$CallStatus, j);
    }

    public static final /* synthetic */ void access$resetCurrentChatListEntry(WidgetChatListAdapterItemCallMessage widgetChatListAdapterItemCallMessage) {
        widgetChatListAdapterItemCallMessage.resetCurrentChatListEntry();
    }

    public static final /* synthetic */ void access$setOngoingCallDurationSubscription$p(WidgetChatListAdapterItemCallMessage widgetChatListAdapterItemCallMessage, Subscription subscription) {
        widgetChatListAdapterItemCallMessage.ongoingCallDurationSubscription = subscription;
    }

    public static final /* synthetic */ void access$setStateSubscription$p(WidgetChatListAdapterItemCallMessage widgetChatListAdapterItemCallMessage, Subscription subscription) {
        widgetChatListAdapterItemCallMessage.stateSubscription = subscription;
    }

    private final void clearSubscriptions() {
        Subscription subscription = this.ongoingCallDurationSubscription;
        if (subscription != null) {
            subscription.unsubscribe();
        }
        Subscription subscription2 = this.stateSubscription;
        if (subscription2 != null) {
            subscription2.unsubscribe();
        }
    }

    private final void configure(ChatListEntry data) {
        this.chatListEntry = data;
        Objects.requireNonNull(data, "null cannot be cast to non-null type com.discord.widgets.chat.list.entries.MessageEntry");
        clearSubscriptions();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui(ObservableExtensionsKt.computationLatest(observeState((MessageEntry) data))), WidgetChatListAdapterItemCallMessage.class, (Context) null, new WidgetChatListAdapterItemCallMessage$configure$1(this), (Function1) null, (Function0) null, (Function0) null, new WidgetChatListAdapterItemCallMessage$configure$2(this), 58, (Object) null);
    }

    private final void configureSubtitle(MessageEntry messageEntry, WidgetChatListAdapterItemCallMessage$CallStatus callStatus, Context context) {
        Subscription subscription = this.ongoingCallDurationSubscription;
        if (subscription != null) {
            subscription.unsubscribe();
        }
        Message message = messageEntry.getMessage();
        CharSequence charSequenceHumanizeDuration = DurationUtilsKt.humanizeDuration(context, message.getCallDuration());
        Context contextX = a.x(this.itemView, "itemView", "itemView.context");
        UtcDateTime timestamp = message.getTimestamp();
        String string = TimeUtils.toReadableTimeString$default(contextX, timestamp != null ? timestamp.getDateTimeMillis() : 0L, null, 4, null).toString();
        LinearLayout linearLayout = this.binding.f;
        m.checkNotNullExpressionValue(linearLayout, "binding.chatListAdapterI…llUnjoinedOngoingSubtitle");
        linearLayout.setVisibility(callStatus == WidgetChatListAdapterItemCallMessage$CallStatus.ACTIVE_UNJOINED ? 0 : 8);
        TextView textView = this.binding.d;
        m.checkNotNullExpressionValue(textView, "binding.chatListAdapterItemCallSubtitle");
        LinearLayout linearLayout2 = this.binding.f;
        m.checkNotNullExpressionValue(linearLayout2, "binding.chatListAdapterI…llUnjoinedOngoingSubtitle");
        textView.setVisibility((linearLayout2.getVisibility() == 0) ^ true ? 0 : 8);
        int iOrdinal = callStatus.ordinal();
        if (iOrdinal == 0 || iOrdinal == 1) {
            UtcDateTime timestamp2 = message.getTimestamp();
            long dateTimeMillis = timestamp2 != null ? timestamp2.getDateTimeMillis() : 0L;
            Observable<Long> observableE = Observable.E(0L, 1L, TimeUnit.SECONDS);
            m.checkNotNullExpressionValue(observableE, "Observable\n            .…0L, 1L, TimeUnit.SECONDS)");
            ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui(observableE), WidgetChatListAdapterItemCallMessage.class, (Context) null, new WidgetChatListAdapterItemCallMessage$configureSubtitle$2(this), (Function1) null, (Function0) null, (Function0) null, new WidgetChatListAdapterItemCallMessage$configureSubtitle$1(this, dateTimeMillis), 58, (Object) null);
            return;
        }
        if (iOrdinal == 2) {
            TextView textView2 = this.binding.d;
            m.checkNotNullExpressionValue(textView2, "binding.chatListAdapterItemCallSubtitle");
            b.n(textView2, 2131887363, new Object[]{charSequenceHumanizeDuration, string}, null, 4);
        } else {
            if (iOrdinal != 3) {
                return;
            }
            TextView textView3 = this.binding.d;
            m.checkNotNullExpressionValue(textView3, "binding.chatListAdapterItemCallSubtitle");
            b.n(textView3, 2131887363, new Object[]{charSequenceHumanizeDuration, string}, null, 4);
        }
    }

    private final List<CollapsedUser> createCallParticipantUsers(Map<Long, StoreVoiceParticipants$VoiceUser> voiceParticipants, WidgetChatListAdapterItemCallMessage$CallStatus callStatus, User messageAuthor) {
        if (callStatus == WidgetChatListAdapterItemCallMessage$CallStatus.INACTIVE_JOINED || callStatus == WidgetChatListAdapterItemCallMessage$CallStatus.INACTIVE_UNJOINED) {
            return d0.t.m.listOf(new CollapsedUser(messageAuthor, false, 0L, 6, null));
        }
        List list = u.toList(voiceParticipants.values());
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            if (((StoreVoiceParticipants$VoiceUser) next).getVoiceState() != null) {
                arrayList.add(next);
            }
        }
        int size = arrayList.size();
        ArrayList arrayList2 = new ArrayList();
        int i = size - 3;
        Iterator<Integer> it2 = f.until(0, Math.min(size, 3)).iterator();
        while (it2.hasNext()) {
            arrayList2.add(new CollapsedUser(((StoreVoiceParticipants$VoiceUser) arrayList.get(((c0) it2).nextInt())).getUser(), false, 0L, 6, null));
        }
        if (i > 0) {
            arrayList2.add(CollapsedUser.Companion.createEmptyUser(i));
        }
        return arrayList2;
    }

    private final Drawable getCallDrawable(WidgetChatListAdapterItemCallMessage$CallStatus callStatus, Context context) {
        Drawable drawable;
        int iOrdinal = callStatus.ordinal();
        if (iOrdinal == 0 || iOrdinal == 1) {
            drawable = AppCompatResources.getDrawable(context, 2131231589);
            if (drawable == null) {
                return null;
            }
            ColorCompatKt.setTint(drawable, ColorCompat.getColor(context, 2131100304), false);
        } else if (iOrdinal == 2) {
            drawable = AppCompatResources.getDrawable(context, 2131231590);
            if (drawable == null) {
                return null;
            }
            ColorCompatKt.setTint(drawable, ColorCompat.getColor(context, 2131100368), false);
        } else {
            if (iOrdinal != 3) {
                throw new NoWhenBranchMatchedException();
            }
            drawable = AppCompatResources.getDrawable(context, 2131231589);
            if (drawable == null) {
                return null;
            }
            ColorCompatKt.setTint(drawable, ColorCompat.getThemedColor(context, 2130969008), false);
        }
        return drawable;
    }

    private final WidgetChatListAdapterItemCallMessage$CallStatus getCallStatus(Message message, Map<Long, StoreVoiceParticipants$VoiceUser> voiceParticipants) {
        MessageCall call = message.getCall();
        if (call == null) {
            return WidgetChatListAdapterItemCallMessage$CallStatus.INACTIVE_UNJOINED;
        }
        long userId = ((WidgetChatListAdapter) this.adapter).getData().getUserId();
        List list = u.toList(voiceParticipants.entrySet());
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            if (((StoreVoiceParticipants$VoiceUser) ((Map$Entry) next).getValue()).getVoiceState() != null) {
                arrayList.add(next);
            }
        }
        ArrayList arrayList2 = new ArrayList(o.collectionSizeOrDefault(arrayList, 10));
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            arrayList2.add(Long.valueOf(((Number) ((Map$Entry) it2.next()).getKey()).longValue()));
        }
        boolean zContains = call.b().contains(Long.valueOf(userId));
        boolean zContains2 = arrayList2.contains(Long.valueOf(userId));
        boolean z2 = call.getEndedTimestamp() == null;
        if (z2 && zContains2) {
            return WidgetChatListAdapterItemCallMessage$CallStatus.ACTIVE_JOINED;
        }
        if (z2) {
            return WidgetChatListAdapterItemCallMessage$CallStatus.ACTIVE_UNJOINED;
        }
        return zContains ? WidgetChatListAdapterItemCallMessage$CallStatus.INACTIVE_JOINED : WidgetChatListAdapterItemCallMessage$CallStatus.INACTIVE_UNJOINED;
    }

    private final int getMinWidthPxForTime(String time) {
        int i = 0;
        for (int i2 = 0; i2 < time.length(); i2++) {
            if (time.charAt(i2) == ':') {
                i++;
            }
        }
        return (i * DimenUtils.dpToPixels(3.047619f)) + ((time.length() - i) * DimenUtils.dpToPixels(7.6190476f));
    }

    private final CharSequence getTitleString(WidgetChatListAdapterItemCallMessage$CallStatus callStatus, Resources resources) {
        int iOrdinal = callStatus.ordinal();
        if (iOrdinal == 0 || iOrdinal == 1) {
            return b.i(resources, 2131893512, new Object[0], null, 4);
        }
        if (iOrdinal == 2) {
            return b.i(resources, 2131893004, new Object[0], null, 4);
        }
        if (iOrdinal == 3) {
            return b.i(resources, 2131887362, new Object[0], null, 4);
        }
        throw new NoWhenBranchMatchedException();
    }

    private final void handleState(WidgetChatListAdapterItemCallMessage$State state) {
        MessageEntry messageEntry = state.getMessageEntry();
        Message message = messageEntry.getMessage();
        Map<Long, StoreVoiceParticipants$VoiceUser> voiceParticipants = state.getVoiceParticipants();
        WidgetChatListAdapterItemCallMessage$CallStatus callStatus = getCallStatus(message, voiceParticipants);
        com.discord.api.user.User author = message.getAuthor();
        m.checkNotNull(author);
        List<CollapsedUser> listCreateCallParticipantUsers = createCallParticipantUsers(voiceParticipants, callStatus, new CoreUser(author));
        configureSubtitle(messageEntry, callStatus, a.I(this.binding.d, "binding.chatListAdapterItemCallSubtitle", "binding.chatListAdapterItemCallSubtitle.context"));
        this.binding.f2314b.setImageDrawable(getCallDrawable(callStatus, a.x(this.itemView, "itemView", "itemView.context")));
        TextView textView = this.binding.e;
        m.checkNotNullExpressionValue(textView, "binding.chatListAdapterItemCallTitle");
        View view = this.itemView;
        m.checkNotNullExpressionValue(view, "itemView");
        Resources resources = view.getResources();
        m.checkNotNullExpressionValue(resources, "itemView.resources");
        textView.setText(getTitleString(callStatus, resources));
        this.itemView.setOnClickListener(new WidgetChatListAdapterItemCallMessage$handleState$1(this, callStatus, message));
        this.usersAdapter.setData(u.toList(listCreateCallParticipantUsers));
    }

    private final Observable<WidgetChatListAdapterItemCallMessage$State> observeState(MessageEntry messageEntry) {
        Observable observableG = StoreStream.Companion.getVoiceParticipants().get(messageEntry.getMessage().getChannelId()).G(new WidgetChatListAdapterItemCallMessage$observeState$1(messageEntry));
        m.checkNotNullExpressionValue(observableG, "StoreStream.getVoicePart…, messageEntry)\n        }");
        return observableG;
    }

    private final void onItemClick(WidgetChatListAdapterItemCallMessage$CallStatus callStatus, long channelId) {
        ((WidgetChatListAdapter) this.adapter).getEventHandler().onCallMessageClicked(channelId, callStatus);
    }

    private final void resetCurrentChatListEntry() {
        ChatListEntry chatListEntry = this.chatListEntry;
        if (chatListEntry != null) {
            configure(chatListEntry);
        }
    }

    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListItem, com.discord.utilities.mg_recycler.MGRecyclerViewHolder
    public /* bridge */ /* synthetic */ void onConfigure(int i, ChatListEntry chatListEntry) {
        onConfigure(i, chatListEntry);
    }

    @Override // com.discord.widgets.chat.list.FragmentLifecycleListener
    public void onPause() {
        clearSubscriptions();
    }

    @Override // com.discord.widgets.chat.list.FragmentLifecycleListener
    public void onResume() {
        resetCurrentChatListEntry();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListItem
    public void onConfigure(int position, ChatListEntry data) {
        m.checkNotNullParameter(data, "data");
        super.onConfigure(position, data);
        configure(data);
    }
}
