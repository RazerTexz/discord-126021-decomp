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
import b.a.d.AppScreen2;
import b.a.k.FormatUtils;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.app.AppActivity;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetSearchBinding;
import com.discord.models.guild.Guild;
import com.discord.stores.StoreSearch;
import com.discord.stores.StoreStream;
import com.discord.utilities.error.Error;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.search.query.node.QueryNode;
import com.discord.utilities.search.strings.ContextSearchStringProvider;
import com.discord.utilities.textprocessing.AstRenderer;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.widgets.search.WidgetSearch;
import com.facebook.drawee.span.DraweeSpanStringBuilder;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputLayout;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import j0.k.Func1;
import j0.l.e.ScalarSynchronousObservable;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import rx.Observable;
import rx.Subscription;
import rx.functions.Func4;

/* JADX INFO: compiled from: WidgetSearch.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSearch extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetSearch.class, "binding", "getBinding()Lcom/discord/databinding/WidgetSearchBinding;", 0)};

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
            Intrinsics3.checkNotNullExpressionValue(intentPutExtra, "Intent()\n          .putE…_TARGET_TYPE, targetType)");
            AppScreen2.d(context, WidgetSearch.class, intentPutExtra);
        }

        public final void launchForChannel(long channelId, Context context) {
            Intrinsics3.checkNotNullParameter(context, "context");
            launch(channelId, 1, context);
        }

        public final void launchForGuild(long guildId, Context context) {
            Intrinsics3.checkNotNullParameter(context, "context");
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
                Observable<Guild> observableObserveGuild = targetType == 0 ? StoreStream.INSTANCE.getGuilds().observeGuild(targetId) : new ScalarSynchronousObservable<>(null);
                Observable<Channel> observableObservePrivateChannel = targetType == 1 ? StoreStream.INSTANCE.getChannels().observePrivateChannel(targetId) : new ScalarSynchronousObservable<>(null);
                StoreStream.Companion companion = StoreStream.INSTANCE;
                Observable observableH = Observable.h(observableObserveGuild, observableObservePrivateChannel, companion.getSearch().getDisplayState(), companion.getSearch().getStoreSearchInput().isInputValid(), new Func4<Guild, Channel, StoreSearch.DisplayState, Boolean, Model>() { // from class: com.discord.widgets.search.WidgetSearch$Model$Companion$get$1
                    @Override // rx.functions.Func4
                    public final WidgetSearch.Model call(Guild guild, Channel channel, StoreSearch.DisplayState displayState, Boolean bool) {
                        if ((guild == null && channel == null) || displayState == null) {
                            return null;
                        }
                        Intrinsics3.checkNotNullExpressionValue(bool, "isQueryValid");
                        return new WidgetSearch.Model(guild, channel, displayState, bool.booleanValue());
                    }
                });
                Intrinsics3.checkNotNullExpressionValue(observableH, "Observable\n            .…          }\n            }");
                return ObservableExtensionsKt.computationLatest(observableH);
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
            return Intrinsics3.areEqual(this.guild, model.guild) && Intrinsics3.areEqual(this.channel, model.channel) && Intrinsics3.areEqual(this.displayState, model.displayState) && this.isQueryValid == model.isQueryValid;
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
            StringBuilder sbU = outline.U("Model(guild=");
            sbU.append(this.guild);
            sbU.append(", channel=");
            sbU.append(this.channel);
            sbU.append(", displayState=");
            sbU.append(this.displayState);
            sbU.append(", isQueryValid=");
            return outline.O(sbU, this.isQueryValid, ")");
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

    /* JADX INFO: renamed from: com.discord.widgets.search.WidgetSearch$configureSearchInput$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetSearch.kt */
    public static final class AnonymousClass1 extends Lambda implements Function3<TextView, Integer, KeyEvent, Boolean> {
        public AnonymousClass1() {
            super(3);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Boolean invoke(TextView textView, Integer num, KeyEvent keyEvent) {
            return Boolean.valueOf(invoke(textView, num.intValue(), keyEvent));
        }

        public final boolean invoke(TextView textView, int i, KeyEvent keyEvent) {
            Intrinsics3.checkNotNullParameter(textView, "textView");
            if (i != 2 && i != 3 && i != 6) {
                return false;
            }
            AppFragment.hideKeyboard$default(WidgetSearch.this, null, 1, null);
            StoreSearch search = StoreStream.INSTANCE.getSearch();
            TextInputLayout textInputLayout = WidgetSearch.this.getBinding().c;
            Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.widgetSearchInput");
            String textOrEmpty = ViewExtensions.getTextOrEmpty(textInputLayout);
            Context context = textView.getContext();
            Intrinsics3.checkNotNullExpressionValue(context, "textView.context");
            search.loadInitial(textOrEmpty, new ContextSearchStringProvider(context));
            return true;
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.search.WidgetSearch$configureSearchInput$2, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetSearch.kt */
    public static final class AnonymousClass2 extends Lambda implements Function1<Editable, Unit> {
        public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

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
            Intrinsics3.checkNotNullParameter(editable, NotificationCompat.MessagingStyle.Message.KEY_TEXT);
            StoreStream.INSTANCE.getSearch().getStoreSearchInput().updateInput(editable.toString());
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.search.WidgetSearch$configureSearchInput$5, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetSearch.kt */
    public static final class AnonymousClass5 extends Lambda implements Function1<String, Unit> {
        public AnonymousClass5() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(String str) {
            invoke2(str);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(String str) {
            TextInputLayout textInputLayout = WidgetSearch.this.getBinding().c;
            Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.widgetSearchInput");
            ViewExtensions.setText(textInputLayout, str);
            TextInputLayout textInputLayout2 = WidgetSearch.this.getBinding().c;
            Intrinsics3.checkNotNullExpressionValue(textInputLayout2, "binding.widgetSearchInput");
            ViewExtensions.setSelectionEnd(textInputLayout2);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.search.WidgetSearch$onViewBoundOrOnResume$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetSearch.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<Model, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Model model) {
            invoke2(model);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Model model) {
            WidgetSearch.this.configureUI(model);
        }
    }

    public WidgetSearch() {
        super(R.layout.widget_search);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetSearch3.INSTANCE, null, 2, null);
        this.targetType = -1;
    }

    private final void configureSearchInput() {
        TextInputLayout textInputLayout = getBinding().c;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.widgetSearchInput");
        ViewExtensions.setOnEditorActionListener(textInputLayout, new AnonymousClass1());
        TextInputLayout textInputLayout2 = getBinding().c;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout2, "binding.widgetSearchInput");
        ViewExtensions.addBindedTextWatcher(textInputLayout2, this, AnonymousClass2.INSTANCE);
        Observable observableG = ObservableExtensionsKt.ui$default(StoreStream.INSTANCE.getSearch().getStoreSearchInput().getForcedInput(), this, null, 2, null).G(new Func1<List<? extends QueryNode>, DraweeSpanStringBuilder>() { // from class: com.discord.widgets.search.WidgetSearch.configureSearchInput.3
            @Override // j0.k.Func1
            public final DraweeSpanStringBuilder call(List<? extends QueryNode> list) {
                Intrinsics3.checkNotNullExpressionValue(list, "queryNodes");
                return AstRenderer.render(list, WidgetSearch.this.requireContext());
            }
        }).G(new Func1<DraweeSpanStringBuilder, String>() { // from class: com.discord.widgets.search.WidgetSearch.configureSearchInput.4
            @Override // j0.k.Func1
            public final String call(DraweeSpanStringBuilder draweeSpanStringBuilder) {
                Intrinsics3.checkNotNullParameter(draweeSpanStringBuilder, IconCompat.EXTRA_OBJ);
                return draweeSpanStringBuilder.toString();
            }
        });
        Intrinsics3.checkNotNullExpressionValue(observableG, "StoreStream\n        .get… obj.toString()\n        }");
        ObservableExtensionsKt.appSubscribe(observableG, (Class<?>) WidgetSearch.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass5());
    }

    private final void configureUI(Model model) {
        CharSequence charSequenceE;
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
            TextInputLayout textInputLayout = getBinding().c;
            Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.widgetSearchInput");
            Object[] objArr = new Object[1];
            Guild guild = model.getGuild();
            objArr[0] = guild != null ? guild.getName() : null;
            ViewExtensions.setSingleLineHint(textInputLayout, FormatUtils.e(this, R.string.search_in, objArr, (4 & 4) != 0 ? FormatUtils.a.j : null));
        } else if (i == 1) {
            Channel channel = model.getChannel();
            String strD = channel != null ? ChannelUtils.d(channel, requireContext(), false) : null;
            TextInputLayout textInputLayout2 = getBinding().c;
            Intrinsics3.checkNotNullExpressionValue(textInputLayout2, "binding.widgetSearchInput");
            Channel channel2 = model.getChannel();
            Integer numValueOf = channel2 != null ? Integer.valueOf(channel2.getType()) : null;
            if (numValueOf != null && numValueOf.intValue() == 1) {
                charSequenceE = FormatUtils.e(this, R.string.search_dm_with, new Object[]{strD}, (4 & 4) != 0 ? FormatUtils.a.j : null);
            } else {
                charSequenceE = (numValueOf != null && numValueOf.intValue() == 3) ? FormatUtils.e(this, R.string.search_in, new Object[]{strD}, (4 & 4) != 0 ? FormatUtils.a.j : null) : FormatUtils.e(this, R.string.search, new Object[0], (4 & 4) != 0 ? FormatUtils.a.j : null);
            }
            ViewExtensions.setSingleLineHint(textInputLayout2, charSequenceE);
        }
        StoreSearch.DisplayState displayState = model.getDisplayState();
        if (displayState == null) {
            return;
        }
        int iOrdinal = displayState.ordinal();
        if (iOrdinal == 0) {
            FragmentContainerView fragmentContainerView = getBinding().e;
            Intrinsics3.checkNotNullExpressionValue(fragmentContainerView, "binding.widgetSearchSuggestions");
            fragmentContainerView.setVisibility(0);
            FragmentContainerView fragmentContainerView2 = getBinding().d;
            Intrinsics3.checkNotNullExpressionValue(fragmentContainerView2, "binding.widgetSearchResults");
            fragmentContainerView2.setVisibility(4);
            FloatingActionButton floatingActionButton = getBinding().f2522b;
            Intrinsics3.checkNotNullExpressionValue(floatingActionButton, "binding.searchSendQueryFab");
            floatingActionButton.setVisibility(model.isQueryValid() ? 0 : 8);
            return;
        }
        if (iOrdinal != 1) {
            return;
        }
        FragmentContainerView fragmentContainerView3 = getBinding().e;
        Intrinsics3.checkNotNullExpressionValue(fragmentContainerView3, "binding.widgetSearchSuggestions");
        fragmentContainerView3.setVisibility(4);
        FragmentContainerView fragmentContainerView4 = getBinding().d;
        Intrinsics3.checkNotNullExpressionValue(fragmentContainerView4, "binding.widgetSearchResults");
        fragmentContainerView4.setVisibility(0);
        FloatingActionButton floatingActionButton2 = getBinding().f2522b;
        Intrinsics3.checkNotNullExpressionValue(floatingActionButton2, "binding.searchSendQueryFab");
        floatingActionButton2.setVisibility(8);
    }

    private final WidgetSearchBinding getBinding() {
        return (WidgetSearchBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final void sendQuery(Context context) {
        AppFragment.hideKeyboard$default(this, null, 1, null);
        StoreSearch search = StoreStream.INSTANCE.getSearch();
        TextInputLayout textInputLayout = getBinding().c;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.widgetSearchInput");
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
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        setRetainInstance(true);
        this.targetId = getMostRecentIntent().getLongExtra(INTENT_EXTRA_TARGET_ID, 0L);
        this.targetType = getMostRecentIntent().getIntExtra(INTENT_EXTRA_TARGET_TYPE, -1);
        if (!getIsRecreated()) {
            TextInputLayout textInputLayout = getBinding().c;
            Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.widgetSearchInput");
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
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(Model.INSTANCE.get(this.targetType, this.targetId), this, null, 2, null), (Class<?>) WidgetSearch.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass1());
        configureSearchInput();
        getBinding().f2522b.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.search.WidgetSearch.onViewBoundOrOnResume.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetSearch widgetSearch = WidgetSearch.this;
                Intrinsics3.checkNotNullExpressionValue(view, "v");
                Context context = view.getContext();
                Intrinsics3.checkNotNullExpressionValue(context, "v.context");
                widgetSearch.sendQuery(context);
            }
        });
        getBinding().c.setStartIconOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.search.WidgetSearch.onViewBoundOrOnResume.3
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
