package com.discord.widgets.channels;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentKt;
import androidx.recyclerview.widget.RecyclerView;
import b.d.b.a.a;
import com.discord.R$layout;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.app.AppBottomSheet;
import com.discord.databinding.WidgetChannelSelectorBinding;
import com.discord.utilities.mg_recycler.MGRecyclerAdapter;
import com.discord.utilities.mg_recycler.MGRecyclerAdapter$Companion;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import d0.g;
import d0.z.d.m;
import java.io.Serializable;
import java.util.List;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;
import rx.Observable;
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
    private WidgetChannelSelector$Adapter adapter;

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* JADX INFO: renamed from: requestCode$delegate, reason: from kotlin metadata */
    private final Lazy requestCode;
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetChannelSelector.class, "binding", "getBinding()Lcom/discord/databinding/WidgetChannelSelectorBinding;", 0)};
    public static final WidgetChannelSelector$Companion Companion = new WidgetChannelSelector$Companion(null);

    public WidgetChannelSelector() {
        super(false, 1, null);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetChannelSelector$binding$2.INSTANCE, null, 2, null);
        this.requestCode = g.lazy(new WidgetChannelSelector$requestCode$2(this));
    }

    public static final /* synthetic */ WidgetChannelSelector$Adapter access$getAdapter$p(WidgetChannelSelector widgetChannelSelector) {
        WidgetChannelSelector$Adapter widgetChannelSelector$Adapter = widgetChannelSelector.adapter;
        if (widgetChannelSelector$Adapter == null) {
            m.throwUninitializedPropertyAccessException("adapter");
        }
        return widgetChannelSelector$Adapter;
    }

    public static final /* synthetic */ Bundle access$getArgumentsOrDefault$p(WidgetChannelSelector widgetChannelSelector) {
        return widgetChannelSelector.getArgumentsOrDefault();
    }

    public static final /* synthetic */ void access$onChannelSelected(WidgetChannelSelector widgetChannelSelector, Channel channel) {
        widgetChannelSelector.onChannelSelected(channel);
    }

    public static final /* synthetic */ void access$setAdapter$p(WidgetChannelSelector widgetChannelSelector, WidgetChannelSelector$Adapter widgetChannelSelector$Adapter) {
        widgetChannelSelector.adapter = widgetChannelSelector$Adapter;
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
        FragmentKt.setFragmentResult(this, requestCode, bundle);
        dismiss();
    }

    @Override // com.discord.app.AppBottomSheet
    public void bindSubscriptions(CompositeSubscription compositeSubscription) {
        m.checkNotNullParameter(compositeSubscription, "compositeSubscription");
        super.bindSubscriptions(compositeSubscription);
        WidgetChannelSelector$Model$Companion widgetChannelSelector$Model$Companion = WidgetChannelSelector$Model.Companion;
        long j = getArgumentsOrDefault().getLong("INTENT_EXTRA_GUILD_ID", -1L);
        boolean z2 = getArgumentsOrDefault().getBoolean(ARG_INCLUDE_NO_CHANNEL, false);
        Serializable serializable = getArgumentsOrDefault().getSerializable(ARG_FILTER_FUNCTION);
        if (!(serializable instanceof WidgetChannelSelector$FilterFunction)) {
            serializable = null;
        }
        WidgetChannelSelector$FilterFunction widgetChannelSelector$BaseFilterFunction = (WidgetChannelSelector$FilterFunction) serializable;
        if (widgetChannelSelector$BaseFilterFunction == null) {
            widgetChannelSelector$BaseFilterFunction = new WidgetChannelSelector$BaseFilterFunction();
        }
        Observable<List<WidgetChannelSelector$Model$Item>> observable = widgetChannelSelector$Model$Companion.get(j, z2, widgetChannelSelector$BaseFilterFunction);
        WidgetChannelSelector$Adapter widgetChannelSelector$Adapter = this.adapter;
        if (widgetChannelSelector$Adapter == null) {
            m.throwUninitializedPropertyAccessException("adapter");
        }
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui(observable, this, widgetChannelSelector$Adapter), WidgetChannelSelector.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetChannelSelector$bindSubscriptions$1(this), 62, (Object) null);
    }

    @Override // com.discord.app.AppBottomSheet
    public int getContentViewResId() {
        return R$layout.widget_channel_selector;
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        m.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        MGRecyclerAdapter$Companion mGRecyclerAdapter$Companion = MGRecyclerAdapter.Companion;
        RecyclerView recyclerView = getBinding().f2267b;
        m.checkNotNullExpressionValue(recyclerView, "binding.channelSelectorList");
        this.adapter = (WidgetChannelSelector$Adapter) mGRecyclerAdapter$Companion.configure(new WidgetChannelSelector$Adapter(recyclerView, this, getArgumentsOrDefault().getInt(ARG_NO_CHANNEL_STRING_ID)));
    }
}
