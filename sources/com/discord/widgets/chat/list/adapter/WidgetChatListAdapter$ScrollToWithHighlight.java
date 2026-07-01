package com.discord.widgets.chat.list.adapter;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import b.i.a.f.e.o.f;
import com.discord.utilities.views.ViewCoroutineScopeKt;
import com.discord.widgets.chat.list.entries.ChatListEntry;
import com.discord.widgets.chat.list.entries.MessageEntry;
import com.discord.widgets.chat.list.entries.NewMessagesEntry;
import com.discord.widgets.chat.list.model.WidgetChatListModel;
import d0.t.n;
import d0.z.d.m;
import java.util.List;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: WidgetChatListAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatListAdapter$ScrollToWithHighlight implements Runnable {
    private final WidgetChatListAdapter adapter;
    private int attempts;
    private final long messageId;
    private final Function0<Unit> onCompleted;

    public WidgetChatListAdapter$ScrollToWithHighlight(WidgetChatListAdapter widgetChatListAdapter, long j, Function0<Unit> function0) {
        m.checkNotNullParameter(widgetChatListAdapter, "adapter");
        m.checkNotNullParameter(function0, "onCompleted");
        this.adapter = widgetChatListAdapter;
        this.messageId = j;
        this.onCompleted = function0;
        widgetChatListAdapter.getRecycler().post(this);
    }

    private final void animateHighlight(View view) {
        view.setBackgroundResource(2131231111);
        Drawable background = view.getBackground();
        Objects.requireNonNull(background, "null cannot be cast to non-null type android.graphics.drawable.TransitionDrawable");
        TransitionDrawable transitionDrawable = (TransitionDrawable) background;
        transitionDrawable.startTransition(500);
        CoroutineScope coroutineScope = ViewCoroutineScopeKt.getCoroutineScope(view);
        if (coroutineScope != null) {
            f.H0(coroutineScope, null, null, new WidgetChatListAdapter$ScrollToWithHighlight$animateHighlight$1(transitionDrawable, null), 3, null);
        }
    }

    private final int getNewMessageEntryIndex(List<? extends ChatListEntry> list) {
        long jLongValue = this.messageId;
        boolean z2 = jLongValue == 0;
        if (jLongValue == 1) {
            return 0;
        }
        Integer num = null;
        if (jLongValue == 0) {
            Long lValueOf = Long.valueOf(this.adapter.getData().getNewMessagesMarkerMessageId());
            if (!(lValueOf.longValue() > 0)) {
                lValueOf = null;
            }
            if (lValueOf == null) {
                return 0;
            }
            jLongValue = lValueOf.longValue();
        }
        int iAccess$findBestNewMessagesPosition = -1;
        if (jLongValue <= 0) {
            return -1;
        }
        int i = 0;
        for (ChatListEntry chatListEntry : list) {
            if ((chatListEntry instanceof MessageEntry) && ((MessageEntry) chatListEntry).getMessage().getId() <= jLongValue) {
                iAccess$findBestNewMessagesPosition = i;
                break;
            }
            i++;
        }
        if (iAccess$findBestNewMessagesPosition < 0 && z2) {
            iAccess$findBestNewMessagesPosition = WidgetChatListAdapter$Companion.access$findBestNewMessagesPosition(WidgetChatListAdapter.Companion, n.getLastIndex(list));
        }
        for (Integer num2 : d0.d0.f.downTo(iAccess$findBestNewMessagesPosition, 0)) {
            ChatListEntry chatListEntry2 = list.get(num2.intValue());
            if ((chatListEntry2 instanceof NewMessagesEntry) && ((NewMessagesEntry) chatListEntry2).getMessageId() == jLongValue) {
                num = num2;
                break;
            }
        }
        Integer num3 = num;
        return num3 != null ? num3.intValue() : iAccess$findBestNewMessagesPosition;
    }

    private final void scheduleRetry() {
        int i = this.attempts;
        if (i >= 20) {
            this.onCompleted.invoke();
            return;
        }
        this.attempts = i + 1;
        CoroutineScope coroutineScope = ViewCoroutineScopeKt.getCoroutineScope(this.adapter.getRecycler());
        if (coroutineScope != null) {
            f.H0(coroutineScope, null, null, new WidgetChatListAdapter$ScrollToWithHighlight$scheduleRetry$1(this, null), 3, null);
        }
    }

    public final void cancel() {
        this.adapter.getRecycler().removeCallbacks(this);
    }

    public final WidgetChatListAdapter getAdapter() {
        return this.adapter;
    }

    public final long getMessageId() {
        return this.messageId;
    }

    public final Function0<Unit> getOnCompleted() {
        return this.onCompleted;
    }

    @Override // java.lang.Runnable
    public void run() {
        WidgetChatListAdapter$Data data = this.adapter.getData();
        View viewFindViewByPosition = null;
        if (!(data instanceof WidgetChatListModel)) {
            data = null;
        }
        WidgetChatListModel widgetChatListModel = (WidgetChatListModel) data;
        if (widgetChatListModel != null && widgetChatListModel.isLoadingMessages()) {
            scheduleRetry();
            return;
        }
        int newMessageEntryIndex = getNewMessageEntryIndex(this.adapter.getData().getList());
        if (newMessageEntryIndex < 0) {
            scheduleRetry();
            return;
        }
        int height = (int) (this.adapter.getRecycler().getHeight() / 2.0f);
        LinearLayoutManager layoutManager = this.adapter.getLayoutManager();
        if (layoutManager != null) {
            layoutManager.scrollToPositionWithOffset(newMessageEntryIndex, height);
            viewFindViewByPosition = layoutManager.findViewByPosition(newMessageEntryIndex);
        }
        if (viewFindViewByPosition == null) {
            scheduleRetry();
            return;
        }
        if (!(newMessageEntryIndex < this.adapter.getData().getList().size() && (this.adapter.getData().getList().get(newMessageEntryIndex) instanceof NewMessagesEntry))) {
            animateHighlight(viewFindViewByPosition);
        }
        this.onCompleted.invoke();
    }
}
