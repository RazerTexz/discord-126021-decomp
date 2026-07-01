package com.discord.widgets.guilds;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.LayoutRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.Fragment2;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;
import b.a.k.FormatUtils;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.app.AppBottomSheet;
import com.discord.databinding.WidgetGuildSelectorBinding;
import com.discord.databinding.WidgetGuildSelectorItemBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.guild.Guild;
import com.discord.stores.StoreStream;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.error.Error;
import com.discord.utilities.extensions.SimpleDraweeViewExtensions;
import com.discord.utilities.mg_recycler.MGRecyclerAdapter;
import com.discord.utilities.mg_recycler.MGRecyclerAdapterSimple;
import com.discord.utilities.mg_recycler.MGRecyclerDataPayload;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.widgets.guilds.WidgetGuildSelector;
import com.facebook.drawee.view.SimpleDraweeView;
import d0.LazyJVM;
import d0.t.Collections2;
import d0.t.CollectionsJVM;
import d0.t.Iterables2;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import j0.k.Func1;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import rx.Observable;
import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

/* JADX INFO: compiled from: WidgetGuildSelector.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildSelector extends AppBottomSheet {
    private static final String ARG_FILTER_FUNCTION = "INTENT_EXTRA_FILTER_FUNCTION";
    private static final String ARG_INCLUDE_NO_GUILD = "INTENT_EXTRA_INCLUDE_NO_GUILD";
    private static final String ARG_NO_GUILD_STRING_ID = "INTENT_EXTRA_NO_GUILD_STRING_ID";
    private static final String ARG_REQUEST_KEY = "INTENT_EXTRA_REQUEST_CODE";
    private static final String REQUEST_KEY_DEFAULT = "GUILD_SELECTOR_DEFAULT_REQUEST_KEY";
    private static final String RESULT_EXTRA_GUILD_ID = "INTENT_EXTRA_GUILD_ID";
    private static final String RESULT_EXTRA_GUILD_NAME = "INTENT_EXTRA_GUILD_NAME";
    private Adapter adapter;

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* JADX INFO: renamed from: requestKey$delegate, reason: from kotlin metadata */
    private final Lazy requestKey;
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetGuildSelector.class, "binding", "getBinding()Lcom/discord/databinding/WidgetGuildSelectorBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: compiled from: WidgetGuildSelector.kt */
    public static final class Adapter extends MGRecyclerAdapterSimple<Item> {
        private final WidgetGuildSelector dialog;
        private final int noGuildStringId;

        /* JADX INFO: compiled from: WidgetGuildSelector.kt */
        public static final class ItemGuild extends MGRecyclerViewHolder<Adapter, Item> {
            private final WidgetGuildSelectorItemBinding binding;
            private final int noGuildStringId;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ItemGuild(@LayoutRes int i, Adapter adapter, int i2) {
                super(i, adapter);
                Intrinsics3.checkNotNullParameter(adapter, "adapter");
                this.noGuildStringId = i2;
                View view = this.itemView;
                int i3 = R.id.item_avatar_wrap;
                FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.item_avatar_wrap);
                if (frameLayout != null) {
                    i3 = R.id.item_icon;
                    SimpleDraweeView simpleDraweeView = (SimpleDraweeView) view.findViewById(R.id.item_icon);
                    if (simpleDraweeView != null) {
                        i3 = R.id.item_name;
                        TextView textView = (TextView) view.findViewById(R.id.item_name);
                        if (textView != null) {
                            i3 = R.id.item_text;
                            TextView textView2 = (TextView) view.findViewById(R.id.item_text);
                            if (textView2 != null) {
                                WidgetGuildSelectorItemBinding widgetGuildSelectorItemBinding = new WidgetGuildSelectorItemBinding((LinearLayout) view, frameLayout, simpleDraweeView, textView, textView2);
                                Intrinsics3.checkNotNullExpressionValue(widgetGuildSelectorItemBinding, "WidgetGuildSelectorItemBinding.bind(itemView)");
                                this.binding = widgetGuildSelectorItemBinding;
                                return;
                            }
                        }
                    }
                }
                throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
            }

            public static final /* synthetic */ Adapter access$getAdapter$p(ItemGuild itemGuild) {
                return (Adapter) itemGuild.adapter;
            }

            public final int getNoGuildStringId() {
                return this.noGuildStringId;
            }

            @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
            public void onConfigure(int position, final Item data) {
                CharSequence charSequenceD;
                Guild guild;
                String icon;
                Intrinsics3.checkNotNullParameter(data, "data");
                super.onConfigure(position, data);
                this.binding.a.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.guilds.WidgetGuildSelector$Adapter$ItemGuild$onConfigure$1
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        WidgetGuildSelector.Adapter.ItemGuild.access$getAdapter$p(this.this$0).dialog.onGuildSelected(data.getGuild());
                    }
                });
                TextView textView = this.binding.d;
                Intrinsics3.checkNotNullExpressionValue(textView, "binding.itemName");
                Guild guild2 = data.getGuild();
                boolean z2 = false;
                String shortName = null;
                if (guild2 == null || (charSequenceD = guild2.getName()) == null) {
                    TextView textView2 = this.binding.d;
                    Intrinsics3.checkNotNullExpressionValue(textView2, "binding.itemName");
                    charSequenceD = FormatUtils.d(textView2, this.noGuildStringId, new Object[0], (4 & 4) != 0 ? FormatUtils.c.j : null);
                }
                textView.setText(charSequenceD);
                Guild guild3 = data.getGuild();
                if (guild3 != null && (icon = guild3.getIcon()) != null) {
                    if (icon.length() > 0) {
                        z2 = true;
                    }
                }
                SimpleDraweeView simpleDraweeView = this.binding.c;
                Intrinsics3.checkNotNullExpressionValue(simpleDraweeView, "binding.itemIcon");
                Guild guild4 = data.getGuild();
                View view = this.itemView;
                Intrinsics3.checkNotNullExpressionValue(view, "itemView");
                Integer numValueOf = Integer.valueOf(ColorCompat.getThemedColor(view, R.attr.colorBackgroundPrimary));
                SimpleDraweeView simpleDraweeView2 = this.binding.c;
                Intrinsics3.checkNotNullExpressionValue(simpleDraweeView2, "binding.itemIcon");
                SimpleDraweeViewExtensions.setGuildIcon(simpleDraweeView, false, (496 & 2) != 0 ? null : guild4, simpleDraweeView2.getResources().getDimensionPixelSize(R.dimen.guild_icon_radius), (496 & 8) != 0 ? null : null, (496 & 16) != 0 ? null : numValueOf, (496 & 32) != 0 ? null : null, (496 & 64) != 0 ? null : null, (496 & 128) != 0 ? false : true, (496 & 256) != 0 ? null : null);
                FrameLayout frameLayout = this.binding.f2452b;
                Intrinsics3.checkNotNullExpressionValue(frameLayout, "binding.itemAvatarWrap");
                frameLayout.setClipToOutline(true);
                TextView textView3 = this.binding.e;
                Intrinsics3.checkNotNullExpressionValue(textView3, "binding.itemText");
                if (!z2 && (guild = data.getGuild()) != null) {
                    shortName = guild.getShortName();
                }
                textView3.setText(shortName);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Adapter(RecyclerView recyclerView, WidgetGuildSelector widgetGuildSelector, int i) {
            super(recyclerView, false, 2, null);
            Intrinsics3.checkNotNullParameter(recyclerView, "recycler");
            Intrinsics3.checkNotNullParameter(widgetGuildSelector, "dialog");
            this.dialog = widgetGuildSelector;
            this.noGuildStringId = i;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public ItemGuild onCreateViewHolder(ViewGroup parent, int viewType) {
            Intrinsics3.checkNotNullParameter(parent, "parent");
            return new ItemGuild(R.layout.widget_guild_selector_item, this, this.noGuildStringId);
        }
    }

    /* JADX INFO: compiled from: WidgetGuildSelector.kt */
    public static final class BaseFilterFunction implements FilterFunction {
        @Override // com.discord.widgets.guilds.WidgetGuildSelector.FilterFunction
        public boolean includeGuild(Guild guild) {
            Intrinsics3.checkNotNullParameter(guild, "guild");
            return FilterFunction.DefaultImpls.includeGuild(this, guild);
        }
    }

    /* JADX INFO: compiled from: WidgetGuildSelector.kt */
    public static final class Companion {
        private Companion() {
        }

        public static /* synthetic */ void launch$default(Companion companion, Fragment fragment, String str, boolean z2, int i, FilterFunction filterFunction, int i2, Object obj) {
            if ((i2 & 2) != 0) {
                str = WidgetGuildSelector.REQUEST_KEY_DEFAULT;
            }
            String str2 = str;
            boolean z3 = (i2 & 4) != 0 ? false : z2;
            int i3 = (i2 & 8) != 0 ? R.string.none : i;
            if ((i2 & 16) != 0) {
                filterFunction = null;
            }
            companion.launch(fragment, str2, z3, i3, filterFunction);
        }

        public static /* synthetic */ void registerForResult$default(Companion companion, Fragment fragment, String str, boolean z2, Function2 function2, int i, Object obj) {
            if ((i & 2) != 0) {
                str = WidgetGuildSelector.REQUEST_KEY_DEFAULT;
            }
            if ((i & 4) != 0) {
                z2 = false;
            }
            companion.registerForResult(fragment, str, z2, function2);
        }

        public final void launch(Fragment fragment, String requestKey, boolean includeNoGuild, int noGuildStringId, FilterFunction filterFunction) {
            Intrinsics3.checkNotNullParameter(fragment, "fragment");
            Intrinsics3.checkNotNullParameter(requestKey, "requestKey");
            WidgetGuildSelector widgetGuildSelector = new WidgetGuildSelector();
            Bundle bundle = new Bundle();
            bundle.putString(WidgetGuildSelector.ARG_REQUEST_KEY, requestKey);
            bundle.putBoolean(WidgetGuildSelector.ARG_INCLUDE_NO_GUILD, includeNoGuild);
            bundle.putInt(WidgetGuildSelector.ARG_NO_GUILD_STRING_ID, noGuildStringId);
            bundle.putSerializable(WidgetGuildSelector.ARG_FILTER_FUNCTION, filterFunction);
            widgetGuildSelector.setArguments(bundle);
            FragmentManager parentFragmentManager = fragment.getParentFragmentManager();
            Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "fragment.parentFragmentManager");
            widgetGuildSelector.show(parentFragmentManager, WidgetGuildSelector.class.getName());
        }

        public final void registerForResult(Fragment fragment, String requestKey, boolean allowNullGuild, Function2<? super Long, ? super String, Unit> onGuildSelected) {
            Intrinsics3.checkNotNullParameter(fragment, "fragment");
            Intrinsics3.checkNotNullParameter(requestKey, "requestKey");
            Intrinsics3.checkNotNullParameter(onGuildSelected, "onGuildSelected");
            Fragment2.setFragmentResultListener(fragment, requestKey, new WidgetGuildSelector3(requestKey, allowNullGuild, onGuildSelected));
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: WidgetGuildSelector.kt */
    public interface FilterFunction extends Serializable {

        /* JADX INFO: compiled from: WidgetGuildSelector.kt */
        public static final class DefaultImpls {
            public static boolean includeGuild(FilterFunction filterFunction, Guild guild) {
                Intrinsics3.checkNotNullParameter(guild, "guild");
                return true;
            }
        }

        boolean includeGuild(Guild guild);
    }

    /* JADX INFO: compiled from: WidgetGuildSelector.kt */
    public static final /* data */ class GuildFilterFunction implements FilterFunction {
        private final Set<Long> guildIds;

        public GuildFilterFunction(Set<Long> set) {
            Intrinsics3.checkNotNullParameter(set, "guildIds");
            this.guildIds = set;
        }

        private final Set<Long> component1() {
            return this.guildIds;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ GuildFilterFunction copy$default(GuildFilterFunction guildFilterFunction, Set set, int i, Object obj) {
            if ((i & 1) != 0) {
                set = guildFilterFunction.guildIds;
            }
            return guildFilterFunction.copy(set);
        }

        public final GuildFilterFunction copy(Set<Long> guildIds) {
            Intrinsics3.checkNotNullParameter(guildIds, "guildIds");
            return new GuildFilterFunction(guildIds);
        }

        public boolean equals(Object other) {
            if (this != other) {
                return (other instanceof GuildFilterFunction) && Intrinsics3.areEqual(this.guildIds, ((GuildFilterFunction) other).guildIds);
            }
            return true;
        }

        public int hashCode() {
            Set<Long> set = this.guildIds;
            if (set != null) {
                return set.hashCode();
            }
            return 0;
        }

        @Override // com.discord.widgets.guilds.WidgetGuildSelector.FilterFunction
        public boolean includeGuild(Guild guild) {
            Intrinsics3.checkNotNullParameter(guild, "guild");
            return this.guildIds.contains(Long.valueOf(guild.getId()));
        }

        public String toString() {
            return outline.N(outline.U("GuildFilterFunction(guildIds="), this.guildIds, ")");
        }
    }

    /* JADX INFO: compiled from: WidgetGuildSelector.kt */
    public static final /* data */ class Item implements MGRecyclerDataPayload {
        private final Guild guild;
        private final String key;
        private final int type = 1;

        public Item(Guild guild) {
            String strValueOf;
            this.guild = guild;
            this.key = (guild == null || (strValueOf = String.valueOf(guild.getId())) == null) ? "" : strValueOf;
        }

        public static /* synthetic */ Item copy$default(Item item, Guild guild, int i, Object obj) {
            if ((i & 1) != 0) {
                guild = item.guild;
            }
            return item.copy(guild);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Guild getGuild() {
            return this.guild;
        }

        public final Item copy(Guild guild) {
            return new Item(guild);
        }

        public boolean equals(Object other) {
            if (this != other) {
                return (other instanceof Item) && Intrinsics3.areEqual(this.guild, ((Item) other).guild);
            }
            return true;
        }

        public final Guild getGuild() {
            return this.guild;
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
            Guild guild = this.guild;
            if (guild != null) {
                return guild.hashCode();
            }
            return 0;
        }

        public String toString() {
            StringBuilder sbU = outline.U("Item(guild=");
            sbU.append(this.guild);
            sbU.append(")");
            return sbU.toString();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.guilds.WidgetGuildSelector$bindSubscriptions$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetGuildSelector.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<List<? extends Item>, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(List<? extends Item> list) {
            invoke2((List<Item>) list);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(List<Item> list) {
            Intrinsics3.checkNotNullParameter(list, "it");
            WidgetGuildSelector.access$getAdapter$p(WidgetGuildSelector.this).setData(list);
        }
    }

    public WidgetGuildSelector() {
        super(false, 1, null);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetGuildSelector4.INSTANCE, null, 2, null);
        this.requestKey = LazyJVM.lazy(new WidgetGuildSelector5(this));
    }

    public static final /* synthetic */ Adapter access$getAdapter$p(WidgetGuildSelector widgetGuildSelector) {
        Adapter adapter = widgetGuildSelector.adapter;
        if (adapter == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("adapter");
        }
        return adapter;
    }

    private final Observable<List<Item>> get(final boolean includeNoGuild, final FilterFunction filterFunction) {
        Observable<R> observableG = StoreStream.INSTANCE.getGuildsSorted().observeOrderedGuilds().G(new Func1<LinkedHashMap<Long, Guild>, List<? extends Item>>() { // from class: com.discord.widgets.guilds.WidgetGuildSelector.get.1
            @Override // j0.k.Func1
            public final List<Item> call(LinkedHashMap<Long, Guild> linkedHashMap) {
                Collection<Guild> collectionValues = linkedHashMap.values();
                Intrinsics3.checkNotNullExpressionValue(collectionValues, "guilds.values");
                FilterFunction filterFunction2 = filterFunction;
                ArrayList arrayList = new ArrayList();
                for (T t : collectionValues) {
                    if (filterFunction2.includeGuild((Guild) t)) {
                        arrayList.add(t);
                    }
                }
                List listListOf = includeNoGuild ? CollectionsJVM.listOf(new Item(null)) : Collections2.emptyList();
                ArrayList arrayList2 = new ArrayList(Iterables2.collectionSizeOrDefault(arrayList, 10));
                Iterator<T> it = arrayList.iterator();
                while (it.hasNext()) {
                    arrayList2.add(new Item((Guild) it.next()));
                }
                return _Collections.plus((Collection) listListOf, (Iterable) arrayList2);
            }
        });
        Intrinsics3.checkNotNullExpressionValue(observableG, "StoreStream.getGuildsSor….map { Item(it) }\n      }");
        Observable<List<Item>> observableR = ObservableExtensionsKt.computationLatest(observableG).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "StoreStream.getGuildsSor…  .distinctUntilChanged()");
        return observableR;
    }

    private final WidgetGuildSelectorBinding getBinding() {
        return (WidgetGuildSelectorBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final String getRequestKey() {
        return (String) this.requestKey.getValue();
    }

    private final void onGuildSelected(Guild guild) {
        String requestKey = getRequestKey();
        Intrinsics3.checkNotNullExpressionValue(requestKey, "requestKey");
        Bundle bundle = new Bundle();
        bundle.putLong("INTENT_EXTRA_GUILD_ID", guild != null ? guild.getId() : -1L);
        bundle.putString(RESULT_EXTRA_GUILD_NAME, guild != null ? guild.getName() : null);
        Fragment2.setFragmentResult(this, requestKey, bundle);
        dismiss();
    }

    @Override // com.discord.app.AppBottomSheet
    public void bindSubscriptions(CompositeSubscription compositeSubscription) {
        Intrinsics3.checkNotNullParameter(compositeSubscription, "compositeSubscription");
        super.bindSubscriptions(compositeSubscription);
        boolean z2 = getArgumentsOrDefault().getBoolean(ARG_INCLUDE_NO_GUILD, false);
        Serializable serializable = getArgumentsOrDefault().getSerializable(ARG_FILTER_FUNCTION);
        if (!(serializable instanceof FilterFunction)) {
            serializable = null;
        }
        FilterFunction baseFilterFunction = (FilterFunction) serializable;
        if (baseFilterFunction == null) {
            baseFilterFunction = new BaseFilterFunction();
        }
        Observable<List<Item>> observable = get(z2, baseFilterFunction);
        Adapter adapter = this.adapter;
        if (adapter == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("adapter");
        }
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui(observable, this, adapter), (Class<?>) WidgetGuildSelector.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass1());
    }

    @Override // com.discord.app.AppBottomSheet
    public int getContentViewResId() {
        return R.layout.widget_guild_selector;
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        MGRecyclerAdapter.Companion companion = MGRecyclerAdapter.INSTANCE;
        RecyclerView recyclerView = getBinding().f2451b;
        Intrinsics3.checkNotNullExpressionValue(recyclerView, "binding.guildSelectorList");
        this.adapter = (Adapter) companion.configure(new Adapter(recyclerView, this, getArgumentsOrDefault().getInt(ARG_NO_GUILD_STRING_ID)));
    }
}
