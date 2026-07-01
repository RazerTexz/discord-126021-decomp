package com.discord.widgets.guilds.invite;

import android.text.Editable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.recyclerview.widget.RecyclerView;
import b.a.d.AppScreen2;
import b.a.d.AppViewModelDelegates3;
import b.a.d.AppViewModelDelegates5;
import b.d.b.a.outline;
import com.discord.BuildConfig;
import com.discord.R;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.guild.Guild;
import com.discord.app.AppFragment;
import com.discord.app.AppViewFlipper;
import com.discord.databinding.WidgetGuildInviteShareCompactBinding;
import com.discord.databinding.WidgetGuildInviteShareItemBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.domain.ModelInvite;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.drawable.DrawableCompat;
import com.discord.utilities.error.Error;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.images.MGImages;
import com.discord.utilities.mg_recycler.MGRecyclerAdapter;
import com.discord.utilities.mg_recycler.MGRecyclerAdapterSimple;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.widgets.guilds.invite.InviteSuggestionItem;
import com.discord.widgets.guilds.invite.WidgetGuildInviteShareCompact;
import com.discord.widgets.guilds.invite.WidgetGuildInviteShareViewModel;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputLayout;
import d0.t.Collections2;
import d0.t.Iterables2;
import d0.t._Collections;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import d0.z.d.Reflection2;
import j0.k.Func1;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;
import rx.Observable;
import rx.Subscription;
import rx.functions.Func0;

/* JADX INFO: compiled from: WidgetGuildInviteShareCompact.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildInviteShareCompact extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetGuildInviteShareCompact.class, "binding", "getBinding()Lcom/discord/databinding/WidgetGuildInviteShareCompactBinding;", 0)};
    private PrivateChannelAdapter adapter;

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private BottomSheetBehavior<ViewInviteSettingsSheet> bottomSheetBehavior;
    private boolean hasTrackedSuggestionsViewed;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* JADX INFO: compiled from: WidgetGuildInviteShareCompact.kt */
    public static final class PrivateChannelAdapter extends MGRecyclerAdapterSimple<InviteSuggestionItem> {
        private Function1<? super InviteSuggestionItem, Unit> onClick;

        /* JADX INFO: compiled from: WidgetGuildInviteShareCompact.kt */
        public static final class Item extends MGRecyclerViewHolder<PrivateChannelAdapter, InviteSuggestionItem> {
            private final WidgetGuildInviteShareItemBinding binding;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Item(PrivateChannelAdapter privateChannelAdapter) {
                super(R.layout.widget_guild_invite_share_item, privateChannelAdapter);
                Intrinsics3.checkNotNullParameter(privateChannelAdapter, "adapter");
                WidgetGuildInviteShareItemBinding widgetGuildInviteShareItemBindingA = WidgetGuildInviteShareItemBinding.a(this.itemView);
                Intrinsics3.checkNotNullExpressionValue(widgetGuildInviteShareItemBindingA, "WidgetGuildInviteShareItemBinding.bind(itemView)");
                this.binding = widgetGuildInviteShareItemBindingA;
            }

            public static final /* synthetic */ PrivateChannelAdapter access$getAdapter$p(Item item) {
                return (PrivateChannelAdapter) item.adapter;
            }

            @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
            public void onConfigure(int position, final InviteSuggestionItem data) {
                Intrinsics3.checkNotNullParameter(data, "data");
                super.onConfigure(position, data);
                boolean z2 = data instanceof InviteSuggestionItem.ChannelItem;
                if (z2) {
                    InviteSuggestionItem.ChannelItem channelItem = (InviteSuggestionItem.ChannelItem) data;
                    if (channelItem.getChannel().getType() != 1) {
                        SimpleDraweeView simpleDraweeView = this.binding.f2421b;
                        Intrinsics3.checkNotNullExpressionValue(simpleDraweeView, "binding.itemIconIv");
                        IconUtils.setIcon$default(simpleDraweeView, channelItem.getChannel(), 0, (MGImages.ChangeDetector) null, 12, (Object) null);
                    } else {
                        SimpleDraweeView simpleDraweeView2 = this.binding.f2421b;
                        Intrinsics3.checkNotNullExpressionValue(simpleDraweeView2, "binding.itemIconIv");
                        IconUtils.setIcon$default(simpleDraweeView2, ChannelUtils.a(channelItem.getChannel()), 0, null, null, null, 60, null);
                    }
                    TextView textView = this.binding.d;
                    Intrinsics3.checkNotNullExpressionValue(textView, "binding.itemNameTv");
                    textView.setText(ChannelUtils.c(channelItem.getChannel()));
                } else if (data instanceof InviteSuggestionItem.UserItem) {
                    SimpleDraweeView simpleDraweeView3 = this.binding.f2421b;
                    Intrinsics3.checkNotNullExpressionValue(simpleDraweeView3, "binding.itemIconIv");
                    InviteSuggestionItem.UserItem userItem = (InviteSuggestionItem.UserItem) data;
                    IconUtils.setIcon$default(simpleDraweeView3, userItem.getUser(), 0, null, null, null, 60, null);
                    TextView textView2 = this.binding.d;
                    Intrinsics3.checkNotNullExpressionValue(textView2, "binding.itemNameTv");
                    textView2.setText(userItem.getUser().getUsername());
                }
                if (z2 || (data instanceof InviteSuggestionItem.UserItem)) {
                    MaterialButton materialButton = this.binding.e;
                    Intrinsics3.checkNotNullExpressionValue(materialButton, "binding.itemSent");
                    materialButton.setVisibility(data.hasSentInvite() ? 0 : 8);
                    MaterialButton materialButton2 = this.binding.c;
                    Intrinsics3.checkNotNullExpressionValue(materialButton2, "binding.itemInviteBtn");
                    materialButton2.setVisibility(data.hasSentInvite() ^ true ? 0 : 8);
                    this.binding.c.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.guilds.invite.WidgetGuildInviteShareCompact$PrivateChannelAdapter$Item$onConfigure$1
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            WidgetGuildInviteShareCompact.PrivateChannelAdapter.Item.access$getAdapter$p(this.this$0).getOnClick().invoke(data);
                        }
                    });
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public PrivateChannelAdapter(RecyclerView recyclerView) {
            super(recyclerView, false, 2, null);
            Intrinsics3.checkNotNullParameter(recyclerView, "recycler");
            this.onClick = WidgetGuildInviteShareCompact3.INSTANCE;
        }

        public final Function1<InviteSuggestionItem, Unit> getOnClick() {
            return this.onClick;
        }

        public final void setOnClick(Function1<? super InviteSuggestionItem, Unit> function1) {
            Intrinsics3.checkNotNullParameter(function1, "<set-?>");
            this.onClick = function1;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public Item onCreateViewHolder(ViewGroup parent, int viewType) {
            Intrinsics3.checkNotNullParameter(parent, "parent");
            return new Item(this);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.guilds.invite.WidgetGuildInviteShareCompact$configureUI$3, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetGuildInviteShareCompact.kt */
    public static final class AnonymousClass3 extends Lambda implements Function1<InviteSuggestionItem, Unit> {
        public final /* synthetic */ ModelInvite $invite;
        public final /* synthetic */ WidgetGuildInviteShareViewModel.ViewState.Loaded $viewState;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass3(WidgetGuildInviteShareViewModel.ViewState.Loaded loaded, ModelInvite modelInvite) {
            super(1);
            this.$viewState = loaded;
            this.$invite = modelInvite;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(InviteSuggestionItem inviteSuggestionItem) {
            invoke2(inviteSuggestionItem);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(InviteSuggestionItem inviteSuggestionItem) {
            Intrinsics3.checkNotNullParameter(inviteSuggestionItem, "item");
            WidgetGuildInviteShareCompact.this.sendInvite(inviteSuggestionItem, this.$viewState, this.$invite);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.guilds.invite.WidgetGuildInviteShareCompact$initBottomSheet$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetGuildInviteShareCompact.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            WidgetGuildInviteShareCompact.access$getBottomSheetBehavior$p(WidgetGuildInviteShareCompact.this).setState(5);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.guilds.invite.WidgetGuildInviteShareCompact$onViewBound$2, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetGuildInviteShareCompact.kt */
    public static final class AnonymousClass2 extends Lambda implements Function1<Editable, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Editable editable) {
            invoke2(editable);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Editable editable) {
            Intrinsics3.checkNotNullParameter(editable, "editable");
            WidgetGuildInviteShareCompact.this.getViewModel().updateSearchQuery(editable.toString());
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.guilds.invite.WidgetGuildInviteShareCompact$onViewBoundOrOnResume$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetGuildInviteShareCompact.kt */
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<WidgetGuildInviteShareViewModel.ViewState.Loaded, Unit> {
        public AnonymousClass1(WidgetGuildInviteShareCompact widgetGuildInviteShareCompact) {
            super(1, widgetGuildInviteShareCompact, WidgetGuildInviteShareCompact.class, "configureUI", "configureUI(Lcom/discord/widgets/guilds/invite/WidgetGuildInviteShareViewModel$ViewState$Loaded;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetGuildInviteShareViewModel.ViewState.Loaded loaded) {
            invoke2(loaded);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetGuildInviteShareViewModel.ViewState.Loaded loaded) {
            Intrinsics3.checkNotNullParameter(loaded, "p1");
            ((WidgetGuildInviteShareCompact) this.receiver).configureUI(loaded);
        }
    }

    public WidgetGuildInviteShareCompact() {
        super(R.layout.widget_guild_invite_share_compact);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetGuildInviteShareCompact4.INSTANCE, null, 2, null);
        WidgetGuildInviteShareCompact5 widgetGuildInviteShareCompact5 = new WidgetGuildInviteShareCompact5(this);
        AppViewModelDelegates3 appViewModelDelegates3 = new AppViewModelDelegates3(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(WidgetGuildInviteShareViewModel.class), new WidgetGuildInviteShareCompact$appViewModels$$inlined$viewModels$1(appViewModelDelegates3), new AppViewModelDelegates5(widgetGuildInviteShareCompact5));
    }

    public static final /* synthetic */ BottomSheetBehavior access$getBottomSheetBehavior$p(WidgetGuildInviteShareCompact widgetGuildInviteShareCompact) {
        BottomSheetBehavior<ViewInviteSettingsSheet> bottomSheetBehavior = widgetGuildInviteShareCompact.bottomSheetBehavior;
        if (bottomSheetBehavior == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("bottomSheetBehavior");
        }
        return bottomSheetBehavior;
    }

    private final void configureUI(WidgetGuildInviteShareViewModel.ViewState.Loaded viewState) {
        Guild guild;
        WidgetInviteModel widgetInviteModel = viewState.getWidgetInviteModel();
        List<InviteSuggestionItem> inviteSuggestionItems = viewState.getInviteSuggestionItems();
        final ModelInvite invite = widgetInviteModel.getInvite();
        AppViewFlipper appViewFlipper = getBinding().i;
        Intrinsics3.checkNotNullExpressionValue(appViewFlipper, "binding.guildInviteSuggestionsFlipper");
        appViewFlipper.setDisplayedChild(!inviteSuggestionItems.isEmpty() ? 1 : 0);
        if (inviteSuggestionItems.size() == 1 && (_Collections.firstOrNull((List) inviteSuggestionItems) instanceof InviteSuggestionItem.Companion)) {
            inviteSuggestionItems = null;
        }
        if (inviteSuggestionItems == null) {
            inviteSuggestionItems = Collections2.emptyList();
        }
        if ((!inviteSuggestionItems.isEmpty()) && !this.hasTrackedSuggestionsViewed) {
            ModelInvite invite2 = widgetInviteModel.getInvite();
            long id2 = (invite2 == null || (guild = invite2.guild) == null) ? 0L : guild.getId();
            AnalyticsTracker analyticsTracker = AnalyticsTracker.INSTANCE;
            ArrayList arrayList = new ArrayList();
            for (Object obj : inviteSuggestionItems) {
                if (obj instanceof InviteSuggestionItem.ChannelItem) {
                    arrayList.add(obj);
                }
            }
            ArrayList arrayList2 = new ArrayList(Iterables2.collectionSizeOrDefault(arrayList, 10));
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                arrayList2.add(((InviteSuggestionItem.ChannelItem) it.next()).getChannel());
            }
            ArrayList arrayList3 = new ArrayList();
            for (Object obj2 : inviteSuggestionItems) {
                if (obj2 instanceof InviteSuggestionItem.UserItem) {
                    arrayList3.add(obj2);
                }
            }
            ArrayList arrayList4 = new ArrayList(Iterables2.collectionSizeOrDefault(arrayList3, 10));
            Iterator it2 = arrayList3.iterator();
            while (it2.hasNext()) {
                arrayList4.add(((InviteSuggestionItem.UserItem) it2.next()).getUser());
            }
            analyticsTracker.inviteSuggestionOpened(id2, arrayList2, arrayList4);
            this.hasTrackedSuggestionsViewed = true;
        }
        TextView textView = getBinding().c;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.guildInviteEmptyResults");
        textView.setVisibility(inviteSuggestionItems.isEmpty() ? 0 : 8);
        RecyclerView recyclerView = getBinding().h;
        Intrinsics3.checkNotNullExpressionValue(recyclerView, "binding.guildInviteSuggestionList");
        recyclerView.setVisibility(inviteSuggestionItems.isEmpty() ^ true ? 0 : 8);
        PrivateChannelAdapter privateChannelAdapter = this.adapter;
        if (privateChannelAdapter == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("adapter");
        }
        privateChannelAdapter.setData(inviteSuggestionItems);
        PrivateChannelAdapter privateChannelAdapter2 = this.adapter;
        if (privateChannelAdapter2 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("adapter");
        }
        privateChannelAdapter2.setOnClick(new AnonymousClass3(viewState, invite));
        getBinding().j.configureUi(viewState.getWidgetInviteModel());
        MaterialButton materialButton = getBinding().f;
        Intrinsics3.checkNotNullExpressionValue(materialButton, "binding.guildInviteShareBtn");
        materialButton.setText(getInviteLink(invite));
        getBinding().f.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.guilds.invite.WidgetGuildInviteShareCompact.configureUI.4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ModelInvite modelInvite = invite;
                if (modelInvite != null) {
                    GuildInviteUiHelper.shareLinkClick(WidgetGuildInviteShareCompact.this.getContext(), modelInvite);
                }
            }
        });
        ImageView imageView = getBinding().e;
        Intrinsics3.checkNotNullExpressionValue(imageView, "binding.guildInviteSettingsEdit");
        imageView.setVisibility(viewState.getShowInviteSettings() ? 0 : 8);
        TextView textView2 = getBinding().d;
        Intrinsics3.checkNotNullExpressionValue(textView2, "binding.guildInviteNeverExpire");
        textView2.setVisibility(viewState.getShowInviteSettings() ? 0 : 8);
        TextView textView3 = getBinding().d;
        Intrinsics3.checkNotNullExpressionValue(textView3, "binding.guildInviteNeverExpire");
        textView3.setText(GuildInviteUiHelper.getInviteLinkText(requireContext(), getViewModel().getDefaultInviteExperiment()));
    }

    private final WidgetGuildInviteShareCompactBinding getBinding() {
        return (WidgetGuildInviteShareCompactBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final String getInviteLink(ModelInvite modelInvite) {
        return modelInvite == null ? BuildConfig.HOST_INVITE : modelInvite.toLink(getResources(), BuildConfig.HOST_INVITE);
    }

    private final WidgetGuildInviteShareViewModel getViewModel() {
        return (WidgetGuildInviteShareViewModel) this.viewModel.getValue();
    }

    private final void initBottomSheet() {
        getBinding().j.setOnGenerateLinkListener(new AnonymousClass1());
        getBinding().j.setViewModel(getViewModel());
    }

    private final void initBottomSheetBehavior(BottomSheetBehavior<ViewInviteSettingsSheet> bottomSheetBehavior) {
        bottomSheetBehavior.setState(5);
        bottomSheetBehavior.addBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() { // from class: com.discord.widgets.guilds.invite.WidgetGuildInviteShareCompact.initBottomSheetBehavior.1
            @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
            public void onSlide(View bottomSheet, float slideOffset) {
                Intrinsics3.checkNotNullParameter(bottomSheet, "bottomSheet");
            }

            @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
            public void onStateChanged(View bottomSheet, int newState) {
                Intrinsics3.checkNotNullParameter(bottomSheet, "bottomSheet");
                if (newState == 5) {
                    WidgetGuildInviteShareCompact.this.getViewModel().refreshUi();
                }
                ViewExtensions.fadeBy$default(WidgetGuildInviteShareCompact.this.getBinding().f2419b, newState != 5, 0L, 2, null);
            }
        });
    }

    private final void sendInvite(InviteSuggestionItem item, WidgetGuildInviteShareViewModel.ViewState.Loaded viewState, ModelInvite invite) {
        if (item instanceof InviteSuggestionItem.ChannelItem) {
            getViewModel().sendInviteToChannel(((InviteSuggestionItem.ChannelItem) item).getChannel().getId(), viewState, invite);
        } else if (item instanceof InviteSuggestionItem.UserItem) {
            getViewModel().sendInviteToUser(((InviteSuggestionItem.UserItem) item).getUser().getId(), viewState, invite);
        }
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        MGRecyclerAdapter.Companion companion = MGRecyclerAdapter.INSTANCE;
        RecyclerView recyclerView = getBinding().h;
        Intrinsics3.checkNotNullExpressionValue(recyclerView, "binding.guildInviteSuggestionList");
        this.adapter = (PrivateChannelAdapter) companion.configure(new PrivateChannelAdapter(recyclerView));
        final boolean booleanExtra = getMostRecentIntent().getBooleanExtra(WidgetGuildInviteShare.INTENT_IS_NUX_FLOW, false);
        long longExtra = getMostRecentIntent().getLongExtra("com.discord.intent.extra.EXTRA_CHANNEL_ID", 0L);
        if (longExtra != 0) {
            getViewModel().selectChannel(longExtra);
        }
        setActionBarDisplayHomeAsUpEnabled(true, booleanExtra ? Integer.valueOf(DrawableCompat.getThemedDrawableRes$default(requireContext(), R.attr.ic_close_24dp, 0, 2, (Object) null)) : null, booleanExtra ? Integer.valueOf(R.string.close) : null);
        setActionBarTitle(R.string.invite_people);
        AppFragment.setOnBackPressed$default(this, new Func0<Boolean>() { // from class: com.discord.widgets.guilds.invite.WidgetGuildInviteShareCompact.onViewBound.1
            @Override // rx.functions.Func0, java.util.concurrent.Callable
            public final Boolean call() {
                if (WidgetGuildInviteShareCompact.access$getBottomSheetBehavior$p(WidgetGuildInviteShareCompact.this).getState() != 5) {
                    WidgetGuildInviteShareCompact.access$getBottomSheetBehavior$p(WidgetGuildInviteShareCompact.this).setState(5);
                    return Boolean.TRUE;
                }
                if (!booleanExtra) {
                    return Boolean.FALSE;
                }
                AppScreen2.c(WidgetGuildInviteShareCompact.this.requireContext(), false, null, 6);
                return Boolean.TRUE;
            }
        }, 0, 2, null);
        TextInputLayout textInputLayout = getBinding().g;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.guildInviteShareCompactSearch");
        ViewExtensions.addBindedTextWatcher(textInputLayout, this, new AnonymousClass2());
        BottomSheetBehavior<ViewInviteSettingsSheet> bottomSheetBehaviorFrom = BottomSheetBehavior.from(getBinding().j);
        Intrinsics3.checkNotNullExpressionValue(bottomSheetBehaviorFrom, "BottomSheetBehavior.from…nviteSettingsBottomSheet)");
        this.bottomSheetBehavior = bottomSheetBehaviorFrom;
        if (bottomSheetBehaviorFrom == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("bottomSheetBehavior");
        }
        initBottomSheetBehavior(bottomSheetBehaviorFrom);
        initBottomSheet();
        getBinding().d.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.guilds.invite.WidgetGuildInviteShareCompact.onViewBound.3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                WidgetGuildInviteShareCompact.access$getBottomSheetBehavior$p(WidgetGuildInviteShareCompact.this).setState(3);
            }
        });
        getBinding().e.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.guilds.invite.WidgetGuildInviteShareCompact.onViewBound.4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                WidgetGuildInviteShareCompact.access$getBottomSheetBehavior$p(WidgetGuildInviteShareCompact.this).setState(3);
            }
        });
        getBinding().f2419b.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.guilds.invite.WidgetGuildInviteShareCompact.onViewBound.5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                WidgetGuildInviteShareCompact.access$getBottomSheetBehavior$p(WidgetGuildInviteShareCompact.this).setState(5);
            }
        });
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        Observable<R> observableG = getViewModel().observeViewState().y(new Func1<Object, Boolean>() { // from class: com.discord.widgets.guilds.invite.WidgetGuildInviteShareCompact$onViewBoundOrOnResume$$inlined$filterIs$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // j0.k.Func1
            public final Boolean call(Object obj) {
                return Boolean.valueOf(obj instanceof WidgetGuildInviteShareViewModel.ViewState.Loaded);
            }
        }).G(new Func1<Object, T>() { // from class: com.discord.widgets.guilds.invite.WidgetGuildInviteShareCompact$onViewBoundOrOnResume$$inlined$filterIs$2
            @Override // j0.k.Func1
            public final T call(Object obj) {
                Objects.requireNonNull(obj, "null cannot be cast to non-null type com.discord.widgets.guilds.invite.WidgetGuildInviteShareViewModel.ViewState.Loaded");
                return (T) ((WidgetGuildInviteShareViewModel.ViewState.Loaded) obj);
            }
        });
        Intrinsics3.checkNotNullExpressionValue(observableG, "filter { it is T }.map { it as T }");
        PrivateChannelAdapter privateChannelAdapter = this.adapter;
        if (privateChannelAdapter == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("adapter");
        }
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.bindToComponentLifecycle(observableG, this, privateChannelAdapter), (Class<?>) WidgetGuildInviteShareCompact.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass1(this));
    }
}
