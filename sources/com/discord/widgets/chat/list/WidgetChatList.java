package com.discord.widgets.chat.list;

import android.content.Context;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView$Adapter$StateRestorationPolicy;
import androidx.recyclerview.widget.RecyclerView$ItemAnimator;
import b.a.d.f0;
import b.d.b.a.a;
import com.discord.R$layout;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetChatListBinding;
import com.discord.stores.StoreStream;
import com.discord.utilities.mg_recycler.MGRecyclerAdapter;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.time.ClockFactory;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.widgets.chat.input.AppFlexInputViewModel;
import com.discord.widgets.chat.list.adapter.WidgetChatListAdapter;
import com.discord.widgets.chat.list.adapter.WidgetChatListAdapterEventsHandler;
import com.discord.widgets.chat.list.model.WidgetChatListModel;
import d0.z.d.a0;
import d0.z.d.m;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;
import rx.functions.Action0;

/* JADX INFO: compiled from: WidgetChatList.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatList extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetChatList.class, "binding", "getBinding()Lcom/discord/databinding/WidgetChatListBinding;", 0)};
    private WidgetChatListAdapter adapter;

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private RecyclerView$ItemAnimator defaultItemAnimator;

    /* JADX INFO: renamed from: flexInputViewModel$delegate, reason: from kotlin metadata */
    private final Lazy flexInputViewModel;

    public WidgetChatList() {
        super(R$layout.widget_chat_list);
        this.binding = FragmentViewBindingDelegateKt.viewBinding(this, WidgetChatList$binding$2.INSTANCE, new WidgetChatList$binding$3(this));
        this.flexInputViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, a0.getOrCreateKotlinClass(AppFlexInputViewModel.class), new WidgetChatList$appActivityViewModels$$inlined$activityViewModels$1(this), new f0(new WidgetChatList$flexInputViewModel$2(this)));
    }

    public static final /* synthetic */ void access$configureUI(WidgetChatList widgetChatList, WidgetChatListModel widgetChatListModel) {
        widgetChatList.configureUI(widgetChatListModel);
    }

    public static final /* synthetic */ WidgetChatListAdapter access$getAdapter$p(WidgetChatList widgetChatList) {
        return widgetChatList.adapter;
    }

    public static final /* synthetic */ void access$scrollTo(WidgetChatList widgetChatList, long j) {
        widgetChatList.scrollTo(j);
    }

    public static final /* synthetic */ void access$setAdapter$p(WidgetChatList widgetChatList, WidgetChatListAdapter widgetChatListAdapter) {
        widgetChatList.adapter = widgetChatListAdapter;
    }

    private final void addThreadSpineItemDecoration(WidgetChatListAdapter adapter) {
        getBinding().f2343b.addItemDecoration(new ThreadSpineItemDecoration(requireContext(), adapter));
    }

    private final void configureExistingAdapter(WidgetChatListAdapter widgetChatListAdapter) {
        FragmentManager parentFragmentManager = getParentFragmentManager();
        m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        widgetChatListAdapter.setFragmentManager(parentFragmentManager);
        RecyclerView recyclerView = getBinding().f2343b;
        m.checkNotNullExpressionValue(recyclerView, "binding.chatListRecycler");
        widgetChatListAdapter.setRecycler(recyclerView);
        LinearLayoutManager layoutManager = ((WidgetChatListAdapter) MGRecyclerAdapter.Companion.configure(widgetChatListAdapter)).getLayoutManager();
        if (layoutManager != null) {
            layoutManager.setReverseLayout(true);
        }
    }

    private final void configureUI(WidgetChatListModel chatData) {
        RecyclerView recyclerView = getBinding().f2343b;
        m.checkNotNullExpressionValue(recyclerView, "binding.chatListRecycler");
        recyclerView.setVisibility(chatData != null ? 0 : 8);
        WidgetChatListAdapter widgetChatListAdapter = this.adapter;
        if (widgetChatListAdapter == null || chatData == null || widgetChatListAdapter == null) {
            return;
        }
        widgetChatListAdapter.setData(chatData);
    }

    private final void createAdapter() {
        RecyclerView recyclerView = getBinding().f2343b;
        m.checkNotNullExpressionValue(recyclerView, "binding.chatListRecycler");
        FragmentManager parentFragmentManager = getParentFragmentManager();
        m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        WidgetChatListAdapter widgetChatListAdapter = new WidgetChatListAdapter(recyclerView, this, parentFragmentManager, new WidgetChatListAdapterEventsHandler(this, getFlexInputViewModel(), null, null, null, null, null, null, null, null, null, null, 4092, null), getFlexInputViewModel(), ClockFactory.get());
        MGRecyclerAdapter.Companion.configure(widgetChatListAdapter);
        addThreadSpineItemDecoration(widgetChatListAdapter);
        LinearLayoutManager layoutManager = widgetChatListAdapter.getLayoutManager();
        if (layoutManager != null) {
            layoutManager.setReverseLayout(true);
        }
        widgetChatListAdapter.setStateRestorationPolicy(RecyclerView$Adapter$StateRestorationPolicy.PREVENT_WHEN_EMPTY);
        this.adapter = widgetChatListAdapter;
    }

    private final WidgetChatListBinding getBinding() {
        return (WidgetChatListBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final AppFlexInputViewModel getFlexInputViewModel() {
        return (AppFlexInputViewModel) this.flexInputViewModel.getValue();
    }

    private final void scrollTo(long messageId) {
        WidgetChatList$scrollTo$onCompleted$1 widgetChatList$scrollTo$onCompleted$1 = WidgetChatList$scrollTo$onCompleted$1.INSTANCE;
        WidgetChatListAdapter widgetChatListAdapter = this.adapter;
        Object widgetChatList$sam$rx_functions_Action0$0 = widgetChatList$scrollTo$onCompleted$1;
        if (widgetChatListAdapter == null) {
            widgetChatList$scrollTo$onCompleted$1.invoke();
        } else if (widgetChatListAdapter != null) {
            if (widgetChatList$scrollTo$onCompleted$1 != null) {
                widgetChatList$sam$rx_functions_Action0$0 = new WidgetChatList$sam$rx_functions_Action0$0(widgetChatList$scrollTo$onCompleted$1);
            }
            widgetChatListAdapter.scrollToMessageId(messageId, (Action0) widgetChatList$sam$rx_functions_Action0$0);
        }
    }

    public final void disableItemAnimations() {
        RecyclerView recyclerView = getBinding().f2343b;
        m.checkNotNullExpressionValue(recyclerView, "binding.chatListRecycler");
        recyclerView.setItemAnimator(null);
    }

    public final void enableItemAnimations() {
        RecyclerView recyclerView = getBinding().f2343b;
        m.checkNotNullExpressionValue(recyclerView, "binding.chatListRecycler");
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
        m.checkNotNullParameter(view, "view");
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
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui(ObservableExtensionsKt.computationLatest(WidgetChatListModel.Companion.get()), this, this.adapter), WidgetChatList.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetChatList$onViewBoundOrOnResume$1(this), 62, (Object) null);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(StoreStream.Companion.getMessagesLoader().getScrollTo(), this, null, 2, null), WidgetChatList.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetChatList$onViewBoundOrOnResume$2(this), 62, (Object) null);
        RecyclerView recyclerView = getBinding().f2343b;
        m.checkNotNullExpressionValue(recyclerView, "binding.chatListRecycler");
        this.defaultItemAnimator = recyclerView.getItemAnimator();
    }
}
