package com.discord.widgets.search;

import android.content.Context;
import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentContainerView;
import b.a.k.b;
import b.d.b.a.a;
import com.discord.R$layout;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.app.AppActivity;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetSearchBinding;
import com.discord.models.guild.Guild;
import com.discord.stores.StoreSearch;
import com.discord.stores.StoreSearch$DisplayState;
import com.discord.stores.StoreStream;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.search.strings.ContextSearchStringProvider;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputLayout;
import d0.z.d.m;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;
import rx.Observable;

/* JADX INFO: compiled from: WidgetSearch.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSearch extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetSearch.class, "binding", "getBinding()Lcom/discord/databinding/WidgetSearchBinding;", 0)};
    public static final WidgetSearch$Companion Companion = new WidgetSearch$Companion(null);
    public static final String INTENT_EXTRA_TARGET_ID = "INTENT_EXTRA_TARGET_ID";
    public static final String INTENT_EXTRA_TARGET_TYPE = "INTENT_EXTRA_SEARCH_TYPE";
    private static final int TARGET_TYPE_CHANNEL = 1;
    private static final int TARGET_TYPE_GUILD = 0;

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private long targetId;
    private int targetType;

    public WidgetSearch() {
        super(R$layout.widget_search);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetSearch$binding$2.INSTANCE, null, 2, null);
        this.targetType = -1;
    }

    public static final /* synthetic */ void access$configureUI(WidgetSearch widgetSearch, WidgetSearch$Model widgetSearch$Model) {
        widgetSearch.configureUI(widgetSearch$Model);
    }

    public static final /* synthetic */ WidgetSearchBinding access$getBinding$p(WidgetSearch widgetSearch) {
        return widgetSearch.getBinding();
    }

    public static final /* synthetic */ void access$sendQuery(WidgetSearch widgetSearch, Context context) {
        widgetSearch.sendQuery(context);
    }

    private final void configureSearchInput() {
        TextInputLayout textInputLayout = getBinding().c;
        m.checkNotNullExpressionValue(textInputLayout, "binding.widgetSearchInput");
        ViewExtensions.setOnEditorActionListener(textInputLayout, new WidgetSearch$configureSearchInput$1(this));
        TextInputLayout textInputLayout2 = getBinding().c;
        m.checkNotNullExpressionValue(textInputLayout2, "binding.widgetSearchInput");
        ViewExtensions.addBindedTextWatcher(textInputLayout2, this, WidgetSearch$configureSearchInput$2.INSTANCE);
        Observable observableG = ObservableExtensionsKt.ui$default(StoreStream.Companion.getSearch().getStoreSearchInput().getForcedInput(), this, null, 2, null).G(new WidgetSearch$configureSearchInput$3(this)).G(WidgetSearch$configureSearchInput$4.INSTANCE);
        m.checkNotNullExpressionValue(observableG, "StoreStream\n        .get… obj.toString()\n        }");
        ObservableExtensionsKt.appSubscribe$default(observableG, WidgetSearch.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetSearch$configureSearchInput$5(this), 62, (Object) null);
    }

    private final void configureUI(WidgetSearch$Model model) {
        CharSequence charSequenceK;
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
            m.checkNotNullExpressionValue(textInputLayout, "binding.widgetSearchInput");
            Object[] objArr = new Object[1];
            Guild guild = model.getGuild();
            objArr[0] = guild != null ? guild.getName() : null;
            ViewExtensions.setSingleLineHint(textInputLayout, b.k(this, 2131895350, objArr, null, 4));
        } else if (i == 1) {
            Channel channel = model.getChannel();
            String strD = channel != null ? ChannelUtils.d(channel, requireContext(), false) : null;
            TextInputLayout textInputLayout2 = getBinding().c;
            m.checkNotNullExpressionValue(textInputLayout2, "binding.widgetSearchInput");
            Channel channel2 = model.getChannel();
            Integer numValueOf = channel2 != null ? Integer.valueOf(channel2.getType()) : null;
            if (numValueOf != null && numValueOf.intValue() == 1) {
                charSequenceK = b.k(this, 2131895317, new Object[]{strD}, null, 4);
            } else {
                charSequenceK = (numValueOf != null && numValueOf.intValue() == 3) ? b.k(this, 2131895350, new Object[]{strD}, null, 4) : b.k(this, 2131895292, new Object[0], null, 4);
            }
            ViewExtensions.setSingleLineHint(textInputLayout2, charSequenceK);
        }
        StoreSearch$DisplayState displayState = model.getDisplayState();
        if (displayState == null) {
            return;
        }
        int iOrdinal = displayState.ordinal();
        if (iOrdinal == 0) {
            FragmentContainerView fragmentContainerView = getBinding().e;
            m.checkNotNullExpressionValue(fragmentContainerView, "binding.widgetSearchSuggestions");
            fragmentContainerView.setVisibility(0);
            FragmentContainerView fragmentContainerView2 = getBinding().d;
            m.checkNotNullExpressionValue(fragmentContainerView2, "binding.widgetSearchResults");
            fragmentContainerView2.setVisibility(4);
            FloatingActionButton floatingActionButton = getBinding().f2522b;
            m.checkNotNullExpressionValue(floatingActionButton, "binding.searchSendQueryFab");
            floatingActionButton.setVisibility(model.isQueryValid() ? 0 : 8);
            return;
        }
        if (iOrdinal != 1) {
            return;
        }
        FragmentContainerView fragmentContainerView3 = getBinding().e;
        m.checkNotNullExpressionValue(fragmentContainerView3, "binding.widgetSearchSuggestions");
        fragmentContainerView3.setVisibility(4);
        FragmentContainerView fragmentContainerView4 = getBinding().d;
        m.checkNotNullExpressionValue(fragmentContainerView4, "binding.widgetSearchResults");
        fragmentContainerView4.setVisibility(0);
        FloatingActionButton floatingActionButton2 = getBinding().f2522b;
        m.checkNotNullExpressionValue(floatingActionButton2, "binding.searchSendQueryFab");
        floatingActionButton2.setVisibility(8);
    }

    private final WidgetSearchBinding getBinding() {
        return (WidgetSearchBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final void sendQuery(Context context) {
        AppFragment.hideKeyboard$default(this, null, 1, null);
        StoreSearch search = StoreStream.Companion.getSearch();
        TextInputLayout textInputLayout = getBinding().c;
        m.checkNotNullExpressionValue(textInputLayout, "binding.widgetSearchInput");
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
        StoreStream.Companion.getSearch().clear();
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        setRetainInstance(true);
        this.targetId = getMostRecentIntent().getLongExtra(INTENT_EXTRA_TARGET_ID, 0L);
        this.targetType = getMostRecentIntent().getIntExtra(INTENT_EXTRA_TARGET_TYPE, -1);
        if (!getIsRecreated()) {
            TextInputLayout textInputLayout = getBinding().c;
            m.checkNotNullExpressionValue(textInputLayout, "binding.widgetSearchInput");
            showKeyboard(textInputLayout);
        }
        int i = this.targetType;
        if (i == 0) {
            StoreStream.Companion.getSearch().initForGuild(this.targetId, new ContextSearchStringProvider(requireContext()));
        } else {
            if (i != 1) {
                return;
            }
            StoreStream.Companion.getSearch().initForChannel(this.targetId, new ContextSearchStringProvider(requireContext()));
        }
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(WidgetSearch$Model.Companion.get(this.targetType, this.targetId), this, null, 2, null), WidgetSearch.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetSearch$onViewBoundOrOnResume$1(this), 62, (Object) null);
        configureSearchInput();
        getBinding().f2522b.setOnClickListener(new WidgetSearch$onViewBoundOrOnResume$2(this));
        getBinding().c.setStartIconOnClickListener(new WidgetSearch$onViewBoundOrOnResume$3(this));
    }

    public final void setTargetId(long j) {
        this.targetId = j;
    }

    public final void setTargetType(int i) {
        this.targetType = i;
    }
}
