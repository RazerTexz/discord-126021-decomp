package com.discord.widgets.guilds;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.LayoutRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentKt;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.C5419R;
import com.discord.app.AppBottomSheet;
import com.discord.databinding.WidgetGuildSelectorBinding;
import com.discord.databinding.WidgetGuildSelectorItemBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.guild.Guild;
import com.discord.stores.StoreStream;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.error.Error;
import com.discord.utilities.extensions.SimpleDraweeViewExtensionsKt;
import com.discord.utilities.mg_recycler.MGRecyclerAdapter;
import com.discord.utilities.mg_recycler.MGRecyclerAdapterSimple;
import com.discord.utilities.mg_recycler.MGRecyclerDataPayload;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.widgets.guilds.WidgetGuildSelector;
import com.facebook.drawee.view.SimpleDraweeView;
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
import p007b.p008a.p027k.C1107b;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.C12083g;
import p507d0.p580t.C12145m;
import p507d0.p580t.C12147n;
import p507d0.p580t.C12149o;
import p507d0.p580t.C12163u;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;
import p637j0.p641k.InterfaceC12589b;
import p658rx.Observable;
import p658rx.Subscription;
import p658rx.subscriptions.CompositeSubscription;

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
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {C1643a.m846d0(WidgetGuildSelector.class, "binding", "getBinding()Lcom/discord/databinding/WidgetGuildSelectorBinding;", 0)};

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
                C12238m.checkNotNullParameter(adapter, "adapter");
                this.noGuildStringId = i2;
                View view = this.itemView;
                int i3 = C5419R.id.item_avatar_wrap;
                FrameLayout frameLayout = (FrameLayout) view.findViewById(C5419R.id.item_avatar_wrap);
                if (frameLayout != null) {
                    i3 = C5419R.id.item_icon;
                    SimpleDraweeView simpleDraweeView = (SimpleDraweeView) view.findViewById(C5419R.id.item_icon);
                    if (simpleDraweeView != null) {
                        i3 = C5419R.id.item_name;
                        TextView textView = (TextView) view.findViewById(C5419R.id.item_name);
                        if (textView != null) {
                            i3 = C5419R.id.item_text;
                            TextView textView2 = (TextView) view.findViewById(C5419R.id.item_text);
                            if (textView2 != null) {
                                WidgetGuildSelectorItemBinding widgetGuildSelectorItemBinding = new WidgetGuildSelectorItemBinding((LinearLayout) view, frameLayout, simpleDraweeView, textView, textView2);
                                C12238m.checkNotNullExpressionValue(widgetGuildSelectorItemBinding, "WidgetGuildSelectorItemBinding.bind(itemView)");
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
                CharSequence charSequenceM212d;
                Guild guild;
                String icon;
                C12238m.checkNotNullParameter(data, "data");
                super.onConfigure(position, data);
                this.binding.f17052a.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.guilds.WidgetGuildSelector$Adapter$ItemGuild$onConfigure$1
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        WidgetGuildSelector.Adapter.ItemGuild.access$getAdapter$p(this.this$0).dialog.onGuildSelected(data.getGuild());
                    }
                });
                TextView textView = this.binding.f17055d;
                C12238m.checkNotNullExpressionValue(textView, "binding.itemName");
                Guild guild2 = data.getGuild();
                boolean z2 = false;
                String shortName = null;
                if (guild2 == null || (charSequenceM212d = guild2.getName()) == null) {
                    TextView textView2 = this.binding.f17055d;
                    C12238m.checkNotNullExpressionValue(textView2, "binding.itemName");
                    charSequenceM212d = C1107b.m212d(textView2, this.noGuildStringId, new Object[0], (4 & 4) != 0 ? C1107b.c.f1492j : null);
                }
                textView.setText(charSequenceM212d);
                Guild guild3 = data.getGuild();
                if (guild3 != null && (icon = guild3.getIcon()) != null) {
                    if (icon.length() > 0) {
                        z2 = true;
                    }
                }
                SimpleDraweeView simpleDraweeView = this.binding.f17054c;
                C12238m.checkNotNullExpressionValue(simpleDraweeView, "binding.itemIcon");
                Guild guild4 = data.getGuild();
                View view = this.itemView;
                C12238m.checkNotNullExpressionValue(view, "itemView");
                Integer numValueOf = Integer.valueOf(ColorCompat.getThemedColor(view, C5419R.attr.colorBackgroundPrimary));
                SimpleDraweeView simpleDraweeView2 = this.binding.f17054c;
                C12238m.checkNotNullExpressionValue(simpleDraweeView2, "binding.itemIcon");
                SimpleDraweeViewExtensionsKt.setGuildIcon(simpleDraweeView, false, (496 & 2) != 0 ? null : guild4, simpleDraweeView2.getResources().getDimensionPixelSize(C5419R.dimen.guild_icon_radius), (496 & 8) != 0 ? null : null, (496 & 16) != 0 ? null : numValueOf, (496 & 32) != 0 ? null : null, (496 & 64) != 0 ? null : null, (496 & 128) != 0 ? false : true, (496 & 256) != 0 ? null : null);
                FrameLayout frameLayout = this.binding.f17053b;
                C12238m.checkNotNullExpressionValue(frameLayout, "binding.itemAvatarWrap");
                frameLayout.setClipToOutline(true);
                TextView textView3 = this.binding.f17056e;
                C12238m.checkNotNullExpressionValue(textView3, "binding.itemText");
                if (!z2 && (guild = data.getGuild()) != null) {
                    shortName = guild.getShortName();
                }
                textView3.setText(shortName);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Adapter(RecyclerView recyclerView, WidgetGuildSelector widgetGuildSelector, int i) {
            super(recyclerView, false, 2, null);
            C12238m.checkNotNullParameter(recyclerView, "recycler");
            C12238m.checkNotNullParameter(widgetGuildSelector, "dialog");
            this.dialog = widgetGuildSelector;
            this.noGuildStringId = i;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public ItemGuild onCreateViewHolder(ViewGroup parent, int viewType) {
            C12238m.checkNotNullParameter(parent, "parent");
            return new ItemGuild(C5419R.layout.widget_guild_selector_item, this, this.noGuildStringId);
        }
    }

    /* JADX INFO: compiled from: WidgetGuildSelector.kt */
    public static final class BaseFilterFunction implements FilterFunction {
        @Override // com.discord.widgets.guilds.WidgetGuildSelector.FilterFunction
        public boolean includeGuild(Guild guild) {
            C12238m.checkNotNullParameter(guild, "guild");
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
            int i3 = (i2 & 8) != 0 ? C5419R.string.none : i;
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
            C12238m.checkNotNullParameter(fragment, "fragment");
            C12238m.checkNotNullParameter(requestKey, "requestKey");
            WidgetGuildSelector widgetGuildSelector = new WidgetGuildSelector();
            Bundle bundle = new Bundle();
            bundle.putString(WidgetGuildSelector.ARG_REQUEST_KEY, requestKey);
            bundle.putBoolean(WidgetGuildSelector.ARG_INCLUDE_NO_GUILD, includeNoGuild);
            bundle.putInt(WidgetGuildSelector.ARG_NO_GUILD_STRING_ID, noGuildStringId);
            bundle.putSerializable(WidgetGuildSelector.ARG_FILTER_FUNCTION, filterFunction);
            widgetGuildSelector.setArguments(bundle);
            FragmentManager parentFragmentManager = fragment.getParentFragmentManager();
            C12238m.checkNotNullExpressionValue(parentFragmentManager, "fragment.parentFragmentManager");
            widgetGuildSelector.show(parentFragmentManager, WidgetGuildSelector.class.getName());
        }

        public final void registerForResult(Fragment fragment, String requestKey, boolean allowNullGuild, Function2<? super Long, ? super String, Unit> onGuildSelected) {
            C12238m.checkNotNullParameter(fragment, "fragment");
            C12238m.checkNotNullParameter(requestKey, "requestKey");
            C12238m.checkNotNullParameter(onGuildSelected, "onGuildSelected");
            FragmentKt.setFragmentResultListener(fragment, requestKey, new WidgetGuildSelector$Companion$registerForResult$1(requestKey, allowNullGuild, onGuildSelected));
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
                C12238m.checkNotNullParameter(guild, "guild");
                return true;
            }
        }

        boolean includeGuild(Guild guild);
    }

    /* JADX INFO: compiled from: WidgetGuildSelector.kt */
    public static final /* data */ class GuildFilterFunction implements FilterFunction {
        private final Set<Long> guildIds;

        public GuildFilterFunction(Set<Long> set) {
            C12238m.checkNotNullParameter(set, "guildIds");
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
            C12238m.checkNotNullParameter(guildIds, "guildIds");
            return new GuildFilterFunction(guildIds);
        }

        public boolean equals(Object other) {
            if (this != other) {
                return (other instanceof GuildFilterFunction) && C12238m.areEqual(this.guildIds, ((GuildFilterFunction) other).guildIds);
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
            C12238m.checkNotNullParameter(guild, "guild");
            return this.guildIds.contains(Long.valueOf(guild.getId()));
        }

        public String toString() {
            return C1643a.m826N(C1643a.m833U("GuildFilterFunction(guildIds="), this.guildIds, ")");
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
                return (other instanceof Item) && C12238m.areEqual(this.guild, ((Item) other).guild);
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
            StringBuilder sbM833U = C1643a.m833U("Item(guild=");
            sbM833U.append(this.guild);
            sbM833U.append(")");
            return sbM833U.toString();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.guilds.WidgetGuildSelector$bindSubscriptions$1 */
    /* JADX INFO: compiled from: WidgetGuildSelector.kt */
    public static final class C85811 extends AbstractC12240o implements Function1<List<? extends Item>, Unit> {
        public C85811() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(List<? extends Item> list) {
            invoke2((List<Item>) list);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(List<Item> list) {
            C12238m.checkNotNullParameter(list, "it");
            WidgetGuildSelector.access$getAdapter$p(WidgetGuildSelector.this).setData(list);
        }
    }

    public WidgetGuildSelector() {
        super(false, 1, null);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetGuildSelector$binding$2.INSTANCE, null, 2, null);
        this.requestKey = C12083g.lazy(new WidgetGuildSelector$requestKey$2(this));
    }

    public static final /* synthetic */ Adapter access$getAdapter$p(WidgetGuildSelector widgetGuildSelector) {
        Adapter adapter = widgetGuildSelector.adapter;
        if (adapter == null) {
            C12238m.throwUninitializedPropertyAccessException("adapter");
        }
        return adapter;
    }

    private final Observable<List<Item>> get(final boolean includeNoGuild, final FilterFunction filterFunction) {
        Observable<R> observableM11083G = StoreStream.INSTANCE.getGuildsSorted().observeOrderedGuilds().m11083G(new InterfaceC12589b<LinkedHashMap<Long, Guild>, List<? extends Item>>() { // from class: com.discord.widgets.guilds.WidgetGuildSelector.get.1
            @Override // p637j0.p641k.InterfaceC12589b
            public final List<Item> call(LinkedHashMap<Long, Guild> linkedHashMap) {
                Collection<Guild> collectionValues = linkedHashMap.values();
                C12238m.checkNotNullExpressionValue(collectionValues, "guilds.values");
                FilterFunction filterFunction2 = filterFunction;
                ArrayList arrayList = new ArrayList();
                for (T t : collectionValues) {
                    if (filterFunction2.includeGuild((Guild) t)) {
                        arrayList.add(t);
                    }
                }
                List listListOf = includeNoGuild ? C12145m.listOf(new Item(null)) : C12147n.emptyList();
                ArrayList arrayList2 = new ArrayList(C12149o.collectionSizeOrDefault(arrayList, 10));
                Iterator<T> it = arrayList.iterator();
                while (it.hasNext()) {
                    arrayList2.add(new Item((Guild) it.next()));
                }
                return C12163u.plus((Collection) listListOf, (Iterable) arrayList2);
            }
        });
        C12238m.checkNotNullExpressionValue(observableM11083G, "StoreStream.getGuildsSor….map { Item(it) }\n      }");
        Observable<List<Item>> observableM11112r = ObservableExtensionsKt.computationLatest(observableM11083G).m11112r();
        C12238m.checkNotNullExpressionValue(observableM11112r, "StoreStream.getGuildsSor…  .distinctUntilChanged()");
        return observableM11112r;
    }

    private final WidgetGuildSelectorBinding getBinding() {
        return (WidgetGuildSelectorBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final String getRequestKey() {
        return (String) this.requestKey.getValue();
    }

    private final void onGuildSelected(Guild guild) {
        String requestKey = getRequestKey();
        C12238m.checkNotNullExpressionValue(requestKey, "requestKey");
        Bundle bundle = new Bundle();
        bundle.putLong("INTENT_EXTRA_GUILD_ID", guild != null ? guild.getId() : -1L);
        bundle.putString(RESULT_EXTRA_GUILD_NAME, guild != null ? guild.getName() : null);
        FragmentKt.setFragmentResult(this, requestKey, bundle);
        dismiss();
    }

    @Override // com.discord.app.AppBottomSheet
    public void bindSubscriptions(CompositeSubscription compositeSubscription) {
        C12238m.checkNotNullParameter(compositeSubscription, "compositeSubscription");
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
            C12238m.throwUninitializedPropertyAccessException("adapter");
        }
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.m8519ui(observable, this, adapter), (Class<?>) WidgetGuildSelector.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C85811());
    }

    @Override // com.discord.app.AppBottomSheet
    public int getContentViewResId() {
        return C5419R.layout.widget_guild_selector;
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        C12238m.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        MGRecyclerAdapter.Companion companion = MGRecyclerAdapter.INSTANCE;
        RecyclerView recyclerView = getBinding().f17051b;
        C12238m.checkNotNullExpressionValue(recyclerView, "binding.guildSelectorList");
        this.adapter = (Adapter) companion.configure(new Adapter(recyclerView, this, getArgumentsOrDefault().getInt(ARG_NO_GUILD_STRING_ID)));
    }
}
