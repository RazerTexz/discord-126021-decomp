package com.discord.widgets.search;

import android.content.Context;
import android.content.Intent;
import android.text.Editable;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;
import androidx.core.app.NotificationCompat;
import androidx.core.graphics.drawable.IconCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentContainerView;
import com.discord.C5419R;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.app.AppActivity;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetSearchBinding;
import com.discord.models.guild.Guild;
import com.discord.stores.StoreSearch;
import com.discord.stores.StoreStream;
import com.discord.utilities.error.Error;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.search.query.node.QueryNode;
import com.discord.utilities.search.strings.ContextSearchStringProvider;
import com.discord.utilities.textprocessing.AstRenderer;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.widgets.search.WidgetSearch;
import com.facebook.drawee.span.DraweeSpanStringBuilder;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputLayout;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p007b.p008a.p018d.C0870j;
import p007b.p008a.p027k.C1107b;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;
import p637j0.p641k.InterfaceC12589b;
import p637j0.p642l.p647e.C12721k;
import p658rx.Observable;
import p658rx.Subscription;
import p658rx.functions.Func4;

/* JADX INFO: compiled from: WidgetSearch.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSearch extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {C1643a.m846d0(WidgetSearch.class, "binding", "getBinding()Lcom/discord/databinding/WidgetSearchBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final String INTENT_EXTRA_TARGET_ID = "INTENT_EXTRA_TARGET_ID";
    public static final String INTENT_EXTRA_TARGET_TYPE = "INTENT_EXTRA_SEARCH_TYPE";
    private static final int TARGET_TYPE_CHANNEL = 1;
    private static final int TARGET_TYPE_GUILD = 0;

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private long targetId;
    private int targetType;

    /* JADX INFO: compiled from: WidgetSearch.kt */
    public static final class Companion {
        private Companion() {
        }

        private final void launch(long targetId, int targetType, Context context) {
            Intent intentPutExtra = new Intent().putExtra(WidgetSearch.INTENT_EXTRA_TARGET_ID, targetId).putExtra(WidgetSearch.INTENT_EXTRA_TARGET_TYPE, targetType);
            C12238m.checkNotNullExpressionValue(intentPutExtra, "Intent()\n          .putE…_TARGET_TYPE, targetType)");
            C0870j.m156d(context, WidgetSearch.class, intentPutExtra);
        }

        public final void launchForChannel(long channelId, Context context) {
            C12238m.checkNotNullParameter(context, "context");
            launch(channelId, 1, context);
        }

        public final void launchForGuild(long guildId, Context context) {
            C12238m.checkNotNullParameter(context, "context");
            launch(guildId, 0, context);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: WidgetSearch.kt */
    public static final /* data */ class Model {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final Channel channel;
        private final StoreSearch.DisplayState displayState;
        private final Guild guild;
        private final boolean isQueryValid;

        /* JADX INFO: compiled from: WidgetSearch.kt */
        public static final class Companion {
            private Companion() {
            }

            public final Observable<Model> get(int targetType, long targetId) {
                Observable<Guild> observableObserveGuild = targetType == 0 ? StoreStream.INSTANCE.getGuilds().observeGuild(targetId) : new C12721k<>(null);
                Observable<Channel> observableObservePrivateChannel = targetType == 1 ? StoreStream.INSTANCE.getChannels().observePrivateChannel(targetId) : new C12721k<>(null);
                StoreStream.Companion companion = StoreStream.INSTANCE;
                Observable observableM11073h = Observable.m11073h(observableObserveGuild, observableObservePrivateChannel, companion.getSearch().getDisplayState(), companion.getSearch().getStoreSearchInput().isInputValid(), new Func4<Guild, Channel, StoreSearch.DisplayState, Boolean, Model>() { // from class: com.discord.widgets.search.WidgetSearch$Model$Companion$get$1
                    @Override // p658rx.functions.Func4
                    public final WidgetSearch.Model call(Guild guild, Channel channel, StoreSearch.DisplayState displayState, Boolean bool) {
                        if ((guild == null && channel == null) || displayState == null) {
                            return null;
                        }
                        C12238m.checkNotNullExpressionValue(bool, "isQueryValid");
                        return new WidgetSearch.Model(guild, channel, displayState, bool.booleanValue());
                    }
                });
                C12238m.checkNotNullExpressionValue(observableM11073h, "Observable\n            .…          }\n            }");
                return ObservableExtensionsKt.computationLatest(observableM11073h);
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public Model(Guild guild, Channel channel, StoreSearch.DisplayState displayState, boolean z2) {
            this.guild = guild;
            this.channel = channel;
            this.displayState = displayState;
            this.isQueryValid = z2;
        }

        public static /* synthetic */ Model copy$default(Model model, Guild guild, Channel channel, StoreSearch.DisplayState displayState, boolean z2, int i, Object obj) {
            if ((i & 1) != 0) {
                guild = model.guild;
            }
            if ((i & 2) != 0) {
                channel = model.channel;
            }
            if ((i & 4) != 0) {
                displayState = model.displayState;
            }
            if ((i & 8) != 0) {
                z2 = model.isQueryValid;
            }
            return model.copy(guild, channel, displayState, z2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Guild getGuild() {
            return this.guild;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final Channel getChannel() {
            return this.channel;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final StoreSearch.DisplayState getDisplayState() {
            return this.displayState;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final boolean getIsQueryValid() {
            return this.isQueryValid;
        }

        public final Model copy(Guild guild, Channel channel, StoreSearch.DisplayState displayState, boolean isQueryValid) {
            return new Model(guild, channel, displayState, isQueryValid);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Model)) {
                return false;
            }
            Model model = (Model) other;
            return C12238m.areEqual(this.guild, model.guild) && C12238m.areEqual(this.channel, model.channel) && C12238m.areEqual(this.displayState, model.displayState) && this.isQueryValid == model.isQueryValid;
        }

        public final Channel getChannel() {
            return this.channel;
        }

        public final StoreSearch.DisplayState getDisplayState() {
            return this.displayState;
        }

        public final Guild getGuild() {
            return this.guild;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v8, types: [int] */
        /* JADX WARN: Type inference failed for: r1v3, types: [int] */
        /* JADX WARN: Type inference failed for: r1v4 */
        /* JADX WARN: Type inference failed for: r1v6 */
        public int hashCode() {
            Guild guild = this.guild;
            int iHashCode = (guild != null ? guild.hashCode() : 0) * 31;
            Channel channel = this.channel;
            int iHashCode2 = (iHashCode + (channel != null ? channel.hashCode() : 0)) * 31;
            StoreSearch.DisplayState displayState = this.displayState;
            int iHashCode3 = (iHashCode2 + (displayState != null ? displayState.hashCode() : 0)) * 31;
            boolean z2 = this.isQueryValid;
            ?? r1 = z2;
            if (z2) {
                r1 = 1;
            }
            return iHashCode3 + r1;
        }

        public final boolean isQueryValid() {
            return this.isQueryValid;
        }

        public String toString() {
            StringBuilder sbM833U = C1643a.m833U("Model(guild=");
            sbM833U.append(this.guild);
            sbM833U.append(", channel=");
            sbM833U.append(this.channel);
            sbM833U.append(", displayState=");
            sbM833U.append(this.displayState);
            sbM833U.append(", isQueryValid=");
            return C1643a.m827O(sbM833U, this.isQueryValid, ")");
        }
    }

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            StoreSearch.DisplayState.values();
            int[] iArr = new int[2];
            $EnumSwitchMapping$0 = iArr;
            iArr[StoreSearch.DisplayState.SUGGESTIONS.ordinal()] = 1;
            iArr[StoreSearch.DisplayState.RESULTS.ordinal()] = 2;
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.search.WidgetSearch$configureSearchInput$1 */
    /* JADX INFO: compiled from: WidgetSearch.kt */
    public static final class C91261 extends AbstractC12240o implements Function3<TextView, Integer, KeyEvent, Boolean> {
        public C91261() {
            super(3);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Boolean invoke(TextView textView, Integer num, KeyEvent keyEvent) {
            return Boolean.valueOf(invoke(textView, num.intValue(), keyEvent));
        }

        public final boolean invoke(TextView textView, int i, KeyEvent keyEvent) {
            C12238m.checkNotNullParameter(textView, "textView");
            if (i != 2 && i != 3 && i != 6) {
                return false;
            }
            AppFragment.hideKeyboard$default(WidgetSearch.this, null, 1, null);
            StoreSearch search = StoreStream.INSTANCE.getSearch();
            TextInputLayout textInputLayout = WidgetSearch.this.getBinding().f17421c;
            C12238m.checkNotNullExpressionValue(textInputLayout, "binding.widgetSearchInput");
            String textOrEmpty = ViewExtensions.getTextOrEmpty(textInputLayout);
            Context context = textView.getContext();
            C12238m.checkNotNullExpressionValue(context, "textView.context");
            search.loadInitial(textOrEmpty, new ContextSearchStringProvider(context));
            return true;
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.search.WidgetSearch$configureSearchInput$2 */
    /* JADX INFO: compiled from: WidgetSearch.kt */
    public static final class C91272 extends AbstractC12240o implements Function1<Editable, Unit> {
        public static final C91272 INSTANCE = new C91272();

        public C91272() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Editable editable) {
            invoke2(editable);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Editable editable) {
            C12238m.checkNotNullParameter(editable, NotificationCompat.MessagingStyle.Message.KEY_TEXT);
            StoreStream.INSTANCE.getSearch().getStoreSearchInput().updateInput(editable.toString());
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.search.WidgetSearch$configureSearchInput$5 */
    /* JADX INFO: compiled from: WidgetSearch.kt */
    public static final class C91305 extends AbstractC12240o implements Function1<String, Unit> {
        public C91305() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(String str) {
            invoke2(str);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(String str) {
            TextInputLayout textInputLayout = WidgetSearch.this.getBinding().f17421c;
            C12238m.checkNotNullExpressionValue(textInputLayout, "binding.widgetSearchInput");
            ViewExtensions.setText(textInputLayout, str);
            TextInputLayout textInputLayout2 = WidgetSearch.this.getBinding().f17421c;
            C12238m.checkNotNullExpressionValue(textInputLayout2, "binding.widgetSearchInput");
            ViewExtensions.setSelectionEnd(textInputLayout2);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.search.WidgetSearch$onViewBoundOrOnResume$1 */
    /* JADX INFO: compiled from: WidgetSearch.kt */
    public static final class C91311 extends AbstractC12240o implements Function1<Model, Unit> {
        public C91311() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Model model) {
            invoke2(model);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Model model) {
            WidgetSearch.this.configureUI(model);
        }
    }

    public WidgetSearch() {
        super(C5419R.layout.widget_search);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetSearch$binding$2.INSTANCE, null, 2, null);
        this.targetType = -1;
    }

    private final void configureSearchInput() {
        TextInputLayout textInputLayout = getBinding().f17421c;
        C12238m.checkNotNullExpressionValue(textInputLayout, "binding.widgetSearchInput");
        ViewExtensions.setOnEditorActionListener(textInputLayout, new C91261());
        TextInputLayout textInputLayout2 = getBinding().f17421c;
        C12238m.checkNotNullExpressionValue(textInputLayout2, "binding.widgetSearchInput");
        ViewExtensions.addBindedTextWatcher(textInputLayout2, this, C91272.INSTANCE);
        Observable observableM11083G = ObservableExtensionsKt.ui$default(StoreStream.INSTANCE.getSearch().getStoreSearchInput().getForcedInput(), this, null, 2, null).m11083G(new InterfaceC12589b<List<? extends QueryNode>, DraweeSpanStringBuilder>() { // from class: com.discord.widgets.search.WidgetSearch.configureSearchInput.3
            @Override // p637j0.p641k.InterfaceC12589b
            public final DraweeSpanStringBuilder call(List<? extends QueryNode> list) {
                C12238m.checkNotNullExpressionValue(list, "queryNodes");
                return AstRenderer.render(list, WidgetSearch.this.requireContext());
            }
        }).m11083G(new InterfaceC12589b<DraweeSpanStringBuilder, String>() { // from class: com.discord.widgets.search.WidgetSearch.configureSearchInput.4
            @Override // p637j0.p641k.InterfaceC12589b
            public final String call(DraweeSpanStringBuilder draweeSpanStringBuilder) {
                C12238m.checkNotNullParameter(draweeSpanStringBuilder, IconCompat.EXTRA_OBJ);
                return draweeSpanStringBuilder.toString();
            }
        });
        C12238m.checkNotNullExpressionValue(observableM11083G, "StoreStream\n        .get… obj.toString()\n        }");
        ObservableExtensionsKt.appSubscribe(observableM11083G, (Class<?>) WidgetSearch.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C91305());
    }

    private final void configureUI(Model model) {
        CharSequence charSequenceM213e;
        if (model == null) {
            AppActivity appActivity = getAppActivity();
            if (appActivity != null) {
                appActivity.finish();
                return;
            }
            return;
        }
        int i = this.targetType;
        if (i == 0) {
            TextInputLayout textInputLayout = getBinding().f17421c;
            C12238m.checkNotNullExpressionValue(textInputLayout, "binding.widgetSearchInput");
            Object[] objArr = new Object[1];
            Guild guild = model.getGuild();
            objArr[0] = guild != null ? guild.getName() : null;
            ViewExtensions.setSingleLineHint(textInputLayout, C1107b.m213e(this, C5419R.string.search_in, objArr, (4 & 4) != 0 ? C1107b.a.f1490j : null));
        } else if (i == 1) {
            Channel channel = model.getChannel();
            String strM7680d = channel != null ? ChannelUtils.m7680d(channel, requireContext(), false) : null;
            TextInputLayout textInputLayout2 = getBinding().f17421c;
            C12238m.checkNotNullExpressionValue(textInputLayout2, "binding.widgetSearchInput");
            Channel channel2 = model.getChannel();
            Integer numValueOf = channel2 != null ? Integer.valueOf(channel2.getType()) : null;
            if (numValueOf != null && numValueOf.intValue() == 1) {
                charSequenceM213e = C1107b.m213e(this, C5419R.string.search_dm_with, new Object[]{strM7680d}, (4 & 4) != 0 ? C1107b.a.f1490j : null);
            } else {
                charSequenceM213e = (numValueOf != null && numValueOf.intValue() == 3) ? C1107b.m213e(this, C5419R.string.search_in, new Object[]{strM7680d}, (4 & 4) != 0 ? C1107b.a.f1490j : null) : C1107b.m213e(this, C5419R.string.search, new Object[0], (4 & 4) != 0 ? C1107b.a.f1490j : null);
            }
            ViewExtensions.setSingleLineHint(textInputLayout2, charSequenceM213e);
        }
        StoreSearch.DisplayState displayState = model.getDisplayState();
        if (displayState == null) {
            return;
        }
        int iOrdinal = displayState.ordinal();
        if (iOrdinal == 0) {
            FragmentContainerView fragmentContainerView = getBinding().f17423e;
            C12238m.checkNotNullExpressionValue(fragmentContainerView, "binding.widgetSearchSuggestions");
            fragmentContainerView.setVisibility(0);
            FragmentContainerView fragmentContainerView2 = getBinding().f17422d;
            C12238m.checkNotNullExpressionValue(fragmentContainerView2, "binding.widgetSearchResults");
            fragmentContainerView2.setVisibility(4);
            FloatingActionButton floatingActionButton = getBinding().f17420b;
            C12238m.checkNotNullExpressionValue(floatingActionButton, "binding.searchSendQueryFab");
            floatingActionButton.setVisibility(model.isQueryValid() ? 0 : 8);
            return;
        }
        if (iOrdinal != 1) {
            return;
        }
        FragmentContainerView fragmentContainerView3 = getBinding().f17423e;
        C12238m.checkNotNullExpressionValue(fragmentContainerView3, "binding.widgetSearchSuggestions");
        fragmentContainerView3.setVisibility(4);
        FragmentContainerView fragmentContainerView4 = getBinding().f17422d;
        C12238m.checkNotNullExpressionValue(fragmentContainerView4, "binding.widgetSearchResults");
        fragmentContainerView4.setVisibility(0);
        FloatingActionButton floatingActionButton2 = getBinding().f17420b;
        C12238m.checkNotNullExpressionValue(floatingActionButton2, "binding.searchSendQueryFab");
        floatingActionButton2.setVisibility(8);
    }

    private final WidgetSearchBinding getBinding() {
        return (WidgetSearchBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final void sendQuery(Context context) {
        AppFragment.hideKeyboard$default(this, null, 1, null);
        StoreSearch search = StoreStream.INSTANCE.getSearch();
        TextInputLayout textInputLayout = getBinding().f17421c;
        C12238m.checkNotNullExpressionValue(textInputLayout, "binding.widgetSearchInput");
        search.loadInitial(ViewExtensions.getTextOrEmpty(textInputLayout), new ContextSearchStringProvider(context));
    }

    public final long getTargetId() {
        return this.targetId;
    }

    public final int getTargetType() {
        return this.targetType;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        StoreStream.INSTANCE.getSearch().clear();
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        C12238m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        setRetainInstance(true);
        this.targetId = getMostRecentIntent().getLongExtra(INTENT_EXTRA_TARGET_ID, 0L);
        this.targetType = getMostRecentIntent().getIntExtra(INTENT_EXTRA_TARGET_TYPE, -1);
        if (!getIsRecreated()) {
            TextInputLayout textInputLayout = getBinding().f17421c;
            C12238m.checkNotNullExpressionValue(textInputLayout, "binding.widgetSearchInput");
            showKeyboard(textInputLayout);
        }
        int i = this.targetType;
        if (i == 0) {
            StoreStream.INSTANCE.getSearch().initForGuild(this.targetId, new ContextSearchStringProvider(requireContext()));
        } else {
            if (i != 1) {
                return;
            }
            StoreStream.INSTANCE.getSearch().initForChannel(this.targetId, new ContextSearchStringProvider(requireContext()));
        }
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(Model.INSTANCE.get(this.targetType, this.targetId), this, null, 2, null), (Class<?>) WidgetSearch.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C91311());
        configureSearchInput();
        getBinding().f17420b.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.search.WidgetSearch.onViewBoundOrOnResume.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetSearch widgetSearch = WidgetSearch.this;
                C12238m.checkNotNullExpressionValue(view, "v");
                Context context = view.getContext();
                C12238m.checkNotNullExpressionValue(context, "v.context");
                widgetSearch.sendQuery(context);
            }
        });
        getBinding().f17421c.setStartIconOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.search.WidgetSearch.onViewBoundOrOnResume.3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetSearch.this.hideKeyboard(view);
                WidgetSearch.this.requireActivity().onBackPressed();
            }
        });
    }

    public final void setTargetId(long j) {
        this.targetId = j;
    }

    public final void setTargetType(int i) {
        this.targetType = i;
    }
}
