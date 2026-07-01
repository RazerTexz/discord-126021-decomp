package com.discord.widgets.channels.threads.browser;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import b.a.k.FormatUtils;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.api.channel.Channel;
import com.discord.databinding.ThreadBrowserItemHeaderBinding;
import com.discord.databinding.ThreadBrowserItemThreadBinding;
import com.discord.databinding.ThreadBrowserItemWarningBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.analytics.Traits;
import com.discord.utilities.mg_recycler.MGRecyclerAdapterSimple;
import com.discord.utilities.mg_recycler.MGRecyclerDataPayload;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import com.discord.widgets.channels.threads.browser.ThreadBrowserThreadView;
import com.discord.widgets.channels.threads.browser.WidgetThreadBrowserAdapter;
import d0.z.d.Intrinsics3;
import java.util.Objects;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetThreadBrowserAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetThreadBrowserAdapter extends MGRecyclerAdapterSimple<Item> {
    private final Function1<Channel, Unit> onOpenThread;
    private final Function1<Channel, Unit> onThreadSettings;

    /* JADX INFO: compiled from: WidgetThreadBrowserAdapter.kt */
    public static final class HeaderItem extends MGRecyclerViewHolder<WidgetThreadBrowserAdapter, Item> {
        private final ThreadBrowserItemHeaderBinding binding;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public HeaderItem(WidgetThreadBrowserAdapter widgetThreadBrowserAdapter) {
            super(R.layout.thread_browser_item_header, widgetThreadBrowserAdapter);
            Intrinsics3.checkNotNullParameter(widgetThreadBrowserAdapter, "adapter");
            View view = this.itemView;
            TextView textView = (TextView) view.findViewById(R.id.header_name);
            if (textView == null) {
                throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.header_name)));
            }
            ThreadBrowserItemHeaderBinding threadBrowserItemHeaderBinding = new ThreadBrowserItemHeaderBinding((ConstraintLayout) view, textView);
            Intrinsics3.checkNotNullExpressionValue(threadBrowserItemHeaderBinding, "ThreadBrowserItemHeaderBinding.bind(itemView)");
            this.binding = threadBrowserItemHeaderBinding;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
        public void onConfigure(int position, Item data) {
            Intrinsics3.checkNotNullParameter(data, "data");
            super.onConfigure(position, data);
            Item.Header header = (Item.Header) data;
            TextView textView = this.binding.f2158b;
            Intrinsics3.checkNotNullExpressionValue(textView, "binding.headerName");
            textView.setText(FormatUtils.b(((WidgetThreadBrowserAdapter) this.adapter).getContext(), header.getStringResId(), new Object[]{Integer.valueOf(header.getCount())}, (4 & 4) != 0 ? FormatUtils.b.j : null).toString());
        }
    }

    /* JADX INFO: compiled from: WidgetThreadBrowserAdapter.kt */
    public static abstract class Item implements MGRecyclerDataPayload {

        /* JADX INFO: compiled from: WidgetThreadBrowserAdapter.kt */
        public static final /* data */ class Header extends Item {
            private final int count;
            private final String key;
            private final int stringResId;
            private final int type;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Header(String str, int i, int i2) {
                super(null);
                Intrinsics3.checkNotNullParameter(str, "key");
                this.key = str;
                this.stringResId = i;
                this.count = i2;
                this.type = ItemType.HEADER.ordinal();
            }

            public static /* synthetic */ Header copy$default(Header header, String str, int i, int i2, int i3, Object obj) {
                if ((i3 & 1) != 0) {
                    str = header.getKey();
                }
                if ((i3 & 2) != 0) {
                    i = header.stringResId;
                }
                if ((i3 & 4) != 0) {
                    i2 = header.count;
                }
                return header.copy(str, i, i2);
            }

            public final String component1() {
                return getKey();
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final int getStringResId() {
                return this.stringResId;
            }

            /* JADX INFO: renamed from: component3, reason: from getter */
            public final int getCount() {
                return this.count;
            }

            public final Header copy(String key, int stringResId, int count) {
                Intrinsics3.checkNotNullParameter(key, "key");
                return new Header(key, stringResId, count);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Header)) {
                    return false;
                }
                Header header = (Header) other;
                return Intrinsics3.areEqual(getKey(), header.getKey()) && this.stringResId == header.stringResId && this.count == header.count;
            }

            public final int getCount() {
                return this.count;
            }

            @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
            public String getKey() {
                return this.key;
            }

            public final int getStringResId() {
                return this.stringResId;
            }

            @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
            public int getType() {
                return this.type;
            }

            public int hashCode() {
                String key = getKey();
                return ((((key != null ? key.hashCode() : 0) * 31) + this.stringResId) * 31) + this.count;
            }

            public String toString() {
                StringBuilder sbU = outline.U("Header(key=");
                sbU.append(getKey());
                sbU.append(", stringResId=");
                sbU.append(this.stringResId);
                sbU.append(", count=");
                return outline.B(sbU, this.count, ")");
            }
        }

        /* JADX INFO: compiled from: WidgetThreadBrowserAdapter.kt */
        public static final /* data */ class Loading extends Item {
            private final String key;
            private final int type;

            /* JADX WARN: Multi-variable type inference failed */
            public Loading() {
                this(null, 1, 0 == true ? 1 : 0);
            }

            public /* synthetic */ Loading(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this((i & 1) != 0 ? "loading" : str);
            }

            public static /* synthetic */ Loading copy$default(Loading loading, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = loading.getKey();
                }
                return loading.copy(str);
            }

            public final String component1() {
                return getKey();
            }

            public final Loading copy(String key) {
                Intrinsics3.checkNotNullParameter(key, "key");
                return new Loading(key);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof Loading) && Intrinsics3.areEqual(getKey(), ((Loading) other).getKey());
                }
                return true;
            }

            @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
            public String getKey() {
                return this.key;
            }

            @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
            public int getType() {
                return this.type;
            }

            public int hashCode() {
                String key = getKey();
                if (key != null) {
                    return key.hashCode();
                }
                return 0;
            }

            public String toString() {
                StringBuilder sbU = outline.U("Loading(key=");
                sbU.append(getKey());
                sbU.append(")");
                return sbU.toString();
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Loading(String str) {
                super(null);
                Intrinsics3.checkNotNullParameter(str, "key");
                this.key = str;
                this.type = ItemType.LOADING.ordinal();
            }
        }

        /* JADX INFO: compiled from: WidgetThreadBrowserAdapter.kt */
        public static final /* data */ class Thread extends Item {
            private final String key;
            private final ThreadBrowserThreadView.ThreadData threadData;
            private final int type;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Thread(ThreadBrowserThreadView.ThreadData threadData) {
                super(null);
                Intrinsics3.checkNotNullParameter(threadData, "threadData");
                this.threadData = threadData;
                this.type = ItemType.THREAD.ordinal();
                this.key = String.valueOf(threadData.getChannel().getId());
            }

            public static /* synthetic */ Thread copy$default(Thread thread, ThreadBrowserThreadView.ThreadData threadData, int i, Object obj) {
                if ((i & 1) != 0) {
                    threadData = thread.threadData;
                }
                return thread.copy(threadData);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final ThreadBrowserThreadView.ThreadData getThreadData() {
                return this.threadData;
            }

            public final Thread copy(ThreadBrowserThreadView.ThreadData threadData) {
                Intrinsics3.checkNotNullParameter(threadData, "threadData");
                return new Thread(threadData);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof Thread) && Intrinsics3.areEqual(this.threadData, ((Thread) other).threadData);
                }
                return true;
            }

            @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
            public String getKey() {
                return this.key;
            }

            public final ThreadBrowserThreadView.ThreadData getThreadData() {
                return this.threadData;
            }

            @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
            public int getType() {
                return this.type;
            }

            public int hashCode() {
                ThreadBrowserThreadView.ThreadData threadData = this.threadData;
                if (threadData != null) {
                    return threadData.hashCode();
                }
                return 0;
            }

            public String toString() {
                StringBuilder sbU = outline.U("Thread(threadData=");
                sbU.append(this.threadData);
                sbU.append(")");
                return sbU.toString();
            }
        }

        /* JADX INFO: compiled from: WidgetThreadBrowserAdapter.kt */
        public static final /* data */ class Warning extends Item {
            private final String key;
            private final int type;

            /* JADX WARN: Multi-variable type inference failed */
            public Warning() {
                this(null, 1, 0 == true ? 1 : 0);
            }

            public /* synthetic */ Warning(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this((i & 1) != 0 ? "warning" : str);
            }

            public static /* synthetic */ Warning copy$default(Warning warning, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = warning.getKey();
                }
                return warning.copy(str);
            }

            public final String component1() {
                return getKey();
            }

            public final Warning copy(String key) {
                Intrinsics3.checkNotNullParameter(key, "key");
                return new Warning(key);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof Warning) && Intrinsics3.areEqual(getKey(), ((Warning) other).getKey());
                }
                return true;
            }

            @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
            public String getKey() {
                return this.key;
            }

            @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
            public int getType() {
                return this.type;
            }

            public int hashCode() {
                String key = getKey();
                if (key != null) {
                    return key.hashCode();
                }
                return 0;
            }

            public String toString() {
                StringBuilder sbU = outline.U("Warning(key=");
                sbU.append(getKey());
                sbU.append(")");
                return sbU.toString();
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Warning(String str) {
                super(null);
                Intrinsics3.checkNotNullParameter(str, "key");
                this.key = str;
                this.type = ItemType.WARNING.ordinal();
            }
        }

        private Item() {
        }

        public /* synthetic */ Item(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: WidgetThreadBrowserAdapter.kt */
    public enum ItemType {
        WARNING,
        THREAD,
        HEADER,
        LOADING;


        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private static final ItemType[] cachedValues = values();

        /* JADX INFO: compiled from: WidgetThreadBrowserAdapter.kt */
        public static final class Companion {
            private Companion() {
            }

            public final ItemType fromOrdinal(int ordinal) {
                return ItemType.cachedValues[ordinal];
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }
    }

    /* JADX INFO: compiled from: WidgetThreadBrowserAdapter.kt */
    public static final class LoadingItem extends MGRecyclerViewHolder<WidgetThreadBrowserAdapter, Item> {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public LoadingItem(WidgetThreadBrowserAdapter widgetThreadBrowserAdapter) {
            super(R.layout.thread_browser_item_loading, widgetThreadBrowserAdapter);
            Intrinsics3.checkNotNullParameter(widgetThreadBrowserAdapter, "adapter");
        }
    }

    /* JADX INFO: compiled from: WidgetThreadBrowserAdapter.kt */
    public static final class ThreadItem extends MGRecyclerViewHolder<WidgetThreadBrowserAdapter, Item> {
        private final ThreadBrowserItemThreadBinding binding;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ThreadItem(WidgetThreadBrowserAdapter widgetThreadBrowserAdapter) {
            super(R.layout.thread_browser_item_thread, widgetThreadBrowserAdapter);
            Intrinsics3.checkNotNullParameter(widgetThreadBrowserAdapter, "adapter");
            View view = this.itemView;
            Objects.requireNonNull(view, "rootView");
            ThreadBrowserThreadView threadBrowserThreadView = (ThreadBrowserThreadView) view;
            ThreadBrowserItemThreadBinding threadBrowserItemThreadBinding = new ThreadBrowserItemThreadBinding(threadBrowserThreadView, threadBrowserThreadView);
            Intrinsics3.checkNotNullExpressionValue(threadBrowserItemThreadBinding, "ThreadBrowserItemThreadBinding.bind(itemView)");
            this.binding = threadBrowserItemThreadBinding;
        }

        public static final /* synthetic */ WidgetThreadBrowserAdapter access$getAdapter$p(ThreadItem threadItem) {
            return (WidgetThreadBrowserAdapter) threadItem.adapter;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
        public void onConfigure(int position, Item data) {
            Intrinsics3.checkNotNullParameter(data, "data");
            super.onConfigure(position, data);
            final Item.Thread thread = (Item.Thread) data;
            this.binding.f2159b.setThreadData(thread.getThreadData());
            this.binding.f2159b.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.channels.threads.browser.WidgetThreadBrowserAdapter$ThreadItem$onConfigure$1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    WidgetThreadBrowserAdapter.ThreadItem.access$getAdapter$p(this.this$0).onThreadClicked(thread.getThreadData().getChannel());
                }
            });
            this.binding.f2159b.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.discord.widgets.channels.threads.browser.WidgetThreadBrowserAdapter$ThreadItem$onConfigure$2
                @Override // android.view.View.OnLongClickListener
                public final boolean onLongClick(View view) {
                    WidgetThreadBrowserAdapter.ThreadItem.access$getAdapter$p(this.this$0).onThreadLongClicked(thread.getThreadData().getChannel());
                    return true;
                }
            });
        }
    }

    /* JADX INFO: compiled from: WidgetThreadBrowserAdapter.kt */
    public static final class WarningItem extends MGRecyclerViewHolder<WidgetThreadBrowserAdapter, Item> {
        private final ThreadBrowserItemWarningBinding binding;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public WarningItem(WidgetThreadBrowserAdapter widgetThreadBrowserAdapter) {
            super(R.layout.thread_browser_item_warning, widgetThreadBrowserAdapter);
            Intrinsics3.checkNotNullParameter(widgetThreadBrowserAdapter, "adapter");
            View view = this.itemView;
            TextView textView = (TextView) view.findViewById(R.id.warning);
            if (textView == null) {
                throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.warning)));
            }
            ThreadBrowserItemWarningBinding threadBrowserItemWarningBinding = new ThreadBrowserItemWarningBinding((ConstraintLayout) view, textView);
            Intrinsics3.checkNotNullExpressionValue(threadBrowserItemWarningBinding, "ThreadBrowserItemWarningBinding.bind(itemView)");
            this.binding = threadBrowserItemWarningBinding;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
        public void onConfigure(int position, Item data) {
            Intrinsics3.checkNotNullParameter(data, "data");
            super.onConfigure(position, data);
            TextView textView = this.binding.f2160b;
            Intrinsics3.checkNotNullExpressionValue(textView, "binding.warning");
            textView.setText(FormatUtils.b(((WidgetThreadBrowserAdapter) this.adapter).getContext(), R.string.forum_android_warning, new Object[0], (4 & 4) != 0 ? FormatUtils.b.j : null).toString());
        }
    }

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            ItemType.values();
            int[] iArr = new int[4];
            $EnumSwitchMapping$0 = iArr;
            iArr[ItemType.WARNING.ordinal()] = 1;
            iArr[ItemType.THREAD.ordinal()] = 2;
            iArr[ItemType.HEADER.ordinal()] = 3;
            iArr[ItemType.LOADING.ordinal()] = 4;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public WidgetThreadBrowserAdapter(RecyclerView recyclerView, Function1<? super Channel, Unit> function1, Function1<? super Channel, Unit> function2) {
        super(recyclerView, false, 2, null);
        Intrinsics3.checkNotNullParameter(recyclerView, "recycler");
        Intrinsics3.checkNotNullParameter(function1, "onOpenThread");
        Intrinsics3.checkNotNullParameter(function2, "onThreadSettings");
        this.onOpenThread = function1;
        this.onThreadSettings = function2;
    }

    public final void onThreadClicked(Channel channel) {
        Intrinsics3.checkNotNullParameter(channel, "channel");
        this.onOpenThread.invoke(channel);
    }

    public final void onThreadLongClicked(Channel channel) {
        Intrinsics3.checkNotNullParameter(channel, "channel");
        this.onThreadSettings.invoke(channel);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public MGRecyclerViewHolder<?, Item> onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics3.checkNotNullParameter(parent, "parent");
        int iOrdinal = ItemType.INSTANCE.fromOrdinal(viewType).ordinal();
        if (iOrdinal == 0) {
            return new WarningItem(this);
        }
        if (iOrdinal == 1) {
            return new ThreadItem(this);
        }
        if (iOrdinal == 2) {
            return new HeaderItem(this);
        }
        if (iOrdinal == 3) {
            return new LoadingItem(this);
        }
        throw new NoWhenBranchMatchedException();
    }
}
