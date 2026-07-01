package com.discord.widgets.channels;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.LayoutRes;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.Fragment2;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;
import b.a.k.FormatUtils;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.app.AppBottomSheet;
import com.discord.databinding.WidgetChannelSelectorBinding;
import com.discord.databinding.WidgetChannelSelectorItemBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.stores.StoreChannels;
import com.discord.stores.StoreStream;
import com.discord.utilities.drawable.DrawableCompat;
import com.discord.utilities.error.Error;
import com.discord.utilities.mg_recycler.MGRecyclerAdapter;
import com.discord.utilities.mg_recycler.MGRecyclerAdapterSimple;
import com.discord.utilities.mg_recycler.MGRecyclerDataPayload;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.widgets.channels.WidgetChannelSelector;
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
import java.util.List;
import java.util.Map;
import java.util.Objects;
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

/* JADX INFO: compiled from: WidgetChannelSelector.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelSelector extends AppBottomSheet {
    private static final String ARG_FILTER_FUNCTION = "INTENT_EXTRA_FILTER_FUNCTION";
    private static final String ARG_GUILD_ID = "INTENT_EXTRA_GUILD_ID";
    private static final String ARG_INCLUDE_NO_CHANNEL = "INTENT_EXTRA_INCLUDE_NO_CHANNEL";
    private static final String ARG_NO_CHANNEL_STRING_ID = "INTENT_EXTRA_NO_CHANNEL_STRING_ID";
    private static final String ARG_REQUEST_KEY = "INTENT_EXTRA_REQUEST_CODE";
    private static final String RESULT_EXTRA_CHANNEL_ID = "INTENT_EXTRA_CHANNEL_ID";
    private static final String RESULT_EXTRA_CHANNEL_NAME = "INTENT_EXTRA_CHANNEL_NAME";
    private Adapter adapter;

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* JADX INFO: renamed from: requestCode$delegate, reason: from kotlin metadata */
    private final Lazy requestCode;
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetChannelSelector.class, "binding", "getBinding()Lcom/discord/databinding/WidgetChannelSelectorBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: compiled from: WidgetChannelSelector.kt */
    public static final class Adapter extends MGRecyclerAdapterSimple<Model.Item> {
        private final WidgetChannelSelector dialog;
        private final int noChannelStringId;

        /* JADX INFO: compiled from: WidgetChannelSelector.kt */
        public static final class ItemChannel extends MGRecyclerViewHolder<Adapter, Model.Item> {
            private final WidgetChannelSelectorItemBinding binding;
            private final int noChannelStringId;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ItemChannel(@LayoutRes int i, Adapter adapter, int i2) {
                super(i, adapter);
                Intrinsics3.checkNotNullParameter(adapter, "adapter");
                this.noChannelStringId = i2;
                View view = this.itemView;
                Objects.requireNonNull(view, "rootView");
                TextView textView = (TextView) view;
                WidgetChannelSelectorItemBinding widgetChannelSelectorItemBinding = new WidgetChannelSelectorItemBinding(textView, textView);
                Intrinsics3.checkNotNullExpressionValue(widgetChannelSelectorItemBinding, "WidgetChannelSelectorItemBinding.bind(itemView)");
                this.binding = widgetChannelSelectorItemBinding;
            }

            public static final /* synthetic */ Adapter access$getAdapter$p(ItemChannel itemChannel) {
                return (Adapter) itemChannel.adapter;
            }

            public final int getNoChannelStringId() {
                return this.noChannelStringId;
            }

            @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
            public void onConfigure(int position, final Model.Item data) {
                CharSequence charSequenceD;
                int i;
                Intrinsics3.checkNotNullParameter(data, "data");
                super.onConfigure(position, data);
                this.binding.a.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.channels.WidgetChannelSelector$Adapter$ItemChannel$onConfigure$1
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        WidgetChannelSelector.Adapter.ItemChannel.access$getAdapter$p(this.this$0).dialog.onChannelSelected(data.getChannel());
                    }
                });
                TextView textView = this.binding.f2268b;
                Intrinsics3.checkNotNullExpressionValue(textView, "binding.itemName");
                Channel channel = data.getChannel();
                if (channel != null) {
                    charSequenceD = ChannelUtils.c(channel);
                } else {
                    TextView textView2 = this.binding.f2268b;
                    Intrinsics3.checkNotNullExpressionValue(textView2, "binding.itemName");
                    charSequenceD = FormatUtils.d(textView2, this.noChannelStringId, new Object[0], (4 & 4) != 0 ? FormatUtils.c.j : null);
                }
                textView.setText(charSequenceD);
                View view = this.itemView;
                Intrinsics3.checkNotNullExpressionValue(view, "itemView");
                Channel channel2 = data.getChannel();
                Integer numValueOf = channel2 != null ? Integer.valueOf(channel2.getType()) : null;
                if (numValueOf != null && numValueOf.intValue() == 2) {
                    i = R.attr.ic_volume_up;
                } else if (numValueOf != null && numValueOf.intValue() == 13) {
                    i = R.attr.ic_channel_stage;
                } else {
                    i = (numValueOf != null && numValueOf.intValue() == 0) ? R.attr.ic_channel_text : 0;
                }
                int themedDrawableRes$default = DrawableCompat.getThemedDrawableRes$default(view, i, 0, 2, (Object) null);
                TextView textView3 = this.binding.f2268b;
                Intrinsics3.checkNotNullExpressionValue(textView3, "binding.itemName");
                DrawableCompat.setCompoundDrawablesCompat$default(textView3, themedDrawableRes$default, 0, 0, 0, 14, (Object) null);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Adapter(RecyclerView recyclerView, WidgetChannelSelector widgetChannelSelector, int i) {
            super(recyclerView, false, 2, null);
            Intrinsics3.checkNotNullParameter(recyclerView, "recycler");
            Intrinsics3.checkNotNullParameter(widgetChannelSelector, "dialog");
            this.dialog = widgetChannelSelector;
            this.noChannelStringId = i;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public ItemChannel onCreateViewHolder(ViewGroup parent, int viewType) {
            Intrinsics3.checkNotNullParameter(parent, "parent");
            return new ItemChannel(R.layout.widget_channel_selector_item, this, this.noChannelStringId);
        }
    }

    /* JADX INFO: compiled from: WidgetChannelSelector.kt */
    public static final class BaseFilterFunction implements FilterFunction {
        @Override // com.discord.widgets.channels.WidgetChannelSelector.FilterFunction
        public boolean includeChannel(Channel channel) {
            Intrinsics3.checkNotNullParameter(channel, "channel");
            return FilterFunction.DefaultImpls.includeChannel(this, channel);
        }
    }

    /* JADX INFO: compiled from: WidgetChannelSelector.kt */
    public static final class Companion {
        private Companion() {
        }

        public static /* synthetic */ void registerForResult$default(Companion companion, Fragment fragment, String str, boolean z2, Function2 function2, int i, Object obj) {
            if ((i & 4) != 0) {
                z2 = false;
            }
            companion.registerForResult(fragment, str, z2, function2);
        }

        public final void launch(Fragment fragment, long guildId, String requestKey, boolean includeNoChannel, int noChannelStringId, FilterFunction filterFunction) {
            Intrinsics3.checkNotNullParameter(fragment, "fragment");
            Intrinsics3.checkNotNullParameter(requestKey, "requestKey");
            WidgetChannelSelector widgetChannelSelector = new WidgetChannelSelector();
            Bundle bundle = new Bundle();
            bundle.putString(WidgetChannelSelector.ARG_REQUEST_KEY, requestKey);
            bundle.putLong("INTENT_EXTRA_GUILD_ID", guildId);
            bundle.putBoolean(WidgetChannelSelector.ARG_INCLUDE_NO_CHANNEL, includeNoChannel);
            bundle.putInt(WidgetChannelSelector.ARG_NO_CHANNEL_STRING_ID, noChannelStringId);
            bundle.putSerializable(WidgetChannelSelector.ARG_FILTER_FUNCTION, filterFunction);
            widgetChannelSelector.setArguments(bundle);
            FragmentManager parentFragmentManager = fragment.getParentFragmentManager();
            Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "fragment.parentFragmentManager");
            widgetChannelSelector.show(parentFragmentManager, WidgetChannelSelector.class.getName());
        }

        public final void launchForInactiveStages(Fragment fragment, long guildId, String requestKey, boolean includeNoChannel, int noChannelStringId) {
            Intrinsics3.checkNotNullParameter(fragment, "fragment");
            Intrinsics3.checkNotNullParameter(requestKey, "requestKey");
            launch(fragment, guildId, requestKey, includeNoChannel, noChannelStringId, InactiveStageChannelFilterFunction.INSTANCE);
        }

        public final void launchForText(Fragment fragment, long guildId, String requestKey, boolean includeNoChannel, int noChannelStringId) {
            Intrinsics3.checkNotNullParameter(fragment, "fragment");
            Intrinsics3.checkNotNullParameter(requestKey, "requestKey");
            launch(fragment, guildId, requestKey, includeNoChannel, noChannelStringId, new TypeFilterFunction(0));
        }

        public final void launchForVocal(Fragment fragment, long guildId, String requestKey, boolean includeNoChannel, int noChannelStringId) {
            Intrinsics3.checkNotNullParameter(fragment, "fragment");
            Intrinsics3.checkNotNullParameter(requestKey, "requestKey");
            launch(fragment, guildId, requestKey, includeNoChannel, noChannelStringId, VocalChannelFilterFunction.INSTANCE);
        }

        public final void launchForVoice(Fragment fragment, long guildId, String requestKey, boolean includeNoChannel, int noChannelStringId) {
            Intrinsics3.checkNotNullParameter(fragment, "fragment");
            Intrinsics3.checkNotNullParameter(requestKey, "requestKey");
            launch(fragment, guildId, requestKey, includeNoChannel, noChannelStringId, new TypeFilterFunction(2));
        }

        public final void registerForResult(Fragment fragment, String requestKey, boolean allowNullChannel, Function2<? super Long, ? super String, Unit> onChannelSelected) {
            Intrinsics3.checkNotNullParameter(fragment, "fragment");
            Intrinsics3.checkNotNullParameter(requestKey, "requestKey");
            Intrinsics3.checkNotNullParameter(onChannelSelected, "onChannelSelected");
            Fragment2.setFragmentResultListener(fragment, requestKey, new WidgetChannelSelector3(requestKey, allowNullChannel, onChannelSelected));
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: WidgetChannelSelector.kt */
    public interface FilterFunction extends Serializable {

        /* JADX INFO: compiled from: WidgetChannelSelector.kt */
        public static final class DefaultImpls {
            public static boolean includeChannel(FilterFunction filterFunction, Channel channel) {
                Intrinsics3.checkNotNullParameter(channel, "channel");
                return true;
            }
        }

        boolean includeChannel(Channel channel);
    }

    /* JADX INFO: compiled from: WidgetChannelSelector.kt */
    public static final class InactiveStageChannelFilterFunction implements FilterFunction {
        public static final InactiveStageChannelFilterFunction INSTANCE = new InactiveStageChannelFilterFunction();

        private InactiveStageChannelFilterFunction() {
        }

        @Override // com.discord.widgets.channels.WidgetChannelSelector.FilterFunction
        public boolean includeChannel(Channel channel) {
            Intrinsics3.checkNotNullParameter(channel, "channel");
            return ChannelUtils.D(channel) && StoreStream.INSTANCE.getStageInstances().getStageInstanceForChannel(channel.getId()) == null;
        }
    }

    /* JADX INFO: compiled from: WidgetChannelSelector.kt */
    public static final class Model {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);

        /* JADX INFO: compiled from: WidgetChannelSelector.kt */
        public static final class Companion {
            private Companion() {
            }

            public final Observable<List<Item>> get(long guildId, final boolean includeNoChannel, final FilterFunction filterFunction) {
                Intrinsics3.checkNotNullParameter(filterFunction, "filterFunction");
                Observable observableG = StoreChannels.observeChannelsForGuild$default(StoreStream.INSTANCE.getChannels(), guildId, null, 2, null).G(new Func1<Map<Long, ? extends Channel>, List<? extends Item>>() { // from class: com.discord.widgets.channels.WidgetChannelSelector$Model$Companion$get$1
                    @Override // j0.k.Func1
                    public /* bridge */ /* synthetic */ List<? extends WidgetChannelSelector.Model.Item> call(Map<Long, ? extends Channel> map) {
                        return call2((Map<Long, Channel>) map);
                    }

                    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
                    public final List<WidgetChannelSelector.Model.Item> call2(Map<Long, Channel> map) {
                        Collection<Channel> collectionValues = map.values();
                        WidgetChannelSelector.FilterFunction filterFunction2 = filterFunction;
                        ArrayList arrayList = new ArrayList();
                        for (T t : collectionValues) {
                            if (filterFunction2.includeChannel((Channel) t)) {
                                arrayList.add(t);
                            }
                        }
                        List listListOf = includeNoChannel ? CollectionsJVM.listOf(new WidgetChannelSelector.Model.Item(null, 0, null, 6, null)) : Collections2.emptyList();
                        List listSortedWith = _Collections.sortedWith(arrayList, ChannelUtils.h(Channel.INSTANCE));
                        ArrayList arrayList2 = new ArrayList(Iterables2.collectionSizeOrDefault(listSortedWith, 10));
                        Iterator<T> it = listSortedWith.iterator();
                        while (it.hasNext()) {
                            arrayList2.add(new WidgetChannelSelector.Model.Item((Channel) it.next(), 0, null, 6, null));
                        }
                        return _Collections.plus((Collection) listListOf, (Iterable) arrayList2);
                    }
                });
                Intrinsics3.checkNotNullExpressionValue(observableG, "StoreStream.getChannels(… { Item(it) }\n          }");
                Observable<List<Item>> observableR = ObservableExtensionsKt.computationLatest(observableG).r();
                Intrinsics3.checkNotNullExpressionValue(observableR, "StoreStream.getChannels(…  .distinctUntilChanged()");
                return observableR;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        /* JADX INFO: compiled from: WidgetChannelSelector.kt */
        public static final /* data */ class Item implements MGRecyclerDataPayload {
            private final Channel channel;
            private final String key;
            private final int type;

            public Item(Channel channel, int i, String str) {
                Intrinsics3.checkNotNullParameter(str, "key");
                this.channel = channel;
                this.type = i;
                this.key = str;
            }

            public static /* synthetic */ Item copy$default(Item item, Channel channel, int i, String str, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    channel = item.channel;
                }
                if ((i2 & 2) != 0) {
                    i = item.getType();
                }
                if ((i2 & 4) != 0) {
                    str = item.getKey();
                }
                return item.copy(channel, i, str);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final Channel getChannel() {
                return this.channel;
            }

            public final int component2() {
                return getType();
            }

            public final String component3() {
                return getKey();
            }

            public final Item copy(Channel channel, int type, String key) {
                Intrinsics3.checkNotNullParameter(key, "key");
                return new Item(channel, type, key);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Item)) {
                    return false;
                }
                Item item = (Item) other;
                return Intrinsics3.areEqual(this.channel, item.channel) && getType() == item.getType() && Intrinsics3.areEqual(getKey(), item.getKey());
            }

            public final Channel getChannel() {
                return this.channel;
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
                Channel channel = this.channel;
                int type = (getType() + ((channel != null ? channel.hashCode() : 0) * 31)) * 31;
                String key = getKey();
                return type + (key != null ? key.hashCode() : 0);
            }

            public String toString() {
                StringBuilder sbU = outline.U("Item(channel=");
                sbU.append(this.channel);
                sbU.append(", type=");
                sbU.append(getType());
                sbU.append(", key=");
                sbU.append(getKey());
                sbU.append(")");
                return sbU.toString();
            }

            /* JADX WARN: Illegal instructions before constructor call */
            public /* synthetic */ Item(Channel channel, int i, String str, int i2, DefaultConstructorMarker defaultConstructorMarker) {
                i = (i2 & 2) != 0 ? channel != null ? channel.getType() : -1 : i;
                if ((i2 & 4) != 0 && (channel == null || (str = String.valueOf(channel.getId())) == null)) {
                    str = "";
                }
                this(channel, i, str);
            }
        }
    }

    /* JADX INFO: compiled from: WidgetChannelSelector.kt */
    public static final /* data */ class SetFilterFunction implements FilterFunction {
        private final Set<Long> channelIds;

        public SetFilterFunction(Set<Long> set) {
            Intrinsics3.checkNotNullParameter(set, "channelIds");
            this.channelIds = set;
        }

        private final Set<Long> component1() {
            return this.channelIds;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ SetFilterFunction copy$default(SetFilterFunction setFilterFunction, Set set, int i, Object obj) {
            if ((i & 1) != 0) {
                set = setFilterFunction.channelIds;
            }
            return setFilterFunction.copy(set);
        }

        public final SetFilterFunction copy(Set<Long> channelIds) {
            Intrinsics3.checkNotNullParameter(channelIds, "channelIds");
            return new SetFilterFunction(channelIds);
        }

        public boolean equals(Object other) {
            if (this != other) {
                return (other instanceof SetFilterFunction) && Intrinsics3.areEqual(this.channelIds, ((SetFilterFunction) other).channelIds);
            }
            return true;
        }

        public int hashCode() {
            Set<Long> set = this.channelIds;
            if (set != null) {
                return set.hashCode();
            }
            return 0;
        }

        @Override // com.discord.widgets.channels.WidgetChannelSelector.FilterFunction
        public boolean includeChannel(Channel channel) {
            Intrinsics3.checkNotNullParameter(channel, "channel");
            return this.channelIds.contains(Long.valueOf(channel.getId()));
        }

        public String toString() {
            return outline.N(outline.U("SetFilterFunction(channelIds="), this.channelIds, ")");
        }
    }

    /* JADX INFO: compiled from: WidgetChannelSelector.kt */
    public static final /* data */ class TypeFilterFunction implements FilterFunction {
        private final int type;

        public TypeFilterFunction(int i) {
            this.type = i;
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        private final int getType() {
            return this.type;
        }

        public static /* synthetic */ TypeFilterFunction copy$default(TypeFilterFunction typeFilterFunction, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = typeFilterFunction.type;
            }
            return typeFilterFunction.copy(i);
        }

        public final TypeFilterFunction copy(int type) {
            return new TypeFilterFunction(type);
        }

        public boolean equals(Object other) {
            if (this != other) {
                return (other instanceof TypeFilterFunction) && this.type == ((TypeFilterFunction) other).type;
            }
            return true;
        }

        public int hashCode() {
            return this.type;
        }

        @Override // com.discord.widgets.channels.WidgetChannelSelector.FilterFunction
        public boolean includeChannel(Channel channel) {
            Intrinsics3.checkNotNullParameter(channel, "channel");
            return this.type == channel.getType();
        }

        public String toString() {
            return outline.B(outline.U("TypeFilterFunction(type="), this.type, ")");
        }
    }

    /* JADX INFO: compiled from: WidgetChannelSelector.kt */
    public static final class VocalChannelFilterFunction implements FilterFunction {
        public static final VocalChannelFilterFunction INSTANCE = new VocalChannelFilterFunction();

        private VocalChannelFilterFunction() {
        }

        @Override // com.discord.widgets.channels.WidgetChannelSelector.FilterFunction
        public boolean includeChannel(Channel channel) {
            Intrinsics3.checkNotNullParameter(channel, "channel");
            return ChannelUtils.w(channel);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.channels.WidgetChannelSelector$bindSubscriptions$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetChannelSelector.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<List<? extends Model.Item>, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(List<? extends Model.Item> list) {
            invoke2((List<Model.Item>) list);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(List<Model.Item> list) {
            Intrinsics3.checkNotNullParameter(list, "it");
            WidgetChannelSelector.access$getAdapter$p(WidgetChannelSelector.this).setData(list);
        }
    }

    public WidgetChannelSelector() {
        super(false, 1, null);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetChannelSelector5.INSTANCE, null, 2, null);
        this.requestCode = LazyJVM.lazy(new WidgetChannelSelector6(this));
    }

    public static final /* synthetic */ Adapter access$getAdapter$p(WidgetChannelSelector widgetChannelSelector) {
        Adapter adapter = widgetChannelSelector.adapter;
        if (adapter == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("adapter");
        }
        return adapter;
    }

    private final WidgetChannelSelectorBinding getBinding() {
        return (WidgetChannelSelectorBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final String getRequestCode() {
        return (String) this.requestCode.getValue();
    }

    private final void onChannelSelected(Channel channel) {
        String requestCode = getRequestCode();
        Bundle bundle = new Bundle();
        bundle.putLong(RESULT_EXTRA_CHANNEL_ID, channel != null ? channel.getId() : -1L);
        bundle.putString(RESULT_EXTRA_CHANNEL_NAME, channel != null ? ChannelUtils.c(channel) : null);
        Fragment2.setFragmentResult(this, requestCode, bundle);
        dismiss();
    }

    @Override // com.discord.app.AppBottomSheet
    public void bindSubscriptions(CompositeSubscription compositeSubscription) {
        Intrinsics3.checkNotNullParameter(compositeSubscription, "compositeSubscription");
        super.bindSubscriptions(compositeSubscription);
        Model.Companion companion = Model.INSTANCE;
        long j = getArgumentsOrDefault().getLong("INTENT_EXTRA_GUILD_ID", -1L);
        boolean z2 = getArgumentsOrDefault().getBoolean(ARG_INCLUDE_NO_CHANNEL, false);
        Serializable serializable = getArgumentsOrDefault().getSerializable(ARG_FILTER_FUNCTION);
        if (!(serializable instanceof FilterFunction)) {
            serializable = null;
        }
        FilterFunction baseFilterFunction = (FilterFunction) serializable;
        if (baseFilterFunction == null) {
            baseFilterFunction = new BaseFilterFunction();
        }
        Observable<List<Model.Item>> observable = companion.get(j, z2, baseFilterFunction);
        Adapter adapter = this.adapter;
        if (adapter == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("adapter");
        }
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui(observable, this, adapter), (Class<?>) WidgetChannelSelector.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass1());
    }

    @Override // com.discord.app.AppBottomSheet
    public int getContentViewResId() {
        return R.layout.widget_channel_selector;
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        MGRecyclerAdapter.Companion companion = MGRecyclerAdapter.INSTANCE;
        RecyclerView recyclerView = getBinding().f2267b;
        Intrinsics3.checkNotNullExpressionValue(recyclerView, "binding.channelSelectorList");
        this.adapter = (Adapter) companion.configure(new Adapter(recyclerView, this, getArgumentsOrDefault().getInt(ARG_NO_CHANNEL_STRING_ID)));
    }
}
