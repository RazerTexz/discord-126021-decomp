package com.discord.widgets.chat.list;

import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.C5419R;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetChatListBinding;
import com.discord.stores.StoreStream;
import com.discord.utilities.error.Error;
import com.discord.utilities.mg_recycler.MGRecyclerAdapter;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.time.ClockFactory;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.widgets.chat.input.AppFlexInputViewModel;
import com.discord.widgets.chat.list.adapter.WidgetChatListAdapter;
import com.discord.widgets.chat.list.adapter.WidgetChatListAdapterEventsHandler;
import com.discord.widgets.chat.list.model.WidgetChatListModel;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;
import p007b.p008a.p018d.C0863f0;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12216a0;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;
import p658rx.Subscription;
import p658rx.functions.Action0;

/* JADX INFO: compiled from: WidgetChatList.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatList extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {C1643a.m846d0(WidgetChatList.class, "binding", "getBinding()Lcom/discord/databinding/WidgetChatListBinding;", 0)};
    private WidgetChatListAdapter adapter;

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private RecyclerView.ItemAnimator defaultItemAnimator;

    /* JADX INFO: renamed from: flexInputViewModel$delegate, reason: from kotlin metadata */
    private final Lazy flexInputViewModel;

    /* JADX INFO: renamed from: com.discord.widgets.chat.list.WidgetChatList$onViewBoundOrOnResume$1 */
    /* JADX INFO: compiled from: WidgetChatList.kt */
    public static final /* synthetic */ class C79551 extends C12236k implements Function1<WidgetChatListModel, Unit> {
        public C79551(WidgetChatList widgetChatList) {
            super(1, widgetChatList, WidgetChatList.class, "configureUI", "configureUI(Lcom/discord/widgets/chat/list/model/WidgetChatListModel;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetChatListModel widgetChatListModel) {
            invoke2(widgetChatListModel);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetChatListModel widgetChatListModel) {
            ((WidgetChatList) this.receiver).configureUI(widgetChatListModel);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.chat.list.WidgetChatList$onViewBoundOrOnResume$2 */
    /* JADX INFO: compiled from: WidgetChatList.kt */
    public static final /* synthetic */ class C79562 extends C12236k implements Function1<Long, Unit> {
        public C79562(WidgetChatList widgetChatList) {
            super(1, widgetChatList, WidgetChatList.class, "scrollTo", "scrollTo(J)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Long l) {
            invoke(l.longValue());
            return Unit.f27425a;
        }

        public final void invoke(long j) {
            ((WidgetChatList) this.receiver).scrollTo(j);
        }
    }

    public WidgetChatList() {
        super(C5419R.layout.widget_chat_list);
        this.binding = FragmentViewBindingDelegateKt.viewBinding(this, WidgetChatList$binding$2.INSTANCE, new WidgetChatList$binding$3(this));
        this.flexInputViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, C12216a0.getOrCreateKotlinClass(AppFlexInputViewModel.class), new C7953x8161d219(this), new C0863f0(new WidgetChatList$flexInputViewModel$2(this)));
    }

    private final void addThreadSpineItemDecoration(WidgetChatListAdapter adapter) {
        getBinding().f16355b.addItemDecoration(new ThreadSpineItemDecoration(requireContext(), adapter));
    }

    private final void configureExistingAdapter(WidgetChatListAdapter widgetChatListAdapter) {
        FragmentManager parentFragmentManager = getParentFragmentManager();
        C12238m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        widgetChatListAdapter.setFragmentManager(parentFragmentManager);
        RecyclerView recyclerView = getBinding().f16355b;
        C12238m.checkNotNullExpressionValue(recyclerView, "binding.chatListRecycler");
        widgetChatListAdapter.setRecycler(recyclerView);
        LinearLayoutManager layoutManager = ((WidgetChatListAdapter) MGRecyclerAdapter.INSTANCE.configure(widgetChatListAdapter)).getLayoutManager();
        if (layoutManager != null) {
            layoutManager.setReverseLayout(true);
        }
    }

    private final void configureUI(WidgetChatListModel chatData) {
        RecyclerView recyclerView = getBinding().f16355b;
        C12238m.checkNotNullExpressionValue(recyclerView, "binding.chatListRecycler");
        recyclerView.setVisibility(chatData != null ? 0 : 8);
        WidgetChatListAdapter widgetChatListAdapter = this.adapter;
        if (widgetChatListAdapter == null || chatData == null || widgetChatListAdapter == null) {
            return;
        }
        widgetChatListAdapter.setData(chatData);
    }

    private final void createAdapter() {
        RecyclerView recyclerView = getBinding().f16355b;
        C12238m.checkNotNullExpressionValue(recyclerView, "binding.chatListRecycler");
        FragmentManager parentFragmentManager = getParentFragmentManager();
        C12238m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        WidgetChatListAdapter widgetChatListAdapter = new WidgetChatListAdapter(recyclerView, this, parentFragmentManager, new WidgetChatListAdapterEventsHandler(this, getFlexInputViewModel(), null, null, null, null, null, null, null, null, null, null, 4092, null), getFlexInputViewModel(), ClockFactory.get());
        MGRecyclerAdapter.INSTANCE.configure(widgetChatListAdapter);
        addThreadSpineItemDecoration(widgetChatListAdapter);
        LinearLayoutManager layoutManager = widgetChatListAdapter.getLayoutManager();
        if (layoutManager != null) {
            layoutManager.setReverseLayout(true);
        }
        widgetChatListAdapter.setStateRestorationPolicy(RecyclerView.Adapter.StateRestorationPolicy.PREVENT_WHEN_EMPTY);
        this.adapter = widgetChatListAdapter;
    }

    private final WidgetChatListBinding getBinding() {
        return (WidgetChatListBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final AppFlexInputViewModel getFlexInputViewModel() {
        return (AppFlexInputViewModel) this.flexInputViewModel.getValue();
    }

    private final void scrollTo(long messageId) {
        final WidgetChatList$scrollTo$onCompleted$1 widgetChatList$scrollTo$onCompleted$1 = WidgetChatList$scrollTo$onCompleted$1.INSTANCE;
        WidgetChatListAdapter widgetChatListAdapter = this.adapter;
        Object obj = widgetChatList$scrollTo$onCompleted$1;
        if (widgetChatListAdapter == null) {
            widgetChatList$scrollTo$onCompleted$1.invoke();
        } else if (widgetChatListAdapter != null) {
            if (widgetChatList$scrollTo$onCompleted$1 != null) {
                obj = new Action0() { // from class: com.discord.widgets.chat.list.WidgetChatList$sam$rx_functions_Action0$0
                    @Override // p658rx.functions.Action0
                    public final /* synthetic */ void call() {
                        C12238m.checkNotNullExpressionValue(widgetChatList$scrollTo$onCompleted$1.invoke(), "invoke(...)");
                    }
                };
            }
            widgetChatListAdapter.scrollToMessageId(messageId, (Action0) obj);
        }
    }

    public final void disableItemAnimations() {
        RecyclerView recyclerView = getBinding().f16355b;
        C12238m.checkNotNullExpressionValue(recyclerView, "binding.chatListRecycler");
        recyclerView.setItemAnimator(null);
    }

    public final void enableItemAnimations() {
        RecyclerView recyclerView = getBinding().f16355b;
        C12238m.checkNotNullExpressionValue(recyclerView, "binding.chatListRecycler");
        recyclerView.setItemAnimator(this.defaultItemAnimator);
    }

    @Override // com.discord.app.AppFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        WidgetChatListAdapter widgetChatListAdapter = this.adapter;
        if (widgetChatListAdapter != null) {
            widgetChatListAdapter.onPause();
        }
        WidgetChatListAdapter widgetChatListAdapter2 = this.adapter;
        if (widgetChatListAdapter2 != null) {
            widgetChatListAdapter2.disposeHandlers();
        }
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        C12238m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        setRetainInstance(true);
        WidgetChatListAdapter widgetChatListAdapter = this.adapter;
        if (widgetChatListAdapter != null) {
            configureExistingAdapter(widgetChatListAdapter);
        } else {
            createAdapter();
        }
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        WidgetChatListAdapter widgetChatListAdapter = this.adapter;
        if (widgetChatListAdapter != null) {
            widgetChatListAdapter.setHandlers();
        }
        WidgetChatListAdapter widgetChatListAdapter2 = this.adapter;
        if (widgetChatListAdapter2 != null) {
            widgetChatListAdapter2.onResume();
        }
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.m8519ui(ObservableExtensionsKt.computationLatest(WidgetChatListModel.INSTANCE.get()), this, this.adapter), (Class<?>) WidgetChatList.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C79551(this));
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(StoreStream.INSTANCE.getMessagesLoader().getScrollTo(), this, null, 2, null), (Class<?>) WidgetChatList.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C79562(this));
        RecyclerView recyclerView = getBinding().f16355b;
        C12238m.checkNotNullExpressionValue(recyclerView, "binding.chatListRecycler");
        this.defaultItemAnimator = recyclerView.getItemAnimator();
    }
}
