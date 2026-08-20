package com.discord.widgets.user.search;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import androidx.annotation.MainThread;
import androidx.core.os.BundleKt;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.C5419R;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.app.AppFragment;
import com.discord.app.AppViewFlipper;
import com.discord.databinding.WidgetGlobalSearchBinding;
import com.discord.models.guild.Guild;
import com.discord.models.user.User;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StoreNavigation;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreTabsNavigation;
import com.discord.utilities.accessibility.AccessibilityUtils;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.channel.ChannelSelector;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.error.Error;
import com.discord.utilities.mg_recycler.MGRecyclerAdapter;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.widgets.channels.list.WidgetChannelsListItemChannelActions;
import com.discord.widgets.chat.input.MentionUtilsKt;
import com.discord.widgets.friends.WidgetFriendsAdd;
import com.discord.widgets.guilds.join.WidgetGuildJoin;
import com.discord.widgets.guilds.profile.WidgetGuildProfileSheet;
import com.discord.widgets.tabs.NavigationTab;
import com.discord.widgets.user.usersheet.WidgetUserSheet;
import com.google.android.material.textfield.TextInputLayout;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import org.objectweb.asm.Opcodes;
import p007b.p008a.p009a.C0837n;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.C12116o;
import p507d0.p579g0.C12103t;
import p507d0.p579g0.C12106w;
import p507d0.p579g0.C12108y;
import p507d0.p580t.C12147n;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12216a0;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;
import p637j0.p642l.p647e.C12721k;
import p658rx.Observable;
import p658rx.Subscription;
import p658rx.subjects.BehaviorSubject;

/* JADX INFO: compiled from: WidgetGlobalSearch.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetGlobalSearch extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {C1643a.m846d0(WidgetGlobalSearch.class, "binding", "getBinding()Lcom/discord/databinding/WidgetGlobalSearchBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final String EXTRA_SEARCH_TEXT = "EXTRA_SEARCH_TEXT";
    private static final int INDEX_EMPTY = 1;
    private static final int INDEX_RESULTS = 0;
    private static final int INDEX_RESULTS_NOT_FOUND = 2;

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* JADX INFO: renamed from: dismissViewModel$delegate, reason: from kotlin metadata */
    private final Lazy dismissViewModel;
    private final BehaviorSubject<String> filterPublisher;
    private String filterString;
    private WidgetGlobalSearchGuildsAdapter guildsAdapter;
    private WidgetGlobalSearchAdapter resultsAdapter;
    private final StoreTabsNavigation storeTabsNavigation;

    /* JADX INFO: compiled from: WidgetGlobalSearch.kt */
    public static final class Companion {
        private Companion() {
        }

        public static /* synthetic */ WidgetGlobalSearch create$default(Companion companion, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = null;
            }
            return companion.create(str);
        }

        private final Pair<Integer, Character>[] getFILTER_OPTIONS_LIST() {
            return new Pair[]{C12116o.m10073to(Integer.valueOf(C5419R.string.users), Character.valueOf(MentionUtilsKt.MENTIONS_CHAR)), C12116o.m10073to(Integer.valueOf(C5419R.string.text_channels), Character.valueOf(MentionUtilsKt.CHANNELS_CHAR)), C12116o.m10073to(Integer.valueOf(C5419R.string.voice_channels), '!'), C12116o.m10073to(Integer.valueOf(C5419R.string.servers), '*')};
        }

        private final WidgetGlobalSearchModel.ItemDataPayload toWidgetGlobalSearchModelItem(WidgetGlobalSearchGuildsModel.Item item) {
            Channel channel = item.getChannel();
            User userM7677a = channel != null ? ChannelUtils.m7677a(channel) : null;
            if (item.getGuild() != null) {
                return new WidgetGlobalSearchModel.ItemGuild(WidgetGlobalSearchModel.INSTANCE.getEMPTY_MATCH_RESULT(), item.getGuild(), channel, 0, false, 24, null);
            }
            if (userM7677a != null) {
                return new WidgetGlobalSearchModel.ItemUser(WidgetGlobalSearchModel.INSTANCE.getEMPTY_MATCH_RESULT(), userM7677a, C12147n.emptyList(), false, null, channel, 0, false, Opcodes.CHECKCAST, null);
            }
            if (channel == null || !ChannelUtils.m7702z(channel)) {
                return null;
            }
            return new WidgetGlobalSearchModel.ItemChannel(WidgetGlobalSearchModel.INSTANCE.getEMPTY_MATCH_RESULT(), channel, null, null, 0, false, 48, null);
        }

        public final WidgetGlobalSearch create(String searchText) {
            WidgetGlobalSearch widgetGlobalSearch = new WidgetGlobalSearch();
            widgetGlobalSearch.setArguments(BundleKt.bundleOf(C12116o.m10073to(WidgetGlobalSearch.EXTRA_SEARCH_TEXT, searchText)));
            return widgetGlobalSearch;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.user.search.WidgetGlobalSearch$configureUI$1 */
    /* JADX INFO: compiled from: WidgetGlobalSearch.kt */
    public static final class C103151 extends AbstractC12240o implements Function3<Integer, Integer, WidgetGlobalSearchGuildsModel.Item, Unit> {
        public C103151() {
            super(3);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(Integer num, Integer num2, WidgetGlobalSearchGuildsModel.Item item) {
            invoke(num.intValue(), num2.intValue(), item);
            return Unit.f27425a;
        }

        public final void invoke(int i, int i2, WidgetGlobalSearchGuildsModel.Item item) {
            C12238m.checkNotNullParameter(item, "data");
            if (i == 2) {
                WidgetChannelsListItemChannelActions.Companion companion = WidgetChannelsListItemChannelActions.INSTANCE;
                FragmentManager parentFragmentManager = WidgetGlobalSearch.this.getParentFragmentManager();
                C12238m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
                companion.show(parentFragmentManager, item.getId());
                return;
            }
            if (i != 3) {
                return;
            }
            WidgetGuildProfileSheet.Companion companion2 = WidgetGuildProfileSheet.INSTANCE;
            FragmentManager parentFragmentManager2 = WidgetGlobalSearch.this.getParentFragmentManager();
            C12238m.checkNotNullExpressionValue(parentFragmentManager2, "parentFragmentManager");
            Guild guild = item.getGuild();
            companion2.show(parentFragmentManager2, false, guild != null ? guild.getId() : 0L, (8 & 8) != 0 ? 0L : 0L, (8 & 16) != 0 ? false : false);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.user.search.WidgetGlobalSearch$configureUI$2 */
    /* JADX INFO: compiled from: WidgetGlobalSearch.kt */
    public static final class C103162 extends AbstractC12240o implements Function3<Integer, Integer, WidgetGlobalSearchGuildsModel.Item, Unit> {
        public final /* synthetic */ WidgetGlobalSearchModel $model;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C103162(WidgetGlobalSearchModel widgetGlobalSearchModel) {
            super(3);
            this.$model = widgetGlobalSearchModel;
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(Integer num, Integer num2, WidgetGlobalSearchGuildsModel.Item item) {
            invoke(num.intValue(), num2.intValue(), item);
            return Unit.f27425a;
        }

        public final void invoke(int i, int i2, WidgetGlobalSearchGuildsModel.Item item) {
            C12238m.checkNotNullParameter(item, "selected");
            if (i == 2) {
                ChannelSelector.selectChannel$default(ChannelSelector.INSTANCE.getInstance(), 0L, item.getId(), null, null, 12, null);
            } else if (i == 3) {
                StoreStream.INSTANCE.getGuildSelected().set(item.getId());
            }
            WidgetGlobalSearchModel.ItemDataPayload widgetGlobalSearchModelItem = WidgetGlobalSearch.INSTANCE.toWidgetGlobalSearchModelItem(item);
            if (widgetGlobalSearchModelItem != null) {
                AnalyticsTracker.INSTANCE.quickSwitcherSelect(this.$model, widgetGlobalSearchModelItem, i2);
            }
            WidgetGlobalSearch.this.onSelected(NavigationTab.HOME, StoreNavigation.PanelAction.OPEN);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.user.search.WidgetGlobalSearch$onViewBound$1 */
    /* JADX INFO: compiled from: WidgetGlobalSearch.kt */
    public static final class C103171 extends AbstractC12240o implements Function1<Editable, Unit> {
        public C103171() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Editable editable) {
            invoke2(editable);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Editable editable) {
            C12238m.checkNotNullParameter(editable, "editable");
            WidgetGlobalSearch.this.filterPublisher.onNext(editable.toString());
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.user.search.WidgetGlobalSearch$onViewBound$5 */
    /* JADX INFO: compiled from: WidgetGlobalSearch.kt */
    public static final class C103205 extends AbstractC12240o implements Function1<Unit, Unit> {
        public C103205() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Unit unit) {
            invoke2(unit);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Unit unit) {
            WidgetGlobalSearch.this.focusSearchBar();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.user.search.WidgetGlobalSearch$onViewBoundOrOnResume$1 */
    /* JADX INFO: compiled from: WidgetGlobalSearch.kt */
    public static final /* synthetic */ class C103231 extends C12236k implements Function1<WidgetGlobalSearchModel, Unit> {
        public C103231(WidgetGlobalSearch widgetGlobalSearch) {
            super(1, widgetGlobalSearch, WidgetGlobalSearch.class, "configureUI", "configureUI(Lcom/discord/widgets/user/search/WidgetGlobalSearchModel;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetGlobalSearchModel widgetGlobalSearchModel) {
            invoke2(widgetGlobalSearchModel);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetGlobalSearchModel widgetGlobalSearchModel) {
            C12238m.checkNotNullParameter(widgetGlobalSearchModel, "p1");
            ((WidgetGlobalSearch) this.receiver).configureUI(widgetGlobalSearchModel);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.user.search.WidgetGlobalSearch$showFilterPickerDialog$1 */
    /* JADX INFO: compiled from: WidgetGlobalSearch.kt */
    public static final class C103241 extends AbstractC12240o implements Function1<Integer, Unit> {
        public C103241() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
            invoke(num.intValue());
            return Unit.f27425a;
        }

        public final void invoke(int i) {
            WidgetGlobalSearch.this.setSearchPrefix(String.valueOf(((Character) WidgetGlobalSearch.INSTANCE.getFILTER_OPTIONS_LIST()[i].component2()).charValue()));
        }
    }

    public WidgetGlobalSearch() {
        super(C5419R.layout.widget_global_search);
        this.dismissViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, C12216a0.getOrCreateKotlinClass(WidgetGlobalSearchDismissModel.class), new WidgetGlobalSearch$$special$$inlined$activityViewModels$1(this), new WidgetGlobalSearch$$special$$inlined$activityViewModels$2(this));
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetGlobalSearch$binding$2.INSTANCE, null, 2, null);
        this.storeTabsNavigation = StoreStream.INSTANCE.getTabsNavigation();
        this.filterPublisher = BehaviorSubject.m11130l0("");
    }

    @MainThread
    private final void configureUI(WidgetGlobalSearchModel model) {
        WidgetGlobalSearchGuildsAdapter widgetGlobalSearchGuildsAdapter = this.guildsAdapter;
        if (widgetGlobalSearchGuildsAdapter == null) {
            C12238m.throwUninitializedPropertyAccessException("guildsAdapter");
        }
        List<WidgetGlobalSearchGuildsModel.Item> guildsList = model.getGuildsList();
        if (guildsList == null) {
            guildsList = C12147n.emptyList();
        }
        widgetGlobalSearchGuildsAdapter.setData(guildsList);
        WidgetGlobalSearchGuildsAdapter widgetGlobalSearchGuildsAdapter2 = this.guildsAdapter;
        if (widgetGlobalSearchGuildsAdapter2 == null) {
            C12238m.throwUninitializedPropertyAccessException("guildsAdapter");
        }
        widgetGlobalSearchGuildsAdapter2.setOnLongClickListener(new C103151());
        WidgetGlobalSearchGuildsAdapter widgetGlobalSearchGuildsAdapter3 = this.guildsAdapter;
        if (widgetGlobalSearchGuildsAdapter3 == null) {
            C12238m.throwUninitializedPropertyAccessException("guildsAdapter");
        }
        widgetGlobalSearchGuildsAdapter3.setOnClickListener(new C103162(model));
        RecyclerView recyclerView = getBinding().f16711e;
        C12238m.checkNotNullExpressionValue(recyclerView, "binding.globalSearchGuildList");
        List<WidgetGlobalSearchGuildsModel.Item> guildsList2 = model.getGuildsList();
        recyclerView.setVisibility(guildsList2 != null && !guildsList2.isEmpty() ? 0 : 8);
        WidgetGlobalSearchAdapter widgetGlobalSearchAdapter = this.resultsAdapter;
        if (widgetGlobalSearchAdapter == null) {
            C12238m.throwUninitializedPropertyAccessException("resultsAdapter");
        }
        widgetGlobalSearchAdapter.setOnUpdated(new WidgetGlobalSearch$configureUI$$inlined$apply$lambda$1(this, model));
        widgetGlobalSearchAdapter.setData(model.getData());
        widgetGlobalSearchAdapter.setOnSelectedListener(new WidgetGlobalSearch$configureUI$$inlined$apply$lambda$2(this, model));
        AppViewFlipper appViewFlipper = getBinding().f16714h;
        C12238m.checkNotNullExpressionValue(appViewFlipper, "binding.globalSearchViewFlipper");
        appViewFlipper.setDisplayedChild(getViewIndex(model));
    }

    private final void focusSearchBar() {
        getBinding().f16710d.requestFocus();
        Context context = getContext();
        Object systemService = context != null ? context.getSystemService("input_method") : null;
        InputMethodManager inputMethodManager = (InputMethodManager) (systemService instanceof InputMethodManager ? systemService : null);
        if (inputMethodManager != null) {
            inputMethodManager.showSoftInput(getBinding().f16710d, 1);
        }
    }

    private final WidgetGlobalSearchBinding getBinding() {
        return (WidgetGlobalSearchBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final WidgetGlobalSearchDismissModel getDismissViewModel() {
        return (WidgetGlobalSearchDismissModel) this.dismissViewModel.getValue();
    }

    private final int getViewIndex(WidgetGlobalSearchModel widgetGlobalSearchModel) {
        if (!widgetGlobalSearchModel.getData().isEmpty()) {
            return 0;
        }
        return C12103t.isBlank(widgetGlobalSearchModel.getFilter()) ^ true ? 2 : 1;
    }

    private final void handleOnSelected(WidgetGlobalSearchModel widgetGlobalSearchModel, View view, int i, WidgetGlobalSearchModel.ItemDataPayload itemDataPayload, boolean z2) {
        if (itemDataPayload instanceof WidgetGlobalSearchModel.ItemUser) {
            if (z2) {
                WidgetUserSheet.Companion companion = WidgetUserSheet.INSTANCE;
                long id2 = ((WidgetGlobalSearchModel.ItemUser) itemDataPayload).getUser().getId();
                FragmentManager parentFragmentManager = getParentFragmentManager();
                C12238m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
                WidgetUserSheet.Companion.show$default(companion, id2, null, parentFragmentManager, null, null, null, null, 122, null);
            } else {
                ChannelSelector companion2 = ChannelSelector.INSTANCE.getInstance();
                Context context = view.getContext();
                C12238m.checkNotNullExpressionValue(context, "view.context");
                companion2.findAndSetDirectMessage(context, ((WidgetGlobalSearchModel.ItemUser) itemDataPayload).getUser().getId());
            }
        } else if (itemDataPayload instanceof WidgetGlobalSearchModel.ItemChannel) {
            ChannelSelector.INSTANCE.getInstance().findAndSet(getContext(), ((WidgetGlobalSearchModel.ItemChannel) itemDataPayload).getChannel().getId());
        } else if (itemDataPayload instanceof WidgetGlobalSearchModel.ItemGuild) {
            StoreStream.INSTANCE.getGuildSelected().set(((WidgetGlobalSearchModel.ItemGuild) itemDataPayload).getGuild().getId());
        }
        if ((itemDataPayload instanceof WidgetGlobalSearchModel.ItemHeader) || z2) {
            return;
        }
        AnalyticsTracker.INSTANCE.quickSwitcherSelect(widgetGlobalSearchModel, itemDataPayload, i);
        onSelected(NavigationTab.HOME, itemDataPayload instanceof WidgetGlobalSearchModel.ItemGuild ? StoreNavigation.PanelAction.OPEN : StoreNavigation.PanelAction.CLOSE);
    }

    private final void onSelected(NavigationTab destinationTab, StoreNavigation.PanelAction panelAction) {
        if (destinationTab == NavigationTab.HOME) {
            StoreTabsNavigation.selectHomeTab$default(this.storeTabsNavigation, panelAction, false, 2, null);
        } else {
            StoreTabsNavigation.selectTab$default(this.storeTabsNavigation, destinationTab, false, 2, null);
        }
        getDismissViewModel().dismiss();
    }

    public static /* synthetic */ void onSelected$default(WidgetGlobalSearch widgetGlobalSearch, NavigationTab navigationTab, StoreNavigation.PanelAction panelAction, int i, Object obj) {
        if ((i & 1) != 0) {
            navigationTab = NavigationTab.HOME;
        }
        if ((i & 2) != 0) {
            panelAction = StoreNavigation.PanelAction.CLOSE;
        }
        widgetGlobalSearch.onSelected(navigationTab, panelAction);
    }

    @SuppressLint({"SetTextI18n"})
    @MainThread
    private final void setSearchPrefix(String prefix) {
        CharSequence charSequenceReplace;
        TextInputLayout textInputLayout = getBinding().f16709c;
        C12238m.checkNotNullExpressionValue(textInputLayout, "binding.globalSearchBar");
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(ViewExtensions.getTextOrEmpty(textInputLayout));
        if (spannableStringBuilder.length() == 0) {
            charSequenceReplace = prefix + ((Object) spannableStringBuilder);
        } else {
            char cFirst = C12108y.first(spannableStringBuilder);
            if (cFirst == '!' || cFirst == '#' || cFirst == '*' || cFirst == '@') {
                charSequenceReplace = spannableStringBuilder.replace(0, 1, (CharSequence) prefix);
            } else {
                charSequenceReplace = prefix + ((Object) spannableStringBuilder);
            }
        }
        C12238m.checkNotNullExpressionValue(charSequenceReplace, "newQuery");
        if (!C12103t.isBlank(charSequenceReplace)) {
            final TextInputLayout textInputLayout2 = getBinding().f16709c;
            ViewExtensions.setText(textInputLayout2, charSequenceReplace);
            textInputLayout2.post(new Runnable() { // from class: com.discord.widgets.user.search.WidgetGlobalSearch$setSearchPrefix$1$1
                @Override // java.lang.Runnable
                public final void run() {
                    ViewExtensions.setSelectionEnd(textInputLayout2);
                }
            });
        }
    }

    private final void showFilterPickerDialog() {
        Pair[] filter_options_list = INSTANCE.getFILTER_OPTIONS_LIST();
        ArrayList arrayList = new ArrayList(filter_options_list.length);
        for (Pair pair : filter_options_list) {
            arrayList.add(getString(((Number) pair.component1()).intValue()));
        }
        Object[] array = arrayList.toArray(new String[0]);
        Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
        C0837n.Companion companion = C0837n.INSTANCE;
        FragmentManager parentFragmentManager = getParentFragmentManager();
        C12238m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        String string = getString(C5419R.string.filter_options);
        C12238m.checkNotNullExpressionValue(string, "getString(R.string.filter_options)");
        companion.m142a(parentFragmentManager, string, (String[]) array, new C103241());
    }

    public final void onDismiss() {
        hideKeyboard(getBinding().f16709c);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        String string;
        C12238m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        MGRecyclerAdapter.Companion companion = MGRecyclerAdapter.INSTANCE;
        RecyclerView recyclerView = getBinding().f16713g;
        C12238m.checkNotNullExpressionValue(recyclerView, "binding.globalSearchRecycler");
        this.resultsAdapter = (WidgetGlobalSearchAdapter) companion.configure(new WidgetGlobalSearchAdapter(recyclerView));
        RecyclerView recyclerView2 = getBinding().f16711e;
        C12238m.checkNotNullExpressionValue(recyclerView2, "binding.globalSearchGuildList");
        this.guildsAdapter = (WidgetGlobalSearchGuildsAdapter) companion.configure(new WidgetGlobalSearchGuildsAdapter(recyclerView2, ColorCompat.getThemedColor(view, C5419R.attr.primary_630)));
        TextInputLayout textInputLayout = getBinding().f16709c;
        C12238m.checkNotNullExpressionValue(textInputLayout, "binding.globalSearchBar");
        ViewExtensions.addBindedTextWatcher(textInputLayout, this, new C103171());
        Bundle arguments = getArguments();
        if (arguments != null && (string = arguments.getString(EXTRA_SEARCH_TEXT)) != null) {
            TextInputLayout textInputLayout2 = getBinding().f16709c;
            C12238m.checkNotNullExpressionValue(textInputLayout2, "binding.globalSearchBar");
            ViewExtensions.setText(textInputLayout2, string);
            TextInputLayout textInputLayout3 = getBinding().f16709c;
            C12238m.checkNotNullExpressionValue(textInputLayout3, "binding.globalSearchBar");
            ViewExtensions.setSelectionEnd(textInputLayout3);
        }
        getBinding().f16709c.setEndIconOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.user.search.WidgetGlobalSearch.onViewBound.3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                WidgetGlobalSearch.this.showFilterPickerDialog();
            }
        });
        getBinding().f16709c.setStartIconOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.user.search.WidgetGlobalSearch.onViewBound.4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                WidgetGlobalSearch widgetGlobalSearch = WidgetGlobalSearch.this;
                widgetGlobalSearch.hideKeyboard(widgetGlobalSearch.getBinding().f16709c);
                WidgetGlobalSearch.this.getDismissViewModel().dismiss();
            }
        });
        C12721k c12721k = new C12721k(Unit.f27425a);
        C12238m.checkNotNullExpressionValue(c12721k, "Observable.just(Unit)");
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(c12721k, this, null, 2, null), (Class<?>) WidgetGlobalSearch.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C103205());
        getBinding().f16708b.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.user.search.WidgetGlobalSearch.onViewBound.6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                WidgetFriendsAdd.Companion companion2 = WidgetFriendsAdd.INSTANCE;
                Context contextM885x = C1643a.m885x(view2, "it", "it.context");
                TextInputLayout textInputLayout4 = WidgetGlobalSearch.this.getBinding().f16709c;
                C12238m.checkNotNullExpressionValue(textInputLayout4, "binding.globalSearchBar");
                companion2.show(contextM885x, C12106w.trimStart(ViewExtensions.getTextOrEmpty(textInputLayout4), MentionUtilsKt.MENTIONS_CHAR, MentionUtilsKt.CHANNELS_CHAR, '*'), "QuickSwitcher");
                WidgetGlobalSearch.onSelected$default(WidgetGlobalSearch.this, NavigationTab.FRIENDS, null, 2, null);
            }
        });
        getBinding().f16712f.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.user.search.WidgetGlobalSearch.onViewBound.7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                WidgetGuildJoin.Companion companion2 = WidgetGuildJoin.INSTANCE;
                C12238m.checkNotNullExpressionValue(view2, "it");
                Context context = view2.getContext();
                C12238m.checkNotNullExpressionValue(context, "it.context");
                companion2.show(context, "QuickSwitcher");
                WidgetGlobalSearch.this.onSelected(NavigationTab.HOME, StoreNavigation.PanelAction.OPEN);
            }
        });
        if (AccessibilityUtils.INSTANCE.isReducedMotionEnabled()) {
            RecyclerView recyclerView3 = getBinding().f16713g;
            C12238m.checkNotNullExpressionValue(recyclerView3, "binding.globalSearchRecycler");
            recyclerView3.setItemAnimator(null);
        }
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        WidgetGlobalSearchModel.Companion companion = WidgetGlobalSearchModel.INSTANCE;
        BehaviorSubject<String> behaviorSubject = this.filterPublisher;
        C12238m.checkNotNullExpressionValue(behaviorSubject, "filterPublisher");
        Observable<WidgetGlobalSearchModel> forNav = companion.getForNav(behaviorSubject);
        WidgetGlobalSearchAdapter widgetGlobalSearchAdapter = this.resultsAdapter;
        if (widgetGlobalSearchAdapter == null) {
            C12238m.throwUninitializedPropertyAccessException("resultsAdapter");
        }
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.m8519ui(forNav, this, widgetGlobalSearchAdapter), (Class<?>) WidgetGlobalSearch.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C103231(this));
        BehaviorSubject<String> behaviorSubject2 = this.filterPublisher;
        C12238m.checkNotNullExpressionValue(behaviorSubject2, "filterPublisher");
        StoreGuilds.Actions.requestMembers(this, behaviorSubject2, false);
    }
}
